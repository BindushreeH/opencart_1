package testBase;


	import org.apache.commons.lang3.RandomStringUtils;
	import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.testng.annotations.*;
    import io.github.bonigarcia.wdm.WebDriverManager;
    import java.time.Duration;

	public class BaseClass {
		  /* public WebDriver driver;
		    @BeforeClass
		    void setup(){
		    WebDriverManager.chromedriver().setup();
		       driver=new ChromeDriver();
		       driver.manage().deleteAllCookies();
		       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		       driver.get("https://demo.opencart.com/index.php");
		    }*/
		    @AfterClass
		    public void teardown(){
		    //    driver.close();
		    }
		    public String randomString() {
		    	String genarated_str=RandomStringUtils.randomAlphabetic(10);
		    	return genarated_str;
		    	
		    }
		    public String randomNumber() {
		    	String genarated_num=RandomStringUtils.randomAlphabetic(10);
		    	return genarated_num;
		    }
		    public String randomStringAndNumber() {
		    	String gen_str=RandomStringUtils.randomAlphabetic(10);
		    	String gen_num=RandomStringUtils.randomAlphabetic(10);
		    	return gen_str+"@"+gen_num;
		    }
		    	
		    }



