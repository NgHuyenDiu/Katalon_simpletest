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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver as Keys
import org.openqa.selenium.WebDriver

WebUI.openBrowser("https://demoqa.com/alerts")
// open 4 tab
for (int i in 1..4 ) {
	WebUI.executeJavaScript('window.open();', [])
	curent_window = WebUI.getWindowIndex()
	// go in to new tab
	next_window = curent_window + 1
	WebUI.switchToWindowIndex(next_window)
	WebUI.navigateToUrl("https://demoqa.com/nestedframes")
	
}
WebUI.switchToWindowTitle("ToolsQA")

WebDriver driver = DriverFactory.getWebDriver()
int count_tab = driver.getWindowHandles().size()
WebUI.switchToWindowIndex(count_tab - 2)

// back 
//WebUI.switchToWindowIndex(curent_window)
WebUI.delay(10)
  
