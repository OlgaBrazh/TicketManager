package org.example.TicketManager.Manager;

import org.example.TicketManager.Ticket;
import org.example.TicketManager.TicketRepository;

public class TicketManager {

    TicketRepository repo = new TicketRepository();

    public boolean matches(Ticket ticket, String search1, String search2) {
        if (ticket.getDepartureAirport().contains(search1)) {
            return true;
        } else if (ticket.getArrivalAirport().contains(search2)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0]; // тут будем хранить подошедшие запросу продукты
        for (Ticket ticket : repo.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];

                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }

        }
        return result;
    }
}
