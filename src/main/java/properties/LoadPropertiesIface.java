package properties;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public interface LoadPropertiesIface {

	public Object loadFile() throws IOException, NoSuchMethodException, SecurityException,
	IllegalAccessException, IllegalArgumentException, InvocationTargetException ;

}