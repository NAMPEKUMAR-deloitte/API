import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
        import org.hamcrest.object.HasEqualValues;
        import org.testng.annotations.Test;

        import java.io.File;

        import static io.restassured.RestAssured.*;
        import static io.restassured.matcher.RestAssuredMatchers.*;
        import static org.hamcrest.Matcher.*;
        import static org.hamcrest.Matchers.equalTo;
        import static org.hamcrest.Matchers.is;

public class RestAssured
{
    @Test
    public static void getCall()
    {
        
        given().
                baseUri("https://jsonplaceholder.typicode.com").
                when().
                get("/posts").
                then().
                statusCode(200);

        //check content type
        given().
                baseUri("https://jsonplaceholder.typicode.com").
                when().
                get("/posts").
                then().
                contentType("application/Json");

        //given().when().get("https://jsonplaceholder.typicode.com/posts").then().assertThat("[0].id", equalTo(1));


    }

    private static Object given() {
    }

    @Test
    public static void putCall()
    {
        File jsonData = new File("src//test//Putdata.json");

        given()
                .baseUri("https://reqres.in/api")
                .body(jsonData)
                .header("Content-Type","application/json")
                .when()
                .put("/users")
                .then()
                .statusCode(200)
                .body("name",equalTo("Arun"))
                .body("job",equalTo("Manager"));
    }

}
