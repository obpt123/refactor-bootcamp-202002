package cc.xpbootcamp.warmup.fibonacci;

import java.util.HashMap;
import java.util.Map;

public final class Fibonacci {
    public static long Calc(final int index) {
        return calcInternal(index, new HashMap<>());
    }

    private static long calcInternal(final int index, final Map<Integer, Long> cacheData) {
        if (cacheData.containsKey(index)) {
            return cacheData.get(index);
        } else {
            final long value = index <= 2 ? 1 : calcInternal(index - 1, cacheData) + calcInternal(index - 2, cacheData);
            cacheData.put(index, value);
            return value;
        }
    }

}