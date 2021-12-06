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

public class Group_transfer_container extends AbstractTest {
	private String casename = "群组信息-群管理权转让";
	static String user;
	static String pwd;
	static String user1;
	static String pwd1;

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
	
	@Test(dataProvider = "loginSuccess", alwaysRun = true, dataProviderClass = DataPro.class)
	// 账号密码登录，修改getsecond1即可，1-3是
	public static void getFirst2(String account, String password) {
		user1 = account;
		pwd1 = password;
	}
	
//执行前请先确认登录的账号是非会员账号
	@SuppressWarnings("unused")
	@Test
	public void group_transfer_container() {
		// 登录
		AbstractPage.login(user, pwd);
		// 添加好友
		FriendPageAction.AddFriend(user1);
		// 退出登录
		AbstractPage.logout();
		// 好友账号登录
		AbstractPage.login(user1, pwd1);
		// 同意好友申请
		FriendPageAction.acceptFriend();
		//点击群组对讲
		AbstractPage.findElementById("com.cmcc.p.poc:id/tab_intercom").click();
		//点击群组
		AbstractPage.findElementById("com.cmcc.p.poc:id/layout_group_list").click();
		//创建群组
		AbstractGroupFunction.newgroup1();
		//获取群组名称，并记录
		String qunzunicheng = AbstractPage.findElementById("com.cmcc.p.poc:id/tv_group_name").getText();
		//点击右上角点点点
		AbstractPage.findElementById("com.cmcc.p.poc:id/ib_group_info").click();
		//等待1s
		Utils.waitShortTime();
		//点击群组管理权转让
		AbstractPage.findElementById("com.cmcc.p.poc:id/group_transfer_container").click();
		//如果有 选择新群管理员 元素，则继续正向，没有提示非会员账号请更换会员账号
		if (AbstractPage.whetherElementVisable(By.id("com.cmcc.p.poc:id/title_content_text"), 1)) {
			Utils.print("成功进入选择新群管理员页面，此账号是会员账号继续转让--->PASS");
		} else {
			Utils.print("非会员账号请更换会员账号---->失败");
		}
		//选择成员
		AbstractPage.findElementById("com.cmcc.p.poc:id/name").click();
		//点击确定
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
		Utils.print("已选择成员并转成成功，正常判断是否转让成功---->PASS");
		//等待1s
		Utils.waitShortTime();
		//检测页面 如果没有群组管理权转让，则表示转让成功
		if (AbstractPage.whetherElementVisable(By.id("com.cmcc.p.poc:id/group_transfer_container"), 1)) {
			Utils.print("有群组管理权转让表示转让群组失败---->失败");
		} else {
			Utils.print("没有群组管理权转让表示转让群组成功--->PASS");
		}
		//等待1s
		Utils.waitShortTime();
		//点击返回
		AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
		// 退出登录
		AbstractPage.logout();
		// 好友账号登录
		AbstractPage.login(user, pwd);
		//点击群组
		AbstractPage.findElementById("com.cmcc.p.poc:id/layout_group_list").click();
		//获取群组昵称
		String qunzunicheng1 = AbstractPage.findElementById("com.cmcc.p.poc:id/tv_group_name").getText();
		//断言，如果有此群组，且昵称一致则通过
		Assert.assertEquals(qunzunicheng, qunzunicheng1);
		Utils.print("有此群组且昵称一致--->PASS");
		//点击此群组，进入成功
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_group_name").click();
		//解散群组
		AbstractGroupFunction.dismissgroup1();
		//删除好友
		FriendPageAction.deleteFirstFriend1();
	}
}