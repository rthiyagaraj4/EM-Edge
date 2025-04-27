<!DOCTYPE html>

<html>
<%@ page contentType="text/html;charset=UTF-8" import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.CommonBean,org.json.simple.*" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
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
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script type="text/javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eOT/js/OTCommon.js"></script>
<script type='text/javascript' src='../../eCommon/js/dchk.js'></script>
<script language="JavaScript" src="../../eOT/js/RecordNursing.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function formatTime(obj){
	var duration=obj.value;
	var arr=duration.split(":");
	if(duration!=''){
	if(duration.length!="5" || arr[0].length!="2"){
		alert(getMessage("APP-OT0130","OT"));
		obj.select();
		obj.focus()
		return;
	}
}
	var RE_EXP =/^(0[0-9]|1[0-9]|2[0-3]):(0[0-9]|[12345][0-9])$/;
	if(obj.value!="" && !RE_EXP.test(obj.value) ){
		var err_text="";
	    var time = obj.value;
	    var arr_time =  time.split(":")
        if(arr_time.length!=2){
			cal_error(getMessage("VALID_TIME_SLOTS","OT"),obj);
		}
		if(arr_time[1]=='' || arr_time[0]==''){
		cal_error(getMessage("VALID_TIME_SLOTS","OT"),obj);
		}
		if(arr_time[0]<0 || arr_time[0]>23 ){
			err_text+=getMessage("APP-OT0040","OT");
		}
		if(arr_time[1]<0 || arr_time[1]>59 ){
			err_text+=getMessage("APP-OT0041","OT");
		}
		if(err_text.length>0)	
			cal_error(err_text,obj);
	}
	return true
}


function cal_error (str_message,obj) {
	alert (str_message);
	obj.focus();
	obj.select();
	return null;
}


function ChkNumber(obj){
	var quantity_value=getLabel("Common.Quantity.label","Common");
	var stock_val=getLabel("eOT.StockAvailable.Label","OT");
	var quantity=obj.value;
	CheckNum(obj);
	if(obj.value!="" ){
	  if(quantity==0)
		{
	  alert(quantity_value + getMessage("VALUE_SHOULD_BE_GR_ZERO","common"));
	  obj.select();
	  obj.focus();
		}
	}
}

function assignSpeciality(){
	var formObjHdr = parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
	var doc_level = formObjHdr.doc_level.value;
	if(document.forms[0].tab.value !="record_surgeon")
	{
	callPopulateList(doc_level);
	}else
	{
			if(doc_level=="IS")
		{
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
}else
		{
			assignListItems('*ALL','All Specialities');
		}
	}
 }


function Class_row(){

  var isTimeDtlsSurNurAppl=document.forms[0].isTimeDtlsSurNurAppl.value;//Added by Arthi for ML-MMOH-CRF-1936

  this.speciality_code ="";
  this.speciality_desc ="";
  
  this.db_preparation_time="";
  this.preparation_mts="";

  this.db_procedure_start_time="";
  this.procedure_start_time="";
  this.procedure_start_date="";

  this.db_procedure_end_time="";
  this.procedure_end_time="";
  this.procedure_end_date="";

  this.db_anaesthesia_start_time="";
  this.anaesthesia_start_time="";
  this.anaesthesia_start_date="";

  this.db_anaesthesia_end_time="";
  this.anaesthesia_end_time="";
  this.anaesthesia_end_date="";

  //Added by Arthi for ML-MMOH-CRF-1936
  if(isTimeDtlsSurNurAppl=="true"){
  this.db_prep_start_time="";
  this.prep_start_time="";
  this.prep_start_date="";

  this.db_prep_end_time="";
  this.prep_end_time="";
  this.prep_end_date="";
  }
  //End ML-MMOH-CRF-1936
  
  this.db_surgery_start_time="";
  this.surgery_start_time="";
  this.surgery_start_date="";

  this.db_surgery_end_time="";
  this.surgery_end_time="";
  this.surgery_end_date="";

  this.recId="";
  this.db_mode="";
  this.verify_flag="OFF";
}

