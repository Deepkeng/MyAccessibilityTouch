package com.pxmao.king.myaccessibilitytouch;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;

import java.io.OutputStream;

/**
 * Created by psq on 2016/9/7
 */
public class RootShellCmd {
    private OutputStream os = null;

    public void exec(String cmd) {
        try {
            if (os == null) {
                os = Runtime.getRuntime().exec("su").getOutputStream();
            }
            os.write(cmd.getBytes());
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //模拟单击
    public void simulateClick(int x, int y) {
        exec("input tap " + Integer.toString(x) + " " + Integer.toString(y) + "\n");
    }

    //模拟长按
    public void simulateLongClick(int x, int y) {
        exec("input swipe " + Integer.toString(x) + " " + Integer.toString(y) + " " + Integer.toString(x) + " " + Integer.toString(y) + " 1500" + "\n");
        Log.d("RootShellCmd", "执行了长按");
    }


    //根据Y坐标模拟上下滑动手势
    public void simulateSwipeUpDown(int y, int y1) {
        exec("input swipe 500 " + Integer.toString(y) + " 500 " + Integer.toString(y1) + " 100 " + "\n");
    }

    //根据X坐标模拟左右滑动
    public void simulateSwipeLeftRight(int x, int x1) {
        exec("input swipe " + Integer.toString(x) + " 640 " + Integer.toString(x1) + " 640 " + "100 " + "\n");
    }

    //根据keyCode执行相应的操作
    public void simulateKey(int keyCode) {
        exec("input keyevent " + keyCode + "\n");
    }

    //给EditText设置文字
    public void setText(String content) {
        exec("input text " + content + "\n");
    }

    //截屏
    public void getScreen(String screenName) {
        exec("screencap /sdcard/backups/" + screenName + ".png" + "\n");//暂时写死的路径
    }

    //获取图片指定坐标的颜色
    public int getColors(int x, int y, String screenName) {
        String filePath = "/sdcard/backups/" + screenName + ".png";//暂时写死的路径
        Bitmap bmp = BitmapFactory.decodeFile(filePath);
        int color = 0;
        if (bmp == null) {
            return -1;
        }

        if (x >= bmp.getWidth() || y >= bmp.getHeight()) {
            Log.d("RootShellCmd", "x, y is out of bounds");
            return -1;
        }

        color = bmp.getPixel(x, y);
        bmp.recycle();

        int r = Color.red(color);
        int g = Color.green(color);
        int b = Color.blue(color);
        Log.d("RootShellCmd", "color=" + color + "  r=" + r + "  g=" + g + "   b=" + b);
        return color;


    }

    //根据X坐标模拟左右滑动
    public void simulateSwipe(String x) {
        exec("input swipe " + x + " 200 " + "\n");
    }

    public void simulateKey(String keyCode) {
        exec("input keyevent " + keyCode + "\n");
    }

   /* public int getColor(int x, int y) {
        Log.d("RootShellCmd", "method:============getColor");

        int color = 0;
        Bitmap bmp = takeScreenshot();
        if (bmp == null) {
            return -1;
        }

        if (x >= bmp.getWidth() || y >= bmp.getHeight()) {
            Log.d("RootShellCmd", "x, y is out of bounds");
            return -1;
        }

        color = bmp.getPixel(x, y);
        bmp.recycle();

        int r = Color.red(color);
        int g = Color.green(color);
        int b = Color.blue(color);
        Log.d("RootShellCmd", "color=" + color + "  r=" + r + "  g=" + g + "   b=" + b);
        return color;
    }

    private static Bitmap takeScreenshot() {
        if (Build.VERSION.SDK_INT < 17) {
            Log.d("RootShellCmd", "sdk must be >= 17 for takeScreenshot.");
            return null;
        }

        long s = System.currentTimeMillis();
        Log.d("RootShellCmd", "method:============takeScreenshot");
        try {
            Class<?> uiDeviceCls = UiDevice.getInstance().getClass();
            Method method = uiDeviceCls.getDeclaredMethod("getAutomatorBridge");
            method.setAccessible(true);
            Object uiAtuomatorBridge = method.invoke(UiDevice.getInstance());
            if (uiAtuomatorBridge != null) {
                Class<?> uiAutomatorBridgeCls = uiAtuomatorBridge.getClass().getSuperclass();
                Field field = uiAutomatorBridgeCls.getDeclaredField("mUiAutomation");
                field.setAccessible(true);
                Object uiAutomation = field.get(uiAtuomatorBridge);
                if (uiAutomation != null) {
                    Class<?> UiAutomationCls = uiAutomation.getClass();
                    Method takeScreenshot = UiAutomationCls.getDeclaredMethod("takeScreenshot");
                    takeScreenshot.setAccessible(true);
                    Object obj = takeScreenshot.invoke(uiAutomation);
                    if (obj instanceof Bitmap) {
                        Bitmap bmp = (Bitmap) obj;
                        return bmp;
                    }
                }
            }
        } catch (NoSuchFieldException e) {
            Log.d("RootShellCmd", "NoSuchFieldException:" + e.getMessage());
            e.printStackTrace();
        } catch (SecurityException e) {
            Log.d("RootShellCmd", "SecurityException:" + e.getMessage());
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            Log.d("RootShellCmd", "NoSuchMethodException:" + e.getMessage());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            Log.d("RootShellCmd", "IllegalAccessException:" + e.getMessage());
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            Log.d("RootShellCmd", "IllegalArgumentException:" + e.getMessage());
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            Log.d("RootShellCmd", "InvocationTargetException:" + e.getMessage());
            e.printStackTrace();
        }
        Log.d("RootShellCmd", "take screenshot: takes=" + (System.currentTimeMillis() - s));
        return null;
    }*/
}





