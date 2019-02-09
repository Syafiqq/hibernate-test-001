package com.github.syafiqq.hbmtest.pojo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * This <test-hibernate> created by :
 * Name         : syafiq
 * Date / Time  : 08 February 2019, 6:30 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event
{
    @Getter @Setter private Long id;
    @Getter @Setter private String title;
    @Getter @Setter private Date date;
}
