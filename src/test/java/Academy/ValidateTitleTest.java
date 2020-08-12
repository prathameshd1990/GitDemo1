package Academy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.startupPage;
import resources.base;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

public class ValidateTitleTest extends base{
	// making a copy locally so when the test is running in parallely it is not overriden by another driver
	public WebDriver driver; 
	
	public static Logger log = LogManager.getLogger(ValidateTitleTest.class.getName());
	
	@BeforeTest
	public void initalizeTest() throws IOException {
		driver = initializeDriver();
		String URL = externalData.getProperty("url");
		driver.get(URL);
	}

	@Test
	public void validateAppTitle()  {
		startupPage stPage = new startupPage(driver);
		// compare the text from startupPage and compare if same pass the test if not fail the test
		Assert.assertEquals(stPage.getTitle().getText(), "Featured Courses");
		log.info("Hello");
		}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
}
