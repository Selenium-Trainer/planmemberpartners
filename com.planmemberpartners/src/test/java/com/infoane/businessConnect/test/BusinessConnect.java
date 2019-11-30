package com.infoane.businessConnect.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.infoane.utilities.BusinessConnectUtilities;
import com.infoane.utilities.HomeUtilities;
import com.infoane.utilities.LogInOutUtilities;
import com.infoane.utilities.SeleniumUtilities;

public class BusinessConnect extends SeleniumUtilities{
	
	//Test Data 
	@DataProvider(name = "client_FullData")
	public Object[][] client_FullData() throws Exception {
		Object[][] retObjArr = WEB_GetExcelData(path, "businessCnct", "client_FullData");
		return retObjArr;
	}
	
	//Test Data 
	@DataProvider(name = "client_Fname_ErrCheck")
	public Object[][] client_Fname_ErrCheck() throws Exception {
		Object[][] retObjArr = WEB_GetExcelData(path, "businessCnct", "client_Fname_ErrCheck");
		return retObjArr;
	}
	
	//Test Data 
	@DataProvider(name = "client_PartialData")
	public Object[][] client_PartialData() throws Exception {
		Object[][] retObjArr = WEB_GetExcelData(path, "businessCnct", "client_PartialData");
		return retObjArr;
	}

