package com.infoane.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.infoane.utilities.SeleniumUtilities;

public class HomePage extends LogInOutPage{

	@FindBy(xpath="//a[text()='SystemsBridge']")
	private WebElement systemsBridgeLnk;
	
	public WebElement getSystemsBridgeLnk() {
		SeleniumUtilities.WEB_ExplicitWait(systemsBridgeLnk);
		return systemsBridgeLnk;
	}
	
	@FindBy(xpath="//div[normalize-space(text())='Last Name:']/input")
	private WebElement lastNameEdt;
	
	public WebElement getLastNameEdt() {
		SeleniumUtilities.WEB_ExplicitWait(lastNameEdt);
		return lastNameEdt;
	}
	
	@FindBy(name="menuFrame")
	private WebElement menuFrame;
	
	public WebElement getMenuFrame() {
		SeleniumUtilities.WEB_ExplicitWait(menuFrame);
		return menuFrame;
	}
	
	@FindBy(name="main")
	private WebElement main;
	
	public WebElement getMain() {
		SeleniumUtilities.WEB_ExplicitWait(main);
		return main;
	}
	
	@FindBy(name="RepOnly")
	private WebElement fetchRepBtn;
	
	public WebElement getFetchRepBtn() {
		SeleniumUtilities.WEB_ExplicitWait(fetchRepBtn);
		return fetchRepBtn;
	}
	
	@FindBy(xpath="//select[@name='AdminRep']")
	private WebElement repList;
	
	public WebElement getRepList() {
		SeleniumUtilities.WEB_ExplicitWait(repList);
		return repList;
	}
	
	@FindBy(xpath="//input[contains(@onclick,'LoginAs')]")
	private WebElement loginToPartnersBtn;
	
	public WebElement getLoginToPartnersBtn() {
		SeleniumUtilities.WEB_ExplicitWait(loginToPartnersBtn);
		return loginToPartnersBtn;
	}
}
