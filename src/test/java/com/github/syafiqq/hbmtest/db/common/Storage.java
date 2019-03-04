package com.github.syafiqq.hbmtest.db.common;

import com.datastax.driver.core.utils.UUIDs;
import com.github.syafiqq.hbmtest.pojo.Address;
import com.github.syafiqq.hbmtest.pojo.Attendee;
import com.github.syafiqq.hbmtest.pojo.Event;
import com.github.syafiqq.hbmtest.pojo.User;
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
    public static final HashMap<Long, Address> addresses;
    public static final HashMap<Long, User> users;

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

        addresses = new LinkedHashMap<>();
        addresses.put(1L, new Address("City 1", "State 1"));
        addresses.put(2L, new Address("City 2", "State 2"));
        addresses.put(3L, new Address("City 3", "State 3"));
        addresses.put(4L, new Address("City 4", "State 4"));
        addresses.put(5L, new Address("City 5", "State 5"));
        addresses.put(6L, new Address("City 6", "State 6"));

        users = new LinkedHashMap<>();
        users.put(1L, new User("Name 1", 1));
        users.put(2L, new User("Name 2", 2));
        users.put(3L, new User("Name 3", 3));
        users.put(4L, new User("Name 4", 4));
        users.put(5L, new User("Name 5", 5));
        users.put(6L, new User("Name 6", 6));
    }
}
