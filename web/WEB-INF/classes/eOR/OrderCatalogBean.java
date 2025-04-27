/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*************************************************************************
*	ClassName					: OrderCatalogBean
*	Description				    : This class caters functional specific  logic for web teir and communicate with EJB for the backened operation
*	Methods						:
*	Exception					:
*	Authors						: Prashant R. Bhalsingh
*	Version						: 1.0
*	Date						: 2/feb/2003
*	Revision History			:
***************************************************************************
*   Version			Date		Name		Remarks
***************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
19/11/2012	  IN031304		 Karthi L	 new checkbox follow_visit_type added(IN035976) 
10/03/2014	  IN024984		 Chowminya	 Duplicate order recording with reason - new mandatory option			
-------------------------------------------------------------------------------------------------------------------------------
Date		  Edit History	Name		Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------------------------------------
11/07/2014	  IN048467		Karthi L										To have an indicator to skip the authorization process if the priority for that order is urgent.
31/03/2017	  IN006320		Raja S		31/03/2017		Ramesh G			EMR-Alpha-OR-Disabled age group listed in Age group drop down field
08/05/2017	IN063816		Vijayakumar K									GHL-CRF-0445.1 [IN:063816]
03/08/2017	IN062992		Dinesh T	7/8/2017		Ramesh G			ML-MMOH-CRF-0345.1
15/12/2017	IN065942		Dinesh T	15/12/2017	Ramesh G	In Nuclear medicine  department we required the barcode 																	functionality at the time of Registration of order,required 																patient Id,patient name,age,sex,register date and name of 																	study.
02/05/2018	IN067312		Sharanraj	03/05/2018		Ramesh G			ML-MMOH-CRF-1126.1
17/07/2018	IN064543		Kamalakannan 17/07/2018		Ramesh G					ML-MMOH-CRF-0776
01/08/2018	IN64543			Dinesh T	01/08/2018		Ramesh G		ML-MMOH-CRF-0776
28/06/2018  IN066009		Sharanraj	13/08/2018		Ramesh G            OR-Common-Order Catalog
20/11/2018		ML-MMOH-SCF-1108		Kamalakannan 		Ramesh G			20/11/2018			ML-MMOH-SCF-1108
28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014
28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015
10/05/2019  IN068926       sivabagyam      10/05/2019      Ramesh G    	 ML-MMOH-CRF-1290
24/12/2019	IN068314	Nijitha		  23/12/2019			Ramesh G	 ML-MMOH-CRF-1229
24/1/2020	IN072190		Shazana 									SKR-SCF-1312
18/11/2020  TFSID-8081      Haribabu  18/11/2020       Ramesh G            GHL-SCF-1531                                    
07/09/2020	7540			Nijitha S		07/12/2020		Nijitha S		PMG2019-MMS-CRF-0004.1                                
20/02/2024    54391   Krishna Pranay     21/02/2024     Ramesh Goli      COMMON-ICN-0275 
09/04/2024   58960     Krishna Pranay  10/04/2024  Ramesh G   ML-MMOH-CRF-1921.1
07/10/2024  68801   Jeyachitra  08/10/2024   Krishna Pranay  ML-MMOH-CRF-0579

-------------------------------------------------------------------------------------------------------------------------------
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
import eOR.OROrderCatalog.*;



public class  OrderCatalogBean  extends OrAdapter implements Serializable
{
//	public    String					  tempChk ="";

	protected final int daysInMonths[]    = {0,31,59,90,120,151,181,212,242,273,304,334,365};

/*****************STORES(TO STORE ALL THE TABS VALUE)**********/

	public  ArrayList					characteristicsRecStr ;
	public  ArrayList					prepRecStr ;

	public  ArrayList					reviewsRecStr ;
	public  ArrayList					frequencyRecStr ;

	public  ArrayList					settingsRecStr ;
	public  HashMap						settingsFreqStr ;//
	public  HashMap						settingsAgeGroupStr ;//
	public  HashMap						settingsDurnStr ;//
	public  HashMap						settingsFreqStrMapper ;

	public  ArrayList					instructionsRecStr ;
	public  HashMap						instructionsConsentStr;

	public  ArrayList					billingRecStr ;

	public  ArrayList					turnAroundRecStr ;

	public  HashMap						orderCatalogHeaderStr ;

    eOR.Common.MultiRecordBean multiRecBean  = new eOR.Common.MultiRecordBean();

	public StringBuffer validateMessage = null;

	protected String frequencyFrom	= "";

	//private String isGlobalFacilityYn;//IN068370,IN068373//54391
	private ArrayList<String> mappedFacilities = new ArrayList<String>();//IN068370,IN068373
/***************Get Methods*******************************/
public ArrayList getCharacteristicsRecStr(){return characteristicsRecStr ;}
public ArrayList getPrepRecStr(){return prepRecStr ;}
public ArrayList getReviewsRecStr(){return reviewsRecStr ;}
public ArrayList getFrequencyRecStr(){return frequencyRecStr ;}
public ArrayList getSettingsRecStr(){return settingsRecStr ;}
public HashMap	 getSettingsFreqStr(){return settingsFreqStr ;}
public HashMap	 getSettingsAgeGroupStr(){return settingsAgeGroupStr ;}
public HashMap	 getSettingsDurnStr(){return settingsDurnStr ;}
public ArrayList getBillingRecStr(){return billingRecStr ;}
public ArrayList getInstructionsRecStr(){return instructionsRecStr ;}
public HashMap	 getInstructionsConsentStr(){return instructionsConsentStr ;}
public HashMap	 getOrderCatalogHeaderStr(){return orderCatalogHeaderStr ;}
public String	 getFrequencyFrom(){return frequencyFrom;}
public ArrayList getTurnAroundRecStr() { return turnAroundRecStr;}

public void	setFrequencyFrom(String frequencyFrom) { this.frequencyFrom = frequencyFrom;}

//ML-MMOH-SCF-1108 start
HashMap map = new HashMap();

public int setInstructionsRecStrClob(String key, HashMap value)
{
	map.put(key,value.get("clobContent"));
	return 1;
}

public int setInstructionsRecStrClob(String key, ArrayList value)
{
	map.put(key,value);
	return 1;
}


public int setInstructionsRecStrClobLoad(String key, HashMap value)
{
	ArrayList d = new ArrayList();
	if("pat_preps_or_instrns_free_fmt_im".equals(key))
	{
		if(map.containsKey("pat_preps_or_instrns_free_fmt_im"))
		{
			d = (ArrayList) map.get("pat_preps_or_instrns_free_fmt_im");
			d.add(value);			
		}
		else
		{
			d.add(value);					
		}
		map.put(key,d);
	}
	return 1;
}

public HashMap getInstructionsRecStrClob()
{
	return map;
}

public int getInstructionsRecStrTemp1Size()
{
	int arrayLength=0;
	ArrayList getSize= (ArrayList) (getInstructionsRecStrClob().get("pat_preps_or_instrns_free_fmt_im"));
	if(getSize!=null)
		arrayLength= getSize.size();
	return arrayLength;
}
//ML-MMOH-SCF-1108 end
/******************Clear ALL*******************************/
public void clearALL(){//Called when combo Option for OrderCategory is Changed

	if(!characteristicsRecStr.isEmpty())
		characteristicsRecStr.clear() ;

	if(!prepRecStr.isEmpty())
		prepRecStr.clear() ;

	if(!reviewsRecStr.isEmpty())
		reviewsRecStr.clear() ;

	if(!frequencyRecStr.isEmpty())
		frequencyRecStr.clear() ;

	if(!settingsRecStr.isEmpty()) {
		settingsRecStr.clear() ;
	}

	if((settingsFreqStr != null) && (!settingsFreqStr.isEmpty())) {
		settingsFreqStr.clear() ;

	}

	if(!instructionsRecStr.isEmpty())
		instructionsRecStr.clear() ;

	if(!turnAroundRecStr.isEmpty())
		turnAroundRecStr.clear() ;

	if(!billingRecStr.isEmpty())
		billingRecStr.clear() ;

	if(!orderCatalogHeaderStr.isEmpty())
		orderCatalogHeaderStr.clear() ;

	if(!frequencyFrom.equals(""))
		frequencyFrom = "";
	
	//ML-MMOH-SCF-1108 start
		if(!map.isEmpty())
			map.clear() ;
	//ML-MMOH-SCF-1108 end
	try {
        multiRecBean.clearDBRec();
	   multiRecBean.clearSelectRec();
	} catch (Exception e) {
		e.printStackTrace();
	}

}

/*********************Constructor *************************/
public OrderCatalogBean(){

	 		 orderCatalogHeaderStr			= new HashMap();

			 characteristicsRecStr			= new ArrayList();
			 prepRecStr			            = new ArrayList();
			 reviewsRecStr				 	= new ArrayList();
			 frequencyRecStr			 	= new ArrayList();
			 settingsRecStr					= new ArrayList();
			 instructionsRecStr				= new ArrayList();
			 billingRecStr					= new ArrayList();
			 turnAroundRecStr               = new ArrayList();
 			 settingsFreqStr                = null ;
 			 settingsAgeGroupStr            = null ;
			 settingsDurnStr                    =null ;
			 validateMessage				= new StringBuffer();
			 mappedFacilities =  new ArrayList<String>();//IN068370,IN068373


	}

/*********************Validate *************************/

public synchronized HashMap validate() throws Exception {


	HashMap map = new HashMap();
	map.put( "result", new Boolean( true ) ) ;
	map.put( "message", "success.." );
	boolean  finalFlag = true ;

	//boolean flag = true ;

	String order_category =  (String)orderCatalogHeaderStr.get("order_category");
	String activity_type=(String)orderCatalogHeaderStr.get("activity_type");
	String msgNotBlank	  =	checkForNull(getMessage(language_id,"SHOULD_NOT_BE_BLANK","Common"));



	String locale = properties.getProperty("LOCALE");
	locale = (locale == null || locale.equals(""))?"en":locale;

	java.util.Locale loc = new java.util.Locale(locale);
	java.util.ResourceBundle or_labels = java.util.ResourceBundle.getBundle( "eOR.resources.Labels",loc);
	java.util.ResourceBundle or_messages = java.util.ResourceBundle.getBundle( "eOR.resources.Messages",loc);
	java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);

	//String label = or_labels.getString("eOR.DirectCare.label");

	if(msgNotBlank.trim().equalsIgnoreCase(""))
			throw new Exception("No Message => to Key SHOULD_NOT_BE_BLANK in the DataBase");

	try
	{


			if(order_category.trim().equalsIgnoreCase("CN"))
			{
				if(!chkRequiredForConsultation(characteristicsRecStr,0,"order_category","CN","complete_on_order_yn"))
				{
						validateMessage.append(or_messages.getString("COMPLETE_ON_ORDER"));
						finalFlag = false ;
				}
			}
			if(!chkRequired(characteristicsRecStr,0,"effective_status_directCare","Y","catalog_synonym_directCare")){
			//validateMessage.append(concat("Direct Care ",msgNotBlank));
			validateMessage.append(concat(or_labels.getString("eOR.DirectCare.label"),msgNotBlank));
			finalFlag = false ;
		}

		if(!chkRequired(characteristicsRecStr,0,"effective_status_ancillaryDept","Y","catalog_synonym_ancillaryDept")){
			validateMessage.append(concat(or_labels.getString("eOR.AncillaryDept.label") , msgNotBlank));
			finalFlag = false ;
		}

		if(!chkRequired(characteristicsRecStr,0,"multiple_consent_yn","N","consent_form_id") && !chkRequired(characteristicsRecStr,0,"consent_form_list","F","consent_form_id") ){//when multiple consent value is N it means it's single & fixed and Consent form id and stage are mandatory
			if(!chkRequired(characteristicsRecStr,0,"consent_reqd_yn","Y","consent_form_id")){
				validateMessage.append(concat("Consent Form ",  msgNotBlank));
				finalFlag = false ;
			}
			if(!chkRequired(characteristicsRecStr,0,"consent_reqd_yn","Y","consent_stage")){
				validateMessage.append(concat("Consent Form ",  msgNotBlank));
				finalFlag = false ;
			}
		}

		if(!chkRequired(characteristicsRecStr,0,"multiple_consent_yn","Y","num_of_consent_req_bo")){
			validateMessage.append(concat("Number Of Consent Required Before Order Release " , msgNotBlank));
			finalFlag = false ;
		}
		if(!chkRequired(characteristicsRecStr,0,"multiple_consent_yn","Y","num_of_consent_req_br")){
			validateMessage.append(concat("Number Of Consent Required Before Order Registration " , msgNotBlank));
			finalFlag = false ;
		}

		if(!chkRequired(characteristicsRecStr,0,"chk_for_dupl_yn","Y","chk_for_dupl_status")){
			validateMessage.append(concat(or_labels.getString("eOR.StatusConsidered.label") , msgNotBlank));
			finalFlag = false ;
		}

		if(!chkActivityType(characteristicsRecStr,0,"check_for_dupl_level","A",activity_type)){
			validateMessage.append(concat(or_labels.getString("eOR.ActivityType.label") , msgNotBlank));
			finalFlag = false ;
		}


 if (!order_category.equals("PH")) {

		if(!chkRequired(characteristicsRecStr,0,"chk_for_dupl_yn","Y","chk_for_dupl_behind_action")){
			validateMessage.append(concat(or_labels.getString("eOR.BehindAction.label") ,msgNotBlank));
			finalFlag = false ;
		}

		if(!chkRequired(characteristicsRecStr,0,"chk_for_dupl_yn","Y","chk_for_dupl_ahead_action")){
			validateMessage.append(concat(or_labels.getString("eOR.AheadAction.label") , msgNotBlank));
			finalFlag = false ;
		}

		if(!chkRequiredEmpty(characteristicsRecStr,0,"chk_for_dupl_ahead_period","chk_for_dupl_ahead_unit")){
			validateMessage.append(concat("Ahead Unit " , msgNotBlank));
			finalFlag = false ;
		}


		if(!chkRequiredEmpty(characteristicsRecStr,0,"chk_for_dupl_ahead_action","chk_for_dupl_ahead_period")){ //chk_for_dupl_ahead_unit
			validateMessage.append(concat("Ahead Period " , msgNotBlank));
			finalFlag = false ;
		}



		if(!chkRequiredEmpty(characteristicsRecStr,0,"chk_for_dupl_behind_period","chk_for_dupl_behind_unit")){
			validateMessage.append(concat("Behind Unit " , msgNotBlank));
			finalFlag = false ;
		}




		//if(!chkRequiredEmpty(characteristicsRecStr,0,"chk_for_dupl_behind_unit","chk_for_dupl_behind_period","")){
		if(!chkRequiredEmpty(characteristicsRecStr,0,"chk_for_dupl_behind_action","chk_for_dupl_behind_period")){
			validateMessage.append(concat("Behind Period " , msgNotBlank));
			finalFlag = false ;
		}
 }

		if(!chkRequired(characteristicsRecStr,0,"result_applicable_yn","Y","chart_result_type")){
			if(characteristicsRecStr.size() > 0){
				HashMap currRec = (HashMap)characteristicsRecStr.get(0);
				String contr_mod_id = (String)currRec.get("contr_mod_id");

				//only if it called from or module Order_category not Lb,RX,RD chk for this cond if
			//	if((contr_mod_id.trim().equals("")||contr_mod_id.trim().equals("OR"))  && !(order_category.equalsIgnoreCase("LB")||order_category.equalsIgnoreCase("RD") || order_category.equalsIgnoreCase("RX")) ){
				if((contr_mod_id.trim().equals("")||contr_mod_id.trim().equals("OR"))){
					if(!(order_category.equalsIgnoreCase("LB")||order_category.equalsIgnoreCase("RD") || order_category.equalsIgnoreCase("RX"))){
						validateMessage.append(concat(or_labels.getString("eOR.ChartResultType.label") , msgNotBlank));
						finalFlag = false ;
					}
				}
			}
		}


		if(!chkRequired(characteristicsRecStr,0,"result_applicable_yn","Y","discr_msr_panel_id")){
			if(characteristicsRecStr.size() > 0){
				HashMap currRec = (HashMap)characteristicsRecStr.get(0);
				String contr_mod_id = (String)currRec.get("contr_mod_id");
				//if((contr_mod_id.trim().equals("")||contr_mod_id.trim().equals("OR"))  && !(order_category.equalsIgnoreCase("LB")||order_category.equalsIgnoreCase("RD")     ||order_category.equalsIgnoreCase("RX")) ){
				if((contr_mod_id.trim().equals("")||contr_mod_id.trim().equals("OR"))){
					if(!(order_category.equalsIgnoreCase("LB")||order_category.equalsIgnoreCase("RD") || order_category.equalsIgnoreCase("RX")) || ( getdefaultArrListValue(characteristicsRecStr,0,"auto_report_yn","").equals("Y") )){
						//if (!getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("I")) {
						if (getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("D")) {
						   validateMessage.append(concat("Discrete Measure" ,msgNotBlank));
						   finalFlag = false ;
						}else if (getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("M")) {
						   validateMessage.append(concat(or_labels.getString("eOR.resultmatrix.label") ,msgNotBlank));
						   finalFlag = false ;
						}else if (getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("N")) {
						   validateMessage.append(concat("Note " ,msgNotBlank));
						   finalFlag = false ;
						}else if (getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("P")) {
						   //validateMessage.append(concat(or_labels.getString("eOR.Procedure.label") ,msgNotBlank));
						   validateMessage.append(concat(common_labels.getString("Common.Procedure.label") ,msgNotBlank));
						   finalFlag = false ;
						}else if (getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("C")) {
						   validateMessage.append(concat(or_labels.getString("eOR.Charting.label") ,msgNotBlank));
						   finalFlag = false ;
						}
					}
				}
			}
		}
		if((getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("P"))){
			if(!chkRequiredEmpty(characteristicsRecStr,0,"discr_msr_panel_id","proc_coding_scheme")){

			validateMessage.append(concat("Procedure Coding Scheme" , msgNotBlank));
			finalFlag = false ;
		}

		}
//**if(!(getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("P"))){
	if(!chkRequired(characteristicsRecStr,0,"proc_link_applicable","P","term_set_id")){

			//validateMessage.append(concat(or_labels.getString("eOR.TermSetID.label") , msgNotBlank));
			validateMessage.append(concat(common_labels.getString("Common.TermSetID.label") , msgNotBlank));
			finalFlag = false ;
		}
//}

//**if(!(getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("P"))){
	if(!chkRequired(characteristicsRecStr,0,"proc_link_applicable","C","term_set_id")){

			//validateMessage.append(concat(or_labels.getString("eOR.TermSetID.label") , msgNotBlank));
			validateMessage.append(concat(common_labels.getString("Common.TermSetID.label") , msgNotBlank));
			finalFlag = false ;
		}
//}
//**if(!(getdefaultArrListValue(characteristicsRecStr,0,"chart_result_type","").equals("P"))){
	if(!chkRequiredEmpty(characteristicsRecStr,0,"term_set_id","term_code")){
			//validateMessage.append(concat(or_labels.getString("eOR.TermCode.label") , msgNotBlank));
			validateMessage.append(concat(common_labels.getString("Common.TermCode.label") , msgNotBlank));
			finalFlag = false ;
		}
//}



		//Prep
		/*if ()
		{

		if (!getdefaultArrListValue(prepRecStr,0,"patient_class0","").equals("I")) {
					   validateMessage.append(concat("Discrete Measure " ,msgNotBlank));
					   finalFlag = false ;
                    }

		}*/


		//Setting tab Validation
		if(!chkSecAuthLevel()){
			validateMessage.append(getMessage(language_id,"CATALOG_AUTH_CHECK","OR"));
			finalFlag = false ;
		}


		if(!chkFreqApp()){
					//validateMessage.append(concat(or_labels.getString("eOR.DurationType.label") , msgNotBlank));
					validateMessage.append(concat(common_labels.getString("Common.Frequency.label") ,	 msgNotBlank));
					finalFlag = false ;

			}


		/**if(!chkFreqRequired()){
			validateMessage.append(concat("Frequency" ,	 msgNotBlank));
			finalFlag = false ;
		}*****/


		if(!chkQtyReqd()){

			validateMessage.append(concat(or_labels.getString("eOR.QtyDose.label") ,	 msgNotBlank));
			finalFlag = false ;
		}

		if(!chkRequired(instructionsRecStr,0,"prompt_alert_yn","Y","prompt_alert_msg")){
			validateMessage.append(concat("Prompt Msg " , msgNotBlank));
			finalFlag = false ;
		}

		if(!chkRequired(instructionsRecStr,0,"splty_speci_reqd_yn","Y","pri_splty_code")){
			validateMessage.append(concat(common_labels.getString("Common.primaryspeciality.label") , msgNotBlank));
			finalFlag = false ;
		}

		if(!chkRequiredEmpty(instructionsRecStr,0,"appt_prep_time_type","appt_prep_time")){
			validateMessage.append(concat(common_labels.getString("Common.DurationType.label") , msgNotBlank));
			finalFlag = false ;
		}

		if(!chkRequiredEmpty(instructionsRecStr,0,"appt_prep_time","appt_prep_time_type")){
			validateMessage.append(concat(or_labels.getString("eOR.PreparationDuration.label") , msgNotBlank));
			finalFlag = false ;
		}


		/*if(!chkRequired(instructionsRecStr,0,"appt_reqd_yn","Y","appt_time","")){
			validateMessage.append(concat("Appointment Duration " , msgNotBlank));
			finalFlag = false ;
		}*/

        if (!chkDurnRequired()) {
			finalFlag	= false ;
		}
		/*if(!chkRequiredAll(settingsRecStr,"max_durn_value","max_durn_type")){
			validateMessage.append(concat("Max Durn/Type " ,	 msgNotBlank));
			finalFlag = false ;
		}


		if(!chkRequiredAll(settingsRecStr,"freq_code","durn_value")){
			validateMessage.append(concat("Durn Value" ,	 msgNotBlank));
			finalFlag = false ;
		}


		if(!chkRequiredAll(settingsRecStr,"max_durn_value","chk_for_max_durn_action")){
			validateMessage.append(concat("Action" ,	 msgNotBlank));
			finalFlag = false ;
		}

		if(!chkRequiredAll(settingsRecStr,"max_durn_value","prompt_msg")){
			validateMessage.append(concat("Msg" ,	 msgNotBlank));
			finalFlag = false ;
		}*/


	if(chkPrepRequired())
		{

			validateMessage.append(concat(or_labels.getString("eOR.PatientClassApplicability.label") ,	 msgNotBlank));
			finalFlag = false ;

		}


	if(chkPrepCatalogRequired())
		{

			validateMessage.append(concat(or_labels.getString("eOR.SecondaryTaskPrep.label") ,	 msgNotBlank));
			finalFlag = false ;

		}
	if(chkPrepDurationRequired())
		{

			validateMessage.append(concat("Duration in Secondary Task/Prep" ,	 msgNotBlank));
			finalFlag = false ;

		}
		/*********************chk Prep-Duration values greater than zero****************************/
		HashMap PrepDurationVal=new HashMap();
		PrepDurationVal=chkPrepDurationValue();
		if(PrepDurationVal.size()!=0){
			String type=(String)PrepDurationVal.get("type");
			String valGrtZero=checkForNull(getMessage(language_id,"VALUE_GREAT_ZERO","MP"));
			String msg1 = "Value should be greater than 0";
			int indx1 = valGrtZero.indexOf(msg1);
			validateMessage.append(valGrtZero.substring(0,indx1) + " "  + type + " " + valGrtZero.substring(indx1,valGrtZero.length()));
			finalFlag = false ;

		}
	/************************************************************/

	}catch (Exception e){

		e.printStackTrace();
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", e.getMessage());
	}

