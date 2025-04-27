var radioval    = "" ;
var a="";
var reloadYN="N"; //44856
var data=""; //44856

function reset(){	
	BLApprStatusTrackQueryFrame.location.reload();
}

async function enCounterIdLookup()
	{
		//alert("3");
		var fieldLegend;
		fieldLegend = new Array() ;
		fieldLegend["CODE_LEGEND"] = "EncounterId"
		fieldLegend["DESC_LEGEND"] = "EpisodeId"
		var episodeType = document.getElementById("episode_type").value;
		//var episodeType;
		var partsql = '';
		/*if(e == "Inpatient")
		{
		episodeType = "I";
		}*/
		if(episodeType=='O' || episodeType =='E'){ //V230518-AAKH-CRF-0152
			partsql = "SELECT EPISODE_ID DESCRIPTION, ENCOUNTER_ID CODE FROM bl_visit_fin_dtls WHERE upper(EPISODE_ID) like upper(?) and upper(ENCOUNTER_ID) like upper(?) AND OPERATING_FACILITY_ID = ";
		}else{
			partsql = "SELECT EPISODE_ID DESCRIPTION, ENCOUNTER_ID CODE FROM bl_episode_fin_dtls WHERE upper(EPISODE_ID) like upper(?) and upper(ENCOUNTER_ID) like upper(?) AND OPERATING_FACILITY_ID = ";
		}
		var sql;
		sql											=	partsql+" '" +document.forms[0].facility_id.value+"'";
		var title									= 	getLabel("Common.encounterid.label", 'common');
		var argumentArray  							= 	new Array() ;
		var dataNameArray  							= 	new Array() ;
		var dataValueArray 							= 	new Array() ;
		var dataTypeArray  							= 	new Array() ;
		var patientId								=	document.getElementById('patient_id'); 
		if(patientId.value != undefined && patientId.value != null && patientId.value != '')
		{
			sql										=	sql+" AND PATIENT_ID ="+" '"+patientId.value+"'";
		}
		if(episodeType != undefined && episodeType != null && episodeType != '')
		{
			if(episodeType != 'A')
				sql										=	sql+" AND EPISODE_TYPE ="+" '"+episodeType+"'";
		}
		var encounterId								=	document.getElementById('encounter_id');
		argumentArray[0]							= 	sql;
		argumentArray[1]   							= 	dataNameArray ;
		argumentArray[2]   							= 	dataValueArray ;
		argumentArray[3]   							= 	dataTypeArray ;
		argumentArray[4]   							= 	"1,2";
		argumentArray[5]   							= 	encounterId.value;
		argumentArray[6]   							= 	DESC_LINK ;
		argumentArray[7]   							= 	CODE_DESC;
		retVal 										= await  CommonLookup(title, argumentArray);
		if(retVal != null && retVal != "")
		{
			encounterId.value 						= 	retVal[0];
		}
		else
		{
			encounterId.value			  			=	"";
			
		}
	 
	    
	}

async function PatientIdLookup()
{	
	var pat_id=await PatientSearch();		
	if( pat_id != null )						
	document.getElementById('patient_id').value = pat_id ;
	if(pat_id!=undefined && pat_id!='')
	{
		LoadPatientName(pat_id);
		ChangeUpperCase(document.getElementById('patient_name'));
	}
}

function primaryPatValidation(obj)
{
	var patient_id=obj.value;	
	if(patient_id!=""){
		var function_id = "PAT_CHK";
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "patient_id=\"" + patient_id + "\" " ;					
		xmlStr +=" /></root>";
		var temp_jsp="PkgSubscriptionValidation.jsp?func_mode=CHK_PAT_ID&function_id="+function_id;					
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml"); 
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		var responseText=trimString(xmlHttp.responseText);		
		if(responseText=="N")
		{
			alert(getMessage("INVALID_PATIENT","MP"));
			obj.select();
		}else if(responseText=="Y"){
			LoadPatientName(patient_id);
		}
	}
}

