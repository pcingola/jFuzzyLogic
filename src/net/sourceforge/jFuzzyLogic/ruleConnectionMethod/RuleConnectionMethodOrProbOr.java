package net.sourceforge.jFuzzyLogic.ruleConnectionMethod;

/**
 * Methods used to connect rule's antecedents
 * 
 * Connection type: OR
 * Connection Method: Probabilistic OR
 * 
 * @author pcingola@users.sourceforge.net
 */
public class RuleConnectionMethodOrProbOr extends RuleConnectionMethod {

	private static RuleConnectionMethod ruleConnectionMethod = new RuleConnectionMethodOrProbOr();

	public static RuleConnectionMethod get() {
		return ruleConnectionMethod;
	}

	private RuleConnectionMethodOrProbOr() {
		super();
		name = "or";
	}

	@Override
	public double connect(double antecedent1, double antecedent2) {
		return (antecedent1 + antecedent2 - antecedent1 * antecedent2);
	}

	@Override
	public String toStringFcl() {
		return "OR: ASUM;";
	}
}
