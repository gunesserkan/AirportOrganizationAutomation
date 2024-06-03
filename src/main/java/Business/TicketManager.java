package Business;

import Dao.TicketDao;
import Entity.Ticket;

import java.sql.SQLException;
import java.util.ArrayList;

public class TicketManager {

    private TicketDao ticketDao;

    public TicketManager() {
        this.ticketDao = new TicketDao();
    }

    public Ticket findTicketById(int ticketId) throws SQLException {
        return ticketDao.findById(ticketId);
    }

    public ArrayList<Ticket> findTicketsByAccountId(int accountId) throws SQLException {
        return ticketDao.findByTicketId(accountId);
    }

    public void addTicket(Ticket ticket) throws SQLException {
        ticketDao.insert(ticket);
    }

    public void updateTicket(Ticket ticket) throws SQLException {
        ticketDao.update(ticket);
    }

    public void deleteTicket(int ticketId) throws SQLException {
        ticketDao.delete(ticketId);
    }
}