function LoadPatientName(pat_id)
{
	var out;
	var response;
	var xmlhttp;    
	if (window.XMLHttpRequest) 
	{// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}
	else
	{// code for IE6, IE5
		//xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		 xmlHttp = new XMLHttpRequest();
	}
		xmlhttp.onreadystatechange=function()
	{
	if (xmlhttp.readyState==4 && xmlhttp.status==200)
	{
		out = xmlhttp.responseText;
		var showdata = out.substring(out.indexOf("!")+1,out.length);
		response=showdata.split(":");
		var actual;
		//alert(response);
	for(var i=0;i<response.length;i++)
	{
		document.getElementById("patient_name").value = response[i];
	}
		ChangeUpperCase(document.getElementById('patient_name'));
	}
	}
		xmlhttp.open("POST","../../eBL/jsp/BillingRecordApprovalGetPatienName.jsp?patientId="+pat_id,true);
		xmlhttp.send(null);
}	
 
async function payerGroupLookup()
	{
		var sql;
		var facility_id = document.forms[0].facility_id.value;
		var locale = document.forms[0].locale.value;
		sql="select description,code from (select long_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and "+
			"cust_group_code in (Select Distinct Cust_Group_Code From Bl_Cust_By_Cust_Group Where Cust_Code In (Select Cust_Code From Ar_Customer_Lang_Vw "+
			"where acc_entity_code  in (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') "+
			"and nvl(patient_flag,'N')  ='Y' And Nvl(Insurance_Yn, 'N') = 'Y' )) "+
			"And Acc_Entity_Code In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"')) where upper(description) like upper(?) and upper(code) like upper(?) "+
			" order by 2";
		var title									= 	getLabel("eBL.PAYER_GROUP.label", 'bl');
		var argumentArray  							= 	new Array() ;
		var dataNameArray  							= 	new Array() ;
		var dataValueArray 							= 	new Array() ;
		var dataTypeArray  							= 	new Array() ;
		var payerGroup								=	document.getElementById('payer_group'); 
	    argumentArray[0]							= 	sql;
		argumentArray[1]   							= 	dataNameArray ;
		argumentArray[2]   							= 	dataValueArray ;
		argumentArray[3]   							= 	dataTypeArray ;
		argumentArray[4]   							= 	"2,1";
		argumentArray[5]   							= 	payerGroup.value;
		argumentArray[6]   							= 	DESC_LINK ;
		argumentArray[7]   							= 	CODE_DESC;
		retVal 										= await  CommonLookup( title, argumentArray );
		if(retVal != null && retVal != "")
		{
			payerGroup.value 						= 	retVal[0];
		}
		else
		{
			payerGroup.value			  			=	"";
			
		}
	 
	    
	}
	
async	function payerLookup()
	{
		var sql;
		var facility_id = document.forms[0].facility_id.value;
		var locale = document.forms[0].locale.value;
		var cust_code = document.forms[0].payer_group.value;
		if(cust_code == "") cust_code = "**";
		sql = "Select description,code from (Select long_name description,cust_code code from ar_customer_lang_vw "+
					"Where Cust_Code In ( SELECT cust_code "+
                    "FROM bl_cust_by_cust_group "+
                    "WHERE cust_group_code = DECODE ('" + cust_code + "', '**', cust_group_code, '" + cust_code + "'))"+
					"and acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') "+
					"and nvl(patient_flag,'N')  ='Y' "+
					"and nvl(pat_com_flag,'N')='N' "+
					"And Nvl(Insurance_Yn, 'N') = 'Y' And Status Is Null "+
					"and upper(language_id) = upper('"+locale+"')) where upper(description) like upper(?) and upper(code) like upper(?) ";

		var title									= 	getLabel("Common.Payer.label", 'common');
		var argumentArray  							= 	new Array() ;
		var dataNameArray  							= 	new Array() ;
		var dataValueArray 							= 	new Array() ;
		var dataTypeArray  							= 	new Array() ;
		var payer									=	document.getElementById('payer'); 
	    argumentArray[0]							= 	sql;
		argumentArray[1]   							= 	dataNameArray ;
		argumentArray[2]   							= 	dataValueArray ;
		argumentArray[3]   							= 	dataTypeArray ;
		argumentArray[4]   							= 	"2,1"; 
		argumentArray[5]   							= 	payer.value;
		argumentArray[6]   							= 	DESC_LINK ;
		argumentArray[7]   							= 	CODE_DESC;
		retVal 										= await  CommonLookup( title, argumentArray );
		if(retVal != null && retVal != "")
		{
			payer.value 							= 	retVal[0];
		}
		else
		{
			payer.value			  					=	"";
			
		}
	 
	    
	}
	
		
	
async	function policyLookup()
	{
		var sql;
		var facility_id = document.forms[0].facility_id.value;
		var locale = document.forms[0].locale.value;
		sql="select long_desc description,policy_type_code code from bl_ins_policy_types_lang_vw where nvl(status,'A') !='S' and operating_facility_id = '"+facility_id+"' and upper(language_id) = upper('"+locale+"') and upper(long_desc) like upper(?) and upper(policy_type_code) like upper(?) order by 2";
		var title									= 	getLabel("eBL.POLICY.label", 'bl');
		var argumentArray  							= 	new Array() ;
		var dataNameArray  							= 	new Array() ;
		var dataValueArray 							= 	new Array() ;
		var dataTypeArray  							= 	new Array() ;
		var policy									=	document.getElementById('policy'); 
	    argumentArray[0]							= 	sql;
		argumentArray[1]   							= 	dataNameArray ;
		argumentArray[2]   							= 	dataValueArray ;
		argumentArray[3]   							= 	dataTypeArray ;
		argumentArray[4]   							= 	"2,1"; 
		argumentArray[5]   							= 	policy.value;
		argumentArray[6]   							= 	DESC_LINK ;
		argumentArray[7]   							= 	CODE_DESC;
		retVal 										= await  CommonLookup( title, argumentArray );
		if(retVal != null && retVal != "")
		{
			policy.value 							= 	retVal[0];
		}
		else
		{
			policy.value			  					=	"";
			
		}
	 
	    
	}

function patLookup()
{
var locale = document.getElementById("locale").value;
	var user = document.getElementById("user").value;
	var strclientip = document.getElementById("strclientip").value;
	var customerCode = document.getElementById("customerCode").value;
	var facility_id = document.getElementById("facility_id").value;
	var val = document.getElementById("val").value;
	var service_code = document.getElementById("service_description").value;
	var patient_id = document.getElementById("patient_id").value;
	var encounter_id = document.getElementById("encounter_id").value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql 		   = '';
	var title 		   = '';
	
    sql = "Select code , description from (SELECT DISTINCT a.patient_id code, DECODE ('"+locale+"', 'en', b.patient_name, NVL (b.patient_name_loc_lang, b.patient_name) ) description FROM bl_ins_dash_serv_data_temp a, mp_patient b WHERE a.operating_facility_id = '"+facility_id+"' AND a.patient_id = b.patient_id AND a.processid = '"+user+"' AND a.machine_id = '"+strclientip+"' AND a.cust_code = '"+customerCode+"' AND ins_status = '"+val+"' AND a.blng_serv_name = NVL ('"+service_code+"', a.blng_serv_name)  AND a.patient_id = NVL ('"+patient_id+"', a.patient_id) AND a.episode_id = NVL ('"+encounter_id+"', a.episode_id)) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";	
	title = 'Patient ID';
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = document.forms[0].patient_id.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retval = CommonLookup(title, argumentArray );
	if((retval != null) && (retval != "") )  {
		document.forms[0].patient_id.value = retval[0];
	}
	else
	{
	document.forms[0].patient_id.value = '';
	}

		
}
function encLookup()
{
	var locale = document.getElementById("locale").value;
	var user = document.getElementById("user").value;
	var strclientip = document.getElementById("strclientip").value;
	var customerCode = document.getElementById("customerCode").value;
	var facility_id = document.getElementById("facility_id").value;
	var val = document.getElementById("val").value;
	var service_code = document.getElementById("service_description").value;
	var patient_id = document.getElementById("patient_id").value;
	var encounter_id = document.getElementById("encounter_id").value;
	var sql 		   = '';
	var title 		   = '';
	title = encodeURIComponent(getLabel("Common.encounterid.label","common"));
	var qryParam = '&user='+user+'&strclientip='+strclientip+'&customerCode='+customerCode+'&locale='+locale+'&facility_id='+facility_id+'&val='+val+'&patient_id='+patient_id+'&encounter_id='+encounter_id+'&service_code='+encodeURIComponent(service_code);
	var retVal				= new String();
	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var message				="";
	var column_sizes = escape("10%");
	var column_descriptions = 'Encounter ID';	
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&col_show_hide=Y"+qryParam+"&"+"&target="+encounter_id;
	var  retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?called_for=enc_id_query&"+param,arguments,features);
	
	if (retVal != null && retVal!="" && retVal!="undefined" )
	 {
		  retVal=unescape(retVal);
		  var arr=retVal.split("^~^");
		  document.forms[0].encounter_id.value = arr[0];
	 }
   else
	{
	document.forms[0].encounter_id.value = '';
	}
	return retVal;
	

}
async function serviceCodeLookUp(){
	var locale = document.getElementById("locale").value;
	var user = document.getElementById("user").value;
	var strclientip = document.getElementById("strclientip").value;
	var customerCode = document.getElementById("customerCode").value;
	var facility_id = document.getElementById("facility_id").value;
	var val = document.getElementById("val").value;
	var service_code = "";
	var patient_id = document.forms[0].patient_id.value;
	var encounter_id = document.forms[0].encounter_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql 		   = '';
	var title 		   = '';
    sql = "Select code , description from (SELECT DISTINCT a.blng_serv_code code,a.blng_serv_name description FROM bl_ins_dash_serv_data_temp a, mp_patient b WHERE a.operating_facility_id = '"+facility_id+"' AND a.patient_id = b.patient_id AND a.processid = '"+user+"' AND a.machine_id = '"+strclientip+"' AND a.cust_code = '"+customerCode+"' AND ins_status = '"+val+"' AND a.patient_id = NVL ('"+patient_id+"', a.patient_id) AND a.episode_id = NVL ('"+encounter_id+"', a.episode_id)) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";	
	title = 'Billing Service';
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = document.forms[0].service_description.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	retval = await CommonLookup(title, argumentArray );
	if((retval != null) && (retval != "") )  {
		document.forms[0].service_description.value = retval[1];
		document.forms[0].service_code.value = retval[0];
	}
	else
	{
	document.forms[0].service_description.value = '';
	document.forms[0].service_code.value = '';
	}
}
	
function serviceCodeLookUpCode(){
	
	var locale = document.getElementById("locale").value;
	var user = document.getElementById("user").value;
	var strclientip = document.getElementById("strclientip").value;
	var customerCode = document.getElementById("customerCode").value;
	var facility_id = document.getElementById("facility_id").value;
	var val = document.getElementById("val").value;
	var service_code = "";
	var patient_id = document.forms[0].patient_id.value;
	var encounter_id = document.forms[0].encounter_id.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql 		   = '';
	var title 		   = '';
	sql = "Select code , description from (SELECT DISTINCT a.blng_serv_code code,a.blng_serv_name description FROM bl_ins_dash_serv_data_temp a, mp_patient b WHERE a.operating_facility_id = '"+facility_id+"' AND a.patient_id = b.patient_id AND a.processid = '"+user+"' AND a.machine_id = '"+strclientip+"' AND a.cust_code = '"+customerCode+"' AND ins_status = '"+val+"' AND a.patient_id = NVL ('"+patient_id+"', a.patient_id) AND a.episode_id = NVL ('"+encounter_id+"', a.episode_id)) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";	
	title = 'Billing Service';

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = document.forms[0].service_description.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;
	
	retval = CommonLookup(title, argumentArray );
	if((retval != null) && (retval != "") )  {
		document.forms[0].service_description.value = retval[1];
		document.forms[0].service_code.value = retval[0];
	}
else
	{
	document.forms[0].service_description.value = '';
	document.forms[0].service_code.value = '';
	}

}


function rightsTypeOnChange(){ 
 var rightsType = document.forms[0].rightsType.value;

		if(rightsType == 'I'){
			document.getElementById("epiType").selectedIndex="0";
			document.getElementById("epiType").options[0].disabled = false;
			document.getElementById("epiType").options[1].disabled = false;
			document.getElementById("epiType").options[2].disabled = false;
			document.getElementById("epiType").options[3].disabled = false;
			document.getElementById("epiType").options[4].disabled = false;
		}else if(rightsType == 'F'){ 
			document.getElementById("epiType").options[0].disabled = true;
			document.getElementById("epiType").options[3].disabled = true;
			document.getElementById("epiType").options[4].disabled = true;
			document.getElementById("epiType").selectedIndex="1";
			
		}
		else if(rightsType == 'S'){
			document.getElementById("epiType").selectedIndex="0";
			document.getElementById("epiType").options[0].disabled = false;
			document.getElementById("epiType").options[1].disabled = false;
			document.getElementById("epiType").options[2].disabled = false;
			document.getElementById("epiType").options[3].disabled = false;
			document.getElementById("epiType").options[4].disabled = false;
		}
		parent.frames[1].location.href = "../../eCommon/html/blank.html";
		parent.frames[2].location.href = "../../eCommon/html/blank.html";
}

function onSearch()
{ 
	var facility_id = parent.frames[0].search.document.getElementById('facility_id').value;
	var locale = parent.frames[0].search.document.getElementById('locale').value;
	var rightsType = parent.frames[0].search.document.getElementById('rightsType').value;
	var validFrontUser = parent.frames[0].search.document.getElementById('validFrontUser').value;
	var validInsUser = parent.frames[0].search.document.getElementById('validInsUser').value;
	var encounterFromDate =	parent.frames[0].search.document.getElementById('Effective_from').value;
	var encounterToDate	= parent.frames[0].search.document.getElementById('Effective_to').value;
	var encounterId	= parent.frames[0].search.document.getElementById('encounter_id').value;
	var patientId	= parent.frames[0].search.document.getElementById('patient_id').value;
	var episodeType	= parent.frames[0].search.document.getElementById('epiType').value;
	var payerGroup	= parent.frames[0].search.document.getElementById('payer_group').value;
	var payer	= parent.frames[0].search.document.getElementById('payer').value;
	var policy	= parent.frames[0].search.document.getElementById('policy').value;
	var refresh	= parent.frames[0].search.document.getElementById('refresh').value;
	var apprvSts_AAKHYN	= parent.frames[0].search.document.getElementById('apprvSts_AAKHYN').value;//V230425
	var PreAuthEclaimYN	= parent.frames[0].search.document.getElementById('PreAuthEclaimYN').value;//V230822
	
	var today = "";
	today = new Date(encounterToDate.split('/')[2],encounterToDate.split('/')[1]-1,encounterToDate.split('/')[0]);
	var date2 = "";
	date2 = new Date(encounterFromDate.split('/')[2],encounterFromDate.split('/')[1]-1,encounterFromDate.split('/')[0]);
	var timeDiff = Math.abs(today.getTime() - date2.getTime());
	var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24));
	diffDays = diffDays + 1;
	//V230425
	var dayRange;
	if(apprvSts_AAKHYN=="Y"){
		dayRange=30;
	}else if(PreAuthEclaimYN=="Y"){
		dayRange=31;
	}else{
		dayRange=7;
	}
	//alert(dayRange);
	
	if((rightsType == 'F' && validFrontUser == 'N') || (rightsType == 'I' && validInsUser == 'N'))
	{
			alert(getMessage('BL0963','BLEXT'));
			//alert("Privilege is not provided for the selected User Type");
			return;
	}

	if(rightsType == 'S')
	{
		alert(getMessage('BL0967','BLEXT'));
		//alert("User Type cannot be blank");
		return;
	}

	
	if((encounterFromDate==undefined || encounterFromDate=='') && (encounterToDate==undefined || encounterToDate==''))
	{
			alert(getMessage('BL0965','BLEXT'));
			//alert("Encounter From and To Date Should not be blank.");
			return;
	}
	else if(encounterFromDate==undefined || encounterFromDate=='')
	{
			alert(getMessage("BL0747","BL"));
			return;
	}
	else if(encounterToDate==undefined || encounterToDate=='')
	{
			alert(getMessage("BL0748","BL"));
			return;
	}
	else if(diffDays > dayRange)//V230425
	{
		if(apprvSts_AAKHYN=="Y"){
			alert(getMessage('BL0981','BLEXT'));
		}else if(PreAuthEclaimYN=="Y"){
			alert(getMessage('BL0939','BLEXT'));
		}else{
			alert(getMessage('BL0969','BLEXT'));
		}
		return;
		//alert("Date should not greater that 7 days");
	}
	else{
		parent.frames[0].search.document.getElementById('search_button').disabled=true; //49172
		parent.frames[0].search.document.getElementById('processMsg').style.visibility="visible"; //49172
		
		if(rightsType == 'F'){
			parent.frames[1].location.href = "../../eBL/jsp/BLApprStatusTrackSearchResult.jsp?facility_id="+facility_id+"&locale="+locale+"&rightsType="+rightsType+"&encounterFromDate="+encounterFromDate+"&encounterToDate="+encounterToDate+"&encounterId="+encounterId+"&patientId="+patientId+"&episodeType="+episodeType+"&payerGroup="+payerGroup+"&payer="+payer+"&policy="+policy;
			//parent.frames[0].search.document.getElementById('search_button').disabled=false; //49172
		if(refresh != ''){
			callForReload();}
		}else if(rightsType == 'I'){
			parent.frames[1].location.href = "../../eBL/jsp/BLApprStatusTrackSearchPayerResult.jsp?facility_id="+facility_id+"&locale="+locale+"&rightsType="+rightsType+"&encounterFromDate="+encounterFromDate+"&encounterToDate="+encounterToDate+"&encounterId="+encounterId+"&patientId="+patientId+"&episodeType="+episodeType+"&payerGroup="+payerGroup+"&payer="+payer+"&policy="+policy+"&apprvSts_AAKHYN="+apprvSts_AAKHYN+"&PreAuthEclaimYN="+PreAuthEclaimYN+"&loadSts="+reloadYN+data;//V230425-44856
			parent.frames[2].location.href = "../../eCommon/html/blank.html";
			parent.frames[3].location.href = "../../eCommon/html/blank.html";
			//parent.frames[0].search.document.getElementById('search_button').disabled=false; //49172
			
			if(refresh != ''){
				callForReload();
			}
		}
	}
}

