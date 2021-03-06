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
@Epic("群组对讲页面-群组内-群组信息-成员管理-设置管理员（设置成员群昵称）")
@Feature("开始创造测试数据")
public class Set_notes extends AbstractTest {
	private String casename = "成员管理-设置管理员（设置成员群昵称）";
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
	@Story("开始执行测试用例")
	@Test
	public static void test() {
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
		//点击设置成员群昵称
		AbstractPage.findElementById("com.cmcc.p.poc:id/set_notes").click();
		//第一次获取，第一个成员的昵称，并且记录
		String diyicinicheng1 = AbstractPage.findElementById("com.cmcc.p.poc:id/name").getText();
		//点击第一个成员昵称
		AbstractPage.findElementById("com.cmcc.p.poc:id/name").click();
		// 清空账号输入框
		AbstractPage.findElementById("com.cmcc.p.poc:id/et_content").clear();
		// 第一次修改 输入新的成员名称
		AbstractPage.findElementById("com.cmcc.p.poc:id/et_content").setValue("修改后成员昵称");
		// 点击完成
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
		//第二次获取修改后的第一个成员的昵称，记录
		String diyicinicheng2 = AbstractPage.findElementById("com.cmcc.p.poc:id/name").getText();
		// 断言 查询到修改后的成员昵称，则通过
		Assert.assertEquals("修改后成员昵称", diyicinicheng2);
		Utils.print("修改后成员昵称---->PASS");
		//点击第一个成员昵称
		AbstractPage.findElementById("com.cmcc.p.poc:id/name").click();
		// 清空账号输入框
		AbstractPage.findElementById("com.cmcc.p.poc:id/et_content").clear();
		// 第二次修改 输入原来的群成员昵称
		AbstractPage.findElementById("com.cmcc.p.poc:id/et_content").setValue(diyicinicheng1); 
		// 点击完成
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
		//第三次获取修改后的第一个成员的昵称，记录
		String diyicinicheng3 = AbstractPage.findElementById("com.cmcc.p.poc:id/name").getText();
		//断言 第二次修改后获取到的昵称和第一次获取的显示一致
		Assert.assertEquals(diyicinicheng1, diyicinicheng3);
		Utils.print("修改成原来的昵称---->PASS");
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