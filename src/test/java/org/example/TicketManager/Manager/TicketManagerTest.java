package org.example.TicketManager.Manager;

import org.example.TicketManager.Ticket;
import org.example.TicketManager.TicketRepository;
import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TicketManagerTest {
    Ticket ticket1 = new Ticket(1, 15000, "DME", "UFA", 280);
    Ticket ticket2 = new Ticket(2, 11000, "VKO", "SVX", 240);
    Ticket ticket3 = new Ticket(3, 9000, "SVO", "SVX", 180);
    Ticket ticket4 = new Ticket(4, 20000, "NSK", "SVO", 510);
    Ticket ticket5 = new Ticket(5, 16000, "DME", "UFA", 140);
    Ticket ticket6 = new Ticket(6, 17000, "DME", "UFA", 280);
    Ticket ticket7 = new Ticket(7, 19000, "VKO", "SVX", 240);
    Ticket ticket8 = new Ticket(8, 21000, "DME", "UFA", 180);
    Ticket ticket9 = new Ticket(9, 13000, "NSK", "SVO", 510);
    Ticket ticket10 = new Ticket(10, 12000, "DME", "UFA", 140);

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager();


    @Test
    public void shouldMatchByAirport(){

        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.save(ticket7);
        repo.save(ticket8);
        repo.save(ticket9);
        repo.save(ticket10);


        manager.matches(ticket1, "DME", "UFA" );


        Boolean expected = true;
        Boolean actual = manager.matches(ticket1, "DME", "UFA" );

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByAirport(){

        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager();

        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);
        repo.save(ticket7);
        repo.save(ticket8);
        repo.save(ticket9);
        repo.save(ticket10);

        manager.searchBy("DME", "UFA");


        Ticket [] expected = {ticket1, ticket5, ticket6, ticket8, ticket10};
        Ticket [] actual = manager.searchBy("DME", "UFA");

        Assertions.assertArrayEquals(expected, actual);
    }

}
