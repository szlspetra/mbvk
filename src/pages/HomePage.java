package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	String url = "https://arveres.mbvk.hu/";
    By ElektronikusArveresiRendszer = By.xpath("//*[text()='ELEKTRONIKUS']");
    By ingatlanMenu = By.xpath("//*[text()='INGATLAN ÁRVERÉSI']");
    
    HomePage objHomeP; 
    
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    
    public void clickEAR () {
    	driver.findElement(ElektronikusArveresiRendszer).click();
    }    
    
    public void clickIngatlanMenu () {
    	driver.findElement(ingatlanMenu).click();
    }    
}
