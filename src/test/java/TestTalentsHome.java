import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestTalentsHome extends TestSignIn{

    String title;

    //click new tab in talents page
    @Test(enabled = true, groups = {"newTalent"}, priority = 2 )
    public void test_click_new_tab() throws Exception{
        objTalentsHome.clickNew();
        title = ExcelUtils.getCellData(2,2);
        WebDriverWait waitVar = new WebDriverWait(driver,10);
        waitVar.until(ExpectedConditions.titleIs(title));
        Assert.assertEquals(driver.getTitle(),title);

    }
    //click logo in the talents page
    @Test(enabled = false, priority = 3)
    public void test_navigation_by_clicking_logo() throws Exception{
        title = ExcelUtils.getCellData(2,1);
        objTalentsHome.clickLogo();
        WebDriverWait waitVar = new WebDriverWait(driver,10);
        waitVar.until(ExpectedConditions.titleIs(title));
        Assert.assertEquals(driver.getTitle(),title);
    }

    //Select category to created new talent
    @Test(enabled = true,groups = {"newTalent"}, priority = 4)
    public void test_create_new_talent() throws Exception{
        //test_click_new_tab();
        objTalentsHome.clickCategory_selectOption();
    }

    //Enter firstName and lastName in Personal tab
    @Test(enabled = true,groups = {"newTalent"}, priority = 5)
    public void test_enter_firstName_lastName() throws Exception{
       objTalentsHome.enter_firstName_lastName();
        title = ExcelUtils.getCellData(2,1);
    }

    //Enter address and contact details in Personal tab
    @Test(enabled = true,groups = {"newTalent"}, priority = 6)
    public void test_enter_address_phone() throws Exception{
        objTalentsHome.enter_address_contact();
    }


    //Click quick test tab and finish button in new talent creation page
    @Test(enabled = true,groups = {"newTalent"}, priority = 7)
    public void test_click_quickTest() throws Exception{
        title = ExcelUtils.getCellData(2,1);
        objTalentsHome.click_QuickTest();
        WebDriverWait waitVar = new WebDriverWait(driver,10);
        waitVar.until(ExpectedConditions.titleIs(title));
        Assert.assertEquals(driver.getTitle(),title);
    }

    //To test that the new talent created reflects the entered data
    @Test(enabled = false,groups = {"newTalent"}, priority = 8)
    public void test_personalDetails_displayed() throws Exception {
        String name = ExcelUtils.getCellData(3,1)+" "+ExcelUtils.getCellData(3,2);
        String address = ExcelUtils.getCellData(4,1);;
        String email = ExcelUtils.getCellData(5,1);
       // String phone = ExcelUtils.getCellData(5,2).toString();
        String title = ExcelUtils.getCellData(2,1);

        String[] displayedInfo = objTalentsHome.retrieve_newTalent_data();

        WebDriverWait waitVar = new WebDriverWait(driver,10);
        waitVar.until(ExpectedConditions.titleIs(title));
        Assert.assertEquals(displayedInfo[0],name);
        Assert.assertEquals(displayedInfo[1],address);
        Assert.assertEquals(displayedInfo[2],email);
       // Assert.assertEquals(displayedInfo[3].toString(),phone);
    }

    //To test editing
    @Test(enabled = false, priority = 9)
    public void test_edit_talent_profile() throws Exception{
        objTalentsHome.click_edit_talent();
        title = ExcelUtils.getCellData(2,2);
        Assert.assertEquals(driver.getTitle(),title);
        driver.navigate().back();
    }

    //To search talent using search field in talent's home
    @Test(enabled = false, priority = 10)
    public void test_search_talent() throws Exception{
          List<WebElement> data = objTalentsHome.search_talent();
          String searchName = ExcelUtils.getCellData(7,1);
        for (WebElement element:data) {
            Boolean search = element.getAttribute("textContent").contains(searchName);
            System.out.println("name "+element.getAttribute("textContent"));
            Assert.assertEquals(search.toString(),"true");
        }
        driver.findElement(objTalentsHome.searchTalent).clear();
        driver.findElement(objTalentsHome.searchTalentBtn).click();
    }

    //To verify check box is selected
    @Test(enabled = false,priority = 11)
    public void test_select_talent(){
        WebElement checkBox=objTalentsHome.select_Talent();
        Boolean checked=checkBox.getAttribute("className").contains("ng-not-empty");
        Assert.assertEquals(checked.toString(),"true");
    }
    //To verify check box is unselected
    @Test(enabled = false,priority = 12)
    public void test_unselect_talent(){
        WebElement checkBox=objTalentsHome.select_Talent();
        Boolean checked=checkBox.getAttribute("className").contains("ng-not-empty");
        Assert.assertEquals(checked.toString(),"false");
    }
    //To verify multiple check box is selected
    @Test(enabled = false,priority = 13)
    public void test_select_multiple_talent(){
        List<WebElement> checkBox=objTalentsHome.select_Multiple_Talent();
        int i=0;
        for (WebElement element:checkBox) {
            Boolean checked=element.getAttribute("className").contains("ng-not-empty");
            i++;
            element.click();
        }
        Assert.assertEquals(checkBox.size(),i);

    }

    //To verify all talents are selected
    @Test(enabled = false,priority = 14)
    public void test_all_talents_selected(){
        List<WebElement> no_of_talents_available=objTalentsHome.select_All_Talent();
        int select_talent_count=0;
        for (WebElement element:no_of_talents_available) {
            Boolean checked=element.getAttribute("className").contains("select");
            System.out.println("check "+checked);
            if(checked) {
                select_talent_count++;
            }
        }
        Assert.assertEquals(no_of_talents_available.size(),select_talent_count);          //expected,actual
        driver.findElement(objTalentsHome.selectAllCheckBox).click();
    }

    //To verify all talents are active by default
    @Test(enabled = false, priority = 15)
    public void test_all_talents_are_active_byDefault() {
        int no_of_talents_available = objTalentsHome.no_Of_Talents();
        int no_of_active_talents = objTalentsHome.no_Of_Active_Talents();
        Assert.assertEquals(no_of_active_talents,no_of_talents_available);
    }
    //To verify talents can be disabled
    @Test(enabled = false,priority = 16)
    public void test_disabling_active_talent() {
        List<WebElement> disabledTalents = objTalentsHome.disable_Talent();
        for (WebElement element:disabledTalents) {
             Assert.assertEquals(element.getAttribute("title"),"INACTIVE");
        }
    }

    //To verify talents can be enabled
    @Test(enabled = false,priority = 17)
    public void test_enabling_inactive_talent() {
        List<WebElement> enabledTalents = objTalentsHome.enable_Talent();
        for (WebElement element:enabledTalents) {
            Assert.assertEquals(element.getAttribute("title"),"ACTIVE");
        }

    }

    //To verify talents can be archived
    @Test(enabled = false,priority = 18)
    public void test_archive_talent() {
        objTalentsHome.archive_Talent();
    }
}
