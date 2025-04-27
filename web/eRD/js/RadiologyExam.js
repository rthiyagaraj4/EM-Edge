
/*
Sr No        Version              TFS              SCF/CRF           	   				 Developer Name
-------------------------------------------------------------------------------------------------------
1            V211228            26735      PMG2021-COMN-CRF-0089.1-TF-US001            Mohanapriya K
2			V220407				29768      PMG2021-COMN-CRF-0089.3-TF-US001            Mohanapriya K
3			 V220720						GHL-SCF-1669-TF							   Mohanapriya K
-------------------------------------------------------------------------------------------------------
*/
var comment="";
var count = 0;
var recordSelected=-1;
var update="N";

function disableSearch(e){
	if(e=="disable"){
		document.radilogyExamCriteriaForm.Search.disabled=true;
	}else if(e=="enable"){
		parent.RadiologyExamSearchHdr.document.forms[0].Search.disabled=false;
	}
}

function SearchRadChart(flag){
	if(flag=='RadExam')	{
		var ordering_facility_id=document.radilogyExamCriteriaForm.ordering_facility_name.value;
		var Reg_no=document.radilogyExamCriteriaForm.Reg_no.value;
		var performing_facility_id=document.radilogyExamCriteriaForm.performing_facility_id.value;
		var performed_by=document.radilogyExamCriteriaForm.performed_by_code.value;
		var order_type_code=document.radilogyExamCriteriaForm.order_type.value;
		var order_catalog_code=document.radilogyExamCriteriaForm.catalog.value;
		var reporting_facility_id=document.radilogyExamCriteriaForm.reporting_facility_id.value;
		var examStatus=document.radilogyExamCriteriaForm.exam_search_criteria.value;
		var fromDate=document.radilogyExamCriteriaForm.date_from.value;
		var toDate=document.radilogyExamCriteriaForm.date_to.value;
		var Patient_Id=document.radilogyExamCriteriaForm.Patient_Id.value;
		var contails_key=document.radilogyExamCriteriaForm.catalog_search_criteria.value;
		var assigned_rad_id=document.radilogyExamCriteriaForm.assigned_red_code.value;
		var urgency_ind = document.radilogyExamCriteriaForm.urgency_ind_criteria.value;
		
		if(fromDate == ""){
		alert("From Date Cannot Be Blank.");
		document.radilogyExamCriteriaForm.date_from.focus();
		return false;
		}
		if(toDate == ""){
			alert("To Date Cannot Be Blank.");
			document.radilogyExamCriteriaForm.date_to.focus();
			return false;
		}
		var max_days=daysBetween(fromDate,toDate,"DMY",document.radilogyExamCriteriaForm.locale.value);
		if(max_days>30){
		var errors=getMessage('OR_DATE_RANGE','OR');
			alert(errors);
			document.radilogyExamCriteriaForm.date_from.focus();
			return false;
		}
		parent.RadiologyExamSearchValues.location.href="../jsp/RadilogyExamSearchResult.jsp?ordering_facility_id="+ordering_facility_id+"&Reg_no="+Reg_no+"&performing_facility_id="+performing_facility_id+"&performed_by="+performed_by+"&order_type_code="+order_type_code+"&order_catalog_code="+order_catalog_code+"&reporting_facility_id_cre="+reporting_facility_id+"&examStatus="+examStatus+"&from_date="+fromDate+"&to_date="+toDate+"&patient_id="+Patient_Id+"&contails_key="+contails_key+"&assigned_rad_id="+assigned_rad_id+"&urgency_ind="+urgency_ind;	
		
		parent.RadiologyExamSubmit.location.href="../jsp/RadiologyExamSubmit.jsp";	
		
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";	
		
		
	}else if(flag=='resetWrkList')	{
		var ordering_facility_id=parent.RadiologyExamSearchHdr.document.forms[0].ordering_facility_name.value;
		var Reg_no=parent.RadiologyExamSearchHdr.document.forms[0].Reg_no.value;
		var performing_facility_id=parent.RadiologyExamSearchHdr.document.forms[0].performing_facility_id.value;
		var performed_by=parent.RadiologyExamSearchHdr.document.forms[0].performed_by_code.value;
		var order_type_code=parent.RadiologyExamSearchHdr.document.forms[0].order_type.value;
		var order_catalog_code=parent.RadiologyExamSearchHdr.document.forms[0].catalog.value;
		var reporting_facility_id=parent.RadiologyExamSearchHdr.document.forms[0].reporting_facility_id.value;
		var examStatus=parent.RadiologyExamSearchHdr.document.forms[0].exam_search_criteria.value;
		var fromDate=parent.RadiologyExamSearchHdr.document.forms[0].date_from.value;
		var toDate=parent.RadiologyExamSearchHdr.document.forms[0].date_to.value;
		var Patient_Id=parent.RadiologyExamSearchHdr.document.forms[0].Patient_Id.value;
		var contails_key=parent.RadiologyExamSearchHdr.document.forms[0].catalog_search_criteria.value;
		var assigned_rad_id=parent.RadiologyExamSearchHdr.document.forms[0].assigned_red_code.value;
		var urgency_ind = parent.RadiologyExamSearchHdr.document.forms[0].urgency_ind_criteria.value;
	
		parent.RadiologyExamSearchValues.location.href="../jsp/RadilogyExamSearchResult.jsp?ordering_facility_id="+ordering_facility_id+"&Reg_no="+Reg_no+"&performing_facility_id="+performing_facility_id+"&performed_by="+performed_by+"&order_type_code="+order_type_code+"&order_catalog_code="+order_catalog_code+"&reporting_facility_id_cre="+reporting_facility_id+"&examStatus="+examStatus+"&from_date="+fromDate+"&to_date="+toDate+"&patient_id="+Patient_Id+"&contails_key="+contails_key+"&assigned_rad_id="+assigned_rad_id+"&urgency_ind="+urgency_ind;	
		
		parent.RadiologyExamSubmit.location.href="../jsp/RadiologyExamSubmit.jsp";	
		
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";	
	}
}

function resetCriteria()
{
	parent.RadiologyExamSearchHdr.location.reload();
	parent.RadiologyExamSearchValues.location.href='../../eCommon/html/blank.html';
	parent.RadiologyExamSubmit.location.href="../../eCommon/html/blank.html";	
	parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
}


