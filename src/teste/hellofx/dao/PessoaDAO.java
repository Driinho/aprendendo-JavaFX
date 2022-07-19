package teste.hellofx.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import teste.hellofx.classes.Pessoa;

public class PessoaDAO extends Conexao {

    private final Connection connection;

    public PessoaDAO(Connection connection) {
        this.connection = connection;
    }

    public Pessoa insert(Pessoa usuario) throws SQLException {

        String sql = "INSERT INTO usuario (usuario,senha) VALUES (?,?);";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, usuario.getNomeDeUsuario());
        statement.setString(2, usuario.getSenha());
        statement.execute();

        ResultSet resultSet = statement.getGeneratedKeys();

        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            usuario.setId(id);
        }
        return usuario;
    }

    public void update(Pessoa usuario) throws SQLException {

        String sql = "UPDATE usuario SET usuario = ?, senha = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getNomeDeUsuario());
        statement.setString(1, usuario.getSenha());
        statement.setInt(3, usuario.getId());

        statement.execute();
    }

    public void insertOrUpdate(Pessoa usuario) throws SQLException {

        if (usuario.getId() > 0) {
            update(usuario);
        } else {
            insert(usuario);
        }
    }

    public void delete(Pessoa usuario) throws SQLException {

        String sql = "DELETE FROM usuario WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, usuario.getId());

        statement.execute();
    }

    public ArrayList<Pessoa> selectAll() throws SQLException {

        String sql = "SELECT * FROM usuario ";
        PreparedStatement statement = connection.prepareStatement(sql);

        return pesquisa(statement);
    }

    private ArrayList<Pessoa> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

        statement.execute();
        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nomeDeUsuario = resultSet.getString("usuario");
            String senha = resultSet.getString("senha");

            Pessoa pessoa = new Pessoa(id, nomeDeUsuario, senha);
            pessoas.add(pessoa);
        }

        return pessoas;
    }

    public Pessoa selectPorId(Pessoa usuario) throws SQLException {

        String sql = "SELECT * FROM usuario WHERE id = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, usuario.getId());

        return pesquisa(statement).get(0);
    }

    public boolean existeNoBancoPorUsuarioESenha(Pessoa autenticar) throws SQLException {

        String sql = "SELECT * FROM usuario WHERE usuario = ? and senha = ?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, autenticar.getNomeDeUsuario());
        statement.setString(2, autenticar.getSenha());
        statement.execute();

        ResultSet resultSet = statement.getResultSet();
        return resultSet.next();
    }
}