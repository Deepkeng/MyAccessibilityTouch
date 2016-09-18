package com.pxmao.king.myaccessibilitytouch;

import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;

/**
 * Created by psq on 2016/8/25
 */
public class PerFormAction {

    /**
     * 通过索引执行首页底部点击
     * @param rowNode 当前窗口节点
     * @param index   1微信  2通讯录  3发现  4我
     */
    public static void performClickByIndexToBottom(AccessibilityNodeInfo rowNode, int index){
        Log.i("MyService","通过父ID执行点击");
        AccessibilityNodeInfo targetNode = null;
        targetNode = FindNodeUtils.findBottomNodeByIndex(rowNode,index);
        if (targetNode.isClickable()) {
            targetNode.performAction(AccessibilityNodeInfo.ACTION_CLICK);
        }
    }

    public static void performClickByText(AccessibilityNodeInfo rowNode,String text){
        Log.i("MyService","通过Text执行点击");
        AccessibilityNodeInfo targetNode = null;
        targetNode = FindNodeUtils.findNodeInfosByText(rowNode,text);
        if (targetNode.isClickable()) {
            targetNode.performAction(AccessibilityNodeInfo.ACTION_CLICK);
        }
    }

    public static void performClickByIndexToAddList(AccessibilityNodeInfo rowNode,int index){
        Log.i("MyService","通过Id查找控件，按照索引来执行点击");
        AccessibilityNodeInfo targetNode = null;
        targetNode = FindNodeUtils.findAddListNodeInfosByIndex(rowNode,index);
        if (targetNode.isClickable()) {
            targetNode.performAction(AccessibilityNodeInfo.ACTION_CLICK);
        }
    }

    public static void performClickByIndexToAddFriendList(AccessibilityNodeInfo rowNode,int index){
        Log.i("MyService","通过Id查找控件，按照索引来执行点击");
        AccessibilityNodeInfo targetNode = null;
        targetNode = FindNodeUtils.findAddFriendListNodeInfosByIndex(rowNode,index);
        if (targetNode.isClickable()) {
            targetNode.performAction(AccessibilityNodeInfo.ACTION_CLICK);
        }
    }
}
