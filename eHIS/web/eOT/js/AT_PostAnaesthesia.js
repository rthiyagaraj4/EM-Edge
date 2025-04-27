/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function apply(){
	var frmObj = parent.ObjectCollect;
	var formObj = parent.AnaesthesiaDetailsFrame.AnaesthesiaParticularsForm;
	var params = frmObj.PAObjectCollectForm.params;
	var params1 = frmObj.PAObjectCollectForm.params.value;
	var PostStatusformObj = window.parent.parent.frames[7].document.forms[0];
	var chk_box = PostStatusformObj.checkAnaes;
	var accession_num=parent.parent.AnaesthesiaHdrFrame.RecordAnesthesiaHdrForm.accession_num.value;
	var chk_box = parent.parent.AnaesthesiaHdrFrame.RecordAnesthesiaHdrForm.checkAnaes;
		params+="&accession_num="+accession_num;
		var locale=formObj.locale.value;
		if(formObj.rec_start_date.value!="")
		var anaes_strt_dt_time = formObj.rec_start_date.value+" "+formObj.rec_start_time.value;
		var chk_in_to_or_dt_time=checkCheckInToORTime();
		var retVal_chk_In=true;

		  if(chk_in_to_or_dt_time!="")
		    retVal_chk_In = compareDates(chk_in_to_or_dt_time,anaes_strt_dt_time,locale,'DMYHM');
			if(retVal_chk_In==false){
			var msg_1 = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
			var msgArr = msg_1.split("#");
			var checkin_time = getLabel("eOT.CheckInTime.Label","OT");
			var chkindatetime =getLabel("eOT.RecoveryStartTime.Label","OT");
			var err_msg=msgArr[0]+ checkin_time+"( "+chk_in_to_or_dt_time+")"+msgArr[1]+ chkindatetime+msgArr[2];
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+err_msg;
			return;
		}
		var formobj1=parent.frames[2].document.forms[0];
		if (formobj1.weight.value=='' && formobj1.height.value!='')
	{
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var Weight  = getLabel("Common.weight.label","Common");
		err_txt=msgArray[0]+Weight +msgArray[1];
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+err_txt;
		return;
	}
	if(formobj1.weight.value!='' && formobj1.height.value=='')
	{
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var Height  = getLabel("Common.height.label","Common");
		err_txt=msgArray[0]+Height +msgArray[1];
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+err_txt;
		return;
	}

	if( chkEmptyAnaesthesiaParticulars() && validateEndDate() ){
		if(PostStatusformObj.checkAnaes.checked==false){
			//if(window.confirm("Documentation not completed, Do you want to continue?")==false){
				if(window.confirm(getMessage("APP-OT0078","OT"))==false){
				messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
				return;
			}
		}
		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		var xmlStr="<root>";
		var action = '../../servlet/eOT.AT_PostAnesthesiaServlet?'+params;
		xmlStr+=frmObj.createXMLForHdr();
		//xmlStr+=frmObj.createXMLForComplications();
		xmlStr+=frmObj.createXMLForPersonnelDetails();
		xmlStr+="</root>";
		//alert(xmlStr);
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",action,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		if(retVal!=null && retVal!=""){
			if(retVal == "RECORD_INSERTED"){
			  retVal = recordUntowardEvtsDtls();
			  alert(getMessage("RECORD_INSERTED","SM"));
		      window.close();
		   }else{
			  alert(retVal);
			  window.close();
			}
		}
			
	}	
}

function chkEmptyAnaesthesiaParticulars(){
	//var formObj = document.ImplantsRecordForm;
var formObj = parent.AnaesthesiaDetailsFrame.AnaesthesiaParticularsForm;

	var fields = new  Array(formObj.finish_date,formObj.finish_time,formObj.rec_start_date,formObj.rec_start_time,formObj.rec_finish_date,formObj.rec_finish_time);

	var FinishDate =getLabel("eOT.FinishDate.Label","OT");
	var	FinishTime =getLabel("eOT.FinishTime.Label","OT");
	var	Recoverystartdate = getLabel("eOT.RecoveryStartDate.Label","OT");
	var	Recoverystarttime = getLabel("eOT.RecoveryStartTime.Label","OT");
	var	RecoveryFinishdate= getLabel("eOT.RecoveryEndDate.Label","OT");	
	var	RecoveryFinishtime = getLabel("eOT.RecoveryEndTime.Label","OT");

	var names = new Array(FinishDate,FinishTime,Recoverystartdate,Recoverystarttime,RecoveryFinishdate,RecoveryFinishtime);
	var messageFrame = parent.messageFrame;
	if(checkFields(fields,names,messageFrame))
		return true;
	
}

