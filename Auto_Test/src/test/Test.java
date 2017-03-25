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
                             
	//ǰ�ڻ�������
	CsvReader r = new CsvReader("E://������ѧ��ѧϰ//������Լ���//inputgit.csv", ',',Charset.forName("GBK"));//����csv��·������GBK��ʽ��ȡ
	System.setProperty("webdriver.firefox.bin", "D:/Firefox/firefox.exe"); //���õ������װ·���µ�exe�ļ�
	WebDriver driver = new FirefoxDriver(); //�򿪻�������
	final int TestCaseNumber = 20; //���ò�������
	int i = 0;
	
	//��ȡcsv���ݱ��ͷ
	r.readHeaders();
	//������ȡ��¼��ֱ����������Ϊֹ����������ж���Ϊ����
	while (r.readRecord() && i<TestCaseNumber) {
	//��������ȡ������¼��ֵ
	String csvName = r.get("����");
	String csvStudentID = r.get("ѧ��");
	String csvStudentPwd = r.get("ѧ��").substring(4, 10); //����Ϊ����λ
	String csvGithubURL = r.get("github��ַ");
	
	//���꿪ʼ����ҳ���ж�
	driver.get("http://121.193.130.195:8080/");//��ת����λ��ҳ
	WebElement element_name = driver.findElement(By.id("name")); //��ȡѧ��������Ԫ��
	element_name.clear();//���������������
	element_name.sendKeys(csvStudentID); //��ѧ����������csv���õ���ѧ��
	WebElement element_pwd = driver.findElement(By.id("pwd")); //��ȡ����������Ԫ��
	element_pwd.clear();
	element_pwd.sendKeys(csvStudentPwd);
	WebElement element_submit = driver.findElement(By.id("submit")); //��ȡ�ύ��ť
	element_submit.click(); //����ύ��ť
	
	//��ȡ��¼����ҳ����ʾ�����֡�ѧ�š�github��ַ����ҳԪ��
	WebElement webName =driver.findElement(By.xpath("//tbody[@id='table-main']/tr/td[2]"));
	WebElement webStudentID =driver.findElement(By.xpath("//tbody[@id='table-main']/tr[2]/td[2]"));
	WebElement webGithubURL =driver.findElement(By.xpath("//tbody[@id='table-main']/tr[3]/td[2]"));
	
	//���csv���������ݺ���ҳ�϶�ӦԪ�ص�������ȣ��������Ϣһ�£����������Ϣ��һ��
	if ((csvName.equals(webName.getText())) && (csvStudentID.equals(webStudentID.getText())) 
	    && (csvGithubURL.equals(webGithubURL.getText())))
		System.out.println("��Ϣһ��");
	else
		System.out.println(csvStudentID + "��Ϣ��һ��");
	
	i++;
	}
	//ѭ��������رձ�������
	r.close();
	driver.close();
	
}

}

    
