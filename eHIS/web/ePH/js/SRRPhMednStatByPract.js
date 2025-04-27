 //saved on 03/11/2005
function run() {
//Modified  on date 14-04-2009 for Medication Order Statistics By Dispense Location  

	var frmObject = f_query_add_mod.document.formPhMednStatByPractCriteria;
	var frmObjectOfDispLocnCriteria = f_query_add_mod.document.formPhMednStatByDispLocnCriteria;
	//alert(frmObjectOfDispLocnCriteria);
   if(frmObjectOfDispLocnCriteria != null || frmObjectOfDispLocnCriteria != undefined){
    if(f_query_add_mod.document.formPhMednStatByDispLocnCriteria) {
		var fields= new Array (frmObjectOfDispLocnCriteria.P_DATE_FROM,frmObjectOfDispLocnCriteria.P_DATE_TO);
		var names= new Array (getLabel("Common.periodfrom.label","Common"),getLabel("Common.periodto.label","Common"));
		var sysdate=frmObjectOfDispLocnCriteria.systemdate.value;		
		if(checkFields(fields,names,messageFrame) ) {
			//Convert Date to English
			var flag=checkSysDate(frmObjectOfDispLocnCriteria.P_DATE_FROM,frmObjectOfDispLocnCriteria.P_DATE_TO,sysdate);
			if(flag){
				var locale=frmObjectOfDispLocnCriteria.language_id.value;
				frmObjectOfDispLocnCriteria.dt_from.value=convertDate(frmObjectOfDispLocnCriteria.P_DATE_FROM.value,'DMY',locale,"en");
				frmObjectOfDispLocnCriteria.dt_to.value=convertDate(frmObjectOfDispLocnCriteria.P_DATE_TO.value,'DMY',locale,"en");
				f_query_add_mod.document.formPhMednStatByDispLocnCriteria.submit();
			}
		 }
	 }
   }
	if(frmObject != null || frmObject != undefined){//End of Modification on date for Medication Order Statistics By Dispense Location 
	var temp_qry_1=f_query_add_mod.document.getElementById("sql_ph_medn_stat_pract_select1").value+"'"+frmObject.language_id.value+"'";
	f_query_add_mod.document.getElementById("sql_ph_medn_stat_pract_select1").value="";
	if(f_query_add_mod.document.formPhMednStatByPractCriteria) {
		var fields= new Array (frmObject.p_select_by,frmObject.dt_from,frmObject.dt_to,frmObject.p_group_by,frmObject.p_report_by);
		var names= new Array (getLabel("Common.ReportBy.label","Common"),getLabel("Common.DateFrom.label","Common"),getLabel("Common.todate.label","Common"), getLabel("Common.groupby.label","Common"),getLabel("Common.reporttype.label","Common"));
		
				
		if(checkFields(fields,names,messageFrame) ) {
			if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formPhMednStatByPractCriteria.dt_from, f_query_add_mod.document.formPhMednStatByPractCriteria.dt_to, messageFrame ) ) {
				if(f_query_add_mod.CheckString(getLabel("Common.practitionerid.label","Common"), 
					f_query_add_mod.document.formPhMednStatByPractCriteria.pract_id, f_query_add_mod.document.formPhMednStatByPractCriteria.tpract_id, messageFrame) ) {
						f_query_add_mod.document.formPhMednStatByPractCriteria.submit();
				}
				
			}
		}
	}
	f_query_add_mod.document.getElementById("sql_ph_medn_stat_pract_select1").value = temp_qry_1;
	}
}




function reset() {
	//Modified  on date 14-04-2009 for Medication Order Statistics By Dispense Location  because The common use of js
    //f_query_add_mod.formPhMednStatByPractCriteria.reset();
     f_query_add_mod.location.reload(); //newly addded
	//messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
}

function callResultPage() {
	var result	=	false;
	frm_obj		=	f_query_add_mod.document.formPhRepDispStatByDrugCriteria.dt_from;
	to_obj		=	f_query_add_mod.document.formPhRepDispStatByDrugCriteria.dt_to;
	msg_frame		=	messageFrame;

	if(doDateCheck(frm_obj,to_obj,msg_frame)) {
		result	=	true;
	}
	else {
		result  = false;
	}
	alert(result);
	return result;
}

