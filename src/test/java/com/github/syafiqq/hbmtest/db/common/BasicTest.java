package com.github.syafiqq.hbmtest.db.common;

import com.github.syafiqq.hbmtest.db.AbstractConnection;
import com.github.syafiqq.hbmtest.pojo.Event;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import junit.framework.TestCase;
import org.hibernate.SessionFactory;
import org.junit.Assert;

/*
 * This <test-hibernate> created by :
 * Name         : syafiq
 * Date / Time  : 09 February 2019, 1:19 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class BasicTest extends TestCase implements AbstractConnection
{
    protected SessionFactory sessionFactory;

    @Override
    protected void setUp() throws Exception
    {
        sessionFactory = AbstractConnection.super.setUp("/hbm/config/hibernate.h2.cfg.xml");
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
        session.save(new Event("My First Title", new Date()));
        session.save(new Event("My Second Title", new Date()));
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
