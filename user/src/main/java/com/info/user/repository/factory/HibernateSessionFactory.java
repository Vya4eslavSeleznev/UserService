package com.info.user.repository.factory;

import com.info.user.entity.Contact;
import com.info.user.entity.Credential;
import com.info.user.entity.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class HibernateSessionFactory {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration().configure("hibernate-docker.cfg.xml");
            configuration.addAnnotatedClass(Contact.class);
            configuration.addAnnotatedClass(Credential.class);
            configuration.addAnnotatedClass(Customer.class);

            StandardServiceRegistryBuilder builder =
              new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

            sessionFactory = configuration.buildSessionFactory(builder.build());
        }

        return sessionFactory;
    }
}
