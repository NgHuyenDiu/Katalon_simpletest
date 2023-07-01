package login_file

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
import common.open_browser
public class login_data_datafile {
	@Keyword
	public void login_Datafile() {
		// excel data in testcase
		//// cach 1: đếm số dòng ở file excel
		// rows= ExcelFactory.getExcelDataWithDefaultSheet("D:\\katalon_basic\\learn\\learn_katalon\\email_password.xlsx", 'Sheet1', true)
		// int count_row = rows.getRowNumbers()
		//
		// // cách 2: file excel là một testdata
		for(int i = 1 ; i<= findTestData("Data Files/login/gmail_password").getRowNumbers()  ; i++) {
			open_browser.openbrowser('https://demo.nopcommerce.com/login')

			WebUI.setText(findTestObject('Object Repository/login/input_Email'), findTestData("Data Files/login/gmail_password").getValue('email', i))

			WebUI.setText(findTestObject('Object Repository/login/input_Password'), findTestData("Data Files/login/gmail_password").getValue('password', i))

			WebUI.click(findTestObject('Object Repository/login/button_Login'))
		}
	}
}
