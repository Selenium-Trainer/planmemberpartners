package com.infoane.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.infoane.utilities.SeleniumUtilities;

import junit.framework.Assert;

public class BusinessConnectPage extends LogInOutPage{
	
	//Plan member connect 
	@FindBy(linkText="PlanMemberConnect™")
	private WebElement planMemberCnctLnk;
	
	public WebElement getPlanMemberCnctLnk() {
		SeleniumUtilities.WEB_ExplicitWait(planMemberCnctLnk);
		return planMemberCnctLnk;
	}
	
	//business connect image
	@FindBy(xpath="//span[contains(@onclick,'businessConnect.cfm')]")
	private WebElement bussCnctBtn;
	
	public WebElement getBussCnctBtn() {
		SeleniumUtilities.WEB_ExplicitWait(bussCnctBtn);
		return bussCnctBtn;
	}
	
	//Welcome to Business connect modal dialog close button
	@FindBy(xpath="//span[text()='Welcome to Business']/../following-sibling::button")
	private WebElement welcme2BusnssMdlCloseBtn;
	
	public WebElement getWelcme2BusnssMdlCloseBtn() {
		SeleniumUtilities.WEB_ExplicitWait(welcme2BusnssMdlCloseBtn);
		return welcme2BusnssMdlCloseBtn;
	}
	
	//proceed to business connect button
	@FindBy(xpath="//button[text()='Proceed to Business']")
	private WebElement proceedToBussBtn;
		
	public WebElement getProceedToBussBtn() {
		SeleniumUtilities.WEB_ExplicitWait(welcme2BusnssMdlCloseBtn);
		return proceedToBussBtn;
	}
	
	// open new account button
	@FindBy(id="openNewAccountTxt")
	private WebElement openNewAccntBtn;
	
	public WebElement getOpenNewAccntBtn() {
		SeleniumUtilities.WEB_ExplicitWait(openNewAccntBtn);
		return openNewAccntBtn;
	}
	
	//account type drop down
	@FindBy(xpath="//span[text()='Select Account Type']")
	private WebElement accountypeDrpDwn;
	
	public WebElement getAccountypeDrpDwn() {
		SeleniumUtilities.WEB_ExplicitWait(accountypeDrpDwn);
		return accountypeDrpDwn;
	}
	
	// client first name
	@FindBy(id="IFPOEFirstName")
	private WebElement clienFnameEdt;
	
	public WebElement getClienFnameEdt() {
		SeleniumUtilities.WEB_ExplicitWait(clienFnameEdt);
		return clienFnameEdt;
	}
	
	// client last name
	@FindBy(id="IFPOELastName")
	private WebElement clientLnameEdt;
	
	public WebElement  getClientLnameEdt() {
		SeleniumUtilities.WEB_ExplicitWait(clientLnameEdt);
		return clientLnameEdt;
	}
	
	//client SSN
	@FindBy(id="IFPOESSN")
	private WebElement clientSSNEdt;
	
	public WebElement getClientSSNEdt() {
		SeleniumUtilities.WEB_ExplicitWait(clientSSNEdt);
		return clientSSNEdt;
	}
	
	//client email
	@FindBy(id="IFPOEEmail")
	private WebElement clientEmailEdt;
	
	public WebElement getClientEmailEdt() {
		SeleniumUtilities.WEB_ExplicitWait(clientEmailEdt);
		return clientEmailEdt;
	}
	
	//primary contact number
	@FindBy(id="IFPOEMobilePhone")
	private WebElement primaryPhNumEdt;
	
	public WebElement getPrimaryPhNumEdt() {
		SeleniumUtilities.WEB_ExplicitWait(primaryPhNumEdt);
		return primaryPhNumEdt;
	}
	
	//client address line1
	@FindBy(id="IFPOEHomeAddressLine1")
	private WebElement hmeAddrLine1Edt;
	
	public WebElement getHmeAddrLine1Edt() {
		SeleniumUtilities.WEB_ExplicitWait(hmeAddrLine1Edt);
		return hmeAddrLine1Edt;
	}
	
	// client zip code
	@FindBy(id="IFPOEHomeAddressZIP")
	private WebElement clientZIPEdt;
	