function isRowCommit(){
	var frmObj = parent.ObjectCollect;
	var compl_rows = frmObj.compl_rows;
	var submit_flag = "F";
	
	if(isModified(compl_rows)){
		submit_flag = "T";
	}
			
	if(submit_flag.indexOf("T")>=0)
		return true;
	else
		return false;
 }

function isModified(rows){
	var modified_flag=false;
	for(var i=0;i<rows.length;i++){
		if(rows[i]!=null){
			if(rows[i].db_mode!='L'){
				modified_flag=true;
			    break;
			}
		} 
		continue
	}
	return modified_flag;
}

function reset(){
	//alert("Inside reset");

}


/*function searchComplication(obj,target)
{
	var code_name = obj.name;
	var desc_name = target.name;
	var tcode = obj.value;
	var tdesc = target.value;
	obj.value='';
	target.value='';
	var sql='';
	var retVal =  new String();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var tit="";				
	if(target.name == desc_name){
	tit="Search Post Anaesthesia Complications"
	//SELECT SHORT_DESC COMPLICATION_DESC, COMPLICATION_CODE FROM AT_COMPLICATIONS_MAST WHERE NVL(STATUS,'E') = 'E'
	sql="SELECT SHORT_DESC  Description, COMPLICATION_CODE Code FROM AT_COMPLICATIONS_MAST WHERE NVL(STATUS,'E') = 'E'  AND NVL(RECOVERY_YN,'N') = 'Y' and upper(SHORT_DESC) like upper(?) and upper(COMPLICATION_CODE) like upper(?) order by 1";
	}
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_DESC_LINK;
	argumentArray[7] = DESC_CODE;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		if(target.name == desc_name){
			obj.value = arr[0];
		}
	}else{
		target.value=tdesc;
		obj.value=tcode;
	}
}*/

function checkLimit(field, limit){
  if (field.value.length > limit){
			//var msg = getMessage("REMARKS_CANNOT_EXCEED");
		   var msg = getMessage("MAX_LENGTH_DATA","OT");
		   var msgArray = msg.split("#");
		   alert(msgArray[0]+""+msgArray[1]+limit+msgArray[2]);
		   // Truncate at the limit
		   var revertField = field.value.slice(0,limit-1);
		   field.value = revertField;
		   field.focus();
	  }
}

function checkTimeFormat(obj)
	{
	if(obj.value!=null && obj.value!="")
		{
		var retVal = chkTime(obj.value);
		if(retVal==false){
			alert(getMessage("VALID_TIME_SLOTS","OT"));		
			//alert(getMessage("APP-OT0037"));		
			obj.focus();
			obj.select();
		}
	}
}
function getSysDateTime(){
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	var temp_jsp="../../eOT/jsp/HoldingAreaValidation.jsp?func_mode=getSysDateTime";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	return responseText;
}


function recordUntowardEvtsDtls(){
	var xmlStr ="<root></root>";
	var temp_jsp="../../eOT/jsp/RecordUntowardDtls.jsp";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=xmlHttp.responseText ;
	return responseText;
}

