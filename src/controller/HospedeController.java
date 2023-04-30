package controller;

import dao.HospedeDAO;
import factory.ConnectionFactory;
import modelo.Hospede;

import java.util.List;

public class HospedeController {

    private HospedeDAO hospedeDAO;

    public HospedeController(){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        this.hospedeDAO = new HospedeDAO(connectionFactory.recuperaConexao());
    }
    public String getUltimoNrReserva() {
        return null;
    }

    public void salvar(Hospede hospede) {
        this.hospedeDAO.salvar(hospede);

    }

    public List<Hospede> listarPorSobreNome(String text) {
        return this.hospedeDAO.buscarSobrenome(text);
    }

    public List<Hospede> listarPorIdReserva(int idReserva) {
        return this.hospedeDAO.buscarIdReserva(idReserva);
    }

    public void deletar(int id){
        this.hospedeDAO.deletar(id);
    }
}
