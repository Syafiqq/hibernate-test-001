package com.github.syafiqq.hbmtest.db.mysql;

import com.github.syafiqq.hbmtest.db.common.CommonDbTest;

/*
 * This <test-hibernate> created by :
 * Name         : syafiq
 * Date / Time  : 09 February 2019, 8:00 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class BasicTest extends CommonDbTest
{
    @SuppressWarnings("MethodDoesntCallSuperMethod")
    @Override protected void setUp() throws Exception
    {
        super.sessionFactory = super.setUp("/hbm/config/hibernate.mysql.cfg.xml");
    }
}
