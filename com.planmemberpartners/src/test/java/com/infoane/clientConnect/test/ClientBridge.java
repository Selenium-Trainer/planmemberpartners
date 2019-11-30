package com.infoane.clientConnect.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.infoane.utilities.ClientBridgeUtilities;
import com.infoane.utilities.LogInOutUtilities;
import com.infoane.utilities.SeleniumUtilities;

public class ClientBridge extends SeleniumUtilities{

	//Test Data 
	@DataProvider(name = "ssn_search")
	public Object[][] ssn_search() throws Exception {
		Object[][] retObjArr = WEB_GetExcelData(path, "clientBridge", "ssn_search");
		return retObjArr;
	}
	
	//Test Data 
	@DataProvider(name = "accNum_search")
	public Object[][] accNum_search() throws Exception {
		Object[][] retObjArr = WEB_GetExcelData(path, "clientBridge", "accNum_search");
		return retObjArr;
	}
	
	//Test Data 
	@DataProvider(name = "accName_search")
	public Object[][] accName_search() throws Exception {
		Object[][] retObjArr = WEB_GetExcelData(path, "clientBridge", "accName_search");
		return retObjArr;
	}
	
	//Test Data 
	@DataProvider(name = "fName_search")
	public Object[][] fName_search() throws Exception {
		Object[][] retObjArr = WEB_GetExcelData(path, "clientBridge", "fName_search");
		return retObjArr;
	}
	
	//Test Data 
	@DataProvider(name = "lName_search")
	public Object[][] lName_search() throws Exception {
		Object[][] retObjArr = WEB_GetExcelData(path, "clientBridge", "lName_search");
		return retObjArr;
	}
	
	//Test Data 
	@DataProvider(name = "city_search")
	public Object[][] city_search() throws Exception {
		Object[][] retObjArr = WEB_GetExcelData(path, "clientBridge", "city_search");
		return retObjArr;
	}
	
	//Test Data 
	@DataProvider(name = "state_search")
	public Object[][] state_search() throws Exception {
		Object[][] retObjArr = WEB_GetExcelData(path, "clientBridge", "state_search");
		return retObjArr;
	}
	
	//Test Data 
	@DataProvider(name = "zipCode_search")
	public Object[][] zipCode_search() throws Exception {
		Object[][] retObjArr = WEB_GetExcelData(path, "clientBridge", "zipCode_search");
		return retObjArr;
	}
	
	//Test Data 
	@DataProvider(name = "email_search")
	public Object[][] email_search() throws Exception {
		Object[][] retObjArr = WEB_GetExcelData(path, "clientBridge", "email_search");
		return retObjArr;
	}
	
	//Test Data 
	@DataProvider(name = "accntType")
	public Object[][] accntType() throws Exception {
		Object[][] retObjArr = WEB_GetExcelData(path, "clientBridge", "accntType");
		return retObjArr;
	}
	
