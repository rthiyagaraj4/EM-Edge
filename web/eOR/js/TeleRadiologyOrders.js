

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
	
06/02/2018		IN065642		Prathyusha P				 		Ramesh G       GHL-CRF-0487 [IN:065642]
14/02/2018      IN066695        Prathyusha p     14/02/2018        Ramesh G        GHL-CRF-0487_US001 [IN:065642]

---------------------------------------------------------------------------------------------------------------------------------------------------------
*/

function checkRec(obj)
{ 

	if(obj.name=="ordered_by"){
		if (obj.value!= "")
		{
			getServiceCode();
			
		}
		else
		{
			document.teleRadilogyOrdersCriteriaForm.ordered_by.value = "";
			document.teleRadilogyOrdersCriteriaForm.ordered_by_code.value = "";
		}
	}
	else if(obj.name="performed_by"){
		if (obj.value!= "")
		{
			getServiceCode1();
			
		}
		else
		{
			document.teleRadilogyOrdersCriteriaForm.performed_by.value = "";
			document.teleRadilogyOrdersCriteriaForm.performed_by_code.value = "";
		}
	}
	
	}

function getServiceCode()
{	
	var target			= document.teleRadilogyOrdersCriteriaForm.ordered_by;
	 
	var val				= document.teleRadilogyOrdersCriteriaForm.ordering_facility_name.value;
	 var sql;
	var retVal			=  new String();
	var dialogTop		= "40";
	var dialogHeight	= "10" ;
	var dialogWidth		= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments		= "" ;
	var search_desc		= "";
	var title			= getLabel("Common.OrderedBy.label","COMMON");
	var locale			=document.teleRadilogyOrdersCriteriaForm.locale.value;
	
    //var sql="Select a.practitioner_id code , b.practitioner_name description from AM_PRACT_FOR_FACILITY A, AM_PRACTITIONER_LANG_VW B where UPPER(b.practitioner_name) like upper(?) AND a.practitioner_id like upper(?) AND a.facility_id = '"+val+"' AND B.PRACTITIONER_ID = A.PRACTITIONER_ID AND B.LANGUAGE_ID = '"+locale+"' ";
	if(val == ""){
		sql="SELECT distinct sm_facility_for_user.appl_user_id code, sm_appl_user.appl_user_name description FROM sm_facility_for_user, sm_facility_param, sm_appl_user WHERE sm_facility_for_user.appl_user_id = sm_appl_user.appl_user_id AND sm_facility_for_user.facility_id = sm_facility_param.facility_id AND sm_appl_user.appl_user_id LIKE UPPER (?) AND UPPER (sm_appl_user.appl_user_name) LIKE UPPER (?) AND sm_appl_user.eff_status = 'E'";
		   }
	   
		   else{
		sql="SELECT sm_facility_for_user.appl_user_id code, sm_appl_user.appl_user_name description FROM sm_facility_for_user, sm_facility_param, sm_appl_user WHERE sm_facility_for_user.appl_user_id = sm_appl_user.appl_user_id AND sm_facility_for_user.facility_id = sm_facility_param.facility_id AND sm_facility_for_user.facility_id='"+val+"'AND sm_appl_user.appl_user_id LIKE UPPER (?) AND UPPER (sm_appl_user.appl_user_name) LIKE UPPER (?) AND sm_appl_user.eff_status = 'E'";
		}
	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();
	
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray = CommonLookup( title, argArray );	

	if(retArray != null && retArray !="")
	{

		document.teleRadilogyOrdersCriteriaForm.ordered_by.value = retArray[1];
		document.teleRadilogyOrdersCriteriaForm.ordered_by_code.value = retArray[0];
		
	}
	else
	{
		document.teleRadilogyOrdersCriteriaForm.ordered_by.value = "";
		document.teleRadilogyOrdersCriteriaForm.ordered_by_code.value = "";
		
	}
}
function getServiceCode1()
{	
	var target			= document.teleRadilogyOrdersCriteriaForm.performed_by;
	 
	var val				= document.teleRadilogyOrdersCriteriaForm.performing_facility_id.value;
	 var sql;
	var retVal			=  new String();
	var dialogTop		= "40";
	var dialogHeight	= "10" ;
	var dialogWidth		= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments		= "" ;
	var search_desc		= "";
	var title			= getLabel("Common.Performed.label","COMMON")+" "+getLabel("Common.by.label","COMMON");
	
	var locale			=document.teleRadilogyOrdersCriteriaForm.locale.value;
	
    if(val == ""){
    	 sql="Select distinct a.practitioner_id code , b.practitioner_name description from AM_PRACT_FOR_FACILITY A, AM_PRACTITIONER_LANG_VW B where   a.practitioner_id like upper(?) and UPPER(b.practitioner_name) like upper(?) AND B.PRACTITIONER_ID = A.PRACTITIONER_ID AND B.LANGUAGE_ID = '"+locale+"' ";
    }
    else{
    	 sql="Select a.practitioner_id code , b.practitioner_name description from AM_PRACT_FOR_FACILITY A, AM_PRACTITIONER_LANG_VW B where  a.practitioner_id like upper(?) and UPPER(b.practitioner_name) like upper(?)  AND a.facility_id = '"+val+"' AND B.PRACTITIONER_ID = A.PRACTITIONER_ID AND B.LANGUAGE_ID = '"+locale+"' and b.eff_status='E' ";
    }
  
	var argArray		= new Array();
	var namesArray		= new Array();
	var valuesArray		= new Array();
	var datatypesArray	= new Array();
	
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value;
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray = CommonLookup( title, argArray );	

	if(retArray != null && retArray !="")
	{

		document.teleRadilogyOrdersCriteriaForm.performed_by.value = retArray[1];
		document.teleRadilogyOrdersCriteriaForm.performed_by_code.value = retArray[0];
		
	}
	else
	{
		document.teleRadilogyOrdersCriteriaForm.performed_by.value = "";
		document.teleRadilogyOrdersCriteriaForm.performed_by_code.value = "";
		
	}
}
function getPerformingFacility1(obj){
	if(obj.value!="")
		getPerformingFacility();
	else{
		document.teleRadilogyOrdersCriteriaForm.performing_facility_id_name.value ="";
		document.teleRadilogyOrdersCriteriaForm.performing_facility_id.value = "";	
	}
}
function getPerformingFacility(){
	var performingFacility = document.teleRadilogyOrdersCriteriaForm.performing_facility_id_name.value;
	var retVal=  new String();
	var dialogTop	= "40";
	var dialogHeight= "10" ;
	var dialogWidth= "40" ;
	var features= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments	= "" ;
	var title= getLabel("Common.PerformingFacility.label","Common");
	var sql="select facility_id code,facility_name description from sm_facility_param where  status='E'  and upper(facility_id) like upper(?) and upper(facility_name) like upper(?)  ";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = performingFacility; 
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	
	retArray = CommonLookup(title,argArray);
	if(retArray != null && retArray !=""){	 
		document.teleRadilogyOrdersCriteriaForm.performing_facility_id_name.value = retArray[1];
		document.teleRadilogyOrdersCriteriaForm.performing_facility_id.value = retArray[0];	
	}
}
function getReportingFactility1(obj){
	if(obj.value!="")
		getReportingFactility();
	else{
		document.teleRadilogyOrdersCriteriaForm.reporting_facility_id_name.value ="";
		 document.teleRadilogyOrdersCriteriaForm.reporting_facility_id.value = "";	
	}
}
function getReportingFactility(){
	var reportingFacility = document.teleRadilogyOrdersCriteriaForm.reporting_facility_id_name.value;
	
	var retVal=  new String();
	var dialogTop	= "40";
	var dialogHeight= "10" ;
	var dialogWidth= "40" ;
	var features= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments	= "" ;
	var title= getLabel("Common.RepFacility.label","Common");
	var sql="select facility_id code,facility_name description from sm_facility_param where  status='E'  and upper(facility_id) like upper(?) and upper(facility_name) like upper(?)  ";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = reportingFacility; 
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	
	retArray = CommonLookup(title,argArray);
	if(retArray != null && retArray !=""){
		 document.teleRadilogyOrdersCriteriaForm.reporting_facility_id_name.value = retArray[1];
		 document.teleRadilogyOrdersCriteriaForm.reporting_facility_id.value = retArray[0];	
	}
}
function get_facility(obj)
{	
var target=obj.value;
/*if(obj.name=="ordering_facility_buttn"  ){
		target=document.teleRadilogyOrdersCriteriaForm.ordering_facility_id_name.value;
		
	}*/
	 if(obj.name=="performing_facility_buttn" ){
		
		target=document.teleRadilogyOrdersCriteriaForm.performing_facility_id_name.value;
		
		}
	  if(obj.name=="reporting_facility_buttn"  ){

		 target=document.teleRadilogyOrdersCriteriaForm.reporting_facility_id_name.value;
		
			}
			
	var retVal=  new String();
	var dialogTop	= "40";
	var dialogHeight= "10" ;
	var dialogWidth= "40" ;
	var features= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments	= "" ;
	var title= getLabel("Common.facility.label","Common");
	var sql="select facility_id code,facility_name description from sm_facility_param where  status='E'  and upper(facility_id) like upper(?) and upper(facility_name) like upper(?) ";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target; 
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	
retArray = CommonLookup(title,argArray);
if(retArray != null && retArray !=""){
	
	/*if(obj.name=="ordering_facility_buttn" || obj.name=="ordering_facility_id_name" ){
		document.teleRadilogyOrdersCriteriaForm.ordering_facility_id_name.value = retArray[1];
		document.teleRadilogyOrdersCriteriaForm.ordering_facility_id.value = retArray[0];
	//	obj.value=retArray[1];
	}*/
	 if(obj.name=="performing_facility_buttn" || obj.name=="performing_facility_id_name" ){
		
		document.teleRadilogyOrdersCriteriaForm.performing_facility_id_name.value = retArray[1];
		document.teleRadilogyOrdersCriteriaForm.performing_facility_id.value = retArray[0];
		//obj.value=retArray[1];
		}
	  if(obj.name=="reporting_facility_buttn" || obj.name=="reporting_facility_id_name" ){

		 document.teleRadilogyOrdersCriteriaForm.reporting_facility_id_name.value = retArray[1];
		 document.teleRadilogyOrdersCriteriaForm.reporting_facility_id.value = retArray[0];
				//obj.value=retArray[1];
			}
}
}
function getPractitioner1(obj){
	if(obj.value!="")
		getPractitioner();
	else{
		document.teleRadilogyOrdersCriteriaForm.ordering_pract_desc.value = ""; 
		document.teleRadilogyOrdersCriteriaForm.ordering_pract_code.value = "";
	}
}
function getPractitioner()
{
		var target			= document.teleRadilogyOrdersCriteriaForm.ordering_pract_desc;
		var locale			= document.teleRadilogyOrdersCriteriaForm.locale.value;
		var val=document.teleRadilogyOrdersCriteriaForm.ordering_facility_name.value;
		var spec_code		= '';
		var sql;
		var retVal			= new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= getLabel("Common.OrderingPractitioner.label","Common");
		
		if(val == ""){
			sql ="select a.PRACTITIONER_ID code, a.SHORT_NAME description from am_practitioner_lang_vw  a where eff_status = 'E' and LANGUAGE_ID='"+locale+"' and upper(a.PRACTITIONER_ID) like upper(?) and upper(a.SHORT_NAME) like upper(?)  order by 2";
			}
			else{
			sql="SELECT   a.practitioner_id code, a.short_name description FROM am_practitioner_lang_vw a,am_pract_for_facility b WHERE b.eff_status = 'E' AND language_id = 'en' AND UPPER (a.practitioner_id) LIKE UPPER (?) AND UPPER (a.short_name) LIKE UPPER (?) AND a.practitioner_id = b.practitioner_id and b.facility_id='"+val+"' ORDER BY 2";
			}
		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();
		
		argArray[0] = sql;
		
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		
		retVal = await CommonLookup( title, argArray )

		if (retVal != null && retVal != '' && retVal != "null")
		{
		   	document.teleRadilogyOrdersCriteriaForm.ordering_pract_desc.value = retVal[1];
		   	document.teleRadilogyOrdersCriteriaForm.ordering_pract_code.value = retVal[0];
			if(retVal[0] == "*ALL" || retVal[0] == "ALL") {
				document.teleRadilogyOrdersCriteriaForm.ordering_pract_code.value = "";
			}
		}
		else
		{
			document.teleRadilogyOrdersCriteriaForm.ordering_pract_desc.value = ""; 
			document.teleRadilogyOrdersCriteriaForm.ordering_pract_code.value = "";
			
		} 
}
function callordertypeSearch1(obj){
	if(obj.value!="")
		callordertypeSearch();
	else{

		document.teleRadilogyOrdersCriteriaForm.order_type.value="";
		document.teleRadilogyOrdersCriteriaForm.order_type_desc.value="";
	}
}
function callordertypeSearch()
{
	
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	
	
	var locale= document.teleRadilogyOrdersCriteriaForm.locale.value;
	var sql="SELECT order_type_code code,  short_desc description FROM or_order_type_lang_vw WHERE language_id='"+locale+"' and eff_status='E' AND  upper(order_type_code) like upper(?) and upper(short_desc) like upper(?)";
	var target			= document.teleRadilogyOrdersCriteriaForm.order_type_desc;
	
	
	
	argumentArray[0]=sql;
	argumentArray[1]=dataNameArray;
	argumentArray[2]=dataValueArray;
	argumentArray[3]=dataTypeArray;
	argumentArray[4]="1,2";
	argumentArray[5]=target.value;
	argumentArray[6]= CODE_LINK;
	argumentArray[7]= CODE_DESC;

	retval=CommonLookup(getLabel("Common.OrderType.label","Common"),argumentArray);

	if(retval !=null && retval != "")
	{
		document.teleRadilogyOrdersCriteriaForm.order_type_desc.value=retval[1];
		document.teleRadilogyOrdersCriteriaForm.order_type.value=retval[0];
	}else{
   	
		document.teleRadilogyOrdersCriteriaForm.order_type.value="";
		document.teleRadilogyOrdersCriteriaForm.order_type_desc.value="";
	}
}


