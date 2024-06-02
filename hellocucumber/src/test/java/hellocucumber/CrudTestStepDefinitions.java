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

public class CrudTestStepDefinitions {

    private Response response;
    @Given("URI is set to {string}")
    public void uriIsSetToHttpsQautoForstudySpace(String s) {
        RestAssured.baseURI = "https://qauto2.forstudy.space";
    }

    @When("new user is created")
    public void newUserIsCreated() {
        Response response = given()
                .header("Content-Type", "application/json")
                .body(UserFactory.createUser())
                .log()
                .all()
                .when()
                .post("/api/auth/signup")
                .then()
                .log()
                .all()
                .statusCode(201)
                .extract()
                .response();

    }

    @Then("status code is {int}")
    public void statusCodeIs(int arg0) {
    }

    @And("session cookies stored")
    public void sessionCookiesStored() {
        Cookie sessionCookie = response.getDetailedCookie("sid");
    }

    @When("user profile is updated")
    public void userProfileIsUpdated() {
    }

    @When("user profile info is requested")
    public void userProfileInfoIsRequested() {
    }
}
