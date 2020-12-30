package ingatlan;

//import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.*;
import fileIO.*;

public class ListDownload {
	ReadExcelFile readExcel;
	String[][] data;
	
	FirefoxDriver driver;
	SetupFirefox objSetupFirefox;
	HomePage objHomeP;
	ArverezokPage objArverezok;
	
	/*
	String filePath = System.getProperty("user.dir")+"\\data";
	String excelName = "AdozoiAdatokRogzitese.xlsx";
	String sheetName = "Munka1";
	*/

	@BeforeTest
	public void setup(){
		
			objSetupFirefox = new SetupFirefox();	
			driver = objSetupFirefox.getDriver();
			System.out.println("INFO: Böngészõ setup megtörtént.");
						
			objHomeP = new HomePage(driver);
			objHomeP.clickEAR();
			objHomeP.clickIngatlanMenu();
			System.out.println("INFO: Ingatlanok listázása sikeres.");
	}
	
	@Test(priority=1) 
	public void filter() throws InterruptedException {
		objArverezok = new ArverezokPage(driver);
		objArverezok.clickReszletesKereso();
		objArverezok.clickBekoltozhetoCB();
		objArverezok.clickmegyeCB("összes");
		objArverezok.clickmegyeCB("veszprém");
		objArverezok.clickmegyeCB("somogy");
		objArverezok.clickmegyeCB("pest");
		objArverezok.clickmegyeCB("budapest");
		objArverezok.clickKeresButton();
	}
	
	@Test(priority=1) 
	public void downloadAll() throws InterruptedException {
		objArverezok.clickReszletesKereso();
		objArverezok.clickPdfButtons();
	}
	
	@AfterTest
	public void logout() {
		
		//driver.close();
	}
	

}
