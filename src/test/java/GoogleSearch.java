package test.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.TestCase;

public class GoogleSearch extends TestCase {
	private WebDriver driver;
	private String baseUrl;
	  
	@Given("^user enter \"([^\"]*)\" in firefox$")
	public void user_enter_in_firefox(String arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    //throw new PendingException();
		driver = new FirefoxDriver();
	    baseUrl = "https://www.google.co.in/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	}

	@Given("^enter \"([^\"]*)\" in search textbox$")
	public void enter_in_search_textbox(String arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    //throw new PendingException();
		driver.get(baseUrl + "/?gfe_rd=cr&ei=iAx9VomGH-vC8Ae-3LXgDw&gws_rd=ssl");
	    driver.findElement(By.id("lst-ib")).clear();
	    //arg1="India"; //hardcoding the value from the feature
	    driver.findElement(By.id("lst-ib")).sendKeys(arg1);
	}

	@When("^click on \"([^\"]*)\"$")
	public void click_on(String arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    //throw new PendingException();
		driver.findElement(By.name("btnG")).submit();
	}

	@Then("^system should return \"([^\"]*)\"$")
	public void system_should_return(String arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    //throw new PendingException();
		//System.out.println(arg1);
		String result=driver.findElement(By.id("resultStats")).getAttribute("textContent");
		System.out.println(result);
		String arrSplit[]=result.split(" ");
		result=arrSplit[1];
		String newval=result.replaceAll(",", "");
		System.out.println(newval);
		assertTrue(Long.valueOf(arg1)<Long.valueOf(newval));
		
	}



}
