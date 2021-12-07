package com.cmcc.p.poc.automation.pagefunction;

import com.cmcc.p.poc.automation.core.Utils;

import io.appium.java_client.MobileElement;

import static com.cmcc.p.poc.automation.core.AbstractTest.driver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.cmcc.p.poc.automation.core.AbstractPage;
import com.cmcc.p.poc.automation.core.FriendPageMethod;

public class FriendPageAction {
	static int a;
	static int b;
	static String friendname1;

	// 搜索好友
	public static void searchFriend(String friend) {
		FriendPageMethod.clickFriendTab();
		Utils.waitDefaultTime();
		FriendPageMethod.clickSearchFriendBtn();
		Utils.waitDefaultTime();
		FriendPageMethod.inputSearchFriend(friend);
		Utils.waitDefaultTime();
		FriendPageMethod.clickReturnBtn();
		Utils.waitDefaultTime();

	}

	// 搜索好友2
		public static void searchFriend1(String friend) {
			FriendPageMethod.clickFriendTab();
			Utils.waitDefaultTime();
			FriendPageMethod.clickSearchFriendBtn();
			Utils.waitDefaultTime();
			FriendPageMethod.inputSearchFriend(friend);
			Utils.waitDefaultTime();

		}
	// 拨打电话，快捷建组等
	public static void clickFirstFriend() {
		FriendPageMethod.clickFriendTab();
		Utils.waitDefaultTime();
		FriendPageMethod.clickFirstFriend();
		Utils.waitDefaultTime();
		// 点击打电话图标
		FriendPageMethod.clickCall();
		Utils.waitDefaultTime();
		// 点击返回
		FriendPageMethod.clickReturnBtn();
		Utils.waitDefaultTime();
		// FriendPageMethod.clickKuaiGroup();
		// Utils.waitDefaultTime();
	}
    
	// 拨打电话，快捷建组等
		public static void clickFirstFriend1() {
			FriendPageMethod.clickFriendTab();
			Utils.waitDefaultTime();
			FriendPageMethod.clickFirstFriend();
			Utils.waitDefaultTime();
			// 点击打电话图标
			AbstractPage.findElementById("com.cmcc.p.poc:id/tv_call").click();
			Utils.waitDefaultTime();
		}
		
	
	// 添加好友
	public static void AddFriend1(String acceptUsername) {

		// 点击好友tab
		FriendPageMethod.clickFriendTab();
		Utils.waitDefaultTime();

		// 点击右上角的添加好友
		FriendPageMethod.clickAddFriend();
		Utils.waitDefaultTime();
		// 判断是不是进入添加好友按钮界面，若没有进入，提示没有进入添加好友按钮界面,断言是否正确？
		// Assert.assertTrue("没有进入添加好友按钮界面",AbstractPage.whetherElementVisable("通讯录",
		// 1));
		// 添加好友界面，点击搜索手机号按钮
		FriendPageMethod.clickSearchAddFriendBtn();

		Utils.waitDefaultTime();
		// 判断是不是进入添加好友界面，若没有进入，提示没有进入添加好友界面
		// Assert.assertTrue("没有进入添加好友界面",AbstractPage.whetherElementVisable("添加好友",
		// 1));
		// 搜索好友界面，输入要搜索的手机号
		FriendPageMethod.inputSearchFriend(acceptUsername);
		Utils.waitDefaultTime();
		// 添加好友界面，点击搜索按钮
		FriendPageMethod.clickAddFriendSearchBtn();
		Utils.waitDefaultTime();
		// 点击搜索出的要添加的好友
		FriendPageMethod.clickSearchAddFriend();
		Utils.waitDefaultTime();
		// 点击加好友按钮，跳转到好友申请界面
		FriendPageMethod.clickAddFriendBtn();
		Utils.waitDefaultTime();
		// 点击发送按钮,跳转到个人信息界面
		FriendPageMethod.clickSendBtn();
		Utils.waitDefaultTime();
		// 搜索好友界面，点击返回按钮
		FriendPageMethod.clickReturnBtn();
		Utils.waitDefaultTime();
		// 返回到添加好友页面
		FriendPageMethod.clickReturnBtn();
		Utils.waitDefaultTime();
		// 返回到好友tab页面
		FriendPageMethod.clickReturnBtn();

		Utils.print("发送好友申请---->PASS");
	}