function searchPractitionerName(target, mode) {

	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;

	dataNameArray[0]	= "APPL_USER_ID" ;
	dataValueArray[0]	= f_query_add_mod.document.formPhMednStatByPractCriteria.p_user_name.value;
	dataTypeArray[0]	= STRING ;
	dataNameArray[1]	= "FACILITY_ID" ;
	dataValueArray[1]	= f_query_add_mod.document.formPhMednStatByPractCriteria.p_facility_code.value;
	dataTypeArray[1]	= STRING ;
	dataNameArray[2]	= "FACILITY_ID" ;
	dataValueArray[2]	= f_query_add_mod.document.formPhMednStatByPractCriteria.p_facility_code.value;
	dataTypeArray[2]	= STRING ;
	dataNameArray[3]	= "PRACT_TYPE" ;
	dataValueArray[3]	= f_query_add_mod.document.formPhMednStatByPractCriteria.p_job_title.value;
	dataTypeArray[3]	= STRING ;

	argumentArray[0] = escape(f_query_add_mod.document.getElementById("sql_ph_medn_stat_pract_select1").value)+"'"+f_query_add_mod.document.formPhMednStatByPractCriteria.language_id.value+"'";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "5,6";
	argumentArray[5] = target.value;

	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;

	retArray = CommonLookup( getLabel("Common.practitioner.label","Common"), argumentArray );

	if(retArray != null && retArray != "") {
			if (mode == 1){
			f_query_add_mod.document.formPhMednStatByPractCriteria.pract_id.value = retArray[0];

		}
		else if (mode == 2){
			f_query_add_mod.document.formPhMednStatByPractCriteria.tpract_id.value = retArray[0];

		}
		target.value = retArray[1];
	}
}

function callDrugSearch(obj) {
	var arrCodeDesc = DrugSearch("D",obj);
	if(arrCodeDesc != null && arrCodeDesc != "" ) {
		document.formPhRepDispStatByDrugCriteria.drug_code.value	=	arrCodeDesc[0];
		obj.value =	arrCodeDesc[1];
	}
}








function GoBack() {
	alert(getMessage("PH_MEDN_ORD_PRACT_WARN","PH"));
	//history.go(-1);
	window.location.href = '../../eCommon/jsp/dmenu.jsp';
}

/*function ValidateFrom(from,to) {
	var result	=	true;
	if(!ValidateDateTime(from,to)) {
	alert("Should be Greater than Current Time");
	to.select();
	result	=	false;
	}

return result;
}*/

function ValidateFrom(from,to,en) {
	var result	=	true;
	if(!ValidateDateTime(from,to)) {
	alert(getMessage("SHOULD_BE_GREATER_THAN_CURRENT_TIME","PH"));
	to.select();
	result	=	false;
	}
	else
	{
		if(!ValidateDateTime(to,en)) {
			alert(getMessage("SHOULD_BE_LESS_THAN_SYSDATE","PH"));
        	to.select();
			result	=	false;
		}
	}

return result;
}

function ValidateTo(from,to,en) {
	var result	=	true;
	if(!ValidateDateTime(from,to)) {
	alert(getMessage("SHOULD_BE_GREATER_THAN_FROM_TIME","PH"));
	to.select();
	to.focus();
	result	=	false;
	}
	else
	{
		if(!ValidateDateTime(to,en)) {
			alert(getMessage("SHOULD_BE_LESS_THAN_SYSDATE","PH")+" + 1");
        	to.select();
			result	=	false;
			to.focus();
		}
	}

return result;
}

function clear1(obj)
{
	
if(document.formPhMednStatByPractCriteria.p_job_title.value==""){

	document.formPhMednStatByPractCriteria.pract_name.value='';
	document.formPhMednStatByPractCriteria.tpract_name.value='';
	document.formPhMednStatByPractCriteria.pract_id.value='';
	document.formPhMednStatByPractCriteria.tpract_id.value='';
		}
else
	{
document.formPhMednStatByPractCriteria.pract_name.value='';
	document.formPhMednStatByPractCriteria.tpract_name.value='';
	document.formPhMednStatByPractCriteria.pract_id.value='';
	document.formPhMednStatByPractCriteria.tpract_id.value='';
}
}


function callLocation(Obj){
	if(document.formPhMednStatByPractCriteria.p_facility_code.value!=""){
		document.formPhMednStatByPractCriteria.pract_search.disabled=false;
		document.formPhMednStatByPractCriteria.tpract_search.disabled=false;
		document.formPhMednStatByPractCriteria.p_job_title.disabled=false;

	}else{
		document.formPhMednStatByPractCriteria.pract_name.value='';
		document.formPhMednStatByPractCriteria.pract_search.disabled=true;
		document.formPhMednStatByPractCriteria.tpract_name.value='';
		document.formPhMednStatByPractCriteria.tpract_search.disabled=true;
		document.formPhMednStatByPractCriteria.p_job_title.value='';
		document.formPhMednStatByPractCriteria.p_job_title.selectedIndex=0;
		document.formPhMednStatByPractCriteria.p_job_title.disabled=true;
	}
}
	//Added on date 14-04-2009 for Medication Order Statistics By Dispense Location 
	
