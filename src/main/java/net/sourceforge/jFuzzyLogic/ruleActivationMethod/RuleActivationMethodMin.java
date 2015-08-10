package net.sourceforge.jFuzzyLogic.ruleActivationMethod;

/**
 * Rule inference method : Minimum
 * Base abstract class
 * @author pcingola@users.sourceforge.net
 */
public class RuleActivationMethodMin extends RuleActivationMethod {

	public RuleActivationMethodMin() {
		super();
		name = "min";
	}

	@Override
	public double imply(double degreeOfSupport, double membership) {
		return Math.min(degreeOfSupport, membership);
	}

	@Override
	public String toStringCppFunction() {
		return "double " + toStringCpp() + "(double degreeOfSupport, double membership)\t{ return (degreeOfSupport < membership ? degreeOfSupport : membership); }\n";
	}

	/** Printable FCL version */
	@Override
	public String toStringFcl() {
		return "ACT : MIN;";
	}
}
