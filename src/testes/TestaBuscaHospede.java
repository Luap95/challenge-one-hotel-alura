package testes;

import dao.HospedeDAO;
import factory.ConnectionFactory;
import modelo.Hospede;

import java.util.List;

public class TestaBuscaHospede {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        HospedeDAO hospedeDAO = new HospedeDAO(connectionFactory.recuperaConexao());
        List<Hospede> hospedeList = hospedeDAO.buscarSobrenome("Almeida Pereira");

        for (Hospede hospede : hospedeList){
            System.out.println(hospede);
        }
        System.out.println(hospedeList);
    }
}
