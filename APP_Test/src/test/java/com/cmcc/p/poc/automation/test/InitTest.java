package com.cmcc.p.poc.automation.test;


import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

public class InitTest {
    private static final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";

    public static void main(String[] args) {
   	
    	XmlSuite suite = new XmlSuite();
    	suite.setName("TmpSuite");

    	XmlTest test = new XmlTest(suite);
    	test.setName("TmpTest");
    	List<XmlClass> classes = new ArrayList<XmlClass>();
    	classes.add(new XmlClass("com.cmcc.p.poc.automation.test.LoginTest"));
    	classes.add(new XmlClass("com.cmcc.p.poc.automation.test.AddAndRemoveMember"));
    	classes.add(new XmlClass("com.cmcc.p.poc.automation.test.JoinAndExitGroup"));
    	classes.add(new XmlClass("com.cmcc.p.poc.automation.test.HistotyTest"));
    	classes.add(new XmlClass("com.cmcc.p.poc.automation.test.SpeakAndPlay"));
    	classes.add(new XmlClass("com.cmcc.p.poc.automation.test.ShareLocation"));
    	classes.add(new XmlClass("com.cmcc.p.poc.automation.test.EmailTest"));
    	test.setXmlClasses(classes) ;
    	        

    	List<XmlSuite> suites = new ArrayList<XmlSuite>();
    	suites.add(suite);
    	TestNG tng = new TestNG();
    	tng.setXmlSuites(suites);
    	tng.run();	
    	
    	
    }
    	
}
