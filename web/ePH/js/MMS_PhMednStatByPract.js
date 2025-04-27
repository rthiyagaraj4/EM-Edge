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
				if(f_query_add_mod.CheckString(getLabel("ePH.DispenseLocation.label","PH"),f_query_add_mod.document.formPhMednStatByDispLocnCriteria.from_location_code, f_query_add_mod.document.formPhMednStatByDispLocnCriteria.to_location_code, messageFrame) ) {//Added for BRUSIM Adhoc Testing
					var locale=frmObjectOfDispLocnCriteria.language_id.value;
					frmObjectOfDispLocnCriteria.dt_from.value=convertDate(frmObjectOfDispLocnCriteria.P_DATE_FROM.value,'DMY',locale,"en");
					frmObjectOfDispLocnCriteria.dt_to.value=convertDate(frmObjectOfDispLocnCriteria.P_DATE_TO.value,'DMY',locale,"en");
					f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
					f_query_add_mod.document.forms[0].target="messageFrame";
					f_query_add_mod.document.formPhMednStatByDispLocnCriteria.submit();
				}
			}
		 }
	 }
   }
	if(frmObject != null || frmObject != undefined){//End of Modification on date for Medication Order Statistics By Dispense Location 
		var temp_qry_1=f_query_add_mod.document.getElementById("sql_ph_medn_stat_pract_select1").value;//Modified for ML-BRU-SCF-1220
		f_query_add_mod.document.getElementById("sql_ph_medn_stat_pract_select1").value="";
		if(f_query_add_mod.document.formPhMednStatByPractCriteria) {
			var locale=frmObject.p_language_id.value;//Added for DateConversion
			var fields= new Array (frmObject.p_select_by,frmObject.p_dt_from,frmObject.p_dt_to,frmObject.p_group_by,frmObject.p_report_by);//dt_from to p_dt_from Added for DateConversion identification  &&  dt_to to p_dt_to Added for DateConversion identification
			var names= new Array (getLabel("ePH.SelectBy.label","PH"),getLabel("Common.periodfrom.label","Common"),getLabel("Common.todate.label","Common"), getLabel("Common.groupby.label","Common"),getLabel("Common.reporttype.label","Common"));
			if(checkFields(fields,names,messageFrame) ) {
				if( f_query_add_mod.doDateCheck( f_query_add_mod.document.formPhMednStatByPractCriteria.p_dt_from, f_query_add_mod.document.formPhMednStatByPractCriteria.p_dt_to, messageFrame ) ) {//dt_from to p_dt_from Added for DateConversion identification  &&  dt_to to p_dt_to Added for DateConversion identification
					if(f_query_add_mod.CheckString(getLabel("Common.practitioner.label","Common"), 
						f_query_add_mod.document.formPhMednStatByPractCriteria.pract_id, f_query_add_mod.document.formPhMednStatByPractCriteria.tpract_id, messageFrame) ) {
						frmObject.dt_from.value=convertDate(frmObject.p_dt_from.value,'DMY',locale,"en");//Added for DateConversion identification
						frmObject.dt_to.value=convertDate(frmObject.p_dt_to.value,'DMY',locale,"en");//Added for DateConversion identification
						if(frmObject.pract_name.value=="")//Added if and else if for MMS_ADHOC_0044
							f_query_add_mod.document.formPhMednStatByPractCriteria.pract_id.value='';
						else if(frmObject.tpract_name.value=="")
							f_query_add_mod.document.formPhMednStatByPractCriteria.tpract_id.value='';
						f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
						f_query_add_mod.document.forms[0].target="messageFrame";
						f_query_add_mod.document.formPhMednStatByPractCriteria.submit();
					}
				}
			}
		}
		f_query_add_mod.document.getElementById("sql_ph_medn_stat_pract_select1").value = temp_qry_1;
	}
}

