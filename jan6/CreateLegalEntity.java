package jan6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLegalEntity {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//enter the url
		driver.get("https://login.salesforce.com/");
		//Enter the username and password
		driver.findElement(By.id("username")).sendKeys("earth@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Bootcamp@123");
		//click the login button
		driver.findElement(By.id("Login")).click();
		//click the toggle button
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//click the view all button
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//click the legal entities
		Thread.sleep(10000);
		WebElement legal = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		driver.executeScript("arguments[0].click();", legal);
		//click the dropdown of legal entity
		Thread.sleep(5000);
		WebElement dropdown = driver.findElement(By.xpath("//span[contains(text(),'Legal Entities Menu')]"));
		driver.executeScript("arguments[0].click();", dropdown);
		//click the new legal entity
		WebElement newlegal = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
		driver.executeScript("arguments[0].click();", newlegal);
		//enter the name
		driver.findElement(By.xpath("(//label[@class='label inputLabel uiLabel-left form-element__label uiLabel']/following::input)[1]")).sendKeys("Salesforce Automation by Pradeepkumar");
		//click the save
		Thread.sleep(2000);
		WebElement save = driver.findElement(By.xpath("(//span[text()='Save'])[2]"));
		driver.executeScript("arguments[0].click();", save);
		Thread.sleep(2000);
		driver.executeScript("arguments[0].click();", save);

		//verify the name
		String text = driver.findElement(By.xpath("(//span[@class='uiOutputText'])[1]")).getText();
		if(text.equalsIgnoreCase("salesforce")) {
			System.out.println("verified");
		}
		else {
			System.out.println("others");
		}
	}

}