function validateEndDate(){
	var formObj = parent.AnaesthesiaDetailsFrame.AnaesthesiaParticularsForm;
	var locale = formObj.locale.value;
	//var validation_flag=false;
	var validation_flag=true;
	var start_date_time = formObj.start_date.value;
	var end_date_time = formObj.finish_date.value+" "+formObj.finish_time.value;
	var rec_start_date_time = formObj.rec_start_date.value+" "+formObj.rec_start_time.value;
	var rec_finish_date_time = formObj.rec_finish_date.value+" "+formObj.rec_finish_time.value;
	var msg = "";
	var errors ="";
	var database_system_date_time = getSysDateTime();
	database_system_date_time = trimString(database_system_date_time);


	//comparsion of Sysdate and End Date
	//var retVal = compareDates(end_date_time,database_system_date_time,locale,"DMYHM");	//small big
	var retVal = compareDatesLocal(end_date_time,database_system_date_time);	//small big
	if(retVal==false){
		//msg = "End date/Time should be < system date and time";		
		
		
		errors = "Anaesthesia Finish Date/Time should be lesser than system Date/Time"+"<BR>";
		//parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
		validation_flag=false;
	}
    
	//comparsion of EndDate and Start Date
	//var retVal1 = compareDates(start_date_time,end_date_time,locale,"DMYHM");	//small big
	var retVal1 = compareDatesLocal(start_date_time,end_date_time);	//small big
	if(retVal1==false){
	   //msg="End date/Time should be > Start date and time";
	   errors+="Anaesthesia End Date/Time should be greater than Anaesthesia Start Date/Time"+"<BR>";
	   //parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
	   validation_flag=false;
	}
	   
	//comparsion of Start Date/Time and Recovery Start Date/Time
	//var retVal2 = compareDates(start_date_time,rec_start_date_time,locale,"DMYHM");	//small big
	var retVal2 = compareDatesLocal(start_date_time,rec_start_date_time);	//small big
	if(retVal2==false){
	   //msg="Start date/Time should be > Recovery Start date and time"; 
	   //the msg is wrong... below msg corrected by bshankar
	   errors+="Recovery Start Date/Time should be greater than Anaesthesia Start Date/Time"+"<BR>";
	   //parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
	   validation_flag=false;
	}

	//comparsion of Recovery Start Date/Time and Recovery End Date/Time
	//var retVal3 = compareDates(rec_start_date_time,rec_finish_date_time,locale,"DMYHM");	//small big
	var retVal3 = compareDatesLocal(rec_start_date_time,rec_finish_date_time);	//small big
	if(retVal3==false){
		//msg="Recovery Finish date/Time should be > Recovery Start date and time";
		errors+="Recovery Finish Date/Time should be greater than Recovery Start Date/Time"+"<BR>";
		//parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
		 validation_flag=false;
	}

	//comparsion of Sysdate and End Date
	//var retVal4 = compareDates(rec_start_date_time,database_system_date_time,locale,"DMYHM");	//small big
	var retVal4 = compareDatesLocal(rec_start_date_time,database_system_date_time);	//small big
	if(retVal4==false){
		//msg = "End date/Time should be < system date and time";		
		errors+= "Recovery Start Date/Time should be lesser than system Date/Time"+"<BR>";
		//parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
		validation_flag=false;
	}
		
	//var retVal5 = compareDates(rec_finish_date_time,database_system_date_time,locale,"DMYHM");	//small big
	var retVal5 = compareDatesLocal(rec_finish_date_time,database_system_date_time);	//small big
	if(retVal5==false){
		//msg = "End date/Time should be < system date and time";		
		errors+= "Recovery Finish Date/Time should be lesser than system Date/Time"+"<BR>";
		//parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
		validation_flag=false;
	}
		if(errors.length>0)	
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
			return validation_flag;
}

function compareDatesLocal(fromdate,todate) {
    var fromarray; var toarray;
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
			

			var fromdt = new Date(fromdatearray[2],fromdatearray[1]-1,fromdatearray[0],fromtimearray[0],fromtimearray[1]);
			var todt = new Date(todatearray[2],todatearray[1]-1,todatearray[0],totimearray[0],totimearray[1]);
			//alert(new Date(2004,11,24,23,11)); is the format used above yyyy,mm,dd,hh24,mi
            if(Date.parse(todt) <= Date.parse(fromdt)) {
				return false;
            }
    }
	return true;
}