function resetCriteria()
{
	parent.teleRadiologyOrdersCriteriaFrame.location.reload();
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	
}
function SearchChart(flag){
	if(flag=='jsp')	{
		
		var ordering_facility_id=document.teleRadilogyOrdersCriteriaForm.ordering_facility_name.value;
		var ordered_by=document.teleRadilogyOrdersCriteriaForm.ordered_by_code.value;
		
		var order_id=document.teleRadilogyOrdersCriteriaForm.order_id.value;
		var performing_facility_id=document.teleRadilogyOrdersCriteriaForm.performing_facility_id.value;
		var performed_by=document.teleRadilogyOrdersCriteriaForm.performed_by_code.value;
		var order_type_code=document.teleRadilogyOrdersCriteriaForm.order_type.value;
		var order_catalog_code=document.teleRadilogyOrdersCriteriaForm.catalog.value;
		var reporting_facility_id=document.teleRadilogyOrdersCriteriaForm.reporting_facility_id.value;
		var ORDERED_PRACT=document.teleRadilogyOrdersCriteriaForm.ordering_pract_code.value;
		var examStatus=document.teleRadilogyOrdersCriteriaForm.exam_search_criteria.value;
		var fromDate=document.teleRadilogyOrdersCriteriaForm.date_from.value;
		var toDate=document.teleRadilogyOrdersCriteriaForm.date_to.value;
		var Patient_Id=document.teleRadilogyOrdersCriteriaForm.Patient_Id.value;
		var contails_key=document.teleRadilogyOrdersCriteriaForm.catalog_search_criteria.value;
		var assigned_rad_id=document.teleRadilogyOrdersCriteriaForm.assigned_red_code.value;
		
		if(fromDate == ""){
		alert("From Date Cannot Be Blank.");
		document.teleRadilogyOrdersCriteriaForm.date_from.focus();
		return false;
		}
		if(toDate == ""){
			alert("To Date Cannot Be Blank.");
			document.teleRadilogyOrdersCriteriaForm.date_to.focus();
			return false;
		}
		var max_days=daysBetween(fromDate,toDate,"DMY",document.teleRadilogyOrdersCriteriaForm.locale.value);
		if(max_days>30){
		var errors=getMessage('OR_DATE_RANGE','OR');
			alert(errors);
			document.teleRadilogyOrdersCriteriaForm.date_from.focus();
			return false;
		}
		parent.teleRadiologyOrdersResultFrame.location.href="../jsp/TeleRadiologyOrdersResult.jsp?ordering_facility_id="+ordering_facility_id+"&ordered_by="+ordered_by+"&order_id="+order_id+"&performing_facility_id="+performing_facility_id+"&performed_by="+performed_by+"&order_type_code="+order_type_code+"&order_catalog_code="+order_catalog_code+"&reporting_facility_id_cre="+reporting_facility_id+"&ORDERED_PRACT="+ORDERED_PRACT+"&examStatus="+examStatus+"&from_date="+fromDate+"&to_date="+toDate+"&patient_id="+Patient_Id+"&contails_key="+contails_key+"&assigned_rad_id="+assigned_rad_id;	
		
		
	}
}
//for patient lookup
function callPatientSearch(target){
	var patient_id = PatientSearch();
		
	if (typeof(patient_id)=="string"){
		target.value = patient_id;
	}
}