function callForReload()
{
	var refresh	= parent.frames[0].search.document.getElementById('refresh').value;
	var reload_interval = refresh * 60 * 1000;
	var cur_time = new Date().getTime();
	var next_refr_time = new Date(cur_time + reload_interval).getTime();
    parent.frames[0].search.document.getElementById('next_refr_time').value = next_refr_time;
    a = setTimeout('reload();', reload_interval);
}

function reload(){
	var popup_opened_yn = parent.frames[0].search.document.getElementById('popup_opened_yn').value ;
	if(popup_opened_yn == "N"){
		resetForDfltSearch();
	}
}

function resetForDfltSearch(){
	onSearch();
}

function isValidDate(obj){
	if(obj.value!=""){
		var flag=true;
		var RE_NUM =  /^\/?\d+$/;
		var str_date = obj.value;
		var arr_date = str_date.split('/');
		if (arr_date.length != 3)
			return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);//flag=false;
		
		if(arr_date[0]!=null)
		{
		if (arr_date[0].length !=2 ) flag=false;
		}
		if(arr_date[1]!=null)
		{
		if (arr_date[1].length !=2 ) flag=false;
		}
		if(arr_date[2]!=null)
		{
		if (arr_date[2].length !=4 ) flag=false;
		}
		if (!arr_date[0]) flag=false;
		if (!RE_NUM.exec(arr_date[0])) flag=false;
		if (!arr_date[1]) flag=false;
		if (!RE_NUM.exec(arr_date[1])) flag=false;
		if (!arr_date[2]) flag=false;
		if (!RE_NUM.exec(arr_date[2])) flag=false;
		if (arr_date[2].length!=4) flag=false;
		var dt_date = new Date();
		dt_date.setDate(1);
		if (arr_date[1] < 1 || arr_date[1] > 12) flag=false;
		dt_date.setMonth(arr_date[1]-1);
		var dt_numdays = new Date(arr_date[2], arr_date[1], 0);
		dt_date.setDate(arr_date[0]);
		if (dt_date.getMonth() != (arr_date[1]-1)) flag=false;

		if (flag==false){
			return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		}
		else
		{
			dateCompare();
		}
		
	}
	else{
			dateCompare();
	}
	return true;
}

