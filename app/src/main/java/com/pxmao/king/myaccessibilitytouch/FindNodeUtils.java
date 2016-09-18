package com.pxmao.king.myaccessibilitytouch;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;

/**
 * Created by psq on 2016/8/24
 */
public class FindNodeUtils {


    //通过文本查找目标节点
    public static AccessibilityNodeInfo findNodeInfosByText(AccessibilityNodeInfo nodeInfo, String text) {
        List<AccessibilityNodeInfo> list = nodeInfo.findAccessibilityNodeInfosByText(text);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }


    //通过id查找目标节点
    public static AccessibilityNodeInfo findNodeInfosById(AccessibilityNodeInfo nodeInfo, String resId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            List<AccessibilityNodeInfo> list = nodeInfo.findAccessibilityNodeInfosByViewId(resId);
            if (list != null && !list.isEmpty()) {
                return list.get(0);
            }
        }
        return null;
    }


    //通过id查找右上角+号
    public static AccessibilityNodeInfo findNodeInfosById(AccessibilityNodeInfo nodeInfo, String resId, int index) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            List<AccessibilityNodeInfo> list = nodeInfo.findAccessibilityNodeInfosByViewId(resId);
            if (list != null && !list.isEmpty()) {
                return list.get(index);
            }
        }
        return null;
    }


    //通过id查找-右上角+号-添加朋友-X
    public static AccessibilityNodeInfo findNodeInfosByIdByFather1(AccessibilityNodeInfo nodeInfo, String resId, int index) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            List<AccessibilityNodeInfo> list = nodeInfo.findAccessibilityNodeInfosByViewId(resId);
            if (list != null && !list.isEmpty()) {
                return list.get(0).getChild(index);
            }
        }
        return null;
    }

    /**
     * 通过父id查找首页底部节点
     * @param rowNode 当前窗口根节点
     * @param index 1微信  2通讯录  3发现  4我
     * @return 目标节点
     */
    public static AccessibilityNodeInfo findBottomNodeByIndex(AccessibilityNodeInfo rowNode, int index) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            List<AccessibilityNodeInfo> list = rowNode.findAccessibilityNodeInfosByViewId("android:id/content");
            if (list != null && !list.isEmpty()) {
                return list.get(0).getChild(0).getChild(0).getChild(1).getChild(0).getChild(index);
            }
        }
        return null;
    }


    public static AccessibilityNodeInfo findAddListNodeInfosByIndex(AccessibilityNodeInfo rowNode, int index) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            List<AccessibilityNodeInfo> list = rowNode.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/aes");
            if (list != null && !list.isEmpty()) {
                return list.get(index);
            }
        }
        return null;
    }

    public static AccessibilityNodeInfo findAddFriendListNodeInfosByIndex(AccessibilityNodeInfo rowNode, int index) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            List<AccessibilityNodeInfo> list = rowNode.findAccessibilityNodeInfosByViewId("android:id/list");
            if (list != null && !list.isEmpty()) {
                return list.get(0).getChild(index);
            }
        }
        return null;
    }


}
