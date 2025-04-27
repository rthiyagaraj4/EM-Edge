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
 * Bean Class used to represent the XHViewInteractiveElementBean
 *
 */ 

public class XHViewInteractiveElementBean 
{ 
private String message_id;
private String ack_message_id;
private String application_id;												   
private String facility_id;
private String request_date;  
private String event_type; 
private String patient_id;
private String merged_patient_id;
private String episode_type;
private String encounter_id;
private String accession_num;
private String ext_accession_num;
private String profile_id;
private String added_by_id;						  
private String added_date;
private String modified_by_id;
private String modified_date;
private String added_at_ws_no;
private String added_facility_id;
private String modified_at_ws_no;
private String modified_facility_id;
private String trx_no;
private String message_date;
private String module_id;
private String pgm_id;
private String user_id;
private String session_id;
private String rejeacted_reason;
private String process_id;
private String protocol_link_id;
private String application_name; 
private String facility_name;
private  int posi=1;
private boolean changed = false;
private String error_text;
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
	  
public XHViewInteractiveElementBean(String message_id,
String ack_message_id,
String application_id,
String facility_id,
String request_date,  
String event_type, 
String patient_id,
String merged_patient_id,
String episode_type,
String encounter_id,
String accession_num,
String ext_accession_num,
String profile_id,
String added_by_id,
String added_date,
String modified_by_id,
String modified_date,
String added_at_ws_no,
String added_facility_id,
String modified_at_ws_no,
String modified_facility_id,
String trx_no,
String message_date,
String module_id,
String pgm_id,
String user_id,
String session_id,
String rejeacted_reason,
String process_id,
String protocol_link_id,String application_name, 
String facility_name,
int posi,String error_text)
   {
this.message_id=message_id;
this.ack_message_id=ack_message_id;
this.application_id=application_id;
this.facility_id=facility_id;
this.request_date=request_date;  
this.event_type=event_type; 
this.patient_id=patient_id;
this.merged_patient_id=merged_patient_id;
this.episode_type=episode_type;
this.encounter_id=encounter_id;
this.accession_num=accession_num;
this.ext_accession_num=ext_accession_num;
this.profile_id=profile_id;
this.added_by_id=added_by_id;
this.added_date=added_date;
this.modified_by_id=modified_by_id;
this.modified_date=modified_date;
this.added_at_ws_no=added_at_ws_no;
this.added_facility_id=added_facility_id;
this.modified_at_ws_no=modified_at_ws_no;
this.modified_facility_id=modified_facility_id;
this.trx_no=trx_no;
this.message_date=message_date;
this.module_id=module_id;
this.pgm_id=pgm_id;
this.user_id=user_id;
this.session_id=session_id;
this.rejeacted_reason=rejeacted_reason;
this.process_id=process_id;
this.protocol_link_id=protocol_link_id;
this.application_name=application_name;
this.facility_name=facility_name;
this.posi=posi;
this.error_text=error_text;
}
 
  
  
 

/**
   * Method gets Arraydata 
   * @return ArrayList
   */  
   public ArrayList getDatabaseArrayData(String applid)
   {
	
     ArrayList arrList = new ArrayList(6);
   
     return(arrList);
  
   }


/**
   * Method gets Arraydata 
   * @return ArrayList
   */

 

  public ArrayList getArrayData()
  {
	ArrayList arrList = new ArrayList(33);
	arrList.add(this.message_id);
	arrList.add(this.ack_message_id);
	arrList.add(this.application_id);
	arrList.add(this.facility_id);
	arrList.add(this.request_date);
	arrList.add(this.event_type);
	arrList.add(this.patient_id);
	arrList.add(this.merged_patient_id);
	arrList.add(this.episode_type);
	arrList.add(this.encounter_id);
	arrList.add(this.accession_num);
	arrList.add(this.ext_accession_num); 
	arrList.add(this.profile_id);
	arrList.add(this.added_by_id);
	arrList.add(this.added_date);
	arrList.add(this.modified_by_id);
	arrList.add(this.modified_date);
	arrList.add(this.added_at_ws_no);
	arrList.add(this.added_facility_id);
	arrList.add(this.modified_at_ws_no);
	arrList.add(this.modified_facility_id);
	arrList.add(this.trx_no);
	arrList.add(this.message_date);
	arrList.add(this.module_id); 
	arrList.add(this.pgm_id);
	arrList.add(this.user_id); 
	arrList.add(this.session_id);
	arrList.add(this.rejeacted_reason);
	arrList.add(this.process_id);
	arrList.add(this.protocol_link_id);
	arrList.add(this.application_name);
	arrList.add(this.facility_name);
	arrList.add(new Integer(this.posi));
	arrList.add(this.error_text);
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
