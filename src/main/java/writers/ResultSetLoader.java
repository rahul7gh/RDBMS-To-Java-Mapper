package writers;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class ResultSetLoader {

	static final Logger logger=Logger.getLogger(ResultSetLoader.class); 
	List<Column> columnList;
	
	public void init(ResultSet rs) throws SQLException
	{
		ResultSetMetaData rsMtdt=rs.getMetaData();
		columnList= new ArrayList<>();
		for (int i=1;i<=rsMtdt.getColumnCount();i++)
		{

			columnList.add(new Column(rsMtdt.getColumnName(i),
					rsMtdt.getColumnTypeName(i)));
		}
		
		logger.debug(columnList);
		
	}
	
}
