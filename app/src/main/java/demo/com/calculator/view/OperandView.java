package demo.com.calculator.view;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import demo.com.calculator.R;

public class OperandView extends TextView {

    public OperandView(Context context) {
        super(context);
    }

    public OperandView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OperandView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public OperandView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int measuredWidth = measureWidth(widthMeasureSpec);

        setMeasuredDimension(measuredWidth, measuredWidth);
    }

    private int measureWidth(int measureSpec) {

        int specMode = MeasureSpec.getMode(measureSpec);

        int specSize = MeasureSpec.getSize(measureSpec);
        int result = 400;

        if (specMode == MeasureSpec.AT_MOST) {
            result = specSize;
        } else if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        }
        return result;
    }
}
