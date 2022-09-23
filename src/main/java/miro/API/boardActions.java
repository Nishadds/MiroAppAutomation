package miro.API;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class boardActions {
    public String bearerToken="eyJtaXJvLm9yaWdpbiI6ImV1MDEifQ_ZZAMlTP-daKrntBWxBv6uVfLPws";
    String boardid;
    String boardname;
    public String createBoard() throws IOException {
    RestAssured.baseURI="https://api.miro.com";
    Response resp = given().
            header("Authorization", "Bearer " + bearerToken).header("Content-Type", "application/json").
            body(GenerateStringFromResource("src/main/java/miro/API/Payloads/createboard.json")).
            when().log().all().
            post("/v2/boards").
            then().assertThat().statusCode(201).
            extract().response();

    boardid = resp.jsonPath().getString("id");
    boardname = resp.jsonPath().getString("name");
    return boardname;
    }

    public String GenerateStringFromResource(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    public void createWidgetData() throws IOException {
        RestAssured.baseURI="https://api.miro.com";

//        https://api.miro.com/v2/boards/uXjVPUMQBko%3D/shapes
        Response resp = given().
                header("Authorization", "Bearer " + bearerToken).header("Content-Type", "application/json").
                body(GenerateStringFromResource("src/main/java/miro/API/Payloads/createwidget.json")).
                when().log().all().
                post("/v2/boards/"+boardid+"/shapes").
                then().assertThat().statusCode(201).
                extract().response();
    }

    public void shareBoard() throws IOException {
        RestAssured.baseURI="https://api.miro.com";

//        https://api.miro.com/v2/boards/uXjVPUMQBko%3D/shapes
        Response resp = given().
                header("Authorization", "Bearer " + bearerToken).header("Content-Type", "application/json").
                body(GenerateStringFromResource("src/main/java/miro/API/Payloads/shareboard.json")).
                when().log().all().
                post("/v2/boards/"+boardid+"/members").
                then().assertThat().statusCode(201).
                extract().response();
    }

    public void deleteBoard() throws IOException {
        RestAssured.baseURI="https://api.miro.com";

//        https://api.miro.com/v2/boards/uXjVPUMQBko%3D/shapes
        Response resp = given().
                header("Authorization", "Bearer " + bearerToken).header("Content-Type", "application/json").
                body(GenerateStringFromResource("src/main/java/miro/API/Payloads/shareboard.json")).
                when().log().all().
                delete("/v2/boards/"+boardid).
                then().assertThat().statusCode(204).
                extract().response();
    }



}
