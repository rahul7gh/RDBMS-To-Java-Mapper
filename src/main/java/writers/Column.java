package writers;

public class Column {

	
	String columnName;
	String columnDataType;
	
	public Column(String columnName, String columnType) {
		this.columnName=columnName;
		this.columnDataType=columnType;
}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnDataType() {
		return columnDataType;
	}

	public void setColumnDataType(String columnDataType) {
		this.columnDataType = columnDataType;
	}

	@Override
	public String toString() {
		return "Column [columnName=" + columnName + ", columnDataType=" + columnDataType + "]";
	}
	
	
	
	
}
