package sample;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetMedsTest1 {

	public ChromeDriver driver;

	@Test
	public void itemMaster() throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		//Properties props = new Properties(); 
		//props.load(NetMedsTest1.class.getClassLoader().getResourceAsStream("ReadDriver.properties"));
		//String path = props.getProperty("path");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		/*
		 * FileInputStream file = new
		 * FileInputStream(".\\src\\main\\resources\\config.properties"); Properties
		 * prop = new Properties(); prop.load(file);
		 */
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.get("https://demo-rpos.netmeds.com/rpos/#/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("userName")).sendKeys("interview");
		driver.findElement(By.id("password")).sendKeys("Interview@rwos");
		driver.findElement(By.xpath("//span[text()='Sign In']")).click();
		try {
			   driver.findElement(By.xpath("//*[text()='Confirm']")).isDisplayed(); 
				driver.findElement(By.xpath("//span[text()='Yes']")).click();
				System.out.println("User alredy logged in, continuing the flow");
			}
			catch(Exception e) {
				System.out.println("logging in for first time");
			}
		finally {
				WebElement toggleMenu = driver.findElement(By.xpath("//a[@class='toggleMenu']"));
				Thread.sleep(2000);
				toggleMenu.click();
				driver.findElement(By.xpath("//a[text()='Item Master']")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("orderSearch")).sendKeys("100014");
				driver.close();
			}
	

	}

}
