package Test_Code;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {
	@Test
	public void test()
	{
		try{
			//File fileChrome=new File("src\\test\\resources\\Drivers\\chromedriver.exe");
			File fBrwsr = new File("src\\test\\resources\\Drivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", fBrwsr.getAbsolutePath());
			WebDriver driver=new ChromeDriver();
			//driver.get("http://10.31.101.16/qa");
			
			//driver.get("http://localhost:8080/FirstServletProject/FirstServlet");
			driver.get("http://localhost:8080/dev/FirstServletProject/FirstServlet");

			driver.manage().window().maximize();
			System.out.println("The Chrome browser is opened");
			
			WebElement ele = driver.findElement(By.xpath("/html/body/h2"));
			String sValue = ele.getText();
			System.out.println("The text present is: " + sValue);
			
			WebElement ele1 = driver.findElement(By.xpath("/html/body/h3"));
			String sValue1 = ele1.getText();
			//String[] saValue1 = sValue1.split(" ");
			/*DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.US); 
			Date startDate = (Date)formatter.parse(sValue1);*/
			System.out.println("The date present is: " + sValue1);
			
			Thread.sleep(10000);
			driver.get("http://localhost:8080/dev/FirstServletProject/FirstServlet");
			
			WebElement ele2 = driver.findElement(By.xpath("/html/body/h3"));
			String sValue2 = ele2.getText();
			System.out.println("The date present is: " + sValue2);
			
			if(!(sValue1.equals(sValue2)))
			{
				System.out.println("Wow....The dates are changing.");
			}
			else
			{
				System.out.println("uff....The dates are not changing.");
			}
			
			driver.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
