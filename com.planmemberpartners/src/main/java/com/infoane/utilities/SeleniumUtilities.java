package com.infoane.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class SeleniumUtilities extends ReportsUtilities{

	//Different OS
	public static String getDriverPath() {
		String OS = System.getProperty("os.name");
		//Driver Path
		String strDriverPath = null;

		switch(browser.toUpperCase()){
		case "CHROME":
			if (OS.contains("Window")) {
				strDriverPath = System.getProperty("user.dir") + "/Drivers/chromedriver.exe";
			}
			break;

		case "IE":
			if (OS.contains("Window")) {
				strDriverPath = System.getProperty("user.dir") + "/Drivers/IEDriverServer.exe";
			}
			break;

		case "FIREFOX":
			if (OS.contains("Window")) {
				strDriverPath = System.getProperty("user.dir") + "/Drivers/geckodriver.exe";
			}
			break;
		}
		return strDriverPath;
	}

	@BeforeSuite
	public static void beforeSuiteConfig(ITestContext context){
		try{
			
			//Creating Reports Folder
			if(!(new File(System.getProperty("user.dir") +"/Reports/")).exists())
				new File(System.getProperty("user.dir") +"/Reports/").mkdir();

			//Creating Folder to place reports
			reportFolder = new SimpleDateFormat("dd_MMM_yyyy").format(Calendar.getInstance().getTime());
			reportPath = new File(System.getProperty("user.dir") +"/Reports/"+reportFolder);

			//to check whether the report path folder exist or not
			if(!reportPath.exists()){
				//If the file not exist, it will create a new folder
				reportPath.mkdir();
			}

			//reading the system OS
			String OS = System.getProperty("os.name");

			//Test Data path
			path = System.getProperty("user.dir") + "/planmemberpartners_data/testdata.xls";

			//Reading values from TestNG.xml
			environment = context.getCurrentXmlTest().getParameter("environment");
			browser = context.getCurrentXmlTest().getParameter("browser");

			if (environment.equalsIgnoreCase("dev"))
				URL = "https://dev.planmemberpartners.com/";

			//Kill the browser from task manager 
			switch(browser.toUpperCase()){

			case "CHROME":
				if (OS.contains("Window")) {
					try {
						//Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
						Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				break;
			}
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail("Failed to Execute Before Suite");
		}
	}

	@BeforeMethod
	public static void launchBrowser(Method method){
		try{
			//report instance creation
			logger = extent.createTest(method.getName());
			
			//Initializing the Browser 
			switch(browser.toUpperCase()){

			case "CHROME":
				try {
					System.setProperty("webdriver.chrome.driver",getDriverPath());
					try{
						driver = new ChromeDriver();
					}catch(Exception e){
						driver = null;
						driver = new ChromeDriver();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}

			//Launching Browser with given URL
			driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
			driver.get(URL);

			//Delete cookies
			WEB_deleteAllCookies();

			//Maximize the browser window
			driver.manage().window().maximize();
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail("Failed to Initialize/Launch Browser");
		}
	}

	@AfterSuite
	public void afterSuiteConfig(){
		try{
			driver.quit();
		}catch(Exception e){

		}
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static void WEB_Click(WebElement element, String buttonName){
		try{
			//condition to check , is spinner available
			if(element.isEnabled()){
				//Clicking on WebElement
				element.click();
				logger.log(Status.PASS, "Clicked on "+"'"+buttonName+"'"+ " button");
			}else{
				logger.log(Status.FAIL, "Failed to click "+buttonName);
				Assert.fail("'"+buttonName+"'" + " : Button is not enabled");
			}
		}catch(NoSuchElementException e){
			e.printStackTrace();
			logger.log(Status.FAIL, " : Button not found");
			Assert.fail(element + " : Button not found");
		}catch(ElementNotVisibleException e){
			e.printStackTrace();
			logger.log(Status.FAIL, " : Button not visible");
			Assert.fail(element + " : Button not visible");
		}
	}
	
	public static void WEB_JSclick(WebElement element, String buttonName) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			logger.log(Status.INFO, "Clicked on "+"'"+buttonName+"'"+ " button");
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	public static void WEB_SendKeys(WebElement element, String fieldName, String Value){
		try{
			//To check the field is enable or not
			WEB_Click(element, fieldName);

			//To clear the existed value
			element.clear();

			//To enter current value
			element.sendKeys(Value);
			if(!fieldName.equals("Password"))
				logger.log(Status.INFO, "Entered the value in "+fieldName+" as: "+Value);
			else
				logger.log(Status.INFO, "Entered the value in "+fieldName+" as: **********");
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail("Failed to Enter Values in: "+fieldName);
		}
	}

	public static WebElement WEB_ExplicitWait(WebElement element){
		try{
			//WebDriverWait Initialization
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
			WEB_Page_Scroll(element);
			WEB_HighlightWebElement(element);
		}catch(Exception e){
			logger.log(Status.INFO, "Element not found");
			element = null;
		}
		return element;
	}
	
	public static List<WebElement> WEB_ExplicitWait(List<WebElement> elements){
		try{
			//WebDriverWait Initialization
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
			WEB_Page_Scroll(elements.get(0));
		}catch(Exception e){
			logger.log(Status.INFO, "Element not found");
		}
		return elements;
	}
	
	public static List<WebElement> WEB_ExplicitWait(List<WebElement> elements, int timeUnitSeconds){
		try{
			//WebDriverWait Initialization
			WebDriverWait wait = new WebDriverWait(driver, timeUnitSeconds);
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
			WEB_Page_Scroll(elements.get(0));
		}catch(Exception e){
			logger.log(Status.INFO, "Element not found");
		}
		return elements;
	}

	public static WebElement WEB_ExplicitWait(WebElement element, int timeUnitSeconds){
		try{
			//WebDriverWait Initialization
			WebDriverWait wait = new WebDriverWait(driver, timeUnitSeconds);
			wait.until(ExpectedConditions.visibilityOf(element));
			if(browser.equalsIgnoreCase("Firefox")){
				if(!element.isDisplayed()){
					for(int i=0;i<60;i++){
						try{
							wait.until(ExpectedConditions.visibilityOf(element));
							if(element.isDisplayed())
								break;
							else
								Thread.sleep(1000);
						}catch(Exception e){
							continue;
						}
					}
				}
			}
			WEB_Page_Scroll(element);
			WEB_HighlightWebElement(element);
		}catch(Exception e){
			logger.log(Status.INFO, "Element not found");
			element = null;
		}
		return element;
	}

	public static void WEB_HighlightWebElement(WebElement element){
		try{
			for(int i=0; i<5; i++){
				((JavascriptExecutor)driver).executeScript("arguments[0].style.border='2px solid yellow'", element);
				((JavascriptExecutor)driver).executeScript("arguments[0].style.border='2px solid skyblue'", element);
			}
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail("Unable to HighLight Element");
		}
	}

	public static void WEB_Page_Scroll(WebElement element){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			wait.until(ExpectedConditions.visibilityOf(element));
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail("Unable to Scroll Element");
		}
	}

	public static String WEB_getVisibleText(WebElement element){
		String str_VisibleText = null;
		try{
			if(element.isDisplayed()){
				str_VisibleText = element.getText().trim();
				logger.log(Status.INFO, "Fetched Visible Text : "+str_VisibleText);
			}else{
				Assert.fail("Unable to 'Get Text' from Element");
			}
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail("Unable to 'Get Text' from Element");
		}
		return str_VisibleText;
	}

	public static String WEB_getAttribute(WebElement element, String value){
		String str_VisibleText = null;
		try{
			if(element.isDisplayed()){
				str_VisibleText = element.getAttribute(value).trim();
				logger.log(Status.INFO, "Fetched Attribute value as : "+str_VisibleText);
			}else{
				Assert.fail("Unable to 'Get Attribute' from Element");
			}
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail("Unable to 'Get Attribute' from Element");
		}
		return str_VisibleText;
	}

	public static boolean WEB_FrameSwitching(String frameType, int index, String nameOrId, WebElement frameElement){
		boolean isFrameSwitched = false;
		try{
			switch(frameType.toLowerCase()){
			case "index":
				driver.switchTo().frame(index);
				isFrameSwitched = true;
				break;
			case "nameorid":
				driver.switchTo().frame(nameOrId);
				isFrameSwitched = true;
				break;
			case "frameelement":
				driver.switchTo().frame(frameElement);
				isFrameSwitched = true;
				break;
			default:
				Assert.fail("Please give proper 'input' to Switch to Frame");
			}
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail("Unable to 'switch Frame' using: "+frameType);
		}
		return isFrameSwitched;
	}

	public static boolean WEB_switchToDefaultContent(){
		boolean isDefaultContent = false;
		try{
			driver.switchTo().defaultContent();
			isDefaultContent = true;
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail("Unable to 'switch back from Frame'");
		}
		return isDefaultContent;
	}

	public String WEB_getWebPageTitle(){
		String strWebPageTitle = null;
		try{
			strWebPageTitle = driver.getTitle().trim();
			logger.log(Status.INFO, "Page Title : "+strWebPageTitle);
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail("Unable to get 'Page Title'");
		}
		return strWebPageTitle;
	}

	public static boolean WEB_Tab(WebElement element){
		boolean isTab = false;
		try{
			element.sendKeys(Keys.chord(Keys.TAB));

			isTab = true;
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail("Unable to 'Tab Out'");
		}
		return isTab;
	}

	public static String[][] WEB_GetExcelData(String xlFilePath, String sheetName,String tableName){
		String[][] tabArray = null;
		try{
			Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			Sheet sheet = workbook.getSheet(sheetName);
			int startRow, startCol, endRow, endCol, ci, cj;
			Cell tableStart = sheet.findCell(tableName);
			startRow = tableStart.getRow();
			startCol = tableStart.getColumn();

			Cell tableEnd = sheet.findCell(tableName, startCol + 1, startRow + 1, 100, 64000, false);

			endRow = tableEnd.getRow();
			endCol = tableEnd.getColumn();
			tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];
			ci = 0;

			for (int i = startRow + 1; i < endRow; i++, ci++) {
				cj = 0;
				startCol = 0;
				for (int j = startCol + 1; j < endCol; j++, cj++) {
					tabArray[ci][cj] = sheet.getCell(j, i).getContents().trim();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail("Unable to read 'Excel data'");
		}
		return (tabArray);
	}

	public static boolean WEB_isEnabled(WebElement element){
		boolean isEnable = false;
		try{
			if(element.isEnabled())
				isEnable = true;
		}catch(Exception e){
			logger.log(Status.INFO, "Element is not Enabled");
		}
		return isEnable;
	}

	public static boolean WEB_selectValuesDrpDwn(WebElement element, String selType, int index, String value, String visibleText){
		boolean isSelected = false;
		try{
			if(element.getTagName().equalsIgnoreCase("SELECT")){
				Select objSelect = new Select(element);
				switch(selType.toUpperCase()){
				case "INDEX":
					objSelect.selectByIndex(index);
					isSelected = true;
					break;

				case "VALUE":
					objSelect.selectByValue(value);
					isSelected = true;
					break;

				case "VISIBLETEXT":
					objSelect.selectByVisibleText(visibleText);
					isSelected = true;
					break;

				default:
					logger.log(Status.FAIL, "Please pass valid Input");
					break;
				}
			}else{
				WEB_Click(element, "Dropdown");
				WebElement searchEdt;
				try {
					searchEdt = element.findElement(By.xpath("./../following-sibling::div/div/input"));
					if(searchEdt.isDisplayed()) {
						WEB_SendKeys(searchEdt, "Dropdown Search", visibleText);
					}
				}catch(Exception e) {
					
				}
				
				List<WebElement> lstul = element.findElements(By.xpath("./../following-sibling::div/ul//li"));
				WEB_ExplicitWait(lstul, 180);
				if(lstul.size()>0){
					for(int i=0; i<lstul.size(); i++){
						if(WEB_getVisibleText(lstul.get(i)).equalsIgnoreCase(visibleText)){
							lstul.get(i).click();
							isSelected = true;
							break;
						}
					}
				}else{
					logger.log(Status.FAIL, "Please input the proper webelement to find the dropdown values");
					Assert.fail();
				}
			}
			
			if(isSelected){
				logger.log(Status.INFO, "Successfully Selected Given element from the Dropdown");
			}else{
				logger.log(Status.FAIL, "Not Selected Given element from the Dropdown");
				Assert.fail("Not Selected Given element from the Dropdown");
			}
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail("Unable to 'Select values from Dropdown'");
		}
		return isSelected;
	}

	public static boolean WEB_isSelected(WebElement element){
		boolean isSelected = false;
		try{
			if(WEB_isEnabled(element)){
				element.isSelected();
				isSelected = true;
			}else{
				logger.log(Status.FAIL, "unable to locate element");
			}
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail("Unable to find element");
		}
		return isSelected;
	}

	public static boolean WEB_isDisplayed(WebElement element){
		boolean isDisplayed = false;
		try{
			// waiting '10' seconds for expected element
			WEB_ExplicitWait(element, 10);
			
			if(element.isDisplayed())
				isDisplayed = true;
		}catch(Exception e){
			logger.log(Status.INFO, "Element is not displayed");
		}
		return isDisplayed;
	}

	public static void WEB_deleteAllCookies(){
		driver.manage().deleteAllCookies();
	}

	public static String WEB_getCurrentWindowHandle(){
		String strCurrWindowHandle = null;
		try{
			strCurrWindowHandle = driver.getWindowHandle();
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail("Failed to get current window handle");
		}
		return strCurrWindowHandle;
	}

	public static Set<String> WEB_getAllWindowHandles(){
		Set<String> strAllWindowHandles = null;
		try{
			strAllWindowHandles = driver.getWindowHandles();
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail("Failed to get all window handles");
		}
		return strAllWindowHandles;
	}

	public static boolean WEB_windowSwitching(String fromWindow){
		boolean isSwitched=false;
		try{
			Set<String> handles =  driver.getWindowHandles();
			logger.log(Status.INFO, "Current Opened Windows: "+handles.size());
			while(handles.size()==1) {
				handles =  driver.getWindowHandles();
			}
			for(String windowHandle  : handles)
			{
				if(!windowHandle.equals(fromWindow))
				{
					driver.switchTo().window(windowHandle);
					logger.log(Status.INFO, "Window Switching is successful");
					isSwitched=true;			     
				}
			}

		}catch(Exception e){
			logger.log(Status.INFO, "Window Switch not successful");
			Assert.fail("WEB_windowSwitching failed");
		}
		return isSwitched;		
	}

	public static boolean WEB_windowSwitchingBackToParent(String toWindow){
		boolean isSwitched=false;
		try{

			driver.switchTo().window(toWindow);
			
			//<!--Perform your operation here for new window--> 
			isSwitched=true;			     

		}catch(Exception e){
			logger.log(Status.INFO, "Window Switch not successful");
			Assert.fail("WEB_windowSwitching failed");
		}
		return isSwitched;		
	}

	public static String WEB_getCurrentUrl(){
		String currentUrl = null;
		try{
			currentUrl = driver.getCurrentUrl();

		}catch(Exception e){
			e.printStackTrace();
			Assert.fail("Unable to get current URL");
		}
		return currentUrl;
	}

	public static void WEB_Clear(WebElement element, String fieldName){
		try{
			//To check the field is enable or not
			WEB_Click(element, fieldName);

			//To clear the existed value
			element.clear();
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail("Failed to clear Values in: "+fieldName);
		}
	}
	
	public static void WEB_MoveToElement(WebElement element) {
		try {
			// actions class 
			Actions act = new Actions(driver);
			
			//move the mouse cursor to an element
			act.moveToElement(element).build().perform();;
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public static void WEB_AcionsClick(WebElement element) {
		try {
			// actions class 
			Actions act = new Actions(driver);
			
			//move the mouse cursor to an element and click on it
			act.moveToElement(element).click(element).build().perform();
			
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public static int WEB_GenerateRandomNumber(int start, int end) {
		int randomInt = 0;
		try {
			randomInt = ThreadLocalRandom.current().nextInt(start, end);
			logger.log(Status.INFO, "Random Number: "+randomInt);
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		return randomInt; 
	}
	
	public static String WEB_GetParentWindowID() {
		String parentWindow = null;
		try {
			//switch back to parent window
			String childWindow = WEB_getCurrentWindowHandle();
			
			Set<String> windowHandles = WEB_getAllWindowHandles();
			
			for(String window: windowHandles) {
				if(!window.equals(childWindow)) {
					parentWindow = window;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		return parentWindow;
	}
	
	public static void WEB_CloseCurrentWindow() {
		try {
			driver.close();
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public static boolean WEB_isSpinnerClosed() {
		boolean isSpinner = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 300);
			wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.id("loadingSpinner"))));
			isSpinner = true;
		}catch(Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
		return isSpinner;
	}
}