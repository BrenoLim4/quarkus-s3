package edu.local;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class S3ResourceTest {

    @Test
    void uploadFile() {

    }

    @Test
    void downloadFile() {
        given()
                .disableCsrf()
                .when().get("/s3resource/download/gui.png")
                .then()
                .statusCode(is(200))
                .body("contentType", is("image/png"));
    }

    @Test
    void deleteFile() {
    }
}