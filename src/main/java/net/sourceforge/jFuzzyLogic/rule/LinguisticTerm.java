package net.sourceforge.jFuzzyLogic.rule;

import net.sourceforge.jFuzzyLogic.CompileCpp;
import net.sourceforge.jFuzzyLogic.fcl.FclObject;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunction;

/**
 * A linguistic term is an asociation between a termName and a membership function
 * @author pcingola@users.sourceforge.net
 */
public class LinguisticTerm extends FclObject implements Comparable<LinguisticTerm>, CompileCpp {

	/** Membership function */
	MembershipFunction membershipFunction;

	/** Terms's name */
	String termName;

	public LinguisticTerm(String termName, MembershipFunction membershipFunction) {
		this.termName = termName;
		this.membershipFunction = membershipFunction;
	}

	@Override
	public int compareTo(LinguisticTerm lt) {
		return termName.compareTo(lt.getTermName());
	}

	public MembershipFunction getMembershipFunction() {
		return membershipFunction;
	}

	public String getTermName() {
		return termName;
	}

	public void setMembershipFunction(MembershipFunction membershipFunction) {
		this.membershipFunction = membershipFunction;
	}

	public void setTermName(String termName) {
		this.termName = termName;
	}

	@Override
	public String toString() {
		return "\tTerm: " + termName + "\t" + membershipFunction.toString();
	}

	public String toString(double value) {
		return "Term: " + termName + "\t" + membershipFunction.membership(value) + "\t" + membershipFunction.toString();
	}

	public String toStringCpp(String className, Variable var) {
		StringBuilder sb = new StringBuilder();
		sb.append("double " + className + "::" + toStringCppMethodName(var) + "(double x) {\n");
		sb.append(membershipFunction.toStringCpp());
		sb.append("}\n");
		return sb.toString();
	}

	public String toStringCppMethodName(Variable var) {
		return "membership_" + var.getName() + "_" + getTermName();
	}

	@Override
	public String toStringFcl() {
		return "TERM " + termName + " := " + membershipFunction.toStringFcl() + ";";
	}

}
