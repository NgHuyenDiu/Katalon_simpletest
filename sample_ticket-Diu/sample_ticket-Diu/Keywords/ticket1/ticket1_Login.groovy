package ticket1

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class ticket1_Login {
	@Keyword
	public void login_astandard_user() {
		WebUI.openBrowser(' https://www.saucedemo.com/ ')
		WebUI.setText(findTestObject('Object Repository/ticket1/Login/usename'), "standard_user")
		WebUI.setText(findTestObject('Object Repository/ticket1/Login/password') , "secret_sauce")
		WebUI.click(findTestObject('Object Repository/ticket1/Login/btn_login'))
		'verify login successfully'
		WebUI.verifyElementVisible(findTestObject('Object Repository/ticket1/saucedemo/btn_cart'))
		WebUI.maximizeWindow()
	}
}
