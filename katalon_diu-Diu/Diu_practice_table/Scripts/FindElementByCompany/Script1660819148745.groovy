import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.security.SecureRandom

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

WebUI.openBrowser(GlobalVariable.browserURL)

// find company name
List<WebElement> list_company = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/company_name'), 10)
Random rand = new Random()
random_num = rand.nextInt(list_company.size()+1)
String name_company = list_company.get(random_num).text


WebUI.delay(2)
List<WebElement> companies_list  = []
result = [:]
if(companies_list.isEmpty()) {
	companies_list = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/companies', [('company'): name_company]), 10)
	
	for (int i in 0..2) {
		if(companies_list.isEmpty()) {
			WebUI.refresh()
			WebUI.delay(2)
			companies_list = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/companies', [('company'): name_company]), 10)		
		}
		else {
			List<WebElement> rows = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/rows'), 10)
			int row_count = rows.size()
			for(int index_row in 0..(row_count -1)) {
				columns = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/columns', [('index'): (index_row + 1)]), 10)
				int column_count  = columns.size()
				String name_cell = columns.get(0).text
				if(name_company == name_cell) {
					def timestamp = new Date().format("YYYYMMdd_HHmmss")
					WebUI.takeElementScreenshot("D://screenShot//"+ name_company +timestamp+".png", WebUI.convertWebElementToTestObject(rows.get(index_row)))
					List<WebElement> titles = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/titles'), 10)
					for(int index_column in 1..(column_count -1)) {
						String key = titles.get(index_column).text
						String value = columns.get(index_column).text
						result.put(key, value)
					
					}
				}
				
			}
			println(WebUI.getText(findTestObject('Object Repository/time')))
			println(name_company)
			result.each{entry -> println "$entry.key: $entry.value"}
			break
		}
	}
	if(companies_list.isEmpty()) {
		println("Not Find element")
	}
	
}


