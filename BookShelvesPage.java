
package PagesClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BookShelvesPage{
WebDriver driver;
//============================================Class Constructor==========================================
	public BookShelvesPage(WebDriver driver) {
		this.driver=driver;
	}
	
//===<<<<<<<<<<<<<<<<<<<<<<<<<<<<<   Methods    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>=====	
	
//=========================================Title Method===================================================
	
	public void getTitle() { String pageTtile =driver.getTitle();
	 
	  System.out.println("PageTitle is : "+pageTtile);
	  System.out.println("\r\n"
				+ "===============================================");
	 
	  }
	 
////===============================Drag And Drop Slider Method============================================	
	
	public void doDragSlider() {
		//Find and Click on Price
		driver.findElement(By.xpath("//*[@id=\'filters-form\']/div[1]/div/div/ul/li[1]")).click();
       
		//Find Element Slider in Price Submenu 
		WebElement slider= driver.findElement(By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[1]/div[2]/div/div/ul/li[1]/div/div[2]/div[2]/div/div[2]/div"));
	 //Actions Class object Created
		Actions action = new Actions(driver);
		//Perform Drag and Drop in slider
	  action.dragAndDropBy(slider,-208,0).perform();
	}
	
////==============================Storage Type Drop Down Method====================================================	
	
	public void doStorageTypeOpen() {
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		
		//Find and Click on Storage type
      driver.findElement(By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[2]")).click();
      //Find and click on Open
      driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div[1]/div/form/div[1]/div/div/ul/li[2]/div[2]/div/div/div/ul/li[1]/input")).click();
	}
	
////============================================Display Method======================================================		
	
	public void displayBookShelves() {
		
		System.out.println("Top3 Bookshelves under 15000 with Storage Type Open with Heighest Recommendation :");
		System.out.println("\n");
	
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		//Find Elements Name  in List
		List<WebElement> lst = driver.findElements(By.xpath("/html/body/div[1]/div[1]/div[3]/div[4]/ul/li/div/div/a/div[1]/span"));
        //Find Price of Product in a list
	      List<WebElement> lst1 = driver.findElements(By.xpath("/html/body/div[1]/div[1]/div[3]/div[4]/ul/li/div/div/a/div[2]/span"));
	      
	      for(int i=0;i<3;i++)
	      {    
	    	  //Print Item Names and Price
	    	  System.out.println(lst.get(i).getText());
			  System.out.println(lst1.get(i).getText());
	      }
	
		System.out.println("\r\n"
				+ "===============================================");
		
	}
////======================================Exclude Out Of Stock CheckBox Method====================================	
	
	public void excludeoutOfStock() {
		//Find excludeoutOfStock Checkbox
		WebElement Checkbox =driver.findElement(By.xpath("//*[@id=\"filters_availability_In_Stock_Only\"]"));
		//Click on Checkbox
		Checkbox.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
////=====================================Navigate HomePage Method================================================	
	
	public HomePage navigateBacktoHome() {
		//Navigate back to HomePage
	     driver.navigate().back();
	   //POM Implementation
		return PageFactory.initElements(driver,HomePage.class);
	}
	
	
	

}
