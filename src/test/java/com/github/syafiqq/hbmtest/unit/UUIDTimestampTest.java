package com.github.syafiqq.hbmtest.unit;

import com.datastax.driver.core.utils.UUIDs;
import java.util.UUID;
import org.joda.time.format.DateTimeFormat;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/*
 * This <test-hibernate> created by :
 * Name         : syafiq
 * Date / Time  : 24 February 2019, 12:16 PM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UUIDTimestampTest
{
    private static final long NUM_100NS_INTERVALS_SINCE_UUID_EPOCH = 0x01b21dd213814000L;

    public static long getTimeFromUUID(UUID uuid)
    {
        return (uuid.timestamp() - NUM_100NS_INTERVALS_SINCE_UUID_EPOCH) / 10000;
    }

    @Test
    public void testUUID()
    {
        var uuid = UUID.randomUUID();
        System.out.println("uuid.version() = " + uuid.version());
        System.out.println("uuid.toString() = " + uuid.toString());
    }

    @Test
    public void testUUIDs()
    {
        var uuid = UUIDs.timeBased();
        System.out.println("uuid.version() = " + uuid.version());
        System.out.println("uuid.toString() = " + uuid.toString());
        System.out.println("uuid.timestamp() = " + uuid.timestamp());
        System.out.println("uuid.timestamp() = " + DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS").print(getTimeFromUUID(uuid)));
    }


}
