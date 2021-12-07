package com.cmcc.p.poc.automation.pagefunction;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cmcc.p.poc.automation.core.AbstractPage;
import com.cmcc.p.poc.automation.core.Utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import static com.cmcc.p.poc.automation.core.AbstractTest.driver;
@SuppressWarnings("unused")

public class AbstractGroupFunction {
	
	
//	对讲页面ptt键
	@SuppressWarnings("rawtypes")
	public static void ptt(int time){
		
//		//判断是否又录音权限弹窗
//		
//		if (AbstractPage.whetherElementVisable(By.id("com.cmcc.p.poc:id/tv_msg"), 1)) {
//			AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
//	}
//		//同意录音权限
//		
//		if (AbstractPage.whetherElementVisable(By.id("com.android.packageinstaller:id/permission_message"), 1)) {
//			AbstractPage.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
//	}
		
        //		把ptt元素id赋值给longclick
		//WebElement longClick = driver.findElement(By.id("com.cmcc.p.poc:id/layout_ptt"));
		WebElement longClick = driver.findElement(By.id("com.cmcc.p.poc:id/pocbtn"));
        //		对ptt键进行长按
		int x =longClick.getLocation().getX();
    	int y =longClick.getLocation().getY();
    	Duration duration =Duration.ofMillis(time);//毫秒级
    	TouchAction action = new TouchAction(driver);
    	action.longPress(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(duration)).release().perform();
	}
		
//	位置共享页面ptt键
	@SuppressWarnings("rawtypes")
	public static void shareptt(int time){
	        //		把ptt元素id赋值给longclick
			WebElement longClick = driver.findElement(By.id("com.cmcc.p.poc:id/ib_ptt"));
	        //		对ptt键进行长按
			int x =longClick.getLocation().getX();
	    	int y =longClick.getLocation().getY();
	    	Duration duration =Duration.ofMillis(time);//毫秒级
	    	TouchAction action = new TouchAction(driver);
	    	action.longPress(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(duration)).release().perform();
		
	}

//	群公告页面长按ptt键
	@SuppressWarnings("rawtypes")
	public static void ptt1(int time){
		
//		//判断是否又录音权限弹窗
//		
//		if (AbstractPage.whetherElementVisable(By.id("com.cmcc.p.poc:id/tv_msg"), 1)) {
//			AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
//	}
//		//同意录音权限
//		
//		if (AbstractPage.whetherElementVisable(By.id("com.android.packageinstaller:id/permission_message"), 1)) {
//			AbstractPage.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
//	}
		
        //		把ptt元素id赋值给longclick
		WebElement longClick = driver.findElement(By.id("com.cmcc.p.poc:id/pocbtn"));
        //		对ptt键进行长按
		int x =longClick.getLocation().getX();
    	int y =longClick.getLocation().getY();
    	Duration duration =Duration.ofMillis(time);//毫秒级
    	TouchAction action = new TouchAction(driver);
    	action.longPress(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(duration)).release().perform();
	}

//	查看成员位置页面长按ptt键
	@SuppressWarnings("rawtypes")
	public static void ptt2(int time){
		
//		//判断是否又录音权限弹窗
//		
//		if (AbstractPage.whetherElementVisable(By.id("com.cmcc.p.poc:id/tv_msg"), 1)) {
//			AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
//	}
//		//同意录音权限
//		
//		if (AbstractPage.whetherElementVisable(By.id("com.android.packageinstaller:id/permission_message"), 1)) {
//			AbstractPage.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
//	}
		
        //		把ptt元素id赋值给longclick
		WebElement longClick = driver.findElement(By.id("com.cmcc.p.poc:id/ib_ptt"));
        //		对ptt键进行长按
		int x =longClick.getLocation().getX();
    	int y =longClick.getLocation().getY();
    	Duration duration =Duration.ofMillis(time);//毫秒级
    	TouchAction action = new TouchAction(driver);
    	action.longPress(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(duration)).release().perform();
	}
	
//	位置共享功能
	public static void sharelocation(){
//		//判断是否有位置权限弹窗
//		
//				if (AbstractPage.whetherElementVisable(By.id("com.cmcc.p.poc:id/tv_msg"), 1)) {
//					AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
//			}
//				//同意位置权限
//				
//				if (AbstractPage.whetherElementVisable(By.id("com.android.packageinstaller:id/permission_message"), 1)) {
//					AbstractPage.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
//			}
		AbstractPage.findElementById("com.cmcc.p.poc:id/btn_location_share").click();
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
			
	}
	
//	发送位置功能
	public static void sendlocation() throws InterruptedException{
           //		   点击发送位置
		   AbstractPage.findElementById("com.cmcc.p.poc:id/btn_location_send").click();
		   Thread.sleep(10000);
		   
           //		   点击发送
		   AbstractPage.findElementById("com.cmcc.p.poc:id/title_right_text").click();
	}
	
//	切组出去又切组回来
//	public static void qiezu(int tt){
//		//选择群组列表任意一个群组
//		AbstractPage.findElementByName("群组").click();
//		AbstractPage.findElementById("com.cmcc.p.poc:id/rl_content").get(tt).click();		
//		//在切回原来的组,群组列表中排序第二个群组
//		AbstractPage.findElementByName("群组").click();
//		AbstractPage.findElementById("com.cmcc.p.poc:id/rl_content").get(2).click();		
//	}
	
//	账号登录
	public static void login(String username,String password){
        // 判断是否进入了登陆页
//        AbstractPage.untilElementDisplayed(By.id("com.cmcc.p.poc:id/tv_account_tip"), 1);
        // 清空账号输入框
        AbstractPage.findElementById("com.cmcc.p.poc:id/et_phone_num").clear();
        // 输入用户名
        AbstractPage.findElementById("com.cmcc.p.poc:id/et_phone_num").setValue(username);
        // 输入密码
        AbstractPage.findElementById("com.cmcc.p.poc:id/et_pwd").setValue(password);
        // 勾选记住密码
        AbstractPage.findElementById("com.cmcc.p.poc:id/iv_remember").click();
        
        // 点击登录
        AbstractPage.findElementById("com.cmcc.p.poc:id/tv_login").click();
	}
	