function checkRec(obj)
{ 
	if(obj.name="performed_by"){
		if (obj.value!= "")
		{
			getServiceCode1();
			
		}
		else
		{
			document.radilogyExamCriteriaForm.performed_by.value = "";
			document.radilogyExamCriteriaForm.performed_by_code.value = "";
		}
	}
	
	}

function getServiceCode()
{	
	var target			= document.radilogyExamCriteriaForm.ordered_by;
	 
	var val				= document.radilogyExamCriteriaForm.ordering_facility_name.value;
	 var sql;
	var retVal			=  new String();
	var dialogTop		= "40";
	var dialogHeight	= "10" ;
	var dialogWidth		= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments		= "" ;
	var search_desc		= "";
	var title			= getLabel("Common.OrderedBy.label","COMMON");
	var locale			=document.radilogyExamCriteriaForm.locale.value;
	
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

		document.radilogyExamCriteriaForm.ordered_by.value = retArray[1];
		
	}
	else
	{
		document.radilogyExamCriteriaForm.ordered_by.value = "";
		//document.radilogyExamCriteriaForm.ordered_by_code.value = "";
		
	}
}

function errorCalled(){
	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
	parent.RadiologyExamSubmit.location.href="../../eCommon/html/blank.html";	
	return false;
}

function getRadiologyReporteingFacility1(obj){
		if(obj.value!="")
			getRadiologyReporteingFacility();
			
			else{
	        document.RadiologyExamResultForm.reporting_facility_id_name.value = ""; 
			document.RadiologyExamResultForm.reporting_facility_id.value = "";
	}
}

function getRadiologyReporteingFacility()
{	
            document.RadiologyExamResultForm.assigned_pract_desc.value = ""; 
			document.RadiologyExamResultForm.assigned_pract_code.value = "";
	var target			= document.RadiologyExamResultForm.reporting_facility_id_name;
	var retArray			= new String();
	var dialogTop	= "40";
	var dialogHeight= "10" ;
	var dialogWidth= "40" ;
	var features= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments	= "" ;
	var search_desc		= "";
	var title= getLabel("Common.RepFacility.label","Common");
	var sql="select facility_id code,facility_name description from sm_facility_param where  status='E' and upper(facility_id) like upper(?)  and upper(facility_name) like upper(?)  ";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = target.value; 
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	
	retArray = CommonLookup( title , argArray )
	
	if(retArray != null && retArray !=""){
		
		document.RadiologyExamResultForm.reporting_facility_id_name.value = retArray[1];
		document.RadiologyExamResultForm.reporting_facility_id.value = retArray[0];
		
	}
	else{
		
	        document.RadiologyExamResultForm.reporting_facility_id_name.value = ""; 
			document.RadiologyExamResultForm.reporting_facility_id.value = "";
	}
}

function getPractitioner1(obj){
	if(obj.value!="")
		getPractitioner();
	else{
		document.radilogyExamCriteriaForm.ordering_pract_desc.value = ""; 
		document.radilogyExamCriteriaForm.ordering_pract_code.value = "";
	}
}

function getPractitioner()
{
		var target			= document.radilogyExamCriteriaForm.ordering_pract_desc;
		var locale			= document.radilogyExamCriteriaForm.locale.value;
		var val=document.radilogyExamCriteriaForm.ordering_facility_name.value;
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
		   	document.radilogyExamCriteriaForm.ordering_pract_desc.value = retVal[1];
		   	document.radilogyExamCriteriaForm.ordering_pract_code.value = retVal[0];
			if(retVal[0] == "*ALL" || retVal[0] == "ALL") {
				document.radilogyExamCriteriaForm.ordering_pract_code.value = "";
			}
		}
		else
		{
			document.radilogyExamCriteriaForm.ordering_pract_desc.value = ""; 
			document.radilogyExamCriteriaForm.ordering_pract_code.value = "";
			
		} 
}

function getPerformingFacility1(obj){
	if(obj.value!="")
		getPerformingFacility();
	else{
		document.radilogyExamCriteriaForm.performing_facility_id_name.value ="";
		document.radilogyExamCriteriaForm.performing_facility_id.value = "";	
	}
}

function getPerformingFacility(){
	var performingFacility = document.radilogyExamCriteriaForm.performing_facility_id_name.value;
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
		document.radilogyExamCriteriaForm.performing_facility_id_name.value = retArray[1];
		document.radilogyExamCriteriaForm.performing_facility_id.value = retArray[0];	
	}
}

function getReportingFactility1(obj){
	if(obj.value!="")
		getReportingFactility();
	else{
		document.radilogyExamCriteriaForm.reporting_facility_id_name.value ="";
		 document.radilogyExamCriteriaForm.reporting_facility_id.value = "";	
	}
}

function getReportingFactility(){
	var reportingFacility = document.radilogyExamCriteriaForm.reporting_facility_id_name.value;
	
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
		 document.radilogyExamCriteriaForm.reporting_facility_id_name.value = retArray[1];
		 document.radilogyExamCriteriaForm.reporting_facility_id.value = retArray[0];	
	}
}

function getServiceCode1()
{	
	var target			= document.radilogyExamCriteriaForm.performed_by;
	 
	var val				= document.radilogyExamCriteriaForm.performing_facility_id.value;
	 var sql;
	var retVal			=  new String();
	var dialogTop		= "40";
	var dialogHeight	= "10" ;
	var dialogWidth		= "40" ;
	var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments		= "" ;
	var search_desc		= "";
	var title			= getLabel("Common.Performed.label","COMMON")+" "+getLabel("Common.by.label","COMMON");
	
	var locale			=document.radilogyExamCriteriaForm.locale.value;
	
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

		document.radilogyExamCriteriaForm.performed_by.value = retArray[1];
		document.radilogyExamCriteriaForm.performed_by_code.value = retArray[0];
		
	}
	else
	{
		document.radilogyExamCriteriaForm.performed_by.value = "";
		document.radilogyExamCriteriaForm.performed_by_code.value = "";
		
	}
}

function getRadiologist1(obj){
	if(obj.value!="")
		getRadiologist();
	else{
		document.radilogyExamCriteriaForm.assigned_red_desc.value = ""; 
		document.radilogyExamCriteriaForm.assigned_red_code.value = "";
	}
}

