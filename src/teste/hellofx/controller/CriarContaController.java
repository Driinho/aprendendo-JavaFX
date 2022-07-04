package teste.hellofx.controller;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import teste.hellofx.App;

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
    void criarConta(ActionEvent event) {

        String nomeDeUsuario = campoUsuario.getText();
        String senha = campoSenha.getText();
        String confirmarSenha = campoConfirmarSenha.getText();

        if (nomeDeUsuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "nome de Usuario é obrigatório.", "ERRO", JOptionPane.ERROR_MESSAGE);
        } else if (senha.isEmpty() && senha.length() < 8) {
            JOptionPane.showMessageDialog(null, "Preencha a senha corretamente.", "ERRO", JOptionPane.ERROR_MESSAGE);
        } else {
            if (senha.equals(confirmarSenha)) {
                JOptionPane.showMessageDialog(null, "Conta Criada !", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Conta Criada!");
                App.cadastroDeUsuario(nomeDeUsuario, senha);

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