package webdriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
	
	private static WebDriver driver;
	private static String browserName;

	public static String getBrowserName() {
		return browserName;
	}

	public static void setBrowserName(String browserName) {
		Driver.browserName = browserName;
	}

	public static WebDriver get() {
		return driver;
	}
	
	public static void set(WebDriver driverInput) {
        driver = driverInput;
    }
	
	public static void init() throws MalformedURLException {
		WebDriver driverInput;
		switch(getBrowserName()){
		
        case "firefox": 
        	driverInput = new FirefoxDriver();
        	System.out.println("Browser is  " + browserName);
         	break;
         	
        case "chrome" :
        	System.setProperty("webdriver.chrome.driver", "d:\\chromedriver.exe");
        	driverInput = new ChromeDriver();
        	System.out.println("Browser is  " + browserName);
         	break;
 
        default:
            throw new AssertionError("Unsupported browser: " + browserName);
        }

        driverInput.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driverInput.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Driver.set(driverInput);
    }
	
    public static void tearDown() {
        Driver.get().quit();
    }

}
