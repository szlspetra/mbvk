package pages;

import org.testng.Assert;

public class Functions {
	
	public Functions () {
		
	}
	public boolean stringOsszehasonlitas (String string1, String string2) {
		if (string1.equals(string2)) {
			return true;
		}
		
		else {
			Assert.fail("Nem egyenlõ a két string: " + string1 + " || " + string2 );
			return false;
		}
			
	}
}