	if(!finalFlag){
		map.put( "result", new Boolean( false ) ) ;
		map.put( "message", "Validate" );
	}


	return map;
}
/****************Concanate Function ************************************/
private String concat(String varMsg,String msgNotBlank){
	try
	{	msgNotBlank = msgNotBlank.replace("{","");
		 msgNotBlank = msgNotBlank.replace("1",varMsg);
		 msgNotBlank = msgNotBlank.replace("}","");
		 msgNotBlank = msgNotBlank+"<br>";
		 return  msgNotBlank;
		//String temp = "Cannot be Blank" ;
		/*String temp = " " ;
		int indx = msgNotBlank.indexOf(temp);


		return  msgNotBlank.substring(0,indx) + " "  + varMsg + " " + msgNotBlank.substring(indx+5,msgNotBlank.length())+"<br>";*/
	}catch (Exception e){

		return "SHOULD_NOT_BE_BLANK Key not in the DataBase Or Msg Corresponding to the  key does not contain ' Cannot be Blank ' " ;
	}

}
/*************Over riding get Message**************************************/
public String getMessage( String msgId ){

String msg ="";

	if(msgId.equals("Validate")){
		msg = validateMessage.toString();
		validateMessage =  new StringBuffer() ;

		return msg ;
	}else{
		return super.getMessage(msgId) ;
	}

}
/*****************MAX DURN VAL CHK *******************************************/
//private boolean chkRequiredAll(ArrayList store, String key , String mandatory ,String manVAL) throws Exception{
private boolean chkRequiredAll(ArrayList store, String key , String mandatory ) throws Exception{
try{
		int size =  store.size();
		boolean flag  = true ;

		if(size == 0)
		return true;

		for (int i = 0 ; i < size ; i++ ){
		flag = chkRequiredEmpty(store,i,key,mandatory)	;
		if(!flag)
			return false ;
		}

		return true;
	}catch(Exception e){
		throw e;
	}
}
/*****************************************************************************/

private boolean chkRequired(ArrayList store, int position , String key ,  String keyVal , String mandatory ) throws Exception{

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

	if(currKeyVal.trim().equalsIgnoreCase(keyVal.trim())){
		if(mandatoryVal.trim().equalsIgnoreCase(""))
			return false ;
	}else{
			return true;
	}


	return true ;

}
/*****************************************************************************/
private boolean chkRequiredForConsultation(ArrayList store, int position , String key ,  String keyVal , String mandatory ) throws Exception{
	int size =  store.size();

	if(size == 0)
	return true;

	if(size < position )
		throw new Exception("Chk position passed and the size of Store") ;
	HashMap currRec = (HashMap)store.get(position);
	if(!currRec.containsKey(mandatory.trim())) //mandatory should be there
		return true ;
	String mandatoryVal  = (String)currRec.get(mandatory.trim());

		if(mandatoryVal.trim().equalsIgnoreCase(""))
		{
				return false ;
		}
		else if(mandatoryVal.trim().equalsIgnoreCase("N"))
		{
				return false ;
		}
		else
		{
				return true;
		}

}
/**************************************************************************/
private boolean chkRequiredEmpty(ArrayList store, int position , String key , String mandatory ) throws Exception{

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

	if(!currKeyVal.trim().equalsIgnoreCase("")){
		if(mandatoryVal.trim().equalsIgnoreCase(""))
			return false ;
	}else{
			return true;
	}


	return true ;

}

/************************CHK Duration Required ******************************/
private boolean chkDurnRequired(){

	String msgNotBlank	  =	checkForNull(getMessage(language_id,"SHOULD_NOT_BE_BLANK","Common"));
	//HashMap currRec=new HashMap();
	int size =  settingsRecStr.size();

	if(size == 0)
	return true;
		String durn_type="";
	try {
		for (int i = 0 ; i < size ; i++ ){
			HashMap currRec	  =	(HashMap)settingsRecStr.get(i);



	    	durn_type = (String)currRec.get("durn_type");

			if(durn_type.trim().equals("")){

			continue ;
			}

			if(!chkRequiredEmpty(settingsRecStr,i,"max_durn_value","max_durn_type")){

				validateMessage.append(concat("Max Durn/Type " ,	 msgNotBlank));
				return false ;
			}


			if(!chkRequiredEmpty(settingsRecStr,i,"freq_code","durn_value")){

				validateMessage.append(concat("Durn Value" ,	 msgNotBlank));
				return false ;
			}


			if(!chkRequiredEmpty(settingsRecStr,i,"max_durn_value","chk_for_max_durn_action")){

				validateMessage.append(concat("Action" ,	 msgNotBlank));
				return false ;
			}

			if(!chkRequiredEmpty(settingsRecStr,i,"max_durn_value","prompt_msg")){

				validateMessage.append(concat("Msg" ,	 msgNotBlank));
				return false ;
			}
			//currRec.clear();
		}

	} catch (Exception e) {
		return false;
	}

	return  true ;

}

/************************CHK Sec-Auth level ******************************/
private boolean chkSecAuthLevel(){

	int size =  settingsRecStr.size();

	if(size == 0)
	return true;

	String security_level  = (String)orderCatalogHeaderStr.get("security_level");
	String auth_level="";
	if(security_level.trim().equals(""))
		return true ;
	//HashMap currRec=new HashMap();
	for (int i = 0 ; i < size ; i++ ){
		 HashMap currRec	  =	(HashMap)settingsRecStr.get(i);
		auth_level = (String)currRec.get("ord_auth_level");
		//currRec.clear();
		if(auth_level.trim().equals(""))
		continue ;

		if(Integer.parseInt(auth_level) < Integer.parseInt(security_level))
		return false ;

	}

	return  true ;

}
/**************************CHK Prep- Req**************************/
private boolean chkPrepRequired(){

ArrayList allRecords = multiRecBean.getAllDBRecords();




boolean flag=true;
    if (allRecords.size()>0)
	{	

		if (prepRecStr.size()>0)
		{
		HashMap ht             = (HashMap)prepRecStr.get(0);
		int	total_rec=0;
		if(ht.containsKey("tot_recs"))
		total_rec=Integer.parseInt((String)ht.get("tot_recs"));

		for(int i=0;i<total_rec;i++)
			{

				if (ht.containsKey("patient_class"+i))
				{
				 flag=false;

				}
			}
		}

	}
	else
			flag=false;

	return flag;
	}
	/**************************CHK Prep-order catalog Req**************************/
private boolean chkPrepCatalogRequired(){


ArrayList allRecords = multiRecBean.getAllDBRecords();




boolean catalogFlag=false;
   // if (allRecords.size()>0)
	//{	

		if (prepRecStr.size()>0)
		{
		HashMap ht             = (HashMap)prepRecStr.get(0);

		int	total_rec=0;
		if(ht.containsKey("tot_recs"))
		total_rec=Integer.parseInt((String)ht.get("tot_recs"));


		for(int i=0;i<total_rec;i++)
			{

				if (ht.containsKey("patient_class"+i) && allRecords.size()==0 )
				{
				 catalogFlag=true;

				}
			}
		}

	//}


	return catalogFlag;
	}



/************************CHK Prep-Duration Req******************************/
private boolean chkPrepDurationRequired(){
	boolean durnFlag=false;
	try{

ArrayList allRecords = multiRecBean.getAllDBRecords();





    if (allRecords.size()>0)
	{
		for(int i=0;i<allRecords.size();i++){
			HashMap ht             = (HashMap)allRecords.get(i);

			if (ht.containsKey("associate_yn") && ((String)ht.get("associate_yn")).equals("Y"))
				{
					if((((String)ht.get("sec_order_stat_durn")).equals("")) || (((String)ht.get("sec_order_urg_durn")).equals("")) || (((String)ht.get("sec_order_rtn_durn")).equals(""))){

					durnFlag=true;
					break;
					}

				}

		}
	}


	}catch(Exception e){
		e.printStackTrace();
	}
	return durnFlag;
}
/************************CHK stat_durn >0 ******************************/
private HashMap chkPrepDurationValue(){
	HashMap PrepDurationValue=new HashMap();
	try{

ArrayList allRecords = multiRecBean.getAllDBRecords();

    if (allRecords.size()>0)
	{
		for(int i=0;i<allRecords.size();i++){
			HashMap ht             = (HashMap)allRecords.get(i);

			if (ht.containsKey("associate_yn") && ((String)ht.get("associate_yn")).equals("Y"))
				{
					if(((String)ht.get("sec_order_stat_durn")).equals("0")){

					PrepDurationValue.put("type","Stat");
					//durnValFlag=true;
					break;
					}else if(((String)ht.get("sec_order_urg_durn")).equals("0")){
					PrepDurationValue.put("type","Urgent");
					//durnValFlag=true;
					break;
					}else if (((String)ht.get("sec_order_rtn_durn")).equals("0"))
					{
					PrepDurationValue.put("type","Routine");
					//durnValFlag=true;
					break;
					}

				}

		}
	}


	}catch(Exception e){
		e.printStackTrace();
	}

	return PrepDurationValue;
}

/************************CHK for Freq- Application Tab******************************/
private boolean chkFreqApp(){
		int sizeCharacteristic	=characteristicsRecStr.size();

		if(sizeCharacteristic == 0)
		return true;

		HashMap ht             = (HashMap)characteristicsRecStr.get(0);
		String freq_applicable_yn  = (String)ht.get("freq_applicable_yn");
		if(!freq_applicable_yn.trim().equalsIgnoreCase("Y"))
		return true ;

try{
	if(settingsRecStr.isEmpty() ){

	Hashtable   dummpPageSettings=  new  Hashtable();
	Hashtable defVal1 = new Hashtable();
	String order_catalog_code =	(String)orderCatalogHeaderStr.get("order_catalog_code");
		 String sqlParam[]  = {order_catalog_code.trim()};
		 defVal1 = settingsDefault("SQL_OR_CATALOG_LOAD_CATALOG_BY_SETTINGS","update",sqlParam);

		 HashMap pat_class		 =	getSqlResult("SQL_OR_PATIENT_CLASS_LIST");
		 Integer noOfRecordsTemp = (Integer)pat_class.get("noRec");
		 int noOfRecords1		 = noOfRecordsTemp.intValue() ;
		 int fm_disp1			 = 0 ;
		 int to_disp1			 = noOfRecords1 ;
		String OrderCategory=((String)orderCatalogHeaderStr.get("order_category")).trim();
		setSettingsFreqStr(OrderCategory,order_catalog_code);
		settingsFreqStr		 = getSettingsFreqStr();

		 if(noOfRecords1!= 0){
			 dummpPageSettings.put("noOfRecords",String.valueOf(noOfRecords1));
			String 	patient_class	= "";
			//HashMap currRecSettings=new HashMap();
			//Integer	noOfRecTemp	=null;
		//	HashMap tempHash=new HashMap();
			 for(int k=fm_disp1; k<= to_disp1;k++){

				patient_class	= "";
				boolean contVal			= false ;
				boolean flag=true;
				boolean flag1=true;

				if(k==0){
					contVal =true ;//always the all patient class(*A)  will  be present in the DataBase
					patient_class = "*A";
				}else{
					patient_class  = (String)pat_class.get("PATIENT_CLASS"+k);
					contVal = defVal1.containsKey(patient_class.trim()) ;
				}
				if(contVal){//Value form the DataBase
				if(k==0 && defVal1.size()==0){

						dummpPageSettings.put("patient_class"+k			,patient_class.trim());
						/*IN066009 starts*/
						//dummpPageSettings.put("setting_applicability"+k		,"X");
						dummpPageSettings.put("setting_applicability"+k		,"A");
						/*IN066009 Ends*/
						dummpPageSettings.put("age_group_code"+k			,"");
						dummpPageSettings.put("qty_value"+k					,"");
						dummpPageSettings.put("qty_uom"+k					,"");
						dummpPageSettings.put("freq_code"+k					,"");
						dummpPageSettings.put("durn_value"+k				,"0");
						dummpPageSettings.put("durn_type"+k					,"");
						dummpPageSettings.put("durn_desc"+k					,"");
						dummpPageSettings.put("max_durn_type"+k			,"");
						dummpPageSettings.put("max_durn_value"+k			,"0");
						dummpPageSettings.put("chk_for_max_durn_action"+k	,"");
						dummpPageSettings.put("ord_auth_level"+k			,"");
						dummpPageSettings.put("prompt_msg"+k				,"");

					}else{
				HashMap currRecSettings					=(HashMap)defVal1.get(patient_class.trim());

			//	if (currRecSettings.size()!=0){

				String setting_applicability_default   =(String)currRecSettings.get("setting_applicability");
				if(setting_applicability_default.trim().equalsIgnoreCase("A")){

		Integer noOfRecTemp				 = (Integer)settingsFreqStr.get("noRec");

		int noOfRecordsFreq				 = noOfRecTemp.intValue() ;


		if(noOfRecordsFreq != 0){

			for(int i=0;i<noOfRecordsFreq;i++){
					int applicableCount = frequencyRecStr.size();

					if (applicableCount > 0) {
						for (int j = 0; j < applicableCount; j++) {

							HashMap tempHash = (HashMap)frequencyRecStr.get(j);



							if (((String)tempHash.get("frequency_code")).equals((String)settingsFreqStr.get("FREQ_CODE"+i))) {

								if (((String)settingsFreqStr.get("APPLICABLE_YN"+i)).equalsIgnoreCase(((String)tempHash.get("applicable_yn"))) && ((String)settingsFreqStr.get("APPLICABLE_YN"+i)).equals("Y") ) {
									flag=true;
									flag1=false;
								}else if (((String)settingsFreqStr.get("APPLICABLE_YN"+i)).equalsIgnoreCase(((String)tempHash.get("applicable_yn"))) && ((String)settingsFreqStr.get("APPLICABLE_YN"+i)).equals("N") )
								{

									flag=true;

								}else{

									if(((String)settingsFreqStr.get("APPLICABLE_YN"+i)).equals("Y") && ((String)tempHash.get("applicable_yn")).equals("N"))
									{
										if (((String)tempHash.get("frequency_code")).equals((String)currRecSettings.get("freq_code")))
										{
											flag=false;
											flag1=false;
											return false;
										}else
										{
											flag=true;
											flag1=false;

										}

									}else{
											flag=true;
											flag1=false;
									}

								}
							}
							//tempHash.clear();
						}
					}
				}
		}
				if (flag==true && flag1==false){
							dummpPageSettings.put("patient_class"+k,patient_class.trim());
							dummpPageSettings.put("setting_applicability"+k		,setting_applicability_default);
							dummpPageSettings.put("age_group_code"+k			,(String)currRecSettings.get("age_group_code"));
							dummpPageSettings.put("freq_code"+k					,(String)currRecSettings.get("freq_code"));
							dummpPageSettings.put("qty_value"+k					,(String)currRecSettings.get("qty_value"));
							dummpPageSettings.put("qty_uom"+k					,(String)currRecSettings.get("qty_uom"));
							dummpPageSettings.put("durn_value"+k				,(String)currRecSettings.get("durn_value"));
							dummpPageSettings.put("durn_type"+k					,(String)currRecSettings.get("durn_type"));
							dummpPageSettings.put("durn_desc"+k				,(String)currRecSettings.get("durn_desc"));
							dummpPageSettings.put("max_durn_type"+k			,(String)currRecSettings.get("max_durn_type"));
							dummpPageSettings.put("max_durn_value"+k			,(String)currRecSettings.get("max_durn_value"));
							dummpPageSettings.put("chk_for_max_durn_action"+k	,(String)currRecSettings.get("chk_for_max_durn_action"));
							dummpPageSettings.put("ord_auth_level"+k			,(String)currRecSettings.get("ord_auth_level"));
							dummpPageSettings.put("prompt_msg"+k				,(String)currRecSettings.get("prompt_msg"));
					}else if(flag==true && flag1==true){
							dummpPageSettings.put("patient_class"+k			,patient_class.trim());
							dummpPageSettings.put("setting_applicability"+k	,"X");
							dummpPageSettings.put("age_group_code"+k			,"");
							dummpPageSettings.put("qty_value"+k					,"");
							dummpPageSettings.put("qty_uom"+k					,"");
							dummpPageSettings.put("freq_code"+k				,"");
							dummpPageSettings.put("durn_value"+k				,"");
							dummpPageSettings.put("durn_type"+k				,"");
							dummpPageSettings.put("durn_desc"+k				,"");
							dummpPageSettings.put("max_durn_type"+k				,"");
							dummpPageSettings.put("max_durn_value"+k			,"");
							dummpPageSettings.put("chk_for_max_durn_action"+k	,"");
							dummpPageSettings.put("ord_auth_level"+k			,"");
							dummpPageSettings.put("prompt_msg"+k				,"");
					}
							continue ;
						}
							//}
					//currRecSettings.clear();
					//noOfRecTemp	=null;
				}

				  }
					dummpPageSettings.put("patient_class"+k			,patient_class.trim());
					/*IN066009 starts*/
					if(k==0)
						dummpPageSettings.put("setting_applicability"+k	,"A");
					else
						dummpPageSettings.put("setting_applicability"+k	,"X");
					/*IN066009 Ends*/
					dummpPageSettings.put("age_group_code"+k			,"");
					dummpPageSettings.put("qty_value"+k					,"");
					dummpPageSettings.put("qty_uom"+k					,"");
					dummpPageSettings.put("freq_code"+k				,"");
					dummpPageSettings.put("durn_value"+k				,"");
					dummpPageSettings.put("durn_type"+k				,"");
					dummpPageSettings.put("durn_desc"+k				,"");
					dummpPageSettings.put("max_durn_type"+k				,"");
					dummpPageSettings.put("max_durn_value"+k			,"");
					dummpPageSettings.put("chk_for_max_durn_action"+k	,"");
					dummpPageSettings.put("ord_auth_level"+k			,"");
					dummpPageSettings.put("prompt_msg"+k				,"");
				 }
			}
	settingsSync(dummpPageSettings)	; //Syn if the str is empty
	}else	{
		//HashMap currRec=new HashMap();
		//HashMap tempHash=new HashMap();



		for (int i = 0 ; i < settingsRecStr.size() ; i++ ){
			boolean flag=false;
			HashMap currRec	  =	(HashMap)settingsRecStr.get(i);


			if((((String)currRec.get("setting_applicability")).trim()).equals("A"))
			{
			if(((String)currRec.get("freq_code")).trim().equals(""))
				return false ;
			int applicableCount = frequencyRecStr.size();
				if (applicableCount > 0) {
					for (int j = 0; j < applicableCount; j++) {
						HashMap tempHash = (HashMap)frequencyRecStr.get(j);
						if(((String)tempHash.get("applicable_yn")).equals("Y"))
						{							if(((String)currRec.get("freq_code")).equals((String)tempHash.get("frequency_code"))){
								flag=true;
								break;
							}
						}
						//tempHash.clear();
					}
				}
				if(flag==false)
					return false;
		}else
			flag=true;
		//currRec.clear();
		}
	}
}catch (Exception e){
	e.printStackTrace();
}

return flag;
}
/************************CHK Freq- Req******************************/
/*****private boolean chkFreqRequired(){


	int size =  settingsRecStr.size();

	int sizeCharacteristic	=characteristicsRecStr.size();

	if(size == 0)
	return true;

	if(sizeCharacteristic == 0)
	return true;

	HashMap ht             = (HashMap)characteristicsRecStr.get(0);
	String freq_applicable_yn  = (String)ht.get("freq_applicable_yn");


	if(!freq_applicable_yn.trim().equalsIgnoreCase("Y"))
		return true ;
	String freq_code="";
	String setting_applicability="";
	for (int i = 0 ; i < size ; i++ ){
		HashMap currRec	  =	(HashMap)settingsRecStr.get(i);


		freq_code = (String)currRec.get("freq_code");
		setting_applicability = (String)currRec.get("setting_applicability");
		if(setting_applicability.trim().equals("A")){
			if(freq_code.trim().equals(""))
				return false ;
		}

	}

	return  true ;

}*****/

/************************CHK Quantity Req******************************/
private boolean chkQtyReqd(){
	int size =  settingsRecStr.size();
	int sizeCharacteristic	=characteristicsRecStr.size();

	if(size == 0)
	return true;

	if(sizeCharacteristic == 0)
	return true;

	HashMap ht					 = (HashMap)characteristicsRecStr.get(0);
	String qty_reqd_yn           = (String)ht.get("qty_reqd_yn");

	if(!qty_reqd_yn.trim().equalsIgnoreCase("Y"))
		return true ;
	String qty_value="";
	String setting_applicability="";
	//HashMap currRec=new HashMap();
	for (int i = 0 ; i < size ; i++ ){
		HashMap currRec				 = (HashMap)settingsRecStr.get(i);
			qty_value			 = (String)currRec.get("qty_value");
		 setting_applicability = (String)currRec.get("setting_applicability");

		if(setting_applicability.trim().equals("A"))
			if(qty_value.trim().equals(""))
				return false ;
		//currRec.clear();
	}

	return  true ;

}
/********************************************************************************************/
private boolean chkActivityType(ArrayList store, int position , String key ,  String keyVal , String mandatory ) throws Exception{

	int size =  store.size();

	if(size == 0)
	return true;

	if(size < position )
		throw new Exception("Chk position passed and the size of Store") ;


	HashMap currRec = (HashMap)store.get(position);

	if(!(currRec.containsKey( key.trim() ))) //key should be there
		return true ;

	String currKeyVal = (String)currRec.get(key.trim()) ;



	if(currKeyVal.trim().equalsIgnoreCase(keyVal.trim())){
		if(mandatory.trim().equalsIgnoreCase(""))
			return false ;
	}else{
			return true;
	}


	return true ;

}
/*********************METHOD TO SET ALL THE FEILDS AT ONCE*************************/
 public void setAll( Hashtable recordSet ) {

    this.mode = (String)recordSet.get("mode");



    if(recordSet.containsKey("order_catalog_code"))
		 orderCatalogHeaderStr.put("order_catalog_code",(String)recordSet.get("order_catalog_code"));
	if(recordSet.containsKey("long_desc"))
		 orderCatalogHeaderStr.put("long_desc",(String)recordSet.get("long_desc"));
	if(recordSet.containsKey("short_desc"))
		 orderCatalogHeaderStr.put("short_desc",(String)recordSet.get("short_desc"));
	if(recordSet.containsKey("order_category"))
		 orderCatalogHeaderStr.put("order_category",(String)recordSet.get("order_category"));
	if(recordSet.containsKey("order_type_code"))
		 orderCatalogHeaderStr.put("order_type_code",checkForNull((String)recordSet.get("order_type_code")));
	if(recordSet.containsKey("activity_type"))
		 orderCatalogHeaderStr.put("activity_type",checkForNull((String)recordSet.get("activity_type")));
	if(recordSet.containsKey("image_link_id"))
		 orderCatalogHeaderStr.put("image_link_id",checkForNull((String)recordSet.get("image_link_id")));
	if(recordSet.containsKey("indexed_yn"))
		 orderCatalogHeaderStr.put("indexed_yn",checkForNull((String)recordSet.get("indexed_yn"),"N"));

	if(recordSet.containsKey("security_level"))
		 orderCatalogHeaderStr.put("security_level",checkForNull((String)recordSet.get("security_level")));
	if(recordSet.containsKey("eff_status"))
		 orderCatalogHeaderStr.put("eff_status", checkForNull((String)recordSet.get("eff_status"),"D"));
	if(recordSet.containsKey("hidLinkedVaccineId"))
	 {
		 orderCatalogHeaderStr.put("linked_vaccine_id", checkForNull((String)recordSet.get("hidLinkedVaccineId"),""));
	 }
	//IN068926
	if(recordSet.containsKey("tpn_item_yn"))
	 {
		 orderCatalogHeaderStr.put("tpn_item_yn", checkForNull((String)recordSet.get("tpn_item_yn"),""));
	 }
	//IN068926

	 //IN068370,IN068373, starts
	 if("Y".equals(getGlobalFacilityYn()) && recordSet.containsKey("appl_fac_id"))
	 {
		String l_fac_ids = checkForNull((String)recordSet.get("appl_fac_id"),"");
		
		if(!"".equals(l_fac_ids))
		{
			String l_ind_fac_ids[] = l_fac_ids.split("~");
			orderCatalogHeaderStr.put("appl_fac_id",l_ind_fac_ids);
		}
	 }
	 //IN068370,IN068373, ends
}

