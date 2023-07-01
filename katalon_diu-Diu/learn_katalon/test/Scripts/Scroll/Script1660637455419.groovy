import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.WebElement;

WebUI.openBrowser("https://demo.nopcommerce.com/")
WebUI.scrollToElement(findTestObject('Object Repository/scroll'), 10)
WebUI.delay(3)
WebUI.scrollToPosition(250, 250)
WebUI.delay(3)
// scroll to the bottom of page
WebUI.executeJavaScript("window.scrollTo(0, document.body.scrollHeight)", null)
WebUI.delay(3)
// scroll to the top of page
WebUI.executeJavaScript("window.scrollTo(document.body.scrollHeight, 0)", null)
WebUI.delay(3)

// dung webdriver 

//System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
//driver = new ChromeDriver();
//JavascriptExecutor js = (JavascriptExecutor) driver;
////Launch the application
//driver.get("http://demo.guru99.com/test/guru99home/");
////Find element by link text and store in variable "Element"
//WebElement Element = driver.findElement(By.linkText("Linux"));
////This will scroll the page till the element is found
//js.executeScript("arguments[0].scrollIntoView();", Element);
//WebUI.delay(3)
//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//WebUI.delay(3)
//js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
//WebUI.delay(3)
