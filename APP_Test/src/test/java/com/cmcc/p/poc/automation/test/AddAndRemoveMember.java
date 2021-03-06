 package com.cmcc.p.poc.automation.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.cmcc.p.poc.automation.core.AbstractPage;
import com.cmcc.p.poc.automation.core.AbstractTest;
import com.cmcc.p.poc.automation.core.FriendPageMethod;
import com.cmcc.p.poc.automation.core.Utils;
import com.cmcc.p.poc.automation.pagefunction.AbstractGroupFunction;
import com.cmcc.p.poc.automation.pagefunction.FriendPageAction;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import java.util.List;

@Epic("群组对讲页面-群组内-邀请和移除成员")
@Feature("开始创造测试数据")
public class AddAndRemoveMember extends AbstractTest {
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
		@Story("开始执行测试用例")
		@Test
		public void test() {
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
		        Utils.waitDefaultTime();			        
		        // 点击新建群组按钮
		        AbstractPage.findElementById("com.cmcc.p.poc:id/tv_new_group").click();			        
		        //点击换一换
		        AbstractPage.findElementById("com.cmcc.p.poc:id/tv_next").click();
		        // 点击创建
		        AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();			        
		        Utils.waitLongTime();
		        AbstractPage.untilElementDisplayed("邀请成员", 2);	
		        // List<MobileElement>friendlist = AbstractPage.findElementsById("com.cmcc.p.poc:id/iv_choose");
		        //int ret=friendlist.size();
		        AbstractPage.findElementsById("com.cmcc.p.poc:id/rl_content").get(0).click();		       
		        AbstractPage.findElementById("com.cmcc.p.poc:id/title_right_text").click();
		        Utils.waitDefaultTime();
		        AbstractPage.findElementById("com.cmcc.p.poc:id/ib_group_info").click();
		        Utils.waitDefaultTime();
		        AbstractPage.untilElementDisplayed("全部2人", 2);
		        Utils.print(casename + "添加好友---->PASS");
		        //等待1s
				Utils.waitShortTime();
		        AbstractPage.findElementById("com.cmcc.p.poc:id/rl_delete").click();
		        //等待1s
				Utils.waitShortTime();
		        AbstractPage.findElementsById("com.cmcc.p.poc:id/iv_member").get(1).click();
		        //等待1s
				Utils.waitShortTime();
		        AbstractPage.findElementById("com.cmcc.p.poc:id/title_right_text").click();
		        //等待1s
				Utils.waitShortTime();
		        AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();	
		        Utils.waitDefaultTime();
		        AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
		        AbstractPage.untilElementDisplayed("全部1人", 2);
		        Utils.print(casename + "移除好友---->PASS");
		        Utils.waitDefaultTime();
		        AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
		        //解散群组
				AbstractGroupFunction.dismissgroup1();
		        Utils.print(casename + "退出群组---->PASS");
		        //删除好友
				Utils.waitDefaultTime();
				FriendPageAction.deleteFirstFriend1();
				
		        
		}
	
}
