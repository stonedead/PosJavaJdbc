package pos_java_jdbc.pos_java_jdbc;

import java.sql.SQLException;

import org.junit.Test;

import br.com.rod.model.UserPosJava;
import br.com.rod.userPosJava.dao.UserPosJavaDAO;

public class TestBuscarPorId {

	@Test
	public void buscarPorId() {
		
		UserPosJavaDAO userPosJavaDAO = new UserPosJavaDAO();
		UserPosJava userPosJava;
		
		try {
			userPosJava=userPosJavaDAO.buscarPorId(1L);
			System.out.println(userPosJava);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
