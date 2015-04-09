package net.sourceforge.jFuzzyLogic.membership;

import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.Gpr;
import net.sourceforge.jFuzzyLogic.fcl.FclLexer;
import net.sourceforge.jFuzzyLogic.fcl.FclObject;
import net.sourceforge.jFuzzyLogic.rule.Variable;

import org.antlr.runtime.tree.Tree;

/**
 * A value can be either REAL, INT, BOOL or a reference to variable
 *
 * @author pcingola@users.sourceforge.net
 */
public class Value extends FclObject {

	public enum Type {
		REAL, VAR_REFERENCE
	};

	public static final Value ONE = new Value(1.0);
	public static final Value ZERO = new Value(0.0);

	Type type;
	double valReal;
	Variable varRef;

	public Value() {
		type = Type.REAL;
		valReal = 0.0;
	}

	public Value(double valReal) {
		type = Type.REAL;
		this.valReal = valReal;
	}

	public Value(Tree tree, FunctionBlock fb) {
		if (tree.getType() == FclLexer.VALUE_REAL) {
			type = Type.REAL;
			valReal = Gpr.parseDouble(tree.getChild(0));
		} else if (tree.getType() == FclLexer.VALUE_ID) {
			type = Type.VAR_REFERENCE;
			String varName = tree.getChild(0).getText();
			varRef = fb.getVariable(varName);
			if (varRef == null) throw new RuntimeException("Cannot find variable: '" + varName + "'");
		} else throw new RuntimeException("Unimplemented 'Value' for node type: " + tree.getType() + "\ttree: " + tree.toStringTree());
	}

	public Type getType() {
		return type;
	}

	public double getValReal() {
		return valReal;
	}

	/**
	 * Get value (not really a getter)
	 */
	public double getValue() {
		if (type == null) {
			Gpr.debug("WARNING: Value type not defined!");
			return 0;
		}

		switch (type) {
		case REAL:
			return valReal;
		case VAR_REFERENCE:
			if (varRef == null) {
				Gpr.debug("WARNING: Undefined variable reference!");
				return 0;
			}
			return varRef.getValue();
		default:
			throw new RuntimeException("Value type '" + type + "' not implemented!");
		}
	}

	public Variable getVarRef() {
		return varRef;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setValReal(double valReal) {
		this.valReal = valReal;
	}

	/**
	 * Set value (not really a setter)
	 */
	public void setValue(double valReal) {
		switch (type) {
		case REAL:
			this.valReal = valReal;
			return;
		case VAR_REFERENCE:
			varRef.setValue(valReal);
			return;
		default:
			throw new RuntimeException("Value type '" + type + "' not implemented!");
		}
	}

	public void setVarRef(Variable varRef) {
		this.varRef = varRef;
	}

	@Override
	public String toStringFcl() {
		if (type == Type.REAL) return "" + getValue();
		if (type == Type.VAR_REFERENCE) return varRef.toStringFcl();
		throw new RuntimeException("Unimplemented type '" + type + "'");
	}
}
