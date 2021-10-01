package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Google {
	public static String sheetName = "sheet1";
	public ChromeDriver driver;
	
	
	@Test(dataProvider="readValues")
	public void websiteGoogle(String text1,String text2) throws IOException, InterruptedException
	{
		WebDriverManager.chromedriver().setup();		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		//options.addArguments("--headless");
		options.addArguments("--disable-extensions");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-popup-blocking");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);		
		FileInputStream file = new FileInputStream(".\\src\\main\\resources\\config.properties");
		Properties prop = new Properties();
		prop.load(file);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.get("https://google.com/");
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);		
		takeSnapshot();
		//driver.findElement(By.name("q")).sendKeys(prop.getProperty("searchtext"));
		driver.findElement(By.name("q")).sendKeys(text1);
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys(text2);
		driver.findElement(By.name("q")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("(//input[@name='btnK'])[2]")).click();
		takeAshotSnap();
		Thread.sleep(3000);		
		System.out.println("Execution completed, Browser is ready for closure having class name :"+this.getClass().getName());
		driver.close();
	}
	
	@DataProvider(name = "readValues")
	public String[][] sendData() throws IOException {
		return utils.ReadExcel.readData("./src/main/resources/testdata/testFile.xlsx", sheetName);

	}
	
	public void takeSnapshot() throws IOException
	{
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\FullStackAutomation_Exercise\\Test\\ScreenShot\\google.png");
		FileUtils.copyFile(src, dest);
	}
	
	public void takeAshotSnap() throws IOException
	{
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        try {
            ImageIO.write(screenshot.getImage(),"PNG",new File("D:\\FullStackAutomation_Exercise\\Test\\ScreenShot\\google"+".bmp"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}


}
