/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sourceforge.jFuzzyLogic.demo.dynamics;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.Variable;

import org.antlr.runtime.RecognitionException;

/**
 *
 * @author pjl
 */
public abstract class FuzzyController {

	//   protected FunctionBlock functionBlock;
	protected FIS fis;
	private String fisString;
	protected Model model;
	protected Vector<Variable> variables;

	protected FuzzyController(InputStream file, Model model) {
		this.model = model;
		variables = new Vector<Variable>();
		try {
			reload(file);
		} catch(IOException ex) {
			Logger.getLogger(FuzzyController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	abstract public void control();

	InputStream getFclAsInputStream() {
		return new ByteArrayInputStream(fisString.getBytes());
	}

	public FIS getFis() {
		return fis;
	}

	//    public String showState() {
	//        
	//        
	//        String str=functionBlock.toString() +"\n";
	//        return str += util.Debugger.functionBlockToString(functionBlock);
	//    }

	public Model getModel() {
		return model;
	}

     public List<Variable> getVariables() {return variables;}

	//    public FunctionBlock getFuzzyRuleSet() {
	//        return functionBlock;
	//    }

	abstract protected void init();

	public void reload(InputStream file) throws IOException {

		String str = FCLPanel.readFileAsString(file);

		reload(str);
		//        FIS newfis=null;
		//        newfis = FIS.load(file,true);
		//     
		//                
		//        if (newfis == null) { // Error while loading?        
		//            System.err.println("Can't load file: '" + file + "'");
		//            return;
		//        } else {
		//            fis = newfis;
		//            
		//  //          functionBlock = fis.getFunctionBlock(null);
		//            init();
		//        }
	}

	public void reload(String str) {
		FIS newfis;
		try {
			newfis = FIS.createFromString(str, true);
			fis = newfis;
			fisString = str;
			//          functionBlock = fis.getFunctionBlock(null);
			init();
		} catch(RecognitionException ex) {
			Logger.getLogger(FuzzyController.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	abstract public String showState();

}
