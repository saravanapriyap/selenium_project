package DBS_pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class DBS_basicPageObjects {
	/**
     * All WebElements are identified by @FindBy annotation (PageObject Factory)
     */
	
	 public WebDriver driver;
	 public String text="priya";
	 //Page URL
	 public String page_URL="https://www.dbs.com.sg/personal/default.page";
	 
	 //Menu 'Cards'
	 @FindBy(xpath="//*[@class='navbar-inner'] //*[@data-node='j7nnjymf']")
	 WebElement cards;
	 
	 //Credit Cards
	 @FindBy(xpath="//*[@class='navbar-overflow navlinks mBot-32 mobMBot-24'] //*[@class='navbar-overflow-width'] //*[@href='/personal/cards/cards-comparator.page']")
	 WebElement creditCard;
	 
	 //Creditcard selection 1
	 @FindBy(xpath="//*[@for='cb0']")
	 WebElement card1;
	 
	 //Creditcard selection 2
	 @FindBy(xpath="//*[@for='cb1']")
	 WebElement card2;
	 
	 //Compare Button
	 @FindBy(id="cardCompareBtn")
	 WebElement compare;
	 
	//Constructor
	   public DBS_basicPageObjects (WebDriver driver){
	       this.driver=driver;

	       //Initialise Elements
	       PageFactory.initElements(driver, this);
	   }
	   
	 //To Click Menu 'Cards' from home page
	   public void menu_cards() {
		  cards.click();
		 
	   }
	   
	 //To Click Menu 'Credit card'
	   public void menu_creditCard() {
		   creditCard.click();
	   }
	   
	 //To Select card1 & card2
	   public void card_selection() throws InterruptedException{
		   card1.click();
		   Thread.sleep(10000);
		   card2.click();
		   compare.click();
	   }

}
