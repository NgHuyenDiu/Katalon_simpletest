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
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.reader.ExcelFactory
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.keyword.excel.ExcelKeywords

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String path = "D:\\katalon_basic\\learn\\product_output\\product.xlsx"
File file_excel= new File(path)
if(file_excel.exists()) {
	file_excel.delete()
}

ExcelKeywords.createExcelFile(path)
workbook = ExcelKeywords.createWorkbook(path)
sheet = ExcelKeywords.createExcelSheet(workbook, 'Sheet01')
ExcelKeywords.saveWorkbook(path, workbook)

ExcelKeywords.getWorkbook(path)
sheet = ExcelKeywords.getExcelSheet(workbook, 'Sheet01')

// title
ExcelKeywords.setValueToCellByAddress(sheet, 'A1','ProductId' )
ExcelKeywords.setValueToCellByAddress(sheet, 'B1', 'ProductType')
ExcelKeywords.setValueToCellByAddress(sheet, 'C1', 'ParentGroupedProductId')
ExcelKeywords.setValueToCellByAddress(sheet, 'D1', 'VisibleIndividually')
ExcelKeywords.setValueToCellByAddress(sheet, 'E1', 'Name')
ExcelKeywords.setValueToCellByAddress(sheet, 'F1', 'ShortDescription')
ExcelKeywords.setValueToCellByAddress(sheet, 'G1', 'FullDescription')
ExcelKeywords.setValueToCellByAddress(sheet, 'H1','Vendor')
ExcelKeywords.setValueToCellByAddress(sheet, 'I1', 'ProductTemplate')
ExcelKeywords.setValueToCellByAddress(sheet, 'J1', 'ShowOnHomepage')
ExcelKeywords.setValueToCellByAddress(sheet, 'K1', 'DisplayOrder')
ExcelKeywords.setValueToCellByAddress(sheet, 'L1', 'MetaKeywords')
ExcelKeywords.setValueToCellByAddress(sheet, 'M1', 'MetaDescription')
ExcelKeywords.setValueToCellByAddress(sheet, 'N1', 'MetaTitle')
ExcelKeywords.setValueToCellByAddress(sheet, 'O1', 'SeName')
ExcelKeywords.setValueToCellByAddress(sheet, 'P1', 'AllowCustomerReviews')
ExcelKeywords.setValueToCellByAddress(sheet, 'Q1','Published')


int row_count = findTestData("Data Files/excel").getRowNumbers()
// content
for(int index = 2; index <= row_count + 1 ; index ++) {
	ProductId = 'A'+ index
	ProductType = 'B'+ index
	ParentGroupedProductId = 'C'+ index
	VisibleIndividually = 'D'+ index
	Name = 'E' + index
	ShortDescription = 'F' + index
	FullDescription = 'G'+ index
	Vendor = 'H' + index
	ProductTemplate = 'I'+ index
	ShowOnHomepage = 'J'+ index
	DisplayOrder = 'K' + index
	MetaKeywords = 'L' + index
	MetaDescription = 'M' + index
	MetaTitle = 'N'+ index
	SeName = 'O'+ index
	AllowCustomerReviews = 'P'+ index
	Published = 'Q'+ index
	
	ExcelKeywords.setValueToCellByAddress(sheet, ProductId, findTestData("Data Files/excel").getValue("ProductId", index - 1))
	ExcelKeywords.setValueToCellByAddress(sheet, ProductType, findTestData("Data Files/excel").getValue("ProductType", index - 1))
	ExcelKeywords.setValueToCellByAddress(sheet, ParentGroupedProductId, findTestData("Data Files/excel").getValue("ParentGroupedProductId", index - 1 ))
	ExcelKeywords.setValueToCellByAddress(sheet, VisibleIndividually, findTestData("Data Files/excel").getValue("VisibleIndividually", index - 1 ))
	ExcelKeywords.setValueToCellByAddress(sheet, Name, findTestData("Data Files/excel").getValue("Name", index - 1 ))
	ExcelKeywords.setValueToCellByAddress(sheet, ShortDescription, findTestData("Data Files/excel").getValue("ShortDescription", index - 1 ))
	ExcelKeywords.setValueToCellByAddress(sheet, FullDescription, findTestData("Data Files/excel").getValue("FullDescription", index - 1 ))
	ExcelKeywords.setValueToCellByAddress(sheet, Vendor, findTestData("Data Files/excel").getValue("Vendor", index - 1 ))
	ExcelKeywords.setValueToCellByAddress(sheet, ProductTemplate, findTestData("Data Files/excel").getValue("ProductTemplate", index - 1 ))
	ExcelKeywords.setValueToCellByAddress(sheet, ShowOnHomepage, findTestData("Data Files/excel").getValue("ShowOnHomepage", index - 1 ))
	ExcelKeywords.setValueToCellByAddress(sheet, DisplayOrder, findTestData("Data Files/excel").getValue("DisplayOrder", index - 1 ))
	ExcelKeywords.setValueToCellByAddress(sheet, MetaKeywords, findTestData("Data Files/excel").getValue("MetaKeywords", index - 1 ))
	ExcelKeywords.setValueToCellByAddress(sheet, MetaDescription, findTestData("Data Files/excel").getValue("MetaDescription", index - 1))
	ExcelKeywords.setValueToCellByAddress(sheet, MetaTitle, findTestData("Data Files/excel").getValue("MetaTitle", index - 1))
	ExcelKeywords.setValueToCellByAddress(sheet, SeName, findTestData("Data Files/excel").getValue("SeName", index -1 ))
	ExcelKeywords.setValueToCellByAddress(sheet, AllowCustomerReviews, findTestData("Data Files/excel").getValue("AllowCustomerReviews", index -1 ))
	ExcelKeywords.setValueToCellByAddress(sheet, Published, findTestData("Data Files/excel").getValue("Published", index -1 ))
		
}
ExcelKeywords.saveWorkbook(path, workbook)


