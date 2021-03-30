package pos_java_jdbc.pos_java_jdbc;

import java.sql.SQLException;

import org.junit.Test;

import br.com.rod.model.UserPosJava;
import br.com.rod.userPosJava.dao.UserPosJavaDAO;

public class UpdateNome {

	@Test
	public void mudarNome() {

		UserPosJavaDAO userPosJavaDAO = new UserPosJavaDAO();
		UserPosJava userPosJava;

		try {
			
			System.out.println();
			
			userPosJava = userPosJavaDAO.buscarPorId(2L);
			
			System.out.println(userPosJava);
			
			userPosJava.setNome("Luiz Gustavo Gomes Pereira");
			
			System.out.println();
			
			userPosJavaDAO.atualizarNome(userPosJava);;
			
			System.out.println();
			
			userPosJava=userPosJavaDAO.buscarPorId(2L);
			
			System.out.println(userPosJava);			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
