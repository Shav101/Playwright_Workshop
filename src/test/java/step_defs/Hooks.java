package step_defs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.Pw;

public class Hooks {
	
	@Before
	
	
	
	@After
	public void wrapup(Scenario scenario) {
		
		if (scenario.isFailed()) {
			
			final byte[] screenshot =  Pw.getPage().screenshot();
			scenario.attach(screenshot, "image/png", "screenshot");
		}
		
		Pw.quitPW();
		
	}
	
	

}
