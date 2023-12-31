import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

import org.openqa.selenium.ElementClickInterceptedException
import org.openqa.selenium.Keys as Keys
WebUI.openBrowser("https://demoqa.com/dynamic-properties")
WebUI.maximizeWindow()
try {	
	//WebUI.waitForElementClickable(findTestObject('Object Repository/wait/wait_For_Element_Clickable'), 3)
	boolean result = WebUI.verifyElementClickable(findTestObject('Object Repository/wait/wait_For_Element_Clickable'))
	println(result)
	WebUI.click(findTestObject('Object Repository/wait/wait_For_Element_Clickable'))
}catch(ElementClickInterceptedException | StepFailedException e) {
	println("Khong click đươc "+ e.message)
}finally {
	println("vào finally")
}


