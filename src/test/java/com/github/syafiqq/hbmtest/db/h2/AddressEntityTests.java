package com.github.syafiqq.hbmtest.db.h2;

import com.github.syafiqq.hbmtest.db.AbstractConnection;
import com.github.syafiqq.hbmtest.db.common.Storage;
import com.github.syafiqq.hbmtest.util.HibernateLifecycleUtil;
import junit.framework.TestCase;
import static org.hamcrest.CoreMatchers.is;
import org.hibernate.SessionFactory;
import org.junit.Assert;

/*
 * This <test-hibernate> created by :
 * Name         : syafiq
 * Date / Time  : 06 March 2019, 6:06 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class AddressEntityTests extends TestCase implements AbstractConnection
{
    @SuppressWarnings("WeakerAccess")
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

    public void testGetManagedEntities()
    {
        try(var session = sessionFactory.openSession())
        {
            var user = Storage.users.get(1L);
            var address = Storage.addresses.get(1L);
            user.setAddress1(address);
            address.setUser(user);
            address.setId(user.getId());
            Assert.assertThat(0, is(HibernateLifecycleUtil.getManagedEntities(session).size()));
            session.beginTransaction();
            session.save(user);
            session.getTransaction()
                   .commit();
            Assert.assertThat(2, is(HibernateLifecycleUtil.getManagedEntities(session).size()));
        }
    }
}
