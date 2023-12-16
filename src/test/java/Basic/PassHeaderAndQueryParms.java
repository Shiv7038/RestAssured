package Basic;

import io.restassured.RestAssured;
import org.junit.Test;

import java.util.HashMap;
import java.util.Objects;

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


}
