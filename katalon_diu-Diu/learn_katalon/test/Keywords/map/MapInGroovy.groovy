package map

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

public class MapInGroovy {
	@Keyword
	public void demoMap() {
		def student = ['name':'diu', 'age': '20']
		println(student)
		println(student.name)
		println student['name']
		println student.get('age')
		println student.getAt('age')

		println student.size()
		student.put('city','paris')
		println(student)
		println student.containsKey('city')
		println student.containsValue('paris')

		println student.getClass()

		def student2 = student.clone()
		println(student2)

		student.each { key, value ->
			println "$key : $value"
		}

		student.eachWithIndex { key, value, i ->
			println "$i | $key : $value"
		}

		student.eachWithIndex  { entry, i ->
			println "$i | $entry.key : $entry.value"
		}


		def map1 =['a': 1, 'b': 2]
		def entries = map1.entrySet()
		entries.each { entry ->
			assert entry.key in ['a', 'b']
			assert entry.value in [1, 2]
		}
		student.clear()
		println(student)
	}
}
