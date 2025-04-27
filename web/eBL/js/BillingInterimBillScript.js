/*
Sr No           Version             Incident			SCF/CRF                      Developer Name
1               V201218             IN73702        MMS-DM-CRF-0100.1         		Palani Narayanan
2               V210222             14742          MMS-DM-CRF-0100.1         		Shikha Seth
3		   	    V220323	    		27763			MMS-ME-SCF-0052 			    Mohana Priya K
*/

var errorFrame = '';
function enCounterIdLookup()
{
	//alerr("1");
	var fieldLegend;
	fieldLegend = new Array() ;
	fieldLegend["CODE_LEGEND"] = "EncounterId"
	fieldLegend["DESC_LEGEND"] = "EpisodeId"
	var e = document.getElementById("episode_type"); 
	var selectedValue;
	var episodeType;
	for(var j=0; j<e.options.length; j++)
	{
		if(e.options[j].selected)
		selectedValue=e.options[j].value;
	}
	switch(selectedValue)
	{
		case 'OP':	episodeType = 'O';			
		break;
		case 'IP':	episodeType = 'I';				
		break;
		case 'EM':	episodeType = 'E';				
		break;
		case 'DC':	episodeType = 'D';				
		break;
		default:	episodeType='';			
	}
	var partsql = '';

	if(episodeType == 'O' || episodeType == 'E'){
	partsql = ENCOUNTERID_LOOKUP_RECORD_PREAPPROVAL;
	}
	else{
			partsql = "SELECT EPISODE_ID DESCRIPTION, ENCOUNTER_ID CODE FROM bl_episode_fin_dtls c WHERE upper(EPISODE_ID) like upper(?) and upper(ENCOUNTER_ID) like upper(?) AND OPERATING_FACILITY_ID = ";
	}
	var sql;
	sql											=	partsql+" '" +document.getElementById('facilityId').value+"'";
	var sql1 = " AND SETTLEMENT_IND = 'X' AND CUST_CODE IS NOT NULL AND NVL (c.discharged_yn, 'N') <> 'Y' AND NOT EXISTS (SELECT 1 FROM ip_discharge_advice_his_vw i WHERE i.facility_id = c.operating_facility_id AND i.episode_id = c.episode_id  AND NVL (i.dis_adv_status, ' ') != '9' AND ROWNUM = 1)";
	var title									= 	getLabel("Common.encounterid.label", 'common');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
	var patientId								=	document.getElementById('patient_id'); 
	if(patientId.value != undefined && patientId.value != null && patientId.value != '')
	{
		sql			=	sql+" AND PATIENT_ID ="+" '"+patientId.value+"'";
	}
	if(episodeType != undefined && episodeType != null && episodeType != '')
	{
			sql		=	sql+" AND EPISODE_TYPE ="+" '"+episodeType+"'"+sql1;
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
	retVal 										=   CommonLookup( title, argumentArray );
	if(retVal != null && retVal != "")
	{
		encounterId.value 						= 	retVal[0];
	}
	else
	{
		encounterId.value			  			=	"";
	}    
} 
	
function payerGroupLookup()
{
		var sql;
		var facility_id = document.getElementById('facilityId').value;
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
		retVal 										=   CommonLookup( title, argumentArray );
		if(retVal != null && retVal != "")
		{
			payerGroup.value 						= 	retVal[0];
		}
		else
		{
			payerGroup.value			  			=	"";
		}
	 }
	
	function payerLookup()
	{
		var sql;
		var facility_id = document.getElementById('facilityId').value;
		var locale = document.forms[0].locale.value;
		var cust_code = document.forms[0].payer_group.value;
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
		retVal 										=   CommonLookup( title, argumentArray );
		if(retVal != null && retVal != "")
		{
			payer.value 							= 	retVal[0];
		}
		else
		{
			payer.value			  					=	"";
			
		}
	 }
	
	function policyLookup()
	{
		var sql;
		var facility_id = document.getElementById('facilityId').value;
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
		retVal 										=   CommonLookup( title, argumentArray );
		if(retVal != null && retVal != "")
		{
			policy.value 							= 	retVal[0];
		}
		else
		{
			policy.value			  					=	"";
		}
	 }
	
	function showRecordApprovalPatientDeatils()
	{
		var patinetId = document.getElementById("patient_id").value;
		document.getElementById("selectArrFlag").value="";
		document.getElementById("selectAllFlag").value="N";
		document.getElementById('authorizedUserId').value="N";
		document.getElementById('authorizedUserName').value="";
		var e = document.getElementById("episode_type");
		var selectedValue = "";
		for(var j=0; j<e.options.length; j++)
	    {
			if(e.options[j].selected)
				selectedValue=e.options[j].value;
	    }
		var episodeType = "";
		switch(selectedValue)
		{
			case 'OP':	episodeType = 'O';			
						break;
			case 'IP':	episodeType = 'I';				
						break;
			case 'EM':	episodeType = 'E';				
						break;
			case 'DC':	episodeType = 'D';				
						break;			
		}

		var authdoc = parent.interim_Bill_Auth_Bnt.document;	
		authdoc.getElementById('auth').disabled = false;
		var patientName																				=	document.getElementById("patient_name").value;
		var encounterId																				=	document.getElementById("encounter_id").value;
		var customerGroupCode																		=	document.getElementById("payer_group").value;
		var customerCode																			=	document.getElementById("payer").value;
		var policyCode																				=	document.getElementById("policy").value;		
	if(selectedValue==undefined || selectedValue=='')
		{
			alert(getMessage("BL00028","BL"));
			return;
		}
		
		if(customerGroupCode==undefined || customerGroupCode=='')
		{
			alert(getMessage("BL6277","BL"));
			return;
		}
	
		var speciality =  document.forms[0].speciality.value;
		parent.recordApprovalPatientDataDetails.location.href = "../../eBL/jsp/BLInterimBillDetals.jsp?&mode=search&patinetId="+patinetId+"&episodeType="+episodeType
			+"&patientName="+patientName+"&encounterId="+encounterId+"&customerGroupCode="+customerGroupCode+"&customerCode="+customerCode+"&policyCode="+policyCode+"&speciality="+speciality;
		parent.parent.parent.frames[2].frames[5].location.href ="../../eCommon/jsp/error.jsp?err_num=&err_value=" ; 
		document.getElementById("selectArrFlag").value="";
		
	}

		
	function reasonCodeLookup(index)
	{
		var sql;
		sql											=	PRE_APPROVAL_REQUEST_REASONCODE_LOOKUP+" '" +document.forms[0].locale.value+"'";
		var title									= 	getLabel("Common.reason.label", 'common');
		var argumentArray  							= 	new Array() ;
		var dataNameArray  							= 	new Array() ;
		var dataValueArray 							= 	new Array() ;
		var dataTypeArray  							= 	new Array() ;
		var reason									=	document.getElementById('reason'+index); 
	    argumentArray[0]							= 	sql;
		argumentArray[1]   							= 	dataNameArray ;
		argumentArray[2]   							= 	dataValueArray ;
		argumentArray[3]   							= 	dataTypeArray ;
		argumentArray[4]   							= 	"1,2";
		argumentArray[5]   							= 	reason.value;
		argumentArray[6]   							= 	DESC_LINK ;
		argumentArray[7]   							= 	DESC_CODE ;
		retVal 										=   CommonLookup( title, argumentArray );
		if(retVal != null && retVal != "")
		{
			reason.value 							= 	retVal[0];
			reason.title							=	retVal[0];
		}
		else
		{
			reason.value			  				=	"";
			reason.title							=	"";
		}	    
	}

	function billingServiceCodeLookup(index)
	{
		var sql;
		sql											=	PRE_APPROVAL_REQUEST_BILLINGSERVICECODE_LOOKUP+" '" +document.forms[0].locale.value+"'";
		var title									= 	getLabel("eBL.BLNG_SERV_CODE.label", 'bl'); 
		var argumentArray  							= 	new Array() ;
		var dataNameArray  							= 	new Array() ;
		var dataValueArray 							= 	new Array() ;
		var dataTypeArray  							= 	new Array() ;
		var billingServiceCode						=	document.getElementById('billing_service_code'+index);
		var billingServiceDesc						=	document.getElementById('billing_service_desc'+index);
	    argumentArray[0]							= 	sql;
		argumentArray[1]   							= 	dataNameArray ;
		argumentArray[2]   							= 	dataValueArray ;
		argumentArray[3]   							= 	dataTypeArray ;
		argumentArray[4]   							= 	"1,2";
		argumentArray[5]   							= 	billingServiceCode.value;
		argumentArray[6]   							= 	DESC_LINK ;
		argumentArray[7]   							= 	DESC_CODE ;
		retVal 										=   CommonLookup( title, argumentArray );
		if(retVal != null && retVal != "")
		{
			billingServiceCode.value 				= 	retVal[0];
			billingServiceCode.title				=	retVal[0];
			billingServiceDesc.value 				= 	retVal[1];
			billingServiceDesc.title				=	retVal[1];
		}
		else
		{
			billingServiceCode.value 				= 	"";
			billingServiceCode.title				=	"";
			billingServiceDesc.value 				= 	"";
			billingServiceDesc.title				=	"";
		}	    
	}

	function specialityLookup()
	{
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
		retVal 										=   CommonLookup( title, argumentArray );
		if(retVal != null && retVal != "")
		{
			speciality.value 						= 	retVal[0];
		}
		else
		{
			speciality.value			  			=	"";
			
		}	    
	}

function reset()
{

	
	Billing_InterimBill_Search.document.location.reload();
	recordApprovalPatientDataDetails.document.location.href= "../../eCommon/html/blank.html";
	messageFrame.document.location.href= "../../eCommon/html/blank.html";
	interim_Bill_Auth_Bnt.document.getElementById("auth").disabled=true;
	}

function restrictCharacters(event){
	if( (event.keyCode >= 48) && (event.keyCode <= 57) )
		return true ;
else
		return false;
}
 
function apply()  
{
	var auth =parent.frames[2].interim_Bill_Auth_Bnt.document.forms[0].document.getElementById("auth1").value;
	var	table = recordApprovalPatientDataDetails.document.getElementById("interim_Bill_Details_table");
	var rowCount1 =  table.rows.length;
	var doc =recordApprovalPatientDataDetails.document;
	var serchDoc=Billing_InterimBill_Search.document;
	var i=0;
	var count=0;
	var init;
	var rowCount = doc.getElementById("rowCount").value;
		doc.getElementById("finalJSONArr").value = serchDoc.getElementById("selectJsonArrFlag").value;	
		doc.getElementById("finalIndexArr").value = serchDoc.getElementById("selectArrFlag").value;
		var arrLength=serchDoc.getElementById("selectArrFlag").value;
		var indexValues=doc.getElementById("finalIndexArr").value;
		var selctAllFlag=doc.getElementById("Header_select_all").value;
		var finalUnselectindex=doc.getElementById("finalUnselectindex").value;
		if(auth=="Y")
		{
		if(indexValues=="" && selctAllFlag=="N" && finalUnselectindex=="")
		{

			 alert(getMessage('BL1259','BL'));
			 commontoolbarFrame.location.reload();
			 return false;
		}
		else
		{
			 var formObj = recordApprovalPatientDataDetails.document.forms[0];
				formObj.target='messageFrame'; 
				formObj.method="post";
				formObj.action="../../servlet/eBL.BillingInterimbillServlet";
				formObj.submit();
				
				Billing_InterimBill_Search.document.location.reload();
				recordApprovalPatientDataDetails.document.location.href= "../../eCommon/html/blank.html";
		}
	}
	else{
		alert(getMessage('BL9136','BL'));		
		commontoolbarFrame.location.reload();
		return;
	}
	}	
function call_pass_valid()
{
	var user = document.forms[0].user.value;
	var err_msg = document.forms[0].err_msg.value;

	var Reason_code = document.forms[0].Reason_code.value;
	
	if(err_msg!=""){
		alert(getMessage(err_msg,'BL'));
		return false;
	}else{
		var returnArray = new Array ("Y","Y",Reason_code,user,"Y");
		parent.window.returnValue=returnArray;
		parent.window.close();
		return;
	} //V220323
}	

function confirmPasswdchk(obj)
{
	var usr_id=document.forms[0].user_id;
	var pass_wd=document.forms[0].passwd;
	var Reason_code=document.forms[0].Reason_code;
	if(usr_id.value=="")
	{
		alert(getMessage("BL9112","BL"));
		usr_id.focus();
		return false;
	}
	if(pass_wd.value=="")  
	{
		alert(getMessage("BL9113","BL"));
		pass_wd.focus();
		return false;
	}
	var HTMLVal="<html><body><form name='BillingRecordApprovalPasswrdForm' id='BillingRecordApprovalPasswrdForm' method='post' action='../../eBL/jsp/BLinterimUserRightsPasswrdCheck.jsp'>"+
				"<input type='hidden' name='usr_id' id='usr_id' value='"+usr_id.value+"'>"+
				"<input type='hidden' name='pass_wd' id='pass_wd' value='"+pass_wd.value+"'>"+
				"<input type='hidden' name='Reason_code' id='Reason_code' value='"+Reason_code.value+"'>"+
                "<input type='hidden' name='mod_fin_chk' id='mod_fin_chk' value='Y'>"+
				"</form></body></html>";
				parent.frames[1].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
				parent.frames[1].document.BillingRecordApprovalPasswrdForm.submit();
}

async function authUser()
{	
	var dialogHeight= "14" ;
	var dialogWidth	= "22" ;
	var dialogTop = "225" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;	
	retVal =await window.showModalDialog("../../eBL/jsp/InterimBillAuthorizeMain.jsp?",arguments,features);
	parent.interim_Bill_Auth_Bnt.document.forms[0].document.getElementById("auth1").value='Y';
	if(retVal!=undefined)
	{
		var userid=retVal[3];
		var mainAuth=retVal[0]+retVal[1];
		var doc = parent.recordApprovalPatientDataDetails.document;
		var doc1 = parent.Billing_InterimBill_Search.document;
		doc1.getElementById('mainAuth').value=mainAuth;
		var customerGroupCode	=	doc1.getElementById("payer_group").value;
		var customerCode	=	doc1.getElementById("payer").value;
		var policyCode	=	doc1.getElementById("policy").value;
		if(retVal.length>0)
		{
			if(retVal[0]=="Y")
			{	
				var patinetId = doc1.getElementById("patient_id").value;
				var e = doc1.getElementById("episode_type");
				var selectedValue = "";
				for(var j=0; j<e.options.length; j++)
			    {
					if(e.options[j].selected)
						selectedValue=e.options[j].value;
			    }
				var episodeType = "";
				switch(selectedValue)
				{
					case 'OP':	episodeType = 'O';			
								break;
					case 'IP':	episodeType = 'I';				
								break;
					case 'EM':	episodeType = 'E';				
								break;
					case 'DC':	episodeType = 'D';				
								break;			
				}

				var patientName																				=	doc1.getElementById("patient_name").value;
				var encounterId																				=	doc1.getElementById("encounter_id").value;
				var customerGroupCode																		=	doc1.getElementById("payer_group").value;
				var customerCode																			=	doc1.getElementById("payer").value;
				var policyCode																				=	doc1.getElementById("policy").value;		
			if(selectedValue==undefined || selectedValue=='')
				{
					alert(getMessage("BL00028","BL"));
					return;
				}
				
				if(customerGroupCode==undefined || customerGroupCode=='')
				{
					alert(getMessage("BL6277","BL"));
					return;
				}
			
				var speciality = doc1.getElementById('speciality').value;
						doc.getElementById('Header_select_all').disabled = false;
						doc1.getElementById('privilegeYN').value="YY";
						parent.parent.parent.frames[2].frames[0].document.forms[0].apply.disabled = false;
						parent.parent.parent.frames[2].frames[3].document.forms[0].document.getElementById("auth").disabled = true;
						doc1.getElementById("authorizedUserName").value=userid;
						parent.parent.parent.frames[2].frames[2].document.location.href = "../../eBL/jsp/BLInterimBillDetals.jsp?&mode=search&from=1&authorizedUserName="+userid+
						"&mainAuth="+mainAuth+"&privilegeYN=YY&patinetId="+patinetId+"&episodeType="+episodeType+
						"&patientName="+patientName+"&encounterId="+encounterId+"&customerGroupCode="+customerGroupCode+"&customerCode="+customerCode+"&policyCode="+policyCode+"&speciality="+speciality;
						parent.parent.parent.frames[2].frames[5].location.href ="../../eCommon/jsp/error.jsp?err_num=&err_value=" ; 			
				doc1.getElementById('authorizedUserId').value="Y";
				parent.window.close();
						
			}else{
					parent.parent.parent.frames[2].frames[0].document.forms[0].apply.disabled = true;
			}			
		}
	}
}


