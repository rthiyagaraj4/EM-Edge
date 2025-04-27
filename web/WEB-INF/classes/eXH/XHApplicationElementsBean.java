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

public class XHApplicationElementsBean 
{ 
  private String formatType = "H";
  private String elementCode;
  private String elementDesc;
  private String inuseYN = "N";  
  private String elementValue = "";
  private String clr = "";
  private String translate_entity = "";
  private String ehis_entity = "";
  private String concatenate_Attributes = "";
  private String Translate_query = "";
private String fieldchange="N";
 private String Masterid="";


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
   public void setFieldchange(String str)
  {
    this.fieldchange = str;
  }

/**
   * Method gets element's value
   * 
   */ 

  public String getFieldchange()   
  {
    return(this.fieldchange);
  } 
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
   public XHApplicationElementsBean(String code,String desc,String formatType,String inuse,String elementValue,String clr,String translateentity,String ehisentity,String concateattr,String translateqry,String Masterid,String fieldchange)
   {
     this.elementCode = code;
     this.elementDesc = desc;
     this.inuseYN = inuse;
     this.formatType = formatType;
     this.elementValue = elementValue;
	 this.clr = clr;
	 this.translate_entity=translateentity;
	this.ehis_entity=ehisentity;
	this.concatenate_Attributes=concateattr;
	this.Translate_query=translateqry;
	this.Masterid=Masterid;
	this.fieldchange=fieldchange; 
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
     arrList.add(elementCode);
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
    ArrayList arrList = new ArrayList(10);
    
    arrList.add(elementCode);
    arrList.add(elementDesc);
    arrList.add(formatType);
    arrList.add(this.inuseYN);
    arrList.add(this.elementValue);
	arrList.add(this.clr);
    arrList.add(translate_entity);
    arrList.add(ehis_entity);
    arrList.add(concatenate_Attributes);
	arrList.add(Translate_query);
	arrList.add(Masterid);
	arrList.add(fieldchange);
    return(arrList);
  }
/**
   * Method gets Databasedata array 
   * @ return string array
   */
   public String[] getDatabaseData()
  {
    return(new String[]{"",this.elementCode,this.inuseYN, this.formatType,this.elementValue,translate_entity,ehis_entity,concatenate_Attributes,Translate_query,this.fieldchange});
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
