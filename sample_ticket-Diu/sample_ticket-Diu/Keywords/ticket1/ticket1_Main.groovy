package ticket1

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

import groovy.json.internal.Exceptions

import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import org.openqa.selenium.WebElement as WebElement
import internal.GlobalVariable
import org.openqa.selenium.By
import com.kms.katalon.core.exception.StepFailedException
import  com.kms.katalon.core.webui.exception.WebElementNotFoundException


public class ticket1_Main {
	public int countListProduct() {
		List<WebElement> listProduct = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ticket1/saucedemo/list_product'), 10)
		int count = listProduct.size()
		return count
	}
	@Keyword
	public int countListCartItem() {
		List<WebElement> listCart = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ticket1/saucedemo/list_cart_item'), 10)
		int count = listCart.size()
		return count
	}
	@Keyword
	public int getIndexCartItemRandom() {
		int count = countListCartItem()
		int indexRandom = new Random().nextInt(count - 1 + 1) + 1
		return indexRandom
	}

	@Keyword
	public int getIndexRandom() {
		int count = countListProduct()
		int indexRandom = new Random().nextInt(count - 1 + 1) + 1
		return indexRandom
	}

	@Keyword
	public boolean verifyElementPresent(TestObject object) {
		try {
			WebUiCommonHelper.findWebElement(object, 5)
			return true
		}catch(Exception e) {
			return false
		}
	}
	public Map getListInfoProduct() {
		def mapListInfo = [:]

		def isVisible
//		WebUI.refresh()
//		try {
//			WebUI.verifyElementPresent(findTestObject('Object Repository/ticket1/saucedemo/btn_shopping_cart'),  3)
//			isVisible = true
//		}
//		catch(StepFailedException e ) {
//			isVisible = false
//		}catch(WebElementNotFoundException e ) {
//			isVisible = false
//		}
		
		if(verifyElementPresent(findTestObject('Object Repository/ticket1/saucedemo/btn_shopping_cart'))) {
			isVisible = true
		}else {
			isVisible = false
		}

		if(isVisible) {

			List<WebElement> listName = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ticket1/saucedemo/list_name'), 10)
			def names = []
			for(WebElement name in listName) {
				names.add(name.text)
			}
			List<WebElement> listDesc = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ticket1/saucedemo/list_decs'), 10)
			def decs = []
			for(WebElement dec in listDesc) {
				decs.add(dec.text)
			}
			List<WebElement> listPrices = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/ticket1/saucedemo/list_price'), 10)
			def Prices = []
			for(WebElement Price in listPrices) {
				Prices.add(Price.text)
			}
			int length = names.size()
			if(length >= 1) {
				for ( int index in 0..(length-1)) {
					def mapInfo = [:]
					mapInfo.put("name",names[index] )
					mapInfo.put("decs",decs[index] )
					mapInfo.put("price",Prices[index] )
					mapListInfo.put(names[index],mapInfo )
				}
			}
		}


		return mapListInfo
	}
	@Keyword
	public Map getProductQuick(int index) {
		String nameProduct = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ticket1/saucedemo/name_product', [('index'): index]), 10).text
		String priceProduct = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ticket1/saucedemo/price_product',[('index'): index]), 10).text
		String descProduct = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ticket1/saucedemo/decs_product',[('index'): index]), 10).text
		//String imgProduct = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ticket1/saucedemo/img_product',[('index'): index]), 10).text
		def info = [:]
		info.put("name", nameProduct)
		info.put("decs", descProduct)
		info.put("price", priceProduct)
		//info.put("img", imgProduct)
		return info
	}
	@Keyword
	public Map getDetailProduct(int index) {
		String nameProduct = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ticket1/saucedemo/name_product', [('index'): index]), 10).text
		String priceProduct = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ticket1/saucedemo/price_product',[('index'): index]), 10).text
		String descProduct = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ticket1/saucedemo/decs_product',[('index'): index]), 10).text
		String imgProduct = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ticket1/saucedemo/img_product',[('index'): index]), 10).getAttribute('src')

		def info = [:]
		info.put("name", nameProduct)
		info.put("decs", descProduct)
		info.put("price", priceProduct)
		info.put("img", imgProduct)
		return info
	}

	public int VerifyDetailProduct(Map product) {
		String nameProduct = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ticket1/detail/name_detail'), 10).text
		String priceProduct = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ticket1/detail/price-detail'), 10).text
		String descProduct = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ticket1/detail/decs_detail'), 10).text
		String imgProduct = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ticket1/detail/img_detail'), 10).getAttribute('src')
		Map detail = [:]
		detail.put("name", nameProduct)
		detail.put("decs", descProduct)
		detail.put("price", priceProduct)
		detail.put("img", imgProduct)

		int count = 0

		if(detail.equals(product)) {
			count = count + 1
		}
		WebUI.click(findTestObject('Object Repository/ticket1/detail/back_to_cart'))
		' navigate to cart page'
		WebUI.click(findTestObject('Object Repository/ticket1/saucedemo/btn_shopping_cart'))

		return count
	}

	@Keyword
	public int VerifyListDetailProduct(List<Map> products) {
		int length = countListCartItem()
		int count = 0
		for( int index = 0; index <length; index ++ ) {
			WebUI.click(findTestObject('Object Repository/ticket1/saucedemo/name_cart_item', [('index'): index+1]))
			count = VerifyDetailProduct(products.get(index)) + count
		}
		return count
	}

	@Keyword
	public int VerifyInfoProduct(List<Map> products) {
		def listInfo = getListInfoProduct()

		int count =0
		for (product in products) {
			for(item in listInfo) {
				if(item.value.equals(product)) {
					count = count +1
				}
			}
		}

		return count
	}
	@Keyword
	public Map getInfoProductRemove(int index) {
		String nameProduct = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ticket1/saucedemo/name_cart_item', [('index'): index]), 10).text
		String priceProduct = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ticket1/saucedemo/price_cart_item',[('index'): index]), 10).text
		String descProduct = WebUiCommonHelper.findWebElement(findTestObject('Object Repository/ticket1/saucedemo/decs_cart_item',[('index'): index]), 10).text
		def info = [:]
		info.put("name", nameProduct)
		info.put("decs", descProduct)
		info.put("price", priceProduct)
		return info
	}

	@Keyword
	public int VerifyRemoveSuccessProduct(List<Map> products) {
		def listInfo = getListInfoProduct()
		int count =0
		if( listInfo.size() > 0) {

			for (product in products) {
				for(item in listInfo) {
					if(item.value.equals(product)) {
						count = count +1
					}
				}
			}
		}

		return count
	}
}