function getRadiologist()
{
		var target			= document.radilogyExamCriteriaForm.assigned_red_desc;
		var locale			= document.radilogyExamCriteriaForm.locale.value;
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
			document.radilogyExamCriteriaForm.assigned_red_desc.value = retVal[1];
		   	document.radilogyExamCriteriaForm.assigned_red_code.value = retVal[0];
			if(retVal[0] == "*ALL" || retVal[0] == "ALL") {
				document.radilogyExamCriteriaForm.assigned_red_code.value = "";
			}
		}
		else
		{
			document.radilogyExamCriteriaForm.assigned_red_desc.value = ""; 
			document.radilogyExamCriteriaForm.assigned_red_code.value = "";
			
		} 				
}
//for patient lookup
function callPatientSearch(target){
	var patient_id = PatientSearch();
		
	if (typeof(patient_id)=="string"){
		target.value = patient_id;
	}
}


function callordertypeSearch1(obj){
	if(obj.value!="")
		callordertypeSearch();
	else{

		document.radilogyExamCriteriaForm.order_type.value="";
		document.radilogyExamCriteriaForm.order_type_desc.value="";
	}
}
function callordertypeSearch()
{
	
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	
	
	var locale= document.radilogyExamCriteriaForm.locale.value;
	var sql="SELECT order_type_code code,  short_desc description FROM or_order_type_lang_vw WHERE language_id='"+locale+"' and eff_status='E' AND  upper(order_type_code) like upper(?) and upper(short_desc) like upper(?)";
	var target			= document.radilogyExamCriteriaForm.order_type_desc;
	
	
	
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
		document.radilogyExamCriteriaForm.order_type_desc.value=retval[1];
		document.radilogyExamCriteriaForm.order_type.value=retval[0];
	}else{
   	
		document.radilogyExamCriteriaForm.order_type.value="";
		document.radilogyExamCriteriaForm.order_type_desc.value="";
	}
}


function select_serv(e){
	var checkUpdate=parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('checkUpdate').value;
	var submitDone=parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('submitDone').value;
	
	if(recordSelected== -1){
		var RowIndex=e;
		if(!(document.getElementById("select"+RowIndex).checked)){
			alert("Please select record before proceeding");
			return false;
		}else{
			return true;
		}
		recordSelected=RowIndex;
		parent.RadiologyExamSubmit.submit_form.document.getElementById('count').value=RowIndex;
	
		parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('idx').value=RowIndex;//to set dropdown in type
		var status=parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('status'+RowIndex).value;
		
		parent.RadiologyExamSubmit.location.href="../jsp/RadiologyExamSubmit.jsp?seltype=Y&status="+status;
		
	}else{	
		if(checkUpdate=="Y"){
			if(submitDone=="N"){
				document.forms[0].select.checked=false;
				document.getElementById("select"+recordSelected).checked=true;
				alert("Please submit the Type before proceeding");
				return false;	
			}//V220407
			else if(submitDone=="Y"){
				document.forms[0].select.checked=false;
				document.getElementById("select"+recordSelected).checked=true;
				return true;	
			}//V220407
		}else{
			if(recordSelected!=e){
				alert("Please select corresponding record before proceeding");
				return false;
			}else{
				return true;
				RowIndex=e;
				parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('idx').value=RowIndex;//to set dropdown in type
				var status=parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('status'+RowIndex).value;
				
				parent.RadiologyExamSubmit.location.href="../jsp/RadiologyExamSubmit.jsp?seltype=Y&status="+status;
				
			}
			}		
	}
}

function selected_serv(e){
	var checkUpdate=parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('checkUpdate').value;
	var submitDone=parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('submitDone').value;
	var RowIndex=e.parentNode.parentNode.rowIndex-1;
	if(recordSelected!= -1){
		if(checkUpdate=="Y"){
			if(submitDone=="N"){
				document.forms[0].select.checked=false;
				document.getElementById("select"+recordSelected).checked=true;
				alert("Please submit the Type before proceeding");
				return false;	
			}
		}//V220407
		else if(checkUpdate=="M"){
			document.forms[0].select.checked=false;
			document.getElementById("select"+recordSelected).checked=true;
		}//V220407
		else{
				document.forms[0].select.checked=false;
				document.getElementById("select"+RowIndex).checked=true;
				recordSelected=RowIndex;
				parent.RadiologyExamSubmit.submit_form.document.getElementById('count').value=RowIndex;
	
				parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('idx').value=RowIndex; //to set dropdown in type
				var status=parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('status'+RowIndex).value;
				parent.RadiologyExamSubmit.location.href="../jsp/RadiologyExamSubmit.jsp?seltype=Y&status="+status;
				
			}		
	}else{
		recordSelected=RowIndex;
		document.forms[0].select.checked=false;
		document.getElementById("select"+RowIndex).checked=true;
		parent.RadiologyExamSubmit.submit_form.document.getElementById('count').value=RowIndex;
		
		parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('idx').value=RowIndex; //to set dropdown in type
		var status=parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('status'+RowIndex).value;
		parent.RadiologyExamSubmit.location.href="../jsp/RadiologyExamSubmit.jsp?seltype=Y&status="+status;
	}
	
}

function tooltip(obj,indx){
	var table;
	
	table = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'> ";
	table += "<tr> "+
					"<td class = 'contextMenuItem' onmouseOver='highlightDynamicTd(this)' onmouseOut='removeHighlight(this)' style='cursor:pointer' nowrap onclick='refFunc("+indx+",1)'>" +
						"View Image "+
					"</td> "+
				"</tr> ";  
	
	
	table += "<tr> "+
	"<td class = 'contextMenuItem' onmouseOver='highlightDynamicTd(this)' onmouseOut='removeHighlight(this)' style='cursor:pointer' nowrap onclick='reqClinicalComm("+indx+")'>" +
			"Request Clinical Comments"+
		"</td> "+
	"</tr> ";
	
		
	table += "<tr> "+
		"<td class = 'contextMenuItem' onmouseOver='highlightDynamicTd(this)' onmouseOut='removeHighlight(this)' style='cursor:pointer' nowrap onclick='techComments("+indx+")'>" +
			"Technologist Comments"+
		"</td> "+
	"</tr> ";
		
	table += "<tr> "+
		"<td class = 'contextMenuItem' onmouseOver='highlightDynamicTd(this)' onmouseOut='removeHighlight(this)' style='cursor:pointer' nowrap onclick='refFunc("+indx+",2)'>" +
			"Clinical Event History"+
		"</td> "+
	"</tr> ";  
		
	table += "<tr> "+
		"<td class = 'contextMenuItem' onmouseOver='highlightDynamicTd(this)' onmouseOut='removeHighlight(this)' style='cursor:pointer' nowrap onclick='refFunc("+indx+",2)'>" +
			"Patient History"+
		"</td> "+
	"</tr> ";   
		
       			"</table>";
		
		document.getElementById("t").innerHTML = table;
		resizeWindow(obj);
	
}


