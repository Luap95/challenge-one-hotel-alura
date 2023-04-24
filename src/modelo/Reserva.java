package modelo;

import java.time.LocalDate;
import java.util.Date;

public class Reserva {
    private int id;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private double valor;
    private String formaDePagamento;

    public Reserva(LocalDate dataEntrada, LocalDate dataSaida){
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }
}
