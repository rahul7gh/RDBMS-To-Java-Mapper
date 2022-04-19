package properties;

import utils.Util;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class TextLoadProperties implements LoadPropertiesIface {

	static Logger log = Logger.getLogger(TextLoadProperties.class);
	String location;
	TextProperties textProperties;

	public TextLoadProperties() throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		this.location = this.getClass().getClassLoader().getResource("properties/application.properties").getPath();

		this.loadFile();

	}

	public TextLoadProperties(String location, TextProperties textProperties) {
		super();
		this.location = location;
		this.textProperties = textProperties;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public TextProperties getTextProperties() {
		return textProperties;
	}

	public void setTextProperties(TextProperties textProperties) {
		this.textProperties = textProperties;
	}

	public TextProperties loadFile() throws IOException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		TextProperties props = new TextProperties();
		File file = new File(this.location);
		Scanner fileReader = new Scanner(file);

		while (fileReader.hasNext()) {

			String input[] = fileReader.next().split("=");
			input[0] = input[0].replaceAll("\\.", "_");

			input[0] = input[0].substring(0, 1).toUpperCase() + input[0].substring(1);

			input[1]=Util.removeQuotesIfPresent(input[1]);
			
			Method setMethod = props.getClass().getMethod("set" + input[0], String.class);
			setMethod.invoke(props, input[1]);

		}

		this.textProperties = props;
		fileReader.close();

		return null;
	}

	public void checkProps(YamlProperties yamlProperties, TextProperties textProperties) {

		if (System.getProperty("param.inputfile") == null) {
			log.warn("No File Path Specified! Assuming \"queries.csv\" exist on the current Directory.");
		} else {
			textProperties.setParam_inputfile(System.getProperty("param.inputfile"));
		}

		if (System.getProperty("param.database.type") == null) {
			log.warn("No Database Vendor Provided!. Assuming \"MYSQL\"!");
			textProperties.setParam_database_type("mysql");
		} else {
			textProperties.setParam_database_type(System.getProperty("param.database.type"));
		}

		Database selectedDatabase = null;
		for (Database db : yamlProperties.getParam().getDatabase()) {
			if (db.getType().toLowerCase().equals(textProperties.getParam_database_type().toLowerCase())) {
				selectedDatabase = db;
			}
		}

		textProperties.setParam_database_protocol(selectedDatabase.getProtocol());

		if (System.getProperty("param.database.host") == null) {
			log.warn("No Host Id Provided! Assuming \"localhost\"");

		} else {
			
			textProperties.setParam_database_host(System.getProperty("param.database.host"));
		}

		if (System.getProperty("param.database.port") == null) {
			log.warn("No Port Provided! Assuming default port: " + selectedDatabase.getPort() + " for the "
					+ textProperties.getParam_database_type() + " .");

			textProperties.setParam_database_port(selectedDatabase.getPort() + "");

		} else {
			textProperties.setParam_database_port(System.getProperty("param.database.port"));
		}

		if (System.getProperty("param.database.name") == null) {
			log.error(
					"No Database Name / service Name provided! Please provide a valid Name!\n Exiting with status code -1");
			System.exit(-1);
		} else {
			textProperties.setParam_database_name(System.getProperty("param.database.name"));
		}
		if (System.getProperty("param.database.username") == null) {

			log.error("No Username Name provided! Please provide a valid Userame!\n Exiting with status code -1");
			System.exit(-1);
		} else {
			textProperties.setParam_database_username(System.getProperty("param.database.username"));
		}

		if (System.getProperty("param.database.password") == null) {

			log.warn("No Passowrd Name provided! Assuming No Password");

		} else {
			textProperties.setParam_database_password(System.getProperty("param.database.password"));
		}

		System.out.println(textProperties);

	}

	@Override
	public String toString() {
		return "TextLoadProperties [location=" + location + ", textProperties=" + textProperties + "]";
	}

}
