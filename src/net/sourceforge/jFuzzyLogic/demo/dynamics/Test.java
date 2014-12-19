/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sourceforge.jFuzzyLogic.demo.dynamics;

import java.io.InputStream;
import net.sourceforge.jFuzzyLogic.FIS;

/**
 *
 * @author pjl
 */
public class Test {
    
    
    public static void main(String args[]) {
        InputStream inputStream=Test.class.getResourceAsStream("ip2.fcl");
        
        FIS fis=FIS.load(inputStream, true);
        
    }

}
