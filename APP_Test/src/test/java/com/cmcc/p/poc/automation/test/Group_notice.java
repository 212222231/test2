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
@Epic("群组对讲页面-群组内-发送群公告")
@Feature("开始创造测试数据")
public class Group_notice extends AbstractTest {
	private String casename = "发送群公告";
	static String user1;
	static String pwd1;

	@Override
	@BeforeTest
	public void setUp() {
		Utils.print("casename: " + casename);
	}

	@Test(dataProvider = "loginSuccess", alwaysRun = true, dataProviderClass = DataPro.class)
	// 账号密码登录
	public static void getsecond(String account, String password) {
		user1 = account;
		pwd1 = password;
	}
//执行前请先点击ptt允许讲话权限，还没有加判断
	@Story("开始执行测试用例")
	@Test
	public void test() {
		// 登录
		AbstractPage.login(user1, pwd1);
		//点击群组
		AbstractPage.findElementById("com.cmcc.p.poc:id/layout_group_list").click();
		//创建群组
		AbstractGroupFunction.newgroup();
		//点击右上角设置点点点
		AbstractPage.findElementById("com.cmcc.p.poc:id/ib_group_info").click();
		//等待1s
		Utils.waitShortTime();
		//点击群公告
		AbstractPage.findElementById("com.cmcc.p.poc:id/group_notice").click();
		//等待1s
		Utils.waitShortTime();
		//长按ptt5000(毫秒)=5s
		AbstractGroupFunction.ptt1(5000);
		//等待1s
		Utils.waitShortTime();
		//点击语音记录进行回放
		AbstractPage.findElementById("com.cmcc.p.poc:id/layout_audio").click();
		//等待5s
		Utils.waitLongTime();
		//等待1s
		Utils.waitShortTime();
		//点击返回
		AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
		//等待1s
		Utils.waitShortTime();
		//点击返回
		AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
		//等待1s
		Utils.waitShortTime();
		//点击群公告语音记录
		AbstractPage.findElementById("com.cmcc.p.poc:id/bubble_group_notice").click();
		//等待1s
		Utils.waitShortTime();
		//点击停止播放
		AbstractPage.findElementById("com.cmcc.p.poc:id/iv_stop_play").click();
		//等待1s
		Utils.waitShortTime();
		//点击关闭群公告按钮
		AbstractPage.findElementById("com.cmcc.p.poc:id/group_notice_close").click();
		//等待1s
		Utils.waitShortTime();
		//断言不显示群公告元素则通过
		if (AbstractPage.findElementByPageSource("com.cmcc.p.poc:id/group_notice_text")) {
			   Utils.print("获取到元素表示关闭失败---->失败");
			  } else {
			   Utils.print("没有获取到元素表示关闭成功---->PASS");
			  }
		//输出日志
		Utils.print("群公告模块---->PASS");
		//等待1s
		Utils.waitShortTime();
		//解散群组
		AbstractGroupFunction.dismissgroup1();
	}
}