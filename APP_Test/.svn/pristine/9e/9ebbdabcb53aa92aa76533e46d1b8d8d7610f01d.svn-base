package com.cmcc.p.poc.automation.core;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CreatTestngxml {
	
    public static void createTestngXml(String classname) throws Exception {
        Document document = DocumentHelper.createDocument();
        Element root = DocumentHelper.createElement("suite");
        document.setRootElement(root);
        root.addAttribute("name", "automation");
        root.addAttribute("parallel", "Automatically generate xml");
        root.addAttribute("thread-count", String.valueOf("1"));
        Element listeners = root.addElement("listeners");  //子标签
        Element listener1 = listeners.addElement("listener");
        listener1.addAttribute("class-name", "org.uncommons.reportng.HTMLReporter");
        Element listener2 = listeners.addElement("listener");
        listener2.addAttribute("class-name", "org.uncommons.reportng.JUnitXMLReporter");
        Element test = root.addElement("test");
        test.addAttribute("name", "127.0.0.1");
        Element classes = test.addElement("classes");
        Element classNode = classes.addElement("class");
        classNode.addAttribute("name", classname);       
        OutputFormat format = new OutputFormat("    ", true);
        XMLWriter xmlWrite2;
        try {
            xmlWrite2 = new XMLWriter(new FileOutputStream("mytestng.xml"), format);
            xmlWrite2.write(document);
        } catch (
                UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (
                FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (
                IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("执行成功！！！");
    }

}
