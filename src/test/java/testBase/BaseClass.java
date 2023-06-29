package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	
	@BeforeClass(groups= {"Regression","Sanity","Master"})
	@Parameters("browser")
	public void setup(String br)
	{
		rb=rb.getBundle("config");
	logger=LogManager.getLogger(this.getClass());
	
	if(br.equals("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(br.equals("edge"))
	{
		driver=new EdgeDriver();
	}
	else
	{
		driver= new FirefoxDriver();
	}
	    driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("AppURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Regression","Sanity","Master"})
	public void teardown()
	{
		driver.quit();
	}
	
	public String RandomStringGenerator()
	{
		String Generatedstring=RandomStringUtils.randomAlphabetic(5);
		return (Generatedstring);
	}
	public String RandomNumber()
	{
	String generatednumber = RandomStringUtils.randomNumeric(10);
	return (generatednumber);
	}
	public String randomAlpha(){
		String str=RandomStringUtils.randomAlphabetic(4);
		String num=RandomStringUtils.randomNumeric(3);
		return(str+"@"+num);
	}
	public String captureScreen(String tname) throws IOException
	{
		SimpleDateFormat df=new SimpleDateFormat("yyyymmddhhmmss");
		Date dt=new Date();
		String timestamp=df.format(dt);
		
		TakesScreenshot takesscreenshot=(TakesScreenshot)driver;
		File Source=takesscreenshot.getScreenshotAs(OutputType.FILE);
		String Destination= System.getProperty("user.dir")+ "\\screenshots\\"+ tname + "_" + timestamp + ".png";
		try {
		FileUtils.copyFile(Source, new File(Destination));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return Destination;
	}
	
	}


