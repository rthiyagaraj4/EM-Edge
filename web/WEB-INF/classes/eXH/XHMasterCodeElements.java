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
 * Bean Class used to represent the master code elements 
 *
 */
public class XHMasterCodeElements 
{ 
  
  private String externalCode="";
  private String externalDesc = "";
  private String code;
  private String desc;
  private boolean presentInXH = false;
  private boolean changed = false;
 
 /**
   * This method is returns the changed flag
   * 
   */
  public boolean getChanged()
  {
    return (changed);
  }
   /**
   * This method is sets changed flag
   * 
   */
  public void setChanged()
  {
    changed = true;
  }
   /**
   * constructor XHMasterCodeElements 
   * @param  String code
   * @param  String desc
   */
  public XHMasterCodeElements(String code,String desc)
  {
    this.code = code;
    this.desc = desc;
  }
   /**
   * This method gets mastercode 
   * 
   */
  public String getMasterCode()
  {
    return(this.code);
  }
   /**
   * This method is gets dsescription 
   * 
   */
  public String getDescription()
  {
    return(this.desc);
  }
   /**
   * This method is sets master code 
   * @param  String str
   */
  public void setMasterCode(String str)
  {
    this.code =  str;
  }
   /**
   * This method is sets description 
   * @param  String str
   */
  public void setDescription(String str)
  {
    this.desc = str;
  }
   /**
   * This method is sets  xhpresent 
   * 
   */
  public void setXHPresent()
  {
    this.presentInXH = true;
  }
   /**
   * This method gets  xhpresent
   * 
   */
  public boolean getXHPresent()
  {
    return(this.presentInXH);
  }
   /**
   * This method is sets external code 
   * @param  String str
   */
  public void setExternalCode(String str)
  {
    this.externalCode = str;
    
  }
   /**
   * This method is sets external description 
   * @param  String str
   */
  public void setExternalDesc(String str)
  {
    this.externalDesc = str;
    
  }
   /**
   * This method is gets external code 
   * 
   */
  public String getExternalCode()
  {
    return(this.externalCode);
    
  }
   /**
   * This method is gets external description 
   * 
   */
  public String getExternalDesc()
  {
    return(this.externalDesc);
  }
   /**
   * This method is gets Arraydata 
   * @return ArrayList
   */
  public ArrayList getArrayData()
  {
    ArrayList arrList = new ArrayList(5);
    arrList.add(code);
    arrList.add(desc);
    arrList.add(externalCode);
    arrList.add(externalDesc);
    return(arrList);
  }
   /**
   * This method is gets Databasedata array 
   * @ return string array
   */
  public String[] getDatabaseData()
  {
    String str[] = new String[]{"","","","",code,this.externalCode,this.externalDesc};
    return(str);
  }
}//end of class
