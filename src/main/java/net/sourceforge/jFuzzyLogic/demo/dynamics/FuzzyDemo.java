package net.sourceforge.jFuzzyLogic.demo.dynamics;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * 
 * @author pjl
 */
public abstract class FuzzyDemo {

	// JMenuBar menuBar;
	protected View view;
	protected Model model;
	private javax.swing.Timer timerG;
	private javax.swing.Timer timerM;
	private int timeStepG = 50; // millisec per frame
	private int timeStepM = 1; // millisec per controller update
	protected int dilation = 1; // make time run slow
	protected FuzzyController fuzzyController;
	private JPanel content;
	private JPanel controlPanel;
	protected boolean fuzzyControlActive = false;
	protected FCLPanel fclPanel;
	protected InputStream fclInputStream;
	private FuzzyDemoLayoutPanel fuzzyLayout;
	private boolean animateRules = false;
	private File fclFile;
	// private String buttonString;
	private boolean applet;

	/** Initializes the applet IPApplet */
	protected FuzzyDemo(InputStream fclInput, boolean applet) {

		this.applet = applet;

		fclInputStream = fclInput;

		initComponents();

		timerG = new javax.swing.Timer(timeStepG, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// System.out.println(" GUI update");
				view.modelStateChanged();
				if (animateRules) {
					fisPanel.repaint();
				}
			}
		});

		timerG.setCoalesce(true);

		// model timestep stays constant but we vary the rate it is called to
		// implement dilation
		timerM = new javax.swing.Timer(timeStepM * dilation,
				new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						if (fuzzyControlActive && !view.isHumanActive()) {
							fuzzyController.control();
						} 
						// System.out.println(" Model update");
						model.update(timeStepM / 1000.0);
					}
				});
		timerM.setCoalesce(false);

		fuzzyLayout.getTabPanel().addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				animateRules = fuzzyLayout.getTabPanel().getSelectedComponent() == fisPanel;
			}
		});

		controlPanel = new JPanel();
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));
		addControlsTo(controlPanel); // content.getControlPanel());
		content.add(controlPanel, BorderLayout.NORTH);
		content.validate();
	}

	// public JMenuBar getJMenuBar() {
	// return menuBar;
	// }

	public Container getPanel() {
		return content;
	}

	public JPanel getControPanel() {
		return controlPanel;
	}

	protected abstract void addFuzzyControls(JPanel cntrl);

	private JComponent createHtmlPanel(String url) {

		JScrollPane scroll = new JScrollPane();

		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		java.net.URL helpURL = this.getClass().getResource(url);
		if (helpURL != null) {
			try {
				editorPane.setPage(helpURL);
			} catch (IOException e) {
				System.err.println("Attempted to read a bad URL: " + helpURL);
			}
		} else {
			System.err.println("Couldn't find file:" + helpURL);
		}

		scroll.setViewportView(editorPane);
		return scroll;

	}

	private void initComponents() {


		initModelImpl(fclInputStream);
		content = new JPanel();
		content.setLayout(new BorderLayout());

		content.add(
				fuzzyLayout = new FuzzyDemoLayoutPanel((JPanel) view
						.getDisplayPanel()), BorderLayout.CENTER);
		if (!applet) {
			fuzzyLayout.getTabPanel().add("About",
					createHtmlPanel("about.html"));
		}
		fuzzyLayout.getTabPanel().add("Fuzzy Control Logic",
				createEditorPanel());

		initFisDebugPanel();

		if (!applet) {
			fuzzyLayout.getTabPanel().add("Credits",
					createHtmlPanel("credits.html"));
		}
	}

	JPanel fisPanel;

	void initFisDebugPanel() {
		// Create a plot
		if (fisPanel != null) {
			System.out.println(" Remove existing fis panel");
			fuzzyLayout.getTabPanel().remove(fisPanel);
		}
		FIS fis = fuzzyController.getFis();
		List<Variable> list = fuzzyController.getVariables();
		fisPanel = new DemoPanelFis(fuzzyController.getVariables(),
				list.size(), 1);
		fuzzyLayout.getTabPanel().add("Graphs", fisPanel);
	}

	public void start() {
		if (timerG.isRunning()) {
			timerG.restart();
		} else {
			timerG.start();
		}
		if (timerM.isRunning()) {
			timerM.restart();
		} else {
			timerM.start();
		}
	}

	public void stop() {
		timerG.stop();
		timerM.stop();
	}

	/**
	 * top panel has all the buttons. create generic and delegate specific to
	 * subclasses.
	 * 
	 * @return
	 */
	protected JPanel createEditorPanel() {

		JPanel top = new JPanel();

		top.setLayout(new BorderLayout());
		try {
			top.add(fclPanel = new FCLPanel(fuzzyController
					.getFclAsInputStream()), BorderLayout.CENTER);
		} catch (IOException ex) {
			Logger.getLogger(FuzzyDemoApplet.class.getName()).log(Level.SEVERE,
					null, ex);
		}

		JPanel cntrl = new JPanel();
		cntrl.setLayout(new BoxLayout(cntrl, BoxLayout.X_AXIS));

		// get subclass to add model spefic controls

		cntrl.add(new JButton(new AbstractAction("Save") {

			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Save fuzzy rules");
				chooser.setFileFilter(new FCLFileFilter());
				if (fclFile != null) {
					chooser.setSelectedFile(fclFile);
				}
				if (chooser.showSaveDialog(content) == JFileChooser.APPROVE_OPTION) {
					File outFile = chooser.getSelectedFile();
					try {
						String str = fclPanel.getText();
						FileWriter out = new FileWriter(outFile);
						out.write(str);
						out.close();
					} catch (IOException ex) {
						Logger.getLogger(FuzzyDemoApplet.class.getName()).log(
								Level.SEVERE, null, ex);
					}
				}
			}
		}));

		cntrl.add(new JButton(new AbstractAction("Load") {

			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Open fuzzy rules");
				chooser.setFileFilter(new FCLFileFilter());
				if (fclFile != null) {
					chooser.setSelectedFile(fclFile);
				}
				if (chooser.showOpenDialog(content) == JFileChooser.APPROVE_OPTION) {
					File newFile = chooser.getSelectedFile();
					try {
						InputStream in = new FileInputStream(newFile);
						fuzzyController.reload(in);
						InputStream in2 = new FileInputStream(newFile);
						fclPanel.setFile(in2);
						fclFile = newFile;
						initFisDebugPanel();
					} catch (IOException ex) {
						Logger.getLogger(FuzzyDemoApplet.class.getName()).log(
								Level.SEVERE, null, ex);
					}

				}
			}
		}));

		cntrl.add(new JButton(new AbstractAction("Apply") {

			public void actionPerformed(ActionEvent e) {
				fuzzyController.reload(fclPanel.getText());
				initFisDebugPanel();
			}
		}));

		top.add(cntrl, BorderLayout.NORTH);
		return top;
	}

	private void addControlsTo(JPanel cntrl) {

		addControlsImpl(cntrl);

		// add generic stuff
		cntrl.add(new JSeparator(JSeparator.VERTICAL));
		JPanel sp = new JPanel();
		sp.add(new JLabel("Slow down by:"));
		final SpinnerNumberModel sm = new SpinnerNumberModel(dilation, 1, 50, 1);
		sm.addChangeListener(new

		ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				dilation = ((SpinnerNumberModel) sm).getNumber().intValue();
				timerM.setDelay(timeStepM * dilation);

			}
		});
		sp.add(new JSpinner(sm));
		cntrl.add(sp);

		cntrl.add(new JSeparator(JSeparator.VERTICAL));

		addFuzzyControls(cntrl);
		cntrl.add(new JToggleButton(new AbstractAction("USE FUZZY CONTROL") {

			public void actionPerformed(ActionEvent e) {
				fuzzyControlActive = ((JToggleButton) e.getSource())
						.isSelected();
				setActiveImpl(fuzzyControlActive);
			}
		}));

	}

	protected abstract void setActiveImpl(boolean yes);

	protected abstract void initModelImpl(InputStream fclInput);

	protected abstract void addControlsImpl(JPanel panel);

	public void dispose() {
		stop();
		timerG = null;
		timerM = null;
	}

	public abstract String getTitle();
}