/*********************METHOD TO Reset the Class variable*************************/

	public void clear() {
	   //super.clear() ;
	}

/*********************METHOD TO Insert*************************/

public synchronized HashMap insert(){
try{

	HashMap map = new HashMap() ;
	HashMap sqlMap = new HashMap();
	map.put( "result", new Boolean( false ) ) ;
	HashMap recordStoreParam = new HashMap() ;
	Boolean isOrderCatalogFacWise = isSiteSpecific("ORDER_CATALOG_FAC_WISE");//IN068370,IN068373
	defaultInitailiseStr();


	recordStoreParam.put("CatalogHeader"	,orderCatalogHeaderStr);
	recordStoreParam.put("Characterstics"	,characteristicsRecStr);



	if (prepRecStr.size() == 0) {
	   HashMap dummyHashMap = new HashMap();
	   prepRecStr.add(dummyHashMap);
	}

	if(frequencyRecStr.isEmpty() && mode.equals("1")){
	String OrderCategory=((String)orderCatalogHeaderStr.get("order_category")).trim();
	String OrderCatalogCode=((String)orderCatalogHeaderStr.get("order_catalog_code")).trim();
	frequencyDefault(mode,OrderCategory,OrderCatalogCode);


}

	recordStoreParam.put("Prep"	            ,prepRecStr);
	recordStoreParam.put("Frequency"		,frequencyRecStr);
	recordStoreParam.put("Reviews"			,reviewsRecStr);
	recordStoreParam.put("Settings"			,settingsRecStr);
	recordStoreParam.put("InstructionClobTemp",getInstructionsRecStrClob());//ML-MMOH-SCF-1108
	recordStoreParam.put("Instructions"		,instructionsRecStr);
	recordStoreParam.put("MappedFacilities",mappedFacilities);//IN068370,IN068373
	recordStoreParam.put("GlobalFacilityYn",getGlobalFacilityYn());//IN068370,IN068373
	recordStoreParam.put("SiteSpecGlobalFac", isOrderCatalogFacWise);//IN068370,IN068373


	if (turnAroundRecStr.size() == 0) {
	   HashMap dummyHashMap = new HashMap();
	   turnAroundRecStr.add(dummyHashMap);
	}
    recordStoreParam.put("TurnAround"		,turnAroundRecStr);

	recordStoreParam.put("login_by_id" , login_by_id) ;
	recordStoreParam.put("login_at_ws_no" , login_at_ws_no ) ;
	recordStoreParam.put("login_facility_id" , login_facility_id ) ;



    ArrayList insertArrList = new ArrayList();
	ArrayList deleteArrList = new ArrayList();

    ArrayList allRecords = multiRecBean.getAllDBRecords();
    HashMap split = new HashMap();
    String valid = "";
    String associate_yn = "";

	//debug += "Before allRecords:"+allRecords.size();


	for(int j=0;j<allRecords.size();j++){

		split			= (HashMap)allRecords.get(j);
		valid			= (String) split.get("valid");
		associate_yn	= (String) split.get("associate_yn");

		if(valid.equals("Y")){
			if(associate_yn.equals("D")){
				deleteArrList.add(split);
			}
		}else if(valid.equals("N")){
			if(associate_yn.equals("Y")){

				insertArrList.add(split);
			}
		}

	}

	recordStoreParam.put("PrepDetail"	,insertArrList);
	recordStoreParam.put("DeletePrepDetail"	,deleteArrList);

	sqlMap.put("SQL_OR_CATALOG_DUP_CHK"				,OrRepository.getOrKeyValue("SQL_OR_CATALOG_DUP_CHK"));
	sqlMap.put("SQL_OR_CATALOG_INSERT"				,OrRepository.getOrKeyValue("SQL_OR_CATALOG_INSERT"));
	sqlMap.put("SQL_OR_CATALOG_INSERT_BY_TYPE"		,OrRepository.getOrKeyValue("SQL_OR_CATALOG_INSERT_BY_TYPE"));
	sqlMap.put("SQL_OR_CATALOG_INSERT_SYNONYM"		,OrRepository.getOrKeyValue("SQL_OR_CATALOG_INSERT_SYNONYM"));
	sqlMap.put("SQL_OR_CATALOG_INSERT_BY_PTCL"		,OrRepository.getOrKeyValue("SQL_OR_CATALOG_INSERT_BY_PTCL"));
	sqlMap.put("SQL_OR_CATALOG_INSERT_PREPS_INSTRN" ,OrRepository.getOrKeyValue("SQL_OR_CATALOG_INSERT_PREPS_INSTRN"));
	sqlMap.put("SQL_OR_CATALOG_FORMAT_ID1"			,OrRepository.getOrKeyValue("SQL_OR_CATALOG_FORMAT_ID1"));
	sqlMap.put("SQL_OR_CATALOG_FORMAT_ID2"			,OrRepository.getOrKeyValue("SQL_OR_CATALOG_FORMAT_ID2"));
	sqlMap.put("SQL_OR_CATALOG_FREQUENCY_INSERT"	,OrRepository.getOrKeyValue("SQL_OR_CATALOG_FREQUENCY_INSERT"));
	sqlMap.put("SQL_OR_ORDER_CATALOG_SEC_TASKS_INSERT"	,OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_SEC_TASKS_INSERT"));
	sqlMap.put("SQL_OR_ORDER_CATALOG_SEC_TASKS_DELETE"	,OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_SEC_TASKS_DELETE"));	
	sqlMap.put("SQL_OR_CATALOG_INSERT_UPDATE_INSTRN_CLOB_PR_DR_IS"	,OrRepository.getOrKeyValue("SQL_OR_CATALOG_INSERT_UPDATE_INSTRN_CLOB_PR_DR_IS"));//IN64543
	sqlMap.put("SQL_OR_CATALOG_INSERT_UPDATE_INSTRN_CLOB_IM"	,OrRepository.getOrKeyValue("SQL_OR_CATALOG_INSERT_UPDATE_INSTRN_CLOB_IM"));//IN64543
	//IN068370,IN068373, starts
	if("Y".equals(getGlobalFacilityYn()) && isOrderCatalogFacWise)
	{
		sqlMap.put("SQL_OR_CATALOG_BY_FACILITY_INSERT", OrRepository.getOrKeyValue("SQL_OR_CATALOG_BY_FACILITY_INSERT"));
		sqlMap.put("SQL_OR_CATALOG_BY_FACILITY_DELETE", OrRepository.getOrKeyValue("SQL_OR_CATALOG_BY_FACILITY_DELETE"));
	}
	//IN068370,IN068373, ends
	return getResult(recordStoreParam,sqlMap );

	}catch(Exception e){
//		tempChk += e.getMessage();
		logErrorMessage(e);
		return null;
	}


}

public void defaultLoadFrequency(String Code) {

    Connection connection	= null ;
    PreparedStatement pstmt     = null ;
    ResultSet rs		= null;
   // ResultSetMetaData rsmd	= null ;
   // String 	columnName	= null ;
   // int 	columnCount	= -1 ;

    try
    {
            frequencyRecStr.clear();
            connection = getConnection();

            //String sql = OrRepository.getOrKeyValue("SQL_OR_CATALOG_FREQUENCY_MODIFY_SELECT");//IN062992
			String sql = "SELECT A.FREQ_CODE FREQ_CODE,FREQ_DESC ,'Y' APPLICABLE_YN,B.FREQ_NATURE FREQ_NATURE FROM OR_FREQ_CATALOG_SCOPE A,AM_FREQUENCY B WHERE A.FREQ_CODE IN (SELECT FREQ_CODE FROM OR_FREQUENCY_SCOPE WHERE ORDER_cATEGORY = ?  and freq_scope_yn ='Y') AND A.FREQ_CODE = B.FREQ_CODE AND A.ORDER_CATALOG_CODE = ? AND B.EFF_STATUS = 'E' UNION SELECT A.FREQ_CODE FREQ_CODE,FREQ_DESC ,'N' APPLICABLE_YN  FROM OR_FREQUENCY_SCOPE A, AM_FREQUENCY B WHERE ORDER_cATEGORY = ? AND A.FREQ_CODE = B.FREQ_CODE  and freq_scope_yn ='Y' AND B.EFF_STATUS = 'E' AND A.FREQ_CODE NOT IN (SELECT FREQ_CODE FROM OR_FREQ_CATALOG_SCOPE WHERE FREQ_CODE =A.FREQ_CODE  AND ORDER_CATALOG_CODE = ?)";//IN062992
            pstmt	   = connection.prepareStatement(sql);
            pstmt.setString(1, Code.trim());
            pstmt.setString(2, Code.trim());

            rs		   = pstmt.executeQuery()  ;
            //rsmd	   = rs.getMetaData()      ;
           // columnCount= rsmd.getColumnCount() ;
            int counter= 0 ;

            while (rs.next()){
				HashMap result = new HashMap();
                //Note keys are converted into lower case

                result.put("frequency_code",ChkDef.defaultString(rs.getString("freq_code")));
                result.put("frequency_desc",ChkDef.defaultString(rs.getString("freq_desc")));
                result.put("applicable_yn",ChkDef.defaultString(rs.getString("applicable_yn")).trim());
                result.put("freq_nature",ChkDef.defaultString(rs.getString("FREQ_NATURE")).trim());//IN062992
				frequencyRecStr.add(result);
                counter++;
				//result.clear();
            }
    }catch(Exception e){
		e.printStackTrace();
    }finally{
            try{
                    closeResultSet( rs ) ;
                    closeStatement( pstmt ) ;
                    closeConnection(connection);
             }catch(Exception e){e.printStackTrace() ;}
    }
}

/************************LOAD DATA FOR UPDATION*****************************/
public void defaultLoadForUpdation(String[] Code){
try{


    String order_catalog_code      = Code[0];

		//String code_p[]			={order_catalog_code,order_catalog_code};
        //Hashtable ht_frequency = getSqlResultParamLoad("SQL_OR_CATALOG_FREQUENCY_MODIFY_SELECT",code_p,-1);

		//frequencySync(ht_frequency,"updation");
    //defaultLoadFrequency(order_catalog_code);

        Hashtable ht_catalog =	getSqlResultParamLoad("SQL_OR_CATALOG_LOAD_CATALOG",Code,-1);
        
        ht_catalog.put("instrn_content_type",checkForNull((String)ht_catalog.get("instrn_content_type"),"T"));//IN64543
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

		//Synonms
		Hashtable ht_syn	 =	getSqlResultParamLoad("SQL_OR_CATALOG_LOAD_CATALOG_BY_SYNONYM",Code,1);
		Integer	size_syn_obj = (Integer)ht_syn.get("noRec") ;
		int size_syn		 =  size_syn_obj.intValue();
			String Str1="";
			String Str2="";

			String syn_type="";
			String syn_desc="";

		for (int i = 1; i <= size_syn ; i++){


		  Str1 = 	"catalog_synonym_type"+ i ;
 		  Str2 = 	"catalog_synonym"+ i ;

 		  syn_type = (String)ht_syn.get(Str1.trim());
		  syn_desc = (String)ht_syn.get(Str2.trim());

			if(syn_type.trim().equalsIgnoreCase("PR")){
				ht_catalog.put("catalog_synonym_primary",syn_desc);
				ht_catalog.put("effective_status_primary","Y");
			}

			if(syn_type.trim().equalsIgnoreCase("DC")){
				ht_catalog.put("catalog_synonym_directCare",syn_desc);
				ht_catalog.put("effective_status_directCare","Y");
			}

			if(syn_type.trim().equalsIgnoreCase("AD")){
				ht_catalog.put("catalog_synonym_ancillaryDept",syn_desc);
				ht_catalog.put("effective_status_ancillaryDept","Y");
			}

		}

//			tempChk ="ht_catalog="+ht_catalog;

			//This is because of spelling mismatch
			ht_catalog.put("contineous_freq_order",checkForNull((String)ht_catalog.get("continuous_freq_order"))) ;

			ht_catalog.put("refusal_form_id",checkForNull((String)ht_catalog.get("refusal_form_id"))) ;

            ht_catalog.put("priority_appl",checkForNull((String)ht_catalog.get("priority_appl"))) ;


			//TO get Discrete Measure Desc form DicreteMeasure Id form Catalog
			String[] discr_msr_panel_id_param = {checkForNull((String)ht_catalog.get("discr_msr_panel_id"))};

			Hashtable ht_discr_mesr =getSqlResultParamLoad("SQL_OR_CATALOG_LOAD_DISCRETE_MEASURE",discr_msr_panel_id_param,-1);

			/*else if(chart_result_type.equals("N")){
			ht_discr_mesr =getSqlResultParamLoad("SQL_OR_CATALOG_LOAD_NOTE",discr_msr_panel_id_param,-1);
			}else if(chart_result_type.equals("M")){
			Hashtable ht_discr_mesr =getSqlResultParamLoad("SQL_OR_CATALOG_LOAD_DISCRETE_MEASURE",discr_msr_panel_id_param,-1);
			}*/
//if(ht_discr_mesr!=null){
			Integer	size = (Integer)ht_discr_mesr.get("noRec") ;
			int size_discr	 =  size.intValue();

			if(size_discr != 0){
				ht_catalog.put("discr_msr_panel_id_desc",(String)ht_discr_mesr.get("short_desc")) ;



			}else
				ht_catalog.put("discr_msr_panel_id_desc","") ;
//}
			CharactersticsSync(ht_catalog);



			frequencyDefault(CommonRepository.getCommonKeyValue("MODE_MODIFY"),(String)orderCatalogHeaderStr.get("order_category"),order_catalog_code);

			instrnsLoad(Code,ht_catalog);//Load the instruction table

			fetchDBRecords(order_catalog_code);

			turnAroundSync(ht_catalog);

			fetchMappedFacilities(order_catalog_code);//IN068370,IN068373		


}catch (Exception e){

		logErrorMessage(e);
	}
}

/*********************LOAD INSTRUCTION for Updation****************************/


private void instrnsLoad(String[] Code , Hashtable catalog){
try
{

	String prompt_alert_yn	 = checkForNull((String)catalog.get("prompt_alert_yn"));
	String prompt_alert_msg	 = checkForNull((String)catalog.get("prompt_alert_msg"));
	String appt_reqd_yn		 = checkForNull((String)catalog.get("appt_reqd_yn"));
	String routine_appt_reqd_yn		 = checkForNull((String)catalog.get("routine_appt_reqd_yn"));
	String urgent_appt_reqd_yn		 = checkForNull((String)catalog.get("urgent_appt_reqd_yn"));
	String stat_appt_reqd_yn		 = checkForNull((String)catalog.get("stat_appt_reqd_yn"));
	String appt_prep_time		 = checkForNull((String)catalog.get("appt_prep_time"));
	String appt_prep_time_type		 = checkForNull((String)catalog.get("appt_prep_time_type"));
	String appt_action_for_prep		 = checkForNull((String)catalog.get("appt_action_for_prep"));
	String clin_cmts_reqd_yn		 = checkForNull((String)catalog.get("clin_cmts_reqd_yn"));
	String splty_speci_reqd_yn		 = checkForNull((String)catalog.get("splty_speci_reqd_yn"));
	String pri_splty_code		 = checkForNull((String)catalog.get("pri_splty_code"));
	String follow_visit_type_yn		= checkForNull((String)catalog.get("follow_visit_type_yn")); // added for IN031304
	String invoke_instrn_window_yn		 = checkForNull((String)catalog.get("invoke_instrn_window_yn"));//IN064543
	String instrn_content_type		= checkForNull((String)catalog.get("instrn_content_type"),"T");//IN64543

	String  appt_time		 = checkForNull((String)catalog.get("appt_time"));

	if(!(appt_time.equals("")))
    appt_time				 = appt_time.substring(11,16) ;


	if(appt_time.trim().equals("00:00"))
			 appt_time = "";

	Hashtable ht_preps		 = getSqlResultParamLoad("SQL_OR_CATALOG_LOAD_CATALOG_BY_INSTRN_PD",Code,1);

//	tempChk = "ht_preps="+ht_preps.toString();

	Hashtable ht_others		 = getSqlResultParamLoad("SQL_OR_CATALOG_LOAD_CATALOG_BY_INSTRN_OTHER",Code,1);//Can have multiple records


//	tempChk = "";
//	tempChk = "ht_others="+ht_others.toString();
	
	String pat_preps_or_instrns_id  = "";//IN64543
	String pat_instrns_free_fmt_id = "";//IN64543

	//pat_preps_or_instrns_id = checkForNull((String)ht_others.get("pat_preps_or_instrns_ind1")); //One record would be always inserted//IN64543

	//This is make ht_preps hastable to be compatible to be passed as parameter the the instructionByAgeSync() method........
	ht_preps.put("pat_preps_or_instrns_id_pr","PR");
	ht_preps.put("pat_preps_or_instrns_id_dr","DR");

	/*ht_preps.put("pat_preps_or_instrns_txt_pr",checkForNull((String)ht_preps.get("pat_preps_or_instrns_txt2")));
    ht_preps.put("pat_preps_or_instrns_txt_dr",checkForNull((String)ht_preps.get("pat_preps_or_instrns_txt1")));
	*/
	//IN64543, starts
	if("T".equals(instrn_content_type))
	{
		ht_preps.put("pat_preps_or_instrns_txt_pr",checkForNull((String)ht_preps.get("pat_preps_or_instrns_txt2")));
		ht_preps.put("pat_preps_or_instrns_txt_dr",checkForNull((String)ht_preps.get("pat_preps_or_instrns_txt1"))); 
		pat_preps_or_instrns_id = checkForNull((String)ht_others.get("pat_preps_or_instrns_ind1"));
	} 
	else if("E".equals(instrn_content_type))
    {
		ht_preps.put("pat_preps_or_instrns_free_fmt_pr",checkForNull((String)ht_preps.get("pat_preps_or_instrns_free_fmt2")));
	    ht_preps.put("pat_preps_or_instrns_free_fmt_dr",checkForNull((String)ht_preps.get("pat_preps_or_instrns_free_fmt1")));
	    //ML-MMOH-SCF-1108 start 
	    HashMap dum = new HashMap();
	    dum.put("pat_preps_or_instrns_free_fmt_pr",checkForNull((String)ht_preps.get("pat_preps_or_instrns_free_fmt2")));
	    dum.put("pat_preps_or_instrns_free_fmt_dr",checkForNull((String)ht_preps.get("pat_preps_or_instrns_free_fmt1")));
	    
	    map.put("pat_preps_or_instrns_free_fmt_pr",checkForNull((String)ht_preps.get("pat_preps_or_instrns_free_fmt2")));
	    map.put("pat_preps_or_instrns_free_fmt_dr",checkForNull((String)ht_preps.get("pat_preps_or_instrns_free_fmt1")));
	  // ML-MMOH-SCF-1108 end
	    pat_instrns_free_fmt_id = checkForNull((String)ht_others.get("pat_preps_or_instrns_ind1"));
    }
    //IN64543, ends

	ht_preps.put("prompt_alert_yn"			,prompt_alert_yn.trim());
	ht_preps.put("prompt_alert_msg"			,prompt_alert_msg.trim());
	ht_preps.put("appt_reqd_yn"				,appt_reqd_yn.trim());
	ht_preps.put("follow_visit_type_yn"		,follow_visit_type_yn.trim()); // added for IN031304
	ht_preps.put("routine_appt_reqd_yn"				,routine_appt_reqd_yn.trim());

	ht_preps.put("urgent_appt_reqd_yn"				,urgent_appt_reqd_yn.trim());

	ht_preps.put("stat_appt_reqd_yn"				,stat_appt_reqd_yn.trim());

	ht_preps.put("appt_prep_time"				,appt_prep_time.trim());
	ht_preps.put("appt_prep_time_type"				,appt_prep_time_type.trim());
	ht_preps.put("appt_action_for_prep"				,appt_action_for_prep.trim());
	ht_preps.put("appt_time"				,appt_time.trim());
	
	
	//IN64543, starts
	//ht_preps.put("pat_preps_or_instrns_id"	,pat_preps_or_instrns_id.trim());
	if("T".equals(instrn_content_type.trim()))
	{
		ht_preps.put("pat_preps_or_instrns_id"	,pat_preps_or_instrns_id.trim());
	}
	else if("E".equals(instrn_content_type.trim()))
	{
		ht_preps.put("pat_instrns_free_fmt_id"	,pat_instrns_free_fmt_id.trim());
	}
	//IN64543, ends
	ht_preps.put("clin_cmts_reqd_yn"	,clin_cmts_reqd_yn.trim());
	ht_preps.put("splty_speci_reqd_yn"	,splty_speci_reqd_yn.trim());
	ht_preps.put("pri_splty_code"	,pri_splty_code.trim());
	ht_preps.put("follow_visit_type_yn", follow_visit_type_yn.trim());
	ht_preps.put("invoke_instrn_window_yn"	,invoke_instrn_window_yn.trim());//IN064543
	ht_preps.put("instrn_content_type", instrn_content_type.trim());//IN64543
	//ht_others.put("pat_preps_or_instrns_txt_is",checkForNull((String)ht_others.get("pat_preps_or_instrns_txt1")));
	
	/*if("T".equals(instrn_content_type.trim()))
	{
		ht_preps.put("pat_preps_or_instrns_txt_is",checkForNull((String)ht_others.get("pat_preps_or_instrns_txt1")));
		ht_preps.put("pat_preps_or_instrns_id"	,pat_preps_or_instrns_id.trim());
	}
	else
	{
		ht_preps.put("pat_preps_or_instrns_txt_is",checkForNull((String)ht_others.get("pat_preps_or_instrns_free_fmt1")));//IN64543
		ht_preps.put("pat_instrns_free_fmt_id"	,pat_preps_or_instrns_id.trim());
	}*/

	instructionSync(ht_preps);
	
	Integer	size_instrns_obj = (Integer)ht_others.get("noRec") ;
	int size_instrns		 =  size_instrns_obj.intValue();
	
	//IN64543, starts
	if("T".equals(instrn_content_type.trim()))
	{
		pat_preps_or_instrns_id = (String)ht_preps.get("pat_preps_or_instrns_id");
	}
	else if("E".equals(instrn_content_type.trim()))
	{
		pat_preps_or_instrns_id = (String)ht_preps.get("pat_instrns_free_fmt_id");
	}
	//IN64543, ends
	
	
	if(pat_preps_or_instrns_id.trim().equalsIgnoreCase("IS")){

	ht_others.put("instructionType","IS");
	
	ht_others.put("instrn_content_type",instrn_content_type.trim());
	
	ht_others.put("pat_preps_or_instrns_txt_is",checkForNull((String)ht_others.get("pat_preps_or_instrns_txt1")));
	ht_others.put("pat_preps_or_instrns_free_fmt_is",checkForNull((String)ht_others.get("pat_preps_or_instrns_free_fmt1")));//IN64543
	map.put("pat_preps_or_instrns_free_fmt_is",checkForNull((String)ht_others.get("pat_preps_or_instrns_free_fmt1")));//ML-MMOH-SCF-1108
	
	instructionByAgeSync(ht_others);
	}

	if(pat_preps_or_instrns_id.trim().equalsIgnoreCase("IM")){

		for (int i = 1; i <= size_instrns ; i++){
		Hashtable temp = new Hashtable() ;
		temp.put("instructionType"				,"IM");
		temp.put("min_age_in_days"				,checkForNull((String)ht_others.get("min_age_in_days"+i)))	;
		temp.put("min_age_in_mths"				,checkForNull((String)ht_others.get("min_age_in_mths"+i)));
		temp.put("min_age_in_yrs"				,checkForNull((String)ht_others.get("min_age_in_yrs"+i)));
		temp.put("max_age_in_days"				,checkForNull((String)ht_others.get("max_age_in_days"+i)));
		temp.put("max_age_in_mths"				,checkForNull((String)ht_others.get("max_age_in_mths"+i)));
		temp.put("max_age_in_yrs"				,checkForNull((String)ht_others.get("max_age_in_yrs"+i)));
		temp.put("sex_spec_ind"					,checkForNull((String)ht_others.get("sex_spec_ind"+i)));
//	    temp.put("pat_preps_or_instrns_txt_im"	,java.net.URLEncoder.encode(checkForNull((String)ht_others.get("pat_preps_or_instrns_txt"+i))));
		//temp.put("pat_preps_or_instrns_txt_im"	,checkForNull((String)ht_others.get("pat_preps_or_instrns_txt"+i)));
		
		//IN64543, starts
		if("T".equals(instrn_content_type.trim()))
			temp.put("pat_preps_or_instrns_txt_im"	,checkForNull((String)ht_others.get("pat_preps_or_instrns_txt"+i)));
		else if("E".equals(instrn_content_type.trim()))
			temp.put("pat_preps_or_instrns_free_fmt_im",checkForNull((String)ht_others.get("pat_preps_or_instrns_free_fmt"+i)));//IN64543(K)
		//IN64543, ends

		temp.put("index"						,"-1");//to add record
		temp.put("action"						, "");
		temp.put("instrn_content_type",instrn_content_type.trim());
		
		//ML-MMOH-SCF-1108 start
		HashMap tempIMRow = new HashMap() ;
		tempIMRow.put("instructionType"				,"IM");
		tempIMRow.put("min_age_in_days"				,checkForNull((String)ht_others.get("min_age_in_days"+i)))	;
		tempIMRow.put("min_age_in_mths"				,checkForNull((String)ht_others.get("min_age_in_mths"+i)));
		tempIMRow.put("min_age_in_yrs"				,checkForNull((String)ht_others.get("min_age_in_yrs"+i)));
		tempIMRow.put("max_age_in_days"				,checkForNull((String)ht_others.get("max_age_in_days"+i)));
		tempIMRow.put("max_age_in_mths"				,checkForNull((String)ht_others.get("max_age_in_mths"+i)));
		tempIMRow.put("max_age_in_yrs"				,checkForNull((String)ht_others.get("max_age_in_yrs"+i)));
		tempIMRow.put("sex_spec_ind"					,checkForNull((String)ht_others.get("sex_spec_ind"+i)));
		if("T".equals(instrn_content_type.trim()))
			tempIMRow.put("pat_preps_or_instrns_txt_im"	,checkForNull((String)ht_others.get("pat_preps_or_instrns_txt"+i)));
		else if("E".equals(instrn_content_type.trim()))
			tempIMRow.put("pat_preps_or_instrns_free_fmt_im",checkForNull((String)ht_others.get("pat_preps_or_instrns_free_fmt"+i)));//IN64543(K)
		

		tempIMRow.put("index"						,"-1");//to add record
		tempIMRow.put("action"						, "");
		
		
		tempIMRow.put("instrn_content_type",instrn_content_type.trim());
		setInstructionsRecStrClobLoad("pat_preps_or_instrns_free_fmt_im",tempIMRow);
		//ML-MMOH-SCF-1108 ends
		instructionByAgeSync(temp);
	}

}



}catch (Exception e){

	logErrorMessage(e);

}



}

/*************************just get the result as Hash table for UPdation***************/
public  Hashtable getSqlResultParamLoad(String key , String[] params ,int indStart) throws Exception{
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
	String l_col_type = "";

	while (rs.next()){

		counter++;
		for(int i = 1; i <= columnCount ; i++){
				columnName	= rsmd.getColumnName(i)  ;

			//Note keys are converted into lower case
			if(indStart == -1 )
				result.put((columnName.toLowerCase()),ChkDef.defaultString(rs.getString(columnName)));
			else
			{
				if ("CLOB".equals(l_col_type)) {
					StringBuffer sbSecFormat = new StringBuffer();

					Clob clb = rs.getClob(columnName);

					if (clb != null) {
						java.io.BufferedReader r = new java.io.BufferedReader(
								clb.getCharacterStream());
						String line = null;

						while ((line = r.readLine()) != null) {
							sbSecFormat.append(line);
						}
					}

					result.put(((columnName.toLowerCase() + counter)
							.trim()), sbSecFormat.toString());
				} 
				else
					result.put(((columnName.toLowerCase()+counter).trim()),ChkDef.defaultString(rs.getString(columnName)));				
			}
		}

	}
	result.put("noRec",new Integer(counter));


	return result ;
}catch(Exception e){
	throw new Exception(e.getMessage());
}finally{
	try{
		closeResultSet( rs ) ;
  		closeStatement( pstmt ) ;
		closeConnection(connection);
	 }catch(Exception e){e.printStackTrace() ;}
}

}

/**********This Method  Actually Calls the EJB's Method ********************/
 private  HashMap getResult(HashMap record , HashMap sqlMap ) {


	HashMap map  = new HashMap() ;
	try
		{

			/*InitialContext context = new InitialContext();
			Object object		   = context.lookup(OrRepository.getOrKeyValue("OR_CATALOG_JNDI"));
			OROrderCatalogHome home  = (OROrderCatalogHome) PortableRemoteObject.narrow( object,OROrderCatalogHome.class );
			OROrderCatalogRemote remote = home.create() ;*/
		  Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("OR_CATALOG_JNDI"), OROrderCatalogHome.class, getLocalEJB());
    	  Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		//	OROrderCatalogManager remote = new 	 OROrderCatalogManager();
			HashMap tabDataParam =  new HashMap() ;
			tabDataParam.put( "properties", getProperties() );
			tabDataParam.put( "tabData",     record );

		  Object argArray[]	= new Object[2];
			argArray[0]		= tabDataParam;
			argArray[1]		= sqlMap;
 		  Class [] paramArray = new Class[2];
 		 	paramArray[0]	= tabDataParam.getClass();
			paramArray[1]	= sqlMap.getClass();



			if(mode.equals(CommonRepository.getCommonKeyValue("MODE_DELETE"))){

				return null ;
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {

			 //map = remote.insert(tabDataParam, sqlMap ) ;
			  map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){

			//map = remote.modify(tabDataParam, sqlMap )    ;
			map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
		//	map = modify(tabDataParam, sqlMap )    ;
			}

		  (busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		  argArray		= null;
		  paramArray	= null;
if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}else{
					//map.put( "message", ((String) map.get("msgid"))) ;

					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "Common")) ;
				}



      //map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
			//return map;

	 }catch(Exception e){

		map.put( "message", e.getMessage() );
		e.printStackTrace() ;

	}

     return map ;
 }//End of Method

