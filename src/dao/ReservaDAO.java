package dao;

import modelo.Hospede;
import modelo.Reserva;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public List<Reserva> buscar(int id){
        String sql = "SELECT * FROM RESERVAS WHERE ID = ?";
        List<Reserva> reservaList = new ArrayList<Reserva>();
        Reserva reserva = new Reserva();

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            try (ResultSet resultSet = preparedStatement.getResultSet()) {
                while (resultSet.next()){
                    reserva.setId(resultSet.getInt(1));
                    reserva.setDataEntrada(LocalDate.parse(resultSet.getString(2)));
                    reserva.setDataSaida(LocalDate.parse(resultSet.getString(3)));
                    reserva.setValor(BigDecimal.valueOf(resultSet.getDouble(4)));
                    reserva.setFormaDePagamento(resultSet.getString(5));

                    reservaList.add(reserva);
                }
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return reservaList;
    }

    public void deletar(int id){
        String sql = "DELETE FROM RESERVAS WHERE ID = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void alterar(Reserva reserva){
        String sql = "UPDATE RESERVAS R SET R.DATA_ENTRADA = ? , R.DATA_SAIDA = ? , " +
                "R.VALOR = ? , R.FORMA_PAGAMENTO = ? WHERE ID = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, reserva.getDataEntrada().toString());
            preparedStatement.setString(2, reserva.getDataSaida().toString());
            preparedStatement.setBigDecimal(3, reserva.getValor());
            preparedStatement.setString(4, reserva.getFormaDePagamento());
            preparedStatement.setInt(5, reserva.getId());

            preparedStatement.execute();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