	public WebElement getClientZIPEdt() {
		SeleniumUtilities.WEB_ExplicitWait(clientZIPEdt);
		return clientZIPEdt;
	}
	
	// client city
	@FindBy(id="IFPOEHomeAddressCity")
	private WebElement clientCityEdt;
	
	public WebElement getClientCityEdt() {
		SeleniumUtilities.WEB_ExplicitWait(clientCityEdt);
		return clientCityEdt;
	}
	
	// Next button
	@FindBy(id="saveClientInfo")
	private WebElement saveClientInfoBtn;
	
	public WebElement getSaveClientInfoBtn() {
		SeleniumUtilities.WEB_ExplicitWait(saveClientInfoBtn);
		return saveClientInfoBtn;
	}
	
	//alert message
	@FindBy(id="alertMsgValidation")
	private WebElement clientFnameErrorMsg;
	
	public WebElement getClientFnameErrorMsg() {
		SeleniumUtilities.WEB_ExplicitWait(clientFnameErrorMsg);
		return clientFnameErrorMsg;
	}
	
	// client DOB
	@FindBy(id="IFPOEIdentityDOB")
	private WebElement clientDOBEdt;
	
	public WebElement getClientDOBEdt() {
		SeleniumUtilities.WEB_ExplicitWait(clientDOBEdt);
		return clientDOBEdt;
	}
	
	// client MaritalStatus
	@FindBy(xpath="//div[@id='IFPOEMaritalStatus1_chosen']//span[text()='Please select...']")
	private WebElement clientMaritalStatusDrpDwn;
	
	public WebElement getClientMaritalStatusDrpDwn() {
		SeleniumUtilities.WEB_ExplicitWait(clientMaritalStatusDrpDwn);
		return clientMaritalStatusDrpDwn;
	}
	
	// client ID type
	@FindBy(xpath="//div[@id='IFPOEIDType_chosen']//span[text()='Please select...']")
	private WebElement clientIDtypeDrpDwn;
	
	public WebElement getClientIDtypeDrpDwn() {
		SeleniumUtilities.WEB_ExplicitWait(clientIDtypeDrpDwn);
		return clientIDtypeDrpDwn;
	}
	
	// client ID number
	@FindBy(id="IFPOEIDNumber")
	private WebElement clientIDnumEdt;
	
	public WebElement getClientIDnumEdt() {
		SeleniumUtilities.WEB_ExplicitWait(clientIDnumEdt);
		return clientIDnumEdt;
	}
	
	// client state of insurance
	@FindBy(xpath="//div[@id='IFPOEIDStateOfIssuance_chosen']//span[text()='Select a State']")
	private WebElement clientStateOfInsuranceDrpDwn;
	
	public WebElement getClientStateOfInsuranceDrpDwn() {
		SeleniumUtilities.WEB_ExplicitWait(clientStateOfInsuranceDrpDwn);
		return clientStateOfInsuranceDrpDwn;
	}
	
	// expiration date
	@FindBy(id="IFPOEIDExpirationDate")
	private WebElement clientIDexpDateEdt;
	
	public WebElement getClientIDexpDateEdt() {
		SeleniumUtilities.WEB_ExplicitWait(clientIDexpDateEdt);
		return clientIDexpDateEdt;
	}
	
	// Next button
	@FindBy(id="saveIdentity")
	private WebElement saveIdentityBtn;
	
	public WebElement getSaveIdentityBtn() {
		SeleniumUtilities.WEB_ExplicitWait(saveIdentityBtn);
		return saveIdentityBtn;
	}
	
	//Occupation
	@FindBy(id="IFPOEOccupation")
	private WebElement clientOccupationEdt;
	
	public WebElement getClientOccupationEdt() {
		SeleniumUtilities.WEB_ExplicitWait(clientOccupationEdt);
		return clientOccupationEdt;
	}
	
	// employer
	@FindBy(xpath="//span[text()='Please select Employer']")
	private WebElement clientEmployerDrpDwn;
	
	public WebElement getClientEmployerDrpDwn() {
		SeleniumUtilities.WEB_ExplicitWait(clientEmployerDrpDwn);
		return clientEmployerDrpDwn;
	}
	
	// date of hire
	@FindBy(id="IFPOEDateOfHire")
	private WebElement dateOfHireEdt;
	
