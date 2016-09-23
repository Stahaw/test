package testingFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class TestBase {
	public WebDriver driver = null;
	@Test
	public void Testing1() throws IOException{
		Properties pop = new Properties();
		FileInputStream fis=new  FileInputStream("C:\\ABTO\\ECLIPSE\\Automation\\Framework\\src\\testingFiles\\datadrive.properties");
		pop.load(fis);
//		System.out.println(pop.getProperty("username"));
//		System.out.println(pop.getProperty("password"));
//		System.out.println(pop.getProperty("url"));
		if(pop.getProperty("browser").contains("firefox")){
			driver = new FirefoxDriver();
		}
		else if(pop.getProperty("browser").contains("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\ABTO\\ECLIPSE\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();	
		}
		else{
			driver = new InternetExplorerDriver();
		}
		driver.get(pop.getProperty("url"));
			
	
	}

}
