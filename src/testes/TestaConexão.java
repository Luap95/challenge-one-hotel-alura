package testes;

import factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexão {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try(Connection connection = connectionFactory.recuperaConexao()){

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
