package com.cmcc.p.poc.automation.pagefunction;

import static com.cmcc.p.poc.automation.core.AbstractTest.driver;

import java.time.Duration;

import com.cmcc.p.poc.automation.core.AbstractPage;
import com.cmcc.p.poc.automation.core.Utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class PersonalCenterPage {
	// 点击个人中心tab
		public static void clickPersionalcenter() {
			AbstractPage.findElementByName("个人中心").click();

		}
		
		//上滑，新加的
		public static void swipeup() {
			// 上滑
			int width1 = driver.manage().window().getSize().width;// 获取屏幕的宽
			System.out.println("宽:" + width1);
			int height1 = driver.manage().window().getSize().height; // 获取屏幕的长
			System.out.println("高:" + height1);
			// ·release 相当于放开 ·perform 相当于发送执行
			Utils.waitDefaultTime();
			new TouchAction(driver).press(PointOption.point(width1 / 2, height1 *2/3))
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(10000)))
					.moveTo(PointOption.point(width1 / 2, height1 / 3)).release().perform();
		}	
		
		
		
		
		

		// 点击群组对讲tab
		public static void clickGroup() {
			AbstractPage.findElementByName("群组对讲").click();
		}

		// 点击好友tab
		public static void clickFriend() {
			AbstractPage.findElementByName("好友").click();
		}

		// 点击个人信息
		public static void clickPersonalinformation() {
			AbstractPage.findElementById("com.cmcc.p.poc:id/rl_user_persona").click();
		}

		// 点击昵称
		public static void clickNickname() {
			AbstractPage.findElementById("com.cmcc.p.poc:id/rl_nick_name").click();
		}

		// 点击设置
		public static void clickSetup() {
			AbstractPage.findElementById("com.cmcc.p.poc:id/rl_me_setting").click();
		}

		// 点击修改密码
		public static void clickModifypwd() {
			AbstractPage.findElementById("com.cmcc.p.poc:id/rl_modify_pwd").click();
			Utils.waitDefaultTime();
			// 点击返回
			AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
		}

		// 点击常见问题
		public static void clickProblem() {
			AbstractPage.findElementById("com.cmcc.p.poc:id/rl_hand_book").click();
			//点击全部展开
			AbstractPage.findElementById("com.cmcc.p.poc:id/title_right_text").click();
			// 点击全部收起
			AbstractPage.findElementById("com.cmcc.p.poc:id/title_right_text").click();
			// 点击返回
			AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
		}

		// 点击分享app
		public static void clickShareApp() {
			AbstractPage.findElementById("com.cmcc.p.poc:id/rl_share_app").click();
		}

		// 点击关于和对讲
		public static void clickAbout() {
			AbstractPage.findElementById("com.cmcc.p.poc:id/rl_about").click();
			Utils.waitShortTime();
			// 点击返回
			AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
		}

		// 点击返回
		public static void clickReturn() {
			AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();

		}

		// 点击取消
		public static void clickCancel() {
			AbstractPage.findElementByName("取消").click();
		}

		// 点击对讲设置
		public static void clickTalkback() {
			AbstractPage.findElementById("com.cmcc.p.poc:id/rl_me_intercom").click();
		}

		// 点击会员权益
		public static void clickMember() {
			AbstractPage.findElementById("com.cmcc.p.poc:id/rl_me_paid_version").click();
		}

}
