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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement

WebUI.openBrowser(GlobalVariable.browserURL)

// find current price
List<WebElement> prices = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/price_list'), 10)
Random rand = new Random()
random_num = rand.nextInt(prices.size()+1)
String curentPrice = prices.get(random_num).text

WebUI.delay(2)

// list title
List<WebElement> titles = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/titles'), 10)

index_column = 0

for (int i : (0..titles.size() - 1)) {
    String temp = titles.get(i).text

    if (temp == 'Current Price (Rs)') {
        index_column = i

        break
    }
}

// find element
List<WebElement> price_list = []

result = [:]

if (price_list.isEmpty()) {
    price_list = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/prices', [('price') : curentPrice]), 
        10)

    for (int i : (0..1)) {
        if (price_list.isEmpty()) {
            WebUI.refresh()

            WebUI.delay(2)

            price_list = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/prices', [('price') : curentPrice]), 
                10)
        } else {
            List<WebElement> rows = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/rows'), 10)

            int row_count = rows.size()

            for (int index_row : (0..row_count - 1)) {
                columns = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/columns', [('index') : index_row + 
                            1]), 10)

                int column_count = columns.size()

                String price_cell = columns.get(3).text

                if (price_cell == curentPrice) {
					def timestamp = new Date().format("YYYYMMdd_HHmmss")
					WebUI.takeElementScreenshot("D://screenShot//"+ curentPrice +timestamp+".png", WebUI.convertWebElementToTestObject(rows.get(index_row)))
                    String row = 'Row : ' + (index_row + 1)

                    String column = 'Column : ' + (index_column + 1)

                    result.put(row, column)
                }
            }
            
            println("Vị trí của : "+ curentPrice)

            result.each({ def entry ->
                    println("$entry.key: $entry.value")
                })

            break
        }
    }
    
    if (price_list.isEmpty()) {
		println("Not Find element")
    }
}