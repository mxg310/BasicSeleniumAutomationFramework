package utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {

	public void selectDropdownOption(WebElement ele, String value) throws Exception {
		Select os = new Select(ele);
		try {
			os.selectByVisibleText(value);
		} catch (Exception e) {
			throw new Exception("Value not available to select from : " + ele + " for value: " + value);
		}
	}

	public void selectRadioOption(List<WebElement> listElements, String value) {
		for (WebElement ele : listElements) {
			if (ele.getText().endsWith(value)) {
				ele.click();
				break;
			}
		}
	}

	public void selectCheckBoxes(List<WebElement> listElements, String values) {
		String[] aStrings =  values.split(",");
		for (WebElement ele : listElements) {
			for(String val: aStrings) {
				if(ele.getText().equalsIgnoreCase(val) ) {
					ele.click();
					break;
				}
			}
		}
	}
	
	public List<String> getDropdownOptions_asList(WebElement element) {
		Select os = new Select(element);
		List<String> listOfValues = new ArrayList<String>();
		for (WebElement ele : os.getOptions()) {
			listOfValues.add(ele.getText());
		}
		return listOfValues;
	}
}