	@Test(priority=1, dataProvider="client_FullData", enabled=true)
	public void testNewClientCreation(String userName, String passWord, String repLNameValue, String accType, String clientFname, String clientLname, 
			String clientEmail, String primaryCnctNumber, String clinetAddrLine1, String clientZIPcode, String clientDOB, String clientMaritalStatus, 
			String clientIDType, String clientIDnum, String clientStateOfInsurance, String clientIDexpDt, String clientOccupation, String employer, 
			String dateOfHire, String annualIncome, String netWorth, String liquidNetWorth, String taxRate, String annualExpnse, String specialExpense, 
			String timeFrameSpecialExpense, String investorObjective, String investmtPurpose, String liquidityNeeds, String investType, String checkBxNum, 
			String investmentAllocation, String productName, String initiaAllocation, String subsequenceAllocation, String advFee, String BenefitsOfProposedProdValue, 
			String BenefitsOfExistingProdValue,String docDelvryDate) {
		
		//creating instances
		LogInOutUtilities objLogInOutUtilities = new LogInOutUtilities();
		HomeUtilities objHomeUtilities = new HomeUtilities();
		BusinessConnectUtilities objBusinessCnctUtilities = new BusinessConnectUtilities();
		
		try {
			//login into the application
			objLogInOutUtilities.login(userName, passWord);
			
			//creating the representative
			objHomeUtilities.connectRepresentative(repLNameValue);
			
			//business connect process
			objBusinessCnctUtilities.businessConnectProcess();
			
			//entering the client basic account details
			objBusinessCnctUtilities.clientAccInfo(accType, clientFname, clientLname, clientEmail, primaryCnctNumber, clinetAddrLine1, clientZIPcode);
			
			//entering client identity details
			objBusinessCnctUtilities.clientIdentity(clientDOB, clientMaritalStatus, clientIDType, clientIDnum, clientStateOfInsurance, clientIDexpDt);
			
			//entering client employment
			objBusinessCnctUtilities.clientEmployementDetails(clientOccupation, employer, dateOfHire);
			
			//entering client financial
			objBusinessCnctUtilities.clientFinancialDetails(annualIncome, netWorth, liquidNetWorth, taxRate, annualExpnse, specialExpense, timeFrameSpecialExpense);
			
			//entering client liquidity
			objBusinessCnctUtilities.clientLiquidityDetails(investorObjective, investmtPurpose, liquidityNeeds);
			
			//entering client investment
			objBusinessCnctUtilities.clientInvestmentDetails(investType, checkBxNum, investmentAllocation);
			
			//entering client product investment details
			objBusinessCnctUtilities.clientProductDetails(productName, initiaAllocation, subsequenceAllocation);
			
			//entering client RTQ details
			objBusinessCnctUtilities.clientRTQDetails();
			
			//entering client port folio details
			objBusinessCnctUtilities.clientPortFolioDetails(advFee);
			
			//entering client advisory details
			objBusinessCnctUtilities.clientAdvisoryFeeBenefits(BenefitsOfProposedProdValue, BenefitsOfExistingProdValue);
			
			//entering client roll over details
			objBusinessCnctUtilities.clientRollOverDetails();
			
			//entering client salary deferral details
			objBusinessCnctUtilities.clientSalaryDeferralDetails();
			
			//entering client beneficiaries details
			objBusinessCnctUtilities.clientSaveBeneficiariesDetails();
			
			//entering client document delivery details
			objBusinessCnctUtilities.clientDocDelvryDetails(docDelvryDate);
			
			//rep information
			objBusinessCnctUtilities.repInfo();
			
			//information summary details
			objBusinessCnctUtilities.infoSummaryDetails();
			
			//generate paper work
			objBusinessCnctUtilities.generatePaperWorkProcess();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test(priority=2, dataProvider="client_Fname_ErrCheck", enabled=true)
	public void testClientFnameErrCheck(String userName, String passWord, String repLNameValue, String accType, String clientFname, String clientLname, 
			String clientEmail, String primaryCnctNumber, String clinetAddrLine1, String clientZIPcode) {
		
		//creating instances
		LogInOutUtilities objLogInOutUtilities = new LogInOutUtilities();
		HomeUtilities objHomeUtilities = new HomeUtilities();
		BusinessConnectUtilities objBusinessCnctUtilities = new BusinessConnectUtilities();
		
		try {
			//login into the application
			objLogInOutUtilities.login(userName, passWord);
			
			//creating the representative
			objHomeUtilities.connectRepresentative(repLNameValue);
			
			//business connect process
			objBusinessCnctUtilities.businessConnectProcess();
			
			//entering the client basic account details
			objBusinessCnctUtilities.clientAccInfo(accType, clientFname, clientLname, clientEmail, primaryCnctNumber, clinetAddrLine1, clientZIPcode);
			
			//error message validation
			objBusinessCnctUtilities.clientFnameErrMsgValidation();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
		
	@Test(priority=3, dataProvider="client_PartialData", enabled=true)
	public void testNewClientCreationWithPartialData(String userName, String passWord, String repLNameValue, String accType, String clientFname, String clientLname, 
			String clientEmail, String primaryCnctNumber, String clinetAddrLine1, String clientZIPcode, String clientDOB, String clientMaritalStatus, 
			String clientIDType, String clientIDnum, String clientStateOfInsurance, String clientIDexpDt, String clientOccupation, String employer, 
			String dateOfHire, String annualIncome, String netWorth, String liquidNetWorth, String taxRate, String annualExpnse, String specialExpense, 
			String timeFrameSpecialExpense, String investorObjective, String investmtPurpose, String liquidityNeeds, String investType, String checkBxNum, 
			String investmentAllocation, String productName, String initiaAllocation, String subsequenceAllocation, String advFee, String BenefitsOfProposedProdValue, 
			String BenefitsOfExistingProdValue,String docDelvryDate) {
		
		//creating instances
		LogInOutUtilities objLogInOutUtilities = new LogInOutUtilities();
		HomeUtilities objHomeUtilities = new HomeUtilities();
		BusinessConnectUtilities objBusinessCnctUtilities = new BusinessConnectUtilities();
		
		try {
			//login into the application
			objLogInOutUtilities.login(userName, passWord);
			
			//creating the representative
			objHomeUtilities.connectRepresentative(repLNameValue);
			
			//business connect process
			objBusinessCnctUtilities.businessConnectProcess();
			
			//entering the client basic account details
			objBusinessCnctUtilities.clientAccInfo(accType, clientFname, clientLname, clientEmail, primaryCnctNumber, clinetAddrLine1, clientZIPcode);
			
			//entering client identity details
			objBusinessCnctUtilities.clientIdentity(clientDOB, clientMaritalStatus, clientIDType, clientIDnum, clientStateOfInsurance, clientIDexpDt);
			
			//entering client employment
			objBusinessCnctUtilities.clientEmployementDetails(clientOccupation, employer, dateOfHire);
			
			//entering client financial
			objBusinessCnctUtilities.clientFinancialDetails(annualIncome, netWorth, liquidNetWorth, taxRate, annualExpnse, specialExpense, timeFrameSpecialExpense);
			
			//entering client liquidity
			objBusinessCnctUtilities.clientLiquidityDetails(investorObjective, investmtPurpose, liquidityNeeds);
			
			//entering client investment
			objBusinessCnctUtilities.clientInvestmentDetails(investType, checkBxNum, investmentAllocation);
			
			//entering client product investment details
			objBusinessCnctUtilities.clientProductDetails(productName, initiaAllocation, subsequenceAllocation);
			
			//entering client RTQ details
			objBusinessCnctUtilities.clientRTQDetails();
			
			//entering client port folio details
			objBusinessCnctUtilities.clientPortFolioDetails(advFee);
			
			//entering client advisory details
			objBusinessCnctUtilities.clientAdvisoryFeeBenefits(BenefitsOfProposedProdValue, BenefitsOfExistingProdValue);
			
			//entering client roll over details
			objBusinessCnctUtilities.clientRollOverDetails();
			
			//entering client salary deferral details
			objBusinessCnctUtilities.clientSalaryDeferralDetails();
			
			//entering client beneficiaries details
			objBusinessCnctUtilities.clientSaveBeneficiariesDetails();
			
			//entering client document delivery details
			objBusinessCnctUtilities.clientDocDelvryDetails(docDelvryDate);
			
			//rep information
			objBusinessCnctUtilities.repInfo();
			
			//information summary details
			objBusinessCnctUtilities.infoSummaryDetails();
			
			//generate paper work
			objBusinessCnctUtilities.errorChckAtGeneratePaperWork();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}