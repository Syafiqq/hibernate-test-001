package com.github.syafiqq.hbmtest.pojo;

import java.util.Date;
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
    private Long id;
    private String name;
    private Date date;
    private transient Event event;

    @java.beans.ConstructorProperties({"name", "date"})
    public Attendee(String name, Date date)
    {
        this.name = name;
        this.date = date;
    }
}
