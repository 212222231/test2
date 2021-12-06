package com.cmcc.p.poc.automation.test;

import java.util.List;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.cmcc.p.poc.automation.core.AbstractPage;
import com.cmcc.p.poc.automation.core.AbstractTest;
import com.cmcc.p.poc.automation.core.FriendPageMethod;
import com.cmcc.p.poc.automation.core.Utils;
import com.cmcc.p.poc.automation.pagefunction.AbstractGroupFunction;
import com.cmcc.p.poc.automation.pagefunction.FriendPageAction;

import io.appium.java_client.MobileElement;

import java.util.List;

public class Callonefriend extends AbstractTest {
	private String casename = "临时单呼";
	static String user1;
	static String pwd1;
	static String user2;
	static String pwd2;

	@Override
	@BeforeTest
	public void setUp() {
		Utils.print("casename: " + casename);
	}
	@Test(dataProvider = "loginSuccess", alwaysRun = true, dataProviderClass = DataPro.class)
    //账号密码登录
	public static void getsecond(String account, String password) {
		user2 = account;
		pwd2 = password;
	}

	@Test(dataProvider = "loginSuccess", alwaysRun = true, dataProviderClass = DataPro.class)
	public static void getFirst(String account, String password) {
		user1 = account;
		pwd1 = password;
	}

	@Test
	public void callonefriend1() {
		// 登录
		AbstractPage.login(user1, pwd1);
		// 临时单呼-对方不在线
		FriendPageAction.callonefriend("15200000009");
		// 断言
	    Object text = AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").getText();
	    System.out.print(text);
	    Assert.assertEquals(text,"临时单呼");
	    Utils.print("临时单呼-对方不在线--->PASS");
	}
	
	@Test
	public void callonefriend2() {
		// 临时单呼-账号不存在
		FriendPageAction.callonefriend("11111");
		// 断言
	    Object text = AbstractPage.findElementById("com.cmcc.p.poc:id/tv_hint").getText();
	    System.out.print(text);
	    Assert.assertEquals(text,"您输入的账号不存在");
	    Utils.print("临时单呼-账号不存在--->PASS");
	    AbstractPage.findElementById("com.cmcc.p.poc:id/iv_close").click();
	    
	}
	
	@Test
	public void callonefriend3() {
		// 添加好友
		FriendPageAction.AddFriend1(user2);
		// 退出登录
		AbstractPage.logout();
		// 好友账号登录
		AbstractPage.login(user2, pwd2);
		// 同意好友申请
		FriendPageAction.acceptFriend1();
	    Utils.waitDefaultTime();
		// 好友详情页临时单呼-账号不在线
		FriendPageAction.friendcall();
		// 断言
	    Object text = AbstractPage.findElementById("com.cmcc.p.poc:id/title_content_text").getText();
	    System.out.print(text);
	    Assert.assertEquals(text,"个人信息");
	    Utils.print("好友详情临时单呼-对方不在线--->PASS");
	    // 返回
	    AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
	    //删除好友
	    Utils.waitDefaultTime();
		FriendPageAction.deleteFirstFriend2();
	}

}