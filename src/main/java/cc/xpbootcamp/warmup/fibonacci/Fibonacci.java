package cc.xpbootcamp.warmup.fibonacci;

public final class Fibonacci {
    public static long Calc(int index) {
        return index <= 2 ? 1 : Calc(index - 1) + Calc(index - 2);
    }
}