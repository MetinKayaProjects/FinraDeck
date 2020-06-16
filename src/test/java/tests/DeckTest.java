package tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeckTest  {

    @BeforeAll
    public static void setup() {

        RestAssured.baseURI = ConfigurationReader.get("ApiBaseURL");
    }

//    user story-1: Create a new deck of cards    (include two Jokers in the deck)
//    query parameter is jokers_enabled=true
//    user sends a GET request
//    user should be able to see the remaining cards are 54
//    user should be able to verify that response status code is 200
//    user should be able to verify that success in the body is true

    @Test
    public void creatDeck() {
        given()
                .queryParam("jokers_enabled","true")
                .when()
                .get("deck/new/")
                .prettyPeek()
                .then()
                .assertThat()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("remaining", equalTo(54)); //including 2 jokers in the deck

    }

//    user story-2: Draw one or more cards from a deck
//    query parameter is jokers_enabled
//    query parameter is count
//    user sends a GET request
//    user should be able to see the remaining cards are 50
//    user should be able to verify that response status code is 200
//    user should be able to verify that success in the body is true
    @Test
    public void drawDeck() {
        // Initially I create first call and get the deck_id and stored in a String
       JsonPath json =
                given()
                        .queryParam("jokers_enabled","true")
                        .when()
                        .get("deck/new/").jsonPath();
        String cardID = json.getString("deck_id");

        given()
                .queryParam("jokers_enabled","true")
                .queryParam("count", 4)  // draw 4 cards
                .pathParam("id",cardID)
                .when()
                .get("deck/{id}/draw/")
                .prettyPeek()
                .then()
                .assertThat()
                .statusCode(200)
                .body("success", equalTo(true))
                .body("remaining", equalTo(50));
    }
}
