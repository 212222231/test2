package com.cmcc.p.poc.automation.core;


import org.openqa.selenium.By;

public class FriendPageMethod {
	//点击好友tab
		public static void clickFriendTab() {
			AbstractPage.findElementById("com.cmcc.p.poc:id/tab_friend").click();
		}
		//点击搜索好友按钮
		public static void clickSearchFriendBtn() {
			AbstractPage.findElementById("com.cmcc.p.poc:id/tv_search").click();
		}
		//点击新的好友
		public static void clickNewFriend() {
			AbstractPage.findElementById("com.cmcc.p.poc:id/tv_search").click();
		}
	   //点击右上角的添加好友
		public static void clickAddFriend() {
			AbstractPage.findElementById("com.cmcc.p.poc:id/title_right_edit").click();
		}
		//搜索好友界面，输入要搜索的手机号
		public static void inputSearchFriend(String serachFriend) {
			AbstractPage.findElementById("com.cmcc.p.poc:id/et_search").clear();
			AbstractPage.findElementById("com.cmcc.p.poc:id/et_search").setValue(serachFriend);
		}
		//搜索好友界面，点击返回按钮
		public static void clickReturnBtn() {
			AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
		}
		//添加好友界面，点击搜索手机号按钮
		public static void clickSearchAddFriendBtn() {
			AbstractPage.findElementById("com.cmcc.p.poc:id/et_search").click();
		}
		//添加好友界面，输入要添加的好友手机号
		public static void inputAddFriend(String addFriend) {
			AbstractPage.findElementById("com.cmcc.p.poc:id/et_search").clear();
			AbstractPage.findElementById("com.cmcc.p.poc:id/et_search").setValue(addFriend);
		}
		//添加好友界面，点击搜索按钮
		public static void clickAddFriendSearchBtn() {
			AbstractPage.findElementById("com.cmcc.p.poc:id/iv_search").click();
		}
		//点击搜索出的要添加的好友
		public static void clickSearchAddFriend() {
			AbstractPage.findElementById("com.cmcc.p.poc:id/rl").click();
		}
		//点击加好友按钮，跳转到好友申请界面
		public static void clickAddFriendBtn() {
			AbstractPage.findElementById("com.cmcc.p.poc:id/tv_add_friend").click();
		}
		//点击发送按钮,跳转到个人信息界面
		public static void clickSendBtn() {
			AbstractPage.findElementById("com.cmcc.p.poc:id/title_right_text").click();
		}
		//点击返回按钮
//		public static void clickReturnBtn(){
//			AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
//		}
		
		//检索好友列表是否存在某好友，若存在，返回元素
		public static void isExistFriend(String friend){
			
		}
		//点击好友列表的第一个好友
	    public static void clickFirstFriend(){
	    	AbstractPage.findElementById("com.cmcc.p.poc:id/delete_bg").click();
		}
	     //长按好友列表的第一个好友
//	    public static void pressFirstFriend(String friend){
//	    	AbstractPage.findElementsById("com.cmcc.p.poc:id/delete_bg").get(1).click();
//		}
	    //点击打电话
	    public static void clickCall(){
	    	AbstractPage.findElementById("com.cmcc.p.poc:id/tv_call").click();
	    	if (AbstractPage.whetherElementVisable(By.id("com.cmcc.p.poc:id/tv_msg"), 1)) {
	        	AbstractPage.findElementById("com.cmcc.p.poc:id/tv_cancel").click();
	        }
	    	
	    }
	    //点击快捷建组
	    public static void clickKuaiGroup(){
	    	//AbstractPage.findElementById("com.cmcc.p.poc:id/tv_launch_intercom").click();
	    	
	    	AbstractPage.findElementByName("快捷建组").click();
	    }
		
	    //点击新的好友图标
	    public static void clickNewFriendBtn(){
	    	AbstractPage.findElementById("com.cmcc.p.poc:id/new_group").click();
	    	
	    }
		//点击好友同意确定按钮
	    public static void clickAcceptFriendBtn(){
	    	AbstractPage.findElementsById("com.cmcc.p.poc:id/tv_delete_ll").get(0).click();
	    }
	    
	    
		//长按删除好友
	    public static void pressClick(){
	         // 把元素id赋值给longclick
	    	AbstractPage.pressClick("com.cmcc.p.poc:id/delete_bg");
	    	//删除
	    	AbstractPage.findElementById("com.cmcc.p.poc:id/tv_friend_delete").click();
	    	//点击确定删除按钮
	    	AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
	    }
}
