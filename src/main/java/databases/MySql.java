package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import properties.TextProperties;

public class MySql implements DatabaseIface {

	static final Logger LOGGER=Logger.getLogger(MySql.class);
	private Connection connection;
	private TextProperties textProperties;
	
	public MySql ()
	{
		
	}
	
	public MySql(TextProperties textProperties) {
		super();
		this.textProperties = textProperties;
	}

	public Connection getConnection() {
		return connection;
	}

	private void setConnection(Connection connection) {
		this.connection = connection;
	}

	public TextProperties getTextProperties() {
		return textProperties;
	}

	public void setTextProperties(TextProperties textProperties) {
		this.textProperties = textProperties;
	}

	@Override
	public String toString() {
		return "MySql [connection=" + connection + ", textProperties=" + textProperties + "]";
	}

	
	@Override
	public void init() throws ClassNotFoundException, SQLException
	{
		LOGGER.info("Started init() ");
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url= "jdbc:"+textProperties.getParam_database_protocol()
		+ "://"+textProperties.getParam_database_host()
		+":"+textProperties.getParam_database_port()+"/"+textProperties.getParam_database_name();
		String username= textProperties.getParam_database_username();
		String password= textProperties.getParam_database_password();
		
		System.out.println(url+"<->"+username+"<->"+password);
		
		Connection con = DriverManager.getConnection(url, username, password);
		this.setConnection(con);
		
		
		
		LOGGER.info("Ended init() ");
	}

	@Override
	public Connection getConnectionObject() {
		
		return this.connection;
	}

	
}