/******************Default Intailise the str'sx if tab not visted ***************/
private void defaultInitailiseStr(){

//Default Intialise only if store's are is empty

Hashtable def = new Hashtable();

	if(characteristicsRecStr.isEmpty()){
		def.put("catalog_synonym_type" ,"PR");
		def.put("catalog_synonym_primary",(String)orderCatalogHeaderStr.get("short_desc"));
		def.put("effective_status_primary","Y");
		CharactersticsSync(def);
		def.clear() ;
	}

	if(reviewsRecStr.isEmpty()){
		def.put("patient_class0" ,"*A");
		def.put("setting_applicability0","A");
		def.put("noOfRecords","0");
		reviewsSync(def);
		def.clear() ;
	}

	if(settingsRecStr.isEmpty()){
		def.put("patient_class0" ,"*A");
		def.put("setting_applicability0","A");
		def.put("noOfRecords","0");
		settingsSync(def);
		def.clear() ;
	}


	if(instructionsRecStr.isEmpty()){
		String orderCat=(String)orderCatalogHeaderStr.get("order_category");
		if(orderCat.equals("OH"))
		{
		def.put("appt_reqd_yn","Y");
		def.put("routine_appt_reqd_yn","Y");
		def.put("urgent_appt_reqd_yn","Y");
		def.put("stat_appt_reqd_yn","Y");
		}
		def.put("pat_preps_or_instrns_id_pr" ,"PR");
		def.put("pat_preps_or_instrns_txt_pr","");
		def.put("pat_preps_or_instrns_id_dr" ,"DR");
		def.put("pat_preps_or_instrns_txt_dr","");
		def.put("pat_preps_or_instrns_id","IS");
		def.put("instrn_content_type","T");//IN64543
		//IN64543, starts
		def.put("pat_preps_or_instrns_free_fmt_pr","");
		def.put("pat_preps_or_instrns_free_fmt_dr","");
		def.put("pat_preps_or_instrns_free_fmt_is","");
		//IN64543, ends
		instructionSync(def);
		def.clear() ;
	}

}
/*********************METHOD TO Update*************************/

