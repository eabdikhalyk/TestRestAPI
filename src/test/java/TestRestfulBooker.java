import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import static io.restassured.RestAssured.given;

public class TestRestfulBooker {
    String url = "https://restful-booker.herokuapp.com";
    String contentType = "Content-type";
    String appJson = "application/json";
    String requestBody = "{ " +
    " \"username\" : \"admin\" ,"
          + "  \"password\" : \"password123\"}";
    @BeforeTest
    public void setup(){
        RestAssured.baseURI = url;
    }
    @Test
    public void getAllBookings(){
        Response response = given().
                when().
                get(url).
                then().
                extract().
                response();
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test
    public void createToken(){
        Response response = given().
                header(contentType, appJson).
                and().
                body(requestBody).
                when().
                post("/auth").
                then().
                extract().
                response();

        Assert.assertEquals(response.statusCode(),200);

    }
}
