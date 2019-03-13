package com.github.syafiqq.hbmtest.pojo;

import com.datastax.driver.core.utils.UUIDs;
import java.util.UUID;

/*
 * This <test-hibernate> created by :
 * Name         : syafiq
 * Date / Time  : 14 March 2019, 6:34 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
@SuppressWarnings("ALL")
public class Address2 extends AbstractAddress
{
    @java.beans.ConstructorProperties({})
    public Address2()
    {
        super();
    }

    @java.beans.ConstructorProperties({"city", "state"})
    public Address2(String city, String state)
    {
        super(UUIDs.timeBased(), city, state, null);
    }

    @java.beans.ConstructorProperties({"city", "state", "user"})
    public Address2(String city, String state, User user)
    {
        super(UUIDs.timeBased(), city, state, user);
    }

    @java.beans.ConstructorProperties({"id", "city", "state", "user"})
    public Address2(UUID id, String city, String state, User user)
    {
        super(id, city, state, user);
    }
}
