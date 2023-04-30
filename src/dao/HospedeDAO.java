package dao;

import modelo.Hospede;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HospedeDAO {

    private Connection connection;

    public HospedeDAO(Connection connection){
        this.connection = connection;
    }

    public void salvar(Hospede hospede){
        String sql = "INSERT INTO HOSPEDE (NOME, SOBRENOME, DATA_NASCIMENTO, NACIONALIDADE, TELEFONE, ID_RESERVA) " +
                "VALUES (? , ? , ? , ? , ? , ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, hospede.getNome());
            preparedStatement.setString(2, hospede.getSobreNome());
            preparedStatement.setString(3, hospede.getDataNascimento().toString());
            preparedStatement.setString(4, hospede.getNacionalidade());
            preparedStatement.setString(5, hospede.getTelefone());
            preparedStatement.setInt(6, hospede.getIdReserva());

            preparedStatement.execute();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Hospede> buscarSobrenome(String sobrenome){
        String sql = "SELECT * FROM HOSPEDE WHERE SOBRENOME = ?";
        List<Hospede> hospedeList = new ArrayList<Hospede>();

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1 , sobrenome);

            preparedStatement.execute();

            formataHospede(hospedeList, preparedStatement);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return hospedeList;
    }

    public List<Hospede> buscarIdReserva(int idReserva){
        String sql = "SELECT * FROM HOSPEDE WHERE ID_RESERVA = ?";
        List<Hospede> hospedeList = new ArrayList<Hospede>();

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1 , idReserva);

            preparedStatement.execute();

            formataHospede(hospedeList, preparedStatement);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return hospedeList;
    }


    private static void formataHospede(List<Hospede> hospedeList, PreparedStatement preparedStatement) throws SQLException {
        try(ResultSet resultSet = preparedStatement.getResultSet()){
            while(resultSet.next()){
                Hospede hospede = new Hospede();

                hospede.setId(resultSet.getInt(1));
                hospede.setNome(resultSet.getString(2));
                hospede.setSobreNome(resultSet.getString(3));
                hospede.setDataNascimento(LocalDate.parse(resultSet.getString(4)));
                hospede.setNacionalidade(resultSet.getString(5));
                hospede.setTelefone(resultSet.getString(6));
                hospede.setIdReserva(resultSet.getInt(7));

                hospedeList.add(hospede);
            }
        }
    }

    public void deletar(int id){
        String sql = "DELETE FROM HOSPEDE WHERE ID = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

        }catch (SQLException e ){
            throw new RuntimeException(e);
        }
    }

    public void alterar(Hospede hospede){
        String sql = "UPDATE HOSPEDE H SET H.NOME = ? , H.SOBRENOME = ? , H.DATA_NASCIMENTO = ? ," +
                "H.NACIONALIDADE = ? , H.TELEFONE = ? , H.ID_RESERVA = ? WHERE ID = ?";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, hospede.getNome());
            preparedStatement.setString(2, hospede.getSobreNome());
            preparedStatement.setString(3, hospede.getDataNascimento().toString());
            preparedStatement.setString(4, hospede.getNacionalidade());
            preparedStatement.setString(5, hospede.getTelefone());
            preparedStatement.setInt(6, hospede.getIdReserva());
            preparedStatement.setInt(7, hospede.getId());

            preparedStatement.execute();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
