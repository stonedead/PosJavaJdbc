package br.com.rod.userPosJava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.rod.connectionJdbc.SingleConnection;
import br.com.rod.model.UserPosJava;

public class UserPosJavaDAO {

	private Connection connection;

	public UserPosJavaDAO() {
		this.connection = SingleConnection.getConnection();
	}

	public void salvar(UserPosJava userPosJava) {

		String sql = "insert into userposjava (id, nome, email) values (?,?,?)";

		try {

			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setLong(1, userPosJava.getId());
			statement.setString(2, userPosJava.getNome());
			statement.setString(3, userPosJava.getEmail());

			statement.execute(); // executa o comando no banco de dados

			this.connection.commit(); // salva os dados no banco

			System.out.println("Dados gravados com sucesso ...");

		} catch (SQLException e) {
			try {
				this.connection.rollback(); // cancela o salvamento dos dados e retorna
											// ao estado anterior
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	public List<UserPosJava> listar() throws SQLException {

		List<UserPosJava> list = new ArrayList<UserPosJava>();

		String sqlStatement = "select * from userposjava";

		PreparedStatement statement = connection.prepareStatement(sqlStatement);

		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {

			UserPosJava posJava = new UserPosJava();
			posJava.setId(resultSet.getLong("id"));
			posJava.setNome(resultSet.getString("nome"));
			posJava.setEmail(resultSet.getString("email"));

			list.add(posJava);
		}

		return list;
	}

	public UserPosJava buscarPorId(Long Id) throws SQLException {

		UserPosJava retorno = new UserPosJava();

		String sqlStatement = "select * from userposjava where id = " + Id;

		PreparedStatement statement = connection.prepareStatement(sqlStatement);

		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {

			retorno.setId(resultSet.getLong("id"));
			retorno.setNome(resultSet.getString("nome"));
			retorno.setEmail(resultSet.getString("email"));

		}

		return retorno;
	}

}
