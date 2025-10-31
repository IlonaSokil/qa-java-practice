package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.*;

@Epic("API Tests")
@Feature("PetStore API")
@Story("Get pet by ID")
@Severity(SeverityLevel.CRITICAL)

public class ApiTests {

    @Test
    public void getPetTest() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        Response response = RestAssured
                .given()
                .when()
                .get("/pet/98765")
                .then()
                .extract()
                .response();

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void createPetTest() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        PetProduct petProduct = new PetProduct();
        petProduct.id = 23456;
        petProduct.name = "Fenixcat";
        petProduct.status = "available";

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(petProduct)
                .when()
                .post("/pet")
                .then()
                .extract()
                .response();

        Assert.assertEquals(response.getStatusCode(), 200);

        PetProduct responsePet = response.as(PetProduct.class);
        Assert.assertEquals(responsePet.name, petProduct.name);
    }
} // update for PR