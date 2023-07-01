package download_box_tma

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
public class Download {
	@Keyword
	public WebDriver changeDefaultDownloadFolder(String path) {

		// download file
		ChromeOptions option = new ChromeOptions()

		// change default download folder
		String downloadFilePath = path

		def prefs = [:]

		prefs.put('download.default_directory', downloadFilePath)

		option.setExperimentalOption('prefs', prefs)

		WebDriver driver = new ChromeDriver(option)
		return driver
	}
	@Keyword
	public void download_file_boxtma(String filename) {
		WebUI.click(findTestObject('Object Repository/upload_download/icon_More', [('file') : filename]))

		try {
			WebUI.waitForElementVisible(findTestObject('Object Repository/upload_download/popup_menu'), 10)
		}
		catch (StepFailedException e) {
			println('element not visible')
		}

		WebUI.click(findTestObject('Object Repository/upload_download/download'))
	}
}
