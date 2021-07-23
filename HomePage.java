package PagesClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage{
	static  WebDriver driver;
	 String path = System.getProperty("user.dir");
	 
//============================================Open Browser Method============================================			 
	
	 public void openBrowser() {
		System.setProperty("webdriver.chrome.driver",path+"\\resources\\drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
	}
	 
//============================================Open WebSite Method============================================			
	
	 public void openUrbanLadder() {
		driver.get("https://www.urbanladder.com/");
	}
	
//===================================Close Pop Up and Click  Method===========================================			
	
	 public BookShelvesPage ClosePopUpAndClickBookShelves() {
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(text(),'Close')]")));

		driver.findElement(By.xpath("//a[contains(text(),'Close')]")).click();
		
			 
		//Click on bookshelves
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	   driver.findElement(By.xpath("//*[@id=\'content\']/div[3]/div/div[3]/a[4]/h4")).click(); 

		
		
		return  PageFactory.initElements(driver,BookShelvesPage.class);
		
	}
//============================================Click GiftCards Method============================================			 
	
	 public GiftCardsPage ClickGiftCards() {
		WebElement gift =driver.findElement(By.xpath("//*[@id=\"header\"]/section/div/ul[2]/li[3]/a"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()",gift);
		
	return PageFactory.initElements(driver,GiftCardsPage.class);
			}
	
//============================================Best Seller Submenu Display Method==================================	

	public void DisplayBestSellerFromCollection() {
	System.out.println("Items under BestSeller SubMenu are :-");
    System.out.println("\n");  

		driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div/nav/div/ul/li[10]/span")).click();
		
		
		
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/header/div[2]/div/nav/div/ul/li[10]/div/div/ul/li[3]/div/a")));
		
		
		List<WebElement> lst = driver.findElements(By.xpath("/html/body/div[1]/header/div[2]/div/nav/div/ul/li[10]/div/div/ul/li[3]/ul/li/a/span"));
		
		
		
		
		for(int i=0;i<7;i++)
		{
			System.out.println(lst.get(i).getText());
			
			
		}
		System.out.println("\r\n"
				+ "===============================================");
		
		
	}
//=========================================Title Method===================================================
	
     public void getTitle() {
	 String pageTtile =driver.getTitle();
	 System.out.println("PageTitle is : "+pageTtile);
	 System.out.println("\r\n"
				+ "===============================================");
	 
}
     
//=========================================Driver Close Method===================================================

     public void CloseBrowser() {
	driver.close();
	}
}
