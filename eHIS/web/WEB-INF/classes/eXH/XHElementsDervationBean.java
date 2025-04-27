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
public class XHElementsDervationBean 
{ 
  private String elementCode;
  private String elementDesc;
  private String inuseYN = "N";
  private String derivation_type;
  private String condition_exp;
 private String expected_value; 
private String expected_value2;
private String execution_order;
private String position;
private String application_id;
private String profile_id;
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

  public String getDerivation()
  {
    return (derivation_type);
  }
  /**
   * Method is sets facility
   * @param  String str
   */
  public void setDerivation(String str)
  {
    this.derivation_type = str;
  }

/**
   * constructor XHElementsBean 
   * @param  String code
   * @param  String desc
   * @param  String inuse
   * @param  String facility
   */

  public XHElementsDervationBean(String Element_code,String Element_desc,String Dervation_type,String inuse,String condition_expr,String expected_value,String Excution_order,String Expected_value2,String position,String Application_id,String Profile_id)
  {
    this.elementCode = Element_code;
    this.elementDesc = Element_desc;
    this.inuseYN = inuse;
	this.derivation_type = Dervation_type;
 this.condition_exp=condition_expr;
 this.expected_value=expected_value; 
this.expected_value2=Expected_value2;
this.execution_order=Excution_order;
this.position=position;
this.application_id=Application_id;
this.profile_id=Profile_id;
  }
  
public String getProfile_id()
  {
    return(this.profile_id);
  }
  /**
   * Method sets mastercode
   * @param  String str
   */
  public void setProfile_id(String str)
  {
    this.profile_id =  str;
  }




public String getApplicationId()
  {
    return(this.application_id);
  }
  /**
   * Method sets mastercode
   * @param  String str
   */
  public void setApplicationId(String str)
  {
    this.application_id =  str;
  }





public String getPosition()
  {
    return(this.position);
  }
  /**
   * Method sets mastercode
   * @param  String str
   */
  public void setPosition(String str)
  {
    this.position =  str;
  }



public String getExecutionOrder()
  {
    return(this.execution_order);
  }
  /**
   * Method sets mastercode
   * @param  String str
   */
  public void setExecutionOrder(String str)
  {
    this.execution_order =  str;
  }



public String getExpectedValue2()
  {
    return(this.expected_value2);
  }
  /**
   * Method sets mastercode
   * @param  String str
   */
  public void setExpectedValue2(String str)
  {
    this.expected_value2 =  str;
  }





  public String getExpectedValue()
  {
    return(this.expected_value);
  }
  /**
   * Method sets mastercode
   * @param  String str
   */
  public void setExpectedValue(String str)
  {
    this.expected_value =  str;
  }





  public String getConditionExp()
  {
    return(this.condition_exp);
  }
  /**
   * Method sets Conditionexpression
   * @param  String str
   */
  public void setConditionExp(String str)
  {
    this.condition_exp =  str;
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
   // System.out.println("this.elementDesc"+this.elementDesc);
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

//	System.out.println("elementCode"+elementCode+"elementDesc"+elementDesc+"this.inuseYN"+this.inuseYN+"this.facilityYN"+this.derivation_type+this.condition_exp+this.expected_value+this.execution_order+this.expected_value2+this.position+this.application_id+this.profile_id);
    arrList.add(elementCode);
    arrList.add(elementDesc);
    arrList.add(this.derivation_type);
	arrList.add(this.inuseYN);
	 arrList.add(this.condition_exp);
	arrList.add(this.expected_value);
	 arrList.add(this.execution_order);
	arrList.add(this.expected_value2);
	 arrList.add(this.position);
	arrList.add(this.application_id);
	arrList.add(this.profile_id);
	






    return(arrList);
  }
  /**
   * Method gets Databasedata array 
   * @ return string array
   */
  public String[] getDatabaseData()
  {
    return (new String[]{"",this.elementDesc,this.elementCode,this.inuseYN,this.derivation_type,this.condition_exp,this.expected_value,this.execution_order,this.expected_value2,this.position,this.application_id,this.profile_id});
  }
 /**
   * Method sets ischanged  
   * 
   */
  public boolean isChanged()
  {

//	   System.out.println("varuthu"+this.changed);
    return(this.changed);
  }

}//end of class
