package com.github.syafiqq.hbmtest.db.common;

import com.github.syafiqq.hbmtest.pojo.Attendee;
import com.github.syafiqq.hbmtest.pojo.Event;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * This <test-hibernate> created by :
 * Name         : syafiq
 * Date / Time  : 10 February 2019, 7:34 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public final class Storage
{
    public static final HashMap<Long, Event> events;
    public static final HashMap<Long, Attendee> attendees;

    static
    {
        //events
        events = new LinkedHashMap<>();
        events.put(1L, new Event("Breakfast", new Date()));
        events.put(2L, new Event("Session 1", new Date()));

        //attendees
        attendees = new LinkedHashMap<>();
        attendees.put(1L, new Attendee("Attendee 1", new Date()));
        attendees.put(2L, new Attendee("Attendee 2", new Date()));
        attendees.put(3L, new Attendee("Attendee 3", new Date()));
        attendees.put(4L, new Attendee("Attendee 4", new Date()));
        attendees.put(5L, new Attendee("Attendee 5", new Date()));

        //assoc
        events.get(1L).getAttendees().addAll(attendees.entrySet()
                                                      .stream()
                                                      .filter(x -> x.getKey() < 3L)
                                                      .map(Map.Entry::getValue)
                                                      .collect(Collectors.toList())
        );
        events.get(2L).getAttendees().addAll(attendees.entrySet()
                                                      .stream()
                                                      .filter(x -> x.getKey() >= 3)
                                                      .map(Map.Entry::getValue)
                                                      .collect(Collectors.toList())
        );
        attendees.entrySet()
                 .stream()
                 .filter(x -> x.getKey() < 3L)
                 .forEach(x -> x.getValue().setEvent(events.get(1L)));
        attendees.entrySet()
                 .stream()
                 .filter(x -> x.getKey() >= 3L)
                 .forEach(x -> x.getValue().setEvent(events.get(2L)));
    }
}
