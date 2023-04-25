package dao;

import modelo.Reserva;

import java.sql.*;

public class ReservaDAO {
    private Connection connection;

    public ReservaDAO(Connection connection){
        this.connection = connection;
    }

    public int salvar(Reserva reserva){
        String sql = "INSERT INTO RESERVAS(DATA_ENTRADA, DATA_SAIDA, VALOR, FORMA_PAGAMENTO) " +
                "VALUES (? , ? , ? , ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setString(1, reserva.getDataEntrada().toString());
            preparedStatement.setString(2, reserva.getDataSaida().toString());
            preparedStatement.setBigDecimal(3, reserva.getValor());
            preparedStatement.setString(4, reserva.getFormaDePagamento());

            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                while (resultSet.next()){
                    reserva.setId(resultSet.getInt(1));
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return reserva.getId();
    }
}
