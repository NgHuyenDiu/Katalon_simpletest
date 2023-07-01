package bai3_4

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.util.stream.Collectors

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

public class Covid {
	private Map  map_main = [:]
	private Map map_sort = [:]
	private Map map_value = [:]
	private String value_sort = ""
	private int value_sort_int = 0
	private Map list_value_sort_int = [:]

	private int getRowSize() {
		List<WebElement> rows = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Bai3_4/rows'), 10)
		int row_size = rows.size()
		return row_size
	}

	private String getProviderName(int index_row) {
		WebElement provide = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Bai3_4/info', [('index_row'): index_row + 1, ('index_column'): 1]), 10)
		String provide_name = provide.text
		return provide_name
	}

	private Map getInfoAtIndex(Map map_info, List<WebElement> titles,int index_row, int index_column) {
		WebElement info = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Bai3_4/info', [('index_row'): (index_row + 1), ('index_column'): (index_column+ 1)]), 10)
		String key = titles.get(index_column).text
		String value = info.text
		map_info.put(key, value)
		return map_info
	}


	public Map getListInfo() {

		Map  map_info = [:]
		List<WebElement> titles = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Bai3_4/title'), 10)
		int column_size = titles.size()
		int row_size = getRowSize()
		for ( int index_row = 0 ; index_row < row_size ; index_row ++) {
			map_info = [:]
			String provide_name = getProviderName(index_row)
			for(int index_column = 1; index_column < column_size; index_column ++) {
				map_info = getInfoAtIndex(map_info, titles, index_row, index_column)
			}
			map_main.put(provide_name, map_info	)
		}

		return map_main
	}

	@Keyword
	public Map getInfoProvider(String provider) {

		map_main = getListInfo()
		map_main.each{entry -> println(entry)}
		Map info_of_provide =  map_main.get(provider)
		return info_of_provide
	}


	private int convertToInt(String value) {
		value = value.replace(".", "").replace("+", "").replace("-", "0")
		int result = Integer.valueOf(value)
		return result
	}

	public boolean checkKeyExists(String key_sort) {
		boolean run = false
		List<WebElement> titles = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Bai3_4/title'), 10)
		int column_size = titles.size()
		for(int i= 0; i< column_size; i++) {
			if(titles.get(i).text == key_sort) {
				run = true
				break
			}
		}
		return run
	}

	public Map getMapSort(String key_sort) {
		// get list value need sort
		map_main.each { key, value ->
			map_value =  map_main.get(key)
			value_sort = map_value.get(key_sort)
			value_sort_int = convertToInt(value_sort)
			list_value_sort_int.put(key, value_sort_int)
		}
		return list_value_sort_int
	}

	public void displayMap(Map map_sort) {
		map_sort.each { entry->
			println(entry)
		}
	}

	@Keyword
	public void sortMap(String key_sort, String sortBy) {

		boolean run = checkKeyExists(key_sort)
		if(run == true) {
			map_main = getListInfo()
			list_value_sort_int = getMapSort(key_sort)

			// sắp xếp danh sách cần sort
			if(sortBy == 'ASC') {
				list_value_sort_int= list_value_sort_int.sort { a, b -> a.value <=> b.value }
			}else if(sortBy == 'DESC'){
				list_value_sort_int= list_value_sort_int.sort { b, a -> a.value <=> b.value }
			}

			// trả về map mới đã sắp xếp
			for( entry in list_value_sort_int) {
				map_sort.put(entry.key,map_main.get(entry.key) )
			}

			displayMap(map_sort)

		}
		else {
			println("Invalid key sort")

		}

	}


}
