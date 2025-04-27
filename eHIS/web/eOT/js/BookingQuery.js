/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function bookingQuerySearch() {
var frmObj=document.forms[0];
var sql="";
var sql1="";
var error="";
var error1="";
var locale = frmObj.locale.value;
var msg = getMessage("CANNOT_BE_BLANK",'OT');
var msgArray = msg.split("&");
//if(frmObj.room_code.value ==''|| frmObj.room_code.value==null)//Commented on 1/18/2011 by Anitha (25897)
if(frmObj.theatre.value ==''|| frmObj.theatre.value==null)
	 error = msgArray[0]+" "+getLabel('Common.Theatre.label','Common')+" "+msgArray[1]+"\n";
	var change_from_date = dateUtils(frmObj.from_date.value,locale); 
	var change_to_date = dateUtils(frmObj.to_date.value,locale); 
	if(change_from_date ==''|| change_from_date==null)
	   error+=msgArray[0]+" "+getLabel('Common.BookingDate.label','Common')+" "+msgArray[1]; 
	   if(error.length > 0){
		alert (error);
		return false;
	   }
	   if(!CompareDateFields(frmObj)){
	  	return false;
	   }
	   else{
			 var pre_oper_diag = changeUpperCase(frmObj.pre_oper_diag);
			 var date_of_birth=dateUtils(frmObj.date_of_birth.value,locale);
			//var param="facility_id="+frmObj.facility_id.value+"&from_date="+frmObj.from_date.value+"&to_date="+frmObj.to_date.value+"&room_code="+frmObj.room_code.value+"&surgeon_code="+frmObj.SURGEON_CODE.value+"&aneasthetist_code="+frmObj.Anaesthetiest1_code.value+"&patient_id="+frmObj.patientid.value+"&patient_name="+frmObj.patientName.value+"&order_by="+frmObj.orderby.value+"&status="+frmObj.status.value+"&speciality_code="+frmObj.SPECIALITY_CODE.value+"&oper_code="+frmObj.oper_code.value+"&sex="+frmObj.sex.value+"&dob="+frmObj.date_of_birth.value+"&preOperDiag="+pre_oper_diag;
	        var param="facility_id="+frmObj.facility_id.value+"&from_date="+ dateUtils(frmObj.from_date.value,locale)+"&to_date="+ dateUtils(frmObj.to_date.value,locale)+"&room_code="+frmObj.room_code.value+"&surgeon_code="+frmObj.SURGEON_CODE.value+"&aneasthetist_code="+frmObj.Anaesthetiest1_code.value+"&patient_id="+frmObj.patientid.value+"&patient_name="+frmObj.patientName.value+"&order_by="+frmObj.orderby.value+"&status="+frmObj.status.value+"&speciality_code="+frmObj.SPECIALITY_CODE.value+"&oper_code="+frmObj.oper_code.value+"&sex="+frmObj.sex.value+"&dob="+ date_of_birth+"&preOperDiag="+pre_oper_diag+"&source_type="+frmObj.source_type.value+"&source_desc="+frmObj.source_desc.value+"&source_code="+frmObj.source_code.value+"&theatre_type="+frmObj.theatre_type_code.value;

			if(frmObj.stage.value !=null && frmObj.stage.value!=''){
				var obj=  frmObj.stage;
				param=param+"&stage_code="+obj.value+"&stage_desc="+obj.options[obj.selectedIndex].text;
			}
			parent.f_query_add_mod.location.href ="../../eOT/jsp/BookingQryDtl.jsp?"+param;
	   }
}

function changeUpperCase(obj){
	  var trim_str = trimString(obj.value);
 	  return trim_str.toUpperCase();
   }

function trimString(sInString){
	  sInString = sInString.replace( /^\s+/g, "" );// strip leading
	  return sInString.replace( /\s+$/g, "" );// strip trailing
   }

function changeStatus(obj){
		var frmObj=document.forms[0];
	if(obj.value=='B'){		 
		frmObj.stage.disabled=false;
		frmObj.pre_oper_diag.disabled=false;
	}else{
		frmObj.stage.disabled=true;
		frmObj.stage.value='';
	if(obj.value!='A'){
		frmObj.pre_oper_diag.disabled=true;
		frmObj.pre_oper_diag.value="";
	}else{
			frmObj.pre_oper_diag.disabled=false;
	}

	//frmObj.pre_oper_diag.value="";
  }


}	


