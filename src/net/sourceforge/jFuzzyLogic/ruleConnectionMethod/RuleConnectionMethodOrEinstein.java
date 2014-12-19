package net.sourceforge.jFuzzyLogic.ruleConnectionMethod;

/**
 * Methods used to connect rule's antecedents
 * 
 * Connection type: OR
 * Connection Method: Einstein sum ((antecedent1+antecedent2)/(1+antecedent1*antecedent2))
 * 
 * @author jan.caha@klikni.cz
 */
public class RuleConnectionMethodOrEinstein extends RuleConnectionMethod {

	private static RuleConnectionMethod ruleConnectionMethod = new RuleConnectionMethodOrEinstein();

	public static RuleConnectionMethod get() {
		return ruleConnectionMethod;
	}

	private RuleConnectionMethodOrEinstein() {
		super();
		name = "or";
	}

	@Override
	public double connect(double antecedent1, double antecedent2) {
		return (antecedent1 + antecedent2) / (1 + antecedent1 * antecedent2);
	}

	@Override
	public String toStringFcl() {
		return "OR: EINSTEIN;";
	}
}
