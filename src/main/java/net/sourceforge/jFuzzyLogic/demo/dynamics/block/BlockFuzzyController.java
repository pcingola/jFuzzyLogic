package net.sourceforge.jFuzzyLogic.demo.dynamics.block;

import java.io.InputStream;
import java.util.List;

import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.demo.dynamics.FuzzyController;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 *
 * @author pjl
 */
public class BlockFuzzyController extends FuzzyController {

	private Variable dxdt;
	private Variable force;
	private FunctionBlock functionBlock;
	private Variable x;
	private double targetX;

	public BlockFuzzyController(BlockModel model, InputStream file) {
		super(file, model);
	}

	@Override
	public void control() {
		if( functionBlock == null ) return;
		double X, DXDT;

		BlockModel model = (BlockModel) this.model;

		X=model.getX();
		x.setValue(X-targetX);
		dxdt.setValue(DXDT=model.getDxdt());

		functionBlock.evaluate();

		double dp = force.getLatestDefuzzifiedValue();
		
		if( Double.isNaN(dp) ) {
			dp = 0.0; //   double dp1=dpull.getValue();
			System.out.println("NaN" + X + "  " + "  " + DXDT + dp);
		}
		model.setForce(dp);
	}

	

	

	@Override
	public String showState() {
		String str = "x=" + x.getValue() + "  dxdt=" + dxdt.getValue() + "\n";
		return str + force.toString();
	}
	
	
    protected void init() {
        if ( fis == null) return;
        functionBlock=fis.getFunctionBlock(null);
        variables.clear();
        variables.add(x    = functionBlock.getVariable("x"));
        variables.add(dxdt = functionBlock.getVariable("dxdt"));
        variables.add(force = functionBlock.getVariable("force"));
    }

    public void setTargetPosition(double x) {
        targetX=x;
    }

}
