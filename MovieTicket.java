public class MovieTicket implements IMovieTickets {
    @Override
    public double CalculateTotalTicketPrice(int numberOfTickets, double ticketPrice) {
        return numberOfTickets * ticketPrice * 1.14;
    }
    @Override
    public boolean ValidateData(MovieTicketData movieTicketData) {
        if (movieTicketData.getMovieName() == null || movieTicketData.getMovieName().isEmpty()) {
            return false;
        }
        if (movieTicketData.getTicketPrice() <= 0) {
            return false;
        }
        if (movieTicketData.getNumberOfTickets() <= 0) {
            return false;
        }
        return true;
    }
}