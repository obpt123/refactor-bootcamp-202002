package cc.xpbootcamp.warmup.fibonacci;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {
    @Test
    public void shouldGet1WhenFibonacciCalcAndGivenIndex1() {
        Assert.assertEquals(1, Fibonacci.calc(1));
    }
    @Test
    public void shouldGet1WhenFibonacciCalcAndGivenIndex2(){
        Assert.assertEquals(1, Fibonacci.calc(2));
    }
    @Test
    public void shouldGet2WhenFibonacciCalcAndGivenIndex3(){
        Assert.assertEquals(2, Fibonacci.calc(3));
    }
    @Test
    public void shouldGet8WhenFibonacciCalcAndGivenIndex6(){
        Assert.assertEquals(8, Fibonacci.calc(6));
    }
    @Test
    public void shouldGet12586269025WhenFibonacciCalcAndGivenIndex50(){
        Assert.assertEquals(12586269025L, Fibonacci.calc(50));
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenFibonacciCalcAndGivenIndex0(){
       Fibonacci.calc(0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenFibonacciCalcAndGivenIndexLessThan0(){
       Fibonacci.calc(-1);
    }
}