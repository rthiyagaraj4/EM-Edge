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
  
public class XHViewInboundElementBean 
{ 
private String application_id;
private String query_id;
private String facility_id;
private String query_date;
private String query_type;
private String query_priority;
private String process_id;
private String query_status;
private String last_proc_start_time;
private String last_proc_end_time;
private String added_by_id;
private String modified_by_id; 
private String status_text;
private String added_date;
private String modified_date;
private String added_at_ws_no;
private String added_facility_id;
private String modified_at_ws_no;
private String modified_facility_id;
private String event_type;
private String accession_number;
private String site_id;
private String protocol_link_id;
private String application_name; 
private String facility_name;
private String app_msg; 
private String err_msg;
private String message_status;
private String message_id;
private  int posi=1;
private  String added_id;
private  String modified_id;
private  String last_proc_date;
private  String not_req_reason;
private  String query_id1;
private  String status_desc;
private  String facility_name1;
private  String srl_no;
private  String Protocolname;  
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
    public void setPosition(int str)
  {
    this.posi = str;
  }

/**
   * Method gets element's value
   * 
   */ 

  public int getPosition()    
  {
    return(this.posi); 
  }

 

/**
   * constructor XHMsgForApplicationElementsBean 
   * @param  String code
   * @param  String desc
   * @param  String inuse
   * @param  String facility
   * @param  String inuseYN
   */  
	  
   public XHViewInboundElementBean(String application_id,
String query_id,
String facility_id,
String query_date,
String query_type,
String query_priority,
String process_id,
String query_status,
String last_proc_start_time,
String last_proc_end_time,
String added_by_id,
String modified_by_id, 
String status_text,
String added_date,
String modified_date,
String added_at_ws_no,
String added_facility_id,
String modified_at_ws_no,
String modified_facility_id,
String event_type,
String accession_number,
String site_id,
String protocol_link_id,
String application_name, 
String facility_name,
String app_msg, 
String err_msg,
String message_status,
String message_id,
String added_id,
String modified_id,
String last_proc_date,
String not_req_reason,
String query_id1,
String status_desc,
String facility_name1,
String srl_no,	   
int posi,String Protocolname
	   )
   {

this.application_id=application_id;
 this.query_id=query_id;
this.facility_id=facility_id;
this.query_date=query_date;
this.query_type=query_type;
this.query_priority=query_priority;
this.process_id=process_id;
this.query_status=query_status;
this.last_proc_start_time=last_proc_start_time;
this.last_proc_end_time=last_proc_end_time;
this.added_by_id=added_by_id;
this.modified_by_id=modified_by_id; 
this.status_text=status_text;
this.added_date=added_date;
this.modified_date=modified_date;
this.added_at_ws_no=added_at_ws_no;
this.added_facility_id=added_facility_id;
this.modified_at_ws_no=modified_at_ws_no;
this.modified_facility_id=modified_facility_id;
this.event_type=event_type;
this.accession_number=accession_number;
this.site_id=site_id;
this.protocol_link_id=protocol_link_id;
this.application_name=application_name; 
this.facility_name=facility_name;
this.app_msg=app_msg; 
this.err_msg=err_msg;
this.message_status=message_status;
this.message_id=message_id;
this.posi=posi;
 this.added_id=added_id;
this.modified_id=modified_id;
 this.last_proc_date=last_proc_date;
this.not_req_reason=not_req_reason;
this.query_id1=query_id1;
this.status_desc=status_desc;
this.facility_name1=facility_name1;
 this.srl_no= srl_no;
this.Protocolname=Protocolname;
}
 
  
  
 public ArrayList getNextArrayData()
  {
    ArrayList arrList = new ArrayList(2);
	arrList.add(this.message_id); 
	arrList.add(new Integer(this.posi));
	return(arrList);
  }
public ArrayList getPreviousArrayData()
  {
    ArrayList arrList = new ArrayList(2);
	arrList.add(this.message_id); 
	arrList.add(new Integer(this.posi));
	return(arrList);
  }

/**
   * Method gets Arraydata 
   * @return ArrayList
   */  
   public ArrayList getDatabaseArrayData(String applid)
   {
	
     ArrayList arrList = new ArrayList(6);
   /*arrList.add(elementCode);
    arrList.add(elementDesc);
    arrList.add(stndCode);
    arrList.add(optio_yn);
    arrList.add(control_yn);
	arrList.add(inuseYN);*/
     return(arrList);
  
   }
/**
   * Method gets Arraydata 
   * @return ArrayList
   */
  public ArrayList getArrayData()
  {
    ArrayList arrList = new ArrayList(38);
arrList.add(this.application_id);
 arrList.add(this.query_id);
arrList.add(this.facility_id);
arrList.add(this.query_date);
arrList.add(this.query_type); 
arrList.add(this.query_priority);
arrList.add(this.process_id);
arrList.add(this.query_status);
arrList.add(this.last_proc_start_time);
arrList.add(this.last_proc_end_time);
arrList.add(this.added_by_id);
arrList.add(this.modified_by_id); 
arrList.add(this.status_text);
arrList.add(this.added_date);
arrList.add(this.modified_date);
arrList.add(this.added_at_ws_no);
arrList.add(this.added_facility_id);
arrList.add(this.modified_at_ws_no);
arrList.add(this.modified_facility_id);
arrList.add(this.event_type);
arrList.add(this.accession_number);
arrList.add(this.site_id);
arrList.add(this.protocol_link_id);
arrList.add(this.application_name); 
arrList.add(this.facility_name);
arrList.add(this.app_msg); 
arrList.add(this.err_msg);
arrList.add(this.message_status);
arrList.add(this.message_id);
arrList.add(added_id);
arrList.add(modified_id);
arrList.add(last_proc_date);
arrList.add(not_req_reason);
arrList.add(query_id1);
arrList.add(status_desc);
arrList.add(facility_name);
arrList.add(srl_no);
arrList.add(new Integer(this.posi));
arrList.add(Protocolname);
 
	
    
   
   
	

    return(arrList);
  }
/**
   * Method gets Databasedata array 
   * @ return string array
   */
   public String[] getDatabaseData()
  {
 
    return(new String[]{""});
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
