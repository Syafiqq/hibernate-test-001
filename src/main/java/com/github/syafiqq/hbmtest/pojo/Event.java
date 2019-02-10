package com.github.syafiqq.hbmtest.pojo;

import java.util.Date;
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
    private Long id;
    private String title;
    private Date date;

    @java.beans.ConstructorProperties({"title", "date"})
    public Event(String title, Date date)
    {
        this.title = title;
        this.date = date;
    }
}
