package liziqiang.bawei.com.zhoukao;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;


import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class BoLangview extends View{
    private Paint mPainttop,mPaintBottom;
    private Path mPathTop,mPathBottom;
    private float φ;
    public BoLangview(Context context) {

        super(context);
        initData(context);
    }

    public BoLangview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData(context);
    }

    public BoLangview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData(context);
    }
     private Context context;
    private void initData(Context context) {
        // 创建画笔
        mPainttop = new Paint();//第一条线
        mPainttop.setColor(Color.BLUE);// 设置颜色为白色
        mPainttop.setAntiAlias(true);// 设置抗锯齿

        mPaintBottom = new Paint();// 设置第二条线
        mPaintBottom.setColor(Color.GREEN);// 设置颜色为白色
        mPaintBottom.setAntiAlias(true);// 设置抗锯齿
        mPaintBottom.setAlpha(60);// 设置透明度


        //设置画笔两个路径
         mPathTop = new Path();
         mPathBottom = new Path();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPathTop.reset();
        mPathBottom.reset();// 重置清空一下路径

        // 路径的起始位置
        mPathTop.moveTo(getLeft(),getBottom());
        mPathBottom.moveTo(getLeft(),getBottom());// xy左下位置

        // 获取每个宽度值所占的度数
        double my = Math.PI*2/getWidth();

        φ-=0.1f;

        // 路径移动的坐标
        for (int x = 0; x <=getWidth() ; x+=5) {
            float y = (float) (10*Math.cos(my*x+φ)+10);
            mPathTop.lineTo(x,y);
            mPathBottom.lineTo(x, (float) (10*Math.sin(my*x+φ)));
            listener.animation(y);
        }
     // 路径 终止位置
        mPathTop.lineTo(getRight(),getBottom());
        mPathBottom.lineTo(getRight(),getBottom());

        canvas.drawPath(mPathTop,mPainttop);
        canvas.drawPath(mPathBottom,mPaintBottom);

       postInvalidateDelayed(20);// 刷新
    }
   private AnimationListener listener;

    //传递接口
    public void animation(AnimationListener listener){
        this.listener=listener;
    }

    public interface AnimationListener{
        void animation(float y);
    }
}
