package com.cmcc.p.poc.automation.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.cmcc.p.poc.automation.core.AbstractPage;
import com.cmcc.p.poc.automation.core.AbstractTest;
import com.cmcc.p.poc.automation.core.Utils;
import com.cmcc.p.poc.automation.pagefunction.AbstractGroupFunction;

import io.appium.java_client.MobileElement;
import java.util.List;

public class HistotyTest extends AbstractTest {
	private String casename = "检查历史语音消息";
    
	static String user1;
	static String pwd1;

	@Override
	@BeforeTest
	public void setUp() {
		Utils.print("casename" + casename);
	}

	@Test(dataProvider = "loginSuccess", alwaysRun = true, dataProviderClass = DataPro.class)
	public static void getFirst(String account, String password) {
		user1 = account;
		pwd1 = password;
	}
		
    @Test
	public void histotytest() throws InterruptedException {
    	//登录
		AbstractPage.login(user1, pwd1);
		Utils.waitDefaultTime();
		//新建群组
		 AbstractGroupFunction.newgroup();
		 Utils.waitDefaultTime();
		//新建群组
		 AbstractGroupFunction.newgroup();
		 Utils.waitDefaultTime();
		// 点击群组
		AbstractPage.findElementByName("群组").click();
		Utils.waitDefaultTime();
		// 进入最后一个群组
		List<MobileElement> list = AbstractPage.findElementsById("com.cmcc.p.poc:id/rl_content");
		int ret = list.size();
		System.out.println(ret);
		AbstractPage.findElementsById("com.cmcc.p.poc:id/rl_content").get(ret - 1).click();
		// 获取进入的群组的群组名称
		String groupname1 = AbstractPage.findElementById("com.cmcc.p.poc:id/tv_group_name").getText();
		System.out.println(groupname1);

		// 在进入的群组里发送语音消息
		AbstractGroupFunction.ptt(5000);
		AbstractGroupFunction.ptt(10000);
		AbstractGroupFunction.ptt(5000);
		AbstractGroupFunction.ptt(15000);
		AbstractGroupFunction.ptt(5000);

		// 获取群组内共有多少条历史语音消息
		int a = AbstractPage.findElementsById("com.cmcc.p.poc:id/layout_audio").size();
		System.out.println(a);
		// 进行切组
		AbstractGroupFunction.changegroup();
		// 切回原来群组
		Utils.waitDefaultTime();
		AbstractPage.findElementByName("群组").click();
		AbstractPage.findElementByName(groupname1).click();
		// 获取切组后群组内共有多少条历史语音消息
		Utils.waitDefaultTime();
		int b = AbstractPage.findElementsById("com.cmcc.p.poc:id/layout_audio").size();
		System.out.println(b);
		// 判断两次历史语音条数是否一致（切组前的历史语音条数是否等于切组后回来的历史语音条数）
		Assert.assertEquals(a, b);
  	       
  	     Utils.print(casename + "---->PASS");
  	    		  

  		
  		Thread.sleep(5000);
  	    //解散群组
  		AbstractGroupFunction.dismissgroup1();
  	    // 进行切组
  		AbstractGroupFunction.changegroup();
  	    //解散群组
  		AbstractGroupFunction.dismissgroup1();
    }
    
}
