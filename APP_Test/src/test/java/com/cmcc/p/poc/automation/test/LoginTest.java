package com.cmcc.p.poc.automation.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.AssertJUnit;
import org.testng.Assert.*;
import org.openqa.selenium.By;
import com.cmcc.p.poc.automation.core.AbstractPage;
import com.cmcc.p.poc.automation.core.AbstractTest;
import com.cmcc.p.poc.automation.core.Utils;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


//uppressWarnings("deprecation")
public class LoginTest extends AbstractTest {
	
	
	
	private String casename = "检查登陆功能";
	static String user1;
	static String pwd1;
	
	
	@Override
	@BeforeTest
	public void setUp() {
		Utils.print("casename: " + casename);

	}

	@SuppressWarnings("deprecation")
	@Test(dataProvider = "loginSuccess",alwaysRun = true, dataProviderClass = DataPro.class)
	// 账号密码登录
	public static void getFirst(String account,String password) {
		
	 user1 = account;
	 pwd1=password;
		
	}
	@Test
	public static void logintest() {

		
//		// 判断是否有隐私弹窗，如果有就点击同意
//		if (AbstractPage.whetherElementVisable(By.id("android:id/content"), 1)) {
//			AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
//	}
//		// 判断是否有升级弹窗，如果有就点击取消
//	if (AbstractPage.whetherElementVisable(By.id("com.cmcc.p.poc:id/tv_info"), 1)) {
//			AbstractPage.findElementById("com.cmcc.p.poc:id/btn_cancel").click();
//		}
//
//		Utils.waitDefaultTime();
		// 判断是否进入了登陆页
		AbstractPage.untilElementDisplayed(By.id("com.cmcc.p.poc:id/tv_account_tip"), 1);
		//清空账号输入框
		AbstractPage.findElementById("com.cmcc.p.poc:id/et_phone_num").clear();
		// 输入用户名
		AbstractPage.findElementById("com.cmcc.p.poc:id/et_phone_num").setValue(user1);
		//输入密码
		 AbstractPage.findElementById("com.cmcc.p.poc:id/et_pwd").setValue(pwd1);

		// 勾选记住密码
		 AbstractPage.findElementById("com.cmcc.p.poc:id/iv_remember").click();
//	        //点击中国移动用户一键登录
		//AbstractPage.findElementById("com.cmcc.p.poc:id/tv_yidong_login").click();
	        Utils.waitLongTime();
		// 点击登陆
	    AbstractPage.findElementById("com.cmcc.p.poc:id/tv_login").click();
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date d1 = new Date();

		// Utils.waitDefaultTime();
		// 判断首页是否有公告，如果有就点击同意
				if (AbstractPage.whetherElementVisable(By.id("com.cmcc.p.poc:id/viewPager"), 1)) {
					AbstractPage.findElementById("com.cmcc.p.poc:id/iv_close").click();
			}
				// 判断首页是否有优惠券提示，如果有就点击同意
				if (AbstractPage.whetherElementVisable(By.id("com.cmcc.p.poc:id/tv_msg"), 1)) {
					AbstractPage.findElementById("com.cmcc.p.poc:id/iv_close").click();
			}		
				// 判断首页是否有密码提示，如果有就点击同意
				if (AbstractPage.whetherElementVisable(By.id("com.cmcc.p.poc:id/tv_msg"), 1)) {
					AbstractPage.findElementById("com.cmcc.p.poc:id/iv_close").click();
			}	
				// 判断首页是否有温馨提示，如果有就点击同意
				if (AbstractPage.whetherElementVisable(By.id("com.cmcc.p.poc:id/tv_title"), 1)) {
					AbstractPage.findElementById("com.cmcc.p.poc:id/iv_close").click();
			}			
				
				
		// 判断是不是登陆成功，若没有登陆成功，提示没有进入首页
		AssertJUnit.assertTrue("没有进入首页", AbstractPage.whetherElementVisable("群组", 1));	
		Utils.print("账号密码登录--->PASS");
//		Date d2 = new Date();
//
//		long diff = d2.getTime() - d1.getTime();
//		long days = diff / (1000 * 60 * 60 * 24);
//
//		System.out.println(diff);
//		System.out.println(days);
//		System.out.println(d1);
//		System.out.println(d2);
//		// 点击个人中心
		// AbstractPage.findElementById("com.cmcc.p.poc:id/tab_me").click();

		// 点击设置
		// AbstractPage.findElementById("com.cmcc.p.poc:id/rl_me_setting").click();

		// 点击退出登录
		// AbstractPage.findElementById("com.cmcc.p.poc:id/tv_sign_out").click();
		// 点击确定
		// AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
		// Utils.print(casename + "账号密码---->PASS");

//	        //点击中国移动用户一键登录
//        AbstractPage.findElementById("com.cmcc.p.poc:id/tv_yidong_login").click();
//	        Utils.waitLongTime();
//	        // 判断是不是登陆成功，若没有登陆成功，提示没有进入首页
//	        AssertJUnit.assertTrue("没有进入首页",AbstractPage.whetherElementVisable("群组", 1));
//	        
//      //点击个人中心
//	        AbstractPage.findElementById("com.cmcc.p.poc:id/tab_me").click();
//	        
//	        //点击设置
//	        AbstractPage.findElementById("com.cmcc.p.poc:id/rl_me_setting").click();
//        
//	        //点击退出登录
//	        AbstractPage.findElementById("com.cmcc.p.poc:id/tv_sign_out").click();
//	        Utils.print(casename + "一键登录---->PASS");
		// 退出登录
		AbstractPage.logout();
	}

}
