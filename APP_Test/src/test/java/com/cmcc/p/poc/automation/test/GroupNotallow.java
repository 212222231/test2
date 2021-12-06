package com.cmcc.p.poc.automation.test;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cmcc.p.poc.automation.core.AbstractPage;
import com.cmcc.p.poc.automation.core.AbstractTest;
import com.cmcc.p.poc.automation.core.Utils;
import com.cmcc.p.poc.automation.pagefunction.AbstractGroupFunction;

public class GroupNotallow extends AbstractTest{
	
	private String casename = "加群设置-不允许加入功能";
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
	 public  void groupnotallow(){
	    //登录
		 AbstractPage.login(user1, pwd1);
		 Utils.waitDefaultTime();
		 //新建群组
		 AbstractGroupFunction.newgroup();
		 
		 //加群设置-不允许加入
		 AbstractGroupFunction.Notallow();
		 
		 //分享群口令
		 AbstractPage.findElementById("com.cmcc.p.poc:id/rl_invivate_command").click();
		
	     if(AbstractPage.whetherElementVisable(By.id("com.cmcc.p.poc:id/token"), 2)){
	    	 Utils.print(casename +"----->fail");
	     }else{
	    	 Utils.print(casename +"----->pass");
	     }
		// 取消加群验证
		// 点击加群设置
		AbstractPage.findElementByName("加群设置").click();
		Utils.waitDefaultTime();
		AbstractPage.findElementById("com.cmcc.p.poc:id/rl_unlimited").click();
		Utils.waitDefaultTime();
		// 点击返回，进入群组对讲页面
		AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
		Utils.waitDefaultTime();
		//解散群组
	  	AbstractGroupFunction.dismissgroup1();
		
	
	 }	

}
