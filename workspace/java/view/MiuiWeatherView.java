package view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by likai on 2017/9/16.
 */
public class MiuiWeatherView extends View {

    private TimeAixs mTime;

    public MiuiWeatherView(Context context) {
        super(context);
    }

    public MiuiWeatherView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MiuiWeatherView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        List<String> strs = new ArrayList<>();
        strs.add("0:00");
        strs.add("1:00");
        strs.add("2:00");
        strs.add("3:00");
        strs.add("10:00");
        strs.add("22:00");
        strs.add("23:00");
        mTime = new TimeAixs(getContext(), strs, 150);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mTime.drawTimeLine(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(mTime.getWidth(), mTime.getHeight());
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

}
