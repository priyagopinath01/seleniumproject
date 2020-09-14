package com.baseclass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.utils.LoadProperties;

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver getBrowser(String browserName) throws Exception {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resource\\com\\driver\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			return driver;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}

	}

	public static void getUrl(String Url) throws Exception {
		// LoadProp lp = new LoadProp();
		driver.get(Url);

	}

	public static String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static void waitForVisibiityofElelement(WebElement element) {
		WebDriverWait wb = new WebDriverWait(driver, 40);
		wb.until(ExpectedConditions.visibilityOf(element));
	}

	public static void sendkeys(WebElement element, String value) {
		waitForVisibiityofElelement(element);
		boolean displayed = element.isDisplayed();
		boolean enabled = element.isEnabled();
		if (displayed && enabled) {
			element.clear();
			element.sendKeys(value);
		}
	}

	public static void clickOnElement(WebElement element) {
		waitForVisibiityofElelement(element);
		boolean displayed = element.isDisplayed();
		if (displayed) {
			element.click();
		}
	}

	public static void screenShot(String filename) throws IOException {
		File src = new File(System.getProperty("user.dir") + "//screenshot//" + filename + ".png");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(temp, src);
	}

	public static byte[] screenShot_bytes() throws Exception {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
			return screenshotAs;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}

	}

	public static void scrollUsingElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public static void actions(WebElement element, String option) {
		Actions ac = new Actions(driver);
		if (option.equalsIgnoreCase("mousehover")) {
			ac.moveToElement(element).build().perform();
		} else if (option.equalsIgnoreCase("rightclick")) {
			ac.contextClick(element).build().perform();
		}
	}

	public static void dropdown(WebElement element, String option, String value) {
		Select sc = new Select(element);
		if (option.equalsIgnoreCase("value")) {
			sc.selectByValue(value);
		} else if (option.equalsIgnoreCase("index")) {
			int index = Integer.parseInt(value);
			sc.selectByIndex(index);
		} else {
			sc.selectByVisibleText(value);
		}

	}

	public static void SwitchToWindow() {
		String handle = driver.getWindowHandle();
		driver.switchTo().window(handle);
	}

	public static void alert() {
		WebDriverWait wb = new WebDriverWait(driver, 40);
		wb.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert();
	}

	public static boolean elementIsDisplayed(WebElement element) {
		boolean b = element.isDisplayed();
		return b;
	}

	public static void highlightWebElement_green(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid green'", element);
	}

	public static void highlightWebElement_red(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

}
