

 Movie Tickets GUI Application

Java GUI application to process movie tickets purchased for a customer at a local cinema. The application captures input and displays the movie ticket sales report including VAT.

Features
- Combo box for movie selection: Napoleon, Oppenheimer, Damsel
- Text fields for Number of Tickets and Ticket Price
- Read-only text area to display Ticket Report
- Menu: File > Exit, Tools > Process, Clear
- Process calculates total with 14% VAT
- Save report to report.txt
- Clear resets all fields to default

 Validation Rules
- Movie Ticket Name: Cannot be empty
- Movie Ticket Price: Cannot be less than or equal to zero (0)
- Number of Movie Tickets: Cannot be less than or equal to zero (0)

Example
- Movie: Napoleon
- Number of Tickets: 3
- Ticket Price: 100
- Total Ticket Price: R 342.0
 Files
- Main.java
- IMovieTickets.java
- MovieTickets.java
- MovieTicketData.java
- MovieTicketApp.java
- MovieTicketsTest.java
 How to Run
1. Open in IntelliJ IDEA
2. Run Main.java
3. Select movie, enter tickets and price
4. Click Tools > Process
5. Report is displayed and saved to report.txt

### Unit Tests
- CalculateTotalTicketPrice_CalculatedSuccessfully
- ValidationTests