	public static void dismissgroup(){
		
//		 AbstractPage.findElementByName("群组").click();
//		 AbstractPage.findElementsById("com.cmcc.p.poc:id/rl_content").get(1).click();
		 AbstractPage.findElementById("com.cmcc.p.poc:id/ib_group_info").click();
		 AbstractPage.findElementById("com.cmcc.p.poc:id/tv_exit_group").click();
		 AbstractPage.findElementById("com.cmcc.p.poc:id/tv_cancel").click();
	}
	
	public static void changegroup(){
		
//		 AbstractPage.findElementByName("群组").click();
//		 AbstractPage.findElementsById("com.cmcc.p.poc:id/rl_content").get(1).click();
		 AbstractPage.findElementByName("群组").click();
	        // 进入群组列表最后一个群组
	        List<MobileElement>list = AbstractPage.findElementsById("com.cmcc.p.poc:id/rl_content");
	        int ret=list.size();
	        AbstractPage.findElementsById("com.cmcc.p.poc:id/rl_content").get(ret-1).click();
	}
	
	// 创建新群组
	public static void newgroup() {
		
		AbstractPage.findElementByName("群组").click();
		// 点击创建群组按钮
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_new_group").click();
		Utils.waitDefaultTime();
		Utils.waitDefaultTime();
		// 点击创建按钮
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
		// 点击返回按钮
		AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
	}

//	创建新群组，有邀请好友加入群组返回群组对讲页面
	public static void newgroup1(){
		//点击新建群组按钮
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_new_group").click();
		//等待3s
		Utils.waitDefaultTime();
		//点击创建按钮
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
		//选择好友
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_friend_name").click();
		//点击邀请
		AbstractPage.findElementById("com.cmcc.p.poc:id/title_right_text").click();
	}
	
//	创建新群组,里面没有点击群组步骤
	public static void newgroup3(){
		//点击新建群组按钮
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_new_group").click();
		//等待3s
		Utils.waitDefaultTime();
		//点击创建按钮
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
		//等待1s
		Utils.waitShortTime();
		//点击返回按钮
		AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
	}
	