function searchDispenseLocation(target, mode) {

	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var language_id=f_query_add_mod.document.formPhMednStatByDispLocnCriteria.language_id.value;
    
	//var sql="SELECT A.DISP_LOCN_CODE code,SHORT_DESC description FROM PH_DISP_LOCN_LANG_VW A WHERE  A.FACILITY_ID LIKE ? AND upper(DISP_LOCN_CODE) LIKE upper(?) AND upper(SHORT_DESC )LIKE upper(?) AND EFF_STATUS='E' and a.language_id=";
	var sql            = f_query_add_mod.document.formPhMednStatByDispLocnCriteria.disp_locn_sql_select1.value;
	dataNameArray[0]   = "FACILITY_ID" ;
	dataValueArray[0]  = f_query_add_mod.document.formPhMednStatByDispLocnCriteria.p_facility_code.value;
	dataTypeArray[0]   = STRING ;

	argumentArray[0] = sql+"'"+language_id+"' order by 2";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "2,3";
	argumentArray[5] = target.value;

	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;

	retArray = CommonLookup( getLabel("ePH.DispenseLocation.label","ph"), argumentArray );

	if(retArray != null && retArray != "") {
			if (mode == 1){
			f_query_add_mod.document.formPhMednStatByDispLocnCriteria.from_location_code.value = retArray[0];

		}
		else if (mode == 2){
			f_query_add_mod.document.formPhMednStatByDispLocnCriteria.to_location_code.value = retArray[0];

		}
		target.value = retArray[1];
	}
}
//Assign value to DispLocn
function assgnDispenseLocation(target, mode) {
	var frmObjectOfDispLocnCriteria = f_query_add_mod.document.formPhMednStatByDispLocnCriteria;
	//alert(frmObjectOfDispLocnCriteria);
	if(mode==1){
		var fromLocationCode=frmObjectOfDispLocnCriteria.from_location_code.value;
		var fromLocationName=frmObjectOfDispLocnCriteria.from_location_name.value;
		if(fromLocationName==""){
			frmObjectOfDispLocnCriteria.from_location_code.value="";
		}else{
			searchDispenseLocation(target, mode);
		}
	}
	if(mode==2){
		var toLocationCode= frmObjectOfDispLocnCriteria.to_location_code.value ;
		var toLocationName=frmObjectOfDispLocnCriteria.to_location_name.value ;
		if(toLocationName==""){
				frmObjectOfDispLocnCriteria.to_location_code.value="";
		}else{
			searchDispenseLocation(target, mode);
			}
	}
}
//For clearing Dispence Location
function clerrDispanceLocation(){
//alert(f_query_add_mod.document.formPhMednStatByDispLocnCriteria.from_location_code);
f_query_add_mod.document.formPhMednStatByDispLocnCriteria.from_location_code.value="";
f_query_add_mod.document.formPhMednStatByDispLocnCriteria.from_location_name.value="";
f_query_add_mod.document.formPhMednStatByDispLocnCriteria.to_location_code.value ="";
f_query_add_mod.document.formPhMednStatByDispLocnCriteria.to_location_name.value ="";

}
//To Check Date
function checkSysDate(from,to,systemdate)
{
	
	var frmObjectOfDispLocnCriteria = f_query_add_mod.document.formPhMednStatByDispLocnCriteria;
	var locale=frmObjectOfDispLocnCriteria.language_id.value;
	var fromDate=convertDate(from.value,'DMY',locale,"en");
	var toDate =convertDate(to.value,'DMY',locale,"en");
	var message;
	//messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+message;
	if(!doDateCheckAlert(fromDate,systemdate,0))
	{
		
		//alert(getMessage("SHOULD_BE_LESS_THAN_SYSDATE","PH"));
		message=getMessage("FROM_DATE_LESS_THAN_SYSDATE","PH");
		messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+message;
		from.select();
		from.focus();
		return false;
	}
	if(!doDateCheckAlert(toDate,systemdate,0))
	{
		//alert("To Should be Less than Sysdate");//For less then Sys date
		message=getMessage("TO_DATE_LESS_THAN_SYSDATE","PH");
         messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+message;
		to.select();
		to.focus();
		return false;
	}
    	if(!doDateCheck(fromDate,toDate,messageFrame))
	{
		//alert("To Should be Greater than From");//For less then Sys date
		message=getMessage("TO_DT_GR_EQ_FM_DT","PH");
		messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+message;
		to.select();
		to.focus();
		return false;
	}
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp?err_num='+message;
	return true;
}


/*FUNCTION FOR CHECKIN STATUS OF THE CHECKBOX*/
function checkStatus(obj){
	
  if (obj.checked)
  {
	  obj.value ='Y';
  }
  else
	 obj.value ='N';
}
