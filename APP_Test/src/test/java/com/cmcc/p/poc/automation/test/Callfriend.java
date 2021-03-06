package com.cmcc.p.poc.automation.test;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import java.util.List;
@Epic("个人中心页面-拨打电话")
@Feature("开始创造测试数据")
public class Callfriend extends AbstractTest {
	private String casename = "拨打电话";
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
	@Story("开始执行测试用例")
	@Test
	public void test() {
		// 登录
		AbstractPage.login(user1, pwd1);
		// 添加好友
		FriendPageAction.AddFriend1(user2);
		// 退出登录
		AbstractPage.logout();
		// 好友账号登录
		AbstractPage.login(user2, pwd2);
		// 同意好友申请
		FriendPageAction.acceptFriend1();
		// 退出登录
		AbstractPage.logout();
		// 账号登录
		AbstractPage.login(user1, pwd1);
		// 搜索存在的好友
		FriendPageAction.searchFriend1(user2);
		// 获取要添加的好友的名字
		String name = AbstractPage.findElementById("com.cmcc.p.poc:id/tv_name").getText();
		System.out.print(name);
		//点击返回
	    AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
		// 拨打好友电话
		FriendPageAction.clickFirstFriend1();        
		// 断言
	    Object text = AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").getText();
	    System.out.print(text);
	    Assert.assertEquals(text,"拨打");
	    Utils.print("拨打电话--->PASS");
	    //点击x
	    AbstractPage.findElementById("com.cmcc.p.poc:id/iv_close").click();
	    //点击返回
	    AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
		 //删除该好友
		Utils.waitDefaultTime();
		FriendPageAction.deleteFirstFriend2();
			    
	}

}
