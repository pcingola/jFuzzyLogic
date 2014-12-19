package net.sourceforge.jFuzzyLogic.ruleConnectionMethod;

/**
 * Methods used to connect rule's antecedents
 * 
 * Connection type: AND
 * Connection Method: Drastic t-norm (antecedent2 if antecedent1 = 1, antecedent1 if antecedent2 = 1, 0 otherwise)
 * 
 * @author jan.caha@klikni.cz
 */
public class RuleConnectionMethodAndDrastic extends RuleConnectionMethod {

	private static RuleConnectionMethod ruleConnectionMethod = new RuleConnectionMethodAndDrastic();

	public static RuleConnectionMethod get() {
		return ruleConnectionMethod;
	}

	private RuleConnectionMethodAndDrastic() {
		super();
		name = "and";
	}

	@Override
	public double connect(double antecedent1, double antecedent2) {
		if (antecedent1 == 1) return antecedent2;
		else if (antecedent2 == 1) return antecedent1;
		else return 0;
	}

	@Override
	public String toStringFcl() {
		return "AND : DMIN;";
	}
}
