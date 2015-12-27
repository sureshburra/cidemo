package test.java;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.TestCase;

public class CarPoolSteps extends TestCase{
	Ride ride;
	String button;
	@Given("^Employee enter all valid data$")
	public void Employee_enter_all_valid_data() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    //throw new PendingException();
		ride=new Ride();
		ride.setName("Suresh");
		ride.setEmail("suresh.burra@gmail.com");
	}

	@When("^Click on \"([^\"]*)\"$")
	public void Click_on(String arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    //throw new PendingException();
		button = arg1;
	}

	@Then("^System should Display a message \"([^\"]*)\"$")
	public void System_should_Display_a_message(String arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    //throw new PendingException();
		RideBLL rideBLL=new RideBLL();
		
		
		if(button.equals("Submit"))
		{
		assertEquals(arg1,rideBLL.Validate(ride));
		}
	}

}
