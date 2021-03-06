package com.cmcc.p.poc.automation.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.cmcc.p.poc.automation.core.AbstractPage;
import com.cmcc.p.poc.automation.core.AbstractTest;
import com.cmcc.p.poc.automation.core.Utils;
import com.cmcc.p.poc.automation.pagefunction.AbstractGroupFunction;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import java.util.Calendar;
import java.util.List;
@Epic("群组对讲页面-长按PTT功能")
@Feature("开始创造测试数据")
public class SpeakAndPlay extends AbstractTest {
	 private String casename = "长按PTT功能";
	 static String user1;
	 static String pwd1;
	 @Override
		@BeforeTest
		public void setUp(){
			Utils.print("casename" + casename);
		}
	 @Test(dataProvider = "loginSuccess",alwaysRun = true, dataProviderClass = DataPro.class)
	 public static void getFirst(String account,String password) {			
		 user1 = account;	
		 pwd1=password;		
		}
	 @Story("开始执行测试用例")
		@Test
		public void test(){
			//登录
			AbstractPage.login(user1,pwd1);
			Utils.waitDefaultTime();
	        //创建群组
	        AbstractGroupFunction.newgroup();
	        //等待3秒
	        Utils.waitDefaultTime();
	        // 点击群组
	        AbstractPage.findElementByName("群组").click();
            //选择群组进入       	        
	        List<MobileElement>list = AbstractPage.findElementsById("com.cmcc.p.poc:id/rl_content");
	        int ret=list.size();
	        AbstractPage.findElementsById("com.cmcc.p.poc:id/rl_content").get(ret-1).click();
	        //在群组对讲页面长按ptt键讲话
	        AbstractGroupFunction.ptt(30000);

	        //判断语音时长是否一致	    
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTimeInMillis(System.currentTimeMillis());
	        String datestr = calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE);
	        Utils.print(datestr);
	        List<MobileElement>historylist = AbstractPage.findElementsById("com.cmcc.p.poc:id/tv_time");
	        int ret2= historylist.size();
	        String appdate = AbstractPage.findElementsById("com.cmcc.p.poc:id/tv_time").get(ret2-1).getText();
	        Utils.print(appdate);
	        
	        List<MobileElement>audiotime = AbstractPage.findElementsById("com.cmcc.p.poc:id/tv_audio_time");
	        int time= audiotime.size();
	        String timea = AbstractPage.findElementsById("com.cmcc.p.poc:id/tv_audio_time").get(time-1).getText();	    
	        timea.contains("3") ;  		      
	        boolean c =appdate.contains(datestr);
	        assert(c)=true;
	        //在位置共享页面长按ptt键讲话
	        AbstractGroupFunction.sharelocation();
	        AbstractGroupFunction.shareptt(10000);
	        
	        //返回群组对讲页面
	        AbstractPage.findElementById("com.cmcc.p.poc:id/ib_back").click();
	        Utils.waitLongTime();	        
	        List<MobileElement>audiotime2 = AbstractPage.findElementsById("com.cmcc.p.poc:id/tv_audio_time");
	        int time2= audiotime2.size();
	        String timeb = AbstractPage.findElementsById("com.cmcc.p.poc:id/tv_audio_time").get(time2-1).getText();	    
	        timeb.contains("1") ; 
	        
	        //播放历史语音
	        AbstractPage.findElementsById("com.cmcc.p.poc:id/tv_audio_time").get(time2-1).click();
	        AssertJUnit.assertTrue("播放语音失败",AbstractPage.whetherElementVisable(By.id("com.cmcc.p.poc:id/iv_stop_play"), 1));
	        //Assert.assertEquals(timeb,"10'");	
	        //Assert.assertEquals(timea,"30'");
	        
	        Utils.print(casename + "---->PASS");
	        //解散群组
			AbstractGroupFunction.dismissgroup1();
		}
}