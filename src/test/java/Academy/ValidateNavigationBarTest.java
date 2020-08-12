package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.startupPage;
import resources.base;

public class ValidateNavigationBarTest extends base{
	// making a copy locally so when the test is running in parallely it is not overriden by another driver
	public WebDriver driver; 
		
	@BeforeTest
	public void initalizeTest() throws IOException {
		driver = initializeDriver();
		String URL = externalData.getProperty("url");
		driver.get(URL);
	}
	
	@Test
	public void validateNavigationBar() {
		startupPage stPage = new startupPage(driver);
		Assert.assertTrue(stPage.getNavigationBar().isDisplayed());
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