function loadDBRows(speciality_code,speciality_desc,prep_time,proc_start_time,proc_end_time,anaes_start_time,anaes_end_time,prepr_start_time,prepr_end_time,surg_start_time,surg_end_time,index,mode){ 
  var objrow = newRow();
  var rows=parent.parent.ObjectCollect.time_rows;
  var result = "";
  var rowLength=parent.parent.parent.ObjectCollect.time_len;
  var isTimeDtlsSurNurAppl=document.forms[0].isTimeDtlsSurNurAppl.value;//Added by Arthi for ML-MMOH-CRF-1936

  if(mode=='L' && rowLength==0){
	  objrow.speciality_code=speciality_code;
	  objrow.speciality_desc=speciality_desc;

	//Added by Arthi for ML-MMOH-CRF-1936
	if(isTimeDtlsSurNurAppl=="true"){
	 //preparation time
	 if(prep_time!=""){
		objrow.db_preparation_time=prep_time;
		var arr1= prep_time.split(" ");
		result = arr1[1];
		var arr2 = result.split(":");
		objrow.preparation_mts = eval(arr2[0]*60) + eval(arr2[1]);
	 }else{
		 objrow.db_preparation_time="";
		 objrow.preparation_date = ""; 
		 objrow.preparation_time = "";
	  }
	 //procedure start
	  if(proc_start_time!=""){
	  objrow.db_procedure_start_time=proc_start_time;
		var arr2 = proc_start_time.split(" ");
		objrow.procedure_start_date = arr2[0];
		objrow.procedure_start_time = arr2[1];
	  }else{
		objrow.db_procedure_start_time="";
		objrow.procedure_start_date ="";
		objrow.procedure_start_time ="";
	  }
	 //procedure end
	  if(proc_end_time!=""){
	  objrow.db_procedure_end_time=proc_end_time;
		var arr3 = proc_end_time.split(" ");
		objrow.procedure_end_date = arr3[0];
		objrow.procedure_end_time = arr3[1];
	  }else{
		  objrow.db_procedure_end_time="";
		  objrow.procedure_end_date ="";
		  objrow.procedure_end_time = "";
	  }
	  //anaesthesia start
	  if(anaes_start_time!=""){
	  objrow.db_anaesthesia_start_time=anaes_start_time;
	    var arr4 = anaes_start_time.split(" ");
		objrow.anaesthesia_start_date = arr4[0];
		objrow.anaesthesia_start_time = arr4[1];
	  }else{
		  objrow.db_anaesthesia_start_time="";
	      objrow.anaesthesia_start_date = "";
		  objrow.anaesthesia_start_time = "";
	  }
	  //anaesthesia end
	  if(anaes_end_time){
		  objrow.db_anaesthesia_end_time=anaes_end_time;
		  var arr5 = anaes_end_time.split(" ");
          objrow.anaesthesia_end_date = arr5[0];
	      objrow.anaesthesia_end_time = arr5[1];
		}else{
			objrow.db_anaesthesia_end_time="";
	  	    objrow.anaesthesia_end_date = "";
		    objrow.anaesthesia_end_time = "";

		}
	  //Preparation start
		if(prepr_start_time!=""){
		objrow.db_prep_start_time=prepr_start_time;
	  	var arr6 = prepr_start_time.split(" ");
		objrow.prep_start_date = arr6[0];
		objrow.prep_start_time = arr6[1];
		}else{
			objrow.db_prep_start_time="";
	  		objrow.prep_start_date = "";
			objrow.prep_start_time = "";
		}
	  //Preparation end
		if(prepr_end_time!=""){
			objrow.db_prep_end_time=prepr_end_time;
			var arr7 = prepr_end_time.split(" ");
			objrow.prep_end_date = arr7[0];
			objrow.prep_end_time = arr7[1];
		}else{
			objrow.db_prep_end_time=""
			objrow.prep_end_date = "";
			objrow.prep_end_time = "";
		}
	  //surgery start
		if(surg_start_time!=""){
		objrow.db_surgery_start_time=surg_start_time;
	  	var arr8 = surg_start_time.split(" ");
		objrow.surgery_start_date = arr8[0];
		objrow.surgery_start_time = arr8[1];
		}else{
			objrow.db_surgery_start_time="";
	  		objrow.surgery_start_date = "";
			objrow.surgery_start_time = "";
		}
	//surgery end
		if(surg_end_time!=""){
			objrow.db_surgery_end_time=surg_end_time;
			var arr9 = surg_end_time.split(" ");
			objrow.surgery_end_date = arr9[0];
			objrow.surgery_end_time = arr9[1];
		}else{
			objrow.db_surgery_end_time=""
			objrow.surgery_end_date = "";
			objrow.surgery_end_time = "";
		}
	}else{
		//preparation time
	 if(prep_time!=""){
		objrow.db_preparation_time=prep_time;
		var arr1= prep_time.split(" ");
		result = arr1[1];
		var arr2 = result.split(":");
		objrow.preparation_mts = eval(arr2[0]*60) + eval(arr2[1]);
	 }else{
		 objrow.db_preparation_time="";
		 objrow.preparation_date = ""; 
		 objrow.preparation_time = "";
	  }
	 //procedure start
	  if(proc_start_time!=""){
	  objrow.db_procedure_start_time=proc_start_time;
		var arr2 = proc_start_time.split(" ");
		objrow.procedure_start_date = arr2[0];
		objrow.procedure_start_time = arr2[1];
	  }else{
		objrow.db_procedure_start_time="";
		objrow.procedure_start_date ="";
		objrow.procedure_start_time ="";
	  }
	 //procedure end
	  if(proc_end_time!=""){
	  objrow.db_procedure_end_time=proc_end_time;
		var arr3 = proc_end_time.split(" ");
		objrow.procedure_end_date = arr3[0];
		objrow.procedure_end_time = arr3[1];
	  }else{
		  objrow.db_procedure_end_time="";
		  objrow.procedure_end_date ="";
		  objrow.procedure_end_time = "";
	  }
	  //anaesthesia start
	  if(anaes_start_time!=""){
	  objrow.db_anaesthesia_start_time=anaes_start_time;
	    var arr4 = anaes_start_time.split(" ");
		objrow.anaesthesia_start_date = arr4[0];
		objrow.anaesthesia_start_time = arr4[1];
	  }else{
		  objrow.db_anaesthesia_start_time="";
	      objrow.anaesthesia_start_date = "";
		  objrow.anaesthesia_start_time = "";
	  }
	  //anaesthesia end
	  if(anaes_end_time){
		  objrow.db_anaesthesia_end_time=anaes_end_time;
		  var arr5 = anaes_end_time.split(" ");
          objrow.anaesthesia_end_date = arr5[0];
	      objrow.anaesthesia_end_time = arr5[1];
		}else{
			objrow.db_anaesthesia_end_time="";
	  	    objrow.anaesthesia_end_date = "";
		    objrow.anaesthesia_end_time = "";
		}
	  //surgery start
		if(surg_start_time!=""){
		objrow.db_surgery_start_time=surg_start_time;
	  	var arr6 = surg_start_time.split(" ");
		objrow.surgery_start_date = arr6[0];
		objrow.surgery_start_time = arr6[1];
		}else{
			objrow.db_surgery_start_time="";
	  		objrow.surgery_start_date = "";
			objrow.surgery_start_time = "";
		}
	//surgery end
		if(surg_end_time!=""){
			objrow.db_surgery_end_time=surg_end_time;
			var arr7 = surg_end_time.split(" ");
			objrow.surgery_end_date = arr7[0];
			objrow.surgery_end_time = arr7[1];
		}else{
			objrow.db_surgery_end_time=""
			objrow.surgery_end_date = "";
			objrow.surgery_end_time = "";
		}
	}
	    objrow.db_mode="L";
	    objrow.recId = index;
	    rows.push(objrow);
	}
}


function refresh(){
	var formObj = document.forms[0];
	var params = formObj.params.value;
	 parent.parent.RecordFrame.DetailFrame.location.href='../../eOT/jsp/NursingTimeDtls.jsp?'+params;
}

