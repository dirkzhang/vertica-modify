package com.bonc.dataplatform.bbdp.geniuspig.vertica.bean;

/**
 * pig udf
 * @author dirk.zhang
 * Nov 6, 2012 3:21:40 PM
 */
public class PigClass {
	private Class<?> classname;
	private String[] params;
	public PigClass(Class<?> classtype,String...params){
		this.classname = classtype;
		this.params = params;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(classname.getName());
		sb.append("(");
		if(params != null){
			StringBuilder sbp = new StringBuilder();
			for (int i = 0; i < params.length; i++) {
				String param = params[i];
				if(param == null || "".equals(param))
					continue;
				sbp.append("'");
				sbp.append(param);
				sbp.append("',");
			}
			if(sbp.toString().endsWith(","))
				sb.append(sbp.substring(0, sbp.length()-1));
		}
		sb.append(")");
		return sb.toString();
	};

}
