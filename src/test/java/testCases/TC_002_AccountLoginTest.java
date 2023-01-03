package testCases;

import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_002_AccountLoginTest {

    public WebDriver driver;
    public Logger logger;
    public ResourceBundle rb;

    @BeforeClass
    @Parameters({"browser"})
    void setup(String br) {

        logger=LogManager.getLogger(this.getClass());
        rb=ResourceBundle.getBundle("config");

        WebDriverManager.chromedriver().setup();
        if (br.equals("chrome")) {
            driver = new ChromeDriver();
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(rb.getString("url"));

    }
    @AfterClass
    void tearDown(){
        driver.close();
    }
    @Test(groups= {"Sanity","Master"})
    void testAccountLogin(){
        try {
            logger.info("test started");
            HomePage hp = new HomePage(driver);
            hp.clkMyAccount();
            hp.clkLogin();
            //login page
             LoginPage lp = new LoginPage(driver);
            lp.setTxtEmail(rb.getString("email"));
            lp.setTxtPassword(rb.getString("password"));
            lp.setBtnLogin();
            //Thread.sleep(7000);
           // WebElement b = driver.findElement(By.xpath("//button[text()='Login']"));
           // b.click();
           // Thread.sleep(7000);
            logger.info("login completed");
            //check target page
            MyAccountPage mp = new MyAccountPage(driver);
            logger.info("myAccount started"); 
            boolean targetPage = mp.isPageHeaderDisplay();
            logger.info("target displayed");
            Assert.assertEquals(targetPage, true);
            logger.info("true");
           // logger.info("test finished");
        }
        catch (Exception e){
            Assert.fail();
        }
        logger.info("test finished");
    }
}

