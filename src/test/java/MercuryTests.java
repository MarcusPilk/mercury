import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class MercuryTests {

    WebDriver driver = null;
    static ExtentReports reports;
    ExtentTest test;

    @BeforeClass
    static public void setUpReports(){
        reports = new ExtentReports(Constants.REPORT_PATH,true);
    }
    @AfterClass
    public static void tearDownReports(){
        reports.flush();
    }

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",Constants.DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //test = reports.startTest("Test");

    }

    @After
    public void tearDown(){
        //reports.endTest(test);
        driver.quit();
    }

    @Test
    public void testLogIn() throws IOException {

        FileInputStream file = new FileInputStream(Constants.EXCEL_PATH); //read from spreadsheet
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        HelperMethods.setExcelFile(Constants.EXCEL_PATH,0);

        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) { //iterates through input data on spreadsheet
            test = reports.startTest("Test run:" + i);

            String username = sheet.getRow(i).getCell(0).getStringCellValue();
            String password = sheet.getRow(i).getCell(1).getStringCellValue();


            driver.get(Constants.HOME_URL);
            test.log(LogStatus.INFO, "Home page loaded");

            HomePage home = PageFactory.initElements(driver,HomePage.class);
            home.registerButton();
            test.log(LogStatus.INFO, "Register page clicked");

            RegisterPage register = PageFactory.initElements(driver,RegisterPage.class);
            register.enterDetails(username,password,password);
            test.log(LogStatus.INFO,"Account created");

            CreateAccountSuccessPage success = PageFactory.initElements(driver,CreateAccountSuccessPage.class);
            success.signIn();
            test.log(LogStatus.INFO,"Sign in button clicked");

            SignInPage signIn = PageFactory.initElements(driver,SignInPage.class);
            signIn.logIn(username,password);
            test.log(LogStatus.INFO,"Submit button clicked and returned to home");

            if(home.checkSignedIn()){
                test.log(LogStatus.PASS,"User has signed in successfully");
                HelperMethods.setCellData("Pass",i,2);

            }else{
                test.log(LogStatus.FAIL, "User has not signed in successfully");
                HelperMethods.setCellData("Fail",i,2);

            }

            assertTrue(home.checkSignedIn());

            reports.endTest(test);

        }
    }


}
