package p1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

@Listeners({ATUReportsListener.class, ConfigurationListener.class,MethodListener.class })
public class Home1 
{
    WebDriver driver;
    
    {
    	System.setProperty("atu.reporter.config", "E:\\selenium\\Web\\atu.properties");
 	}
    public Home1(WebDriver driver)
    {
    	this.driver=driver;
    }
	public void open()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://www.yahoomail.com");
	}
	public void validate_links()
	{
		open();
		String arr[]={"About Mail","Features","Get App","Help"};
		WebElement w=driver.findElement(By.xpath("//ul[@class='Fl(end) Mend(10px) Lts(-0.31em) Tren(os) Whs(nw) My(6px)']"));
		List<WebElement> lst=w.findElements(By.xpath("li/a/b"));
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i].matches(lst.get(i).getText()))
			{
				ATUReports.add("Link is matching",LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));
			}
			else
			{
				ATUReports.add("Link is NOT matching",LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
			}
		}		
	}
	public void createacc() throws Exception
	{
		open();
		driver.findElement(By.id("login-signup")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("firstname")).sendKeys("abcd");
		driver.findElement(By.name("secondname")).sendKeys("xyza");
		
		
		driver.findElement(By.xpath("//span[@class='country-code-arrow']")).click();
		driver.findElement(By.xpath("//a[@data-code='91']")).click();
		driver.findElement(By.id("mobile")).sendKeys("9898989898");
		
			
		//to select value in drop down list
		new Select(driver.findElement(By.id("day"))).selectByVisibleText("20");
		new Select(driver.findElement(By.id("month"))).selectByVisibleText("April");
	    new Select(driver.findElement(By.id("year"))).selectByVisibleText("1984");
	    
	    new Actions(driver).moveToElement(driver.findElement(By.id("male"))).click().perform();
		
	}
	public void login() throws Exception
	{
		open();
		driver.findElement(By.name("username")).sendKeys("venkat123456a");
		driver.findElement(By.id("login-signin")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("passwd")).sendKeys("mq123456");
		driver.findElement(By.name("signin")).click();
	}
}
