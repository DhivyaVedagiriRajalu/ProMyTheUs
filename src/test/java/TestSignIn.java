import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class TestSignIn {

    SignInPage objSignIn;
    TalentsHomePage objTalentsHome;
    WebDriver driver;

    //for data provider
    String excelPath="C:\\Users\\Dhivya Balaji\\IdeaProjects\\ProMyTheUs\\src\\test\\TestData\\TestData.xlsx";
    String sheetName="Sheet1";
    private String sTestCaseName;
    public int iTestCaseRow;

    @BeforeSuite
    public WebDriver setUpDriver(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
    //opening URL and getting firefox connection
    @BeforeTest
    public void setup() throws Exception{
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.get("http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html");

        //Creating objects
        objSignIn = new SignInPage(driver);
        objTalentsHome = new TalentsHomePage(driver);
        //setting path to excel to access the data
       // ExcelUtils.setExcelFile(excelPath,sheetName);
       }

     @Test(priority = 0, dataProvider = "TestData")
     public void test_to_type_in_username_password(String sUserName, String sPassword)throws Exception{

        //send email address to the email field
        String userName=objSignIn.setUserName(sUserName);

         //send password to the password field
         String password=objSignIn.setPassword(sPassword);

         //Test to check user can type in the username and password field
        Assert.assertEquals(objSignIn.getuserName().getAttribute("value"),userName);
        Assert.assertEquals(objSignIn.getPassword().getAttribute("value"),password);
     }
   @Test(priority = 1, dataProvider = "TestData")
   public void test_navigation_after_login(String title)throws Exception{
       //Click login to verify user login with valid credentials
       objSignIn.clickLogin();

        //Verify user navigates to Talents screen after Login
       WebDriverWait waitVar = new WebDriverWait(driver,15);
       waitVar.until(ExpectedConditions.titleIs(title));
       Assert.assertEquals(driver.getTitle(),title);
    }

    @DataProvider
    public Object[][] TestData(Method method) throws Exception{
        // Setting up the Test Data Excel file
        ExcelUtils.setExcelFile(excelPath,sheetName);


        // The below method will give your test case name, exactly the name we have used
        String sTestCaseName = method.getName() ;

        // Fetching the Test Case row number from the Test Data Sheet
        // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet
        iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);
        Object[][] testObjArray = ExcelUtils.getTableArray(excelPath,sheetName,iTestCaseRow);
        return (testObjArray);
    }
}
