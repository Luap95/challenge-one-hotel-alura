package testes;

import dao.ReservaDAO;
import factory.ConnectionFactory;

import java.sql.SQLException;

public class TestaDeleteReserva {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        ReservaDAO reservaDAO = new ReservaDAO(connectionFactory.recuperaConexao());

        reservaDAO.deletar(2);
    }
}
