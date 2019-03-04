package com.github.syafiqq.hbmtest.db.common;

import java.util.Map;
import java.util.stream.Collectors;

/*
 * This <test-hibernate> created by :
 * Name         : syafiq
 * Date / Time  : 05 March 2019, 6:10 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public final class Relations
{
    public static void eventToAttendees()
    {
        Storage.attendees.entrySet()
                         .stream()
                         .filter(x -> x.getKey() < 3L)
                         .forEach(x -> x.getValue().setEvent(Storage.events.get(1L)));
        Storage.attendees.entrySet()
                         .stream()
                         .filter(x -> x.getKey() >= 3L)
                         .forEach(x -> x.getValue().setEvent(Storage.events.get(2L)));
    }

    public static void attendeesToEvent()
    {
        Storage.events.get(1L).getAttendees().addAll(Storage.attendees.entrySet()
                                                                      .stream()
                                                                      .filter(x -> x.getKey() < 3L)
                                                                      .map(Map.Entry::getValue)
                                                                      .collect(Collectors.toList())
        );
        Storage.events.get(2L).getAttendees().addAll(Storage.attendees.entrySet()
                                                                      .stream()
                                                                      .filter(x -> x.getKey() >= 3)
                                                                      .map(Map.Entry::getValue)
                                                                      .collect(Collectors.toList())
        );
    }
}
