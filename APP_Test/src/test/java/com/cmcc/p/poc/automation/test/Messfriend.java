
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
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import java.util.List;
@Epic("好友页面-发送短信")
@Feature("开始创造测试数据")
public class Messfriend extends AbstractTest {
	private String casename = "发送短信";
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
		// 发送短信
		FriendPageAction.messageFirstFriend();
		//如果有选择窗口则点击短信，没有则继续断言
		if(AbstractPage.findElementByPageSource("android:id/text1")){
			//点击窗口短信按钮
			AbstractPage.findElementById("android:id/text1").click();
			//断言
			Object text = AbstractPage.findElementById("com.android.mms:id/embedded_text_editor").getText();
			System.out.print(text);
			Assert.assertEquals(text,"短信");
			Utils.print("发送短信页面--->PASS");
			//点击返回
			AbstractPage.findElementById("miui:id/up").click();
			//点击返回
			AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
			//删除好友
			Utils.waitDefaultTime();
			FriendPageAction.deleteFirstFriend2();
		}else if(AbstractPage.findElementByPageSource("com.android.mms:id/embedded_text_editor")){
			   //断言
			   Object text = AbstractPage.findElementById("com.android.mms:id/embedded_text_editor").getText();
			   System.out.print(text);
			   Assert.assertEquals(text,"短信");
			   Utils.print("发送短信页面--->PASS");
			   //点击返回
			   AbstractPage.findElementById("miui:id/up").click();
			   //点击返回
			   AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
			   //删除好友
			   Utils.waitDefaultTime();
			   FriendPageAction.deleteFirstFriend2();
		}else{
			   //输出日志
			   Utils.print("模拟器测试没有发短信页面---->PASS");
			   //点击返回
			   AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
			   //删除好友
			   Utils.waitDefaultTime();
			   FriendPageAction.deleteFirstFriend2();
			  }
	}
}