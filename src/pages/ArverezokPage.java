package pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ArverezokPage {

	WebDriver driver;
	
    By reszletesKeresoButton = By.xpath("//*[text()=' Részletes keresõ']");
    By BekoltozhetoCheckbox = By.xpath("//*[@name='ingatlan_keres[teher][bekoltozheto]']");
    By OsszesMegyeCheckbox = By.xpath("//*[@name='ingatlan_keres[checkAll1]']");
    By VeszpremMegyeCheckbox = By.xpath("//*[@name='ingatlan_keres[megye][18]']");
    By SomogyMegyeCheckbox = By.xpath("//*[@name='ingatlan_keres[megye][14]']");
    By BudapestCheckbox = By.xpath("//*[@name='ingatlan_keres[megye][20]']");
    By PestMegyeCheckbox = By.xpath("//*[@name='ingatlan_keres[megye][13]']");
    By KeresesButton = By.xpath("//*[@id='fadesima3']");
    By DownloadButton = By.xpath("//*[@id='pdfDiv']");
    
    public ArverezokPage(WebDriver driver){
        this.driver = driver;
    }
    
    public void clickReszletesKereso() {
    	driver.findElement(reszletesKeresoButton).click();
    }
    
    public void clickBekoltozhetoCB() {
    	driver.findElement(BekoltozhetoCheckbox).click();
    }
    
    public void clickmegyeCB(String megyeCheckbox) {
    	switch(megyeCheckbox) {
    	  case "veszprém":
    		  driver.findElement(VeszpremMegyeCheckbox).click();
    	    break;
    	  case "somogy":
    		  driver.findElement(SomogyMegyeCheckbox).click();
    	    break;
    	  case "pest":
    		  driver.findElement(PestMegyeCheckbox).click();
    	    break;
    	  case "budapest":
    		  driver.findElement(BudapestCheckbox).click();
    	    break;
    	  case "összes":
    		  driver.findElement(OsszesMegyeCheckbox).click();
    	    break;
    	}
    }
    
    public void clickKeresButton() {
    	driver.findElement(KeresesButton).click();
    }
    
    public void clickPdfButtons() {
    	List<WebElement> pdfIcon = driver.findElements(DownloadButton);
    	for (int i= 0; i < pdfIcon.size(); i++) {
    		pdfIcon.get(i).click();
    	} 		
    }
}

