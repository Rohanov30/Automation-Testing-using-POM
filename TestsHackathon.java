package Test_DisplayBookshelves;

import java.io.IOException;

import org.testng.annotations.Test;


import PagesClass.BookShelvesPage;
import PagesClass.GiftCardsPage;
import PagesClass.HomePage;

public class TestsHackathon {
	HomePage homepage;
	
	@Test(groups="regression")
	public void displayBookShelves() {
		System.out.println("\r\n"
				+ "===============================================");
	    homepage = new HomePage();
	    homepage.openBrowser();
		homepage.openUrbanLadder();
		homepage.getTitle();
		BookShelvesPage bookshelves=homepage.ClosePopUpAndClickBookShelves();
		bookshelves.getTitle();
		bookshelves.doDragSlider();
		bookshelves.doStorageTypeOpen();
		bookshelves.displayBookShelves();
		HomePage returned =bookshelves.navigateBacktoHome();
		returned.CloseBrowser();
		
		}
	
	@Test(groups="regression")
	public void excludeOutofStockTest() {
		System.out.println("\r\n"
				+ "===============================================");
		homepage = new HomePage();
	    homepage.openBrowser();
		homepage.openUrbanLadder();
		homepage.getTitle();
		BookShelvesPage bookshelves=homepage.ClosePopUpAndClickBookShelves();
		bookshelves.getTitle();
		bookshelves.doDragSlider();
		bookshelves.doStorageTypeOpen();
		bookshelves.excludeoutOfStock();
		bookshelves.displayBookShelves();
		HomePage returned =bookshelves.navigateBacktoHome();
		returned.CloseBrowser();
	
	}
	
	@Test(groups="regression")
	public void giftCardTest() throws IOException, InterruptedException {
		System.out.println("\r\n"
				+ "===============================================");
		homepage = new HomePage();
	    homepage.openBrowser();
		homepage.openUrbanLadder();
		homepage.getTitle();
		GiftCardsPage giftCard=homepage.ClickGiftCards();
		giftCard.getTitle();
		giftCard.takeSnapShot();
		giftCard.giftCardTest();
		HomePage returned=giftCard.navigateToHome();
		returned.CloseBrowser();
		
		}
	@Test(groups="regression")
	public void BestSellerSubMenuTest() {
		System.out.println("\r\n"
				+ "===============================================");
		homepage = new HomePage();   //
	    homepage.openBrowser();
		homepage.openUrbanLadder();
		homepage.getTitle();
		homepage.DisplayBestSellerFromCollection();
		homepage.CloseBrowser();
	}
	@Test(groups="smoke")
	public void WebsiteOpenTest() {
		System.out.println("\r\n"
				+ "===============================================");
		System.out.println("OpenWebSiteTest");
		homepage = new HomePage();
	    homepage.openBrowser();
		homepage.openUrbanLadder();
		homepage.getTitle();
		homepage.CloseBrowser();
	}
	@Test(groups="smoke")
	public void NavigationTest() {
		System.out.println("\r\n"
				+ "===============================================");
		System.out.println("Navigation Test");
	    homepage = new HomePage();
	    homepage.openBrowser();
		homepage.openUrbanLadder();
		BookShelvesPage bookshelves=homepage.ClosePopUpAndClickBookShelves();
		HomePage returned =bookshelves.navigateBacktoHome();
		returned.CloseBrowser();
		
	}
	@Test(groups="smoke")
	public void pageTitleTest() {
		System.out.println("\r\n"
				+ "===============================================");
		System.out.println("PageTitle Test");
		homepage = new HomePage();
	    homepage.openBrowser();
		homepage.openUrbanLadder();
		homepage.getTitle();
		BookShelvesPage bookshelves=homepage.ClosePopUpAndClickBookShelves();
		bookshelves.getTitle();
		HomePage returned =bookshelves.navigateBacktoHome();
		GiftCardsPage giftCards=homepage.ClickGiftCards();
		giftCards.getTitle();
		HomePage back= giftCards.navigateToHome();
		back.CloseBrowser();
		
		
	}

}