function addRow(){

	//Added by Arthi for ML-MMOH-CRF-1936
	var isTimeDtlsSurNurAppl=document.forms[0].isTimeDtlsSurNurAppl.value;
	if(isTimeDtlsSurNurAppl=="true"){
		var fields = new Array ();
		var names = new Array ();
		if(document.getElementById("anesProcmandImgStart").style.visibility=='visible'){
			fields = fields.concat( document.forms[0].procedure_start_date ) ;
            names = names.concat( getLabel('eOT.AnaesthesiaProcedureStartTime.Label','OT') ) ;
		}
		if(document.getElementById("anesProcmandImgEnd").style.visibility=='visible'){
			fields = fields.concat( document.forms[0].procedure_end_date ) ;
            names = names.concat( getLabel('eOT.AnaesthesiaProcedureEndTime.Label','OT') ) ;
		}
		if(document.getElementById("anesmandImgStart").style.visibility=='visible'){
			fields = fields.concat( document.forms[0].anaesthesia_start_date ) ;
            names = names.concat( getLabel('eOT.AnaesthesiaStartTime.Label','OT') ) ;
		}
		if(document.getElementById("anesmandImgEnd").style.visibility=='visible'){
			fields = fields.concat( document.forms[0].anaesthesia_end_date ) ;
            names = names.concat( getLabel('eOT.AnaesthesiaEndTime.Label','OT') ) ;
		}
		if(document.getElementById("prepmandImgStart").style.visibility=='visible'){
			fields = fields.concat( document.forms[0].prep_start_date ) ;
            names = names.concat( getLabel('eOT.Preparation.Label','OT')+" "+getLabel('Common.StartTime.label','common') ) ;
		}
		if(document.getElementById("prepmandImgEnd").style.visibility=='visible'){
			fields = fields.concat( document.forms[0].prep_end_date ) ;
            names = names.concat( getLabel('eOT.Preparation.Label','OT')+" "+getLabel('Common.EndTime.label','common') ) ;
		}
		if(document.getElementById("surgmandImgStart").style.visibility=='visible'){
			fields = fields.concat( document.forms[0].surgery_start_date ) ;
            names = names.concat( getLabel('Common.Surgery.label','common')+" "+getLabel('Common.StartTime.label','common') ) ;
		}
		if(document.getElementById("surgmandImgEnd").style.visibility=='visible'){
			fields = fields.concat( document.forms[0].surgery_end_date ) ;
            names = names.concat( getLabel('Common.Surgery.label','common')+" "+getLabel('Common.EndTime.label','common') ) ;
		}
		if(checkFieldsofMst( fields, names, parent.parent.messageFrame)){
		
			  var objrow = newRow();
			  var rows=parent.parent.ObjectCollect.time_rows;
			  var formObj = document.NursingTimeRecordForm;
			  var obj = formObj.speciality;
			  var mode =formObj.mode.value;
			  var result = convertMts();
			  result = trimString(result);
			  var msg = trimString(getMessage("CODE_ALREADY_EXISTS","Common"));
			  if(mode=='I' && validateEndDate()==true ){
				if(alreadyExist()){ 		
				 objrow.speciality_code=formObj.speciality.value;
				 objrow.speciality_desc=formObj.speciality[obj.selectedIndex].text;
				 
				  objrow.db_preparation_time=result;
				  objrow.preparation_mts = formObj.preparation_time.value;
						 
				 //procedure start
				 objrow.db_procedure_start_time=formObj.procedure_start_date.value+" "+formObj.procedure_start_time.value;
				 objrow.procedure_start_time=formObj.procedure_start_time.value;
				 objrow.procedure_start_date=formObj.procedure_start_date.value;
				
				//procedure end
				 objrow.db_procedure_end_time=formObj.procedure_end_date.value+" "+formObj.procedure_end_time.value;
				 objrow.procedure_end_time=formObj.procedure_end_time.value;
				 objrow.procedure_end_date=formObj.procedure_end_date.value;
				 //anaesthesia start
				 objrow.db_anaesthesia_start_time=formObj.anaesthesia_start_date.value+" "+formObj.anaesthesia_start_time.value;
				 objrow.anaesthesia_start_time=formObj.anaesthesia_start_time.value;
				 objrow.anaesthesia_start_date=formObj.anaesthesia_start_date.value;
				 //anaesthesia end
				 objrow.db_anaesthesia_end_time=formObj.anaesthesia_end_date.value+" "+formObj.anaesthesia_end_time.value;
				 objrow.anaesthesia_end_time=formObj.anaesthesia_end_time.value;
				 objrow.anaesthesia_end_date=formObj.anaesthesia_end_date.value;

				//Preparation start
				 objrow.db_prep_start_time=formObj.prep_start_date.value+" "+formObj.prep_start_time.value;
				 objrow.prep_start_time=formObj.prep_start_time.value;
				 objrow.prep_start_date=formObj.prep_start_date.value;
				//Preparation end
				 objrow.db_prep_end_time=formObj.prep_end_date.value+" "+formObj.prep_end_time.value;
				 objrow.prep_end_time=formObj.prep_end_time.value;
				 objrow.prep_end_date=formObj.prep_end_date.value;
				
				 //surgery start
				 objrow.db_surgery_start_time=formObj.surgery_start_date.value+" "+formObj.surgery_start_time.value;
				 objrow.surgery_start_time=formObj.surgery_start_time.value;
				 objrow.surgery_start_date=formObj.surgery_start_date.value;
				//surgery end
				 objrow.db_surgery_end_time=formObj.surgery_end_date.value+" "+formObj.surgery_end_time.value;
				 objrow.surgery_end_time=formObj.surgery_end_time.value;
				 objrow.surgery_end_date=formObj.surgery_end_date.value;
				  
				  objrow.db_mode="I";
				  objrow.recId = rows.length+1;
				  rows.push(objrow);
				   resetFields();
				   parent.parent.RecordFrame.DetailFrame.location.href='../../eOT/jsp/NursingTimeDtls.jsp';
				  parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';

				}else
				parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
			} else if(validateEndDate()==true){
				  updateRow();
				  parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
				}
	}
	}else{
	  var objrow = newRow();
	  var rows=parent.parent.ObjectCollect.time_rows;
	  var formObj = document.NursingTimeRecordForm;
	  var obj = formObj.speciality;
	  var mode =formObj.mode.value;
	  var result = convertMts();
  result = trimString(result);
   var msg = trimString(getMessage("CODE_ALREADY_EXISTS","Common"));
  if(mode=='I' && validateEndDate()==true ){
	if(alreadyExist()){ 		
	 objrow.speciality_code=formObj.speciality.value;
	 objrow.speciality_desc=formObj.speciality[obj.selectedIndex].text;
	 
	  objrow.db_preparation_time=result;
	  objrow.preparation_mts = formObj.preparation_time.value;
	 	 	 
	 //procedure start
	 objrow.db_procedure_start_time=formObj.procedure_start_date.value+" "+formObj.procedure_start_time.value;
	 objrow.procedure_start_time=formObj.procedure_start_time.value;
	 objrow.procedure_start_date=formObj.procedure_start_date.value;
	
	//procedure end
	 objrow.db_procedure_end_time=formObj.procedure_end_date.value+" "+formObj.procedure_end_time.value;
	 objrow.procedure_end_time=formObj.procedure_end_time.value;
	 objrow.procedure_end_date=formObj.procedure_end_date.value;
	 //anaesthesia start
	 objrow.db_anaesthesia_start_time=formObj.anaesthesia_start_date.value+" "+formObj.anaesthesia_start_time.value;
	 objrow.anaesthesia_start_time=formObj.anaesthesia_start_time.value;
	 objrow.anaesthesia_start_date=formObj.anaesthesia_start_date.value;
	 //anaesthesia end
	 objrow.db_anaesthesia_end_time=formObj.anaesthesia_end_date.value+" "+formObj.anaesthesia_end_time.value;
	 objrow.anaesthesia_end_time=formObj.anaesthesia_end_time.value;
	 objrow.anaesthesia_end_date=formObj.anaesthesia_end_date.value;
	 //surgery start
	 objrow.db_surgery_start_time=formObj.surgery_start_date.value+" "+formObj.surgery_start_time.value;
	 objrow.surgery_start_time=formObj.surgery_start_time.value;
	 objrow.surgery_start_date=formObj.surgery_start_date.value;
	//surgery end
	 objrow.db_surgery_end_time=formObj.surgery_end_date.value+" "+formObj.surgery_end_time.value;
	 objrow.surgery_end_time=formObj.surgery_end_time.value;
	 objrow.surgery_end_date=formObj.surgery_end_date.value;
	  
	  objrow.db_mode="I";
	  objrow.recId = rows.length+1;
	  rows.push(objrow);
	   resetFields();
	   parent.parent.RecordFrame.DetailFrame.location.href='../../eOT/jsp/NursingTimeDtls.jsp';
	  parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';

	}else
	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
} else if(validateEndDate()==true){
	  updateRow();
	  parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
	}
		
	}
	  
}

