/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.vitals.healthobject;

public class ChartCombo implements java.io.Serializable{
	 
	private static final long serialVersionUID = 1L;
	private String refRangeDesc;
	private String normAbnormIndicator;
	private String dfltYN;
	private String refRangeSeq;
	/**
	 * @return the refRangeDesc 
	 */
	public String getRefRangeDesc() {
		return refRangeDesc;
	}
	/**
	 * @param refRangeDesc the refRangeDesc to set
	 */
	public void setRefRangeDesc(String refRangeDesc) {
		this.refRangeDesc = refRangeDesc;
	}
	/**
	 * @return the normAbnormIndicator
	 */
	public String getNormAbnormIndicator() {
		return normAbnormIndicator;
	}
	/**
	 * @param normAbnormIndicator the normAbnormIndicator to set
	 */
	public void setNormAbnormIndicator(String normAbnormIndicator) {
		this.normAbnormIndicator = normAbnormIndicator;
	}
	/**
	 * @return the dfltYN
	 */
	public String getDfltYN() {
		return dfltYN;
	}
	/**
	 * @param dfltYN the dfltYN to set
	 */
	public void setDfltYN(String dfltYN) {
		this.dfltYN = dfltYN;
	}
	/**
	 * @return the refRangeSeq
	 */
	public String getRefRangeSeq() {
		return refRangeSeq;
	}
	/**
	 * @param refRangeSeq the refRangeSeq to set
	 */
	public void setRefRangeSeq(String refRangeSeq) {
		this.refRangeSeq = refRangeSeq;
	}
}
