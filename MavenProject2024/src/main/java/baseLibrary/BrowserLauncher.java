package baseLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLauncher 
{
	@Test
	public void launchBrowser()
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		WebDriverManager.safaridriver();
		WebDriverManager.firefoxdriver();
		WebDriverManager.operadriver();
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver1 = new ChromeDriver();
		driver.get("https://testingbaba.com/old/index.html");
		//driver1.get("https://testingbaba.com/old/index.html");
		driver.manage().window().maximize();
		//driver1.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='×']")).click();
		//driver1.findElement(By.xpath("//button[text()='×']")).click();
		driver.findElement(By.xpath("//a[text()='Practice']")).click();
	}
}
