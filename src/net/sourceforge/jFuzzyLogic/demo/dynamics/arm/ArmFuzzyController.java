/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sourceforge.jFuzzyLogic.demo.dynamics.arm;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.demo.dynamics.FuzzyController;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * 
 * @author pjl
 */
public class ArmFuzzyController extends FuzzyController {

	private Variable phi1;
	private Variable dphi1dt;
	private Variable phi2;
	private Variable dphi2dt;
	private Variable torque1;
	private Variable torque2;
	
	private FunctionBlock functionBlock;

	public ArmFuzzyController(ArmModel model, InputStream file) {
		super(file, model);
	}

	protected void init() {
		if (fis == null) {
			return;
		}
		functionBlock = fis.getFunctionBlock(null);

		variables.clear();
		
		variables.add(phi1 = functionBlock.getVariable("phi1"));
		variables.add(phi2 = functionBlock.getVariable("phi2"));
		variables.add(dphi1dt = functionBlock.getVariable("dphi1dt"));
		variables.add(dphi2dt = functionBlock.getVariable("dphi2dt"));
		variables.add(torque1 = functionBlock.getVariable("torque1"));
		variables.add(torque2 = functionBlock.getVariable("torque2"));

	}

	public void setTargetAngle(double angleRequest) {
		//this.angleRequest = angleRequest;
	}

	public void control() {
		if (functionBlock == null) {
			return;
		}
		
		ArmModel model = (ArmModel) this.model;

		// calculate the error in the angles
		double phi1t = model.phi1 - model.phi1target;
		double phi2t = model.phi2 - model.phi2target;
		
		// unwrap these to lie between -PI and PI
		while(phi1t > Math.PI) phi1t  -= Math.PI*2;
		while(phi1t < -Math.PI) phi1t += Math.PI*2;
		while(phi2t > Math.PI) phi2t  -= Math.PI*2;
		while(phi2t < -Math.PI) phi2t += Math.PI*2;
		
		// set the the fuzzy system values
		// evaluate and get the outputs
		phi1.setValue(phi1t);
		phi2.setValue(phi2t);
		dphi1dt.setValue(model.dphi1dt);
		dphi2dt.setValue(model.dphi2dt);

		functionBlock.evaluate();

		double t1 = torque1.getLatestDefuzzifiedValue();
		double t2 = torque2.getLatestDefuzzifiedValue();
		
		// control the model with the fuzzy outputs.		
		model.setTorques(t1,t2);
	}

	@Override
	public String showState() {
		// throw new UnsupportedOperationException("Not supported yet.");
		return null;
	}

	//

}
