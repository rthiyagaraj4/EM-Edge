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
%>
<html>
<head>
<script type='text/javascript' src='../../eOT/js/OTCommon.js'></script>
<script type='text/javascript' src='../../eOT/js/RecordNursing.js'></script>
<script type='text/javascript' src='../../eOT/js/CommonOperDtlsHdr.js'></script>
<% 
String tab=checkForNull(request.getParameter("tab"));
if(!("record_nursing").equals(tab)){ %>
<script type='text/javascript' src='../../eOT/js/CheckOutFromOR.js'></script>
<%}%>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script language='javascript'>
	

var personnelrows = new Array();
var personnelrowLength=0;
var rows = new Array();
var rowLength=0;
var line_no=0;


var specimen_rows = new Array();
var specimen_len=0;
var disposal_rows = new Array();
var disposal_len=0;
var instrument_rows = new Array();
var instrument_len=0;
var equipment_rows = new Array();
var equipment_len = 0;
var packs_rows=new Array();
var packs_len = 0;
var implants_rows = new Array();
var implants_len = 0;
var time_rows = new Array();
var time_len = 0;
var visit_pers_rows=new Array();
var visit_pers_len=0;

//For Sugery History
var diagnosis_rows = new Array();
var diagnosis_len = 0;
//for displaying the rows only one time from db(initially)
var db_flag="ON";
var splty_code="";
var TIME_AND_DETAILS_ENTERED="N";
var VISIT_PERSONEL_ENTERED="N";
var mandatory_proc=new Array();
</script>

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

