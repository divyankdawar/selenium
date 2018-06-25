	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	
	public class tatoc {
	
		public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver",
					"G:\\selenium\\SeleniumTest\\exefiles\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			Actions action = new Actions(driver);
	
			driver.get("http://10.0.1.86/tatoc");
			driver.manage().window().maximize();
			driver.findElement(By.linkText("Basic Course")).click();
			driver.findElement(By.className("greenbox")).click();
	
			boolean found=false;
			driver.switchTo().frame("main");
			//for (int i = 0; i < 10; i++) {
			while(found==false){	
				WebElement box1 = driver.findElement(By
						.xpath("//div[@id='answer'and contains(.,'Box 1')]"));
				String box1Class = box1.getAttribute("className");
				
				driver.switchTo().frame("child");
				
				WebElement box2 = driver.findElement(By
						.xpath("//div[@id='answer' and contains(.,'Box 2')]"));
				String box2Class = box2.getAttribute("className");
				
				if (box1Class.equalsIgnoreCase(box2Class)) {
					//driver.switchTo().defaultContent();
					driver.switchTo().parentFrame();
					driver.findElement(By.linkText("Proceed")).click();
					found=true;
					break;
				
				} else {
					driver.switchTo().parentFrame();
					//driver.switchTo().defaultContent();
					driver.findElement(By.linkText("Repaint Box 2")).click();
	
				}
			}
	
			WebElement drag = driver.findElement(By.id("dragbox"));
			WebElement drop = driver.findElement(By.id("dropbox"));
			action.dragAndDrop(drag, drop).perform();
			driver.findElement(By.linkText("Proceed")).click();
			driver.findElement(By.linkText("Launch Popup Window")).click();
			driver.findElement(By.id("name")).click();
			WebElement searchBox = driver.findElement(By.id("name"));
			searchBox.sendKeys("divyankdawar");
			
			WebElement submitButton = driver.findElement(By.id("submit"));
			submitButton.click();
			
			
			driver.findElement(By.linkText("Launch Popup Window")).click();
			String MainWindow = driver.getWindowHandle();
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> it = windows.iterator();
			while(it.hasNext())
			{
				
				String ChildWindow = it.next();	
				driver.switchTo().window(ChildWindow);	
				if(!MainWindow.equalsIgnoreCase(ChildWindow))	
				{                                                                                                  
		           		driver.findElement(By.id("name")).sendKeys("DIVYANK DAWAR");
		            		driver.findElement(By.id("submit")).click();
		            		break;
				}
			}
			driver.switchTo().window(MainWindow);
			driver.findElement(By.linkText("Proceed")).click();
			
			
			driver.findElement(By.linkText("Generate Token")).click();
			String Cookie_val = driver.findElement(By.id("token")).getText();
			Cookie cookie = new Cookie("Token", Cookie_val.substring(7));
			driver.manage().addCookie(cookie);
			driver.findElement(By.linkText("Proceed")).click();
			
	
		}
	
	}
