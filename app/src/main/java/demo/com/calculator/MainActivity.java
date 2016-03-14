package demo.com.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends Activity implements View.OnClickListener {

    private TextView resultView;
    private StringBuilder currentInputContent;
    private String firstOperand;
    private String secondOperant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        currentInputContent = new StringBuilder();
    }

    private void findViews() {
        findViewById(R.id.zero).setOnClickListener(this);
        findViewById(R.id.one).setOnClickListener(this);
        findViewById(R.id.two).setOnClickListener(this);
        findViewById(R.id.three).setOnClickListener(this);
        findViewById(R.id.four).setOnClickListener(this);
        findViewById(R.id.five).setOnClickListener(this);
        findViewById(R.id.six).setOnClickListener(this);
        findViewById(R.id.multiple).setOnClickListener(this);
        findViewById(R.id.minus).setOnClickListener(this);
        findViewById(R.id.add).setOnClickListener(this);
        findViewById(R.id.equal).setOnClickListener(this);
        findViewById(R.id.del).setOnClickListener(this);

        resultView = (TextView) findViewById(R.id.result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch(viewId) {
            case R.id.zero:
                if (ifStartByZero()) {
                    //do nth
                } else {
                    currentInputContent.append("0");
                }
                resultView.setText(currentInputContent.toString());
            break;
            case R.id.one:
                if (ifStartByZero()) {
                    currentInputContent.replace(0, 1, "1");
                } else {
                    currentInputContent.append("1");
                }
                resultView.setText(currentInputContent.toString());
            break;
            case R.id.two:
                if (ifStartByZero()) {
                    currentInputContent.replace(0, 1, "2");
                } else {
                    currentInputContent.append("2");
                }
            break;
            case R.id.three:
                if (ifStartByZero()) {
                    currentInputContent.replace(0, 1, "3");
                } else {
                    currentInputContent.append("3");
                }
            break;
            case R.id.four:
                if (ifStartByZero()) {
                    currentInputContent.replace(0, 1, "4");
                } else {
                    currentInputContent.append("4");
                }
            break;
            case R.id.five:
                if (ifStartByZero()) {
                    currentInputContent.replace(0, 1, "5");
                } else {
                    currentInputContent.append("5");
                }
            break;
            case R.id.six:
                if (ifStartByZero()) {
                    currentInputContent.replace(0, 1, "6");
                } else {
                    currentInputContent.append("6");
                }
            break;
            case R.id.multiple:
                if (TextUtils.isEmpty(currentInputContent.toString())) {
                    currentInputContent.append("0");
                    currentInputContent.append("X");
                } else if (!isLastCharSign()) {
                    currentInputContent.append("X");
                }
            break;
            case R.id.minus:
                if (TextUtils.isEmpty(currentInputContent.toString())) {
                    currentInputContent.append("0");
                    currentInputContent.append("-");
                } else if (!isLastCharSign()) {
                    currentInputContent.append("-");
                }
            break;
            case R.id.add:
                if (TextUtils.isEmpty(currentInputContent.toString())) {
                    currentInputContent.append("0");
                    currentInputContent.append("+");
                } else if (!isLastCharSign()) {
                    currentInputContent.append("+");
                }
            break;
            case R.id.equal:
                //TBD do calculate.
            break;
            case R.id.del:
                if (!TextUtils.isEmpty(currentInputContent.toString())) {
                    currentInputContent.deleteCharAt(currentInputContent.length() - 1);
                }
            break;
            default:break;
        }

        resultView.setText(currentInputContent.toString());
    }

    private boolean isLastCharSign() {
        CharSequence lastChar = currentInputContent.subSequence(currentInputContent.length() - 1, currentInputContent.length());

        return lastChar.equals("X") || lastChar.equals("-") || lastChar.equals("+");
    }

    private boolean ifStartByZero() {
        if (TextUtils.isEmpty(currentInputContent.toString())) {
            return false;
        }
        return currentInputContent.substring(0, 1).equals("0");
    }
}
