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
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.builtin.ConvertWebElementToTestObjectKeyword as ConvertWebElementToTestObjectKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.By.ByXPath as ByXPath
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

CustomKeywords.'ticket1.ticket1_Login.login_astandard_user'()

'screenshot before add product'
WebUI.takeScreenshot()

'random number of product add to cart'
//int randomNumberOfProduct = CustomKeywords.'ticket1.ticket1_Main.getIndexRandom'()
int randomNumberOfProduct =1
def listProductSelect = []
def listDetailProductSelect = []
def listProductRemove = []
boolean addSuccess = true
'Add product to list'
for (int index : (1..randomNumberOfProduct)) {
    
    WebUI.click(findTestObject('Object Repository/ticket1/saucedemo/btn_add_to_cart', [('index') : index]))

    'Verify add product successfully'
    if(!WebUI.verifyElementPresent(findTestObject('Object Repository/ticket1/saucedemo/btn_remove', [('index') : index]), 10)) {
		addSuccess = false
	}

    'get product just selected'
    Map quickProduct = CustomKeywords.'ticket1.ticket1_Main.getProductQuick'(index)
	
	'get detail product'
	Map detailProduct = CustomKeywords.'ticket1.ticket1_Main.getDetailProduct'(index)

    'add product into list product'
    listProductSelect.add(quickProduct)
	listDetailProductSelect.add(detailProduct)
}

'verify number product in cart'
if(!WebUI.verifyElementText(findTestObject('Object Repository/ticket1/saucedemo/btn_shopping_cart'), randomNumberOfProduct.toString()))
{
	addSuccess = false
}

' navigate to cart page'
WebUI.click(findTestObject('Object Repository/ticket1/saucedemo/btn_shopping_cart'))

'screenshot add product'
WebUI.takeScreenshot()

WebUI.delay(2)

'verify add successful list product'
int numberProductAddSuccess = CustomKeywords.'ticket1.ticket1_Main.VerifyInfoProduct'(listProductSelect)

if (numberProductAddSuccess != randomNumberOfProduct) {
    KeywordUtil.markError('Add product fail')
	addSuccess = false
}

'verify right detail product'
int numberProductDetailSuccess = CustomKeywords.'ticket1.ticket1_Main.VerifyListDetailProduct'(listDetailProductSelect)

if (numberProductDetailSuccess != randomNumberOfProduct) {
	KeywordUtil.markError('Detail product fail')
	addSuccess = false
}

if(addSuccess == true) {
	'sceenshot add product successful'
	WebUI.takeScreenshot()
}


'begin remove product'
boolean removeSuccess = true
if (randomNumberOfProduct > 0) {  
    'random number of product will remove'
    //int numberProductRemove = CustomKeywords.'ticket1.ticket1_Main.getIndexCartItemRandom'()

	int numberProductRemove = 1    
    int countProduct = 0

    for (int index = 1; index <= numberProductRemove; index++) {
        
        'get product remove'
        Map product = CustomKeywords.'ticket1.ticket1_Main.getInfoProductRemove'(index)

        'add product into list remove '
        listProductRemove.add(product)

        WebUI.click(findTestObject('Object Repository/ticket1/saucedemo/btn_remove_cart_item', [('index') : index]))

        'index -1 because size of list product -1'
        index = (index - 1)

        countProduct++

        'loop until countProduct = numberProductRemove'
        if (countProduct == numberProductRemove) {
            break
        }
    }
    
    'verify remove successful list product'
    int numberProductRemoveFail = CustomKeywords.'ticket1.ticket1_Main.VerifyRemoveSuccessProduct'(listProductRemove)

    if (numberProductRemoveFail != 0) {
        KeywordUtil.markError('Add product fail')
		removeSuccess = false
    }	
}
if(removeSuccess == true) {
	WebUI.takeScreenshot()
}

'checkout'
boolean checkoutSuccess = true
WebUI.click(findTestObject('Object Repository/ticket1/saucedemo/btn_checkout'))
'fill info'
WebUI.setText(findTestObject('Object Repository/ticket1/checkout/firstname'), "diu")
WebUI.setText(findTestObject('Object Repository/ticket1/checkout/last_name'), "nguyen")
WebUI.setText(findTestObject('Object Repository/ticket1/checkout/postal_code'), "test")
'continue'
WebUI.click(findTestObject('Object Repository/ticket1/checkout/btn_continue'))
'finish'
WebUI.click(findTestObject('Object Repository/ticket1/checkout/btn_finish'))
'verify checkout success'
if(!WebUI.verifyElementText(findTestObject('Object Repository/ticket1/checkout/span_complete'), 'Checkout: Complete!', FailureHandling.STOP_ON_FAILURE)) {
	checkoutSuccess = false
}
if(checkoutSuccess == true) {
	WebUI.takeScreenshot("checkout_success.png")
}
WebUI.closeBrowser()