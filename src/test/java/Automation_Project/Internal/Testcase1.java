package Automation_Project.Internal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class Testcase1 {

	@org.testng.annotations.Test
	public void testContactUsLink() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.airnavradar.com/");
		driver.manage().window().maximize();
		Actions actions = new Actions(driver);
		By MenuLoc = By.xpath("/html/body/header/div/nav/ul/li[9]");
		By ContactusLoc =By.xpath("/html/body/header/div/nav/ul/li[9]/div[2]/ul/li[15]");
		WebElement aboutMenu = driver.findElement(MenuLoc);
		actions.moveToElement(aboutMenu).perform();
		driver.findElement(ContactusLoc).click();
		Assert.assertTrue(driver.getTitle().contains("Contact"));
		driver.quit();
	}

}	

