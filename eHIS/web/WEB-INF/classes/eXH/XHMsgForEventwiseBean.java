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

public class XHMsgForEventwiseBean 
{ 

  private String elementCode;
  private String elementDesc;
   private String optional_yn,master_optional_yn,profile_id,short_desc,event_type,segment_seq;
    private String stndCode;
  private String stndDesc;																	  
  private String inuseYN ;  
  private String status = "";
 private String strstart="N"; 								   
private String fieldchange="N";
	 private int count=0; 																		 
	 private int rscount=0;
	private String comm_mode="";
  private boolean changed = false;
  private String repeatable_yn="";

 /**
   * Method sets changed boolean value
   * 
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

   public void setChanged()
  {
    this.changed =  true;
  }

/**
   * Method sets elementsvalue
   * @param  String str
   */
  
 

/**
   * Method gets element's value
   * 
   */

 

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
  

/**
   * Method sets format type
   * @param  String str
   */



public void setStart(String str)
{
	
	this.strstart=str;
}
	
public String getStart()
  {
 
    return (this.strstart);
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







/**
   * Method sets status
   * @param  String str
   */

  




/**
   * constructor XHMsgForEventwiseBean 
   * @param  String code
   * @param  String desc
   * @param  String inuse 
   * @param  String facility
   * @param  String inuseYN
   */  
   public XHMsgForEventwiseBean(String code,String desc,String optional_yn,String in_use_yn,String master_optional_yn,String profile_id,String short_desc,String standard_desc,String event_type,String standard_code,String segment_seq, String status,String fieldchange,int count,int rscount,String comm_mode,String repeatable_yn)
   {																																																																																	   
      this.elementCode = code;
     this.elementDesc = desc;
	    this.inuseYN = in_use_yn;
	 this.optional_yn=optional_yn;
     this.stndCode = standard_code;
	 this.stndDesc=standard_desc;
     this.master_optional_yn=master_optional_yn;
	 this.profile_id=profile_id;
	 this.short_desc=short_desc;
	 this.event_type=event_type;
	 this.segment_seq=segment_seq;
	 this.status=status;
    this.fieldchange=fieldchange;
   	 this.count=count; 
  	 this.rscount=rscount;
	   this.comm_mode=comm_mode;
	   this.repeatable_yn=repeatable_yn;      
	


   }
 /**
   * Method gets clr
   * 
   */  
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
  public void setProfileCode(String str)
  {
    this.profile_id =  str;
  }

public String getProfileCode()
  {
   return(this.profile_id);
  }

  public void setProfileDesc(String str)
  {
    this.short_desc =  str;
  }

public String getProfileDesc()
  {
   return(this.short_desc);
  }


   public void setOptionYN(String str)
  {
    this.optional_yn =  str;
  }

  public String getOptionYN()
  {
   return(this.optional_yn);
  }
  /**
   * Method sets clr
   * @param  String str
   */
   

    /**
   * Method sets RepeatYN
   * @param  String str
   */
  public void setRepeatYN(String str)
  {
    this.repeatable_yn = str;
  }
   /**
   * Method gets RepeatYN
   * @param  String str
   */
   public String getRepeatYN(String str)
  {
    return (this.repeatable_yn);
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
    arrList.add(profile_id);
    arrList.add(event_type);
	arrList.add(inuseYN);
     return(arrList);
  
   }
/**
   * Method gets Arraydata 
   * @return ArrayList
   */
  public ArrayList getArrayData()
  {
    ArrayList arrList = new ArrayList(16);
    arrList.add(elementCode);
    arrList.add(elementDesc);
    arrList.add(optional_yn);
    arrList.add(inuseYN);
    arrList.add(master_optional_yn);
	arrList.add(profile_id);
    arrList.add(short_desc);
    arrList.add(stndDesc);
    arrList.add(event_type);
	arrList.add(stndCode);
    arrList.add(segment_seq);
    arrList.add(status);
	arrList.add(fieldchange); 
	arrList.add(count+"");        
	  arrList.add(rscount+"");
	   arrList.add(comm_mode);
	   arrList.add(repeatable_yn);
    return(arrList);
  }
/**
   * Method gets Databasedata array 
   * @ return string array
   */
   public String[] getDatabaseData()
  {
 
    return(new String[]{"",this.elementCode,this.elementDesc,this.inuseYN,this.profile_id,this.short_desc,this.optional_yn,this.event_type,this.fieldchange,this.repeatable_yn});   
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