//Commented by rajesh for Uniue Constraing PK error TH_OT_SPR-3270
/*function createXMLForVisitPersonnel(){
  var rows=parent.ObjectCollect.visit_pers_rows;
  var table_name="VISIT_PERSONNEL";
  var len = rows.length;
  var xmlString ="";
  for(var i=0;i<len;i++){
	 if(rows[i]!=null &&  rows[i].db_mode!='L' && rows[i].verify_flag=="OFF" ){
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

/*function createXMLForVisitPersonnel(){
  var rows=parent.ObjectCollect.visit_pers_rows;
  var rows_time=parent.ObjectCollect.time_rows;
//  var locale=document.forms[0].locale.value;
//var l=rows_time.length;
  var table_name="VISIT_PERSONNEL";
  var len = rows.length;
 //  TIME_AND_DETAILS_ENTERED = (l>0)?"Y":"N";

 // if(TIME_AND_DETAILS_ENTERED=="Y") return "";
  var xmlString ="";
  for(var i=0;i<len;i++){
	 if(rows[i]!=null && rows[i].db_mode!='L'){
		xmlString+="<PER_DTL"+i+" ";
		xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
		xmlString+="speciality_code=\""+rows[i].speciality_code+"\""+" ";
		xmlString+="visit_desc=\""+encodeURIComponent(rows[i].visit_desc,"UTF-8")+"\""+" ";
		xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
	}
  }
  return xmlString;

}*/
function createXMLForVisitPersonnel(){
  var rows=parent.ObjectCollect.visit_pers_rows;
  var rows_time=parent.ObjectCollect.time_rows;
//  var locale=document.forms[0].locale.value;
  var l=rows_time.length;
  var table_name="VISIT_PERSONNEL";
  var len = rows.length;
  var locale=document.forms[0].locale.value;

 //  TIME_AND_DETAILS_ENTERED = (l>0)?"Y":"N";

 // if(TIME_AND_DETAILS_ENTERED=="Y") return "";
  var xmlString ="";
  for(var i=0;i<len;i++){
	  TIME_AND_DETAILS_ENTERED = (l>0)?"Y":"N";
	 if(rows[i]!=null && rows[i].db_mode!='L'){
		xmlString+="<PER_DTL"+i+" ";
		xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
		xmlString+="speciality_code=\""+rows[i].speciality_code+"\""+" ";
		xmlString+="visit_desc=\""+encodeURIComponent(rows[i].visit_desc,"UTF-8")+"\""+" ";
		xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" ";

		if(TIME_AND_DETAILS_ENTERED=="Y")
		 {
		xmlString+="preparation_time=\""+convertDate(rows[i].db_preparation_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="procedure_start_time=\""+convertDate(rows[i].db_procedure_start_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="procedure_end_time=\""+convertDate(rows[i].db_procedure_end_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="anaesthesia_start_time=\""+convertDate(rows[i].db_anaesthesia_start_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="anaesthesia_end_time=\""+convertDate(rows[i].db_anaesthesia_end_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="surgery_start_time=\""+convertDate(rows[i].db_surgery_start_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="surgery_end_time=\""+convertDate(rows[i].db_surgery_end_time,'DMYHM',locale,"en")+"\""+" />";
		xmlString+="prep_start_time=\""+convertDate(rows[i].db_prep_start_time,'DMYHM',locale,"en")+"\""+" />";
		xmlString+="prep_end_time=\""+convertDate(rows[i].db_prep_end_time,'DMYHM',locale,"en")+"\""+" />";
		 }
		 else
			 xmlString+=" />";
	}
	l--;
  }
  return xmlString;

}

 function createXMLForInstruments(){
  var rows=parent.ObjectCollect.instrument_rows;
  var table_name="OT_SURGICAL_ACCESSORIES_INSTRUMENT";
  var accessory_type = "I";
  var len = rows.length;
  var xmlString ="";
   var bill_flag=document.forms[0].bill_flag.value;

  for(var i=0;i<len;i++){

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
		//xmlString+="remarks=\""+ rows[i].remarks+"\""+" ";
		//Added encodeURIComponent on 10/27/2010 for IN023758 by AnithaJ
		xmlString+="remarks=\""+encodeURIComponent(rows[i].remarks)+"\""+" ";

		xmlString+="accessory_type=\""+accessory_type+"\""+" ";
		xmlString+="quantity=\""+rows[i].quantity+"\""+" ";
		xmlString+="frm_pick_list=\""+rows[i].frm_pick_list+"\""+" ";
		if(rows[i].db_mode=="L")
			xmlString+="db_mode=\""+"U"+"\""+" ";
		else
			xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
		
	 }
  }
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
	 //if(rows[i]!=null &&  rows[i].db_mode!='L')
	 if(rows[i]!=null){
		xmlString+="<EQUIP_DTL"+i+" ";
		xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
		xmlString+="oper_code=\""+rows[i].oper_code+"\""+" ";
		xmlString+="equip_code=\""+rows[i].equip_code+"\""+" ";
		xmlString+="key_line=\""+rows[i].key_line+"\""+" "; // Use this during update mode for Billing
		if(bill_flag=="true")
		{
		xmlString+="bill_str=\""+rows[i].rate+"::"+rows[i].bill_str+"\""+" "; // Newly added by bshankar
		xmlString+="panel_str=\""+escape(rows[i].panel_str)+"\""+" "; // Newly Added by bshankar
		}
		xmlString+="oper_line_no=\""+rows[i].oper_line_no+"\""+" ";
		xmlString+="equip_id=\""+rows[i].equip_id+"\""+" ";
		//xmlString+="remarks=\""+ rows[i].remarks+"\""+" ";
		//Added encodeURIComponent on 10/27/2010 for IN023758 by AnithaJ
		xmlString+="remarks=\""+encodeURIComponent(rows[i].remarks)+"\""+" ";
		xmlString+="desiredDate=\""+rows[i].desiredDate+"\""+" ";
		xmlString+="accessory_type=\""+accessory_type+"\""+" ";
		xmlString+="frm_pick_list=\""+rows[i].frm_pick_list+"\""+" ";
		xmlString+="quantity=\""+rows[i].quantity+"\""+" ";
		if(rows[i].db_mode=="L"){
			//Added Against Start AMRI-CRF-0294 [IN049121]
			if(rows[i].oper_line_status=='99'){
				xmlString+="db_mode=\""+"D"+"\""+" ";
			}else{ //Added Against End AMRI-CRF-0294 [IN049121]
			xmlString+="db_mode=\""+"U"+"\""+" ";
			} //Added Against AMRI-CRF-0294 [IN049121]
		}			
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
		//xmlString+="Store_desc=\""+rows[i].Store_desc+"\""+" ";
		xmlString+="sale_document_no=\""+rows[i].sale_document_no+"\""+" ";
		xmlString+="sale_document_type=\""+rows[i].sale_document_type+"\""+" ";
		xmlString+="Stockavail=\""+rows[i].Stockavail+"\""+" ";
		xmlString+="manufacturer=\""+rows[i].manufacturer+"\""+" ";
		xmlString+="batch=\""+rows[i].batch+"\""+" ";
		//Added encodeURIComponent on 10/18/2010 for IN023758 by AnithaJ
		xmlString+="remarks=\""+encodeURIComponent(rows[i].remarks)+"\""+" ";
		//xmlString+="remarks=\""+rows[i].remarks+"\""+" ";
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
		xmlString+="bill_str=\""+rows[i].rate+"::"+rows[i].bill_str_conspack+"\""+" "; // Newly added by bshankar
		xmlString+="panel_str=\""+escape(rows[i].panel_str)+"\""+" "; // Newly Added by bshankar
		}
		xmlString+="oper_line_no=\""+rows[i].oper_line_no+"\""+" ";
		xmlString+="quantity=\""+rows[i].quantity+"\""+" ";
		xmlString+="frm_pick_list=\""+rows[i].frm_pick_list+"\""+" ";
		//xmlString+="reserved_qty=\""+rows[i].quantity+"\""+" ";
		//xmlString+="requested_qty=\""+rows[i].requested_qty+"\""+" ";
		//xmlString+="req_store_code=\""+rows[i].req_store_code+"\""+" ";
		////xmlString+="sale_document_no=\""+rows[i].sale_document_no+"\""+" ";
		//xmlString+="sale_document_type=\""+rows[i].sale_document_type+"\""+" ";

		//xmlString+="remarks=\""+rows[i].remarks+"\""+" ";
		//Added encodeURIComponent on 10/27/2010 for IN023758 by AnithaJ
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



function createXMLForSpecimenDtls(){
  var rows=parent.ObjectCollect.specimen_rows;
  var len = rows.length;
  var table_name = "OT_POST_OPER_SPECIMENS";
  var xmlString ="";
  for(var i=0;i<len;i++){
	  if(rows[i]!=null && rows[i].db_mode!='L' ){
		xmlString+="<SPEC_DTL"+i+" ";
		xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
		xmlString+="specimen_dtls=\""+checkSpl( rows[i].specimen_dtls )+"\""+" ";
		xmlString+="dept_code=\""+rows[i].dept_code+"\""+" ";
		xmlString+="quantity=\""+rows[i].quantity+"\""+" ";
		xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
	 }
  }
 return xmlString;
}

 function createXMLForDisposalDtls(){
  var rows=parent.ObjectCollect.disposal_rows;
  var table_name="OT_POST_OPER_ORGAN";
  var len = rows.length;
  var xmlString ="";
  for(var i=0;i<len;i++){
	 if(rows[i]!=null && rows[i].db_mode!='L'){
		xmlString+="<DISPOSAL_DTL"+i+" ";
		xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
		xmlString+="anatomical_code=\""+rows[i].anatomical_code+"\""+" ";
		xmlString+="disposal_code=\""+rows[i].disposal_code+"\""+" ";
		xmlString+="given_by=\""+checkSpl( rows[i].given_by )+"\""+" ";
		xmlString+="received_by=\""+checkSpl(rows[i].received_by )+"\""+" ";
		xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
	}
  }
  return xmlString;
}

//Commented by rajesh for Uniue Constraing PK error TH_OT_SPR-3270
/*function createXMLForTimeAndDetails(){
  var rows=parent.ObjectCollect.time_rows;
  var table_name="OT_POST_OPER_DTL2";
  var len = rows.length;
  var xmlString ="";
  for(var i=0;i<len;i++){
	 if(rows[i]!=null &&  rows[i].db_mode!='L' && rows[i].verify_flag=="OFF" ){
		xmlString+="<TIME_DTL"+i+" ";
		xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
		xmlString+="speciality_code=\""+rows[i].speciality_code+"\""+" ";
		xmlString+="preparation_time=\""+rows[i].db_preparation_time+"\""+" ";
		xmlString+="procedure_start_time=\""+rows[i].db_procedure_start_time+"\""+" ";
		xmlString+="procedure_end_time=\""+rows[i].db_procedure_end_time+"\""+" ";
		xmlString+="anaesthesia_start_time=\""+rows[i].db_anaesthesia_start_time+"\""+" ";
		xmlString+="anaesthesia_end_time=\""+rows[i].db_anaesthesia_end_time+"\""+" ";
		xmlString+="surgery_start_time=\""+rows[i].db_surgery_start_time+"\""+" ";
		xmlString+="surgery_end_time=\""+rows[i].db_surgery_end_time+"\""+" ";

		xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
		
	 }
  }
  return xmlString;
}*/

function createXMLForTimeAndDetails(){
  var rows=parent.ObjectCollect.time_rows;
	 var visit_pers_rows=parent.ObjectCollect.visit_pers_rows;
	 var locale=document.forms[0].locale.value;
  var table_name="OT_POST_OPER_DTL2";
  VISIT_PERSONEL_ENTERED = (visit_pers_rows.length>0)?"Y":"N"
  var len = rows.length;
  var xmlString ="";
  for(var i=0;i<len;i++){
	 //if(rows[i]!=null &&  rows[i].db_mode!='L' && rows[i].verify_flag=="OFF" ){
	 if(rows[i]!=null && rows[i].db_mode!='L' ){
		xmlString+="<TIME_DTL"+i+" ";
		xmlString+="oper_num=\""+document.forms[0].oper_num.value+"\""+" ";
		xmlString+="speciality_code=\""+rows[i].speciality_code+"\""+" ";

		if(VISIT_PERSONEL_ENTERED=="Y" && (rows[i].speciality_code == visit_pers_rows[i].speciality_code) ){
			xmlString+="visit_desc=\""+encodeURIComponent(visit_pers_rows[i].visit_desc,"UTF-8")+"\""+" ";
		}

		xmlString+="preparation_time=\""+convertDate(rows[i].db_preparation_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="procedure_start_time=\""+convertDate(rows[i].db_procedure_start_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="procedure_end_time=\""+convertDate(rows[i].db_procedure_end_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="anaesthesia_start_time=\""+convertDate(rows[i].db_anaesthesia_start_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="anaesthesia_end_time=\""+convertDate(rows[i].db_anaesthesia_end_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="surgery_start_time=\""+convertDate(rows[i].db_surgery_start_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="surgery_end_time=\""+convertDate(rows[i].db_surgery_end_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="prep_start_time=\""+convertDate(rows[i].db_prep_start_time,'DMYHM',locale,"en")+"\""+" ";
		xmlString+="prep_end_time=\""+convertDate(rows[i].db_prep_end_time,'DMYHM',locale,"en")+"\""+" ";
		
		xmlString+="db_mode=\""+rows[i].db_mode+"\""+" ";
		xmlString+="table_name=\""+table_name+"\""+" />";
		
	 }
  }
  return xmlString;
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<% String oper_num = checkForNull(request.getParameter("oper_num"));
%>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<% String bill_flag = request.getParameter("bill_flag");
%>
<form name="OperCollectForm" id="OperCollectForm">
<input type='hidden' name='oper_num' id='oper_num' value='<%=oper_num%>' >
<input type='hidden' name='bill_flag' id='bill_flag' value='<%=bill_flag%>' >
<input type='hidden' name='locale' id='locale' value='<%=locale%>' >

<input type='hidden' name='slate_user_id' id='slate_user_id' 			value='<%=checkForNull(request.getParameter("slate_user_id"))%>' >
<input type='hidden' name='params' id='params' value='<%=request.getQueryString()%>' >
</form>
</body>
</html>

