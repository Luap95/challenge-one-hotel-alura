package testes;

import dao.ReservaDAO;
import factory.ConnectionFactory;
import modelo.Reserva;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TestaInsercao {
    public static void main(String[] args) {
        Reserva reserva = new Reserva();

        reserva.setDataEntrada(LocalDate.of(2023, 04, 25));
        reserva.setDataSaida(LocalDate.of(2023,07,07));
        reserva.setValor(BigDecimal.valueOf(200));
        reserva.setFormaDePagamento("DINHEIRO");

        ConnectionFactory connectionFactory = new ConnectionFactory();
        ReservaDAO reservaDAO = new ReservaDAO(connectionFactory.recuperaConexao());
        int id = reservaDAO.salvar(reserva);
        System.out.println(id);
    }
}
