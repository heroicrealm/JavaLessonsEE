/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.heroicrealm.javalessonsee.l01lib;

import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Dmitry
 */
public class SomeClass {
    
    Logger log = LoggerFactory.getLogger(SomeClass.class);
    
    public int someLogic(int a, int b)
    {
        log.info("In SomeClass logic");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            log.error("Got exception:"+ex);
        }
        try
        {            
            return a / b;
        }
        catch(Exception e)
        {
            log.error("Division by zero!");
        }
        finally
        {
            log.info("All done");
        }        
        return 0;
    }
    
}
