package com.cmcc.p.poc.automation.test;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cmcc.p.poc.automation.core.AbstractPage;
import com.cmcc.p.poc.automation.core.AbstractTest;
import com.cmcc.p.poc.automation.core.Utils;
import com.cmcc.p.poc.automation.pagefunction.AbstractGroupFunction;

public class GroupUndisturbed extends AbstractTest {

	private String casename = "群组免打扰功能";
	static String user1;
	static String pwd1;

	@Override
	@BeforeTest
	public void setUp() {
		Utils.print("casename" + casename);
	}

	@SuppressWarnings("deprecation")
	@Test(dataProvider = "loginSuccess", alwaysRun = true, dataProviderClass = DataPro.class)
	// 账号密码登录
	public static void getFirst(String account, String password) {
		user1 = account;
		pwd1 = password;
	}
	 
	 @Test
	 public  void groupundisturbed(){
		 
		 //登录
		 AbstractPage.login(user1, pwd1);
		 Utils.waitDefaultTime();
		 //新建群组
		 AbstractGroupFunction.newgroup();
		 Utils.waitDefaultTime();	 
		 //群组对讲页面，点击右上角的三个点
		 AbstractPage.findElementById("com.cmcc.p.poc:id/ib_group_info").click();
		 Utils.waitDefaultTime();
		 //开启免打扰
		 AbstractPage.findElementById("com.cmcc.p.poc:id/mute_group").click();
		 Utils.waitDefaultTime();
		 //点击返回
		 AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
		 Utils.waitDefaultTime();
		 //长按Ptt
		 AbstractGroupFunction.ptt(2000);
		 Utils.waitDefaultTime();
		 if(AbstractPage.whetherElementVisable(By.id("com.cmcc.p.poc:id/fl_container"), 2)){
			//弹框点击确定，关闭免打扰
			AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
			Utils.waitDefaultTime();		
		 }
		 AbstractGroupFunction.ptt(10000);
		 Utils.waitDefaultTime();	
		 Utils.print(casename + "---->pass");
		 //解散群组
		 AbstractGroupFunction.dismissgroup1();
	 }
}
