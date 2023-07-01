package map

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

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

public class getInfoCovid {

	private int getRowSize() {
		List<WebElement> rows = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/covid19_Map/rows'), 10)
		int row_size = rows.size()
		return row_size
	}

	private String getProviderName(int index_row) {
		WebElement provide = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/covid19_Map/info', [('index_row'): index_row + 1, ('index_column'): 1]), 10)
		String provide_name = provide.text
		return provide_name
	}

	private Map getInfoIndex(Map map_info, List<WebElement> titles,int index_row, int index_column) {
		WebElement info = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/covid19_Map/info', [('index_row'): (index_row + 1), ('index_column'): (index_column+ 1)]), 10)
		String key = titles.get(index_column).text
		String value = info.text
		map_info.put(key, value)
		return map_info
	}

	@Keyword
	public Map getListInfo() {
		def  map_all = [:]
		def  map_info = [:]
		List<WebElement> titles = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/covid19_Map/title'), 10)
		int column_size = titles.size()
		int row_size = getRowSize()
		for ( int index_row = 0 ; index_row < row_size ; index_row ++) {
			map_info = [:]
			String provide_name = getProviderName(index_row)
			for(int index_column = 1; index_column < column_size; index_column ++) {
				map_info = getInfoIndex(map_info, titles, index_row, index_column)
			}
			map_all.put(provide_name, map_info	)
		}
		return map_all
	}

	@Keyword
	public void getInfo(String provider, String info) {

		Map map_all = getListInfo()

		// print all
		map_all.each { entry->
			println(entry)
		}

		// get info of provide
		Map info_of_provide =  map_all.get(provider)

		// print all map of info
		info_of_provide.each { entry->
			println(entry)
		}

		// return 1 info of provide
		String result =  info_of_provide.get(info)

		println (provider + " có thông tin về "+ info +" là : " + result)

		// loop
		//
		//		Scanner scanner = new Scanner(System.in)
		//		while( true) {
		//			println("Bạn muốn tiếp tục (0: dừng lại): ")
		//			int temp = scanner.nextInt()
		//			if(temp == 0) {
		//				break
		//			}
		//			scanner.nextLine()
		//			println("Nhập tỉnh thành: ")
		//			String provide_loop = scanner.nextLine()
		//			println("Nhập thông tin muốn tìm kiếm: ")
		//			String info_loop = scanner.nextLine()
		//
		//			Map list_info_loop =  map_all.get(provide_loop)
		//			String result_loop =  list_info_loop.get(info_loop)
		//
		//			println (provide_loop + " có thông tin về "+ info_loop +" là : " + result_loop)
		//
		//		}
		Map remove_item_by_key = removeItem(info_of_provide)
		remove_item_by_key.each { entry ->
			println(entry)
		}
	}

	private Map removeItem(Map map) {
		//		Map result = map.minus(["24 giờ qua": "+540"])
		map.remove("24 giờ qua")
		return map
	}
}
