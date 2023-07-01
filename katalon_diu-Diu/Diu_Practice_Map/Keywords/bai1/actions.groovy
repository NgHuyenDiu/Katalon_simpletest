package bai1

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

public class actions {
	static Map getListActions() {

		Map map_actions= [:]

		List<WebElement> list_hover = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Bai1/Hover'), 10)
		for(int index = 0; index < list_hover.size(); index++) {
			map_actions.put(list_hover.get(index), "hover")
		}

		List<WebElement> list_click = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Bai1/click_header'), 10)
		for(int index = 0; index < list_click.size(); index++) {
			map_actions.put(list_click.get(index), "click")
		}

		List<WebElement> list_dropdown = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Bai1/click_div_dropdown'), 10)
		for(int index = 0; index < list_dropdown.size(); index++) {
			map_actions.put(list_dropdown.get(index), "click")
		}

		List<WebElement> list_dropdown1 = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Bai1/click_dropdown'), 10)
		for(int index = 0; index < list_dropdown1.size(); index++) {
			map_actions.put(list_dropdown1.get(index), "click")
		}
		return map_actions
	}
}
