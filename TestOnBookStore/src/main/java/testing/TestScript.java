package testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestScript {
	public WebDriver d;
	
	@BeforeTest
	  public void beforeTest() {	  
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Krati\\Documents\\SeleniumServer\\chromedriver.exe");	
		  d = new ChromeDriver();
		  d.manage().window().maximize();
	  }
	
	  @Test (priority=0)
	  public void titlecheck() {
		  d.get("http://localhost:8585/onlinebookstore/");
		  String expected="Welcome to Book Store";
		  Assert.assertEquals(expected, d.getTitle());
	  }
	  @Test (priority=1)
	  public void adminLogin() {
		  WebElement wb1 = d.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/a"));
		  wb1.click();
		  d.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
		  WebElement id = d.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/form/input[1]"));
		  WebElement psswd = d.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/form/input[2]"));
		  WebElement btn = d.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/form/input[3]"));	
		  String email = "admin";
		  String pwd = "admin";
		  id.sendKeys(email);
		  psswd.sendKeys(pwd);
		  btn.click();

	  }
	  @Test (priority=2)
	  public void prechanges() {
		  d.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
		  String expected="Welcome to Book Store";
		  Assert.assertEquals(expected, d.getTitle());
	  }
	  @Test (priority=2)
	  public void postchanges() {
		  d.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS) ;
		  String expected="Book Store";
		  Assert.assertEquals(expected, d.getTitle());
	  }
	  
	  @AfterTest
	  public void afterTest() {
		  WebElement signout = d.findElement(By.xpath("/html/body/div[5]/a"));
		  signout.click();
		  d.close();
		  
	  }

}
