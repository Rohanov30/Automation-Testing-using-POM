package PagesClass;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import com.google.common.io.Files;

public class GiftCardsPage {
	WebDriver driver;
////============================================Class Constructor============================================		
	public GiftCardsPage(WebDriver driver) {
		this.driver=driver;
	}
////============================================Title Method==================================================	
	public void getTitle() {
		String pageTtile =driver.getTitle();
		System.out.println("PageTitle is : "+pageTtile);
		 System.out.println("\r\n"
					+ "===============================================");
		 
	}
////============================================TakeSnapShot Method============================================		
	public  void takeSnapShot() throws IOException
	{
       TakesScreenshot scrshot = ((TakesScreenshot)driver);
       File ScrFile = scrshot.getScreenshotAs(OutputType.FILE);
       File DestFile = new File(System.getProperty("user.dir")+"\\Screenshots\\screenshots.png");
       Files.copy(ScrFile,DestFile);
	}
////============================================Fill Form Method=================================================		
	public WebDriver giftCardTest ()  throws InterruptedException {
	
		//click on birthday/anniversary
		driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/main/section/section[1]/ul/li[3]/div/h3")).click();
		//fill customize the gift card 
		driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/div[1]/button[2]")).click();
        //click on next button
		driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/button")).click();
		//Fill Recipient's name and email id
		driver.findElement(By.xpath("//*[@id=\"ip_4036288348\"]")).sendKeys("abcd");
		driver.findElement(By.xpath("//*[@id=\"ip_137656023\"]")).sendKeys("abcdgmail.com");
		//Fill customer's name and email id
		driver.findElement(By.xpath("//*[@id=\"ip_1082986083\"]")).sendKeys("efgh");
		driver.findElement(By.xpath("//*[@id=\"ip_1082986083\"]")).sendKeys("efgh@gmail.com");
		//Enter mobile number
		driver.findElement(By.xpath("//*[@id=\"ip_2121573464\"]")).sendKeys("4567889987");
		//click on confirm
		driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/main/section/section[3]/form/button")).click();
        // called takeSnapShot method to capture the error message 
		try {
			takeSnapShot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 Calendar cal = Calendar.getInstance();
	      SimpleDateFormat simpleformat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss Z");
	      System.out.println("ScreenShot Was Captured of Error Messege at "+simpleformat.format(cal.getTime()));
		return driver;
		
			
		
}
////============================================Navigate Back Home Method============================================	
	public HomePage navigateToHome() {
		//Navigate back to HomePage
		driver.navigate().back();
		//POM Implementation
		return PageFactory.initElements(driver,HomePage.class);
		
		
	}
}