async function searchBookingQryOperation(obj,target){
	var tcode = obj.value;
	var tdesc = target.value;
	var retVal =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit=getLabel("Common.operation.label","Common");
	//var sql="SELECT SHORT_DESC DESCRIPTION,OPER_CODE CODE  FROM OT_OPER_MAST WHERE NVL(STATUS,'E') = 'E' AND upper(SHORT_DESC) like upper(?) AND upper(OPER_CODE) like upper(?) ";//MMS-QH-CRF-0199
	var sql="SELECT LONG_DESC DESCRIPTION,OPER_CODE CODE  FROM OT_OPER_MAST WHERE NVL(STATUS,'E') = 'E' AND upper(LONG_DESC) like upper(?) AND upper(OPER_CODE) like upper(?) ";//MMS-QH-CRF-0199
	var frmObj=document.forms[0];
	if(frmObj.SPECIALITY_CODE.value !='' && frmObj.SPECIALITY_CODE.value !=null)
		sql+=" AND SPECIALITY_CODE='"+frmObj.SPECIALITY_CODE.value+"'";
	sql+=" ORDER BY 2 ";
	argumentArray[0] =sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( tit, argumentArray );
	if(retVal != null && retVal != "" )
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}	
		obj.value = arr[0];
		target.value=arr[1];
		
	}else{
		target.value=tdesc;
		obj.value=tcode;
	}
}


function reset() {
	 if(f_query_add_mod.document.location.href.indexOf("BookingQuerSearch.jsp") != -1) {
		  return false;
	 }
	 else {
		 f_query_add_mod.document.location.reload();
	 }
}
function funResetAll(){	
		//document.forms[0].reset();
	var formObj = document.forms[0];
	parent.f_query_add_mod.document.location.href="../../eCommon/html/blank.html";
	formObj.reset();
	}

function checkDateFormat(obj)
{
	if(obj.value!=null && obj.value!="")
	{
	var retVal= checkDt(obj.value)
		if(retVal== false)
		{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			obj.select();
		}
	}
}


/*function callPatientSearch(){
	var patient_id	=	document.forms[0].patientid;
	var return_value =	"";
	return_value	=	PatientSearch();	
	var obj=document.forms[0];
	if(return_value!=null){
		obj.patientid.value	=	return_value;

	}else{
		obj.patientid.value	="";
	}
	obj.submit();	
}*/

function CompareDateFields(frmObj){
	if(frmObj.no_of_compare_date_fields!=null){
		var no_of_compare_date_fields = frmObj.no_of_compare_date_fields.value;
		var locale = frmObj.locale.value;
		for(i=1;i<=no_of_compare_date_fields;i++){
			frm_field_text = eval("frmObj.compare_date_fm_"+i).value;
			arr=frm_field_text.split("##");
			obj_text	= arr[1];

			frm_obj_name  = arr[0];
			to_obj_name = eval("frmObj.compare_date_to_"+i).value;

			fromobj = eval("frmObj."+frm_obj_name).value;
			fromobj = fromobj+" 00:00";
			toobj = eval("frmObj."+to_obj_name).value;
			toobj = toobj+ " 00:00";
			validate_flag = compareDates(fromobj,toobj,locale,'DMYHM');
			if(validate_flag ==false){
				//To Date should not be less than from date
				var msg = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
				var msgArray = msg.split("#");
				var to_date=getLabel("Common.todate.label","Common");
				var from_date =getLabel("Common.fromdate.label","Common");

				alert(msgArray[0]+from_date+(msgArray[1])+to_date+(msgArray[2]));
				return false;
			}
		}
	}
	return true;
}


async function callPatSearch(){
	var male=getLabel('Common.male.label','Common');
	var female=getLabel('Common.female.label','Common');
	var unknown=getLabel('Common.unknown.label','Common');
	var formObj = document.forms[0];
	var patient_id=formObj.patientid;
	var patient_name = formObj.patientName;
	var date_of_birth = formObj.date_of_birth;
	var sex	= formObj.sex;
	var return_value =	"";
	if(patient_id.value.length>0) {
		return_value = patient_id.value; }
	else {
		return_value = await PatientSearch();
	}
	//return_value	=	await (patient_id.value.length>0)?patient_id.value:PatientSearch();
	if(return_value==null)  return;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var xmlStr ="<root></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","CommonValidation.jsp?func_mode=patient_search&patient_id="+return_value,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText); 
	if(retVal=="INVALID_PATIENT"){
			alert(getMessage("INVALID_PATIENT","MP")); 
			patient_id.value="";
			patient_name.value="";
			date_of_birth.value="";
			sex.value = ""; 
			patient_id.focus();
			return
	}
	
	if(retVal!="" ){
			var retVal_arr = retVal.split("##");
			patient_id.value		=return_value
			patient_name.value		= retVal_arr[0];
			date_of_birth.value 	= retVal_arr[1];
			if(retVal_arr[2]=="MALE")
				formObj.sex.value="M" ;
			else if(retVal_arr[2]=="FEMALE")
				formObj.sex.value="F";
			else
				formObj.sex.value="U";
	}
}

function localTrimString(sInString) {
   return sInString.replace(/^\s+|\s+$/g,"");
}

