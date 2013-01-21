package com.bonc.dataplatform.bbdp.geniuspig.vertica.db;

/**
 * db interface
 * @author dirk.zhang
 * Nov 6, 2012 3:23:37 PM
 */
public interface IDBAction {
//	public String setHost(String host);
//	public String setPort(String port);
//	public String setUserName(String username);
//	public String setPassWord(String password);
	public String getJdbcURL(String host,String port,String database);
	public String getQueryByPaging(String query,long start,long end);
	public String getDriver();
}
