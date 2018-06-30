package com.example.aria.commonsocialapp.widget;

import android.content.Context;
import android.support.design.widget.BottomNavigationView;
import android.util.AttributeSet;

public class BaseBottomNavigationView extends BottomNavigationView{

    public BaseBottomNavigationView(Context context){
        super(context,null);
    }

    public BaseBottomNavigationView(Context context,AttributeSet attr){
        super(context,attr,0);
    }
    public BaseBottomNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
