package hellocucumber;

import entityfactory.UserFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CrudTestStepDefinitions {

    private Cookie sessionCookie;
    private Response loginResponse;
    @Given("URI is set to {string}")
    public void uriIsSetToHttpsQautoForstudySpace(String s) {
        RestAssured.baseURI = "https://qauto2.forstudy.space";
    }

    @When("new user is created")
    public void newUserIsCreated() {
         loginResponse = given()
                .header("Content-Type", "application/json")
                .body(UserFactory.createUser())
                .post("/api/auth/signup")
                .then()
                .extract()
                .response();
    }

    @Then("status code is {int}")
    public void statusCodeIs(int statusCode) {
        assertEquals(statusCode, loginResponse.statusCode());
    }

    @And("session cookies stored")
    public void sessionCookiesStored() {
        sessionCookie = loginResponse.getDetailedCookie("sid");
    }

    @When("user profile is updated")
    public void userProfileIsUpdated() {
        given()
                .header("Content-Type", "application/json")
                .body(UserFactory.updateUserProfile())
                .cookie(sessionCookie)
                .when()
                .put("/api/users/profile");
    }

    @When("user profile info is requested")
    public void userProfileInfoIsRequested() {
        given()
                .cookie(sessionCookie)
                .when()
                .get("/api/users/profile");

    }
}