public synchronized HashMap modify(){
try{


	HashMap map = new HashMap() ;
	HashMap sqlMap = new HashMap();
	Boolean isOrderCatalogFacWise = isSiteSpecific("ORDER_CATALOG_FAC_WISE");//IN068370,IN068373
	StringBuffer traceVal =  new  StringBuffer();
	map.put( "result", new Boolean( false ) ) ;
	HashMap recordStoreParam = new HashMap() ;


	recordStoreParam.put("CatalogHeader"	,orderCatalogHeaderStr);
	recordStoreParam.put("Characterstics"	,characteristicsRecStr);
	
	recordStoreParam.put("Prep"	            ,prepRecStr);
	if (turnAroundRecStr.size() == 0)
	{
	   HashMap dummyHashMap = new HashMap();
	   turnAroundRecStr.add(dummyHashMap);
	}
    recordStoreParam.put("TurnAround"		,turnAroundRecStr);


	ArrayList insertArrList = new ArrayList();
	ArrayList deleteArrList = new ArrayList();


    ArrayList allRecords = multiRecBean.getAllDBRecords();

    HashMap split = new HashMap();
    String valid = "";
    String associate_yn = "";

	for(int j=0;j<allRecords.size();j++)
	{

		split			= (HashMap)allRecords.get(j);

		//if (split.get("pri_sec_tasks_type")!=null)
		//{
		valid			= (String) split.get("valid");
		associate_yn	= (String) split.get("associate_yn");

		if(valid.equals("Y"))
		{
			if(associate_yn.equals("D"))
			{
				deleteArrList.add(split);
			} else if (associate_yn.equals("Y"))
			{

			    insertArrList.add(split);
			}
		}else if(valid.equals("N"))
		{
			if(associate_yn.equals("Y"))
			{

				insertArrList.add(split);
			}
		}
	//}
	}
	//}catch(Exception e){}


	recordStoreParam.put("PrepDetail"	,insertArrList);
	recordStoreParam.put("DeletePrepDetail"	,deleteArrList);
//try{
	if(reviewsRecStr.isEmpty())
	{//That means there is no  visit to  this page (Tab)
	//Fill the records in the store as if there is visted to the page
		 traceVal.append("inside");
		 String order_catalog_code = (String)orderCatalogHeaderStr.get("order_catalog_code");

		 String sqlParam[]  = {order_catalog_code.trim()};
		 Hashtable defVal =		reviewsDefault("SQL_OR_CATALOG_LOAD_CATALOG_BY_PTCL","update",sqlParam);


		 HashMap pat_class =	getSqlResult("SQL_OR_PATIENT_CLASS_LIST");

		 Integer	noOfRecordsTemp = (Integer)pat_class.get("noRec");
		 int noOfRecords	  = noOfRecordsTemp.intValue() ;

		 int fm_disp		  = 0 ;
		 int to_disp		  = noOfRecords  ;

		 Hashtable   dummpPage=  new  Hashtable();

		 traceVal.append("noOfRecords"+noOfRecords);
		 if(noOfRecords != 0)
		{
 			dummpPage.put("noOfRecords",String.valueOf(noOfRecords));
			String 	patient_class	= "";

			 for(int i=fm_disp ; i <= to_disp; i++)
			{

				patient_class	= "";
				boolean contVal			= false ;

				if(i==0)
				{

					contVal =true ;//always the all patient class(*A)  will  be present in the DataBase
					patient_class = "*A";
				}
				else
				{
					patient_class  = (String)pat_class.get("PATIENT_CLASS"+i);
					contVal = defVal.containsKey(patient_class.trim()) ;
				}


				if(contVal)
				{//Value form the DataBase
					if(i==0 && defVal.size()==0)
					{
 							 dummpPage.put("ord_auth_level"			,"");
							 dummpPage.put("ord_spl_appr_level"		,"");
							 dummpPage.put("patient_class"+i		,patient_class);
							 dummpPage.put("setting_applicability"+i,"X");
							 dummpPage.put("ord_auth_reqd_yn"+i		,"N");
							 dummpPage.put("ord_cosign_reqd_yn"+i	,"N");
							 dummpPage.put("ord_spl_appr_reqd_yn"+i	,"N");
					}
					else
					{
						if((!defVal.containsKey(patient_class.trim()))&&(i==0)&& (defVal.size()>0))
						{
						}
						else
						{
							HashMap currRec					=(HashMap)defVal.get(patient_class.trim());

							//if(currRec.size()!=0){
							String setting_applicability_default   =(String)currRec.get("setting_applicability");
							if(setting_applicability_default.trim().equalsIgnoreCase("A"))
							{
								dummpPage.put("ord_auth_level"			,"");
								dummpPage.put("ord_spl_appr_level"		,"");
								dummpPage.put("patient_class"+i			,patient_class);
								dummpPage.put("setting_applicability"+i	,setting_applicability_default);
								dummpPage.put("ord_auth_reqd_yn"+i		,(String)currRec.get("ord_auth_reqd_yn"));
								dummpPage.put("ord_cosign_reqd_yn"+i	,(String)currRec.get("ord_cosign_reqd_yn"));
								dummpPage.put("ord_spl_appr_reqd_yn"+i	,(String)currRec.get("ord_spl_appr_reqd_yn"));
								dummpPage.put("skip_auth"+i	,(String)currRec.get("skip_auth"));//IN048467
								continue ;
							}
				//}
						}
					}
				 }


				 dummpPage.put("ord_auth_level"			,"");
				 dummpPage.put("ord_spl_appr_level"		,"");
				 dummpPage.put("patient_class"+i		,patient_class);
				 dummpPage.put("setting_applicability"+i,"X");
				 dummpPage.put("ord_auth_reqd_yn"+i		,"N");
				 dummpPage.put("ord_cosign_reqd_yn"+i	,"N");
				 dummpPage.put("ord_spl_appr_reqd_yn"+i	,"N");

			}
		  }


				traceVal.append("dummpPage"+dummpPage.toString());
				reviewsSync(dummpPage)		;//Syn with dummy Page
	}
//}catch(Exception e){}


	recordStoreParam.put("Reviews"			,reviewsRecStr);



//try{
	if(settingsRecStr.isEmpty()){//That means there is no  visit to  this page (Tab)
	//Fill the records in the store as if there is visted to the page


		Hashtable   dummpPageSettings=  new  Hashtable();
		String order_catalog_code =
		(String)orderCatalogHeaderStr.get("order_catalog_code");
		 String sqlParam[]  = {order_catalog_code.trim()};

		 Hashtable defVal1 = settingsDefault("SQL_OR_CATALOG_LOAD_CATALOG_BY_SETTINGS","update",sqlParam);



		 /********* String OrderCategory=((String)orderCatalogHeaderStr.get("order_category")).trim();
		 String OrderCatalogCode=((String)orderCatalogHeaderStr.get("order_catalog_code")).trim();
		 setSettingsFreqStr(OrderCategory,OrderCatalogCode);
		 settingsFreqStr		 = getSettingsFreqStr();
		*/

		 HashMap pat_class		 =	getSqlResult("SQL_OR_PATIENT_CLASS_LIST");

		 Integer noOfRecordsTemp = (Integer)pat_class.get("noRec");
		 int noOfRecords1		 = noOfRecordsTemp.intValue() ;
		 int fm_disp1			 = 0 ;
		 int to_disp1			 = noOfRecords1 ;


		 if(noOfRecords1!= 0){
			dummpPageSettings.put("noOfRecords",String.valueOf(noOfRecords1));
			String 	patient_class	= "";
			//HashMap currRecSettings	=new HashMap();
			 for(int k=fm_disp1; k<= to_disp1;k++){

				patient_class	= "";
				boolean contVal			= false ;
				//*****boolean flag1=true;

				if(k==0){

					contVal =true ;//always the all patient class(*A)  will  be present in the DataBase
					patient_class = "*A";
				}else{
					patient_class  = (String)pat_class.get("PATIENT_CLASS"+k);
					contVal = defVal1.containsKey(patient_class.trim()) ;
				}

					traceVal.append("defVal1="+defVal1.toString());
				if(contVal){//Value form the DataBase
					if(k==0 && defVal1.size()==0){

						dummpPageSettings.put("patient_class"+k			,patient_class.trim());
						dummpPageSettings.put("setting_applicability"+k		,"X");
						dummpPageSettings.put("age_group_code"+k			,"");
						dummpPageSettings.put("qty_value"+k					,"0");
						dummpPageSettings.put("qty_uom"+k					,"");
						dummpPageSettings.put("freq_code"+k					,"");
						dummpPageSettings.put("durn_value"+k				,"0");
						dummpPageSettings.put("durn_type"+k					,"");
						dummpPageSettings.put("durn_desc"+k					,"");
						dummpPageSettings.put("max_durn_type"+k			,"");
						dummpPageSettings.put("max_durn_value"+k			,"0");
						dummpPageSettings.put("chk_for_max_durn_action"+k	,"");
						dummpPageSettings.put("ord_auth_level"+k			,"");
						dummpPageSettings.put("prompt_msg"+k				,"");

					}
					else
					{
						if((!defVal1.containsKey(patient_class.trim()))&&(k==0)&& (defVal1.size()>0))
						{
						}
						else
						{

							HashMap currRecSettings			=(HashMap)defVal1.get(patient_class.trim());


							//if(currRecSettings.size()!=0){
							String setting_applicability_default   =(String)currRecSettings.get("setting_applicability");
							if(setting_applicability_default.trim().equalsIgnoreCase("A")){
										/***********/
								/****Integer	noOfRecTemp				 = (Integer)settingsFreqStr.get("noRec");

							int noOfRecordsFreq				 = noOfRecTemp.intValue() ;****/

					/*
									   */
				/**************	if(noOfRecordsFreq != 0){

						for(int i=0;i<noOfRecordsFreq;i++){
								int applicableCount = frequencyRecStr.size();

								if (applicableCount > 0) {
									for (int j = 0; j < applicableCount; j++) {

										HashMap tempHash = (HashMap)frequencyRecStr.get(j);



								if (((String)tempHash.get("frequency_code")).equals((String)settingsFreqStr.get("FREQ_CODE"+i))) {
									if (((String)settingsFreqStr.get("APPLICABLE_YN"+i)).equalsIgnoreCase(((String)tempHash.get("applicable_yn"))) && ((String)settingsFreqStr.get("APPLICABLE_YN"+i)).equals("Y") ) {
										flag=true;
										flag1=false;
									}else if (((String)settingsFreqStr.get("APPLICABLE_YN"+i)).equalsIgnoreCase(((String)tempHash.get("applicable_yn"))) && ((String)settingsFreqStr.get("APPLICABLE_YN"+i)).equals("N") )
									{
										flag=true;

									}else{

										flag=false;
										flag1=false;
									}
								}
							}
						}
					}
			}


				if (flag==true && flag1==false){
							dummpPageSettings.put("patient_class"+k,patient_class.trim());
							dummpPageSettings.put("setting_applicability"+k		,setting_applicability_default);
							dummpPageSettings.put("age_group_code"+k			,(String)currRecSettings.get("age_group_code"));
							dummpPageSettings.put("freq_code"+k					,(String)currRecSettings.get("freq_code"));
							dummpPageSettings.put("qty_value"+k					,(String)currRecSettings.get("qty_value"));
							dummpPageSettings.put("qty_uom"+k					,(String)currRecSettings.get("qty_uom"));
							dummpPageSettings.put("durn_value"+k				,(String)currRecSettings.get("durn_value"));
							dummpPageSettings.put("durn_type"+k					,(String)currRecSettings.get("durn_type"));
							dummpPageSettings.put("durn_desc"+k				,(String)currRecSettings.get("durn_desc"));
							dummpPageSettings.put("max_durn_type"+k			,(String)currRecSettings.get("max_durn_type"));
							dummpPageSettings.put("max_durn_value"+k			,(String)currRecSettings.get("max_durn_value"));
							dummpPageSettings.put("chk_for_max_durn_action"+k	,(String)currRecSettings.get("chk_for_max_durn_action"));
							dummpPageSettings.put("ord_auth_level"+k			,(String)currRecSettings.get("ord_auth_level"));
							dummpPageSettings.put("prompt_msg"+k				,(String)currRecSettings.get("prompt_msg"));
					}else if(flag==true && flag1==true){
							dummpPageSettings.put("patient_class"+k			,patient_class.trim());
							dummpPageSettings.put("setting_applicability"+k	,"X");
							dummpPageSettings.put("age_group_code"+k			,"");
							dummpPageSettings.put("qty_value"+k					,"");
							dummpPageSettings.put("qty_uom"+k					,"");
							dummpPageSettings.put("freq_code"+k				,"");
							dummpPageSettings.put("durn_value"+k				,"");
							dummpPageSettings.put("durn_type"+k				,"");
							dummpPageSettings.put("durn_desc"+k				,"");
							dummpPageSettings.put("max_durn_type"+k				,"");
							dummpPageSettings.put("max_durn_value"+k			,"");
							dummpPageSettings.put("chk_for_max_durn_action"+k	,"");
							dummpPageSettings.put("ord_auth_level"+k			,"");
							dummpPageSettings.put("prompt_msg"+k				,"");
					}******************/
							/***********************/
						   dummpPageSettings.put("patient_class"+k				,patient_class.trim());
							dummpPageSettings.put("setting_applicability"+k		,setting_applicability_default);
							dummpPageSettings.put("age_group_code"+k			,(String)currRecSettings.get("age_group_code"));
							dummpPageSettings.put("freq_code"+k					,(String)currRecSettings.get("freq_code"));
							dummpPageSettings.put("qty_value"+k					,(String)currRecSettings.get("qty_value"));
							dummpPageSettings.put("qty_uom"+k					,(String)currRecSettings.get("qty_uom"));
							dummpPageSettings.put("durn_value"+k				,(String)currRecSettings.get("durn_value"));
							dummpPageSettings.put("durn_type"+k				,(String)currRecSettings.get("durn_type"));
							dummpPageSettings.put("durn_desc"+k					,(String)currRecSettings.get("durn_desc"));
							dummpPageSettings.put("max_durn_type"+k			,(String)currRecSettings.get("max_durn_type"));
							dummpPageSettings.put("max_durn_value"+k			,(String)currRecSettings.get("max_durn_value"));
							dummpPageSettings.put("chk_for_max_durn_action"+k	,(String)currRecSettings.get("chk_for_max_durn_action"));
							dummpPageSettings.put("ord_auth_level"+k		,(String)currRecSettings.get("ord_auth_level"));
							dummpPageSettings.put("prompt_msg"+k			,(String)currRecSettings.get("prompt_msg"));
							continue ;
						}
				//}
						//currRecSettings.clear();
					}
				}
				 }

					dummpPageSettings.put("patient_class"+k			,patient_class.trim());
					dummpPageSettings.put("setting_applicability"+k		,"X");
					dummpPageSettings.put("age_group_code"+k			,"");
					dummpPageSettings.put("qty_value"+k					,"");
					dummpPageSettings.put("qty_uom"+k					,"");
					dummpPageSettings.put("freq_code"+k					,"");
					dummpPageSettings.put("durn_value"+k				,"");
					dummpPageSettings.put("durn_type"+k					,"");
					dummpPageSettings.put("durn_desc"+k					,"");
					dummpPageSettings.put("max_durn_type"+k			,"");
					dummpPageSettings.put("max_durn_value"+k			,"");
					dummpPageSettings.put("chk_for_max_durn_action"+k	,"");
					dummpPageSettings.put("ord_auth_level"+k			,"");
					dummpPageSettings.put("prompt_msg"+k				,"");

				 }

			}

			settingsSync(dummpPageSettings)	; //Syn if the str is empty
	} //If Empty Loop Conditinon ends
//}catch(Exception e){}
	recordStoreParam.put("Settings"			,settingsRecStr);
	recordStoreParam.put("Frequency"		,frequencyRecStr);
	recordStoreParam.put("InstructionClobTemp",getInstructionsRecStrClob());//ML-MMOH-SCF-1108 ends
	recordStoreParam.put("Instructions"		,instructionsRecStr);
	recordStoreParam.put("login_by_id"		,login_by_id) ;
	recordStoreParam.put("login_at_ws_no"	,login_at_ws_no ) ;
	recordStoreParam.put("login_facility_id",login_facility_id ) ;
	recordStoreParam.put("MappedFacilities",mappedFacilities );//IN068370,IN068373
	recordStoreParam.put("GlobalFacilityYn",getGlobalFacilityYn());//IN068370,IN068373
	recordStoreParam.put("SiteSpecGlobalFac", isOrderCatalogFacWise);//IN068370,IN068373

//try{
	sqlMap.put("SQL_OR_CATALOG_BY_EFF_STATUS_SELECT",OrRepository.getOrKeyValue("SQL_OR_CATALOG_BY_EFF_STATUS_SELECT"));
	sqlMap.put("SQL_OR_CATALOG_BY_EFF_STATUS_UPDATE",OrRepository.getOrKeyValue("SQL_OR_CATALOG_BY_EFF_STATUS_UPDATE"));
	sqlMap.put("SQL_OR_CATALOG_UPDATE"				,OrRepository.getOrKeyValue("SQL_OR_CATALOG_UPDATE"));
	sqlMap.put("SQL_OR_CATALOG_BY_TYPE_UPDATE"		,OrRepository.getOrKeyValue("SQL_OR_CATALOG_BY_TYPE_UPDATE"));
	sqlMap.put("SQL_OR_CATALOG_INSERT_SYNONYM"		,OrRepository.getOrKeyValue("SQL_OR_CATALOG_INSERT_SYNONYM"));
	sqlMap.put("SQL_OR_CATALOG_INSERT_BY_PTCL"		,OrRepository.getOrKeyValue("SQL_OR_CATALOG_INSERT_BY_PTCL"));
	sqlMap.put("SQL_OR_CATALOG_INSERT_PREPS_INSTRN" ,OrRepository.getOrKeyValue("SQL_OR_CATALOG_INSERT_PREPS_INSTRN"));
	sqlMap.put("SQL_OR_CATALOG_BY_SYNONYM_DELETE"	,OrRepository.getOrKeyValue("SQL_OR_CATALOG_BY_SYNONYM_DELETE"));
	sqlMap.put("SQL_OR_CATALOG_BY_INSTRN_DELETE"	,OrRepository.getOrKeyValue("SQL_OR_CATALOG_BY_INSTRN_DELETE"));
	sqlMap.put("SQL_OR_CATALOG_BY_PTCL_DELETE"		,OrRepository.getOrKeyValue("SQL_OR_CATALOG_BY_PTCL_DELETE"));
	sqlMap.put("SQL_OR_CATALOG_FORMAT_ID1"			,OrRepository.getOrKeyValue("SQL_OR_CATALOG_FORMAT_ID1"));
	sqlMap.put("SQL_OR_CATALOG_FORMAT_ID2"			,OrRepository.getOrKeyValue("SQL_OR_CATALOG_FORMAT_ID2"));
	sqlMap.put("SQL_OR_CATALOG_FREQUENCY_INSERT"	,OrRepository.getOrKeyValue("SQL_OR_CATALOG_FREQUENCY_INSERT"));
	sqlMap.put("SQL_OR_CATALOG_FREQUENCY_DELETE"	,OrRepository.getOrKeyValue("SQL_OR_CATALOG_FREQUENCY_DELETE"));
	sqlMap.put("SQL_OR_ORDER_CATALOG_SEC_TASKS_INSERT"	,OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_SEC_TASKS_INSERT"));
	sqlMap.put("SQL_OR_ORDER_CATALOG_SEC_TASKS_DELETE"	,OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_SEC_TASKS_DELETE"));
	sqlMap.put("SQL_OR_CATALOG_INSERT_UPDATE_INSTRN_CLOB_PR_DR_IS"	,OrRepository.getOrKeyValue("SQL_OR_CATALOG_INSERT_UPDATE_INSTRN_CLOB_PR_DR_IS"));//IN64543
	sqlMap.put("SQL_OR_CATALOG_INSERT_UPDATE_INSTRN_CLOB_IM"	,OrRepository.getOrKeyValue("SQL_OR_CATALOG_INSERT_UPDATE_INSTRN_CLOB_IM"));//IN64543
	//IN068370,IN068373, starts
	if("Y".equals(getGlobalFacilityYn()) && isOrderCatalogFacWise)
	{
		sqlMap.put("SQL_OR_CATALOG_BY_FACILITY_INSERT", OrRepository.getOrKeyValue("SQL_OR_CATALOG_BY_FACILITY_INSERT"));
		sqlMap.put("SQL_OR_CATALOG_BY_FACILITY_DELETE", OrRepository.getOrKeyValue("SQL_OR_CATALOG_BY_FACILITY_DELETE"));
	}
	//IN068370,IN068373, ends
//}catch(Exception e){}
//	map.put("traveVal",traceVal.toString());
//	map.put("reviewsRecStr",reviewsRecStr);
//	map.put("settingsRecStr",settingsRecStr);


	return getResult(recordStoreParam,sqlMap );


	}catch(Exception e){
		e.printStackTrace();
		logErrorMessage(e);
		return null;
	}

}

/*********************METHOD TO Delete*************************/

public HashMap delete(){

	HashMap map = new HashMap();
	map.put( "result", new Boolean( false ) ) ;
	map.put( "message", "delete failure.." );
	return map;
}

/*********************DoCommon*************************/
private void doCommon() throws Exception {
}
/****************GET RESULT******************************/
public String getComboOptions(String opt,String defaultval , String sqlParams) throws Exception{
	Connection connection =null ;
	String str = "";
	String sql = "";
	String[] language_id_param = new String[1];

		if(opt.trim().equalsIgnoreCase(""))
		return "";

try{
		language_id_param[0] = language_id;
		connection = getConnection();
		if(opt.trim().equalsIgnoreCase("OrderCategory")){

			str = Populate.getComboOptions(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC8"),connection,"ORDER_CATEGORY","SHORT_DESC",defaultval.trim(),language_id_param);
		}else if(opt.trim().equalsIgnoreCase("OrderType")){

			if(!sqlParams.trim().equals("")){//called will painting only jsp if OrderCategory is passed

				sql = OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_ORDER_TYPE") ;
				sql = eHISFormatter.replaceForSQL(sql,"?",sqlParams.trim());
				str = Populate.getComboOptions(sql,connection,"ORDER_TYPE_CODE","SHORT_DESC",defaultval.trim()); }
		}else if(opt.trim().equalsIgnoreCase("ActivityType")){


			String param[] = new String[3];
			StringTokenizer stktok = new StringTokenizer(sqlParams,",");
			int i=0;
			while(stktok.hasMoreTokens()){
				param[i] = stktok.nextToken();
				i++;
			}

			str = Populate.getComboOptions_sp(OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_ACTIVITY_TYPE"),connection,"ACTIVITY_TYPE","SHORT_DESC",defaultval.trim(),param);
		}else if(opt.trim().equalsIgnoreCase("HotSpot")){

			StringTokenizer stktok = new StringTokenizer(sqlParams,",");
			String param[] = new String[stktok.countTokens()];

			int i=0;
			while(stktok.hasMoreTokens()){
				param[i] = stktok.nextToken();
				i++;
			}
			str = Populate.getComboOptions_sp(OrRepository.getOrKeyValue("SQL_OR_CATALOG_HOTSPOT"),connection,"hotspot_id","hotspot_id",defaultval.trim(),param);
			/*str = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_CATALOG_HOTSPOT"),connection,"hotspot_id","hotspot_id",defaultval.trim(),sqlParams);*/

		}else if(opt.trim().equalsIgnoreCase("Consent")){
			str = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_CATALOG_CONSENT_FORMAT"),connection,"CONSENT_FORM_ID","CONSENT_FORM_ID",defaultval.trim());
		}else if(opt.trim().equalsIgnoreCase("OrderCategoryOthers")){
			sql = OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC6") ;
			sql= eHISFormatter.replaceForSQL(sql,"?",language_id);
			sql = eHISFormatter.replaceForSQL(sql,"?",sqlParams.trim());
			str = Populate.getComboOptions(sql,connection,"ORDER_CATEGORY","SHORT_DESC",defaultval.trim());
		}else if(opt.trim().equalsIgnoreCase("CHART_VALUES")){
			sql = OrRepository.getOrKeyValue("SQL_OR_CATALOG_CHART_VALUES") ;
			str = Populate.getComboOptions(sql,connection,"CHART_RESULT_TYPE","CHART_RESULT_TYPE_DESC",defaultval.trim());

		}else {//directly sql is passed
			str = Populate.getComboOptions(opt,connection ,"code" ,"short_desc",defaultval.trim());
		}

		return str;
}catch(Exception e){
		logErrorMessage(e);
		throw new Exception(e.getMessage());
}
finally{
		try
		 {
			closeConnection(connection);
		 }catch(Exception e){e.printStackTrace() ;}
	  }
}
/*************get Combo Options Dynamic Population(Headre Frame)***********/
public String getComboBoxHtml(Hashtable ht) throws Exception {
	String sql = "" ;
	String optionString = "";
	String comboBoxString = "";
	Connection connection = null;
try
	{
		if( ht == null )
			return "Hashtable Passed to  this method is null";

		connection = getConnection();
	 	String  type = (String)ht.get("type");


		if(type.trim().equalsIgnoreCase("OrderCategory"))
		{


			sql			  = eHISFormatter.replaceForSQL(OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_ORDER_TYPE") , "?" ,(String)ht.get("order_category"));
			optionString  = Populate.getComboOptions(sql,connection,"ORDER_TYPE_CODE","SHORT_DESC");
			comboBoxString="<select name='order_type_code' id='order_type_code' onChange='parent.parent.fillComboOptions(this);parent.parent.defaultTabChar();parent.parent.display(\\\"C\\\")' ><option value=''>-------------Select----------</option>"+optionString + "</select><img src='../../eCommon/images/mandatory.gif'></img>" ;

		//	tempChk = "";
		}else if(type.trim().equalsIgnoreCase("HotSpot"))
		{
			sql			  = eHISFormatter.replaceForSQL(OrRepository.getOrKeyValue("SQL_OR_CATALOG_HOTSPOT") , "?" ,(String)ht.get("order_category"));
			optionString = Populate.getComboOptions(sql,connection,"hotspot_id","hotspot_id");
			comboBoxString="<select name='image_link_id' id='image_link_id' ><option value=''>-------------Select----------</option>"+optionString +"</select>" ;
		}else if(type.trim().equalsIgnoreCase("OrderType"))
		{
			String[] sqlparam=new String[3];
			sqlparam[0]=(String)ht.get("order_category");
			sqlparam[1]=(String)ht.get("order_type_code");
			sqlparam[2]=(String)ht.get("order_category");
			optionString  = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_ACTIVITY_TYPE"),connection,"ACTIVITY_TYPE","SHORT_DESC",sqlparam);

			comboBoxString="<select name='activity_type' id='activity_type' ><option value=''>-------------Select----------</option>"+optionString + "</select>" ;

		//	tempChk = "";
		}else

			throw new Exception("Exception :-in Bean getComboBoxHtml function Hashtable Passed should contain order_category or tick_sheet ID only");
		}
	catch(Exception e){
		throw e;
	}
	finally
	{
		try
		 {
			closeConnection(connection);
		 }catch(Exception e){e.printStackTrace() ;

		 }
	}

	return comboBoxString;

}/*********************METHOD TO load OrderCategory code-desc for Query Page********/
public String getComboString() {
Connection 	connection  = null;
java.sql.PreparedStatement pstmt		= null;
java.sql.ResultSet			rs			= null;
try
	{
		connection  = getConnection();

		pstmt						= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC8"));
		pstmt.setString(1,language_id);
		 rs		= pstmt.executeQuery();
	    StringBuffer sb			    = new StringBuffer();
		String  codeCol="";
			String  codeDesc="";

		while (rs.next())
			{
				codeCol			    = ChkDef.defaultString(rs.getString(1));
				codeDesc			= ChkDef.defaultString(rs.getString(2));
			    sb.append(codeDesc + "," + codeCol + ",");
			}

		 String str =   sb.toString() ;
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
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		 }catch(Exception e){e.printStackTrace() ;

		 }
	}
}

/***************rewiews Syn************************************/
private void reviewsSync(Hashtable request){

HashMap record = null;
boolean flag = reviewsRecStr.isEmpty() ;//to Chk  whether  the client has visited this tab before


int noOfRecords = Integer.parseInt(chkPresent(request,"noOfRecords","-1")) ;



for (int i = 0 ; i <= noOfRecords ; i++){//0th rec for ALL patient  class which is hard coded

		if(!flag)
			record = (HashMap)reviewsRecStr.get(i);
		else
			record = new HashMap();

		record.put("ord_auth_level"				,chkPresent(request,"ord_auth_level",""));
		record.put("ord_cosign_level"			,chkPresent(request,"ord_cosign_level",""));
		record.put("ord_spl_appr_level"			,chkPresent(request,"ord_spl_appr_level",""));
		record.put("patient_class"				,chkPresent(request,"patient_class"+i,""));
		record.put("setting_applicability"		,chkPresent(request,"setting_applicability"+i,""));
		record.put("ord_auth_reqd_yn"			,chkPresent(request,"ord_auth_reqd_yn"+i,"N"));
		record.put("ord_cosign_reqd_yn"			,chkPresent(request,"ord_cosign_reqd_yn"+i,"N"));
		record.put("ord_spl_appr_reqd_yn"		,chkPresent(request,"ord_spl_appr_reqd_yn"+i,"N"));
		record.put("skip_auth", chkPresent(request,"skip_auth"+i,"")); //IN048467
		if(flag)//only when str was empty
		reviewsRecStr.add(record);

	}

}
/***************frequency Syn************************************/
private void frequencySync(Hashtable request){




  	 HashMap record = null;

    boolean flag = frequencyRecStr.isEmpty() ;//to Chk  whether  the client has visited this tab before



    int fm_disp = Integer.parseInt(chkPresent(request,"fm_disp","-1")) ;
    int to_disp = Integer.parseInt(chkPresent(request,"to_disp","-1")) ;

    if (fm_disp != -1) {
        for (int i = fm_disp ; i <= to_disp ; i++){//0th rec for ALL patient  class which is hard coded

    		if(!flag) {
    			record = (HashMap)frequencyRecStr.get(i);

    		} else
				record=new HashMap();

    		record.put("frequency_code"         ,chkPresent(request,"frequency_code"+i,""));
            record.put("frequency_desc"         ,chkPresent(request,"frequency_desc"+i,""));
            record.put("applicable_yn"		,chkPresent(request,"applicable_yn"+i,"N"));
            record.put("freq_nature"		,chkPresent(request,"freq_nature"+i,"N"));//IN062992

    		if(flag)//only when str was empty
    		frequencyRecStr.add(record);


    	}
    }

}

/*****Default Load for settings tab/for other module defaults or modify*****/
public Hashtable reviewsDefault(String sql , String defaultFor ,String sqlParam[]){

Hashtable retVal =   new Hashtable();
Hashtable result =   null;

try{

	 if(defaultFor.trim().equalsIgnoreCase("auth_level")){
		result  =  getSqlResultParamModule(sql, sqlParam , 1);
	 }


	if(defaultFor.trim().equalsIgnoreCase("update")){
		sql     =  OrRepository.getOrKeyValue(sql.trim());
		result  =  getSqlResultParamModule(sql,sqlParam ,1);

	 }


	Integer	size_res = (Integer)result.get("noRec") ;
	int size		 =  size_res.intValue();

	if(size == 0)
		return retVal;
	String 	patient_class="";
	//HashMap	record = new HashMap();

	for (int i = 1 ; i <= size ; i++){
		HashMap	record = new HashMap();
			record.put("ord_auth_level"				,chkPresent(result,"ord_auth_level"+i,""));
			record.put("ord_cosign_level"			,chkPresent(result,"ord_cosign_level"+i,""));
			record.put("ord_spl_appr_level"			,chkPresent(result,"ord_spl_appr_level"+i,""));
			record.put("patient_class"				,chkPresent(result,"patient_class"+i,""));
			record.put("setting_applicability"		,chkPresent(result,"setting_applicability"+i,"A"));
			record.put("ord_auth_reqd_yn"			,chkPresent(result,"ord_auth_reqd_yn"+i,"N"));
			record.put("ord_cosign_reqd_yn"			,chkPresent(result,"ord_cosign_reqd_yn"+i,"N"));
			record.put("ord_spl_appr_reqd_yn"		,chkPresent(result,"ord_spl_appr_reqd_yn"+i,"N"));
			record.put("skip_auth"					,chkPresent(result,"ord_skip_auth_ind"+i,"")); //IN048467
			//if qry does not fetch the patient class then default one
			patient_class =	chkPresent(result,"patient_class"+i,"")	;

			if(patient_class.trim().equalsIgnoreCase("")){
				retVal.put("*A",record);
			}else{
				retVal.put(	patient_class.trim(),record);
			}
			//record.clear();
		}


		return  retVal ;
 }catch(Exception e){
		e.printStackTrace();
		return null;
}

}

//
public void frequencyDefault(String mode,String order_category,String order_catalog_code) throws Exception{





    Hashtable request = new Hashtable();

    Connection connection = null;
    PreparedStatement pstmt = null;
    ResultSet resultSet = null;
    try {
        String sql = "";
        frequencyRecStr.clear();
        connection = getConnection();
        /*IN067312 Starts*/
        boolean site=false;
		site = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","TPN_CONT_FREQ_CHECK");
		int count=0;
		/*IN067312 ends*/
        if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
            sql = OrRepository.getOrKeyValue("SQL_OR_CATALOG_FREQUENCY_MODIFY_SELECT") ;
            /*IN067312 Starts*/
            if(site)
            {
            	PreparedStatement pstmt1 = null;
				ResultSet resultSet1 = null; 
            	String tpn_yn="N";
				pstmt1 = connection.prepareStatement("select count(*) from PH_TPN_REGIMEN where TPN_REGIMEN_CODE =? AND STANDARD_REGIMEN_YN='Y'");//IN067312
				pstmt1.setString(1, order_catalog_code);
				resultSet1 = pstmt1.executeQuery();
				if(resultSet1.next())
				{
					count=resultSet1.getInt(1);
				}
				if(count>0)
					tpn_yn="Y";
				else
					tpn_yn="N";
				if(tpn_yn.equals("Y"))
				{
					sql=OrRepository.getOrKeyValue("SQL_OR_CATALOG_FREQUENCY_MODIFY_SELECT_TPN");
				}
            }
            /*IN067312 Starts*/
            pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, order_category);
            pstmt.setString(2, order_catalog_code);
            pstmt.setString(3, order_category);
            pstmt.setString(4, order_catalog_code);
        } else if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
			if (order_category.equals("PH")) {
				/*IN067312 Starts*/
				PreparedStatement pstmt1 = null;
				ResultSet resultSet1 = null; 
	    		sql = OrRepository.getOrKeyValue("SQL_OR_CATALOG_SETTINGS_FREQ_PH");
				if(site){
					String tpn_yn="N";
					pstmt1 = connection.prepareStatement("select count(*) from PH_TPN_REGIMEN where TPN_REGIMEN_CODE =?");
					pstmt1.setString(1, order_catalog_code);
					resultSet1 = pstmt1.executeQuery();
					if(resultSet1.next())
					{
						count=resultSet1.getInt(1);
					}
					if(count>0)
						tpn_yn="Y";
					else
						tpn_yn="N";
					
					if(tpn_yn.equals("Y"))
					{
						sql=OrRepository.getOrKeyValue("SQL_OR_CATALOG_SETTINGS_FREQ_PH_TPN");
					}
					/*IN067312 ends*/
				}
            } else {
                sql = OrRepository.getOrKeyValue("SQL_OR_CATALOG_SETTINGS_FREQ");
            }
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, order_category);
        }
        if (pstmt != null) {

            resultSet = pstmt.executeQuery();
            int counter = 0;
            while(resultSet.next()) {
                request.put("frequency_code"+counter,resultSet.getString("freq_code"));

                request.put("frequency_desc"+counter,resultSet.getString("freq_desc"));
                if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
                    request.put("applicable_yn"+counter,resultSet.getString("applicable_yn").trim());
					request.put("freq_nature"+counter,resultSet.getString("freq_nature"));//IN062992
                } else {
                    request.put("applicable_yn"+counter,"Y");
					//IN062992, starts
					if ("PH".equals(order_category)) 
					{
						request.put("freq_nature"+counter,resultSet.getString("freq_nature"));
					}
					//IN062992, ends
                }
                counter++;
            }
            request.put("fm_disp",""+0);
            request.put("to_disp",""+(counter-1));

            frequencySync(request);
        }
    } catch (Exception e) {
    	e.printStackTrace();
    } finally {
    	closeResultSet(resultSet);
	    closeStatement(pstmt);
	    closeConnection(connection);
    }
}

