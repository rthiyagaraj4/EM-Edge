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
 
public class XHEventForApplicationElementsBean 
{ 
  private String MastType ;
  private String elementCode;
  private String elementDesc; 
    private String stndCode;
  private String stndDesc;
  private String DTLType;
  private String Msgtype;
  private String inuseYN ;  
  private String status = "";
 private String fieldchange="N";



  private boolean changed = false;

 /**
   * Method sets changed boolean value
   * 
   */
 
   public void setChanged()
  {
    this.changed =  true;
  }




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

/**
   * Method sets elementsvalue
   * @param  String str
   */
  
  public void setMsgtype(String str)
  {
    this.Msgtype = str;
  }

/**
   * Method gets element's value
   * 
   */

  public String getMsgtype()   
  {
    return(this.Msgtype);
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
  public String getMastType()
  {
    return (this.MastType);
  }

/**
   * Method sets format type
   * @param  String str
   */

  public void setMastType(String str)
  {
   this.MastType = str;
  }




public String getstndDesc()
  {
    return (stndDesc);
  }

/**
   * Method sets translateentity
   * @param  String str
   */

  public void setstndDesc(String str)
  {
   this.stndDesc = str;
  }

public String getStandardCode()
  {
    return (this.stndCode);
  }

/**
   * Method sets ehisentity
   * @param  String str
   */

	 
	


  public void setStandardCode(String str)
  {
   this.stndCode = str;
  }





public String getStatus()
  {
    return (status);
  }

/**
   * Method sets status
   * @param  String str
   */

  public void setStatus(String str)
  {
   this.status = str;
  }




/**
   * constructor XHMsgForApplicationElementsBean 
   * @param  String code
   * @param  String desc
   * @param  String inuse
   * @param  String facility
   * @param  String inuseYN
   */  
   public XHEventForApplicationElementsBean(String code,String desc,String standcode,String msgtype,String inuse,String dtltype,String standdesc,String masttype,String status,String fieldchange)
   {


     this.elementCode = code;
     this.elementDesc = desc;
     this.inuseYN = inuse;
     this.MastType = masttype;
     this.stndCode = standcode;
	 this.DTLType = dtltype;
	 this.stndDesc=standdesc;
	this.Msgtype=msgtype;
	this.status=status;
this.fieldchange=fieldchange;
   }
 /**
   * Method gets clr
   * 
   */  public String getDTLType()
  {
    return(this.DTLType);
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
   public void setDTLType(String clr)
  {
     this.DTLType =  clr;
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
   arrList.add(elementCode);
    arrList.add(elementDesc);
    arrList.add(stndCode);
    arrList.add(Msgtype);
    arrList.add(MastType);
	arrList.add(inuseYN);
     return(arrList);
  
   }
/**
   * Method gets Arraydata 
   * @return ArrayList
   */
  public ArrayList getArrayData()
  {
    ArrayList arrList = new ArrayList(9);
    arrList.add(elementCode);
    arrList.add(elementDesc);
    arrList.add(stndCode);
    arrList.add(Msgtype);
    arrList.add(MastType);
	arrList.add(inuseYN);
    arrList.add(DTLType);
    arrList.add(status);
    arrList.add(stndDesc);
	arrList.add(fieldchange); 

    return(arrList);
  }
/**
   * Method gets Databasedata array 
   * @ return string array
   */  
   public String[] getDatabaseData()
  {
 
    return(new String[]{"",this.elementCode,this.elementDesc,this.inuseYN, this.DTLType,this.fieldchange});
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
