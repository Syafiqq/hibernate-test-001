package com.github.syafiqq.hbmtest.db.h2;

/*
 * This <test-hibernate> created by :
 * Name         : syafiq
 * Date / Time  : 09 February 2019, 8:00 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class BasicTest extends com.github.syafiqq.hbmtest.db.common.BasicTest
{
    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override protected void setUp() throws Exception
    {
        super.sessionFactory = super.setUp("/hbm/config/hibernate.h2.cfg.xml");
    }
}