function callPractitioners(obj) {
	var pract_vals=document.forms[0].pract_type.value;
	var locale = document.forms[0].locale.value;
	var paract_array=pract_vals.split("##");
	var pract_type= paract_array[0]; 
	if(paract_array.length==1 ) {
		var msg = getMessage("CANNOT_BE_BLANK","OT");
		var msgArray = msg.split("&");
		var  PractitionerType = getLabel("Common.Role.label","Common");
		alert(msgArray[0]+PractitionerType+(msgArray[1]));
		return;
	}

	var sql="";
	var search=getLabel("Common.search.label","Common");
	if(pract_type=='OS'){
		var pract=getLabel("Common.practitioner.label","Common");
		var title=pract+" "+search;
		sql="SELECT PRACTITIONER_ID CODE, PRACTITIONER_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG_VW A WHERE A.LANGUAGE_ID = '"+locale+"' AND PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE = 'OS') AND upper(PRACTITIONER_ID ) like upper(?) AND upper(PRACTITIONER_NAME) like upper(?) order by 2 ";
	}else if(pract_type=='AS') {
		var pract=getLabel("Common.practitioner.label","Common");
		var title=pract+" "+search;
		sql="SELECT PRACTITIONER_ID CODE, PRACTITIONER_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG_VW A WHERE A.LANGUAGE_ID = '"+locale+"' AND PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE = 'AS') AND upper( PRACTITIONER_ID ) like upper(?) AND upper(PRACTITIONER_NAME) like upper(?) order by 2 ";
	}
	else if(pract_type=='MA') {
		var anaes=getLabel("Common.Anaesthetist.label","Common");
		var title=anaes+" "+search;
		sql="SELECT PRACTITIONER_ID CODE, PRACTITIONER_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG_VW A WHERE A.LANGUAGE_ID = '"+locale+"' AND PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE = 'MA') AND upper(PRACTITIONER_ID ) like upper(?) AND upper(PRACTITIONER_NAME) like upper(?) order by 2 ";
	} else if(pract_type=='AA') {
		var anaes=getLabel("Common.Anaesthetist.label","Common");
		var title=anaes+" "+search;
		sql="SELECT PRACTITIONER_ID CODE, PRACTITIONER_NAME DESCRIPTION FROM AM_PRACTITIONER_LANG_VW A WHERE A.LANGUAGE_ID = '"+locale+"' AND PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE = 'AA') AND upper(PRACTITIONER_ID) like upper(?) AND upper(PRACTITIONER_NAME) like upper(?) order by 2 ";
	}else if(pract_type=='NS') {
		var nurse=getLabel("Common.nurse.label","Common");
		var title=nurse+" "+search;
		// Modified by DhanasekarV against the issue IN024345 on 14/10/2010
		sql="SELECT PRACTITIONER_ID CODE,PRACTITIONER_NAME DESCRIPTION  FROM AM_PRACTITIONER_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'E') = 'E' AND PRACT_TYPE IN (SELECT PRACT_TYPE FROM OT_PRACT_TYPES_FOR_ROLE_TYPE WHERE ROLE_TYPE = 'NS')  AND upper(PRACTITIONER_ID) like upper(?) AND upper(PRACTITIONER_NAME) like upper(?) order by 2 ";
	}

	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = obj.value;
	argumentArray[6] =DESC_LINK;
	argumentArray[7] = DESC_CODE;
	var returnedValues = CommonLookup(title, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		document.forms[0].practitioner_id.value = returnedValues[0];
		document.forms[0].practitioner_name.value = returnedValues[1];
		
	}else{
		document.forms[0].practitioner_id.value = "";
		document.forms[0].practitioner_name.value = "";	
	}
}

function checkNull(retVal) {
	if(retVal != null && retVal.length>0)		
		return retVal;
	else 
		return '';

}

function CheckBmiPositiveNumber(obj) 
{
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) {
	
		displyBSAandBMI();

    }
    else {
			document.forms[0].bsa.value="";
			document.forms[0].bsaDisp.value="";
			document.forms[0].bmi.value="";
			document.forms[0].status_desc.value="";
        if ( obj.value.length > 0 ) {
            //alert(getMessage("VALUE_GREATER_ZERO"));
            alert(getMessage("VALUE_SHOULD_BE_GR_ZERO","Common"));			
            obj.value="";
            obj.focus();
        }
    }
}

function displyBSAandBMI()
{
	var weight="";
	var height="";
	//weight=document.RecordAnesthesiaHdrForm.weight.value;
	//height=document.RecordAnesthesiaHdrForm.height.value;
	weight=document.forms[0].weight.value;
	height=document.forms[0].height.value;

	if( weight!="" && weight!=null && weight!="undefined" && height!="" && height!=null && height!="undefined")
	{		
		parent.parent.dummy_frame.location.href = "../../eCommon/html/blank.html";
		parent.parent.dummy_frames.location.href = "../../eCommon/html/blank.html";
		var htmlVal = "<html><head></head><body>";
		htmlVal += "<form name='frm_temp' id='frm_temp' method='post'; action='../../eOT/jsp/AT_PreAnaesHdrDynamicValue.jsp' target='dummy_frames'>";
		htmlVal += "<input type='hidden' name='weight' id='weight' value='"+weight+"'>";
		htmlVal += "<input type='hidden' name='height' id='height' value='"+height+"'>";
		htmlVal += "</form></body></html>";		parent.parent.dummy_frame.document.body.insertAdjacentHTML("afterBegin",htmlVal);
		parent.parent.dummy_frame.document.frm_temp.submit();
	}else{
	}
}

