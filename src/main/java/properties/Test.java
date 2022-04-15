package properties;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;

public class Test {

	static Logger log = Logger.getLogger(Test.class.getName());

	
	public static void main(String[] args) throws IOException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		YamlLoadPropertiesImpl yamlLoadProperties = new YamlLoadPropertiesImpl();
		YamlProperties yamlProperties = yamlLoadProperties.getYamlProperties();

		TextLoadProperties textLoadProperties = new TextLoadProperties();
		TextProperties textProperties = textLoadProperties.getTextProperties();
		
		textLoadProperties.checkProps(yamlProperties, textProperties);

		System.out.println(textProperties);


	}

}
