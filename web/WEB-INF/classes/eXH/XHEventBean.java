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

public class XHEventBean 
{ 
  private String formatType = "H";
  private String eventCode;
  private String eventDesc;
  private String inuseYN = "N";  
  private String elementValue = "";
  private String clr = "";
  private String translate_entity = "";
  private String ehis_entity = "";
  private String concatenate_Attributes = "";
  private String Translate_query = "";




  private boolean changed = false;

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
   * Method gets format type
   * 
   */
  public String getFormatType()
  {
    return (formatType);
  }

/**
   * Method sets format type
   * @param  String str
   */

  public void setFormatType(String str)
  {
    this.formatType = str;
  }




public String getTranslateEntity()
  {
    return (translate_entity);
  }

/**
   * Method sets translateentity
   * @param  String str
   */

  public void setTranslateEntity(String str)
  {
   this.translate_entity = str;
  }

public String getehisEntity()
  {
    return (ehis_entity);
  }

/**
   * Method sets ehisentity
   * @param  String str
   */

  public void setehisEntity(String str)
  {
   this.ehis_entity = str;
  }





public String getconAttribute()
  {
    return (concatenate_Attributes);
  }

/**
   * Method sets ehisentity
   * @param  String str
   */

  public void setconAttribute(String str)
  {
   this.concatenate_Attributes = str;
  }


public String getTranslateQuery()
  {
    return (Translate_query);
  }

/**
   * Method sets ehisentity
   * @param  String str
   */

  public void setTranslateQuery(String str)
  {
   this.Translate_query = str;
  }

/**
   * constructor XHApplicationElementsBean 
   * @param  String code
   * @param  String desc
   * @param  String inuse
   * @param  String facility
   * @param  String inuseYN
   */  
   public XHEventBean(String code,String desc,String Inuse)
   {
     this.eventCode = code;
     this.eventDesc = desc;
     this.inuseYN =Inuse;
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
    return(this.eventCode);
  }
   /**
   * Method gets  description 
   * 
   */
  public String getDescription()
  {
    return(this.eventDesc);
  }
  /**
   * Method sets mastercode
   * @param  String str
   */
  public void setMasterCode(String str)
  {
    this.eventCode =  str;
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
    this.eventDesc = str;
  }
/**
   * Method gets Arraydata 
   * @return ArrayList
   */  
   public ArrayList getDatabaseArrayData(String applid)
   {
     ArrayList arrList = new ArrayList(6);
     arrList.add(applid);
     arrList.add(eventCode);
     arrList.add(formatType);
     arrList.add(this.inuseYN);
     arrList.add(this.elementValue);
	 arrList.add(this.clr);
     return(arrList);
    
   }
/**
   * Method gets Arraydata 
   * @return ArrayList
   */
  public ArrayList getArrayData()
  {
    ArrayList arrList = new ArrayList(9);
    
    arrList.add(eventCode);
    arrList.add(eventDesc);
	arrList.add(this.inuseYN);
    return(arrList);
  }
/**
   * Method gets Databasedata array 
   * @ return string array
   */
   public String[] getDatabaseData()
  {
	   

    return(new String[]{"",this.eventCode,this.eventDesc,this.inuseYN});
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
