package com.github.syafiqq.hbmtest.pojo;

import com.datastax.driver.core.utils.UUIDs;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * This <test-hibernate> created by :
 * Name         : syafiq
 * Date / Time  : 08 February 2019, 6:30 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event
{
    private UUID id;
    private String title;
    private Date date;
    private transient Set<Attendee> attendees;

    @java.beans.ConstructorProperties({"title", "date"})
    public Event(String title, Date date)
    {
        this(UUIDs.timeBased(), title, date);
    }

    @java.beans.ConstructorProperties({"id", "title", "date"})
    public Event(UUID id, String title, Date date)
    {
        this.id = id;
        this.title = title;
        this.date = date;
        this.attendees = new HashSet<>();
    }
}
