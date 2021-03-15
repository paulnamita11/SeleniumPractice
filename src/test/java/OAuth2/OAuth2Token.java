package OAuth2;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class OAuth2Token {
	static Properties prop = new Properties();
	@Test
	public void TC_02() {

		InputStream input;
		try {
			input = new FileInputStream("/Users/namita_pm_pursuitsof/eclipse-workspace/DemoSampleProject/src/test/java/OAuth2/credentials.properties");
		
		prop.load(input);
		System.out.println("==========GRANT" + prop.getProperty("grant_type"));
		Response resp = given().formParam("client_id", prop.getProperty("client_id"))
				.formParam("client_secret", prop.getProperty("client_secret"))
				.formParam("grant_type", prop.getProperty("grant_type"))
				.formParam("access_token", prop.getProperty("access_token"))
				.formParam("header_prefix", prop.getProperty("header_prefix"))
				.formParam("client_authentication", prop.getProperty("client_authentication"))
				.formParam("scope", prop.getProperty("scope"))
				.post(prop.getProperty("token_url"));

		System.out.println("Response Code ===========" + resp.getStatusCode());
		System.out.println("Code " + resp.jsonPath().prettify());

		String Token = resp.jsonPath().get("token_type") + " " + resp.jsonPath().get("access_token").toString();
		System.out.println("==========" + Token);

		String payload = "{\r\n \"inquiries\": [\r\n\t{\r\n        \"correlationId\": \"a1p1Q000005DVbUAL01\",\t\r\n\t    \"accountNumber\": \"014200912611726117\",\r\n\t\t\"productType\": \"L\",\r\n\t\t\"applySecDepositIndicator\": null,\r\n\t\t\"clientNumber\": \"001\",\r\n\t\t\"contractOblTaxIndicator\": null,\r\n\t\t\"effectiveDate\": \"2021-01-25\",\r\n\t\t\"estPropTaxIndicator\": null,\r\n\t\t\"luxuryTaxIndicator\": null,\r\n\t\t\"payoffConcessionAmt\": -150.34,\r\n\t\t\"payoffType\": \"Customer\",\r\n\t\t\"termChargeTaxIndicator\": null,\r\n\t\t\"dealer\": {\r\n\t\t\"name\": \"Drake Toyota\",\r\n\t\t\"partyName\": \"John Drake\",\r\n\t\t\"phone\": \"9042304857\"\r\n\t\t}\r\n\t}\r\n],\r\n\"meta\": {\r\n     \"correlationId\":  \"a1p1Q000005DmETM02\",\r\n     \"requestedUserId\": \"TMNA\",\r\n     \"requestingSystem\": \"SmartPath\",\r\n     \"requestTs\": \"2020-06-03T21:16:54.683Z\"\r\n  }\r\n}";

		Response resp1 = 
				// given().auth().oauth2(Token).baseUri("https://setf.uat.api.jmfamily.com/").and().basePath("saih-payoff-exp/v1/api/accounts/quote").when().get().thenReturn();

				given()
						// .header("User-Agent", "PostmanRuntime/7.26.10")
						.header("Content-Type", prop.getProperty("Content-Type")).body(payload)
						.accept(ContentType.JSON)
						.auth().oauth2(Token)
						.post(prop.getProperty("API_URL"));
						//.then()
			            //.statusCode(200)
						//.log().all()
			            //.extract()
			            //.response();

		// System.out.println("BODY============ "+resp1.getBody().asString());
		System.out.println("RESP1============ " + resp1.jsonPath().prettify());
		System.out.println("Status Code============ " + resp1.getStatusCode());
		// Assert.assertEquals(resp1.getStatusCode(), 200);
		
		} catch (Exception exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
		}

	}
	
	
}
