package com.bonc.dataplatform.bbdp.geniuspig.vertica.bean;

/**
 * pig column
 * @author dirk.zhang
 * Nov 6, 2012 3:21:54 PM
 */
public class PigColumn {
	private String name;
//	private String pigName;
	private String pigType;
	private String type;
	private int length;
	
	private static final String DEFAULTTYPE = "varchar(255)";
	private static final String DEFAULTPIGTYPE = "chararry";
	
	
//	public PigColumn(String name,String type){
//		this.name = name;
//		this.type = type;
//	}
//	
//	public PigColumn(String name,String type,int length){
//		this(name, type);
//		this.length = length;
//	}
	public PigColumn(){};
	
	public void setDBProperty(String name,String type){
		this.name = name;
		this.type = type;
	}
	public void setPigProperty(String name,String pigtype){
		this.name = name;
		this.pigType = pigtype;
	}
	
	public String getDBString() throws Exception{
		if(this.name == null)
			throw new Exception("违法列，无列名");
		if(this.type == null)
			return getDBFormat(this.name, DEFAULTTYPE);
		return getDBFormat(this.name, this.type);
	}
	
	public String getPigString() throws Exception{
		if(this.name == null)
			throw new Exception("违法列，无列名");
		if(this.pigType == null)
			return getPigFormat(name, DEFAULTPIGTYPE);
		return getPigFormat(name, pigType);
	}
	
	protected String getDBFormat(String name,String type){
		StringBuilder sb = new StringBuilder(name);
		sb.append(" ");
		sb.append(type);
		return sb.toString();
	}
	
	protected String getPigFormat(String name,String pigtype){
		StringBuilder sb = new StringBuilder(name);
		sb.append(":");
		sb.append(pigtype);
		return sb.toString();
	}
	
	public String getPigType() {
		return pigType;
	}
	public void setPigType(String pigType) {
		this.pigType = pigType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
}
