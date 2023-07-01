import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.main.CustomKeywordDelegatingMetaClass
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import groovy.json.internal.Exceptions as Exceptions
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebDriver as Keys
import org.openqa.selenium.WebDriver.Options as Options
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import org.openqa.selenium.support.ui.ExpectedConditions as ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait as WebDriverWait
import org.testng.Assert as Assert

WebUI.openBrowser('https://box.tma.com.vn/index.php/login')

// login
CustomKeywords.'login_box_tma.login.Login'('nthdiu', 'Huyendiu99@')

WebUI.waitForPageLoad(10)

// check free space 
free_space = WebUI.getAttribute(findTestObject('Object Repository/upload_download/free_space'), 'value')

println(free_space)

while (free_space == 0) {
    WebUI.delay(1)

    free_space = WebUI.getAttribute(findTestObject('Object Repository/upload_download/free_space'), 'value')
}

// upload
WebUI.uploadFile(findTestObject('Object Repository/upload_download/input_file'), 'D:\\katalon_basic\\upload_demo\\add_new.txt')
// nếu tồn tại rồi bỏ qua
//CustomKeywords.'upload_box_tma.Upload.cancel'()

// replace new file
CustomKeywords.'upload_box_tma.Upload.addNew'()
// kiểm tra trên box có file chưa
CustomKeywords.'upload_box_tma.Upload.verifyUpload'('add_new.txt')
WebUI.delay(5)