package org.example.TicketManager.Manager;

import org.example.TicketManager.Ticket;
import org.example.TicketManager.TicketRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    TicketManager manager = new TicketManager(repo);


    @Test
    public void shouldAdd() {

        manager.add(ticket1);
        manager.add(ticket2);

        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMatchByAirportIfNo() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);


        manager.matches(ticket3, "DME", "UFA");


        Boolean expected = false;
        Boolean actual = manager.matches(ticket3, "DME", "UFA");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchByAirportIfYes() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);


        manager.matches(ticket1, "DME", "UFA");


        Boolean expected = true;
        Boolean actual = manager.matches(ticket1, "DME", "UFA");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByAirportIfSome() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        manager.searchBy("DME", "UFA");


        Ticket[] expected = {ticket10, ticket1, ticket5, ticket6, ticket8};
        Ticket[] actual = manager.searchBy("DME", "UFA");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByAirportIfOne() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        manager.searchBy("SVO", "SVX");


        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.searchBy("SVO", "SVX");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByAirportIfNo() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        manager.searchBy("DME", "SVX");


        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("DME", "SVX");


        Assertions.assertArrayEquals(expected, actual);
    }

}
