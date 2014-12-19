package net.sourceforge.jFuzzyLogic.ruleConnectionMethod;

/**
 * Methods used to connect rule's antecedents
 * 
 * Connection type: AND
 * Connection Method: Hamacher product ( (antecedent1*antecedent2)/(antecedent1+antecedent2+antecedent1*antecedent2),  
 *                                      if antecedent1==0 && antecedent2==0 then 0)
 * 
 * @author jan.caha@klikni.cz
 */
public class RuleConnectionMethodAndHamacher extends RuleConnectionMethod {

	private static RuleConnectionMethod ruleConnectionMethod = new RuleConnectionMethodAndHamacher();

	public static RuleConnectionMethod get() {
		return ruleConnectionMethod;
	}

	private RuleConnectionMethodAndHamacher() {
		super();
		name = "and";
	}

	@Override
	public double connect(double antecedent1, double antecedent2) {
		if (antecedent1 == 0 && antecedent2 == 0) return 0;
		else return (antecedent1 * antecedent2) / ((antecedent1 + antecedent2) - antecedent1 * antecedent2);
	}

	@Override
	public String toStringFcl() {
		return "AND: HAMACHER;";
	}
}
