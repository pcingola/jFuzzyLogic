package net.sourceforge.jFuzzyLogic.demo.dynamics;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class FCLFileFilter extends FileFilter {

	/* (non-Javadoc)
	 * @see javax.swing.filechooser.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File f) {
		if( f.getName().toLowerCase().indexOf(".fcl") > 0 || f.isDirectory() ) return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.swing.filechooser.FileFilter#getDescription()
	 */
	@Override
	public String getDescription() {
		return "FCL file";
	}

}
