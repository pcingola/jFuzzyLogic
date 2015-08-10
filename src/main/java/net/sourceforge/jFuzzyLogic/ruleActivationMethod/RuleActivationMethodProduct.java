package net.sourceforge.jFuzzyLogic.ruleActivationMethod;

/**
 * Rule inference method: Product
 * Base abstract class
 * @author pcingola@users.sourceforge.net
 */
public class RuleActivationMethodProduct extends RuleActivationMethod {

	public RuleActivationMethodProduct() {
		super();
		name = "product";
	}

	public double imply(double degreeOfSupport, double membership) {
		return degreeOfSupport * membership;
	}

	/** Printable FCL version */
	public String toStringFcl() {
		return "ACT : PROD;";
	}
}
