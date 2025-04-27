/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	created
25/07/2012    IN034227		Dinesh T		Added the filter condition for the PH orders with the NPB field in the ph_drug
-------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------
27/03/2017    IN063686		Raja S			27/03/2017		Ramesh G		PMG2017-GHL-CRF-0001
31/03/2017	  IN006320		Raja S			31/03/2017		Ramesh G		EMR-Alpha-OR-Disabled age group listed in Age group drop down field
31/03/2017	  IN006321		Vijayakumar K   31/03/2017		Ramesh G		EMR-Alpha-OR-Unable to place “Order set” in
03/08/2017	IN062992		Dinesh T		7/8/2017		Ramesh G		ML-MMOH-CRF-0345.1
04/09/2017	IN065144		Dinesh T		04/09/2017		Ramesh G		Script error displayed
30/01/2018	IN065713		Dinesh T		30/01/2017		Ramesh G		System to allow to do multiple setup for same drug in the same Oncology Regimen.
16/01/2018	IN066717		Dinesh T		16/02/2018		Ramesh G		Order set Additional icon(+) is not showing in the next pages.
																			Order catalog is not searchable in the select tab with catalog (Dextrose)
																			Warning messages such Route code must be entered is coming in a single line along with age wise catalog messages.
10/10/2018	IN68241			Dinesh T		10/10/2018		Ramesh G		ML-MMOH-CRF-1227																			
28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014
28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015
19/03/2019  IN069974    Dinesh T      19/03/2019    Ramesh G    PMG2018-GHL-CRF-0015 - Issue 2
08/01/2020	IN068314	Nijitha S     08/01/2020	Ramesh G	ML-MMOH-CRF-1229
07/06/2020	IN072524	Nijitha S     		07/06/2020		Ramesh G		ML-MMOH-CRF-1229.2
-------------------------------------------------------------------------------------------------
*/
package eOR;

import eOR.Common.* ;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;
import javax.servlet.* ;
import eCommon.Common.*;

import javax.servlet.http.*;
import webbeans.eCommon.*;

import eOR.OROrderSet.*;


public class  CareSetBean  extends OrAdapter implements Serializable
{
	protected String which_place = "";
	protected Hashtable allValues = new Hashtable();
	protected String total_records = "";
	public    StringBuffer  tempChk = new StringBuffer();

/*****************STORES(TO STORE ALL THE TABS VALUE)**********/

	public  ArrayList					synonymsRecStr ;
	public  ArrayList					explanatoryRecStr ;
	public  ArrayList					settingsRecStr ;
	public  ArrayList					billingRecStr ;

	public  HashMap						settingsFreqStr ;//
	public  HashMap						settingsAgeGroupStr ; //IN063686
	public  HashMap						settingsDurnStr ;//
	public  HashMap						settingsFreqStrMapper ;
	public  HashMap						careSetHeaderStr ;
	public  HashMap						orderTypeStr  ;//Component tab
	public  HashMap						orderFreqStr ;//Component tab
	public HashMap hashCatalog = new HashMap();
	private String isGlobalFacilityYn;//IN068370,IN068373
	//IN068314 Starts
	public Boolean isFPPApplicable;
	public Boolean getIsFPPApplicable() {
		return isFPPApplicable;
	}
	public void setIsFPPApplicable(Boolean isFPPApplicable) {
		this.isFPPApplicable = isFPPApplicable;
	}
	//IN068314 Ends
	private ArrayList<String> mappedFacilities = new ArrayList<String>();//IN068370,IN068373
	

	public	eOR.Common.MultiRecordBean1			componentStr ;

	public  String						action ;	  //Component tab
	public  String						detailPageMode;//Component tab

	public StringBuffer validateMessage = null;

	//IN062992, starts
	public HashMap hashCatalogAgeWise = new HashMap();
	public String applicableTo;
	//IN062992, ends
	public HashMap hashAdditionalCatalogAgeWise = new HashMap();//IN065713
	public HashMap hashCatalogDosageTypeWise = new HashMap();//IN68241
	
	public HashMap hashAdditionalCatalogDosageTypeKgWise = new HashMap();//IN68241	
	public HashMap hashAdditionalCatalogDosageTypeM2Wise = new HashMap();//IN68241
	public String fpp_applicable_yn =null;

/***************Get Methods*******************************/ 
	public ArrayList getsynonymsRecStr(){return synonymsRecStr ;}
	public ArrayList getExplanatoryRecStr(){return explanatoryRecStr ;}
	public ArrayList getSettingsRecStr(){return settingsRecStr ;}
	public HashMap	 getSettingsFreqStr(){return settingsFreqStr ;}
	public HashMap	 getSettingsAgeGroupStr(){return settingsAgeGroupStr ;}//IN063686
	public HashMap	 getSettingsDurnStr(){return settingsDurnStr ;}
	public HashMap	 getCareSetHeaderStr(){return careSetHeaderStr ;}
	public String    getAction(){return action;}
	public String    getDetailPageMode(){return detailPageMode;}
	public HashMap	 getOrderFreqStr(){return orderFreqStr ;}
	public HashMap	 getOrderTypeStr(){return orderTypeStr ;}
	public void setWhichType(String which_place){	this.which_place = which_place;	}
	public String getWhichType(){					return which_place;	}
	public ArrayList getBillingRecStr(){return billingRecStr ;}
	public Hashtable getAllValues() 
	{
			return allValues;    
	}
	

	public void setTotalRecs(String total_records){	this.total_records = total_records;	}
	public String getTotalRecs(){			return total_records;	}

	//IN062992, starts
	public void setApplicableTo(String p_applicableTo)
	{
		applicableTo = p_applicableTo;
	}

	public String getApplicableTo()
	{
		return applicableTo;
	}
	//IN062992, ends
	//IN068370,IN068373, starts
	public void setGlobalFacilityYn(String isGlobalFacilityYn)
	{
		this.isGlobalFacilityYn = isGlobalFacilityYn; 
	}

	public String getGlobalFacilityYn()
	{
		return isGlobalFacilityYn;
	}
	//IN068370,IN068373, ends


	/******************Clear ALL*******************************/
	public void clearALL()
	{//Called when combo Option for OrderCategory is Changed

		if(!synonymsRecStr.isEmpty())
			synonymsRecStr.clear() ;

		if(!explanatoryRecStr.isEmpty())
			explanatoryRecStr.clear() ;


		if(!settingsRecStr.isEmpty())
			settingsRecStr.clear() ;


		if(!careSetHeaderStr.isEmpty())
			careSetHeaderStr.clear() ;

		clearComponentStr();

		action = "";

		detailPageMode ="";

		if(!billingRecStr.isEmpty())
			billingRecStr.clear() ;

		if(!hashCatalog.isEmpty())
			hashCatalog.clear();

		//IN062992, starts
		if(!hashCatalogAgeWise.isEmpty())
			hashCatalogAgeWise.clear();
		//IN062992, ends

		//IN065144, starts
		if(settingsFreqStr!=null && !settingsFreqStr.isEmpty())
		{
			settingsFreqStr = null;
		}
		//IN065144, ends
		
		//IN065713, starts
		if(!hashAdditionalCatalogAgeWise.isEmpty())
			hashAdditionalCatalogAgeWise.clear();
		//IN065713, ends
		
		//IN68241, starts
		if(!hashCatalogDosageTypeWise.isEmpty())
			hashCatalogDosageTypeWise.clear();
		
		if(!hashAdditionalCatalogDosageTypeKgWise.isEmpty())
			hashAdditionalCatalogDosageTypeKgWise.clear();
		
		if(!hashAdditionalCatalogDosageTypeM2Wise.isEmpty())
			hashAdditionalCatalogDosageTypeM2Wise.clear();
		//IN68241, ends
	}

	/*********************Constructor *************************/
	public CareSetBean()
	{

		careSetHeaderStr				= new HashMap();
		orderTypeStr					= new HashMap();
		orderFreqStr					= new HashMap();

		synonymsRecStr					= new ArrayList();
		explanatoryRecStr				= new ArrayList();
		settingsRecStr					= new ArrayList();
		billingRecStr					= new ArrayList();
		settingsFreqStr					= null ;
		validateMessage					= new StringBuffer();
		settingsAgeGroupStr            = null ;//IN063686
		componentStr					= new eOR.Common.MultiRecordBean1();
		mappedFacilities = new ArrayList<String>();//IN068370,IN068373

	}

	public eOR.Common.MultiRecordBean1 getComponentStr() {
		return componentStr;
	}
	/*********************Validate *************************/

	public HashMap validate() throws Exception 
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." );
		boolean  finalFlag = true ;

		validateMessage  =  new StringBuffer();

		String msgNotBlank	  =	checkForNull(getMessage(language_id,"SHOULD_NOT_BE_BLANK","Common"));		

		String locale = properties.getProperty("LOCALE");
		locale = (locale == null || locale.equals(""))?"en":locale;

		java.util.Locale loc = new java.util.Locale(locale);
		java.util.ResourceBundle or_labels = java.util.ResourceBundle.getBundle( "eOR.resources.Labels",loc);
		//java.util.ResourceBundle or_messages = java.util.ResourceBundle.getBundle( "eOR.resources.Messages",loc);
		//java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);

		//String label = or_labels.getString("eOR.DirectCare.label");

		if(msgNotBlank.trim().equalsIgnoreCase(""))
				throw new Exception("No Message => to Key SHOULD_NOT_BE_BLANK in the DataBase");

		try
		{
			if(!chkRequired(synonymsRecStr,0,"effective_status_directCare","Y","catalog_synonym_directCare"))
			{
				validateMessage.append(concat(or_labels.getString("eOR.DirectCare.label"),msgNotBlank));
				finalFlag = false ;
			}
			if(!chkRequired(synonymsRecStr,0,"effective_status_ancillaryDept","Y","catalog_synonym_ancillaryDept"))
			{
				validateMessage.append(concat(or_labels.getString("eOR.AncillaryDept.label") , msgNotBlank));
				finalFlag = false ;
			}
			//1)Seq no Madatory Chk 2) Atleast one Catalog Ascc chk 3) Durn value chk  if freq is selected 4) Qty Req chk 5) freq Required chk
			int size =	componentStr.getSize("DB");
			int counter = 0 ;
			ArrayList asccRec  =componentStr.getAllDBRecords();

			boolean seqFlag = true ;
			boolean timeFlag = true ;
			boolean durnFlag = true ;
			boolean freqFlag = true ;
			boolean qtyFlag = true ;
			boolean routeFlag = true ;
			boolean ordertype_flag=true;
			boolean ageWiseFlag = true;//IN062992

			StringBuffer freq_catalog_reqd	= new StringBuffer();
			StringBuffer qty_catalog_reqd	= new StringBuffer();
			StringBuffer age_wise_required	= new StringBuffer();//IN062992

			//Iterate through all the records
			String associate_yn	="";
		 
			String rel_start_date_time ="";
			String freq_code="";
			String durn_value="";
			String freq_applicable_yn="";
			String qty_reqd_yn="";
			String qty_unit="";
			String iv_prep_yn="";
			String route_code="";
			String dosage_type="";//IN062992
			Boolean isAgeWiseValidReq = false;//IN062992
		
			iv_prep_yn=(String)careSetHeaderStr.get("iv_prep_yn");

			for (int i = 0; i < size ; i++ )
			{
				HashMap currRec				=(HashMap)asccRec.get(i)	;
				associate_yn			=(String)currRec.get("associate_yn");				
				isAgeWiseValidReq = false;//IN062992

				//Chk for all the Ascc records
				if(associate_yn.trim().equalsIgnoreCase("Y")){

				String seqNo				= (String)currRec.get("order_set_seq_num");
				String OrderTypeValue		= (String)currRec.get("order_type_code");			
				rel_start_date_time = (String)currRec.get("rel_start_date_time");
				freq_code			= (String)currRec.get("freq_code");
				durn_value			= (String)currRec.get("durn_value");

				freq_applicable_yn	= (String)currRec.get("freq_applicable_yn");
				qty_reqd_yn			= (String)currRec.get("qty_reqd_yn");
				qty_unit			= (String)currRec.get("qty_unit");
				//route_code=(String)currRec.get("route_code");//IN062992
				route_code=(String)(currRec.get("route_code")==null?"":currRec.get("route_code"));//IN062992
				dosage_type = (String)currRec.get("dosage_type");//IN062992


				if(seqNo.trim().equalsIgnoreCase(""))
				seqFlag = false ;
				
				if(OrderTypeValue.trim().equalsIgnoreCase(""))
				ordertype_flag = false ;
				
				//IN062992, starts
				if("C".equals(iv_prep_yn) && "A".equals(dosage_type))
				{
					isAgeWiseValidReq = true;
				}
				//IN062992, ends

				counter++;//IN062992
				
				//IN062992, starts
				if(isAgeWiseValidReq)
				{
					if("A".equals(dosage_type) && !hashCatalogAgeWise.containsKey((String)currRec.get("order_catalog_code")))
					{
						ageWiseFlag = false;
						age_wise_required.append((String)currRec.get("order_catalog_desc") + ",");
					}

					if("Y".equalsIgnoreCase(qty_reqd_yn.trim()) && "".equalsIgnoreCase(qty_unit.trim()))
					{
						qty_catalog_reqd.append((String)currRec.get("order_catalog_desc") + ",");
						qtyFlag = false ;
					}
				}
				else
				{//IN062992, ends
					if(rel_start_date_time.trim().equalsIgnoreCase(""))
					timeFlag = false ;					

					//counter++;//IN062992
					if(!freq_code.trim().equalsIgnoreCase("") && durn_value.trim().equalsIgnoreCase(""))
					{ //i:e freq is selected nd durn is not selected
						durnFlag = false;
					}

					if(freq_applicable_yn.trim().equalsIgnoreCase("Y") && freq_code.trim().equalsIgnoreCase(""))
					{
						freq_catalog_reqd.append((String)currRec.get("order_catalog_desc") + ",");
						freqFlag = false ;
					}

					if(qty_reqd_yn.trim().equalsIgnoreCase("Y") && qty_unit.trim().equalsIgnoreCase(""))
					{
						qty_catalog_reqd.append((String)currRec.get("order_catalog_desc") + ",");
						qtyFlag = false ;
					}

					if(iv_prep_yn.trim().equalsIgnoreCase("C") && route_code.trim().equalsIgnoreCase(""))
					{
						routeFlag=false;
					}
				}//IN062992

			}//Ascc  records
		} //Iteration for All ascc records ends

		if(counter <=0 )   
		{//No rec Ascc
			validateMessage.append( getMessage("ASSO_CATLOG_TO_ORDERSET"));
			finalFlag = false ;
		}

		if(!seqFlag)   
		{
			validateMessage.append( getMessage("MANDATORY_SEQNO"));
			finalFlag = false ;
		}

		if(!ordertype_flag)   
		{
			validateMessage.append(getMessage(language_id, "ASSOCIATE_ORDER_TYPE_FOR_CATALOG","OR"));
			finalFlag = false ;
		}

		if(!timeFlag)   
		{
			validateMessage.append( getMessage("MANDATORY_TIME"));
			finalFlag = false ;
		}


		if(!durnFlag)   
		{
			validateMessage.append( getMessage("MANDATORY_DURN"));
			finalFlag = false ;
		}

		if(!freqFlag)   
		{
			String freqMsg		= getMessage("MAND_ORDSET_FREQUENCY");
			String freq_catalog_val_msg	= freq_catalog_reqd.substring(0,freq_catalog_reqd.length()-1) ;
			int indxFreq		= freqMsg.lastIndexOf("@");
			validateMessage.append(freqMsg.substring(0,indxFreq) + freq_catalog_val_msg + freqMsg.substring(indxFreq+1) );
			finalFlag = false ;
		}

		if(!qtyFlag)   
		{
			String qtyMsg		= getMessage("MAND_ORDERSET_QTY");
			int indxQty		= qtyMsg.lastIndexOf("@");
			validateMessage.append(qtyMsg.substring(0,indxQty) + qty_catalog_reqd.substring(0,qty_catalog_reqd.length()-1) + qtyMsg.substring(indxQty+1) );
			finalFlag = false ;
		}

		if(!routeFlag)   
		{
			validateMessage.append(getMessage(language_id,"ORDER_SET_ADMIN_ROUTE","OR"));
			finalFlag = false ;
		}

		//IN062992, starts
		if(!ageWiseFlag)
		{
			//validateMessage.append(getMessage(language_id,"AGE_WISE_DATA_REQUIRED","OR"));//IN066717
			validateMessage.append("\n"+getMessage(language_id,"AGE_WISE_DATA_REQUIRED","OR"));//IN066717
			finalFlag = false ;
		}
		//IN062992, ends


		/***duplicate Chk*****/
		int sizeRecordStore		 = componentStr.getSize("DB");
		boolean flagDuplicate = false ;//Assume no duplicate at start
		boolean result = true ;
		StringBuffer msg = new StringBuffer();
		TreeSet chker = new TreeSet();//Duplicate chker
		String seqNoStr="";
		
	   	for(int i=0 ; i < sizeRecordStore ; i++)
		{//Loop to Chk Duplicate
			HashMap currData = (HashMap)componentStr.getObject(i) ;

			if(((String)currData.get("associate_yn")).trim().equalsIgnoreCase("Y"))
			{
				seqNoStr = checkForNull(((String)currData.get("order_set_seq_num")));

			  //  if(!seqNoStr.equals(""))
				
					Integer seqNo = new Integer( Integer.parseInt(seqNoStr));
				
				flagDuplicate = chker.add(seqNo);
				if(!flagDuplicate)
				{//Duplicate has been detected
					msg.append(seqNo + ",") ;
					result = false;
				}
			}//Chk  for Ascc record only
		}//End of for Loop

		if(!result)
		{ //Duplicate is present
			String msgStr  = msg.toString() ;
			int t	      = msgStr.lastIndexOf(",");
			msgStr		  = msgStr.substring(0,t) ;
			String dupMsg  = getMessage("DUPL_SEQNO");
			int rep		  =	dupMsg.lastIndexOf("@");
			//validateMessage.append(dupMsg.substring(0,rep) + msgStr + dupMsg.substring(rep+1) );//IN066717
			validateMessage.append("\n"+dupMsg.substring(0,rep) + msgStr + dupMsg.substring(rep+1) );//IN066717
			finalFlag = false ;
		 }
		 freq_catalog_reqd.setLength(0);
		 qty_catalog_reqd.setLength(0);


	}
	catch (Exception e)
	{
		e.printStackTrace();
			map.put( "result", new Boolean( false ) ) ;
			map.put( "message", e.getMessage());
	}

	if(!finalFlag)
	{
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "Validate" );
	}


		return map;
	}


/****************Concanate Function ************************************/
private String concat(String varMsg,String msgNotBlank)
{
		/*Modified by Uma on 12/22/2009 for IN017385
		String temp = "Cannot be Blank" ;
		int indx = msgNotBlank.indexOf(temp);
		return  msgNotBlank.substring(0,indx) + " "  + varMsg + " " + msgNotBlank.substring(indx,msgNotBlank.length());*/
		msgNotBlank = msgNotBlank.replace("{","");
		msgNotBlank = msgNotBlank.replace("1",varMsg);
		msgNotBlank = msgNotBlank.replace("}","");
		msgNotBlank = msgNotBlank+"<br>";
		return  msgNotBlank;
}
/*************Over riding get Message**************************************/
public String getMessage( String msgId )
{

	String msg ="";

	if(msgId.equals("Validate"))
	{
		msg = validateMessage.toString();
		validateMessage =  new StringBuffer() ;
		return msg ;
	}
	else
	{
		return super.getMessage(msgId) ;
	}

}
/*****************MAX DURN VAL CHK *******************************************/
 private boolean chkRequiredAll(ArrayList store, String key , String mandatory ) throws Exception
{
	try
	{
		int size =  store.size();
		boolean flag  = true ;

		if(size == 0)
		return true;

		for (int i = 0 ; i < size ; i++ )
		{
			flag = chkRequiredEmpty(store,i,key,mandatory)	;
			if(!flag)
				return false ;
		}

		return true;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}
}
/*****************************************************************************/

  private boolean chkRequired(ArrayList store, int position , String key ,  String keyVal , String mandatory ) throws Exception
  {

	int size =  store.size();
	
	if(size == 0)
	return true;

	if(size < position )
		throw new Exception("Chk position passed and the size of Store") ;


	HashMap currRec = (HashMap)store.get(position);

	if(!(currRec.containsKey( key.trim() ))) //key should be there
		return true ;

	if(!currRec.containsKey(mandatory.trim())) //mandatory should be there
		return true ;


	String currKeyVal = (String)currRec.get(key.trim()) ;
	String mandatoryVal  = (String)currRec.get(mandatory.trim());

	if(currKeyVal.trim().equalsIgnoreCase(keyVal.trim()))
	{
		if(mandatoryVal.trim().equalsIgnoreCase(""))
			return false ;
	}
	else
	{
			return true;
	}


	return true ;

}
/**************************************************************************/
  private boolean chkRequiredEmpty(ArrayList store, int position , String key , String mandatory ) throws Exception
  {

	int size =  store.size();

	if(size == 0)
	return true;

	if(size < position )
		throw new Exception("Chk position passed and the size of Store") ;


	HashMap currRec = (HashMap)store.get(position);

	if(!(currRec.containsKey( key.trim() ))) //key should be there
		return true ;

	if(!currRec.containsKey(mandatory.trim())) //mandatory should be there
		return true ;


	String currKeyVal = (String)currRec.get(key.trim()) ;
	String mandatoryVal  = (String)currRec.get(mandatory.trim());

	if(!currKeyVal.trim().equalsIgnoreCase(""))
	{
		if(mandatoryVal.trim().equalsIgnoreCase(""))
			return false ;
	}
	else
	{
			return true;
	}


	return true ;

}

/*********************METHOD TO SET ALL THE FEILDS AT ONCE*************************/
 public void setAll( Hashtable recordSet ) 
{
	allValues = recordSet;
	/*careset Header*/		
	if(recordSet.containsKey("order_set_code"))
		 careSetHeaderStr.put("order_set_code",(String)recordSet.get("order_set_code"));
	if(recordSet.containsKey("long_desc"))
		 careSetHeaderStr.put("long_desc",(String)recordSet.get("long_desc"));
	if(recordSet.containsKey("short_desc"))
		 careSetHeaderStr.put("short_desc",(String)recordSet.get("short_desc"));
	if(recordSet.containsKey("order_category"))
		 careSetHeaderStr.put("order_category",(String)recordSet.get("order_category"));
	if(recordSet.containsKey("order_type_code"))
		 careSetHeaderStr.put("order_type_code",checkForNull((String)recordSet.get("order_type_code")));
	if(recordSet.containsKey("activity_type"))
		 careSetHeaderStr.put("activity_type",checkForNull((String)recordSet.get("activity_type")));
	if(recordSet.containsKey("security_level"))
		 careSetHeaderStr.put("security_level",checkForNull((String)recordSet.get("security_level")));
/*	if(recordSet.containsKey("explanatory_text"))	
		 careSetHeaderStr.put("explanatory_text",checkForNull((String)recordSet.get("explanatory_text"))); */
	if(recordSet.containsKey("eff_status"))
		 careSetHeaderStr.put("eff_status"	  ,checkForNull((String)recordSet.get("eff_status"),"D"));
	if(recordSet.containsKey("indexed_yn")){
		careSetHeaderStr.put("indexed_yn"	  ,checkForNull((String)recordSet.get("indexed_yn"),"N"));
	}
	if(recordSet.containsKey("iv_prep_yn")){
		careSetHeaderStr.put("iv_prep_yn"	  ,checkForNull((String)recordSet.get("iv_prep_yn"),""));
	}
	if(recordSet.containsKey("discharge_indicator")){
		careSetHeaderStr.put("discharge_indicator"	  ,checkForNull((String)recordSet.get("discharge_indicator"),"N"));
	}
	if(recordSet.containsKey("which_place")){	setWhichType(((String)recordSet.get("which_place")));}
	if(recordSet.containsKey("total_recs"))
	{
			setTotalRecs((String)recordSet.get("total_recs"));
	}
	if(recordSet.containsKey("contr_mod_id"))
	{
			careSetHeaderStr.put("contr_mod_id"	  ,checkForNull((String)recordSet.get("contr_mod_id"),""));
	}
	if(recordSet.containsKey("contr_msr_panel_id"))
	{
			careSetHeaderStr.put("contr_msr_panel_id"	  ,checkForNull((String)recordSet.get("contr_msr_panel_id"),""));
	}
	this.mode = (String)recordSet.get("mode");
	//IN068370,IN068373 , starts
	 if("Y".equals(getGlobalFacilityYn()) && recordSet.containsKey("appl_fac_id"))
	 {
		String l_fac_ids = checkForNull((String)recordSet.get("appl_fac_id"),"");
		
		if(!"".equals(l_fac_ids))
		{
			String l_ind_fac_ids[] = l_fac_ids.split("~");
			careSetHeaderStr.put("appl_fac_id",l_ind_fac_ids);
		}
	 }
	 //IN068370,IN068373, ends
	 //IN068314 Starts
	 System.out.println("FPP_YN"+(String)recordSet.get("fpp_yn"));
	 System.out.println("FPP_YN:708"+recordSet.containsKey("fpp_yn"));
	 if(recordSet.containsKey("fpp_yn"))
	 {
			careSetHeaderStr.put("fpp_yn"	  ,checkForNull((String)recordSet.get("fpp_yn"),""));
			
	 }
	//IN068314 Ends
 }

/*********************METHOD TO Reset the Class variable*************************/

	public void clear() 
	{
		which_place = "";
	}

/*********************METHOD TO Insert*************************/