function highlightDynamicTd(obj){
	$(obj).removeClass('contextMenuItem');
	$(obj).addClass('selectedcontextMenuItem');
}

function removeHighlight(obj){
	$(obj).removeClass('selectedcontextMenuItem');
	$(obj).addClass('contextMenuItem');
}

function resizeWindow(orderctlHDR)
{
    var orderctlHDR1 = orderctlHDR.id;
	var wdth = eval("document.all."+orderctlHDR1).offsetWidth;
	var hght1 = eval("document.all."+orderctlHDR1).offsetHeight;		
	var wdth1 = getPos(orderctlHDR).x +wdth;
	var hght = getPos(orderctlHDR).y ;	
	bodwidth  = document.body.offsetWidth
	bodheight = document.body.offsetHeight
	
	var z = bodwidth- (event.x + wdth);	
	
	var x 	  = event.x;
	var y 	  = event.y;	
	
	x 	  = x + (document.getElementById("tooltiplayer1").offsetWidth);
	y 	  = hght + (document.getElementById("tooltiplayer1").offsetHeight);	
	
	if(x<bodwidth){
		x= wdth1;
		
	}else{			
		x = getPos(orderctlHDR).x;
		
	}
	if(y<bodheight){			
		y = hght;
		
	}else
	{
		y = y - (document.getElementById("tooltiplayer1").offsetHeight*2) + hght1 ;	
	}
	document.getElementById("tooltiplayer1").style.posLeft= x;
	document.getElementById("tooltiplayer1").style.posTop = hght;
	document.getElementById("tooltiplayer1").style.visibility='visible'
}

function getPos(inputElement) {
    var coords =  new Object();
    coords.x = 0;
    coords.y = 0;
    try {
        targetElement = inputElement;
		
        if(targetElement.x && targetElement.y){
            coords.x = targetElement.x;
            coords.y = targetElement.y;
        } else {
            if(targetElement.offsetParent) {
                coords.x += targetElement.offsetLeft;
                coords.y += targetElement.offsetTop;
                while(targetElement = targetElement.offsetParent) {
                    coords.x += targetElement.offsetLeft;
                    coords.y += targetElement.offsetTop;
                }
            } else {
                // alert("Could not find any reference for coordinate
				// positioning.");
            }
        }
        return coords;
    } catch(error) {
        return coords;
    }
}


function hideToolTip()	{
	  document.getElementById("tooltiplayer1").style.visibility = 'hidden';
}

function insertRecords(){
	var idx =parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('idx').value;
	var P_REP_TYPE_TO="";
	if(idx=="" || idx==null || idx=="null"){
		alert(getMessage('RD0002', 'RD'));
		return false;
	}else{
		if(parent.RadiologyExamSubmit.submit_form.document.getElementById('typeN').value=='F'){
			if(parent.RadiologyExamSubmit.submit_form.document.getElementById('type').value!='sel'){
				P_REP_TYPE_TO=parent.RadiologyExamSubmit.submit_form.document.getElementById('type').value; //New Change
			}else{ 
				alert(getMessage('RD0004', 'RD'));
				return false;
			}
		}else{
			P_REP_TYPE_TO=parent.RadiologyExamSubmit.submit_form.document.getElementById('type').value; 
		}
	}//V221006

	var P_FACILITY_ID = parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('operating_facility_id'+idx).value;
	var P_PATIENT_ID = parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('patientid'+idx).value;
	var P_ENCOUNTER_ID = parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('enc_id'+idx).value;
	var P_LOGIN_USER = parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('User').value;
	var P_LANGUAGE_ID = parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('locale').value;
	var P_RESP_ID = parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('responsibility_id').value;
	var P_REQUEST_NUM = parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('req_no'+idx).value;
	var P_REQUEST_LINE_NUM = parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('REQUEST_LINE_NUM'+idx).value;
	var P_EXT_APPL_ACCESSION_NUM=	parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('ext_appl_accession'+idx).value;
	var indicator=	parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('indicator'+idx).value;
	var P_REP_TYPE_FROM=parent.RadiologyExamSubmit.submit_form.document.getElementById('report_from').value;
	//var P_REP_TYPE_TO=parent.RadiologyExamSubmit.submit_form.document.getElementById('type').value; //New Change //V221006
	var valid="";	
	if(P_REP_TYPE_TO=="" || P_REP_TYPE_TO==null || P_REP_TYPE_TO=="null"){
		parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('checkUpdate').value="N";
		return false;
	}
	var params="&P_FACILITY_ID="+P_FACILITY_ID+"&P_PATIENT_ID="+P_PATIENT_ID+"&P_ENCOUNTER_ID="+P_ENCOUNTER_ID+"&P_LOGIN_USER="+P_LOGIN_USER+"&P_LANGUAGE_ID="+P_LANGUAGE_ID+"&P_RESP_ID="+P_RESP_ID+"&P_REQUEST_NUM="+P_REQUEST_NUM+"&P_REQUEST_LINE_NUM="+P_REQUEST_LINE_NUM+"&P_REP_TYPE_FROM="+P_REP_TYPE_FROM+"&P_REP_TYPE_TO="+P_REP_TYPE_TO+"&called=CN";
	if(parent.RadiologyExamSubmit.submit_form.document.getElementById('mod_date').value!="" && parent.RadiologyExamSubmit.submit_form.document.getElementById('mod_date').value!=undefined){
		params+="&mod_date="+parent.RadiologyExamSubmit.submit_form.document.getElementById('mod_date').value;
	}
	var type='';
	var error='';
	$.ajax({
		type:"GET",
		url:"../jsp/RadiologyExamAjax.jsp?functionMode=StatusValidation",
		data:params,
		dataType:"json",
		async:false,
		success: function(data){
			var n=trimString(data.valid);
			var lcl = n.split('~');
			type=lcl[0];
			error=lcl[1] ; 
			
			if(error!=''){
				alert(error);
			}
			if(type!=''){
				parent.RadiologyExamSubmit.submit_form.document.getElementById('type').value=type;
			}
			
	},
		 error: function(data){
			 alert(data)
	      }
	});
	
	if(error=='' || error==null){
		parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('submitDone').value="Y";
		document.forms[0].target='messageFrame';
		document.forms[0].action="../../servlet/eRD.RadiologyExamServlet?mode=updateType"+params;
		document.forms[0].submit();		
		alert(getMessage('RD0003', 'RD'));
		// to reset
		setTimeout(function () {
			SearchRadChart("resetWrkList");
			parent.RadiologyExamSubmit.location.href="../jsp/RadiologyExamSubmit.jsp";	
			parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";	
			}, 1000);  //V220720
		/*SearchRadChart("resetWrkList");
		parent.RadiologyExamSubmit.location.href="../jsp/RadiologyExamSubmit.jsp";	
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";	*/
	}//V220407
	else if(error=="Report is not modified"){
			parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('checkUpdate').value="N";
			parent.RadiologyExamSubmit.submit_form.document.getElementById('type').disabled=true;
			parent.RadiologyExamSubmit.submit_form.document.getElementById('submitbtn').disabled=true;
	}
	//V220407
	else{
		return false;
	}
}

