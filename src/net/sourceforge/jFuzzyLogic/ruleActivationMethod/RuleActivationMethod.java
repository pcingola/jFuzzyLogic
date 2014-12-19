package net.sourceforge.jFuzzyLogic.ruleActivationMethod;

import net.sourceforge.jFuzzyLogic.defuzzifier.Defuzzifier;
import net.sourceforge.jFuzzyLogic.defuzzifier.DefuzzifierContinuous;
import net.sourceforge.jFuzzyLogic.defuzzifier.DefuzzifierDiscrete;
import net.sourceforge.jFuzzyLogic.fcl.FclObject;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunction;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionDiscrete;
import net.sourceforge.jFuzzyLogic.rule.RuleTerm;
import net.sourceforge.jFuzzyLogic.rule.Variable;
import net.sourceforge.jFuzzyLogic.ruleAccumulationMethod.RuleAccumulationMethod;

/**
 * Rule activation method
 * Base abstract class
 * 
 * From FCL's definition:
 * "In the conclusion, subconclusions relate to the output variables. The degree of membership of the
 * conclusion is then determined on the basis of the degree of accomplishment of the condition
 * determined in aggregation (Conclusion IF A THEN B). In general, the MIN or PROD is used for
 * activation.
 * If the rule base contains rules with weighting factors wk, where wk in [0, 1], this can be implemented
 * by means of multiplication."
 *  
 * @author pcingola@users.sourceforge.net
 */
public abstract class RuleActivationMethod extends FclObject {

	String name;

	public RuleActivationMethod() {
		name = "Undefined name! (Please set it up in constructor)";
	}

	public String getName() {
		return name;
	}

	/**
	 * Implication sub method used for inference (see imply method) 
	 * @param degreeOfSupport : degree of support for this point
	 * @param membership : membership for this point
	 * @return implication
	 */
	public abstract double imply(double degreeOfSupport, double membership);

	/**
	 * Inference method
	 * Add membershipfunction to deffuzifier (using 'min' as inference)
	 */
	public void imply(RuleTerm fuzzyRuleTerm, RuleAccumulationMethod ruleAccumulationMethod, double degreeOfSupport) {
		Variable variable = fuzzyRuleTerm.getVariable();
		Defuzzifier defuzzifier = variable.getDefuzzifier();
		MembershipFunction mf = fuzzyRuleTerm.getMembershipFunction();
		double membership, y, x, aggregated = 0;

		// Both are equal? (both discrete or both continuous?)
		if (mf.isDiscrete() != defuzzifier.isDiscrete()) throw new RuntimeException("MembershipFunction and Defuzzifier are neither both discrete nor both continuous\n\tTerm: " + fuzzyRuleTerm + "\n\tMembership function: " + mf + "\n\tDefuzzifier: " + defuzzifier + "\n");

		if (mf.isDiscrete()) {
			//---
			// Discrete case
			//---
			DefuzzifierDiscrete defuzzifierDiscrete = (DefuzzifierDiscrete) defuzzifier;
			MembershipFunctionDiscrete mfd = (MembershipFunctionDiscrete) mf;

			// Add membership function to deffuzifier
			int i, size = mfd.size();
			for (i = 0; i < size; i++) {
				// Get 'x' value
				x = mfd.valueX(i);

				// Is term negated?
				if (fuzzyRuleTerm.isNegated()) membership = 1 - mf.membership(x);
				else membership = mf.membership(x);

				y = imply(degreeOfSupport, membership); // Call to abstract implication method described above

				// Aggregate value
				aggregated = ruleAccumulationMethod.aggregate(defuzzifierDiscrete.getDiscreteValue(x), y);
				defuzzifierDiscrete.setPoint(x, aggregated);
			}
		} else {
			//---
			// Continuous case
			//---
			DefuzzifierContinuous defuzzifierContinuous = (DefuzzifierContinuous) defuzzifier;
			x = defuzzifierContinuous.getMin();
			double step = defuzzifierContinuous.getStepSize();

			// Do some sanity checks
			if (Double.isNaN(x) || Double.isInfinite(x)) throw new RuntimeException("Universe minimum not calculated for term '" + fuzzyRuleTerm.getTermName() + "' : " + x);
			if (Double.isNaN(step) || Double.isInfinite(step)) throw new RuntimeException("Step not calculated for term '" + fuzzyRuleTerm.getTermName() + "' : " + step);

			int i, length = defuzzifierContinuous.getLength();

			// Add membership function to deffuzifier
			for (i = 0; i < length; i++, x += step) {
				// Is term negated?
				if (fuzzyRuleTerm.isNegated()) membership = 1 - mf.membership(x);
				else membership = mf.membership(x);

				y = imply(degreeOfSupport, membership); // Call to abstract implication method described above

				// Aggregate value
				aggregated = ruleAccumulationMethod.aggregate(defuzzifierContinuous.getValue(i), y);
				defuzzifierContinuous.setValue(i, aggregated);
			}
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.getClass().getName();
	}

	@Override
	public String toStringCpp() {
		return "ruleActivationMethod_" + name;
	}

	public String toStringCpp(RuleTerm fuzzyRuleTerm, RuleAccumulationMethod ruleAccumulationMethod, String degreeOfSupportName) {
		StringBuilder out = new StringBuilder();

		Variable variable = fuzzyRuleTerm.getVariable();
		Defuzzifier defuzzifier = variable.getDefuzzifier();

		if (fuzzyRuleTerm.getMembershipFunction().isDiscrete()) {
			throw new RuntimeException("Unimplemented for discre cases!");
		} else {
			//---
			// Continuous case
			//---
			DefuzzifierContinuous defuzzifierContinuous = (DefuzzifierContinuous) defuzzifier;

			// Add membership function to deffuzifier
			out.append("\tif( " + degreeOfSupportName + " > 0 ) {\n");
			out.append("\t\tfor (int i = 0 ; i < " + defuzzifierContinuous.getLength() + " ; i++ ) {\n");
			out.append("\t\t\tdouble x = " + defuzzifierContinuous.getMin() + " + i * " + defuzzifierContinuous.getStepSize() + ";\n");
			// Is term negated?
			if (fuzzyRuleTerm.isNegated()) out.append("\t\tmembership = 1 - mf.membership(x);\n");
			else out.append("\t\t\tdouble membership = " + fuzzyRuleTerm.getLinguisticTerm().toStringCppMethodName(fuzzyRuleTerm.getVariable()) + "(x);\n");

			out.append("\t\t\tdouble y = " + toStringCpp() + "( " + degreeOfSupportName + " , membership );\n");

			// Aggregate value
			out.append("\t\t\t" + variable.toStringCppDefuzzifyVarName() + "[i] += " + ruleAccumulationMethod.toStringCpp() + "( " + variable.toStringCppDefuzzifyVarName() + "[i], y );\n");
			out.append("\t\t}\n");
			out.append("\t}\n");
		}

		return out.toString();
	}

	public String toStringCppFunction() {
		throw new RuntimeException("Unimplemented method foe class " + this.getClass().getCanonicalName());
	}

}
