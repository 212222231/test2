package com.cmcc.p.poc.automation.test;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataPro {
//  成功登陆的用户名密码
  @DataProvider(name = "loginSuccess")
//  public static Object[][] data() throws IOException {
//      Object[][] data;
//      String text = System.getProperty("user.dir");
//      String file = text + "/taskdata_excel/account.xls";
//      data = DataTest.readFromExcel_o(file, "sheet1", 0);
//      
//      return new Object[][] {{ data[0][0],data[0][1]}};
////      return data;
//  }
  //1-3行是会员账号，4-6行是非会员账号
  public static Object[][] provider(Method method) throws IOException {
      Object[][] data;
      String text = System.getProperty("user.dir");
      String file = text + "/taskdata_excel/account.xls";
      data = DataTest.readFromExcel_o(file, "sheet1", 0);
      if (method.getName().equals("getFirst")) {
    	  //第一列数据
    	  return new Object[][] {{ data[0][0],data[0][1]}};}
      else if (method.getName().equals("getFirst2")) { //如果调用该DataProvider的函数不是getFirst也不是getSecond，那么就返回这个数组
    	  //第二列数据
    	  return new Object[][] {{ data[1][0],data[1][1]}};
      }else if (method.getName().equals("getFirst3")) {
    	  //第三列数据
    	  return new Object[][] {{ data[2][0],data[2][1]}};
      }else if (method.getName().equals("getsecond")) {
    	  //第四列数据
    	  return new Object[][] {{ data[3][0],data[3][1]}};
      }else if (method.getName().equals("getsecond5")) {
    	  //第五列数据
    	  return new Object[][] {{ data[4][0],data[4][1]}};
      }else if (method.getName().equals("getsecond6")) {
    	  //第六列数据
    	  return new Object[][] {{ data[5][0],data[5][1]}};
      }else {
    	  //如果取不到数据则返回第六列数据，非会员账号
		return new Object[][] {{ data[5][0],data[5][1]}};
	}
//      return data;
  }
  
}