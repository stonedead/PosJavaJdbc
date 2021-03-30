package pos_java_jdbc.pos_java_jdbc;

import org.junit.Test;

import br.com.rod.connectionJdbc.SingleConnection;

public class TestBancoJdbc {

	@Test
	public void initBanco() {
		SingleConnection.getConnection();
	}
	
	
}
