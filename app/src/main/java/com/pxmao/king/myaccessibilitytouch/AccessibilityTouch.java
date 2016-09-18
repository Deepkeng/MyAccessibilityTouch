package com.pxmao.king.myaccessibilitytouch;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import java.util.List;

/**
 * Created by psq on 2016/9/18
 */
public class AccessibilityTouch extends AccessibilityService {
    private static final String TAG = "MyAccessibility";
    private int mOffsetX = 20;
    private int mOffsetY = 100;
    private int mWidth;
    private int mHeight;


    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        int eventType = event.getEventType();



        switch (eventType) {
            case AccessibilityEvent.TYPE_VIEW_CLICKED:
            /*    CharSequence className = getRootInActiveWindow().getClassName();
                Log.d(TAG, "className:"+className);*/
                break;
            case AccessibilityEvent.TYPE_VIEW_LONG_CLICKED:

                break;
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED:
                CharSequence className = event.getClassName();
                Log.d(TAG, "className:"+className);
                AccessibilityNodeInfo rowNode = getRootInActiveWindow();

                List<AccessibilityNodeInfo> list = rowNode.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/aes");

                if(className.equals("android.widget.FrameLayout")&&list.size()>1){
                    Log.d(TAG, "点击了加号");
                    PerFormAction.performClickByIndexToAddList(rowNode,1);
                    Log.d(TAG, "添加朋友");
                }
                if(className.equals("com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI")){
                 // PerFormAction.performClickByIndexToAddFriendList(getRootInActiveWindow(),7);
                    new RootShellCmd().simulateClick(500,275);//点击搜索
                }
                if(className.equals("com.tencent.mm.plugin.search.ui.FTSAddFriendUI")){
                    new RootShellCmd().setText("13632316531");
                    SystemClock.sleep(2000);
                    new RootShellCmd().simulateClick(500,275);//输入账号后点击搜索

                }

                if(className.equals("com.tencent.mm.plugin.profile.ui.ContactInfoUI")){
                    new RootShellCmd().simulateClick(1060,100);//右上角的三点（和加号同一ID）
                }

                if(className.equals("android.widget.FrameLayout")&&list.size()<=1){

                    PerFormAction.performClickByIndexToAddList(rowNode,0);

                }

                if(className.equals("com.tencent.mm.ui.contact.ModRemarkNameUI")){
                    for (int i = 0; i < 30; i++) {
                        SystemClock.sleep(100);
                        new RootShellCmd().simulateKey(67);
                    }
                    new RootShellCmd().setText("9518");
                    SystemClock.sleep(2000);
                    new RootShellCmd().simulateClick(1060,100);

                }
                break;
            case AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED:

                break;

        }

    }

    @Override
    public void onInterrupt() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);

    }


}

