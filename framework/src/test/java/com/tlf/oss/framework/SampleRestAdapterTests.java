package com.tlf.oss.framework;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class SampleRestAdapterTests {

    @Test
    public void testExportEndpoint() {
        Map<String,String> requestParams = new HashMap<>();
        requestParams.put("requestParamA", "A");
        requestParams.put("requestParamB", "B");

       given().contentType("application/json")
                .body(requestParams)
                .when()
                .post("/api/v1/export")
                .then()
                .statusCode(200)
                .body(is("Neo4j data"));

    }

}
