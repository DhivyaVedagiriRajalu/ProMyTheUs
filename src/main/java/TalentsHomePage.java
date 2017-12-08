import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class TalentsHomePage {
    WebDriver driver;
    WebDriverWait waitVar;
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
    By firstCheckBox = By.xpath("(//input[@type = 'checkbox'])[2]");
    By tableRows = By.xpath("//tbody/tr");
    By selectAllCheckBox = By.xpath("(//input[@type = 'checkbox'])[1]");
    By activeTalents = By.xpath("//tbody/tr/td[@class='status text-center']/em[@title='ACTIVE']");
    By disableButton = By.xpath("//button[text()='Disable']");
    By activeTalentsCheckBox = By.xpath("//tr[td[em[@title='ACTIVE']]]/td[div[@class='checkbox c-checkbox']]");
    By enableButton = By.xpath("//button[text()='Enable']");
    By inActiveTalentsCheckBox = By.xpath("//tr[td[em[@title='INACTIVE']]]/td[div[@class='checkbox c-checkbox']]");
   // By firstRowInTable = By.xpath("//table/tbody/tr[1]/td[div[@class='checkbox c-checkbox']]");
    By archiveButton = By.xpath("//button[text()='Archive']");
    By firstTalent = By.xpath("//tbody/tr[1]");
    By secondTalent = By.xpath("//tbody/tr[2]");
    By selectDropDown = By.xpath("/html/body/app/ui-view/public-area/div/ui-view/talents-section/div/section/div/div/spinner-container/div[1]/div/div[1]/div/div/select");
    By talentName = By.linkText("tyiyu  wrwe");
    By personBtn = By.xpath("//*[@id=\"talentForm\"]/wizard-form/div/ol/li[2]");
    By profileIcon = By.xpath("//li[@class='dropdown dropdown-list']/a/em[@class='icon-user']");
    By signOut = By.xpath("//a[@class='list-group-item']/div/div[2]/p[text()='Sign Out']");
    By tradeMark = By.xpath("//footer/div[1]");
    By version = By.xpath("//footer/div[2]");
    By iconOptions=By.xpath("/html/body/app/ui-view/public-area/div/header/nav/div[2]/ul[2]/li[2]/ul/li/div/a");


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
       driver.findElement(newTab).click();
    }

    //Select category to created new talent
    public void clickCategory_selectOption() {
        for(int i=0;i<=2;i++){
            driver.findElement(dropDown).click();
        }
        driver.findElement(selectOption).click();
        driver.findElement(nextBtn).click();
 }

    //Enter firstName and LastName in Personal Tab
    public void enter_firstName_lastName(String sFirstName,String sLastName) throws Exception{
        driver.findElement(firstName).sendKeys(sFirstName);
        driver.findElement(lastName).sendKeys(sLastName);
    }

    //Enter address and contact details
    public void enter_address_contact(String street, String city, String email, String phone, String state, String zip) throws Exception{
        driver.findElement(addressLine1).sendKeys(street);
        driver.findElement(addressLine2).sendKeys(city);
        driver.findElement(emailAdress).sendKeys(email);
        driver.findElement(phoneNumber).sendKeys(phone);
        System.out.println("ph "+phone);
        driver.findElement(addressLine3).sendKeys(state);

        //String zip = ExcelUtils.getCellData(6,2);
        System.out.println("zip " + zip);
        driver.findElement(addressLine4).sendKeys(zip);


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
        waitVar = new WebDriverWait(driver,15);
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
    public List<WebElement> search_talent(String searchName) throws Exception{
        driver.findElement(searchTalent).sendKeys(searchName);
        waitVar = new WebDriverWait(driver,15);
        waitVar.until(ExpectedConditions.visibilityOf(driver.findElement(searchTalentBtn)));
        driver.findElement(searchTalentBtn).click();


        List<WebElement> searchedData = driver.findElements(tableRows);
        return searchedData;
    }

    //Select talent
    public WebElement select_Talent(){
        WebElement checkBox = driver.findElement(firstCheckBox);
        checkBox.click();
        return checkBox;
    }
    //Select multiple talent
    public List<WebElement> select_Multiple_Talent(){
      //  By tableRows1 = By.xpath();
        waitVar = new WebDriverWait(driver,15);
        waitVar.until(ExpectedConditions.visibilityOfElementLocated(tableRows));
        List<WebElement> checkBoxList = driver.findElements(tableRows);
        for (WebElement x: checkBoxList) {
            x.click();
        }
     return checkBoxList;
    }
    //Select All talent
    public List<WebElement> select_All_Talent(){
        driver.findElement(selectAllCheckBox).click();
        List<WebElement> noOfTalents = driver.findElements(tableRows);
        return noOfTalents;
    }

    //Verify Talents are active by default
    public int no_Of_Talents(){
        waitVar = new WebDriverWait(driver,15);
        waitVar.until(ExpectedConditions.visibilityOfElementLocated(tableRows));
        int noOfTalents = driver.findElements(tableRows).size();
        return noOfTalents;
    }
    public int no_Of_Active_Talents(){
        int noOfActiveTalents = driver.findElements(activeTalents).size();
        return noOfActiveTalents;
    }

    //Change challenge status inactive
    public List<WebElement> disable_Talent() {
        WebElement inactiveColumn;
        List<WebElement> elements_disabled = new ArrayList<WebElement>();
        List<WebElement> activeTalentList = driver.findElements(activeTalentsCheckBox);
        System.out.println("activeTalentList.size() "+activeTalentList.size());
        if(activeTalentList.size()>=1){
            for (WebElement element:activeTalentList) {
                element.click();
                inactiveColumn = element.findElement(By.xpath("//tr/td/em[@title='ACTIVE']"));
                elements_disabled.add(inactiveColumn);

            }
            if(driver.findElement(disableButton).isEnabled()) {
                driver.findElement(disableButton).click();
                //to retrieve one column element from another column element in a table row

                // element.click();
            }

        }
        else{
            System.out.println("No active talents found to disable");
        }
        return elements_disabled;
    }

    //Change inactive challenge status to active
    public List<WebElement> enable_Talent() {
        WebElement activeColumn;
        List<WebElement> elements_enabled = new ArrayList<WebElement>();
        List<WebElement> inActiveTalentList = driver.findElements(inActiveTalentsCheckBox);
        System.out.println("inActiveTalentList.size() "+inActiveTalentList.size());
        if(inActiveTalentList.size()>=1){
            for (WebElement element:inActiveTalentList) {
                element.click();
                activeColumn = element.findElement(By.xpath("//tr/td/em[@title='INACTIVE']"));
                elements_enabled.add(activeColumn);
            }
            if(driver.findElement(enableButton).isEnabled()) {
                driver.findElement(enableButton).click();
            }
        }
        else{
            System.out.println("No inactive talents found to enable");
        }
        return elements_enabled;
    }

    //Change inactive challenge status to active
    public WebElement archive_Talent() {
        WebElement secondRow = null;
        List<WebElement> noOfTalents = driver.findElements(tableRows);
        if(noOfTalents.size()>0){
          secondRow = driver.findElement(secondTalent);
          driver.findElement(firstCheckBox).click();
          WebElement archive = driver.findElement(archiveButton);
          if(archive.isEnabled()){
              archive.click();
          }
        }
        return secondRow;
    }

    //Select number of talents to be displayed in first page
    public String numberOfTalentsInFirstPage(String noOfTalentToDisplay) {
        Select selectVar = new Select(driver.findElement(selectDropDown));
        selectVar.selectByVisibleText(noOfTalentToDisplay);
        String noOfRowsInPage1 = driver.findElements(tableRows).size()+"";
        return noOfRowsInPage1;
    }

    //Navigate to talent's profile by clicking talent's name
    public String[] clickTalentName(String title){
        driver.findElement(talentName).click();
        String[] name = new String[2];
        waitVar = new WebDriverWait(driver,15);
        waitVar.until(ExpectedConditions.visibilityOfElementLocated(personBtn));
        driver.findElement(personBtn).click();
        waitVar = new WebDriverWait(driver,15);
        waitVar.until(ExpectedConditions.titleIs(title));
        name[0]=driver.findElement(firstName).getAttribute("value");
        name[1]=driver.findElement(lastName).getAttribute("value");
        return name;
    }

    //Click sign out under profile icon
    public void clickSignOut(){
        driver.findElement(profileIcon).click();
        driver.findElement(signOut).click();
    }

    //Check trademark in footer
    public WebElement checkForTrademark(){
        return driver.findElement(tradeMark);
    }

    //Check verrsion in footer
    public WebElement checkForVersion(){
        return driver.findElement(version);
    }

    //Click profile icon
    public List<WebElement> clickProfileIcon(){
        driver.findElement(profileIcon).click();
        List<WebElement> profileOptions = driver.findElements(iconOptions);
        return profileOptions;
    }
}
