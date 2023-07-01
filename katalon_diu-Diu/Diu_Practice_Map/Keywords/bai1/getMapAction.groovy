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
import bai1.actions
import internal.GlobalVariable

public class getMapAction {

	private List<String> getListRequest(String request) {
		request = request.replace(">>", ">")
		List<String> list_actions = []
		if(request.contains(">")) {
			list_actions = request.split(">")
		}else {
			list_actions = request.split(" ")
		}
		return list_actions
	}

	@Keyword
	public boolean action(String request) {
		WebUI.waitForPageLoad(10)
		Map map_actions = actions.getListActions()

		List<String> list_actions = getListRequest(request)

		String key_text
		boolean success = false

		for(String action in list_actions) {
			success = false
			for(entry in map_actions) {
				WebElement ele = entry.key
				key_text = ele.text

				if(key_text == action) {
					success = true
					if(entry.value == "click") {
						WebUI.click(WebUI.convertWebElementToTestObject(ele))
						WebUI.delay(1)
						break
					}
					else if(entry.value == "hover") {

						WebUI.mouseOver(WebUI.convertWebElementToTestObject(ele))
						break
					}
				}
			}
			if(success == false) {
				break
			}
		}
		return success
	}
}
