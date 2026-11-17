import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovieTicketsTest {
    @Test
    public void CalculateTotalTicketPrice_CalculatedSuccessfully() {
        MovieTicket mt = new MovieTicket();
        assertEquals(342.0, mt.CalculateTotalTicketPrice(3, 100.0), 0.01);
    }
    @Test
    public void ValidationTests() {
        MovieTicket mt = new MovieTicket();
        assertFalse(mt.ValidateData(new MovieTicketData("", 3, 100)));
        assertFalse(mt.ValidateData(new MovieTicketData("Napoleon", 0, 100)));
        assertFalse(mt.ValidateData(new MovieTicketData("Napoleon", 3, 0)));
        assertTrue(mt.ValidateData(new MovieTicketData("Napoleon", 3, 100)));
    }
}