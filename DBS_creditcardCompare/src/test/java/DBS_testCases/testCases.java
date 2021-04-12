package DBS_testCases;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import DBS_pageObjects.DBS_basicPageObjects;

public class testCases {
	String driverPath="D:\\Selenium\\Workspace\\DBS_creditcardCompare\\src\\test\\resources\\chromedriver.exe";
	WebDriver driver;
	DBS_basicPageObjects obj;
	@BeforeTest
	 public void setup()throws InterruptedException{
		//Calling Base URL
	       System.setProperty("webdriver.chrome.driver", driverPath);
	       driver = new ChromeDriver(); 
	       obj = new DBS_basicPageObjects(driver);
	       System.out.println(obj.page_URL);
	       driver.manage().window().maximize();
	        
	       driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	       driver.get(obj.page_URL);
	       System.out.println(obj.text);
	       driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	    }
	 @Test(priority=0)
	 public void toTestHomepage() {
		 //Create BasicPageobject

		    obj = new DBS_basicPageObjects(driver);
		  //Check title 
		       String Actual=driver.getTitle();
		       System.out.println(Actual);
		       String Expected="Bank Accounts, Cards, Loans, Financial Planning | DBS Singapore";
		       if (Actual.equals(Expected)) {
					 System.out.println("Test passed. Title name is matched");
				 }
				 else {
					 System.out.println("Test Failed");
				 }
	 }
	 @Test(priority=1)
	 public void toClick_Card() {
		 //To Click Menu 'Card' & CreditCard
		 obj = new DBS_basicPageObjects(driver);
		 obj.menu_cards();
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 obj.menu_creditCard();
		 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 
	 }
	 @Test(priority=2)
	 //To select 2 cards and Click 'Compare'
	 public void toCompare_creditcards() throws InterruptedException {
		 obj = new DBS_basicPageObjects(driver);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,800)");
		 Thread.sleep(2000);
		 obj.card_selection();
	 }
	 
	
	@Test(priority=3)
	 public void toAssertCardDetails() {
		String Actual=driver.findElement(By.xpath("//img[@alt='DBS Altitude Visa Signature Card']")).getAttribute("alt");
		 System.out.println(Actual);
		 String Expected="DBS Altitude Visa Signature Card";
		 if (Actual.equals(Expected)) {
			 System.out.println("Test passed. Card name is matched");
		 }
		 else {
			 System.out.println("Test Failed");
		 }
		String Actual1=driver.findElement(By.xpath("//img[@alt='DBS Black Visa Card']")).getAttribute("alt");
		 System.out.println(Actual1);
		 String Expected1="DBS Black Visa Card";
		 if (Actual1.equals(Expected1)) {
			 System.out.println("Test passed. Card name is matched");
		 }
		 else {
			 System.out.println("Test Failed");
		 }
		
	 }
	 
	 @AfterTest
	 public void terminateBrowser() {
		 driver.close();
	 }
}
