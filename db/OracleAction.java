package com.bonc.dataplatform.bbdp.geniuspig.vertica.db;

/**
 * oracle
 * @author dirk.zhang
 * Nov 6, 2012 3:23:56 PM
 */
public class OracleAction implements IDBAction {
	
//	@Override
//	public String setHost(String host) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String setPort(String port) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String setUserName(String username) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String setPassWord(String password) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public String getDriver() {
		return "oracle.jdbc.driver.OracleDriver";
	}

	@Override
	public String getJdbcURL(String host, String port, String database) {
		StringBuilder sb = new StringBuilder();
		sb.append("jdbc:oracle:thin:@");
		sb.append(host);
		sb.append(":");
		sb.append(port);
		sb.append(":");
		sb.append(database);
		return sb.toString();
	}

	@Override
	public String getQueryByPaging(String query, long start, long end) {
		StringBuilder sb = new StringBuilder();
		sb.append("select * from(select t.*, rownum rn from (");
		sb.append(query);
		sb.append(") t where rownum <= ");
		sb.append(String.valueOf(end));
		sb.append(" )where rn >= ");
		sb.append(String.valueOf(start));
		return sb.toString();
	}
}
