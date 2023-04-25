package controller;

import com.toedter.calendar.JDateChooser;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class ReservaController {

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

    public int salvar() {
        return 1220;
    }
}