//

/*************************just get the result as Hash table WHEN SQL IS PASSED***************/

public  Hashtable getSqlResultParamModule(String sql , String[] params ,int indStart) throws Exception{

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
}catch(Exception e){
	throw new Exception(e.getMessage());
}finally{
	try{
		closeResultSet( rs ) ;
		closeStatement( pstmt ) ;
		closeConnection(connection);
	 }catch(Exception e){e.printStackTrace() ;}
}

}

/***************rewiews Syn************************************/
private void settingsSync(Hashtable request){
HashMap record = null;
boolean flag = settingsRecStr.isEmpty() ;//to Chk  whether  the client has visited this tab before


int noOfRecords = Integer.parseInt(chkPresent(request,"noOfRecords","-1")) ;
for (int i = 0 ; i <= noOfRecords ; i++){//0th rec for ALL patient  class which is hard coded

		if(!flag)
			record = (HashMap)settingsRecStr.get(i);
		else
			record=new HashMap();

		record.put("patient_class"				,chkPresent(request,"patient_class"+i,""));
		record.put("setting_applicability"		,chkPresent(request,"setting_applicability"+i,"X"));
		record.put("age_group_code"				,chkPresent(request,"age_group_code"+i,""));
		record.put("qty_value"					,chkPresent(request,"qty_value"+i,"1"));
		record.put("qty_uom"					,chkPresent(request,"qty_uom"+i,""));
		record.put("freq_code"					,chkPresent(request,"freq_code"+i,""));
		record.put("durn_value"					,chkPresent(request,"durn_value"+i,""));
		record.put("durn_type"					,chkPresent(request,"durn_type"+i,""));
		record.put("durn_desc"					,chkPresent(request,"durn_desc"+i,""));
		record.put("max_durn_type"				,chkPresent(request,"max_durn_type"+i,""));
		record.put("max_durn_value"				,chkPresent(request,"max_durn_value"+i,""));
		record.put("chk_for_max_durn_action"	,chkPresent(request,"chk_for_max_durn_action"+i,""));
		record.put("ord_auth_level"				,chkPresent(request,"ord_auth_level"+i,""));
		record.put("prompt_msg"					,chkPresent(request,"prompt_msg"+i,""));


		if(flag)//only when str was empty
		settingsRecStr.add(record);

	}

}

/*****Default Load for rewiews tab/for other module defaults or modify*****/
public Hashtable settingsDefault(String sql , String defaultFor ,String sqlParam[]){


Hashtable retVal =   new Hashtable();
Hashtable result =   null;

try{

	 if(defaultFor.trim().equalsIgnoreCase("sql_setting")){
		result  =  getSqlResultParamModule(sql, sqlParam , 1);
	 }


	 if(defaultFor.trim().equalsIgnoreCase("update")){
		sql     =  OrRepository.getOrKeyValue(sql.trim());
		result  =  getSqlResultParamModule(sql, sqlParam , 1);
	 }

//	tempChk = "";
//	tempChk = result.toString();

	Integer	size_res = (Integer)result.get("noRec") ;
	int size		 =  size_res.intValue();

	if(size == 0)
		return retVal;
	String 	patient_class="";

	for (int i = 1 ; i <= size ; i++){
		HashMap	record = new HashMap();

		record.put("patient_class"				,chkPresent(result,"patient_class"+i,""));
		record.put("setting_applicability"		,chkPresent(result,"setting_applicability"+i,"A"));				//In case of other module calling
		record.put("age_group_code"				,chkPresent(result,"age_group_code"+i,""));
		record.put("qty_value"					,chkPresent(result,"qty_value"+i,"1"));
		record.put("qty_uom"					,chkPresent(result,"qty_uom"+i,""));
		record.put("freq_code"					,chkPresent(result,"freq_code"+i,""));
		record.put("durn_value"					,chkPresent(result,"durn_value"+i,""));
		record.put("durn_type"					,chkPresent(result,"durn_type"+i,""));
		record.put("durn_desc"					,chkPresent(result,"durn_desc"+i,""));
		record.put("max_durn_type"				,chkPresent(result,"max_durn_type"+i,""));
		record.put("max_durn_value"				,chkPresent(result,"max_durn_value"+i,""));
		record.put("chk_for_max_durn_action"	,chkPresent(result,"chk_for_max_durn_action"+i,""));
		record.put("ord_auth_level"				,chkPresent(result,"ord_auth_level"+i,""));
		record.put("prompt_msg"					,chkPresent(result,"prompt_msg"+i,""));

		patient_class =	chkPresent(result,"patient_class"+i,"-1")	;

		retVal.put(patient_class.trim(),record);
		//record.clear();
	}

		return  retVal ;
  }catch(Exception e){
		e.printStackTrace();
		return null;
  }
}
/***************instruction Syn************************************/
private void instructionSync(Hashtable request){
	try{
HashMap recordOrderCatalog			= null ;
HashMap recordPreps					= null ;
HashMap recordStdIntruction			= null ;
HashMap recordByAge					= null ;
String appt_time = "";


	if(!instructionsRecStr.isEmpty()){

		recordOrderCatalog  =(HashMap)instructionsRecStr.get(0);
		recordPreps		    =(HashMap)instructionsRecStr.get(1);
		recordStdIntruction =(HashMap)instructionsRecStr.get(2);
		recordByAge			=(HashMap)instructionsRecStr.get(3);

		appt_time			=chkPresent(request,"appt_time","");
		if(appt_time.equals(""))
			appt_time		=(String)recordOrderCatalog.get("appt_time");
		//recordOrderCatalog.put("appt_time"				,appt_time);
	}else{

		recordOrderCatalog  = new HashMap();
		recordPreps			= new HashMap();
		recordStdIntruction = new HashMap();
		recordByAge			= new HashMap();
		recordByAge.put("records",new ArrayList());

		instructionsRecStr.add(recordOrderCatalog);
		instructionsRecStr.add(recordPreps);
		instructionsRecStr.add(recordStdIntruction);
		instructionsRecStr.add(recordByAge);

		appt_time			= chkPresent(request,"appt_time","");
		//recordOrderCatalog.put("appt_time"				,chkPresent(request,"appt_time",""));

	}


	/**
	While Syn of the Main tab we would be Syn only recordOrderCatalog and recordPreps records ------other 2 will  be done in the other functions
	**/

//	recordOrderCatalog.put("consent_reqd_yn"		,chkPresent(request,"consent_reqd_yn","N"));
//	recordOrderCatalog.put("consent_form_id"		,chkPresent(request,"consent_form_id",""));
	recordOrderCatalog.put("prompt_alert_yn"		,chkPresent(request,"prompt_alert_yn","N"));
	recordOrderCatalog.put("prompt_alert_msg"		,chkPresent(request,"prompt_alert_msg",""));
	recordOrderCatalog.put("appt_reqd_yn"  			,chkPresent(request,"appt_reqd_yn","N"));
	recordOrderCatalog.put("routine_appt_reqd_yn"  			,chkPresent(request,"routine_appt_reqd_yn","N"));
	recordOrderCatalog.put("urgent_appt_reqd_yn"  			,chkPresent(request,"urgent_appt_reqd_yn","N"));
	recordOrderCatalog.put("stat_appt_reqd_yn"  			,chkPresent(request,"stat_appt_reqd_yn","N"));
	recordOrderCatalog.put("clin_cmts_reqd_yn"  			,chkPresent(request,"clin_cmts_reqd_yn","N"));
	recordOrderCatalog.put("splty_speci_reqd_yn"  			,chkPresent(request,"splty_speci_reqd_yn","N"));
	recordOrderCatalog.put("pri_splty_code"  			,chkPresent(request,"pri_splty_code",""));
	recordOrderCatalog.put("invoke_instrn_window_yn"  			,chkPresent(request,"invoke_instrn_window_yn","N"));//IN064543
	recordOrderCatalog.put("instrn_content_type"  			,chkPresent(request,"instrn_content_type","T"));//IN64543
	
	recordOrderCatalog.put("appt_prep_time",chkPresent(request,"appt_prep_time",""));
	recordOrderCatalog.put("appt_prep_time_type",chkPresent(request,"appt_prep_time_type",""));
	recordOrderCatalog.put("appt_action_for_prep",chkPresent(request,"appt_action_for_prep",""));
	//recordOrderCatalog.put("appt_time"				,chkPresent(request,"appt_time",""));
	recordOrderCatalog.put("appt_time"	,appt_time);

	//recordPreps.put("pat_preps_or_instrns_txt_pr"   ,chkPresent(request,"pat_preps_or_instrns_txt_pr",""));//This record will  goi  in any case
    recordPreps.put("pat_preps_or_instrns_id_pr"    ,"PR");

	//recordPreps.put("pat_preps_or_instrns_txt_dr"   ,chkPresent(request,"pat_preps_or_instrns_txt_dr",""));//This record will  goi  in any case
    recordPreps.put("pat_preps_or_instrns_id_dr"    ,"DR");



	//recordOrderCatalog.put("pat_preps_or_instrns_id"	   ,chkPresent(request,"pat_preps_or_instrns_id",""));
	recordOrderCatalog.put("follow_visit_type_yn"	,chkPresent(request,"follow_visit_type_yn","N")); // added for IN031304
	
	//IN64543, starts	
	if("T".equals(recordOrderCatalog.get("instrn_content_type")))
	{
		recordOrderCatalog.put("pat_preps_or_instrns_id"	   ,chkPresent(request,"pat_preps_or_instrns_id",""));
		recordPreps.put("pat_preps_or_instrns_txt_pr"   ,chkPresent(request,"pat_preps_or_instrns_txt_pr",""));//This record will  goi  in any case
		recordPreps.put("pat_preps_or_instrns_txt_dr"   ,chkPresent(request,"pat_preps_or_instrns_txt_dr",""));//This record will  goi  in any case
	}
	else if("E".equals(recordOrderCatalog.get("instrn_content_type")))
	{
		//recordOrderCatalog.put("pat_preps_or_instrns_id"	   ,chkPresent(request,"pat_instrns_free_fmt_id",""));
		recordOrderCatalog.put("pat_instrns_free_fmt_id"	   ,chkPresent(request,"pat_instrns_free_fmt_id",""));
		recordPreps.put("pat_preps_or_instrns_free_fmt_pr"   ,chkPresent(request,"pat_preps_or_instrns_free_fmt_pr",""));    
		recordPreps.put("pat_preps_or_instrns_free_fmt_dr"   ,chkPresent(request,"pat_preps_or_instrns_free_fmt_dr",""));
		recordPreps.put("pat_preps_or_instrns_free_fmt_is"   ,chkPresent(request,"pat_preps_or_instrns_free_fmt_is",""));
		////ML-MMOH-SCF-1108 start
		if(map!=null && map.size()>0)
		{
		recordPreps.put("pat_preps_or_instrns_free_fmt_pr"   ,(String)map.get("pat_preps_or_instrns_free_fmt_pr"));    
		recordPreps.put("pat_preps_or_instrns_free_fmt_dr"   ,(String)map.get("pat_preps_or_instrns_free_fmt_dr"));
		}
		//ML-MMOH-SCF-1108 ends 
	}
    	//IN64543, ends
	}catch(Exception e){
	e.printStackTrace();}

}

private void prepSync(Hashtable request){

	HashMap record= null;
	boolean flag=false;

	if(!prepRecStr.isEmpty())
	{
		flag=true;

		record = (HashMap)prepRecStr.get(0);

	}else
		record = new HashMap();

	//record.put("pri_sec_tasks_type0"			,chkPresent(request,"pri_sec_tasks_type","O"));

	int tot_recs = Integer.parseInt(chkPresent(request,"tot_recs","0"));

	for (int i = 0;i < tot_recs; i++) {

	   if ((chkPresent(request,"patient_class_chk"+i,"N")).equals("Y")) {


			record.put("patient_class"+i		,chkPresent(request,"patient_class"+i,""));
			if(flag)
			record.put("pri_sec_tasks_type"+i	,chkPresent(request,"pri_sec_tasks_type",""));
			else
			record.put("pri_sec_tasks_type"+i	,chkPresent(request,"pri_sec_tasks_type"+i,""));
			record.put("patient_class_chk"+i	,chkPresent(request,"patient_class_chk"+i,"N"));
       }else{
			if(record.get("patient_class"+i)!=null)
			   record.remove("patient_class"+i);
			   record.remove("patient_class_chk"+i);
			   record.remove("pri_sec_tasks_type"+i);

		    }
	   //record.put("patient_class_chk"+i	,chkPresent(request,"patient_class_chk"+i,"N"));

	}

    record.put("tot_recs"		,chkPresent(request,"tot_recs","0"));



	if(prepRecStr.isEmpty())
		prepRecStr.add(record);


}

/***********instruction------standard/By Age  -GET*************/
public HashMap getInstructionStdByAge(String instructionType){
Hashtable dummy                     = new Hashtable();

if(instructionsRecStr.isEmpty())
instructionSync(dummy);

 if(instructionType.trim().equalsIgnoreCase("IS")){//std  Instr
	HashMap recordStdIntruction  =(HashMap)instructionsRecStr.get(2);//Stored at second position
	return recordStdIntruction;
 }

 if(instructionType.trim().equalsIgnoreCase("IM")){//Instr ByAge/sex
	HashMap recordByAge			=(HashMap)instructionsRecStr.get(3);//Stored at second position
	return recordByAge;
 }

	return null ;

}
/***********instruction------By Age  -SYN*************/

public synchronized boolean instructionByAgeSync(Hashtable request){

HashMap recordStdIntruction			= null ;
HashMap recordByAge					= null ;
Hashtable dummy                     = new Hashtable();
String pat_preps_or_instrns_txt_is = "";//IN64543
String pat_preps_or_instrns_free_fmt_is = "";//IN64543

if(instructionsRecStr.isEmpty())
instructionSync(dummy);

recordStdIntruction  =(HashMap)instructionsRecStr.get(2);//Stored at second position
recordByAge		     =(HashMap)instructionsRecStr.get(3);//Stored at third position

String instructionType =  (String)request.get("instructionType");
String instrn_content_type = (String) request.get("instrn_content_type");

if(instructionType.trim().equalsIgnoreCase("IS")){//std  Instr

	if(!recordByAge.isEmpty()) //clear  the Other One
    	recordByAge.clear() ;

				//IN64543, starts
		if("T".equals(instrn_content_type))
		{
			recordStdIntruction.clear();
			pat_preps_or_instrns_txt_is = (String)(request.get("pat_preps_or_instrns_txt_is")==null?"":request.get("pat_preps_or_instrns_txt_is"));	
			recordStdIntruction.put("pat_preps_or_instrns_txt_is",pat_preps_or_instrns_txt_is);
			recordStdIntruction.put("pat_preps_or_instrns_free_fmt_is",	"");
		}
		else if("E".equals(instrn_content_type))
		{			
			recordStdIntruction.clear();
			pat_preps_or_instrns_free_fmt_is = (String)(request.get("pat_preps_or_instrns_free_fmt_is")==null?"":request.get("pat_preps_or_instrns_free_fmt_is"));
			recordStdIntruction.put("pat_preps_or_instrns_free_fmt_is",	pat_preps_or_instrns_free_fmt_is);
			recordStdIntruction.put("pat_preps_or_instrns_txt_is","");
		}


	return true;
}

if(instructionType.trim().equalsIgnoreCase("IM")){//By Age

ArrayList records = null ;
HashMap currRec   = new HashMap();

	if(!recordStdIntruction.isEmpty())
    	recordStdIntruction.clear() ;

	if(!recordByAge.isEmpty())
		records =(ArrayList)recordByAge.get("records");
	else{
		records = new ArrayList();
		recordByAge.put("records" , records);
	}
	
	String indexOfRec = chkPresent(request,"index","-1");
	String action     = chkPresent(request,"action","");

	int indx		  = Integer.parseInt(indexOfRec.trim());
	
	if(!action.trim().equalsIgnoreCase("delete")){
		//if (indx!=-1)
		//{
			if(!chkRangeOverLap(records,request,indx)){

			return false ;
		//}
		}
	}

	if(Integer.parseInt(indexOfRec.trim()) != -1){
	currRec =(HashMap)records.get(Integer.parseInt(indexOfRec.trim())); //Syn
	}

	currRec.put("min_age_in_days"		   ,chkPresent(request,"min_age_in_days","0"));
	currRec.put("min_age_in_mths"		   ,chkPresent(request,"min_age_in_mths","0"));
	currRec.put("min_age_in_yrs"		   ,chkPresent(request,"min_age_in_yrs" ,"0"));
	currRec.put("max_age_in_days"		   ,chkPresent(request,"max_age_in_days","0"));
	currRec.put("max_age_in_mths"  		   ,chkPresent(request,"max_age_in_mths","0"));
	currRec.put("max_age_in_yrs"		   ,chkPresent(request,"max_age_in_yrs","0"));
	currRec.put("sex_spec_ind"			   ,chkPresent(request,"sex_spec_ind",""));
	
	//IN64543, starts
	if("T".equals(instrn_content_type))
	{				
		currRec.put("pat_preps_or_instrns_txt",chkPresent(request, "pat_preps_or_instrns_txt_im", ""));
	}
	else if("E".equals(instrn_content_type))
	{
		currRec.put("pat_preps_or_instrns_free_fmt_im",chkPresent(request, "pat_preps_or_instrns_free_fmt_im", ""));
	}
	//IN64543, ends
	
	if(indexOfRec.trim().equals("-1")){ //New Record to be added
		records.add(currRec);

		return  true;
	}

	if(action.trim().equalsIgnoreCase("delete")){//delete the rec
		 records.remove(Integer.parseInt(indexOfRec.trim()));
 		return true;
	}
	
 	//records.add(Integer.parseInt(indexOfRec.trim()),currRec); //UPdate the record

	return true;
}//By Age Instruction
return false;
}
/******************Range Valiadtion Catalog*********************/
private boolean chkRangeOverLap(ArrayList recordStr,Hashtable currRec , int currIndx ){
int size		=	recordStr.size();

int yrsMx		=Integer.parseInt(eHISFormatter.chkReturn((String)currRec.get("max_age_in_yrs"),"","0",(String)currRec.get("max_age_in_yrs")));
int mnthsMx		=Integer.parseInt(eHISFormatter.chkReturn((String)currRec.get("max_age_in_mths"),"","0",(String)currRec.get("max_age_in_mths")));
int daysMx		=Integer.parseInt(eHISFormatter.chkReturn((String)currRec.get("max_age_in_days"),"","0",(String)currRec.get("max_age_in_days")));

int yrsMn		=Integer.parseInt(eHISFormatter.chkReturn((String)currRec.get("min_age_in_yrs"),"","0",(String)currRec.get("min_age_in_yrs")));
int mnthsMn		=Integer.parseInt(eHISFormatter.chkReturn((String)currRec.get("min_age_in_mths"),"","0",(String)currRec.get("min_age_in_mths")));
int daysMn		=Integer.parseInt(eHISFormatter.chkReturn((String)currRec.get("min_age_in_days"),"","0",(String)currRec.get("min_age_in_days")));


String sex		=(String)currRec.get("sex_spec_ind");

//int currMaxTotal  = getDays(yrsMx,mnthsMx,daysMx);
//int currMinTotal  = getDays(yrsMn,mnthsMn,daysMn);

//HashMap tempRec=new HashMap();
//String sexTemp="";
	if(size != 0){
	   for(int i = 0 ; i  < size ; i++){

			HashMap tempRec =(HashMap)recordStr.get(i);
			 String sexTemp		=(String)tempRec.get("sex_spec_ind");

			//Don't chk OverLapping for the opposite sex

			if(!sex.trim().equalsIgnoreCase("N")){ //chks if curRec is M or F only
				if(!sexTemp.trim().equalsIgnoreCase("N")){ //chks if tempRec is M or F only
					if(!sexTemp.trim().equalsIgnoreCase(sex))  //if	curRec & TempRec have opp sex don,t chk  for overLap
					continue ;
				}else
				{
					return false;
				}
			}



			int yrsMxTemp		=Integer.parseInt(eHISFormatter.chkReturn((String)tempRec.get("max_age_in_yrs"),"","0",(String)tempRec.get("max_age_in_yrs")));
			int mnthsMxTemp		=Integer.parseInt(eHISFormatter.chkReturn((String)tempRec.get("max_age_in_mths"),"","0",(String)tempRec.get("max_age_in_mths")));
			int daysMxTemp		=Integer.parseInt(eHISFormatter.chkReturn((String)tempRec.get("max_age_in_days"),"","0",(String)tempRec.get("max_age_in_days")));

			int yrsMnTemp		=Integer.parseInt(eHISFormatter.chkReturn((String)tempRec.get("min_age_in_yrs"),"","0",(String)tempRec.get("min_age_in_yrs")));
			int mnthsMnTemp		=Integer.parseInt(eHISFormatter.chkReturn((String)tempRec.get("min_age_in_mths"),"","0",(String)tempRec.get("min_age_in_mths")));
			int daysMnTemp		=Integer.parseInt(eHISFormatter.chkReturn((String)tempRec.get("min_age_in_days"),"","0",(String)tempRec.get("min_age_in_days")));

	//		int tempMaxTotal    = getDays(yrsMxTemp,mnthsMxTemp,daysMxTemp);
	//		int tempMinTotal    = getDays(yrsMnTemp,mnthsMnTemp,daysMnTemp);

/*			if(currIndx != i )	{//don't chk with the rec being updated

				if(currMaxTotal < tempMaxTotal && currMaxTotal > tempMinTotal)
					return false ;

				if(currMinTotal < tempMaxTotal &&  currMinTotal > tempMinTotal)
					return false ;

				if(tempMaxTotal == currMaxTotal && tempMinTotal == currMinTotal)
					return false;

			 	if(tempMaxTotal < currMaxTotal && tempMaxTotal > currMinTotal)
					return false ;

				if(tempMinTotal < currMaxTotal &&  tempMinTotal > currMinTotal)
					return false ;
			}
  */
			//Alternative Algorithm for overLapping Chk

			Integer currMaxTotalI = new Integer(getDays(yrsMx,mnthsMx,daysMx));
			Integer currMinTotalI = new Integer(getDays(yrsMn,mnthsMn,daysMn));

			float currMaxTotal	  =  currMaxTotalI.floatValue() ;
			float currMinTotal    =  currMinTotalI.floatValue() ;

			Integer tempMaxTotalI = new Integer(getDays(yrsMxTemp,mnthsMxTemp,daysMxTemp));
			Integer tempMinTotalI = new Integer(getDays(yrsMnTemp,mnthsMnTemp,daysMnTemp));


			float tempMaxTotal	  = tempMaxTotalI.floatValue() ;
			float tempMinTotal    = tempMinTotalI.floatValue() ;

			float meanTemp	      = (tempMaxTotal	+ tempMinTotal) / 2	   ;

			if(currIndx != i )	{//don't chk with the rec being updated

			if(meanTemp < currMaxTotal && meanTemp > currMinTotal)
			return false;

			}
// tempRec.clear();
 //sexTemp="";

	/**/
	}
	   return true ;
  }
	   return true;
}
//ML-MMOH-SCF-1108
public boolean chkRangeOverLapTemp(ArrayList recordStr,Hashtable currRec , int currIndx ){
int size		=	recordStr.size();

int yrsMx		=Integer.parseInt(eHISFormatter.chkReturn((String)currRec.get("max_age_in_yrs"),"","0",(String)currRec.get("max_age_in_yrs")));
int mnthsMx		=Integer.parseInt(eHISFormatter.chkReturn((String)currRec.get("max_age_in_mths"),"","0",(String)currRec.get("max_age_in_mths")));
int daysMx		=Integer.parseInt(eHISFormatter.chkReturn((String)currRec.get("max_age_in_days"),"","0",(String)currRec.get("max_age_in_days")));

int yrsMn		=Integer.parseInt(eHISFormatter.chkReturn((String)currRec.get("min_age_in_yrs"),"","0",(String)currRec.get("min_age_in_yrs")));
int mnthsMn		=Integer.parseInt(eHISFormatter.chkReturn((String)currRec.get("min_age_in_mths"),"","0",(String)currRec.get("min_age_in_mths")));
int daysMn		=Integer.parseInt(eHISFormatter.chkReturn((String)currRec.get("min_age_in_days"),"","0",(String)currRec.get("min_age_in_days")));


String sex		=(String)currRec.get("sex_spec_ind");


	if(size != 0){
	   for(int i = 0 ; i  < size ; i++){

		   HashMap tempRec =(HashMap)recordStr.get(i);
			 String sexTemp		=(String)tempRec.get("sex_spec_ind");

			//Don't chk OverLapping for the opposite sex

			if(!sex.trim().equalsIgnoreCase("N")){ //chks if curRec is M or F only
				if(!sexTemp.trim().equalsIgnoreCase("N")){ //chks if tempRec is M or F only
					if(!sexTemp.trim().equalsIgnoreCase(sex))  //if	curRec & TempRec have opp sex don,t chk  for overLap
					continue ;
				}else
				{
					return false;
				}
			}



			int yrsMxTemp		=Integer.parseInt(eHISFormatter.chkReturn((String)tempRec.get("max_age_in_yrs"),"","0",(String)tempRec.get("max_age_in_yrs")));
			int mnthsMxTemp		=Integer.parseInt(eHISFormatter.chkReturn((String)tempRec.get("max_age_in_mths"),"","0",(String)tempRec.get("max_age_in_mths")));
			int daysMxTemp		=Integer.parseInt(eHISFormatter.chkReturn((String)tempRec.get("max_age_in_days"),"","0",(String)tempRec.get("max_age_in_days")));

			int yrsMnTemp		=Integer.parseInt(eHISFormatter.chkReturn((String)tempRec.get("min_age_in_yrs"),"","0",(String)tempRec.get("min_age_in_yrs")));
			int mnthsMnTemp		=Integer.parseInt(eHISFormatter.chkReturn((String)tempRec.get("min_age_in_mths"),"","0",(String)tempRec.get("min_age_in_mths")));
			int daysMnTemp		=Integer.parseInt(eHISFormatter.chkReturn((String)tempRec.get("min_age_in_days"),"","0",(String)tempRec.get("min_age_in_days")));


			Integer currMaxTotalI = new Integer(getDays(yrsMx,mnthsMx,daysMx));
			Integer currMinTotalI = new Integer(getDays(yrsMn,mnthsMn,daysMn));

			float currMaxTotal	  =  currMaxTotalI.floatValue() ;
			float currMinTotal    =  currMinTotalI.floatValue() ;

			Integer tempMaxTotalI = new Integer(getDays(yrsMxTemp,mnthsMxTemp,daysMxTemp));
			Integer tempMinTotalI = new Integer(getDays(yrsMnTemp,mnthsMnTemp,daysMnTemp));


			float tempMaxTotal	  = tempMaxTotalI.floatValue() ;
			float tempMinTotal    = tempMinTotalI.floatValue() ;

			float meanTemp	      = (tempMaxTotal	+ tempMinTotal) / 2	   ;

			if(currIndx != i )	{//don't chk with the rec being updated

			if(meanTemp < currMaxTotal && meanTemp > currMinTotal)
			return false;

			}

	}
	   return true ;
  }
	   return true;
}
/**********************utility method for days calulation**********/
private int getDays(int yrs,int mths,int days){
	return 	(yrs*365 + daysInMonths[mths] + days) ;
}
/***************rewiews Syn************************************/
//private void billingSync(Hashtable request){
//}
/***************turnAroundTime Syn************************************/
private void turnAroundSync(Hashtable request){
	HashMap record= null;

	if(!turnAroundRecStr.isEmpty())
		record = (HashMap)turnAroundRecStr.get(0);
	else
		record = new HashMap();

	record.put("stat_turn_around_time"		 ,chkPresent(request,"stat_turn_around_time",""));
	record.put("stat_turn_around_type"		 ,chkPresent(request,"stat_turn_around_type",""));
	record.put("urgent_turn_around_time"	 ,chkPresent(request,"urgent_turn_around_time",""));
	record.put("urgent_turn_around_type"	 ,chkPresent(request,"urgent_turn_around_type",""));
	record.put("routine_turn_around_time"	 ,chkPresent(request,"routine_turn_around_time",""));
	record.put("routine_turn_around_type"	 ,chkPresent(request,"routine_turn_around_type",""));
	record.put("stat_warn_turn_around_time"	  ,chkPresent(request,"stat_warn_turn_around_time",""));//58960
	record.put("stat_warn_turn_around_type"	  ,chkPresent(request,"stat_warn_turn_around_type",""));//58960
	record.put("urge_warn_turn_around_time"	 ,chkPresent(request,"urge_warn_turn_around_time",""));//58960
	record.put("urge_warn_turn_around_type"	 ,chkPresent(request,"urge_warn_turn_around_type",""));//58960
	record.put("rout_warn_turn_around_time"	 ,chkPresent(request,"rout_warn_turn_around_time",""));//58960
	record.put("rout_warn_turn_around_type"	 ,chkPresent(request,"rout_warn_turn_around_type",""));//58960

	if(turnAroundRecStr.isEmpty())
		turnAroundRecStr.add(record);

}