async function callRecordChart(){
	 var formObj =  parent.parent.AnaesthesiaHdrFrame.document.forms[0];
     var frmObj = parent.frames[2].document.forms[0];
	 var chart_id  = frmObj.chart_id.value;
	/*Modified By Muthukumar against Issue Number- SRR20056-SCF 7625 on 14/06/2011*/ 
	 if(chart_id==null || chart_id.length == 0 ||  chart_id ==""){
		chart_id = "null";
	 }
	 /*Modified By Muthukumar against Issue Number- SRR20056-SCF 7625 on 14/06/2011*/
	 var facility_id =  frmObj.facility_id.value;
	 var patient_id = frmObj.patient_id.value;
	 var episode_id = frmObj.episode_id.value;
	 var date_time = frmObj.rec_finish_date_time.value
	 var encounter_id = frmObj.encounter_id.value;
	 var locale=frmObj.locale.value;
	 //var url = "../../eCA/jsp/DisDataCharting.jsp?option_id=VITAL_SIGNS1&patient_id="+patient_id+"&visit_id=&episode_id="+episode_id+"&encounter_id="+encounter_id+"&location_code=&location_type=&bed_num=&room_num=&episode_type="+episode_type+"&discharge_date=&visit_adm_date=&episode_Status=&Sex="+sex+"&Age=&Dob="+dob+"&security_level=&protection_ind=&reln_req_yn=N&patient_class="+patient_class+"&PQ=Y&CA=N&relationship_id=&window_name="+window_name+"&child_window=Y&mode=R&module_id=AT&discr_msr_id="+discr_msr_id;
	 date_time=convertDate(date_time,'DMYHM','en',locale) ;	
	  //alert("date_time "+date_time)
	 var url='../../eCA/jsp/ChartRecording.jsp?patient_id='+patient_id+'&function_from=CP&p_start_date_time='+date_time+'&Chart_Id='+chart_id+'&episode_id='+encounter_id+'&encounter_id='+encounter_id+'&facility_id='+facility_id;
	// alert("url "+url)
	var retVal;
	var dialogHeight = "60" ;
	var dialogWidth  = "70" ;
	var dialogTop    = "200";
	var dialogLeft   = "100";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	var arguments    = "" ;
	retVal  = await window.showModalDialog(url, arguments, features);
	//retVal  = window.open(url);
		
}

