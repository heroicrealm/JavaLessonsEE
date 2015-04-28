/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.heroicrealm.javalessonsee.logging.log4j;

import org.apache.log4j.Logger;
/**
 *
 * @author Dmitry
 */
public class Main {
      private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        log.trace("trace message");
        log.debug("debug message");
        log.info("info message");
        log.warn("warn message");
        log.error("error message");
        log.fatal("fatal message");
    }
}
