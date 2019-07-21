package ass1;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Weblaunch {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.adactin.com/HotelApp/index.php");
		
		WebElement user= driver.findElement(By.id("username"));
		user.sendKeys("nithumohan");
		driver.findElement(By.id("password")).sendKeys("nithu24");
	
		driver.findElement(By.id("login")).click();
		String logmsg=driver.findElement(By.id("username_show")).getAttribute("Value");		
		if(logmsg.equals("Hello nithumohan!")) {
	}else {
			System.out.println("Login Failed");		
		}		
				
		WebElement checkout = driver.findElement(By.id("datepick_out"));
		checkout.clear();
		checkout.sendKeys("20/08/2019");
		WebElement single = driver.findElement(By.name("location"));
		Select op1 = new Select (single);
		op1.selectByIndex(1);
		
		WebElement select1 = op1.getFirstSelectedOption();
		String select1text =select1.getText();
		System.out.println("The selected value :" +select1text);
					
		List<WebElement> alloptions = op1.getOptions();
		for (WebElement a1 : alloptions){
			System.out.println( a1.getText() );
		}	
		
		driver.findElement(By.id("Submit")).click();
		
		WebElement single1 = driver.findElement(By.name("radiobutton_1"));
		single1.click();
		driver.findElement(By.id("continue")).click();
		WebElement name= driver.findElement(By.id("first_name"));
		name.sendKeys("Nithya");
		driver.findElement(By.id("last_name")).sendKeys("Mohan");
		driver.findElement(By.id("address")).sendKeys("Tambaram");
		driver.findElement(By.id("cc_num")).sendKeys("1234567891011134");
		WebElement Cardtype = driver.findElement(By.name("cc_type"));
		Select typ1 = new Select (Cardtype);
		typ1.selectByIndex(1);
		WebElement Date = driver.findElement(By.name("cc_exp_month"));
		Select typ2 = new Select(Date);
		typ2.selectByIndex(1);
		WebElement Date2 = driver.findElement(By.name("cc_exp_year"));
		Select typ3 = new Select(Date2);
		typ3.selectByIndex(10);
		driver.findElement(By.id("cc_cvv")).sendKeys("123");
		WebElement booknow = driver.findElement(By.name("book_now"));
		booknow.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("order_no")));
		String orderno = driver.findElement(By.id("order_no")).getAttribute("value");
		System.out.println("The order no"+orderno);
		WebElement itinerary = driver.findElement(By.name("my_itinerary"));
		itinerary.click();		
		WebElement cancel = driver.findElement(By.xpath("//*[@id=\"booked_form\"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]/input"));
		cancel.click();
		WebElement cancel2=driver.findElement(By.xpath("//*[@id=\"booked_form\"]/table/tbody/tr[3]/td/input[1]"));
		cancel2.click();
		Alert ordercancel=driver.switchTo().alert();
		ordercancel.accept();	
			 String handle=driver.getWindowHandle();
	 System.out.println(handle);
	 Set<String> handle1=driver.getWindowHandles();
	 System.out.println(handle1);
	 driver.switchTo().window("www.toolsqa.com/selenium-webdriver/switch-commands/");
			}
		
	 
	 
	}

	 	
	


