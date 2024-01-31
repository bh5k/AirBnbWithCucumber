package stepdefinitions;

import com.airbnb.model.Room;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.web.client.RestClient;

public class RoomRestIntegrationStepdefs {

    RestClient restClient;
    String uriBase;
    Room room;

    @Given("I have a Rest Spring Endpoint")
    public void iHaveARestSpringEndpoint() {
        uriBase = "http://localhost:8080";
        restClient = RestClient.create();
    }

    @When("I call the room endpoint by name for rooms")
    public void iCallTheRoomEndpointByNameForRooms() {
        room = restClient.get()
                .uri(uriBase+ "/room?name=Cliffhanger")
                .retrieve()
                .body(Room.class);
    }

    @Then("Cliffhanger is the result from the server")
    public void cliffhangerIsTheResultFromTheServer() {
        Assertions.assertEquals("Cliffhanger", room.getName());
    }
}
