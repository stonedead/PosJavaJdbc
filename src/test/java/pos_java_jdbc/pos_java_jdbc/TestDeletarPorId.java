package pos_java_jdbc.pos_java_jdbc;

import org.junit.Test;

import br.com.rod.userPosJava.dao.UserPosJavaDAO;

public class TestDeletarPorId {

	@Test
	public void deletarPorId() {
		
		UserPosJavaDAO userPosJavaDAO = new UserPosJavaDAO();
		
		userPosJavaDAO.deletar(8L);
		
	}

}
