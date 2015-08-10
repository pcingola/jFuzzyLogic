package net.sourceforge.jFuzzyLogic.optimization;

import net.sourceforge.jFuzzyLogic.membership.MembershipFunction;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * Representation of a parameter (that may be optimized using some optimization algorithm)
 * Membership funcion's parameter.
 *  
 * @author pcingola@users.sourceforge.net
 */
public class ParameterMembershipFunction extends Parameter {

	MembershipFunction membershipFunction; // Which membership funcion we refer 
	int parameterIndex; // Which parameter in that membership funcion we refer 
	Variable variable; // Variable's whose linguistic term 'membershipFunction' belongs to 

	/**
	 * Default constructor
	 * @param name : Parameter's name
	 * @param epsilon : A small number (e.g used to calculate derivates) 
	 * @param membershipFunction : Which membership funcion we refer
	 * @param parameterIndex : Which parameter in that membership funcion we refer
	 */
	public ParameterMembershipFunction(String name, double epsilon, Variable variable, MembershipFunction membershipFunction, int parameterIndex) {
		super(name, epsilon);
		this.variable = variable;
		this.membershipFunction = membershipFunction;
		this.parameterIndex = parameterIndex;
	}

	@Override
	public double get() {
		return membershipFunction.getParameter(parameterIndex);
	}

	public MembershipFunction getMembershipFunction() {
		return membershipFunction;
	}

	public int getParameterIndex() {
		return parameterIndex;
	}

	public Variable getVariable() {
		return variable;
	}

	@Override
	public boolean set(double value) {
		// Can't set parameter outside universe
		if( value < variable.getUniverseMin() ) return false;
		if( value > variable.getUniverseMax() ) return false;

		// Store old parameter
		double oldParam = membershipFunction.getParameter(parameterIndex);

		// Change to new one
		membershipFunction.setParameter(parameterIndex, value);

		// Check parameters: still ok?
		if( !membershipFunction.checkParamters(null) ) {
			// Error => reset to old value
			membershipFunction.setParameter(parameterIndex, oldParam);
			return false;
		}
		return true;
	}

	public void setMembershipFunction(MembershipFunction membershipFunction) {
		this.membershipFunction = membershipFunction;
	}

	public void setParameterIndex(int parameterIndex) {
		this.parameterIndex = parameterIndex;
	}

	public void setVariable(Variable variable) {
		this.variable = variable;
	}

}
