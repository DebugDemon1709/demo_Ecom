package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	WebDriver driver;
	WebDriverWait wait;
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[routerlink='/dashboard/cart']")
	WebElement cartHeader;
	@FindBy(css = "[routerlink='/dashboard/myorders']")
	WebElement orderHeader;
	
	public void waitForElementToAppear(By findBy) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement findEle) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findEle));
	}
	
	public CartPage goToCartPage() {
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	public OrdersPage goToOrdersPage() {
		orderHeader.click();
		OrdersPage ordersPage = new OrdersPage(driver);
		return ordersPage;
	}
	
	public void waitForElementToDisappear(WebElement ele) {
		//Thread.sleep(1000);  Or
		wait.until(ExpectedConditions.invisibilityOf(ele));	
	}
}
