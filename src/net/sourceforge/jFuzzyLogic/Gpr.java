package net.sourceforge.jFuzzyLogic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.antlr.runtime.tree.Tree;

/**
 * General pupose rutines
 * @author Pablo Cingolani <pcingola@users.sourceforge.net>
 */
public class Gpr {

	/** Only print this number of warnings */
	public static int MAX_NUMBER_OF_WARNINGS = 5;

	/** Print warning only N times */
	public static int warnCount = 0;

	// User's home directory
	public static final String HOME = System.getProperty("user.home");

	/**
	 * Sanity check for a root node
	 * @param name1
	 * @param name2
	 * @param tree
	 */
	public static void checkRootNode(String name1, String name2, Tree tree) {
		if (!tree.getText().equalsIgnoreCase(name1) && !tree.getText().equalsIgnoreCase(name2)) //
			throw new RuntimeException("\n\tThis tree does NOT have a '" + name1 + "' or '" + name2 + "' as root node! (this should never happen)\n\tLine: " + tree.getLine() + "\n");
	}

	/**
	 * Sanity check for a root node
	 * @param name
	 * @param tree
	 */
	public static void checkRootNode(String name, Tree tree) {
		if (!tree.getText().equalsIgnoreCase(name)) //
			throw new RuntimeException("\n\tThis tree does NOT have a '" + name + "' as root node! (this should never happen)\n\tLine: " + tree.getLine() + "\n");
	}

	/**
	 * Prits a debug message (prints class name, method and line number)
	 * @param obj : Object to print
	 */
	public static void debug(Object obj) {
		debug(obj, 1, true);
	}

	/**
	 * Prits a debug message (prints class name, method and line number)
	 * @param obj : Object to print
	 * @param offset : Offset N lines from stacktrace
	 */
	public static void debug(Object obj, int offset) {
		debug(obj, offset, true);
	}

	/**
	 * Prits a debug message (prints class name, method and line number)
	 * @param obj : Object to print
	 * @param offset : Offset N lines from stacktrace
	 * @param newLine : Print a newline char at the end ('\n')
	 */
	public static void debug(Object obj, int offset, boolean newLine) {
		StackTraceElement ste = new Exception().getStackTrace()[1 + offset];
		String steStr = ste.getClassName();
		int ind = steStr.lastIndexOf('.');
		steStr = steStr.substring(ind + 1);
		steStr += "." + ste.getMethodName() + "(" + ste.getLineNumber() + "): " + (obj == null ? null : obj.toString());
		if (newLine) System.err.println(steStr);
		else System.err.print(steStr);
	}

	/**
	 * Equivalent to Integer.parseInt, except it returns 0 on invalid integer (NumberFormatException)
	 * @param s
	 * @return	int
	 */
	public static boolean parseBooleanSafe(String s) {
		if (s == null) return false;
		try {
			if (s.equalsIgnoreCase("true") || s.equalsIgnoreCase("on") || s.equalsIgnoreCase("yes") || s.equalsIgnoreCase("si") || s.equalsIgnoreCase("oui") || s.equalsIgnoreCase("ja") || s.equalsIgnoreCase("da")) return true;
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	/** Parse a double number */
	public static double parseDouble(Tree tree) {
		double sign = +1.0;
		double number = 0;

		if (tree.getText().equals("-")) {
			// Negative sign
			sign = -1.0;
			number = Gpr.parseDoubleSafe(tree.getChild(0).getText());
		} else if (tree.getText().equals("+")) {
			// Positive sign
			sign = +1.0;
			number = Gpr.parseDoubleSafe(tree.getChild(0).getText());
		} else // No sign
		number = Gpr.parseDoubleSafe(tree.getText());

		return sign * number;
	}

	/**
	 * Equivalent to Double.parseDouble, except it returns 0 on invalid value (NumberFormatException)
	 * @param s
	 * @return	double
	 */
	public static double parseDoubleSafe(String s) {
		try {
			return Double.parseDouble(s);
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * Equivalent to Integer.parseInt, except it returns 0 on invalid integer (NumberFormatException)
	 * @param s
	 * @return	int
	 */
	public static int parseIntSafe(String s) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * Read a file as a String 
	 * @param fileName : File to read (null on error)
	 * @param showExceptions : show exceptions if true 
	 */
	public static String readFile(String fileName) {
		BufferedReader inFile;
		StringBuffer strb = new StringBuffer();
		char buff[] = new char[10240];
		int len = 0;
		try {
			inFile = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			while ((len = inFile.read(buff)) >= 0)
				strb.append(buff, 0, len);
			inFile.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return strb.toString();
	}

	/**
	 * Show a mark
	 * @param i
	 * @param showEvery
	 */
	public static void showMark(int i, int showEvery) {
		if (showEvery <= 0) return;
		if (i % showEvery == 0) {
			if (i % (100 * showEvery) == 0) System.out.print(".\n" + i + "\t");
			else System.out.print('.');
		}
	}

	/**
	 * Write an object to a file 
	 * @param fileName : File to write
	 * @param obj : Object 
	 */
	public static void toFile(String fileName, Object obj) {
		BufferedWriter outFile;
		try {
			outFile = new BufferedWriter(new FileWriter(fileName));
			outFile.write(obj.toString());
			outFile.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Print a warning message (only a few of them) 
	 * @param warning
	 */
	public static void warn(String warning) {
		if (warnCount < MAX_NUMBER_OF_WARNINGS) {
			warnCount++;
			Gpr.debug(warning, 2);
		}
	}

}