public HashMap insert()
{
	try
	{
		
		HashMap map = new HashMap() ;
		HashMap sqlMap = new HashMap();
		Boolean isOrderCatalogFacWise = isSiteSpecific("ORDER_CATALOG_FAC_WISE");//IN068370,IN068373
		map.put( "result", new Boolean( false ) ) ;
		HashMap recordStoreParam = new HashMap() ;

		
		defaultInitailiseStr();

		recordStoreParam.put("careSetHeaderStr"	,careSetHeaderStr);
		recordStoreParam.put("synonymsStr"		, synonymsRecStr);
		recordStoreParam.put("explanatoryStr"	, explanatoryRecStr);
		recordStoreParam.put("settingsStr"		, settingsRecStr);
		recordStoreParam.put("componentStr"		, componentStr.getAllDBRecords());
		recordStoreParam.put("billingRecStr"	, billingRecStr);
		recordStoreParam.put("login_by_id"		 , login_by_id) ;
		recordStoreParam.put("login_at_ws_no"	 , login_at_ws_no ) ;
		recordStoreParam.put("login_facility_id" , login_facility_id ) ;
		recordStoreParam.put("appl_to" , getApplicableTo() ) ;//IN68241
		recordStoreParam.put("componentAdditionalStr" , hashCatalog ) ;
		recordStoreParam.put("isSiteSpecificYN" , isSiteSpecificYN() ) ;//IN062992
		recordStoreParam.put("MappedFacilities",mappedFacilities);//IN068370,IN068373
		recordStoreParam.put("GlobalFacilityYn",getGlobalFacilityYn());//IN068370,IN068373
		recordStoreParam.put("SiteSpecGlobalFac", isOrderCatalogFacWise);//IN068370,IN068373

		//IN062992, starts
		if(isSiteSpecificYN())
		{
			recordStoreParam.put("componentAgeWiseStr" , hashCatalogAgeWise ) ;
			recordStoreParam.put("additionalComponentAgeWiseStr" , hashAdditionalCatalogAgeWise ) ;//IN065713
			//IN68241, starts
			recordStoreParam.put("hashCatalogDosageTypeWise" , hashCatalogDosageTypeWise );
			recordStoreParam.put("hashAdditionalCatalogDosageTypeKgWise" , hashAdditionalCatalogDosageTypeKgWise );
			recordStoreParam.put("hashAdditionalCatalogDosageTypeM2Wise" , hashAdditionalCatalogDosageTypeM2Wise );
			//IN68241, ends
		}
		//IN062992, ends
		
		

		sqlMap.put("SQL_OR_ORDERSET_DUP_CHK"			,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_DUP_CHK"));
		sqlMap.put("SQL_OR_ORDERSET_INSERT"				,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_INSERT"));
		sqlMap.put("SQL_OR_ORDERSET_INSERT_SYNONYM"		,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_INSERT_SYNONYM"));
		sqlMap.put("SQL_OR_ORDERSET_INSERT_BY_PTCL"		,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_INSERT_BY_PTCL"));
		//IN062992, starts
		//sqlMap.put("SQL_OR_ORDERSET_INSERT_COMP"		,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_INSERT_COMP"));
		if(isSiteSpecificYN())
		{
			sqlMap.put("SQL_OR_ORDERSET_INSERT_COMP"		,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_INSERT_COMP_ONCOLOGY"));
		}
		else
		{
			sqlMap.put("SQL_OR_ORDERSET_INSERT_COMP"		,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_INSERT_COMP"));
		}//IN062992, ends

		sqlMap.put("SQL_OR_ORDER_SET_COMPONENT_ADD_SELECT"	,OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_SET_COMPONENT_ADD_SELECT"));
		sqlMap.put("SQL_OR_ORDER_SET_COMPONENT_ADD_DELETE"	,OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_SET_COMPONENT_ADD_DELETE"));
				
		//IN062992, starts
		if(isSiteSpecificYN())
		{
			sqlMap.put("SQL_OR_ORDERSET_COMP_AGE_WISE_INSERT",OrRepository.getOrKeyValue("SQL_OR_ORDERSET_COMP_AGE_WISE_INSERT"));			
			sqlMap.put("SQL_OR_ORDERSET_COMP_AGE_WISE_SELECT",OrRepository.getOrKeyValue("SQL_OR_ORDERSET_COMP_AGE_WISE_SELECT"));			
			sqlMap.put("SQL_OR_ORDERSET_COMP_AGE_WISE_DELETE",OrRepository.getOrKeyValue("SQL_OR_ORDERSET_COMP_AGE_WISE_DELETE"));
			
			//IN68241, starts
			sqlMap.put("SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_INSERT",OrRepository.getOrKeyValue("SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_INSERT"));			
			sqlMap.put("SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_SELECT",OrRepository.getOrKeyValue("SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_SELECT"));			
			sqlMap.put("SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_DELETE",OrRepository.getOrKeyValue("SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_DELETE"));
			//IN68241, starts
		}
		//IN062992, ends
		//IN068370,IN068373, starts
		if("Y".equals(getGlobalFacilityYn()) && isOrderCatalogFacWise)
		{
			sqlMap.put("SQL_OR_CATALOG_BY_FACILITY_INSERT", OrRepository.getOrKeyValue("SQL_OR_CATALOG_BY_FACILITY_INSERT"));
			sqlMap.put("SQL_OR_CATALOG_BY_FACILITY_DELETE", OrRepository.getOrKeyValue("SQL_OR_CATALOG_BY_FACILITY_DELETE"));
		}
		//IN068370,IN068373, ends

		map.put("recordStoreParam",recordStoreParam);
		map.put("////sqlMap",sqlMap);

		return getResult(recordStoreParam,sqlMap );
	}
	catch(Exception e)
	{
		e.printStackTrace();
		logErrorMessage(e);
		return null;
	}
}
/**************************************************************************/

/**********************Store the Age Group for Setting Tab********/
//IN063686 changes starts
public synchronized void setSettingsAgeGroupStr(){
	try
	{
		//Commented the if condition for IN006320 starts
		/*
        if(settingsAgeGroupStr == null){//Only for the first time
		 settingsAgeGroupStr  = getSqlResult("SQL_OR_CATALOG_SETTINGS_AGE_GROUP");
        }
		*/
		settingsAgeGroupStr  = getSqlResult("SQL_OR_CATALOG_SETTINGS_AGE_GROUP");
		//IN006320 Ends
	}catch (Exception e){		 
		e.printStackTrace();

	}

}
//IN063686 changes starts
/**********This Method  Actually Calls the EJB's Method ********************/
 private  HashMap getResult(HashMap record , HashMap sqlMap ) 
 {
	HashMap map  = new HashMap() ;
	try
	{

		/*InitialContext context = new InitialContext();
		Object object		   = context.lookup(OrRepository.getOrKeyValue("OR_ORDERSET_JNDI"));
		OROrderSetHome home  = (OROrderSetHome) PortableRemoteObject.narrow( object,OROrderSetHome.class );
		OROrderSetRemote remote = home.create() ;*/
		  Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("OR_ORDERSET_JNDI"), OROrderSetHome.class, getLocalEJB());
		  Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		 
		HashMap tabDataParam =  new HashMap() ;
		tabDataParam.put( "properties", getProperties() );
		tabDataParam.put( "tabData",     record );

		Object argArray[]	= new Object[2];
		argArray[0]		= tabDataParam;
		argArray[1]		= sqlMap;
		Class [] paramArray = new Class[2];
		paramArray[0]	= tabDataParam.getClass();
		paramArray[1]	= sqlMap.getClass();		
						
			
		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_DELETE")))
		{
			return null ;
		}
		else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) 
		{

			// map = remote.insert(tabDataParam, sqlMap ) ;
			map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
		}
		else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")))
		{

				//map = remote.modify(tabDataParam, sqlMap )    ;
				map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
		}

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
		 
		  argArray		= null;
		  paramArray	= null;

		if( ((Boolean) map.get( "result" )).booleanValue() )
		{
				//map.put( "message", (String) map.get( "msgid" ));
				map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
		}
		else
		{
				//map.put( "message", ((String) map.get("msgid"))) ;
			String map_message=(String) map.get( "message" );
			if(map_message.equalsIgnoreCase("Insert Failed"))
			{
				map.put( "message", getMessage(language_id,"ERROR_INSERTING", "SM")) ;
			}
			else if(map_message.equalsIgnoreCase("ORDERSET_INCORRECT_CATALOG_COMB"))//IN069974, starts
			{
				map.put( "message", getMessage(language_id,map_message, "OR")) ;
			}//IN069974, ends
			else
			{
				map.put( "message", getMessage(language_id, (String) map.get( "message" ), "Common")) ;
			}
		}

	  //return map;

	 }catch(Exception e){
		map.put( "message", e.getMessage() );
		e.printStackTrace() ;
		
	}
   return map ;
 }//End of Method


/************************LOAD DATA FOR UPDATION *****************************/
public void defaultLoadForUpdation(String[] Code)
{
	try
	{
		String order_catalog_code      = Code[0];////IN068370,IN068373
		Hashtable ht_catalog =	getSqlResultParamLoad("SQL_OR_ORDERSET_LOAD_ORDERSET",Code,-1);
		
		//IN068370,IN068373, starts
		String[] discr_msr_panel_id_param1 = {order_catalog_code};

    	Hashtable ht_discr_mesr1 =getSqlResultParamLoad("SQL_OR_CATALOG_BY_FACILITY_SELECT",discr_msr_panel_id_param1,1);
    	
		if("Y".equals(getGlobalFacilityYn()) && isSiteSpecific("ORDER_CATALOG_FAC_WISE"))
		{
			String l_appl_fac_ids = "";
			Integer	l_size_appl_fac_ids = (Integer)ht_discr_mesr1.get("noRec") ;
		
			for (int i = 1; i <= l_size_appl_fac_ids ; i++)
			{  		  
				l_appl_fac_ids = l_appl_fac_ids + "~" + (String)ht_discr_mesr1.get("applicable_facility_id"+ i);  				  
			}
			
			ht_catalog.put("appl_fac_id",l_appl_fac_ids);
		}
		//IN068370,IN068373, ends

		setAll(ht_catalog);//for header
       
	    // ExplanatoryText
		explanatorySync(ht_catalog);

		// For billing synchronisation
		billingSync(ht_catalog);
		
		//Synonms
		Hashtable ht_syn	 =	getSqlResultParamLoad("SQL_OR_ORDERSET_LOAD_CATALOG_BY_SYNONYM",Code,1);
		Integer	size_syn_obj = (Integer)ht_syn.get("noRec") ;
		int size_syn		 =  size_syn_obj.intValue();

		String Str1="";
		String Str2 ="";
		String syn_type="";
		String syn_desc="";

		for (int i = 1; i <= size_syn ; i++)
		{


			Str1 = 	"catalog_synonym_type"+ i ;
			Str2 = 	"catalog_synonym"+ i ;

			syn_type = (String)ht_syn.get(Str1.trim());
			syn_desc = (String)ht_syn.get(Str2.trim());

			if(syn_type.trim().equalsIgnoreCase("PR"))
			{
				ht_catalog.put("catalog_synonym_primary",syn_desc);
				ht_catalog.put("effective_status_primary","Y");
			}

			if(syn_type.trim().equalsIgnoreCase("DC"))
			{
				ht_catalog.put("catalog_synonym_directCare",syn_desc);
				ht_catalog.put("effective_status_directCare","Y");
			}

			if(syn_type.trim().equalsIgnoreCase("AD"))
			{
				ht_catalog.put("catalog_synonym_ancillaryDept",syn_desc);
				ht_catalog.put("effective_status_ancillaryDept","Y");
			}
		}
		synonymsSync(ht_catalog);
		fetchMappedFacilities(order_catalog_code);//IN068370,IN068373

	}
	catch (Exception e)
	{
		e.printStackTrace();
			logErrorMessage(e);
	}
}

/*************************just get the result as Hash table for UPdation***************/
public  Hashtable getSqlResultParamLoad(String key , String[] params ,int indStart) throws Exception
{
	Connection connection	= null ;
	PreparedStatement pstmt = null ;
	ResultSet rs			= null;
	ResultSetMetaData rsmd	= null ;
	String 	columnName		= null ;
	int 	columnCount		= -1 ;

	Hashtable result = new Hashtable();

	int paramslen  = params.length ;

	try
	{
		connection = getConnection();


		String sql = OrRepository.getOrKeyValue(key.trim());

		pstmt	   = connection.prepareStatement(sql);


		for (int i = 0; i < paramslen ; i++ ){
			pstmt.setString(i+1, (params[i]).trim());
		}

		rs		   = pstmt.executeQuery()  ;
		rsmd	   = rs.getMetaData()      ;
		columnCount= rsmd.getColumnCount() ;
		int counter= 0 ;

		while (rs.next())
		{

			counter++;
			for(int i = 1; i <= columnCount ; i++){
					columnName	= rsmd.getColumnName(i)  ;
				if(indStart == -1 )
					result.put((columnName.toLowerCase()),ChkDef.defaultString(rs.getString(columnName)));
				else
					result.put(((columnName.toLowerCase()+counter).trim()),ChkDef.defaultString(rs.getString(columnName)));
			}

		}
		result.put("noRec",new Integer(counter));
	
		return result ;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}
	finally
	{
		try
		{
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		catch(Exception e)
		{
			e.printStackTrace() ; 
		}
	}
}

/******************Default Intailise the str if tab not visted ***************/
private void defaultInitailiseStr()
{

//Default Intialise only if store's are is empty
	Hashtable def = new Hashtable();

	if(synonymsRecStr.isEmpty())
	{
		def.put("catalog_synonym_type" ,"PR");
		def.put("catalog_synonym_primary",(String)careSetHeaderStr.get("short_desc"));
		def.put("effective_status_primary","Y");
		synonymsSync(def);
		def.clear() ;
	}

	if(explanatoryRecStr.isEmpty())
	{
		def.put("explanatory_text" ,"");	
		//		def.put("explanatory_text" ,(String)careSetHeaderStr.get("explanatory_text"));	
		explanatorySync(def);
		def.clear() ;
	}   


	if(settingsRecStr.isEmpty())
	{
		def.put("patient_class0" ,"*A");
		def.put("setting_applicability0","A");
		def.put("age_group_code0","");//IN063686
		def.put("noOfRecords","0");
		settingsSync(def);
		def.clear() ;
	}

//	ComponentRecStr -------- it has to be mandatorly filled chk in validation

	if(billingRecStr.isEmpty())
	{
		def.put("charge_type_applicable" ,"S");
		//Added to disable the billing for the Order Set by Uma 2/6/2009
		def.put("bill_yn","N");
		def.put("ord_set_charge_pat_yn","N");
		//def.put("bill_yn","Y");
		//End 
		billingSync(def);
		def.clear() ;
	}
}
/*********************METHOD TO Update*************************/

public HashMap modify()
{
	try
	{
		
		HashMap map = new HashMap() ;
		HashMap sqlMap = new HashMap();
		Boolean isOrderCatalogFacWise = isSiteSpecific("ORDER_CATALOG_FAC_WISE");//IN068370,IN068373
		map.put( "result", new Boolean( false ) ) ;
		HashMap recordStoreParam = new HashMap() ;


		recordStoreParam.put("careSetHeaderStr"	,careSetHeaderStr);

		recordStoreParam.put("synonymsStr"		,synonymsRecStr);
		recordStoreParam.put("explanatoryStr"	,explanatoryRecStr);
		recordStoreParam.put("componentAdditionalStr" , hashCatalog ) ;
		recordStoreParam.put("isSiteSpecificYN" , isSiteSpecificYN() ) ;//IN062992

		//IN062992, starts
		if(isSiteSpecificYN())
		{
			recordStoreParam.put("componentAgeWiseStr" , hashCatalogAgeWise ) ;
			recordStoreParam.put("additionalComponentAgeWiseStr" , hashAdditionalCatalogAgeWise ) ;//IN065713
			//IN68241, starts
			recordStoreParam.put("hashCatalogDosageTypeWise" , hashCatalogDosageTypeWise );
			recordStoreParam.put("hashAdditionalCatalogDosageTypeKgWise" , hashAdditionalCatalogDosageTypeKgWise );
			recordStoreParam.put("hashAdditionalCatalogDosageTypeM2Wise" , hashAdditionalCatalogDosageTypeM2Wise );
			//IN68241, ends
		}
		//IN062992, ends


		if(settingsRecStr.isEmpty())
		{//That means there is no  visit to  this page (Tab)
		//Fill the records in the store as if there is visted to the page
			Hashtable   dummpPageSettings=  new  Hashtable();
			String order_set_code =
			(String)careSetHeaderStr.get("order_set_code");
			String sqlParam[]  = {order_set_code.trim()};

			Hashtable defVal1 = settingsDefault("SQL_OR_ORDERSET_LOAD_CATALOG_BY_SETTINGS","update",sqlParam);

			HashMap pat_class		 =	getSqlResult("SQL_OR_PATIENT_CLASS_LIST");
			Integer noOfRecordsTemp = (Integer)pat_class.get("noRec");
			int noOfRecords1		 = noOfRecordsTemp.intValue() ;
			int fm_disp1			 = 0 ;
			int to_disp1			 = noOfRecords1 ;


			if(noOfRecords1!= 0)
			{	
				dummpPageSettings.put("noOfRecords",String.valueOf(noOfRecords1));
				String 	patient_class="";
				HashMap currRecSettings=null;
				String setting_applicability_default="";
				String age_group_code = ""; //IN063686
				for(int j=fm_disp1; j<= to_disp1;j++)
				{

					patient_class	= "";
					boolean contVal			= false ;

					if(j==0)
					{
						contVal =true ;//always the all patient class(*A)  will  be present in the DataBase
						patient_class = "*A";
					}
					else
					{
						patient_class  = (String)pat_class.get("PATIENT_CLASS"+j);
						contVal = defVal1.containsKey(patient_class.trim()) ;
					}

					if(contVal)
					{//Value form the DataBase
						currRecSettings			=(HashMap)defVal1.get(patient_class.trim());
						setting_applicability_default   =(String)currRecSettings.get("setting_applicability");
						age_group_code = (String)currRecSettings.get("age_group_code"); //IN063686
						if(setting_applicability_default.trim().equalsIgnoreCase("A"))
						{
							dummpPageSettings.put("patient_class"+j				,patient_class.trim());
							dummpPageSettings.put("setting_applicability"+j		,setting_applicability_default);
							dummpPageSettings.put("age_group_code"+j		,age_group_code);//IN063686
							continue ;
						}
					}

					dummpPageSettings.put("patient_class"+j				,patient_class.trim());
					dummpPageSettings.put("setting_applicability"+j		,"X");
					dummpPageSettings.put("age_group_code"+j		,"");//IN063686
				}

			}

			settingsSync(dummpPageSettings)	; //Syn if the str is empty
		}
		recordStoreParam.put("settingsStr"		,settingsRecStr);
		recordStoreParam.put("componentStr"		,componentStr.getAllDBRecords());

		recordStoreParam.put("billingRecStr"		,billingRecStr);
		recordStoreParam.put("login_by_id"		,login_by_id) ;
		recordStoreParam.put("login_at_ws_no"	,login_at_ws_no ) ;
		recordStoreParam.put("login_facility_id",login_facility_id ) ;
		recordStoreParam.put("appl_to",getApplicableTo());//IN68241
		recordStoreParam.put("MappedFacilities",mappedFacilities );//IN068370,IN068373
		recordStoreParam.put("GlobalFacilityYn",getGlobalFacilityYn());//IN068370,IN068373
		recordStoreParam.put("SiteSpecGlobalFac", isOrderCatalogFacWise);//IN068370,IN068373

		sqlMap.put("SQL_OR_ORDERSET_UPDATE"				,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_UPDATE"));
		sqlMap.put("SQL_OR_ORDERSET_INSERT_SYNONYM"		,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_INSERT_SYNONYM"));
		sqlMap.put("SQL_OR_ORDERSET_INSERT_BY_PTCL"		,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_INSERT_BY_PTCL"));

		//IN062992, starts
		//sqlMap.put("SQL_OR_ORDERSET_INSERT_COMP"		,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_INSERT_COMP"));
		if(isSiteSpecificYN())
		{
			sqlMap.put("SQL_OR_ORDERSET_INSERT_COMP"		,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_INSERT_COMP_ONCOLOGY"));
		}
		else
		{
			sqlMap.put("SQL_OR_ORDERSET_INSERT_COMP"		,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_INSERT_COMP"));
		}
		//IN062992, ends

		sqlMap.put("SQL_OR_ORDERSET_SYNONYM_DELETE"		,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_SYNONYM_DELETE"));
		sqlMap.put("SQL_OR_ORDERSET_COMP_DELETE"		,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_COMP_DELETE"));
		sqlMap.put("SQL_OR_ORDERSET_PTCL_DELETE"		,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_PTCL_DELETE"));
		sqlMap.put("SQL_OR_ORDERSET_EFF_STATUS_SELECT"	,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_EFF_STATUS_SELECT"));
		sqlMap.put("SQL_OR_ORDERSET_EFF_STATUS_UPDATE"	,OrRepository.getOrKeyValue("SQL_OR_ORDERSET_EFF_STATUS_UPDATE"));
		
		sqlMap.put("SQL_OR_ORDER_SET_COMPONENT_ADD_SELECT"	,OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_SET_COMPONENT_ADD_SELECT"));
		sqlMap.put("SQL_OR_ORDER_SET_COMPONENT_ADD_DELETE"	,OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_SET_COMPONENT_ADD_DELETE"));

		//IN062992, starts
		if(isSiteSpecificYN())
		{
			sqlMap.put("SQL_OR_ORDERSET_COMP_AGE_WISE_INSERT",OrRepository.getOrKeyValue("SQL_OR_ORDERSET_COMP_AGE_WISE_INSERT"));			
			sqlMap.put("SQL_OR_ORDERSET_COMP_AGE_WISE_SELECT",OrRepository.getOrKeyValue("SQL_OR_ORDERSET_COMP_AGE_WISE_SELECT"));			
			sqlMap.put("SQL_OR_ORDERSET_COMP_AGE_WISE_DELETE",OrRepository.getOrKeyValue("SQL_OR_ORDERSET_COMP_AGE_WISE_DELETE"));
			
			//IN68241, starts
			sqlMap.put("SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_INSERT",OrRepository.getOrKeyValue("SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_INSERT"));			
			sqlMap.put("SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_SELECT",OrRepository.getOrKeyValue("SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_SELECT"));			
			sqlMap.put("SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_DELETE",OrRepository.getOrKeyValue("SQL_OR_ORDERSET_COMP_DOSAGE_TYPE_WISE_DELETE"));
			//IN68241, starts
		}
		//IN062992, ends
		//IN068370,IN068373, starts
		if("Y".equals(getGlobalFacilityYn()) && isOrderCatalogFacWise)
		{
			sqlMap.put("SQL_OR_CATALOG_BY_FACILITY_INSERT", OrRepository.getOrKeyValue("SQL_OR_CATALOG_BY_FACILITY_INSERT"));
			sqlMap.put("SQL_OR_CATALOG_BY_FACILITY_DELETE", OrRepository.getOrKeyValue("SQL_OR_CATALOG_BY_FACILITY_DELETE"));
		}
		//IN068370,IN068373, ends

		map.put("recordStoreParam",recordStoreParam);
		map.put("////sqlMap",sqlMap);

		return getResult(recordStoreParam,sqlMap );


	}
	catch(Exception e)
	{
		tempChk.append(e.getMessage());
		logErrorMessage(e);
		e.printStackTrace();
		return null;
	}

}

/*********************METHOD TO Delete*************************/

public HashMap delete()
{
	HashMap map = new HashMap();
	map.put( "result", new Boolean( false ) ) ;
	map.put( "message", "delete failure.." );
	return map;
}

/*********************DoCommon*************************/
private void doCommon() throws Exception
{
}
/****************GET RESULT******************************/
public String getComboOptions(String opt,String defaultval , String sqlParams) throws Exception
{


	Connection connection =null ;
	PreparedStatement pstmt=null;
	String Ph_installed="N";
	ResultSet rs=null;
	String str = "";
	String sql = "";
	String[] language_id_param = new String[1];


	if(opt.trim().equalsIgnoreCase(""))
	return "";

	try
	{
	
		language_id_param[0] = language_id;
		connection = getConnection();
		if(opt.trim().equalsIgnoreCase("OrderCategory"))
		{
			str = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST"),connection,"ORDER_CATEGORY","SHORT_DESC",defaultval.trim(),language_id_param);
		}
		else if(opt.trim().equalsIgnoreCase("OrderType"))
		{
			if(!sqlParams.trim().equals("")){//called will painting only jsp if OrderCategory is passed
			sql = OrRepository.getOrKeyValue("SQL_OR_ORDERSET_ORDER_TYPE") ;
			String sqlParam[] = {sqlParams};
			str = Populate.getComboOptions(sql,connection,"ORDER_TYPE_CODE","SHORT_DESC",defaultval.trim(),sqlParam); }
		}
		else if(opt.trim().equalsIgnoreCase("ActivityType"))
		{
		
			String param[] = new String[3];
			StringTokenizer stktok = new StringTokenizer(sqlParams,",");
			int i=0;
			while(stktok.hasMoreTokens())
			{				
				param[i] = stktok.nextToken();
				i++;
			}

			str = Populate.getComboOptions_sp(OrRepository.getOrKeyValue("SQL_OR_ORDERSET_ACTIVITY_TYPE"),connection,"ACTIVITY_TYPE","SHORT_DESC",defaultval.trim(),param);
		}
		else if(opt.trim().equalsIgnoreCase("iv_prep_yn"))
		{
			try
			{	
				pstmt=connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CHECK_MODULE_INSTALL_YN"));
				pstmt.setString(1,"PH");
				rs=pstmt.executeQuery();
				if(rs.next())
				{
					Ph_installed=rs.getString(1);
				}

				if (Ph_installed.equalsIgnoreCase("Y"))
				{
					
					str = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_ORDERSET_IV_PREP_YN"),connection,"Code","Short_Desc",defaultval.trim());
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else 
		{//directly sql is passed
			str = Populate.getComboOptions(opt,connection ,"code" ,"short_desc",defaultval.trim());
		}

		return str;
	}
	catch(Exception e)
	{
		e.printStackTrace();
			logErrorMessage(e);
			throw new Exception(e.getMessage());
	}
	finally
	{
		try
		{
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConnection(connection);
				
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}
	}
}
/*************get Combo Options Dynamic Population(Header Frame)***********/
public String getComboBoxHtml(Hashtable ht) throws Exception
{
	String optionString = "";
	String comboBoxString = "";
	Connection connection = null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String ph_installed="N";
	try
	{
		if( ht == null )
			return "Hashtable Passed to  this method is null";

		connection = getConnection();
	 	String  type = (String)ht.get("type");
		if(type.trim().equalsIgnoreCase("OrderCategory"))
		{
			String sqlParams[] = {(String)ht.get("order_category")};
			optionString  = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_ORDERSET_ORDER_TYPE"),connection,"ORDER_TYPE_CODE","SHORT_DESC",sqlParams);
		   	comboBoxString="<select name='order_type_code' onChange='parent.parent.fillComboOptions(this);parent.parent.display(\\\"S\\\")' ><option>-------------Select----------</option>"+optionString + "</select><img src='../../eCommon/images/mandatory.gif'></img>" ;
		}
		else if(type.trim().equalsIgnoreCase("OrderType"))
		{
			String[] sqlparam=new String[3];
			sqlparam[0]=(String)ht.get("order_category");
			sqlparam[1]=(String)ht.get("order_type_code");
			sqlparam[2]=(String)ht.get("order_category");
			
			optionString  = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_ORDERSET_ACTIVITY_TYPE"),connection,"ACTIVITY_TYPE","SHORT_DESC",sqlparam);

			comboBoxString="<select name='activity_type'  ><option>-------------Select----------</option>"+optionString + "</select>" ;

		//	tempChk = "";
		}
		else if(type.trim().equalsIgnoreCase("iv_prep_yn"))
		{
			try
			{
						
				pstmt=connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CHECK_MODULE_INSTALL_YN"));
				pstmt.setString(1,"PH");
				rs=pstmt.executeQuery();
				if(rs.next())
					ph_installed=rs.getString(1);

				if(ph_installed.equalsIgnoreCase("Y"))
				{
					//String sqlParams[] = {(String)ht.get("order_category")};
					optionString  = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_ORDERSET_IV_PREP_YN"),connection,"Code","Short_Desc ");
					comboBoxString="<select name='iv_prep_yn' ><option value=''>-------------Select----------</option>"+optionString + "</select><img src='../../eCommon/images/mandatory.gif'></img>" ;
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else
			throw new Exception("Exception :-in Bean getComboBoxHtml function Hashtable Passed should contain order_category  only");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		finally
		{
			try
			 {
				closeResultSet(rs);
				closeStatement(pstmt);
				closeConnection(connection);
			 }
			catch(Exception e)
			{ 
				e.printStackTrace() ;
			}
		}

	return comboBoxString;

}/****METHOD TO load OrderCategory code-desc for Query Page********/

public String getComboString() 
{
	Connection 	connection  = null;
	java.sql.PreparedStatement pstmt = null;
	java.sql.ResultSet rs	= null;

	try
	{
		connection  		= getConnection();
		pstmt				= connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST"));
		pstmt.setString(1,language_id);
		rs					= pstmt.executeQuery();
	    StringBuffer sb		= new StringBuffer();
		String  codeCol="";
		String  codeDesc="";
		while (rs.next())
		{
			codeCol			    = ChkDef.defaultString(rs.getString(1));
			codeDesc			= ChkDef.defaultString(rs.getString(2));
			sb.append(codeDesc + "," + codeCol + ",");
		}

		 String str =   sb.toString() ;
		 sb.setLength(0);
		 return str.substring(0, str.length()-1);
	}
	catch(Exception e){
		e.printStackTrace();
		return null;
	}
	finally
	{
		try
		 {
		 	closeResultSet(rs);
		 	closeStatement(pstmt);
			closeConnection(connection);
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace() ;
		 }
	}
}

/*************************just get the result as Hash table WHEN SQL IS PASSED***************/
public  Hashtable getSqlResultParamModule(String sql , String[] params ,int indStart) throws Exception
{
	Connection connection	= null ;
	PreparedStatement pstmt = null ;
	ResultSet rs			= null;
	ResultSetMetaData rsmd	= null ;
	String 	columnName		= null ;
	int 	columnCount		= -1 ;

	Hashtable result = new Hashtable();

	int paramslen  = params.length ;

	try
	{
		connection = getConnection();
		pstmt	   = connection.prepareStatement(sql);
		for (int i = 0; i < paramslen ; i++ ){
			pstmt.setString(i+1, (params[i]).trim());
		}

		rs		   = pstmt.executeQuery()  ;
		rsmd	   = rs.getMetaData()      ;
		columnCount= rsmd.getColumnCount() ;
		int counter= 0 ;

		while (rs.next()){

			counter++;
			for(int i = 1; i <= columnCount ; i++){
					columnName	= rsmd.getColumnName(i)  ;
				if(indStart == -1 )
					result.put((columnName.toLowerCase()),ChkDef.defaultString(rs.getString(columnName)));
				else
					result.put(((columnName.toLowerCase()+counter).trim()),ChkDef.defaultString(rs.getString(columnName)));
			}

		}
		result.put("noRec",new Integer(counter));


		return result ;
	}
	catch(Exception e)
	{
		throw new Exception(e.getMessage());
	}
	finally
	{
		try
		{
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConnection(connection);
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace() ;
		 }
	}

}

/***************rewiews Syn************************************/
private void settingsSync(Hashtable request)
{
	HashMap record= null;
	boolean flag = settingsRecStr.isEmpty() ;//to Chk  whether  the client has visited this tab before


	int noOfRecords = Integer.parseInt(chkPresent(request,"noOfRecords","-1")) ;

	for (int i = 0 ; i <= noOfRecords ; i++)
	{//0th rec for ALL patient  class which is hard coded

		if(!flag)
			record = (HashMap)settingsRecStr.get(i);
		else
			record = new HashMap();

		record.put("patient_class"				,chkPresent(request,"patient_class"+i,""));
		record.put("setting_applicability"		,chkPresent(request,"setting_applicability"+i,"X"));
		//IN006321 starts
		//record.put("age_group_code"		,chkPresent(request,"age_group_code"+i,"X")); //IN063686
		record.put("age_group_code"		,chkPresent(request,"age_group_code"+i,"")); //IN006321
		//IN006321 ends
		if(flag)//only when str was empty
		settingsRecStr.add(record);

	}

}

/*****Default Load for settings tab/for other module defaults or modify*****/
public Hashtable settingsDefault(String sql , String defaultFor ,String sqlParam[])
{

	Hashtable retVal =   new Hashtable();
	Hashtable result =   null;

	try
	{
	
		if(defaultFor.trim().equalsIgnoreCase("update"))
		{
			sql     =  OrRepository.getOrKeyValue(sql.trim());
			result  =  getSqlResultParamModule(sql,sqlParam , 1);
		}


		Integer	size_res = (Integer)result.get("noRec") ;
		int size		 =  size_res.intValue();

		if(size == 0)
		return retVal;
		HashMap	record=null;
		String 	patient_class="";
		for (int i = 1 ; i <= size ; i++)
		{

			record = new HashMap();
			record.put("patient_class"				,chkPresent(result,"patient_class"+i,""));
			record.put("setting_applicability"		,chkPresent(result,"setting_applicability"+i,"A"));
			record.put("age_group_code"		,chkPresent(result,"age_group_code"+i,"")); //IN063686
			record.put("qty_uom"					,chkPresent(result,"qty_uom"+i,""));
			//In case of other module calling

			patient_class =	chkPresent(result,"patient_class"+i,"-1")	;

			retVal.put(patient_class.trim(),record);
		}

		return  retVal ;
  }
  catch(Exception e)
  {
		e.printStackTrace();
		return null;
  }
}

/***************rewiews Syn************************************/
private void synonymsSync(Hashtable request){
	HashMap record= null;

	if(!synonymsRecStr.isEmpty())
		record = (HashMap)synonymsRecStr.get(0);
	else
		record = new HashMap();

	record.put("catalog_synonym_primary"		,chkPresent(request,"catalog_synonym_primary",""));
	record.put("effective_status_primary"		,chkPresent(request,"effective_status_primary","N"));
	record.put("catalog_synonym_directCare"		,chkPresent(request,"catalog_synonym_directCare",""));
	record.put("effective_status_directCare"	,chkPresent(request,"effective_status_directCare","N"));
	record.put("catalog_synonym_ancillaryDept"	,chkPresent(request,"catalog_synonym_ancillaryDept",""));
	record.put("effective_status_ancillaryDept"	,chkPresent(request,"effective_status_ancillaryDept","N"));


	if(synonymsRecStr.isEmpty())
		synonymsRecStr.add(record);

}

/********componentSyn************************************************************/
private void componentSyn(Hashtable request){


String detailPageMode_p	=(String)request.get("detailPageMode") ;
this.action				=(String)request.get("action") ;




if(detailPageMode_p.equalsIgnoreCase("S")){//i:e if detail page mode was selected
	updateCurrentPageForAsscStore(request);
}

if(detailPageMode_p.equalsIgnoreCase("A")){
	synAsscStore(request);
}

}
/**************************explanatorySyn********************/

private void explanatorySync(Hashtable request){

	HashMap record= null;
	if(!explanatoryRecStr.isEmpty())
		record = (HashMap)explanatoryRecStr.get(0);
	else
		record = new HashMap();  

//    careSetHeaderStr.put("explanatory_text",chkPresent(request,"explanatory_text",""));

	record.put("explanatory_text"		,chkPresent(request,"explanatory_text",""));	

	if(explanatoryRecStr.isEmpty())
		explanatoryRecStr.add(record);   

}

/******************Update   Records  *********************/
private void updateCurrentPageForAsscStore(Hashtable request){

	int fm_disp  =ChkDef.defaultInt(((String)request.get("previousRecord")));
	int to_disp	 =ChkDef.defaultInt(((String)request.get("nextRecord")));
try{
	String ascc="";
	HashMap ht=null;

	for (int i = fm_disp-1; i <to_disp ; i++){

		ascc = checkForNull(((String)request.get("include" + i)),"N");

		ht  =(HashMap)componentStr.getListObject(i);

		String pk[] ={(String)ht.get("order_catalog_code")};//Primary Key

		ht = Validaty(ht); //this will give the inserted record if already present in the  ascc  str

		if(((String)ht.get("valid")).trim().equalsIgnoreCase("Y"))//if the curr rec is database rec then return	since we won't change it
		continue ;

		if(ascc.trim().equalsIgnoreCase("Y")){

      
        String d_t = ((String)request.get("durn_type" + i));

		if(d_t.equals("null") || d_t.equals(" ") || d_t==null)
		{
          d_t = "";
		}

			ht.put("order_set_seq_num"		,ChkDef.defaultString(((String)request.get("order_set_seq_num" + i))));
			ht.put("order_type_code"		,ChkDef.defaultString(((String)request.get("order_type_code" + i))));
			ht.put("qty_unit"				,checkForNull((String)request.get("qty_unit" + i),"1"));
			ht.put("qty_value"				,checkForNull((String)request.get("qty_uom" + i),""));		
			ht.put("route_code"				,checkForNull((String)request.get("route_code" + i),""));		
			ht.put("freq_code"				,ChkDef.defaultString(((String)request.get("freq_code" + i))));
			ht.put("durn_value"				,ChkDef.defaultString(((String)request.get("durn_value" + i))));
			ht.put("durn_type"				,ChkDef.defaultString(((String)request.get("durn_type" + i))));
			ht.put("rel_start_date_time"	,ChkDef.defaultString(((String)request.get("rel_start_date_time" + i))));
			ht.put("reqd_or_opt_ind"		,ChkDef.defaultString(((String)request.get("reqd_or_opt_ind" + i))));
			ht.put("item_narration"			,""); //Not used in 2nd phase
			ht.put("occ_no"			,ChkDef.defaultString(((String)request.get("occ_no" + i)))); //Not used in 2nd phase
			ht.put("route_code"				,checkForNull((String)request.get("route_code" + i),"")); //Not used in 2nd phase
		   	ht.put("valid"					,"N");
			ht.put("associate_yn"			,"y");
			ht.put("status"					,"y");
			ht.put("prompt_msg"				,ChkDef.defaultString(((String)request.get("prompt_msg" + i))));
			ht.put("dosage_type"				,ChkDef.defaultString(((String)request.get("dosage_type" + i))));//IN062992


			componentStr.setObject(pk,ht);//Will add or set depending upon the primary key match

		}else{//remove form assoc list if alreay asccociated
			int indx = componentStr.containsElement(pk);
			if(indx != -1 )
			componentStr.removeObject(indx);
		}

	}
}catch(Exception e){
	e.printStackTrace();
	logErrorMessage(e);
}
}
/**************************Synchronize in Associated Mode****************/
private void  synAsscStore(Hashtable request){

int fm_disp  =ChkDef.defaultInt(((String)request.get("previousRecord")));
int to_disp	 =ChkDef.defaultInt(((String)request.get("nextRecord")));

  try{
	  Hashtable ht =null;
	for (int i = fm_disp-1;i<to_disp;i++){
		ht  = new Hashtable();
		ht.put("order_set_seq_num"		,ChkDef.defaultString(((String)request.get("order_set_seq_num" + i))));
		ht.put("order_type_code"		,ChkDef.defaultString(((String)request.get("order_type_code" + i))));
		ht.put("qty_unit"				,checkForNull((String)request.get("qty_unit" + i),"1"));
		ht.put("qty_value"				,checkForNull((String)request.get("qty_uom" + i),"")); 
		ht.put("route_code"				,checkForNull((String)request.get("route_code" + i),"")); 
		ht.put("freq_code"				,ChkDef.defaultString(((String)request.get("freq_code" + i))));
		ht.put("durn_value"				,ChkDef.defaultString(((String)request.get("durn_value" + i))));
		ht.put("rel_start_date_time"	,ChkDef.defaultString(((String)request.get("rel_start_date_time" + i))));
		ht.put("durn_type"				,ChkDef.defaultString(((String)request.get("durn_type" + i))));
		ht.put("reqd_or_opt_ind"		,ChkDef.defaultString(((String)request.get("reqd_or_opt_ind" + i))));
		ht.put("prompt_msg"		,ChkDef.defaultString(((String)request.get("prompt_msg" + i))));
		ht.put("item_narration"			,""); //Not used in 2nd phase
		ht.put("occ_no"			,ChkDef.defaultString(((String)request.get("occ_no" + i))));
		ht.put("route_code"				,checkForNull((String)request.get("route_code" + i),"")); //Not used in 2nd phase
		ht.put("include"				,checkForNull((String)request.get("include" + i),"N"));
		ht.put("dosage_type"				,checkForNull((String)request.get("dosage_type" + i),""));//IN062992


		componentStr.setDBBeanValue(i,ht);
		}
   }catch(Exception e){
	e.printStackTrace();
	logErrorMessage(e);
	}

}


/*****************************************/
public String getqty_uom_desc(String uom_code) {
	
Connection connection	= null ;
PreparedStatement pstmt = null ;
ResultSet rs			= null;
String result="N";

try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CATALOG_QTY_UOM_DESC") ) ;
			pstmt.setString(1, uom_code);
			rs = pstmt.executeQuery() ;
			while (rs.next()){			
			result=rs.getString(1);
			}

}
catch( Exception e )
	{
		e.printStackTrace() ;
	}
finally
	{
	try{
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		} catch (Exception ee) {

				ee.printStackTrace() ;
		}
	}
	return result;
}
/*******************************************/


/********Gives the DataBase Record if already  present or for Ascc /else Original DataBase record***********/
public synchronized HashMap Validaty(HashMap record )
{
	try
	{
		String pk[] ={(String)record.get("order_catalog_code")};//Primary Key

		int index =	componentStr.containsElement(pk) ;

		if(index != -1)
		{//Rec is there in Ascc store

			HashMap tempChk	 =(HashMap)componentStr.getObject(index);
			String valid = (String)tempChk.get("valid");

			if(valid.trim().equalsIgnoreCase("Y"))
			{//if it was form DataBase
				int indexOriginal = componentStr.containsElementInOriginalDB(pk);

				if(indexOriginal != -1)
					return (HashMap)componentStr.getObjectOriginal(indexOriginal) ;//DataBase record
				else
					return null ;//Some Error Condition Chk it
			}
			else
				return (HashMap)componentStr.getObject(index) ;//Ascc record

		 }
		 else
		 { //not in ascc store

			return record;
		  }	 //return Original
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return null ;
	}
}

/**********************Handle Action in all scenario's***********************/
public synchronized  void handleAction(HttpServletRequest request){


  String detailPageMode_p	=request.getParameter("detailPageMode") ;
  this.action				=request.getParameter("action") ;

  setApplicableTo(request.getParameter("applicable_to"));//IN062992

//All sync done js--Sync method and not here
//Scenario will be called in apply Method

//No mode
  if(detailPageMode_p.equalsIgnoreCase("N")){

	if(action.equalsIgnoreCase("IndexSelect")) {//scenario
	loadIndexData(request);

	this.detailPageMode = "S" ;
	}

	if(action.equalsIgnoreCase("select")) //scenario
	this.detailPageMode = "S" ;

	if(action.equalsIgnoreCase("associated"))//scenario
	this.detailPageMode = "A" ;

	//loadRecordedData(request);//scenario   DB records already ascc
	loadRecordedData();//scenario   DB records already ascc

 }

 //Select mode
 if(detailPageMode_p.equalsIgnoreCase("S")){
//	updateCurrentPageForAsscStore(request);//scenario  --even in case of next prev

	if(action.equalsIgnoreCase("indexSelect")){//scenario
	loadIndexData(request);
	this.detailPageMode = "S" ;
	}

	if(action.equalsIgnoreCase("associated")){//Scenario
	this.detailPageMode = "A" ;
	}
}
 //Ass mode
 if(detailPageMode_p.equalsIgnoreCase("A")){
//	synAsscStore(request);//scenario --even in case of next prev
  	this.detailPageMode = "A" ;
}

}//End of Handle Method
 /******************************************************************************/
// public synchronized int  loadRecordedData(HttpServletRequest request){
public synchronized int  loadRecordedData(){


//Used in  update mode only
if(careSetHeaderStr.isEmpty()) //i:e in the insert mode
	return 0 ;

if(componentStr.getSize("DB")>0)
	return componentStr.getSize("DB");
Connection connection		  = null ;
PreparedStatement pstmt		  = null ;
ResultSet rs				  = null;
String sql		 ="";
String l_order_category = (String)getCareSetHeaderStr().get("order_category");//IN062992

try
{
		connection	 =  getConnection();
	//	sql			 = OrRepository.getOrKeyValue("SQL_OR_ORDERSET_LOAD_COMPONENT") ;
		
		//IN062992, starts		
		//sql			 = "SELECT a.ORDER_SET_SEQ_NUM ORDER_SET_SEQ_NUM,a.ORDER_CATALOG_CODE ORDER_CATALOG_CODE,b.short_desc short_desc, b.qty_reqd_yn qty_reqd_yn, b.freq_applicable_yn freq_applicable_yn,a.ORDER_TYPE_CODE ORDER_TYPE_CODE,c.SHORT_DESC order_type_desc,a.ORDER_CATEGORY ORDER_CATEGORY,REQD_OR_OPT_IND, REL_START_DATE_TIME,ROUTE_CODE ,a.QTY_VALUE QTY_VALUE,a.qty_unit QTY_UNIT ,a.FREQ_CODE FREQ_CODE,a.DURN_VALUE DURN_VALUE,a.DURN_TYPE DURN_TYPE,ITEM_NARRATION FROM or_order_set_component a ,  OR_ORDER_CATALOG b,OR_ORDER_TYPE c WHERE b.ORDER_CATALOG_CODE = a.ORDER_CATALOG_CODE AND c.ORDER_TYPE_CODE = b.ORDER_TYPE_CODE AND order_set_code = ? and order_catalog_nature !='S' and  OCURRANCE_NUM =1" ;
		if(isSiteSpecificYN() && "PH".equals(l_order_category))
		{
			sql			 = "SELECT a.ORDER_SET_SEQ_NUM ORDER_SET_SEQ_NUM,a.ORDER_CATALOG_CODE ORDER_CATALOG_CODE,b.short_desc short_desc, b.qty_reqd_yn qty_reqd_yn, b.freq_applicable_yn freq_applicable_yn,a.ORDER_TYPE_CODE ORDER_TYPE_CODE,c.SHORT_DESC order_type_desc,a.ORDER_CATEGORY ORDER_CATEGORY,REQD_OR_OPT_IND, REL_START_DATE_TIME,a.ROUTE_CODE ,a.QTY_VALUE QTY_VALUE,a.qty_unit QTY_UNIT ,a.FREQ_CODE FREQ_CODE,a.DURN_VALUE DURN_VALUE,a.DURN_TYPE DURN_TYPE,ITEM_NARRATION,DOSAGE_TYPE,d.strength_value, d.strength_uom,OCURRANCE_NUM FROM or_order_set_component a ,  OR_ORDER_CATALOG b,OR_ORDER_TYPE c, ph_drug d WHERE b.ORDER_CATALOG_CODE = a.ORDER_CATALOG_CODE and b.order_catalog_code = d.drug_code AND c.ORDER_TYPE_CODE = b.ORDER_TYPE_CODE AND order_set_code = ? and order_catalog_nature !='S' and  OCURRANCE_NUM =1" ;
		}
		else
		{
			sql			 = "SELECT a.ORDER_SET_SEQ_NUM ORDER_SET_SEQ_NUM,a.ORDER_CATALOG_CODE ORDER_CATALOG_CODE,b.short_desc short_desc, b.qty_reqd_yn qty_reqd_yn, b.freq_applicable_yn freq_applicable_yn,a.ORDER_TYPE_CODE ORDER_TYPE_CODE,c.SHORT_DESC order_type_desc,a.ORDER_CATEGORY ORDER_CATEGORY,REQD_OR_OPT_IND, REL_START_DATE_TIME,ROUTE_CODE ,a.QTY_VALUE QTY_VALUE,a.qty_unit QTY_UNIT ,a.FREQ_CODE FREQ_CODE,a.DURN_VALUE DURN_VALUE,a.DURN_TYPE DURN_TYPE,ITEM_NARRATION,OCURRANCE_NUM FROM or_order_set_component a ,  OR_ORDER_CATALOG b,OR_ORDER_TYPE c WHERE b.ORDER_CATALOG_CODE = a.ORDER_CATALOG_CODE AND c.ORDER_TYPE_CODE = b.ORDER_TYPE_CODE AND order_set_code = ? and order_catalog_nature !='S' and  OCURRANCE_NUM =1" ;
		}
		//IN062992, ends
		
		pstmt		 = connection.prepareStatement(sql);
		pstmt.setString(1,(String)careSetHeaderStr.get("order_set_code"));

	    rs           = pstmt.executeQuery();

		while(rs.next()){
		HashMap tempHash = new HashMap();//Represents each record
			HashMap tempHashO = new HashMap();//Represents each record
		
		loadOrderTypeCodeFreq(rs.getString("order_category"),rs.getString("order_catalog_code"));
		
		HashMap orderFreqStr = getOrderFreqStr();
		ArrayList freq_val	   =(ArrayList)orderFreqStr.get("value") ;
		ArrayList freq_desc    =(ArrayList)orderFreqStr.get("Description") ;

		HashMap  orderTypeStr = getOrderTypeStr();
		ArrayList order_val	   =(ArrayList)orderTypeStr.get("value") ;
		ArrayList order_desc   =(ArrayList)orderTypeStr.get("Description") ;		

		tempHash.put("order_category"		,rs.getString("order_category"));
		tempHash.put("order_catalog_code"	,rs.getString("order_catalog_code"));
		tempHash.put("order_catalog_desc"	,rs.getString("short_desc"));
		tempHash.put("order_type_code"		,rs.getString("order_type_code"));
		tempHash.put("order_type_desc"		,rs.getString("order_type_desc"));
		tempHash.put("order_set_seq_num"	,rs.getString("order_set_seq_num"));
		tempHash.put("prompt_msg"		 ,rs.getString("item_narration")); //Not used in 2nd phase
		tempHash.put("qty_value"	         ,checkForNull(rs.getString("qty_unit"),"1"));
//		tempHash.put("qty_value"	         ,""); //Not used in 2nd phase
		tempHash.put("route_code"	         ,rs.getString("route_code")); //Not used in 2nd phase
		tempHash.put("qty_unit"				 ,checkForNull(rs.getString("qty_value"),""));
 
 
		tempHash.put("qty_reqd_yn"		     ,checkForNull(rs.getString("qty_reqd_yn"),"N"));
		tempHash.put("freq_applicable_yn"	 ,checkForNull(rs.getString("freq_applicable_yn"),"N"));
		tempHash.put("freq_code"			 ,checkForNull(rs.getString("freq_code")));
		tempHash.put("durn_value"			 ,checkForNull(rs.getString("durn_value")));
		tempHash.put("durn_type"			 ,checkForNull(rs.getString("durn_type")));
		tempHash.put("freq_val_opts"		 ,freq_val);
		tempHash.put("freq_desc_opts"		 ,freq_desc);
		tempHash.put("order_val_opts"		 ,order_val);
		tempHash.put("order_desc_opts"		 ,order_desc);
		tempHash.put("rel_start_date_time"	 ,checkForNull(rs.getString("rel_start_date_time")));
		tempHash.put("reqd_or_opt_ind"		 ,checkForNull(rs.getString("reqd_or_opt_ind")));
		tempHash.put("valid"				,"Y");
		tempHash.put("associate_yn"			,"Y");
		tempHash.put("status"				,"Y");
		tempHash.put("occ_no"				,checkForNull(rs.getString("OCURRANCE_NUM")));

		//IN062992, starts
		if(isSiteSpecificYN() && "PH".equals(l_order_category))
		{
			tempHash.put("dosage_type"		 ,checkForNull(rs.getString("dosage_type"),""));
			tempHash.put("strength_uom"		 ,checkForNull(rs.getString("strength_uom"),""));
			tempHash.put("strength_value"		 ,checkForNull(rs.getString("strength_value"),""));
		}
		//IN062992, ends


		tempHashO.put("order_category"	,rs.getString("order_category"));
		tempHashO.put("order_catalog_code"	,rs.getString("order_catalog_code"));
		tempHashO.put("order_catalog_desc"	,rs.getString("short_desc"));
		tempHashO.put("order_type_code"		,rs.getString("order_type_code"));
		tempHashO.put("order_type_desc"		,rs.getString("order_type_desc"));
		tempHashO.put("order_set_seq_num"	,rs.getString("order_set_seq_num"));
		tempHashO.put("prompt_msg"		 ,rs.getString("item_narration"));//Not used in 2nd phase
		tempHashO.put("qty_value"	         ,checkForNull(rs.getString("qty_unit"),"1")); //Not used in 2nd phase
	//	tempHashO.put("qty_value"	         ,""); //Not used in 2nd phase
		tempHashO.put("route_code"	         ,rs.getString("route_code")); //Not used in 2nd phase
		tempHashO.put("qty_unit"			 ,checkForNull(rs.getString("qty_value"),""));
		tempHashO.put("qty_reqd_yn"			 ,checkForNull(rs.getString("qty_reqd_yn"),"N"));
		tempHashO.put("freq_applicable_yn"	 ,checkForNull(rs.getString("freq_applicable_yn"),"N"));
		tempHashO.put("freq_code"			 ,checkForNull(rs.getString("freq_code")));
		tempHashO.put("durn_value"			 ,checkForNull(rs.getString("durn_value")));
		tempHashO.put("durn_type"			 ,checkForNull(rs.getString("durn_type")));
		tempHashO.put("freq_val_opts"		 ,freq_val);
		tempHashO.put("freq_desc_opts"		 ,freq_desc);
		tempHashO.put("order_val_opts"		 ,order_val);
		tempHashO.put("order_desc_opts"		 ,order_desc);
		tempHashO.put("rel_start_date_time"	 ,checkForNull(rs.getString("rel_start_date_time")));
		tempHashO.put("reqd_or_opt_ind"		 ,checkForNull(rs.getString("reqd_or_opt_ind")));
		tempHashO.put("valid"				,"Y");
		tempHashO.put("associate_yn"		,"Y");
		tempHashO.put("status"				,"Y");
		
		//IN062992, starts
		if(isSiteSpecificYN() && "PH".equals(l_order_category))
		{
			tempHashO.put("dosage_type"		 ,checkForNull(rs.getString("dosage_type"),""));
			tempHashO.put("strength_uom"		 ,checkForNull(rs.getString("strength_uom"),""));
			tempHashO.put("strength_value"		 ,checkForNull(rs.getString("strength_value"),""));
		}
		//IN062992, ends

		componentStr.putObject(tempHash);
		componentStr.putObjectOriginal(tempHashO);
	} //End of while loop


  }catch(Exception e){

			e.printStackTrace();
			tempChk.append("in loadRecordedData exception="+e);
  }finally{
		try
		 {
		 	closeResultSet( rs );
		 	closeStatement(pstmt);
			closeConnection(connection);
		 }catch(Exception e){

             e.printStackTrace() ;

		 }
  }

   return componentStr.getSize("DB");

}
/***********************************************************************/
private int  loadIndexData(HttpServletRequest request){

	Connection connection		  = null ;
	PreparedStatement pstmt		  = null ;
	PreparedStatement pstmt1	  = null;
	ResultSet rs				  = null;
	ResultSet rs1				  = null;
	String order_category		  = request.getParameter("order_category");
	String OrderCatalogIndex	  = request.getParameter("OrderCatalogIndex");

	String sql					  = "";
	String fpp_yn = request.getParameter("fpp_yn");//IN068314
	
	Boolean isfppapplicable = getIsFPPApplicable();//IN068314
try
{
	connection	 = getConnection();
	if(!order_category.trim().equalsIgnoreCase("CS")){
		if(!OrderCatalogIndex.trim().equalsIgnoreCase("others")){

		  //sql = OrRepository.getOrKeyValue("SQL_OR_ORDERSET_CATALOG_CODE") ;//IN034227,starts
		  //IN062992, starts
		  //sql = "SELECT   a.order_catalog_code, a.short_desc, a.order_type_code,b.short_desc order_type_desc, a.order_category order_category,a.qty_reqd_yn, a.freq_applicable_yn FROM or_order_catalog a, or_order_type b ";
		  sql = "SELECT   a.order_catalog_code, a.short_desc, a.order_type_code,b.short_desc order_type_desc, a.order_category order_category,a.qty_reqd_yn, a.freq_applicable_yn ";

		  if(isSiteSpecificYN() && "PH".equals(order_category))
			  sql = sql + " ,c.strength_value, c.strength_uom ";
		  //IN062992, ends
		  
		  sql = sql + " FROM or_order_catalog a, or_order_type b ";//IN062992
		  
		  if(order_category.equals("PH"))
		  sql = sql+",ph_drug c ";

		  sql = sql+" WHERE b.order_type_code = a.order_type_code ";

		//IN062992, starts
		if(order_category.equals("PH"))
			sql = sql+" and a.order_catalog_code = C.DRUG_CODE ";
		//IN062992, ends

		  sql = sql+" AND a.order_category = DECODE (?, '*A', a.order_category, ?) AND UPPER (a.short_desc) LIKE UPPER (?) AND order_catalog_nature != 'S' AND a.eff_status = 'E' ";
		  
		  if(order_category.equals("PH"))
		  sql = sql+" and c.npb_drug_yn != 'Y' ";
		  
		  //IN068314 Starts
		 if(isfppapplicable){
		 if("Y".equals(fpp_yn)){
			  sql = sql+" and a.fpp_yn = ? ";
		 }else{
			   sql = sql+" and (a.fpp_yn is null or a.fpp_yn='N') ";
		 }
		 }
		  //IN068314 Ends
		  sql = sql+" ORDER BY a.short_desc";//IN034227,ends
		  pstmt = connection.prepareStatement(sql);
		  pstmt.setString(1,order_category.trim());
  		  pstmt.setString(2,order_category.trim());
  		  pstmt.setString(3,OrderCatalogIndex.trim() + "%");
		  if(isfppapplicable && "Y".equals(fpp_yn))
			pstmt.setString(4,fpp_yn);//IN068314
		}else{
		//sql = OrRepository.getOrKeyValue("SQL_OR_ORDERSET_CATALOG_CODE_OTHRS") ;//IN034227,starts
   		  //IN062992, starts
		  //sql = "SELECT   a.order_catalog_code, a.short_desc, a.order_type_code,b.short_desc order_type_desc, a.order_category order_category,a.qty_reqd_yn, a.freq_applicable_yn FROM or_order_catalog a, or_order_type b";
   		  sql = "SELECT   a.order_catalog_code, a.short_desc, a.order_type_code,b.short_desc order_type_desc, a.order_category order_category,a.qty_reqd_yn, a.freq_applicable_yn ";

		  if(isSiteSpecificYN() && "PH".equals(order_category))
			  sql = sql + " ,c.strength_value, c.strength_uom ";
		  //IN062992, ends

		  sql = sql + " FROM or_order_catalog a, or_order_type b ";//IN062992
		  
		//IN062992, starts
		if(order_category.equals("PH"))
			sql = sql + ",ph_drug c ";
		//IN062992, ends

		  sql = sql + " WHERE a.order_type_code = b.order_type_code ";
		 
		//IN062992, starts
		if(order_category.equals("PH"))
			sql = sql +" and a.order_catalog_code = C.DRUG_CODE ";
		//IN062992, ends

		  sql = sql + " AND a.order_category = DECODE (?, '*A', a.order_category, ?) AND UPPER (a.short_desc) NOT BETWEEN UPPER ('A%') AND UPPER ('_Z%') AND order_catalog_nature != 'S' AND a.eff_status = 'E'";

          if(order_category.equals("PH"))
		  sql = sql+" and c.npb_drug_yn != 'Y' ";
	  
		  //IN068314 Starts
		  if(isfppapplicable){
		  if("Y".equals(fpp_yn)){
			  sql = sql+" and a.fpp_yn = ? ";
		  }else{
			   sql = sql+" and (a.fpp_yn is null or a.fpp_yn='N') ";
		  }
		  }
		  //IN068314 Ends
          sql = sql+" ORDER BY a.short_desc";//IN034227,ends
		  pstmt = connection.prepareStatement(sql);
		  pstmt.setString(1,order_category.trim());
  		  pstmt.setString(2,order_category.trim());
		  if(isfppapplicable && "Y".equals(fpp_yn))//IN068314
			pstmt.setString(3,fpp_yn);//IN068314
  		  }
	}else{//Load all catalog's
		if(!OrderCatalogIndex.trim().equalsIgnoreCase("others")){
		  sql = OrRepository.getOrKeyValue("SQL_OR_ORDERSET_CATALOG_CODE_ALL") ;
		//IN068314 Starts
		  if(isfppapplicable){
		  if("Y".equals(fpp_yn)){
			  sql=sql.replace("##FPP_APPLICABLEYN##"," AND a.FPP_YN='Y' ");
		  }else{
			  sql=sql.replace("##FPP_APPLICABLEYN##"," AND (a.FPP_YN IS NULL OR a.FPP_YN='N') ");
		  }
		  }
		  else
			  sql=sql.replace("##FPP_APPLICABLEYN##","");
		  //IN068314 Ends
		  pstmt = connection.prepareStatement(sql);
		  pstmt.setString(1,OrderCatalogIndex.trim() + "%");
		}else{
			sql = OrRepository.getOrKeyValue("SQL_OR_ORDERSET_CATALOG_CODE_OTHRS_ALL") ;
			//IN068314 Starts
			  if(isfppapplicable){
			  if("Y".equals(fpp_yn)){
				  sql=sql.replace("##FPP_APPLICABLEYN##"," AND a.FPP_YN='Y' ");
			  }else{
				  sql=sql.replace("##FPP_APPLICABLEYN##"," AND (a.FPP_YN IS NULL OR a.FPP_YN='N') ");
			  }
			  }
			  else
				  sql=sql.replace("##FPP_APPLICABLEYN##","");
			  //IN068314 Ends
		 pstmt = connection.prepareStatement(sql);
		 }
	}


	rs = pstmt.executeQuery();

	componentStr.clearSelectRec();//first clear  the  prevoius record.
HashMap tempHash=null;
String sql1="";
String freq_code ="";
String qty_unit ="";
String durn_value = "";
String durn_type = "";
HashMap orderFreqStr = null;
ArrayList freq_val	   = null;
ArrayList freq_desc    = null;

HashMap  orderTypeStr =  null;
ArrayList order_val	   = null;
ArrayList order_desc   = null;

		//IN065713, starts
		/*if(isSiteSpecificYN() && "PH".equals(order_category.trim()) && "C".equals(getApplicableTo()))
		{
			sql1 = OrRepository.getOrKeyValue("SQL_OR_ORDERSET_PTCL_ALL_ONCOLOCY") ;
		}
		else
		{
			sql1 = OrRepository.getOrKeyValue("SQL_OR_ORDERSET_PTCL_ALL") ;
		}*/

		sql1 = OrRepository.getOrKeyValue("SQL_OR_ORDERSET_PTCL_ALL") ;
		//IN065713, ends
		pstmt1	= connection.prepareStatement(sql1);

	while(rs.next()){
		tempHash = new HashMap();//Represents each record
		freq_code = "";
		qty_unit = "";
		durn_value = "";
		durn_type = "";
		qty_unit = "";

		loadOrderTypeCodeFreq(rs.getString("order_category"),rs.getString("order_catalog_code"));

		//rs1			  = null;
		//pstmt1	  = null ;

		
		pstmt1.setString(1,rs.getString("order_catalog_code"));

		rs1 = pstmt1.executeQuery();

		while(rs1.next()){
			freq_code =	 checkForNull(rs1.getString("FREQ_CODE"),"")  ;
			qty_unit  =  checkForNull( rs1.getString("QTY_VALUE"),"1")  ;

			
			durn_value = checkForNull(rs1.getString("DURN_VALUE"),"")  ;

	//		durn_type  = checkForNull( rs1.getString("durn_type"),"1")  ;

			durn_type  = checkForNull( rs1.getString("durn_type"),"")  ;

			if(freq_code.trim().equals("")){
			   durn_value = "";
  			   durn_type = "";
			}


			if(qty_unit.trim().equals("0") || qty_unit.trim().equals(""))
			qty_unit = "1";

		}

		closeResultSet(rs1);	
		//closeStatement(pstmt1);
		//if(rs1!=null)rs1.close();
		//if(pstmt1!=null)pstmt1.close();

		 orderFreqStr = getOrderFreqStr();
		 freq_val	   =(ArrayList)orderFreqStr.get("value") ;
		 freq_desc    =(ArrayList)orderFreqStr.get("Description") ;

		 orderTypeStr = getOrderTypeStr();
		 order_val	   =(ArrayList)orderTypeStr.get("value") ;
		 order_desc   =(ArrayList)orderTypeStr.get("Description") ;

		tempHash.put("order_category"		 ,rs.getString("order_category"));
		tempHash.put("order_catalog_code"	 ,rs.getString("order_catalog_code"));
		tempHash.put("order_catalog_desc"	 ,rs.getString("short_desc"));
		tempHash.put("order_type_code"		 ,rs.getString("order_type_code"));
		tempHash.put("order_type_desc"		 ,rs.getString("order_type_desc"));
		tempHash.put("order_set_seq_num"	 ,"");
		tempHash.put("item_narration"		 ,""); //Not used in 2nd phase
		//tempHash.put("occ_no"		 ,rs.getString("occ_no"));
		tempHash.put("qty_value"	         ,""); //Not used in 2nd phase
		tempHash.put("route_code"	         ,""); //Not used in 2nd phase
		tempHash.put("qty_unit"				 ,qty_unit);
		tempHash.put("qty_reqd_yn"			 ,checkForNull(rs.getString("qty_reqd_yn"),"N"));
		tempHash.put("freq_applicable_yn"	 ,checkForNull(rs.getString("freq_applicable_yn"),"N"));
		tempHash.put("freq_code"			 ,freq_code);
		tempHash.put("durn_value"			 ,durn_value);
		tempHash.put("durn_type"			 ,durn_type);
		tempHash.put("freq_val_opts"		 ,freq_val);
		tempHash.put("freq_desc_opts"		 ,freq_desc);
		tempHash.put("order_val_opts"		 ,order_val);
		tempHash.put("order_desc_opts"		 ,order_desc);
		tempHash.put("rel_start_date_time"	 ,"");
		tempHash.put("reqd_or_opt_ind"		 ,"");
		tempHash.put("valid"				 ,"N");
		tempHash.put("associate_yn"			 ,"N");
		tempHash.put("status"				 ,"N");	

		//IN062992, starts
		if(isSiteSpecificYN() && "PH".equals(order_category))
		{
			tempHash.put("strength_value" ,checkForNull(rs.getString("strength_value"),""));
			tempHash.put("strength_uom" ,checkForNull(rs.getString("strength_uom"),""));
		}
		//IN062992, ends
		componentStr.putListObject(tempHash);
	}



	}catch(Exception e){

			e.printStackTrace();
			tempChk.append("Exception in sQL" + e);
	}finally{
		try
		 {
		 	closeResultSet(rs1);
		 	closeStatement(pstmt1);
		 	closeResultSet(rs);
		 	closeStatement(pstmt);
			closeConnection(connection);
		 }catch(Exception e){

			 e.printStackTrace() ;

		 }
	}
	return componentStr.getSize("SELECT");
}


/**********Deerag ADDDED AND USED ***************************/
public synchronized void loadOrderTypeCodeFreq(String  order_category, String order_catalog){
  	Connection connection			= null ;
	PreparedStatement pstmt			= null ;
	ResultSet rs					= null;
	orderTypeStr					= new HashMap();
	String sqlFreq = "";

	try{

		//String sqlFreq				  = OrRepository.getOrKeyValue("SQL_OR_ORDERSET_FREQ_CODE");
		
		//IN062992, starts
		if(isSiteSpecificYN() && "PH".equals(order_category) && "C".equals(getApplicableTo()))
			sqlFreq = OrRepository.getOrKeyValue("SQL_OR_ORDERSET_FREQ_CODE_ONCOLOGY");
		else
			sqlFreq = OrRepository.getOrKeyValue("SQL_OR_ORDERSET_FREQ_CODE");

		//IN062992, ends

		String sqlOrderType			  = OrRepository.getOrKeyValue("SQL_OR_ORDERSET_ORDER_TYPE_CODE1");


		connection   =	getConnection();

		String sqlParamOrder[] ={order_category.trim(),order_catalog.trim()};
		String sqlParamFreq[]  ={order_category.trim(), order_catalog.trim()};


		orderTypeStr =	Populate.getAsHashArray(sqlOrderType,connection,"order_type_code","short_desc",sqlParamOrder) ;
		
		orderFreqStr =	Populate.getAsHashArray(sqlFreq,connection,"freq_code","freq_desc",sqlParamFreq) ;		

	}catch(Exception e){

			e.printStackTrace();
			tempChk.append("Exception in sQL" + e);
	}finally{
		try
		 {
					closeResultSet(rs);
					closeStatement(pstmt);
					closeConnection(connection);
		 }catch(Exception e){e.printStackTrace() ;

		 }
	}
}
/********************************************************************/
public synchronized int getRecordsNo(){
if(detailPageMode.equalsIgnoreCase("A"))
	return componentStr.getSize("DB") ;
else
	return componentStr.getSize("SELECT") ;
}
/*******************************************************************/
public synchronized Object getRecord( int i){
try{
	if(detailPageMode.equalsIgnoreCase("A")){
	return componentStr.getObject(i) ;
	}else{
	return componentStr.getListObject(i) ;}
}catch(Exception e){
	return null ;
}
}
 /************Methos to Short Record for Associate mode*************/
 public  synchronized void SortedArrayListAscc(){


  java.util.ArrayList tempRef		= componentStr.getAllDBRecords();
  java.util.TreeMap sorter			= new java.util.TreeMap();
  java.util.ArrayList holdDuplicate = new java.util.ArrayList();

  int sizeAscc = tempRef.size(); //ref of the Object DB Array List
	HashMap tempHash=null;
	String seqNoStr="";
	Integer seqNo=null;
  for(int i=0 ; i < sizeAscc ; i++){
	   tempHash = (java.util.HashMap)tempRef.get(i);
	  seqNoStr = checkForNull(((String)tempHash.get("order_set_seq_num")),"8888");
      seqNo   = new Integer( Integer.parseInt(seqNoStr));
	  if(!sorter.containsKey(seqNo)){
		  sorter.put(seqNo,tempHash);
	  }else{
		  holdDuplicate.add(tempHash);//array List of Dup records
	  }
 }

	tempRef.clear();//Clear  the  DB  records

	Collection  coll = sorter.values();
	Iterator iter    = coll.iterator();

	int dupSize = holdDuplicate.size();
	HashMap tempSrt	 =null;
	String  seqNoStr1  ="";
	 HashMap tempDup=null;
	  String seqNoStr2="";

	while(iter.hasNext()){
	  tempSrt	 =(java.util.HashMap)iter.next();
	 seqNoStr1  =checkForNull(((String)tempSrt.get("order_set_seq_num")),"8888");
      int     seqNoSrt   =Integer.parseInt(seqNoStr1);

	  for(int j=0;j<dupSize;j++){
	  tempDup	= (java.util.HashMap)holdDuplicate.get(j);
	   seqNoStr2	= checkForNull(((String)tempDup.get("order_set_seq_num")),"8888");
      int  seqNoDup		=Integer.parseInt(seqNoStr2);
	  if(seqNoSrt == seqNoDup)
	  tempRef.add(tempDup);	//inserting Dup Values
	  }
  	  tempRef.add(tempSrt);
	}
}
/***************************************************************************/
public void clearComponentStr(){
	componentStr.clearDBRec();
	componentStr.clearSelectRec();
	componentStr.clearDBRecOriginal();
}
/****chk whether parameter is coming from the client*******UTILTIY METHOD***/
private String  chkPresent(Hashtable ht,String param , String defaultVal){
	if(ht.containsKey(param))
	return	checkForNull((String)ht.get(param),defaultVal);
	else
	return  defaultVal ;
}
/***********UTILITY METHOD This is method called from jsp for get rec in a particular array list at given index ----
if not retrun  the  default value******/
public String getdefaultArrListValue(ArrayList ar ,int recIndex ,String  key , String defaultVal){

	boolean flag = ar.isEmpty();
	int size	 = ar.size() ;

	if( (recIndex >= size) || flag )
		return defaultVal;


	HashMap currRec = (HashMap)ar.get(recIndex);

	if(currRec.containsKey(key))
	return	checkForNull((String)currRec.get(key),defaultVal);
	else
	return   defaultVal ;

}

/*****************Synchronization*****************************/
public synchronized boolean doSync(Hashtable request) throws Exception{
try
{
	String tabType  = "";


	if(request.containsKey("tabType"))
		tabType = (String)request.get("tabType");


	if(tabType.trim().equalsIgnoreCase("S"))
		synonymsSync(request);

	if(tabType.trim().equalsIgnoreCase("Se"))
		settingsSync(request);

	if(tabType.trim().equalsIgnoreCase("C"))
		componentSyn(request);

	if(tabType.trim().equalsIgnoreCase("E"))
		explanatorySync(request);

	if(tabType.trim().equalsIgnoreCase("B"))
		billingSync(request);
	
	return true;

    }catch(Exception e){
		e.printStackTrace();
	   throw new Exception(e.getMessage());
  }
}
/**********************Store the Freq,dura type,value for Components Tab********/
//public synchronized void setSettingsFreqStr(String OrderCategory){
public synchronized void setSettingsFreqStr(){
try
	{
		String param[] =  {};


		if(settingsFreqStr == null)//Only for the first time
		settingsFreqStr  = getSqlResultParam("SQL_OR_ORDERSET_FREQ_CODE_MAP",param);

		Integer	noOfRecTemp			 = (Integer)settingsFreqStr.get("noRec");
		int noOfRecordsFreq			 = noOfRecTemp.intValue() ;


		settingsFreqStrMapper = new HashMap() ;
		if(noOfRecordsFreq != 0){
			HashMap temp=null;
		  for(int i=1 ; i <= noOfRecordsFreq; i++){
			temp = new HashMap();
			temp.put("durn_value",checkForNull((String)settingsFreqStr.get("DURN_VALUE"+i)));	temp.put("durn_type" ,checkForNull((String)settingsFreqStr.get("DURN_TYPE"+i)));	temp.put("durn_desc" ,checkForNull((String)settingsFreqStr.get("DURN_DESC"+i)));	settingsFreqStrMapper.put(checkForNull((String)settingsFreqStr.get("FREQ_CODE"+i)),temp);
		  }
        }


	}catch (Exception e){
		 tempChk.append("Exception in setSettingsFreqStr =" + e.getMessage());

	}

}
/**********************Store the Freq,dura type,value for Setting Tab********/
public synchronized void setSettingsDurnStr(){
	try
	{
		if(settingsDurnStr == null)//Only for the first time
			settingsDurnStr  = getSqlResult("SQL_OR_CATALOG_DURATIONS");
}catch(Exception e){e.printStackTrace() ;
}
}
/************************************************************************/
public HashMap getFreqRec(String freq_code) throws Exception{

if(freq_code == null )
	throw new Exception("freq_code passed is null");

try{
    	Object objTemp  = settingsFreqStrMapper.get(freq_code.trim());


		if(objTemp == null)
			throw new Exception("Cannot find Freq_code in settingsFreqStr..exc raised in  getFreqRec function in OrdercatalogBean ");
		else
			return (HashMap)objTemp ;

}catch (Exception e){
	throw new Exception(e.getMessage());
}

}

/*************************just get the result***************/
public  HashMap getSqlResult(String key) throws Exception{
Connection connection	= null ;
PreparedStatement pstmt = null ;
ResultSet rs			= null;
ResultSetMetaData rsmd	= null ;
String 	columnName		= null ;
int 	columnCount		= -1 ;

HashMap result = new HashMap();
String sql = "";
try
{
	connection = getConnection();
	sql = OrRepository.getOrKeyValue(key.trim());
	pstmt	   = connection.prepareStatement(sql);
	if(key.trim().equals("SQL_OR_PATIENT_CLASS_LIST"))
	pstmt.setString(1,language_id);
	rs		   = pstmt.executeQuery()  ;
	rsmd	   = rs.getMetaData()      ;
	columnCount= rsmd.getColumnCount() ;
	int counter= 0 ;


	while (rs.next()){
		counter++;
		for(int i = 1; i <= columnCount ; i++){
		columnName	= rsmd.getColumnName(i)  ;
		result.put((columnName+counter),ChkDef.defaultString(rs.getString(columnName)));
		}

	}

	result.put("noRec",new Integer(counter));


	return result ;
}catch(Exception e){
		e.printStackTrace();
	    throw new Exception(e.getMessage());
}finally{
	try{
		closeResultSet(rs);
		closeStatement(pstmt);
		closeConnection(connection);
	 }catch(Exception e){e.printStackTrace() ;}
}

}
/*************************just get the result***************/
public  HashMap getSqlResultParam(String key , String[] params) throws Exception{
Connection connection	= null ;
PreparedStatement pstmt = null ;
ResultSet rs			= null;
ResultSetMetaData rsmd	= null ;
String 	columnName		= null ;
int 	columnCount		= -1 ;

HashMap result = new HashMap();

int paramslen  = params.length ;

try
{
	connection = getConnection();
	String sql = OrRepository.getOrKeyValue(key.trim());

	pstmt	   = connection.prepareStatement(sql);

	for (int i = 0; i < paramslen ; i++ ){
	pstmt.setString(i+1, (params[i]).trim());
	}

	rs		   = pstmt.executeQuery()  ;
	rsmd	   = rs.getMetaData()      ;
	columnCount= rsmd.getColumnCount() ;
	int counter= 0 ;

	while (rs.next()){
		counter++;
		for(int i = 1; i <= columnCount ; i++){
		columnName	= rsmd.getColumnName(i)  ;
		result.put((columnName+counter),ChkDef.defaultString(rs.getString(columnName)));
		}
	}

	result.put("noRec",new Integer(counter));

	return result ;
}catch(Exception e){
    e.printStackTrace();
	throw new Exception(e.getMessage());
}finally{
	try{
		closeResultSet(rs);
		closeStatement(pstmt);
		closeConnection(connection);
	 }catch(Exception e){e.printStackTrace() ;}
}

}


/******************INSERTION LOGIC For EJB****************************/

/*******************this method give range of duplicates******************/
private boolean chkDuplicate(String sql,Connection con , String arr[]) throws Exception{
	StringBuffer messages = new StringBuffer() ;
	StringBuffer traceVal = new StringBuffer() ;
	PreparedStatement pstmt = null;
	ResultSet rs	         = null ;
try{


		boolean dupFlag = false ;

		pstmt = con.prepareStatement(sql);

		
		int size				= arr.length ;



		for(int i =0 ; i < size ; i++){
			pstmt.setString(i+1,arr[i]);
		}



		rs = pstmt.executeQuery();

		int count = 0;

		if(rs.next())
			count = rs.getInt(1);

		if(count > 0)
		dupFlag = true ;


		return dupFlag;

		}catch(Exception e){
				e.printStackTrace();
				traceVal.append(e);
				messages.append(e.getMessage());
				throw e;
	 }
	 finally{
		 	closeResultSet(rs);
			closeStatement(pstmt);
 }

}//End of dulicate chk




public HashMap insert(HashMap tabDataParam , HashMap sqlMap ){




StringBuffer messages =  null ;
StringBuffer traceVal =  null ;
HashMap map =null;
Connection connection =  null ;
PreparedStatement pstmt_cr	    	= null ;
PreparedStatement pstmt_comp	    = null ;
PreparedStatement pstmt_syn		= null ;
PreparedStatement pstmt_ptcl		= null ;
try {
		messages = new StringBuffer() ;
		traceVal = new StringBuffer() ;
		map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "flag" ) ;



		HashMap tabData_p			=(HashMap)tabDataParam.get("tabData");

		HashMap	 careSetHeaderStr	=(HashMap)tabData_p.get("careSetHeaderStr");

		ArrayList componentStr		=(ArrayList)tabData_p.get("componentStr");

		ArrayList synonymsRec		=(ArrayList)tabData_p.get("synonymsStr");//passed as arrayList
		HashMap synonymsStr			=(HashMap)synonymsRec.get(0);
		ArrayList settingsStr		=(ArrayList)tabData_p.get("settingsStr");
		ArrayList billingRecStr		=(ArrayList)tabData_p.get("billingRecStr");//IN072524
		HashMap billingStr			=(HashMap)billingRecStr.get(0);	//IN072524


		String login_by_id			=(String)tabData_p.get("login_by_id" ) ;
		String login_at_ws_no		=(String)tabData_p.get("login_at_ws_no" ) ;
		String login_facility_id	=(String)tabData_p.get("login_facility_id" ) ;


	 	 connection = getConnection() ;
		 
		 String SQL_OR_ORDERSET_DUP_CHK					= (String)sqlMap.get("SQL_OR_ORDERSET_DUP_CHK");
		 String SQL_OR_ORDERSET_INSERT					= (String)sqlMap.get("SQL_OR_ORDERSET_INSERT");
		 String SQL_OR_ORDERSET_INSERT_SYNONYM			= (String)sqlMap.get("SQL_OR_ORDERSET_INSERT_SYNONYM");
		 String SQL_OR_ORDERSET_INSERT_BY_PTCL			= (String)sqlMap.get("SQL_OR_ORDERSET_INSERT_BY_PTCL");
		 String SQL_OR_ORDERSET_INSERT_COMP				= (String)sqlMap.get("SQL_OR_ORDERSET_INSERT_COMP");


		 String order_set_code							=(String)careSetHeaderStr.get("order_set_code") ;
		 traceVal.append("order_set_code="+order_set_code)	   ;
		 String	order_category							=(String)careSetHeaderStr.get("order_category") ;
		 String order_type_code							=(String)careSetHeaderStr.get("order_type_code") ;


		/********DUPLICATE CHK*****************************************/
		String arrChkDup[]  =  new String[1] ;

		arrChkDup[0] = order_set_code ;

		traceVal.append("Before dup chk");

		boolean duplicate = chkDuplicate(SQL_OR_ORDERSET_DUP_CHK,connection,arrChkDup);

		traceVal.append("After dup chk");

		if(duplicate){
		  String msg  =	 "CODE_ALREADY_EXISTS";
		  map.put( "message", msg ) ;
          map.put( "flag", "Duplicate") ;
		  map.put( "traceVal", "dup loop records" ) ;
		  connection.rollback();
		  return map ;
		}

		/*************************************************************/

		pstmt_cr										= connection.prepareStatement(SQL_OR_ORDERSET_INSERT);
		pstmt_syn										= connection.prepareStatement(SQL_OR_ORDERSET_INSERT_SYNONYM);
		pstmt_ptcl										= connection.prepareStatement(SQL_OR_ORDERSET_INSERT_BY_PTCL);
		pstmt_comp										= connection.prepareStatement(SQL_OR_ORDERSET_INSERT_COMP);


		int	insert_cr		= -1 ;
		int	insert_syn[]	= {} ;
		int	insert_ptcl[]	= {} ;
		int	insert_comp[]	= {} ;

		/******************INSERT INTO ORDER_CATALOG*************/


		pstmt_cr.setString(1	,order_set_code);
		pstmt_cr.setString(2	,(String)careSetHeaderStr.get("long_desc"));
		pstmt_cr.setString(3	,(String)careSetHeaderStr.get("short_desc"));
		pstmt_cr.setString(4	,(String)careSetHeaderStr.get("order_category"));
		pstmt_cr.setString(5	,order_type_code);
		pstmt_cr.setString(6	,(String)careSetHeaderStr.get("security_level"));
		pstmt_cr.setString(7	,(String)careSetHeaderStr.get("explanatory_text"));
		pstmt_cr.setString(8	,"S");
		pstmt_cr.setString(9	,"N");
		pstmt_cr.setString(10	,"");
		pstmt_cr.setString(11	,"N");
		pstmt_cr.setString(12	,"");
		pstmt_cr.setString(13	,"N");
		pstmt_cr.setString(14	,"");
		pstmt_cr.setString(15	,"N");
		pstmt_cr.setString(16	,"N");
		pstmt_cr.setString(17	,"N");
		pstmt_cr.setString(18	,"N");
		pstmt_cr.setString(19	,"N");
		pstmt_cr.setString(20	,"N");
		pstmt_cr.setString(21	,"");
		pstmt_cr.setString(22	,"N");
		pstmt_cr.setString(23	,"");
		pstmt_cr.setString(24	,"");
		pstmt_cr.setString(25	,"");
		pstmt_cr.setString(26	,"");
		pstmt_cr.setString(27	,"");
		pstmt_cr.setString(28	,"");
		pstmt_cr.setString(29	,"");
		pstmt_cr.setString(30	,"");
		pstmt_cr.setString(31	,"");
		pstmt_cr.setString(32	,"");
		pstmt_cr.setString(33	,"N");
		pstmt_cr.setString(34	,"");
		pstmt_cr.setString(35	,"N");
		pstmt_cr.setString(36	,"N");
		pstmt_cr.setString(37	,"N");
		pstmt_cr.setString(38	,"N");
		pstmt_cr.setString(39	,"N");
		pstmt_cr.setString(40	,"N");
		pstmt_cr.setString(41	,"");
		pstmt_cr.setString(42	,"");
		pstmt_cr.setString(43	,"");
		pstmt_cr.setString(44	,"");
		pstmt_cr.setString(45	,"");
		pstmt_cr.setString(46	,(String)careSetHeaderStr.get("indexed_yn"));
		pstmt_cr.setString(47	,(String)careSetHeaderStr.get("eff_status"));
		pstmt_cr.setString(48	,login_by_id);
		pstmt_cr.setString(49	,login_at_ws_no);
		pstmt_cr.setString(50	,login_facility_id);
		pstmt_cr.setString(51	,login_by_id);
		pstmt_cr.setString(52	,login_at_ws_no);
		pstmt_cr.setString(53	,login_facility_id);
		pstmt_cr.setString(54	,"");//Little differnce in database name and bean name
   		pstmt_cr.setString(55	,"");//FROM SQL
		pstmt_cr.setString(56	,(String)careSetHeaderStr.get("fpp_yn"));//IN068314
		pstmt_cr.setString(57	, (String)billingStr.get("fpp_category"));//IN072524


		insert_cr = pstmt_cr.executeUpdate();

		traceVal.append("ORDER_CATALOG after Insetion insert_cr="+insert_cr) ;

		/**************INSERT INTO ORDER CATALOG SYNONYM**************/


		String 	effective_status_primary		= (String)synonymsStr.get("effective_status_primary") ;
		String 	effective_status_directCare		= (String)synonymsStr.get("effective_status_directCare") ;
		String 	effective_status_ancillaryDept	= (String)synonymsStr.get("effective_status_ancillaryDept") ;

		if(effective_status_primary.trim().equalsIgnoreCase("Y")){//This insertion is Mandatory
			pstmt_syn.setString(1 ,order_set_code);
			pstmt_syn.setString(2 ,"PR");
			pstmt_syn.setString(3 ,(String)synonymsStr.get("catalog_synonym_primary"));
			pstmt_syn.setString(4 ,login_by_id);
			pstmt_syn.setString(5 ,login_at_ws_no);
			pstmt_syn.setString(6 ,login_facility_id);
			pstmt_syn.setString(7 ,login_by_id);
			pstmt_syn.setString(8 ,login_at_ws_no);
			pstmt_syn.setString(9 ,login_facility_id);
			pstmt_syn.setString(10,effective_status_primary);//*************
			pstmt_syn.addBatch() ;

		}

		if(effective_status_directCare.trim().equalsIgnoreCase("Y")){
			pstmt_syn.setString(1 ,order_set_code);
			pstmt_syn.setString(2 ,"DC");
			pstmt_syn.setString(3 ,(String)synonymsStr.get("catalog_synonym_directCare"));
			pstmt_syn.setString(4 ,login_by_id);
			pstmt_syn.setString(5 ,login_at_ws_no);
			pstmt_syn.setString(6 ,login_facility_id);
			pstmt_syn.setString(7 ,login_by_id);
			pstmt_syn.setString(8 ,login_at_ws_no);
			pstmt_syn.setString(9 ,login_facility_id);
			pstmt_syn.setString(10,effective_status_directCare);//*************
			pstmt_syn.addBatch() ;
		}

		if(effective_status_ancillaryDept.trim().equalsIgnoreCase("Y")){
			pstmt_syn.setString(1 ,order_set_code);
			pstmt_syn.setString(2 ,"AD");
			pstmt_syn.setString(3 ,(String)synonymsStr.get("catalog_synonym_ancillaryDept"));
			pstmt_syn.setString(4 ,login_by_id);
			pstmt_syn.setString(5 ,login_at_ws_no);
			pstmt_syn.setString(6 ,login_facility_id);
			pstmt_syn.setString(7 ,login_by_id);
			pstmt_syn.setString(8 ,login_at_ws_no);
			pstmt_syn.setString(9 ,login_facility_id);
			pstmt_syn.setString(10,effective_status_ancillaryDept);//*************
			pstmt_syn.addBatch();
		
		}

			insert_syn = pstmt_syn.executeBatch();

			traceVal.append("after insertion sysn="+insert_syn.length);

	/**************INSERT INTO OR_ORDER BY PTCL*******************/

			int sizeSettings			=settingsStr.size()  ;
			int iterateVal				=0;

			 traceVal.append("Settings="+sizeSettings + "   //////");


			iterateVal = sizeSettings ;

			HashMap tempSetting=null;
			String setting_applicability="";
			String patient_class="";
			String age_group_code = ""; //IN063686
///Assumption that corresponding Index of a particular Patient Class is same in Both the tabs is  same
	for(int i = 0; i < iterateVal ; i++){//0 for the default

			    tempSetting = (HashMap)settingsStr.get(i);
				setting_applicability	    =(String)tempSetting.get("setting_applicability");

				if(setting_applicability.trim().equalsIgnoreCase("A") || i== 0 ){

				patient_class	=(String)tempSetting.get("patient_class");
				age_group_code	=(String)tempSetting.get("age_group_code");//IN063686

				pstmt_ptcl.setString(1	 ,order_set_code);
				pstmt_ptcl.setString(2	 ,patient_class);
				pstmt_ptcl.setString(3	 ,"X");
				pstmt_ptcl.setString(4	 ,"N");
				pstmt_ptcl.setString(5	 ,"N");
				pstmt_ptcl.setString(6	 ,"N");
				pstmt_ptcl.setString(7	 ,"A");
				pstmt_ptcl.setString(8	 ,"");
				pstmt_ptcl.setString(9	 ,"");
				pstmt_ptcl.setString(10	 ,"");
				pstmt_ptcl.setString(11	 ,"");
				pstmt_ptcl.setString(12	 ,"");
				pstmt_ptcl.setString(13	 ,"");
				pstmt_ptcl.setString(14	 ,"");
				pstmt_ptcl.setString(15	 ,"");
				pstmt_ptcl.setString(16  ,"");
				//IN063686 Start.
				/*pstmt_ptcl.setString(17	 ,login_by_id);
				pstmt_ptcl.setString(18	 ,login_at_ws_no);
				pstmt_ptcl.setString(19  ,login_facility_id);
				pstmt_ptcl.setString(20  ,login_by_id);
				pstmt_ptcl.setString(21  ,login_at_ws_no);
				pstmt_ptcl.setString(22  ,login_facility_id);
				pstmt_ptcl.setString(23  ,"");*/
				pstmt_ptcl.setString(17	 ,age_group_code);
				pstmt_ptcl.setString(18	 ,login_by_id);
				pstmt_ptcl.setString(19	 ,login_at_ws_no);
				pstmt_ptcl.setString(20  ,login_facility_id);
				pstmt_ptcl.setString(21  ,login_by_id);
				pstmt_ptcl.setString(22  ,login_at_ws_no);
				pstmt_ptcl.setString(23  ,login_facility_id);
				pstmt_ptcl.setString(24  ,"");
				//IN063686 End.
				pstmt_ptcl.addBatch();
		   	}//end of For Loop for PTCL INSERTION
	}

				insert_ptcl = pstmt_ptcl.executeBatch();

				traceVal.append("afterInsertion="+insert_ptcl.length);
				
/*****************INSERTION FOR OR ORDER Set Component************/

		 int noOfRecords = componentStr.size() ;
		 HashMap currData=null;
		 String  associate_yn="";

		 for(int k=0 ; k< noOfRecords ; k++){

	     currData	     =(HashMap)componentStr.get(k);
		 associate_yn	 =(String)currData.get("associate_yn");

		traceVal.append("order_category="+order_category);

		 if(associate_yn.trim().equalsIgnoreCase("Y")){

			pstmt_comp.setString(1	,order_set_code);
			pstmt_comp.setString(2	,(String)currData.get("order_set_seq_num"));
			pstmt_comp.setString(3	,(String)currData.get("order_catalog_code"));
			pstmt_comp.setString(4	,(String)currData.get("order_type_code"));
			pstmt_comp.setString(5	,(String)currData.get("order_category"));//order_category
			pstmt_comp.setString(6	,(String)currData.get("reqd_or_opt_ind"));
			pstmt_comp.setString(7	,(String)currData.get("rel_start_date_time"));
			pstmt_comp.setString(8	,(String)currData.get("route_code"));
			pstmt_comp.setString(9	,(String)currData.get("qty_unit"));	 //Not in sec phase
	
			pstmt_comp.setString(10 ,(String)currData.get("qty_value"));		 //Not in sec phase*/
			pstmt_comp.setString(11 ,(String)currData.get("freq_code"));
			pstmt_comp.setString(12 ,(String)currData.get("durn_value"));
			pstmt_comp.setString(13 ,(String)currData.get("durn_type"));
			pstmt_comp.setString(14 ,(String)currData.get("prompt_msg"));//Not in sec phase		

			pstmt_comp.setString(15 ,login_by_id);
			pstmt_comp.setString(16 ,login_at_ws_no);
			pstmt_comp.setString(17 ,login_facility_id);
			pstmt_comp.setString(18 ,login_by_id);
			pstmt_comp.setString(19 ,login_at_ws_no);
			pstmt_comp.setString(20 ,login_facility_id);
			pstmt_comp.setInt(21 ,1);
		

			pstmt_comp.addBatch();

		 }//End of if


		 } //End of For loop

		insert_comp = pstmt_comp.executeBatch();

		traceVal.append("insert_comp="+insert_comp.length);

		boolean insert_cmp	=  false ;
		boolean insert_ptl	=  false ;
		boolean insert_sy	=  false ;


		 if((insert_comp.length > 0)){ //check updation in Component
					insert_cmp= true ;
		 }else if((insert_comp.length == (-3))){
					insert_cmp= false ;
		 }


		 if((insert_ptcl.length > 0)){ //check updation in PTCL
					insert_ptl= true ;
		 }else if((insert_ptcl.length == (-3))){
					insert_ptl= false ;
		 }


		 if((insert_syn.length > 0)){ //check updation in SYN
					insert_sy= true ;
		 }else if((insert_syn.length == (-3))){
					insert_sy= false ;
		 }


		if (insert_cr > 0  && insert_sy  && insert_cmp && insert_ptl){
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
				messages.append("RECORD_INSERTED") ;
		}else{
				connection.rollback();
				messages.append( "Insert Failed" ) ;
		}

	}catch( Exception e ){
					traceVal.append("In Exception==");
					e.printStackTrace();
					traceVal.append(e.getMessage());
					map.put( "traceVal", traceVal.toString() ) ;

			try {
						connection.rollback();
						//closeConnection(connection);
				} catch ( Exception ee ) {
						messages.append(ee.getMessage() ) ;
				}
				messages.append( e.getMessage() ) ;

				e.printStackTrace() ;
    		  } finally{
	            	try {
						closeStatement(pstmt_cr);
						closeStatement(pstmt_comp);
						closeStatement(pstmt_syn);
						closeStatement(pstmt_ptcl);
						closeConnection(connection);
					} catch ( Exception fe ) {

					   	fe.printStackTrace() ;
			        }
	    	    }

			map.put( "message", messages.toString() ) ;
			map.put( "traceVal", traceVal.toString() ) ;
			return map ;
}

/*****************MODIFY MODE ******************************/
public HashMap modify(HashMap tabDataParam , HashMap sqlMap ){

StringBuffer messages =  null ;
StringBuffer traceVal =  null ;
HashMap map =null;
Connection connection =  null ;
PreparedStatement del_pstmt_syn		= null ;
PreparedStatement del_pstmt_ptcl		= null ;
PreparedStatement del_pstmt_comp		= null ;
PreparedStatement pstmt_eff		= null ;
ResultSet	rs_eff					= null;
PreparedStatement pstmt_cr	    	= null ;
PreparedStatement pstmt_comp	    = null ;
PreparedStatement pstmt_syn		= null ;
PreparedStatement pstmt_ptcl		= null ;

try {
		messages = new StringBuffer() ;
		traceVal = new StringBuffer() ;
		map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "flag" ) ;



		HashMap tabData_p			=(HashMap)tabDataParam.get("tabData");

		HashMap	 careSetHeaderStr	=(HashMap)tabData_p.get("careSetHeaderStr");

		ArrayList componentStr		=(ArrayList)tabData_p.get("componentStr");
		ArrayList synonymsRec		=(ArrayList)tabData_p.get("synonymsStr");//passed as arrayList
		HashMap synonymsStr			=(HashMap)synonymsRec.get(0);
		ArrayList settingsStr		=(ArrayList)tabData_p.get("settingsStr");


		String login_by_id			=(String)tabData_p.get("login_by_id" ) ;
		String login_at_ws_no		=(String)tabData_p.get("login_at_ws_no" ) ;
		String login_facility_id	=(String)tabData_p.get("login_facility_id" ) ;


	 	 connection = getConnection() ;
		 pstmt_cr	    	= null ;
 		 pstmt_comp	    = null ;
 		 pstmt_syn		= null ;
  		 pstmt_ptcl		= null ;

		 String SQL_OR_ORDERSET_UPDATE					= (String)sqlMap.get("SQL_OR_ORDERSET_UPDATE");
		 String SQL_OR_ORDERSET_EFF_STATUS_SELECT		= (String)sqlMap.get("SQL_OR_ORDERSET_EFF_STATUS_SELECT");
		 String SQL_OR_ORDERSET_EFF_STATUS_UPDATE		= (String)sqlMap.get("SQL_OR_ORDERSET_EFF_STATUS_UPDATE");


		 String SQL_OR_ORDERSET_INSERT_SYNONYM			= (String)sqlMap.get("SQL_OR_ORDERSET_INSERT_SYNONYM");
		 String SQL_OR_ORDERSET_INSERT_BY_PTCL			= (String)sqlMap.get("SQL_OR_ORDERSET_INSERT_BY_PTCL");
		 String SQL_OR_ORDERSET_INSERT_COMP				= (String)sqlMap.get("SQL_OR_ORDERSET_INSERT_COMP");

		 String SQL_OR_ORDERSET_SYNONYM_DELETE			= (String)sqlMap.get("SQL_OR_ORDERSET_SYNONYM_DELETE");
		 String SQL_OR_ORDERSET_COMP_DELETE				= (String)sqlMap.get("SQL_OR_ORDERSET_COMP_DELETE");
		 String SQL_OR_ORDERSET_PTCL_DELETE				= (String)sqlMap.get("SQL_OR_ORDERSET_PTCL_DELETE");


		 String order_set_code							=(String)careSetHeaderStr.get("order_set_code") ;
		 traceVal.append("order_set_code="+order_set_code)	   ;
		 String	order_category							=(String)careSetHeaderStr.get("order_category") ;
		 String order_type_code							=(String)careSetHeaderStr.get("order_type_code") ;

		/*****EFFECTIVE STATUS CHK AND UPDATION*****************/
		 pstmt_eff		= null ;
		 rs_eff					= null;
		 String eff_status					= "";

		 pstmt_eff = connection.prepareStatement(SQL_OR_ORDERSET_EFF_STATUS_SELECT);

		 pstmt_eff.setString(1,order_set_code.trim());
		 rs_eff	= pstmt_eff.executeQuery();

		 if(rs_eff.next())
			eff_status =   rs_eff.getString("eff_status");

		
		 closeStatement( pstmt_eff ) ;

		 if(eff_status.trim().equalsIgnoreCase("D")){//Update only the Eff Status and return

			pstmt_eff = connection.prepareStatement(SQL_OR_ORDERSET_EFF_STATUS_UPDATE);

			pstmt_eff.setString(1 ,(String)careSetHeaderStr.get("eff_status"));
			pstmt_eff.setString(2 ,login_by_id);
			pstmt_eff.setString(3 ,login_at_ws_no);
			pstmt_eff.setString(4 ,login_facility_id);
			pstmt_eff.setString(5 ,order_set_code.trim());


			int update_eff_status = pstmt_eff.executeUpdate();

			if(update_eff_status > 0){
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
				messages.append("RECORD_INSERTED") ;

				map.put( "message", messages.toString() ) ;
				map.put( "traceVal", traceVal.toString() ) ;
				return map ;
			}

	     }

		/****************DELETE RECORD IN THREE TABLES*****************/

		 del_pstmt_syn		= null ;
  		 del_pstmt_ptcl		= null ;
		 del_pstmt_comp		= null ;

		 int update_syn_del_status =  0;
		 int update_ptcl_del_status =  0;
		 int update_comp_del_status =  0;

		 del_pstmt_syn = connection.prepareStatement(SQL_OR_ORDERSET_SYNONYM_DELETE);
		 del_pstmt_syn.setString(1,order_set_code.trim());
		 update_syn_del_status = del_pstmt_syn.executeUpdate();


  		traceVal.append("del=syn");


		 del_pstmt_ptcl = connection.prepareStatement(SQL_OR_ORDERSET_PTCL_DELETE);
		 del_pstmt_ptcl.setString(1,order_set_code.trim());
		 update_ptcl_del_status = del_pstmt_ptcl.executeUpdate();

 		traceVal.append("del=ptcl");

		 del_pstmt_comp = connection.prepareStatement(SQL_OR_ORDERSET_COMP_DELETE);
		 del_pstmt_comp.setString(1,order_set_code.trim());
		 update_comp_del_status = del_pstmt_comp.executeUpdate();

 		traceVal.append("del=inst");

		 if(update_syn_del_status < 0 || update_ptcl_del_status < 0  || update_comp_del_status < 0  ){
				connection.rollback();
				map.put( "result", new Boolean( false ) ) ;
				messages.append("Faliure") ;
				map.put( "message", "Some prob in delete" ) ;
				map.put( "traceVal", "Some prob in delete" ) ;
				return map ;
			}

		traceVal.append("delete done");



		/*************************************************************/

		pstmt_cr										= connection.prepareStatement(SQL_OR_ORDERSET_UPDATE);
		pstmt_syn										= connection.prepareStatement(SQL_OR_ORDERSET_INSERT_SYNONYM);
		pstmt_ptcl										= connection.prepareStatement(SQL_OR_ORDERSET_INSERT_BY_PTCL);
		pstmt_comp										= connection.prepareStatement(SQL_OR_ORDERSET_INSERT_COMP);


		int	update_cr	= -1 ;
		int	insert_syn[]	= {} ;
		int	insert_ptcl[]	= {} ;
		int	insert_comp[]	= {} ;

		/******************UPDATE INTO ORDER_CATALOG*************/


		pstmt_cr.setString(1	,(String)careSetHeaderStr.get("long_desc"));
		pstmt_cr.setString(2	,(String)careSetHeaderStr.get("short_desc"));
		pstmt_cr.setString(3	,(String)careSetHeaderStr.get("order_category"));
		pstmt_cr.setString(4	,order_type_code);
		pstmt_cr.setString(5	,(String)careSetHeaderStr.get("security_level"));
		pstmt_cr.setString(6	,(String)careSetHeaderStr.get("explanatory_text"));
		pstmt_cr.setString(7	,"S");
		pstmt_cr.setString(8	,"N");
		pstmt_cr.setString(9	,"");
		pstmt_cr.setString(10	,"N");
		pstmt_cr.setString(11	,"");
		pstmt_cr.setString(12	,"N");
		pstmt_cr.setString(13	,"");
		pstmt_cr.setString(14	,"N");
		pstmt_cr.setString(15	,"N");
		pstmt_cr.setString(16	,"N");
		pstmt_cr.setString(17	,"N");
		pstmt_cr.setString(18	,"N");
		pstmt_cr.setString(19	,"N");
		pstmt_cr.setString(20	,""); //from sql
		pstmt_cr.setString(21	,"N");
		pstmt_cr.setString(22	,"");
		pstmt_cr.setString(23	,"");
		pstmt_cr.setString(24	,"");
		pstmt_cr.setString(25	,"");
		pstmt_cr.setString(26	,"");
		pstmt_cr.setString(27	,"");
		pstmt_cr.setString(28	,"");
		pstmt_cr.setString(29	,"");
		pstmt_cr.setString(30	,"");
		pstmt_cr.setString(31	,"");
		pstmt_cr.setString(32	,"N");
		pstmt_cr.setString(33	,"");
		pstmt_cr.setString(34	,"N");
		pstmt_cr.setString(35	,"N");
		pstmt_cr.setString(36	,"N");
		pstmt_cr.setString(37	,"N");
		pstmt_cr.setString(38	,"N");
		pstmt_cr.setString(39	,"N");
		pstmt_cr.setString(40	,"");
		pstmt_cr.setString(41	,"");
		pstmt_cr.setString(42	,"");
		pstmt_cr.setString(43	,"");
		pstmt_cr.setString(44	,"");
		pstmt_cr.setString(45	,(String)careSetHeaderStr.get("indexed_yn"));
		pstmt_cr.setString(46	,(String)careSetHeaderStr.get("eff_status"));
		pstmt_cr.setString(47	,"");
		pstmt_cr.setString(48	,login_by_id);
		pstmt_cr.setString(49	,login_at_ws_no);
		pstmt_cr.setString(50	,login_facility_id);
		pstmt_cr.setString(51	,"");
		pstmt_cr.setString(52	,order_set_code.trim());

		update_cr			= pstmt_cr.executeUpdate();


		/**************INSERT INTO ORDER CATALOG SYNONYM**************/


		String 	effective_status_primary		= (String)synonymsStr.get("effective_status_primary") ;
		String 	effective_status_directCare		= (String)synonymsStr.get("effective_status_directCare") ;
		String 	effective_status_ancillaryDept	= (String)synonymsStr.get("effective_status_ancillaryDept") ;


		if(effective_status_primary.trim().equalsIgnoreCase("Y")){//This insertion is Mandatory
			pstmt_syn.setString(1 ,order_set_code);
			pstmt_syn.setString(2 ,"PR");
			pstmt_syn.setString(3 ,(String)synonymsStr.get("catalog_synonym_primary"));
			pstmt_syn.setString(4 ,login_by_id);
			pstmt_syn.setString(5 ,login_at_ws_no);
			pstmt_syn.setString(6 ,login_facility_id);
			pstmt_syn.setString(7 ,login_by_id);
			pstmt_syn.setString(8 ,login_at_ws_no);
			pstmt_syn.setString(9 ,login_facility_id);
			pstmt_syn.setString(10,effective_status_primary);//*************
			pstmt_syn.addBatch() ;

		}


		if(effective_status_directCare.trim().equalsIgnoreCase("Y")){
			pstmt_syn.setString(1 ,order_set_code);
			pstmt_syn.setString(2 ,"DC");
			pstmt_syn.setString(3 ,(String)synonymsStr.get("catalog_synonym_directCare"));
			pstmt_syn.setString(4 ,login_by_id);
			pstmt_syn.setString(5 ,login_at_ws_no);
			pstmt_syn.setString(6 ,login_facility_id);
			pstmt_syn.setString(7 ,login_by_id);
			pstmt_syn.setString(8 ,login_at_ws_no);
			pstmt_syn.setString(9 ,login_facility_id);
			pstmt_syn.setString(10,effective_status_directCare);//*************
			pstmt_syn.addBatch() ;
		}



		if(effective_status_ancillaryDept.trim().equalsIgnoreCase("Y")){
			pstmt_syn.setString(1 ,order_set_code);
			pstmt_syn.setString(2 ,"AD");
			pstmt_syn.setString(3 ,(String)synonymsStr.get("catalog_synonym_ancillaryDept"));
			pstmt_syn.setString(4 ,login_by_id);
			pstmt_syn.setString(5 ,login_at_ws_no);
			pstmt_syn.setString(6 ,login_facility_id);
			pstmt_syn.setString(7 ,login_by_id);
			pstmt_syn.setString(8 ,login_at_ws_no);
			pstmt_syn.setString(9 ,login_facility_id);
			pstmt_syn.setString(10,effective_status_ancillaryDept);//*************
			pstmt_syn.addBatch();
		}


			insert_syn = pstmt_syn.executeBatch();


	/**************INSERT INTO OR_ORDER BY PTCL*******************/

			int sizeSettings			=settingsStr.size()  ;
			int iterateVal				=0;

			 traceVal.append("Settings="+sizeSettings + "   //////");


			iterateVal = sizeSettings ;



if(sizeSettings > 0){ //i:e page is visited in  update mode
///Assumption that corresponding Index of a particular Patient Class is same in Both the tabs is  same
	HashMap tempSetting=null;
	String setting_applicability="";
	String patient_class="";
	String age_group_code = "";//IN063686
	for(int i = 0; i < iterateVal ; i++){//0 for the default

			    tempSetting = (HashMap)settingsStr.get(i);
				setting_applicability	    =(String)tempSetting.get("setting_applicability");

				if(setting_applicability.trim().equalsIgnoreCase("A") || i== 0 ){

				patient_class	=(String)tempSetting.get("patient_class");
				age_group_code	=(String)tempSetting.get("age_group_code");//IN063686

				pstmt_ptcl.setString(1	 ,order_set_code);
				pstmt_ptcl.setString(2	 ,patient_class);
				pstmt_ptcl.setString(3	 ,"X");
				pstmt_ptcl.setString(4	 ,"N");
				pstmt_ptcl.setString(5	 ,"N");
				pstmt_ptcl.setString(6	 ,"N");
				pstmt_ptcl.setString(7	 ,"A");
				pstmt_ptcl.setString(8	 ,"");
				pstmt_ptcl.setString(9	 ,"");
				pstmt_ptcl.setString(10	 ,"");
				pstmt_ptcl.setString(11	 ,"");
				pstmt_ptcl.setString(12	 ,"");
				pstmt_ptcl.setString(13	 ,"");
				pstmt_ptcl.setString(14	 ,"");
				pstmt_ptcl.setString(15	 ,"");
				pstmt_ptcl.setString(16  ,"");
				//IN063686 Start.
				/*pstmt_ptcl.setString(17	 ,login_by_id);
				pstmt_ptcl.setString(18	 ,login_at_ws_no);
				pstmt_ptcl.setString(19  ,login_facility_id);
				pstmt_ptcl.setString(20  ,login_by_id);
				pstmt_ptcl.setString(21  ,login_at_ws_no);
				pstmt_ptcl.setString(22  ,login_facility_id);
				pstmt_ptcl.setString(23  ,"");*///Commented for IN063686
				pstmt_ptcl.setString(17	 ,age_group_code);
				pstmt_ptcl.setString(18	 ,login_by_id);
				pstmt_ptcl.setString(19	 ,login_at_ws_no);
				pstmt_ptcl.setString(20  ,login_facility_id);
				pstmt_ptcl.setString(21  ,login_by_id);
				pstmt_ptcl.setString(22  ,login_at_ws_no);
				pstmt_ptcl.setString(23  ,login_facility_id);
				pstmt_ptcl.setString(24  ,"");
				//IN063686 End.
				pstmt_ptcl.addBatch();
		   	}//end of For Loop for PTCL INSERTION
	}

				insert_ptcl = pstmt_ptcl.executeBatch();

	}else{ //Page not visisted in update mode

			   traceVal.append("Before assign insert_ptcl.length");
			   insert_ptcl = new int[1];
	}

			traceVal.append("afterInsertion="+insert_ptcl.length);


/*****************INSERTION FOR OR ORDER Set Component************/

		 int noOfRecords = componentStr.size() ;

	 if(noOfRecords > 0){ //i:e page is visited in  update mode
HashMap currData=null;
String  associate_yn="";
		 for(int k=0 ; k< noOfRecords ; k++){
	   currData	     =(HashMap)componentStr.get(k);
		associate_yn	 =(String)currData.get("associate_yn");

		traceVal.append("order_category="+order_category);

		 if(associate_yn.trim().equalsIgnoreCase("Y")){

			pstmt_comp.setString(1	,order_set_code);
			pstmt_comp.setString(2	,(String)currData.get("order_set_seq_num"));
			pstmt_comp.setString(3	,(String)currData.get("order_catalog_code"));
			pstmt_comp.setString(4	,(String)currData.get("order_type_code"));
			pstmt_comp.setString(5	,(String)currData.get("order_category"));
			pstmt_comp.setString(6	,(String)currData.get("reqd_or_opt_ind"));
			pstmt_comp.setString(7	,(String)currData.get("rel_start_date_time"));
			pstmt_comp.setString(8	,(String)currData.get("route_code"));
			pstmt_comp.setString(9	,(String)currData.get("qty_unit"));	 //Not in sec phase
			pstmt_comp.setString(10 ,(String)currData.get("qty_value")); //Not in sec phase
			pstmt_comp.setString(11 ,(String)currData.get("freq_code"));
			pstmt_comp.setString(12 ,(String)currData.get("durn_value"));
			pstmt_comp.setString(13 ,(String)currData.get("durn_type"));
			pstmt_comp.setString(14 ,(String)currData.get("prompt_msg"));//Not in sec phase
			pstmt_comp.setString(15 ,login_by_id);
			pstmt_comp.setString(16 ,login_at_ws_no);
			pstmt_comp.setString(17 ,login_facility_id);
			pstmt_comp.setString(18 ,login_by_id);
			pstmt_comp.setString(19 ,login_at_ws_no);
			pstmt_comp.setString(20 ,login_facility_id);
			pstmt_comp.setInt(21 ,1);

			pstmt_comp.addBatch();

		 }//End of if


		 } //End of For loop
		   	insert_comp = pstmt_comp.executeBatch();
		 }else{//In case page is not visited the no Updation required
		    insert_comp = new int[1];
		 }

		traceVal.append("insert_comp="+insert_comp.length);

		boolean insert_cmp	=  false ;
		boolean insert_ptl	=  false ;
		boolean insert_sy	=  false ;


		 if((insert_comp.length > 0)){ //check updation in Component
					insert_cmp= true ;
		 }else if((insert_comp.length == (-3))){
					insert_cmp= false ;
		 }


		 if((insert_ptcl.length > 0)){ //check updation in PTCL
					insert_ptl= true ;
		 }else if((insert_ptcl.length == (-3))){
					insert_ptl= false ;
		 }


		 if((insert_syn.length > 0)){ //check updation in SYN
					insert_sy= true ;
		 }else if((insert_syn.length == (-3))){
					insert_sy= false ;
		 }


		if (update_cr > 0  && insert_sy  && insert_cmp && insert_ptl){
				connection.commit();
				map.put( "result", new Boolean( true ) ) ;
				messages.append("RECORD_INSERTED") ;
	}else{
				connection.rollback();
				messages.append( "Insert Failed" ) ;
	}

	}catch( Exception e ){
					traceVal.append("In Exception==");
					e.printStackTrace();
					traceVal.append(e.getMessage());
					map.put( "traceVal", traceVal.toString() ) ;

			try {
						connection.rollback();
						//closeConnection(connection);
				} catch ( Exception ee ) {
						messages.append(ee.getMessage() ) ;
				}
				messages.append( e.getMessage() ) ;

				e.printStackTrace() ;
    		  }finally{
	            	try {

						closeResultSet(rs_eff);
						closeStatement(del_pstmt_syn);
						closeStatement(del_pstmt_ptcl);
						closeStatement(del_pstmt_comp);
						closeStatement(pstmt_eff);
						closeStatement(pstmt_cr);
						closeStatement(pstmt_comp);
						closeStatement(pstmt_syn);
						closeStatement(pstmt_ptcl);
						closeConnection(connection);
					} catch ( Exception fe ) {

					   	fe.printStackTrace() ;
			        }
	    	    }

			map.put( "message", messages.toString() ) ;
			map.put( "traceVal", traceVal.toString() ) ;
			return map ;
}

   public ArrayList getFrequency(String category,String catalogcode)  throws Exception
	{

	  
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
	try {
			connection			= getConnection() ;
			//IN062992, starts
			//pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDERSET_FREQ_CODE")  ) ;
			if(isSiteSpecificYN() && "PH".equals(category.trim()) && "C".equals(getApplicableTo()))
			{
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDERSET_FREQ_CODE_ONCOLOGY")  ) ;
			}
			else
			{
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDERSET_FREQ_CODE")  ) ;
			}
			//IN062992, ends
			pstmt.setString( 1, category);
			pstmt.setString( 2, catalogcode);
			resultSet = pstmt.executeQuery() ;
		
		  while (  resultSet!=null && resultSet.next()) {
  				 		String[] record = new String[36];
						record[0] = checkForNull(resultSet.getString( "FREQ_CODE" ),"")   ;
						record[1] = checkForNull(resultSet.getString( "freq_desc" ),"")  ;
						OrderCat.add(record) ;
						
 				}
				
	} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return OrderCat;
	}

public String getRouteDesc(String route_code) {
	
Connection connection	= null ;
PreparedStatement pstmt = null ;
ResultSet rs			= null;
String result="N";

try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_SET_COMPONENT_ROUTE_DESC") ) ;
			pstmt.setString(1, route_code);

			rs = pstmt.executeQuery() ;
			while (rs.next()){			
			result=rs.getString("description");
			}

}
catch( Exception e )
	{

		e.printStackTrace() ;
	}
finally
	{
	try{
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		} catch (Exception ee) {

				ee.printStackTrace() ;
		}
	}

	return result;

}

/*
		This method returns Y if billing is installed
		else N
	*/
	public String getBillingInstalledYN() throws Exception
	{
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet rs			= null;
		String bill_install_yn   ="N";
		try
		{
			connection = getConnection();
			String sql = OrRepository.getOrKeyValue("SQL_OR_CHECK_MODULE_INSTALL_YN");
			pstmt	   = connection.prepareStatement(sql);
			pstmt.setString(1,"BL");
			rs		   = pstmt.executeQuery();
			while(rs!=null && rs.next())
			{
				bill_install_yn =  rs.getString("INSTALL_YN");
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				closeResultSet( rs ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			catch(Exception e)
			{
				e.printStackTrace() ;
			}
		}
		return bill_install_yn;
	}
	
	private void billingSync(Hashtable request)
	{

		String tabType  = "";


		if(request.containsKey("tabType"))
			tabType = (String)request.get("tabType");
		//if(tabType.trim().equalsIgnoreCase("B"))
		//{
			HashMap record= null;

			if(!billingRecStr.isEmpty())
				record = (HashMap)billingRecStr.get(0);
			else
				record = new HashMap();


			record.put("bill_yn"					,	chkPresent(request,"bill_yn","N"));
			record.put("charge_type_applicable"		,	chkPresent(request,"charge_type_applicable","S"));
			record.put("ord_set_charge_pat_yn"		,	chkPresent(request,"ord_set_charge_pat_yn","N"));
			record.put("fpp_category"		,	chkPresent(request,"fpp_category","N"));//IN072524


			if(billingRecStr.isEmpty())
				billingRecStr.add(record);
		//}


	}

	public boolean setBeanItemValue(int rowIndex, String order_set_seq_num,String include,String order_type_code,String qty_unit,String qty_uom,String route_code,String freq_code,String durn_value,String durn_type,String rel_start_date_time,String reqd_or_opt_ind,String prompt_msg,String catalogCode)throws Exception
	{
		

		boolean altSelRecord  =	false;
		boolean altDBRecord =	false;
		int foundIndex = -1;
		java.util.HashMap hash = new java.util.HashMap();
		hash = (java.util.HashMap)componentStr.getListObject(rowIndex);
		String temp_order_catalog_code = "";

		if(include.equals("Y"))
		{
			hash.put("associate_yn", "Y");
			hash.put("order_set_seq_num", order_set_seq_num);
			hash.put("order_type_code", order_type_code);
			hash.put("qty_unit", qty_unit);
			hash.put("qty_uom", qty_uom);
			hash.put("route_code", route_code);
			hash.put("freq_code", freq_code);
			hash.put("durn_value", durn_value);
			hash.put("durn_type", durn_type);
			hash.put("rel_start_date_time", rel_start_date_time);
			hash.put("reqd_or_opt_ind", reqd_or_opt_ind);
			hash.put("prompt_msg", prompt_msg);
			hash.put("item_narration", "");
			hash.put("occ_no", "");//IN68241
			hash.put("status", "y");
			hash.put("valid", "N");
			altSelRecord = componentStr.setListObject(rowIndex, hash);

			if(altSelRecord)
			{

               	ArrayList allRecords = new ArrayList();
				allRecords = componentStr.getAllDBRecords();						
				java.util.HashMap hashValue = new java.util.HashMap();						
				if(allRecords!=null)
				{
					for(int z=0; z<allRecords.size();z++)
					{
							hashValue =(java.util.HashMap)componentStr.getObject(z);
							temp_order_catalog_code = (String)hashValue.get("order_catalog_code");
							if(catalogCode.equals(temp_order_catalog_code))
							{
								foundIndex = z;
								break;
							}
						}
				}					
				if(foundIndex != -1)
				{
					altDBRecord = componentStr.setObject(foundIndex,hash);
				}
				else
				{
					componentStr.putObject(hash);
				}
			}
			
		}
		else if(include.equals("N"))
		{
			hash.put("associate_yn", "D");
			hash.put("order_set_seq_num", "");
			hash.put("order_type_code", "");
			hash.put("qty_unit", "");
			hash.put("qty_uom", "");
			hash.put("route_code", "");
			hash.put("freq_code", "");
			hash.put("durn_value", "");
			hash.put("durn_type", "");
			hash.put("rel_start_date_time", "");
			hash.put("reqd_or_opt_ind", "");
			hash.put("prompt_msg", "");
			hash.put("item_narration", "");
			hash.put("occ_no", "");//IN68241
			hash.put("status", "y");
			hash.put("valid", "N");
			altSelRecord = componentStr.setListObject(rowIndex, hash);   
		
			if(altSelRecord)
			{
				altDBRecord = componentStr.removeRecord(hash);
			}
		}
		
		return altDBRecord;
	}
	 /***************************To get the multiRecord bean ***********/
	 public Object getBean()
	{
		return this.componentStr;
	 }//end of getBean
	 /*Added by Uma on 6/7/2010 for IN021348*/
	 public void setHashValues(Hashtable hash) throws Exception
	 {
		
		String index_value	= (String)hash.get("INDEX_VALUES");
		String value_str	= (String)hash.get("VALUE_STR");
		String order_set_seq_num 	= (String)hash.get("ORDER_SET_SEQ_NUM");
		String qty_value 	= (String)hash.get("QTY_VALUE");
		String qty_uom 	= (String)hash.get("QTY_UOM");
		String route_code 	= (String)hash.get("ROUTE_CODE");
		String freq_code 	= (String)hash.get("FREQ_CODE");
		String durn_value 	= (String)hash.get("DURN_VALUE");
		String durn_type 	= (String)hash.get("DURN_TYPE");
		String rel_start_date_time 	= (String)hash.get("REL_START_DATE_TIME");
		String reqd_or_opt_ind 	= (String)hash.get("REQD_OR_OPT_IND");
		String prompt_msg 	= (String)hash.get("PROMPT_MSG");
		String catalog_code	= (String)hash.get("CATALOG_CODE");
		String order_type_code	= (String)hash.get("ORDER_TYPE_CODE");
		String count	= (String)hash.get("COUNT");
		String occ_no	= (String)hash.get("OCC_NO");//IN68241
		String l_order_category = (String)getCareSetHeaderStr().get("order_category");//IN68241

		String update_value	="";
		String index	="";

		int total_records = Integer.parseInt(count);		

		StringTokenizer indexstoken = new StringTokenizer(index_value,"~");
		StringTokenizer stoken = new StringTokenizer(value_str,"~");
		StringTokenizer stoken1 = new StringTokenizer(order_set_seq_num,"~");
		StringTokenizer qty_values = new StringTokenizer(qty_value,"~");
		StringTokenizer order_type_codes = new StringTokenizer(order_type_code,"~");
		StringTokenizer qty_uoms = new StringTokenizer(qty_uom,"~");
		StringTokenizer route_codes = new StringTokenizer(route_code,"~");
		StringTokenizer freq_codes = new StringTokenizer(freq_code,"~");
		StringTokenizer durn_values = new StringTokenizer(durn_value,"~");
		StringTokenizer durn_types = new StringTokenizer(durn_type,"~");
		StringTokenizer rel_start_date_times = new StringTokenizer(rel_start_date_time,"~");
		StringTokenizer reqd_or_opt_inds = new StringTokenizer(reqd_or_opt_ind,"~");
		//StringTokenizer prompt_msgs = new StringTokenizer(prompt_msg,"~");//IN065144
		StringTokenizer prompt_msgs = new StringTokenizer(java.net.URLDecoder.decode(prompt_msg,"UTF-8"),"~");//IN065144
		StringTokenizer occ_nos = new StringTokenizer(java.net.URLDecoder.decode(occ_no,"UTF-8"),"~");//IN68241

		HashMap hashindex = new HashMap();
	
		HashMap hashmap = new HashMap();
		try
		{
			for(int j=1; j<=total_records; j++)
			{
				if(indexstoken.hasMoreTokens()) 
				{
					index		=	 indexstoken.nextToken();				
				}
				else 
				{
					index		=	 "";
				}
				if(stoken.hasMoreTokens()) 
				{
					update_value		=	 stoken.nextToken();				
				}
				else 
				{
					update_value		=	 "";
				}
				if(stoken.hasMoreTokens()) 
				{
					update_value		=	 stoken.nextToken();				
				}
				else 
				{
					update_value		=	 "";
				}
				if(stoken1.hasMoreTokens()) 
				{
					order_set_seq_num			=	 (stoken1.nextToken()).trim();
					if(order_set_seq_num.equals("@#"))
						order_set_seq_num		=	 "";
				}
				else 
				{
					order_set_seq_num			=	 "";
				}

				if(qty_values.hasMoreTokens()) 
				{
					qty_value			=	  (qty_values.nextToken()).trim();
					if(qty_value.equals("@#"))
						qty_value		=	 "";
				}
				else 
				{
					qty_value			=	 "";
				}

				if(order_type_codes.hasMoreTokens()) 
				{
					order_type_code		=	  (order_type_codes.nextToken()).trim();
				}
				else 
				{
					order_type_code			=	 "";
				}			

				if(qty_uoms.hasMoreTokens()) 
				{
					qty_uom		=	  (qty_uoms.nextToken()).trim();
					if(qty_uom.equals("@#"))
						qty_uom		=	 "";
				}
				else 
				{
					qty_uom			=	 "";
				}

				if(route_codes.hasMoreTokens()) 
				{
					route_code		=	  (route_codes.nextToken()).trim();
					if(route_code.equals("@#"))
						route_code		=	 "";
				}
				else 
				{
					route_code			=	 "";
				}

				if(freq_codes.hasMoreTokens()) 
				{
					freq_code		=	  (freq_codes.nextToken()).trim();
					if(freq_code.equals("@#"))
						freq_code		=	 "";
				}
				else 
				{
					freq_code			=	 "";
				}

				if(durn_values.hasMoreTokens()) 
				{
					durn_value		=	  (durn_values.nextToken()).trim();
					if(durn_value.equals("@#"))
						durn_value		=	 "";
				}
				else 
				{
					durn_value			=	 "";
				}

				if(durn_types.hasMoreTokens()) 
				{
					durn_type		=	  (durn_types.nextToken()).trim();
					if(durn_type.equals("@#"))
						durn_type		=	 "";
				}
				else 
				{
					durn_type			=	 "";
				}
				
				if(rel_start_date_times.hasMoreTokens()) 
				{
					rel_start_date_time		=	  (rel_start_date_times.nextToken()).trim();
					if(rel_start_date_time.equals("@#"))
						rel_start_date_time		=	 "";
				}
				else 
				{
					rel_start_date_time			=	 "";
				} 

				if(reqd_or_opt_inds.hasMoreTokens()) 
				{
					reqd_or_opt_ind		=	  (reqd_or_opt_inds.nextToken()).trim();
					if(reqd_or_opt_ind.equals("@#"))
						reqd_or_opt_ind		=	 "";
				}
				else 
				{
					reqd_or_opt_ind			=	 "";
				} 
				
				if(prompt_msgs.hasMoreTokens()) 
				{
					prompt_msg		=	  (prompt_msgs.nextToken()).trim();
					if(prompt_msg.equals("@#"))
						prompt_msg		=	 "";
				}
				else 
				{
					prompt_msg			=	 "";
				}			
				
				//IN68241, starts
				if(occ_nos.hasMoreTokens()) 
				{
					occ_no		=	  (occ_nos.nextToken()).trim();
					if(occ_no.equals("@#"))
						occ_no		=	 "";
				}
				else 
				{
					occ_no			=	 "";
				}
				//IN68241, ends
			
				hashmap = new HashMap();
			
				hashmap.put("associate_yn" , "Y");
				hashmap.put("order_set_seq_num" , order_set_seq_num);
				hashmap.put("order_type_code" , order_type_code);
				hashmap.put("qty_value" , qty_value);
				hashmap.put("qty_uom" , qty_uom);
				hashmap.put("route_code" , route_code);
				hashmap.put("freq_code" , freq_code);
				hashmap.put("durn_value" , durn_value);
				hashmap.put("durn_type" , durn_type);
				hashmap.put("rel_start_date_time" , rel_start_date_time);
				hashmap.put("reqd_or_opt_ind" , reqd_or_opt_ind);
				hashmap.put("prompt_msg", prompt_msg);
				hashmap.put("item_narration", "");
				hashmap.put("occ_no", occ_no);
				hashmap.put("status" , "y");
				hashmap.put("valid" , "N");
				hashmap.put("update_value" , update_value);
				hashmap.put("index" , index);

				//IN68241, starts
				//hashindex.put(index,hashmap);
				if(isSiteSpecificYN() && "PH".equals(l_order_category) && "C".equals(getApplicableTo()))
					hashindex.put(occ_no,hashmap);
				else
					hashindex.put(index,hashmap);
				//IN68241, ends
				
			}

			hashCatalog.put(catalog_code , hashindex);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public HashMap getDBAdditionalCatalogs()
	{
		return hashCatalog;
	}
	
	public void additionalDBCatalogs(String order_set_code) throws Exception
	{
		Connection connection			= null ;
		PreparedStatement pstmt			= null ;
		ResultSet rs					= null;
		String sql						= (String)OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_SET_ADDITIONAL_DBRECORDS");
		HashMap hashmap					= new HashMap();
		HashMap hashindex				= null;
		String order_set_seq_num		= "";
		String order_type_code			= "";
		String qty_value					= "";
		String qty_uom					= "";
		String route_code				= "";
		String freq_code				= "";
		String durn_value				= "";
		String durn_type				= "";
		String rel_start_date_time		= "";
		String reqd_or_opt_ind			= "";
		String update_value				= "";
		String index					= "";
		String order_catalog_code		= "";
		String temp_order_catalog_code  = "";
		String prompt_msg				= "";

		if(order_set_code==null)
			order_set_code				= "";

		try
		{
			connection					= getConnection();
			pstmt						= connection.prepareStatement(sql);
			pstmt.setString(1 , order_set_code);
			rs							= pstmt.executeQuery();

			while(rs!=null&&rs.next())
			{
			
				order_catalog_code		= rs.getString("ORDER_CATALOG_CODE")==null?"":rs.getString("ORDER_CATALOG_CODE");
				order_set_seq_num		= rs.getString("order_set_seq_num")==null?"":rs.getString("order_set_seq_num");
				order_type_code			= rs.getString("order_type_code")==null?"":rs.getString("order_type_code");
				qty_value				= rs.getString("qty_value")==null?"":rs.getString("qty_value");
				qty_uom					= rs.getString("qty_unit")==null?"":rs.getString("qty_unit");
				route_code				= rs.getString("ROUTE_CODE")==null?"":rs.getString("ROUTE_CODE");
				freq_code				= rs.getString("freq_code")==null?"":rs.getString("freq_code");
				durn_value				= rs.getString("durn_value")==null?"":rs.getString("durn_value");
				durn_type				= rs.getString("durn_type")==null?"":rs.getString("durn_type");
				rel_start_date_time				= rs.getString("rel_start_date_time")==null?"":rs.getString("rel_start_date_time");
				reqd_or_opt_ind				= rs.getString("reqd_or_opt_ind")==null?"":rs.getString("reqd_or_opt_ind");
				index				= rs.getString("OCURRANCE_NUM")==null?"":rs.getString("OCURRANCE_NUM");
				prompt_msg				= rs.getString("item_narration")==null?"":rs.getString("item_narration");
				if(!temp_order_catalog_code.equalsIgnoreCase(order_catalog_code))
				{
					if(hashindex!=null)
					{
						if(hashindex.size()>0)
						{
							hashCatalog.put(temp_order_catalog_code , hashindex);
						}
					}
					hashindex = new HashMap ();					
					temp_order_catalog_code = order_catalog_code;
				}
				
				hashmap = new HashMap();
				hashmap.put("associate_yn" , "Y");
				hashmap.put("order_set_seq_num" , order_set_seq_num);
				hashmap.put("order_type_code" , order_type_code);
				hashmap.put("qty_value" , qty_value);
				hashmap.put("qty_uom" , qty_uom);
				hashmap.put("route_code" , route_code);
				hashmap.put("freq_code" , freq_code);
				hashmap.put("durn_value" , durn_value);
				hashmap.put("durn_type" , durn_type);
				hashmap.put("rel_start_date_time" , rel_start_date_time);
				hashmap.put("reqd_or_opt_ind" , reqd_or_opt_ind);
				hashmap.put("prompt_msg", prompt_msg);
				hashmap.put("item_narration", "");
				hashmap.put("occ_no", index);//IN68241
				hashmap.put("status" , "y");
				hashmap.put("valid" , "N");
				hashmap.put("update_value" , update_value);
				hashmap.put("index" , index);

				hashindex.put(index,hashmap);

			}
			if(hashindex!=null)
			{
				if(hashindex.size()>0)
				{
					hashCatalog.put(temp_order_catalog_code , hashindex);
				}
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally//IN062992, starts
		{
			try
			{
				closeResultSet(rs);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}//IN062992, ends
		
	}
	/*Ends Here by Uma on 6/7/2010 for IN021348*/

	//IN062992, starts
	public void setAgeGrpWiseHashValues(Hashtable hash) throws Exception
	{		
		String index_value	= (String)hash.get("INDEX_VALUES");
		String value_str	= (String)hash.get("VALUE_STR");
		String order_set_seq_num 	= (String)hash.get("ORDER_SET_SEQ_NUM");
		String route_code 	= (String)hash.get("ROUTE_CODE");
		String freq_code 	= (String)hash.get("FREQ_CODE");
		String durn_value 	= (String)hash.get("DURN_VALUE");
		String durn_type 	= (String)hash.get("DURN_TYPE");
		String rel_start_date_time 	= (String)hash.get("REL_START_DATE_TIME");
		String prompt_msg 	= (String)hash.get("PROMPT_MSG");
		String catalog_code	= (String)hash.get("CATALOG_CODE");
		String count	= (String)hash.get("COUNT");
		String age_group_str	= (String)hash.get("AGE_GROUP_STR");
		String qty_unit_str	= (String)hash.get("QTY_UNIT_STR");
		//String qty_uom_str	= (String)hash.get("QTY_UOM_STR");//IN68241
		String qty_uom_str	= (String)hash.get("QTY_UOM");//IN68241
		String route_desc	= (String)hash.get("ROUTE_DESC");
		String occ_no	= (String)hash.get("OCC_NO");//IN68241

		String update_value	="";
		String index	="";

		int total_records = Integer.parseInt(count);		

		StringTokenizer indexstoken = new StringTokenizer(index_value,"~");
		StringTokenizer stoken = new StringTokenizer(value_str,"~");
		StringTokenizer route_codes = new StringTokenizer(route_code,"~");
		StringTokenizer route_descs = new StringTokenizer(route_desc,"~");
		StringTokenizer freq_codes = new StringTokenizer(freq_code,"~");
		StringTokenizer durn_values = new StringTokenizer(durn_value,"~");
		StringTokenizer durn_types = new StringTokenizer(durn_type,"~");
		StringTokenizer rel_start_date_times = new StringTokenizer(rel_start_date_time,"~");
		//StringTokenizer prompt_msgs = new StringTokenizer(prompt_msg,"~");//IN065144
		StringTokenizer prompt_msgs = new StringTokenizer(java.net.URLDecoder.decode(prompt_msg,"UTF-8"),"~");//IN065144
		StringTokenizer age_group_strs = new StringTokenizer(age_group_str,"~");
		StringTokenizer qty_unit_strs = new StringTokenizer(qty_unit_str,"~");
		StringTokenizer qty_uom_strs = new StringTokenizer(qty_uom_str,"~");
		StringTokenizer occ_nos = new StringTokenizer(occ_no,"~");//IN68241

		HashMap hashindex = new HashMap();	
		HashMap hashmap = new HashMap();
		HashMap ageWiseAdditionalTemp = new HashMap();//IN68241	

		try
		{
			for(int j=1; j<=total_records; j++)
			{
				if(indexstoken.hasMoreTokens()) 
				{
					index		=	 indexstoken.nextToken();			
				}
				else 
				{
					index		=	 "";
				}

				if(stoken.hasMoreTokens()) 
				{
					update_value		=	 stoken.nextToken();				
				}
				else 
				{
					update_value		=	 "";
				}

				if(stoken.hasMoreTokens()) 
				{
					update_value		=	 stoken.nextToken();				
				}
				else 
				{
					update_value		=	 "";
				}

				if(route_codes.hasMoreTokens()) 
				{
					route_code		=	  (route_codes.nextToken()).trim();
					if(route_code.equals("@#"))
						route_code		=	 "";
				}
				else 
				{
					route_code			=	 "";
				}

				if(route_descs.hasMoreTokens()) 
				{
					route_desc		=	  (route_descs.nextToken()).trim();
					if(route_desc.equals("@#"))
						route_desc		=	 "";
				}
				else 
				{
					route_desc			=	 "";
				}

				if(freq_codes.hasMoreTokens()) 
				{
					freq_code		=	  (freq_codes.nextToken()).trim();
					if(freq_code.equals("@#"))
						freq_code		=	 "";
				}
				else 
				{
					freq_code			=	 "";
				}

				if(durn_values.hasMoreTokens()) 
				{
					durn_value		=	  (durn_values.nextToken()).trim();
					if(durn_value.equals("@#"))
						durn_value		=	 "";
				}
				else 
				{
					durn_value			=	 "";
				}

				if(durn_types.hasMoreTokens()) 
				{
					durn_type		=	  (durn_types.nextToken()).trim();
					if(durn_type.equals("@#"))
						durn_type		=	 "";
				}
				else 
				{
					durn_type			=	 "";
				}
				
				if(rel_start_date_times.hasMoreTokens()) 
				{
					rel_start_date_time		=	  (rel_start_date_times.nextToken()).trim();
					
					if(rel_start_date_time.equals("@#"))
						rel_start_date_time		=	 "";
				}
				else 
				{
					rel_start_date_time			=	 "";
				}			
				
				if(prompt_msgs.hasMoreTokens()) 
				{
					prompt_msg		=	  (prompt_msgs.nextToken()).trim();
					
					if(prompt_msg.equals("@#"))
						prompt_msg		=	 "";
				}
				else 
				{
					prompt_msg			=	 "";
				} 

				if(age_group_strs.hasMoreTokens()) 
				{
					age_group_str		=	  (age_group_strs.nextToken()).trim();
					
					if(age_group_str.equals("@#"))
						age_group_str		=	 "";
				}
				else 
				{
					age_group_str			=	 "";
				} 

				if(qty_unit_strs.hasMoreTokens()) 
				{
					qty_unit_str		=	  (qty_unit_strs.nextToken()).trim();
					if(qty_unit_str.equals("@#"))
						qty_unit_str		=	 "";
				}
				else 
				{
					qty_unit_str			=	 "";
				}

				if(qty_uom_strs.hasMoreTokens()) 
				{
					qty_uom_str		=	  (qty_uom_strs.nextToken()).trim();
					
					if(qty_uom_str.equals("@#"))
						qty_uom_str		=	 "";
				}
				else 
				{
					qty_uom_str			=	 "";
				}
				
				//IN68241, starts
				if(occ_nos.hasMoreTokens()) 
				{
					occ_no		=	  (occ_nos.nextToken()).trim();
					
					if(occ_no.equals("@#"))
						occ_no	=	 "";
				}
				else 
				{
					occ_no			=	 "";
				}
				//IN68241, ends

				hashmap = new HashMap();
			
				hashmap.put("associate_yn" , "Y");
				hashmap.put("order_catalog_code" , catalog_code);
				hashmap.put("order_set_seq_num" , order_set_seq_num);
				hashmap.put("route_code" , route_code);
				hashmap.put("route_desc" , route_desc);
				hashmap.put("freq_code" , freq_code);
				hashmap.put("durn_value" , durn_value);
				hashmap.put("durn_type" , durn_type);
				hashmap.put("rel_start_date_time" , rel_start_date_time);
				hashmap.put("prompt_msg", prompt_msg);
				hashmap.put("item_narration", "");
				hashmap.put("occ_no", "");
				hashmap.put("status" , "y");
				hashmap.put("valid" , "N");
				hashmap.put("update_value" , update_value);
				hashmap.put("age_group_code" , age_group_str);
				hashmap.put("qty_unit" , qty_unit_str);
				hashmap.put("qty_uom" , qty_uom_str);
				hashmap.put("occ_no" , occ_no);//IN68241
				
				//IN68241, starts
				if(hashAdditionalCatalogAgeWise.containsKey(catalog_code+"_"+age_group_str))
					ageWiseAdditionalTemp.put(catalog_code+"_"+age_group_str, hashAdditionalCatalogAgeWise.get(catalog_code+"_"+age_group_str));
				//IN68241, ends

				hashindex.put(age_group_str,hashmap);
			}

			hashCatalogAgeWise.put(catalog_code , hashindex);
			//hashAdditionalCatalogAgeWise = ageWiseAdditionalTemp;//IN68241
			
			//IN68241, starts
			if(hashAdditionalCatalogAgeWise!=null && hashAdditionalCatalogAgeWise.size() > 0)
			{
				HashMap<String, String> manipulateMap = hashAdditionalCatalogAgeWise;
				ArrayList<String> removeKeysList = new ArrayList<String>();
	
				for(Map.Entry entry : manipulateMap.entrySet()) 
				{
					if(((String)entry.getKey()).startsWith(catalog_code+"_"))
					{
						removeKeysList.add((String) entry.getKey());
					}
				}
	
				for(int i=0;i<removeKeysList.size();i++)
				{
					if(hashAdditionalCatalogAgeWise.containsKey(removeKeysList.get(i)))
						hashAdditionalCatalogAgeWise.remove(removeKeysList.get(i));						
				}
				
				hashAdditionalCatalogAgeWise.putAll(ageWiseAdditionalTemp);
			}
			//IN68241, ends
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}		
	}

	public HashMap getDBAgeWiseCatalogs()
	{
		return hashCatalogAgeWise;
	}

	public void ageWiseDBCatalogs(String order_set_code) throws Exception
	{
		Connection connection			= null ;
		PreparedStatement pstmt			= null ;
		ResultSet rs					= null;
		//String sql						= " SELECT   ORDER_SET_CODE, ORDER_SET_SEQ_NUM, ORDER_CATALOG_CODE,QTY_VALUE,QTY_UOM, AGE_GROUP, FREQ_CODE, DURN_VALUE, DURN_TYPE, REL_START_DATE_TIME,ROUTE_CODE,(SELECT ROUTE_DESC FROM PH_ROUTE WHERE ROUTE_CODE = A.ROUTE_CODE)ROUTE_DESC, ITEM_NARRATION FROM OR_ORDER_SET_COMP_BY_AGE_GRP A WHERE ORDER_SET_CODE = ? ORDER BY ORDER_CATALOG_CODE ";//IN065713
		String sql						= " SELECT   ORDER_SET_CODE, ORDER_SET_SEQ_NUM, ORDER_CATALOG_CODE,QTY_VALUE,QTY_UOM, AGE_GROUP, FREQ_CODE, DURN_VALUE, DURN_TYPE, REL_START_DATE_TIME,ROUTE_CODE,(SELECT ROUTE_DESC FROM PH_ROUTE WHERE ROUTE_CODE = A.ROUTE_CODE)ROUTE_DESC, ITEM_NARRATION FROM OR_ORDER_SET_COMP_BY_AGE_GRP A WHERE ORDER_SET_CODE = ? and OCURRANCE_NUM = 1 ORDER BY ORDER_CATALOG_CODE ";//IN065713
		HashMap hashmap					= new HashMap();
		HashMap hashindex				= null;

		String order_set_seq_num		= "";
		String qty_value					= "";
		String qty_uom					= "";
		String route_code				= "";
		String freq_code				= "";
		String durn_value				= "";
		String durn_type				= "";
		String rel_start_date_time		= "";
		String update_value				= "";
		String order_catalog_code		= "";
		String temp_order_catalog_code  = "";
		String prompt_msg				= "";
		String age_group				= "";
		String route_desc = "";

		if(order_set_code==null)
			order_set_code				= "";		

		try
		{
			connection					= getConnection();
			pstmt						= connection.prepareStatement(sql);
			pstmt.setString(1 , order_set_code);
			rs							= pstmt.executeQuery();

			while(rs!=null && rs.next())
			{			
				order_catalog_code		= rs.getString("order_catalog_code")==null?"":rs.getString("order_catalog_code");
				order_set_seq_num		= rs.getString("order_set_seq_num")==null?"":rs.getString("order_set_seq_num");
				age_group				= rs.getString("age_group")==null?"":rs.getString("age_group");				
				qty_value				= rs.getString("qty_value")==null?"":rs.getString("qty_value");
				qty_uom				    = rs.getString("qty_uom")==null?"":rs.getString("qty_uom");				
				freq_code				= rs.getString("freq_code")==null?"":rs.getString("freq_code");
				durn_value				= rs.getString("durn_value")==null?"":rs.getString("durn_value");
				durn_type				= rs.getString("durn_type")==null?"":rs.getString("durn_type");
				rel_start_date_time		= rs.getString("rel_start_date_time")==null?"":rs.getString("rel_start_date_time");
				route_code				= rs.getString("route_code")==null?"":rs.getString("route_code");
				prompt_msg				= rs.getString("item_narration")==null?"":rs.getString("item_narration");			
				route_desc				= rs.getString("route_desc")==null?"":rs.getString("route_desc");
				
				if(!temp_order_catalog_code.equalsIgnoreCase(order_catalog_code))
				{
					if(hashindex!=null)
					{
						if(hashindex.size()>0)
						{
							hashCatalogAgeWise.put(temp_order_catalog_code , hashindex);
						}
					}

					hashindex = new HashMap ();					
					temp_order_catalog_code = order_catalog_code;
				}
				
				hashmap = new HashMap();
				hashmap.put("associate_yn" , "Y");
				hashmap.put("order_catalog_code" , order_catalog_code);
				hashmap.put("order_set_seq_num" , order_set_seq_num);
				hashmap.put("age_group_code" , age_group);
				hashmap.put("qty_unit" , qty_value);
				hashmap.put("qty_uom" , qty_uom);
				hashmap.put("freq_code" , freq_code);
				hashmap.put("durn_value" , durn_value);
				hashmap.put("durn_type" , durn_type);
				hashmap.put("rel_start_date_time" , rel_start_date_time);
				hashmap.put("route_code" , route_code);
				hashmap.put("prompt_msg", prompt_msg);
				hashmap.put("item_narration", "");
				hashmap.put("occ_no", "");
				hashmap.put("status" , "y");
				hashmap.put("valid" , "y");//IN68241
				hashmap.put("update_value" , update_value);	
				hashmap.put("route_desc" , route_desc);
				hashindex.put(age_group,hashmap);
			}

			if(hashindex!=null)
			{
				if(hashindex.size()>0)
				{
					hashCatalogAgeWise.put(temp_order_catalog_code , hashindex);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				closeResultSet(rs);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}		
	}

	public void clearAdditionalCatalogs()
	{
		if(!hashCatalog.isEmpty())
			hashCatalog.clear();
	}	

	public synchronized void reloadFreqRecordedData()
	{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null;
		String sql = "";
		String l_order_category = (String)getCareSetHeaderStr().get("order_category");//IN062992

		try
		{
			connection	 =  getConnection();
			
			clearComponentStr();

			if(isSiteSpecificYN() && "PH".equals(l_order_category))
			{
				sql = "SELECT a.ORDER_SET_SEQ_NUM ORDER_SET_SEQ_NUM,a.ORDER_CATALOG_CODE ORDER_CATALOG_CODE,b.short_desc short_desc, b.qty_reqd_yn qty_reqd_yn, b.freq_applicable_yn freq_applicable_yn,a.ORDER_TYPE_CODE ORDER_TYPE_CODE,c.SHORT_DESC order_type_desc,a.ORDER_CATEGORY ORDER_CATEGORY,REQD_OR_OPT_IND, REL_START_DATE_TIME,a.ROUTE_CODE ,a.QTY_VALUE QTY_VALUE,a.qty_unit QTY_UNIT ,a.FREQ_CODE FREQ_CODE,a.DURN_VALUE DURN_VALUE,a.DURN_TYPE DURN_TYPE,ITEM_NARRATION,DOSAGE_TYPE,d.strength_value, d.strength_uom FROM or_order_set_component a ,  OR_ORDER_CATALOG b,OR_ORDER_TYPE c, ph_drug d WHERE b.ORDER_CATALOG_CODE = a.ORDER_CATALOG_CODE and b.order_catalog_code = d.drug_code AND c.ORDER_TYPE_CODE = b.ORDER_TYPE_CODE AND order_set_code = ? and order_catalog_nature !='S' and  OCURRANCE_NUM =1" ;
			}
			else
			{
				sql = "SELECT a.ORDER_SET_SEQ_NUM ORDER_SET_SEQ_NUM,a.ORDER_CATALOG_CODE ORDER_CATALOG_CODE,b.short_desc short_desc, b.qty_reqd_yn qty_reqd_yn, b.freq_applicable_yn freq_applicable_yn,a.ORDER_TYPE_CODE ORDER_TYPE_CODE,c.SHORT_DESC order_type_desc,a.ORDER_CATEGORY ORDER_CATEGORY,REQD_OR_OPT_IND, REL_START_DATE_TIME,ROUTE_CODE ,a.QTY_VALUE QTY_VALUE,a.qty_unit QTY_UNIT ,a.FREQ_CODE FREQ_CODE,a.DURN_VALUE DURN_VALUE,a.DURN_TYPE DURN_TYPE,ITEM_NARRATION FROM or_order_set_component a ,  OR_ORDER_CATALOG b,OR_ORDER_TYPE c WHERE b.ORDER_CATALOG_CODE = a.ORDER_CATALOG_CODE AND c.ORDER_TYPE_CODE = b.ORDER_TYPE_CODE AND order_set_code = ? and order_catalog_nature !='S' and  OCURRANCE_NUM =1" ;
			}
			
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1,(String)careSetHeaderStr.get("order_set_code"));

			rs           = pstmt.executeQuery();

			while(rs.next())
			{
				HashMap tempHash = new HashMap();//Represents each record
				HashMap tempHashO = new HashMap();//Represents each record

				loadOrderTypeCodeFreq(rs.getString("order_category"),rs.getString("order_catalog_code"));
				
				HashMap orderFreqStr = getOrderFreqStr();
				ArrayList freq_val	   =(ArrayList)orderFreqStr.get("value") ;
				ArrayList freq_desc    =(ArrayList)orderFreqStr.get("Description") ;

				HashMap  orderTypeStr = getOrderTypeStr();
				ArrayList order_val	   =(ArrayList)orderTypeStr.get("value") ;
				ArrayList order_desc   =(ArrayList)orderTypeStr.get("Description") ;		

				tempHash.put("order_category"		,rs.getString("order_category"));
				tempHash.put("order_catalog_code"	,rs.getString("order_catalog_code"));
				tempHash.put("order_catalog_desc"	,rs.getString("short_desc"));
				tempHash.put("order_type_code"		,rs.getString("order_type_code"));
				tempHash.put("order_type_desc"		,rs.getString("order_type_desc"));
				tempHash.put("order_set_seq_num"	,rs.getString("order_set_seq_num"));
				tempHash.put("prompt_msg"		 ,rs.getString("item_narration")); //Not used in 2nd phase
				tempHash.put("qty_value"	         ,checkForNull(rs.getString("qty_unit"),"1"));
				tempHash.put("route_code"	         ,rs.getString("route_code")); //Not used in 2nd phase
				tempHash.put("qty_unit"				 ,checkForNull(rs.getString("qty_value"),""));
		 
		 
				tempHash.put("qty_reqd_yn"		     ,checkForNull(rs.getString("qty_reqd_yn"),"N"));
				tempHash.put("freq_applicable_yn"	 ,checkForNull(rs.getString("freq_applicable_yn"),"N"));
				tempHash.put("freq_code"			 ,checkForNull(rs.getString("freq_code")));
				tempHash.put("durn_value"			 ,checkForNull(rs.getString("durn_value")));
				tempHash.put("durn_type"			 ,checkForNull(rs.getString("durn_type")));
				tempHash.put("freq_val_opts"		 ,freq_val);
				tempHash.put("freq_desc_opts"		 ,freq_desc);
				tempHash.put("order_val_opts"		 ,order_val);
				tempHash.put("order_desc_opts"		 ,order_desc);
				tempHash.put("rel_start_date_time"	 ,checkForNull(rs.getString("rel_start_date_time")));
				tempHash.put("reqd_or_opt_ind"		 ,checkForNull(rs.getString("reqd_or_opt_ind")));
				tempHash.put("valid"				,"Y");
				tempHash.put("associate_yn"			,"Y");
				tempHash.put("status"				,"Y");
				tempHash.put("occ_no"				,"");

				if(isSiteSpecificYN() && "PH".equals(l_order_category))
				{
					tempHash.put("dosage_type"		 ,checkForNull(rs.getString("dosage_type"),""));
					tempHash.put("strength_uom"		 ,checkForNull(rs.getString("strength_uom"),""));
					tempHash.put("strength_value"		 ,checkForNull(rs.getString("strength_value"),""));
				}

				tempHashO.put("order_category"	,rs.getString("order_category"));
				tempHashO.put("order_catalog_code"	,rs.getString("order_catalog_code"));
				tempHashO.put("order_catalog_desc"	,rs.getString("short_desc"));
				tempHashO.put("order_type_code"		,rs.getString("order_type_code"));
				tempHashO.put("order_type_desc"		,rs.getString("order_type_desc"));
				tempHashO.put("order_set_seq_num"	,rs.getString("order_set_seq_num"));
				tempHashO.put("prompt_msg"		 ,rs.getString("item_narration"));//Not used in 2nd phase
				tempHashO.put("qty_value"	         ,checkForNull(rs.getString("qty_unit"),"1")); //Not used in 2nd phase
				tempHashO.put("route_code"	         ,rs.getString("route_code")); //Not used in 2nd phase
				tempHashO.put("qty_unit"			 ,checkForNull(rs.getString("qty_value"),""));
				tempHashO.put("qty_reqd_yn"			 ,checkForNull(rs.getString("qty_reqd_yn"),"N"));
				tempHashO.put("freq_applicable_yn"	 ,checkForNull(rs.getString("freq_applicable_yn"),"N"));
				tempHashO.put("freq_code"			 ,checkForNull(rs.getString("freq_code")));
				tempHashO.put("durn_value"			 ,checkForNull(rs.getString("durn_value")));
				tempHashO.put("durn_type"			 ,checkForNull(rs.getString("durn_type")));
				tempHashO.put("freq_val_opts"		 ,freq_val);
				tempHashO.put("freq_desc_opts"		 ,freq_desc);
				tempHashO.put("order_val_opts"		 ,order_val);
				tempHashO.put("order_desc_opts"		 ,order_desc);
				tempHashO.put("rel_start_date_time"	 ,checkForNull(rs.getString("rel_start_date_time")));
				tempHashO.put("reqd_or_opt_ind"		 ,checkForNull(rs.getString("reqd_or_opt_ind")));
				tempHashO.put("valid"				,"Y");
				tempHashO.put("associate_yn"		,"Y");
				tempHashO.put("status"				,"Y");
				
				if(isSiteSpecificYN() && "PH".equals(l_order_category))
				{
					tempHashO.put("dosage_type"		 ,checkForNull(rs.getString("dosage_type"),""));
					tempHashO.put("strength_uom"		 ,checkForNull(rs.getString("strength_uom"),""));
					tempHashO.put("strength_value"		 ,checkForNull(rs.getString("strength_value"),""));
				}
				
				componentStr.putObject(tempHash);
				componentStr.putObjectOriginal(tempHashO);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				closeResultSet( rs );
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception e)
			{
				e.printStackTrace() ;
			}
		}
	}
	//IN062992, ends
	

	
	//IN065713, start
	public void setAgeGrpWiseAdditionalHashValues(Hashtable hash) throws Exception
	{		
		String index_value	= (String)hash.get("INDEX_VALUES");
		String value_str	= (String)hash.get("VALUE_STR");
		String order_set_seq_num 	= (String)hash.get("ORDER_SET_SEQ_NUM");
		String qty_value 	= (String)hash.get("QTY_VALUE");
		String qty_uom 	= (String)hash.get("QTY_UOM");
		String route_code 	= (String)hash.get("ROUTE_CODE");
		String freq_code 	= (String)hash.get("FREQ_CODE");
		String durn_value 	= (String)hash.get("DURN_VALUE");
		String durn_type 	= (String)hash.get("DURN_TYPE");
		String rel_start_date_time 	= (String)hash.get("REL_START_DATE_TIME");
		String reqd_or_opt_ind 	= (String)hash.get("REQD_OR_OPT_IND");
		String prompt_msg 	= (String)hash.get("PROMPT_MSG");
		String catalog_code	= (String)hash.get("CATALOG_CODE");
		String order_type_code	= (String)hash.get("ORDER_TYPE_CODE");
		String count	= (String)hash.get("COUNT");
		String l_age_grp_code	= (String)hash.get("AGE_GRP_CODE");
		String occ_no = (String)hash.get("OCC_NO");//IN68241
		String l_order_category = (String)getCareSetHeaderStr().get("order_category");//IN68241

		String update_value	="";
		String index	="";

		int total_records = Integer.parseInt(count);		

		StringTokenizer indexstoken = new StringTokenizer(index_value,"~");
		StringTokenizer stoken = new StringTokenizer(value_str,"~");
		StringTokenizer stoken1 = new StringTokenizer(order_set_seq_num,"~");
		StringTokenizer qty_values = new StringTokenizer(qty_value,"~");
		StringTokenizer order_type_codes = new StringTokenizer(order_type_code,"~");
		StringTokenizer qty_uoms = new StringTokenizer(qty_uom,"~");
		StringTokenizer route_codes = new StringTokenizer(route_code,"~");
		StringTokenizer freq_codes = new StringTokenizer(freq_code,"~");
		StringTokenizer durn_values = new StringTokenizer(durn_value,"~");
		StringTokenizer durn_types = new StringTokenizer(durn_type,"~");
		StringTokenizer rel_start_date_times = new StringTokenizer(rel_start_date_time,"~");
		StringTokenizer reqd_or_opt_inds = new StringTokenizer(reqd_or_opt_ind,"~");
		StringTokenizer prompt_msgs = new StringTokenizer(java.net.URLDecoder.decode(prompt_msg,"UTF-8"),"~");
		StringTokenizer occ_nos = new StringTokenizer(occ_no,"~");//IN68241

		HashMap hashindex = new HashMap();
	
		HashMap hashmap = new HashMap();
		try
		{
			for(int j=1; j<=total_records; j++)
			{
				index = indexstoken.hasMoreTokens()?indexstoken.nextToken():"";
				update_value = stoken.hasMoreTokens()?stoken.nextToken():"";
				update_value = stoken.hasMoreTokens()?stoken.nextToken():"";
				
				order_set_seq_num = stoken1.hasMoreTokens()?(stoken1.nextToken()).trim():"";
				if("@#".equals(order_set_seq_num)) order_set_seq_num		=	 "";
				
				qty_value = qty_values.hasMoreTokens()?(qty_values.nextToken()).trim():"";
				if("@#".equals(qty_value)) qty_value		=	 "";
				
				order_type_code = order_type_codes.hasMoreTokens()?"":order_type_codes.nextToken().trim();

				qty_uom = qty_uoms.hasMoreTokens()?(qty_uoms.nextToken()).trim():"";
				if("@#".equals(qty_uom)) qty_uom		=	 "";
				
				route_code = route_codes.hasMoreTokens()?(route_codes.nextToken()).trim():"";
				if("@#".equals(route_code)) route_code		=	 "";
				
				freq_code = freq_codes.hasMoreTokens()?(freq_codes.nextToken()).trim():"";
				if("@#".equals(freq_code)) freq_code		=	 "";
				
				durn_value = durn_values.hasMoreTokens()?(durn_values.nextToken()).trim():"";
				if("@#".equals(durn_value)) durn_value		=	 "";
				
				durn_type = durn_types.hasMoreTokens()?(durn_types.nextToken()).trim():"";
				if("@#".equals(durn_type)) durn_type		=	 "";
				
				rel_start_date_time = rel_start_date_times.hasMoreTokens()?(rel_start_date_times.nextToken()).trim():"";
				if("@#".equals(rel_start_date_time)) rel_start_date_time		=	 "";
				
				reqd_or_opt_ind = reqd_or_opt_inds.hasMoreTokens()?(reqd_or_opt_inds.nextToken()).trim():"";
				if("@#".equals(reqd_or_opt_ind)) reqd_or_opt_ind		=	 "";
				
				prompt_msg = prompt_msgs.hasMoreTokens()?(prompt_msgs.nextToken()).trim():"";
				if("@#".equals(prompt_msg)) prompt_msg		=	 "";
				
				//IN68241, starts
				occ_no = occ_nos.hasMoreTokens()?(occ_nos.nextToken()).trim():"";
				if("@#".equals(occ_no)) occ_no		=	 "";
				//IN68241, ends	
			
				hashmap = new HashMap();
			
				hashmap.put("associate_yn" , "Y");
				hashmap.put("order_set_seq_num" , order_set_seq_num);
				hashmap.put("order_type_code" , order_type_code);
				hashmap.put("qty_unit" , qty_value);
				hashmap.put("qty_value" , qty_value);
				hashmap.put("qty_uom" , qty_uom);
				hashmap.put("route_code" , route_code);
				hashmap.put("freq_code" , freq_code);
				hashmap.put("durn_value" , durn_value);
				hashmap.put("durn_type" , durn_type);
				hashmap.put("rel_start_date_time" , rel_start_date_time);
				hashmap.put("reqd_or_opt_ind" , reqd_or_opt_ind);
				hashmap.put("prompt_msg", prompt_msg);
				hashmap.put("item_narration", "");
				hashmap.put("occ_no", occ_no);//IN68241
				hashmap.put("status" , "y");
				hashmap.put("valid" , "N");
				hashmap.put("update_value" , update_value);
				hashmap.put("index" , index);

				//IN68241, starts
				//hashindex.put(index,hashmap);
				if(isSiteSpecificYN() && "PH".equals(l_order_category) && "C".equals(getApplicableTo()))
					hashindex.put(occ_no,hashmap);
				else
					hashindex.put(index,hashmap);
				//IN68241, ends
			}
			
			hashAdditionalCatalogAgeWise.put(catalog_code+"_"+l_age_grp_code , hashindex);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}		
	}

	public HashMap getDBAgeWiseAdditionalCatalogs()
	{
		return hashAdditionalCatalogAgeWise;
	}

	public void ageWiseDBAdditionalCatalogs(String order_set_code) throws Exception
	{
		Connection connection			= null ;
		PreparedStatement pstmt			= null ;
		ResultSet rs					= null;
		String sql						= " SELECT   ORDER_SET_CODE, ORDER_SET_SEQ_NUM, ORDER_CATALOG_CODE,QTY_VALUE,QTY_UOM, AGE_GROUP, FREQ_CODE, DURN_VALUE, DURN_TYPE, REL_START_DATE_TIME,ROUTE_CODE,(SELECT ROUTE_DESC FROM PH_ROUTE WHERE ROUTE_CODE = A.ROUTE_CODE)ROUTE_DESC, ITEM_NARRATION,OCURRANCE_NUM FROM OR_ORDER_SET_COMP_BY_AGE_GRP A WHERE ORDER_SET_CODE = ? and OCURRANCE_NUM > 1 ORDER BY ORDER_CATALOG_CODE,AGE_GROUP ";
		HashMap hashmap					= new HashMap();
		HashMap hashindex				= null;

		String order_set_seq_num		= "";
		String qty_value					= "";
		String qty_uom					= "";
		String route_code				= "";
		String freq_code				= "";
		String durn_value				= "";
		String durn_type				= "";
		String rel_start_date_time		= "";
		String update_value				= "";
		String order_catalog_code		= "";
		String temp_order_catalog_code  = "";
		String temp_age_grp_code  = "";
		String prompt_msg				= "";
		String age_group				= "";
		String route_desc = "";
		String index = "";

		if(order_set_code==null)
			order_set_code				= "";		

		try
		{
			connection					= getConnection();
			pstmt						= connection.prepareStatement(sql);
			pstmt.setString(1 , order_set_code);
			rs							= pstmt.executeQuery();

			while(rs!=null && rs.next())
			{			
				order_catalog_code		= rs.getString("order_catalog_code")==null?"":rs.getString("order_catalog_code");
				order_set_seq_num		= rs.getString("order_set_seq_num")==null?"":rs.getString("order_set_seq_num");
				age_group				= rs.getString("age_group")==null?"":rs.getString("age_group");				
				qty_value				= rs.getString("qty_value")==null?"":rs.getString("qty_value");
				qty_uom				    = rs.getString("qty_uom")==null?"":rs.getString("qty_uom");				
				freq_code				= rs.getString("freq_code")==null?"":rs.getString("freq_code");
				durn_value				= rs.getString("durn_value")==null?"":rs.getString("durn_value");
				durn_type				= rs.getString("durn_type")==null?"":rs.getString("durn_type");
				rel_start_date_time		= rs.getString("rel_start_date_time")==null?"":rs.getString("rel_start_date_time");
				route_code				= rs.getString("route_code")==null?"":rs.getString("route_code");
				prompt_msg				= rs.getString("item_narration")==null?"":rs.getString("item_narration");			
				route_desc				= rs.getString("route_desc")==null?"":rs.getString("route_desc");
				index 			= rs.getString("OCURRANCE_NUM")==null?"":rs.getString("OCURRANCE_NUM"); 
				
				if(!(temp_order_catalog_code+"_"+temp_age_grp_code).equalsIgnoreCase(order_catalog_code+"_"+age_group))
				{
					if(hashindex!=null)
					{
						if(hashindex.size()>0)
						{
							hashAdditionalCatalogAgeWise.put(temp_order_catalog_code+"_"+temp_age_grp_code , hashindex);
						}
					}

					hashindex = new HashMap ();					
					temp_order_catalog_code = order_catalog_code;
					temp_age_grp_code = age_group;
				}
				
				hashmap = new HashMap();
				hashmap.put("associate_yn" , "Y");
				hashmap.put("order_catalog_code" , order_catalog_code);
				hashmap.put("order_set_seq_num" , order_set_seq_num);
				hashmap.put("age_group_code" , age_group);
				hashmap.put("qty_unit" , qty_value);
				hashmap.put("qty_value" , qty_value);
				hashmap.put("qty_uom" , qty_uom);
				hashmap.put("freq_code" , freq_code);
				hashmap.put("durn_value" , durn_value);
				hashmap.put("durn_type" , durn_type);
				hashmap.put("rel_start_date_time" , rel_start_date_time);
				hashmap.put("route_code" , route_code);
				hashmap.put("prompt_msg", prompt_msg);
				hashmap.put("item_narration", "");
				hashmap.put("occ_no", index);//IN68241
				hashmap.put("status" , "y");
				hashmap.put("valid" , "N");
				hashmap.put("update_value" , update_value);	
				hashmap.put("route_desc" , route_desc);
				hashmap.put("index" , index);
				hashindex.put(index,hashmap);
			}

			if(hashindex!=null)
			{
				if(hashindex.size()>0)
				{
					hashAdditionalCatalogAgeWise.put(temp_order_catalog_code+"_"+temp_age_grp_code, hashindex);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				closeResultSet(rs);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}		
	}
	
	public void clearAdditionalCatalogs(String catalog_code)
	{
		if(hashCatalog.containsKey(catalog_code))
			hashCatalog.remove(catalog_code);
	}
	//IN065713, ends
	
	//IN68241, starts
	public void populateCatalogByDosageType(String order_set_code)
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HashMap<String, String> colValues = new HashMap<String, String>();
		HashMap<String, HashMap<String, String>> records = new HashMap<String, HashMap<String, String>>();
		String l_dosage_type = "";
		String l_catalog_code = "";
		
		try
		{
			connection = getConnection();
			String sql = "SELECT A.DOSAGE_TYPE DOSAGE_TYPE,A.OCURRANCE_NUM OCURRANCE_NUM,A.QTY_VALUE QTY_VALUE,A.QTY_UOM QTY_UOM, A.FREQ_CODE FREQ_CODE,A.DURN_VALUE DURN_VALUE,A.DURN_TYPE DURN_TYPE,A.REL_START_DATE_TIME REL_START_DATE_TIME,A.ROUTE_CODE ROUTE_CODE,A.ITEM_NARRATION ITEM_NARRATION,A.ORDER_CATALOG_CODE ORDER_CATALOG_CODE,(SELECT ROUTE_DESC FROM PH_ROUTE WHERE ROUTE_CODE = A.ROUTE_CODE)ROUTE_DESC,ORDER_SET_SEQ_NUM,DOSAGE_TYPE_SEQ_NO FROM OR_ORDER_SET_COMP_BY_DSG_TYPE A WHERE A.ORDER_SET_CODE = ? AND A.OCURRANCE_NUM = '1' order by A.DOSAGE_TYPE_SEQ_NO";
			pstmt	   = connection.prepareStatement(sql);
			
			pstmt.setString(1, order_set_code);
			//pstmt.setString(2, catalog_code);
			rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				colValues = new HashMap();
				l_dosage_type = rs.getString("DOSAGE_TYPE")==null?"":rs.getString("DOSAGE_TYPE");
				//colValues.put("occ_no",rs.getString("OCURRANCE_NUM")==null?"":rs.getString("OCURRANCE_NUM"));
				colValues.put("dosage_type",l_dosage_type);
				colValues.put("qty_value",rs.getString("QTY_VALUE")==null?"":rs.getString("QTY_VALUE"));
				colValues.put("qty_uom",rs.getString("QTY_UOM")==null?"":rs.getString("QTY_UOM"));
				colValues.put("freq_code",rs.getString("FREQ_CODE")==null?"":rs.getString("FREQ_CODE"));
				colValues.put("durn_value",rs.getString("DURN_VALUE")==null?"":rs.getString("DURN_VALUE"));
				colValues.put("durn_type",rs.getString("DURN_TYPE")==null?"":rs.getString("DURN_TYPE"));
				colValues.put("rel_start_date_time",rs.getString("REL_START_DATE_TIME")==null?"":rs.getString("REL_START_DATE_TIME"));
				colValues.put("route_code",rs.getString("ROUTE_CODE")==null?"":rs.getString("ROUTE_CODE"));
				colValues.put("prompt_msg",rs.getString("ITEM_NARRATION")==null?"":rs.getString("ITEM_NARRATION"));
				colValues.put("include","Y");
				colValues.put("route_desc",rs.getString("ROUTE_DESC")==null?"":rs.getString("ROUTE_DESC"));
				colValues.put("order_set_seq_num",rs.getString("ORDER_SET_SEQ_NUM")==null?"":rs.getString("ORDER_SET_SEQ_NUM"));
				colValues.put("dosage_type_seq_no",rs.getString("DOSAGE_TYPE_SEQ_NO")==null?"":rs.getString("DOSAGE_TYPE_SEQ_NO"));
				colValues.put("valid","y");
				l_catalog_code = rs.getString("ORDER_CATALOG_CODE")==null?"":rs.getString("ORDER_CATALOG_CODE");
				colValues.put("order_catalog_code",l_catalog_code);
				
				HashMap temp = new HashMap();
				
				if(hashCatalogDosageTypeWise.containsKey(l_catalog_code))
				{
					temp = (HashMap)hashCatalogDosageTypeWise.get(l_catalog_code);
					temp.put(l_dosage_type, colValues);
				}
				else
				{
					temp.put(l_dosage_type, colValues);					
				}
				
				hashCatalogDosageTypeWise.put(l_catalog_code, temp);	
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}	
	}
	
	public HashMap<String, String> emptyDosageTypeRecord()
	{
		HashMap<String, String> colValues = new HashMap<String, String>();
		colValues.put("OCCURRANCE_NO","");
		colValues.put("DOSAGE_TYPE","");
		colValues.put("QTY","");
		colValues.put("FREQ_CODE","");
		colValues.put("DURN_VALUE","");
		colValues.put("DURN_TYPE","");
		colValues.put("TIME_FRAME","");
		colValues.put("ROUTE_CODE","");
		colValues.put("COMMENTS","");
		colValues.put("INCLUDE","N");
		return colValues;
	}
	
	public String decode(String code)
	{
	  if(code.equalsIgnoreCase("H")) return "Hour(s)";
	  if(code.equalsIgnoreCase("D")) return "Day(s)";
	  if(code.equalsIgnoreCase("W")) return "Week(s)";
	  if(code.equalsIgnoreCase("L")) return "Month(s)";
  	  if(code.equalsIgnoreCase("M")) return "Minute(s)";
  	  if(code.equalsIgnoreCase("Y")) return "Year(s)";
	  return "";
	}

	public String decodeForAgeGrp(String code)
	{
		if(code.equalsIgnoreCase("D")) return "Day";
		if(code.equalsIgnoreCase("H")) return "Hours";
		if(code.equalsIgnoreCase("N")) return "Minute";
		if(code.equalsIgnoreCase("M")) return "Month";
		if(code.equalsIgnoreCase("Y")) return "Year";  	  
		return "";
	}
	
	public void setDosageTypeHashValues(Hashtable hash) throws Exception
	{		
		String index_value	= (String)hash.get("INDEX_VALUES");
		String value_str	= (String)hash.get("VALUE_STR");
		String order_set_seq_num 	= (String)hash.get("ORDER_SET_SEQ_NUM");
		String qty_value 	= (String)hash.get("QTY_UNIT_STR");
		String qty_uom 	= (String)hash.get("QTY_UOM");
		String route_code 	= (String)hash.get("ROUTE_CODE");
		String freq_code 	= (String)hash.get("FREQ_CODE");
		String durn_value 	= (String)hash.get("DURN_VALUE");
		String durn_type 	= (String)hash.get("DURN_TYPE");
		String rel_start_date_time 	= (String)hash.get("REL_START_DATE_TIME");
		String reqd_or_opt_ind 	= (String)hash.get("REQD_OR_OPT_IND");
		String prompt_msg 	= (String)hash.get("PROMPT_MSG");
		String catalog_code	= (String)hash.get("CATALOG_CODE");
		String order_type_code	= (String)hash.get("ORDER_TYPE_CODE");
		String count	= (String)hash.get("COUNT");
		String l_age_grp_code	= (String)hash.get("AGE_GRP_CODE");
		String dosage_type 	= (String)hash.get("DOSAGE_TYPE");
		String dosage_type_seq_no 	= (String)hash.get("DOSAGE_TYPE_SEQ_NO");
		String route_desc = (String)hash.get("ROUTE_DESC");

		String update_value	="";
		String index	="";

		int total_records = Integer.parseInt(count);
		
		hashCatalogDosageTypeWise.put(catalog_code,null);

		StringTokenizer indexstoken = new StringTokenizer(index_value,"~");
		StringTokenizer stoken = new StringTokenizer(value_str,"~");
		StringTokenizer stoken1 = new StringTokenizer(order_set_seq_num,"~");
		StringTokenizer qty_values = new StringTokenizer(qty_value,"~");
		//StringTokenizer order_type_codes = new StringTokenizer(order_type_code,"~");
		StringTokenizer qty_uoms = new StringTokenizer(qty_uom,"~");
		StringTokenizer route_codes = new StringTokenizer(route_code,"~");
		StringTokenizer route_descs = new StringTokenizer(route_desc,"~");
		StringTokenizer freq_codes = new StringTokenizer(freq_code,"~");
		StringTokenizer durn_values = new StringTokenizer(durn_value,"~");
		StringTokenizer durn_types = new StringTokenizer(durn_type,"~");
		StringTokenizer rel_start_date_times = new StringTokenizer(rel_start_date_time,"~");
		//StringTokenizer reqd_or_opt_inds = new StringTokenizer(reqd_or_opt_ind,"~");
		StringTokenizer prompt_msgs = new StringTokenizer(java.net.URLDecoder.decode(prompt_msg,"UTF-8"),"~");
		StringTokenizer dosage_types = new StringTokenizer(java.net.URLDecoder.decode(dosage_type,"UTF-8"),"~");
		StringTokenizer dosage_type_seq_nos = new StringTokenizer(java.net.URLDecoder.decode(dosage_type_seq_no,"UTF-8"),"~");

		HashMap hashindex = new HashMap();
	
		HashMap hashmap = new HashMap();
		
		//if(total_records>0)
		clearAdditionalCatalogs(catalog_code);
		
		try
		{
			for(int j=0; j<total_records; j++)
			{
				index = indexstoken.hasMoreTokens()?indexstoken.nextToken():"";
				update_value = stoken.hasMoreTokens()?stoken.nextToken():"";
				update_value = stoken.hasMoreTokens()?stoken.nextToken():"";
				
				order_set_seq_num = stoken1.hasMoreTokens()?(stoken1.nextToken()).trim():"";
				if("@#".equals(order_set_seq_num)) order_set_seq_num		=	 "";
				
				qty_value = qty_values.hasMoreTokens()?(qty_values.nextToken()).trim():"";
				if("@#".equals(qty_value)) qty_value		=	 "";
				
				//order_type_code = order_type_codes.hasMoreTokens()?"":order_type_codes.nextToken().trim();

				qty_uom = qty_uoms.hasMoreTokens()?(qty_uoms.nextToken()).trim():"";
				if("@#".equals(qty_uom)) qty_uom		=	 "";
				
				route_code = route_codes.hasMoreTokens()?(route_codes.nextToken()).trim():"";
				if("@#".equals(route_code)) route_code		=	 "";
				
				route_desc = route_descs.hasMoreTokens()?(route_descs.nextToken()).trim():"";
				if("@#".equals(route_desc)) route_desc		=	 "";
				
				freq_code = freq_codes.hasMoreTokens()?(freq_codes.nextToken()).trim():"";
				if("@#".equals(freq_code)) freq_code		=	 "";
				
				durn_value = durn_values.hasMoreTokens()?(durn_values.nextToken()).trim():"";
				if("@#".equals(durn_value)) durn_value		=	 "";
				
				durn_type = durn_types.hasMoreTokens()?(durn_types.nextToken()).trim():"";
				if("@#".equals(durn_type)) durn_type		=	 "";
				
				rel_start_date_time = rel_start_date_times.hasMoreTokens()?(rel_start_date_times.nextToken()).trim():"";
				if("@#".equals(rel_start_date_time)) rel_start_date_time		=	 "";
				
				//reqd_or_opt_ind = reqd_or_opt_inds.hasMoreTokens()?(reqd_or_opt_inds.nextToken()).trim():"";
				//if("@#".equals(reqd_or_opt_ind)) reqd_or_opt_ind		=	 "";
				
				prompt_msg = prompt_msgs.hasMoreTokens()?(prompt_msgs.nextToken()).trim():"";
				if("@#".equals(prompt_msg)) prompt_msg		=	 "";					
				
				dosage_type = dosage_types.hasMoreTokens()?(dosage_types.nextToken()).trim():"";
				if("@#".equals(dosage_type)) dosage_type		=	 "";
				
				dosage_type_seq_no = dosage_type_seq_nos.hasMoreTokens()?(dosage_type_seq_nos.nextToken()).trim():"";
				if("@#".equals(dosage_type_seq_no)) dosage_type_seq_no		=	 "";
			
				hashmap = new HashMap();
			
				hashmap.put("associate_yn" , "Y");
				hashmap.put("order_set_seq_num" , order_set_seq_num);
				//hashmap.put("order_type_code" , order_type_code);
				hashmap.put("order_catalog_code" , catalog_code);
				hashmap.put("qty_unit" , qty_value);
				hashmap.put("qty_value" , qty_value);
				hashmap.put("qty_uom" , qty_uom);
				hashmap.put("route_code" , route_code);
				hashmap.put("freq_code" , freq_code);
				hashmap.put("durn_value" , durn_value);
				hashmap.put("durn_type" , durn_type);
				hashmap.put("rel_start_date_time" , rel_start_date_time);
				//hashmap.put("reqd_or_opt_ind" , reqd_or_opt_ind);
				hashmap.put("prompt_msg", prompt_msg);
				hashmap.put("item_narration", "");
				hashmap.put("dosage_type_seq_no", dosage_type_seq_no);
				hashmap.put("status" , "y");
				hashmap.put("valid" , "N");
				hashmap.put("update_value" , update_value);
				hashmap.put("index" , index);
				hashmap.put("route_desc" , route_desc);	
				hashmap.put("dosage_type" , dosage_type);

				hashindex.put(dosage_type,hashmap);				
			}
			hashCatalogDosageTypeWise.put(catalog_code, hashindex);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public HashMap getDosageTypeHashValues()
	{
		return hashCatalogDosageTypeWise;
	}
	
	public void setDosageTypeAdditionalKgHashValues(Hashtable hash) throws Exception
	{		
		String index_value	= (String)hash.get("INDEX_VALUES");
		String value_str	= (String)hash.get("VALUE_STR");
		String order_set_seq_num 	= (String)hash.get("ORDER_SET_SEQ_NUM");
		String qty_value 	= (String)hash.get("QTY_UNIT_STR");
		String qty_uom 	= (String)hash.get("QTY_UOM");
		String route_code 	= (String)hash.get("ROUTE_CODE");
		String freq_code 	= (String)hash.get("FREQ_CODE");
		String durn_value 	= (String)hash.get("DURN_VALUE");
		String durn_type 	= (String)hash.get("DURN_TYPE");
		String rel_start_date_time 	= (String)hash.get("REL_START_DATE_TIME");
		String reqd_or_opt_ind 	= (String)hash.get("REQD_OR_OPT_IND");
		String prompt_msg 	= (String)hash.get("PROMPT_MSG");
		String catalog_code	= (String)hash.get("CATALOG_CODE");
		String order_type_code	= (String)hash.get("ORDER_TYPE_CODE");
		String count	= (String)hash.get("COUNT");
		String l_age_grp_code	= (String)hash.get("AGE_GRP_CODE");
		String dosage_type 	= (String)hash.get("DOSAGE_TYPE");
		String occ_no 	= (String)hash.get("OCC_NO");
		String route_desc = (String)hash.get("ROUTE_DESC");
		String l_order_category = (String)getCareSetHeaderStr().get("order_category");//IN062992

		String update_value	="";
		String index	="";

		int total_records = Integer.parseInt(count);
		hashAdditionalCatalogDosageTypeKgWise.put(catalog_code , null);

		StringTokenizer indexstoken = new StringTokenizer(index_value,"~");
		StringTokenizer stoken = new StringTokenizer(value_str,"~");
		StringTokenizer stoken1 = new StringTokenizer(order_set_seq_num,"~");
		StringTokenizer qty_values = new StringTokenizer(qty_value,"~");
		//StringTokenizer order_type_codes = new StringTokenizer(order_type_code,"~");
		StringTokenizer qty_uoms = new StringTokenizer(qty_uom,"~");
		StringTokenizer route_codes = new StringTokenizer(route_code,"~");
		StringTokenizer route_descs = new StringTokenizer(route_desc,"~");
		StringTokenizer freq_codes = new StringTokenizer(freq_code,"~");
		StringTokenizer durn_values = new StringTokenizer(durn_value,"~");
		StringTokenizer durn_types = new StringTokenizer(durn_type,"~");
		StringTokenizer rel_start_date_times = new StringTokenizer(rel_start_date_time,"~");
		//StringTokenizer reqd_or_opt_inds = new StringTokenizer(reqd_or_opt_ind,"~");
		StringTokenizer prompt_msgs = new StringTokenizer(java.net.URLDecoder.decode(prompt_msg,"UTF-8"),"~");
		StringTokenizer dosage_types = new StringTokenizer(java.net.URLDecoder.decode(dosage_type,"UTF-8"),"~");
		StringTokenizer occ_nos = new StringTokenizer(java.net.URLDecoder.decode(occ_no,"UTF-8"),"~");		

		HashMap hashindex = new HashMap();
	
		HashMap hashmap = new HashMap();
		try
		{
			for(int j=0; j<total_records; j++)
			{
				index = indexstoken.hasMoreTokens()?indexstoken.nextToken():"";
				update_value = stoken.hasMoreTokens()?stoken.nextToken():"";
				update_value = stoken.hasMoreTokens()?stoken.nextToken():"";
				
				order_set_seq_num = stoken1.hasMoreTokens()?(stoken1.nextToken()).trim():"";
				if("@#".equals(order_set_seq_num)) order_set_seq_num		=	 "";
				
				qty_value = qty_values.hasMoreTokens()?(qty_values.nextToken()).trim():"";
				if("@#".equals(qty_value)) qty_value		=	 "";			
				
				//order_type_code = order_type_codes.hasMoreTokens()?"":order_type_codes.nextToken().trim();

				qty_uom = qty_uoms.hasMoreTokens()?(qty_uoms.nextToken()).trim():"";
				if("@#".equals(qty_uom)) qty_uom		=	 "";
				
				route_code = route_codes.hasMoreTokens()?(route_codes.nextToken()).trim():"";
				if("@#".equals(route_code)) route_code		=	 "";
				
				route_desc = route_descs.hasMoreTokens()?(route_descs.nextToken()).trim():"";
				if("@#".equals(route_desc)) route_desc		=	 "";
				
				freq_code = freq_codes.hasMoreTokens()?(freq_codes.nextToken()).trim():"";
				if("@#".equals(freq_code)) freq_code		=	 "";
				
				durn_value = durn_values.hasMoreTokens()?(durn_values.nextToken()).trim():"";
				if("@#".equals(durn_value)) durn_value		=	 "";
				
				durn_type = durn_types.hasMoreTokens()?(durn_types.nextToken()).trim():"";
				if("@#".equals(durn_type)) durn_type		=	 "";
				
				rel_start_date_time = rel_start_date_times.hasMoreTokens()?(rel_start_date_times.nextToken()).trim():"";
				if("@#".equals(rel_start_date_time)) rel_start_date_time		=	 "";
				
				//reqd_or_opt_ind = reqd_or_opt_inds.hasMoreTokens()?(reqd_or_opt_inds.nextToken()).trim():"";
				//if("@#".equals(reqd_or_opt_ind)) reqd_or_opt_ind		=	 "";
				
				prompt_msg = prompt_msgs.hasMoreTokens()?(prompt_msgs.nextToken()).trim():"";
				if("@#".equals(prompt_msg)) prompt_msg		=	 "";					
				
				dosage_type = dosage_types.hasMoreTokens()?(dosage_types.nextToken()).trim():"";
				if("@#".equals(dosage_type)) dosage_type		=	 "";
				
				occ_no = occ_nos.hasMoreTokens()?(occ_nos.nextToken()).trim():"";
				if("@#".equals(occ_no)) occ_no		=	 "";
			
				hashmap = new HashMap();
			
				hashmap.put("associate_yn" , "Y");
				hashmap.put("order_set_seq_num" , order_set_seq_num);
				//hashmap.put("order_type_code" , order_type_code);
				hashmap.put("order_type_code" , order_type_code);
				hashmap.put("qty_unit" , qty_value);
				hashmap.put("qty_value" , qty_value);
				hashmap.put("qty_uom" , qty_uom);
				hashmap.put("route_code" , route_code);
				hashmap.put("freq_code" , freq_code);
				hashmap.put("durn_value" , durn_value);
				hashmap.put("durn_type" , durn_type);
				hashmap.put("rel_start_date_time" , rel_start_date_time);
				//hashmap.put("reqd_or_opt_ind" , reqd_or_opt_ind);
				hashmap.put("prompt_msg", prompt_msg);
				hashmap.put("item_narration", "");
				hashmap.put("occ_no", occ_no);
				hashmap.put("status" , "y");
				hashmap.put("valid" , "N");
				hashmap.put("update_value" , update_value);
				hashmap.put("index" , index);
				hashmap.put("route_desc" , route_desc);
				hashmap.put("catalog_code" , catalog_code);
				hashmap.put("dosage_type" , dosage_type);
				//hashindex.put(index,hashmap);
				if(isSiteSpecificYN() && "PH".equals(l_order_category) && "C".equals(getApplicableTo()))
					hashindex.put(occ_no,hashmap);				
				else
					hashindex.put(index,hashmap);
			}
			
			hashAdditionalCatalogDosageTypeKgWise.put(catalog_code , hashindex);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}	
	
	public HashMap getDosageTypeAdditionalKgHashValues() throws Exception
	{
		return hashAdditionalCatalogDosageTypeKgWise; 
	}
	
	public void setDosageTypeAdditionalM2HashValues(Hashtable hash) throws Exception
	{		
		String index_value	= (String)hash.get("INDEX_VALUES");
		String value_str	= (String)hash.get("VALUE_STR");
		String order_set_seq_num 	= (String)hash.get("ORDER_SET_SEQ_NUM");
		String qty_value 	= (String)hash.get("QTY_UNIT_STR");
		String qty_uom 	= (String)hash.get("QTY_UOM");
		String route_code 	= (String)hash.get("ROUTE_CODE");
		String freq_code 	= (String)hash.get("FREQ_CODE");
		String durn_value 	= (String)hash.get("DURN_VALUE");
		String durn_type 	= (String)hash.get("DURN_TYPE");
		String rel_start_date_time 	= (String)hash.get("REL_START_DATE_TIME");
		String reqd_or_opt_ind 	= (String)hash.get("REQD_OR_OPT_IND");
		String prompt_msg 	= (String)hash.get("PROMPT_MSG");
		String catalog_code	= (String)hash.get("CATALOG_CODE");
		String order_type_code	= (String)hash.get("ORDER_TYPE_CODE");
		String count	= (String)hash.get("COUNT");
		String l_age_grp_code	= (String)hash.get("AGE_GRP_CODE");
		String dosage_type 	= (String)hash.get("DOSAGE_TYPE");
		String occ_no 	= (String)hash.get("OCC_NO");
		String route_desc = (String)hash.get("ROUTE_DESC");
		String l_order_category = (String)getCareSetHeaderStr().get("order_category");//IN062992

		String update_value	="";
		String index	="";

		int total_records = Integer.parseInt(count);
		hashAdditionalCatalogDosageTypeM2Wise.put(catalog_code , null);

		StringTokenizer indexstoken = new StringTokenizer(index_value,"~");
		StringTokenizer stoken = new StringTokenizer(value_str,"~");
		StringTokenizer stoken1 = new StringTokenizer(order_set_seq_num,"~");
		StringTokenizer qty_values = new StringTokenizer(qty_value,"~");
		//StringTokenizer order_type_codes = new StringTokenizer(order_type_code,"~");
		StringTokenizer qty_uoms = new StringTokenizer(qty_uom,"~");
		StringTokenizer route_codes = new StringTokenizer(route_code,"~");
		StringTokenizer route_descs = new StringTokenizer(route_desc,"~");
		StringTokenizer freq_codes = new StringTokenizer(freq_code,"~");
		StringTokenizer durn_values = new StringTokenizer(durn_value,"~");
		StringTokenizer durn_types = new StringTokenizer(durn_type,"~");
		StringTokenizer rel_start_date_times = new StringTokenizer(rel_start_date_time,"~");
		//StringTokenizer reqd_or_opt_inds = new StringTokenizer(reqd_or_opt_ind,"~");
		StringTokenizer prompt_msgs = new StringTokenizer(java.net.URLDecoder.decode(prompt_msg,"UTF-8"),"~");
		StringTokenizer dosage_types = new StringTokenizer(java.net.URLDecoder.decode(dosage_type,"UTF-8"),"~");
		StringTokenizer occ_nos = new StringTokenizer(java.net.URLDecoder.decode(occ_no,"UTF-8"),"~");

		HashMap hashindex = new HashMap();
	
		HashMap hashmap = new HashMap();
		try
		{
			for(int j=0; j<total_records; j++)
			{
				index = indexstoken.hasMoreTokens()?indexstoken.nextToken():"";
				update_value = stoken.hasMoreTokens()?stoken.nextToken():"";
				update_value = stoken.hasMoreTokens()?stoken.nextToken():"";
				
				order_set_seq_num = stoken1.hasMoreTokens()?(stoken1.nextToken()).trim():"";
				if("@#".equals(order_set_seq_num)) order_set_seq_num		=	 "";
				
				qty_value = qty_values.hasMoreTokens()?(qty_values.nextToken()).trim():"";
				if("@#".equals(qty_value)) qty_value		=	 "";
				
				//order_type_code = order_type_codes.hasMoreTokens()?"":order_type_codes.nextToken().trim();

				qty_uom = qty_uoms.hasMoreTokens()?(qty_uoms.nextToken()).trim():"";
				if("@#".equals(qty_uom)) qty_uom		=	 "";
				
				route_code = route_codes.hasMoreTokens()?(route_codes.nextToken()).trim():"";
				if("@#".equals(route_code)) route_code		=	 "";
				
				route_desc = route_descs.hasMoreTokens()?(route_descs.nextToken()).trim():"";
				if("@#".equals(route_desc)) route_desc		=	 "";
				
				freq_code = freq_codes.hasMoreTokens()?(freq_codes.nextToken()).trim():"";
				if("@#".equals(freq_code)) freq_code		=	 "";
				
				durn_value = durn_values.hasMoreTokens()?(durn_values.nextToken()).trim():"";
				if("@#".equals(durn_value)) durn_value		=	 "";
				
				durn_type = durn_types.hasMoreTokens()?(durn_types.nextToken()).trim():"";
				if("@#".equals(durn_type)) durn_type		=	 "";
				
				rel_start_date_time = rel_start_date_times.hasMoreTokens()?(rel_start_date_times.nextToken()).trim():"";
				if("@#".equals(rel_start_date_time)) rel_start_date_time		=	 "";
				
				//reqd_or_opt_ind = reqd_or_opt_inds.hasMoreTokens()?(reqd_or_opt_inds.nextToken()).trim():"";
				//if("@#".equals(reqd_or_opt_ind)) reqd_or_opt_ind		=	 "";
				
				prompt_msg = prompt_msgs.hasMoreTokens()?(prompt_msgs.nextToken()).trim():"";
				if("@#".equals(prompt_msg)) prompt_msg		=	 "";					
				
				dosage_type = dosage_types.hasMoreTokens()?(dosage_types.nextToken()).trim():"";
				if("@#".equals(dosage_type)) dosage_type		=	 "";
				
				occ_no = occ_nos.hasMoreTokens()?(occ_nos.nextToken()).trim():"";
				if("@#".equals(occ_no)) occ_no		=	 "";
			
				hashmap = new HashMap();
			
				hashmap.put("associate_yn" , "Y");
				hashmap.put("order_set_seq_num" , order_set_seq_num);
				//hashmap.put("order_type_code" , order_type_code);
				hashmap.put("qty_unit" , qty_value);
				hashmap.put("qty_value" , qty_value);
				hashmap.put("qty_uom" , qty_uom);
				hashmap.put("route_code" , route_code);
				hashmap.put("freq_code" , freq_code);
				hashmap.put("durn_value" , durn_value);
				hashmap.put("durn_type" , durn_type);
				hashmap.put("rel_start_date_time" , rel_start_date_time);
				//hashmap.put("reqd_or_opt_ind" , reqd_or_opt_ind);
				hashmap.put("prompt_msg", prompt_msg);
				hashmap.put("item_narration", "");
				hashmap.put("occ_no", occ_no);
				hashmap.put("status" , "y");
				hashmap.put("valid" , "N");
				hashmap.put("update_value" , update_value);
				hashmap.put("index" , index);
				hashmap.put("route_desc" , route_desc);
				hashmap.put("dosage_type" , dosage_type);
				//hashindex.put(index,hashmap);
				if(isSiteSpecificYN() && "PH".equals(l_order_category) && "C".equals(getApplicableTo()))
					hashindex.put(occ_no,hashmap);
				else
					hashindex.put(index,hashmap);
			}
			hashAdditionalCatalogDosageTypeM2Wise.put(catalog_code, hashindex);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}	
	
	public HashMap getDosageTypeAdditionalM2HashValues() throws Exception
	{
		return hashAdditionalCatalogDosageTypeM2Wise; 
	}	
	
	public void clearDosageTypeWiseAdditional(String catalog_code,String dosage_type)
	{
		if("K".equals(dosage_type))
			hashAdditionalCatalogDosageTypeKgWise.put(catalog_code,null);
		else if("M".equals(dosage_type))
			hashAdditionalCatalogDosageTypeM2Wise.put(catalog_code,null);
		else if("A".equals(dosage_type))
		{
			hashCatalogAgeWise.put(catalog_code , null);
			HashMap<String, String> manipulateMap = hashAdditionalCatalogAgeWise;

			for(Map.Entry<String, String> entry : manipulateMap.entrySet()) 
			{
				if((entry.getKey()).startsWith(catalog_code+"_"))
				{

					manipulateMap.remove(entry.getKey());
				}
			}

			hashAdditionalCatalogAgeWise = manipulateMap;

		}			
	}
	
	public void clearAdditionalCatalogsAgeGrpWise(String catalog_code, String age_grp_code)
	{
		if(hashAdditionalCatalogAgeWise.containsKey(catalog_code+"_"+age_grp_code))
			hashAdditionalCatalogAgeWise.remove(catalog_code+"_"+age_grp_code);
	}
	
	public void populateCatalogByDosageTypeAdditionalsM2(String order_set_code)
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HashMap<String, String> colValues = new HashMap<String, String>();
		HashMap<String, HashMap<String, String>> records = new HashMap<String, HashMap<String, String>>();
		String l_dosage_type = "";
		String l_catalog_code = "";
		String l_occ_no ="";
		HashMap temp = new HashMap();
		
		try
		{
			connection = getConnection();
			String sql = "SELECT A.DOSAGE_TYPE DOSAGE_TYPE,A.OCURRANCE_NUM OCURRANCE_NUM,A.QTY_VALUE QTY_VALUE,A.QTY_UOM QTY_UOM,A.FREQ_CODE FREQ_CODE,A.DURN_VALUE DURN_VALUE,A.DURN_TYPE DURN_TYPE,A.REL_START_DATE_TIME REL_START_DATE_TIME,A.ROUTE_CODE ROUTE_CODE,A.ITEM_NARRATION ITEM_NARRATION,A.ORDER_CATALOG_CODE ORDER_CATALOG_CODE,(SELECT ROUTE_DESC FROM PH_ROUTE WHERE ROUTE_CODE = A.ROUTE_CODE)ROUTE_DESC,ORDER_SET_SEQ_NUM,DOSAGE_TYPE_SEQ_NO FROM OR_ORDER_SET_COMP_BY_DSG_TYPE A WHERE A.ORDER_SET_CODE = ? AND A.DOSAGE_TYPE = 'M' AND A.OCURRANCE_NUM > 1 order by A.DOSAGE_TYPE_SEQ_NO";
			pstmt	   = connection.prepareStatement(sql);
			
			pstmt.setString(1, order_set_code);

			rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				colValues = new HashMap();
				l_dosage_type = rs.getString("DOSAGE_TYPE")==null?"":rs.getString("DOSAGE_TYPE");
				l_occ_no = rs.getString("OCURRANCE_NUM")==null?"":rs.getString("OCURRANCE_NUM");
				colValues.put("occ_no",l_occ_no);
				colValues.put("dosage_type",l_dosage_type);
				colValues.put("dosage_type_seq_no",rs.getString("DOSAGE_TYPE_SEQ_NO")==null?"":rs.getString("DOSAGE_TYPE_SEQ_NO"));				
				colValues.put("qty_value",rs.getString("QTY_VALUE")==null?"":rs.getString("QTY_VALUE"));
				colValues.put("freq_code",rs.getString("FREQ_CODE")==null?"":rs.getString("FREQ_CODE"));
				colValues.put("durn_value",rs.getString("DURN_VALUE")==null?"":rs.getString("DURN_VALUE"));
				colValues.put("durn_type",rs.getString("DURN_TYPE")==null?"":rs.getString("DURN_TYPE"));
				colValues.put("rel_start_date_time",rs.getString("REL_START_DATE_TIME")==null?"":rs.getString("REL_START_DATE_TIME"));
				colValues.put("route_code",rs.getString("ROUTE_CODE")==null?"":rs.getString("ROUTE_CODE"));
				colValues.put("prompt_msg",rs.getString("ITEM_NARRATION")==null?"":rs.getString("ITEM_NARRATION"));
				colValues.put("include","Y");
				colValues.put("route_desc",rs.getString("ROUTE_DESC")==null?"":rs.getString("ROUTE_DESC"));
				colValues.put("qty_uom",rs.getString("QTY_UOM")==null?"":rs.getString("QTY_UOM"));
				colValues.put("order_set_seq_num",rs.getString("ORDER_SET_SEQ_NUM")==null?"":rs.getString("ORDER_SET_SEQ_NUM"));
				l_catalog_code = rs.getString("ORDER_CATALOG_CODE")==null?"":rs.getString("ORDER_CATALOG_CODE");				
				
				if(hashAdditionalCatalogDosageTypeM2Wise.containsKey(l_catalog_code))
				{
					temp = new HashMap();
					temp.put(l_occ_no, colValues);					
					((HashMap)hashAdditionalCatalogDosageTypeM2Wise.get(l_catalog_code)).put(l_occ_no,colValues);
				}
				else
				{
					temp = new HashMap();
					temp.put(l_occ_no, colValues);
					hashAdditionalCatalogDosageTypeM2Wise.put(l_catalog_code,temp);					
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}	
	}
	
	public void populateCatalogByDosageTypeAdditionalsKg(String order_set_code)
	{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HashMap<String, String> colValues = new HashMap<String, String>();
		HashMap<String, HashMap<String, String>> records = new HashMap<String, HashMap<String, String>>();
		String l_dosage_type = "";
		String l_catalog_code = "";
		String l_occ_no ="";
		HashMap temp = new HashMap();
		
		try
		{
			connection = getConnection();
			String sql = "SELECT A.DOSAGE_TYPE DOSAGE_TYPE,A.OCURRANCE_NUM OCURRANCE_NUM,A.QTY_VALUE QTY_VALUE,A.QTY_UOM QTY_UOM,A.FREQ_CODE FREQ_CODE,A.DURN_VALUE DURN_VALUE,A.DURN_TYPE DURN_TYPE,A.REL_START_DATE_TIME REL_START_DATE_TIME,A.ROUTE_CODE ROUTE_CODE,A.ITEM_NARRATION ITEM_NARRATION,A.ORDER_CATALOG_CODE ORDER_CATALOG_CODE,(SELECT ROUTE_DESC FROM PH_ROUTE WHERE ROUTE_CODE = A.ROUTE_CODE)ROUTE_DESC,ORDER_SET_SEQ_NUM,DOSAGE_TYPE_SEQ_NO FROM OR_ORDER_SET_COMP_BY_DSG_TYPE A WHERE A.ORDER_SET_CODE = ? AND A.DOSAGE_TYPE = 'K' AND A.OCURRANCE_NUM > 1 order by A.DOSAGE_TYPE_SEQ_NO";
			pstmt	   = connection.prepareStatement(sql);
			
			pstmt.setString(1, order_set_code);
			rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				colValues = new HashMap();
				l_dosage_type = rs.getString("DOSAGE_TYPE")==null?"":rs.getString("DOSAGE_TYPE");
				l_occ_no = rs.getString("OCURRANCE_NUM")==null?"":rs.getString("OCURRANCE_NUM");
				colValues.put("occ_no",l_occ_no);
				colValues.put("dosage_type",l_dosage_type);
				colValues.put("dosage_type_seq_no",rs.getString("DOSAGE_TYPE_SEQ_NO")==null?"":rs.getString("DOSAGE_TYPE_SEQ_NO"));
				colValues.put("qty_value",rs.getString("QTY_VALUE")==null?"":rs.getString("QTY_VALUE"));
				colValues.put("freq_code",rs.getString("FREQ_CODE")==null?"":rs.getString("FREQ_CODE"));
				colValues.put("durn_value",rs.getString("DURN_VALUE")==null?"":rs.getString("DURN_VALUE"));
				colValues.put("durn_type",rs.getString("DURN_TYPE")==null?"":rs.getString("DURN_TYPE"));
				colValues.put("rel_start_date_time",rs.getString("REL_START_DATE_TIME")==null?"":rs.getString("REL_START_DATE_TIME"));
				colValues.put("route_code",rs.getString("ROUTE_CODE")==null?"":rs.getString("ROUTE_CODE"));
				colValues.put("prompt_msg",rs.getString("ITEM_NARRATION")==null?"":rs.getString("ITEM_NARRATION"));
				colValues.put("include","Y");
				colValues.put("route_desc",rs.getString("ROUTE_DESC")==null?"":rs.getString("ROUTE_DESC"));
				colValues.put("qty_uom",rs.getString("QTY_UOM")==null?"":rs.getString("QTY_UOM"));
				l_catalog_code = rs.getString("ORDER_CATALOG_CODE")==null?"":rs.getString("ORDER_CATALOG_CODE");
				colValues.put("order_set_seq_num",rs.getString("ORDER_SET_SEQ_NUM")==null?"":rs.getString("ORDER_SET_SEQ_NUM"));

				if(hashAdditionalCatalogDosageTypeKgWise.containsKey(l_catalog_code))
				{
					temp = new HashMap();
					temp.put(l_occ_no, colValues);					
					((HashMap)hashAdditionalCatalogDosageTypeKgWise.get(l_catalog_code)).put(l_occ_no,colValues);
				}
				else
				{
					temp = new HashMap();
					temp.put(l_occ_no, colValues);
					hashAdditionalCatalogDosageTypeKgWise.put(l_catalog_code,temp);					
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();			
		}
	}
	
	public void clearAdditionalAgeWiseCatalogs()
	{
		if(!hashCatalog.isEmpty())
			hashCatalog.clear();
	}
	//IN68241, ends
	//IN068370,IN068373, starts
		private void fetchMappedFacilities(String order_catalog_code) {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			
			String sql = "select applicable_facility_id from or_order_catalog_by_facility where order_catalog_code = ? order by 1";
		
		    try {
				connection = getConnection() ;
				
				pstmt = connection.prepareStatement(sql);	
				pstmt.setString(1,order_catalog_code);
		
				resultSet = pstmt.executeQuery() ;
		
				while ( resultSet != null && resultSet.next() ) {
					mappedFacilities.add(resultSet.getString("applicable_facility_id"));
				}
			} catch ( Exception e )	{
				e.printStackTrace() ;			
			} finally {
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection(connection) ;
				} catch (Exception e) {
					e.printStackTrace() ;
				}
			}
		}		
		
		public void setMappedFacilities(String fac_ids)
		{
			mappedFacilities = new ArrayList();
			StringTokenizer l_fac_ids = new StringTokenizer(fac_ids,"~");
			String l_fac_id = "";
			
			while(l_fac_ids.hasMoreTokens()) 
			{	
				l_fac_id = l_fac_ids.nextToken().trim();
				l_fac_id = l_fac_id.equals("@#")?"":l_fac_id;
				
				if(!"".equals(l_fac_id))
					mappedFacilities.add(l_fac_id);
			}	
		}
		
		public ArrayList<String> getMappedFacilities()
		{
			return mappedFacilities;
		}
		
		public void clearMappedFacilities()
		{
			if(mappedFacilities!=null)
				mappedFacilities.clear();
		}
		//IN068370,IN068373, ends
}//ENd of the class
