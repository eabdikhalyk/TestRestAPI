import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestRestfulBooker {
    String url = "https://restful-booker.herokuapp.com/booking";
    @Test
    public void getAllBookings(){
        given().when().get(url).then().log().all();
    }
}
