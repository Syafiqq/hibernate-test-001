package com.github.syafiqq.hbmtest.pojo;

/*
 * This <test-hibernate> created by :
 * Name         : syafiq
 * Date / Time  : 14 March 2019, 6:12 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */

import com.datastax.driver.core.utils.UUIDs;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("ALL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractAddress
{
    protected UUID id;
    protected String city;
    protected String state;
    protected transient User user;

    @java.beans.ConstructorProperties({"city", "state"})
    public AbstractAddress(String city, String state)
    {
        this(UUIDs.timeBased(), city, state, null);
    }

    @java.beans.ConstructorProperties({"city", "state", "user"})
    public AbstractAddress(String city, String state, User user)
    {
        this(UUIDs.timeBased(), city, state, user);
    }
}
