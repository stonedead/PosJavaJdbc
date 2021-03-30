package pos_java_jdbc.pos_java_jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.rod.model.UserPosJava;
import br.com.rod.userPosJava.dao.UserPosJavaDAO;

public class TestListar {

	@Test
	public void listar() {

		UserPosJavaDAO userPosJavaDAO = new UserPosJavaDAO();

		List<UserPosJava> userPosJavas = new ArrayList<UserPosJava>();

		try {
			userPosJavas = userPosJavaDAO.listar();

			for (UserPosJava userPosJava : userPosJavas) {
				System.out.println(userPosJava.toString());
				System.out.println("----------------------------------");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
