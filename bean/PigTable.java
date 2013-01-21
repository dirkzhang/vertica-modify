package com.bonc.dataplatform.bbdp.geniuspig.vertica.bean;

import java.util.LinkedList;
import java.util.List;

/**
 * pig structure
 * 
 * @author dirk.zhang Nov 6, 2012 3:22:37 PM
 */
public class PigTable {
	List<PigColumn> itemList = new LinkedList<PigColumn>();
	private String tableName;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public PigTable() {
	}

	/**
	 * 添加列
	 * 
	 * @param name
	 * @param type
	 */
	public void addColumn(String name, String type) {
		PigColumn column = new PigColumn();
		column.setDBProperty(name, type);
		itemList.add(column);
	}

	/**
	 * 添加列
	 * 
	 * @param name
	 * @param pigtype
	 */
	public void addPig(String name, String pigtype) {
		PigColumn column = new PigColumn();
		column.setPigProperty(name, pigtype);
		itemList.add(column);
	}

	/**
	 * 获得db格式信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getDBColumns() throws Exception {
		StringBuilder sb = new StringBuilder();
		for (PigColumn pc : itemList) {
			sb.append(pc.getDBString());
			sb.append(",");
		}
		return sb.substring(0, sb.length() - 1);
	}

	public String getTable() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("tableinfo{");
		sb.append(this.tableName);
		sb.append("(");
		sb.append(this.getDBColumns());
		sb.append(")}");
		return sb.toString();
	}

	/**
	 * 获得pig格式信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getPigColumns() throws Exception {
		StringBuilder sb = new StringBuilder();
		for (PigColumn pc : itemList) {
			sb.append(pc.getPigString());
			sb.append(",");
		}
		return sb.substring(0, sb.length() - 1);
	}

	/**
	 * 获得schemal
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getSchemal() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append(" as (");
		sb.append(this.getPigColumns());
		sb.append(")");
		return sb.toString();
	}

}
