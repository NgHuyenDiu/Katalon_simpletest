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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import org.openqa.selenium.Rectangle as Rectangle

WebUI.openBrowser("https://demo.nopcommerce.com/")
// luu vao report folder
//WebUI.takeElementScreenshot(RunConfiguration.getReportFolder() + '/logo.png',findTestObject('Object Repository/ScreenShot/logo'))
// luu folder
//WebUI.takeElementScreenshot('D:\\screenShot\\logo.png',findTestObject('Object Repository/ScreenShot/logo'))
// chụp toàn màn hình loại trừ phần tử logo
//WebUI.takeFullPageScreenshot('D:\\screenShot\\fullpage_ingoreLogo.png',[findTestObject('Object Repository/ScreenShot/logo')] )
//WebUI.takeFullPageScreenshot('D:\\screenShot\\fullpage.png')
//WebUI.takeAreaScreenshot('D:\\screenShot\\AreaScreenshot.png', new Rectangle(250, 225, 150, 100))
//def timestamp = new Date().format("YYYYMMdd_HHmmss")
//WebUI.takeScreenshot('D:\\screenShot\\Screenshot.png',["text" : timestamp])

// screen shot and scroll web page
int x = 550
int y = 550
while(true) {
	def timestamp = new Date().format("YYYYMMdd_HHmmss")
	WebUI.takeScreenshot('D:\\screenShot\\Scroll'+timestamp+'.png')
	WebUI.delay(6)
	WebUI.scrollToPosition(x, y)
	x += 550
	y += 550
	if(WebUI.getPageHeight() < y) {
		break
	}
	
}