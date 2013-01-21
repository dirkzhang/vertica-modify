package com.bonc.dataplatform.bbdp.geniuspig.vertica.db;

/**
 * mysql
 * @author dirk.zhang
 * Nov 6, 2012 3:23:47 PM
 */
public class MysqlAction implements IDBAction {

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
		return "com.mysql.jdbc.Driver";
	}

	@Override
	public String getJdbcURL(String host, String port, String database) {
		StringBuilder sb = new StringBuilder();
		sb.append("jdbc:mysql://");
		sb.append(host);
		sb.append(":");
		sb.append(port);
		sb.append("/");
		sb.append(database);
		sb.append("?useUnicode=true&characterEncoding=utf8");
		return sb.toString();
	}

	@Override
	public String getQueryByPaging(String query, long start, long end) {
		return queryByPaing(query, start, end);
	}
	
	
	/**
	 * low effience
	 * @param query
	 * @param start
	 * @param end
	 * @return
	 */
	@Deprecated
	private String queryByPaing(String query,long start,long end){
		StringBuilder sb = new StringBuilder();
		long length = end - start;
		sb.append(query);
		sb.append(" limit ");
		sb.append(start);
		sb.append(",");
		sb.append(length);
		return sb.toString();
	}
	
	/**
	 * effient query by paging
	 * @param query
	 * @param start
	 * @param end
	 * @return
	 */
	public String effientQueryByPaing(String query,long start,long end){
		StringBuilder sb = new StringBuilder();
		long length = end - start +1;
		int whereIndex = query.lastIndexOf("where");
		sb.append(query.substring(0, whereIndex+5)+"("+query.substring(whereIndex+5));
		sb.append(" and id >= ");
		sb.append(start);
		sb.append(" ) limit ");
		sb.append(length);
		System.out.println(sb.toString());//TODO: for test
		return sb.toString();
	}
	
	public static void main(String[] args) {
		MysqlAction a = new MysqlAction();
		a.effientQueryByPaing("1234where5678", 10, 20);
	}

	
	
	
	
	
	
	
	
	
	
	


}