function clearDesc(){
	var formObj = document.forms[0];
	var pat_id=formObj.patientid.value;
	if(pat_id=="" || pat_id==null || pat_id=="null" || pat_id=="undefined")
	formObj.patientName.value="";
	formObj.date_of_birth.value="";
	formObj.sex.value="";
}

function getLongNameRefSrc(){
	var formObj=document.forms[0];
	var ref_src_id=formObj.HLongRefSrcId.value;
	var strSourceDesc=formObj.source_desc.value;
	var strSrcTypeTemp=formObj.source_type.value;
	var locale=formObj.locale.value;
	var param="func_mode=ref_long_name&locale="+locale+"&ref_src_id="+ref_src_id;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("GET","../../eOT/jsp/OTCommonValidation.jsp?"+param,false);
	xmlHttp.send(xmlDoc);
	var retVal = localTrimString(xmlHttp.responseText);	
	if(retVal!="null"  && strSrcTypeTemp=="E" && strSourceDesc!=""){
		document.getElementById("more_img").style.visibility = 'visible';
	}else{
		document.getElementById("more_img").style.visibility = 'hidden';
	}
	return retVal;
}

function selectStatus()
{
	var index = 0;
	var frmObj=document.forms[0];
	var selectValue = '<%=request.getParameter("status")==null?0:request.getParameter("status")%>';
	for(var i=0; i<frmObj.status.length;i++)
	{
		if(frmObj.status.options[i].value == selectValue )
		{
			index = i;
			break;
		}
	}
	frmObj.status.selectedIndex=index;	
}

function selectOrderby()
{
	var index = 0;
	var frmObj=document.forms[0];
	var selectValue = '<%=request.getParameter("orderby")==null?0:request.getParameter("orderby")%>';
	for(var i=0; i<frmObj.orderby.length;i++)
	{
		if(frmObj.orderby.options[i].value == selectValue )
		{
			index = i;
			break;
		}
	}
	frmObj.orderby.selectedIndex=index;	
}

function selectSourceType()
{
	var index = 0;
	var frmObj=document.forms[0];
	var selectValue = '<%=request.getParameter("source_type")==null?0:request.getParameter("source_type")%>';
	for(var i=0; i<frmObj.source_type.length;i++)
	{
		if(frmObj.source_type.options[i].value == selectValue )
		{
			index = i;
			break;
		}
	}
	frmObj.source_type.selectedIndex=index;	
}

function changeDate(da){
	return retDat;
}
function checkDate(){}

function setInitialData(){
	var frmObj=document.forms[0];
	if(frmObj.sex.DB_VALUE !=''&& frmObj.sex.DB_VALUE != null)
	frmObj.sex.value=frmObj.sex.DB_VALUE;
}

function enableMoreIcon(){
	var formObj=document.forms[0];
	var source_type=formObj.source_type.value;
		if(source_type=="E"){
		document.getElementById("more_img").style.visibility='visible';	
	}else if(source_type=="W"){
		document.getElementById("more_img").style.visibility='hidden';	
	}else if(source_type=="C") {
		document.getElementById("more_img").style.visibility='hidden';	
	}else if(source_type=="") {
		document.getElementById("more_img").style.visibility='hidden';	
	}
}

function clearSource(){ 
	var formObj=document.forms[0];
	formObj.source_code.value="";
    formObj.source_desc.value="";
	var Source_code=formObj.source_desc.value;
	if(Source_code==""){
		document.getElementById("more_img").style.visibility = 'hidden';
	} 
}

async function searchsourcetype(source_type){
	var formObj=document.forms[0];
	var locale=formObj.locale.value;
	var title="";
	if(formObj.source_type.value=='W'){
		title=getLabel("Common.nursingUnit.label","common");
		sql="SELECT LONG_DESC DESCRIPTION, NURSING_UNIT_CODE CODE FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+formObj.facility_id.value+"' AND NVL(EFF_STATUS,'D') = 'E' AND upper(LONG_DESC) like upper(?) AND upper(NURSING_UNIT_CODE) like upper(?)  order by 1" ;
	}else if(formObj.source_type.value=='C'){
		title = getLabel("Common.clinic.label","common");
		sql="SELECT LONG_DESC DESCRIPTION, CLINIC_CODE CODE FROM  OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = '"+formObj.facility_id.value+"' AND NVL(EFF_STATUS,'D') = 'E' AND upper(LONG_DESC) like upper(?) AND upper(CLINIC_CODE) like upper(?)  order by 1" ;
	}else if(formObj.source_type.value=='E'){
		title= getLabel("Common.referral.label","common");
		sql="SELECT LONG_DESC  DESCRIPTION, REFERRAL_CODE  CODE FROM AM_REFERRAL_LANG_VW  WHERE LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'D') = 'E' AND upper(LONG_DESC) like upper(?) AND upper(REFERRAL_CODE) like upper(?)  order by 1" ;
	}else{
		 var msg = getMessage("CANNOT_BE_BLANK","OT");
		 var msgArray = msg.split("&");
		 alert(msgArray[0]+" "+getLabel("Common.SourceType.label","Common")+" "+msgArray[1]);
		 return false;
	}
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = formObj.source_desc.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	returnedValues = await CommonLookup(title, argumentArray );
	if( (returnedValues != null) && (returnedValues != "") )  {
		//obj.value = returnedValues[1];
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		formObj.source_code.value=arr[0];
		formObj.source_desc.value=arr[1];
		formObj.HLongRefSrcId.value=arr[0];
	}else{
		formObj.HLongRefSrcId.value="";
		formObj.source_desc.value="";
		formObj.source_code.value="";
	}
}



