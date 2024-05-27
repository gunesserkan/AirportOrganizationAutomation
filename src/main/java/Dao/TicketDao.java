package Dao;

import Core.Database;
import Entity.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TicketDao {
    private Connection connection;

    public TicketDao() {
        this.connection = Database.getIntance();
    }

    public Ticket findById(int ticketID) throws SQLException {
        Ticket ticket = null;
        String sql = "SELECT * FROM ticket WHERE ticket_id=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, ticketID);
        ResultSet result = preparedStatement.executeQuery();
        if (result.next()) {
            ticket = this.match(result);
        }
        return ticket;
    }

    public ArrayList<Ticket> findByTicketId(int ticketId) throws SQLException {
        ArrayList<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM ticket WHERE account_id=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, ticketId);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            tickets.add(this.match(result));
        }
        return tickets;
    }

    public void insert(Ticket ticket) throws SQLException {
        String sql = "INSERT INTO address ( flight_id, account_id,seat_number) VALUES ( ?, ?, ?)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, ticket.getFlightId());
        preparedStatement.setInt(2, ticket.getAccountId());
        preparedStatement.setString(3, ticket.getSeatNumber());
        preparedStatement.executeUpdate();
    }

    public void update(Ticket ticket) throws SQLException {
        String sql = "UPDATE ticket SET flight_id=?, account_id=?, seat_number=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, ticket.getFlightId());
        preparedStatement.setInt(2, ticket.getAccountId());
        preparedStatement.setString(3, ticket.getSeatNumber());
        preparedStatement.setInt(4, ticket.getAccountId());
        preparedStatement.setInt(5, ticket.getFlightId());
        preparedStatement.executeUpdate();
    }

    public void delete(int ticketId) throws SQLException {
        String sql = "DELETE FROM ticket WHERE ticket_id=?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, ticketId);
        preparedStatement.executeUpdate();
    }

    private Ticket match(ResultSet result) throws SQLException {
        Ticket ticket = new Ticket(
                result.getInt("ticket_id"),
                result.getInt("flight_id"),
                result.getInt("account_id"),
                result.getString("seat_number"));
        return ticket;
    }
}

