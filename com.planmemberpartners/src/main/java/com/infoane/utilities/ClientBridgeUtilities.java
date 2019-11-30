package com.infoane.utilities;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.infoane.pages.ClientBridgePage;

public class ClientBridgeUtilities extends ReportsUtilities{
	ClientBridgePage objClientBridgePage = PageFactory.initElements(SeleniumUtilities.getDriver(), ClientBridgePage.class);
	
	public void clickClientBridgeHmeOff() {
		try {
			//Switch frame
			SeleniumUtilities.WEB_FrameSwitching("frameelement", 0, null, objClientBridgePage.getMenuFrame());
			
			//Switch frame
			SeleniumUtilities.WEB_FrameSwitching("frameelement", 0, null, objClientBridgePage.getSlideMenuBarFrame());
			
			//click client bridge
			SeleniumUtilities.WEB_Click(objClientBridgePage.getClientBridgeHmeOffLnk(), "Client Bridge for Home Office");
			
			//Switch to default
			SeleniumUtilities.WEB_switchToDefaultContent();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void checkSSN_Search(String ssn) {
		try {
			//click client bridge for home office
			clickClientBridgeHmeOff();
			
			//Switch frame
			SeleniumUtilities.WEB_FrameSwitching("frameelement", 0, null, objClientBridgePage.getMainFrame());
			
			//Enter SSN
			SeleniumUtilities.WEB_SendKeys(objClientBridgePage.getSSNEdt(), "SSN/TIN", ssn);
			
			//Click search
			SeleniumUtilities.WEB_Click(objClientBridgePage.getSearchBtn(), "Search");
			
			//verifying the search result
			String searchSSN = SeleniumUtilities.WEB_getVisibleText(objClientBridgePage.getSearchResults_SSN()).replace("-", "");
			
			if(ssn.equals(searchSSN)) {
				logger.log(Status.PASS, "Search Results are matched with the given SSN");
			}else {
				logger.log(Status.FAIL, "Search Results are not matched with the given SSN");
				Assert.fail();
			}
			
			//Switch to default
			SeleniumUtilities.WEB_switchToDefaultContent();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void checkAccNumSearch(String accNum) {
		//Variable declaration
		String actlAccntNum = null;
		boolean accntFound = false;
	
		try {
			//click client bridge for home office
			clickClientBridgeHmeOff();
			
			//Switch frame
			SeleniumUtilities.WEB_FrameSwitching("frameelement", 0, null, objClientBridgePage.getMainFrame());
			
			//Enter account number
			SeleniumUtilities.WEB_SendKeys(objClientBridgePage.getAccNumEdt(), "Account Number", accNum);
			
			//click search
			SeleniumUtilities.WEB_Click(objClientBridgePage.getSearchBtn(), "Search");
			
			//click account name
			SeleniumUtilities.WEB_Click(objClientBridgePage.getSearchResults_FullName(), SeleniumUtilities.WEB_getVisibleText(objClientBridgePage.getSearchResults_FullName()));
			
			//verifying the search result
			List<WebElement> searchAccNums = objClientBridgePage.getSearchResults_AccNum();
			
			for(WebElement element:searchAccNums) {		
				actlAccntNum = SeleniumUtilities.WEB_getVisibleText(element);
				
				//condition to check account number found or not
				if(accNum.equals(actlAccntNum)) {
					accntFound = true;
				}
			}
			
			if(accntFound) {
				logger.log(Status.PASS, "Search results are matched with the given Account Number");
			}else {
				logger.log(Status.FAIL, "Search results are not matched with the given Account Number");
				Assert.fail();
			}
			
			//Switch to default
			SeleniumUtilities.WEB_switchToDefaultContent();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void checkAccNameSearch(String accName) {
		try {
			//click client bridge for home office
			clickClientBridgeHmeOff();
			
			//Switch frame
			SeleniumUtilities.WEB_FrameSwitching("frameelement", 0, null, objClientBridgePage.getMainFrame());
			
			//Enter account name
			SeleniumUtilities.WEB_SendKeys(objClientBridgePage.getFullNameEdt(), "Account Name", accName);
			
			//click search
			SeleniumUtilities.WEB_Click(objClientBridgePage.getSearchBtn(), "Search");
			
			//verifying the search result
			String searchFullName = SeleniumUtilities.WEB_getVisibleText(objClientBridgePage.getSearchResults_FullName());
			
			if(accName.equals(searchFullName)) {
				logger.log(Status.PASS, "Search results are matched with the given Account Name");
			}else {
				logger.log(Status.FAIL, "Search results are not matched with the given Account Name");
				Assert.fail();
			}
			
			//Switch to default
			SeleniumUtilities.WEB_switchToDefaultContent();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void checkFirstNameSearch(String firstName) {
		try {
			//click client bridge for home office
			clickClientBridgeHmeOff();
			
			//Switch frame
			SeleniumUtilities.WEB_FrameSwitching("frameelement", 0, null, objClientBridgePage.getMainFrame());
			
			//click advance search
			SeleniumUtilities.WEB_Click(objClientBridgePage.getShowAdvSearchBtn(), "Show Advance Search");
			
			//Enter first name
			SeleniumUtilities.WEB_SendKeys(objClientBridgePage.getFNameEdt(), "First Name", firstName);
			
			//click search
			SeleniumUtilities.WEB_Click(objClientBridgePage.getSearchBtn(), "Search");
			
			//verifying the search result
			String searchFullName = SeleniumUtilities.WEB_getVisibleText(objClientBridgePage.getSearchResults_FullName());
			
			if(searchFullName.contains(firstName)) {
				logger.log(Status.PASS, "Search results are matched with the given First Name");
			}else {
				logger.log(Status.FAIL, "Search results are not matched with the given First Name");
				Assert.fail();
			}
			
			//Switch to default
			SeleniumUtilities.WEB_switchToDefaultContent();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void checkLastNameSearch(String lastName) {
		try {
			//click client bridge for home office
			clickClientBridgeHmeOff();
			
			//Switch frame
			SeleniumUtilities.WEB_FrameSwitching("frameelement", 0, null, objClientBridgePage.getMainFrame());
			
			//click advance search
			SeleniumUtilities.WEB_Click(objClientBridgePage.getShowAdvSearchBtn(), "Show Advance Search");
			
			//Enter last name
			SeleniumUtilities.WEB_SendKeys(objClientBridgePage.getLNameEdt(), "Last Name", lastName);
			
			//click search
			SeleniumUtilities.WEB_Click(objClientBridgePage.getSearchBtn(), "Search");
			
			//verifying the search result
			String searchFullName = SeleniumUtilities.WEB_getVisibleText(objClientBridgePage.getSearchResults_FullName());
			
			if(searchFullName.contains(lastName)) {
				logger.log(Status.PASS, "Search results are matched with the given Last Name");
			}else {
				logger.log(Status.FAIL, "Search results are not matched with the given Last Name");
				Assert.fail();
			}
			
			//Switch to default
			SeleniumUtilities.WEB_switchToDefaultContent();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void checkCitySearch(String city) {
		try {
			//click client bridge for home office
			clickClientBridgeHmeOff();
			
			//Switch frame
			SeleniumUtilities.WEB_FrameSwitching("frameelement", 0, null, objClientBridgePage.getMainFrame());
			
			//click advance search
			SeleniumUtilities.WEB_Click(objClientBridgePage.getShowAdvSearchBtn(), "Show Advance Search");
			
			//Enter city
			SeleniumUtilities.WEB_SendKeys(objClientBridgePage.getCityEdt(), "City", city);
			
			//click search
			SeleniumUtilities.WEB_Click(objClientBridgePage.getSearchBtn(), "Search");
			
			//verifying the search result
			String searchCity = SeleniumUtilities.WEB_getVisibleText(objClientBridgePage.getSearchResults_city());
			
			if(searchCity.contains(city)) {
				logger.log(Status.PASS, "Search results are matched with the given City Name");
			}else {
				logger.log(Status.FAIL, "Search results are not matched with the given City Name");
				Assert.fail();
			}
			
			//Switch to default
			SeleniumUtilities.WEB_switchToDefaultContent();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void checkStateSearch(String state, String stateCode) {
		try {
			//click client bridge for home office
			clickClientBridgeHmeOff();
			
			//Switch frame
			SeleniumUtilities.WEB_FrameSwitching("frameelement", 0, null, objClientBridgePage.getMainFrame());
			
			//click advance search
			SeleniumUtilities.WEB_Click(objClientBridgePage.getShowAdvSearchBtn(), "Show Advance Search");
			
			//Select state
			SeleniumUtilities.WEB_selectValuesDrpDwn(objClientBridgePage.getStateDrpDwn(), "VISIBLETEXT", 0, null, state);
			
			//click search
			SeleniumUtilities.WEB_Click(objClientBridgePage.getSearchBtn(), "Search");
			
			//verifying the search result
			String searchState = SeleniumUtilities.WEB_getVisibleText(objClientBridgePage.getSearchResults_state());
			
			if(stateCode.equals(searchState)) {
				logger.log(Status.PASS, "Search results are matched with the given State Name");
			}else {
				logger.log(Status.FAIL, "Search results are not matched with the given State Name");
				Assert.fail();
			}
			
			//Switch to default
			SeleniumUtilities.WEB_switchToDefaultContent();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void checkZipCodeSearch(String zipCode) {
		try {
			//click client bridge for home office
			clickClientBridgeHmeOff();
			
			//Switch frame
			SeleniumUtilities.WEB_FrameSwitching("frameelement", 0, null, objClientBridgePage.getMainFrame());
			
			//click advance search
			SeleniumUtilities.WEB_Click(objClientBridgePage.getShowAdvSearchBtn(), "Show Advance Search");
			
			//Enter city
			SeleniumUtilities.WEB_SendKeys(objClientBridgePage.getZipCodeEdt(), "ZipCode", zipCode);
			
			//click search
			SeleniumUtilities.WEB_Click(objClientBridgePage.getSearchBtn(), "Search");
			
			//verifying the search result
			String searchZipCode = SeleniumUtilities.WEB_getVisibleText(objClientBridgePage.getSearchResults_ZipCode());
			
			if(searchZipCode.contains(zipCode)) {
				logger.log(Status.PASS, "Search results are matched with the given ZipCode Name");
			}else {
				logger.log(Status.FAIL, "Search results are not matched with the given ZipCode Name");
				Assert.fail();
			}
			
			//Switch to default
			SeleniumUtilities.WEB_switchToDefaultContent();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void checkAccDelvrySearch(String email) {
		try {
			//click client bridge for home office
			clickClientBridgeHmeOff();
			
			//Switch frame
			SeleniumUtilities.WEB_FrameSwitching("frameelement", 0, null, objClientBridgePage.getMainFrame());
			
			//click advance search
			SeleniumUtilities.WEB_Click(objClientBridgePage.getShowAdvSearchBtn(), "Show Advance Search");
			
			//Select state
			SeleniumUtilities.WEB_selectValuesDrpDwn(objClientBridgePage.getAccDelvryDrpDwn(), "VISIBLETEXT", 0, null, email);
			
			//click search
			SeleniumUtilities.WEB_Click(objClientBridgePage.getSearchBtn(), "Search");
			
			//wait for spinner to be disappeared
			SeleniumUtilities.WEB_isSpinnerClosed();
			
			//click account name
			SeleniumUtilities.WEB_Click(objClientBridgePage.getSearchResults_FullName(), SeleniumUtilities.WEB_getVisibleText(objClientBridgePage.getSearchResults_FullName()));
			
			//verifying the search result
			String searchEmail = SeleniumUtilities.WEB_getVisibleText(objClientBridgePage.getSearchResults_Email());
			
			if(!searchEmail.isEmpty()) {
				logger.log(Status.PASS, "Client email ID: "+searchEmail+" is present");
			}else {
				logger.log(Status.FAIL, "Client email is not present");
				Assert.fail();
			}
			
			//Switch to default
			SeleniumUtilities.WEB_switchToDefaultContent();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void checkStmtDelvrySearch(String email) {
		try {
			//click client bridge for home office
			clickClientBridgeHmeOff();
			
			//Switch frame
			SeleniumUtilities.WEB_FrameSwitching("frameelement", 0, null, objClientBridgePage.getMainFrame());
			
			//click advance search
			SeleniumUtilities.WEB_Click(objClientBridgePage.getShowAdvSearchBtn(), "Show Advance Search");
			
			//Select state
			SeleniumUtilities.WEB_selectValuesDrpDwn(objClientBridgePage.getStmtDelvryDrpDwn(), "VISIBLETEXT", 0, null, email);
			
			//click search
			SeleniumUtilities.WEB_Click(objClientBridgePage.getSearchBtn(), "Search");
			
			//wait for spinner to be disappeared
			SeleniumUtilities.WEB_isSpinnerClosed();
			
			//click account name
			SeleniumUtilities.WEB_Click(objClientBridgePage.getSearchResults_FullName(), SeleniumUtilities.WEB_getVisibleText(objClientBridgePage.getSearchResults_FullName()));
			
			//verifying the search result
			String searchEmail = SeleniumUtilities.WEB_getVisibleText(objClientBridgePage.getSearchResults_Email());
			
			if(!searchEmail.isEmpty()) {
				logger.log(Status.PASS, "Client email ID: "+searchEmail+" is present");
			}else {
				logger.log(Status.FAIL, "Client email is not present");
				Assert.fail();
			}
			
			//Switch to default
			SeleniumUtilities.WEB_switchToDefaultContent();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void checkAccntTypeSearch(String accntType) {
		try {
			//click client bridge for home office
			clickClientBridgeHmeOff();
			
			//Switch frame
			SeleniumUtilities.WEB_FrameSwitching("frameelement", 0, null, objClientBridgePage.getMainFrame());
			
			//click advance search
			SeleniumUtilities.WEB_Click(objClientBridgePage.getShowAdvSearchBtn(), "Show Advance Search");
			
			//Select state
			SeleniumUtilities.WEB_selectValuesDrpDwn(objClientBridgePage.getStmtDelvryDrpDwn(), "VISIBLETEXT", 0, null, accntType);
			
			//click search
			SeleniumUtilities.WEB_Click(objClientBridgePage.getSearchBtn(), "Search");
			
			//wait for spinner to be disappeared
			SeleniumUtilities.WEB_isSpinnerClosed();
			
			//click account name
			SeleniumUtilities.WEB_Click(objClientBridgePage.getSearchResults_FullName(), SeleniumUtilities.WEB_getVisibleText(objClientBridgePage.getSearchResults_FullName()));
			
			//verifying the search result
			String searchEmail = SeleniumUtilities.WEB_getVisibleText(objClientBridgePage.getSearchResults_Email());
			
			if(!searchEmail.isEmpty()) {
				logger.log(Status.PASS, "Client email ID: "+searchEmail+" is present");
			}else {
				logger.log(Status.FAIL, "Client email is not present");
				Assert.fail();
			}
			
			//Switch to default
			SeleniumUtilities.WEB_switchToDefaultContent();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}