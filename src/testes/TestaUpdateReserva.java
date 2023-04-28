package testes;

import dao.ReservaDAO;
import factory.ConnectionFactory;
import modelo.Reserva;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TestaUpdateReserva {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        ReservaDAO reservaDAO = new ReservaDAO(connectionFactory.recuperaConexao());

        Reserva reserva = new Reserva();
        reserva.setDataEntrada(LocalDate.of(2023, 04, 4));
        reserva.setDataSaida(LocalDate.of(2023,07,07));
        reserva.setValor(BigDecimal.valueOf(780));
        reserva.setFormaDePagamento("CREDITO");
        reserva.setId(1);

        reservaDAO.alterar(reserva);
    }
}
