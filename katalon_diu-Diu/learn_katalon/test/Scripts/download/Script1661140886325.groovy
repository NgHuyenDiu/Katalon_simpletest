import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.exception.StepFailedException as StepFailedException
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import org.openqa.selenium.chrome.ChromeOptions as Keys

// check file exist
String filePath = 'D:\\katalon_basic\\learn\\download_demo\\demo.txt'

File file = new File(filePath)

if (file.exists()) {
    file.delete()
}

// download file
ChromeOptions option = new ChromeOptions()

// change default download folder
String downloadFilePath = 'D:\\katalon_basic\\learn\\download_demo'

prefs = [:]

prefs.put('download.default_directory', downloadFilePath)

option.setExperimentalOption('prefs', prefs)

WebDriver driver = new ChromeDriver(option)

// change driver
DriverFactory.changeWebDriver(driver)

driver.get('https://box.tma.com.vn/index.php/login')

WebUI.setText(findTestObject('Object Repository/upload_download/username'), 'nthdiu')

WebUI.setText(findTestObject('Object Repository/upload_download/password'), 'Huyendiu99@')

WebUI.click(findTestObject('Object Repository/upload_download/btn_submit'))

WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('Object Repository/upload_download/icon_More', [('file') : 'demo']))

try {
    WebUI.waitForElementVisible(findTestObject('Object Repository/upload_download/popup_menu'), 10)
}
catch (StepFailedException e) {
    println('element not visible')
} 

WebUI.click(findTestObject('Object Repository/upload_download/download'))

WebUI.delay(10)

if (file.exists()) {
    println('Download success')
}