package testes;

import dao.ReservaDAO;
import factory.ConnectionFactory;
import modelo.Reserva;

import java.util.List;

public class TestaBuscaReserva {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        ReservaDAO reservaDAO = new ReservaDAO(connectionFactory.recuperaConexao());
        List<Reserva> reservas = reservaDAO.buscar(1);

        for (Reserva reserva : reservas) {
            System.out.println(reservas);
        }
    }
}