function callPostAnesthesiaNotes(){
	
	/*var formObjHdr=parent.frames[2].document.forms[0];
	//alert(formObjHdr.name);
	var formObj = document.forms[0];
	//alert(formObj.name);
	title=getLabel("eOT.PostAnaesthesiaNotes.Label","OT");
	
	var facility_id = formObj.facility_id.value;//1
	var patient_id = formObj.patient_id.value;//2
	var episode_id = formObj.episode_id.value;//3
	var patient_class = formObjHdr.patient_class.value;//4
	var encounter_id = formObjHdr.encounter_id.value;//5
	var called_from = "POST_ANES";//6 
	var accession_num="";//formObj.anesthesia_srl_no.value;//7
	var anesthesia_accession_num=formObjHdr.accession_num.value
	var anesthesia_srl_no=formObj.anesthesia_srl_no.value;
	//alert(anesthesia_srl_no);
    var slate_user_id = formObjHdr.slate_user_id.value
	//alert(slate_user_id);
	var locn_type = "90";
	var speciality_code="";
	var url = "../../eOT/jsp/SelectNoteTypeFrames.jsp?"+ "facility_id="+facility_id+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&encounter_id="+encounter_id+"&called_from="+called_from+"&accession_num="+accession_num+"&speciality_code="+speciality_code+"&locn_type="+locn_type+"&slate_user_id="+slate_user_id+"&anesthesia_srl_no="+anesthesia_srl_no;
	//alert(url);
	var retVal;
	//var dialogHeight = "5";
   // var dialogWidth  = "20";
   // var dialogTop    = "200";
   // var dialogLeft   = "200";
	//var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" + dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no" ;
	var arguments    = "" ;
	retVal 	   = window.open(url, arguments, 'height=35,width=300,top=250,left=250,resizable=no');*/


	/*New changes done by Suma on 15 march 2010 to handle null pointer exception when CA page is opened without proxy*/

	var window_close="Y";
	var speciality_code= ""; 
	var hide_header="N";
	
	var locn_type="90";
	var called_from="POST_ANES";
	var formObjHdr=parent.frames[2].document.forms[0];
	var anesthesia_srl_no = formObjHdr.anesthesia_srl_no.value;
	var anesthesia_accession_num =  formObjHdr.accession_num.value;
	var accession_num="";
	var facility_id = formObjHdr.facility_id.value;
	var patient_id = formObjHdr.patient_id.value;
	var episode_id = formObjHdr.episode_id.value;
	var patient_class = formObjHdr.patient_class.value;
	var encounter_id = formObjHdr.encounter_id.value;
	var contr_mod_accession_num="";
	contr_mod_accession_num = facility_id+anesthesia_srl_no+"POST";	
	var tab_yn="N";
	var title= getLabel("eOT.PostAnaesthesiaDetails.Label","OT");
	title= encodeURIComponent(title);
	var function_id="SPCL_NOTE";
	var event_class="$PHY$";

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","OTCommonValidation.jsp?func_mode=Pre_anesthesia_notes&accession_num="+accession_num+"&facility_id="+facility_id+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&encounter_id="+encounter_id+"&called_from="+called_from+"&speciality_code="+speciality_code+"&locn_type="+locn_type+"&contr_mod_accession_num="+contr_mod_accession_num,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var update_mode="N";
	var arr_spec=retVal.split(",");
	var arr2_spec="";
	var note_type_value="";
	var note_type="";
	var note_type_desc="";
	note_type =arr_spec[0];
	note_type_desc=arr_spec[1];
	update_mode=arr_spec[3];
	accession_num=arr_spec[4];

	//Added performed_by_ql on 1/19/2011 by Anitha for 25928

	var action_url	=	"../../eCA/jsp/RecClinicalNotesModal.jsp?appl_task_id=OT_NOTES&title="+title+"&note_type="+note_type+"&patient_id="+patient_id+"&episode_id="+episode_id+"&patient_class="+patient_class+"&function_id="+function_id+"&event_class="+event_class+"&accession_num="+accession_num+"&window_close="+window_close+"&ot_speciality_code="+speciality_code+"&hide_header="+hide_header+"&tab_yn="+tab_yn+"&encounter_id="+encounter_id+"&facility_id="+facility_id+"&contr_mod_accession_num="+contr_mod_accession_num+"&performed_by_ql="+formObjHdr.strUser.value;

	var title1="";

	var dialogHeight= "42";
	var dialogWidth	= "85";
	dialogTop    = "55";
		 dialogLeft   = "30";
	var status = "no";
	var arguments	= "";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal  = await window.showModalDialog(action_url, title1, features);



}

function getPositionDesc(practitioner_id){
	var locale = document.forms[0].locale.value;
	//alert("Enters");
	var xmlStr ="<root><SEARCH";
	xmlStr +=" /></root>";
	var formObj = document.forms[0];
	var sql = "SELECT POSITION_DESC FROM AM_PRACTITIONER A,AM_POSITION_LANG_VW B WHERE B.LANGUAGE_ID='"+locale+"' AND PRACTITIONER_ID = '"+practitioner_id+"' AND  A.POSITION_CODE  = B.POSITION_CODE (PLUS) ";
	var params = "sql="+sql+"&flag=PERS_RECORD";
	var temp_jsp="../../servlet/eOT.CommonQueryServlet?"+params;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	responseText=localTrimString(xmlHttp.responseText);
	return responseText;
}

 function localTrimString(sInString) {
  return sInString.replace(/^\s+|\s+$/g,"");
}

