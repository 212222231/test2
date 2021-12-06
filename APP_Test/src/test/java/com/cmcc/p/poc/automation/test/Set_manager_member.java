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

public class Set_manager_member extends AbstractTest {
	private String casename = "成员管理-设置管理员（会员账号-设置管理员和取消管理员）";
	static String user;
	static String pwd;
	static String user1;
	static String pwd1;

	@Override
	@BeforeTest
	public void setUp() {
		Utils.print("casename: " + casename);
	}

	@Test(dataProvider = "loginSuccess", alwaysRun = true, dataProviderClass = DataPro.class)
	// 账号密码登录，修改getsecond1即可，1-3是
	public static void getFirst(String account, String password) {
		user = account;
		pwd = password;
	}
	
	@Test(dataProvider = "loginSuccess", alwaysRun = true, dataProviderClass = DataPro.class)
	// 账号密码登录，修改getsecond1即可，1-3是
	public static void getFirst2(String account, String password) {
		user1 = account;
		pwd1 = password;
	}
	
//执行前请先确认登录的账号是非会员账号
	@Test
	public void set_manager_member() {
		// 登录
		AbstractPage.login(user, pwd);
		// 添加好友
		FriendPageAction.AddFriend(user1);
		// 退出登录
		AbstractPage.logout();
		// 好友账号登录
		AbstractPage.login(user1, pwd1);
		// 同意好友申请
		FriendPageAction.acceptFriend();
		//点击群组对讲
		AbstractPage.findElementById("com.cmcc.p.poc:id/tab_intercom").click();
		//点击群组
		AbstractPage.findElementById("com.cmcc.p.poc:id/layout_group_list").click();
		//创建群组
		AbstractGroupFunction.newgroup1();
		//点击右上角点点点
		AbstractPage.findElementById("com.cmcc.p.poc:id/ib_group_info").click();
		//等待1s
		Utils.waitShortTime();
		//点击成员管理
		AbstractPage.findElementById("com.cmcc.p.poc:id/member_dispatch").click();
		//点击设置管理员
		AbstractPage.findElementById("com.cmcc.p.poc:id/set_manager").click();
		//点击第一个成员昵称
		AbstractPage.findElementById("com.cmcc.p.poc:id/name").click();
		//点击取消按钮
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_cancel").click();
		//点击第一个成员昵称
		AbstractPage.findElementById("com.cmcc.p.poc:id/name").click();
		//点击确定按钮
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
		//等待1s
		Utils.waitShortTime();
		//断言不显示暂无群公告，不显示元素则通过
		AssertJUnit.assertEquals(false, AbstractGroupFunction.yuansu("com.cmcc.p.poc:id/text"));
		//输出日志
		Utils.print("设置管理员成功---->PASS");
		//点击管理员昵称
		AbstractPage.findElementById("com.cmcc.p.poc:id/name").click();
		//点击取消按钮
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_cancel").click();
		//点击管理员昵称
		AbstractPage.findElementById("com.cmcc.p.poc:id/name").click();
		//点击确定按钮
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
		//等待1s
		Utils.waitShortTime();
		//断言 显示暂无群公告，显示元素则通过
		AssertJUnit.assertEquals(false, AbstractGroupFunction.yuansu("com.cmcc.p.poc:id/text"));
		//输出日志
		Utils.print("取消管理员成功---->PASS");
		//点击返回
		AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
		//等待1s
		Utils.waitShortTime();
		//点击返回
		AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
		//等待1s
		Utils.waitShortTime();
		//点击返回
		AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
		//解散群组
		AbstractGroupFunction.dismissgroup1();
		//删除好友
		FriendPageAction.deleteFirstFriend1();
	}
	
}