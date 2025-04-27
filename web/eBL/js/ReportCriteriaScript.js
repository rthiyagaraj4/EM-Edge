

async function payerGroupLookup()
	{

		var formObj  =  document.forms[0];
		var sql;

		
	//	sql											=	PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL+" '" +document.forms[0].locale.value+"'";

		sql											=	"SELECT LONG_DESC DESCRIPTION , CUST_GROUP_CODE CODE FROM AR_CUST_GROUP_LANG_VW WHERE upper(CUST_GROUP_CODE) like upper(?) and upper(LONG_DESC) like upper(?) AND STATUS IS NULL AND LANGUAGE_ID = '" +document.forms[0].locale.value+"'";
		var title									= 	getLabel("eBL.PAYER_GROUP.label", 'bl');
		var argumentArray  							= 	new Array() ;
		var dataNameArray  							= 	new Array() ;
		var dataValueArray 							= 	new Array() ;
		var dataTypeArray  							= 	new Array() ;
		
	    argumentArray[0]							= 	sql;
		argumentArray[1]   							= 	dataNameArray ;
		argumentArray[2]   							= 	dataValueArray ;
		argumentArray[3]   							= 	dataTypeArray ;
		argumentArray[4]   							= 	"1,2";
		argumentArray[5]   							= 	formObj.payer_grp_desc.value;
		argumentArray[6]   							= 	DESC_LINK ;
		argumentArray[7]   							= 	DESC_CODE ;
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
			formObj.p_payer_grp_code.value			= 	arr[0];
			formObj.payer_grp_desc.value			=  	arr[1];

		}
		else
		{
			formObj.p_payer_grp_code.value = arr[0]; 
			formObj.payer_grp_desc.value = arr[1]; 
			//formObj.p_payer_grp_code.value			= 	"";
			//formObj.payer_grp_desc.value			=  	"";
			
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
var xmlDoc =  "";
var xmlHttp = new XMLHttpRequest();
//xmlDoc.loadXML(xmlStr); 
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
//	ChangeUpperCase(document.getElementById('patient_name'));
}

}
}
	
async function episodeNoLookup()
{
	
	//alert("IN episodeNoLookup");
	var e = document.getElementById("episode_type");
	var selectedValue=e.value;
/*	for(var j=0; j<e.options.length; j++)
    {
		if(e.options[j].selected)
			selectedValue=e.options[j].value;
    }
	*/
	
	var fomrsObj = document.forms[0];
	
	var sql;
	sql											=	RECORD_REPORT_CRITERIA_EPISODE_NO_LOOKUP;
	var episodeType								=	selectedValue; 
	var patientId								=	document.getElementById("patient_id").value;
	if(patientId != undefined && patientId != null && patientId != '')
	{
		sql										=	sql+" AND PATIENT_ID ="+" '"+patientId+"'";
	}
	if(episodeType != undefined && episodeType != null && episodeType != '')		
	{
		/*if(episodeType=='I' || episodeType == 'O')			episodeType = episodeType+'P';
		else  if(episodeType == 'E')  episodeType = episodeType+'M';
		else  if(episodeType == 'D')  episodeType = episodeType+'C';  */
			
		sql										=	sql+" AND PATIENT_CLASS ="+" '"+episodeType+"'";
	}

	//alert( 'sql  '+sql);
	var title									= 	getLabel("Common.encounterid.label", 'common');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
	var episodeNo								=	fomrsObj.episode_id; 
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	episodeNo.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
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
		fomrsObj.episode_id.value 						= arr[0];
		fomrsObj.p_episode_id.value                     = arr[0];		
	//	episodeNo	=	retVal[0];
	}
	else
	{
		fomrsObj.episode_id.value = arr[0]; 
		fomrsObj.p_episode_id.value = arr[1]; 
		//fomrsObj.episode_id.value			  				=	"";
		//fomrsObj.p_episode_id.value = "";				
		//episodeNo	=	"";
		
	}
 
	
	/*var ep_id = episodeNo;
		
	if(selectedValue == 'OP' && ep_id !="")
	{	
	
	var e_id =  ep_id.substring(0,8);
//	alert('e_id  = '+e_id);
	var v_id =  ep_id.substring(8,ep_id.length);			
	alert(" v_id ="+v_id);			
	fomrsObj.p_episode_id.value =  e_id;
	fomrsObj.p_visit_id.value =    v_id;
	}
	 */
}


