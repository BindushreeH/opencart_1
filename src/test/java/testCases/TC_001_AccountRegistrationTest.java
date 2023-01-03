package testCases;


import pageObjects.AccountRegistrationPage;
import pageObjects.ConfirmPage;
import pageObjects.HomePage;
import testBase.BaseClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;


	public class TC_001_AccountRegistrationTest extends BaseClass {
		public static WebDriver driver;
		Logger logger;
		ResourceBundle rb;
	    @BeforeClass
	    public void setup(){
	    	 logger=LogManager.getLogger(this.getClass());
	         rb=ResourceBundle.getBundle("config");
	         WebDriverManager.chromedriver().setup();
	       driver=new ChromeDriver();
	       driver.manage().deleteAllCookies();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	       driver.get(rb.getString("url"));
	    }
	    @AfterClass
	   public void teardown() {
	    	driver.close();
	    }
	    public String captureScreen(String tname) throws IOException {

	        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

	        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
	        String destination =".//screenshots//" + tname + "_" + timeStamp + ".png";

	        try {
	            FileUtils.copyFile(source, new File(destination));
	        } catch (Exception e) {
	            e.getMessage();
	        }
	        return destination;
	    	
	}
	    @Test(groups={"Regression","Master"})
	    public void test_account_registration(){
		   logger.info("test started");
	   try {
		   logger.info("Home page started");
	        HomePage hp=new HomePage(driver);
	        hp.clkMyAccount();
	        hp.clkRegister();
	       logger.info("AccountRegistrationpage started");
	        AccountRegistrationPage ap=new AccountRegistrationPage(driver);
	        ap.setTxtFirstName(randomString().toUpperCase());//generating dynamically using randomString();
            ap.setTxtLastName(randomString().toUpperCase());
            ap.setTxtEmail(randomString()+"@gmail.com");//dynamic identical email id
            ap.setTxtTelepnone(randomNumber());
            String password=randomStringAndNumber();
            ap.setTxtPassword(password);
            ap.setTxtConfirmPassword(password);
            ap.clkChkInput();
            ap.clkBtnPrimary();
            logger.info("Confirmation page started");
            ConfirmPage cp = new ConfirmPage(driver);
            String confirmMsg = cp.getConfirmMsg();
            SoftAssert st = new SoftAssert();
            st.assertEquals(confirmMsg, "Your Account Has Been Created!");
            cp.clickBnt();
          
	   }
	   catch(Exception e) {
		   Assert.assertFalse(true);
	   }
		   logger.info("test ended");
	   }

            
	        
	  }


