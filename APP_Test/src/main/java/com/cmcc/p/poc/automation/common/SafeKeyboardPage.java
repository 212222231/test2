package com.cmcc.p.poc.automation.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.cmcc.p.poc.automation.core.AbstractPage;
import com.cmcc.p.poc.automation.core.AbstractTest;
import com.cmcc.p.poc.automation.core.Utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidKeyCode;

/**
 * 安全键盘输入页面
 *
 * 
 */
public class SafeKeyboardPage extends AbstractPage {

    /**
     * 安全键盘输入
     */
    //    public static void sendKeys(String numberStr) {
    //        System.out.println("[" + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()) + "]check安全键盘...");
    //        if (numberStr.equals("111111")) {
    //            WebElement one = AbstractTest.driver.findElementByName("1");
    //            one.click();
    //            one.click();
    //            one.click();
    //            one.click();
    //            one.click();
    //            one.click();
    //        } else if (numberStr.equals("121212")) {
    //            // WebElement one = AbstractTest.driver.findElementByName("1");
    //            WebElement one = AbstractTest.driver.findElementByXPath("//XCUIElementTypeButton[@name=\"1\"]");
    //            WebElement two = AbstractTest.driver.findElementByName("2");
    //            one.click();
    //            two.click();
    //            one.click();
    //            two.click();
    //            one.click();
    //            two.click();
    //        } else if (numberStr.equals("141414")) {
    //            WebElement one = AbstractTest.driver.findElementByName("1");
    //            WebElement four = AbstractTest.driver.findElementByName("4");
    //            one.click();
    //            four.click();
    //            one.click();
    //            four.click();
    //            one.click();
    //            four.click();
    //        }  else {
    //            WebElement one = AbstractTest.driver.findElementByName("1");
    //            WebElement two = AbstractTest.driver.findElementByName("2");
    //            WebElement three = AbstractTest.driver.findElementByName("3");
    //            WebElement four = AbstractTest.driver.findElementByName("4");
    //            WebElement five = AbstractTest.driver.findElementByName("5");
    //            WebElement six = AbstractTest.driver.findElementByName("6");
    //            WebElement seven = AbstractTest.driver.findElementByName("7");
    //            WebElement eight = AbstractTest.driver.findElementByName("8");
    //            WebElement nine = AbstractTest.driver.findElementByName("9");
    //            WebElement zero = AbstractTest.driver.findElementByName("0");
    //
    //
    //            for (int i = 0; i < numberStr.length(); i++) {
    //                switch (numberStr.charAt(i)) {
    //                case '0':
    //                    zero.click();
    //                    break;
    //                case '1':
    //                    one.click();
    //                    break;
    //                case '2':
    //                    two.click();
    //                    break;
    //                case '3':
    //                    three.click();
    //                    break;
    //                case '4':
    //                    four.click();
    //                    break;
    //                case '5':
    //                    five.click();
    //                    break;
    //                case '6':
    //                    six.click();
    //                    break;
    //                case '7':
    //                    seven.click();
    //                    break;
    //                case '8':
    //                    eight.click();
    //                    break;
    //                case '9':
    //                    nine.click();
    //                    break;
    //                default:
    //                    break;
    //                }
    //            }
    //        }
    //    }

