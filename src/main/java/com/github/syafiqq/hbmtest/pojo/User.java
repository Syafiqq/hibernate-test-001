package com.github.syafiqq.hbmtest.pojo;

import com.datastax.driver.core.utils.UUIDs;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * This <test-hibernate> created by :
 * Name         : syafiq
 * Date / Time  : 05 March 2019, 3:23 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
@SuppressWarnings("ALL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User
{
    private UUID id;
    private String name;
    private Integer age;
    private transient Address1 address1;
    private transient Address2 address2;

    @java.beans.ConstructorProperties({"name", "age"})
    public User(String name, Integer age)
    {
        this(UUIDs.timeBased(), name, age, null, null);
    }

    @java.beans.ConstructorProperties({"name", "age", "address1"})
    public User(String name, Integer age, Address1 address1)
    {
        this(UUIDs.timeBased(), name, age, address1, null);
    }

    @java.beans.ConstructorProperties({"name", "age", "address2"})
    public User(String name, Integer age, Address2 address2)
    {
        this(UUIDs.timeBased(), name, age, null, address2);
    }

    @java.beans.ConstructorProperties({"name", "age", "address1", "address2"})
    public User(String name, Integer age, Address1 address1, Address2 address2)
    {
        this(UUIDs.timeBased(), name, age, address1, address2);
    }

}
