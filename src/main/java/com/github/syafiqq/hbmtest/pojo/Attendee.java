package com.github.syafiqq.hbmtest.pojo;

import com.datastax.driver.core.utils.UUIDs;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * This <test-hibernate> created by :
 * Name         : syafiq
 * Date / Time  : 10 February 2019, 12:12 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendee
{
    private UUID id;
    private String name;
    private Date date;
    private transient Event event;

    @java.beans.ConstructorProperties({"name", "date"})
    public Attendee(String name, Date date)
    {
        this(UUIDs.timeBased(), name, date);
    }

    @java.beans.ConstructorProperties({"id", "name", "date"})
    public Attendee(UUID id, String name, Date date)
    {
        this.id = id;
        this.name = name;
        this.date = date;
    }
}
