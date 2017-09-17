package view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.example.likai.miuiweather.R;
import java.util.List;

/**
 * Created by likai on 2017/9/16.
 */
public class TimeAixs {

    private final static int LINE_WIDTH = 1; //长线粗细
    private final static int SCALE_LINE_LENGTH = 6; //刻度线长度
    private final static int TEXT_TOP_SPACE = 12; //时间文本与刻度线的间隙
    private final static float TEXT_SIZE = 24f; //文字大小
    private final static int DRAW_START_POS_Y = 2; //开始画的Y位置，留一点

    private List<String> mTimeTexts; //需要绘制的时间文本
    private Context mContext;
    private int mTimePointCount = 0;
    private int mGap = 0;
    private int mHeight = 0;
    private int mWidth = 0;
    private int mExtendLong = 0;

    public TimeAixs(Context context, List<String> times, int gap) {
        mContext = context;
        mTimeTexts = times;
        mGap = gap;
        init();
    }

    private void init() {
        mExtendLong = mGap / 3;
        if (mTimeTexts != null) {
            mTimePointCount = mTimeTexts.size();
        }
        measure();
    }

    public void drawTimeLine(Canvas canvas) {
        if (mTimePointCount < 1) {
            return;
        }
        int longLineColor = mContext.getResources().getColor(R.color.time_line);
        int timeTextColor = mContext.getResources().getColor(R.color.time_text);
        int divideLineColor = mContext.getResources().getColor(R.color.devi_line);
        // 第一步，先画一条长线
        Paint paint = new Paint();
        paint.setAntiAlias(true); // 抗锯齿
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(LINE_WIDTH);
        paint.setColor(longLineColor);
        float length = mGap * (mTimePointCount - 1) + mExtendLong * 2;
        canvas.drawLine(0, DRAW_START_POS_Y, length, DRAW_START_POS_Y, paint);
        // 第二步，循环画时间文本和线
        paint.setTextSize(TEXT_SIZE); // 设置文字属性
        paint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fm = paint.getFontMetrics();
        float textStartY = DRAW_START_POS_Y + SCALE_LINE_LENGTH +
                TEXT_TOP_SPACE - fm.ascent; // ascent为负数，所以要减
        int pos;
        for (int i = 0; i < mTimePointCount; i++) {
            pos = mGap * i + mExtendLong; //画的位置
            //画文字
            paint.setColor(timeTextColor);// 文字颜色
            canvas.drawText(mTimeTexts.get(i), pos, textStartY, paint);
            //画刻度线
            paint.setColor(divideLineColor);// 刻度线颜色
            canvas.drawRect(pos, DRAW_START_POS_Y, pos + 2, DRAW_START_POS_Y
                    + SCALE_LINE_LENGTH, paint);
        }

    }

    private void measure() {
        mHeight = (int) (LINE_WIDTH + SCALE_LINE_LENGTH + TEXT_TOP_SPACE + TEXT_SIZE) + DRAW_START_POS_Y;
        mWidth = mGap * (mTimePointCount - 1) + mExtendLong * 2;
    }

    public int getWidth() {
        return mWidth;
    }

    public int getHeight() {
        return mHeight;
    }

}
