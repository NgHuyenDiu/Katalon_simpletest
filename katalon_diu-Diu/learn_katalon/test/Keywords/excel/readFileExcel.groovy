package excel

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.apache.poi.hssf.util.CellReference

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.reader.ExcelFactory
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.keyword.excel.ExcelKeywords

import internal.GlobalVariable

public class readFileExcel {
	@Keyword
	public void getIndexItem (String path , String input) {
		// dùng data ở file excel
		def data = ExcelFactory.getExcelDataWithDefaultSheet(path, 'Sheet1', false)
		// lấy tổng số hàng, số cột trong file excel
		int count_row = data.getRowNumbers()
		int count_column = data.getColumnNumbers()
		println(count_row +"/"+ count_column)

		def workbook01 = ExcelKeywords.getWorkbook(path)
		def sheet01 = ExcelKeywords.getExcelSheet(workbook01, 'sheet1')
		
		// hiển thị danh sách cell
		//		for(int column = 0 ; column < count_column ;column++) {
		//			def cell = ExcelKeywords.getCellByIndex(sheet01, 0, column)
		//			println(cell)
		//		}
		
		// duyệt tìm item
		for(int row = 0; row < count_row; row++) {
			for(int column = 0 ; column < count_column ;column++) {
				def cell = ExcelKeywords.getCellByIndex(sheet01, row, column)
				//	println("row " + row + " col " + column + " val: " + cell)

				if(cell.toString().contains( input)) {
					def column_out = CellReference.convertNumToColString(column)
					int row_out = row + 1
					def column_name = ExcelKeywords.getCellByIndex(sheet01, 0, column)
					println("Index of cell : ("+ column_out + ","+ row_out+")")
					println("Column name: "+ column_name)
				}
			}
		}
	}


}
