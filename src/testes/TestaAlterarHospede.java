package testes;

import dao.HospedeDAO;
import factory.ConnectionFactory;
import modelo.Hospede;

import java.time.LocalDate;

public class TestaAlterarHospede {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        HospedeDAO hospedeDAO = new HospedeDAO(connectionFactory.recuperaConexao());

        Hospede hospede = new Hospede();

        hospede.setNome("Fabíola");
        hospede.setSobreNome("Souza Ferreira");
        hospede.setDataNascimento(LocalDate.of(1995, 10, 12));
        hospede.setNacionalidade("brasileiro");
        hospede.setTelefone("12000000000");
        hospede.setIdReserva(1);
        hospede.setId(1);

        hospedeDAO.alterar(hospede);
    }
}
