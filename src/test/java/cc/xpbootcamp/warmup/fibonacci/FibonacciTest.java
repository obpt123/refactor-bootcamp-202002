package cc.xpbootcamp.warmup.fibonacci;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {
    @Test
    public void shouldGet1WhenFibonacciCalcAndGivenIndex1() {
        Assert.assertEquals(1, Fibonacci.Calc(1));
    }
    @Test
    public void shouldGet1WhenFibonacciCalcAndGivenIndex2(){
        Assert.assertEquals(1, Fibonacci.Calc(2));
    }
    @Test
    public void shouldGet2WhenFibonacciCalcAndGivenIndex3(){
        Assert.assertEquals(2, Fibonacci.Calc(3));
    }
    @Test
    public void shouldGet8WhenFibonacciCalcAndGivenIndex6(){
        Assert.assertEquals(8, Fibonacci.Calc(6));
    }
}