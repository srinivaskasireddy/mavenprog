package p1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

@Listeners({ATUReportsListener.class, ConfigurationListener.class,MethodListener.class })
public class Test_prg
{
    WebDriver driver;
    
    {
    	System.setProperty("atu.reporter.config", "E:\\selenium\\Web\\atu.properties");
    }
	@Test
	@Parameters({"browser"})
	public void testing(String br) throws Exception
	{
		if(br.matches("firefox"))
		{
			driver=new FirefoxDriver();
		}
		if(br.matches("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","e:\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		Home1 h=new Home1(driver);
		//h.validate_links();
		//h.createacc();
		h.login();
		
		Compose1 c=new Compose1(driver);
		c.sendmail();
		c.signout();
		
		
	}
}
