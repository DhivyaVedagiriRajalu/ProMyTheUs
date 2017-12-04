import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TalentsHomePage {
    WebDriver driver;
    //public WebElement dropdown;
    By userName = By.className("img-responsive");
    By newTab = By.linkText("New");
    //By dropDown = By.xpath("//span[@class='btn btn-default form-control ui-select-toggle']");
    By dropDown = By.xpath("//div[@name='category']");
    By selectOption = By.xpath("//span[@class='ui-select-choices-row-inner' and text()='Music']");
    //By talentList = By.xpath("//li[@id='ui-select-choices-0']/div[contains(@class,'ui-select-choices-row ng-scope')]");
    By nextBtn = By.xpath("//button[text()='Next']");
    By firstName = By.name("firstName");
    By lastName = By.name("lastName");
    By quickTestTab = By.xpath("//li/span[text()='Quick Tests']");
    By finshBtn = By.xpath("//button[text()='Finish']");
    By addressLine1 = By.id("address");
    By addressLine2 = By.name("city");
    By addressLine3 = By.name("addressState");
    By addressLine4 = By.name("zip");
    By emailAdress = By.name("email");
    By phoneNumber = By.name("phone");
    By nameEntered = By.xpath("//table/tbody/tr[1]/td[2]");
    By addressEntered = By.xpath("//table/tbody/tr[1]/td[4]");
    By emailEntered = By.xpath("//table/tbody/tr[1]/td[6]");
    By phoneEntered = By.xpath("//table/tbody/tr[1]/td[5]");
    By editIcon = By.xpath("(//a[@class='clear-hover'])[1]");
    By searchTalent = By.name("search");
    By searchTalentBtn = By.xpath("//button[text()='Search']");
    By firstCheckBox = By.xpath("(//span[@class='fa fa-check'])[2]");


    //constructor
    public TalentsHomePage(WebDriver driver){
        this.driver = driver;
    }

    //Click ProMyTheUs Logo in talents home
    public void clickLogo(){

        driver.findElement(userName).click();
    }

    //Click New tab in talents home
    public void clickNew(){
        //System.out.println("link name "+driver.findElement(newTab).getText());
        driver.findElement(newTab).click();
    }

    //Select category to created new talent
    public void clickCategory_selectOption() {
        for(int i=0;i<=2;i++){
            driver.findElement(dropDown).click();
        }

        driver.findElement(selectOption).click();
//        List<WebElement> optionList = driver.findElements(talentList);
//        System.out.println("option "+optionList.get(2).getText());
//        optionList.get(30).click();
        driver.findElement(nextBtn).click();

 }

    //Enter firstName and LastName in Personal Tab
    public void enter_firstName_lastName() throws Exception{
        String sFirstName = ExcelUtils.getCellData(3,1);
        driver.findElement(firstName).sendKeys(sFirstName);

        String sLastName = ExcelUtils.getCellData(3,2);
        driver.findElement(lastName).sendKeys(sLastName);
    }

    //Enter address and contact details
    public void enter_address_contact() throws Exception{
        String street = ExcelUtils.getCellData(4,1);
        driver.findElement(addressLine1).sendKeys(street);

        String city = ExcelUtils.getCellData(4,2);
        driver.findElement(addressLine2).sendKeys(city);

        String state = ExcelUtils.getCellData(6,1);
        System.out.println("State " + state);
        driver.findElement(addressLine3).sendKeys(state);

        String zip = ExcelUtils.getCellData(6,2);
        System.out.println("zip " + zip);
        driver.findElement(addressLine4).sendKeys(zip);

        String email = ExcelUtils.getCellData(5,1);
        driver.findElement(emailAdress).sendKeys(email);

        String phone = ExcelUtils.getCellData(5,2);
        System.out.println("in phone section");

        driver.findElement(phoneNumber).sendKeys(phone);
        System.out.println("ph "+phone);
    }

    //Click QuickTest tab to finish the talent creation
    public void click_QuickTest(){
        driver.findElement(quickTestTab).click();
        driver.findElement(finshBtn).click();
    }

    //Send the data displayed in talent home page for verification
    public String[] retrieve_newTalent_data() throws Exception{
        String[] talentInfo = new String[4];
        String title = ExcelUtils.getCellData(2,1);
        WebDriverWait waitVar = new WebDriverWait(driver,20);
        waitVar.until(ExpectedConditions.titleIs(title));
        talentInfo[0]=driver.findElement(nameEntered).getText();
        talentInfo[1]=driver.findElement(addressEntered).getText();
        talentInfo[2]=driver.findElement(emailEntered).getText();
        talentInfo[3]=driver.findElement(phoneEntered).getText();

        return talentInfo;
    }

    //edit talent profile
    public void click_edit_talent(){
        driver.findElement(editIcon).click();
    }

    //search talent using search field in talent's home page
    public void search_talent() throws Exception{
        String searchName = ExcelUtils.getCellData(7,1);
        driver.findElement(searchTalent).sendKeys(searchName);
        driver.findElement(searchTalentBtn).click();
    }

    //Select talent
    public void select_Talent(){
        driver.findElement(firstCheckBox).click();
    }
}
