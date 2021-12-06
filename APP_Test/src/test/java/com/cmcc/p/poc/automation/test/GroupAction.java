package com.cmcc.p.poc.automation.test;



import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.cmcc.p.poc.automation.core.AbstractPage;
import com.cmcc.p.poc.automation.core.AbstractTest;
import com.cmcc.p.poc.automation.core.Utils;
import com.cmcc.p.poc.automation.pagefunction.AbstractGroupFunction;

import io.appium.java_client.MobileElement;
import java.util.List;

public class GroupAction extends AbstractTest {
	private String casename = "群组详情页";
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
	public void groupaction() {
		// 登录
		AbstractPage.login(user1, pwd1);

		// 点击群组
		AbstractPage.findElementByName("群组").click();
		Utils.waitDefaultTime();	
		//创建群组
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_new_group").click();
		//等待3s
		Utils.waitDefaultTime();
		//点击创建按钮
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
		Utils.waitDefaultTime();
		//点击返回
	    AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
//		// 进入群组列表最后一个群组
//		List<MobileElement>list = AbstractPage.findElementsById("com.cmcc.p.poc:id/rl_content");
//		int ret=list.size();
//		AbstractPage.findElementsById("com.cmcc.p.poc:id/rl_content").get(ret-1).click();
        //点击右上角...
	    AbstractPage.findElementById("com.cmcc.p.poc:id/ib_group_info").click();
	    Utils.waitDefaultTime();
	    //AbstractGroupFunction.changegrounpname();
		// 断言
	    Object text = AbstractPage.findElementById("com.cmcc.p.poc:id/title_content_text").getText();
	    System.out.print(text);
	    Assert.assertEquals("群组信息",text);
	    Utils.print("进入群组信息界面--->PASS");
		//解散群组
		AbstractGroupFunction.dismissgroup2();
		}
	
	
	
}
