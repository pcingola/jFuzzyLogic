/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sourceforge.jFuzzyLogic.demo.dynamics.IP;

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
public class IPFuzzyController2 extends FuzzyController {

    private Variable phi;
    private Variable dphidt;
    private Variable force;
    private FunctionBlock functionBlock;
    private double angleRequest = 0.0;

    public IPFuzzyController2(IPModel model,InputStream file) {
        super(file, model);
    }

    protected void init() {
        if (fis == null) {
            return;
        }
        functionBlock = fis.getFunctionBlock(null);
        //   x = functionBlock.getVariable("x");
        //   dxdt = functionBlock.getVariable("dxdt");
        variables.clear();
        variables.add(phi = functionBlock.getVariable("phi"));
        variables.add(dphidt = functionBlock.getVariable("dphidt"));
        variables.add(force = functionBlock.getVariable("force"));

    }

    public void setTargetAngle(double angleRequest) {
        this.angleRequest = angleRequest;
    }

    public void control() {
        if (functionBlock == null) {
            return;
        }
        double X, DXDT, PHI, DPHIDT;

        IPModel model = (IPModel) this.model;

        X = model.getX();
        DXDT = model.getDxdt();
        phi.setValue(PHI = (model.getPhiInDegrees() - angleRequest));
        dphidt.setValue(DPHIDT = model.getDPhiDtInDegrees());

        functionBlock.evaluate();

        double dp = force.getLatestDefuzzifiedValue();
        if (Double.isNaN(dp)) {
            dp = 0.0;        //   double dp1=dpull.getValue();
            System.out.println(
                    String.format(
                    " x=%f  dxdt=%f phi=%f dphidt=%f ",
                    X, DXDT, PHI, DPHIDT));
        }
        model.setForce(dp);

    // Show output variable's chart 
    //	fuzzyRuleSet.getVariable("tip").chartDefuzzifier(true);

    // Print ruleSet
    //	System.out.println(fuzzyRuleSet);
    }

    @Override
    public String showState() {
        // throw new UnsupportedOperationException("Not supported yet.");
        return null;
    }

//   

   
}
