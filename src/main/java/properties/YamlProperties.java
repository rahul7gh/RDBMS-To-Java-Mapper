package properties;

import java.util.List;

public class YamlProperties {

	public Param param;

	public YamlProperties() {

	}

	public YamlProperties(Param param) {
		this.param = param;
	}

	public Param getParam() {
		return param;
	}

	public void setParam(Param param) {
		this.param = param;
	}

	@Override
	public String toString() {
		return "YamlProperties [param=" + param + "]";
	}

}

class Param {

	public String inputfile;
	public List<Database> database;

	public Param() {

	}

	public Param(String inputfile, List<Database> database) {
		super();
		this.inputfile = inputfile;
		this.database = database;
	}

	public String getInputfile() {
		return inputfile;
	}

	public void setInputfile(String inputfile) {
		this.inputfile = inputfile;
	}

	public List<Database> getDatabase() {
		return database;
	}

	public void setDatabase(List<Database> database) {
		this.database = database;
	}

	@Override
	public String toString() {
		return "YamlProperties [inputfile=" + inputfile + ", database=" + database + "]";
	}

}

class Database {
	public String type;
	public String protocol;
	public String host;
	public int port;
	public String name;
	public String username;
	public String password;

	public Database() {

	}

	public Database(String type, String protocol, String host, int port, String name, String username,
			String password) {
		super();
		this.type = type;
		this.protocol = protocol;
		this.host = host;
		this.port = port;
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Database [type=" + type + ", protocol=" + protocol + ", host=" + host + ", port=" + port + ", name="
				+ name + ", username=" + username + ", password=" + password + "]";
	}

}