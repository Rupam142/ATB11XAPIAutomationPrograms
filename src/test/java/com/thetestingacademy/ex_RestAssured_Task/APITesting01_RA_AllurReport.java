package com.thetestingacademy.ex_RestAssured_Task;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting01_RA_AllurReport {

    RequestSpecification rs;
    Response res;
    ValidatableResponse vr;


    // TC#1 - Verify that the Create token
    @Owner("Rupam")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC#1 - Verify that the Create token")
    @Test(priority = 1)
    public void test_Post_token() {
        String token_payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/auth");
        rs.contentType(ContentType.JSON);
        rs.body(token_payload).log().all();

        res = rs.when().log().all().post();

        vr = res.then().log().all();
        vr.statusCode(200);
    }


    // TC#2 - Verify that the Create Booking
    @Owner("Rupam")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#2 - Verify that the Create Booking")
    @Test
    public void test_post_create_booking() {
        String create_booking_payload = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking");
        rs.contentType(ContentType.JSON);
        rs.body(create_booking_payload).log().all();

        res = rs.when().log().all().post();

        vr = res.then().log().all();
        vr.statusCode(200);
    }


    // TC#3 - Verify Get Booking with bookingid
    @Owner("Rupam")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#3 - Verify Get Booking with bookingid")
    @Test(priority = 3)
    public void test_get_booking(){
        String bookingid = "2573";
        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/"+bookingid);
//        rs.contentType(ContentType.JSON).log().all();

        res = rs.when().log().all().get();

        System.out.println(res.asString());

        vr = res.then().log().all();
        vr.statusCode(200);
    }


    // TC#4 - Verify Update booking
    @Owner("Rupam")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#4 - Verify Update booking")
    @Test(priority = 4)
    public void test_update_booking_put() {
        String token = "39082def6a285b8";
        String bookingid = "598";

        String payloadPUT = "{\n" +
                "    \"firstname\" : \"Rohit\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";

        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking/" + bookingid);
        rs.contentType(ContentType.JSON);
//        r.auth().oaut
        rs.cookie("token", token);
        rs.body(payloadPUT).log().all();

        res = rs.when().log().all().put();
        vr = res.then().log().all();

        vr.statusCode(200);

    }


    @Owner("Rupam")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#1 - Verify Partial update")
    @Test(priority = 5)
    public void test_partial_updated_patch() {
        String token = "f5be7bdc5c6055f";
        String bookingid = "4606";

        String payloadPatch = "{\n" +
                "    \"firstname\" : \"Sunny\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";


        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("/booking/" + bookingid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token", token);
        rs.body(payloadPatch).log().all();

        res = rs.when().log().all().patch();

        vr = res.then().log().all();
        vr.statusCode(200);


    }


    @Owner("Rupam")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#1 - Verify delete booking")
    @Test(priority = 6)
    public void test_delete() {

        String token = "f5be7bdc5c6055f";
        String bookingid = "4606";


        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("/booking/" + bookingid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token", token);


        res = rs.when().log().all().delete();

        vr = res.then().log().all();
        vr.statusCode(201);


    }




}