    @SuppressWarnings("unchecked")
    public static void sendH5SMSKeys() {
        System.out.println("[" + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()) + "]check安全键盘...");
        List<MobileElement> e;
        for (int i = 0 ; i < 6 ; i++) {
            e = AbstractTest.driver.findElementsByName("1");
            e.get(e.size() - 2).click();
        }
    }

    //    public static void tapLastKeys(String numberStr) {
    //        System.out.println("[" + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()) + "]check安全键盘...");
    //        if (numberStr.equals("111111")) {
    //            MobileElement one = CommonLocationPage.getLastText("1");
    //            one.click();
    //            one.click();
    //            one.click();
    //            one.click();
    //            one.click();
    //            one.click();
    //        } else if (numberStr.equals("121212")) {
    //            // WebElement one = AbstractTest.driver.findElementByName("1");
    //            MobileElement one = CommonLocationPage.getLastText("1");
    //            MobileElement two = CommonLocationPage.getLastText("2");
    //            one.click();
    //            two.click();
    //            one.click();
    //            two.click();
    //            one.click();
    //            two.click();
    //        } else if (numberStr.equals("141414")) {
    //            MobileElement one = CommonLocationPage.getLastText("1");
    //            MobileElement four = CommonLocationPage.getLastText("4");
    //            one.click();
    //            four.click();
    //            one.click();
    //            four.click();
    //            one.click();
    //            four.click();
    //        }  else {
    //            MobileElement one = CommonLocationPage.getLastText("1");
    //            MobileElement two = CommonLocationPage.getLastText("2");
    //            MobileElement three = CommonLocationPage.getLastText("3");
    //            MobileElement four = CommonLocationPage.getLastText("4");
    //            MobileElement five = CommonLocationPage.getLastText("5");
    //            MobileElement six = CommonLocationPage.getLastText("6");
    //            MobileElement seven = CommonLocationPage.getLastText("7");
    //            MobileElement eight = CommonLocationPage.getLastText("8");
    //            MobileElement nine = CommonLocationPage.getLastText("9");
    //            MobileElement zero = CommonLocationPage.getLastText("0");
    //
    //            for (int i = 0; i < numberStr.length(); i++) {
    //                switch (numberStr.charAt(i)) {
    //                case '0':
    //                    zero.click();
    //                    break;
    //                case '1':
    //                    one.click();
    //                    break;
    //                case '2':
    //                    two.click();
    //                    break;
    //                case '3':
    //                    three.click();
    //                    break;
    //                case '4':
    //                    four.click();
    //                    break;
    //                case '5':
    //                    five.click();
    //                    break;
    //                case '6':
    //                    six.click();
    //                    break;
    //                case '7':
    //                    seven.click();
    //                    break;
    //                case '8':
    //                    eight.click();
    //                    break;
    //                case '9':
    //                    nine.click();
    //                    break;
    //                default:
    //                    break;
    //                }
    //            }
    //        }
    //    }


    public static void sendKeysForAndroid(String numberStr) {
        for (int i = 0; i < numberStr.length(); i++) {
            Utils.waitShortTime();;
            switch (numberStr.charAt(i)) {
            case '0':
                AbstractTest.driver.pressKeyCode(AndroidKeyCode.KEYCODE_0);

                break;
            case '1':
                AbstractTest.driver.pressKeyCode(AndroidKeyCode.KEYCODE_1);

                break;
            case '2':
                AbstractTest.driver.pressKeyCode(AndroidKeyCode.KEYCODE_2);

                break;
            case '3':
                AbstractTest.driver.pressKeyCode(AndroidKeyCode.KEYCODE_3);

                break;
            case '4':
                AbstractTest.driver.pressKeyCode(AndroidKeyCode.KEYCODE_4);

                break;
            case '5':
                AbstractTest.driver.pressKeyCode(AndroidKeyCode.KEYCODE_5);

                break;
            case '6':
                AbstractTest.driver.pressKeyCode(AndroidKeyCode.KEYCODE_6);

                break;
            case '7':
                AbstractTest.driver.pressKeyCode(AndroidKeyCode.KEYCODE_7);

                break;
            case '8':
                AbstractTest.driver.pressKeyCode(AndroidKeyCode.KEYCODE_8);
                AbstractTest.driver.pressKeyCode(AndroidKeyCode.KEYCODE_MOVE_END);
                break;
            case '9':
                AbstractTest.driver.pressKeyCode(AndroidKeyCode.KEYCODE_9);
                AbstractTest.driver.pressKeyCode(AndroidKeyCode.KEYCODE_MOVE_END);
                break;
            default:
                break;
            }
        }

    } 

}
