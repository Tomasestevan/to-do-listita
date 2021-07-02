package server;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import spark.Filter;
import spark.Spark;

import static spark.Spark.after;

public class Server {
    static SessionFactory factory;
    public static void main (String[] args){
        Session session = null;
       // factory = new Configuration().configure().buildSessionFactory();
        Configuration config = new Configuration().configure("file:D:\\proyects git\\to do list\\src\\main\\resources\\hibernate.cfg.xml");
        SessionFactory sf = config.buildSessionFactory();
        Transaction txn = null;
        try {
            session = sf.openSession();
            txn = session.beginTransaction();
            txn.commit();
        } catch (RuntimeException e) {
            if ( txn != null && txn.isActive() ) txn.rollback();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        Spark.port(9047);
        Router.configure();
    }

}