function Class_Personnel()
	{
		
		 this.pract_type="";
		 this.desc_userdef="";
		 this.practitioner_id="";
		 this.practitioner_name="";
		 this.db_mode="";
		 this.position_desc="";
		 this.recId ="";
	}

	function checkForDeletedRecords(){
	    var rows=parent.parent.parent.ObjectCollect.personnel_rows;
		var formObj = document.forms[0];
		//var code1 = formObj.pract_type.value;
		var code = formObj.practitioner_id.value;
		//var code=code1+""+code2;
		for(var i=0;i<rows.length;i++){
			if(rows[i]!=null){
				if((rows[i].practitioner_id)==code && rows[i].db_mode=="D" )
				{
					rows[i].db_mode="L";
					return true
					break;
				}
			}else
				continue;
		}
		return false;	
			
	}
	
	function loadDBRows(pract_type,desc_userdef,practitioner_id,practitioner_name,recId,mode)
	{ 
		  var objrow = newRow();
		  //alert(rows.length);
		  var rows=parent.parent.parent.ObjectCollect.personnel_rows;
		  var rowLength=parent.parent.parent.ObjectCollect.personnel_len;
		  if(mode=='L' && rowLength==0)
		  {
			  objrow.pract_type = pract_type;
			  objrow.desc_userdef= desc_userdef;
			  objrow.practitioner_id = practitioner_id;
			  objrow.practitioner_name= practitioner_name;
			  objrow.db_mode="L";
			  objrow.recId=recId;
			  objrow.position_desc=getPositionDesc(practitioner_id);
			  rows.push(objrow);
		
		  }
	}
	
	function newRow()
	{
		   var objrow = new Class_Personnel();
		   objrow.recId = parent.parent.parent.ObjectCollect.personnel_rows.length+1;
		   return(objrow);
	}
	function assignRecId()
	{
		var rows = parent.parent.parent.ObjectCollect.personnel_rows;
		parent.parent.parent.ObjectCollect.personnel_len=rows.length;
	}
	function refresh()
	{
		//alert("inside refersh")
		
		var params = document.forms[0].params.value;
		//alert(params);
		parent.personal_details_frame.location.href='../../eOT/jsp/AT_PostAnaesPersonalDetails.jsp?'+params;
		
	}

	function addRow()
	{
		var objrow = newRow();
		var formObj = document.personnel_form;
		var params = formObj.params.value;
		var mode = formObj.mode.value;

		if(mode=='I'){
			 if(chkEmpty()){
			 if(alreadyExist()){
				  var obj = formObj.pract_type;
				  var rows = parent.parent.parent.ObjectCollect.personnel_rows;
				  objrow.pract_type=formObj.pract_type.value;
				  objrow.desc_userdef=formObj.pract_type.options[obj.selectedIndex].text;
				//  objrow.desc_userdef=formObj.desc_userdef.value;
				  objrow.practitioner_id=formObj.practitioner_id.value;
				  objrow.practitioner_name=formObj.practitioner_name.value;
				  objrow.position_desc=getPositionDesc(formObj.practitioner_id.value);
				  objrow.db_mode='I';
				  objrow.recId = getRecId();
				  if(checkForDeletedRecords()==false)
				  rows.push(objrow);
				  resetFields();
				 parent.personal_details_frame.location.href='../../eOT/jsp/AT_PostAnaesPersonalDetails.jsp?'+params;
				 
				  parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
		   }else { 
					var msg =getMessage("CODE_ALREADY_EXISTS","Common");
					parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		   }
		}//mandatory_check
    }//if part of mode Check Ends Here
}


function chkEmpty(){
	var formObj = document.personnel_form;
	var fields = new Array(formObj.pract_type,formObj.practitioner_name);
	var PractitionerType=getLabel("Common.practitionertype.label","Common");
	var PractitionerName=getLabel("Common.practitionername.label","Common");
	var names = new Array(PractitionerType,PractitionerName);
	var messageFrame = parent.parent.parent.messageFrame;
	if(checkFields( fields, names, messageFrame))
		return true;
}
 function alreadyExist()
 {
	var formObj = document.personnel_form;
	var codeDtl = parent.frames[1].code;
	var rows = parent.parent.parent.ObjectCollect.personnel_rows;
	//var pract_type=formObj.pract_type.value;
	var practitioner_id=formObj.practitioner_id.value;

	var codeRecord = practitioner_id;
	if(codeDtl.indexOf(codeRecord)>=0)
	   return false;
	else
	  return true;
 }

	function getRecId()
	{
		var rowLength= parent.parent.parent.ObjectCollect.personnel_len;
		var recId = rowLength+1;
		 parent.parent.parent.ObjectCollect.personnel_len =  recId;
		return recId;
	}

