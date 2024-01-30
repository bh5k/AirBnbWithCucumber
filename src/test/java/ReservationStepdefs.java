import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Rental;
import model.Room;
import model.SeasonType;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

public class ReservationStepdefs {

    private List<Map<String, String>> roomRates;

    Rental rental;

    @Given("the following rooms are available to rent")
    public void theFollowingRoomsAreAvailableToRent(DataTable roomTable) {
        this.roomRates = roomTable.asMaps(String.class, String.class);
    }


    @When("I book a {string} in {string} for {int}")
    public void iBookARoomInSeasonForDays(String roomName, String seasonStr, int days) {
        Room room = findRoom(roomName);
        SeasonType season = SeasonType.valueOf(seasonStr);
        rental = new Rental();
        rental.setRoom(room);
        rental.setSeasonType(season);
        rental.setDays(days);
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
}
