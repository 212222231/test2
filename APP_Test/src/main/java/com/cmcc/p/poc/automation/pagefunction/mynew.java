package com.cmcc.p.poc.automation.pagefunction;
import com.cmcc.p.poc.automation.core.Utils;

import io.appium.java_client.MobileElement;

import static com.cmcc.p.poc.automation.core.AbstractTest.driver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.cmcc.p.poc.automation.core.AbstractPage;
import com.cmcc.p.poc.automation.core.FriendPageMethod;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
public class mynew {
	static int a;
	static int b;
	static String friendname1 ;
	
	
	//搜索好友
	public static void searchFriend(String friend){
		FriendPageMethod.clickFriendTab();
		Utils.waitDefaultTime();
		FriendPageMethod.clickSearchFriendBtn();	
		Utils.waitDefaultTime();
		FriendPageMethod.inputSearchFriend(friend);
		Utils.waitDefaultTime();
		FriendPageMethod.clickReturnBtn();
		Utils.waitDefaultTime();
		
	}
	//拨打电话，快捷建组等
	public static void clickFirstFriend(){
		FriendPageMethod.clickFriendTab();
		Utils.waitDefaultTime();
		FriendPageMethod.clickFirstFriend();
		Utils.waitDefaultTime();
		//点击打电话图标
		FriendPageMethod.clickCall();
		Utils.waitDefaultTime();
		//点击返回
		FriendPageMethod.clickReturnBtn();
		Utils.waitDefaultTime();
//		FriendPageMethod.clickKuaiGroup();
//		Utils.waitDefaultTime();
	}
	
	//删除好友
	public static void deleteFriend(){
		//点击好友tab
		//FriendPageMethod.clickFriendTab();
		//Utils.waitDefaultTime();
		//找到刚添加的好友	
	 	 WebElement friendname = AbstractPage.findElementByName(friendname1);	  	
	 	 int x =friendname.getLocation().getX();
	 	 int y =friendname.getLocation().getY();	
	 	 
       //找到刚添加的好友,长按	
	 	TouchAction action =new TouchAction(driver);
	 	PointOption pressPoint=PointOption.point(x, y);
	 	 //设置长按的时间
        Duration last = Duration.ofSeconds(2);
        WaitOptions wait= WaitOptions.waitOptions(last);
        //长按坐标
        action.longPress(pressPoint).waitAction(wait).perform();
        // action.press(PointOption.point( x, y));   		
    	//删除
    	AbstractPage.findElementById("com.cmcc.p.poc:id/tv_friend_delete").click();
    	//点击确定删除按钮
    	AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
		Utils.waitDefaultTime();
		Utils.print("删除好友---->PASS");
	}
	
	//添加好友
	public static void AddFriend(String acceptUsername){
		//点击好友tab
		FriendPageMethod.clickFriendTab();
		Utils.waitDefaultTime();
		
		//点击右上角的添加好友
    	FriendPageMethod.clickAddFriend();
    	Utils.waitDefaultTime();
    	// 判断是不是进入添加好友按钮界面，若没有进入，提示没有进入添加好友按钮界面
//        Assert.assertTrue("没有进入添加好友按钮界面",AbstractPage.whetherElementVisable("通讯录", 1));
    	//添加好友界面，点击搜索手机号按钮
    	FriendPageMethod.clickSearchAddFriendBtn();
    	Utils.waitDefaultTime();
    	// 判断是不是进入添加好友界面，若没有进入，提示没有进入添加好友界面
//        Assert.assertTrue("没有进入添加好友界面",AbstractPage.whetherElementVisable("添加好友", 1));
    	//搜索好友界面，输入要搜索的手机号
    	FriendPageMethod.inputSearchFriend(acceptUsername);
    	Utils.waitDefaultTime();
    	//添加好友界面，点击搜索按钮
    	FriendPageMethod.clickAddFriendSearchBtn();
    	Utils.waitDefaultTime();
    	//点击搜索出的要添加的好友
    	FriendPageMethod.clickSearchAddFriend();
    	Utils.waitDefaultTime();
    	//点击加好友按钮，跳转到好友申请界面
    	FriendPageMethod.clickAddFriendBtn();
    	Utils.waitDefaultTime();
    	//点击发送按钮,跳转到个人信息界面
    	FriendPageMethod.clickSendBtn();
    	Utils.waitDefaultTime();
    	//搜索好友界面，点击返回按钮
    	FriendPageMethod.clickReturnBtn();
    	Utils.waitDefaultTime();
    	//返回到添加好友页面
    	FriendPageMethod.clickReturnBtn();
    	Utils.waitDefaultTime();
    	//返回到好友tab页面
    	FriendPageMethod.clickReturnBtn();
    	Utils.waitDefaultTime();
    	Utils.print("发送好友申请---->PASS");
	}
	
	//同意好友邀请
	 public static void acceptFriend(){
 	    //点击好友tab
	    	FriendPageMethod.clickFriendTab();
	    	Utils.waitDefaultTime();
	    	// 获取当前好友总数
			List<MobileElement> friendlist = AbstractPage.findElementsById("com.cmcc.p.poc:id/rl_friend");
			 a = friendlist.size();
			 
	    	FriendPageMethod.clickNewFriendBtn();
	    	Utils.waitDefaultTime();
	    	friendname1 =  AbstractPage.findElementById("com.cmcc.p.poc:id/tv_msg_title").getText();
	    	FriendPageMethod.clickAcceptFriendBtn();
	    	Utils.waitDefaultTime();
	    	// 返回好友列表页面
	    	FriendPageMethod.clickReturnBtn();
	    	Utils.waitDefaultTime();				
			// 再次获取好友人数
			/// AssertJUnit.assertTrue("同意好友失败",AbstractPage.whetherElementVisable(By.name("好友1508188256(崔琳正式)"),
			// 1));
			List<MobileElement> friendlist2 = AbstractPage.findElementsById("com.cmcc.p.poc:id/rl_friend");
			int b = friendlist2.size();
			Assert.assertEquals(a + 1, b);
			Utils.print("同意好友申请---->PASS");
  }
	 

}
