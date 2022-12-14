package com.stepDefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class TestSteps {
	static LoginPage loginp;
	public static WebDriver driver;
	public String expectedOp="Hello vasuvespag!";
	@Given("user is on HotelApp homepage")
	public void user_is_on_hotel_app_homepage() {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://adactinhotelapp.com");
		driver.manage().window().maximize();
		System.out.println("user on homepage");
	}

	@When("user enters username")
	public void user_enters_username() {
	    // Write code here that turns the phrase above into concrete actions
		/*WebElement uname=driver.findElement(By.id("username"));
		uname.clear();
		uname.sendKeys("vasuvespag");*/
		loginp=new LoginPage(driver);
		loginp.enterUname("vasuvespag");
		System.out.println("user enters username");
	}

	@When("user enters password")
	public void user_enters_password() {
	    // Write code here that turns the phrase above into concrete actions
		/*driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("vasu1234");*/
		loginp.enterPass("vasu1234");
		System.out.println("enters password");
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.className("login_button")).click();
	}

	@Then("login is successful")
	public void login_is_successful() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement greeting=driver.findElement(By.name("username_show"));
		String actualOp=greeting.getAttribute("value");
		Assert.assertEquals(expectedOp, actualOp);
	}
	@When("user selects location from dropdown")
	public void user_selects_location_from_dropdown() {
	    // Write code here that turns the phrase above into concrete actions
		new Select(driver.findElement(By.cssSelector("#location"))).selectByIndex(8);
	}

	@When("user clicks on search button")
	public void user_clicks_on_search_button() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.className("reg_button")).click();
	}

	@Then("list of hotels is displayed")
	public void list_of_hotels_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		String expectedTitle="Adactin.com - Select Hotel";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	@When("user selects radio button")
	public void user_selects_radio_button() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"radiobutton_4\"]")).click();

	}

	@When("user clicks on continue button")
	public void user_clicks_on_continue_button() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
	}

	@Then("book a hotel is displayed")
	public void book_a_hotel_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		String expectedTitle="Adactin.com - Book A Hotel";
		String actualTitle=driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	@When("user enters username {string}")
	public void user_enters_username(String string) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement uname=driver.findElement(By.id("username"));
		uname.clear();
		uname.sendKeys(string);
	}

	@When("user enters password {string}")
	public void user_enters_password(String string) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(string);
	}
	@When("user enters username as <{string}>")
	public void user_enters_username_as(String string) {
		 WebElement uname=driver.findElement(By.id("username"));
		uname.clear();
		uname.sendKeys(string);
	}

	@When("user enters password as <{string}>")
	public void user_enters_password_as(String string) {
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(string);
	}
	@When("user enters username and password")
	public void user_enters_username_and_password(io.cucumber.datatable.DataTable userCredentials) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    /*List<List<String>> data=userCredentials.asLists(String.class);
	    String username=data.get(0).get(0);
	    String password=data.get(0).get(1);
	    WebElement uname=driver.findElement(By.id("username"));
		uname.clear();
		uname.sendKeys(username);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);*/
		List<Map<String, String>> data=userCredentials.asMaps(String.class,String.class);
		for(Map<String,String> data1:data) {
			String username=data1.get("username");
			WebElement uname=driver.findElement(By.id("username"));
			uname.clear();
			uname.sendKeys(username);
			String password=data1.get("password");
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys(password);
		}
	}
	


}