function cal_error (str_message,obj) {
	alert (str_message);
	obj.focus();
	obj.select();
	return false;
}

function dateCompare()
{
	var encounterFromDate =	document.getElementById("Effective_from").value;
	var encounterToDate	= document.getElementById("Effective_to").value;
	var locale = document.forms[0].locale.value;
	var today = "";
	today = new Date(encounterToDate.split('/')[2],encounterToDate.split('/')[1]-1,encounterToDate.split('/')[0]);
	var date2 = "";
	date2 = new Date(encounterFromDate.split('/')[2],encounterFromDate.split('/')[1]-1,encounterFromDate.split('/')[0]);
	var timeDiff = Math.abs(today.getTime() - date2.getTime());
	var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24));
	diffDays = diffDays + 1;
	var dayRange="";
	var apprvSts_AAKHYN	= document.getElementById("apprvSts_AAKHYN").value;
	var PreAuthEclaimYN	= parent.frames[0].search.document.getElementById('PreAuthEclaimYN').value;//V230822
	
	if(apprvSts_AAKHYN=="Y"){
		dayRange=30;
	}else if(PreAuthEclaimYN=="Y"){
		dayRange=31;
	}else{
		dayRange=7;
	}
	

	
	if(apprvSts_AAKHYN=="Y" || PreAuthEclaimYN=="Y"){
		
		if(encounterFromDate != '' && encounterToDate != ''){
		var starr = encounterFromDate.split("/");
		var enarr = encounterToDate.split("/");
		var startdt = new Date();
		var enddt = new Date();
		startdt.setFullYear(starr[2], starr[1]-1, starr[0]);
		enddt.setFullYear(enarr[2], enarr[1]-1, enarr[0]);
		if( (startdt > enddt) && (encounterFromDate!=getCurrentDate('DMY',locale) && isAfterNow(encounterFromDate,'DMY',locale)==true))
		{
				alert(getMessage('BL0964','BLEXT'));
				//alert("Encounter From Date should not be greater than To Date/Current Date");
				document.getElementById("Effective_from").value = '';
				return;
		}
		if(startdt > enddt)
		{
			alert(getMessage('BL0973','BLEXT'));
			//alert("Encounter To Date should not be lesser than Encounter From Date");
			document.getElementById("Effective_to").value = '';
			return;
		}
		
		}
	}else{
		if(encounterFromDate==undefined || encounterFromDate=='')
		{
				alert(getMessage("BL0747","BL"));
				return;
		}
		if(encounterToDate==undefined || encounterToDate=='')
		{
				alert(getMessage("BL0748","BL"));
				return;
		}
		if( (encounterFromDate > encounterToDate) && (encounterFromDate!=getCurrentDate('DMY',locale) && isAfterNow(encounterFromDate,'DMY',locale)==true))
		{
				alert(getMessage('BL0964','BLEXT'));
				//alert("Encounter From Date should not be greater than To Date/Current Date");
				document.getElementById("Effective_from").value = '';
				return;
		}
		if(encounterFromDate > encounterToDate)
		{
			alert(getMessage('BL0973','BLEXT'));
			//alert("Encounter To Date should not be lesser than Encounter From Date");
			document.getElementById("Effective_to").value = '';
			return;
		}
	}
	if(encounterToDate!= getCurrentDate('DMY',locale) && isAfterNow(encounterToDate,'DMY',locale)==true)
	{
			alert(getMessage('BL0966','BLEXT'));
			//alert("Encounter To Date should not be greater than the current system date.");
			document.getElementById("Effective_to").value = '';
			return;
	}
	if(diffDays > dayRange)
	{
		if(apprvSts_AAKHYN=="Y"){ 
			alert(getMessage('BL0981','BLEXT'));
		}else if(PreAuthEclaimYN=="Y"){
			alert(getMessage('BL0939','BLEXT'));
		}else{
			alert(getMessage('BL0969','BLEXT'));
			}
		return;
		//alert("Date should not greater that 7 days");
	}
	
	
}