	@Test(priority=1, dataProvider="ssn_search", enabled=false)
	public void checkSSNsearchFuncty(String userName, String passWord, String ssn) {
		//Instance creation
		LogInOutUtilities objLogInOutUtilities = new LogInOutUtilities();
		ClientBridgeUtilities objClientBridgeUtilities = new ClientBridgeUtilities();
		
		try {
			//logIn into the application
			objLogInOutUtilities.login(userName, passWord);
			
			//Check SSN search functionality
			objClientBridgeUtilities.checkSSN_Search(ssn);
			
			//logout
			objLogInOutUtilities.logOut();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=2, dataProvider="accNum_search", enabled=false)
	public void checkAccNumSearchFuncty(String userName, String passWord, String accNum) {
		//Instance creation
		LogInOutUtilities objLogInOutUtilities = new LogInOutUtilities();
		ClientBridgeUtilities objClientBridgeUtilities = new ClientBridgeUtilities();
		
		try {
			//logIn into the application
			objLogInOutUtilities.login(userName, passWord);
			
			//Check SSN search functionality
			objClientBridgeUtilities.checkAccNumSearch(accNum);
			
			//logout
			objLogInOutUtilities.logOut();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=3, dataProvider="accName_search", enabled=false)
	public void checkAccNameSearchFuncty(String userName, String passWord, String accName) {
		//Instance creation
		LogInOutUtilities objLogInOutUtilities = new LogInOutUtilities();
		ClientBridgeUtilities objClientBridgeUtilities = new ClientBridgeUtilities();
		
		try {
			//logIn into the application
			objLogInOutUtilities.login(userName, passWord);
			
			//Check SSN search functionality
			objClientBridgeUtilities.checkAccNameSearch(accName);
			
			//logout
			objLogInOutUtilities.logOut();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=4, dataProvider="fName_search", enabled=false)
	public void checkFirstNameSearchFuncty(String userName, String passWord, String firstName) {
		//Instance creation
		LogInOutUtilities objLogInOutUtilities = new LogInOutUtilities();
		ClientBridgeUtilities objClientBridgeUtilities = new ClientBridgeUtilities();
		
		try {
			//logIn into the application
			objLogInOutUtilities.login(userName, passWord);
			
			//Check SSN search functionality
			objClientBridgeUtilities.checkFirstNameSearch(firstName);
			
			//logout
			objLogInOutUtilities.logOut();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=5, dataProvider="lName_search", enabled=false)
	public void checkLastNameSearchFuncty(String userName, String passWord, String lastName) {
		//Instance creation
		LogInOutUtilities objLogInOutUtilities = new LogInOutUtilities();
		ClientBridgeUtilities objClientBridgeUtilities = new ClientBridgeUtilities();
		
		try {
			//logIn into the application
			objLogInOutUtilities.login(userName, passWord);
			
			//Check SSN search functionality
			objClientBridgeUtilities.checkLastNameSearch(lastName);
			
			//logout
			objLogInOutUtilities.logOut();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=6, dataProvider="city_search", enabled=false)
	public void checkCitySearchFuncty(String userName, String passWord, String city) {
		//Instance creation
		LogInOutUtilities objLogInOutUtilities = new LogInOutUtilities();
		ClientBridgeUtilities objClientBridgeUtilities = new ClientBridgeUtilities();
		
		try {
			//logIn into the application
			objLogInOutUtilities.login(userName, passWord);
			
			//Check SSN search functionality
			objClientBridgeUtilities.checkCitySearch(city);
			
			//logout
			objLogInOutUtilities.logOut();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=7, dataProvider="state_search", enabled=false)
	public void checkStateSearchFuncty(String userName, String passWord, String state, String stateCode) {
		//Instance creation
		LogInOutUtilities objLogInOutUtilities = new LogInOutUtilities();
		ClientBridgeUtilities objClientBridgeUtilities = new ClientBridgeUtilities();
		
		try {
			//logIn into the application
			objLogInOutUtilities.login(userName, passWord);
			
			//Check SSN search functionality
			objClientBridgeUtilities.checkStateSearch(state, stateCode);
			
			//logout
			objLogInOutUtilities.logOut();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=8, dataProvider="zipCode_search", enabled=false)
	public void checkZipCodeSearchFuncty(String userName, String passWord, String zipCode) {
		//Instance creation
		LogInOutUtilities objLogInOutUtilities = new LogInOutUtilities();
		ClientBridgeUtilities objClientBridgeUtilities = new ClientBridgeUtilities();
		
		try {
			//logIn into the application
			objLogInOutUtilities.login(userName, passWord);
			
			//Check SSN search functionality
			objClientBridgeUtilities.checkZipCodeSearch(zipCode);
			
			//logout
			objLogInOutUtilities.logOut();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=9, dataProvider="email_search", enabled=false)
	public void checkAccDelvrySearchFuncty(String userName, String passWord, String email) {
		//Instance creation
		LogInOutUtilities objLogInOutUtilities = new LogInOutUtilities();
		ClientBridgeUtilities objClientBridgeUtilities = new ClientBridgeUtilities();
		
		try {
			//logIn into the application
			objLogInOutUtilities.login(userName, passWord);
			
			//Check SSN search functionality
			objClientBridgeUtilities.checkAccDelvrySearch(email);
			
			//logout
			objLogInOutUtilities.logOut();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=10, dataProvider="email_search", enabled=true)
	public void checkStmtDelvrySearchFuncty(String userName, String passWord, String email) {
		//Instance creation
		LogInOutUtilities objLogInOutUtilities = new LogInOutUtilities();
		ClientBridgeUtilities objClientBridgeUtilities = new ClientBridgeUtilities();
		
		try {
			//logIn into the application
			objLogInOutUtilities.login(userName, passWord);
			
			//Check SSN search functionality
			objClientBridgeUtilities.checkStmtDelvrySearch(email);
			
			//logout
			objLogInOutUtilities.logOut();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}