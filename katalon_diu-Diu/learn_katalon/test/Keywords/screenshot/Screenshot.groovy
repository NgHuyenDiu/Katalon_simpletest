package screenshot

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Screenshot {
	@Keyword
	public static takeScreenshot() {

		def pathTS = (RunConfiguration.getExecutionSource().toString().substring(RunConfiguration.getExecutionSource().toString().lastIndexOf("\\")+1))

		println(pathTS)

		def textSuiteName = pathTS.split("_").first().split("/").last()

		println(textSuiteName)



		Date today = new Date()
		String todaysDate = today.format('MM_dd_yy')
		String nowTime = today.format('hh_mm_ss')

		//		GlobalVariable.screenShotIndex = GlobalVariable.screenShotIndex +1
		return WebUI.takeScreenshot(GlobalVariable.path + textSuiteName + '/' + String.format("%03d", GlobalVariable.screenShotIndex)+"Day_" +todaysDate +"_" + "Time_"+ nowTime + ".png")
	}
}
