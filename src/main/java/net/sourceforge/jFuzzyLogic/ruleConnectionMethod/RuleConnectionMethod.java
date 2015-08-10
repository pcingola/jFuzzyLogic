package net.sourceforge.jFuzzyLogic.ruleConnectionMethod;

import net.sourceforge.jFuzzyLogic.fcl.FclObject;

/**
 * Base for methods used to connect rule's antecedents
 * 
 * From FCL's specs:
 * 
 * "To fulfill de Morgan's Law, the algorithms for operators AND and OR shall be used pair-wise e.g. 
 * MAX shall be used for OR if MIN is used for AND."
 *  
 * 			Operator OR 		Operator AND 
 * 			MAX					MIN 
 * 			PROB_OR				PROD 
 * 			BSUM				BDIF
 *  
 * @author pcingola@users.sourceforge.net
 */
public abstract class RuleConnectionMethod extends FclObject {

	protected String name;

	public RuleConnectionMethod() {
		name = "Undefined name! (Please set it up in constructor)";
	}

	public abstract double connect(double antecedent1, double antecedent2);

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toStringCpp() {
		return "ruleConnectionMethod_" + name;
	}

	public String toStringCppFunction() {
		throw new RuntimeException("Unimplemented method foe class " + this.getClass().getCanonicalName());
	}

}
