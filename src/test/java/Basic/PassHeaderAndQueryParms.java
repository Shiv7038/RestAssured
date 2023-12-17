package Basic;

import io.restassured.RestAssured;
import org.junit.Test;
import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class PassHeaderAndQueryParms {
    String token = "Bearer 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";

    @Test
    public void passHeader() {
        RestAssured.baseURI = "https://api.github.com/";
//Pass single headers
        given().header("Authorization", token)
                .when().get("/repos/Shiv7038/ATT").then().log().all();

        //to pass multiple headers
        given().headers("Authorization", token, "Accept", "application/vnd.github+json")
                .when().get("/repos/Shiv7038/ATT").then().log().all();

        //multiple headers using hashMap
        HashMap<String, Object>header=new HashMap<>();
        header.put("Authorization",token);
        header.put("Accept","application/vnd.github+json");

        given().headers(header)
                .when().get("/repos/Shiv7038/ATT").then().log().all();
    }

    @Test
    public void passQueryParams() {
        RestAssured.baseURI = "https://api.github.com/";
//Pass single query Param
        given().queryParam("name","ATT").header("Authorization", token)
                .when().get("/repos/Shiv7038/ATT").then().log().all();

        //to pass multiple query param
        given().queryParams("name","ATT", "fullName","Shiv7038/ATT").headers("Authorization", token)
                .when().get("/repos/Shiv7038/ATT").then().log().all();

        //multiple query using hashMap
        HashMap<String, Object>query=new HashMap<>();
        query.put("name","ATT");
        query.put("fullName","Shiv7038/ATT");

        given().queryParams(query).header("Authorization", token)
                .when().get("/repos/Shiv7038/ATT").then().log().all();
    }


    @Test
    public void passPathParams() {
        RestAssured.baseURI = "https://api.github.com/";

        given().pathParam("path","ATT").header("Authorization", token)
                .when().get("/repos/Shiv7038/{path}").then().log().all();
    }

}
