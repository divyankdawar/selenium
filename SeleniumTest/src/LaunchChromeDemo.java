import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LaunchChromeDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "G:\\selenium\\SeleniumTest\\exefiles\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Test selenium");
	    
		WebElement submitButton = driver.findElement(By.name("btnK"));
		submitButton.click();
		
		driver.quit();
		
	}

}
