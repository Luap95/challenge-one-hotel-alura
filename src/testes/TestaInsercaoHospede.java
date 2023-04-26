package testes;

import dao.HospedeDAO;
import factory.ConnectionFactory;
import modelo.Hospede;

import java.time.LocalDate;

public class TestaInsercaoHospede {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        HospedeDAO hospedeDAO = new HospedeDAO(connectionFactory.recuperaConexao());

        Hospede hospede = new Hospede();

        hospede.setNome("Lucas");
        hospede.setSobreNome("Almeida Pereira");
        hospede.setDataNascimento(LocalDate.of(1995, 07, 07));
        hospede.setNacionalidade("brasileiro");
        hospede.setTelefone("11000000000");
        hospede.setIdReserva(1);

        hospedeDAO.salvar(hospede);
    }
}
