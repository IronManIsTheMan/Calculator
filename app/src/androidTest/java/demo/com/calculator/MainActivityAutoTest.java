package demo.com.calculator;

import android.content.Intent;
import android.os.SystemClock;
import android.support.test.uiautomator.UiAutomatorTestCase;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.util.Log;

/*
 * Created by Jian on 2016/3/14.
 */
public class MainActivityAutoTest extends UiAutomatorTestCase {

    public void testDemo() throws UiObjectNotFoundException {
        UiDevice.getInstance(this.getInstrumentation());


        Intent intent = new Intent();
        intent.setClassName("demo.com.calculator", "demo.com.calculator.MainActivity");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getInstrumentation().startActivitySync(intent);

        SystemClock.sleep(1000l);

        Log.e("TT", getUiDevice().getDisplayRotation() + "");

        UiObject five = findUiObject("demo.com.calculator:id/five");
        UiObject six = findUiObject("demo.com.calculator:id/six");
        UiObject add = findUiObject("demo.com.calculator:id/add");



        UiObject equal = findUiObject("demo.com.calculator:id/equal");

        five.click();
        if (getUiDevice().getDisplayRotation() == 1) {
            getUiDevice().swipe(200, 400, 200, 0, 100);
        }
        add.click();
        six.click();
        equal.click();

        UiObject result = findUiObject("demo.com.calculator:id/result");
        assertEquals("4", result.getText());

        SystemClock.sleep(1000l);
    }

    private UiObject findUiObject(String resourceId) {
        return UiDevice.getInstance(this.getInstrumentation())
                .findObject(new UiSelector().resourceId(resourceId));
    }
}