function OrAllowDateFormat(){
	   var key = window.event.keyCode;   
	   if( ! ( (( key>=48 ) && ( key<58 ) ) || (key == 47)) ) {
	       return false;
	   }

	}

function callSearch()
{
   	if(window.event.keyCode==13)
	{
   		SearchChart('jsp');
	}
}

function checkDateRange(obj,from){
	var fromDate = eval("document."+from+".date_from")
	var toDate = eval("document."+from+".date_to")
    var localeName = eval("document."+from+".locale")
	var max_days=daysBetween(fromDate.value,toDate.value,"DMY",localeName);
     if(validDateObj(obj,"DMY",localeName.value))
	{

		if(!isAfter(toDate.value,fromDate.value,"DMY",localeName.value)){
			
			alert(getMessage("TO_DT_GR_EQ_FM_DT","SM")); 
			//fromDate.select()
			obj.focus();
			obj.select();
			return false;
		}
		else if(!(isBeforeNow(toDate.value,"DMY",localeName.value) ))
			{
				alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
				
				obj.focus();
				obj.select();
				return false;
			}
	
	}
	
}
function checkDate(obj,from){
	var fromDate = eval("document."+from+".date_from")
	var toDate = eval("document."+from+".date_to")
    var localeName = eval("document."+from+".locale")
	var max_days=daysBetween(fromDate.value,toDate.value,"DMY",localeName.value);
     if(validDateObj(obj,"DMY",localeName.value))
	{

		if(!isBefore(fromDate.value,toDate.value,"DMY",localeName.value)) {
			
			var errors=getMessage('FROM_DATE_GREATER_TO_DATE','FM'); 
			alert(errors);
			//fromDate.select();
			fromDate.focus();
			return false;
		}
		else if(max_days>30){
			var errors=getMessage('OR_DATE_RANGE','OR');
			alert(errors);
			//fromDate.select();
			fromDate.focus();
			return false;
		}
	
	}
	
}
function getRadiologist1(obj){
	if(obj.value!="")
		getRadiologist();
	else{
		document.teleRadilogyOrdersCriteriaForm.assigned_red_desc.value = ""; 
		document.teleRadilogyOrdersCriteriaForm.assigned_red_code.value = "";
	}
}
function getRadiologist()
{
		var target			= document.teleRadilogyOrdersCriteriaForm.assigned_red_desc;
		var locale			= document.teleRadilogyOrdersCriteriaForm.locale.value;
		var retVal			= new String();
		var dialogTop		= "40";
		var dialogHeight	= "10" ;
		var dialogWidth		= "40" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;
		var search_desc		= "";
		var title			= getLabel("Common.Assigned.label","COMMON")+" "+getLabel("eOR.radiologist.label","EOR");
		var sql="SELECT   a.practitioner_id code, a.short_name description FROM am_practitioner_lang_vw a WHERE a.eff_status = 'E' AND language_id ='"+locale+"' AND UPPER (a.practitioner_id) LIKE UPPER (?) AND UPPER (a.short_name) LIKE UPPER (?) AND a.pract_type ='RD' ORDER BY 2";
		
		var argArray		= new Array();
		var namesArray		= new Array();
		var valuesArray		= new Array();
		var datatypesArray	= new Array();
		
		argArray[0] = sql;
		
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = CODE_DESC;
		
		retVal = await CommonLookup( title, argArray )

		if (retVal != null && retVal != '' && retVal != "null")
		{
		   	document.teleRadilogyOrdersCriteriaForm.assigned_red_desc.value = retVal[1];
		   	document.teleRadilogyOrdersCriteriaForm.assigned_red_code.value = retVal[0];
			if(retVal[0] == "*ALL" || retVal[0] == "ALL") {
				document.teleRadilogyOrdersCriteriaForm.assigned_red_code.value = "";
			}
		}
		else
		{
			document.teleRadilogyOrdersCriteriaForm.assigned_red_desc.value = ""; 
			document.teleRadilogyOrdersCriteriaForm.assigned_red_code.value = "";
			
		} 
				
}
function chkDateTime(toDate,format,locale)
{
	
	if(toDate.value != '') 
	{		
		var from_date = document.getElementById("date_from");
		var to_date = document.getElementById("date_to");
		
			if(validDateObj(toDate,format,locale))
		{			
			
			if(from_date.value != "" || to_date.value != "" )
			{
				chkToDate(from_date,to_date,format,locale);
			}
			
		}
	}
	
	
}
function chkToDate(fromDate,toDate,format,locale)
{	
	var max_days=daysBetween(fromDate.value,toDate.value,"DMY",locale.value);
      
	  	if( max_days>30)
			{
			var errors=getMessage('OR_DATE_RANGE','OR');
			alert(errors);
			toDate.select();
			toDate.focus();
			return false;
			}
	if(fromDate.value != "")
	{		
		if(!isBeforeNow(fromDate.value,format,locale))
		{
			alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
			fromDate.select();
			fromDate.focus();
			fromDate.value="";
			return false;
				
		}else{ 
		  if( toDate.value != ""){
				if(isBeforeNow(toDate.value,format,locale))
				{
					if(isAfter(toDate.value,fromDate.value, format, locale))
						return true;
					else
					{
						alert(getMessage("TO_DT_GR_EQ_FM_DT","CA")); 
						toDate.select();
						toDate.focus();
						return false;
					}
					
					
				}else{
					alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common")); 
					toDate.select();
					toDate.focus();
					return false;
				}
			}
		
		}
	}else{	
	
		document.teleRadilogyOrdersCriteriaForm.date_from.value= document.teleRadilogyOrdersCriteriaForm.current_date.value;
		if((toDate.value!=""))
		{
			if(!isBeforeNow(toDate.value, format, locale)){
				alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
				toDate.select();
				toDate.focus();
				return false;
			}
		}
		
		
	}

}
