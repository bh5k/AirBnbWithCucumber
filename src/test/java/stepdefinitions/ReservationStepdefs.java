package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.airbnb.model.Rental;
import com.airbnb.model.Room;
import com.airbnb.model.SeasonType;
import com.airbnb.model.User;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

public class ReservationStepdefs {

    private List<Map<String, String>> roomRates;

    private List<Map<String, String>> registeredUsers;

    Rental rental;

    @Given("the following rooms are available to rent")
    public void theFollowingRoomsAreAvailableToRent(DataTable roomTable) {
        this.roomRates = roomTable.asMaps(String.class, String.class);
    }


    @When("{string} books a {string} in {string} for {int}")
    public void iBookARoomInSeasonForDays(String username, String roomName, String seasonStr, int days) {
        User user = findUser(username);
        Room room = findRoom(roomName);
        SeasonType season = SeasonType.valueOf(seasonStr);
        rental = new Rental();
        rental.setUser(user);
        rental.setRoom(room);
        rental.setSeasonType(season);
        rental.setDays(days);
    }

    private User findUser(String username) {
        System.out.println(registeredUsers.get(0).get("Name"));
        for (Map<String, String> user : registeredUsers) {
            if (user.get("Name").equals(username)) {
                User registeredUser = new User();
                registeredUser.setName(username);
                return registeredUser;
            }
        }
        throw new RuntimeException("User not found: " + username);
    }

    private Room findRoom(String roomName) {
        for (Map<String, String> room : roomRates) {
            if (room.get("Room Name").equals(roomName)) {
                Room roomToBook = new Room();
                roomToBook.setName(roomName);
                roomToBook.setRate(Double.parseDouble(room.get("Rate")));
                return roomToBook;
            }
        }
        throw new RuntimeException("Rate not found for room: " + roomName);
    }

    @Then("my bill total is {double}")
    public void myBillTotalIsAmount(double totalAmount) {
        Assertions.assertEquals(totalAmount, rental.getRoom().getRate() *
                rental.getDays() *
                rental.getSeasonType().getValue(), 0.1);
    }

    @Given("I am a registered user")
    public void iAmARegisteredUser(DataTable userTable) {
        this.registeredUsers = userTable.asMaps(String.class, String.class);
    }
}
