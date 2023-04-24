package controller;

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
}
