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
import com.kms.katalon.keyword.excel.ExcelKeywords
import com.kms.katalon.core.testdata.reader.ExcelFactory

String path = "D://katalon_basic//learn//test_excel_file//test.xlsx"

File file_excel = new File(path)
if(file_excel.exists()) {
	file_excel.delete()
}
ExcelKeywords.createExcelFile(path)
// create sheet
workbook01 = ExcelKeywords.getWorkbook(path)
sheet01 = ExcelKeywords.createExcelSheet(workbook01, 'sheet01')
ExcelKeywords.saveWorkbook(path, workbook01)
// write some data
workbook01 = ExcelKeywords.getWorkbook(path)
sheet01 = ExcelKeywords.getExcelSheet(workbook01, 'sheet01')
ExcelKeywords.setValueToCellByAddress(sheet01, 'A1' , 'hello')
ExcelKeywords.saveWorkbook(path, workbook01)
for(int i= 2; i < 10; i++) {
	String index = 'A'+ i
	ExcelKeywords.setValueToCellByAddress(sheet01, index , i)
}
ExcelKeywords.setValueToCellByAddress(sheet01, 'B1' , 'hi')

ExcelKeywords.saveWorkbook(path, workbook01)
for(int i= 2; i < 10; i++) {
	String index = 'B'+ i
	ExcelKeywords.setValueToCellByAddress(sheet01, index , i)
}
ExcelKeywords.saveWorkbook(path, workbook01)

// read file

excelData = ExcelFactory.getExcelDataWithDefaultSheet(path, 'sheet01', false)
int row = excelData.getRowNumbers()
println(row)

List<String> list_output = []

workbook01 = ExcelKeywords.getWorkbook(path)
sheet01 = ExcelKeywords.getExcelSheet(workbook01, 'sheet01')

for (int i= 1; i<= row; i++) {
	list_output.add(ExcelKeywords.getCellByAddress(sheet01, 'A'+i)) 
}

for(int i= 0; i< list_output.size() ; i++) {
	println(list_output.get(i))
}