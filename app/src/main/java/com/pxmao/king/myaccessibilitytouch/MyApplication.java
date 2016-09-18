package com.pxmao.king.myaccessibilitytouch;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by psq on 2016/9/18
 */
public class MyApplication extends Application {

    private static Context mContext;
    private static int mMainThreadId;
    private static Handler mHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        mMainThreadId = android.os.Process.myTid();// 获取当前主线程id
        mHandler = new Handler();
    }

    public static Context getContext() {
        return mContext;
    }

    public static int getMainThreadId() {
        return mMainThreadId;
    }

    public static Handler getHandler() {
        return mHandler;
    }

    /*private void getDisplayPixels() {
        DisplayMetrics metric = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(metric);
        mWidth = metric.widthPixels;     // 屏幕宽度（像素）
        mHeight = metric.heightPixels;   // 屏幕高度（像素）

        Log.d("MyAccessibility","宽："+mWidth+"高："+mHeight);
    }*/
}
