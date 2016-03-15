package demo.com.calculator;

import android.support.test.uiautomator.UiAutomatorTestCase;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;


/*
 * Created by Jian on 2016/3/14.
 */
public class MainActivityAutoTest extends UiAutomatorTestCase {

    public void testDemo() throws UiObjectNotFoundException {
        UiDevice.getInstance(this.getInstrumentation());
        UiObject calculator = new UiObject(new UiSelector().description("calculator"));

        calculator.clickAndWaitForNewWindow();

        UiObject five = findUiObject("demo.com.calculator:id/five");
        UiObject six = findUiObject("demo.com.calculator:id/six");
        UiObject add = findUiObject("demo.com.calculator:id/add");
        UiObject equal = findUiObject("demo.com.calculator:id/equal");

        five.click();
        add.click();
        six.click();
        equal.click();

        UiObject result = findUiObject("demo.com.calculator:id/result");
        assertEquals("4", result.getText());
    }

    private UiObject findUiObject(String resourceId) {
        return UiDevice.getInstance(this.getInstrumentation())
                .findObject(new UiSelector().resourceId(resourceId));
    }
}
