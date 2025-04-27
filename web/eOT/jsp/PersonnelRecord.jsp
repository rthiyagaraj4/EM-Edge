<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  contentType=" text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp"%>
<%@page  import ="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,eCommon.Common.CommonBean,java.sql.CallableStatement,webbeans.eCommon.ConnectionManager,eCommon.Common.*,eOT.*,eOT.Common.*,eCommon.XSSRequestWrapper,eOR.OrderEntryBillingQueryBean,java.util.ArrayList" contentType=" text/html;charset=UTF-8" %>

<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%! 
	String encode(String data){	  
	  byte byteData[] = data.getBytes();
		String outDat = "";
	  for (int i=0; i<byteData.length; i++)
	  {
		outDat = outDat +"%"+Integer.toHexString((int)byteData[i]);
	  }
		return(outDat);
	}

%>
<HTML>
<HEAD>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script type='text/javascript' src='../../eCommon/js/dchk.js'></script>

<% String tab = CommonBean.checkForNull(request.getParameter("tab")); 
	String params = request.getQueryString();
	boolean isMandateEffortEstimation = false;
	String oper_code = CommonBean.checkForNull(request.getParameter("oper_code"));
	Connection con = null;
	
	try{
		con = ConnectionManager.getConnection(request);
		
		isMandateEffortEstimation = eCommon.Common.CommonBean.isSiteSpecific(con, "OT", "MANDATE_EFFORT_ESTIMATION");//Added Against ML-MMOH-CRF-1979-US02
		//isMandateEffortEstimation = true;
		System.err.println("isMandateEffortEstimation="+isMandateEffortEstimation);
	}catch(Exception e){
		 System.err.println("Err Msg in Personnel Records"+e.getMessage());
	}finally{
		try{ 
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
	
   if(tab.equals("record_surgeon")){ %>
<script language="JavaScript" src="../../eOT/js/RecordSurgeon.js"></script>
   <% } else if(tab.equals("record_nursing")){ %>
<script language="JavaScript" src="../../eOT/js/RecordNursing.js"></script>
   <%}%>
<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>

<script language='javascript'>

function Class_personnelrow()
{
     this.speciality_code="";
	 this.speciality_desc="";
	 this.role_id ="";
	 this.role_desc ="";
	 this.role_type="";
     this.practitioner_id="";
     this.practitioner_name="";
	 this.position_desc="";
	 this.db_mode="";
	 this.recId ="";
	 //Added Against ML-MMOH-CRF-1979-US02...starts
	 var isMandateEffortEstimation = document.forms[0].isMandateEffortEstimation.value;
	if(isMandateEffortEstimation == 'true'){
	 this.operation_code="";
     this.operation_desc="";
	 this.team = "";
	 this.time_in_date = "";
	 this.time_in_time = "";
	 this.time_out_date = "";
	 this.time_out_time = "";
	}
	 //Added Against ML-MMOH-CRF-1979-US02...ends
}

function disableDocLevel(){
   var formObj = parent.parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
   if(formObj.doc_level.disabled==false)
	   formObj.doc_level.disabled=true;
}

function assignSpeciality(){
	var formObjHdr = parent.parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var doc_level = formObjHdr.doc_level.value;	
	var isMandateEffortEstimation = document.forms[0].isMandateEffortEstimation.value;
	if(document.forms[0].tab.value !="record_surgeon")
	{	
		callPopulateList(doc_level);
		if(isMandateEffortEstimation == 'true'){
			populateOperations();
		}
	}
	else
	{
		if(doc_level=="IS")
		{
			if(isMandateEffortEstimation == 'true'){
				populateOperations();
			}else{
				var facility_id=document.forms[0].facility_id.value;
				var db_mode=parent.parent.parent.frames[4].RecordSurgeonTabForm.db_mode.value;
				var status_value=parent.parent.parent.frames[4].RecordSurgeonTabForm.status_value.value;
				var oper_code_all=parent.parent.parent.frames[4].RecordSurgeonTabForm.oper_code_all.value;
				var oper_code_new=parent.parent.parent.frames[4].RecordSurgeonTabForm.oper_code_new.value;
				var spec_code_final=parent.parent.parent.frames[4].RecordSurgeonTabForm.spec_code_final.value;
				var oper_num=document.forms[0].oper_num.value;
				var arr2=oper_code_all.split("*");
				var arr3=status_value.split("*");
				var arr1=db_mode.split("*");
	
				var oper_code="";
				var chk_status="";
				var db_mode_val="";
				
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
			    xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=exist_operation_speciality&spec_code_final="+spec_code_final,false);
				xmlHttp.send(xmlDoc);
				var retVal = trimString(xmlHttp.responseText);
				var arr_spec=retVal.split("*");
				var spec_code_new="";
				var spec_code_old="";
				var arr2_spec="";
				var opt ="";
				for (var m=0;m<arr_spec.length-1;m++ )
				{
					spec_code_new=arr_spec[m];
					 arr2_spec=spec_code_new.split(",");
					 opt = parent.frames[0].document.createElement('OPTION');
					opt.text =arr2_spec[1];
					opt.value=arr2_spec[0];
					document.forms[0].speciality.add(opt);
				}
}else if(doc_level=="AS")
		{
			assignListItems('*ALL','All Specialities');
		}
	}
}


function splitString(strVal){
	var isMandateEffortEstimation = document.forms[0].isMandateEffortEstimation.value;
	var arr = strVal.split('::');
	var frmObj = document.forms[0];
	frmObj.speciality.value=arr[0];
	frmObj.role_id.value=arr[2];
	frmObj.role_desc.value=arr[3]
	frmObj.practitioner_id.value=arr[4];
	frmObj.practitioner_name.value=arr[5];
	frmObj.recId.value = arr[6];
	frmObj.role_type.value=arr[7];
	frmObj.mode.value=arr[8];
	//Added Against ML-MMOH-CRF-1979-US02...starts
	if(isMandateEffortEstimation == 'true'){
	frmObj.operation.value=arr[9];
	if (arr[11] == 'A') document.getElementById('A').checked = true;
	else if (arr[11] == 'B') document.getElementById('B').checked = true;
	
	frmObj.time_in_date.value = arr[12];
	frmObj.time_in_time.value = arr[13];
	frmObj.time_out_date.value = arr[14];
	frmObj.time_out_time.value = arr[15];
	frmObj.operation.disabled=true;
	frmObj.practitioner_name.disabled=true;
	//Added Against ML-MMOH-CRF-1979-US02...ends
	}else{
	frmObj.record.disabled=true;	
	}
	frmObj.speciality.disabled=true;
	frmObj.role_desc.disabled=true;
	frmObj.speciality.disabled=true;
	frmObj.DoctorLookUp.disabled=true;
	frmObj.record.disabled=true;	
}

function resetFields(){
	var frmObj = document.PersonnelRecordForm;
	frmObj.mode.value='I';
	frmObj.role_desc.value='';
	frmObj.practitioner_name.value='';
	frmObj.role_desc.value='';
	frmObj.role_type.value='';
	//Added Against ML-MMOH-CRF-1979-US02...starts
	var isMandateEffortEstimation = document.forms[0].isMandateEffortEstimation.value;
	if(isMandateEffortEstimation == 'true'){
	//frmObj.operation.value = "";
	frmObj.time_in_date.value = "";
	frmObj.time_in_time.value = "";
	frmObj.time_out_date.value = "";
	frmObj.time_out_time.value = "";
	if (frmObj.team.value == 'A') document.getElementById('A').checked = false;
	else if (frmObj.team.value == 'B') document.getElementById('B').checked = false;
	frmObj.operation.disabled=false;
	frmObj.operation.textContent = 'Select';
	frmObj.practitioner_name.disabled=false;
	}else{
	//Added Against ML-MMOH-CRF-1979-US02...ends
	frmObj.speciality.disabled=false;
	frmObj.role_desc.disabled=false;
	frmObj.DoctorLookUp.disabled=false;
	frmObj.record.disabled=false;
	//refresh();
}

function refresh(){
	var params = document.forms[0].params.value;
	var disp_hosp = '';//Added for CHL-CRF-0020.1 [IN:043132]
	if(document.forms[0].tab.value =="record_surgeon")
		disp_hosp = parent.parent.parent.frames[4].RecordSurgeonTabForm.disp_hosp.value;//Added for CHL-CRF-0020.1 [IN:043132]
	else if(document.forms[0].tab.value =="record_nursing")
		disp_hosp = parent.parent.parent.frames[3].RecordNursingTabForm.disp_hosp.value;//Added for CHL-CRF-0020.1 [IN:043132]
	//parent.DetailFrame.location.href='../../eOT/jsp/PersonnelDtls.jsp?'+params+ "&disp_hosp="+disp_hosp,1000;
	setTimeout(function(){parent.DetailFrame.location.href='../../eOT/jsp/PersonnelDtls.jsp?'+params+ "&disp_hosp="+disp_hosp,1000});//Added Against SKR-SCF-1744
}

function addRow(operation,speciality,team,role_desc,practitioner_name,time_in_date,time_in_time,time_out_date,time_out_time){
	var objrow = newRow();
	var formObj = document.PersonnelRecordForm;
	var params = formObj.params.value;
	var disp_hosp = '';
	var isMandateEffortEstimation = document.forms[0].isMandateEffortEstimation.value;
if(isMandateEffortEstimation == 'true'){
	var check_in_time = trimString(document.forms[0].check_in_time.value);
	var check_out_time = trimString(document.forms[0].check_out_time.value);
	var time_in = document.forms[0].time_in_date.value+" "+document.forms[0].time_in_time.value;
	var time_out = document.forms[0].time_out_date.value+" "+document.forms[0].time_out_time.value;
	   if(time_in == '' || time_in == 'undefined' || time_in == null) time_in = '';
	   if(time_out == '' || time_out == 'undefined' || time_out == null) time_out = '';
	}
	//var mandate_eff_estimation_yn = document.forms[0].mandate_eff_estimation_yn.value;						
	if(document.forms[0].tab.value =="record_surgeon")
		disp_hosp = parent.parent.parent.frames[4].RecordSurgeonTabForm.disp_hosp.value;//Added for CHL-CRF-0020.1 [IN:043132]
	else if(document.forms[0].tab.value =="record_nursing")
		disp_hosp = parent.parent.parent.frames[3].RecordNursingTabForm.disp_hosp.value;//Added for CHL-CRF-0020.1 [IN:043132]
	var locale = formObj.locale.value;
	var mode = formObj.mode.value;
		if(mode=='I'){
			  if(chkEmpty() && validateTimeInTimeOut(time_in,time_out,check_in_time,check_out_time,isMandateEffortEstimation)){
			  if(alreadyExist()){
				  var obj = formObj.speciality;
				  var obj1 = formObj.role_desc;
				  var rows = parent.parent.parent.ObjectCollect.personnelrows;
				  var tempPersonnelRows = parent.parent.parent.ObjectCollect.tempPersonnelRows;
				  //Added Aganst ML-MMOH-CRF-1979-US02...starts
				  if(isMandateEffortEstimation == 'true'){  
					objrow.operation_code =formObj.operation.value; 
					objrow.operation_desc=formObj.operation.options[formObj.operation.selectedIndex].text;		  
					if (document.getElementById('A').checked) objrow.team = document.getElementById('A').value;	
					if (document.getElementById('B').checked) objrow.team = document.getElementById('B').value;			objrow.time_in = document.forms[0].time_in_date.value+" "+document.forms[0].time_in_time.value;
					objrow.time_out = document.forms[0].time_out_date.value+" "+document.forms[0].time_out_time.value;
					if(objrow.operation_desc == null && objrow.operation_desc == 'undefined') objrow.operation_desc = '';
					if(objrow.team == null && objrow.team == 'undefined') objrow.team = '';
					if(objrow.time_in == null && objrow.time_in == 'undefined') objrow.time_in = '';
					if(objrow.time_out == null && objrow.time_out == 'undefined') objrow.time_out = '';
				  }
				  //Added Aganst ML-MMOH-CRF-1979-US02...ends
				  objrow.speciality_code =formObj.speciality.value; 
				  objrow.speciality_desc=formObj.speciality.options[obj.selectedIndex].text;
				  objrow.role_id=formObj.role_id.value;
				  objrow.role_desc = formObj.role_desc.options[obj1.selectedIndex].text;// formObj.role_desc.value;
				  objrow.role_type=formObj.role_type.value;
				  objrow.practitioner_id=formObj.practitioner_id.value;
				  objrow.practitioner_name=formObj.practitioner_name.value;
				  objrow.db_mode='I';
				  objrow.position_desc = getPositionDesc(formObj.practitioner_id.value,locale);
				  objrow.recId = rows.length+1;
				  rows.push(objrow);
				  //if(disp_hosp == 'N')
				  //	tempPersonnelRows.push(objrow);
				  resetFields();
				  //parent.DetailFrame.location.href='../../eOT/jsp/PersonnelDtls.jsp?'+params+ "&disp_hosp="+disp_hosp,1000;
				  setTimeout(function(){parent.DetailFrame.location.href='../../eOT/jsp/PersonnelDtls.jsp?'+params+ "&disp_hosp="+disp_hosp,1000});//Added Against SKR-SCF-1744
				  parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
		   }else { //else part of alreadyExist method
				 var msg = trimString(getMessage("CODE_ALREADY_EXISTS","Common"));
				parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		   }
		}
    }//if part of mode Check Ends Here
	else if(mode != "I" && isMandateEffortEstimation == 'true') {
	updateRow(operation,speciality,team,formObj.practitioner_id.value,role_desc,practitioner_name,time_in_date,time_in_time,time_out_date,time_out_time,mode);
}
}


function updateRow(operation,speciality,team,practitioner_id,role_id,role_desc,practitioner_name,time_in_date,time_in_time,time_out_date,time_out_time,mode){
	var formObj = document.PersonnelRecordForm;
	var rows2 = parent.parent.parent.ObjectCollect.personnelrows;
	
	var params = formObj.params.value;
	var disp_hosp = '';
	var check_in_time = trimString(document.forms[0].check_in_time.value);
	var check_out_time = trimString(document.forms[0].check_out_time.value);
	var time_in = document.forms[0].time_in_date.value+" "+document.forms[0].time_in_time.value;
	var time_out = document.forms[0].time_out_date.value+" "+document.forms[0].time_out_time.value;
	var isMandateEffortEstimation = document.forms[0].isMandateEffortEstimation.value;
	var locale = formObj.locale.value;
	if(document.forms[0].tab.value =="record_surgeon")
		disp_hosp = parent.parent.parent.frames[4].RecordSurgeonTabForm.disp_hosp.value;//Added for CHL-CRF-0020.1 [IN:043132]
	else if(document.forms[0].tab.value =="record_nursing")
		disp_hosp = parent.parent.parent.frames[3].RecordNursingTabForm.disp_hosp.value;//Added for CHL-CRF-0020.1 [IN:043132]
	
		for(var jj=0;jj<rows2.length;jj++){
			if(rows2[jj].operation_code == '' || rows2[jj].operation_code == 'undefined' || rows2[jj].operation_code == null) rows2[jj].operation_code = document.forms[0].oper_code.value;
			if(rows2[jj]!=null && rows2[jj].operation_code!=null && rows2[jj].operation_code!="" && rows2[jj].practitioner_id!=null && rows2[jj].practitioner_id!="" ) {
				if(rows2[jj].operation_code==operation && rows2[jj].practitioner_id==practitioner_id ){
				
					if(mode !="I" && validateTimeInTimeOut(time_in,time_out,check_in_time,check_out_time,isMandateEffortEstimation) && chkEmpty()){
					//Added Aganst ML-MMOH-CRF-1979-US02...starts
							if (document.getElementById('A').checked) rows2[jj].team = document.getElementById('A').value;
							if (document.getElementById('B').checked) rows2[jj].team = document.getElementById('B').value;
							rows2[jj].time_in = document.forms[0].time_in_date.value+" "+document.forms[0].time_in_time.value;
							rows2[jj].time_out = document.forms[0].time_out_date.value+" "+document.forms[0].time_out_time.value;
							if(rows2[jj].db_mode=='L') rows2[jj].db_mode='U';
						resetFields();
						setTimeout(function(){parent.DetailFrame.location.href='../../eOT/jsp/PersonnelDtls.jsp?'+params+ "&disp_hosp="+disp_hosp,1000});
						parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
					}
				}
			}else{
				continue;
			}
		}
}

function assignRecId(){
	var rows = parent.parent.parent.ObjectCollect.personnelrows;
	parent.parent.parent.ObjectCollect.personnelrowLength=rows.length;
	
}

function getRecId(){
	var rowLength=parent.parent.parent.ObjectCollect.personnelrowLength;
	var recId = rowLength+1;
	parent.parent.parent.ObjectCollect.personnelrowLength  =  recId;
	return recId;
}


function removeRow()
 {
	 var formObj = document.PersonnelRecordForm;
	 var mode = formObj.mode.value;
	 var recId = formObj.recId.value;
	 var params = formObj.params.value;
	 var objrow = newRow();
	 var rows = parent.parent.parent.ObjectCollect.personnelrows;
	 objrow=rows;
		if(rows.length>0&& mode=='U')
		{
			for(var  jj=rows.length; jj>-1; jj--)
			{
				if(rows[jj]!=null  && rows[jj].recId!=null && rows[jj].recId!="")
				{
					if(rows[jj].recId==recId )
					{
					  if(rows[jj].db_mode=='L')
						  {	
							  rows[jj].db_mode='D';
						  }
					  else
						  {
							  rows.splice(jj,1);
						  }
						 // rows.splice(jj,1);//ML-BRU-SCF-1192 [IN:045650]
	         			  break;
					 }
				 }
			else
			continue;
		 }//end for-Loop
	   resetFields();
	   parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
	   //parent.DetailFrame.location.href='../../eOT/jsp/PersonnelDtls.jsp?'+params;
	   setTimeout(function(){parent.DetailFrame.location.href='../../eOT/jsp/PersonnelDtls.jsp?'+params,1000});//Added Against SKR-SCF-1744
	   refresh(); //added for cancel
	 }else
	   resetFields();
	   isValidDocumentation();
 }

function isValidDocumentation(){
	 var rows = parent.parent.parent.ObjectCollect.personnelrows;
	 var role="";
	 var formObj = parent.parent.parent.doc_status_frame.SurgeonDocStatusForm;
	  if(rows!=null && rows.length>0){
			for(i=0;i<rows.length;i++){
				if(rows[i]!=null && rows[i].db_mode!='D') role+=rows[i].role_type+",";
			}
	}
	if(role.length>0){
		if(role.indexOf("OS")>=0 && role.indexOf("MA")>=0){
		}else
			formObj.doc_complete.checked = false;
	}
  }

function newRow()
{
   var objrow = new Class_personnelrow();
   objrow.recId = parent.parent.parent.ObjectCollect.personnelrows.length+1;
   return(objrow);
}


function chkEmpty(){
	var formObj = document.PersonnelRecordForm;
	var fields = new Array(formObj.role_desc,formObj.practitioner_name);
	var names = new Array('Role','Name');
	var messageFrame = parent.parent.parent.messageFrame;
	var mandate_eff_estimation_yn = document.forms[0].mandate_eff_estimation_yn.value;
	var isMandateEffortEstimation = document.forms[0].isMandateEffortEstimation.value;
	if(mandate_eff_estimation_yn === 'Y' && isMandateEffortEstimation == 'true'){
		var names = new Array('Role','Name','Time in Date','Time in Time','Time out Date','Time out Time');//Added Against ML-MMOH-CRF-1979-US02
		var fields = new Array(formObj.role_desc,formObj.practitioner_name,formObj.time_in_date,formObj.time_in_time,formObj.time_out_date,formObj.time_out_time);//Added Against ML-MMOH-CRF-1979-US02
	
		if(checkFields( fields, names, messageFrame)){
			if(document.getElementById('A').checked == true || document.getElementById('B').checked == true) {
				return true;
			}else{
				errors = getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent('Team Selection')))+"<br>"
				messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
				return false;
			}
		}
	}else if(mandate_eff_estimation_yn === 'N' && isMandateEffortEstimation == 'true'){
		
		var time_in_date = formObj.time_in_date.value;
		var time_in_time = formObj.time_in_time.value;
		var time_out_date = formObj.time_out_date.value;
		var time_out_time = formObj.time_out_time.value;
		
		if ((time_in_date || time_in_time || time_out_date || time_out_time) && !(time_in_date && time_in_time && time_out_date && time_out_time)){
				/* errors = getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent('Time in/out')))+"<br>"
				messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
		 
				return false; */
		var names = new Array('Role','Name','Time in Date','Time in Time','Time out Date','Time out Time');
		var fields = new Array(formObj.role_desc,formObj.practitioner_name,formObj.time_in_date,formObj.time_in_time,formObj.time_out_date,formObj.time_out_time);
		
		}else{
		var names = new Array('Role','Name');
		var fields = new Array(formObj.role_desc,formObj.practitioner_name);
		}
		if(checkFields(fields, names, messageFrame)) return true;
	}else{
		var names = new Array('Role','Name');
		var fields = new Array(formObj.role_desc,formObj.practitioner_name);
		if(checkFields(fields, names, messageFrame)) return true;
	}
}

function alreadyExist(){
	var formObj = document.PersonnelRecordForm;
	var codeDtl = parent.DetailFrame.code; 
	var spltyCodeDtl = parent.DetailFrame.splty_code; 
	var operCodeDtl = parent.DetailFrame.oper_code; 
	var rows = parent.parent.parent.ObjectCollect.personnelrows;
	var speciality_code=formObj.speciality.value;
	var role_id = formObj.role_id.value;
	var practitioner_id = formObj.practitioner_id.value;
	var codeRecord = practitioner_id+",";
	var operCodeArr = operCodeDtl.split(",");
	var spltyArr = spltyCodeDtl.split(",");
	var splCode =  codeDtl.split(",");
	var isMandateEffortEstimation = document.forms[0].isMandateEffortEstimation.value;//Added Agaisnt ML-MMOH-CRF-1979-US02

//modified by DhanasekarV 17/01/2011 against issue IN025911
	if(isMandateEffortEstimation == 'true'){
		var operation_code = formObj.operation.value;			
			for (var i=0 ;i<splCode.length;i++){
				if(splCode[i]==practitioner_id && operCodeArr[i]==operation_code) return false; //Modified Against ML-MMOH-SCF-2950 By Gaurav
			}
	}else{
		for (var i=0 ;i<spltyArr.length;i++)
		{ 
			if(spltyArr[i]==speciality_code && splCode[i]==practitioner_id) return false;
		}
	}
	return true;


 }

 function assign(obj){
	 formObj = document.PersonnelRecordForm;
	 var str = obj.value;
	 var arr = str.split("##");
	 formObj.role_id.value=arr[0];
	 formObj.role_type.value=arr[1];
 }
//CRF-CHL-20.1
function hideSelect()
{
	var disp_hosp = '';
	if(document.forms[0].tab.value =="record_surgeon")
		disp_hosp = parent.parent.parent.frames[4].RecordSurgeonTabForm.disp_hosp.value;//Added for CHL-CRF-0020.1 [IN:043132]
	else if(document.forms[0].tab.value =="record_nursing")
		disp_hosp = parent.parent.parent.frames[3].RecordNursingTabForm.disp_hosp.value;//Added for CHL-CRF-0020.1 [IN:043132]
	if(disp_hosp == 'N')
	{
		document.getElementById("recordId").style.display = 'none';
		document.getElementById("cancelId").style.display = 'none';
	}
}
//Added Against ML-MMOH-CRF-1979-US02...starts
function populateOperations(){
	var formObj=document.forms[0];
	var oper_desc=new Array();
	var oper_code=new Array();
	var oper_line_no=new Array();
	var specialityArr=new Array();
	var objFrm = parent.parent.parent.ObjectCollect;
	var operationObj=formObj.operation;
	var specialityObj=formObj.speciality;
	var count = 0;
	var value = "";
	  
	if(objFrm.rows!=null){
		for(var i=0;i<objFrm.rows.length;i++) {
			if(objFrm.rows[i]!=null  && objFrm.rows[i].db_mode!='D'){
				oper_code[i]=objFrm.rows[i].oper_code;
				oper_desc[i]=objFrm.rows[i].oper_desc; 
				oper_line_no[i]=objFrm.rows[i].line_no;
				operationObj.options[i]=new Option(oper_desc[i],oper_code[i]);
				
				specialityArr = populateSpeciality(oper_code[i]);
				specialityArr[3] = oper_line_no[i];
				if(oper_line_no[i] == 1 && specialityArr[3] == 1){	
					count = i;
				}
			}
		}
	}
	operationObj.selectedIndex = count;
	specialityObj.selectedIndex = count;
	//Added against ML-MMOH-SCF-2899
	if(formObj.speciality.value == '' || formObj.speciality.value == null)
		count = 0;
	
	specialityObj.selectedIndex = count;
}


function isValueInObj(Obj, specialityArr) {
    for (var i = 0; i < Obj.options.length; i++) {
        if (Obj.options[i].value === specialityArr[0]) {
            return true;
        }
    }
		return false;
}

function getSpeciality(oper_code){
	var Obj = document.forms[0].speciality;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=getSpecialityDesc&oper_code="+oper_code,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var specialityArr = retVal.split("*");
	return specialityArr;
}

function populateSpeciality(oper_code){
	var Obj = document.forms[0].speciality;
	var specialityArr = getSpeciality(oper_code);
    // Check if the value already exists in the dropdown
    if (!isValueInObj(Obj, specialityArr)) {
        var listOption1	= document.createElement('option');
		listOption1.value = specialityArr[0];
		listOption1.text = specialityArr[1];
		Obj.add(listOption1);
    }
	return specialityArr;
}

function updateSpeciality(oper_code){
	var Obj = document.forms[0].speciality;
	var specialityArr = getSpeciality(oper_code);	
	for (var i = 0; i < Obj.options.length; i++) {
            if (Obj.options[i].value === specialityArr[0]) {
				count = i;
            }
        }
	Obj.selectedIndex = count;	
}	

function changeDateForm(date_time){
	var fromdt = "";
	if(date_time.length > 0) {
		var date_time_array = date_time.split(" ");
		var date = date_time_array[0];
		var time = date_time_array[1];
        var datearray = date.split("-");
        var timearray = time.split(":");
		fromdt = datearray[2]+"/"+datearray[1]+"/"+datearray[0]+" "+timearray[0]+":"+timearray[1];            
    }
	return fromdt;
}
	
function validateTimeInTimeOut(timeIn, timeOut, checkIn_Time, checkOut_Time,isMandateEffortEstimation) {
	if((isMandateEffortEstimation == 'true') && (document.forms[0].time_in_date.value != '' && document.forms[0].time_in_time.value  != '' && document.forms[0].time_out_date.value  != '' && document.forms[0].time_out_time.value != '')){
		
		var checkInTime = changeDateForm(checkIn_Time);
		var checkOutTime = changeDateForm(checkOut_Time);
		var timeInParsed = timeIn;
		var timeOutParsed = timeOut;
		var messageFrame = parent.parent.parent.messageFrame;
		var locale = document.forms[0].locale.value;
		var sysdate = document.forms[0].sysdate.value;
		// Check if 'to date&time' is not before 'from date&time'
		if(compareDates2(timeOutParsed,timeInParsed,locale,'DMYHM')) {
			error = getMessage("TIME_OUT_LESS_TIME_IN","OT");
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("TIME_OUT_LESS_TIME_IN","OT");
			return false;
		}

		// Check if 'from date&time' and 'to date&time' fall within the given date range
		if(compareDates2(timeInParsed,checkInTime,locale,'DMYHM')){
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("TIME_IN_LESS_CHECK_IN","OT");
			return false;
		}
		
		if(compareDates2(checkOutTime,timeOutParsed,locale,'DMYHM')) {
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("TIME_OUT_GREATER_CHECK_OUT","OT")+"["+(trimString(checkOutTime))+"]";
		return false;
		}
		var returnValone = compareDates2(timeInParsed,sysdate,locale,'DMYHM');
		if(returnValone==false){
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("APP-OT0244","OT");
			return false;
		}
		var returnValone2 = compareDates2(timeOutParsed,sysdate,locale,'DMYHM');
		if(returnValone2==false){
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("APP-OT0245","OT");
			return false;
		}
	}	
	return true;
}

function compareDates2(fromdate,todate,locale,format) {
    var fromarray; var toarray;
	var fromdate = dateUtils(fromdate,locale,format);
	var todate = dateUtils(todate,locale,format);
	
    if(fromdate.length > 0 && todate.length > 0 ) {
		var from_date_array = fromdate.split(" ");
		var from_date = from_date_array[0];
		var from_time = from_date_array[1];
		
		var to_date_array = todate.split(" ");
		var to_date = to_date_array[0];
		var to_time = to_date_array[1];
		
		var fromdatearray = from_date.split("/");
        var todatearray = to_date.split("/");
		
		var fromtimearray = from_time.split(":");
        var totimearray = to_time.split(":");
		
		var fromdt = new Date(fromdatearray[2],fromdatearray[1],fromdatearray[0],fromtimearray[0],fromtimearray[1]);
        var todt = new Date(todatearray[2],todatearray[1],todatearray[0],totimearray[0],totimearray[1]);
        if(Date.parse(todt) < Date.parse(fromdt)) {
			return false;
        }
		return true;
	}else{
		return false;
	}
	
}

function clearFields(){
	
	//var team = document.getElementsByName('team');
	//for(var i=0;i<team.length;i++)  team[i].checked = false;
	document.getElementById("role_desc").selectedIndex = 0
	document.forms[0].practitioner_name.value = '';
	document.forms[0].time_in_date.value = '';
	document.forms[0].time_in_time.value = '';
	document.forms[0].time_out_date.value = '';
	document.forms[0].time_out_time.value = '';
	document.PersonnelRecordForm.speciality.disabled = true;
}
//Added Against ML-MMOH-CRF-1979-US02...ends

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<!--Added Against ML-MMOH-CRF-1979-US02...starts-->

<body onLoad="assignSpeciality();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<!--<body onLoad="assignSpeciality();hideSelect();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'-->
<!--Added Against ML-MMOH-CRF-1979-US02...ends-->
<form name = 'PersonnelRecordForm'>
<input type = "hidden"  name='params' id='params'  value="<%=params%>" > 
<input type='hidden' name='tab' id='tab' value="<%=tab%>">

<%
	String called_from =  CommonBean.checkForNull(request.getParameter("called_from"));
	String refresh_flag=CommonBean.checkForNull(request.getParameter("refresh_flag"));
	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
	String oper_room_code = CommonBean.checkForNull(request.getParameter("oper_room_code"));
	String theatre_date = CommonBean.checkForNull(request.getParameter("theatre_date"));
	String check_in_time = "";//CommonBean.checkForNull(request.getParameter("check_in_time"));//Added Against ML-MMOH-CRF-1979-US02
	String sysdate = "";//Added Against ML-MMOH-CRF-1979-US02
	String surgeon_doc_comp_yn ="";
	String nursing_doc_comp_yn ="";
	String customer_id1=""; // Added for IN:046182
	String sql_sm_report="select customer_id from SM_SITE_PARAM where rownum = 1";
	if(tab.equals("record_surgeon")){
		surgeon_doc_comp_yn = CommonBean.checkForNull(request.getParameter("surgeon_doc_comp_yn"));
	} else if(tab.equals("record_nursing")){
		nursing_doc_comp_yn = CommonBean.checkForNull(request.getParameter("nursing_doc_comp_yn"));
	}
	//String db_speciality_code="";
	String db_speciality_code=CommonBean.checkForNull(request.getParameter("SPECIALITY_CODE"));
	String disable_flag="";
	if(surgeon_doc_comp_yn.equals("Y") || nursing_doc_comp_yn.equals("Y"))
		disable_flag="disabled";
	else 
		disable_flag="";

	String SQL1 ="SELECT DISTINCT(SPECIALITY_CODE) FROM OT_POST_OPER_PERSONNEL WHERE  OPERATING_FACILITY_ID=? AND  OPER_NUM=?";
	
	//Added Against ML-MMOH-CRF-1979-US02...starts
	
	String defaultDate = "";
	String defaultTime = "";
	String disable_flag2="";
	if(isMandateEffortEstimation) 
		disable_flag2="disabled";
	else 
		disable_flag2="";
	String mandate_eff_estimation_yn = "N"; 
	String check_out_time = "";
	String bean_id = "OTCommonBean";
	String bean_name = "eOT.OTCommonBean";
	OTCommonBean bean = (OTCommonBean)mh.getBeanObject( bean_id, request, bean_name );
	String sql2 = "Select CHECK_OUT_TIME,CHECK_IN_TIME,TO_CHAR(sysdate,'DD/MM/YYYY HH24:MI') from OT_POST_OPER_HDR where OPERATING_FACILITY_ID=? AND  OPER_NUM=?";
		
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	//CHL-CRF-0020
	PreparedStatement pstmt1 = null;
	ResultSet rst1 = null;
	//CHL-CRF-0020
	try{
		con = ConnectionManager.getConnection(request);
		
		mandate_eff_estimation_yn = checkForNull(bean.getMandateEffEstimation(facility_id)); //Added Against ML-MMOH-CRF-1979-US02
		System.err.println("mandate_eff_estimation_yn === "+mandate_eff_estimation_yn); //Added Against ML-MMOH-CRF-1979-US02
				
		pstmt = con.prepareStatement(sql2);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();	 
		while(rst.next()){
           check_out_time = CommonBean.checkForNull(rst.getString(1));
           check_in_time = CommonBean.checkForNull(rst.getString(2));
           sysdate = CommonBean.checkForNull(rst.getString(3));
		}
	
	defaultDate = sysdate.substring(0,10);
	defaultTime = sysdate.substring(11,16);
	//Added Against ML-MMOH-CRF-1979-US02...ends
		 pstmt=con.prepareStatement(sql_sm_report); // Added for IN:046182
		 rst=pstmt.executeQuery();
		 if(rst !=null && rst.next())
	    {
	    customer_id1=CommonBean.checkForNull(rst.getString("customer_id"));
	    }	
	    if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();// End for IN:046182
		pstmt = con.prepareStatement(SQL1);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();	 
		while(rst.next()){
           db_speciality_code=rst.getString(1);
		}

		if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
				if(rst!=null)rst.close();
				if(rst1!=null)rst1.close();
					if(pstmt!=null)pstmt.close();
				out.println("<script>assignRecId()</script>");
				out.println("<script>refresh()</script>");
			//CHL-CRF-0020 
%>


<table  border='0' cellpadding=3 cellspacing='0' width='100%' align="center">
<tr>
	<!--ML-MMOH-CRF-1979-US02 starts-->
	<%if(isMandateEffortEstimation){%>
		<td class="label" width='5%'>
				<fmt:message key="eOT.Operation.Label" bundle="${ot_labels}"/> 
		</td>
		<td class="label" width='20%'>
			<select name='operation' id='operation' id = 'operation'  onChange="clearFields(); updateSpeciality(this.value)" >
				<option value=""></option>
			</select>
		<%if(mandate_eff_estimation_yn.equals("Y")){%>
			<img src='../../eCommon/images/mandatory.gif'></img>
		<%}%>	
		</td>
	<%}%>	
	<!--ML-MMOH-CRF-1979-US02 end-->
		
		<td class="label" width='5%'>
				<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
		</td>
		<td class="label" width='20%'>
			<select name='speciality' id='speciality' <%=disable_flag2%> ></select>
		</td>
	<!--ML-MMOH-CRF-1979-US02 start-->
	<%if(isMandateEffortEstimation){%>
		<td class="label" width='5%'>
				<fmt:message key="eOT.Team.Label" bundle="${ot_labels}"/>
		</td>
		<td class="label" width='20%'>
			A<input type="radio" name="team" id="team" id="A" value="A">&nbsp;&nbsp;&nbsp;
			B<input type="radio" name="team" id="team" id="B" value="B">
			<%if(mandate_eff_estimation_yn.equals("Y")){%>
				<img src='../../eCommon/images/mandatory.gif'></img>
			<%}%>
		</td>
	<%}%>	
	<!--ML-MMOH-CRF-1979-US02 end-->	
</tr>		
<tr> 
		<td class="label" width='30%'>
				<fmt:message key="Common.Role.label" bundle="${common_labels}"/>
		</td>
		<td class="fields" width='70%'>
			<select name='role_desc' id='role_desc'  onChange="assign(this);" <%=disable_flag%>>
				<option value="">
				<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
				</option>
				<%	  
					String SQL ="SELECT ROLE_DESC,ROLE_ID ,ROLE_TYPE FROM OT_ROLES_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(APPL_TO_OT_SLATE,'N') = 'N' AND NVL(STATUS,'E') = 'E'";
					String val = "";
		
					pstmt = con.prepareStatement(SQL) ;
					rst = pstmt.executeQuery();
					while(rst.next()){
						val = rst.getString("ROLE_ID")+"##"+rst.getString("ROLE_TYPE");
						
				%>
				<option value="<%=val%>"><%=rst.getString("ROLE_DESC")%></option>

			<%	}
			
			%>

</select>
	<img src='../../eCommon/images/mandatory.gif'></img>
			</td>
</tr>
<tr> 
			<td class="label" width='30%'>
					<fmt:message key="Common.name.label" bundle="${common_labels}"/>
			</td>
			<td class="fields" width='70%'>
				<input type='hidden' name='practitioner_id' id='practitioner_id' >
			<input type='text' name='practitioner_name' id='practitioner_name' size='20' onblur="if(this.value!='')searchDoctor(practitioner_id,practitioner_name); else practitioner_id.value='';" <%=disable_flag%> >			
			<input type='button' class='button' value='?' name='DoctorLookUp' id='DoctorLookUp' 	onClick='searchDoctor(practitioner_id,practitioner_name);' <%=disable_flag%> > <img src='../../eCommon/images/mandatory.gif'></img>
			</td>
</tr>
<!--ML-MMOH-CRF-1979-US02 starts-->
<%if(isMandateEffortEstimation){%>
	<tr>
		
			<td class="label" width='5%'>
					<fmt:message key="eOT.TimeIn.Label" bundle="${ot_labels}"/>
			</td>
			<td class="fields" width='10%' align='left'>
			<input type='text' name='time_in_date' id='time_in_date' value='<%=defaultDate%>' size='8' readonly> 
			
			<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('time_in_date');" >
			
			<input type='text' name='time_in_time' id='time_in_time' size='2' maxlength='5' value='<%=defaultTime%>' onkeypress ='return checkForSpecCharsforIDTime(event);' onBlur="if(this.value!='')checkTimeFormat(time_in_date,this);"  >
			
			<%if(mandate_eff_estimation_yn.equals("Y")){%>
			<img src='../../eCommon/images/mandatory.gif'></img>
			<%}%>
	        </td>
			
			<td class="label" width='5%'>
					<fmt:message key="eOT.TimeOut.Label" bundle="${ot_labels}"/>
			</td>
			<td class="fields" width='10%' align='left'>
			<input type='text' name='time_out_date' id='time_out_date' value='<%=defaultDate%>' size='8' readonly> 
			
			<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('time_out_date');" >
			
			<input type='text' name='time_out_time' id='time_out_time' size='2' maxlength='5' value='<%=defaultTime%>' onkeypress ='return checkForSpecCharsforIDTime(event);'  onBlur="if(this.value!='')checkTimeFormat(time_out_date,this);"  >
			
			<%if(mandate_eff_estimation_yn.equals("Y")){%>
			<img src='../../eCommon/images/mandatory.gif'></img>
			<%}%>
			</td>
	<%}%>	
<!--ML-MMOH-CRF-1979-US02 end--> 

			<td width='25%'class="button" colspan="2" >
				<% if(customer_id1.equalsIgnoreCase("MOHBR")){ // Added for IN:046182%>
					<input type='button' name='view' id='view' class='button' value='View Staff Assignment' onClick='javascript:viewStaffAssignment("<%= theatre_date %>","<%=oper_room_code %>")'>
				<%}%>	
			<%if(isMandateEffortEstimation){%>	
				<input type='button' name='record' id='record' id='recordId' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='addRow(document.forms[0].operation.value,document.forms[0].speciality.value,document.forms[0].team.value,document.forms[0].role_desc.value,document.forms[0].practitioner_name.value,document.forms[0].time_in_date.value,document.forms[0].time_in_time.value,document.forms[0].time_out_date.value,document.forms[0].time_out_time.value); disableDocLevel();' <%=disable_flag%> >
			<%}else{%>
				<input type='button' name='record' id='record' id='recordId' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='addRow(); disableDocLevel();' <%=disable_flag%> >
			<%}%>			
				<input type='button' name='cancel' id='cancel' id='cancelId' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow();' <%=disable_flag%> >
			</td>
	
</tr>
</table>
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
<input type='hidden' name='mode' id='mode' value='I'>
<input type='hidden' name='recId' id='recId' value=''>
<input type='hidden' name='oper_num' id='oper_num' value='<%=oper_num%>'>
<input type='hidden' name='called_from' id='called_from' value='<%=called_from%>'>
<input type='hidden' name='db_speciality_code' id='db_speciality_code' value='<%=db_speciality_code%>' >
<input type='hidden' name='role_type' id='role_type' >
<input type='hidden' name='role_id' id='role_id' >
<input type='hidden' name='refresh_flag' id='refresh_flag' value='<%=refresh_flag%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">
<input type='hidden' name='check_in_time' id='check_in_time' value="<%=check_in_time%>"><!--ML-MMOH-CRF-1979-US02-->
<input type='hidden' name='check_out_time' id='check_out_time' value="<%=check_out_time%>"><!--ML-MMOH-CRF-1979-US02-->
<input type='hidden' name='mandate_eff_estimation_yn' id='mandate_eff_estimation_yn' value="<%=mandate_eff_estimation_yn%>"><!--ML-MMOH-CRF-1979-US02-->
<input type='hidden' name='isMandateEffortEstimation' id='isMandateEffortEstimation' value="<%=isMandateEffortEstimation%>"><!--ML-MMOH-CRF-1979-US02-->
<input type='hidden' name='oper_code' id='oper_code' value="<%=oper_code%>"><!--ML-MMOH-CRF-1979-US02-->
<input type='hidden' name='sysdate' id='sysdate' value="<%=sysdate%>"><!--ML-MMOH-CRF-1979-US02-->
<!-- Added below hidden field on march 1,2011 by Anitha -->
<input type='hidden' name='tab_id' id='tab_id' value='<%=CommonBean.checkForNull(request.getParameter("tab_id"))%>'>

</form>
</body>
</html>
<%

	}catch(Exception e){
		 System.err.println("Err Msg in Personnel Records"+e.getMessage());
	}finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
	%>

