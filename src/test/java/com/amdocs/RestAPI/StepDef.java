package com.amdocs.RestAPI;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT,classes=RestApiApplication.class)
public class StepDef {
	String url;
	double result;
@Given("Rest API {string}")
public void rest_API(String string) throws IOException {
    this.url=string;
  
    }

@When("invoking the given rest api")
public void invoking_the_given_rest_api() {
	 RestTemplate restTemplate=new RestTemplate();
	 result=restTemplate.getForObject(url,Double.class);
}

@Then("expecting result as {string}")
public void expecting_result_as(String string) {
		assertEquals(Double.parseDouble(string),result,0);
}


}
