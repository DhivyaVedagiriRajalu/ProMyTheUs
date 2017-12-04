import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestSignIn {

    SignInPage objSignIn;
    WebDriver driver;
    String excelPath="C:\\Users\\Dhivya Balaji\\IdeaProjects\\ProMyTheUs\\src\\test\\TestData\\";
    String excelName="TestData.xlsx";

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

        //Create signIn Page object
        objSignIn = new SignInPage(driver);

        //setting path to excel to access the data
        ExcelUtils.setExcelFile(excelPath+excelName,"Sheet1");
       }

     @Test(priority = 0)
     public void test_to_type_in_username_password()throws Exception{

        //send email address to the email field
         String userName=objSignIn.setUserName();

         //send password to the password field
         String password=objSignIn.setPassword();

         //Test to check user can type in the username and password field
        Assert.assertEquals(objSignIn.getuserName().getAttribute("value"),userName);
        Assert.assertEquals(objSignIn.getPassword().getAttribute("value"),password);
     }
   @Test(priority = 1)
   public void test_navigation_after_login()throws Exception{

       String title = ExcelUtils.getCellData(2,1);
        //Click login to verify user login with valid credentials
        objSignIn.clickLogin();

        //Verify user navigates to Talents screen after Login
       WebDriverWait waitVar = new WebDriverWait(driver,15);
       waitVar.until(ExpectedConditions.titleIs(title));
       Assert.assertEquals(driver.getTitle(),title);
    }
}
