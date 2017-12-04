/*
import org.testng.annotations.DataProvider;

public class PromytheusData {
    @DataProvider(name = "LogInCredentials")
    public static Object[][] userData() {
        // ExcelUtils.getTableArray("C://1//dataTable.xlsx","Sheet1");
        return new Object[][] {
                { "creative@mailinator.com", "testpassword", "ProMytheUs - Talents" }
        };
    }
}
*/



   /* @Test(priority = 0)
    public void test_to_type_in_username_password()throws InterruptedException{

        //retrieving data from object array in promytheus data class
        data = new PromytheusData();
        credentials=data.userData();

        //retrieving username and password from object array
        String userName = credentials[0][0].toString();
        String password = credentials[0][1].toString();

        //send email address to the email field
        objSignIn.setUserName(userName);

        //send password to the password field
        objSignIn.setPassword(password);

        //Test to check user can type in the username and password field
       Assert.assertEquals(objSignIn.getuserName().getAttribute("value"),userName);
       Assert.assertEquals(objSignIn.getPassword().getAttribute("value"),password);
    }*/