function trimString(sInString)
{
  sInString = sInString.replace( /^\s+/g, "" );// strip leading
  return sInString.replace( /\s+$/g, "" );// strip trailing
}

function populateStatus(idx){
     var CA_Validation=document.getElementById("CA_Validation").value;
     if(CA_Validation=="Y"){
		
	var P_FACILITY_ID = document.getElementById('operating_facility_id'+idx).value;
	var P_PATIENT_ID = document.getElementById('patientid'+idx).value;
	var P_ENCOUNTER_ID = document.getElementById('enc_id'+idx).value;
	var P_LOGIN_USER = document.getElementById('User').value;
	var P_LANGUAGE_ID = document.getElementById('locale').value;
	var P_RESP_ID = document.getElementById('responsibility_id').value;
	var P_REQUEST_NUM = document.getElementById('req_no'+idx).value;
	var P_REQUEST_LINE_NUM = document.getElementById('REQUEST_LINE_NUM'+idx).value;
	var P_EXT_APPL_ACCESSION_NUM=	document.getElementById('ext_appl_accession'+idx).value;
	var indicator=	document.getElementById('indicator'+idx).value;
	var rep_type="";	
	
	
	var params="P_FACILITY_ID="+P_FACILITY_ID+"&P_PATIENT_ID="+P_PATIENT_ID+"&P_ENCOUNTER_ID="+P_ENCOUNTER_ID+"&P_LOGIN_USER="+P_LOGIN_USER+"&P_LANGUAGE_ID="+P_LANGUAGE_ID+"&P_RESP_ID="+P_RESP_ID+"&P_REQUEST_NUM="+P_REQUEST_NUM+"&P_REQUEST_LINE_NUM="+P_REQUEST_LINE_NUM+"&P_EXT_APPL_ACCESSION_NUM="+P_EXT_APPL_ACCESSION_NUM+"&indicator="+indicator;
	
	
	$.ajax({
		type:"GET",
		url:"../jsp/RadiologyExamAjax.jsp?functionMode=CN_validation",
		data:params,
		dataType:"json",
		async:false,
		success: function(data){
			rep_type=data.type;
			if(rep_type!=""){
				
				parent.RadiologyExamSubmit.submit_form.document.getElementById('type').value=rep_type;
				parent.RadiologyExamSubmit.submit_form.document.getElementById('typeN').value=rep_type;//V221006
				parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('checkUpdate').value="Y";
			}
		},
		 error: function(data){
			 alert(data)
	      }
		});
		
		if(rep_type=="M"){
			var P_REP_TYPE_FROM=parent.RadiologyExamSubmit.submit_form.document.getElementById('report_from').value;
			var P_REP_TYPE_TO=parent.RadiologyExamSubmit.submit_form.document.getElementById('type').value; //New Change
			var valid="";	
			if(P_REP_TYPE_TO=="" || P_REP_TYPE_TO==null || P_REP_TYPE_TO=="null"){
				parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('checkUpdate').value="N";
				return false;
			}
			params+="&P_REP_TYPE_FROM="+P_REP_TYPE_FROM+"&P_REP_TYPE_TO="+P_REP_TYPE_TO+"&called=CN";
			
			if(parent.RadiologyExamSubmit.submit_form.document.getElementById('mod_date').value!="" && parent.RadiologyExamSubmit.submit_form.document.getElementById('mod_date').value!=undefined){
					params+="&mod_date="+parent.RadiologyExamSubmit.submit_form.document.getElementById('mod_date').value;
				}
			
			var type='';
			var error='';
			$.ajax({
				type:"GET",
				url:"../jsp/RadiologyExamAjax.jsp?functionMode=StatusValidation",
				data:params,
				dataType:"json",
				async:false,
				success: function(data){
					//alert(data);
					var n=trimString(data.valid);
					var lcl = n.split('~');
					type=lcl[0];
					error=lcl[1] ; 
					
					if(error!=''){
						alert(error);
						//return false;
					}
					if(type!=''){
						parent.RadiologyExamSubmit.submit_form.document.getElementById('type').value=type;
					}
					
			},
		 error: function(data){
			 alert(data)
	      }
		});
		
		if(error=='' || error==null){
			parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('checkUpdate').value="Y";
			parent.RadiologyExamSubmit.submit_form.document.getElementById('type').disabled=false;
			parent.RadiologyExamSubmit.submit_form.document.getElementById('submitbtn').disabled=false;
		}//V220407
		else if(error=="Report text cannot be null"){
			parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('checkUpdate').value="M";
			parent.RadiologyExamSubmit.submit_form.document.getElementById('type').disabled=false;
			parent.RadiologyExamSubmit.submit_form.document.getElementById('submitbtn').disabled=false;
		}//V220407
		else{
			parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('checkUpdate').value="N";
			parent.RadiologyExamSubmit.submit_form.document.getElementById('type').disabled=true;
			parent.RadiologyExamSubmit.submit_form.document.getElementById('submitbtn').disabled=true;
		 }
		}
	}else{
		
	}
}
//V220720
function showNote(idx){
	var status = document.getElementById('status'+idx).value;
	var indicator=document.getElementById('indicator'+idx).value;
	var val=populateDate(idx,status); 
	if(val==true || val=='true'){
		var note=clinicalNotes(idx,indicator);
		if(note==true || note=='true'){
			populateStatus(idx);
		}
	}
}
//V220720
//Result indicator click function
function clinicalNotes(idx,ind){
	parent.RadiologyExamSubmit.submit_form.document.getElementById('submitbtn').disabled=false;
	parent.RadiologyExamSubmit.submit_form.document.getElementById('type').disabled=false;
	var notetype=document.getElementById('note_type'+idx).value;
	var P_FACILITY_ID = document.getElementById('operating_facility_id'+idx).value;
	var order_fac_id = parent.RadiologyExamSearchHdr.document.forms[0].ordering_facility_name.value; //V220209
	var P_PATIENT_ID = document.getElementById('patientid'+idx).value;
	var P_ENCOUNTER_ID = document.getElementById('enc_id'+idx).value;
	var P_LOGIN_USER = document.getElementById('User').value;
	var P_LANGUAGE_ID = document.getElementById('locale').value;
	var P_RESP_ID = document.getElementById('responsibility_id').value;
	var P_REQUEST_NUM = document.getElementById('req_no'+idx).value;
	var P_REQUEST_LINE_NUM = document.getElementById('REQUEST_LINE_NUM'+idx).value;
	var orderid = document.getElementById('orderid'+idx).value;
	var radiologist = document.getElementById('radiologist'+idx).value;
	var order_line_num = document.getElementById('order_line_num'+idx).value;
	var P_EXT_APPL_ACCESSION_NUM=	document.getElementById('ext_appl_accession'+idx).value;
	var ret_url="";	
	var params="P_FACILITY_ID="+P_FACILITY_ID+"&P_PATIENT_ID="+P_PATIENT_ID+"&P_ENCOUNTER_ID="+P_ENCOUNTER_ID+"&orderid="+orderid+"&order_line_num="+order_line_num+"&P_LOGIN_USER="+P_LOGIN_USER+"&P_LANGUAGE_ID="+P_LANGUAGE_ID+"&P_RESP_ID="+P_RESP_ID+"&P_REQUEST_NUM="+P_REQUEST_NUM+"&P_REQUEST_LINE_NUM="+P_REQUEST_LINE_NUM+"&P_EXT_APPL_ACCESSION_NUM="+P_EXT_APPL_ACCESSION_NUM+"&indicator="+ind+"&called=CN"+"&radiologist="+radiologist+"&order_fac_id="+order_fac_id; //V220209
	var error='';//V220720
	if(notetype=="null" || notetype==null || notetype==''){
		var dialogUrl1 = "../jsp/ResIndClinicNotes.jsp?index="+idx+"&"+params;
		var dialogArguments = "";
		var dialogFeatures = "dialogHeight:50;dialogWidth:70;status:no;scroll:yes"; //V220214
		var urlRet = window.showModalDialog(dialogUrl1,dialogArguments,dialogFeatures);
		if(urlRet != null){
			if(urlRet=="Y"){
				document.getElementById('checkUpdate').value="Y";
			}
		}
		if(urlRet == undefined){
			urlRet = dialogArguments;
		}
		document.getElementById('CA_Validation').value="Y";
		return true;
	}else{
		$.ajax({
			type:"GET",
			url:"../jsp/RadiologyExamAjax.jsp?functionMode=retrive_url",
			data:params,
			dataType:"json",
			async:false,
			success: function(data){
				ret_url=data.retrived_url;
			},
			 error: function(data){
				 error="error in retriving url";  //V220720
				 alert(data)
			  }
		});
		//callCApage(ret_url);  //V220720
		//document.getElementById('CA_Validation').value="Y";
		 //V220720
		if(error=='' || error==null){
			document.getElementById('CA_Validation').value="Y";
			return callCApage(ret_url);
		}else{
			return false;
		}
		 //V220720
	}
}

