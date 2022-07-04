package teste.hellofx.classes;

import java.util.ArrayList;

public class Sistema {

    private String nome;
    private ArrayList<Pessoa> listaDeUsuarios;

    public Sistema(String nome) {
        this.nome = nome;
        listaDeUsuarios = new ArrayList<Pessoa>();
    }

    public ArrayList<Pessoa> getListaDeUsuarios() {
        return listaDeUsuarios;
    }

    public void setListaDeUsuarios(ArrayList<Pessoa> listaDeUsuarios) {
        this.listaDeUsuarios = listaDeUsuarios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void cadastroDeUsuario(String nomeDeUsuario, String senha) {
        Pessoa pessoa = new Pessoa(nomeDeUsuario, senha);
        this.listaDeUsuarios.add(pessoa);
    }

    public ArrayList<Pessoa> listarUsuarios() {
        return listaDeUsuarios;
    }

}
