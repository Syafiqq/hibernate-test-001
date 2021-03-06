package com.github.syafiqq.hbmtest.pojo;

import com.datastax.driver.core.utils.UUIDs;
import java.util.UUID;

/*
 * This <test-hibernate> created by :
 * Name         : syafiq
 * Date / Time  : 05 March 2019, 3:24 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
@SuppressWarnings("ALL")
public class Address1 extends AbstractAddress
{
    @java.beans.ConstructorProperties({})
    public Address1()
    {
        super();
    }

    @java.beans.ConstructorProperties({"city", "state"})
    public Address1(String city, String state)
    {
        super(UUIDs.timeBased(), city, state, null);
    }

    @java.beans.ConstructorProperties({"city", "state", "user"})
    public Address1(String city, String state, User user)
    {
        super(UUIDs.timeBased(), city, state, user);
    }

    @java.beans.ConstructorProperties({"id", "city", "state", "user"})
    public Address1(UUID id, String city, String state, User user)
    {
        super(id, city, state, user);
    }
}