//insert clinic notes
function insertNotes(idx){
	var clinicnote = document.getElementById('clinComm1').value;
	var prevComm = document.getElementById('retrivedtext').value;
	document.getElementById('updatedText').value=clinicnote;
	//alert("clinicnote-"+clinicnote);
	var rep_type="";
	if(clinicnote==null || clinicnote=="null" || clinicnote==""){
		alert("Report text cannot be null");
		return false;
	}else{
		if(prevComm != clinicnote){
		update="Y";
		var v_facility_id=document.getElementById('operating_facility_id'+idx).value;
		var v_request_num=document.getElementById('req_no'+idx).value;
		var v_request_line_num=document.getElementById('REQUEST_LINE_NUM'+idx).value;
		var radiologist=document.getElementById('radiologist'+idx).value;
		var indicator=document.getElementById('indicator'+idx).value;
		var upd_cmt="";	
		var params="&P_FACILITY_ID="+v_facility_id+"&P_REQUEST_NUM="+v_request_num+"&P_REQUEST_LINE_NUM="+v_request_line_num+"&clinicnote="+clinicnote+"&radiologist="+radiologist+"&indicator="+indicator;
		
		document.forms[0].target='messageFrame';
		document.forms[0].action="../../servlet/eRD.RadiologyExamServlet?mode=updRepText"+params;
		document.forms[0].submit();		
		window.returnValue="Y";
		window.close();
		}else{
			window.close();
		}
		
	}	
	
}

