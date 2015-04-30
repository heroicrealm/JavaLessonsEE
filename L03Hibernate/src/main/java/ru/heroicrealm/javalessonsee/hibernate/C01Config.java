/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.heroicrealm.javalessonsee.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Dmitry
 */
public class C01Config {
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    static Logger log = Logger.getLogger(C01Config.class);
    private static void init() {
        log.debug("Initializing Hibernate");
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        log.info("Hibername initialized");
    }
    
     private static void destroy() {
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }

    
    public static void main(String[] args) {
        init();
        Session s = sessionFactory.getCurrentSession();
        s.beginTransaction();
        Student st = new Student();
        st.setFirstName("Petr");
        st.setLastName("Ivanov");
        st.setAge(22);
        s.save(st);
        
        s.getTransaction().commit();
        destroy();
    }
    
}
