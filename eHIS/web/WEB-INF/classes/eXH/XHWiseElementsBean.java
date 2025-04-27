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

public class XHWiseElementsBean 
{ 
  private String segment_seq ;
  private String elementCode;
  private String elementDesc;
    private String stndCode;
  private String stndDesc;
  private String event_type;
  private String optio_yn; 
  private String inuseYN ;  
  private String file_control_type = "";
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


  public void setMsgtype(String str)
  {
    this.optio_yn = str;
  }

/**
   * Method gets element's value
   * 
   */

  public String getMsgtype()   
  {
    return(this.optio_yn);
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
    return (this.segment_seq);
  }

/**
   * Method sets format type
   * @param  String str
   */

  public void setMastType(String str)
  {
   this.segment_seq = str;
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
    return (file_control_type);
  }

/**
   * Method sets file_control_type
   * @param  String str
   */

  public void setStatus(String str)
  {
   this.file_control_type = str;
  }




/**
   * constructor XHMsgForApplicationElementsBean 
   * @param  String code
   * @param  String desc
   * @param  String inuse
   * @param  String facility
   * @param  String inuseYN
   */  
	  
   public XHWiseElementsBean(String code,String desc,String optio_yn,String inuse,String standdesc,String event_type,String segment_seq,String standcode,String fieldchange)
   {

 
     this.elementCode = code;
     this.elementDesc = desc;
     this.inuseYN = inuse;
     this.segment_seq = segment_seq;
     this.stndCode = standcode;
	 this.event_type = event_type;
	 this.stndDesc=standdesc;
	this.optio_yn=optio_yn;
	this.fieldchange=fieldchange;

   }
 /**
   * Method gets clr
   * 
   */  public String getDTLType()
  {
    return(this.event_type);
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
     this.event_type =  clr;
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
    arrList.add(optio_yn);
    arrList.add(segment_seq);
	arrList.add(inuseYN);
     return(arrList);
  
   }
/**
   * Method gets Arraydata 
   * @return ArrayList
   */
  public ArrayList getArrayData()
  {
    ArrayList arrList = new ArrayList(8);
	
    arrList.add(elementCode);
    arrList.add(elementDesc);
    arrList.add(optio_yn); 
	arrList.add(inuseYN);
    arrList.add(stndDesc);
	arrList.add(event_type);
	arrList.add(segment_seq); 

	arrList.add(stndCode);
     arrList.add(fieldchange);
   
	
    
   
   
	

    return(arrList);
  }
/**
   * Method gets Databasedata array 
   * @ return string array
   */
   public String[] getDatabaseData()
  {
 
    return(new String[]{"",this.elementCode,this.event_type,this.inuseYN,this.fieldchange});
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