function typeChange(e){
	document.getElementById('report_to').value=e.value;
	document.getElementById('type').value=e.value; //New Change
	var P_REP_TYPE_TO="";
	var idx =parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('idx').value;
	if(idx=="" || idx==null || idx=="null"){
		alert(getMessage('RD0002', 'RD'));
		parent.RadiologyExamSubmit.submit_form.document.getElementById('type').value="sel";
		return false;
	}else{
		if(parent.RadiologyExamSubmit.submit_form.document.getElementById('typeN').value=='F'){
			if(parent.RadiologyExamSubmit.submit_form.document.getElementById('type').value!='sel'){
				P_REP_TYPE_TO=parent.RadiologyExamSubmit.submit_form.document.getElementById('type').value; //New Change
			}else{ 
				alert(getMessage('RD0004', 'RD'));
				return false;
			}
		}else{
			P_REP_TYPE_TO=parent.RadiologyExamSubmit.submit_form.document.getElementById('type').value; 
		}
		
	}//V221006

	var P_FACILITY_ID = parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('operating_facility_id'+idx).value;
	var P_PATIENT_ID = parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('patientid'+idx).value;
	var P_ENCOUNTER_ID = parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('enc_id'+idx).value;
	var P_LOGIN_USER = parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('User').value;
	var P_LANGUAGE_ID = parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('locale').value;
	var P_RESP_ID = parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('responsibility_id').value;
	var P_REQUEST_NUM = parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('req_no'+idx).value;
	var P_REQUEST_LINE_NUM = parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('REQUEST_LINE_NUM'+idx).value;
	var P_EXT_APPL_ACCESSION_NUM=	parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('ext_appl_accession'+idx).value;
	var indicator=	parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('indicator'+idx).value;
	var P_REP_TYPE_FROM=parent.RadiologyExamSubmit.submit_form.document.getElementById('report_from').value;
	//var P_REP_TYPE_TO=parent.RadiologyExamSubmit.submit_form.document.getElementById('type').value; //New Changev
	//alert("P_REP_TYPE_TO-"+P_REP_TYPE_TO+"---");
	if(P_REP_TYPE_TO=="" || P_REP_TYPE_TO==null || P_REP_TYPE_TO=="null"){
		parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('checkUpdate').value="N";
		// parent.RadiologyExamSearchHdr.document.forms[0].Search.disabled=false;//28647  //V220214
		return false;
	}
	
	var valid="N";	
	var params="&P_FACILITY_ID="+P_FACILITY_ID+"&P_PATIENT_ID="+P_PATIENT_ID+"&P_ENCOUNTER_ID="+P_ENCOUNTER_ID+"&P_LOGIN_USER="+P_LOGIN_USER+"&P_LANGUAGE_ID="+P_LANGUAGE_ID+"&P_RESP_ID="+P_RESP_ID+"&P_REQUEST_NUM="+P_REQUEST_NUM+"&P_REQUEST_LINE_NUM="+P_REQUEST_LINE_NUM+"&P_REP_TYPE_FROM="+P_REP_TYPE_FROM+"&P_REP_TYPE_TO="+P_REP_TYPE_TO+"&called=CN";

	var type='';
	var error='';
	$.ajax({
		type:"GET",
		url:"../jsp/RadiologyExamAjax.jsp?functionMode=StatusValidation",
		data:params,
		dataType:"json",
		async:false,
		success: function(data){
			//alert(data);
			var n=trimString(data.valid);
			var lcl = n.split('~');
			type=lcl[0];
			error=lcl[1] ; 
			
			if(error!=''){
				alert(error);
				//return false;
			}
			if(type!=''){
				parent.RadiologyExamSubmit.submit_form.document.getElementById('type').value=type;
			}
			
	},
		 error: function(data){
			 alert(data)
	      }
	});
	
	if(error=='' || error==null){
		parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('checkUpdate').value="Y";
		//parent.RadiologyExamSearchHdr.document.forms[0].Search.disabled=true;//28647  //V220214
	}else{
		parent.RadiologyExamSearchValues.RadiologyExamResultForm.document.getElementById('checkUpdate').value="N";
	}
	
}
	
function onSuccess() {
  
}

//Request clinical comments click function
function reqClinicalComm(idx){
	var P_FACILITY_ID = document.getElementById('operating_facility_id'+idx).value;
	var P_PATIENT_ID = document.getElementById('patientid'+idx).value;
	var P_ENCOUNTER_ID = document.getElementById('enc_id'+idx).value;
	var P_LOGIN_USER = document.getElementById('User').value;
	var P_LANGUAGE_ID = document.getElementById('locale').value;
	var P_RESP_ID = document.getElementById('responsibility_id').value;
	var P_REQUEST_NUM = document.getElementById('req_no'+idx).value;
	var P_REQUEST_LINE_NUM = document.getElementById('REQUEST_LINE_NUM'+idx).value;
	var orderid = document.getElementById('orderid'+idx).value;
	var order_line_num = document.getElementById('order_line_num'+idx).value;
	var P_EXT_APPL_ACCESSION_NUM=	document.getElementById('ext_appl_accession'+idx).value;
	
	var params="&P_FACILITY_ID="+P_FACILITY_ID+"&orderid="+orderid+"&order_line_num="+order_line_num+"&P_LOGIN_USER="+P_LOGIN_USER+"&P_LANGUAGE_ID="+P_LANGUAGE_ID+"&P_RESP_ID="+P_RESP_ID+"&P_REQUEST_NUM="+P_REQUEST_NUM+"&P_REQUEST_LINE_NUM="+P_REQUEST_LINE_NUM+"&P_EXT_APPL_ACCESSION_NUM="+P_EXT_APPL_ACCESSION_NUM;
	
	var dialogUrl1 = "../jsp/RequestClinicalComment.jsp?index="+idx+params;
    var dialogArguments = "";
    var dialogFeatures = "dialogHeight:45;dialogWidth:40;status:no;scroll:yes"; //V220214
	urlRet = window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
	
	if(urlRet != null){
    	url = urlRet;
     }
    if(urlRet == undefined){
    	urlRet = dialogArguments;
    }
}
   
//Request clinical comments click function
function techComments(idx){
	var P_FACILITY_ID = document.getElementById('operating_facility_id'+idx).value;
	var P_PATIENT_ID = document.getElementById('patientid'+idx).value;
	var P_ENCOUNTER_ID = document.getElementById('enc_id'+idx).value;
	var P_LOGIN_USER = document.getElementById('User').value;
	var P_LANGUAGE_ID = document.getElementById('locale').value;
	var P_RESP_ID = document.getElementById('responsibility_id').value;
	var P_REQUEST_NUM = document.getElementById('req_no'+idx).value;
	var P_REQUEST_LINE_NUM = document.getElementById('REQUEST_LINE_NUM'+idx).value;
	var orderid = document.getElementById('orderid'+idx).value;
	var order_line_num = document.getElementById('order_line_num'+idx).value;
	var P_EXT_APPL_ACCESSION_NUM=	document.getElementById('ext_appl_accession'+idx).value;
	
	var params="P_FACILITY_ID="+P_FACILITY_ID+"&orderid="+orderid+"&order_line_num="+order_line_num+"&P_LOGIN_USER="+P_LOGIN_USER+"&P_LANGUAGE_ID="+P_LANGUAGE_ID+"&P_RESP_ID="+P_RESP_ID+"&P_REQUEST_NUM="+P_REQUEST_NUM+"&P_REQUEST_LINE_NUM="+P_REQUEST_LINE_NUM+"&P_EXT_APPL_ACCESSION_NUM="+P_EXT_APPL_ACCESSION_NUM;
	
	var dialogUrl1 = "../jsp/TechnologistComments.jsp?"+params; //28661
    var dialogArguments = "";
    var dialogFeatures = "dialogHeight:25;dialogWidth:35;status:no;scroll:yes"; //20,30 //V220214
	urlRet = window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
	if(urlRet != null){
    	url = urlRet;
    }
    if(urlRet == undefined){
    	urlRet = dialogArguments;
    }
   }


