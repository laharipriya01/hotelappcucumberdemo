package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	WebElement uname;
	
	@FindAll({
		@FindBy(id="password"),
		@FindBy(name="password")
	})
	WebElement pass;
	
	@FindAll({
		@FindBy(id="login"),
		@FindBy(className="button"),
		@FindBy(name="login_button")
	})
	WebElement loginb;
	public void enterUname(String user) {
		uname.sendKeys(user);
	}
	public void enterPass(String pwd) {
		pass.sendKeys(pwd);
	}
	public void clickLoginb() {
		loginb.click();
	}
}
