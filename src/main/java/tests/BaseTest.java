package tests;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import webdriver.Driver;

public class BaseTest {
	
	 @BeforeMethod
	    public void init() throws MalformedURLException {
	        Driver.init();
	    }

	 @AfterMethod
	    public void cleanup() {
	        Driver.tearDown();
	    }

}
