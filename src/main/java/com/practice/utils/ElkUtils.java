package com.practice.utils;

import com.practice.enums.ConfigProperties;
import io.restassured.response.Response;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;

public final class ElkUtils {

    private ElkUtils(){}

    public static void sendResultsToElk(String testName,String testStatus) {

        if (PropertyUtil.getValue(ConfigProperties.SENDRESULTTOELK).equalsIgnoreCase("yes")) {
            Map<String, String> map = new HashMap<>();
            map.put("testName", testName);
            map.put("status", testStatus);
            map.put("executionTime", LocalDateTime.now().toString());

            Response response = given()
                    .header("Content-Type", "application/json")
                    .log()
                    .all()
                    .body(map)
                    .post(PropertyUtil.getValue(ConfigProperties.ELASTICSEARCHURL));

            response.prettyPrint();

        }
    }
}
