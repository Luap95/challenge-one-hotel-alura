package modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Reserva {
    private int id;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private BigDecimal valor;
    private String formaDePagamento;


    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", dataEntrada=" + dataEntrada +
                ", dataSaida=" + dataSaida +
                ", valor=" + valor +
                ", formaDePagamento='" + formaDePagamento + '\'' +
                '}';
    }
}