function disableDocLevel(){
   var formObj = parent.parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;
   if(formObj.doc_level.disabled==false)
	   formObj.doc_level.disabled=true;
}




function newRow(){
  var objrow = new Class_row();
   return(objrow);
}


function alreadyExist(){
	var formObj = document.forms[0];
	var codeDtl = parent.parent.RecordFrame.DetailFrame.code; 
	var codeRecord = formObj.speciality.value;
	if(codeDtl.indexOf(codeRecord)>=0){
	   return false;
	}
	else
	   return true;
 }



function removeRow(){
var formObj = document.forms[0];
var rows=parent.parent.ObjectCollect.time_rows;
var recId = document.forms[0].recId.value;
var mode = document.forms[0].mode.value;
if(rows.length>0 && mode=='U'){        
  for(var jj=0;jj<rows.length;jj++){
	 if(rows[jj]!=null){
		if(rows[jj].recId==recId){
			 if(rows[jj].db_mode=='L')
				rows[jj].db_mode='D';
			 else
			  delete rows[jj];
			   break;
		}
	 }else
	continue;
 }//end for-Loop
 resetFields();
 parent.parent.RecordFrame.DetailFrame.location.href='../../eOT/jsp/NursingTimeDtls.jsp';
 parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
}else
   resetFields();
}

