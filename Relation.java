/* Copyright (c) 2005 - 2012 Vertica, an HP company -*- Java -*- */
package com.bonc.dataplatform.bbdp.geniuspig.vertica;

public class Relation {
	private String table = null;
	private String database = null;
	private boolean defSchema = false;

	public Relation(String name) {
		if (name == null) return;

		String[] splut = name.split("\\.");

		if (splut.length == 3) {
			database = splut[0];
			table = splut[2];
		} else if (splut.length == 2) {
			table = splut[1];
		} else if (splut.length == 1) {
			defSchema = true;
			table = splut[0];
		}
	}

	public boolean isNull() {
		return table == null;
	}

	public boolean isDefaultSchema() {
		return defSchema;
	}

	public String getDatabase() {
		return database;
	}

	public String getSchema() {
		return "";
//		return schema;
	}

	public String getTable() {
		return table;
	}

	public StringBuilder getQualifiedName() {
		StringBuilder sb = new StringBuilder();
		if (database != null) {
			sb.append(database);
			sb.append('.');
		}

//		sb.append(schema);
//		sb.append('.');
		sb.append(table);

		return sb;
	}
}