	// 修改群组名称
	public static void changegrounpname(String groupname) {

		// 进入群组详情页
		AbstractPage.findElementById("com.cmcc.p.poc:id/ib_group_info").click();
		Utils.waitDefaultTime();
		// 获取原来群组名称
		String groupname1 = AbstractPage.findElementById("com.cmcc.p.poc:id/tv_group_name").getText();
		System.out.println("群组名称" + groupname1);
		// 点击群组名称
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_group_name").click();
		Utils.waitDefaultTime();
		// 清空账号输入框
		AbstractPage.findElementById("com.cmcc.p.poc:id/et_content").clear();
		// 输入新的群组名称
		AbstractPage.findElementById("com.cmcc.p.poc:id/et_content").setValue(groupname);
		// 点击完成
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
		//点击返回，返回到群组对讲页面
		AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
		// 群组对讲页面，获取新的群组名称
		String groupname2 = AbstractPage.findElementById("com.cmcc.p.poc:id/tv_group_name").getText();
		//等待1s
		Utils.waitShortTime();
		System.out.println("群组名称:" + groupname2);
		// 查询群组名称是否更新
		if (AbstractPage.whetherElementVisable(groupname2, 3)) {
			Utils.print("更换群名称---->PASS");
		} else {
			Utils.print("更换群名称---->失败");
		}
	}
		//加入群组
		public static void joingroup(String token ){
			 AbstractPage.findElementByName("群组").click();
		        Utils.waitDefaultTime();	
		        //点击加入群组
		        AbstractPage.findElementById("com.cmcc.p.poc:id/rl_enter_group").click();	
		        //输入群口令， 点击加入，
		        AbstractPage.findElementById("com.cmcc.p.poc:id/et_content").setValue(token);
		        AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
		        Utils.waitDefaultTime();
		        
		}
		
		
	//管理群组
		public static void managegroup(){
			//群组列表点击群组
			 AbstractPage.findElementByName("群组").click();
			 Utils.waitDefaultTime();
			 //点击管理群组
			 AbstractPage.findElementById("com.cmcc.p.poc:id/mgr_group").click();
			 if(AbstractPage.whetherElementVisable(By.id("com.cmcc.p.poc:id/title_content_text"), 2)){
				 System.out.println("成功进入管理群组页面");
			 }
		}
		
		//加群设置，开启进群验证
		public static void NeedCheck(){
			
			// 群组对讲页面，点击右上角的三个点
			AbstractPage.findElementById("com.cmcc.p.poc:id/ib_group_info").click();
			Utils.waitDefaultTime();
			
			//点击加群设置
			AbstractPage.findElementByName("加群设置").click();
			if(AbstractPage.whetherElementVisable(By.id("com.cmcc.p.poc:id/title_content_text"), 2)){
				//开启进群验证
				AbstractPage.findElementById("com.cmcc.p.poc:id/rl_need_check").click();
				Utils.waitDefaultTime();
			}
		}
		
		//加群设置，修改为不限制
		public static void Unlimited(){
		//等待1s
		Utils.waitShortTime();	
		// 群组对讲页面，点击右上角的三个点
		AbstractPage.findElementById("com.cmcc.p.poc:id/ib_group_info").click();
		//等待1s
		Utils.waitShortTime();

		// 点击加群设置
		AbstractPage.findElementByName("加群设置").click();
		AbstractPage.findElementById("com.cmcc.p.poc:id/rl_unlimited").click();
		//等待1s
		Utils.waitShortTime();
		// 点击返回，进入群组对讲页面
		AbstractPage.findElementById("com.cmcc.p.poc:id/title_left_text").click();
	}
		
