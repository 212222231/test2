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

public class Group_my_nick_name_tip extends AbstractTest {
	private String casename = "修改我在本群的昵称";
	static String user1;
	static String pwd1;

	@Override
	@BeforeTest
	public void setUp() {
		Utils.print("casename: " + casename);
	}

	@Test(dataProvider = "loginSuccess", alwaysRun = true, dataProviderClass = DataPro.class)
	// 账号密码登录
	public static void getsecond(String account, String password) {
		user1 = account;
		pwd1 = password;
	}

	@SuppressWarnings("unused")
	@Test
	public void grop_my_nick_name_tip() {
		// 登录
		AbstractPage.login(user1, pwd1);
		//点击群组
		AbstractPage.findElementById("com.cmcc.p.poc:id/layout_group_list").click();
		//创建群组
		AbstractGroupFunction.newgroup();
		//点击右上角设置点点点
		AbstractPage.findElementById("com.cmcc.p.poc:id/ib_group_info").click();
		//点击我在本群的昵称
		AbstractPage.findElementByName("我在本群的昵称").click();
		//获取到修改前输入框的昵称
		String wozaibenqundenicheng1 =  AbstractPage.findElementById("com.cmcc.p.poc:id/et_content").getText();
		//清空输入框
		AbstractPage.findElementById("com.cmcc.p.poc:id/et_content").clear();
		//输入新的本群昵称
		AbstractPage.findElementById("com.cmcc.p.poc:id/et_content").setValue("修改后的昵称");
		//点击完成
		AbstractPage.findElementByName("完成").click();
		//点击我在本群的昵称
		AbstractPage.findElementByName("我在本群的昵称").click();
		//获取到修改后输入框的昵称
		String wozaibenqundenicheng2 =  AbstractPage.findElementById("com.cmcc.p.poc:id/et_content").getText();
		//断言 显示修改后的昵称，则通过 或者 修改前和修改后不一致，则通过
		Assert.assertEquals("修改后的昵称", wozaibenqundenicheng2);
		Utils.print("更换群名称---->PASS");
		//点击叉号关闭
		AbstractPage.findElementById("com.cmcc.p.poc:id/iv_close").click();
		//点击返回按钮
		AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
		//解散群组
		AbstractGroupFunction.dismissgroup1();
	}
}