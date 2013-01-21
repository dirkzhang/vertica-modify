package com.bonc.dataplatform.bbdp.geniuspig.vertica.db;

/**
 * database类型枚举
 * @author dirk.zhang
 * 2012-10-25 上午9:50:35
 */
public enum DBType {
	ORACLE("oracle","1"),
	MYSQL("mysql","2"),
	DB2("db2","3"),
	SQLSERVER("sqlserver","4");
	
	private String name;
	private String num;

	DBType(String name,String num){
		this.name = name;
		this.num = num;
	}
	
	public static DBType getDefault(){
		return DBType.ORACLE;
	}
	
	public static DBType getDBType(String input){
		if(DBType.ORACLE.equal(input))
			return DBType.ORACLE;
		else if(DBType.MYSQL.equal(input))
			return DBType.MYSQL;
		else if(DBType.DB2.equal(input))
			return DBType.DB2;
		else if(DBType.SQLSERVER.equal(input))
			return DBType.SQLSERVER;
		else
			return DBType.ORACLE;
	}
	
	public DBType getObj(String input){
		if(equal(input))
			return this;
		return null;
	}
	
	
	public boolean equal(String input)
	{
		if(this.name.equalsIgnoreCase(input) || this.name.equalsIgnoreCase(input))
			return true;
		return false;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
}
