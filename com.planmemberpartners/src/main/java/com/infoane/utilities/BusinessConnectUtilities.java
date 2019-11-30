package com.infoane.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.infoane.pages.BusinessConnectPage;

public class BusinessConnectUtilities extends LogInOutUtilities{
	
	// Page Factory
	BusinessConnectPage objBusinessCnctPage = PageFactory.initElements(SeleniumUtilities.getDriver(), BusinessConnectPage.class);
	
	public void businessConnectProcess() {
		try {
			// fetching the window handle
			String parentWindow = SeleniumUtilities.WEB_getCurrentWindowHandle();
			
			// switch to child
			SeleniumUtilities.WEB_windowSwitching(parentWindow);
			
			//clicking on business connect
			SeleniumUtilities.WEB_Click(objBusinessCnctPage.getBussCnctBtn(), "Business Connect");
			
			if(SeleniumUtilities.WEB_isDisplayed(objBusinessCnctPage.getWelcme2BusnssMdlCloseBtn())) {
				//clicking on proceed to business connect
				SeleniumUtilities.WEB_Click(objBusinessCnctPage.getProceedToBussBtn(), "Proceed to Business Connect");
			}
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void selectAccountType(String accType) {
		try {
			// selecting the account type
			SeleniumUtilities.WEB_selectValuesDrpDwn(objBusinessCnctPage.getAccountypeDrpDwn(), "VISIBLETEXT", 0, null, accType);
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void clientAccInfo(String accType, String clientFname, String clientLname, String clientEmail,
			String primaryCnctNumber, String clinetAddrLine1, String clientZIPcode) {
		try {
			// click on open a new account
			SeleniumUtilities.WEB_Click(objBusinessCnctPage.getOpenNewAccntBtn(), "Open A New Account");
			
			// select account type
			selectAccountType(accType);
			
			// enter client first name
			SeleniumUtilities.WEB_SendKeys(objBusinessCnctPage.getClienFnameEdt(), "Client First Name", clientFname);
			
			// enter client last name
			SeleniumUtilities.WEB_SendKeys(objBusinessCnctPage.getClientLnameEdt(), "Client Last Name", clientLname);
			
			// generating random SSN
			int clientSSN = SeleniumUtilities.WEB_GenerateRandomNumber(111111111, 999999999);
			
			// enter client SSN
			SeleniumUtilities.WEB_SendKeys(objBusinessCnctPage.getClientSSNEdt(), "Client SSN", Integer.toString(clientSSN));
			
			// enter client email
			SeleniumUtilities.WEB_SendKeys(objBusinessCnctPage.getClientEmailEdt(), "Client Email", clientEmail);
			
			// enter primary mobile number
			SeleniumUtilities.WEB_SendKeys(objBusinessCnctPage.getPrimaryPhNumEdt(), "Primary Contact Phone", primaryCnctNumber);
			
			// address line1
			SeleniumUtilities.WEB_SendKeys(objBusinessCnctPage.getHmeAddrLine1Edt(), "Client Address Line1", clinetAddrLine1);
			
			// ZIP code
			SeleniumUtilities.WEB_SendKeys(objBusinessCnctPage.getClientZIPEdt(), "Client ZIP code", clientZIPcode);
			
			// click save button
			SeleniumUtilities.WEB_Click(objBusinessCnctPage.getSaveClientInfoBtn(), "saveClientInfo");
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void clientFnameErrMsgValidation() {
		// expected error message
		String exptdErrMsg = "You need to enter first and last name of the contact to create the record";
		try {
			if(SeleniumUtilities.WEB_isDisplayed(objBusinessCnctPage.getClientFnameErrorMsg())){
				logger.log(Status.PASS, "Modal dialog box is displayed successfully");
				
				//Screenshot
				SeleniumUtilities.WEB_getScreenShot("clientFnameErrMsgValidation"+SeleniumUtilities.WEB_GenerateRandomNumber(0, 9));
				
				// reading error message from application
				String actErrMsg = SeleniumUtilities.WEB_getVisibleText(objBusinessCnctPage.getClientFnameErrorMsg());
				
				if(actErrMsg.equals(exptdErrMsg)) {
					logger.log(Status.PASS, "Error Message verified successfully");
				}else {
					logger.log(Status.PASS, "Failed verify Error Message");
				}
			}else {
				logger.log(Status.FAIL, "Modal dialog box is not displayed");
			}
			
			//Parent window
			String parentWindow = SeleniumUtilities.WEB_GetParentWindowID();
			
			//close current window
			SeleniumUtilities.WEB_CloseCurrentWindow();
			
			//Switch back to parent
			SeleniumUtilities.WEB_windowSwitchingBackToParent(parentWindow);
			
			//logout
			logOut();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void clientIdentity(String clientDOB, String clientMaritalStatus, String clientIDType, String clientIDnum, String clientStateOfInsurance, String clientIDexpDt) {
		try {
			// DOB
			SeleniumUtilities.WEB_SendKeys(objBusinessCnctPage.getClientDOBEdt(), "Client DOB", clientDOB);
			
			// Marital status
			SeleniumUtilities.WEB_selectValuesDrpDwn(objBusinessCnctPage.getClientMaritalStatusDrpDwn(), "VISIBLETEXT", 0, null, clientMaritalStatus);
			
			// ID type
			SeleniumUtilities.WEB_selectValuesDrpDwn(objBusinessCnctPage.getClientIDtypeDrpDwn(), "VISIBLETEXT", 0, null, clientIDType);
			
			// ID number
			SeleniumUtilities.WEB_SendKeys(objBusinessCnctPage.getClientIDnumEdt(), "Client ID Number", clientIDnum);
			
			// state of insurance
			SeleniumUtilities.WEB_selectValuesDrpDwn(objBusinessCnctPage.getClientStateOfInsuranceDrpDwn(), "VISIBLETEXT", 0, null, clientStateOfInsurance);
			
			// ID expiration date
			SeleniumUtilities.WEB_SendKeys(objBusinessCnctPage.getClientIDexpDateEdt(), "Client ID Experiation Date", clientIDexpDt);
			
			// next button
			SeleniumUtilities.WEB_Click(objBusinessCnctPage.getSaveIdentityBtn(), "saveIdentity");
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void clientEmployementDetails(String clientOccupation, String employer, String dateOfHire) {
		try {
			// client occupation
			SeleniumUtilities.WEB_SendKeys(objBusinessCnctPage.getClientOccupationEdt(), "Client Occupation", clientOccupation);
			
			// select employer
			SeleniumUtilities.WEB_selectValuesDrpDwn(objBusinessCnctPage.getClientEmployerDrpDwn(), "VISIBLETEXT", 0, null, employer);
			
			// enter date of hire
			SeleniumUtilities.WEB_SendKeys(objBusinessCnctPage.getDateOfHireEdt(), "Date of Hire", dateOfHire);
			
			// click on next button
			SeleniumUtilities.WEB_Click(objBusinessCnctPage.getSaveEmploymentBtn(), "Save Employement");
			
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void clientFinancialDetails(String annualIncome, String netWorth, String liquidNetWorth, String taxRate, String annualExpnse,
			String specialExpense, String timeFrameSpecialExpense) {
		try {
			//select annual income
			SeleniumUtilities.WEB_selectValuesDrpDwn(objBusinessCnctPage.getAnnualIncmeDrpDwn(), "VISIBLETEXT", 0, null, annualIncome);
			
			//select net worth
			SeleniumUtilities.WEB_selectValuesDrpDwn(objBusinessCnctPage.getNetWorthDrpDwn(), "VISIBLETEXT", 0, null, netWorth);
			
			//select liquid net worth
			SeleniumUtilities.WEB_selectValuesDrpDwn(objBusinessCnctPage.getLiqudNetWorthDrpDwn(), "VISIBLETEXT", 0, null, liquidNetWorth);
			
			//select tax rate
			SeleniumUtilities.WEB_selectValuesDrpDwn(objBusinessCnctPage.getTaxRateDrpDwn(), "VISIBLETEXT", 0, null, taxRate);
			
			//select annual expense
			SeleniumUtilities.WEB_selectValuesDrpDwn(objBusinessCnctPage.getAnnualExpnseDrpDwn(), "VISIBLETEXT", 0, null, annualExpnse);
			
			//select special expense
			SeleniumUtilities.WEB_selectValuesDrpDwn(objBusinessCnctPage.getSpcalExpnseDrpDwn(), "VISIBLETEXT", 0, null, specialExpense);
			
			//select time frame special expense
			SeleniumUtilities.WEB_selectValuesDrpDwn(objBusinessCnctPage.getTimeFrameSpcalExpnseDrpDwn(), "VISIBLETEXT", 0, null, timeFrameSpecialExpense);
			
			// click on next button
			SeleniumUtilities.WEB_Click(objBusinessCnctPage.getSaveFinancialBtn(), "Save Financial");
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void clientLiquidityDetails(String investorObjective, String investmtPurpose, String liquidityNeeds) {
		try {
			//select investor objective
			SeleniumUtilities.WEB_selectValuesDrpDwn(objBusinessCnctPage.getInvstrObjDrpDwn(), "VISIBLETEXT", 0, null, investorObjective);
			
			//select investor objective
			SeleniumUtilities.WEB_selectValuesDrpDwn(objBusinessCnctPage.getInvestmtPurpseDrpDwn(), "VISIBLETEXT", 0, null, investmtPurpose);
			
			//select liquidity needs
			SeleniumUtilities.WEB_selectValuesDrpDwn(objBusinessCnctPage.getLiqudtyNeedsDrpDwn(), "VISIBLETEXT", 0, null, liquidityNeeds);
			
			// click on next button
			SeleniumUtilities.WEB_Click(objBusinessCnctPage.getSaveLiquidityBtn(), "Save Liquidity");
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void clientInvestmentDetails(String investType, String checkBxNum, String investmentAllocation) {
		try {
			// investment type and no.of years
			SeleniumUtilities.WEB_Click((objBusinessCnctPage.getInvestType(investType, checkBxNum)), investType);
			
			// approximate allocation
			SeleniumUtilities.WEB_SendKeys((objBusinessCnctPage.getInvestPercentage(investType, checkBxNum)), investType, investmentAllocation);
			
			// click on next button
			SeleniumUtilities.WEB_Click(objBusinessCnctPage.getSaveInvestmentBtn(), "Save Investment");
			
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void clientProductDetails(String productName, String initiaAllocation, String subsequenceAllocation) {
		try {
			// enter initial allocation
			SeleniumUtilities.WEB_SendKeys(objBusinessCnctPage.getPrdctInitalAllcatin(productName), productName, initiaAllocation);
			
			// enter subsequence allocation
			SeleniumUtilities.WEB_SendKeys(objBusinessCnctPage.getPrdctSubSeqnceAllcatin(productName), productName, subsequenceAllocation);
			
			// click on next button
			SeleniumUtilities.WEB_Click(objBusinessCnctPage.getSaveProductsBtn(), "Save Products");
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void clientRTQDetails() {
		try {
			// expand the question1
			SeleniumUtilities.WEB_Click(objBusinessCnctPage.getRTQQuestion1Lnk(), "Question 1");
			
			// selecting the random RTQ1 question
			WebElement rtq1 = objBusinessCnctPage.getRTQQuestions1List().get(SeleniumUtilities.WEB_GenerateRandomNumber(0, 4));
			SeleniumUtilities.WEB_Click(rtq1, SeleniumUtilities.WEB_getVisibleText(rtq1));
			
			// selecting the random RTQ2 question
			WebElement rtq2 = objBusinessCnctPage.getRTQQuestions2List().get(SeleniumUtilities.WEB_GenerateRandomNumber(0, 4));
			SeleniumUtilities.WEB_Click(rtq2, SeleniumUtilities.WEB_getVisibleText(rtq2));
			
			// selecting the random RTQ3 question
			WebElement rtq3 = objBusinessCnctPage.getRTQQuestions3List().get(SeleniumUtilities.WEB_GenerateRandomNumber(0, 4));
			SeleniumUtilities.WEB_Click(rtq3, SeleniumUtilities.WEB_getVisibleText(rtq3));
			
			// selecting the random RTQ4 question
			WebElement rtq4 = objBusinessCnctPage.getRTQQuestions4List().get(SeleniumUtilities.WEB_GenerateRandomNumber(0, 2));
			SeleniumUtilities.WEB_Click(rtq4, SeleniumUtilities.WEB_getVisibleText(rtq4));
			
			// selecting the random RTQ5 question
			WebElement rtq5 = objBusinessCnctPage.getRTQQuestions5List().get(SeleniumUtilities.WEB_GenerateRandomNumber(0, 2));
			SeleniumUtilities.WEB_Click(rtq5, SeleniumUtilities.WEB_getVisibleText(rtq5));
			
			// selecting the random RTQ6 question
			WebElement rtq6 = objBusinessCnctPage.getRTQQuestions6List().get(SeleniumUtilities.WEB_GenerateRandomNumber(0, 2));
			SeleniumUtilities.WEB_Click(rtq6, SeleniumUtilities.WEB_getVisibleText(rtq6));
			
			// selecting the random RTQ7 question
			WebElement rtq7 = objBusinessCnctPage.getRTQQuestions7List().get(SeleniumUtilities.WEB_GenerateRandomNumber(0, 2));
			SeleniumUtilities.WEB_Click(rtq7, SeleniumUtilities.WEB_getVisibleText(rtq7));
			
			// selecting the random RTQ8 question
			WebElement rtq8 = objBusinessCnctPage.getRTQQuestions8List().get(SeleniumUtilities.WEB_GenerateRandomNumber(0, 4));
			SeleniumUtilities.WEB_Click(rtq8, SeleniumUtilities.WEB_getVisibleText(rtq8));
			
			// click on next button
			SeleniumUtilities.WEB_Click(objBusinessCnctPage.getSaveQuestionBtn(), "saveQuestion");
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void clientPortFolioDetails(String advFee) {
		try {
			//enter adv fee
			SeleniumUtilities.WEB_SendKeys(objBusinessCnctPage.getAdvFeeEdt(), "Adv Fee", advFee);
			
			// click on Next button
			SeleniumUtilities.WEB_Click(objBusinessCnctPage.getSavePortfolioBtn(), "Save Portfolio");
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void clientAdvisoryFeeBenefits(String BenefitsOfProposedProdValue, String BenefitsOfExistingProdValue) {
		try {
			// enter BenefitsOfProposedProduct
			SeleniumUtilities.WEB_SendKeys(objBusinessCnctPage.getBenefitsOfProposedProdEdt(), "BenefitsOfProposedProduct", BenefitsOfProposedProdValue);
			
			// enter BenefitsOfExistingProduct
			SeleniumUtilities.WEB_SendKeys(objBusinessCnctPage.getBenefitsOfExistingProdEdt(), "BenefitsOfExistingProduct", BenefitsOfExistingProdValue);
			
			// click on next button
			SeleniumUtilities.WEB_Click(objBusinessCnctPage.getSaveBenefitsBtn(), "Save Benifits");
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void clientRollOverDetails() {
		try {
			// click on Next button
			SeleniumUtilities.WEB_Click(objBusinessCnctPage.getSaveRolloverBtn(), "Save RollOver --> Next");
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void clientSalaryDeferralDetails() {
		try {
			// click on next button
			SeleniumUtilities.WEB_Click(objBusinessCnctPage.getSaveSalaryDeferralBtn(), "Save Salary Deferal Next");
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void clientSaveBeneficiariesDetails() {
		try {
			// click on next button
			SeleniumUtilities.WEB_Click(objBusinessCnctPage.getSaveBeneficiariesBtn(), "Save Beneficiaries Next");
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void clientDocDelvryDetails(String docDelvryDate) {
		try {
			// enter the client doc delivery date
			SeleniumUtilities.WEB_SendKeys(objBusinessCnctPage.getDocDelvryDtAdvEdt(), "Document Delivery Date", docDelvryDate);
			
			// click on Next button
			SeleniumUtilities.WEB_JSclick(objBusinessCnctPage.getSaveDocDelvryBtn(), "Save Document Delivery -> Next");
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void repInfo() {
		try {
			// click on Next button
			SeleniumUtilities.WEB_JSclick(objBusinessCnctPage.getSaveRepIdBtn(), "Save Rep Info -> Next");
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void infoSummaryDetails() {
		try {
			// click on Next button
			SeleniumUtilities.WEB_Click(objBusinessCnctPage.getSaveInfoSummaryBtn(), "Save Summary -> Next");
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void generatePaperWorkProcess() {
		try {
			// click on Generate paper work
			SeleniumUtilities.WEB_Click(objBusinessCnctPage.getGeneratePaperWorkBtn(), "Generate Paper Work");
			
			//let me  initiate error check
			SeleniumUtilities.WEB_Click(objBusinessCnctPage.getInitiateErrChckbtn(), "Initiate Error Check");
			
			if(SeleniumUtilities.WEB_isDisplayed(objBusinessCnctPage.getPaperWorkGenrtnProgressBar())) {
				logger.log(Status.FAIL, "Before Clicking on 'OK' button on Generate PaperWork Modal dialog box, client account creation process started");
			}
			
			//Screenshot
			SeleniumUtilities.WEB_getScreenShot("generatePaperWorkProcess"+SeleniumUtilities.WEB_GenerateRandomNumber(0, 9));
			
			// click on 'Ok'on generate paper work
			SeleniumUtilities.WEB_Click(objBusinessCnctPage.getGeneratePaperWrkOkBtn(), "Generate PaperWork -> Ok");
			
			//Condition to disappear the progress bar
			while(SeleniumUtilities.WEB_isDisplayed(objBusinessCnctPage.getPaperWorkGenrtnProgressBar())) {
				Thread.sleep(1000);
				logger.log(Status.INFO, "Paperwork Generation is InProgress");
			}
			
			//Screenshot
			SeleniumUtilities.WEB_getScreenShot("generatePaperWorkProcess"+SeleniumUtilities.WEB_GenerateRandomNumber(0, 9));
			
			//OES ID
			SeleniumUtilities.WEB_getVisibleText(objBusinessCnctPage.getOESID());
			
			//Parent window
			String parentWindow = SeleniumUtilities.WEB_GetParentWindowID();
			
			//close current window
			SeleniumUtilities.WEB_CloseCurrentWindow();
			
			//Switch back to parent
			SeleniumUtilities.WEB_windowSwitchingBackToParent(parentWindow);
			
			//logout
			logOut();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void errorChckAtGeneratePaperWork() {
		try {
			// click on Generate paper work
			SeleniumUtilities.WEB_Click(objBusinessCnctPage.getGeneratePaperWorkBtn(), "Generate Paper Work");
			
			//take screenshot
			SeleniumUtilities.WEB_getScreenShot("Initiate Error Check");
			
			//let me  initiate error check
			SeleniumUtilities.WEB_Click(objBusinessCnctPage.getInitiateErrChckbtn(), "Initiate Error Check");
			
			//take screenshot
			SeleniumUtilities.WEB_getScreenShot("Ignore errors and generate paper work");
			
			//Screenshot
			SeleniumUtilities.WEB_getScreenShot("errorChckAtGeneratePaperWork"+SeleniumUtilities.WEB_GenerateRandomNumber(0, 9));
			
			//Ignore errors and generate paper work
			SeleniumUtilities.WEB_Click(objBusinessCnctPage.getIgnoreErrAndGenertePaprWrkBtn(), "Ignore errors and generate paper work");
			
			//Condition to disappear the progress bar
			while(SeleniumUtilities.WEB_isDisplayed(objBusinessCnctPage.getPaperWorkGenrtnProgressBar())) {
				Thread.sleep(1000);
				logger.log(Status.INFO, "Paperwork Generation is InProgress");
			}
			//Screenshot
			SeleniumUtilities.WEB_getScreenShot("errorChckAtGeneratePaperWork"+SeleniumUtilities.WEB_GenerateRandomNumber(0, 9));
			
			//OES ID
			SeleniumUtilities.WEB_getVisibleText(objBusinessCnctPage.getOESID());
			
			//Parent window
			String parentWindow = SeleniumUtilities.WEB_GetParentWindowID();
			
			//close current window
			SeleniumUtilities.WEB_CloseCurrentWindow();
			
			//Switch back to parent
			SeleniumUtilities.WEB_windowSwitchingBackToParent(parentWindow);
			
			//Logout
			logOut();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}