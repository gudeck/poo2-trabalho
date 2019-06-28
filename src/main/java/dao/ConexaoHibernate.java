/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author guzuc
 */
public class ConexaoHibernate {

    private ConexaoHibernate() {

    }

    private static final SessionFactory SESSIONFACTORY;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            SESSIONFACTORY = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException ex) {
            // Log the exception. 
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSESSIONFACTORY() {
        return SESSIONFACTORY;
    }
}
