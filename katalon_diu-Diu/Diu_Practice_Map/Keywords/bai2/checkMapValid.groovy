package bai2

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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class checkMapValid {
	private Map user_map = [:]
	private put_name() {
		String name = WebUI.getAttribute(findTestObject('Object Repository/Bai2/name'), "value")
		if(name.trim().empty == false) {
			String label_name = WebUI.getText(findTestObject('Object Repository/Bai2/label_name'))
			user_map.put(label_name, name)
		}
	}

	private put_company() {
		String company = WebUI.getAttribute(findTestObject('Object Repository/Bai2/company'), "value")
		if(company.trim().empty == false) {
			String label_company = WebUI.getText(findTestObject('Object Repository/Bai2/label_company'))
			user_map.put(label_company, company)
		}
	}

	private put_email() {
		String email = WebUI.getAttribute(findTestObject('Object Repository/Bai2/email'), "value")
		if(email.trim().empty == false) {
			String label_email = WebUI.getText(findTestObject('Object Repository/Bai2/label_email'))
			user_map.put(label_email, email)
		}
	}

	private void put_phone_number() {
		String phone_number = WebUI.getAttribute(findTestObject('Object Repository/Bai2/phonenumber'), "value")
		if(phone_number.trim().empty == false) {
			String label_phone_number = WebUI.getText(findTestObject('Object Repository/Bai2/label_phone_number'))
			user_map.put(label_phone_number, phone_number)
		}
	}

	private void put_check_box(){
		WebElement combobox_check = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Bai2/input_check'), 10)
		boolean checked = combobox_check.isSelected()
		String label_check = WebUI.getText(findTestObject('Object Repository/Bai2/label_check'))
		if(checked == true) {
			user_map.put(label_check, "Yes")
		}
		else {
			user_map.put(label_check, "No")
		}
	}

	private Map createMap() {
		put_name()
		put_company()
		put_email()
		put_phone_number()
		put_check_box()
		return user_map
	}

	private void displayMap() {
		println("Thông tin dữ liệu người dùng nhập: [")
		user_map.each { key, value -> println("	"+ key +" : "+ value +" ," ) }
		println("]")
	}

	@Keyword
	public boolean verify_user_map() {
		List<WebElement> keys = [
			'Name',
			'Company',
			'Work Email',
			'Phone Number',
			'Yes, I would like to be emailed with the latest news and happenings, products, and special offers from GitHub.'
		]
		user_map = createMap()
		displayMap()

		boolean find = true
		for(String item in keys) {
			find = user_map.containsKey(item)
			if(find == false) {
				break
			}
		}
		return find
	}
}
