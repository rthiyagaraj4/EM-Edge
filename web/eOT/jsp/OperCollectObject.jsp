<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%
  String locale = (String)session.getAttribute("LOCALE");
String tab_name = checkForNull(request.getParameter("tab_name"));
%>

<html>
<head>
	<script type='text/javascript' src='../../eOT/js/OTCommon.js'></script>
	<script type='text/javascript' src='../../eOT/js/RecordSurgeon.js'></script>
	<script type='text/javascript' src='../../eOT/js/CommonOperDtlsHdr.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
	


<script language='javascript'>

function convertDate(date,format,from,to){
	var xhr =  getXHR();
	var url = "../../eCommon/jsp/DateUtils.jsp?methodName=convertDate&format="+format+"&date="+date+"&fromLocale="+from+"&toLocale="+to;
    xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type","text/plain")
   	xhr.send("");
	
	var xmlText =  trimString(xhr.responseText)
	return(xmlText);
}

function getXHR(){
	var request = false;
	try {
		request = new XMLHttpRequest();
	}catch (trymicrosoft) {
		try {
			request = new ActiveXObject("Msxml2.XMLHTTP");
		}catch (othermicrosoft) {
			try {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (failed) {
				request = false;
			}
		}
    }
	if (!request){
		alert("System Error initializing XMLHttpRequest!");
		return;
	}else return request;
}
var ICD_PCS_ROWS=new Array();
var ICD_PCS_LEN=0;
var rows = new Array();
var rowLength=0;
var line_no=0;
var serial_no=0;

var personnelrows = new Array();
var tempPersonnelRows = new Array();//Added for CHL-CRF-0020.1 [IN:043132]
var personnelrowLength=0;
var diagnosis_rows = new Array();
var diagnosis_len = 0;
//for displaying the rows only one time from db(initially)
var db_flag="ON";
var primary_flag="ON";
var diagnosis_text="";
var wound_rows = new Array();
var wound_len = 0; // added on 13/02/2009
var notes_rows = new Array();
var DIAG_MODIFIED_FLAG="ON";
var visit_pers_rows=new Array();
var visit_pers_len=0;
var time_rows = new Array();
var time_len = 0;
//Added by Suma wrt Surgical Accessories changes
var instrument_rows = new Array();
var instrument_len=0;
var equipment_rows = new Array();
var equipment_len = 0;
var packs_rows=new Array();
var packs_len = 0;
var implants_rows = new Array();
var implants_len = 0;
var cnt=0;//for patient History display
var splty_code="";

var Bill_Sub_Services_Rows=new Array();
var Bill_Sub_Services_len=0;
var AUTO_LEN =0;
var TIME_AND_DETAILS_ENTERED="N";
var VISIT_PERSONEL_ENTERED="N";
var WOUND_DETAILS_ENTERED="N";
var mandatory_proc=new Array();
</script>
<script language='javascript'>
 function createXMLForPersonnel(){
  var rows=parent.ObjectCollect.personnelrows;
  var table_name="OT_POST_OPER_PERSONNEL";
  var len = rows.length;
  var xmlString ="";
  for(var i=0;i<len;i++){
	 if(rows[i]!=null &&  rows[i].db_mode!='L'){
		xmlString+="<PER_DTL"+i+" ";
		xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
		xmlString+="speciality_code=\""+rows[i].speciality_code+"\""+" ";
		xmlString+="role_id=\""+rows[i].role_id+"\""+" ";
		xmlString+="role_type=\""+rows[i].role_type+"\""+" ";
		xmlString+="practitioner_id=\""+rows[i].practitioner_id+"\""+" ";
		xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
	
	 }
  }
  return xmlString;
}

////Commented by rajesh for Uniue Constraing PK error TH_OT_SPR-3270
/*function createXMLForVisitPersonnel(){
  var rows=parent.ObjectCollect.visit_pers_rows;
  var table_name="VISIT_PERSONNEL";
  var len = rows.length;
  var xmlString ="";
  for(var i=0;i<len;i++){
	 if(rows[i]!=null &&  rows[i].db_mode!='L' && rows[i].verify_flag=="OFF"){
		xmlString+="<PER_DTL"+i+" ";
		xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
		xmlString+="speciality_code=\""+rows[i].speciality_code+"\""+" ";
		xmlString+="visit_desc=\""+rows[i].visit_desc+"\""+" ";
		xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
	}
  }
  return xmlString;
}*/
/*
function createXMLForVisitPersonnel(){
  var rows=parent.ObjectCollect.visit_pers_rows;
  var rows_time=parent.ObjectCollect.time_rows;
  var rows_wound=parent.ObjectCollect.wound_rows;
  var table_name="VISIT_PERSONNEL";
  var len = rows.length;
  TIME_AND_DETAILS_ENTERED = (rows_time.length>0)?"Y":"N";
  WOUND_DETAILS_ENTERED = (rows_wound.length>0)?"Y":"N";
  if(TIME_AND_DETAILS_ENTERED=="Y") return "";
  var xmlString ="";
  for(var i=0;i<len;i++){
	 if(rows[i]!=null && rows[i].db_mode!='L'){
		xmlString+="<PER_DTL"+i+" ";
		xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
		xmlString+="speciality_code=\""+rows[i].speciality_code+"\""+" ";
		xmlString+="visit_desc=\""+rows[i].visit_desc+"\""+" ";
		if(WOUND_DETAILS_ENTERED=="Y" && (rows[i].speciality_code == wound_rows[i].speciality_code) ){
			xmlString+="wound_code=\""+wound_rows[i].wound_code+"\""+" ";
		}
		xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
	}
  }
  return xmlString;
} commented by Sathish.K on 19-02-2009*/

function createXMLForOperations(){
  var rows=parent.ObjectCollect.rows;
  var bill_flag=document.forms[0].bill_flag.value;
  var len = rows.length;
  var table_name = "OT_POST_OPER_DTLS";
  var xmlString ="";
  var tab_name = document.forms[0].tab_name.value;


  for(var i=0;i<len;i++){
	 // here we skip the rows db_mode='L' since no modification is done (fetched records from db)
	 //if(rows[i]!=null && rows[i].db_mode!='L'){
	 if(rows[i]!=null){
		 if(rows[i].fpp_category=='' || rows[i].fpp_category ==undefined || rows[i].fpp_category == null )
			 rows[i].fpp_category="";
		xmlString+="<PROC_DTL"+i+" ";
		xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
		xmlString+="oper_code=\""+rows[i].oper_code+"\""+" ";
		xmlString+="right_left_flag=\""+rows[i].side_applicable+"\""+" ";
		xmlString+="oper_remarks=\""+encodeURIComponent(rows[i].remarks,"UTF-8")+"\""+" ";
		xmlString+="oper_line_num=\""+rows[i].line_no+"\""+" ";
		xmlString+="order_line_num=\""+rows[i].order_line_no+"\""+" ";
		xmlString+="oper_line_status=\""+rows[i].chk_status+"\""+" ";
		xmlString+="cancel_remarks=\""+encodeURIComponent(rows[i].cancel_remarks,"UTF-8")+"\""+" ";
		xmlString+="Speciality_code=\""+rows[i].Speciality_code+"\""+" ";
		xmlString+="order_catalog_code=\""+rows[i].order_catalog_code+"\""+" ";
		if(bill_flag=="true")
		{
		xmlString+="fpp_category=\""+rows[i].fpp_category+"\""+" ";//Added Against ML-MMOH-CRF-1939-US4
		/* if(rows[i].fpp_category === 'S' || rows[i].fpp_category === 'M' || rows[i].fpp_category === 'C' )
			rows[i].fpp_yn = 'Y';
		else rows[i].fpp_yn = 'N'; */
		if(rows[i].fpp_order_yn=='' || rows[i].fpp_order_yn ==undefined || rows[i].fpp_order_yn == null)
			rows[i].fpp_order_yn = "N";
		else rows[i].fpp_order_yn = rows[i].fpp_order_yn;
		xmlString+="fpp_yn=\""+rows[i].fpp_order_yn+"\""+" ";//Added Against ML-MMOH-SCF-2511-TF
		xmlString+="bill_str=\""+rows[i].rate+"::"+rows[i].bill_str+"\""+" ";
		xmlString+="panel_str=\""+escape(rows[i].panel_str)+"\""+" ";
		}

		xmlString+="order_id=\""+rows[i].order_id+"\""+" ";
		
		if(rows[i].db_mode=="L")
			xmlString+="db_mode=\""+"U"+"\""+" ";
		else
			xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		
		//xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
	 }
  }
 return xmlString;
}

function createXMLForPostOperDiagnosis(){
  var rows=parent.ObjectCollect.diagnosis_rows;
  var len = rows.length;
  var table_name = "OT_POST_OPER_DIAG";
  var xmlString ="";
  for(var i=0;i<len;i++){
	 // here we skip the rows db_mode='L' since no modification is done (fetched records from db)
	 if(rows[i]!=null && rows[i].db_mode!='L'){
		xmlString+="<DIAG_DTL"+i+" ";
		xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
		xmlString+="diag_code=\""+rows[i].icd_code+"\""+" ";
		xmlString+="scheme_code=\""+rows[i].scheme_code+"\""+" ";
		xmlString+="srl_no=\""+rows[i].srl_no+"\""+" ";
		xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
	 }
  }
 return xmlString;
}

function createXMLForProblemTable(){
  var rows=parent.ObjectCollect.diagnosis_rows;
  var len = rows.length;
  var table_name = "PR_PROBLEM";
  var xmlString ="";
  for(var i=0;i<len;i++){
	 // here we skip the rows db_mode='L' since no modification is done (fetched records from db)
	 if(rows[i]!=null && rows[i].db_mode!='L'){
		xmlString+="<PR_DTL"+i+" ";
		//xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
		xmlString+="patient_id=\""+rows[i].patient_id+"\""+" ";
		xmlString+="srl_no=\""+rows[i].srl_no+"\""+" ";
		xmlString+="diag_code=\""+rows[i].icd_code+"\""+" ";
		xmlString+="scheme_code=\""+rows[i].scheme_code+"\""+" ";
		xmlString+="diag_desc=\""+rows[i].icd_desc+"\""+" ";
		
		xmlString+="onset_date=\""+rows[i].onset_date+"\""+" ";
		xmlString+="close_date=\""+rows[i].close_date+"\""+" ";
		
		xmlString+="primary=\""+rows[i].primary+"\""+" ";
		xmlString+="significant=\""+rows[i].significant+"\""+" ";
		
		xmlString+="notifiable=\""+rows[i].notifiable+"\""+" ";
		xmlString+="sensitive=\""+rows[i].sensitive+"\""+" ";

		xmlString+="surgeon_code=\""+rows[i].surgeon_code+"\""+" ";
		xmlString+="encounter_id=\""+rows[i].encounter_id+"\""+" ";
		xmlString+="source_code=\""+rows[i].source_code+"\""+" ";
		xmlString+="source_type=\""+rows[i].source_type+"\""+" ";
		
		xmlString+="v_stat=\""+rows[i].v_stat+"\""+" ";
		xmlString+="remarks=\""+rows[i].remarks+"\""+" ";
		
		xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";

	 }
  }
 return xmlString;
}
function createXMLForVisitPersonnel(){
var locale=document.forms[0].locale.value;
  var rows=parent.ObjectCollect.visit_pers_rows;
  var rows_time=parent.ObjectCollect.time_rows;
  var rows_wound=parent.ObjectCollect.wound_rows;
  var table_name="VISIT_PERSONNEL";
  var len = rows.length;
  var l=rows_time.length;
  var k=rows_wound.length;
 /* TIME_AND_DETAILS_ENTERED = (rows_time.length>0)?"Y":"N";
  WOUND_DETAILS_ENTERED = (rows_wound.length>0)?"Y":"N";*/
  //if(TIME_AND_DETAILS_ENTERED=="Y") return "";
  var xmlString ="";
  for(var i=0;i<len;i++){
	  TIME_AND_DETAILS_ENTERED = (l>0)?"Y":"N";
      WOUND_DETAILS_ENTERED = (k>0)?"Y":"N";
	//  if(TIME_AND_DETAILS_ENTERED=="Y" && (rows[i].speciality_code == rows_time[i].speciality_code)) return "";
	
	 if(rows[i]!=null && rows[i].db_mode !='L'){


		xmlString+="<PER_DTL"+i+" ";
		xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
		xmlString+="speciality_code=\""+rows[i].speciality_code+"\""+" ";
		xmlString+="visit_desc=\""+encodeURIComponent(rows[i].visit_desc,"UTF-8")+"\""+" ";
		

		if(WOUND_DETAILS_ENTERED=="Y" && (rows[i].speciality_code == wound_rows[i].speciality_code) ){
			xmlString+="wound_code=\""+wound_rows[i].wound_code+"\""+" ";
		}


	 if(TIME_AND_DETAILS_ENTERED=="Y")
		 {
		
		if( (rows[i].speciality_code == rows_time[i].speciality_code) ){

		xmlString+="preparation_time=\""+convertDate(rows_time[i].db_preparation_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="procedure_start_time=\""+convertDate(rows_time[i].db_procedure_start_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="procedure_end_time=\""+convertDate(rows_time[i].db_procedure_end_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="anaesthesia_start_time=\""+convertDate(rows_time[i].db_anaesthesia_start_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="anaesthesia_end_time=\""+convertDate(rows_time[i].db_anaesthesia_end_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="surgery_start_time=\""+convertDate(rows_time[i].db_surgery_start_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="surgery_end_time=\""+convertDate(rows_time[i].db_surgery_end_time,'DMYHM',locale,"en")+"\""+" ";

		xmlString+="prep_start_time=\""+convertDate(rows_time[i].db_prep_start_time,'DMYHM',locale,"en")+"\""+" ";//Added by Arthi for ML-MMOH-CRF-1936
		xmlString+="prep_end_time=\""+convertDate(rows_time[i].db_prep_end_time,'DMYHM',locale,"en")+"\""+" ";

		 }
		 }

		xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
	}
	l--;
	k--;
  }
  return xmlString;

}

function createXMLForWoundDetails(){
  var locale=document.forms[0].locale.value;
  var rows=parent.ObjectCollect.wound_rows;
  var rows_time=parent.ObjectCollect.time_rows;
  var visit_pers_rows=parent.ObjectCollect.visit_pers_rows;
  var table_name="OT_POST_OPER_DTL2_WOU";
  var len = rows.length;
  var l = rows_time.length;
  var k = visit_pers_rows.length;

  var xmlString ="";
  for(var i=0;i<len;i++){
	  TIME_AND_DETAILS_ENTERED = (l>0)?"Y":"N";
      VISIT_PERSONEL_ENTERED = (k>0)?"Y":"N";
      //if((VISIT_PERSONEL_ENTERED=="Y" && (rows[i].speciality_code == visit_pers_rows[i].speciality_code))||(TIME_AND_DETAILS_ENTERED=="Y"&& (rows[i].speciality_code == rows_time[i].speciality_code))) return "";
	 if(rows[i]!=null &&  rows[i].db_mode !='L'){

	
		xmlString+="<WOU_DTL"+i+" ";
		xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
		xmlString+="speciality_code=\""+rows[i].speciality_code+"\""+" ";

		  if(VISIT_PERSONEL_ENTERED=="Y")
		 {
			if( (rows[i].speciality_code == visit_pers_rows[i].speciality_code) ){
			xmlString+="visit_desc=\""+encodeURIComponent(visit_pers_rows[i].visit_desc,"UTF-8")+"\""+" ";

		 }
		 }
		 if(TIME_AND_DETAILS_ENTERED=="Y")
		 {
		
		if( (rows[i].speciality_code == rows_time[i].speciality_code) ){

		xmlString+="preparation_time=\""+convertDate(rows_time[i].db_preparation_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="procedure_start_time=\""+convertDate(rows_time[i].db_procedure_start_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="procedure_end_time=\""+convertDate(rows_time[i].db_procedure_end_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="anaesthesia_start_time=\""+convertDate(rows_time[i].db_anaesthesia_start_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="anaesthesia_end_time=\""+convertDate(rows_time[i].db_anaesthesia_end_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="surgery_start_time=\""+convertDate(rows_time[i].db_surgery_start_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="surgery_end_time=\""+convertDate(rows_time[i].db_surgery_end_time,'DMYHM',locale,"en")+"\""+" ";

		xmlString+="prep_start_time=\""+convertDate(rows_time[i].db_prep_start_time,'DMYHM',locale,"en")+"\""+" ";//Added by Arthi for ML-MMOH-CRF-1936
		xmlString+="prep_end_time=\""+convertDate(rows_time[i].db_prep_end_time,'DMYHM',locale,"en")+"\""+" ";

		 }
		 }

		xmlString+="wound_code=\""+rows[i].wound_code+"\""+" ";
		xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
		
	 }
	 l--;
	 k--;
  }

  return xmlString;
}

function createXMLForTimeAndDetails(){
	var rows=parent.ObjectCollect.time_rows;
	var locale=document.forms[0].locale.value;
	var visit_pers_rows=parent.ObjectCollect.visit_pers_rows;
	var wound_rows = parent.ObjectCollect.wound_rows;
	var table_name="OT_POST_OPER_DTL2";
	var j=visit_pers_rows.length;
	var k=wound_rows.length;
	/*alert("(visit_pers_rows.length----->"+visit_pers_rows.length)
	VISIT_PERSONEL_ENTERED = (visit_pers_rows.length>0)?"Y":"N";
	alert("VISIT_PERSONEL_ENTERED----->"+VISIT_PERSONEL_ENTERED)
	WOUND_DETAILS_ENTERED = (wound_rows.length>0)?"Y":"N";*/
	var len = rows.length;
	var xmlString ="";
	for(var i=0;i<len;i++){
	 //if(rows[i]!=null &&  rows[i].db_mode!='L' && rows[i].verify_flag=="OFF" ){
		// alert("(visit_pers_rows.length----->"+j)
	     VISIT_PERSONEL_ENTERED = (j>0)?"Y":"N";
	    // alert("VISIT_PERSONEL_ENTERED----->"+VISIT_PERSONEL_ENTERED)
	     WOUND_DETAILS_ENTERED = (k>0)?"Y":"N";
		 //alert("rows[i].db_mode---->"+rows[i].db_mode)
	 if(rows[i]!=null && rows[i].db_mode!='L' ){
		xmlString+="<TIME_DTL"+i+" ";
		xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
		xmlString+="speciality_code=\""+rows[i].speciality_code+"\""+" ";
		if(VISIT_PERSONEL_ENTERED=="Y")
		 {// alert("308")
			if( (rows[i].speciality_code == visit_pers_rows[i].speciality_code) ){
			//xmlString+="visit_desc=\""+visit_pers_rows[i].visit_desc+"\""+" ";
			xmlString+="visit_desc=\""+encodeURIComponent(visit_pers_rows[i].visit_desc,"UTF-8")+"\""+" ";

		 }
		 }
		
		if(WOUND_DETAILS_ENTERED=="Y" && (rows[i].speciality_code == wound_rows[i].speciality_code) ){
			xmlString+="wound_code=\""+wound_rows[i].wound_code+"\""+" ";
		}
		xmlString+="preparation_time=\""+convertDate(rows[i].db_preparation_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="procedure_start_time=\""+convertDate(rows[i].db_procedure_start_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="procedure_end_time=\""+convertDate(rows[i].db_procedure_end_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="anaesthesia_start_time=\""+convertDate(rows[i].db_anaesthesia_start_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="anaesthesia_end_time=\""+convertDate(rows[i].db_anaesthesia_end_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="surgery_start_time=\""+convertDate(rows[i].db_surgery_start_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="surgery_end_time=\""+convertDate(rows[i].db_surgery_end_time,'DMYHM',locale,"en")+"\""+" ";

		xmlString+="prep_start_time=\""+convertDate(rows[i].db_prep_start_time,'DMYHM',locale,"en")+"\""+" ";//Added by Arthi for ML-MMOH-CRF-1936
		xmlString+="prep_end_time=\""+convertDate(rows[i].db_prep_end_time,'DMYHM',locale,"en")+"\""+" ";

		xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
		
	 }
	
	j--;
	k--;
  }

  return xmlString;
}


//Added by Suma wrt Surgical Accessories changes


function createXMLForInstruments(){
   var rows=parent.ObjectCollect.instrument_rows;
  var table_name="OT_SURGICAL_ACCESSORIES_INSTRUMENT";
  var accessory_type = "I";
  var len = rows.length;
  var xmlString ="";
   var bill_flag=document.forms[0].bill_flag.value;
  for(var i=0;i<len;i++){
	  //alert("88::"+rows[i]);
	  //alert("88::"+rows[i].db_mode);
	 //if(rows[i]!=null &&  rows[i].db_mode!='L'){
	 if(rows[i]!=null){
		xmlString+="<INSTR_DTL"+i+" ";
		xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
		xmlString+="oper_code=\""+rows[i].oper_code+"\""+" ";
		xmlString+="instr_code=\""+rows[i].instr_code+"\""+" ";
		xmlString+="key_line=\""+rows[i].key_line+"\""+" "; // Use this during update mode for Billing
		if(bill_flag=="true")
		{
		xmlString+="bill_str=\""+rows[i].rate+"::"+rows[i].bill_str+"\""+" "; // Newly added by bshankar
		xmlString+="panel_str=\""+escape(rows[i].panel_str)+"\""+" "; // Newly Added by bshankar
		}
		xmlString+="oper_line_no=\""+rows[i].oper_line_no+"\""+" ";
		//Encoded for CRF-0058 by Rajesh
		xmlString+="tray_no=\""+encodeURIComponent(rows[i].tray_no)+"\""+" ";
		//Encoded for CRF-0058 by Rajesh
		xmlString+="quantity=\""+rows[i].quantity+"\""+" ";
		xmlString+="remarks=\""+checkSpl( rows[i].remarks )+"\""+" ";
		xmlString+="accessory_type=\""+accessory_type+"\""+" ";
		if(rows[i].db_mode=="L")
			xmlString+="db_mode=\""+"U"+"\""+" ";
		else
			xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
		
	 }
  }
 //alert("105:"+xmlString);
   return xmlString;
}

function createXMLForEquipments(){
  var rows=parent.ObjectCollect.equipment_rows;
  var table_name="OT_SURGICAL_ACCESSORIES_EQUIPMENTS";
  var accessory_type = "E";
  var len = rows.length;
  var xmlString ="";
  var bill_flag=document.forms[0].bill_flag.value;
  for(var i=0;i<len;i++){
	 //if(rows[i]!=null &&  rows[i].db_mode!='L'){
	 if(rows[i]!=null){
		xmlString+="<EQUIP_DTL"+i+" ";
		xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
		xmlString+="oper_code=\""+rows[i].oper_code+"\""+" ";
		xmlString+="equip_code=\""+rows[i].equip_code+"\""+" ";
		xmlString+="st_location=\""+rows[i].st_location+"\""+" ";//091
		xmlString+="key_line=\""+rows[i].key_line+"\""+" "; // Use this during update mode for Billing
		if(bill_flag=="true")
		{
		xmlString+="bill_str=\""+rows[i].rate+"::"+rows[i].bill_str+"\""+" "; // Newly added by bshankar
		xmlString+="panel_str=\""+escape(rows[i].panel_str)+"\""+" "; // Newly Added by bshankar
		}
		xmlString+="oper_line_no=\""+rows[i].oper_line_no+"\""+" ";
		xmlString+="equip_id=\""+rows[i].equip_id+"\""+" ";
		xmlString+="quantity=\""+rows[i].quantity+"\""+" ";
		xmlString+="remarks=\""+checkSpl( rows[i].remarks )+"\""+" ";
		xmlString+="accessory_type=\""+accessory_type+"\""+" ";
		if(rows[i].db_mode=="L")
			xmlString+="db_mode=\""+"U"+"\""+" ";
		else
			xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
		
	 }
  }
  
  return xmlString;
}

function createXMLForImplants(){
  var rows=parent.ObjectCollect.implants_rows;
  var table_name="OT_SURGICAL_ACCESSORIES_IMPLANTS";
  var accessory_type = "S";
  var len = rows.length;
  var xmlString ="";
  var bill_flag=document.forms[0].bill_flag.value;

  for(var i=0;i<len;i++){
	 //if(rows[i]!=null &&  rows[i].db_mode!='L'){
	 if(rows[i]!=null){
		xmlString+="<IMPL_DTL"+i+" ";
		xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
		xmlString+="oper_code=\""+rows[i].oper_code+"\""+" ";
		xmlString+="implant_code=\""+rows[i].implant_code+"\""+" ";
		xmlString+="key_line=\""+rows[i].key_line+"\""+" "; // Use this during update mode for Billing
		if(bill_flag=="true")
		{
		xmlString+="bill_str=\""+rows[i].rate+"::"+rows[i].bill_str+"\""+" "; // Newly added by bshankar
		xmlString+="panel_str=\""+escape(rows[i].panel_str)+"\""+" "; // Newly Added by bshankar
		}
		xmlString+="oper_line_no=\""+rows[i].oper_line_no+"\""+" ";
		xmlString+="frm_pick_list=\""+rows[i].frm_pick_list+"\""+" ";
		xmlString+="quantity=\""+rows[i].quantity+"\""+" ";
		xmlString+="reserved_qty=\""+rows[i].quantity+"\""+" ";
		xmlString+="requested_qty=\""+rows[i].requested_qty+"\""+" ";
		xmlString+="req_store_code=\""+rows[i].req_store_code+"\""+" ";
		xmlString+="sale_document_no=\""+rows[i].sale_document_no+"\""+" ";
		xmlString+="sale_document_type=\""+rows[i].sale_document_type+"\""+" ";
		xmlString+="manufacturer=\""+rows[i].manufacturer+"\""+" ";
		xmlString+="batch=\""+rows[i].batch+"\""+" ";
		//xmlString+="remarks=\""+rows[i].remarks+"\""+" ";
		//Added encodeURIComponent on 10/18/2010 for IN023758 by AnithaJ
		xmlString+="remarks=\""+encodeURIComponent(rows[i].remarks)+"\""+" ";
		xmlString+="accessory_type=\""+accessory_type+"\""+" ";
		if(rows[i].db_mode=="L")
			xmlString+="db_mode=\""+"U"+"\""+" ";
		else
			xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
		
	 }
  }
  return xmlString;
}

function createXMLForPackage(){
  var rows=parent.ObjectCollect.packs_rows;
  var table_name="OT_SURGICAL_ACCESSORIES_PACKAGES";
  var accessory_type = "P";
  var len = rows.length;
  var xmlString ="";
  var bill_flag=document.forms[0].bill_flag.value;
  for(var i=0;i<len;i++){
	 //if(rows[i]!=null &&  rows[i].db_mode!='L'){
	 if(rows[i]!=null){
		xmlString+="<PACK_DTL"+i+" ";
		xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
		xmlString+="oper_code=\""+rows[i].oper_code+"\""+" ";
		xmlString+="package_code=\""+rows[i].package_code+"\""+" ";
		xmlString+="key_line=\""+rows[i].key_line+"\""+" "; // Use this during update mode for Billing
		if(bill_flag=="true")
		{
		xmlString+="bill_str=\""+rows[i].rate+"::"+rows[i].bill_str+"\""+" "; // Newly added by bshankar
		xmlString+="panel_str=\""+escape(rows[i].panel_str)+"\""+" "; // Newly Added by bshankar
		}
		xmlString+="oper_line_no=\""+rows[i].oper_line_no+"\""+" ";
		xmlString+="quantity=\""+rows[i].quantity+"\""+" ";
		xmlString+="reserved_qty=\""+rows[i].quantity+"\""+" ";
		xmlString+="requested_qty=\""+rows[i].requested_qty+"\""+" ";
		xmlString+="req_store_code=\""+rows[i].req_store_code+"\""+" ";
		xmlString+="sale_document_no=\""+rows[i].sale_document_no+"\""+" ";
		xmlString+="sale_document_type=\""+rows[i].sale_document_type+"\""+" ";
		xmlString+="remarks=\""+checkSpl(rows[i].remarks)+"\""+" ";
		xmlString+="accessory_type=\""+accessory_type+"\""+" ";
		if(rows[i].db_mode=="L")
			xmlString+="db_mode=\""+"U"+"\""+" ";
		else
			xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
	 }
  }
  //alert("xmlString")
  
  return xmlString;
}






function createXMLForICDPCS(){
  var rows=parent.ObjectCollect.ICD_PCS_ROWS;
  var table_name="OT_POST_OPER_PROC_DTLS";
  var xmlString ="";
  for(var j in rows){

	 if(rows[j].db_mode!='L'){
		xmlString+="<ICD_PCS_DTL"+j+" ";
		xmlString+="oper_code=\""+rows[j].oper_code+"\""+" ";
		xmlString+="oper_line_no=\""+rows[j].line_no+"\""+" ";
		xmlString+="coding_scheme=\""+rows[j].coding_scheme+"\""+" ";
		xmlString+="proc_code=\""+rows[j].proc_code+"\""+" ";
		if(rows[j].db_mode=="U")
		xmlString+="old_proc_code=\""+rows[j].old_proc_code+"\""+" "
		xmlString+="db_mode=\""+rows[j].db_mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
	 }
  }
  //alert(xmlString);
  return xmlString;
}

//Created newly for rajesh on 18/08/08
/*
function createXMLForSubServices(){
  var rows=parent.ObjectCollect.Bill_Sub_Services_Rows;
  alert(rows.length)
  alert(rows[0].value);
  var xmlString ="";
 		xmlString+="<Bill_Sub_Services_Dtl";
		xmlString+="facility_id=\""+rows[1]+"\""+" ";
		xmlString+="patient_id=\""+rows[2]+"\""+" ";
		xmlString+="episode_type=\""+rows[3]+"\""+" ";
		xmlString+="episode_id=\""+rows[4]+"\""+" ";
		xmlString+="visit_id=\""+rows[5]+"\""+" "
		xmlString+="str_order_cat_code=\""+rows[6]+"\""+" ";
		xmlString+="str_serv_panel_ind=\""+rows[7]+"\""+" ";
		xmlString+="str_blng_serv_code=\""+rows[8]+"\""+" ";
		xmlString+="str_trx_date_time=\""+rows[9]+"\""+" ";
		xmlString+="str_serv_qty=\""+rows[10]+"\""+" ";
		xmlString+="charging_stage=\""+rows[11]+"\""+" ";
		xmlString+="str_charge_based_amt=\""+rows[12]+"\""+" ";
		xmlString+="str_pract_id=\""+rows[13]+"\""+" ";
		xmlString+="str_overridden_excl_incl_ind=\""+rows[14]+"\""+" ";
		xmlString+="strloggeduser=\""+rows[15]+"\""+" ";
		xmlString+="strclientip=\""+rows[16]+"\""+" ";
		xmlString+="str_dep_blng_serv_code=\""+rows[17]+"\""+" ";
		xmlString+="str_dep_serv_charge_eff_perc=\""+rows[18]+"\""+" ";
		xmlString+="str_disc_seq_num=\""+rows[19]+"\""+" ";
		xmlString+="str_multi_surg_disc_eff_perc=\""+rows[20]+"\""+" ";
		xmlString+="str_ref_sec_module_id=\""+rows[21]+"\""+" ";
		xmlString+="str_ref_sec_key_main=\""+rows[22]+"\""+" ";
		xmlString+="str_ref_sec_key_line_num=\""+rows[23]+"\""+" />";
  alert("OperCollectObject : "+xmlString);
  return xmlString;
}
*/
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<% 
String oper_num = checkForNull(request.getParameter("oper_num")); 

%>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="OperCollectForm" id="OperCollectForm">
<% String bill_flag = request.getParameter("bill_flag");
%>
<input type='hidden' name='oper_num' id='oper_num' value='<%=oper_num%>' >
<input type='hidden' name='bill_flag' id='bill_flag' value='<%=bill_flag%>' >
<input type='hidden' name='locale' id='locale' value='<%=locale%>' >
<input type='hidden' name='slate_user_id' id='slate_user_id' value='<%=checkForNull(request.getParameter("slate_user_id"))%>' >
<input type='hidden' name='tab_name' id='tab_name' value='<%=tab_name%>' >
</form>
</body>
</html>

