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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement
import org.openqa.selenium.By

WebUI.openBrowser("https://opensource-demo.orangehrmlive.com/")
CustomKeywords.'ticket2.ticket2_login.Login'()
WebUI.maximizeWindow()
WebUI.delay(5)
'Click btn My Info'
WebUI.click(findTestObject('Object Repository/ticket2/MyInfo/btn_myInfo'))

int rowCount = findTestData("Data Files/ticket2/info_employee").getRowNumbers()

for( int row = 1 ; row<= rowCount; row ++) {
	
	WebUI.refresh()
	'screenshot before change info'
	WebUI.takeScreenshot()
	'change firstname'
	WebUI.sendKeys(findTestObject('Object Repository/ticket2/MyInfo/firstname'), Keys.chord(Keys.CONTROL, 'a'))
	WebUI.sendKeys(findTestObject('Object Repository/ticket2/MyInfo/firstname'), Keys.chord(Keys.BACK_SPACE))
	String firstname = findTestData("Data Files/ticket2/info_employee").getValue('firstName', row)
	WebUI.setText(findTestObject('Object Repository/ticket2/MyInfo/firstname'), firstname )
	
	'change middle name'
	WebUI.sendKeys(findTestObject('Object Repository/ticket2/MyInfo/middlename'), Keys.chord(Keys.CONTROL, 'a'))
	WebUI.sendKeys(findTestObject('Object Repository/ticket2/MyInfo/middlename'), Keys.chord(Keys.BACK_SPACE))
	String middlename = findTestData("Data Files/ticket2/info_employee").getValue('middleName', row)
	WebUI.setText(findTestObject('Object Repository/ticket2/MyInfo/middlename'), middlename)
	
	'change last name'
	WebUI.sendKeys(findTestObject('Object Repository/ticket2/MyInfo/lastname'), Keys.chord(Keys.CONTROL, 'a'))
	WebUI.sendKeys(findTestObject('Object Repository/ticket2/MyInfo/lastname'), Keys.chord(Keys.BACK_SPACE))
	String lastname = findTestData("Data Files/ticket2/info_employee").getValue('lastName', row)
	WebUI.setText(findTestObject('Object Repository/ticket2/MyInfo/lastname'), lastname)
	
	'change nickname'
	WebUI.sendKeys(findTestObject('Object Repository/ticket2/MyInfo/nickname'), Keys.chord(Keys.CONTROL, 'a'))
	WebUI.sendKeys(findTestObject('Object Repository/ticket2/MyInfo/nickname'), Keys.chord(Keys.BACK_SPACE))
	String nickname = findTestData("Data Files/ticket2/info_employee").getValue('nickName', row)
	WebUI.setText(findTestObject('Object Repository/ticket2/MyInfo/nickname'), nickname)
	
	'change employee id'
	
	WebUI.sendKeys(findTestObject('Object Repository/ticket2/MyInfo/employeeId'), Keys.chord(Keys.CONTROL, 'a'))
	WebUI.sendKeys(findTestObject('Object Repository/ticket2/MyInfo/employeeId'), Keys.chord(Keys.BACK_SPACE))
	String empId = findTestData("Data Files/ticket2/info_employee").getValue('employeeId', row)
	WebUI.setText(findTestObject('Object Repository/ticket2/MyInfo/employeeId'),empId )
	
	'change other id'
	WebUI.sendKeys(findTestObject('Object Repository/ticket2/MyInfo/other_id'), Keys.chord(Keys.CONTROL, 'a'))
	WebUI.sendKeys(findTestObject('Object Repository/ticket2/MyInfo/other_id'), Keys.chord(Keys.BACK_SPACE))
	String otherId = findTestData("Data Files/ticket2/info_employee").getValue('otherId', row)
	WebUI.setText(findTestObject('Object Repository/ticket2/MyInfo/other_id'), otherId)
	
	"change Driver's License Number"
	WebUI.sendKeys(findTestObject('Object Repository/ticket2/MyInfo/driver_license_number'), Keys.chord(Keys.CONTROL, 'a'))
	WebUI.sendKeys(findTestObject('Object Repository/ticket2/MyInfo/driver_license_number'), Keys.chord(Keys.BACK_SPACE))
	String driverLicenseNumber = findTestData("Data Files/ticket2/info_employee").getValue('driverLicenseNumber', row)
	WebUI.setText(findTestObject('Object Repository/ticket2/MyInfo/driver_license_number'), driverLicenseNumber)
	
	'change license expriry date'
	WebUI.sendKeys(findTestObject('Object Repository/ticket2/MyInfo/license_expiry_date'), Keys.chord(Keys.CONTROL, 'a'))
	WebUI.sendKeys(findTestObject('Object Repository/ticket2/MyInfo/license_expiry_date'), Keys.chord(Keys.BACK_SPACE))
	//String date = CustomKeywords.'ticket2.gen_date.FutureDate'()
	String licenseExpiryDate =  findTestData("Data Files/ticket2/info_employee").getValue('licenseExpiryDate', row)
	WebUI.setText(findTestObject('Object Repository/ticket2/MyInfo/license_expiry_date'),licenseExpiryDate)
	
	'change ssn number'
	WebUI.sendKeys(findTestObject('Object Repository/ticket2/MyInfo/ssn_number'), Keys.chord(Keys.CONTROL, 'a'))
	WebUI.sendKeys(findTestObject('Object Repository/ticket2/MyInfo/ssn_number'), Keys.chord(Keys.BACK_SPACE))
	String ssnNumber = findTestData("Data Files/ticket2/info_employee").getValue('ssnNumber', row)
	WebUI.setText(findTestObject('Object Repository/ticket2/MyInfo/ssn_number'),ssnNumber )
	
	'change sin number'
	WebUI.sendKeys(findTestObject('Object Repository/ticket2/MyInfo/sin_number'), Keys.chord(Keys.CONTROL, 'a'))
	WebUI.sendKeys(findTestObject('Object Repository/ticket2/MyInfo/sin_number'), Keys.chord(Keys.BACK_SPACE))
	String sinNumber = findTestData("Data Files/ticket2/info_employee").getValue('sinNumber', row)
	WebUI.setText(findTestObject('Object Repository/ticket2/MyInfo/sin_number'), sinNumber)
	
	'change nationality'
	WebUI.click(findTestObject('Object Repository/ticket2/MyInfo/nationality'))
	WebElement listElements = WebUiCommonHelper.findWebElement(
		findTestObject('Object Repository/ticket2/MyInfo/listbox_nationality'), 3)
	
	'find all country in listbox'
	List<WebElement> allCountry = listElements.findElements(By.xpath('./*'))
//	List<String> listCountryName = []
//	for (WebElement country : allCountry) {
//		listCountryName.add(country.getText())
//	}
//	'ramdom nationality'
//	int sizeCountry = listCountryName.size()
//	int indexCountryRandom = new Random().nextInt(sizeCountry )
//	String nationality = listCountryName.get(indexCountryRandom)
//	println("size: "+ sizeCountry)
//	println("indexRandom: "+indexCountryRandom )
//	println("nationality: "+ nationality)
	
	'choose nationality'
	String nationality = findTestData("Data Files/ticket2/info_employee").getValue('nationality', row)
	for (WebElement country : allCountry) {
		if(country.getText().equals(nationality))
		{
			country.click()
			break
		}
	}
	
	'change marital status'
	WebUI.click(findTestObject('Object Repository/ticket2/MyInfo/maritalStatus'))
	WebElement listStatus = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ticket2/MyInfo/listbox_nationality'), 3)
	List<WebElement> allStatus = listStatus.findElements(By.xpath('./*'))
//	List<String> marialStatus = []
//	for(WebElement status : allStatus ) {
//		marialStatus.add(status.getText())
//	}
//	'ramdom marital status'
//	int sizeStatus = marialStatus.size()
//	int indexStatusRandom = new Random().nextInt(sizeStatus)
//	String valuestatus = marialStatus.get(indexStatusRandom)
//	println("size: "+ sizeStatus)
//	println("indexRandom: "+indexStatusRandom )
//	println("satus: "+ valuestatus)
	
	'choose marital status'
	String maritalStatus = findTestData("Data Files/ticket2/info_employee").getValue('maritalStatus', row)
	for (WebElement status : allStatus) {
		if(status.getText().equals(maritalStatus))
		{
			status.click()
			break
		}
	}
	
	'change birthday'
	WebUI.sendKeys(findTestObject('Object Repository/ticket2/MyInfo/birthday'), Keys.chord(Keys.CONTROL, 'a'))
	WebUI.sendKeys(findTestObject('Object Repository/ticket2/MyInfo/birthday'), Keys.chord(Keys.BACK_SPACE))
	
	//String dob = CustomKeywords.'ticket2.gen_date.BirthDate'()
	String dateOfBirth = findTestData("Data Files/ticket2/info_employee").getValue('dateOfBirth', row)
	WebUI.setText(findTestObject('Object Repository/ticket2/MyInfo/birthday'),dateOfBirth )
	
	if(findTestData("Data Files/ticket2/info_employee").getValue('gender', row).equals('Male'))
	{		
		'select male'
		WebUI.click(findTestObject('Object Repository/ticket2/MyInfo/male'))
	}else {
		'select female'
		WebUI.click(findTestObject('Object Repository/ticket2/MyInfo/female'))
	}

	'change Military Service'
	WebUI.sendKeys(findTestObject('Object Repository/ticket2/MyInfo/military_service'), Keys.chord(Keys.CONTROL, 'a'))
	WebUI.sendKeys(findTestObject('Object Repository/ticket2/MyInfo/military_service'), Keys.chord(Keys.BACK_SPACE))
	String militaryService =  findTestData("Data Files/ticket2/info_employee").getValue('militaryService', row)
	WebUI.setText(findTestObject('Object Repository/ticket2/MyInfo/military_service'),militaryService )
	
	'check smoke'
	'get background color of span smoke'
	backgroundColor =  WebUI.getCSSValue(findTestObject('Object Repository/ticket2/MyInfo/span_smoker'), 'background-color')
	//println(backgroundColor)
	if(findTestData("Data Files/ticket2/info_employee").getValue('smoker', row).equals('Yes') )
	{
		println("Yes: " + backgroundColor)
		if(backgroundColor.equals('rgba(255, 255, 255, 1)')) {
			println("yes, white")
			WebUI.click(findTestObject('Object Repository/ticket2/MyInfo/smoker'))
		}
		
	}else if(findTestData("Data Files/ticket2/info_employee").getValue('smoker', row).equals('No') ) {
		println("No: " +backgroundColor)
		if(!backgroundColor.equals('rgba(255, 255, 255, 1)')) {
			println("no, orange")
			WebUI.click(findTestObject('Object Repository/ticket2/MyInfo/smoker'))
		}
		
	}else {
		println("Smoker not change")
	}
	
	
	'save'
	WebUI.click(findTestObject('Object Repository/ticket2/MyInfo/btn_save'))
	'verify change info success'
	boolean success = false
	WebUI.refresh()
	WebUI.waitForPageLoad(60)
	WebUI.waitForElementVisible(findTestObject('Object Repository/ticket2/MyInfo/firstname'), 5, FailureHandling.STOP_ON_FAILURE)
	String firstNameOutput = WebUI.getAttribute(findTestObject('Object Repository/ticket2/MyInfo/firstname'), 'value')
	//WebUI.click(findTestObject('Object Repository/ticket2/MyInfo/middlename'))
	String middleNameOutput = WebUI.getAttribute(findTestObject('Object Repository/ticket2/MyInfo/middlename'), 'value')
	String lastNameOutput = WebUI.getAttribute(findTestObject('Object Repository/ticket2/MyInfo/lastname'), 'value')
	String empIdOutput = WebUI.getAttribute(findTestObject('Object Repository/ticket2/MyInfo/employeeId'), 'value')
	String nicknameOutput = WebUI.getAttribute(findTestObject('Object Repository/ticket2/MyInfo/nickname'), 'value')
	String driverLicenseNumberOutput = WebUI.getAttribute(findTestObject('Object Repository/ticket2/MyInfo/driver_license_number'), 'value')
	String licenseExpiryDateOutput = WebUI.getAttribute(findTestObject('Object Repository/ticket2/MyInfo/license_expiry_date'), 'value')
	String ssnOutput = WebUI.getAttribute(findTestObject('Object Repository/ticket2/MyInfo/ssn_number'), 'value')
	String sinOutput = WebUI.getAttribute(findTestObject('Object Repository/ticket2/MyInfo/sin_number'), 'value')
	String nationalityOutput = WebUI.getText(findTestObject('Object Repository/ticket2/MyInfo/nationality'))
	String maritalStatusOutput = WebUI.getText(findTestObject('Object Repository/ticket2/MyInfo/maritalStatus'))
	String dayOfBirthOutput = WebUI.getAttribute(findTestObject('Object Repository/ticket2/MyInfo/birthday'), 'value')
	String militaryServiceOutput = WebUI.getAttribute(findTestObject('Object Repository/ticket2/MyInfo/military_service'), 'value')
	println(firstNameOutput)
	println(middleNameOutput)
	println(lastNameOutput)
	println(empIdOutput)
	println(nicknameOutput)
	println(driverLicenseNumberOutput)
	println(licenseExpiryDateOutput)
	println(ssnOutput)
	println(nationalityOutput)
	println(maritalStatusOutput)
	println(dayOfBirthOutput)
	println(militaryServiceOutput)
	
	if(firstname.equals(firstNameOutput)
		&& middlename.equals(middleNameOutput)
		&& lastname.equals(lastNameOutput)
		&& empId.equals(empIdOutput)
		&& nickname.equals(nicknameOutput)
		&& driverLicenseNumber.equals(driverLicenseNumberOutput)
		&& licenseExpiryDate.equals(licenseExpiryDateOutput)
		&& ssnNumber.equals(ssnOutput)
		&& sinNumber.equals(sinOutput)
		&& nationality.equals(nationalityOutput)
		&& maritalStatus.equals(maritalStatusOutput)
		&& dateOfBirth.equals(dayOfBirthOutput)
		&& militaryService.equals(militaryServiceOutput)) {
		success = true
		println("vaof if")
	}
	'screenshot update info success'
	if(success == true) {
		WebUI.takeScreenshot()
		WebUI.scrollToElement(findTestObject('Object Repository/ticket2/MyInfo/nationality'), 5)
		WebUI.takeScreenshot()
	}
	

}

