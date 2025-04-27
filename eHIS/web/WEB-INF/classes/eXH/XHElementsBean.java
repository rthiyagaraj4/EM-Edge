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
 * Bean Class used to represent the XH Facility Inbound bean 
 *
 */
public class XHElementsBean 
{ 
  private String elementCode;
  private String elementDesc;
  private String inuseYN = "N";
  private String facilityYN = "N";
  private boolean changed = false;
 /**
   * Method gets inuse  
   * 
   */ 
 public void setChanged()
  {
    this.changed =  true;
  } 


  public String getInuse()
  {
    return (inuseYN);
  }
  
  /**
   * Method sets in use
   * @param  String str
   */
  public void setInuse(String str)
  {
    this.inuseYN = str;
  }
 
   /**
   * Method gets facility 
   * 
   */

  public String getFacility()
  {
    return (facilityYN);
  }
  /**
   * Method is sets facility
   * @param  String str
   */
  public void setFacility(String str)
  {
    this.facilityYN = str;
  }

/**
   * constructor XHElementsBean 
   * @param  String code
   * @param  String desc
   * @param  String inuse
   * @param  String facility
   */
  public XHElementsBean(String code,String desc,String inuse,String facility)
  {
    this.elementCode = code;
    this.elementDesc = desc;
    this.inuseYN = inuse;
	this.facilityYN = facility;
  }
  
   /**
   * Method gets mastercode 
   * 
   */
  public String getMasterCode()
  {
    return(this.elementCode);
  }
  /**
   * Method sets mastercode
   * @param  String str
   */
  public void setMasterCode(String str)
  {
    this.elementCode =  str;
  }
   /**
   * Method gets external description 
   * 
   */
	public String getDescription()
	{    
		return(this.elementDesc);
	}
  /**
   * Method sets description
   * @param  String str
   */
  public void setDescription(String str)
  {
	
    this.elementDesc = str;

  }
  
   /**
   * Method gets Arraydata 
   * @return ArrayList
   */

  public ArrayList getArrayData()
  {
    ArrayList arrList = new ArrayList(5);
    arrList.add(elementCode);
    arrList.add(elementDesc);
    arrList.add(this.inuseYN);
	arrList.add(this.facilityYN);
    return(arrList);
  }
  /**
   * Method gets Databasedata array 
   * @ return string array
   */
  public String[] getDatabaseData()
  {
    return (new String[]{"",this.elementDesc,this.elementCode,this.inuseYN,this.facilityYN});
  }
 /**
   * Method sets ischanged  
   * 
   */
  public boolean isChanged()
  {	   
    return(this.changed);
  }

}//end of class
