/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.heroicrealm.javalessonsee.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;

/**
 *
 * @author Dmitry
 */
public class C04Transactions {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(C01ConnectToDb.class);
        Connection con = null;
            Statement stat = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            con.setAutoCommit(false);
            stat = con.createStatement();
            stat.executeUpdate("TRUNCATE public.\"Students\"");
            log.info("Table truncated");
            stat.executeUpdate("INSERT INTO  public.\"Students\" VALUES(default,'Vasya','Pupkin',21,'Grp-01');");
            stat.executeUpdate("INSERT INTO  public.\"Students\" VALUES(default,'Petya','Ivanov',22,'Grp-01');");
            stat.executeUpdate("INSERT INTO  public.\"Students\" VALUES(default,'Ken','unknown',22,'Grp-01');");
            stat.executeUpdate("INSERT INTO  public.\"Students\" VALUES(default,'Jonny','Cage',32,'Grp-02');");
            con.rollback();
            log.info("Record added");
           
        } catch (ClassNotFoundException ex) {
            log.error(ex);
        } catch (SQLException ex) {
            log.error(ex);
        }finally
        {
             if(stat != null)
            {
                try {
                    stat.close();
                } catch (SQLException ex) {
                      log.error(ex);
                }
            }
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
