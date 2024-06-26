package baseLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LauchChrome 
{
	String path="C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\automation_Testing\\\\NewChromeDriver\\\\latestchromedriver.exe";
	public static WebDriver driver=null;
	@Test
public void lauchBrowserURL()
{
	System.setProperty("webdriver.driver.chrome", path);
	driver = new ChromeDriver();
	driver.get("https://testingbaba.com/old/index.html");
	driver.manage().window().maximize();
}
}
