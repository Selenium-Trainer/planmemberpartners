package com.infoane.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.infoane.utilities.SeleniumUtilities;

public class LogInOutPage {
	
	// UserName input field
	@FindBy(id="userName")
	private WebElement userNameEdt;

	public WebElement getUserNameEdt() {
		SeleniumUtilities.WEB_ExplicitWait(userNameEdt);
		return userNameEdt;
	}

	// Password input field
	@FindBy(name="password")
	private WebElement passwordEdt;

	public WebElement getPasswordEdt() {
		SeleniumUtilities.WEB_ExplicitWait(passwordEdt);
		return passwordEdt;
	}

	// SignIn Button
	@FindBy(id="submitBtn")
	private WebElement signInBtn;

	public WebElement getSignInBtn() {
		SeleniumUtilities.WEB_ExplicitWait(signInBtn);
		return signInBtn;
	}
	
	// Frame
	@FindBy(name="partnerTopFrame")
	private WebElement topFrame;
	
	public WebElement getTopFrame() {
		SeleniumUtilities.WEB_ExplicitWait(topFrame);
		return topFrame;
	}

	// Logout Button
	@FindBy(xpath="//td[@align='right']//a[text()='Logout']")
	private WebElement rgtLogoutBtn;

	public WebElement getRgtLogoutBtn() {
		SeleniumUtilities.WEB_ExplicitWait(rgtLogoutBtn);
		return rgtLogoutBtn;
	}
}