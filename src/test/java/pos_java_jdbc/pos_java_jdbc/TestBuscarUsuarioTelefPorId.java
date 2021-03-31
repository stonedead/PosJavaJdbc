package pos_java_jdbc.pos_java_jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.rod.model.BeanUserFone;
import br.com.rod.userPosJava.dao.UserPosJavaDAO;

public class TestBuscarUsuarioTelefPorId {

	@Test
	public void listarUsuarioTelef() {

		UserPosJavaDAO userPosJavaDAO = new UserPosJavaDAO();

		List<BeanUserFone> list = new ArrayList<BeanUserFone>();

		try {
			list = userPosJavaDAO.buscarUserFonePorId(4L);
			
			for (BeanUserFone beanUserFone : list) {
				System.out.println(beanUserFone);
				System.out.println("----------------------------------");
			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
