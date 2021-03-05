package utils;

public class ExcelOperations {

	String filePath;

	public ExcelOperations() throws Exception {
		filePath = System.getProperty("user.dir") + PropertiesReader.getPropertyValueByKey("testData");
	}

	public void getTestData() throws Exception {

		// TODO 
		
		// for working with Excel, we need dependencies for Apache-poi (pom.xml)
		// use WorkBook Factory

		// location

		// open

		// read and fill map
	}
}
