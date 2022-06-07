package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class CreateEvent {

	AppiumDriver driver;
	@BeforeTest
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "AhmedEmulator2");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, " eu.parent.android.app");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "eu.parent.android.app.main.presentation.MainActivity");
		driver = new AndroidDriver(new URL ("http://localhost:4723/wd/hub"),caps);
	}
	@Test
	public void createEvent() {
		WebElement permission = driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));
		permission.click();
		WebElement email =driver.findElement(By.id("eu.parent.android.app:id/email_edit_text"));
		email.sendKeys("democompany@parent.eu");
		WebElement pass=  driver.findElement(By.id("eu.parent.android.app:id/password_edit_text"));
		pass.sendKeys("P@rent12345678");
		WebElement loginBtn = driver.findElement(By.id("eu.parent.android.app:id/login_button"));
		loginBtn.click();
		WebElement class0= driver.findElement(By.id("eu.parent.android.app:id/container"));
		class0.click();
		WebElement calendar = driver.findElement(MobileBy.AccessibilityId("Kalender"));
		calendar.click();
		WebElement addBtn = driver.findElement(By.id("eu.parent.android.app:id/add_button"));
		addBtn.click();
		WebElement event= driver.findElement(By.id("eu.parent.android.app:id/label"));
		event.click();
		WebElement addPic= driver.findElement(By.id("eu.parent.android.app:id/day_item_layout"));
		addPic.click();
		WebElement galariesPic= driver.findElement(By.id("eu.parent.android.app:id/title"));
		galariesPic.click();
		WebElement picture = driver.findElement(By.id("com.google.android.documentsui:id/icon_thumb"));
		picture.click();
		WebElement eventTitle = driver.findElement(By.id("eu.parent.android.app:id/event_title_edit_text"));
		eventTitle.sendKeys("party");
		WebElement eventdesc = driver.findElement(By.id("eu.parent.android.app:id/event_desc_edit_text"));
		eventdesc.sendKeys("party");
		WebElement sendToList = driver.findElement(By.id("eu.parent.android.app:id/recipients_view"));
		Select select = new Select(sendToList);
		select.selectByIndex(0);
		WebElement date= driver.findElement(By.id("eu.parent.android.app:id/event_date_edit_text"));
		date.click();
		WebElement eventDay= driver.findElement(MobileBy.AccessibilityId("05 June 2022"));
		eventDay.click();
		WebElement confirmDate= driver.findElement(By.id("eu.parent.android.app:id/mdtp_ok"));
		confirmDate.click();
		WebElement eventTime = driver.findElement(By.id("eu.parent.android.app:id/day_name_text_view"));
		eventTime.click();
		driver.findElement(By.id("eu.parent.android.app:id/mdtp_hours"));
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
