package demo.com.calculator;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.view.View;
import android.widget.TextView;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.w3c.dom.Text;

/*
 * Created by Jian on 2016/3/14.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2 {

    private MainActivity mainActivity;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        setActivityInitialTouchMode(true);
        mainActivity = (MainActivity) getActivity();
    }

    public void testAddTwoNumbersOnUI() {
        View one = mainActivity.findViewById(R.id.one);
        View add = mainActivity.findViewById(R.id.add);
        View five = mainActivity.findViewById(R.id.five);
        View equal = mainActivity.findViewById(R.id.equal);

        TextView result = (TextView) mainActivity.findViewById(R.id.result);

        TouchUtils.clickView(this, one);
        Assert.assertEquals("1", result.getText());

        TouchUtils.clickView(this, add);
        Assert.assertEquals("1+", result.getText());

        TouchUtils.clickView(this, five);
        Assert.assertEquals("1+5", result.getText());

        TouchUtils.clickView(this, equal);
        Assert.assertEquals("6", result.getText());
    }
}