function refFunc(idx,called){
	var order_fac_id = parent.RadiologyExamSearchHdr.document.forms[0].ordering_facility_name.value; //V220209
	var P_FACILITY_ID = document.getElementById('operating_facility_id'+idx).value;
	var P_PATIENT_ID = document.getElementById('patientid'+idx).value;
	var P_ENCOUNTER_ID = document.getElementById('enc_id'+idx).value;
	var P_LOGIN_USER = document.getElementById('User').value;
	var P_LANGUAGE_ID = document.getElementById('locale').value;
	var P_RESP_ID = document.getElementById('responsibility_id').value;
	var P_REQUEST_NUM = document.getElementById('req_no'+idx).value;
	var P_REQUEST_LINE_NUM = document.getElementById('REQUEST_LINE_NUM'+idx).value;
	var P_EXT_APPL_ACCESSION_NUM=	document.getElementById('ext_appl_accession'+idx).value;
	var P_URL_TYPE="";	
	var ret_url="";	
	
	if(called==1){
		P_URL_TYPE='I';
	}else if(called==2){
		P_URL_TYPE='H';
	}
	
	var params="P_FACILITY_ID="+P_FACILITY_ID+"&P_PATIENT_ID="+P_PATIENT_ID+"&P_ENCOUNTER_ID="+P_ENCOUNTER_ID+"&P_LOGIN_USER="+P_LOGIN_USER+"&P_LANGUAGE_ID="+P_LANGUAGE_ID+"&P_RESP_ID="+P_RESP_ID+"&P_REQUEST_NUM="+P_REQUEST_NUM+"&P_REQUEST_LINE_NUM="+P_REQUEST_LINE_NUM+"&P_URL_TYPE="+P_URL_TYPE+"&P_EXT_APPL_ACCESSION_NUM="+P_EXT_APPL_ACCESSION_NUM+"&order_fac_id="+order_fac_id; //V220209
	
	$.ajax({
		type:"GET",
		url:"../jsp/RadiologyExamAjax.jsp?functionMode=retrive_url",
		data:params,
		dataType:"json",
		async:false,
		success: function(data){
			ret_url=data.retrived_url;
		},
		 error: function(data){
			 alert(data)
	      }
	});
	if(called==1){
		dialogUrl1=ret_url;
		var dialogArguments = comment;
		var dialogFeatures = "dialogHeight:120;dialogWidth:240;status:no;scroll:yes";
		urlRet = window.open(dialogUrl1, dialogArguments,dialogFeatures);
		//alert("urlRet-"+urlRet);
		if(urlRet != null){
			url = urlRet;
		}
		if(urlRet == undefined){
			urlRet = dialogArguments;
		}
	}
	else{
		callCApage(ret_url);
	}
	
}

function callCApage(ret_url){
	
	var dialogUrl1 = ret_url;
	var n=trimString(ret_url);
	var lcl = n.split('?');
	var qrystrg=lcl[1]; 
	var ret_url1="";
	var error='';//V220720
	$.ajax({
		type:"GET",
		url:"../jsp/RadiologyExamAjax.jsp?functionMode=patienthistory",
		data:qrystrg,
		dataType:"json",
		async:false,
		success: function(data){
			ret_url1=data.retrived_url;
		},
		 error: function(data){
			 error="error in patienthistory url retrival";
			 alert(data)
	      }
	});
	if(error=='' || error==null){ //V220720
		//dialogUrl1="../../eCA/jsp/InvokePatientHistory.jsp?"+ret_url1+",'eHIS','location=0,height=700,width=1015,top=0,left=0,resizable=yes'";
		dialogUrl1="../../eCA/jsp/InvokePatientHistory.jsp?"+ret_url1;
			
		var dialogArguments = 'eHIS';
		var dialogFeatures = "dialogHeight:120;dialogWidth:240;status:no;scroll:yes";
		urlRet = window.showModalDialog(dialogUrl1, dialogArguments,dialogFeatures);
		if(urlRet != null){
			url = urlRet;
		}
		if(urlRet == undefined){
			urlRet = dialogArguments;
		}
		return true;
	}else{
		return false;
	}
	//V220720
}

 //To get prev modified date of note //V220328 Starts
function populateDate(indx,indc){
		var P_FACILITY_ID = document.getElementById('operating_facility_id'+indx).value;
		var P_REQUEST_NUM = document.getElementById('req_no'+indx).value;
		var P_REQUEST_LINE_NUM = document.getElementById('REQUEST_LINE_NUM'+indx).value;
		var rep_type="";	
		var error='';//V220720
		var params="P_FACILITY_ID="+P_FACILITY_ID+"&P_REQUEST_NUM="+P_REQUEST_NUM+"&P_REQUEST_LINE_NUM="+P_REQUEST_LINE_NUM;
		if(indc=="Reported-Final" || indc=="Report Modified"  ){
			var date='';
			$.ajax({
				type:"GET",
				url:"../jsp/RadiologyExamAjax.jsp?functionMode=modified_date",
				data:params,
				dataType:"json",
				async:false,
				success: function(data){
					date=trimString(data.mod_date);
					if(date!=''){
						parent.RadiologyExamSubmit.submit_form.document.getElementById('mod_date').value=date;
					}
			},
		 error: function(data){
			 error="error while retriving date"; //V220720
			 alert(data)
	      }
		});
		//V220720
		if(error=='' || error==null)
			return true;
		else
			return false;
		//V220720
	}else{
		return true;
	}
}//V220328 ends
    
