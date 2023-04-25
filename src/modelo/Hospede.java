package modelo;

import java.time.LocalDate;

public class Hospede {
    private int id;
    private String nome;
    private String sobreNome;
    private LocalDate dataNascimento;
    private String nacionalidade;
    private String telefone;
    private int idReserva;

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
}
