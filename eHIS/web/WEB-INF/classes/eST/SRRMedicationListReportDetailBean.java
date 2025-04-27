/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST;
import java.util.ArrayList;

/**
 * Bean Class used to represent the SRRMedicationListReportDetailBean
 *
 */

public class SRRMedicationListReportDetailBean 
{ 															 

	private String doc_type_code;
private String doc_no;
private String doc_date;
private String store_code;														  
private String fm_store_desc;										    
private String patient_id;											   
private String encounter_id;
private String patient_name;
private String print_option;
 private String optionYN="";

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
  
 
/**
   * Method gets in use
   * 
   */
 
 	 public void setOption(String opt)
  {
    this.print_option =  opt;
  }

	public String getOption()
  {
    return(this.print_option);
  }

							 
													   

/**
   * constructor SRRMedicationListReportDetailBean 
   * @param  String code
   * @param  String desc
   * @param  String inuse
   * @param  String facility
   * @param  String inuseYN
   */  

	  
   public SRRMedicationListReportDetailBean(String doc_type_code,String doc_no,String doc_date,String store_code,String fm_store_desc,String patient_id,String encounter_id,String patient_name,String print_option)
   {
     this.doc_type_code = doc_type_code;
     this.doc_no = doc_no;
     this.doc_date = doc_date;
     this.store_code = store_code;
     this.fm_store_desc = fm_store_desc;
	 this.patient_id = patient_id;
	 this.encounter_id=encounter_id;
	this.patient_name=patient_name;
	this.print_option=print_option; 
   }
 /**
   * Method gets clr
   * 
   */  
   /**
   * Method gets  description 
   * 
   */
 
/**
   * Method gets Arraydata 
   * @return ArrayList																		 
   */  
   public ArrayList getDatabaseArrayData(String applid)
   {
     ArrayList arrList = new ArrayList(6);
     arrList.add(doc_type_code);
     arrList.add(doc_no);
     arrList.add(doc_date);
     arrList.add(this.store_code);
     arrList.add(this.fm_store_desc);
	 arrList.add(this.patient_id);
     return(arrList);
     
   }
/**
   * Method gets Arraydata 
   * @return ArrayList
   */
  public ArrayList getArrayData()
  {
    ArrayList arrList = new ArrayList(9);
    arrList.add(this.doc_type_code);
    arrList.add(this.doc_no);
    arrList.add(this.doc_date);
    arrList.add(this.store_code);
    arrList.add(this.fm_store_desc);
	arrList.add(this.patient_id);
    arrList.add(this.encounter_id);							  
    arrList.add(this.patient_name);
	arrList.add(this.print_option);
    return(arrList);		    
  }
/**
   * Method gets Databasedata array 							  
   * @ return string array
   */
   public String[] getDatabaseData()    
  {
    //return(new String[]{"",this.elementCode,this.inuseYN, this.formatType,this.elementValue,translate_entity,ehis_entity,concatenate_Attributes,Translate_query,this.fieldchange});
	return(new String[]{"",this.doc_type_code,this.doc_no,this.doc_date,this.store_code,this.fm_store_desc,this.patient_id,this.encounter_id,this.patient_name,this.print_option});
  }
 /**
   * Method sets ischanged  
   * 
   */
  public boolean isChanged()
  {																		 
    return(this.changed);
  }

  public SRRMedicationListReportDetailBean(String optionYN)
{
	this.optionYN=optionYN;
}

 public void setOptionYN(String opt)
  {
    this.optionYN =  opt;
  }

	public String getOptionYN()
  {
    return(this.optionYN);
  }

																				  


}
//end of class
