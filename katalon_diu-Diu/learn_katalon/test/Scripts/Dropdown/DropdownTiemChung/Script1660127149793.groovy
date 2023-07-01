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
import org.openqa.selenium.WebElement

WebUI.openBrowser("https://tiemchungcovid19.gov.vn/portal/register-person")
WebUI.maximizeWindow()
WebUI.scrollToElement(findTestObject("Object Repository/dropdown/dropdown_Tiemchung/dan_Toc"), 10)
WebUI.click(findTestObject("Object Repository/dropdown/dropdown_Tiemchung/input_Provider"))

//WebUI.click(findTestObject("Object Repository/dropdown/dropdown_Tiemchung/provider", [('provider'):'Tỉnh Điện Biên']))


List<WebElement> listProvider = WebUI.findWebElements(findTestObject("Object Repository/dropdown/dropdown_Tiemchung/list_Provider"), 10)
for(WebElement provider in listProvider) {
	text = provider.getText()
	println(text)
	if(text.equals('Tỉnh Sơn La')) {
		WebUI.click(findTestObject("Object Repository/dropdown/dropdown_Tiemchung/provider", [('provider'):'Tỉnh Sơn La']))
		break
	}
}

WebUI.delay(5)
WebUI.closeBrowser()
