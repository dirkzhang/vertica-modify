package com.bonc.dataplatform.bbdp.geniuspig.vertica.db;

/**
 * db2
 * @author dirk.zhang
 * Nov 6, 2012 3:23:07 PM
 */
public class DB2Action implements IDBAction {

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
		return "com.ibm.db2.jdbc.net.DB2Driver";
	}

	@Override
	public String getJdbcURL(String host, String port, String database) {
		StringBuilder sb = new StringBuilder();
		sb.append("jdbc:db2://");
		sb.append(host);
		sb.append(":");
		sb.append(port);
		sb.append("/");
		sb.append(database);
		return sb.toString();
	}

	@Override
	public String getQueryByPaging(String query, long start, long end) {
		StringBuilder sb = new StringBuilder();
		sb.append("select * from( select t.*, rownumber() over() as rowid from (");
		sb.append(query);
		sb.append(")t )t1 where t1.rowid >=");
		sb.append(start);
		sb.append(" and t1.rowid <=");
		sb.append(end);
		return sb.toString();
	}

}
