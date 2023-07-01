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
import com.kms.katalon.keyword.excel.ExcelKeywords

import internal.GlobalVariable

public class write_file {
	@Keyword
	public void write_file_excel(String path) {
		// ghi file

		File file_excel= new File(path)
		if(file_excel.exists()) {
			file_excel.delete()
		}

		ExcelKeywords.createExcelFile(path)
		def workbook = ExcelKeywords.createWorkbook(path)
		def sheet = ExcelKeywords.createExcelSheet(workbook, 'Sheet0')
		ExcelKeywords.saveWorkbook(path, workbook)

		ExcelKeywords.getWorkbook(path)
		sheet = ExcelKeywords.getExcelSheet(workbook, 'Sheet0')

		for(int i= 1; i<= findTestData("Data Files/login/gmail_password").getRowNumbers()  ; i++ ) {
			String index_email = 'A'+i
			String index_pass = 'B'+i
			ExcelKeywords.setValueToCellByAddress(sheet, index_email, findTestData("Data Files/login/gmail_password").getValue('email', i))
			ExcelKeywords.setValueToCellByAddress(sheet, index_pass , findTestData("Data Files/login/gmail_password").getValue('password', i))
		}
		ExcelKeywords.saveWorkbook(path, workbook)

	}
}
