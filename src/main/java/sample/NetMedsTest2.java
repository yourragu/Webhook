package sample;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.description.modifier.SynchronizationState;

public class NetMedsTest2 {

	public ChromeDriver driver;
	public JavascriptExecutor js;

	@Test
	public void itemMaster() throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.get("https://demo-rpos.netmeds.com/rpos/#/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("userName")).sendKeys("interview");
		driver.findElement(By.id("password")).sendKeys("Interview@rwos");
		driver.findElement(By.xpath("//span[text()='Sign In']")).click();
		try {
			if (driver.findElement(By.xpath("//*[text()='Confirm']")).isDisplayed()) {
				driver.findElement(By.xpath("//span[text()='Yes']")).click();
				System.out.println("User alredy logged in, continuing the flow");
			}
		} catch (Exception e) {
			System.out.println("logging in for first time");
		} finally {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@class='toggleMenu']")).click();
			driver.findElement(By.xpath("//a[text()='Retail Invoice']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//span[text()='Phone Order']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//*[@placeholder='Item Search...']/span/input)[1]")).sendKeys("100013");
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//*[@placeholder='Item Search...']/span/input)[1]"))
					.sendKeys(Keys.ARROW_DOWN);
			driver.findElement(By.xpath("(//*[@placeholder='Item Search...']/span/input)[1]")).sendKeys(Keys.TAB);
			Thread.sleep(3000);
			WebElement batchId = driver.findElement(By.xpath("//*[@name='batchId']/span/input"));
			js.executeScript("arguments[0].value='QWERTY';", batchId);
			driver.findElement(By.xpath("//*[@name='batchId']/span/input")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@name='batchId']/span/input")).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@name='batchId']/span/input")).sendKeys(Keys.TAB);
			driver.findElement(By.xpath("(//*[@name='number'])[1]")).click();
			driver.findElement(By.xpath("(//*[@name='number'])[1]")).sendKeys(Keys.DELETE);
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//*[@name='number'])[1]")).sendKeys("10");
			driver.findElement(By.xpath("(//*[@name='number'])[1]")).sendKeys(Keys.TAB);
			WebElement tenderCash = driver.findElement(By.xpath("//span[text()='Tender Cash']"));
			js.executeScript("arguments[0].click();", tenderCash);
			WebElement submit = driver.findElement(By.xpath("(//span[text()='Submit'])[1]"));
			js.executeScript("arguments[0].click();", submit);
			Thread.sleep(3000);
			String phone="9";
			  for(int i=1;i<=9;i++)
			  { 
			  phone = phone.concat(Integer.toString(randomNumber()));				  
			  }
			 System.out.println(phone);			  
			WebElement ph = driver.findElement(By.xpath("//input[@name='phoneNumber']"));
			ph.click();
			ph.sendKeys(phone);			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[text()='Search']")).click();
			Thread.sleep(5000);			
			driver.findElement(By.name("partyName")).sendKeys("TestUser");
			driver.findElement(By.name("partySecondaryName")).sendKeys("TestNedMedUser");
			driver.findElement(By.name("custEmail")).sendKeys("testuser@nedmeds.com");
			driver.findElement(By.xpath("(//div[contains(@class,'radiobutton')])[2]")).click();
			driver.findElement(By.name("firstName")).sendKeys("TestUser");
			driver.findElement(By.name("lastName")).sendKeys("TestUser");
			driver.findElement(By.name("addressLine1")).sendKeys("1855 Harmony Street");
			driver.findElement(By.name("addressLine2")).sendKeys("Sylvyan County");
			driver.findElement(By.name("city")).sendKeys("Chennai");
			driver.findElement(By.name("stateName")).sendKeys("TamilNadu");
			driver.findElement(By.name("pincode")).sendKeys("637062");	
			WebElement submit1 = driver.findElement(By.xpath("(//span[text()='Submit'])[1]"));
			js.executeScript("arguments[0].click();", submit1);
			driver.findElement(By.xpath("//span[text()='Use this Address']")).click();
			WebElement submit2 = driver.findElement(By.xpath("(//span[text()='Submit'])[1]"));
			js.executeScript("arguments[0].click();", submit2);			
			try {
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[text()='Close'])[2]")).click();
				System.out.println("Backdated transaction prompt is displayed");
				}
			catch(Exception e) {
				System.out.println("Backdated transaction prompt is not displayed");
			}
		}
		driver.close();
	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(9);
	}

}
