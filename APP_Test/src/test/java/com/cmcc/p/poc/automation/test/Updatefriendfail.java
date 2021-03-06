package com.cmcc.p.poc.automation.test;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import java.util.List;
@Epic("好友页面-群修改好友备注-敏感词修改失败")
@Feature("开始创造测试数据")
public class Updatefriendfail extends AbstractTest {
	private String casename = "修改好友备注-敏感词修改失败";
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
		// 搜索存在的好友
		FriendPageAction.searchFriend1(user1);
	    // 获取好友现在的备注名
	 	String name = AbstractPage.findElementById("com.cmcc.p.poc:id/tv_name").getText();
	 	System.out.print(name);
	 	//点击该好友，进入其详情
	    AbstractPage.findElementById("com.cmcc.p.poc:id/rl").click();
	    //修改备注，修改为不合法的备注
		FriendPageAction.updateFriendname("法轮功");
		// 断言
	    Object text = AbstractPage.findElementById("com.cmcc.p.poc:id/errorTip").getText();
	    System.out.print(text);
	    Assert.assertEquals(text,"您输入内容包含敏感词，请重试。");
	    Utils.print("敏感词提示成功--->PASS");
	    //关闭弹窗
	    AbstractPage.findElementById("com.cmcc.p.poc:id/iv_close").click();
	    //点击返回
	    AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
	    //等待1s
	  	Utils.waitShortTime();
	    AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
	    //等待1s
	  	Utils.waitShortTime();
	    //删除好友
	  	FriendPageAction.deleteFirstFriend2();

//	    WebElement friendname = AbstractPage.findElementByName(name);	  	
//	 	 int x =friendname.getLocation().getX();
//	 	 int y =friendname.getLocation().getY();	
//	 	 
//     //找到刚添加的好友,长按	
//	 	TouchAction action =new TouchAction(driver);
//	 	PointOption pressPoint=PointOption.point(x, y);
//	 	 //设置长按的时间
//      Duration last = Duration.ofSeconds(2);
//      WaitOptions wait= WaitOptions.waitOptions(last);
//      //长按坐标
//      action.longPress(pressPoint).waitAction(wait).perform();
//		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_friend_delete").click();
//		 Utils.waitDefaultTime();
//		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
    
	}

}
