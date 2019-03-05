package com.github.syafiqq.hbmtest.pojo;

import com.datastax.driver.core.utils.UUIDs;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * This <test-hibernate> created by :
 * Name         : syafiq
 * Date / Time  : 05 March 2019, 3:24 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
@SuppressWarnings("ALL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address
{
    private UUID id;
    private String city;
    private String state;
    private transient User user;

    @java.beans.ConstructorProperties({"city", "state"})
    public Address(String city, String state)
    {
        this(UUIDs.timeBased(), city, state, null);
    }

    @java.beans.ConstructorProperties({"city", "state", "user"})
    public Address(String city, String state, User user)
    {
        this(UUIDs.timeBased(), city, state, user);
    }
}
