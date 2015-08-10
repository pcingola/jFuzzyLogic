package net.sourceforge.jFuzzyLogic.demo.dynamics.generic;

import java.util.List;

import net.sourceforge.jFuzzyLogic.demo.dynamics.ForceDrivenModel;
import net.sourceforge.jFuzzyLogic.demo.dynamics.Model;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * An IPModel object represents the dynamics of an inverted pendulum attached to a
 * sliding block.
 * @author Andrew Kaluzniacki
 */
public final class GenericModel implements Model {

        List<Variable> variables;
        

	/**
	 * propagate the model state through deltaTime using the Runge-Kutta method.
	 */
	public void update(double deltaTime) {

//		double endTime = time + deltaTime;
//		// break deltaTime into even smaller time steps.
//		while(time < endTime)
//			stepRK(timeStep);

	}

    Iterable<Variable> getVariables() {
       return variables;
    }
    
    public void setVariables(List<Variable> v){ 
            variables=v;
    }


    
}
