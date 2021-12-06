package com.cmcc.p.poc.automation.core;

import org.apache.commons.io.FileUtils;
import org.dom4j.Element;
import org.dom4j.*;   
import org.dom4j.io.*;   
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Marshaller;

public class Utils {
    public static final int SLEEPTIME = 1000;
    public static final int SLEEPTIME_SHORT = 1000;
    public static final int SLEEPTIME_MIDDLE = 3000;
    public static final int SLEEPTIME_LONG = 5000;
    public static final int SLEEPTIME_TooLONG = 300000;
    public static final long TIME_OUT = 10000;

    /**
     * 获取格式化时间
     */
    public static String formatTime() {
        return "[" + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()) + "]";
    }

    /**
     * 输出log
     *
     * @param msg
     */
    public static void print(String msg) {
        System.out.println(Utils.formatTime() + msg);
    }

    /**
     * 等待1秒
     */
    public static void waitShortTime() {
        try {
            Thread.sleep(Utils.SLEEPTIME_SHORT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 等待3秒
     */
    public static void waitDefaultTime() {
        try {
            Thread.sleep(Utils.SLEEPTIME_MIDDLE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 等待5秒
     */
    public static void waitLongTime() {
        try {
            Thread.sleep(Utils.SLEEPTIME_LONG);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    

    /**
     * 等待1h
     */
    public static void waitHourTime() {
        try {
            Thread.sleep(Utils.SLEEPTIME_TooLONG);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }  
    

    public static String cardNoTail(String cardNo) {
        if (null != cardNo && cardNo.length() > 3) {
            return cardNo.substring(cardNo.length() - 4, cardNo.length() - 1);
        }
        return "";
    }

    public static void snapshot(TakesScreenshot drivername, String filename) {
        String currentPath = System.getProperty("user.dir");
        File srcFile = drivername.getScreenshotAs(OutputType.FILE);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(new Date());
        try {
            String filepath = currentPath + "/ScreenShot/" + date + "/" + filename;
            System.out.println(Utils.formatTime() + "save snapshot path is:" + filepath);
            File file = new File(filepath + ".png");
            if (file.exists()) {
                file.delete();
            }
            FileUtils.copyFile(srcFile, file);
        } catch (IOException e) {
            System.out.println(Utils.formatTime() + "Can't save screenshot");
            e.printStackTrace();
        } finally {
            System.out
                    .println(Utils.formatTime() + "screen shot finished, it's in" + currentPath + "/ScreenShot folder");
        }
    }

    public static final String doMD5(String s) {
        char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static final void wait(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }    
   
}