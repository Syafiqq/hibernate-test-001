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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User
{
    private UUID id;
    private String name;
    private Integer age;
    private Address address;

    @java.beans.ConstructorProperties({"name", "age"})
    public User(String name, Integer age)
    {
        this(UUIDs.timeBased(), name, age, null);
    }

    @java.beans.ConstructorProperties({"name", "age", "address"})
    public User(String name, Integer age, Address address)
    {
        this(UUIDs.timeBased(), name, age, address);
    }
}
