import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {
    WebDriver driver;
    By userName = By.name("email");
    By password = By.name("password");
    By login = By.id("login");

    public SignInPage(WebDriver driver){
       this.driver = driver;
    }

    //Get username element
    public WebElement getuserName(){
        return driver.findElement(userName);
    }
    //Get password element
    public WebElement getPassword(){
        return driver.findElement(password);
    }
    //Set user name in textbox
    public String setUserName() throws Exception{
        String strUserName = ExcelUtils.getCellData(1,1);
        driver.findElement(userName).sendKeys(strUserName);
        return strUserName;
    }
    //Set password in password textbox
    public String setPassword()throws Exception{
        String strPassword = ExcelUtils.getCellData(1,2);
        driver.findElement(password).sendKeys(strPassword);
        return strPassword;
    }

    //Click Login button
    public void clickLogin(){
        driver.findElement(login).click();
    }
}
