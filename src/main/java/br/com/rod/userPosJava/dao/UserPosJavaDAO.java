package br.com.rod.userPosJava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.rod.connectionJdbc.SingleConnection;
import br.com.rod.model.BeanUserFone;
import br.com.rod.model.UserPosJava;

public class UserPosJavaDAO {

	private Connection connection;

	public UserPosJavaDAO() {
		this.connection = SingleConnection.getConnection();
	}

	public void salvar(UserPosJava userPosJava) {

		String sql = "insert into userposjava (nome, email) values (?,?)";

		try {

			PreparedStatement statement = this.connection.prepareStatement(sql);
			statement.setString(1, userPosJava.getNome());
			statement.setString(2, userPosJava.getEmail());

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

	public void atualizarNome(UserPosJava userPosJava) {

		try {

			String sql = "update userposjava set nome = ? where id = " + userPosJava.getId();

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, userPosJava.getNome());

			statement.execute();

			connection.commit();

			System.out.println("Update do nome realizado com sucesso !!!");

		} catch (SQLException e) {

			try {
				connection.rollback();
				System.out.println("Update do nome não foi realizado !!!");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			e.printStackTrace();
		}

	}

	public void deletar(Long id) {

		try {
			String sql = "delete from userposjava where id = " + id;

			PreparedStatement statement;

			statement = connection.prepareStatement(sql);

			statement.execute();

			connection.commit();

			System.out.println("Registro deletado com sucesso !!!");

		} catch (SQLException e) {
			try {
				System.out.println("Não foi possível deletar o registro!!!");
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	public List<BeanUserFone> listarUserFone() throws SQLException {

		List<BeanUserFone> list = new ArrayList<BeanUserFone>();

		String sql = "select nome, email, tipo, numero from telefoneuser as fone inner join userposjava as userp on fone.usuariopessoa = userp.id";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {

			BeanUserFone beanUserFone = new BeanUserFone();
			beanUserFone.setNome(resultSet.getString("nome"));
			beanUserFone.setEmail(resultSet.getString("email"));
			beanUserFone.setTipo(resultSet.getString("tipo"));
			beanUserFone.setNumero(resultSet.getString("numero"));
			
			list.add(beanUserFone);
		}

		return list;

	}
	
	public List<BeanUserFone> buscarUserFonePorId(Long id) throws SQLException {

		List<BeanUserFone> list = new ArrayList<BeanUserFone>();

		String sql = "select nome, email, tipo, numero from telefoneuser as fone inner join userposjava as userp on fone.usuariopessoa = userp.id where userp.id = " + id;

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {

			BeanUserFone beanUserFone = new BeanUserFone();
			beanUserFone.setNome(resultSet.getString("nome"));
			beanUserFone.setEmail(resultSet.getString("email"));
			beanUserFone.setTipo(resultSet.getString("tipo"));
			beanUserFone.setNumero(resultSet.getString("numero"));
			
			list.add(beanUserFone);
		}

		return list;

	}	
}
