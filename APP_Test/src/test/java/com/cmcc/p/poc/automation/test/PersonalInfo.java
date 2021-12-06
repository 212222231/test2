package com.cmcc.p.poc.automation.test;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cmcc.p.poc.automation.core.AbstractPage;
import com.cmcc.p.poc.automation.core.AbstractTest;
import com.cmcc.p.poc.automation.core.Utils;
import com.cmcc.p.poc.automation.pagefunction.PersonalCenterPage;

public class PersonalInfo extends AbstractTest {
	private String casename = "检查个人信息功能";
	static String user1;
	static String pwd1;

	@Override
	@BeforeTest
	public void setUp() {
		Utils.print("casename" + casename);
	}

	@Test(dataProvider = "loginSuccess", alwaysRun = true, dataProviderClass = DataPro.class)
	public static void getFirst(String account, String password) {
		user1 = account;
		pwd1 = password;
	}
 
	@Test
	public void personalinfo() {

		AbstractPage.login(user1, pwd1);
		Utils.waitDefaultTime();
		// 个人中心
		PersonalCenterPage.clickPersionalcenter();

		// 个人信息
		PersonalCenterPage.clickPersonalinformation();
		Utils.waitDefaultTime();
		// 获取昵称
		String name = AbstractPage.findElementById("com.cmcc.p.poc:id/tv_name").getText();
		System.out.println("昵称:" + name);
		// 昵称
		PersonalCenterPage.clickNickname();
		// 清空昵称输入框
		AbstractPage.findElementById("com.cmcc.p.poc:id/et_content").clear();
		String nickname = name+"89xiugai";
		// 输入昵称信息
		AbstractPage.findElementById("com.cmcc.p.poc:id/et_content").setValue(nickname);
		// 点击完成
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();

		Utils.waitDefaultTime();
		String name1 = AbstractPage.findElementById("com.cmcc.p.poc:id/tv_name").getText();
		System.out.println("昵称:" + name1);
		
		//判断
		if (AbstractPage.whetherElementVisable(name1, 2)) {

			// 将昵称改回来，点击昵称
			PersonalCenterPage.clickNickname();
			// 清空昵称输入框
			AbstractPage.findElementById("com.cmcc.p.poc:id/et_content").clear();
			// 输入昵称信息
			AbstractPage.findElementById("com.cmcc.p.poc:id/et_content").setValue(name);
			// 点击完成
			AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
		} else {
			Utils.print("昵称修改" + "---->失败");
		}

		

		// 性别的点选
		AbstractPage.findElementById("com.cmcc.p.poc:id/rb_secret").click();
		AbstractPage.findElementById("com.cmcc.p.poc:id/rb_boy").click();
		AbstractPage.findElementById("com.cmcc.p.poc:id/rb_girl").click();
		// 点击返回
		PersonalCenterPage.clickReturn();

	}

	//@AfterTest
	//public void tearDown() {
	//	Utils.snapshot(driver, this.getClass().getSimpleName());
	//}
}
