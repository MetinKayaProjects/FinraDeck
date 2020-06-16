package utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiUtils {

//    private static Response response;
//
//    public static void setResponse(Response res) {
//        response = res;
//    }
//
//    public static Response getResponse() {
//        return response;
//    }
//
//    public static String generateToken() {
//        Response response = given().queryParams("email", ConfigurationReader.get("finra.email"),
//                "password", ConfigurationReader.get("finra.password"))
//                .when().get(ConfigurationReader.get("finra.baseuri") + "/sign");
//        // String token = response.body().jsonPath().getString("accessToken");
//        JsonPath jsonPath = response.body().jsonPath();
//        String token = jsonPath.getString("accessToken");
//        return token;
//}


    }