async function payerLookup(custgrp)
	{
		var sql;

		var formObj		=  document.forms[0];
		var custgrpcode ; 
	//	alert(' custgrp '+custgrp);
//		 alert(' custgrp '+custgrp.value);
		if(custgrp != 'undefined' || custgrp !=null)
		{
		 custgrpcode = custgrp.value; 

//		"SELECT LONG_NAME DESCRIPTION , CUST_CODE CODE FROM AR_CUSTOMER_LANG_VW WHERE cust_group_code = '"+custgrpcode+"'  upper(LONG_NAME) like upper(?) and upper(CUST_CODE) like upper(?) AND STATUS IS NULL AND LANGUAGE_ID = "

			sql										=	"SELECT LONG_NAME DESCRIPTION , CUST_CODE CODE FROM AR_CUSTOMER_LANG_VW WHERE CUST_GROUP_CODE = '"+custgrpcode+"' and upper(CUST_CODE) like upper(?) and upper(LONG_NAME) like upper(?) AND STATUS IS NULL AND LANGUAGE_ID  ='"+document.forms[0].locale.value+"'";

//		sql											=	PAYER_LOOKUP_RECORD_PREAPPROVAL+" '" +document.forms[0].locale.value+"'";
		var title									= 	getLabel("Common.Payer.label", 'common');
		var argumentArray  							= 	new Array() ;
		var dataNameArray  							= 	new Array() ;
		var dataValueArray 							= 	new Array() ;
		var dataTypeArray  							= 	new Array() ;
//		var payer									=	document.getElementById('payer'); 
	    argumentArray[0]							= 	sql;
		argumentArray[1]   							= 	dataNameArray ;
		argumentArray[2]   							= 	dataValueArray ;
		argumentArray[3]   							= 	dataTypeArray ;
		argumentArray[4]   							= 	"1,2";
		argumentArray[5]   							= 	formObj.cust_desc.value;
		argumentArray[6]   							= 	DESC_LINK ;
		argumentArray[7]   							= 	DESC_CODE ;
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
			formObj.p_cust_code.value						=arr[0];
			formObj.cust_desc.value							=arr[1];

				

		}
		else
		{
			formObj.p_cust_code.value = arr[0]; 
			formObj.cust_desc.value = arr[1]; 
			//formObj.p_cust_code.value					="";
			//formObj.cust_desc.value						="";

			
		}
		}
	    
	}
	
	
async	function policyLookup()
	{
		alert("policyLookup9");
		//alert("IN POLICY LOOK UP");

		var formObj			=  document.forms[0];
		var sql;
//		"SELECT LONG_DESC DESCRIPTION , POLICY_TYPE_CODE CODE FROM BL_INS_POLICY_TYPES_LANG_VW WHERE upper(LONG_DESC) like upper(?) and upper(POLICY_TYPE_CODE) like upper(?) AND NVL(STATUS,'A') !='S' AND OPERATING_FACILITY_ID = "

		sql											=	"SELECT LONG_DESC DESCRIPTION , POLICY_TYPE_CODE CODE FROM BL_INS_POLICY_TYPES_LANG_VW WHERE upper(POLICY_TYPE_CODE) like upper(?) and upper(LONG_DESC) like upper(?) AND NVL(STATUS,'A') !='S' AND OPERATING_FACILITY_ID = '" +document.forms[0].p_facility_id.value+"'";
	//	sql											=	POLICY_LOOKUP_RECORD_PREAPPROVAL+" '" +document.forms[0].p_facility_id.value+"'";
		var title									= 	getLabel("eBL.POLICY.label", 'bl');
		var argumentArray  							= 	new Array() ;
		var dataNameArray  							= 	new Array() ;
		var dataValueArray 							= 	new Array() ;
		var dataTypeArray  							= 	new Array() ;
	//	var policy									=	document.getElementById('policy'); 
	    argumentArray[0]							= 	sql;
		argumentArray[1]   							= 	dataNameArray ;
		argumentArray[2]   							= 	dataValueArray ;
		argumentArray[3]   							= 	dataTypeArray ;
		argumentArray[4]   							= 	"1,2";
		argumentArray[5]   							= 	formObj.policy_desc.value;
		argumentArray[6]   							= 	DESC_LINK ;
		argumentArray[7]   							= 	DESC_CODE ;
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

			formObj.p_policy_type_code.value				=arr[0];
			formObj.policy_desc.value						=arr[1];
		}
		else
		{
			
            formObj.p_policy_type_code.value = arr[0]; 
			formObj.policy_desc.value = arr[1];
			//formObj.p_policy_type_code.value					="";
			//formObj.policy_desc.value						="";	
			
		}
	 
	    
	}
	
async function practionerLookup()
	{
		//alert("IN practionerLookup");
		var formObj	= document.forms[0];

		var sql;

		
		//sql											=	RECORD_REPORT_CRITERIA_PRACTIONER_LOOKUP+" '" +document.forms[0].locale.value+"'";

		sql											=	"SELECT PRACTITIONER_NAME DESCRIPTION,PRACTITIONER_ID CODE  FROM AM_PRACTITIONER_LANG_VW  WHERE upper(PRACTITIONER_ID) like upper(?) AND upper(PRACTITIONER_NAME) like upper(?) AND LANGUAGE_ID = '" +document.forms[0].locale.value+"'";
		var title									= 	getLabel("Common.practitioner.label", 'common');
		var argumentArray  							= 	new Array() ;
		var dataNameArray  							= 	new Array() ;
		var dataValueArray 							= 	new Array() ;
		var dataTypeArray  							= 	new Array() ;
		//var practioner								=   document.getElementById('practioner_id'); 
	    argumentArray[0]							= 	sql;
		argumentArray[1]   							= 	dataNameArray ;
		argumentArray[2]   							= 	dataValueArray ;
		argumentArray[3]   							= 	dataTypeArray ;
		argumentArray[4]   							= 	"1,2";
		argumentArray[5]   							= 	formObj.p_physician.value; 
		argumentArray[6]   							= 	DESC_LINK;
		argumentArray[7]   							= 	DESC_CODE ;
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
			formObj.p_physician_id.value			=   retVal[1];
			formObj.p_physician.value 				= 	retVal[0];
		}
		else
		{
			formObj.p_physician_id.value = arr[0]; 
			formObj.p_physician_id.value = arr[1]; 
			//formObj.p_physician_id.value			=   "";
			//formObj.p_physician.value 				= 	"";
			
		}
	 
	    
	}
