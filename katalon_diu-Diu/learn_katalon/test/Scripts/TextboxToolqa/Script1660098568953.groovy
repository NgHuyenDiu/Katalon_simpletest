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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.util.regex.Pattern
import java.util.regex.Matcher

WebUI.openBrowser("https://demoqa.com/text-box")
WebUI.maximizeWindow()

// set text 
WebUI.setText(findTestObject('Object Repository/textbox_ToolQA/fullname'), fullname)
WebUI.setText(findTestObject('Object Repository/textbox_ToolQA/email'), email)
WebUI.setText(findTestObject('Object Repository/textbox_ToolQA/current_Address'), currentAddress)
WebUI.setText(findTestObject('Object Repository/textbox_ToolQA/permanent_Address'), permanentAddress)
// click submit
WebUI.click(findTestObject('Object Repository/textbox_ToolQA/btn_Submit'))

WebUI.scrollToElement(findTestObject('Object Repository/textbox_ToolQA/output'), 10)
// get value
nameOut = WebUI.getText(findTestObject('Object Repository/textbox_ToolQA/name_Output'))
emailOut = WebUI.getText( findTestObject('Object Repository/textbox_ToolQA/email_Out'))
currentAddressOut = WebUI.getText(findTestObject('Object Repository/textbox_ToolQA/current_Address_Out'))
permanetAddressOut  = WebUI.getText(findTestObject('Object Repository/textbox_ToolQA/permanent_Address_Out'))

// split String, get value
String[] name = nameOut.split(":")
nameUser = name[1]
String[] eml = emailOut.split(":")
email_user = eml[1]
String[] cur_add = currentAddressOut.split(":")
cur_add_user = cur_add[1]
String[] per_add = permanetAddressOut.split(":")
per_add_user = per_add[1]

// verifyMatch
WebUI.verifyMatch(nameUser, fullname, true)
WebUI.verifyMatch(email_user, email, true)
WebUI.verifyMatch(cur_add_user, currentAddress, true)
WebUI.verifyMatch(per_add_user, permanentAddress, true)

// verify regex email
String patternStr = '^[a-z][a-z0-9_\\.]{1,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$'
Pattern pattern = Pattern.compile(patternStr)
Matcher matcher = pattern.matcher(email_user)
if (matcher.matches()) {
	KeywordUtil.markPassed("Email user =\"${email_user}\" DOES match regex ${patternStr}")
} else {
	KeywordUtil.markFailed("Email user =\"${email_user}\" does NOT match regex ${patternStr}")
}

// close
WebUI.closeBrowser()