function updateRow(){
	var isTimeDtlsSurNurAppl=document.forms[0].isTimeDtlsSurNurAppl.value;//Added by Arthi for ML-MMOH-CRF-1936
	var formObj = document.forms[0];
	var mode =formObj.mode.value
	var recId = formObj.recId.value;
	var result = convertMts();
	result = trimString(result);
	var rows=parent.parent.ObjectCollect.time_rows;
	if(rows.length>0 && mode=='U'){        
	for(var jj=0;jj<rows.length;jj++){
	if(rows[jj]!=null){
	 if(rows[jj].recId==recId){
	 rows[jj].db_preparation_time=result;
	 rows[jj].preparation_mts = formObj.preparation_time.value;
		//procedure start
		 rows[jj].db_procedure_start_time=formObj.procedure_start_date.value+" "+formObj.procedure_start_time.value;
		 rows[jj].procedure_start_time=formObj.procedure_start_time.value;
		 rows[jj].procedure_start_date=formObj.procedure_start_date.value;
		
		//procedure end
		 rows[jj].db_procedure_end_time=formObj.procedure_end_date.value+" "+formObj.procedure_end_time.value;
		 rows[jj].procedure_end_time=formObj.procedure_end_time.value;
		 rows[jj].procedure_end_date=formObj.procedure_end_date.value;
		 //anaesthesia start
		 rows[jj].db_anaesthesia_start_time=formObj.anaesthesia_start_date.value+" "+formObj.anaesthesia_start_time.value;
		 rows[jj].anaesthesia_start_time=formObj.anaesthesia_start_time.value;
		 rows[jj].anaesthesia_start_date=formObj.anaesthesia_start_date.value;
		 //anaesthesia end
		 rows[jj].db_anaesthesia_end_time=formObj.anaesthesia_end_date.value+" "+formObj.anaesthesia_end_time.value;
		 rows[jj].anaesthesia_end_time=formObj.anaesthesia_end_time.value;
		 rows[jj].anaesthesia_end_date=formObj.anaesthesia_end_date.value;

		//Added by Arthi for ML-MMOH-CRF-1936
		if(isTimeDtlsSurNurAppl=="true"){
		//Preparation start
		rows[jj].db_prep_start_time=formObj.prep_start_date.value+" "+formObj.prep_start_time.value;
		rows[jj].prep_start_time=formObj.prep_start_time.value;
		rows[jj].prep_start_date=formObj.prep_start_date.value;
		//Preparation end
		rows[jj].db_prep_end_time=formObj.prep_end_date.value+" "+formObj.prep_end_time.value;
		rows[jj].prep_end_time=formObj.prep_end_time.value;
		rows[jj].prep_end_date=formObj.prep_end_date.value;
		}
		//End ML-MMOH-CRF-1936

		//surgery start	
		rows[jj].db_surgery_start_time=formObj.surgery_start_date.value+" "+formObj.surgery_start_time.value;
		rows[jj].surgery_start_time=formObj.surgery_start_time.value;
		rows[jj].surgery_start_date=formObj.surgery_start_date.value;
		//surgery end
		rows[jj].db_surgery_end_time=formObj.surgery_end_date.value+" "+formObj.surgery_end_time.value;
		rows[jj].surgery_end_time=formObj.surgery_end_time.value;
		rows[jj].surgery_end_date=formObj.surgery_end_date.value;
        if(rows[jj].db_mode=='L'){
		    rows[jj].db_mode='U'
			break;
		}
	  }
	}else  
			continue;
	}//END OF FOR LOOP
      resetFields();
	  parent.parent.RecordFrame.DetailFrame.location.href='../../eOT/jsp/NursingTimeDtls.jsp';
 }
}

function splitString(strVal){
	var isTimeDtlsSurNurAppl=document.forms[0].isTimeDtlsSurNurAppl.value;//Added by Arthi for ML-MMOH-CRF-1936
    var arr = strVal.split('::');
	var frmObj = document.NursingTimeRecordForm;

	//Added by Arthi for ML-MMOH-CRF-1936
	if(isTimeDtlsSurNurAppl=="true"){
	frmObj.speciality.value=arr[0];
	frmObj.speciality.disabled=true;
	frmObj.preparation_time.value=arr[3];
		
	frmObj.procedure_start_time.value = arr[4];
	frmObj.procedure_start_date.value = arr[5];
	frmObj.procedure_end_time.value = arr[6];
	frmObj.procedure_end_date.value = arr[7];

	frmObj.anaesthesia_start_time.value = arr[8];
	frmObj.anaesthesia_start_date.value = arr[9];
	frmObj.anaesthesia_end_time.value = arr[10];
	frmObj.anaesthesia_end_date.value = arr[11];

	frmObj.prep_start_time.value = arr[12];
	frmObj.prep_start_date.value = arr[13];
	frmObj.prep_end_time.value = arr[14];
	frmObj.prep_end_date.value = arr[15];

	frmObj.surgery_start_time.value = arr[16];
	frmObj.surgery_start_date.value = arr[17];
	frmObj.surgery_end_time.value = arr[18];
	frmObj.surgery_end_date.value = arr[19];
	
	frmObj.recId.value=arr[20];
	frmObj.mode.value=arr[21];
	}else{
	frmObj.speciality.value=arr[0];
	frmObj.speciality.disabled=true;
	frmObj.preparation_time.value=arr[3];
		
	frmObj.procedure_start_time.value = arr[4];
	frmObj.procedure_start_date.value = arr[5];
	frmObj.procedure_end_time.value = arr[6];
	frmObj.procedure_end_date.value = arr[7];

	frmObj.anaesthesia_start_time.value = arr[8];
	frmObj.anaesthesia_start_date.value = arr[9];
	frmObj.anaesthesia_end_time.value = arr[10];
	frmObj.anaesthesia_end_date.value = arr[11];

	frmObj.surgery_start_time.value = arr[12];
	frmObj.surgery_start_date.value = arr[13];
	frmObj.surgery_end_time.value = arr[14];
	frmObj.surgery_end_date.value = arr[15];
	
	frmObj.recId.value=arr[16];
	frmObj.mode.value=arr[17];	
	}
	
}

function resetFields(){
	var isTimeDtlsSurNurAppl=document.forms[0].isTimeDtlsSurNurAppl.value;//Added by Arthi for ML-MMOH-CRF-1936
	var frmObj = document.NursingTimeRecordForm;
	frmObj.preparation_time.value="";
	
	frmObj.procedure_start_time.value = "";
	frmObj.procedure_start_date.value = "";
	frmObj.procedure_end_time.value = "";
	frmObj.procedure_end_date.value = "";

	frmObj.anaesthesia_start_time.value = "";
	frmObj.anaesthesia_start_date.value = "";
	frmObj.anaesthesia_end_time.value = "";
	frmObj.anaesthesia_end_date.value ="";

	//Added by Arthi for ML-MMOH-CRF-1936
	if(isTimeDtlsSurNurAppl=="true"){
	frmObj.prep_start_time.value = "";
	frmObj.prep_start_date.value = "";
	frmObj.prep_end_time.value = "";
	frmObj.prep_end_date.value = "";
	}
	//End ML-MMOH-CRF-1936

	frmObj.surgery_start_time.value = "";
	frmObj.surgery_start_date.value = "";
	frmObj.surgery_end_time.value = "";
	frmObj.surgery_end_date.value = "";
	
	frmObj.recId.value="";
	frmObj.mode.value='I';
	frmObj.speciality.disabled=false;
}

function assignRecId(){
	var rows = parent.parent.parent.ObjectCollect.time_rows;
	parent.parent.parent.ObjectCollect.time_len=rows.length;
	
}

