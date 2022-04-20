package launcher;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import databases.DatabaseIface;
import databases.MySql;
import properties.TextLoadProperties;
import properties.TextProperties;
import properties.YamlLoadPropertiesImpl;
import properties.YamlProperties;
import writers.ResultSetLoader;

public class Test {

	static Logger log = Logger.getLogger(Test.class.getName());

	public static void main(String[] args) throws IOException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException,
			SQLException, InterruptedException {

		YamlLoadPropertiesImpl yamlLoadProperties = new YamlLoadPropertiesImpl();
		YamlProperties yamlProperties = yamlLoadProperties.getYamlProperties();

		TextLoadProperties textLoadProperties = new TextLoadProperties();
		TextProperties textProperties = textLoadProperties.getTextProperties();

		textLoadProperties.checkProps(yamlProperties, textProperties);

		DatabaseIface mySql = new MySql(textProperties);

		mySql.init();
		
//		System.out.println(textProperties);
		PreparedStatement stmt= mySql.getConnectionObject()
				.prepareStatement("select * from employees limit 1");
		ResultSet rs= stmt.executeQuery(); 
		
		ResultSetLoader resultSetLoader= new ResultSetLoader();
		resultSetLoader.init(rs);
		
//		System.out.println(rs.getMetaData().getColumnCount());
 		
		
		Thread.sleep(100000);
		

	}

}
