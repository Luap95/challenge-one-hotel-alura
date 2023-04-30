package controller;

import com.toedter.calendar.JDateChooser;
import dao.ReservaDAO;
import factory.ConnectionFactory;
import modelo.Reserva;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ReservaController {

    private ReservaDAO reservaDAO;

    public ReservaController(){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        this.reservaDAO = new ReservaDAO(connectionFactory.recuperaConexao());
    }

    public BigDecimal calculaValorReserva(LocalDate dataEntrada, LocalDate dataSaida){
        BigDecimal valor = new BigDecimal(20);
        valor =valor.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        valor = valor.multiply(new BigDecimal(ChronoUnit.DAYS.between(dataEntrada, dataSaida)));
        return valor;
    }

    public LocalDate FormataData(JDateChooser data){
        return LocalDate.of(data.getJCalendar().getYearChooser().getYear(),
                data.getJCalendar().getMonthChooser().getMonth()+1,
                data.getJCalendar().getDayChooser().getDay());
    }

    public int salvar(Reserva reserva) {
        return this.reservaDAO.salvar(reserva);
    }

    public List<Reserva> listar(int idReserva) {
        return reservaDAO.buscar(idReserva);
    }

    public void alterar(Reserva reserva) {
        this.reservaDAO.alterar(reserva);
    }
}
