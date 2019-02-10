package com.github.syafiqq.hbmtest.pojo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class Event
{
    private Long id;
    private String title;
    private Date date;
}
