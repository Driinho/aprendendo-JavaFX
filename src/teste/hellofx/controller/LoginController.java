package teste.hellofx.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import teste.hellofx.App;
import teste.hellofx.classes.Pessoa;
import teste.hellofx.dao.Conexao;
import teste.hellofx.dao.PessoaDAO;

public class LoginController {

    @FXML
    private Button botaoCadastro;

    @FXML
    private Button botaoEntrar;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private TextField campoUsuario;

    @FXML
    void fazerLogin(ActionEvent event) throws SQLException {
        String usuarioAtual = campoUsuario.getText();
        String senhaAtual = campoSenha.getText();

        Pessoa autenticar = new Pessoa(usuarioAtual, senhaAtual);
        Connection conexao = new Conexao().getConnection();
        PessoaDAO pessoaDao = new PessoaDAO(conexao);

        if (pessoaDao.existeNoBancoPorUsuarioESenha(autenticar)) {
            JOptionPane.showMessageDialog(null, "Login Efetuado com Sucesso !!!", "SUCESSO",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario ou senha invalidos !!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }

        campoUsuario.setText("");
        campoSenha.setText("");
    }

    @FXML
    void cadastrar(ActionEvent event) {
        System.out.println("Btn Cadastrar!");
        App.trocarTela(2);
    }
}
