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
public class ChartType implements java.io.Serializable
{
  private String sChartId;
  private String sChartDesc;
/**
 * @return the sChartId
 */
public String getChartId() {
	return sChartId;
}
/**
 * @param sChartId the sChartId to set
 */
public void setChartId(String sChartId) {
	this.sChartId = sChartId;
}
/**
 * @return the sChartDesc
 */
public String getChartDesc() {
	return sChartDesc;
}
/**
 * @param sChartDesc the sChartDesc to set
 */
public void setChartDesc(String sChartDesc) {
	this.sChartDesc = sChartDesc;
}
  
}
