package teste.hellofx.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import teste.hellofx.App;
import teste.hellofx.classes.Pessoa;
import teste.hellofx.dao.Conexao;
import teste.hellofx.dao.PessoaDAO;

public class CriarContaController {

    @FXML
    private Button botaoCriarConta;

    @FXML
    private PasswordField campoConfirmarSenha;

    @FXML
    private PasswordField campoSenha;

    @FXML
    private TextField campoUsuario;

    @FXML
    private Label errorMessage1;

    @FXML
    private Label errorMessage2;

    @FXML
    private Label errorMessage3;

    @FXML
    void criarConta(ActionEvent event) {

        String nomeDeUsuario = campoUsuario.getText();
        String senha = campoSenha.getText();
        String confirmarSenha = campoConfirmarSenha.getText();

        if (nomeDeUsuario.isEmpty()) {
            errorMessage1.setVisible(true);
            campoUsuario.setStyle("-fx-border-color: red");
        } else {
            errorMessage1.setVisible(false);
            campoUsuario.setStyle("-fx-border-color: default");
        }

        if (senha.isEmpty()) {
            errorMessage2.setVisible(true);
            campoSenha.setStyle("-fx-border-color: red");
        } else {
            errorMessage2.setVisible(false);
            campoSenha.setStyle("-fx-border-color: default");
        }

        if (confirmarSenha.isEmpty()) {
            errorMessage3.setVisible(true);
            campoConfirmarSenha.setStyle("-fx-border-color: red");
        } else {
            errorMessage3.setVisible(false);
            campoConfirmarSenha.setStyle("-fx-border-color: default");
        }

        if (!nomeDeUsuario.isEmpty() && !senha.isEmpty() && !confirmarSenha.isEmpty()) {
            if (senha.equals(confirmarSenha)) {
                JOptionPane.showMessageDialog(null, "Conta Criada !", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Conta Criada!");
                Pessoa pessoa = new Pessoa(nomeDeUsuario, senha);

                try {
                    Connection conexao = new Conexao().getConnection();
                    PessoaDAO pessoaDao = new PessoaDAO(conexao);
                    pessoaDao.insert(pessoa);

                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                campoUsuario.setText("");
                campoSenha.setText("");
                campoConfirmarSenha.setText("");

                App.trocarTela(1);
            } else {
                JOptionPane.showMessageDialog(null, "Erro, as senhas nao coincidem", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}