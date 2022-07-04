package teste.hellofx.controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import teste.hellofx.App;
import teste.hellofx.classes.Pessoa;

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
    void fazerLogin(ActionEvent event) {
        String usuarioAtual = campoUsuario.getText();
        String senhaAtual = campoSenha.getText();

        ArrayList<Pessoa> usuarios = App.listarUsuarios();

        if (usuarios.size() == 0) {
            JOptionPane.showMessageDialog(null, "Ainda não existe um Usuario cadastrado", "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarioAtual.equals(usuarios.get(i).getNomeDeUsuario())
                    && senhaAtual.equals(usuarios.get(i).getSenha())) {
                System.out.println("Login Efetuado !!");
                JOptionPane.showMessageDialog(null, "Login Efetuado !", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Usuario ou senha incorreto !!");
                JOptionPane.showMessageDialog(null, "Usuario ou senha incorreto !", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
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
