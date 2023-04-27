package testes;

import dao.HospedeDAO;
import factory.ConnectionFactory;

public class TestaDeleteHospede {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        HospedeDAO hospedeDAO = new HospedeDAO(connectionFactory.recuperaConexao());

        hospedeDAO.deletar(30);
    }
}
