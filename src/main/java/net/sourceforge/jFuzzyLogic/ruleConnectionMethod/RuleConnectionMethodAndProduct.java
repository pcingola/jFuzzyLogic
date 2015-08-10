package net.sourceforge.jFuzzyLogic.ruleConnectionMethod;

/**
 * Methods used to connect rule's antecedents
 * 
 * Connection type: AND
 * Connection Method: Product
 * 
 * @author pcingola@users.sourceforge.net
 */
public class RuleConnectionMethodAndProduct extends RuleConnectionMethod {

	private static RuleConnectionMethod ruleConnectionMethod = new RuleConnectionMethodAndProduct();

	public static RuleConnectionMethod get() {
		return ruleConnectionMethod;
	}

	private RuleConnectionMethodAndProduct() {
		super();
		name = "and";
	}

	@Override
	public double connect(double antecedent1, double antecedent2) {
		return (antecedent1 * antecedent2);
	}

	@Override
	public String toStringFcl() {
		return "AND : PROD;";
	}
}