async function onClickTile(obj)
{
	parent.frames[0].search.document.getElementById('popup_opened_yn').value = "Y"
	var facility_id	= document.getElementById("facility_id").value;
	var user	= document.getElementById("user").value;
	var strclientip	= document.getElementById("strclientip").value;
	var penCoder	= document.getElementById("penCoder").value;
	var penIns	= document.getElementById("penIns").value;
	var penDiscBill	= document.getElementById("penDiscBill").value;
	var penDisc	= document.getElementById("penDisc").value;
	var refresh	= parent.frames[0].search.document.getElementById('refresh').value;
	var tileValue	= obj.value;

	if((tileValue == 'CC' && penCoder == 0) || (tileValue == 'IC' && penIns == 0) || (tileValue == 'DB' &&  penDiscBill == 0) || (tileValue == 'DC' && penDisc == 0))
	{
		alert("No Records to Display.");
		return;
	}
	
	var	title = "";
	var dialogTop			= "70";
	var dialogHeight		= "10" ;
	var dialogWidth			= "70" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	if(tileValue == 'CC')
	{
	title = getLabel("eBL.PendCoder.label", "bl"); 
	}
	else if(tileValue == 'IC')
	{
	title = getLabel("eBL.PendIns.label", "bl");
	}
	if(tileValue == 'DB')
	{
	title = getLabel("eBL.PendDiscBill.label", "bl");
	}
	if(tileValue == 'DC')
	{
	title = getLabel("eBL.PendDiscClear.label", "bl");
	}
	var param = "title="+title+"&"+"facility_id="+facility_id+"&"+"user="+user+"&"+"strclientip="+strclientip+"&"+"tileValue="+tileValue;
	retVal= await window.showModalDialog("../../eBL/jsp/BLApprStatusTrackWeb.jsp?"+param,arguments,features);
	if(refresh != ''){
	reloadWeb();
	}
}