function resetFields()
{
	//loadDBRows(pract_type,desc_userdef,practitioner_id,practitioner_name,recId,mode)

	var frmObj = document.personnel_form;
	frmObj.mode.value='I';
	frmObj.pract_type.value='';
	frmObj.desc_userdef.value='';
	frmObj.practitioner_id.value='';
	frmObj.practitioner_name.value='';

	frmObj.practitioner_name.disabled=false;
	frmObj.pract_type.disabled=false;
	frmObj.generic_search.disabled=false;
	frmObj.select_button.disabled=false;

}

function splitString(strVal)
{

	var arr = strVal.split('::');
	var frmObj = document.forms[0];
	frmObj.pract_type.value=arr[0];
	frmObj.desc_userdef.value=arr[1];
	frmObj.practitioner_id.value=arr[2];
	frmObj.practitioner_name.value=arr[3];
	frmObj.recId.value=arr[4]
	frmObj.mode.value=arr[5];
	
	frmObj.practitioner_name.disabled=true;
	frmObj.pract_type.disabled=true;
	frmObj.generic_search.disabled=true;
	frmObj.select_button.disabled=true;
}

function removeRow(){
 var formObj = document.personnel_form;
 var mode = formObj.mode.value;
 var recId = formObj.recId.value;
 var params = formObj.params.value;
 var rows = parent.parent.parent.ObjectCollect.personnel_rows;

 if(rows.length>0&& mode=='U'){        
 for(var jj=0;jj<rows.length;jj++){
 if(rows[jj]!=null  && rows[jj].recId!=null && rows[jj].recId!="") {
	 if(rows[jj].recId==recId ){
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
   parent.parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='
  
parent.personal_details_frame.location.href='../../eOT/jsp/AT_PostAnaesPersonalDetails.jsp?'+params;
}else
   resetFields();
}

function clearPractitioner()
{
	document.forms[0].practitioner_id.value="";
	document.forms[0].practitioner_name.value="";
}

function changeTab(objStr){
	//alert(objStr);
	selectTab(objStr);
	var ResultFrame =  parent.ResultFrame;
	var MessageFrame = parent.parent.messageFrame;
	var old_objStr = "";
	if(objStr=="PersonalDetails")	
		old_objStr = "personnel_details";
	else if(objStr=="UntowardEvent")
		old_objStr = "untowards_tab";
	
		if(parent.AnaesthesiaHdrFrame!=null){
		var hdr_formObj = parent.AnaesthesiaHdrFrame.RecordAnesthesiaHdrForm;
		if(hdr_formObj!=null){
//			var accession_num=hdr_formObj.accession_num.value;
		}
	}

	

	if(objStr=="PersonalDetails"){
		var frmObj=document.forms[0];
		var params=frmObj.params.value+"&tab_id="+old_objStr;
		//alert(params);
		if(ResultFrame!=null)
			//alert(parent.ResultFrame.name);
			//parent.ResultFrame.document.location.href='../../eOT/jsp/AT_PostAnaesthesiaFrames.jsp?'+params;
			if(ResultFrame!=null)
			parent.ResultFrame.location.href='../../eOT/jsp/AT_PostAnaesthesiaFrames.jsp?'+params
		if(MessageFrame!=null)
		parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
	}else if(objStr=="UntowardEvent"){
		var frmObj=document.forms[0];
		var params=frmObj.params.value+"&tab_id="+old_objStr;
		//alert(params);
		if(ResultFrame!=null)
			parent.ResultFrame.location.href='../../eOT/jsp/UntowardEventFrames.jsp?'+params
		if(MessageFrame!=null)
			parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num=';
	}
}

/*function CodeArrest() 
{
    if((window.event.button == 2) || (window.event.button == 3) || (window.event.button == 4)) 
	{
        alert("Welcome to eHIS");
    }
}

function lockKey()
{
    if(event.keyCode == 93)
		alert(getMessage("WELCOME",'Common'));
	
}*/

function checkCheckInToORTime(){
	var formObj = parent.AnaesthesiaDetailsFrame.AnaesthesiaParticularsForm;
	var accession_num = formObj.accession_num.value;
	var facility_id=formObj.facility_id.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "func_mode=checkInToORTime&facility_id="+facility_id+"&oper_num="+accession_num;
	xmlHttp.open("GET","../../eOT/jsp/CommonValidation.jsp?"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	return retVal;

}

