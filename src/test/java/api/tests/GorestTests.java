package api.tests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Endpoints;
import api.payloads.EndpointsPayloads;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class GorestTests {

	 ArrayList<Integer> createdId = new ArrayList<>();
	String bearerToken = "5486269cf3dabd5d01fd4baedaafa291572b993fd0cd71eb27a1bf3aaaf60161";
	
	
	@Test(priority=1,dataProvider = "ExcelData",dataProviderClass = DataProviders.class)
	public void createUser(String data[]) {
		Faker faker = new Faker();
		EndpointsPayloads payload = new EndpointsPayloads();
		payload.setName(data[0]);
		payload.setGender(data[1]);
		payload.setEmail(data[2]);
		payload.setStatus(data[3]);		
		Response createUserResponse = Endpoints.createUser(payload, bearerToken);
		int userId = createUserResponse.then().extract().path("id");
		createdId.add(userId);		
		createUserResponse.then().log().body();
		Assert.assertEquals(createUserResponse.getStatusCode(), 201);
	}
	
	@Test(priority = 2 )
	public void deleteUser() {
		
		for (Integer userId : createdId) {
			System.out.println("Deleting user with ID: " + userId);
            Response deleteUserResponse = Endpoints.deleteUser(userId, bearerToken);
            deleteUserResponse.then().log().status();
        }
		
	}

}







