package pos_java_jdbc.pos_java_jdbc;

import org.junit.Test;

import br.com.rod.model.UserPosJava;
import br.com.rod.userPosJava.dao.UserPosJavaDAO;

public class TestInsertBancoJdbc {

	@Test
	public void insereBanco() {
		
		UserPosJava posJava = new UserPosJava();
		UserPosJavaDAO posJavaDAO = new UserPosJavaDAO();
		
		posJava.setNome("Thiago Gomes Pereira");
		posJava.setEmail("thigope@gmail.com");
		
		posJavaDAO.salvar(posJava);
		
	}
	
}
