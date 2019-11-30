package com.infoane.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.infoane.utilities.SeleniumUtilities;

public class ClientBridgePage extends LogInOutPage{

	@FindBy(name="menuFrame")
	private WebElement menuFrame;
	
	public WebElement getMenuFrame() {
		SeleniumUtilities.WEB_ExplicitWait(menuFrame);
		return menuFrame;
	}
	
	@FindBy(xpath="//a[text()='Client Bridge for Home Office']")
	private WebElement clientBridgeHmeOffLnk;
	
	public WebElement getClientBridgeHmeOffLnk() {
		SeleniumUtilities.WEB_ExplicitWait(clientBridgeHmeOffLnk);
		return clientBridgeHmeOffLnk;
	}
	
	@FindBy(name="main")
	private WebElement mainFrame;
	
	public WebElement getMainFrame() {
		SeleniumUtilities.WEB_ExplicitWait(mainFrame);
		return mainFrame;
	}
	
	@FindBy(id="slidemenubar2")
	private WebElement slideMenuBar;
	
	public WebElement getSlideMenuBarFrame() {
		SeleniumUtilities.WEB_ExplicitWait(slideMenuBar);
		return slideMenuBar;
	}
	
	@FindBy(id="SSN")
	private WebElement ssnEdt;
	
	public WebElement getSSNEdt() {
		SeleniumUtilities.WEB_ExplicitWait(ssnEdt);
		return ssnEdt;
	}
	
	@FindBy(id="SearchBtn")
	private WebElement searchBtn;
	
	public WebElement getSearchBtn() {
		SeleniumUtilities.WEB_ExplicitWait(searchBtn);
		return searchBtn;
	}

	@FindBy(xpath="//table[@id='ResultsDisplayTbl']/tbody/tr/td[4]")
	private WebElement searchResults_SSN;
	
	public WebElement getSearchResults_SSN() {
		SeleniumUtilities.WEB_ExplicitWait(searchResults_SSN, 60);
		return searchResults_SSN;
	}
	
	@FindBy(id="AccountNumber")
	private WebElement accNumEdt;
	
	public WebElement getAccNumEdt() {
		SeleniumUtilities.WEB_ExplicitWait(accNumEdt);
		return accNumEdt;
	}
	
	@FindAll({@FindBy(xpath="//div[contains(text(),'Account/Contract')]/following-sibling::div[@class='details-account-registration-details']")})
	private List<WebElement> searchResults_AccNum;
	
	public List<WebElement> getSearchResults_AccNum() {
		SeleniumUtilities.WEB_ExplicitWait(searchResults_AccNum, 60);
		return searchResults_AccNum;
	}
	
	@FindBy(id="FullName")
	private WebElement fullNameEdt;
	
	public WebElement getFullNameEdt() {
		SeleniumUtilities.WEB_ExplicitWait(fullNameEdt);
		return fullNameEdt;
	}
	
	@FindBy(xpath="//table[@id='ResultsDisplayTbl']/tbody/tr/td[2]/a")
	private WebElement searchResults_FullName;
	
	public WebElement getSearchResults_FullName() {
		SeleniumUtilities.WEB_ExplicitWait(searchResults_FullName, 60);
		return searchResults_FullName;
	}
	
	@FindBy(id="ShowHideAdvSearchBtn")
	private WebElement showAdvSearchBtn;
	
	public WebElement getShowAdvSearchBtn() {
		SeleniumUtilities.WEB_ExplicitWait(showAdvSearchBtn);
		return showAdvSearchBtn;
	}
	
	@FindBy(id="FirstName")
	private WebElement fNameEdt;
	
	public WebElement getFNameEdt() {
		SeleniumUtilities.WEB_ExplicitWait(fNameEdt);
		return fNameEdt;
	}
	
	@FindBy(id="LastName")
	private WebElement lNameEdt;
	
	public WebElement getLNameEdt() {
		SeleniumUtilities.WEB_ExplicitWait(lNameEdt);
		return lNameEdt;
	}
	
	@FindBy(id="City")
	private WebElement cityEdt;
	
	public WebElement getCityEdt() {
		SeleniumUtilities.WEB_ExplicitWait(cityEdt);
		return cityEdt;
	}
	
	@FindBy(xpath="//table[@id='ResultsDisplayTbl']/tbody/tr/td[9]")
	private WebElement searchResults_city;
	
	public WebElement getSearchResults_city() {
		SeleniumUtilities.WEB_ExplicitWait(searchResults_city);
		return searchResults_city;
	}
	
	@FindBy(id="Zipcode")
	private WebElement zipCodeEdt;
	
	public WebElement getZipCodeEdt() {
		SeleniumUtilities.WEB_ExplicitWait(zipCodeEdt);
		return zipCodeEdt;
	}
	
	@FindBy(xpath="//table[@id='ResultsDisplayTbl']/tbody/tr/td[11]")
	private WebElement searchResults_ZipCode;
	
	public WebElement getSearchResults_ZipCode() {
		SeleniumUtilities.WEB_ExplicitWait(searchResults_ZipCode);
		return searchResults_ZipCode;
	}
	
	@FindBy(id="Email")
	private WebElement emailEdt;
	
	public WebElement getEmailEdt() {
		SeleniumUtilities.WEB_ExplicitWait(emailEdt);
		return emailEdt;
	}
	
	@FindBy(xpath="//div[@id='State_chosen']//span[text()='All']")
	private WebElement stateDrpDwn;
	
	public WebElement getStateDrpDwn() {
		SeleniumUtilities.WEB_ExplicitWait(stateDrpDwn);
		return stateDrpDwn;
	}
	
	@FindBy(xpath="//table[@id='ResultsDisplayTbl']/tbody/tr/td[10]")
	private WebElement searchResults_state;
	
	public WebElement getSearchResults_state() {
		SeleniumUtilities.WEB_ExplicitWait(searchResults_state);
		return searchResults_state;
	}
	
	@FindBy(id="AccountBalanceFrom")
	private WebElement accBalFrmEdt;
	
	public WebElement getAccBalFrmEdt() {
		SeleniumUtilities.WEB_ExplicitWait(accBalFrmEdt);
		return accBalFrmEdt;
	}
	
	@FindBy(id="AccountBalanceTo")
	private WebElement accBalToEdt;
	
	public WebElement getAccBalToEdt() {
		SeleniumUtilities.WEB_ExplicitWait(accBalToEdt);
		return accBalToEdt;
	}
	
	@FindBy(xpath="//div[@id='AccounteDelivery_chosen']//span[text()='Please select...']")
	private WebElement accDelvryDrpDwn;
	
	public WebElement getAccDelvryDrpDwn() {
		SeleniumUtilities.WEB_ExplicitWait(accDelvryDrpDwn);
		return accDelvryDrpDwn;
	}
	
	@FindBy(xpath="//th[text()='Email:']/following-sibling::td/a")
	private WebElement searchResults_Email;
	
	public WebElement getSearchResults_Email() {
		SeleniumUtilities.WEB_ExplicitWait(searchResults_Email);
		return searchResults_Email;
	}
	
	@FindBy(xpath="//div[@id='StatementeDelivery_chosen']//span[text()='Please select...']")
	private WebElement stmtDelvryDrpDwn;
	
	public WebElement getStmtDelvryDrpDwn() {
		SeleniumUtilities.WEB_ExplicitWait(stmtDelvryDrpDwn);
		return stmtDelvryDrpDwn;
	}
}