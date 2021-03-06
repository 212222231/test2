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
@Epic("群组对讲页面-群组内-群组信息-成员管理-设置管理员（非会员账号）")
@Feature("开始创造测试数据")
public class Set_manager_no_member extends AbstractTest {
	private String casename = "成员管理-设置管理员（非会员账号）";
	static String user;
	static String pwd;

	@Override
	@BeforeTest
	public void setUp() {
		Utils.print("casename: " + casename);
	}

	@Test(dataProvider = "loginSuccess", alwaysRun = true, dataProviderClass = DataPro.class)
	// 账号密码登录，修改getsecond1即可，1-3是
	public static void getsecond6(String account, String password) {
		user = account;
		pwd = password;
	}
//执行前请先确认登录的账号是非会员账号
	@Story("开始执行测试用例")
	@Test
	public void test() {
		// 登录
		AbstractPage.login(user, pwd);
		//点击群组
		AbstractPage.findElementById("com.cmcc.p.poc:id/layout_group_list").click();
		//创建群组
		AbstractGroupFunction.newgroup();
		//点击右上角设置点点点
		AbstractPage.findElementById("com.cmcc.p.poc:id/ib_group_info").click();
		//等待1s
		Utils.waitShortTime();
		//点击成员管理
		AbstractPage.findElementById("com.cmcc.p.poc:id/member_dispatch").click();
		//点击是否允许上报您在该群位置
		AbstractPage.findElementById("com.cmcc.p.poc:id/allowReportLoc").click();
		//获取到 弹窗购买按钮的元素
		String goumai = AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").getText();
		//断言 显示修改后的昵称，则通过 或者 修改前和修改后不一致，则通过
		Assert.assertEquals("购买", goumai);
		Utils.print("有购买弹窗---->PASS");
		//点击取消
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_cancel").click();
		//点击设置管理员
		AbstractPage.findElementById("com.cmcc.p.poc:id/set_manager").click();
		//点击取消
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_cancel").click();
		//点击设置成员群昵称
		AbstractPage.findElementById("com.cmcc.p.poc:id/set_notes").click();
		//点击取消
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_cancel").click();
		//点击查看成员位置
		AbstractPage.findElementById("com.cmcc.p.poc:id/member_location").click();
		//点击购买
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
		//点击返回
		AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
		//等待1s
		Utils.waitShortTime();
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