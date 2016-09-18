package com.pxmao.king.myaccessibilitytouch;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Dialog mTipsDialog;
    private int mOffsetX = 20;
    private int mOffsetY = 100;
    private int mWidth;
    private int mHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getDisplayPixels();
    }

    private void getDisplayPixels() {
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        mWidth = metric.widthPixels;     // 屏幕宽度（像素）
        mHeight = metric.heightPixels;   // 屏幕高度（像素）

        Log.d("MyAccessibility","宽："+mWidth+"高："+mHeight);
    }

    public void startService(View view) {
        showOpenAccessibilityServiceDialog();
    }

    /**
     * 显示未开启辅助服务的对话框
     */
    private void showOpenAccessibilityServiceDialog() {
        if (mTipsDialog != null && mTipsDialog.isShowing()) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("需要开启辅助服务正常使用");
        builder.setPositiveButton("打开辅助服务", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                openAccessibilityServiceSettings();
            }
        });
        mTipsDialog = builder.show();
    }

    /**
     * 打开辅助服务的设置
     */
    private void openAccessibilityServiceSettings() {
        try {
            Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
            startActivity(intent);
            Toast.makeText(this, "找" + getString(R.string.app_name) + ",然后开启服务", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        SystemClock.sleep(3000);
        new RootShellCmd().simulateClick(mWidth-mOffsetX,mOffsetY);

    }


    public void startMission(View view){
        finish();
    }
}

