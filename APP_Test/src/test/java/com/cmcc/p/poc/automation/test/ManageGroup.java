package com.cmcc.p.poc.automation.test;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cmcc.p.poc.automation.core.AbstractPage;
import com.cmcc.p.poc.automation.core.AbstractTest;
import com.cmcc.p.poc.automation.core.Utils;
import com.cmcc.p.poc.automation.pagefunction.AbstractGroupFunction;

import io.appium.java_client.MobileElement;

public class ManageGroup extends AbstractTest {
	 private String casename = "管理群组功能";		
		static String user1;
		static String pwd1;
	
		@Override
		@BeforeTest
		public void setUp(){
			Utils.print("casename" + casename);
		}
	 @SuppressWarnings("deprecation")
		@Test(dataProvider = "loginSuccess",alwaysRun = true, dataProviderClass = DataPro.class)
		// 账号密码登录
	 public static void getFirst(String account,String password) {			
		 user1 =account;	
		 pwd1=password;		
		}
		
	 @Test
	 public  void manageGroup(){	 
		//登录
		AbstractPage.login(user1, pwd1);
		//新建群组
		AbstractGroupFunction.newgroup();
		Utils.waitShortTime();
		//新建群组
		AbstractGroupFunction.newgroup();
		Utils.waitShortTime();
		// 点击管理群组
		AbstractGroupFunction.managegroup();
		Utils.waitShortTime();
		// 获取列表第2个群组的群组名称
		String groupname = AbstractPage.findElementsById("com.cmcc.p.poc:id/tv_group_name").get(1).getText();
		System.out.println(groupname);
		Utils.waitShortTime();
		// 勾选列表第2个群组，
		AbstractPage.findElementsById("com.cmcc.p.poc:id/group_checked").get(2).click();
		Utils.waitShortTime();
		// 点击确定
		AbstractPage.findElementById("com.cmcc.p.poc:id/title_right_text").click();
		// 弹框页面，点击确定
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
		//点击好的按钮，如果有则点击好的，没有则继续
		if (AbstractPage.findElementByPageSource("com.cmcc.p.poc:id/tv_confirm")) {
			AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
		}
		if(AbstractPage.whetherElementVisable(groupname, 1)){
			System.out.println("群组删除失败");
		}else{
			System.out.println("群组删除成功");
		}
		//删除剩下的那个群组
		AbstractPage.findElementById("com.cmcc.p.poc:id/group_checked").click();
		Utils.waitDefaultTime();
		// 点击确定
		AbstractPage.findElementById("com.cmcc.p.poc:id/title_right_text").click();
		// 弹框页面，点击确定
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
		Utils.waitShortTime();
		} 
}
