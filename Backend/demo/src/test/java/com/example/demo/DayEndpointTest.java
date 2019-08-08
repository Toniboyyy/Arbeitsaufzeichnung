package com.example.demo;

import com.example.demo.DTO.dayDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DayEndpointTest extends ArbeitsaufzeichnungApplicationTests {

    private final String DAY_ENDPOINT = "/day";

    @Before
    public void set_up() {
    }

    public void findAllMessageUnauthorizedAsAnonymous() {
        Response response =  RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().post(DAY_ENDPOINT)
                .then().extract().response();
    }
}
