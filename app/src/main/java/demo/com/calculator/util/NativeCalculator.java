package demo.com.calculator.util;

public class NativeCalculator {

    static {
        System.loadLibrary("NativeCalculator");
    }

    public native int addAndModulo7(int leftOperand, int rightOperand);

    public native int subtractAndModulo7(int leftOperand, int rightOperand);

    public native int multiplyAndModulo7(int leftOperand, int rightOperand);

}
