/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eXH;
import java.util.ArrayList;
/**
 * Bean Class used to represent the XH Facility 
 *
 */
public class XHFacilityBean 
{ 
  private String applnId;
  private String applnName;
  private String facilityId;
  private String facilityName;
  private String inuseYN ;
  private String protocolLinkId;
  private String protocolLinkName;
  private String status;
  private String reportOPDir;
  private String protocolId;
 
 /**
   * constructor XHFacilityBean 
   * @param  String code
   * @param  String desc
   * @param  String inuse
   * @param  String facility
   * @param  String inuseYN
   * @param  String protocolLinkId
   */
  public XHFacilityBean(String code,String desc,String inuseYN,String protocolLinkId,String protocolLinkName,String status,String reportOPDir,String protocolId)
  {
    this.applnId = code;
    this.applnName = desc;
	this.facilityId = "XX";
//	this.facilityName = facility;
	this.inuseYN = inuseYN;
	this.protocolLinkId = protocolLinkId;
	this.protocolLinkName = protocolLinkName;
	this.status = status;
	this.reportOPDir = reportOPDir;
	this.protocolId=protocolId;
  }
  
  /**
   * Method  gets Arraydata 
   * @return ArrayList
   */
  public ArrayList getArrayData()
  {
    ArrayList arrList = new ArrayList(9);
    arrList.add(applnId);
    arrList.add(applnName);
	arrList.add(facilityId);
	arrList.add(facilityName);
    arrList.add(this.inuseYN);
	arrList.add(this.protocolLinkId);
	arrList.add(this.protocolLinkName);	
	arrList.add(this.status);
	arrList.add(this.reportOPDir);
	arrList.add(this.protocolId);   
	return(arrList);
  }

 /**
   * Method gets inuse 
   * 
   */

   public String getInuse()
  {
    return (inuseYN);
  }
  
  /**
   * Method  sets in use
   * @param  String str
   */
  
  public void setInuse(String str)
  {
    this.inuseYN = str;
  }
  
  /**
   * Method gets application 
   * 
   */
  
  public String getAppln()
  {
    return (applnId);
  }
  
  /**
   * Method sets in use
   * @param  String str
   */
  
  public void setAppln(String str)
  {
    this.applnId = str;
  }
  
  /**
   * Method  gets facility
   * 
   */
   public String getFacility()
  {
    return (facilityId);
  }
 
  /**
   * Method  sets facility
   * @param  String str
   */
  public void setFacility(String str)
  {
    this.facilityId = str;
  }
  /**
   * Method  gets Databasedata array 
   * @ return string array
   */
public String[] getDatabaseData()
  {
    return (new String[]{this.applnId,this.applnName,this.facilityId,this.facilityName,getInuse(),this.protocolLinkId,this.reportOPDir,this.protocolId});	    
  }
   /**
   * Method  gets protocol link id
   */
   public String getProtocolLinkID()
  {
    return (protocolLinkId);
  }
 
  /**
   * Method  sets protocol link id
   * @param  String str
   */
  public void setProtocolLinkID(String str)
  {
    this.protocolLinkId = str;
  }	

    /**
   * Method  gets protocol  id
   */
   public String getProtocolID()
  {
    return (this.protocolId);
  }																	   
 
  /**
   * Method  sets protocol link id
   * @param  String str
   */
  public void setProtocolID(String str)
  {
    this.protocolId = str;
  }	


																		  
   /**
   * Method  gets report output directory
   */
   public String getReportOPDirectory()
  {
    return (reportOPDir);
  }
 
  /**
   * Method  sets report output directory
   * @param  String str
   */
  public void setReportOPDirectory(String str)
  {
    this.reportOPDir = str;
  }	
  
}//end of class
