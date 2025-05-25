package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
//import org.testng.annotations.Test;

public class APITesting012_PUT_NonBddStyle {


    public String getAuthToken() {
        String payload = "{ \"username\": \"admin\", \"password\": \"password123\" }";

        Response response = RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType(ContentType.JSON)
                .body(payload)
                .post("/auth");

        return response.jsonPath().getString("token");
    }


    @Test
    public void test_put_with_valid_token() {

        String token = getAuthToken();  // dynamically fetch a fresh token

        String bookingId = "3664";  // optional: dynamically create and get bookingId for safety

        String payload = "{\n" +
                "    \"firstname\" : \"Pramod\",\n" +
                "    \"lastname\" : \"Dutta\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        RestAssured.given()
                        .baseUri("https://restful-booker.herokuapp.com")
                        .basePath("/booking/" + bookingId)
                        .contentType(ContentType.JSON)
                        .header("Cookie", "token=" + token)
                        .body(payload)
                        .log().all()
                .when()
                        .put()
                .then()
                        .log().all()
                .statusCode(200);  // This should now pass
    }


}