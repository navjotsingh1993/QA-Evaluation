package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public WebDriver driver;
	public Properties prop;

	
	public WebDriver initializeDriver() throws IOException

	{

		// Create object of Properties class to access data available
		prop = new Properties();
		// Specify the path of property file
		FileInputStream fis = new FileInputStream(
				"C:\\Navjot\\Navjot\\src\\main\\java\\resources\\data.properties");
		// send reference of file path to prop for loading data from properties file
		prop.load(fis);
		// save value of browser in a variable
		String browserName = prop.getProperty("browser"); // save value of browser in a variable

		if (browserName.equals("chrome")) {
			// execute chrome driver
			System.setProperty("webdriver.chrome.driver", "C://Users//navjot.gahir//Documents//chromedriver.exe");  
			driver = new ChromeDriver();

		}

		else if (browserName.equals("firefox")) {
			// execute firefox driver
			driver = new FirefoxDriver();
		}

		else if (browserName.equals("IE")) {

		}

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}

	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;  //casting webdriver type driver to takescreenshot
		File source =ts.getScreenshotAs(OutputType.FILE);   //produce screenshot as an File
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";  // WHere to store the screenshot in system
		FileUtils.copyFile(source,new File(destinationFile));   //
		return destinationFile;


	}
}
