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

public class Groupfriend extends AbstractTest {
	private String casename = "添加删除成员";
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

	@Test
	public void groupfriend() {
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
	    Utils.waitDefaultTime();
	    // 点击群组
		AbstractPage.findElementByName("群组对讲").click();
		Utils.waitDefaultTime();
		// 点击群组
		AbstractPage.findElementByName("群组").click();
		// 新建群组
		AbstractPage.findElementByName("新建群组").click();
		// 创建群组
		Utils.waitDefaultTime();
		AbstractPage.findElementByName("创建").click();
		Utils.waitDefaultTime();
		// 往群组里添加好友
		AbstractPage.findElementById("com.cmcc.p.poc:id/iv_choose").click();
		Utils.waitDefaultTime();
		// 点击邀请
		AbstractPage.findElementById("com.cmcc.p.poc:id/title_right_text").click();
		Utils.waitDefaultTime();
		// 获取群组名称
		String groupname = AbstractPage.findElementById("com.cmcc.p.poc:id/tv_group_name").getText();
		//打印群组名称
		System.out.print(groupname);
		// 点击该好友
		FriendPageAction.groupfriend();
		Utils.waitDefaultTime();
		// 点击该群组
		AbstractPage.findElementByName("在线1/2人").click();
		AbstractPage.findElementByName("在线1/2人").click();
		Utils.waitDefaultTime();
		// 断言
		String text = AbstractPage.findElementById("com.cmcc.p.poc:id/tv_group_name").getText();
		Utils.waitDefaultTime();
	    System.out.print(text);
	    Utils.waitDefaultTime();
	    Assert.assertEquals(text,groupname);
	    Utils.print("从好友详情页进入群组--->PASS");
	    //解散群组
	  	AbstractGroupFunction.dismissgroup1();
	  	//删除好友
	  	FriendPageAction.deleteFirstFriend1();
	}

}
