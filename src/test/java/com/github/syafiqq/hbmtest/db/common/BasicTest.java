package com.github.syafiqq.hbmtest.db.common;

import com.github.syafiqq.hbmtest.db.AbstractConnection;
import com.github.syafiqq.hbmtest.pojo.Attendee;
import com.github.syafiqq.hbmtest.pojo.Event;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import junit.framework.TestCase;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/*
 * This <test-hibernate> created by :
 * Name         : syafiq
 * Date / Time  : 09 February 2019, 1:19 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
        try(var session = sessionFactory.openSession())
        {
            session.beginTransaction();
            session.save(new Event("My First Title", new Date()));
            session.save(new Event("My Second Title", new Date()));
            session.getTransaction()
                   .commit();
        }

        try(var session = sessionFactory.openSession())
        {
            session.beginTransaction();
            var result = session.createQuery("from Event").list();
            for(var event : (List<Event>) result)
            {
                Assert.assertTrue(Arrays.stream(new String[] {"first", "second"}).anyMatch(x -> event.getTitle().toLowerCase().contains(x)));
            }
            session.getTransaction()
                   .commit();
        }
    }

    public void testInsertEvent()
    {
        try(var session = sessionFactory.openSession())
        {
            session.beginTransaction();
            Storage.events.values().forEach(session::save);
            session.getTransaction()
                   .commit();
        }

        try(var session = sessionFactory.openSession())
        {
            session.beginTransaction();
            var cb = session.getCriteriaBuilder();
            var crt = cb.createQuery(Object.class);
            var root = crt.from(Event.class);
            crt.select(cb.count(root));
            var result = session.createQuery(crt).getSingleResult();
            Assert.assertEquals(2L, result);
            session.getTransaction()
                   .commit();
        }

        try(var session = sessionFactory.openSession())
        {
            session.beginTransaction();
            var cb = session.getCriteriaBuilder();
            var crt = cb.createQuery(Object.class);
            var root = crt.from(Attendee.class);
            crt.select(cb.count(root));
            var result = session.createQuery(crt).getSingleResult();
            Assert.assertEquals(5L, result);
            session.getTransaction()
                   .commit();
        }
    }
}
