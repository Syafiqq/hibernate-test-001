package com.github.syafiqq.hbmtest.db.h2;

import com.github.syafiqq.hbmtest.db.AbstractConnection;
import junit.framework.TestCase;
import org.hibernate.SessionFactory;

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
}
