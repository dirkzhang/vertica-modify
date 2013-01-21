package com.bonc.dataplatform.bbdp.geniuspig.vertica.bean;

/**
 * pig udf store
 * @author dirk.zhang
 * Nov 6, 2012 3:22:25 PM
 */
public class PigStore {

	PigClass pcl;
	PigTable pt;
	public PigStore(PigClass pcl , PigTable pt){
		this.pcl = pcl;
		this.pt = pt;
	}
	
	public String toString(String param){
		StringBuilder sb = new StringBuilder();
		try {
			sb.append("store ");
			sb.append(param);
			sb.append(" into '");
			sb.append(pt.getTable());
			sb.append("' using ");
			sb.append(pcl.toString());
			sb.append(";");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return sb.toString();
		
	}
	
}
