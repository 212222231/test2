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
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import java.util.List;
@Epic("好友页面-新好友小红点数")
@Feature("开始创造测试数据")
public class Redpointfriend extends AbstractTest {
	private String casename = "新的好友，小红点数";
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
	// 账号密码登录
	public static void getsecond(String account, String password) {
		user2 = account;
		pwd2 = password;
	}

	@Test(dataProvider = "loginSuccess", alwaysRun = true, dataProviderClass = DataPro.class)
	public static void getFirst(String account, String password) {
		user1 = account;
		pwd1 = password;
	}
	@Story("开始执行测试用例")
	@Test
	public void test() {
		// 登录
		AbstractPage.login(user1, pwd1);
		// 进入新的好友界面
		FriendPageMethod.clickFriendTab();
		AbstractPage.findElementById("com.cmcc.p.poc:id/new_group").click();
		Utils.waitDefaultTime();
    	AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
    	Utils.waitDefaultTime();
		// 退出登录
		AbstractPage.logout();
		// 好友账号登录
		AbstractPage.login(user2, pwd2);
		// 添加好友
		FriendPageAction.AddFriend(user1);
		// 退出登录
		AbstractPage.logout();
		// 账号登录
		AbstractPage.login(user1, pwd1);
		// 进入好友界面，获取小红点数
		FriendPageMethod.clickFriendTab();
		Utils.waitDefaultTime();
		Object sum1 = AbstractPage.findElementById("com.cmcc.p.poc:id/new_friends_num").getText();
		System.out.print(sum1);
		// 断言
	    // Assert.assertEquals(sum1,"1");
	    Assert.assertNotEquals(sum1,"0");
	}
}
	  