</script>
</head>

<body onLoad="assignSpeciality(); surNurMandatory();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="NursingTimeRecordForm" id="NursingTimeRecordForm">
<input type='hidden' name='params' id='params' value="<%=request.getQueryString()%>" > 
<% 

	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
	String disable_flag="",sysdate1="";
	String nursing_doc_comp_yn = CommonBean.checkForNull(request.getParameter("nursing_doc_comp_yn")); 
	String surgeon_doc_comp_yn = CommonBean.checkForNull(request.getParameter("surgeon_doc_comp_yn")); 
	String check_into_or_time = CommonBean.checkForNull(request.getParameter("check_into_or_time")); 
	String function_id = CommonBean.checkForNull(request.getParameter("function_id")); 
	String tab = CommonBean.checkForNull(request.getParameter("tab")); 

	//Added by Arthi for ML-MMOH-CRF-1936
	String anes_proc_start_end_time_yn = "";
	String anes_start_end_time_yn = "";
	String surgery_start_end_time_yn = "";
	String preparation_start_end_time_yn = "";
	String record_surgeon_notes_yn = "";
	String record_nursing_notes_yn = "";
	Boolean isTimeDtlsSurNurAppl = false;
	//End ML-MMOH-CRF-1936
	
	if(tab.equals("record_nursing")){
		disable_flag = (nursing_doc_comp_yn.equals("Y") )?"disabled":"";
	}else if(tab.equals("record_surgeon") ) {
		disable_flag = (surgeon_doc_comp_yn.equals("Y") )?"disabled":"";
	}

    	String SQL1 = "SELECT A.SPECIALITY_CODE SPL_CODE,DECODE(A.SPECIALITY_CODE, '*ALL','All Specialities',B.SHORT_DESC) SPL_DESC,TO_CHAR(A.PREPARATION_TIME,'DD/MM/YYYY HH24:MI') PREP_TIME,TO_CHAR(A.ANEST_PROC_START_TIME,'DD/MM/YYYY HH24:MI') PROC_START_TIME,TO_CHAR(A.ANEST_PROC_END_TIME,'DD/MM/YYYY HH24:MI') PROC_END_TIME,TO_CHAR(A.ANEST_START_TIME,'DD/MM/YYYY HH24:MI') ANST_START_TIME,TO_CHAR(A.ANEST_END_TIME,'DD/MM/YYYY HH24:MI') ANST_END_TIME,TO_CHAR(A.PREP_START_TIME,'DD/MM/YYYY HH24:MI') PRE_START_TIME,TO_CHAR(A.PREP_END_TIME,'DD/MM/YYYY HH24:MI') PRE_END_TIME,TO_CHAR(A.SURG_START_TIME,'DD/MM/YYYY HH24:MI') SUG_START_TIME,TO_CHAR(A.SURG_END_TIME,'DD/MM/YYYY HH24:MI') SUG_END_TIME,TO_CHAR(sysdate,'DD/MM/YYYY HH24:MI') sysdate1 FROM OT_POST_OPER_DTL2 A,AM_SPECIALITY B WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND A.SPECIALITY_CODE = B.SPECIALITY_CODE(+)";

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	int index=0;
	try{
		con = ConnectionManager.getConnection(request);
		
		//Added by Arthi for ML-MMOH-CRF-1936
		JSONArray SurNurMandYNJsonArr = new JSONArray();
		SurNurMandYNJsonArr = eOT.OTCommonBean.getSurNurMandatoryYN(con,facility_id);
		isTimeDtlsSurNurAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OT", "TIMEDTLS_NUR_SUR_NOTE_MAND");
%>
<input type='hidden' name='isTimeDtlsSurNurAppl' id='isTimeDtlsSurNurAppl' value="<%=isTimeDtlsSurNurAppl%>"><!-- Added Against ML-MMOH-CRF-1936 -->
<%
		for(int i = 0 ; i < SurNurMandYNJsonArr.size() ; i++) 
		{
			JSONObject json	= (JSONObject)SurNurMandYNJsonArr.get(i);
			anes_proc_start_end_time_yn = (String) json.get("anes_proc_start_end_time_yn");
			anes_start_end_time_yn = (String) json.get("anes_start_end_time_yn");
			surgery_start_end_time_yn = (String) json.get("surgery_start_end_time_yn");
			preparation_start_end_time_yn = (String) json.get("preparation_start_end_time_yn");
			record_surgeon_notes_yn = (String) json.get("record_surgeon_notes_yn");
			record_nursing_notes_yn = (String) json.get("record_nursing_notes_yn");
		}
		//End ML-MMOH-CRF-1936

		pstmt = con.prepareStatement(SQL1);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();	
		while(rst.next()){
			 ++index;
		sysdate1=rst.getString("sysdate1");
		if(sysdate1 ==null) sysdate1="";
		//out.println("<script>loadDBRows('"+CommonBean.checkForNull(rst.getString("SPL_CODE"))+"','"+CommonBean.checkForNull(rst.getString("SPL_DESC"))+"','"+CommonBean.checkForNull(rst.getString("PREP_TIME"))+"','"+CommonBean.checkForNull(rst.getString("PROC_START_TIME"))+"','"+CommonBean.checkForNull(rst.getString("PROC_END_TIME"))+"','"+CommonBean.checkForNull(rst.getString("ANST_START_TIME"))+"','"+CommonBean.checkForNull(rst.getString("ANST_END_TIME"))+"','"+CommonBean.checkForNull(rst.getString("SUG_START_TIME"))+"','"+CommonBean.checkForNull(rst.getString("SUG_END_TIME"))+"','"+index+"','L'); </script>");	

		//if(isTimeDtlsSurNurAppl){
			
		//out.println("<script>loadDBRows('"+CommonBean.checkForNull(rst.getString("SPL_CODE"))+"','"+CommonBean.checkForNull(rst.getString("SPL_DESC"))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("PREP_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("PROC_START_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("PROC_END_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("ANST_START_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("ANST_END_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("PRE_START_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("PRE_END_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("SUG_START_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("SUG_END_TIME"),"DMYHM","en",locale))+"','"+index+"','L'); </script>");
		//}else{
			
			//Added By Gaurav added for ML-BRU-SCF-2237
			out.println("<script>loadDBRows('"+CommonBean.checkForNull(rst.getString("SPL_CODE"))+"','"+CommonBean.checkForNull(rst.getString("SPL_DESC"))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("PREP_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("PROC_START_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("PROC_END_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("ANST_START_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("ANST_END_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("PRE_START_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("PRE_END_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("SUG_START_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("SUG_END_TIME"),"DMYHM","en",locale))+"','"+index+"','L'); </script>");
			
			//out.println("<script>loadDBRows('"+CommonBean.checkForNull(rst.getString("SPL_CODE"))+"','"+CommonBean.checkForNull(rst.getString("SPL_DESC"))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("PREP_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("PROC_START_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("PROC_END_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("ANST_START_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("ANST_END_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("SUG_START_TIME"),"DMYHM","en",locale))+"','"+CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rst.getString("SUG_END_TIME"),"DMYHM","en",locale))+"','"+index+"','L'); </script>");
			//com.ehis.util.DateUtils.convertDate(,"DMYHM","en",locale);
		//}
			
		}
		out.println("<script>assignRecId();</script>"); 
		out.println("<script>refresh()</script>");
	
	}catch(Exception e){
		System.err.println("NursingTimeRecord.jsp"+e.getMessage());
	}
	finally{
		try{
			if(rst!=null) rst.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}

%>
<table border='0' cellpadding=3  cellspacing='0' width='100%' align='center'>
<tr> 
	<td class="label" width='25%'>
		<fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
	 <td class="fields" width='25%'>
		  <select name="speciality" id="speciality" <%=disable_flag%> > </select>
	  </td>
	<td class="label" width='25%'>
			<fmt:message key="eOT.PreparationTime.Label" bundle="${ot_labels}"/> </td>
	  <td class="fields" width='25%'>
		 <input type='text' name='preparation_time' id='preparation_time' size='2' maxlength='3' onblur="ChkNumber(this);" <%=disable_flag%> > (in mins)
	 </td>
</tr>
<tr>
	 <td class="label" width='25%'> 
			<fmt:message key="eOT.AnaesthesiaProcedureStartTime.Label" bundle="${ot_labels}"/></td >
	<td class="fields" width='25%'>
		<input type='text' name='procedure_start_date' id='procedure_start_date' size='8' value="" readonly>
		 <img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('procedure_start_date');" <%=disable_flag%> >
		<input type='text' name='procedure_start_time' id='procedure_start_time' size='2' maxlength='5' onkeypress ='return checkForSpecCharsforIDTime(event);' onBlur="if(this.value!='')checkTimeFormat(procedure_start_date,this);" <%=disable_flag%> >
		<%if(isTimeDtlsSurNurAppl){%>
		<img src='../../eCommon/images/mandatory.gif' style='visibility:hidden' id='anesProcmandImgStart'></img>
		<%}%>
	</td>
	<td class="label" width='25%'>
			<fmt:message key="eOT.AnaesthesiaProcedureEndTime.Label" bundle="${ot_labels}"/> </td>
	 <td class="fields" width='25%'>
		  <input type='text' name='procedure_end_date' id='procedure_end_date' size='8' value="" readonly>
		  <img src='../../eCommon/images/CommonCalendar.gif' onClick="return validateStartDate(procedure_end_date);" <%=disable_flag%> >
		  <input type='text' name='procedure_end_time' id='procedure_end_time' size='2' maxlength='5' onkeypress ='return checkForSpecCharsforIDTime(event);'  onBlur="if(this.value!='')checkTimeFormat(procedure_end_date,this);chkAnaesProcFromToTime()" <%=disable_flag%>  >
		  <%if(isTimeDtlsSurNurAppl){%>
		  <img src='../../eCommon/images/mandatory.gif' style='visibility:hidden' id='anesProcmandImgEnd'></img>
		  <%}%>
	</td>
</tr>
<tr>
	 <td class="label" width='25%'>
			<fmt:message key="eOT.AnaesthesiaStartTime.Label" bundle="${ot_labels}"/> </td>
     <td class="fields" width='25%'>
		<input type='text' name='anaesthesia_start_date' id='anaesthesia_start_date' size='8' readonly>
		<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('anaesthesia_start_date');" <%=disable_flag%> >
		<input type='text' name='anaesthesia_start_time' id='anaesthesia_start_time' size='2' maxlength='5' onkeypress ='return checkForSpecCharsforIDTime(event);' onBlur="if(this.value!=''){checkTimeFormat(anaesthesia_start_date,this);}" <%=disable_flag%> > 
		<%if(isTimeDtlsSurNurAppl){%>
		<img src='../../eCommon/images/mandatory.gif' style='visibility:hidden' id='anesmandImgStart'></img>
		<%}%>
	</td>
	<td class="label" width='25%'>
			<fmt:message key="eOT.AnaesthesiaEndTime.Label" bundle="${ot_labels}"/> </td>
	 <td class="fields" width='25%'>
		  <input type='text' name='anaesthesia_end_date' id='anaesthesia_end_date' size='8' readonly>
		  <img src='../../eCommon/images/CommonCalendar.gif' onClick="return validateStartDate(anaesthesia_end_date);" <%=disable_flag%> >
		  <input type='text' name='anaesthesia_end_time' id='anaesthesia_end_time' size='2' maxlength='5' onkeypress ='return checkForSpecCharsforIDTime(event);' onBlur="if(this.value!=''){checkTimeFormat(anaesthesia_end_date,this);chkAnaesFromToTime();}" <%=disable_flag%> >
		  <%if(isTimeDtlsSurNurAppl){%>
		  <img src='../../eCommon/images/mandatory.gif' style='visibility:hidden' id='anesmandImgEnd'></img>
		  <%}%>
	 </td>
</tr>

<!-- Added by Arthi for ML-MMOH-CRF-1936 -->
<%if(isTimeDtlsSurNurAppl){%>
<tr>
	 <td class="label" width='25%'>
			<fmt:message key="eOT.Preparation.Label" bundle="${ot_labels}"/>&nbsp;<fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></td>
	<td class="fields" width='25%'>
			<input type='text' name='prep_start_date' id='prep_start_date' size='8' readonly> 
			<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('prep_start_date');" <%=disable_flag%> >
			<input type='text' name='prep_start_time' id='prep_start_time' size='2' maxlength='5' onkeypress ='return checkForSpecCharsforIDTime(event);' onBlur="if(this.value!='')checkTimeFormat(prep_start_date,this);" <%=disable_flag%> > 
			<img src='../../eCommon/images/mandatory.gif' style='visibility:hidden' id='prepmandImgStart'></img>
	</td>
	<td class="label" width='25%'>
			<fmt:message key="eOT.Preparation.Label" bundle="${ot_labels}"/>&nbsp;<fmt:message key="Common.EndTime.label" bundle="${common_labels}"/></td>
	 <td class="fields" width='25%'>
		  <input type='text' name='prep_end_date' id='prep_end_date' size='8' readonly> 
		  <img src='../../eCommon/images/CommonCalendar.gif' onClick="return validateStartDate(prep_end_date);" <%=disable_flag%> >
		  <input type='text' name='prep_end_time' id='prep_end_time' size='2' maxlength='5'  onBlur="if(this.value!='')checkTimeFormat(prep_end_date,this);chkPrepFromToTime();" <%=disable_flag%> > 
		  <img src='../../eCommon/images/mandatory.gif' style='visibility:hidden' id='prepmandImgEnd'></img>
	 </td>
</tr>
<%}%>
<!-- End ML-MMOH-CRF-1936 -->

<tr>
	<%if(isTimeDtlsSurNurAppl){%>
	<td class="label" width='25%'>
			<fmt:message key="Common.Surgery.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></td>
	<%}else{%>
	 <td class="label" width='25%'>
			<fmt:message key="eOT.ProcedureStartTime.Label" bundle="${ot_labels}"/> </td>
	<%}%>
	<td class="fields" width='25%'>
			<input type='text' name='surgery_start_date' id='surgery_start_date' size='8' readonly> 
			<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('surgery_start_date');" <%=disable_flag%> >
			<input type='text' name='surgery_start_time' id='surgery_start_time' size='2' maxlength='5' onkeypress ='return checkForSpecCharsforIDTime(event);' onBlur="if(this.value!='')checkTimeFormat(surgery_start_date,this);" <%=disable_flag%> >
			<%if(isTimeDtlsSurNurAppl){%>
			<img src='../../eCommon/images/mandatory.gif' style='visibility:hidden' id='surgmandImgStart'></img>
			<%}%>
	</td>
	<%if(isTimeDtlsSurNurAppl){%>
	<td class="label" width='25%'>
			<fmt:message key="Common.Surgery.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.EndTime.label" bundle="${common_labels}"/></td>
	<%}else{%>
	<td class="label" width='25%'>
			<fmt:message key="eOT.ProcedureEndTime.Label" bundle="${ot_labels}"/></td>
	<%}%>
	 <td class="fields" width='25%'>
		  <input type='text' name='surgery_end_date' id='surgery_end_date' size='8' readonly> 
		  <img src='../../eCommon/images/CommonCalendar.gif' onClick="return validateStartDate(surgery_end_date);" <%=disable_flag%> >
		  <input type='text' name='surgery_end_time' id='surgery_end_time' size='2' maxlength='5'  onBlur="if(this.value!='')checkTimeFormat(surgery_end_date,this);chkProcFromToTime();" <%=disable_flag%> >
		  <%if(isTimeDtlsSurNurAppl){%>
		  <img src='../../eCommon/images/mandatory.gif' style='visibility:hidden' id='surgmandImgEnd'></img>
		  <%}%>
	 </td>
</tr>
<tr>
		 <td class="fields" width='25%'></td>
		 <td class="fields" width='25%'></td>
		 <td class="fields" width='25%'></td>
		<td  width='25%' class="button">
		<input type='button' name='record' id='record' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='addRow();disableDocLevel();' <%=disable_flag%> >
		<input type='button' name='cancel' id='cancel' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow();' <%=disable_flag%> >
		</td>
		 
</tr>
</table>
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
<input type='hidden' name='recId' id='recId' value="" > 
<input type='hidden' name='mode' id='mode' value="I" > 
<input type='hidden' name='tab_id' id='tab_id' value='<%=CommonBean.checkForNull(request.getParameter("tab_id"))%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='check_into_or_time' id='check_into_or_time' value="<%=check_into_or_time%>">
<input type='hidden' name='sysdate1' id='sysdate1' value="<%=sysdate1%>">
<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">
<input type='hidden' name='oper_num' id='oper_num' value="<%=oper_num%>">
<input type='hidden' name='tab' id='tab' value="<%=tab%>">

<!-- Added by Arthi for ML-MMOH-CRF-1936 -->
<input type='hidden' name='anes_proc_start_end_time_yn' id='anes_proc_start_end_time_yn' value="<%=anes_proc_start_end_time_yn%>">
<input type='hidden' name='anes_start_end_time_yn' id='anes_start_end_time_yn' value="<%=anes_start_end_time_yn%>">
<input type='hidden' name='surgery_start_end_time_yn' id='surgery_start_end_time_yn' value="<%=surgery_start_end_time_yn%>">
<input type='hidden' name='preparation_start_end_time_yn' id='preparation_start_end_time_yn' value="<%=preparation_start_end_time_yn%>">
<input type='hidden' name='record_surgeon_notes_yn' id='record_surgeon_notes_yn' value="<%=record_surgeon_notes_yn%>">
<input type='hidden' name='record_nursing_notes_yn' id='record_nursing_notes_yn' value="<%=record_nursing_notes_yn%>">
<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>">
<!-- End ML-MMOH-CRF-1936 -->

</form>
</body>
</html>


