/*
Sr No        Version              TFS              SCF/CRF           		   Developer Name
---------------------------------------------------------------------------------------------
1            V201216             11086        NMC-JD-CRF-0087-TF-US001         Mohana Priya K
 */
function run(){
	messageFrame.document.location.href="../../eCommon/jsp/error.jsp?";
}

function reset(){
	summaryreport.location.reload();
}

async function enCounterIdLookup()
	{
		//alert("4");
	var fieldLegend;
		fieldLegend = new Array() ;
		fieldLegend["CODE_LEGEND"] = "EncounterId"
		fieldLegend["DESC_LEGEND"] = "EpisodeId"
		var e = document.getElementById("episode_type"); 
		
		var selectedValue;
		var episodeType;
		var partsql = '';
		
		if(episodeType == 'O' || episodeType == 'E'){
			partsql = ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL;
		}
		else{
			partsql = "SELECT EPISODE_ID DESCRIPTION, ENCOUNTER_ID CODE FROM bl_episode_fin_dtls WHERE upper(EPISODE_ID) like upper(?) and upper(ENCOUNTER_ID) like upper(?) AND OPERATING_FACILITY_ID = ";
		}
		var sql;
		sql											=	partsql+" '" +document.forms[0].facilityId.value+"'";
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
		retVal 										= await  CommonLookup( title, argumentArray );
		if(retVal != null && retVal != "")
		{
			encounterId.value 						= 	retVal[0];
		}
		else
		{
			encounterId.value			  			=	"";
			
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

async function PatientIdLookup(){	
					
	var pat_id=await PatientSearch();		
	if( pat_id != null )						
	document.getElementById('patient_id').value = pat_id ;
	if(pat_id!=undefined && pat_id!='')
	{
		LoadPatientName(pat_id);
		ChangeUpperCase(document.getElementById('patient_name'));
	}
}	
		
function LoadPatientName(pat_id){
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
	if (xmlhttp.readyState==4 && xmlhttp.status==200){
		out = xmlhttp.responseText;
		var showdata = out.substring(out.indexOf("!")+1,out.length);
		response=showdata.split(":");
		var actual;
				
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

async  function policyLookup()
{
	var sql;
	var facility_id = document.forms[0].facilityId.value;
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
	var ret1=unescape(retVal);
							var arr=ret1.split(",");
							if(arr[1]==undefined) 
							{
								arr[0]="";	
								arr[1]="";	
							}				
 
	if(retVal != null && retVal != "")
	{
		policy.value 							= 	arr[0];
	}
	else
	{
		policy.value = arr[0]; 
		//policy.value			  					=	"";
		
	}
 }

async function payerLookup()
{
	var sql;
	var facility_id = document.forms[0].facilityId.value;
	var locale = document.forms[0].locale.value;
	var cust_code = document.getElementById("payer_group").value;
	
	sql = "Select description,code from (Select long_name description,cust_code code from ar_customer_lang_vw "+
				"Where Cust_Code In ( SELECT cust_code "+
                "FROM bl_cust_by_cust_group "+
                "WHERE cust_group_code = "+
                         "DECODE ('"+cust_code+"', "+
                                 "'**', cust_group_code, '"+ cust_code+
                                "')) "+
				"and acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') "+
				"and nvl(patient_flag,'N')  ='Y' "+
				"and nvl(pat_com_flag,'N')='N' "+
				"And Nvl(Insurance_Yn, 'N') = 'Y' And Status Is Null "+
				"and upper(language_id) = upper('"+locale+"') union  Select 'All Payer','**' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) ";

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


async function payerGroupLookup(){
	var sql;
	var facility_id = document.forms[0].facilityId.value;
	var locale = document.forms[0].locale.value;
	sql="select description,code from (select long_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and "+
		"cust_group_code in (Select Distinct Cust_Group_Code From Bl_Cust_By_Cust_Group Where Cust_Code In (Select Cust_Code From Ar_Customer_Lang_Vw "+
		"where acc_entity_code  in (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') "+
		"and nvl(patient_flag,'N')  ='Y' And Nvl(Insurance_Yn, 'N') = 'Y' )) "+
		"And Acc_Entity_Code In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facility_id+"') and upper(language_id) = upper('"+locale+"') union Select 'All Payer Group','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) "+
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



async function specialityLookup(){
	alert("specialityLookup3");
		var sql;
		sql											=	RECORD_REPORT_CRITERIA_SPECIALITY_LOOKUP+" '" +document.forms[0].locale.value+"'";
		var title									= 	getLabel("Common.speciality.label", 'common');
		var argumentArray  							= 	new Array() ;
		var dataNameArray  							= 	new Array() ;
		var dataValueArray 							= 	new Array() ;
		var dataTypeArray  							= 	new Array() ;
		var speciality								=	document.getElementById('speciality'); 
	    argumentArray[0]							= 	sql;
		argumentArray[1]   							= 	dataNameArray ;
		argumentArray[2]   							= 	dataValueArray ;
		argumentArray[3]   							= 	dataTypeArray ;
		argumentArray[4]   							= 	"1,2";
		argumentArray[5]   							= 	speciality.value;
		argumentArray[6]   							= 	DESC_LINK ;
		argumentArray[7]   							= 	CODE_DESC;
		retVal 										=  await CommonLookup( title, argumentArray );
		
	if(retVal != null && retVal != "")
	{
		speciality.value 						= 	retVal[0];
	}
	else
	{
		speciality.value			  			=	"";
	}	    
}


function dateRegEx(e){  //Added for Character Restriction in date field
  
  var pattern = new RegExp("^(0?[1-9]|[12][0-9]|3[01])[\-](0?[1-9]|1[012])[\/\-]\d{4}$");
  if (e.value.search(pattern)===0){
    return true;
  }
  else {
    alert("Please provide valid date in format dd/mm/yyyy");
    document.getElementById(e.id).focus();
    return false; 
  } 
}


//Effective From and ToDate Logic
function toFromDateChk(obj,from,to){	
	if(!(obj.value==""))
	{		
		var locale    =  document.forms[0].locale.value;
		var effFromDt=from.value;
		var effToDt=to.value;
	
		if(validDate(obj.value,"DMY",locale))
		{  
			if(  effToDt!=getCurrentDate('DMY',locale) && isAfterNow(effToDt,'DMY',locale)==true){
				alert(getMessage("BL6015",'BL'));
				obj.value = '';
				return false;
			}
			
			if(effFromDt != '' && effToDt !=''){
				if((!isBefore(effFromDt,effToDt,'DMY',locale)))
				{		
					alert(getMessage("BL7060",'BL'));
					obj.value = '';
					return false;
				}
				else
				{			
					return true;
				}				
			}
		}
		
	}
	else
	{
		return true;
	}
}

function checkDateBL(entered_date,from,to)
{		
	var locale    = document.forms[0].locale.value;
	var effFromDt=from.value;
	var effToDt=to.value;
	
	if(entered_date.value!="")
	{   
		if(validDate(entered_date.value,'DMY',locale))
		{
			if(effFromDt!=getCurrentDate('DMY',locale) && isAfterNow(effFromDt,'DMY',locale)==true){
				alert(getMessage("BL9114",'BL'));
				entered_date.value='';
				return false;
			}			
			if(effToDt != '' && effFromDt!=''){    
				if((!isBefore(effFromDt,effToDt,'DMY',locale))){
					alert(getMessage("BL7060",'BL'));
					entered_date.value='';
					return false;
			}
			else{
					return true;
			 }
			}	
		}
		
	}
	else
	{
		return true;
	}
}

//Effective From and ToDate Logic

function trimString(sInString) {
	  return sInString.replace(/^\s+|\s+$/g,"");
}



function callExcelDisplay(){
	var formObj=document.forms[0];
	
	var locale=formObj.locale.value;
	var facilityId=document.getElementById('facilityId').value;
	var patient_id=document.getElementById('patient_id').value;
	var patient_name=document.getElementById('patient_name').value;
	var episode_type=document.getElementById('episode_type').value;
	var encounter_id=document.getElementById('encounter_id').value;
	var speciality=document.getElementById('speciality').value;
	var payer_group=document.getElementById('payer_group').value;
	var Effective_from=document.getElementById('fm_date').value;
	var Effective_to=document.getElementById('to_date').value;
	var payer=document.getElementById('payer').value;
	var policy=document.getElementById('policy').value;
	 
	var err_msg="";
	var err_code="";
	
	if(episode_type==undefined || episode_type=='')
	{
		alert(getMessage("BL00028","BL"));
		return false;
	}
	

	if(payer_group==undefined || payer_group=='')
	{
		alert(getMessage("BL6277","BL"));
		return false;
	}
	
	if(Effective_from==undefined || Effective_from=='')
	{
		alert(getMessage("BL0747","BL"));
		return false;
	}
	else if(Effective_to==undefined || Effective_to=='')
	{
		alert(getMessage("BL0748","BL"));
		return false;
	}
	else{
		var starr = Effective_from.split("/");
		var enarr = Effective_to.split("/");
	
	var startdt = new Date();
	var enddt = new Date();
	startdt.setFullYear(starr[2], starr[1]-1, starr[0]);
	enddt.setFullYear(enarr[2], enarr[1]-1, enarr[0]);
 	var timeDiff;
    var daysDiff;
    if(startdt>enddt)
	{
		alert(getMessage('BL4115','BL'));
		return false;
	}

  	timeDiff = enddt.getTime() - startdt.getTime();
	daysDiff =  Math.floor(timeDiff / (1000 * 60 * 60 * 24));
	
	var daysRestrict = 31;
	if(daysRestrict != ''){
		var actualDays = parseInt(daysRestrict)-1;
		if(daysDiff > actualDays)
		{
				alert("Encounter To Date Cannot be greater than "+daysRestrict+" Days from Encounter from Date");
				return false;
			}
	 	}  
	}
	

	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";

	var param1 = "&p_facility_id="+facilityId+"&p_patient_id="+patient_id+"&p_episode_type="+episode_type +
	"&p_encounter_id="+encounter_id+
	"&p_fm_date="+Effective_from +
	"&p_to_date="+Effective_to +"&p_payer="+payer_group +"&p_payer_name="+payer+
	"&p_policy="+policy+"&p_specialty="+speciality+"&p_language_id="+locale ;

	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eBL/jsp/EClaimValidation.jsp?func_mode=insert"+param1,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	var retValArr = retVal.split(":::");
	
	if(retValArr[0] ==''){	
			tmpformObj = document.eclaim;
			tmpformObj.noOfCols.value = "61";
			tmpformObj.method ="post";
			tmpformObj.action="../../servlet/eBL.EClaimservlet";
			tmpformObj.target = "messageFrame";
			tmpformObj.submit();
			parent.window.frames["summaryreport"].location.href = 'BLEclaimRpts.jsp';
	}else{
			alert(retValArr[1]);
		}
}


function trimString(sInString) {
	  return sInString.replace(/^\s+|\s+$/g,"");
}
