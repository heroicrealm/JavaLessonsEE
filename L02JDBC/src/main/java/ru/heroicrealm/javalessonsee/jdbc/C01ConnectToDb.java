/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.heroicrealm.javalessonsee.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Dmitry
 */
public class C01ConnectToDb {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(C01ConnectToDb.class);
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            log.info(con.getClass().getCanonicalName());
            
        } catch (ClassNotFoundException ex) {
            log.error(ex);
        } catch (SQLException ex) {
            log.error(ex);
        }finally
        {
            if(con!=null)
            {
                try {
                    con.close();
                } catch (SQLException ex) {
                    log.error(ex);
                }
                log.info("Connection closed");
            }
        }
        
    }
    
}
