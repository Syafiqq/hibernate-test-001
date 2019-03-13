package com.github.syafiqq.hbmtest.util;

import com.github.syafiqq.hbmtest.pojo.Address1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

/*
 * This <test-hibernate> created by :
 * Name         : syafiq
 * Date / Time  : 06 March 2019, 6:15 AM.
 * Email        : syafiq.rezpector@gmail.com
 * Github       : syafiqq
 */
public class DirtyDataInspector extends EmptyInterceptor
{
    private static final ArrayList<Address1> dirtyEntities = new ArrayList<>();

    public static List<Address1> getDirtyEntities()
    {
        return dirtyEntities;
    }

    public static void clearDirtyEntitites()
    {
        dirtyEntities.clear();
    }

    @Override public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types)
    {
        dirtyEntities.add((Address1) entity);
        return true;
    }
}
