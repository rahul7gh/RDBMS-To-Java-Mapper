package databases;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseIface {

	public void init() throws ClassNotFoundException, SQLException;
	public Connection getConnectionObject();
	
}
