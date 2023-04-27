package testes;

import factory.ConnectionFactory;
import modelo.Reserva;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class TestaConexão {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection connection = connectionFactory.recuperaConexao()){

        }catch (SQLException e){
            throw new RuntimeException(e);
        }


    }
}
