package properties;

public class TextProperties {

	String param_inputfile;
	String param_database_type;
	String param_database_protocol;
	String param_database_host;
	String param_database_port;
	String param_database_name;
	String param_database_username;
	String param_database_password;

	public TextProperties() {

	}

	public TextProperties(String param_inputfile, String param_database_type, String param_database_protocol,
			String param_database_host, String param_database_port, String param_database_name,
			String param_database_usaename, String param_database_password) {
		super();
		this.param_inputfile = param_inputfile;
		this.param_database_type = param_database_type;
		this.param_database_protocol = param_database_protocol;
		this.param_database_host = param_database_host;
		this.param_database_port = param_database_port;
		this.param_database_name = param_database_name;
		this.param_database_username = param_database_usaename;
		this.param_database_password = param_database_password;
	}

	public String getParam_inputfile() {
		
		return param_inputfile;
	}

	public void setParam_inputfile(String param_inputfile) {
		this.param_inputfile = param_inputfile;
	}

	public String getParam_database_type() {
		return param_database_type;
	}

	public void setParam_database_type(String param_database_type) {
		this.param_database_type = param_database_type;
	}

	public String getParam_database_protocol() {
		return param_database_protocol;
	}

	public void setParam_database_protocol(String param_database_protocol) {
		this.param_database_protocol = param_database_protocol;
	}

	public String getParam_database_host() {
		return param_database_host;
	}

	public void setParam_database_host(String param_database_host) {
		this.param_database_host = param_database_host;
	}

	public String getParam_database_port() {
		return param_database_port;
	}

	public void setParam_database_port(String param_database_port) {
		this.param_database_port = param_database_port;
	}

	public String getParam_database_name() {
		return param_database_name;
	}

	public void setParam_database_name(String param_database_name) {
		this.param_database_name = param_database_name;
	}

	public String getParam_database_username() {
		return param_database_username;
	}

	public void setParam_database_username(String param_database_usaename) {
		this.param_database_username = param_database_usaename;
	}

	public String getParam_database_password() {
		return param_database_password;
	}

	public void setParam_database_password(String param_database_password) {
		this.param_database_password = param_database_password;
	}

	@Override
	public String toString() {
		return "TextProperties [param_inputfile=" + param_inputfile + ", param_database_type=" + param_database_type
				+ ", param_database_protocol=" + param_database_protocol + ", param_database_host="
				+ param_database_host + ", param_database_port=" + param_database_port + ", param_database_name="
				+ param_database_name + ", param_database_usaename=" + param_database_username
				+ ", param_database_password=" + param_database_password + "]";
	}

}