/***************rewiews Syn************************************/
private void CharactersticsSync(Hashtable request){


	HashMap record= null;

	if(!characteristicsRecStr.isEmpty())
		record = (HashMap)characteristicsRecStr.get(0);
	else
		record = new HashMap();

	record.put("catalog_synonym_primary"		,chkPresent(request,"catalog_synonym_primary",""));
	record.put("effective_status_primary"		,chkPresent(request,"effective_status_primary","N"));
	record.put("catalog_synonym_directCare"		,chkPresent(request,"catalog_synonym_directCare",""));
	record.put("effective_status_directCare"	,chkPresent(request,"effective_status_directCare","N"));
	record.put("catalog_synonym_ancillaryDept"	,chkPresent(request,"catalog_synonym_ancillaryDept",""));
	record.put("effective_status_ancillaryDept"	,chkPresent(request,"effective_status_ancillaryDept","N"));

	record.put("qty_reqd_yn"					,chkPresent(request,"qty_reqd_yn","N"));
	record.put("qty_uom"						,chkPresent(request,"qty_uom",""));
	record.put("qty_uom_desc"					,chkPresent(request,"qty_uom_desc",""));
	record.put("split_dose_yn"					,chkPresent(request,"split_dose_yn","N"));
	record.put("taper_dose_yn"					,chkPresent(request,"taper_dose_yn","N"));
	record.put("taper_up"					    ,chkPresent(request,"taper_up","N"));
	record.put("none_yn"						,chkPresent(request,"none_yn","N"));
	record.put("appl_sliding_scale_yn"		    ,chkPresent(request,"appl_sliding_scale_yn","N"));
	record.put("freq_applicable_yn"				,chkPresent(request,"freq_applicable_yn","N"));
	record.put("soft_stop_yn"					,chkPresent(request,"soft_stop_yn","N"));
	record.put("cont_order_yn"					,chkPresent(request,"cont_order_yn","N"));
	record.put("refill_cont_order_yn"			,chkPresent(request,"refill_cont_order_yn","N"));

	record.put("contineous_freq_order"	        ,chkPresent(request,"contineous_freq_order",""));
	record.put("consent_reqd_yn"				,chkPresent(request,"consent_reqd_yn","N"));
	record.put("multiple_consent_yn"			,chkPresent(request,"multiple_consent_yn","N"));
	record.put("consent_form_list"				,chkPresent(request,"consent_form_list",""));
	record.put("num_of_consent_req_bo"			,chkPresent(request,"num_of_consent_req_bo",""));
	record.put("num_of_consent_req_br"			,chkPresent(request,"num_of_consent_req_br",""));
	record.put("consent_form_id"				,chkPresent(request,"consent_form_id",""));
	record.put("consent_stage"					,chkPresent(request,"consent_stage",""));
	record.put("refusal_form_id"				,chkPresent(request,"refusal_form_id",""));
	record.put("priority_appl"				    ,chkPresent(request,"priority_appl",""));
	record.put("comment_format_id"				,chkPresent(request,"comment_format_id",""));
	record.put("dept_only_yn"					,chkPresent(request,"dept_only_yn","N"));
	record.put("complete_on_order_yn"			,chkPresent(request,"complete_on_order_yn","N"));
	record.put("bill_yn"						,chkPresent(request,"bill_yn","N"));
	record.put("charge_type_applicable"			,chkPresent(request,"charge_type_applicable","S"));
	record.put("result_applicable_yn"			,chkPresent(request,"result_applicable_yn","N"));
	if ((chkPresent(request,"complete_on_order_yn","N")).equals("Y") && (chkPresent(request,"result_applicable_yn","N")).equals("Y"))// Modified for TFSID-8081
	{
		record.put("auto_report_yn"					,"Y");
	}else
	record.put("auto_report_yn"					,chkPresent(request,"auto_report_yn","N"));
	//**record.put("image_link_id"					,chkPresent(request,"image_link_id",""));//moved to header frame.
	//record.put("indexed_yn"						,chkPresent(request,"indexed_yn","N"));
	record.put("result_auth_reqd_yn"			,chkPresent(request,"result_auth_reqd_yn","N"));
	record.put("order_catalog_nature"			,chkPresent(request,"order_catalog_nature","A"));
	//record.put("proc_coding_scheme"				,chkPresent(request,"proc_coding_scheme",""));
	record.put("chart_result_type"				,chkPresent(request,"chart_result_type",""));
	record.put("proc_coding_scheme"				,chkPresent(request,"proc_coding_scheme",""));
	record.put("discr_msr_panel_id"				,chkPresent(request,"discr_msr_panel_id",""));
	record.put("discr_msr_panel_id_desc"		,chkPresent(request,"discr_msr_panel_id_desc",""));
	record.put("contr_mod_id"					,chkPresent(request,"contr_mod_id",""));
	record.put("contr_msr_panel_id"				,chkPresent(request,"contr_msr_panel_id",""));
	record.put("proc_link_applicable"			,chkPresent(request,"proc_link_applicable","X"));
	if(!((chkPresent(request,"proc_link_applicable","X")).equals("R")))// Modified for TFSID-8081
	{
	record.put("proc_link_resulting_option"	,"");
	}else
	record.put("proc_link_resulting_option"	,chkPresent(request,"proc_link_resulting_option",""));
	/****if(chkPresent(request,"chart_result_type","").equals("P")){
		record.put("term_set_id"		,chkPresent(request,"scheme",""));
		record.put("term_code"		,chkPresent(request,"discr_msr_panel_id",""));

	}else{*/
	record.put("term_set_id"		,chkPresent(request,"term_set_id",""));
	record.put("term_code"		,chkPresent(request,"term_code",""));
	record.put("term_desc"		,chkPresent(request,"term_desc",""));
	//}
	record.put("chk_for_dupl_yn"				,chkPresent(request,"chk_for_dupl_yn","N"));
	record.put("chk_for_dupl_status"			,chkPresent(request,"chk_for_dupl_status",""));
	record.put("check_for_dupl_level"		    ,chkPresent(request,"check_for_dupl_level",""));
	//record.put("activity_type"		            ,chkPresent(request,"activity_type",""));
	record.put("chk_for_dupl_behind_action"		,chkPresent(request,"chk_for_dupl_behind_action",""));
	record.put("chk_for_dupl_behind_period"		,chkPresent(request,"chk_for_dupl_behind_period",""));
	record.put("chk_for_dupl_behind_unit"		,chkPresent(request,"chk_for_dupl_behind_unit",""));
	record.put("chk_for_dupl_ahead_action"		,chkPresent(request,"chk_for_dupl_ahead_action",""));
	record.put("chk_for_dupl_ahead_period"		,chkPresent(request,"chk_for_dupl_ahead_period",""));
	record.put("chk_for_dupl_ahead_unit"		,chkPresent(request,"chk_for_dupl_ahead_unit",""));
	record.put("confidential_yn"			    ,chkPresent(request,"confidential_yn","N"));
	record.put("routine_chk_for_dupl_yn"		,chkPresent(request,"routine_chk_for_dupl_yn","N"));
	record.put("urgent_chk_for_dupl_yn"			,chkPresent(request,"urgent_chk_for_dupl_yn","N"));
	record.put("stat_chk_for_dupl_yn"			,chkPresent(request,"stat_chk_for_dupl_yn","N"));
	record.put("explanatory_text"			    ,chkPresent(request,"explanatory_text",""));
	record.put("dup_reason_reqd_yn"			    ,chkPresent(request,"dup_reason_reqd_yn","N"));//IN024984
	record.put("barcode_reqd_yn"			,chkPresent(request,"barcode_reqd_yn","N"));//IN063816
	record.put("prn_regd_ord"			,chkPresent(request,"prn_regd_ord","N"));//IN065942

	record.put("fpp_yn", chkPresent(request,"fpp_yn",""));//IN068314
	record.put("fpp_category", chkPresent(request,"fpp_category",""));//IN068314
	record.put("freq_order_split_indvi_yn", chkPresent(request,"freq_order_split_indvi_yn",""));//7540
	record.put("external_requisition_yn", chkPresent(request, "external_requisition_yn", "N"));//68801
	if(characteristicsRecStr.isEmpty())
		characteristicsRecStr.add(record);

}
/****************chk whether parameter is coming from the client*******UTILTIY METHOD************************/
private String  chkPresent(Hashtable ht,String param , String defaultVal){
	if(ht.containsKey(param))
	return	checkForNull((String)ht.get(param),defaultVal);
	else
	return  defaultVal ;
}
/***********UTILITY METHOD This is method called from jsp for get rec in a particular array list at given index ----if not retrun  the  default value******/
public String getdefaultArrListValue(ArrayList ar ,int recIndex ,String  key , String defaultVal){

	boolean flag = ar.isEmpty();
	int size	 = ar.size() ;

	if( (recIndex >= size) || flag ) {

		return defaultVal;
	}

	HashMap currRec = (HashMap)ar.get(recIndex);

	if(currRec.containsKey(key))
	return	checkForNull((String)currRec.get(key),defaultVal);
	else
	return   defaultVal ;

}
/*****************Synchronization*****************************/
public synchronized boolean  doSync(Hashtable request) throws Exception{
try
{

	String tabType  = "";

	if(request.containsKey("tabType"))
		tabType = (String)request.get("tabType");


	if(tabType.trim().equalsIgnoreCase("C") || tabType.trim().equalsIgnoreCase("Timing"))
		CharactersticsSync(request);

	if(tabType.trim().equalsIgnoreCase("R"))
		reviewsSync(request);

	if(tabType.trim().equalsIgnoreCase("F"))
	{
		frequencySync(request);

	}

	if(tabType.trim().equalsIgnoreCase("Se"))
		settingsSync(request);


	if(tabType.trim().equalsIgnoreCase("I"))
		instructionSync(request);


	//if(tabType.trim().equalsIgnoreCase("B"))
		//billingSync(request);


    if(tabType.trim().equalsIgnoreCase("P")) {
        prepSync(request);
	}

	if(tabType.trim().equalsIgnoreCase("T")) {

		turnAroundSync(request);
	}

	return true;

    }catch(Exception e){
	   throw new Exception(e.getMessage());
  }
}

/**********************Store the Age Group for Setting Tab********/
public synchronized void setSettingsAgeGroupStr(){
	try
	{
		//Commented the if condition for IN006320 starts
		/*
        if(settingsAgeGroupStr == null){//Only for the first time
		
		 settingsAgeGroupStr  = getSqlResult("SQL_OR_CATALOG_SETTINGS_AGE_GROUP");
        }
		*/
		if(settingsAgeGroupStr == null){//Only for the first time
		settingsAgeGroupStr  = getSqlResult("SQL_OR_CATALOG_SETTINGS_AGE_GROUP");
		}
		//IN006320 Ends
		//Integer	noOfRecTemp			 = (Integer)settingsAgeGroupStr.get("noRec");
	//	int noOfRecordsAgeGroup		 = noOfRecTemp.intValue() ;



	}catch (Exception e){
		 //tempChk += "Exception =" + e.getMessage();
		e.printStackTrace();

	}

}

