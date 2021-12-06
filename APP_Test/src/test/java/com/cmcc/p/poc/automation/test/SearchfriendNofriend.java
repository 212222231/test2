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

public class SearchfriendNofriend extends AbstractTest {
	private String casename = "搜索好友-无该好友";
	static String user1;
	static String pwd1;

	@Override
	@BeforeTest
	public void setUp() {
		Utils.print("casename: " + casename);
	}

    //账号密码登录
	@Test(dataProvider = "loginSuccess", alwaysRun = true, dataProviderClass = DataPro.class)
	public static void getFirst(String account, String password) {
		user1 = account;
		pwd1 = password;
	}

	@Test
	public void searchfriendnofriend() {
		// 登录
		AbstractPage.login(user1, pwd1);
		// 搜索不存在的好友
		FriendPageAction.searchFriend1(pwd1);
		// 断言
	    Object text = AbstractPage.findElementById("com.cmcc.p.poc:id/tv_tip").getText();
	    System.out.print(text);
	    Assert.assertEquals(text,"搜索结果(0)");
	    Utils.print("搜索好友-无好友--->PASS");
	}

}
