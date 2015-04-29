/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.heroicrealm.javalessonsee.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Dmitry
 */
public class C03RetrievingData {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(C01ConnectToDb.class);
        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
            stat = con.createStatement();
            rs = stat.executeQuery("SELECT fname, lname, age as bage FROM public.\"Students\"");
            while(rs.next())
            {
                System.out.println(""+rs.getString(1)+" "+rs.getString(2)+ " "+rs.getInt("bage"));
            }
            rs.close();
            System.out.println("=========================");
            rs = stat.executeQuery("SELECT fname, lname, age as bage FROM public.\"Students\" WHERE age = 22");
            
            while(rs.next())
            {
                System.out.println(""+rs.getString(1)+" "+rs.getString(2)+ " "+rs.getInt("bage"));
            }            
            rs.close();
            System.out.println("=============================");
            
            PreparedStatement pstat = con.prepareStatement("SELECT fname, lname, age as bage FROM public.\"Students\" WHERE age = ?");
            pstat.setInt(1, 21);
            rs = pstat.executeQuery();
            
            while(rs.next())
            {
                System.out.println(""+rs.getString(1)+" "+rs.getString(2)+ " "+rs.getInt("bage"));
            }            
            rs.close();
            
            
            
            
            
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