	public WebElement getDateOfHireEdt() {
		SeleniumUtilities.WEB_ExplicitWait(dateOfHireEdt);
		return dateOfHireEdt;
	}
	
	// save employment details
	@FindBy(id="saveEmployment")
	private WebElement saveEmploymentBtn;
	
	public WebElement getSaveEmploymentBtn() {
		SeleniumUtilities.WEB_ExplicitWait(saveEmploymentBtn);
		return saveEmploymentBtn;
	}
	
	// annual income drop down
	@FindBy(xpath="//span[text()='Select Annual Income']")
	private WebElement annualIncmeDrpDwn;
	
	public WebElement getAnnualIncmeDrpDwn() {
		SeleniumUtilities.WEB_ExplicitWait(annualIncmeDrpDwn);
		return annualIncmeDrpDwn;
	}
	
	// net worth
	@FindBy(xpath="//span[text()='Select Net Worth']")
	private WebElement netWorthDrpDwn;
	
	public WebElement getNetWorthDrpDwn() {
		SeleniumUtilities.WEB_ExplicitWait(netWorthDrpDwn);
		return netWorthDrpDwn;
	}
	
	//Liquid Net Worth
	@FindBy(xpath="//span[text()='Select Liquid Net Worth']")
	private WebElement liqudNetWorthDrpDwn;
	
	public WebElement getLiqudNetWorthDrpDwn() {
		SeleniumUtilities.WEB_ExplicitWait(liqudNetWorthDrpDwn);
		return liqudNetWorthDrpDwn;
	}
	
	//tax rate
	@FindBy(xpath="//span[text()='Select Tax Rate']")
	private WebElement taxRateDrpDwn;
	
	public WebElement getTaxRateDrpDwn() {
		SeleniumUtilities.WEB_ExplicitWait(taxRateDrpDwn);
		return taxRateDrpDwn;
	}
	
	//annual expenses
	@FindBy(xpath="//span[text()='Select Annual Expenses']")
	private WebElement annualExpnseDrpDwn;
	
	public WebElement getAnnualExpnseDrpDwn() {
		SeleniumUtilities.WEB_ExplicitWait(annualExpnseDrpDwn);
		return annualExpnseDrpDwn;
	}
	
	//special expenses
	@FindBy(xpath="//span[text()='Select Special Expenses']")
	private WebElement spcalExpnseDrpDwn;
	
	public WebElement getSpcalExpnseDrpDwn() {
		SeleniumUtilities.WEB_ExplicitWait(spcalExpnseDrpDwn);
		return spcalExpnseDrpDwn;
	}
	
	//Time frame For Special Expenses
	@FindBy(xpath="//span[text()='Select Timeframe For Special Expenses']")
	private WebElement timeFrameSpcalExpnseDrpDwn;
	
	public WebElement getTimeFrameSpcalExpnseDrpDwn() {
		SeleniumUtilities.WEB_ExplicitWait(timeFrameSpcalExpnseDrpDwn);
		return timeFrameSpcalExpnseDrpDwn;
	}
	
	//Investor Objective
	@FindBy(xpath="//div[@id='OEInvestorObjective_chosen']//span[text()='Please select...']")
	private WebElement invstrObjDrpDwn;
	
	public WebElement getInvstrObjDrpDwn() {
		SeleniumUtilities.WEB_ExplicitWait(invstrObjDrpDwn);
		return invstrObjDrpDwn;
	}
	
	//Investment Purpose
	@FindBy(xpath="//div[@id='OEInvestorPurpose_chosen']//span[text()='Please select...']")
	private WebElement investmtPurpseDrpDwn;
	
	public WebElement getInvestmtPurpseDrpDwn() {
		SeleniumUtilities.WEB_ExplicitWait(investmtPurpseDrpDwn);
		return investmtPurpseDrpDwn;
	}
	
	//Liquidity needs
	@FindBy(xpath="//div[@id='OELiquidityNeeds_chosen']//span[text()='Please select...']")
	private WebElement liqudtyNeedsDrpDwn;
	
	public WebElement getLiqudtyNeedsDrpDwn() {
		SeleniumUtilities.WEB_ExplicitWait(liqudtyNeedsDrpDwn);
		return liqudtyNeedsDrpDwn;
	}
	
