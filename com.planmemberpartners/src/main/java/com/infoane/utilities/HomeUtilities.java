package com.infoane.utilities;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.infoane.pages.HomePage;

public class HomeUtilities extends LogInOutUtilities{
	
	//Page Factory
	HomePage objHomePage = PageFactory.initElements(driver, HomePage.class);

	public void connectRepresentative(String lastNameValue) {
		try {
			if(SeleniumUtilities.WEB_isDisplayed(objHomePage.getMenuFrame())) {
				//switching to menu frame
				SeleniumUtilities.WEB_FrameSwitching("nameorid", 0, "menuFrame", null);
				
				//switching to slidemenubar2
				SeleniumUtilities.WEB_FrameSwitching("nameorid", 0, "slidemenubar2", null);
				
				//clicking on 'Systems Bridge'
				SeleniumUtilities.WEB_Click(objHomePage.getSystemsBridgeLnk(), "SystemsBridge");
				
				//switching back from frame
				SeleniumUtilities.WEB_switchToDefaultContent();
			}else {
				logger.log(Status.FAIL, "Frame is not loaded");
			}
			if(SeleniumUtilities.WEB_isDisplayed(objHomePage.getMain())) {
				//switch to main frame
				SeleniumUtilities.WEB_FrameSwitching("nameorid", 0, "main", null);
				
				//select representative
				SeleniumUtilities.WEB_selectValuesDrpDwn(objHomePage.getRepList(), "VALUE", 0, lastNameValue, null);
				
				//clicking on loginToPartners
				SeleniumUtilities.WEB_Click(objHomePage.getLoginToPartnersBtn(), "loginToPartners");
			}else {
				logger.log(Status.FAIL, "Frame is not loaded");
			}
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}