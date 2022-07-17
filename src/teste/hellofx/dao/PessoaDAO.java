package teste.hellofx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import teste.hellofx.classes.Pessoa;

public class PessoaDAO extends Conexao {

    private final Connection connection;

    public PessoaDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Pessoa usuario) throws SQLException {

        String sql = "insert into usuario (usuario,senha) values ('" + usuario.getNomeDeUsuario() + "','"
                + usuario.getSenha() + "');";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();
    }

    public boolean existeNoBancoPorUsuarioESenha(Pessoa autenticar) throws SQLException {

        String sql = "select * from usuario where usuario = '" + autenticar.getNomeDeUsuario() + "' and senha = '"
                + autenticar.getSenha() + "'";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.execute();

        ResultSet resultSet = statement.getResultSet();
        return resultSet.next();
    }

}