function searchsourcetypeReferal(obj){
	var formObj=document.forms[0];
	var column_sizes = escape("60%,20%,10%");        
	var locale = formObj.locale.value;
	var surg_type_desc=obj.value
	var tit = getLabel('Common.code.label','Common')+','+getLabel('Common.description.label','Common')+','+getLabel('Common.longname.label','Common'); 
	var column_descriptions = encodeURIComponent(tit); 
	var sql=escape("SELECT REFERRAL_CODE CODE, LONG_DESC DESCRIPTION, LONG_NAME LONG_NAMES FROM AM_REFERRAL_LANG_VW  WHERE LANGUAGE_ID ='"+locale+"' AND NVL(EFF_STATUS,'D') = 'E'");
	var title=getLabel("Common.referral.label","Common");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&search_criteria="+surg_type_desc;
	retVal=callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");	
		formObj.HLongRefSrcId.value=arr[0];
		formObj.source_code.value=arr[0];
		formObj.source_desc.value=arr[1];
		if(arr[2]==""){
			document.getElementById("more_img").style.visibility = 'hidden';
		}else{
			document.getElementById("more_img").style.visibility = 'visible';
		}
	}else{
		formObj.HLongRefSrcId.value="";
		formObj.source_code.value="";
		formObj.source_desc.value="";
	}
}


function searchSourceTypeSelect(obj){
	var formObj=document.forms[0];
	var patient_class=formObj.source_type.value;
	if(patient_class=="E"){
		searchsourcetypeReferal(obj);
	}else{
		searchsourcetype(obj);	
	}
}

function callchangeMoreIcon(){
	var formObj=document.forms[0];
	var Source_code=formObj.source_desc.value;
	formObj.source_code.value='';
	formObj.HLongRefSrcId.value='';
	if(Source_code==""){
		document.getElementById("more_img").style.visibility = 'hidden';
	} 
}

function searchsourcetypeReferal(obj){
	var formObj=document.forms[0];
	var column_sizes = escape("60%,20%,10%");        
	var locale = formObj.locale.value;
	var surg_type_desc=obj.value
	var tit = getLabel('Common.code.label','Common')+','+getLabel('Common.description.label','Common')+','+getLabel('Common.longname.label','Common'); 
	var column_descriptions = encodeURIComponent(tit); 
	var sql=escape("SELECT REFERRAL_CODE CODE, LONG_DESC DESCRIPTION, LONG_NAME LONG_NAMES FROM AM_REFERRAL_LANG_VW  WHERE LANGUAGE_ID ='"+locale+"' AND NVL(EFF_STATUS,'D') = 'E'");
	var title=getLabel("Common.referral.label","Common");
	title=encodeURIComponent(title);
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&search_criteria="+surg_type_desc;
	retVal=callDialog(param);
	var obj=document.forms[0];
	retVal=checkNull(retVal);
	var arr=new Array();
	if(retVal!=''){
		arr=retVal.split("::");	
		formObj.HLongRefSrcId.value=arr[0];
		formObj.source_code.value=arr[0];
		formObj.source_desc.value=arr[1];
		if(arr[2]==""){
			document.getElementById("more_img").style.visibility = 'hidden';
		}else{
			document.getElementById("more_img").style.visibility = 'visible';
		}
	}else{
		formObj.HLongRefSrcId.value="";
		formObj.source_code.value="";
		formObj.source_desc.value="";
	}
}


function searchSourceTypeSelect(obj){
	var formObj=document.forms[0];
	var patient_class=formObj.source_type.value;
	if(patient_class=="E"){
		searchsourcetypeReferal(obj);
	}else{
		searchsourcetype(obj);	
	}
}

function callchangeMoreIcon(){
	var formObj=document.forms[0];
	var Source_code=formObj.source_desc.value;
	formObj.source_code.value='';
	formObj.HLongRefSrcId.value='';
	if(Source_code==""){
		document.getElementById("more_img").style.visibility = 'hidden';
	} 
}
