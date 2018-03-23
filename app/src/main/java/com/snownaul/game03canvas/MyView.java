package com.snownaul.game03canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import java.util.Random;


/**
 * Created by alfo6-11 on 2018-03-23.
 */

public class MyView extends View {

    int num=0;
    int width;
    int height;

    public MyView(Context context) {
        super(context);
        WindowManager wm=(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Display display=wm.getDefaultDisplay();
        width=display.getWidth();
        height=display.getHeight();

        handler.sendEmptyMessageDelayed(0,10);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint paint=new Paint();
        canvas.drawRect(100,100,400,200,paint);

        canvas.save();//변형전 상태를 기억
        canvas.rotate(30,100,150);
        canvas.drawRect(100,100,400,200,paint);

        canvas.rotate(30,100,150);
        canvas.drawRect(100,100,400,200,paint);

        //캔버스 변형을 복구
        canvas.restore();//saved 된 지점으로 돌아간다 (save와 restore은 한 세트다 같이사용되야함)
        paint.setTextSize(100);
        canvas.drawText("aaa",500,200,paint);

        canvas.drawCircle(100,500,50,paint);

        canvas.scale(1.3f,1.0f,300,700);
        canvas.drawCircle(300,700,50,paint);

        canvas.scale(1.0f,1.3f,500,700);//스케일을 할때 이전꺼를 기억한다.
        canvas.drawCircle(500,700,50,paint);

        canvas.translate(100,-50);







        canvas.restore();

        canvas.rotate(num%360,width/2,height/2);//피봇. 축이되는 좌표의 값
        canvas.drawRect(300,300,400,500,paint);


        canvas.rotate(num-new Random().nextInt(360)%360,width/2-150,height/2+150);//피봇. 축이되는 좌표의 값
        paint.setColor(Color.RED);
        canvas.drawRect(200,200,300,400,paint);

        canvas.rotate((num-new Random().nextInt(360))%360,600,250);//피봇. 축이되는 좌표의 값
        paint.setColor(Color.YELLOW);
        canvas.drawRect(500,400,600,550,paint);

    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            invalidate();
            num+=2;
            sendEmptyMessageDelayed(0,10);
        }
    };


}
