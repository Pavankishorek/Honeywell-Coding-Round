package Automation_Project.Internal;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Testcase2 {
	public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.airnavradar.com/");
        Actions actions = new Actions(driver);
        List<WebElement> topMenus = driver.findElements(By.cssSelector("nav ul li"));
        for (WebElement menu : topMenus) {
            actions.moveToElement(menu).perform();
            Thread.sleep(500); 
            List<WebElement> allLinks = menu.findElements(By.cssSelector("a[href]"));
            for (WebElement link : allLinks) {
                String href = link.getAttribute("href");
                if (href != null && !href.trim().isEmpty()) {
                    System.out.println("Checking link: " + href);
                    boolean isValid = isLinkWorking(href);
                    if (isValid) {
                        System.out.println("Link is valid");
                    } else {
                        System.out.println("link is not valid");
                    }
                }
            }
        }

        driver.quit();
    }
    public static boolean isLinkWorking(String url) throws Exception {
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod("HEAD");
        conn.setConnectTimeout(3000);
        conn.connect();
        int status = conn.getResponseCode();
        return status < 400;
    }
}