function reloadWeb(){
	parent.frames[0].search.document.getElementById('popup_opened_yn').value = "N";
	var cur_time = new Date().getTime();
	var refresh_time = parent.frames[0].search.document.getElementById('next_refr_time').value;

	if(cur_time > refresh_time)
	{
		clearTimeout(a);
		reload();
		return false;
	}
	else
	{
	}
	return false;

}

function onClickPayer(cusName,cusCode)
{
	/*if(document.getElementById("selCust").value==cusName && document.getElementById("selCusCode").value==cusCode){
		return false;
	}else{
		document.getElementById("selCust").value=cusName;
		document.getElementById("selCusCode").value=cusCode;
	}//49172
	*/
	if(document.getElementById("click_count").value=="0"){
		document.getElementById("click_count").value="1";
	}else{
		alert("Query in progress...");
		return false;
	}
	var user	= document.getElementById("user").value;
	var strclientip	= document.getElementById("strclientip").value;
	var encounterFromDate	= document.getElementById("encounterFromDate").value;
	var encounterToDate	= document.getElementById("encounterToDate").value;
	var episodeType	= document.getElementById("episodeType").value;
	var apprvSts_AAKHYN	= document.getElementById("apprvSts_AAKHYN").value;//V230425
	var PreAuthEclaimYN	= document.getElementById("PreAuthEclaimYN").value;//V230822
	var cusName	= cusName; 
	var cusCode	= cusCode;
	parent.frames[2].location.href = "../../eBL/jsp/BLApprStatusTrackSearchPayerStatus.jsp?user="+user+"&strclientip="+strclientip+"&cusCode="+cusCode+"&cusName="+encodeURIComponent(cusName)+"&Code="+cusCode+"&encounterFromDate="+encounterFromDate+"&encounterToDate="+encounterToDate+"&episodeType="+episodeType+"&apprvSts_AAKHYN="+apprvSts_AAKHYN+"&PreAuthEclaimYN="+PreAuthEclaimYN;//V230425 V230822
}

