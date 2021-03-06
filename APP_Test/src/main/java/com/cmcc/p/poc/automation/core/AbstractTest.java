package com.cmcc.p.poc.automation.core;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;

import org.openqa.selenium.By;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AbstractTest {
    @SuppressWarnings("rawtypes")
    public static AndroidDriver driver;
    public static String DeviceName = "";
    public static String PlatformName = "";
    public static String PlatformVersion = "";
    public static String ServerURL = "";
    public static String AppPackage = "";
    public static String AppActivity = "";
    public static String Udid = "";
    public static DesiredCapabilities capabilities = null;

    // 初始化配置信息
    public static void initCapabilities() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(System.getProperty("user.dir") + "/capabilities.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Enumeration<?> enumer = prop.propertyNames(); // 得到配置文件的名字
        while (enumer.hasMoreElements()) {
            String strKey = (String) enumer.nextElement();
            String strValue = prop.getProperty(strKey);
            System.out.println(strKey + "=" + strValue);
        }
        DeviceName = prop.getProperty("DeviceName");
        PlatformName = prop.getProperty("PlatformName");
        PlatformVersion = prop.getProperty("PlatformVersion");
        ServerURL = prop.getProperty("ServerURL");
        AppPackage = prop.getProperty("AppPackage");
        AppActivity = prop.getProperty("AppActivity");
        Udid = prop.getProperty("Udid");
    }

    @SuppressWarnings("rawtypes")
    @BeforeClass
    public static void createAppiumServer() {
        System.out.println(Utils.formatTime() + "[@BeforeClass]createAppiumServer:init appium server and enviroment");
        initCapabilities();
        createEnvironment();
        System.out.println(Utils.formatTime() + "createAppiumServer:init driver");

        if (PlatformName.equalsIgnoreCase("Android")) {
            capabilities.setCapability("deviceName", DeviceName);
            capabilities.setCapability("platformName", PlatformName);
            capabilities.setCapability("appPackage", AppPackage);
            capabilities.setCapability("appActivity", AppActivity);
            capabilities.setCapability("platformVersion", PlatformVersion);
            capabilities.setCapability("udid", Udid);
            capabilities.setCapability("noReset", true);
            capabilities.setCapability("exported", true);
           // capabilities.setCapability("automationName","uiautomator2");

            try {
                System.out.println(Utils.formatTime() + "new a driver...");
                driver = new AndroidDriver(new URL(ServerURL), capabilities);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            initPage();
        } catch (NullPointerException e) {
            Utils.print("driver init fail");
        }

    }

    public static void createEnvironment() {
        System.out.println(Utils.formatTime() + "createEnvironment:createEnvironment");
        System.out.println(Utils.formatTime() + "PlatformType:" + PlatformName + " ");
        capabilities = new DesiredCapabilities();
       // capabilities.setCapability("unicodeKeyboard", "True");
       // capabilities.setCapability("resetKeyboard", "True");
    }

    @AfterClass
    public static void tearDownAfter() {
    	try {
    		System.out.println(Utils.formatTime() + "[@AfterClass]case end, kill server");
            Utils.print(driver.getSessionId().toString());
            if (driver != null) {
                driver.quit();
                System.out.println(Utils.formatTime() + "[@AfterClass]case end, kill server done");
            }
		} catch (Exception e) {
			// TODO: handle exception
		}

    }

    public static void initPage() {
        System.out.println(Utils.formatTime() + "start page init...");
        System.out.println(Utils.formatTime() + "end page init...");
    }

    @BeforeMethod

	public void setUp() throws UnsupportedEncodingException {
        System.out.println(Utils.formatTime() + "[@BeforeTest]");
    }

    /**
     * 复原账号
     */
    @AfterMethod
	public void tearDwon() {
        System.out.println(Utils.formatTime() + "[@AfterTest]");
    }


    
}
