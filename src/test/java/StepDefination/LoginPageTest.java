package StepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest {
	WebDriver driver;
	@Given("user is on login page")
	public void user_is_on_login_page() {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@When("User enter valid username and valid password")
	public void user_enter_valid_username_and_valid_password() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	    }

	@Then("user will be home page")
	public void user_will_be_home_page() {
		System.out.println(driver.getTitle());
	}
}
