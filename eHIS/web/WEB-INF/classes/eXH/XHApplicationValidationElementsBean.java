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
 * Bean Class used to represent the XHApplicationElementsBean
 *
 */

public class XHApplicationValidationElementsBean
{ 
  private String validationType = "IF";
  private String elementCode;
  private String elementDesc;
  private String inuseYN = "N";
  private String elementValue = "";
  private String clr = "";
  private boolean changed = false;
  private String condition = "";
  private String actionvalue = "";
  private String execOrder = "";
private String errortext = "";
private String position = "";
private String profile = "";
private String application_id="";
 /**
   * Method sets changed boolean value
   * 
   */
 
   public void setChanged()
  {
    this.changed =  true;
  }

/**
   * Method sets elementsvalue
   * @param  String str
   */
  
  public void setElementValue(String str)
  {
    this.elementValue = str;
  }

/**
   * Method gets element's value
   * 
   */
 public String getApplicationId()
   {
    return (this.application_id);
   }
/**
   * Method sets in use
   * @param  String str
   */
    public void setApplicationId(String str)
    {
       this.application_id = str;
     }


   public String getElementValue()
  {
    return(this.elementValue);
  }

/**
   * Method gets in use
   * 
   */
   public String getInuse()
   {
    return (this.inuseYN);
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
   * Method gets format type
   * 
   */
  public String getFormatType()
  {
    return (this.validationType);
  }

/**
   * Method sets format type
   * @param  String str
   */

  public void setFormatType(String str)
  {
    this.validationType = str;
  }

  /**
   * Method sets condition value
   * @param  String str
   */
  
  public void setCondition(String str)
  {
    this.condition = str;
//System.out.println("this.condition"+this.condition);

  }

/**
   * Method gets condition's value
   * 
   */

  public String getCondition()
  {
    return(this.condition);
  }
    /**
   * Method sets expectedValue
   * @param  String str
   */
  
  public void setActionValue(String str)
  {
    this.actionvalue = str;
  }
public void setErrorText(String str)
  {
    this.errortext = str;
  }
/**
   * Method gets expectedValue's value
   * 
   */

  public String getActionValue()
  {
    return(this.actionvalue);
  }


public String getErrorText()
  {
    return(this.errortext);
  }
      /**
   * Method sets expectedValue
   * @param  String str
   */
  
  public void setExecOrder(String str)
  {
	  this.execOrder = str;
   
  }

/**
   * Method gets expectedValue's value
   * 
   */

  public String getExecOrder()
  {
    return(this.execOrder);
  }

public void setPosition(String str)
  {
    this.position = str;
  }

  
public String getPosition()
  {
    return(this.position);
  }


 
/**
   * constructor XHApplicationElementsBean 
   * @param  String code
   * @param  String desc
   * @param  String inuse
   * @param  String facility
   * @param  String inuseYN
   */  
   public XHApplicationValidationElementsBean(String code,String desc,String validationType,String inuse,String condition,String action,String execOrder,String error_text,String position,String Application_id)
   {
     this.elementCode = code;
     this.elementDesc = desc;
     this.inuseYN = inuse;
     this.validationType = validationType;
     this.condition = condition;
	 this.actionvalue = action;
	 this.execOrder = execOrder;
    this.errortext = error_text;
   this.position = position;
   this.application_id=Application_id;
  

   }
 /**
   * Method gets clr
   * 
   */  public String getClr()
  {
    return(this.clr);
  }
   /**
   * Method gets mastrer coden 
   * 
   */
  public String getMasterCode()
  {
    return(this.elementCode);
  }
   /**
   * Method gets  description 
   * 
   */
  public String getDescription()
  {
    return(this.elementDesc);
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
   * Method sets clr
   * @param  String str
   */
   public void setClr(String clr)
  {
    this.clr =  clr;
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
   public ArrayList getDatabaseArrayData(String applid)
   {
     ArrayList arrList = new ArrayList(6);
     arrList.add(applid);
     arrList.add(this.elementCode);
     arrList.add(this.validationType);
     arrList.add(this.inuseYN);
     arrList.add(this.actionvalue);
	 arrList.add(this.execOrder);
	 arrList.add(this.condition);
     return(arrList);
    
   }
/**
   * Method gets Arraydata 
   * @return ArrayList
   */
  public ArrayList getArrayData()
  {
    ArrayList arrList = new ArrayList(12);
//System.out.println(this.elementCode+","+this.elementDesc+","+this.inuseYN+","+this.validationType+","+this.actionvalue+","+this.execOrder+","+this.condition+","+this.errortext+","+this.position+"this.application_id"+this.application_id+"end");    
    arrList.add(this.elementCode);
    arrList.add(this.elementDesc);
    arrList.add(this.validationType);
    arrList.add(this.inuseYN);
    arrList.add(this.actionvalue);
	arrList.add(this.execOrder);
	arrList.add(this.condition);
	arrList.add(this.errortext);
		arrList.add(this.position);
arrList.add(this.application_id);
	


    return(arrList);
  }
/**
   * Method gets Databasedata array 
   * @ return string array
   */
   public String[] getDatabaseData()
	{



//System.out.println(this.elementCode+","+this.elementDesc+","+this.inuseYN+","+this.validationType+","+this.actionvalue+","+this.execOrder+","+this.condition+","+this.errortext+","+this.position+"this.application_id"+this.application_id+"end");

   return(new String[]{"",this.elementCode,this.elementDesc,this.inuseYN, this.validationType,this.actionvalue,this.execOrder,this.condition,this.errortext,this.position,this.application_id});
  }
 /**
   * Method sets ischanged  
   * 
   */
  public boolean isChanged()
  {
	
    return(this.changed);
  }
}
//end of class