async function CustomerGroupSearch(target){ //added for MMS CRF-0107 start
	var frmObject = parent.f_query_add_mod.document.formPhMednStatByPractCriteria;
	if(frmObject==undefined||frmObject==null)
		var frmObject = parent.f_query_add_mod.document.formPhMednStatByDispLocnCriteria;
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var lan_id=frmObject.language_id.value;
	argumentArray[0] = frmObject.SQL_PH_CUSTOMER_GROUP_SELECT.value+"'"+lan_id+"' ORDER BY 2";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] =target.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( getLabel("ePH.CustomerGroup.label","PH"), argumentArray );
	var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != "") {
		    
		frmObject.p_customer_group.value = arr[1];
		frmObject.P_CUST_GROUP_CODE.value = arr[0];
	}
}

async function CustomerSearch(target){
	var frm_obj = parent.f_query_add_mod.document.formPhMednStatByPractCriteria;
	
	if(frm_obj==undefined||frm_obj==null)
		var frm_obj = parent.f_query_add_mod.document.formPhMednStatByDispLocnCriteria;
		
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	var lan_id=frm_obj.language_id.value;
	argumentArray[0] = frm_obj.SQL_PH_CUSTOMER_SELECT.value+"'"+lan_id+"' ORDER BY 2";
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK ;
	argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( getLabel("Common.Customer.label","PH"), argumentArray );
	 var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != "") {
		frm_obj.p_customer.value = arr[1];
		frm_obj.P_CUST_CODE.value = arr[0];
	}
}//added for MMS CRF-0107 end



function reset() {
	//Modified  on date 14-04-2009 for Medication Order Statistics By Dispense Location  because The common use of js
    //f_query_add_mod.formPhMednStatByPractCriteria.reset();
     f_query_add_mod.document.forms[0].reset(); //newly addded
    if(f_query_add_mod.document.getElementById("p_job_title")!=undefined||f_query_add_mod.document.getElementById("p_job_title")!=null)
     f_query_add_mod.document.getElementById("p_job_title").disabled=true;//Added for ML-BRU-SCF-1220
	messageFrame.document.location.href='../../eCommon/jsp/error.jsp';
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

async function searchPractitionerName(target, mode) {

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

	retArray = await CommonLookup( getLabel("Common.practitioner.label","Common"), argumentArray );
	 var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retArray != null && retArray != "") {
			if (mode == 1){
			f_query_add_mod.document.formPhMednStatByPractCriteria.pract_id.value = arr[0];

		}
		else if (mode == 2){
			f_query_add_mod.document.formPhMednStatByPractCriteria.tpract_id.value = arr[0];

		}
		target.value = arr[1];
	}
	else{//Added for MMS_ADHOC_0044
		 if (mode == 1){
			f_query_add_mod.document.formPhMednStatByPractCriteria.pract_name.value ="";
		 }
	else if (mode == 2){
			f_query_add_mod.document.formPhMednStatByPractCriteria.tpract_name.value = "";

		}
	 }
}

async function callDrugSearch(obj) {
	var arrCodeDesc = await DrugSearch("D",obj);
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
		//document.formPhMednStatByPractCriteria.pract_search.disabled=true;//Commented for ML-BRU-SCF-1220
		document.formPhMednStatByPractCriteria.tpract_name.value='';
		//document.formPhMednStatByPractCriteria.tpract_search.disabled=true;////Commented for ML-BRU-SCF-1220
		document.formPhMednStatByPractCriteria.p_job_title.value='';
		document.formPhMednStatByPractCriteria.p_job_title.selectedIndex=0;
		document.formPhMednStatByPractCriteria.p_job_title.disabled=true;
	}
}
	//Added on date 14-04-2009 for Medication Order Statistics By Dispense Location 
	
async function searchDispenseLocation(target, mode) {

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

	retArray = await CommonLookup( getLabel("ePH.DispenseLocation.label","ph"), argumentArray );
	var ret1=unescape(retArray);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	
	if(retArray != null && retArray != "") {
			if (mode == 1){
			f_query_add_mod.document.formPhMednStatByDispLocnCriteria.from_location_code.value = arr[0];

		}
		else if (mode == 2){
			f_query_add_mod.document.formPhMednStatByDispLocnCriteria.to_location_code.value = arr[0];

		}
		target.value = arr[1];
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


