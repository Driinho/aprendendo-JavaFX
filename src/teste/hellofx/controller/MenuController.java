package teste.hellofx.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import teste.hellofx.classes.Pessoa;
import teste.hellofx.dao.Conexao;
import teste.hellofx.dao.PessoaDAO;

public class MenuController {

    @FXML
    private MenuItem testaUsuarioDao;

    @FXML
    void testaUsuarioDAO(ActionEvent event) throws SQLException {

        Connection conexao = new Conexao().getConnection();
        PessoaDAO pessoaDao = new PessoaDAO(conexao);

        Pessoa pessoaInsert = new Pessoa("Testesinho", "4321");
        Pessoa pessoaInserida = pessoaDao.insert(pessoaInsert);

        Pessoa pessoaSelecionada = pessoaDao.selectPorId(pessoaInserida);

        pessoaDao.delete(pessoaSelecionada);

        ArrayList<Pessoa> pessoas = pessoaDao.selectAll();

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getNomeDeUsuario());
        }
    }

}
