package com.infoane.utilities;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.infoane.pages.LogInOutPage;

public class LogInOutUtilities extends ReportsUtilities{
	
	//Page Factory
	LogInOutPage objLogInOutPage = PageFactory.initElements(SeleniumUtilities.getDriver(), LogInOutPage.class);
	
	/**
	 * @author svupala
	 * @purpose logIn into the application
	 * @param userName
	 * @param passWord
	 */
	public void login(String userName, String passWord) {
		try {
			// enter userName
			SeleniumUtilities.WEB_SendKeys(objLogInOutPage.getUserNameEdt(), "UserName", userName);
			
			// enter password
			SeleniumUtilities.WEB_SendKeys(objLogInOutPage.getPasswordEdt(), "Password", passWord);
			
			// click signIn button
			SeleniumUtilities.WEB_Click(objLogInOutPage.getSignInBtn(), "SignIn");
			
			// switch frame
			SeleniumUtilities.WEB_FrameSwitching("frameelement", 0, null, objLogInOutPage.getTopFrame());
			
			// click logout button
			if(SeleniumUtilities.WEB_isDisplayed(objLogInOutPage.getRgtLogoutBtn())) {
				logger.log(Status.PASS, "LogIn Successful");
			}else {
				logger.log(Status.FAIL, "LogIn is not Successful");
				Assert.fail("LogIn is not Successful");
			}
			
			//Switch to main window
			SeleniumUtilities.WEB_switchToDefaultContent();
			
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	/**
	 * @author svupala
	 * @purpose logOut from the application
	 */
	public void logOut() {
		try {
			// switch frame
			SeleniumUtilities.WEB_FrameSwitching("frameelement", 0, null, objLogInOutPage.getTopFrame());
			
			// click logout button
			SeleniumUtilities.WEB_Click(objLogInOutPage.getRgtLogoutBtn(), "LogOut");
			
			// check for logout successful or not
			if(SeleniumUtilities.WEB_isDisplayed(objLogInOutPage.getSignInBtn())) {
				logger.log(Status.PASS, "Logout Successful");
			}else {
				logger.log(Status.FAIL, "Logout is not Successful");
				Assert.fail();
			}
		}catch(Exception e) {
			
		}
	}
}