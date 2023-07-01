package upload_box_tma

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.WebElement

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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Upload {
	@Keyword
	public void cancel() {
		try {
			WebElement conflig = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/upload_download/dialog'), 10)
			if(conflig != null) {
				WebUI.click(findTestObject('Object Repository/upload_download/cancel'))
			}
		}catch(WebElementNotFoundException e) {
			println("Not visibility")
		}
	}

	@Keyword
	public void addNew() {
		try {
			WebElement conflig = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/upload_download/add_New'), 10)
			if(conflig != null) {
				WebUI.click(findTestObject('Object Repository/upload_download/add_New'))
				WebUI.click(findTestObject('Object Repository/upload_download/continue'))
			}
		}catch(WebElementNotFoundException e) {
			println("Not visibility")
		}
	}

	@Keyword
	public void verifyUpload(String filename) {
		if (WebUI.verifyElementPresent(findTestObject('Object Repository/upload_download/verify_upload', [('file') : filename]), 10) ==
		true) {
			println('Upload success')
		} else {
			println('Upload fail')
		}
	}
}