	    //加群设置，不允许加入
		public static void Notallow(){
			// 群组对讲页面，点击右上角的三个点
			AbstractPage.findElementById("com.cmcc.p.poc:id/ib_group_info").click();
			Utils.waitDefaultTime();

			// 点击加群设置
			AbstractPage.findElementByName("加群设置").click();
			AbstractPage.findElementById("com.cmcc.p.poc:id/rl_dont_allow").click();
			Utils.waitDefaultTime();
			
		}
	
		//by对象是否存在，查找某个元素是否存在
		public static boolean byElementIsExist(By by) {
			try {
				driver.findElement(by);
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				return false;
			}
		}
		
		//调用查找某个元素是否存在
	    public static boolean yuansu(String yuansuid) {
		if(byElementIsExist(By.id(yuansuid))) {
			assert true;
		}else {
			assert false:" 元素不存在 ";
		}
		return false;
	}
		
		  //会员账号和非会员账号退出群组  ，执行前停留群组对讲页面
	    public static void dismissgroup1(){
	    	//点击群组对讲页面，右上角点点点按钮
	   		AbstractPage.findElementById("com.cmcc.p.poc:id/ib_group_info").click();
	   		//等待1s
	   		Utils.waitShortTime();
	   		//向上滑动找到退出群组按钮，兼容小屏幕手机
	   		AbstractPage.swipeup();
	   		//点击退出群组
	   		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_exit_group").click();
	   		//如果有这个元素则点击，没有则点击关闭
	   		if(byElementIsExist(By.id("com.cmcc.p.poc:id/tv_cancel")) == true) {
	   			//等待1s
	   	   		Utils.waitShortTime();
	   			//会员账号
	   			//点击退出群组
	   			AbstractPage.findElementById("com.cmcc.p.poc:id/tv_cancel").click();
	   			//等待1s
		   		Utils.waitShortTime();
			}else {
				//等待1s
		   		Utils.waitShortTime();
				//点击叉号关闭窗口
				AbstractPage.findElementById("com.cmcc.p.poc:id/iv_close").click();
				//等待1s
		   		Utils.waitShortTime();
				//非会员
				AbstractPage.findElementById("com.cmcc.p.poc:id/tv_exit_group").click();
				//等待1s
		   		Utils.waitShortTime();
		   		//点击确认退出
		   		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
		   		//等待1s
		   		Utils.waitShortTime();
			}
	   		Utils.print("解散群组成功--->PASS");
	   }


public static void dismissgroup2(){
		//向上滑动找到退出群组按钮，兼容小屏幕手机
		AbstractPage.swipeup();
		//点击退出群组
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_exit_group").click();
		//如果有这个元素则点击，没有则点击关闭
		if(byElementIsExist(By.id("com.cmcc.p.poc:id/tv_cancel")) == true) {
			//等待1s
	   		Utils.waitShortTime();
			//会员账号
			//点击退出群组
			AbstractPage.findElementById("com.cmcc.p.poc:id/tv_cancel").click();
	}else {
		//等待1s
   		Utils.waitShortTime();
		//点击叉号关闭窗口
		AbstractPage.findElementById("com.cmcc.p.poc:id/iv_close").click();
		//等待1s
   		Utils.waitShortTime();
		//非会员
		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_exit_group").click();
		//等待1s
   		Utils.waitShortTime();
   		//点击确认退出
   		AbstractPage.findElementById("com.cmcc.p.poc:id/tv_confirm").click();
   		//等待1s
   		Utils.waitShortTime();
	}
		Utils.print("解散群组成功--->PASS");
}
}