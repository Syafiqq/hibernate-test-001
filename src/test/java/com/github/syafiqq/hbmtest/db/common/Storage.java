package com.github.syafiqq.hbmtest.db.common;

import com.datastax.driver.core.utils.UUIDs;
import com.github.syafiqq.hbmtest.pojo.Attendee;
import com.github.syafiqq.hbmtest.pojo.Event;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

/*
 * This <test-hibernate> created by :
 * Name         : syafiq
 * Date / Time  : 10 February 2019, 7:34 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
@SuppressWarnings("ALL")
public final class Storage
{
    public static final HashMap<Long, Event> events;
    public static final HashMap<Long, Attendee> attendees;

    static
    {
        //events
        events = new LinkedHashMap<>();
        events.put(1L, new Event(UUIDs.timeBased(), "Breakfast", new Date()));
        events.put(2L, new Event(UUIDs.timeBased(), "Session 1", new Date()));

        //attendees
        attendees = new LinkedHashMap<>();
        attendees.put(1L, new Attendee(UUIDs.timeBased(), "Attendee 1", new Date()));
        attendees.put(2L, new Attendee(UUIDs.timeBased(), "Attendee 2", new Date()));
        attendees.put(3L, new Attendee(UUIDs.timeBased(), "Attendee 3", new Date()));
        attendees.put(4L, new Attendee(UUIDs.timeBased(), "Attendee 4", new Date()));
        attendees.put(5L, new Attendee(UUIDs.timeBased(), "Attendee 5", new Date()));
    }
}