	// 同意好友邀请
	public static void acceptFriend1() {
		// 点击好友tab
		FriendPageMethod.clickFriendTab();
		Utils.waitDefaultTime();
		// 获取当前好友总数
		// List<MobileElement> friendlist =
		// AbstractPage.findElementsById("com.cmcc.p.poc:id/rl_friend");
		// a = friendlist.size();
		// 点击新的好友图标
		FriendPageMethod.clickNewFriendBtn();
		Utils.waitDefaultTime();
		String friendname1 = AbstractPage.findElementById("com.cmcc.p.poc:id/tv_msg_title").getText();
		System.out.println("昵称:" + friendname1);
		//点击好友同意确定按钮
		FriendPageMethod.clickAcceptFriendBtn();
		Utils.waitDefaultTime();
		// 返回好友列表页面
		FriendPageMethod.clickReturnBtn();
		Utils.waitDefaultTime();
		// 再次获取好友人数
		/// AssertJUnit.assertTrue("同意好友失败",AbstractPage.whetherElementVisable(By.name("好友1508188256(崔琳正式)"),
		// 1));
		//List<MobileElement> friendlist2 = AbstractPage.findElementsById("com.cmcc.p.poc:id/rl_friend");
		//int b = friendlist2.size();
		//Assert.assertEquals(a + 1, b);
		Utils.print("同意好友申请---->PASS");
	}

	// 删除好友
		public static void deleteFirstFriend() {
			// 点击好友tab
			FriendPageMethod.clickFriendTab();
			Utils.waitDefaultTime();
			// 找到刚添加的好友,长按
			AbstractPage.whetherElementVisable(friendname1, 3);
			AbstractPage.pressClick("friendname1");

			// 删除
			AbstractPage.findElementById("com.cmcc.p.poc:id/tv_friend_delete").click();
			// 点击确定删除按钮
			AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
			Utils.waitDefaultTime();
			 AbstractPage.whetherElementVisable(friendname1, 3);
			Utils.print("删除好友---->PASS");
		}	
		
		//删除好友
		public static void deleteFirstFriend1(){
			//点击好友tab
			FriendPageMethod.clickFriendTab();
			Utils.waitDefaultTime();
			//找到刚添加的好友,长按		
			
		
		 AbstractPage.pressClick1("friendname1");
			
	    	//删除
	    	AbstractPage.findElementById("com.cmcc.p.poc:id/tv_friend_delete").click();
	    	//点击确定删除按钮
	    	AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
			Utils.waitDefaultTime();
			Utils.print("删除好友---->PASS");
		}
		
		//删除好友2
				public static void deleteFirstFriend2(){
					//找到刚添加的好友,长按		
					
				
				 AbstractPage.pressClick1("friendname1");
					
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
//	        Assert.assertTrue("没有进入添加好友按钮界面",AbstractPage.whetherElementVisable("通讯录", 1));
	    	//添加好友界面，点击搜索手机号按钮
	    	FriendPageMethod.clickSearchAddFriendBtn();
	    	Utils.waitDefaultTime();
	    	// 判断是不是进入添加好友界面，若没有进入，提示没有进入添加好友界面
//	        Assert.assertTrue("没有进入添加好友界面",AbstractPage.whetherElementVisable("添加好友", 1));
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
		 
		//修改好友备注
		   public static void updateFriendname(String name){
		    //如果找到修改按钮2 则继续执行，否则执行1
		    if (AbstractPage.whetherElementVisable(By.id("com.cmcc.p.poc:id/tv_remark2"), 1)) {
		      //点击修改按钮
		           AbstractPage.findElementById("com.cmcc.p.poc:id/tv_remark2").click();
		    }else {
		     //点击修改按钮
		           AbstractPage.findElementById("com.cmcc.p.poc:id/tv_remark").click();
		    }
		        //输入想修改的名字
		        AbstractPage.findElementById("com.cmcc.p.poc:id/et_content").setValue(name);
		        //点击确定
		        AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
		           Utils.waitDefaultTime();
		     Utils.print("修改好友备注---->PASS");
		    }
		 
		 
		    //发送短信
			public static void messageFirstFriend(){
				//FriendPageMethod.clickFriendTab();
				//Utils.waitDefaultTime();
				FriendPageMethod.clickFirstFriend();
				Utils.waitDefaultTime();
				//点击发短信图标
				AbstractPage.findElementById("com.cmcc.p.poc:id/tv_sms").click();
				Utils.waitDefaultTime();
			}
		 
			//单呼好友-左上角临时单呼按钮
			 public static void callonefriend(String phone){
				    FriendPageMethod.clickFriendTab();
		 	        //点击临时单呼按钮
			        AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
			    	//输入想修改的名字
			        AbstractPage.findElementById("com.cmcc.p.poc:id/et_content").setValue(phone);
			        //点击确定
			        AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
			        Utils.waitDefaultTime();
		  }
			 
			 
			//单呼好友-好友详情页临时单呼按钮
			 public static void friendcall(){
				    //FriendPageMethod.clickFriendTab();
				    //点击单个好友
				    FriendPageMethod.clickFirstFriend();
		 	        //点击临时单呼按钮
			        AbstractPage.findElementById("com.cmcc.p.poc:id/tv_launch_intercom").click();
			        Utils.waitDefaultTime();
		  }
			//好友-共同群组
			 public static void groupfriend(){
				    FriendPageMethod.clickFriendTab();
				    //点击单个好友
				    FriendPageMethod.clickFirstFriend();
		 	        //点击共同群组按钮
			        AbstractPage.findElementByName("我和他/她的共同群组").click();
			        Utils.waitDefaultTime();
			 }
			        

}
