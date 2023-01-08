package org.example.TicketManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TicketRepositoryTest {

    Ticket ticket1 = new Ticket(1, 15000, "DME", "UFA", 280);
    Ticket ticket2 = new Ticket(2, 11000, "VKO", "SVX", 240);
    Ticket ticket3 = new Ticket(3, 9000, "SVO", "SVX", 180);
    Ticket ticket4 = new Ticket(4, 20000, "NSK", "SVO", 510);
    Ticket ticket5 = new Ticket(5, 16000, "LED", "DME", 140);
    Ticket ticket6 = new Ticket(6, 17000, "DME", "UFA", 280);
    Ticket ticket7 = new Ticket(7, 19000, "VKO", "SVX", 240);
    Ticket ticket8 = new Ticket(8, 21000, "SVO", "SVX", 180);
    Ticket ticket9 = new Ticket(9, 13000, "NSK", "SVO", 510);
    Ticket ticket10 = new Ticket(10, 12000, "LED", "DME", 140);

    @Test
    public void shouldSaveOne() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        //repo.save(ticket2);
        //repo.save(ticket3);
        //repo.save(ticket4);
        //repo.save(ticket5);

        Ticket[] expected = {ticket1};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);


    }


    @Test
    public void shouldSaveAll() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeById() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.removeById(3);

        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }


}
