package com.example.hugoc.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class MaClasseGraphique extends View {
    public MaClasseGraphique(Context context) {
        super(context);
        init();
    }

    public MaClasseGraphique(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MaClasseGraphique(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    //Dessins
    private Paint crayonRect = new Paint();
    private Paint crayonDisque = new Paint();
    Drawable etoile;


    private void init(){
        crayonRect.setColor(Color.WHITE);
        crayonRect.setStyle(Paint.Style.FILL);
        crayonDisque.setColor(Color.RED);
        crayonDisque.setStyle(Paint.Style.FILL);
        etoile = getResources().getDrawable(R.drawable.etoile);
        etoile.setBounds(200,200,300,300);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        canvas.drawRect(0,0,100,50,crayonRect);
        canvas.drawCircle(100,100,60,crayonDisque);
        etoile.draw(canvas);
    }


}
