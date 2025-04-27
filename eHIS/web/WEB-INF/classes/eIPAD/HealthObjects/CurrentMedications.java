/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.HealthObjects;
import java.io.*;
public class CurrentMedications implements java.io.Serializable{
	
	private String sCurrentMedCount;
	private String sOrderID;
	private String sQuantity;
	private String sOrderedBy;
	private String sPriority;
	private String sOrderCatalog;
	private String sDrugDesc;
	private String sCatalogDesc;
	
	public String getsCatalogDesc() {
		return sCatalogDesc;
	}
	public void setsCatalogDesc(String sCatalogDesc) {
		this.sCatalogDesc = sCatalogDesc;
	}
	public String getsDrugDesc() {
		return sDrugDesc;
	}
	public void setsDrugDesc(String sDrugDesc) {
		this.sDrugDesc = sDrugDesc;
	}
	/**
	 * @return the sOrderCatalog
	 */
	public String getsOrderCatalog() {
		return sOrderCatalog;
	}
	/**
	 * @param sOrderCatalog the sOrderCatalog to set
	 */
	public void setsOrderCatalog(String sOrderCatalog) {
		this.sOrderCatalog = sOrderCatalog;
	}
	public String getsOrderID() {
		return sOrderID;
	}
	public void setsOrderID(String sOrderID) {
		this.sOrderID = sOrderID;
	}
	public String getsQuantity() {
		return sQuantity;
	}
	public void setsQuantity(String sQuantity) {
		this.sQuantity = sQuantity;
	}
	public String getsOrderedBy() {
		return sOrderedBy;
	}
	public void setsOrderedBy(String sOrderedBy) {
		this.sOrderedBy = sOrderedBy;
	}
	public String getsPriority() {
		return sPriority;
	}
	public void setsPriority(String sPriority) {
		this.sPriority = sPriority;
	}
	
	
	
	/**
	 * @return the sCurrentMedCount
	 */
	public String getsCurrentMedCount() {
		return sCurrentMedCount;
	}
	/**
	 * @param sCurrentMedCount the sCurrentMedCount to set
	 */
	public void setsCurrentMedCount(String sCurrentMedCount) {
		this.sCurrentMedCount = sCurrentMedCount;
	}
}
