package com.github.syafiqq.hbmtest.db;

import com.github.syafiqq.hbmtest.pojo.Event;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import junit.framework.TestCase;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Assert;

/*
 * This <test-hibernate> created by :
 * Name         : syafiq
 * Date / Time  : 09 February 2019, 1:19 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class DBEventsTest extends TestCase
{
    private SessionFactory sessionFactory;

    @Override
    protected void setUp() throws Exception
    {
        // A SessionFactory is set up once for an application!
        final var registry = new StandardServiceRegistryBuilder()
                .configure("/hbm/config/hibernate.h2.cfg.xml") // configures settings from hibernate.h2.cfg.xml
                .build();
        try
        {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            System.out.println("Session Factory Success Create");
        }
        catch(Exception e)
        {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            System.err.println(e.getMessage());
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    @Override
    protected void tearDown() throws Exception
    {
        if(sessionFactory != null)
        {
            sessionFactory.close();
        }
    }

    @SuppressWarnings("unchecked")
    public void testBasicUsage()
    {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(Event.builder()
                          .title("My First Title")
                          .date(new Date())
                          .build());
        session.save(Event.builder()
                          .title("My Second Title")
                          .date(new Date())
                          .build());
        session.getTransaction()
               .commit();
        session.close();

        // now lets pull events from the database and list them
        session = sessionFactory.openSession();
        session.beginTransaction();
        var result = session.createQuery("from Event").list();
        for(var event : (List<Event>) result)
        {
            Assert.assertTrue(Arrays.stream(new String[] {"first", "second"}).anyMatch(x -> event.getTitle().toLowerCase().contains(x)));
        }
        session.getTransaction().commit();
        session.close();
    }
}
