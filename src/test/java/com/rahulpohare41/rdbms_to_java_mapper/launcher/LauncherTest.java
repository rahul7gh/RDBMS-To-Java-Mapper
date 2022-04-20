package com.rahulpohare41.rdbms_to_java_mapper.launcher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import databases.DatabaseIface;
import databases.MySql;
import properties.TextLoadProperties;
import properties.TextProperties;
import properties.YamlLoadPropertiesImpl;
import properties.YamlProperties;
import writers.ResultSetLoader;

public class LauncherTest {

	@Test
	public void PropertyLoadTest() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, IOException, SQLException, ClassNotFoundException
	{
		System.out.println("Test Toh hai!!");
		System.setProperty("param.database.name", "hrdb");
		System.setProperty("param.database.username", "root");
		System.setProperty("param.database.password", "root");
		
		
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
		
	}
	
}