	// save financial details 
	@FindBy(id="saveFinancial")
	private WebElement saveFinancialBtn;
	
	public WebElement getSaveFinancialBtn() {
		SeleniumUtilities.WEB_ExplicitWait(saveFinancialBtn);
		return saveFinancialBtn;
	}
	
	// save liquidity
	@FindBy(id="saveLiquidity")
	private WebElement saveLiquidityBtn;
	
	public WebElement getSaveLiquidityBtn() {
		SeleniumUtilities.WEB_ExplicitWait(saveLiquidityBtn);
		return saveLiquidityBtn;
	}
	
	// invest type
	public WebElement getInvestType(String investType, String checkBxNum) {
		WebElement element = null;
		try {
			switch(checkBxNum) {
			case "1":
				element = SeleniumUtilities.getDriver().findElement(By.xpath("//span[text()='"+investType+"']/../following-sibling::td/input[@value='0']"));
				break;
			case "2":
				element = SeleniumUtilities.getDriver().findElement(By.xpath("//span[text()='"+investType+"']/../following-sibling::td/input[@value='1-5']"));
				break;
			case "3":
				element = SeleniumUtilities.getDriver().findElement(By.xpath("//span[text()='"+investType+"']/../following-sibling::td/input[@value='5+']"));
				break;
			default:
				Assert.fail("Kindly pass inputs as '1' or '2' or '3'");
				break;
			}
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		return element;
	}
	
	// invest percentage
	public WebElement getInvestPercentage(String investType, String checkBxNum) {
		WebElement element = SeleniumUtilities.getDriver().findElement(By.xpath("//span[text()='"+investType+"']/../following-sibling::td/input[contains(@id,'allocationPercent')]"));
		return element;
	}
	
	// save investment button
	@FindBy(id="saveInvestmentExp")
	private WebElement saveInvestmentBtn;
	
	public WebElement getSaveInvestmentBtn() {
		SeleniumUtilities.WEB_ExplicitWait(saveInvestmentBtn);
		return saveInvestmentBtn;
	}
	
	// product initial allocation
	public WebElement getPrdctInitalAllcatin(String productName) {
		WebElement element = SeleniumUtilities.getDriver().findElement(By.xpath("//label[text()='"+productName+"']/../following-sibling::td/input[contains(@id,'InitialPurchase')]"));
		return element;
	}
	
	// product sub sequence allocation
	public WebElement getPrdctSubSeqnceAllcatin(String productName) {
		WebElement element = SeleniumUtilities.getDriver().findElement(By.xpath("//label[text()='"+productName+"']/../following-sibling::td/input[contains(@id,'SubsequentPercent')]"));
		return element;
	}
	
	// saveProducts button
	@FindBy(id="saveProducts")
	private WebElement saveProductsBtn;
	
	public WebElement getSaveProductsBtn() {
		SeleniumUtilities.WEB_ExplicitWait(saveProductsBtn);
		return saveProductsBtn;
	}
	
	// RTQ question1
	@FindBy(id="RTQQuestion1")
	private WebElement rtqQuestion1Lnk;
	
	public WebElement getRTQQuestion1Lnk() {
		SeleniumUtilities.WEB_ExplicitWait(rtqQuestion1Lnk);
		return rtqQuestion1Lnk;
	}
	
	// RTQ questions list
	@FindBys({@FindBy(xpath="//input[contains(@id,'rt-q1-a') and @name='RtQuestion1']/following-sibling::label")})
	private List<WebElement> rtqQuestions1List;
	
	public List<WebElement> getRTQQuestions1List(){
		SeleniumUtilities.WEB_ExplicitWait(rtqQuestions1List);
		return rtqQuestions1List;
	}
	
	// RTQ questions list
	@FindBys({@FindBy(xpath="//input[contains(@id,'rt-q2-a') and @name='RtQuestion2']/following-sibling::label")})
	private List<WebElement> rtqQuestions2List;
	
	public List<WebElement> getRTQQuestions2List(){
		SeleniumUtilities.WEB_ExplicitWait(rtqQuestions2List);
		return rtqQuestions2List;
	}
	
	// RTQ questions list
	@FindBys({@FindBy(xpath="//input[contains(@id,'rt-q3-a') and @name='RtQuestion3']/following-sibling::label")})
	private List<WebElement> rtqQuestions3List;
	
	public List<WebElement> getRTQQuestions3List(){
		SeleniumUtilities.WEB_ExplicitWait(rtqQuestions3List);
		return rtqQuestions3List;
	}
	
	// RTQ questions list
	@FindBys({@FindBy(xpath="//input[contains(@id,'rt-q4-a') and @name='RtQuestion4']/following-sibling::label")})
	private List<WebElement> rtqQuestions4List;
	
	public List<WebElement> getRTQQuestions4List(){
		SeleniumUtilities.WEB_ExplicitWait(rtqQuestions4List);
		return rtqQuestions4List;
	}
	
	// RTQ questions list
	@FindBys({@FindBy(xpath="//input[contains(@id,'rt-q5-a') and @name='RtQuestion5']/following-sibling::label")})
	private List<WebElement> rtqQuestions5List;
	
	public List<WebElement> getRTQQuestions5List(){
		SeleniumUtilities.WEB_ExplicitWait(rtqQuestions5List);
		return rtqQuestions5List;
	}
	
	// RTQ questions list
	@FindBys({@FindBy(xpath="//input[contains(@id,'rt-q6-a') and @name='RtQuestion6']/following-sibling::label")})
	private List<WebElement> rtqQuestions6List;
	
	public List<WebElement> getRTQQuestions6List(){
		SeleniumUtilities.WEB_ExplicitWait(rtqQuestions6List);
		return rtqQuestions6List;
	}
	
	// RTQ questions list
	@FindBys({@FindBy(xpath="//input[contains(@id,'rt-q7-a') and @name='RtQuestion7']/following-sibling::label")})
	private List<WebElement> rtqQuestions7List;
	
	public List<WebElement> getRTQQuestions7List(){
		SeleniumUtilities.WEB_ExplicitWait(rtqQuestions7List);
		return rtqQuestions7List;
	}
	
	// RTQ questions list
	@FindBys({@FindBy(xpath="//input[contains(@id,'rt-q8-a') and @name='RtQuestion8']/following-sibling::label")})
	private List<WebElement> rtqQuestions8List;
	
	public List<WebElement> getRTQQuestions8List(){
		SeleniumUtilities.WEB_ExplicitWait(rtqQuestions8List);
		return rtqQuestions8List;
	}
	
	// save question
	@FindBy(id="saveQuestion")
	private WebElement saveQuestionBtn;
	
	public WebElement getSaveQuestionBtn() {
		SeleniumUtilities.WEB_ExplicitWait(saveQuestionBtn);
		return saveQuestionBtn;
	}
	
	//AdvisoryFee_Hybrid
	@FindBy(id="AdvisoryFee_Hybrid")
	private WebElement advFeeEdt;
	
	public WebElement getAdvFeeEdt() {
		SeleniumUtilities.WEB_ExplicitWait(advFeeEdt);
		return advFeeEdt;
	}
	
	// save portfolio
	@FindBy(id="savePortfolio")
	private WebElement savePortfolioBtn;
	
	public WebElement getSavePortfolioBtn() {
		SeleniumUtilities.WEB_ExplicitWait(savePortfolioBtn);
		return savePortfolioBtn;
	}
	
	// BenefitsOfProposedProduct
	@FindBy(id="BenefitsOfProposedProduct")
	private WebElement benefitsOfProposedProdEdt;
		
	public WebElement getBenefitsOfProposedProdEdt() {
		SeleniumUtilities.WEB_ExplicitWait(benefitsOfProposedProdEdt);
		return benefitsOfProposedProdEdt;
	}
	
	// BenefitsOfExistingProduct
	@FindBy(id="BenefitsOfExistingProduct")
	private WebElement benefitsOfExistingProdEdt;
	
	public WebElement getBenefitsOfExistingProdEdt() {
		SeleniumUtilities.WEB_ExplicitWait(benefitsOfExistingProdEdt);
		return benefitsOfExistingProdEdt;
	}
	
	// saveBenefits
	@FindBy(id="saveBenefits")
	private WebElement saveBenefitsBtn;
	
	public WebElement getSaveBenefitsBtn() {
		SeleniumUtilities.WEB_ExplicitWait(saveBenefitsBtn);
		return saveBenefitsBtn;
	}
	
	// saveRollover
	@FindBy(id="saveRollover")
	private WebElement saveRolloverBtn;
	
	public WebElement getSaveRolloverBtn() {
		SeleniumUtilities.WEB_ExplicitWait(saveRolloverBtn);
		return saveRolloverBtn;
	}
	
	// save salary Deferral
	@FindBy(id="saveSalaryDeferral")
	private WebElement saveSalaryDeferralBtn;
	
	public WebElement getSaveSalaryDeferralBtn() {
		SeleniumUtilities.WEB_ExplicitWait(saveSalaryDeferralBtn);
		return saveSalaryDeferralBtn;
	}
	
	// save beneficiaries
	@FindBy(id="saveBeneficiaries")
	private WebElement saveBeneficiariesBtn;
	
	public WebElement getSaveBeneficiariesBtn() {
		SeleniumUtilities.WEB_ExplicitWait(saveBeneficiariesBtn);
		return saveBeneficiariesBtn;
	}
	
	//document delivery date
	@FindBy(id="DocDeliveryDateADV")
	private WebElement docDelvryDtAdvEdt;
	
	public WebElement getDocDelvryDtAdvEdt() {
		SeleniumUtilities.WEB_ExplicitWait(docDelvryDtAdvEdt);
		return docDelvryDtAdvEdt;
	}
	
	// saveDocumentDelivery
	@FindBy(id="saveDocumentDelivery")
	private WebElement saveDocDelvryBtn;
	
	public WebElement getSaveDocDelvryBtn() {
		SeleniumUtilities.WEB_ExplicitWait(saveDocDelvryBtn);
		return saveDocDelvryBtn;
	}
	
	// saveRepIDSelection
	@FindBy(id="saveRepIDSelection")
	private WebElement saveRepIdBtn;
	
	public WebElement getSaveRepIdBtn() {
		SeleniumUtilities.WEB_ExplicitWait(saveRepIdBtn);
		return saveRepIdBtn;
	}
	
	//saveInfoSummary
	@FindBy(id="saveInfoSummary")
	private WebElement saveInfoSummaryBtn;
	
	public WebElement getSaveInfoSummaryBtn() {
		SeleniumUtilities.WEB_ExplicitWait(saveInfoSummaryBtn);
		return saveInfoSummaryBtn;
	}
	
	//printPaperWork
	@FindBy(id="printPaperWork")
	private WebElement generatePaperWorkBtn;
	
	public WebElement getGeneratePaperWorkBtn() {
		SeleniumUtilities.WEB_ExplicitWait(generatePaperWorkBtn);
		return generatePaperWorkBtn;
	}
	
	//initiate error check
	@FindBy(id="accountWarningClsButtonGenerate")
	private WebElement initiateErrChckbtn;
	
	public WebElement getInitiateErrChckbtn() {
		SeleniumUtilities.WEB_ExplicitWait(initiateErrChckbtn);
		return initiateErrChckbtn;
	}
	
	//
	@FindBy(id="missingValues-button1")
	private WebElement generatePaperWrkOkBtn;
	
	public WebElement getGeneratePaperWrkOkBtn() {
		SeleniumUtilities.WEB_ExplicitWait(generatePaperWrkOkBtn);
		return generatePaperWrkOkBtn;
	}
	
	//ignore errors and generate paper work
	@FindBy(id="DefaultErrorWarningClsButton")
	private WebElement ignoreErrAndGenertePaprWrkBtn;
	
	public WebElement getIgnoreErrAndGenertePaprWrkBtn() {
		SeleniumUtilities.WEB_ExplicitWait(ignoreErrAndGenertePaprWrkBtn);
		return ignoreErrAndGenertePaprWrkBtn;
	}

	//progress bar
	@FindBy(id="progressbar")
	private WebElement paperWorkGenrtnProgressBar;
	
	public WebElement getPaperWorkGenrtnProgressBar() {
		return paperWorkGenrtnProgressBar;
	}
	
	//OES ID
	@FindBy(id="rtn_OESID")
	private WebElement oesID;
	
	public WebElement getOESID() {
		SeleniumUtilities.WEB_ExplicitWait(oesID);
		return oesID;
	}
}