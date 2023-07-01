import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.github.kklisura.cdt.protocol.types.page.HandleFileChooserAction
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

//WebUI.openBrowser("https://demoqa.com/alerts")

// get text alert
//WebUI.click(findTestObject('Object Repository/alert/alertButton'))
//String text = WebUI.getText(findTestObject('Object Repository/alert/Text'))
//println(text)
//WebUI.acceptAlert()

// accept alert liên tục khi có arlert hiển thị liên tục trong vòng 6 giây
//WebUI.click(findTestObject('Object Repository/alert/alertButton'))
//while(true) {
//elementPresent=WebUI.waitForAlert(6)
//boolean present = WebUI.verifyAlertPresent(4, FailureHandling.CONTINUE_ON_FAILURE)
//if (elementPresent==true) {
//	WebUI.acceptAlert()
//	elementPresent=WebUI.waitForAlert(6)
//} else {
//	break
//	}
//}

WebUI.openBrowser("https://demoqa.com/alerts")
CustomKeywords.'exception.example.acceptAlert'()




//WebUI.click(findTestObject('Object Repository/alert/confirmButton'))
////WebUI.acceptAlert()
//WebUI.dismissAlert()

// handle alert
//WebUI.click(findTestObject('Object Repository/alert/promtButton'))
//WebDriver driver = DriverFactory.getWebDriver()
//
//String text1 = WebUI.getAlertText()
//WebUI.verifyEqual(text1, 'Please enter your name')
//
//driver.switchTo().alert().sendKeys('Huyen')
//driver.switchTo().alert().accept()
//WebUI.delay(5) 