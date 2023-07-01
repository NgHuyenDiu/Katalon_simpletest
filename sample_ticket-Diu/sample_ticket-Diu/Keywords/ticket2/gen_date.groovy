package ticket2

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
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
import java.text.SimpleDateFormat as SimpleDateFormat
public class gen_date {
	@Keyword
	public  String FutureDate() {
		//Creates current date
		int randomDay = new Random().nextInt(365)
		println("randomDay: " + randomDay)
		SimpleDateFormat sdf = new SimpleDateFormat('yyyy-MM-dd')
		Calendar c = Calendar.getInstance()
		c.setTime(new Date())
		c.add(Calendar.DATE, randomDay)
		c.add(Calendar.YEAR, 0)
		def VerDate = sdf.format(c.getTime())
		return VerDate
	}

	@Keyword
	public String BirthDate() {
		//Creates 20 year old birth date
		int ageRamdom = new Random().nextInt(100)
		println("ageRamdom: " + ageRamdom)
		SimpleDateFormat sdf = new SimpleDateFormat('yyyy-MM-dd')
		Calendar c = Calendar.getInstance()
		c.setTime(new Date())
		c.add(Calendar.DATE, 0)
		c.add(Calendar.YEAR, - ageRamdom)
		def BirthDate = sdf.format(c.getTime())
		return BirthDate
	}
}
