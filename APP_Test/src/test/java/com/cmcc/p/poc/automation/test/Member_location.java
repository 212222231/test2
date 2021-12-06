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
//操作前需手动打开定位权限
public class Member_location extends AbstractTest {
	private String casename = "成员管理-设置管理员（查看成员位置页面）";
	static String user;
	static String pwd;

	@Override
	@BeforeTest
	public void setUp() {
		Utils.print("casename: " + casename);
	}

	@Test(dataProvider = "loginSuccess", alwaysRun = true, dataProviderClass = DataPro.class)
	// 账号密码登录，修改getsecond1即可，1-3是
	public static void getFirst(String account, String password) {
		user = account;
		pwd = password;
	}
	
//执行前请先确认登录的账号是非会员账号
	@Test
	public void member_location() {
		// 登录
		AbstractPage.login(user, pwd);
		//点击群组
		AbstractPage.findElementById("com.cmcc.p.poc:id/layout_group_list").click();
		//创建群组
		AbstractGroupFunction.newgroup();
		//点击右上角点点点
		AbstractPage.findElementById("com.cmcc.p.poc:id/ib_group_info").click();
		//等待1s
		Utils.waitShortTime();
		//点击成员管理
		AbstractPage.findElementById("com.cmcc.p.poc:id/member_dispatch").click();
		//点击查看成员位置
		AbstractPage.findElementById("com.cmcc.p.poc:id/member_location").click();
		//判断是否有 共享您的位置 窗口，如果有点击继续
		if (AbstractPage.whetherElementVisable(By.id("com.cmcc.p.poc:id/tv_confirm"), 1)) {
			//点击继续按钮
			AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
			Utils.print("有 继续 按钮点击成功---->PASS");
		}else {
			Utils.print("没有 继续 按钮跳过---->PASS");
		}
		//判断如果有允许权限，如果有则点击没有则跳过
		if (AbstractPage.whetherElementVisable(By.id("android:id/button1"), 1)) {
			//点击允许按钮
			AbstractPage.findElementById("android:id/button1").click();
			Utils.print("有 允许 按钮点击成功---->PASS");
		}else {
			Utils.print("没有 允许 按钮跳过---->PASS");
		}
		//判断是否有 操作说明 如果有点击确定
		if (AbstractPage.whetherElementVisable(By.id("com.cmcc.p.poc:id/tv_title"), 1)) {
			//点击确定按钮
			AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
			Utils.print("有 确定 按钮点击成功---->PASS");
		}else {
			Utils.print("没有 确定 按钮跳过---->PASS");
		}
		//等待1s
		Utils.waitShortTime();
		//点击开启ptt按钮
		AbstractPage.findElementById("com.cmcc.p.poc:id/master_ptt_sw").click();
		//等待1s
		Utils.waitShortTime();
		//查找ptt元素是否有，如果有则通过，没有则失败
		if (AbstractPage.whetherElementVisable(By.id("com.cmcc.p.poc:id/ib_ptt"), 1)) {
			Utils.print("ptt开启成功---->PASS");
		} else {
			Utils.print("ptt开启失败---->失败");
		}
		//长按ptt5000(毫秒)=5s
		AbstractGroupFunction.ptt2(5000);
		//点击关闭ptt按钮
		AbstractPage.findElementById("com.cmcc.p.poc:id/master_ptt_sw").click();
		//查找ptt元素是否有，如果有则失败，没有则通过
		if (AbstractPage.whetherElementVisable(By.id("com.cmcc.p.poc:id/ib_ptt"), 1)) {
			Utils.print("ptt关闭失败---->失败");
		} else {
			Utils.print("ptt关闭成功---->PASS");
		}
		//查找眼睛UI 如果有此元素则通过
		if (AbstractPage.findElementById("com.cmcc.p.poc:id/master_eye_sw") != null) {
			Utils.print("有眼睛按钮通过---->PASS");
		} else {
			 Utils.print("没有眼睛按钮失败---->失败");
		}
		//查找上报人数元素是否有，如果有则通过
		if (AbstractPage.findElementById("com.cmcc.p.poc:id/tv_user_number") != null) {
			Utils.print("有上报人数通过---->PASS");
		} else {
			 Utils.print("没有上报人数失败---->失败");
		}
		//点击返回
		AbstractPage.findElementById("com.cmcc.p.poc:id/ib_back").click();
		//点击返回
		AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
		//等待1s
		Utils.waitShortTime();
		//点击返回
		AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
		//解散群组
		AbstractGroupFunction.dismissgroup1();
	}
}