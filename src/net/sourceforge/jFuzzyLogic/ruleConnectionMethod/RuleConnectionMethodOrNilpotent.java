package net.sourceforge.jFuzzyLogic.ruleConnectionMethod;

/**
 * Methods used to connect rule's antecedents
 * 
 * Connection type: OR
 * Connection Method: Nilpotent maximum (if antecedent1 + antecedent2<1 then max(antecedent1,antecedent2), 1 otherwise)
 * 
 * @author jan.caha@klikni.cz
 */
public class RuleConnectionMethodOrNilpotent extends RuleConnectionMethod {

	private static RuleConnectionMethod ruleConnectionMethod = new RuleConnectionMethodOrNilpotent();

	public static RuleConnectionMethod get() {
		return ruleConnectionMethod;
	}

	private RuleConnectionMethodOrNilpotent() {
		super();
		name = "or";
	}

	@Override
	public double connect(double antecedent1, double antecedent2) {
		if ((antecedent1 + antecedent2) < 1) return Math.max(antecedent1, antecedent2);
		else return 1;
	}

	@Override
	public String toStringFcl() {
		return "OR: NIPMAX;";
	}
}
