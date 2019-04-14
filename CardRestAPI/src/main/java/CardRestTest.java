import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.assesment.CardRestAPI.model.Card;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CardRestTest {

	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
	}

	@Test
	public void testGetAllCard() {
		given().when().get("CardRestAPI/rest/cards").then().assertThat()
				.body("cardNo", hasSize(3));
	}

	@Test
	public void testGetCard() {
		get("CardRestAPI/rest/cards/C01").then().body("cardNo", equalTo("C01"))
				.body("name", equalTo("Smith")).body("type", equalTo("Visa"));
	}

	@Test
	public void testCreateCard() throws JsonProcessingException {
		final String url = "CardRestAPI/rest/cards/create";
		Card newCard = new Card("C007", "James Bond", "Mastercard");
		ObjectMapper obj = new ObjectMapper();

		Response output = given().contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(obj.writeValueAsString(newCard))
				.when().post(url);
		output.then().body("cardNo", equalTo("C007"))
				.body("name", equalTo("James Bond"))
				.body("type", equalTo("Mastercard"));
	}

	@Test
	public void testUpdateCard() throws JsonProcessingException {
		final String url = "CardRestAPI/rest/cards/update/C02";
		Card newCard = new Card("C02", "James Terry", "Visa");
		ObjectMapper obj = new ObjectMapper();

		Response output = given().contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(obj.writeValueAsString(newCard))
				.when().put(url);
		output.then().body("cardNo", equalTo("C02"))
				.body("name", equalTo("James Terry"))
				.body("type", equalTo("Visa"));
	}

	@Test
	public void testDeleteCard() throws JsonProcessingException {
		final String url = "CardRestAPI/rest/cards/delete/{cardNo}";

		given().pathParam("cardNo", "C03").when().delete(url).then()
				.statusCode(204);

		// given().when().delete(url).then().header("Expires", equalTo(null));
	}
}
