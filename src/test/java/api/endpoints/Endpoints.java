package api.endpoints;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;
import api.payloads.EndpointsPayloads;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Endpoints {
	
	
	public static ResourceBundle getUrl() {
		
		ResourceBundle resourceBundle = ResourceBundle.getBundle("routes");
		return resourceBundle;
	}
		
	public static Response createUser(EndpointsPayloads payload,String bearerToken) {
		
		String createUser = getUrl().getString("createUser");
		
		Response response= 	given()
			.body(payload)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.header("Authorization","Bearer "+bearerToken)
		.when()
			.post(createUser);
		return response;
	}
	
	public static Response getUser(int id,String bearerToken) {
		String getUser = getUrl().getString("getUser");
		
		Response response= 	given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.header("Authorization","Bearer "+bearerToken)
			.pathParam("id", id)
		.when()
			.get(getUser);
		return response;
	}
	
	public static Response updateUser(int id,EndpointsPayloads payload,String bearerToken) {
		
		String updateUser = getUrl().getString("updateUser");
		
		Response response= 	given()
			.body(payload)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("id", id)
			.header("Authorization","Bearer "+bearerToken)
		.when()
			.put(updateUser);
		return response;
	}
	
	public static Response deleteUser(int id,String bearerToken) {
		String deleteUser = getUrl().getString("deleteUser");
		
		Response response= 	given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("id", id)
			.header("Authorization","Bearer "+bearerToken)
		.when()
			.delete(deleteUser);
		return response;
	}



}