async	function specialityLookup()
	{

			var formObj	= document.forms[0];
		var sql;


		sql											=	"SELECT SPECIALITY_CODE CODE,SHORT_DESC DESCRIPTION FROM AM_SPECIALITY_LANG_VW WHERE upper(SHORT_DESC) like upper(?) AND upper(SPECIALITY_CODE) like upper(?) AND NVL(EFF_STATUS,'E')  !=  'D' AND LANGUAGE_ID ='" +document.forms[0].locale.value+"'";
		
		
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
		argumentArray[5]   							= 	formObj.specialty_desc.value;
		argumentArray[6]   							= 	DESC_LINK ;
		argumentArray[7]   							= 	DESC_CODE ;
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
			formObj.p_specialty_code.value			=   arr[0];
			formObj.specialty_desc.value 				= 	arr[1];

		}
		else
		{

            formObj.p_specialty_code.value = arr[0]; 
			formObj.specialty_desc.value = arr[1]; 
			//formObj.p_specialty_code.value			=   "";
			//formObj.specialty_desc.value 				= 	"";
			
		}
	 
	    
	}
	
	 
	function create() 
	{	

		
	}

	function reset()

{
	 var formObj =BillingReportCriteria.document.forms[0];

	 formObj.patient_id.value="";
 	 formObj.episode_type.value="";
 	formObj.episode_id.value="";
	 formObj.p_episode_id.value="";
  	 formObj.p_physician.value="";
	 formObj.p_physician_id.value="";
 	 formObj.payer_grp_desc.value="";
	 formObj.p_payer_grp_code.value="";
  	 formObj.cust_desc.value="";
   	 formObj.p_cust_code.value="";
 	 formObj.policy_desc.value="";
	 formObj.p_policy_type_code.value="";
  	 formObj.p_fm_date.value="";
   	 formObj.p_fm_date.value="";
   	 formObj.specialty_desc.value="";
   	 formObj.p_specialty_code.value="";
	 formObj.sum_yn.selectedIndex = 0;
}





	 
	function run()  
	{
		

		var formsObj =  parent.frames[2].BillingReportCriteria.BillingReportCriteriaForm.document.forms[0];

		var p_episode_type =formsObj.p_episode_type.value;	 
		var p_fm_date	=formsObj.p_fm_date.value;	 
		var p_to_date =formsObj.p_to_date.value;
		var  cust_desc = formsObj.cust_desc.value;
	
		if(cust_desc != 'undefined'&& cust_desc != null)
			{
		cust_desc =cust_desc.replace(/\#/g,' ');	
		cust_desc =cust_desc.replace(/\&/g,' ');	
		formsObj.cust_desc.value = cust_desc;
			}
		var pat_id =   formsObj.patient_id.value;
		
		if(pat_id !='' && pat_id !='undefined')		
		formsObj.p_patient_id.value =   pat_id;
		else
			formsObj.p_patient_id.value =   '';

		formsObj.p_report_id.value =   formsObj.sum_yn.value;
		formsObj.pgm_id.value =   formsObj.sum_yn.value;
		
		
		
		var ep_id = formsObj.episode_id.value;
		
		
		if(p_episode_type == 'O' && ep_id !="")
		{	
		
		var e_id =  ep_id.substring(0,8);

		var v_id =  ep_id.substring(8,ep_id.length);			
			
		formsObj.p_episode_id.value =  e_id;
		formsObj.p_visit_id.value =    v_id;
		
		}
		

		
		if(p_episode_type==undefined || p_episode_type=='')
		{
			alert(getMessage("BL00028","BL"));
			return;
		}
		if(p_fm_date==undefined || p_fm_date=='')
		{
			alert(getMessage("BL00004","BL"));
			return;
		}
		if(p_to_date==undefined || p_to_date=='')
		{
			alert(getMessage("BL8560","BL"));
			return;
		}
		formsObj.submit();
					
	}

function changeEpisode()

{
	
	var formObj = document.forms[0];
	var epis=formObj.episode_type.value;

	formObj.p_episode_id.value = '';	
	formObj.episode_id.value = '';
	formObj.p_visit_id.value = '';
	

	if( epis != '' && epis != 'undefined')
 	 formObj.p_episode_type.value =  epis.charAt(0);
	else
		formObj.p_episode_type.value =  '';


}
	

function onSuccess()
{
	parent.frames[2].BillingRecordApproval.document.location.reload(); 
}

	
