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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

import org.openqa.selenium.Keys as Keys

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import com.kms.katalon.core.webui.driver.DriverFactory

//driver1= WebUI.openBrowser("https://www.youtube.com/watch?v=D2vNeCuaA0U")
//driver2= WebUI.openBrowser("https://docs.katalon.com/")

//WebDriver driver= DriverFactory.getWebDriver()

System.setProperty("webdriver.gecko.driver", "D:\\WebDriver\\geckodriver.exe")
WebDriver driver1 = new FirefoxDriver()
//WebDriver driver2 = new FirefoxDriver()

System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe")
WebDriver driver2 = new ChromeDriver()

DriverFactory.changeWebDriver(driver1)
WebUI.navigateToUrl("https://www.youtube.com/watch?v=D2vNeCuaA0U")
println(WebUI.getWindowTitle())

DriverFactory.changeWebDriver(driver2)
WebUI.navigateToUrl("https://docs.katalon.com/")
println(WebUI.getWindowTitle())

DriverFactory.changeWebDriver(driver1)
println(WebUI.getUrl())

//driver1.close()
driver2.quit()
