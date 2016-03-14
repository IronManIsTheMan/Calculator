package demo.com.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import demo.com.calculator.util.NativeCalculator;


public class MainActivity extends Activity implements View.OnClickListener {

    private TextView resultView;
    private StringBuilder currentInputContent;
    private final static String MINUS_MARK = "-";
    private final static String ADD_MARK = "+";
    private final static String MULTIPLE_MARK = "x";
    private final static String REGX_FOR_MARKS = "[+x-]";
    private NativeCalculator nativeCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        findViews();
        currentInputContent = new StringBuilder();

        nativeCalculator = new NativeCalculator();
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
                    return;
                }
                if (!isLastCharMark()) {

                    String strToValidate = currentInputContent.toString();
                    if (currentInputContent.substring(0, 1).equals(MINUS_MARK)) {
                        strToValidate = currentInputContent.substring(1);
                    }

                    if (strToValidate.split(REGX_FOR_MARKS).length == 2) {
                        doCalculation();
                        return;
                    } else {
                        currentInputContent.append(MULTIPLE_MARK);
                    }
                }
            break;
            case R.id.minus:
                if (TextUtils.isEmpty(currentInputContent.toString())) {
                    currentInputContent.append(MINUS_MARK);
                }
                if (!isLastCharMark()) {

                    String strToValidate = currentInputContent.toString();
                    if (currentInputContent.substring(0, 1).equals(MINUS_MARK)) {
                        strToValidate = currentInputContent.substring(1);
                    }

                    if (strToValidate.split(REGX_FOR_MARKS).length == 2) {
                        doCalculation();
                        return;
                    } else {
                        currentInputContent.append(MINUS_MARK);
                    }
                }
            break;
            case R.id.add:
                if (TextUtils.isEmpty(currentInputContent.toString())) {
                    return;
                }
                if (!isLastCharMark()) {

                    String strToValidate = currentInputContent.toString();
                    if (currentInputContent.substring(0, 1).equals(MINUS_MARK)) {
                        strToValidate = currentInputContent.substring(1);
                    }

                    if (strToValidate.split(REGX_FOR_MARKS).length == 2) {
                        doCalculation();
                        return;
                    } else {
                        currentInputContent.append(ADD_MARK);
                    }
                }
            break;
            case R.id.equal:
                if (TextUtils.isEmpty(currentInputContent.toString())) {
                    return;
                }
                doCalculation();
                return;
            case R.id.del:
                if (!TextUtils.isEmpty(currentInputContent.toString())) {
                    currentInputContent.deleteCharAt(currentInputContent.length() - 1);
                }
            break;
            default:break;
        }

        resultView.setText(currentInputContent.toString());
    }

    private void doCalculation() {
        boolean isFirstOperandNegtive = false;
        String subString = currentInputContent.toString();
        if (currentInputContent.substring(0, 1).equals(MINUS_MARK)) {
            isFirstOperandNegtive = true;
            subString = currentInputContent.substring(1);
        }
        if (!isLastCharMark() && subString.toString().split(REGX_FOR_MARKS).length == 2) {
            String operator = MULTIPLE_MARK;
            String firstOperand = null;
            String secondOperant = null;

            if (subString.toString().split(getRegxStr(operator)).length < 2) {
                operator = ADD_MARK;
            } else {
                firstOperand = subString.toString().split(getRegxStr(operator))[0];
                secondOperant = subString.toString().split(getRegxStr(operator))[1];
            }

            if (subString.toString().split(getRegxStr(operator)).length < 2) {
                operator = MINUS_MARK;
            } else {
                firstOperand = subString.toString().split(getRegxStr(operator))[0];
                secondOperant = subString.toString().split(getRegxStr(operator))[1];
            }

            if (subString.toString().split(getRegxStr(operator)).length < 2) {
                Log.e("CC", "Impossible");
            } else {
                firstOperand = subString.toString().split(getRegxStr(operator))[0];
                secondOperant = subString.toString().split(getRegxStr(operator))[1];
            }

            if (firstOperand != null && secondOperant != null) {
                if (isFirstOperandNegtive) {
                    firstOperand = "-" + firstOperand;
                }
                calculate(firstOperand, secondOperant, operator);
            }
        }
    }

    private String getRegxStr(String operator) {
        return "[" + operator + "]";
    }

    private boolean isLastCharMark() {
        CharSequence lastChar = currentInputContent.subSequence(currentInputContent.length() - 1, currentInputContent.length());

        return lastChar.equals(MULTIPLE_MARK) || lastChar.equals(MINUS_MARK) || lastChar.equals(ADD_MARK);
    }

    private boolean ifStartByZero() {
        if (TextUtils.isEmpty(currentInputContent.toString())) {
            return false;
        }
        return currentInputContent.substring(0, 1).equals("0");
    }

    private void calculate(String leftOperand, String rightOperand, String operator) {
        try {
            int result = 0;
            if (operator.equals(MINUS_MARK)) {
                result = nativeCalculator.subtract(Integer.valueOf(leftOperand).intValue(), Integer.valueOf(rightOperand).intValue());
            } else if (operator.equals(ADD_MARK)) {
                result = nativeCalculator.add(Integer.valueOf(leftOperand).intValue(), Integer.valueOf(rightOperand).intValue());
            } else if (operator.equals(MULTIPLE_MARK)) {
                result = nativeCalculator.multiply(Integer.valueOf(leftOperand).intValue(), Integer.valueOf(rightOperand).intValue());
            }
            resultView.setText(String.valueOf(result));

            currentInputContent.delete(0, currentInputContent.length());
            currentInputContent.append(String.valueOf(result));
        } catch (NumberFormatException e) {
            currentInputContent.delete(0, currentInputContent.length());
            resultView.setText("");
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