function onClickStatus(obj)
{
	parent.frames[0].search.document.getElementById('popup_opened_yn').value = "Y";
	var user	= document.getElementById("user").value;
	var strclientip	= document.getElementById("strclientip").value;
	var customerCode	= document.getElementById("customerCode").value;
	var cusName	= document.getElementById("cusName").value;//44856
	if(document.getElementById("clickCnt").value=="0"){
		document.getElementById("clickCnt").value="1";
	}else{
		alert("Query in progress...");
		return false;
	}
	var encounterFromDate	= document.getElementById("encounterFromDate").value;
	var encounterToDate	= document.getElementById("encounterToDate").value;
	var episodeType	= document.getElementById("episodeType").value;
	var apprvSts_AAKHYN	= document.getElementById("apprvSts_AAKHYN").value;//V230425
	var PreAuthEclaimYN	= document.getElementById("PreAuthEclaimYN").value;//V230822
	var refresh	= parent.frames[0].search.document.getElementById('refresh').value; 
	var dialogTop			= "80";
	var dialogHeight		= "50" ;
	var dialogWidth			= "80" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no;" ;
	var arguments			= "" ;
	var tileValue	= obj;
	var val = "";
	if(obj == 'Approved')
			val = "A";
		else if(obj == 'Pending')
			val = "P";
		else if(obj == 'Hold')
			val = "H";
		else if(obj == 'Rejected')
			val = "R";
		else if(obj == 'Send to Insurance')
			val = "S";
		else if(obj == 'Clarification')
			val = "C";
	var param = "title="+tileValue+"&"+"customerCode="+customerCode+"&cusName="+cusName+"&"+"user="+user+"&"+"strclientip="+strclientip+"&"+"encounterFromDate="+encounterFromDate+"&"+"encounterToDate="+encounterToDate+"&"+"episodeType="+episodeType+"&"+"val="+val+"&"+"apprvSts_AAKHYN="+apprvSts_AAKHYN+"&PreAuthEclaimYN="+PreAuthEclaimYN; //44856 V230822
	retVal=window.showModalDialog("../../eBL/jsp/BLApprStatusTrackInsWeb.jsp?"+param,arguments,features);
	//52174 -undefined condn added
	if((retVal=="Y" || retVal=="undefined" || retVal==undefined) && (apprvSts_AAKHYN=="Y" || PreAuthEclaimYN=="Y")){
		reloadYN="Y";
		data="&"+"customerCode="+customerCode+"&cusName="+cusName;
		document.getElementById("clickCnt").value="0";
		onSearch();
	}else{
		reloadYN="N";
	}//V230511-44856
	if(refresh != ''){
	reloadWeb();
	}
}

function onClickResult() {
	var user	= document.getElementById("user").value;
	var strclientip	= document.getElementById("strclientip").value;
	var customerCode	= document.getElementById("customerCode").value; 
	var cusName	= document.getElementById("cusName").value; //44856
	var validRecUserView	= document.getElementById("validRecUserView").value;
	var validFrontUserView	= document.getElementById("validFrontUserView").value;
	var encounterFromDate	= document.getElementById("encounterFromDate").value;
	var encounterToDate	= document.getElementById("encounterToDate").value;
	var patient_id	= document.getElementById("patient_id").value;
	var encounter_id	= document.getElementById("encounter_id").value;
	var service_code	= document.getElementById("service_description").value;
	var episodeType =  document.getElementById('episodeType').value;
	var val =  document.getElementById('val').value;
	var apprvSts_AAKHYN =  document.getElementById('apprvSts_AAKHYN').value;//V230425 
	var PreAuthEclaimYN =  document.getElementById('PreAuthEclaimYN').value;//V230822
	
	var view	= radioval;
	if(PreAuthEclaimYN=="Y"){
		var param = "customerCode="+customerCode+"&cusName="+cusName+"&"+"user="+user+"&"+"strclientip="+strclientip+"&"+"view="+view+"&"+"encounterFromDate="+encounterFromDate+"&"+"encounterToDate="+encounterToDate+"&"+"patient_id="+patient_id+"&"+"encounter_id="+encounter_id+"&"+"service_code="+encodeURIComponent(service_code)+"&"+"episodeType="+episodeType+"&"+"val="+val+"&"+"apprvSts_AAKHYN="+apprvSts_AAKHYN+"&PreAuthEclaimYN="+PreAuthEclaimYN;//V230425-44856
		
		var url = "../../eBL/jsp/BLApprStatusTrackInsWebSearchResult.jsp?"+param;
		var url1 = "../../eBL/jsp/BLApprStatusTrackInsWebCancel.jsp?"+param;
	    parent.lookup_detail.location.href = url;
	    parent.lookup_cancel.location.href = url1;
	}else{
		if(validFrontUserView == 'Y' && validRecUserView == 'N' && radioval == '' ) view = 'F';
		if(validFrontUserView == 'N' && validRecUserView == 'Y' && radioval == '' ) view = 'R';
		if(validRecUserView == 'N' && validFrontUserView == 'N' && view == '')
		{
			alert(getMessage('BL0970','BLEXT'));
			//alert("Privilege is not provided for the Record Approval User View and Front Office User View");
			return;
		}
		if(validRecUserView == 'Y' && validFrontUserView == 'Y' && view == '' )
		{
			alert(getMessage('BL0971','BLEXT'));
			//alert("Record Approval User View or Front Office User View need to be selected");
			return;
		}
		if((validRecUserView == 'N' && view =='R') || (validFrontUserView == 'N' && view =='F'))
		{
			alert(getMessage('BL0972','BLEXT'));
			//alert("Privilege is not provided for the selected View");
			return;
		}
		
		
		if(view != '' )
		{
		var param = "customerCode="+customerCode+"&cusName="+cusName+"&"+"user="+user+"&"+"strclientip="+strclientip+"&"+"view="+view+"&"+"encounterFromDate="+encounterFromDate+"&"+"encounterToDate="+encounterToDate+"&"+"patient_id="+patient_id+"&"+"encounter_id="+encounter_id+"&"+"service_code="+encodeURIComponent(service_code)+"&"+"episodeType="+episodeType+"&"+"val="+val+"&"+"apprvSts_AAKHYN="+apprvSts_AAKHYN;//V230425-44856
	
		var url = "../../eBL/jsp/BLApprStatusTrackInsWebSearchResult.jsp?"+param;
		var url1 = "../../eBL/jsp/BLApprStatusTrackInsWebCancel.jsp?"+param;
	    parent.lookup_detail.location.href = url;
	    parent.lookup_cancel.location.href = url1;
		}
	}
	
}

