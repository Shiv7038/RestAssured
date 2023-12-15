package Basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class BasicMetohds {

	
	@Test(enabled = false)
	public void getAPIMethod() {

		RestAssured.baseURI="https://reqres.in/";

		given().relaxedHTTPSValidation().when().get("api/users?page=2").then().log().all();

		Response resonse=given().log().all().when().get("users?page=2").then().extract().response();
        // to get the response in Response format

//		JsonPath js=resonse.jsonPath();
//		String a=js.getString("data.id");
//		System.out.println(a);
//
		String stringResonse=given().log().all().when().get("users?page=2").then().extract()
                .response().asPrettyString();
           // to get response in String format

       String stringResonse1=given().queryParam("page",2).when().get("api/users").then().extract()
                 .response().asPrettyString();
            // to get response in PrittyString format
        System.out.println(stringResonse1);

	}

	@Test
	public void postAPIMethod() {

		RestAssured.baseURI="https://reqres.in/";

		given().body("{\n" +
				"    \"name\": \"morpheus\",\n" +
				"    \"job\": \"leader\"\n" +
				"}").when().post("api/users").then().log().all();
	}

	@Test
	public void putAPIMethod() {

		RestAssured.baseURI="https://reqres.in/";

		given().body("{\n" +
				"    \"name\": \"morpheus\",\n" +
				"    \"job\": \"zion resident\"\n" +
				"}").when().put("api/users/2").then().log().all();
	}

	@Test
	public void deleteAPIMethod() {

		RestAssured.baseURI="https://reqres.in/";

		given().body("{\n" +
				"    \"name\": \"morpheus\",\n" +
				"    \"job\": \"zion resident\"\n" +
				"}").when().delete("api/users/2").then().log().all();
	}
}
