package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class YamlLoadPropertiesImpl implements LoadPropertiesIface {

	public String location;
	YamlProperties yamlProperties;
	

	static Logger log = Logger.getLogger(YamlLoadPropertiesImpl.class);

	public YamlLoadPropertiesImpl() throws FileNotFoundException {
		log.info("No External File Location Provided Readig Default Config data from : "
				+ this.getClass().getClassLoader().getResource("properties/default-config.yml").getPath());
		this.location = this.getClass().getClassLoader().getResource("properties/default-config.yml").getPath();
		this.yamlProperties = this.loadFile();
		
		log.info("File Loading Complete!");
	}

	public YamlLoadPropertiesImpl(String location) throws FileNotFoundException {
		
		log.info("Using teh absolute location : " + location + "to read the default config data.");
		
		this.location = location;
		this.yamlProperties = this.loadFile();
		
		log.info("File Loading Complete!");
	}

	
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	
	public YamlProperties getYamlProperties() {
		return yamlProperties;
	}

	public void setYamlProperties(YamlProperties yamlProperties) {
		this.yamlProperties = yamlProperties;
	}

	public YamlProperties loadFile() throws FileNotFoundException {

		Yaml ymlFile = new Yaml(new Constructor(YamlProperties.class));

		return ymlFile.load(new FileInputStream(new File(location)));
	}

}
