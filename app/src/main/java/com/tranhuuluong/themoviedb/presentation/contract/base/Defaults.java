package com.tranhuuluong.themoviedb.presentation.contract.base;

import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.unmodifiableMap;

/**
 * Created by taidangvan on 5/21/17.
 */

class Defaults {

    private Defaults() {
        // no instances
    }

    private static final Map<Class<?>, Object> DEFAULTS = unmodifiableMap(new HashMap<Class<?>, Object>() {
        {
            put(Boolean.TYPE, false);
            put(Byte.TYPE, (byte) 0);
            put(Character.TYPE, '\000');
            put(Double.TYPE, 0.0d);
            put(Float.TYPE, 0.0f);
            put(Integer.TYPE, 0);
            put(Long.TYPE, 0L);
            put(Short.TYPE, (short) 0);
        }
    });

    static <T> T defaultValue(Class<T> type) {
        return (T) DEFAULTS.get(type);
    }
}
