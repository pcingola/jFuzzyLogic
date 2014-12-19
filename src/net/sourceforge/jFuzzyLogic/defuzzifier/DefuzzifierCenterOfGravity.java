package net.sourceforge.jFuzzyLogic.defuzzifier;

import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * Center of gravity defuzzyfier
 * @author pcingola@users.sourceforge.net
 */
public class DefuzzifierCenterOfGravity extends DefuzzifierContinuous {

	public DefuzzifierCenterOfGravity(Variable variable) {
		super(variable);
	}

	/** Defuzification function */
	@Override
	public double defuzzify() {
		double x = min, sum = 0, weightedSum = 0;

		// Calculate integrals (approximated as sums)
		for (int i = 0; i < values.length; i++, x += stepSize) {
			sum += values[i];
			weightedSum += x * values[i];
		}

		// No sum? => this variable has no active antecedent
		if (sum <= 0) return Double.NaN;

		// Calculate center of gravity
		double cog = weightedSum / sum;
		return cog;
	}

	@Override
	public String toStringCpp() {
		StringBuilder out = new StringBuilder();

		String defuzzName = "defuzzify_" + variable.getName();
		String sumName = "sum_" + variable.getName();
		String wsumName = "wsum_" + variable.getName();

		out.append("\tdouble " + sumName + " = 0.0;\n");
		out.append("\tdouble " + wsumName + " = 0.0;\n");

		out.append("\tfor (int i = 0; i < " + getLength() + " ; i++ ) {\n");
		out.append("\t\tdouble x = " + min + " + i * " + stepSize + ";\n");
		out.append("\t\t" + sumName + " += " + defuzzName + "[i];\n");
		out.append("\t\t" + wsumName + " += x * " + defuzzName + "[i];\n");
		out.append("\t}\n");
		out.append("\t" + variable.getName() + " = " + wsumName + " / " + sumName + ";\n");
		return out.toString();
	}

	@Override
	public String toStringFcl() {
		return "METHOD : COG;";
	}

}
