package com.bonc.dataplatform.bbdp.geniuspig.vertica.db;

/**
 * sqlserver
 * @author dirk.zhang
 * Nov 6, 2012 3:24:05 PM
 */
public class SQLServerAction implements IDBAction {

	// @Override
	// public String setHost(String host) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public String setPort(String port) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public String setUserName(String username) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public String setPassWord(String password) {
	// // TODO Auto-generated method stub
	// return null;
	// }

	private int driverType = 1;
	private int dbVersion = 2012;

	public int getDbVersion() {
		return dbVersion;
	}

	public void setDbVersion(int dbVersion) {
		this.dbVersion = dbVersion;
	}

	public int getDriverType() {
		return driverType;
	}

	public void setDriverType(int driverType) {
		this.driverType = driverType;
	}

	@Override
	public String getDriver() {
		if (driverType == 1)
			return "net.sourceforge.jtds.jdbc.Driver";
		else
			return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	}

	@Override
	public String getJdbcURL(String host, String port, String database) {
		if (driverType == 1)
			return getJTDSURL(host, port, database);
		else
			return getMicrosoftJDBCURL(host, port, database);
	}

	/**
	 * jtds的jdbcurl
	 * @param host
	 * @param port
	 * @param database
	 * @return
	 */
	private String getJTDSURL(String host, String port, String database) {
		StringBuilder sb = new StringBuilder();
		sb.append("jdbc:jtds:sqlserver://");
		sb.append(host);
		sb.append(":");
		sb.append(port);
		sb.append("/");
		sb.append(database);
		return sb.toString();
	}

	/**
	 * 微软提供的jdbc，微软有bugurl
	 * @param host
	 * @param port
	 * @param database
	 * @return
	 */
	@Deprecated
	private String getMicrosoftJDBCURL(String host, String port, String database) {
		StringBuilder sb = new StringBuilder();
		sb.append("jdbc:sqlserver://");
		sb.append(host);
		sb.append(":");
		sb.append(port);
		sb.append("; DatabaseName=");
		sb.append(database);
		return sb.toString();
	}

	@Override
	public String getQueryByPaging(String query, long start, long end) {
		if (this.dbVersion == 2012) 
			return getQuery2012(query, start, end);
		else
			return getQueryByRowNum(query, start, end);
	}
	
	/**
	 * sqlserver 2012 之前用rownum
	 * @param query
	 * @param start
	 * @param end
	 * @return
	 */
	private String getQueryByRowNum(String query, long start, long end) {
		StringBuilder sb = new StringBuilder();
		sb.append("select * from( select top ");
		sb.append(end);
		sb.append(" row_number() over(order by id) rn,* from ( ");
		sb.append(query);
		sb.append(" ))t where");
		sb.append(" t.rn >=");
		sb.append(start);
		return sb.toString();
	}
	
	private String getQuery2012(String query, long start, long end) {
		StringBuilder sb = new StringBuilder();
		long length = end - start +1;
		sb.append(query);
		sb.append(" OFFSET ");
		sb.append(start);
		sb.append(" ROWS FETCH NEXT ");
		sb.append(length);
		sb.append(" ROWS ONLY");
		return sb.toString();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
