import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTalentsHome extends TestSignIn{
    TalentsHomePage objTalentsHome;
    String title;

    //click new tab in talents page
    @Test(priority = 2 )
    public void test_click_new_tab() throws Exception{
        objTalentsHome = new TalentsHomePage(driver);
        objTalentsHome.clickNew();
        title = ExcelUtils.getCellData(2,2);
        Assert.assertEquals(driver.getTitle(),title);

    }
    //click logo in the talents page
    @Test(priority = 3)
    public void test_navigation_by_clicking_logo() throws Exception{
        title = ExcelUtils.getCellData(2,1);
        objTalentsHome.clickLogo();
        WebDriverWait waitVar = new WebDriverWait(driver,10);
        waitVar.until(ExpectedConditions.titleIs(title));
        Assert.assertEquals(driver.getTitle(),title);
    }

    //Select category to created new talent
    @Test(priority = 4)
    public void test_create_new_talent() throws Exception{
        test_click_new_tab();
        objTalentsHome.clickCategory_selectOption();
    }

    //Enter firstName and lastName in Personal tab
    @Test(priority = 5)
    public void test_enter_firstName_lastName() throws Exception{
       objTalentsHome.enter_firstName_lastName();
    }

    //Enter address and contact details in Personal tab
    @Test(priority = 6)
    public void test_enter_address_phone() throws Exception{
        objTalentsHome.enter_address_contact();
    }


    //Click quick test tab and finish button in new talent creation page
    @Test(priority = 7)
    public void test_click_quickTest() throws Exception{
        title = ExcelUtils.getCellData(2,1);
        objTalentsHome.click_QuickTest();
        WebDriverWait waitVar = new WebDriverWait(driver,10);
        waitVar.until(ExpectedConditions.titleIs(title));
        Assert.assertEquals(driver.getTitle(),title);
    }

    //To test that the new talent created reflects the entered data
    @Test(priority = 8)
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
    @Test(priority = 9)
    public void test_edit_talent_profile() throws Exception{
        objTalentsHome.click_edit_talent();
        title = ExcelUtils.getCellData(2,2);
        Assert.assertEquals(driver.getTitle(),title);
        driver.navigate().back();
    }

    //To search talent using search field in talent's home
    @Test(priority = 10)
    public void test_search_talent() throws Exception{
          objTalentsHome.search_talent();
    }

    //To verify check box is selected
    @Test(priority = 11)
    public void test_select_talent(){
        objTalentsHome.select_Talent();
    }

}