/**********************Store the Freq,dura type,value for Setting Tab********/
public synchronized void setSettingsFreqStr(String OrderCategory,String OrderCatalogCode){

	try
	{
		String param[] =  {OrderCategory.trim()};
		String param1[]={OrderCategory.trim(),OrderCatalogCode.trim(),OrderCategory.trim(),OrderCatalogCode.trim()};

		if(settingsFreqStr == null || settingsFreqStr.size() == 0){//Only for the first time

			if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
				 settingsFreqStr  = getSqlResultParam("SQL_OR_CATALOG_SETTINGS_FREQ_MODIFY",param1);



			}else{
				if(OrderCategory.trim().equalsIgnoreCase("PH"))//Only select freq where interval furn type is day
					 settingsFreqStr  = getSqlResultParam("SQL_OR_CATALOG_SETTINGS_FREQ_PH",param);
				else{

					 settingsFreqStr  = getSqlResultParam("SQL_OR_CATALOG_SETTINGS_FREQ",param);


					}
			}
		}

		Integer	noOfRecTemp			 = (Integer)settingsFreqStr.get("noRec");
		int noOfRecordsFreq			 = noOfRecTemp.intValue() ;

//		tempChk	 ="no if Rec" + noOfRecordsFreq;

		settingsFreqStrMapper = new HashMap() ;
		if(noOfRecordsFreq != 0){
		  for(int i=1 ; i <= noOfRecordsFreq; i++){
			settingsFreqStrMapper.put((String)settingsFreqStr.get("FREQ_CODE"+i),new Integer(i));
		  }
        }

	}catch (Exception e){
		// tempChk += "Exception =" + e.getMessage();
		e.printStackTrace();
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

		Integer indxTemp =(Integer)objTemp;
		int indx = indxTemp.intValue();

		HashMap rec= new HashMap();

		rec.put("durn_value",(String)settingsFreqStr.get("DURN_VALUE"+indx));
		rec.put("durn_type" ,(String)settingsFreqStr.get("DURN_TYPE"+indx));
		rec.put("durn_desc" ,(String)settingsFreqStr.get("DURN_DESC"+indx));

		return rec ;


}catch (Exception e){
	throw new Exception(e.getMessage());
}

}
/**********************Store the Consent ID for Instruction Tab********/
public synchronized void setInstructionsConsentStr(){
	try
	{
		if(instructionsConsentStr == null)//Only for the first time
			instructionsConsentStr  = getSqlResult("SQL_OR_CATALOG_CONSENT_FORMAT");
}catch(Exception e){e.printStackTrace() ;
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
	sql		   = OrRepository.getOrKeyValue(key.trim());
	pstmt	   = connection.prepareStatement(sql);
	if(key.trim().equals("SQL_OR_PATIENT_CLASS_LIST"))
	pstmt.setString(1,language_id);
	if(key.trim().equals("SQL_OR_CHECK_MODULE_INSTALL_YN"))
	pstmt.setString(1,"BL");
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
	throw new Exception(e.getMessage());
}finally{
	try{
		closeResultSet( rs ) ;
		closeStatement( pstmt ) ;
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
	throw new Exception(e.getMessage());
}finally{
	try{
		closeResultSet( rs ) ;
		closeStatement( pstmt ) ;
		closeConnection(connection);
	 }catch(Exception e){e.printStackTrace() ;}
}

}
/************************to get the Type********************/
public String getType(String module_id) {

Connection connection	= null ;
PreparedStatement pstmt = null ;
ResultSet rs			= null;
String result="N";

try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_CHECK_MODULE_INSTALL_YN") ) ;
			pstmt.setString(1, module_id);
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
	/*****public ArrayList getProc_code_scheme() {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList Proc_code_scheme		= new ArrayList() ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CATALOG_PROC_CODE_SCHEME_SELECT") ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "scheme" )  ;
				record[1] = resultSet.getString( "scheme_desc" )  ;

				Proc_code_scheme.add(record) ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			//throw e ;
		} finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			} catch (Exception e) {
				e.printStackTrace() ;
			}
		}

		return Proc_code_scheme;
	}

	public String getProc_desc(String diag_code) {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		PreparedStatement pstmt1 	= null;
		ResultSet resultSet 		= null;
		String proc_desc			= "";
		String scheme               = "";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CATALOG_PROC_CODE_SCHEME_SELECT") ) ;
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next() ) {
				scheme = resultSet.getString( "scheme" )  ;
			}
			if (scheme.equals("3")){
                pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CATALOG_PROC_DESC_SELECT_CPT") ) ;
			} else {
                pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CATALOG_PROC_DESC_SELECT_ICD") ) ;
			}
			pstmt1.setString(1,diag_code);
			resultSet = pstmt1.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				proc_desc = resultSet.getString( "short_desc" )  ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			//throw e ;
		} finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeStatement( pstmt1 ) ;
				closeConnection(connection) ;
			} catch (Exception e) {
				e.printStackTrace() ;
			}
		}

		return proc_desc;
	}***/

		public String getResultTemp_desc(String result_temp_id) {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String ResultTemp_desc			= "";

        try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CATALOG_RESULT_TEMPLATE_DESC_SELECT") ) ;
			pstmt.setString(1,result_temp_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				ResultTemp_desc = resultSet.getString( "short_desc" )  ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			//throw e ;
		} finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			} catch (Exception e) {
				e.printStackTrace() ;
			}
		}

		return ResultTemp_desc;
	}

	public String getResultMatrix_desc(String ResultMatrix_code) {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String ResultMatrix_desc			= "";

        try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CATALOG_RESULT_MARTRIX_DESC_SELECT") ) ;
			pstmt.setString(1,ResultMatrix_code);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				ResultMatrix_desc = resultSet.getString( "short_desc" )  ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			//throw e ;
		} finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			} catch (Exception e) {
				e.printStackTrace() ;
			}
		}

		return ResultMatrix_desc;
	}

	public String getNotes_desc(String notes_code) {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String notes_desc			= "";

        try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CATALOG_NOTES_DESC_SELECT") ) ;
			pstmt.setString(1,notes_code);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				notes_desc = resultSet.getString( "short_desc" )  ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			//throw e ;
		} finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			} catch (Exception e) {
				e.printStackTrace() ;
			}
		}

		return notes_desc;
	}

	public String getChart_desc(String chart_code) {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String chart_desc			= "";

        try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CATALOG_CHART_DESC_SELECT") ) ;
			//pstmt.setString(1,language_id);
			pstmt.setString(1,chart_code);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				chart_desc = resultSet.getString( "short_desc" )  ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			//throw e ;
		} finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			} catch (Exception e) {
				e.printStackTrace() ;
			}
		}

		return chart_desc;
	}

    /********Gives the DataBase Record if already  present or for Ascc /else Original DataBase record***********/
	public boolean setBeanItemValue(int rowIndex, String ascc, String sec_order_stage_stat, String sec_order_stat_durn, String sec_order_stat_durn_type, String sec_order_stage_urg, String sec_order_urg_durn, String sec_order_urg_durn_type, String sec_order_stage_rtn, String sec_order_rtn_durn, String sec_order_rtn_durn_type,String pri_sec_tasks_type)throws Exception{

		boolean altSelRecord  =	false;
		boolean altDBRecord =	false;
		int foundIndex = 0;
		//String valid ="";
		java.util.HashMap hash = new java.util.HashMap();
		//java.util.HashMap hashDB = new java.util.HashMap();

		hash = (java.util.HashMap)multiRecBean.getListObject(rowIndex);

		//String pk =(String)hash.get("code");//Primary Key

		if(ascc.equals("Y")){

        	hash.put("associate_yn","Y");

            //hash.put("status","Y");

	        hash.put("sec_order_stage_stat", sec_order_stage_stat);
			hash.put("sec_order_stat_durn", sec_order_stat_durn);
			hash.put("sec_order_stat_durn_type", sec_order_stat_durn_type);

			hash.put("sec_order_stage_urg", sec_order_stage_urg);
			hash.put("sec_order_urg_durn", sec_order_urg_durn);
			hash.put("sec_order_urg_durn_type", sec_order_urg_durn_type);

			hash.put("sec_order_stage_rtn", sec_order_stage_rtn);
			hash.put("sec_order_rtn_durn", sec_order_rtn_durn);
			hash.put("sec_order_rtn_durn_type", sec_order_rtn_durn_type);
			hash.put("pri_sec_tasks_type", pri_sec_tasks_type);


			altSelRecord = multiRecBean.setListObject(rowIndex, hash);

			if(altSelRecord){
				foundIndex = multiRecBean.scanRecord(hash);
				if(foundIndex != -1){
					altDBRecord = multiRecBean.setObject(foundIndex,hash);
				}else{
					altDBRecord = multiRecBean.putObject(hash);
				}
			}
		}else {
			foundIndex = multiRecBean.scanRecord(hash);

			if(foundIndex != -1){
				altDBRecord = multiRecBean.removeObject(foundIndex);
			}
        }

		return altDBRecord;
	}

    /**
	  * Used to set the latest status of the bean value in the Associted records and inturn
	  * keep both to ArrayList in Synchronize, based on the operations
	  * performed on them.
	  * @param rowIndex refers the row Position.
	  *	@param value refers to the latest value.
	  */
	public boolean setDBBeanItemValue(int rowIndex, String sec_order_stage_stat, String sec_order_stat_durn, String sec_order_stat_durn_type, String sec_order_stage_urg, String sec_order_urg_durn, String sec_order_urg_durn_type, String sec_order_stage_rtn, String sec_order_rtn_durn, String sec_order_rtn_durn_type,String pri_sec_tasks_type)throws Exception{

		boolean altDBRecord =	false;
		//String valid ="";
		java.util.HashMap hash = new java.util.HashMap();
		hash = (java.util.HashMap)multiRecBean.getObject(rowIndex);

        hash.put("sec_order_stage_stat", sec_order_stage_stat);
		hash.put("sec_order_stat_durn", sec_order_stat_durn);
		hash.put("sec_order_stat_durn_type", sec_order_stat_durn_type);

		hash.put("sec_order_stage_urg", sec_order_stage_urg);
		hash.put("sec_order_urg_durn", sec_order_urg_durn);
		hash.put("sec_order_urg_durn_type", sec_order_urg_durn_type);

		hash.put("sec_order_stage_rtn", sec_order_stage_rtn);
		hash.put("sec_order_rtn_durn", sec_order_rtn_durn);
		hash.put("sec_order_rtn_durn_type", sec_order_rtn_durn_type);
		hash.put("pri_sec_tasks_type", pri_sec_tasks_type);

		altDBRecord = multiRecBean.setObject(rowIndex,hash);
		return altDBRecord;
	}

	/*********Method to fetch the Data Base Values*************/
 public int fetchDBRecords(String pri_order_catalog_code)throws Exception {

	int total_rec =0;
	Connection connection = null ;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	PreparedStatement pstmt2=null;
	//HashMap htMapRecord = new HashMap();
	Hashtable prepHash = null;
	ResultSet rs=null;
	ResultSet rs1=null;
	ResultSet rs2=null;

	String SQL_QUERY1="",SQL_QUERY="", code="", desc="", performing_locn="",SQL_QUERY2="", patient_class="",patient_class_chk = "" ;
	String sec_order_stage_stat        =	"";
	String sec_order_stat_durn         =	"";
	String sec_order_stat_durn_type    =	"";

    String sec_order_stage_urg         =	"";
	String sec_order_urg_durn          =	"";
	String sec_order_urg_durn_type     =	"";

    String sec_order_stage_rtn         =	"";
	String sec_order_rtn_durn          =	"";
	String sec_order_rtn_durn_type	   =	"";
	String pri_sec_tasks_type="";
	try{
		int checkRec = multiRecBean.getSize("DB");

		if(checkRec==0){
			connection = getConnection();
			SQL_QUERY1 = OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_SEC_TASKS_UPDATE_SELECT");
			SQL_QUERY2=OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_SEC_TASKS_UPDATE");


			pstmt1 = connection.prepareStatement(SQL_QUERY1);
			pstmt1.setString(1,pri_order_catalog_code);
			pstmt1.setString(2,pri_order_catalog_code);
			rs1 = pstmt1.executeQuery();

			if(rs1 != null){

                int index   = 0;
                prepHash = new Hashtable();
                while(rs1.next()){

                    patient_class = rs1.getString(1);
                    patient_class_chk = rs1.getString(3);
					pri_sec_tasks_type=rs1.getString(4);

                    prepHash.put("patient_class_chk"+index, patient_class_chk);
                    prepHash.put("patient_class"+index, patient_class);
                    index++;
                }
				pstmt2 = connection.prepareStatement(SQL_QUERY2);
				pstmt2.setString(1,pri_order_catalog_code);
				rs2 = pstmt2.executeQuery();
				while(rs2.next()){
				pri_sec_tasks_type=rs2.getString(1);
				}

				for(int i=0;i<index;i++)
				prepHash.put("pri_sec_tasks_type"+i, pri_sec_tasks_type);

				pri_sec_tasks_type=(String)prepHash.get("pri_sec_tasks_type0");



                prepHash.put("tot_recs",""+index);

			    prepSync(prepHash);

			}
			if(pri_sec_tasks_type.equals("I")){


				SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_INTERVENTION_SEC_TASKS_SELECT");
			}else
			{

				SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_SEC_TASKS_SELECT");
			}
			pstmt = connection.prepareStatement(SQL_QUERY);

            pstmt.setString(1,pri_order_catalog_code);


			rs = pstmt.executeQuery();

			//int counter = 0;

			if(rs != null){

               String temp_code = "";
				//HashMap htMapRecord		=	new HashMap();
                while(rs.next()){
                    HashMap htMapRecord		=	new HashMap();
    				code					    =	rs.getString("code");
    				if (!temp_code.equals(code)) {

        				temp_code                   =   code;
        				desc					    =	rs.getString("short_desc");
        				patient_class               =   rs.getString("patient_class");
        				sec_order_stage_stat        =	rs.getString("sec_order_stage_stat");
        				sec_order_stat_durn         =	rs.getString("sec_order_stat_durn");
        				sec_order_stat_durn_type	=	rs.getString("sec_order_stat_durn_type");

                        sec_order_stage_urg         =	rs.getString("sec_order_stage_urg");
        				sec_order_urg_durn          =	rs.getString("sec_order_urg_durn");
        				sec_order_urg_durn_type     =	rs.getString("sec_order_urg_durn_type");

                        sec_order_stage_rtn         =	rs.getString("sec_order_stage_rtn");
        				sec_order_rtn_durn          =	rs.getString("sec_order_rtn_durn");
        				sec_order_rtn_durn_type	    =	rs.getString("sec_order_rtn_durn_type");

        				if(desc == null || desc.equals("null"))desc="";
        				if (patient_class == null || patient_class.equals("null")) patient_class = "";
        				if (performing_locn == null || performing_locn.equals("null")) performing_locn = "";

        				if (sec_order_stage_stat == null || sec_order_stage_stat.equals("null")) sec_order_stage_stat = "";
        				if (sec_order_stat_durn == null || sec_order_stat_durn.equals("null")) sec_order_stat_durn = "";
        				if (sec_order_stat_durn_type == null || sec_order_stat_durn_type.equals("null")) sec_order_stat_durn_type = "";

        				if (sec_order_stage_urg == null || sec_order_stage_urg.equals("null")) sec_order_stage_urg = "";
        				if (sec_order_urg_durn == null || sec_order_urg_durn.equals("null")) sec_order_urg_durn = "";
        				if (sec_order_urg_durn_type == null || sec_order_urg_durn_type.equals("null")) sec_order_urg_durn_type = "";

        				if (sec_order_stage_rtn == null || sec_order_stage_rtn.equals("null")) sec_order_stage_rtn = "";
        				if (sec_order_rtn_durn == null || sec_order_rtn_durn.equals("null")) sec_order_rtn_durn = "";
        				if (sec_order_rtn_durn_type == null || sec_order_rtn_durn_type.equals("null")) sec_order_rtn_durn_type = "";

        				htMapRecord.put("code"				,	code);
        				htMapRecord.put("catalog_desc"		,	desc);

                        htMapRecord.put("sec_order_stage_stat"       , 	sec_order_stage_stat);
        				htMapRecord.put("sec_order_stat_durn"          , 	sec_order_stat_durn);
        				htMapRecord.put("sec_order_stat_durn_type" 	, 	sec_order_stat_durn_type);

        				htMapRecord.put("sec_order_stage_urg"       , 	sec_order_stage_urg);
        				htMapRecord.put("sec_order_urg_durn"          , 	sec_order_urg_durn);
        				htMapRecord.put("sec_order_urg_durn_type" 	, 	sec_order_urg_durn_type);

        				htMapRecord.put("sec_order_stage_rtn"       , 	sec_order_stage_rtn);
        				htMapRecord.put("sec_order_rtn_durn"          , 	sec_order_rtn_durn);
        				htMapRecord.put("sec_order_rtn_durn_type" 	, 	sec_order_rtn_durn_type);

        				htMapRecord.put("valid"				,	"Y");
        				htMapRecord.put("associate_yn"		,   "Y");
        				htMapRecord.put("status"			,   "N");

        				multiRecBean.putObject(htMapRecord);

    				}
					//htMapRecord.clear();
			    }
            }
	}
	total_rec = multiRecBean.getSize("DB");

	}
	catch(Exception e){
		e.printStackTrace();
		throw e;
	}
	finally{
		try{
			closeResultSet(rs2);
			closeStatement(pstmt2);
			closeResultSet(rs1);
			closeStatement(pstmt1);
            closeResultSet(rs);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		catch(Exception e){throw e;}
	}

	return total_rec;
 }//end of fetchDBRecords

 /*********************Method to fetch Alphabetical Records ***********************/

 public Object getRecordSet(String index,String pri_sec_tasks_type)throws Exception{

	Connection connection = null ;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String SQL_QUERY="" ;
	try{
		//java.util.HashMap htRecord = new HashMap();
		String  catalog_desc="", code="";//status="E",valid="N";
		connection = getConnection();
		multiRecBean.clearSelectRec();
		if(pri_sec_tasks_type.equals(""))
			pri_sec_tasks_type="";

		if(pri_sec_tasks_type.equals("I"))
		{

			if(!(index.equals("OTH"))){

				SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_INTERVENTION_DESC");
			}else{

				SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_INTERVENTION_DESC_OTH");
			}
		}else{
		if(!(index.equals("OTH"))){

			SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_CATALOG_DESC");
		}else{

			SQL_QUERY = OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_CATALOG_DESC_OTH");
		}
		}
		pstmt = connection.prepareStatement(SQL_QUERY);
		if(!(index.equals("OTH"))){

			pstmt.setString(1,index+"%");
		}


		rs = pstmt.executeQuery();
		//ArrayList dbRecords = new ArrayList();
		//HashMap tempHash = new HashMap();
		//String tempStatus="";
		if(rs != null){
			while(rs.next()){
				code				=	rs.getString(2);
				catalog_desc		=	rs.getString("short_desc");
				//valid				=	rs.getString("valid");

				/*if(valid.equals("Y"))
					status="D";
				else if(valid.equals("N"))
					status="E";
				*/
				if(catalog_desc == null || catalog_desc.equals("null"))catalog_desc="";

				java.util.HashMap htRecord = new HashMap();
				htRecord.put("code"			,	code);
				htRecord.put("catalog_desc"	,	catalog_desc);

                htRecord.put("sec_order_stage_stat"  ,	"");
				htRecord.put("sec_order_stat_durn"     ,	"");
				htRecord.put("sec_order_stat_durn_type",	"");

				htRecord.put("sec_order_stage_urg"  ,	"");
				htRecord.put("sec_order_urg_durn"     ,	"");
				htRecord.put("sec_order_urg_durn_type",	"");

                htRecord.put("sec_order_stage_rtn"  ,	"");
				htRecord.put("sec_order_rtn_durn"     ,	"");
				htRecord.put("sec_order_rtn_durn_type",	"");

				htRecord.put("valid"		,	"N");
				htRecord.put("associate_yn" ,   "N");
				htRecord.put("status"		,	"N");

				if (!multiRecBean.containsElement(code)) {


					multiRecBean.putListObject(htRecord);
				} else {

					int foundIndex = -1;
					ArrayList dbRecords = multiRecBean.getAllDBRecords();
					if(dbRecords!=null){
						//tempStatus="";
						for(int i=0; i<dbRecords.size(); i++){

							HashMap tempHash =(java.util.HashMap)multiRecBean.getObject(i);
							boolean containsElement = tempHash.containsValue(code);
							if(containsElement){
								String tempStatus = (String)tempHash.get("status");
								if(tempStatus.equals("N")){
									foundIndex = i;
									break;
								}
							}
						}
					}


					if(foundIndex != -1){

						htRecord = (HashMap)multiRecBean.getObject(foundIndex);

						multiRecBean.putListObject(htRecord);
					}
				}

				/*htRecord.clear();
				dbRecords.clear();
				tempHash.clear();*/
			}
		}


	}
	catch(Exception e){
		e.printStackTrace();
		throw e;
	}
	finally{
		try{
			closeResultSet(rs);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		catch(Exception e){throw e;}
	}
	return multiRecBean;
 }//end of getRecordSet

 /***************************To get the multiRecord bean ***********/
 public Object getBean(){
	return this.multiRecBean;
 }//end of getBean

 /***************************To clear the multiRecord bean ***********/
  public boolean clearDBRec()throws Exception{
	boolean clearFlag = false;
	clearFlag = multiRecBean.clearDBRec();
	return clearFlag;
 }//end of clearDBRec

/*****************populating of term_set list box********************/
public ArrayList populateTermSetID () throws Exception
	{
		ArrayList TermSetID = new ArrayList() ;
		Connection connection=null;
		java.sql.ResultSet resultSet=null;
		java.sql.PreparedStatement pstmt = null;

		try {
			connection=	getConnection() ;
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_POPULATE_TERM_SET_ID") ) ;
			if(!(pstmt==null)){
				resultSet = pstmt.executeQuery() ;
			}
			String[] record =null;
			while ( resultSet != null && resultSet.next() ) {
				record = new String[2];
				record[0] = resultSet.getString( "term_set_id" )  ;
				record[1] = resultSet.getString( "term_set_desc" )  ;
				TermSetID.add(record) ;
			}
		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection) ;
		}
		return TermSetID;
	}

	public String get_pri_splty_desc(String pri_splty_code)
	{

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet rs			= null;
		String pri_splty_desc="";

		try
		{
				connection = getConnection() ;
				pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_CATALOG_SPLTY_DESC") ) ;
				pstmt.setString(1, pri_splty_code);
				rs = pstmt.executeQuery() ;
				while (rs.next())
				{
					pri_splty_desc=rs.getString("description");
				}

		}
		catch( Exception e )
		{
			e.printStackTrace() ;
		}
		finally
		{
			try
			{
				closeResultSet( rs ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			} catch (Exception ee)
			{
					ee.printStackTrace() ;
			}
		}
		return pri_splty_desc;
	}

	public int getConsentNumData(String order_catalog_code,String obj_name,String obj_value)
	{

		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet rs			= null;
		int consent_count=0;

		try
		{
				connection = getConnection() ;
				pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_CATALOG_CONSENT_DTL_CNT") ) ;
				if(obj_name.equals("num_of_consent_req_bo"))
				{
					pstmt.setString(1, "A");
				}
				else if(obj_name.equals("num_of_consent_req_br"))
				{
					pstmt.setString(1, "R");
				}
				pstmt.setString(2, order_catalog_code);
				rs = pstmt.executeQuery() ;
				while (rs.next())
				{
					consent_count=rs.getInt("cnt_consent");
				}
				if(consent_count>Integer.parseInt(obj_value))
				{
					return consent_count;
				}
				else
				{
					return 0;
				}

		}
		catch( Exception e )
		{
			e.printStackTrace() ;
		}
		finally
		{
			try
			{
				closeResultSet( rs ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			} catch (Exception ee)
			{
					ee.printStackTrace() ;
			}
		}
		return consent_count;
	}

public String getDescriptions(String drugcode)
{
		String description = "";
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet rs			= null;
		try
		{
				connection = getConnection() ;
				pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_CATALOG_DESC_PH") ) ;
				pstmt.setString(1, drugcode);
				rs = pstmt.executeQuery() ;
				while (rs.next())
				{
					description=rs.getString("drug_desc");
				}
		}
		catch( Exception e )
		{
			e.printStackTrace() ;
		}
		finally
		{
			try
			{
				closeResultSet( rs ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection) ;
			} catch (Exception ee)
			{
					ee.printStackTrace() ;
			}
		}
		return description;
}

/* Added on 9/29/2009 by kishore kumar N on 10-Spet-09, For CRF-691*/
public String getLinkedVaccineId(String orderCatalogCode, String locale)
{
	String lnkVaccineId = "";
	Connection con	= null ;
	PreparedStatement pst = null ;
	ResultSet rs = null;
	try
	{
			con = getConnection() ;
			pst = con.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_CATALOG_LINKED_VACCINE_SELECT")) ;
			pst.setString(1, locale);
			pst.setString(2, orderCatalogCode);
			rs = pst.executeQuery() ;
			while (rs.next())
			{
				lnkVaccineId = rs.getString(1)+"`~"+rs.getString(2);
			}
	}
	catch( Exception e )
	{
		e.printStackTrace() ;
	}
	finally
	{
		try
		{
			closeResultSet(rs);
			closeStatement(pst);
			closeConnection(con);
		} catch (Exception ee)
		{
				ee.printStackTrace() ;
		}
	}
	return lnkVaccineId;
}
/*ends here.*/
// added for IN031304
public String getOaIntegrationKey()
{
	String rd_oa_integration_key = "";
	Connection con	= null ;
	PreparedStatement pst = null ;
	ResultSet rs = null;
	try
	{
		con = getConnection() ;
		pst = con.prepareStatement(OrRepository.getOrKeyValue("SQL_OA_INEGRATION_PARAM_SELECT"));
		rs = pst.executeQuery() ;
		while (rs.next())
		{
			rd_oa_integration_key = rs.getString(1);
		}
	}
	catch( Exception e )
	{
		e.printStackTrace() ;
	}
	finally
	{
		try
		{
			closeResultSet(rs);
			closeStatement(pst);
			closeConnection(con);
		} catch (Exception ee)
		{
				ee.printStackTrace() ;
		}
	}
	return rd_oa_integration_key;
}


	public void clearPatInstrnsRecStr() {		
		if (getInstructionsRecStr() != null && getInstructionsRecStr().size()>0) {
			HashMap patInstnPrDr = (HashMap) getInstructionsRecStr().get(1);
			patInstnPrDr.clear();
			HashMap patInstnStnd = (HashMap) getInstructionsRecStr().get(2);
			patInstnStnd.clear();
			HashMap patInstnAge = (HashMap) getInstructionsRecStr().get(3);
			patInstnAge.clear();
		}
	}//IN64543, ends
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
	// IN071721 Start.
	// IN072190 - modified method name from 'getShortDescription'
	public HashMap getMMDescriptions(String drugcode,String locale)
	{
			String description = "";
			Connection connection	= null ;
			PreparedStatement pstmt = null ;
			ResultSet rs			= null;
			HashMap result			= new HashMap();
			try 
			{
					connection = getConnection() ;
					pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_FETCH_DESCRIPTION_MM") ) ;
					pstmt.setString(1, drugcode);
					pstmt.setString(2, locale);
					rs = pstmt.executeQuery() ;
					while (rs!=null && rs.next())
					{
						result.put("LONG_DESC",rs.getString("LONG_DESC"));
						result.put("SHORT_DESC",rs.getString("SHORT_DESC"));
					}
			}
			catch( Exception e )
			{
				e.printStackTrace() ;
			}
			finally
			{
				try
				{
					closeResultSet( rs ) ;
					closeStatement( pstmt ) ;
					closeConnection(connection) ;
				} catch (Exception ee)
				{
						ee.printStackTrace() ;
				}
			}
			return result;
	}
	// IN072190 End.
}
