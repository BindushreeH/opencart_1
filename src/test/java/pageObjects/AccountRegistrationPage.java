package pageObjects;


	import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
     public class AccountRegistrationPage extends BasePage {
	 public AccountRegistrationPage(WebDriver driver) {
	        super(driver);
	    }

	    @FindBy(xpath = "//input[@id='input-firstname']")
	    WebElement txtFirstName;
	    
	    @FindBy(xpath = "//input[@id='input-lastname']")
	    WebElement txtLastName;
	 
	    @FindBy(xpath="//input[@id='input-email']")
	    WebElement txtEmail;
	    @FindBy(xpath = "//input[@name='telephone']")
	    WebElement txtTelepnone;
	  
	    @FindBy(xpath="//input[@id='input-password']")
	    WebElement txtPassword;
	    
	    @FindBy(xpath="//input[@name='confirm']")
	    WebElement txtConfirmPassword;
	   
	    @FindBy(xpath = "//input[@name='agree']")
	    WebElement chkInput;
	   
	    @FindBy(xpath = "//input[@value='Continue']")
	    WebElement btnPrimary;
	    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	    WebElement msgConfirmation;

	    public void setTxtFirstName(String firstName) {
	        txtFirstName.sendKeys(firstName);
	    }

	    public void setTxtLastName(String lastName) {
	        txtLastName.sendKeys(lastName);
	    }

	    public void setTxtEmail(String email) {
	        txtEmail.sendKeys(email);
	    }
	    
	    public void setTxtTelepnone(String telepnone){
	        txtTelepnone.sendKeys(telepnone);
	    }

	    public void setTxtPassword(String password) {
	        txtPassword.sendKeys(password);
	    }
	    public void setTxtConfirmPassword(String confirmPassword){
	        txtConfirmPassword.sendKeys(confirmPassword);
	    }
	    

	    public void clkChkInput() {
	        chkInput.click();
	    }

	    public void clkBtnPrimary() {
	        btnPrimary.click();//solution 1(interview question)
	        // btnPrimary.submit();                  ( solution 2)
	       /* Actions act=new Actions(driver);      ( solution 3 mouseover command)
	        act.moveToElement(btnPrimary).click().perform();*/
	      /*  JavascriptExecutor js=(JavascriptExecutor) driver;  (solution 4)
	        js.executeScript("arguments[0].click();",btnPrimary)*/
	        //btnPrimary.sendKeys(Keys.RETURN);SOLUTION 5 keyboard command
	        // btnPrimary.sendKeys(Keys.ENTER);SOLUTION 6
	      /*  WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(10));
	        wt.until(ExpectedConditions.elementToBeClickable(btnPrimary)).click();//or submit*/ //(solution 7)
	    }
	    
	   

     }

