package org.example.core.comon.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable e) {
            System.out.println("loi rồi");
            throw new ExceptionInInitializerError(e);
        }

    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}