function onWebReset()
{
document.getElementById("web_Search").reset();
parent.lookup_detail.location.href = "../../eCommon/html/blank.html";
parent.lookup_cancel.location.href = "../../eCommon/html/blank.html";
parent.lookup_head.webSearch.document.getElementById('servicecodebut').disabled = false;
parent.lookup_head.webSearch.document.getElementById('service_description').disabled = false;
radioval = '';
}

function storeVal(currad) {
    radioval=currad.value
	if(radioval == 'R')
	{
	parent.lookup_head.webSearch.document.getElementById('service_description').value = '';
	parent.lookup_head.webSearch.document.getElementById('servicecodebut').disabled = true;
	parent.lookup_head.webSearch.document.getElementById('service_description').disabled = true;
	}
	else
	{
	parent.lookup_head.webSearch.document.getElementById('servicecodebut').disabled = false;
	parent.lookup_head.webSearch.document.getElementById('service_description').disabled = false;
	}
	parent.lookup_detail.location.href = "../../eCommon/html/blank.html";
	parent.lookup_cancel.location.href = "../../eCommon/html/blank.html";
}

function changeFieldColor(obj)
{
 document.getElementById('patient_Id').value = document.getElementById('patientId'+obj).value;
}

async function callDemographic()
{
		var patient_id 		=	trimString(parent.lookup_detail.websearchresult.document.getElementById('patient_Id').value) ;
		var retVal 			= 	new String();
		var dialogHeight 	= "38" ;
		var dialogWidth  	= "100" ;
		var dialogTop    	= "100";
	    var status 			= "no";
		var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
		retVal =await window.showModalDialog("../../eCA/jsp/DemographicsView.jsp?patient_id="+patient_id,arguments,features);

}

function closew() {
    parent.window.close();
}

function recApprvlData(i){
	var patientid=document.getElementById('patientId'+i).value;
	var patient_name=document.getElementById('patientName'+i).value;
	var encounter_id=document.getElementById('encounterId'+i).value;
	var episode_type=document.getElementById('epiType'+i).value;
	if(episode_type=="O")
		episode_type="OP";
	else if(episode_type=="I")
		episode_type="IP";
	else if(episode_type=="D")
		episode_type="DC";
	else if(episode_type=="E")
		episode_type="EM";
	else
		episode_type="";	
	
	var payer_group=document.getElementById('payer_group'+i).value;
	var payer=document.getElementById('payer'+i).value;
	var policy=document.getElementById('policy'+i).value;
	var Effective_from=document.getElementById('Effective_from').value;
	var Effective_to=document.getElementById('Effective_to').value;
	var PreAuthEclaimYN=document.getElementById('PreAuthEclaimYN').value; 
	var Speciality=document.getElementById('specialty_code'+i).value;
	var val=document.getElementById('val').value;//102.2
	
	var dialogHeight= "50" ; 
	var dialogWidth	= "90" ;													   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; scroll=auto; center:yes";
		
	var arguments			= "" ;
	var	title = "Record Approval";
	var url;
	if(PreAuthEclaimYN=="Y"){
		 url="title="+title+"&function_id=EBL_TRANS_INS_RECORD_APPROVAL&function_type=F&access=NYNNN"+"&patient_name="+patient_name+"&patientId="+patientid+"&encounter_id="+encounter_id+"&payer_group="+payer_group+"&payer="+payer+"&policy="+policy+"&Effective_from="+Effective_from+"&Effective_to="+Effective_to+"&episode_type="+episode_type+"&calledForm=preAuthStsTrack&Speciality="+Speciality+"&Status="+val;
	}else{
		 url="title="+title+"&function_id=EBL_TRANS_INS_RECORD_APPROVAL&function_type=F&access=NYNNN"+"&patient_name="+patient_name+"&patientId="+patientid+"&encounter_id="+encounter_id+"&payer_group="+payer_group+"&payer="+payer+"&policy="+policy+"&Effective_from="+Effective_from+"&Effective_to="+Effective_to+"&episode_type="+episode_type+"&calledForm=ApprStsTrack&Speciality="+Speciality+"&Status="+val;
	}
	//var url="title="+title+"&function_id=EBL_TRANS_INS_RECORD_APPROVAL&function_type=F&access=NYNNN"+"&patient_name="+patient_name+"&patientId="+patientid+"&encounter_id="+encounter_id+"&payer_group="+payer_group+"&payer="+payer+"&policy="+policy+"&Effective_from="+Effective_from+"&Effective_to="+Effective_to+"&episode_type="+episode_type+"&calledForm=ApprStsTrack";
	retVal=window.showModalDialog("../../eBL/jsp/BillingRecordapproval.jsp?"+url,arguments,features);
	
}

function showMainTabDetails(fromTab,params){
	if(fromTab=="PreAuthorization"){ 
		document.getElementById('EClaim').className = "tabA";
		document.getElementById('EClaimspan').className = "tabAspan";
		document.getElementById('PreAuthorization').className = "tabClicked";
		document.getElementById('PreAuthorizationspan').className = "tabSpanclicked";
		parent.BLApprStatusTrackQueryFrame.document.location.href = '../../eBL/jsp/BLApprStatusTrackQueryFrame.jsp?'+params;
	}
	if(fromTab=="EClaim"){
		document.getElementById('PreAuthorization').className = "tabA";
		document.getElementById('PreAuthorizationspan').className = "tabAspan";
		document.getElementById('EClaim').className = "tabClicked";
		document.getElementById('EClaimspan').className = "tabSpanclicked";
		parent.BLApprStatusTrackQueryFrame.document.location.href = '../../eBL/jsp/BLEClaimTabMainFrame.jsp?'+params;
		
	}
}
