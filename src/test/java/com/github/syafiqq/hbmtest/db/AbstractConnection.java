package com.github.syafiqq.hbmtest.db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/*
 * This <test-hibernate> created by :
 * Name         : syafiq
 * Date / Time  : 09 February 2019, 7:51 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public interface AbstractConnection
{
    default SessionFactory setUp(String connection) throws Exception
    {
        final var registry = new StandardServiceRegistryBuilder()
                .configure(connection) // configures settings from hibernate.h2.cfg.xml
                .build();
        try
        {
            return new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
            StandardServiceRegistryBuilder.destroy(registry);
        }
        return null;
    }
}
