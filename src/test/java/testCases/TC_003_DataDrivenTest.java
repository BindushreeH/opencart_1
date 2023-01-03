package testCases;

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

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC_003_DataDrivenTest {
	  public static WebDriver driver;
	  public ResourceBundle rb;
	  public Logger logger;

	    @BeforeClass
	    @Parameters({"browser"})
	    void setup(String br) {
	        rb = ResourceBundle.getBundle("config");
	        logger = LogManager.getLogger(this.getClass());
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
	   public void tearDown() {
	    	driver.close();
	    	
	    }

	    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups= {"DataDriven","Master"})
	    void testDataDriven(String email, String paswrd, String exp) {
	        logger.info("test started");
	        try {
	            
	        	logger.info("Home page started");
	            HomePage hp = new HomePage(driver);
	            hp.clkMyAccount();
	            hp.clkLogin();
	            
	            logger.info("login page started");
	            LoginPage lp = new LoginPage(driver);
	            lp.setTxtEmail(email);
	            lp.setTxtPassword(paswrd);
	            lp.setBtnLogin();
	            
	            logger.info("login page ended");
	            logger.info("MyAccount page stared");
	            MyAccountPage mp = new MyAccountPage(driver);
	            boolean targetPage = mp.isPageHeaderDisplay();
	            
	            logger.info("Data Driven test started");
	            if (exp.equals("Valid")) {
	                if (targetPage == true) {
	                     mp.clkLogout();
	                    System.out.println("click logout");
	                    logger.info("logout clicked");
	                    Assert.assertTrue(true);
	                } else {
	                    Assert.assertTrue(false);
	                }
	            }
	            if (exp.equals("Invalid")) {
	                if (targetPage == false) {
	                    Assert.assertTrue(true);
	                } else {
	                     mp.clkLogout();
	                    System.out.println("click logout");
	                    logger.info("logout clicked");
	                    Assert.assertTrue(false);
	                }
	            }
	            logger.info("DataDriven test Ended");

	        } catch (Exception e) {
	            Assert.fail();
	        }

	        logger.info("test ended");
	    }
	        
	    }
	

