package com.bonc.dataplatform.bbdp.geniuspig.vertica.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * db manager
 * @author dirk.zhang
 * Nov 6, 2012 3:23:22 PM
 */
public class DBManager {
	IDBAction dbAction = null;
	
//	private String host;
//	private String port;
//	private String database;
//	private String username;
//	private String password;
	
	public DBManager(DBType type){
		switch (type) {
		case ORACLE:
			dbAction = new OracleAction();
			break;
		case MYSQL:
			dbAction = new MysqlAction();
			break;
		case DB2:
			dbAction = new DB2Action();
			break;
		case SQLSERVER:
			dbAction = new SQLServerAction();
			break;
		default:
			dbAction = new OracleAction();
			break;
		}
	}
	
	public IDBAction getAction(){
		return dbAction;
	}
	
	/**
	 * 获取分页查询sql
	 * @param query
	 * @param start
	 * @param end
	 * @return
	 */
	public String getQueryByPaing(String query,long start,long end){
		if(dbAction==null)
			dbAction = new OracleAction();
		return dbAction.getQueryByPaging(query, start, end);
	}
	
	/**
	 * 获取连接
	 * @param host
	 * @param port
	 * @param database
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public Connection getConn(String host,String port,String database,String username,String password) throws SQLException{
		Connection conn = null;
		conn = DriverManager.getConnection(dbAction.getJdbcURL(host, port, database), username, password);
		return conn;
	}
	
	/**
	 * 获得driver
	 * @return
	 */
	public String getDriver(){
		return dbAction.getDriver();
	}

}
