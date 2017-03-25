package test;

import java.io.IOException;
import java.nio.charset.Charset;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.*;
import com.csvreader.CsvReader;

public class Test {
    
public static void main(String[] args) throws IOException {
                             
	//前期环境配置
	CsvReader r = new CsvReader("E://大三下学期学习//软件测试技术//inputgit.csv", ',',Charset.forName("GBK"));//设置csv表路径并以GBK格式读取
	System.setProperty("webdriver.firefox.bin", "D:/Firefox/firefox.exe"); //配置到火狐安装路径下的exe文件
	WebDriver driver = new FirefoxDriver(); //打开火狐浏览器
	final int TestCaseNumber = 20; //设置测试数量
	int i = 0;
	
	//读取csv数据表表头
	r.readHeaders();
	//逐条读取记录，直至读到数量为止。如果不加判断则为读完
	while (r.readRecord() && i<TestCaseNumber) {
	//按列名读取这条记录的值
	String csvName = r.get("姓名");
	String csvStudentID = r.get("学号");
	String csvStudentPwd = r.get("学号").substring(4, 10); //密码为后六位
	String csvGithubURL = r.get("github地址");
	
	//读完开始在网页中判断
	driver.get("http://121.193.130.195:8080/");//跳转到定位网页
	WebElement element_name = driver.findElement(By.id("name")); //获取学号输入框的元素
	element_name.clear();//清空输入框里的内容
	element_name.sendKeys(csvStudentID); //在学号这栏输入csv表获得到的学号
	WebElement element_pwd = driver.findElement(By.id("pwd")); //获取密码输入框的元素
	element_pwd.clear();
	element_pwd.sendKeys(csvStudentPwd);
	WebElement element_submit = driver.findElement(By.id("submit")); //获取提交按钮
	element_submit.click(); //点击提交按钮
	
	//获取登录后网页上显示的名字、学号、github地址的网页元素
	WebElement webName =driver.findElement(By.xpath("//tbody[@id='table-main']/tr/td[2]"));
	WebElement webStudentID =driver.findElement(By.xpath("//tbody[@id='table-main']/tr[2]/td[2]"));
	WebElement webGithubURL =driver.findElement(By.xpath("//tbody[@id='table-main']/tr[3]/td[2]"));
	
	//如果csv表格里的内容和网页上对应元素的内容相等，则输出信息一致，否则输出信息不一致
	if ((csvName.equals(webName.getText())) && (csvStudentID.equals(webStudentID.getText())) 
	    && (csvGithubURL.equals(webGithubURL.getText())))
		System.out.println("信息一致");
	else
		System.out.println(csvStudentID + "信息不一致");
	
	i++;
	}
	//循环结束后关闭表和浏览器
	r.close();
	driver.close();
	
}

}

    
