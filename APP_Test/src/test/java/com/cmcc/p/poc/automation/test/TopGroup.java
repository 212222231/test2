package com.cmcc.p.poc.automation.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cmcc.p.poc.automation.core.AbstractPage;
import com.cmcc.p.poc.automation.core.AbstractTest;
import com.cmcc.p.poc.automation.core.Utils;
import com.cmcc.p.poc.automation.pagefunction.AbstractGroupFunction;

import junit.framework.Assert;

public class TopGroup extends AbstractTest {
	private String casename = "置顶群组功能";
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
	 
	 @SuppressWarnings("unused")
	@Test
	 public  void topgroup(){
		 //登录
		 AbstractPage.login(user1, pwd1);
		 //新建群组
		 AbstractGroupFunction.newgroup();
		 Utils.waitDefaultTime();
		 //获取群组名称
		 String groupname1 = AbstractPage.findElementById("com.cmcc.p.poc:id/tv_group_name").getText();
		 System.out.println("第一次创建的群组名称1："+groupname1);
		//新建群组2
		 AbstractGroupFunction.newgroup();
		 Utils.waitDefaultTime();
		 //获取群组名称
		 String groupname2 = AbstractPage.findElementById("com.cmcc.p.poc:id/tv_group_name").getText();
		 System.out.println("第二次创建的群组名称2："+groupname2);
		 //等待3s
		 Utils.waitDefaultTime();
		 //群组对讲页面，点击右上角的三个点
		 AbstractPage.findElementById("com.cmcc.p.poc:id/ib_group_info").click();
		 Utils.waitDefaultTime();
		 //开启置顶
		 AbstractPage.findElementById("com.cmcc.p.poc:id/switch_btn").click();
		 //点击返回
		 AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
		 //点击群组
		 AbstractPage.findElementByName("群组").click();
		 Utils.waitDefaultTime();
		 //切组
		 AbstractGroupFunction.changegroup();
		 //点击群组
		 AbstractPage.findElementByName("群组").click();
		 Utils.waitDefaultTime();
		 //获取群组列表第一个群组的名称
		 String groupname3 = AbstractPage.findElementById("com.cmcc.p.poc:id/tv_group_name").getText();
		 System.out.println("第一次创建的群组名称2："+groupname3);
		 //断言 第一个群组名和置顶的昵称一致
		 Assert.assertEquals(groupname2,groupname3);
		 Utils.print("置顶群组成功---->PASS");
		 //点击第一个指定群组进入
		 AbstractPage.findElementById("com.cmcc.p.poc:id/tv_group_name").click();
		 //等待3s
		 Utils.waitDefaultTime();
		 //群组对讲页面，点击右上角的三个点
		 AbstractPage.findElementById("com.cmcc.p.poc:id/ib_group_info").click();
		 Utils.waitDefaultTime();
		 //点击关闭置顶
		 AbstractPage.findElementById("com.cmcc.p.poc:id/switch_btn").click();
		 //点击返回
		 AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
		 //点击群组
		 AbstractPage.findElementByName("群组").click();
		 Utils.waitDefaultTime();
		 //切组
		 AbstractGroupFunction.changegroup();
		 //点击群组
		 AbstractPage.findElementByName("群组").click();
		 Utils.waitDefaultTime();
		 //获取群组列表第一个群组的名称
		 String groupname4 = AbstractPage.findElementById("com.cmcc.p.poc:id/tv_group_name").getText();
		 Assert.assertEquals(groupname1,groupname4);
		 Utils.print("取消置顶群组成功---->PASS");
		 //点击返回
		 AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
		 //解散群组
		 AbstractGroupFunction.dismissgroup1();
		 //点击群组
		 AbstractPage.findElementByName("群组").click();
		 //点击一个群组，进入群组
		 AbstractPage.findElementById("com.cmcc.p.poc:id/tv_group_name").click();
		 //解散群组
		 AbstractGroupFunction.dismissgroup1();
	 
//		 String groupname3 = AbstractPage.findElementsById("com.cmcc.p.poc:id/tv_group_name").get(0).getText();
//		 System.out.println("群组名称："+groupname3);
//		 Utils.waitDefaultTime();
//		 //断言，群组名称是否一致，一致则置顶成功
//		 if (groupname2.equals(groupname3)) {
//				//取消置顶
//			 AbstractPage.findElementByName(groupname1).click();
//			//群组对讲页面，点击右上角的三个点
//			 AbstractPage.findElementById("com.cmcc.p.poc:id/ib_group_info").click();
//			 Utils.waitDefaultTime();
//			//取消置顶
//			 AbstractPage.findElementById("com.cmcc.p.poc:id/switch_btn").click();
//			 Utils.waitDefaultTime();
//			//点击返回
//			 AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();		
//			 Utils.waitDefaultTime();
//			 
//			 Utils.print(casename + "---->pass");
//			} else {
//				Utils.print(casename + "---->Fail");
//			}
		 
		 
		 
	 }
}
