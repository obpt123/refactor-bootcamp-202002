package cc.xpbootcamp.warmup.fibonacci;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {
    @Test
    public void shouldGet1WhenFibonacciCalcAndGivenIndex1() {
        Assert.assertEquals(1, Fibonacci.Calc(1));
    }
}