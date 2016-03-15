package demo.com.calculator.util;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by 95 on 2016/3/14.
 */
public class NativeCalculatorTest extends TestCase {

    private NativeCalculator nativeCalculator;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        nativeCalculator = new NativeCalculator();

    }

    public void testAddAndModulo7() throws Exception {
        int x = 1;
        int y = 2;
        int expectedVal = 3;

        int result = nativeCalculator.addAndModulo7(x, y);
        Assert.assertEquals(expectedVal, result);

        x = 7;
        y = 1;
        expectedVal = 1;
        result = nativeCalculator.addAndModulo7(x, y);
        Assert.assertEquals(expectedVal, result);

    }

    public void testSubtractAndModulo7() throws Exception {
        int x = -5;
        int y = 3;
        int expectedVal = -1;

        int result = nativeCalculator.subtractAndModulo7(x, y);
        Assert.assertEquals(expectedVal, result);

        x = 7;
        y = 1;
        expectedVal = 6;
        result = nativeCalculator.subtractAndModulo7(x, y);
        Assert.assertEquals(expectedVal, result);

    }

    public void testMultiplyAndModulo7() throws Exception {
        int x = 5;
        int y = 2;
        int expectedVal = 3;

        int result = nativeCalculator.multiplyAndModulo7(x, y);
        Assert.assertEquals(expectedVal, result);

        x = 7;
        y = 1;
        expectedVal = 0;
        result = nativeCalculator.multiplyAndModulo7(x, y);
        Assert.assertEquals(expectedVal, result);

    }
}