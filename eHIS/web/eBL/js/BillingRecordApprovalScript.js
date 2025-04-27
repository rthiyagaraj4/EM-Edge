/*
Sr No            Version            Incident             SCF/CRF           Developer Name
1                V201013            IN73702           NMC-JD-CRF-0042.1     Shikha Seth
2                V201024            IN73702           NMC-JD-CRF-0042.1     Shikha Seth
3                V201027            IN73702           NMC-JD-CRF-0042.1     Shikha Seth
4 		  V211130		      	26231		          KDAH-SCF-0744-TF		  Mohanapriya K
5 		  V220323	    	27763			  MMS-ME-SCF-0052 		Mohana Priya K
6            	 V220413            30399      		 MMS-ME-SCF-0064-TF      Mohanapriya K
7           	 V220627             31872      	  NMC-JD-CRF-0170 US001   Mohanapriya K
8				V220909				  33891		         TH-KW-CRF-0093         Mohanapriya K
9				V221025				 					TH-KW-CRF-0020.7		Mohanapriya
10				V221130				37915			TH-KW-CRF-0084.1			Mohanapriya
11				V230411				40318			MOHE-SCF-0215-TF		Mohanapriya
12 		V230608							MMS-KH-SCF-0199 			Mohanapriya
13				V230711						MOHE-SCF-0247					Mohanapriya
*/
var errorFrame = '';
var dataArr = []; //V220909
var locArr = []; //V221025
async function enCounterIdLookup()

	{
		//alert("2");
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
			partsql="BLINTERNALREP_11::blsql::"; //V230711
		}
		else{
			partsql="BLINTERNALREP_12::blsql::";//V230711
		}
		var sql;
		sql											=	partsql+document.forms[0].facilityId.value+"::"; //V230711
		var title									= 	getLabel("Common.encounterid.label", 'common');
		var argumentArray  							= 	new Array() ;
		var dataNameArray  							= 	new Array() ;
		var dataValueArray 							= 	new Array() ;
		var dataTypeArray  							= 	new Array() ;
		var patientId								=	document.getElementById('patient_id'); 
		if(patientId.value != undefined && patientId.value != null && patientId.value != '')
		{
			sql										=	sql+"AND PATIENT_ID ="+" '"+patientId.value+"'"; //V230711
		}
		if(episodeType != undefined && episodeType != null && episodeType != '')
		{
			sql										=	sql+"AND EPISODE_TYPE ="+" '"+episodeType+"'";
		}
		var encounterId								=	document.getElementById('encounter_id');
		argumentArray[0]							= 	sql;
		argumentArray[1]   							= 	dataNameArray ;
		argumentArray[2]   							= 	dataValueArray ;
		argumentArray[3]   							= 	dataTypeArray ;
		argumentArray[4]   							= 	"1,2";
		argumentArray[5]   							= 	encounterId.value;
		argumentArray[6]   							= 	DESC_LINK ;
		argumentArray[7]   							= 	CODE_DESC;/* Modified by Aravindh/11-04-2018/MMS-DM-CRF-0125/From CODE_DESC */
		//argumentArray[8]   							= 	fieldLegend ;
		retVal 										=   await CommonLookup( title, argumentArray );
		
		var ret1=unescape(retVal);
		var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if(retVal != null && retVal != "")
		{
			encounterId.value 						= 	arr[0];
		}
		else
		{
			encounterId.value			  			=	"";
			
		}
	 
	    
	}


  function defaultGivenDate(ind)
  {
	  
	  var p_appvl =document.getElementById('p_approval_status'+ind).value;
	  var c_appvl=document.getElementById('approval_status'+ind).value;
	  
	  
	  
	  if( p_appvl != 'A' && p_appvl != 'R' && (c_appvl == 'A' || c_appvl =='R'))		   		  
	  document.getElementById('approved_date'+ind).value =	document.forms[0].sys_date.value;
	  
	  var siteId = document.BillingPreApprovalRequestDetailsForm.siteId.value;
	  if(siteId == 'ALKA'){
		  if(c_appvl == 'A'){
			  document.getElementById('reason'+ind).value='APPR';
			  document.getElementById('approval_remarks'+ind).value='Approved';
		  }
		  else if(c_appvl == 'R'){
			  document.getElementById('reason'+ind).value='REJT';
			  document.getElementById('approval_remarks'+ind).value='';
		  }
		  else{
			  document.getElementById('reason'+ind).value='';
			  document.getElementById('approval_remarks'+ind).value='';
		  }
	  }
	  	  
  }
	
	async function payerGroupLookup()
	{
		
		var sql;
		var facility_id = document.forms[0].facilityId.value;
		var locale = document.forms[0].locale.value;
		//sql											=	PAYER_GROUP_LOOKUP_RECORD_PREAPPROVAL+" '" +document.forms[0].locale.value+"'";
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
		argumentArray[4]   							= 	"2,1";             // Modified by Gayathri  for MMS-ICN-00036
		argumentArray[5]   							= 	payerGroup.value;
		argumentArray[6]   							= 	DESC_LINK ;
		argumentArray[7]   							= 	CODE_DESC;/* Modified by Aravindh/11-04-2018/MMS-DM-CRF-0125/From CODE_DESC */
		retVal 										=   await CommonLookup( title, argumentArray );
		
		var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if(retVal != null && retVal != "")
		{
			payerGroup.value 						= 	arr[0];
		}
		else
		{
			payerGroup.value			  			=	"";
			
		}
	 
	    
	}
	
	async function payerLookup()
	{
		var sql;
		var facility_id = document.forms[0].facilityId.value;
		var locale = document.forms[0].locale.value;
		var cust_code = document.forms[0].payer_group.value;
		//sql											=	PAYER_LOOKUP_RECORD_PREAPPROVAL+" '" +document.forms[0].locale.value+"'";
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
		argumentArray[4]   							= 	"2,1";          // Modified by Gayathri  for MMS-ICN-00036
		argumentArray[5]   							= 	payer.value;
		argumentArray[6]   							= 	DESC_LINK ;
		argumentArray[7]   							= 	CODE_DESC;/* Modified by Aravindh/11-04-2018/MMS-DM-CRF-0125/From CODE_DESC */
		retVal 										=   await CommonLookup( title, argumentArray );
		
		var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
		if(retVal != null && retVal != "")
		{
			payer.value 							= 	arr[0];
		}
		else
		{
			payer.value			  					=	"";
			
		}
	 
	    
	}
	
	
	async function callDemographic()
	{
		var doc = parent.recordApprovalPatientDataDetails.document;
		var index = doc.getElementById('printUCAFIndex').value; 
		
		if(index!= undefined && index!='')
			{
		var patient_id 		=	trimString(doc.getElementById('patient_id'+index).innerText) ;
		var retVal 			= 	new String();
		var dialogHeight 	= "93vh" ;
		var dialogWidth  	= "96vw" ;
		var dialogTop    	= "100";
	    var status 			= "no";
		var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
		retVal = await top.window.showModalDialog("../../eCA/jsp/DemographicsView.jsp?patient_id="+patient_id,arguments,features);
			}
		
	}
	
	
	
	async function policyLookup()
	{
		var sql;
		var facility_id = document.forms[0].facilityId.value;
		var locale = document.forms[0].locale.value;
		//sql											=	POLICY_LOOKUP_RECORD_PREAPPROVAL+" '" +document.forms[0].facilityId.value+"'";
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
		argumentArray[4]   							= 	"2,1";     // Modified by Gayathri  for MMS-ICN-00036
		argumentArray[5]   							= 	policy.value;
		argumentArray[6]   							= 	DESC_LINK ;
		argumentArray[7]   							= 	CODE_DESC;/* Modified by Aravindh/11-04-2018/MMS-DM-CRF-0125/From CODE_DESC */
		retVal 										=   await CommonLookup( title, argumentArray );
		
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
			policy.value			  					=	"";
			
		}
	 
	    
	}
	
	
	function showRecordApprovalPatientDeatilsAuth(ind)
	{
				
		var doc = parent.recordApprovalPatientDataDetails.document;
		var episodeType =doc.getElementById('episode_type'+ind).value; 
		if(episodeType == 'I' || episodeType == 'D')
		{
			/* Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/if condition */
			var calledForm = document.forms[0].calledForm.value;
			
			if(calledForm != "serviceApprStatus") {
				doc.getElementById("effective_to"+ind).disabled=false;
				doc.getElementById("eff__to_img"+ind).disabled=false;
			}
		}
			
	}
	
	function showRecordApprovalPatientDeatils()
	{
		
		
		var patinetId = document.getElementById("patient_id").value;
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
		var request_status = document.getElementById("request_status");
		var requestStatus = "";
		for(var j=0; j<request_status.options.length; j++)
	    {
			if(request_status.options[j].selected)
				requestStatus=request_status.options[j].value;
	    }
		var patientName																				=	document.getElementById("patient_name").value;
		var encounterId																				=	document.getElementById("encounter_id").value;
		var customerGroupCode																		=	document.getElementById("payer_group").value;
		var encounterFromDate																		=	document.getElementById("Effective_from").value;
		var encounterToDate																			=	document.getElementById("Effective_to").value;
		var customerCode																			=	document.getElementById("payer").value;
		var policyCode																				=	document.getElementById("policy").value;		
		var enableMCNNumber= document.getElementById('enableMCNNumber').value;//V220909
		if(selectedValue==undefined || selectedValue=='')
		{
			alert(getMessage("BL00028","BL"));
			return;
		}
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
		
		var starr = document.getElementById('Effective_from').value.split("/");
		var enarr = document.getElementById('Effective_to').value.split("/");
		var startdt = new Date();
		var enddt = new Date();
		startdt.setFullYear(starr[2], starr[1]-1, starr[0]);
		enddt.setFullYear(enarr[2], enarr[1]-1, enarr[0]);
		var timeDiff;
		var daysDiff;
		if(startdt>enddt)
		{
			alert(getMessage('BL4115','BL'));
			return;
		}
		timeDiff = enddt.getTime() - startdt.getTime();
		daysDiff =  Math.floor(timeDiff / (1000 * 60 * 60 * 24));
		
		//AAKH SCF 222
		var daysRestrict = document.getElementById('restrictDate').value;
		if(daysRestrict != ''){
			var actualDays = parseInt(daysRestrict)-1;
			if(daysDiff > actualDays)
			{
					alert("Encounter To Date Cannot be greater than "+daysRestrict+" Days from Encounter from Date");
					return;
			}
		}
		//AAKH SCF 222
				
		/* Added V190219-Aravindh/MMS-ICN-0114/Starts */
		var calledForm = document.forms[0].calledForm.value;
		var dayDiff = 31;
		if(calledForm == "serviceApprStatus") {
			if(patinetId == "" && encounterId =="") {
				if (daysDiff > dayDiff - 1) {
					alert("Encounter To Date Cannot be greater than " + dayDiff + " Days from Encounter from Date");
					return false;
				}
			}
		}
		/* Added V190219-Aravindh/MMS-ICN-0114/Ends */
		
		document.getElementById("add_mod").disabled=true;	

		/*if (daysDiff > 30) {
		alert("Encounter To Date Cannot be greter than 30 Days from Encounter from Date");
		return;
		}*/
		var speciality =  document.forms[0].speciality.value;
		
		/* Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/Starts */
		//var calledForm = document.forms[0].calledForm.value;  //Commented V190219-Aravindh/MMS-ICN-????/Moved this line above
		var servGrpCode = "";
		var servClsfctnCode = "";
		var orderStatus = "";
		if(calledForm == "serviceApprStatus") {
			servGrpCode = document.forms[0].service_group.value;
			servClsfctnCode = document.forms[0].service_classification.value;
			orderStatus = document.forms[0].order_status.value;
			document.forms[0].serviceGroupHid.value = document.forms[0].service_group.value;
			document.forms[0].serviceClassficationHid.value = document.forms[0].service_classification.value;
			document.forms[0].orderStatusHid.value = document.forms[0].order_status.value;
		}
		/* Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/Ends */
		
		
		/* Added 3 more parameters 'servGrpCode, servClsfctnCode, orderStatus'/Added by Aravindh/11-04-2018/MMS-DM-CRF-0125 */
		/* Added V190103-Aravindh/MMS-DM-CRF-0125/if-else */
		if(calledForm == "serviceApprStatus") {
			parent.recordApprovalPatientDataDetails.location.href = "../../eBL/jsp/BLServiceApprovalPatientDataDetails.jsp?patinetId="+patinetId+"&episodeType="+episodeType
			+"&patientName="+patientName+"&encounterId="+encounterId+"&customerGroupCode="+customerGroupCode+"&encounterFromDate="+encounterFromDate+"&encounterToDate="+encounterToDate
			+"&customerCode="+customerCode+"&policyCode="+policyCode+"&requestStatus="+requestStatus+"&speciality="+speciality
			+"&servGrpCode="+servGrpCode+"&servClsfctnCode="+servClsfctnCode+"&orderStatus="+orderStatus+"&calledForm="+calledForm+"&operationMode=search";
		} else {
			parent.recordApprovalPatientDataDetails.location.href = "../../eBL/jsp/BillingRecordApprovalPatientDataDetails.jsp?patinetId="+patinetId+"&episodeType="+episodeType
			+"&patientName="+patientName+"&encounterId="+encounterId+"&customerGroupCode="+customerGroupCode+"&encounterFromDate="+encounterFromDate+"&encounterToDate="+encounterToDate
			+"&customerCode="+customerCode+"&policyCode="+policyCode+"&requestStatus="+requestStatus+"&speciality="+speciality
			+"&servGrpCode="+servGrpCode+"&servClsfctnCode="+servClsfctnCode+"&orderStatus="+orderStatus+"&calledForm="+calledForm+"&enableMCNNumber="+enableMCNNumber;		//V220909	
		}
		
		parent.recordApprovalPatientDataBtn.location.href = "../../eBL/jsp/BillingRecordApprovalPatientDataBtn.jsp?calledForm="+calledForm+"&enableMCNNumber="+enableMCNNumber;//V220909
		parent.recordPreApprovalRecordDetails.location.href ="../../eCommon/html/blank.html";
		parent.recordPreApprovalRecordBtn.location.href = 	"../../eCommon/html/blank.html";
	}

	/* function added by karthik for MMS-QH-CRF-0165 to set the modified effectiveto date  */
	function setModifiedEffectiveToDate(index){
		
		var serviceListForm=parent.recordPreApprovalRecordDetails.document.BillingPreApprovalRequestDetailsForm;
	   	if(serviceListForm!=null && serviceListForm.authorized.value=='Y'){
		  var modifiedDate= showCalendar('effective_to'+index);		  
	   	  serviceListForm.document.getElementById('effectiveToModified').value='Y';
		  return modifiedDate;
		}
		else{
			alert("Authorization Needed to Change Effective To Date ");
		}	   	
	}		
	
	function showRecordApprovalRequestDetails(index)
	{		
		var indd= document.getElementById('printUCAFIndex').value;
		var enableMCNNumberYN=document.getElementById("enableMCNNumber").value;//V220909
		var site_spec=document.getElementById('siteSpec').value;
		var calledForm = document.forms[0].calledForm.value;/* Added by Aravindh/11-04-2018/MMS-DM-CRF-0125 */
		
		if(indd==index) return;
		
		if(indd != -1)
		{
			var doc = parent.recordApprovalPatientDataDetails.document;
			
			/* Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/if condition */
			if(calledForm != "serviceApprStatus") {
				doc.getElementById("effective_to"+indd).disabled=true;
				doc.getElementById("eff__to_img"+indd).disabled=true;			
			}
		}
		
		document.getElementById('prevIndex').value=indd;		
		document.getElementById('printUCAFIndex').value = index;
		/*document.getElementById('patient_id'+index).focus();
		document.getElementById('patient_id'+index).select();
		*//*document.getElementById('srl_no'+index).style.fontWeight = 'bold';
		document.getElementById('patient_id'+index).style.fontWeight = 'bold';
		document.getElementById('patient_name'+index).style.fontWeight = 'bold';
		document.getElementById('episode_id'+index).style.fontWeight = 'bold';
		document.getElementById('encounter_id'+index).style.fontWeight = 'bold';
		document.getElementById('policy'+index).style.fontWeight = 'bold';
		document.getElementById('payer_group'+index).style.fontWeight = 'bold';
		document.getElementById('payer'+index).style.fontWeight = 'bold';
		document.getElementById('age'+index).style.fontWeight = 'bold';
		document.getElementById('mobile_number'+index).style.fontWeight = 'bold';
		document.getElementById('policy_effective_from'+index).style.fontWeight = 'bold';
		document.getElementById('effective_to'+index).style.fontWeight = 'bold';
		document.getElementById('approved_amount'+index).style.fontWeight = 'bold';*/
		var patinetId 		=	trimString(document.getElementById('patient_id'+index).innerText) ;
		var episodeType		=	trimString(document.getElementById('episode_type'+index).value) ;
		var episodeId		=	trimString(document.getElementById('episode_id'+index).innerText) ;
		var visitId			=	trimString(document.getElementById('visit_id'+index).value );
		var priority		=	trimString(document.getElementById('priority'+index).value);
		var acctSeqNo		=	trimString(document.getElementById('acct_seq_no'+index).value);
		var encounterId		=   trimString(document.getElementById('encounterId'+index).value);
		
		//var billingGrpId	=	document.getElementById('billing_grp_id'+index).value;
		var policyTypeCode	=	trimString(document.getElementById('p_policy'+index).value);
		var custGroupCode   =  	trimString(document.getElementById('p_payer_group'+index).value);
		var custCode   		=  	trimString(document.getElementById('p_payer'+index).value);
		var policyNumber	=  	trimString(document.getElementById('policy_number'+index).value);
		var requestStatus	=	trimString(document.getElementById('requestStatus').value);
		var approvedAmount	=	trimString(document.getElementById('approved_amount'+index).innerText);
		var expiryDate		=   trimString(document.getElementById('expiry_date'+index).value); //Karthik Record approval   -  MMS-QH-CRF-0165
		var effectiveTo		=   trimString(document.getElementById('effective_to'+index).value); 
		var membershipNo	=   trimString(document.getElementById('membershipno'+index).value); 
		/* Added by karthik for MMS-QH-CRF-0165 - refreshPage Change allows both 
		 * Servicelist Page and  PatientList page(EffectiveTo details) to be modified Simultaneously - Starts*/
		
		/* Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/Starts */
		var calledForm = document.forms[0].calledForm.value;
		
		if(calledForm == "serviceApprStatus") {
			var servGrpCode = "";
			var servClsfctnCode = "";
			var orderStatus = "";
			
			servGrpCode = document.forms[0].service_group.value;
			servClsfctnCode = document.forms[0].service_classification.value;
			orderStatus = document.forms[0].order_status.value;
				
			parent.recordPreApprovalRecordDetails.location.href = "../../eBL/jsp/BillingPreApprovalRequestStatusDetails.jsp?patinetId="+patinetId+"&episodeType="+episodeType
			+"&episodeId="+episodeId+"&visitId="+visitId+"&priority="+priority+"&acctSeqNo="+acctSeqNo+"&encounterId="+encodeURIComponent(encounterId)+"&policyTypeCode="+encodeURIComponent(policyTypeCode)
			+"&custGroupCode="+custGroupCode+"&custCode="+custCode+"&policyNumber="+policyNumber+"&requestStatus="+requestStatus+"&approvedAmount="+approvedAmount+"&expiryDate="+expiryDate+"&effectiveTo="+effectiveTo+"&site_spec="+site_spec
			+"&servGrpCode="+servGrpCode+"&servClsfctnCode="+servClsfctnCode+"&orderStatus="+orderStatus+"&calledForm="+calledForm;
			
			parent.recordPreApprovalRecordBtn.location.href = "../../eBL/jsp/BillingPreApprovalRequestDetailsBtn.jsp?calledForm="+calledForm;
		} else {
			if(enableMCNNumberYN=="Y"){
				parent.recordApprovalPatientDataBtn.document.getElementById("auto_fill").disabled=false;//V220909
			}
			parent.recordPreApprovalRecordDetails.location.href = "../../eBL/jsp/BillingPreApprovalRequestDetails.jsp?patinetId="+patinetId+"&episodeType="+episodeType
			+"&episodeId="+episodeId+"&visitId="+visitId+"&priority="+priority+"&acctSeqNo="+acctSeqNo+"&encounterId="+encodeURIComponent(encounterId)+"&policyTypeCode="+encodeURIComponent(policyTypeCode)
			+"&custGroupCode="+custGroupCode+"&custCode="+custCode+"&policyNumber="+policyNumber+"&requestStatus="+requestStatus+"&approvedAmount="+approvedAmount+"&expiryDate="+expiryDate+"&effectiveTo="+effectiveTo+"&site_spec="+site_spec+"&enableMCNNumberYN="+enableMCNNumberYN+"&calledForm="+calledForm+"&membershipNo="+membershipNo;//V230102
	
			parent.recordPreApprovalRecordBtn.location.href = "../../eBL/jsp/BillingPreApprovalRequestDetailsBtn.jsp?episodeType="+episodeType+"&patinetId="+patinetId+"&episodeId="+episodeId+"&visitId="+visitId+"&encounterId="+encodeURIComponent(encounterId)+"&calledForm="+calledForm+"&membershipNo="+membershipNo; //V221130
		}
		/* Added by Aravindh/11-04-2018/MMS-DM-CRF-0125/Ends */		
	}
	
	async function reasonCodeLookup(index)
	{
		var sql;
		//sql											=	PRE_APPROVAL_REQUEST_REASONCODE_LOOKUP+" '" +document.forms[0].locale.value+"'";
		sql="BLINTERNALREP_9::blsql::"+document.forms[0].locale.value+"::";//V230411
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
		retVal 										=   await CommonLookup( title, argumentArray );
					var ret1=unescape(retVal);
				 	var arr=ret1.split(",");
				 	if(arr[1]==undefined) 
			 		{
				 		arr[0]="";	
				 		arr[1]="";	
			 		}
		if(retVal != null && retVal != "")
		{
			reason.value 							= 	arr[0];
			reason.title							=	arr[0];
		}
		else
		{
			reason.value			  				=	"";
			reason.title							=	"";
		}	    
	}

	async function billingServiceCodeLookup(index)
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
		retVal 										=   await CommonLookup( title, argumentArray );
					var ret1=unescape(retVal);
				 	var arr=ret1.split(",");
				 	if(arr[1]==undefined) 
			 		{
				 		arr[0]="";	
				 		arr[1]="";	
			 		}
		if(retVal != null && retVal != "")
		{
			billingServiceCode.value 				= 	arr[0];
			billingServiceCode.title				=	arr[0];
			billingServiceDesc.value 				= 	arr[1];
			billingServiceDesc.title				=	arr[1];
		}
		else
		{
			billingServiceCode.value 				= 	"";
			billingServiceCode.title				=	"";
			billingServiceDesc.value 				= 	"";
			billingServiceDesc.title				=	"";
		}	    
	}

	async function specialityLookup()
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
		argumentArray[7]   							= 	CODE_DESC;/* Modified by Aravindh/11-04-2018/MMS-DM-CRF-0125/From CODE_DESC */
		retVal 										=   await CommonLookup( title, argumentArray );
		
		var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			
		if(retVal != null && retVal != "")
		{
			speciality.value 						= 	arr[0];
		}
		else
		{
			speciality.value			  			=	"";
			
		}	    
	}

function addNewRow(tableId)
{
	table = document.getElementById(tableId);
	var objDiv = document.getElementById("record_approval_detaile_div");
	var rowCount =  table.rows.length;  
	/*for(var k=0;k<rowCount;k++)
	{
		if(document.getElementById(patient_id+k).value == "")
		{
			alert(getMessage("BL6103","BL"));
			objDiv.scrollTop = objDiv.scrollHeight;
			window.scrollTo(0, objDiv.scrollHeight); 
			return;
		}
	}*/
	var i=rowCount; 
	var index;
	index = i;//-1;
	var row =  table.insertRow(i);
	var cell1=row.insertCell(0);
	var cell2=row.insertCell(1);
	var cell3=row.insertCell(2);
	var cell4=row.insertCell(3);
	var cell5=row.insertCell(4);
	var cell6=row.insertCell(5); 
	var cell7=row.insertCell(6);
	var cell8=row.insertCell(7);
	var cell9=row.insertCell(8);
	var cell10=row.insertCell(9);
	var cell11=row.insertCell(10);
	//var cell12=row.insertCell(10);
	//var cell6=row.insertCell(5);
	cell1.innerHTML="<select 					name='included_excluded"+index+"' 					id='included_excluded"+index+"' 					style='width:110px;'><option>B</option><option>G</option><option>L</option></select>";
	cell2.innerHTML="<input type ='text' 	 	name='billing_service_code"+index+"'  				id='billing_service_code"+index+"'	 								size=10 	onKeyPress='return lockbackSpace();' onBlur='return billingServiceCodeLookup("+index+"); ' /><input type='button' class='button' name='patientidbut"+index+"' value='?' onClick='return billingServiceCodeLookup("+index+");'  tabindex='2'>";
	cell3.innerHTML="<input type ='text' 		name='billing_service_desc"+index+"'   				id='billing_service_desc"+index+"' 								 	size=11 	onBlur='ChangeUpperCase( this );'onKeyPress='return CheckForSpecChar1(event);lockbackSpace();'     		/>";
	cell4.innerHTML="<input type ='text' 		name='service_date"+index+"'   						id='service_date"+index+"' 										 	size=7      onKeyPress='return CheckForSpecChar1(event);lockbackSpace();'  											/><img src='../../eCommon/images/CommonCalendar.gif' onClick='return showCalendar(\"service_date"+index+"\");'  onKeyPress='return lockbackSpace();'>";
	cell5.innerHTML="<input type ='text' 	 	name='available_service_amount"+index+"'  			id='available_service_amount"+index+"'	 							size=10 	onKeyPress='return lockbackSpace();'  />";
	cell6.innerHTML="<input type ='text' 		name='approved_date"+index+"'   					id='approved_date"+index+"' 									 	size=7	 	onBlur='ChangeUpperCase( this );'onKeyPress='return CheckForSpecChar1(event);lockbackSpace();'     		/><img src='../../eCommon/images/CommonCalendar.gif' onClick='return showCalendar(\"approved_date"+index+"\");'  onKeyPress='return lockbackSpace();'>";
	cell7.innerHTML="<input type ='text' 	 	name='approval_number"+index+"'  					id='approval_number"+index+"'	 									size=10 	onKeyPress='return lockbackSpace();' onBlur='return additionalPatValidation(this,"+index+"); ' />";
	cell8.innerHTML="<input type ='text' 		name='approval_status"+index+"'   					id='approval_status"+index+"' 									 	size=3	 	onBlur='ChangeUpperCase( this );'onKeyPress='return CheckForSpecChar1(event);lockbackSpace();'     		/>";
	cell9.innerHTML="<input type ='text' 	 	name='reason"+index+"'  							id='reason"+index+"'	 											size=5	 	onKeyPress='return lockbackSpace();' onBlur='return reasonCodeLookup("+index+"); ' /><input type='button' class='button' name='patientidbut"+index+"' value='?' onClick='return reasonCodeLookup("+index+");'  tabindex='2'>";
   cell10.innerHTML="<input type ='text' 		name='approval_remarks"+index+"'   					id='approval_remarks"+index+"' 									 	size=4	 	onBlur='ChangeUpperCase( this );'onKeyPress='return CheckForSpecChar1(event);lockbackSpace();'     		/>";
   cell11.innerHTML="<input type ='checkbox'	name='select_all"+index+"'   						id='select_all"+index+"' 						 								onBlur='ChangeUpperCase( this );'onKeyPress='return CheckForSpecChar1(event);lockbackSpace();'     		/><input type='hidden'  	    name='type"+index+"'  								id='type"+index+"'	 												size=0		value=\"insert\"		 />";
  // cell12.innerHTML="<input type='hidden'  	    name='type"+index+"'  								id='type"+index+"'	 												size=0		value=\"insert\"		 />";
	objDiv.scrollTop = objDiv.scrollHeight;
	window.scrollTo(0, objDiv.scrollHeight);	
}

function CopyValue(index)
{
	if((document.getElementById('copyIndex').value!=undefined && document.getElementById('copyIndex').value =='') && document.getElementById('copyIndex').value!=index)
	{
		//alert("INSIDE IF");
		document.getElementById('select_all'+index).disable=true;
		document.getElementById('copyIndex').value=index;
	}	
}

function copySelected(index)
{
	//copyIndex = document.getElementById('copyIndex').value;
	
	let copyIndex = document.getElementById('copyIndex')?.value || '0'; 



	document.getElementById('app_req_date'+index).value		=	document.getElementById('app_req_date'+copyIndex).value;
	document.getElementById('approved_date'+index).value	=	document.getElementById('approved_date'+copyIndex).value;
	document.getElementById('approval_number'+index).value	=	document.getElementById('approval_number'+copyIndex).value;
	document.getElementById('approval_status'+index).value	=	document.getElementById('approval_status'+copyIndex).value;
	document.getElementById('reason'+index).value			=	document.getElementById('reason'+copyIndex).value;
	document.getElementById('approval_remarks'+index).value	=	document.getElementById('approval_remarks'+copyIndex).value;
	
	document.getElementById('app_req_date'+index).title		=	document.getElementById('app_req_date'+copyIndex).value;
	document.getElementById('approved_date'+index).title	=	document.getElementById('approved_date'+copyIndex).value;
	document.getElementById('approval_number'+index).title	=	document.getElementById('approval_number'+copyIndex).value;
	document.getElementById('approval_status'+index).title	=	document.getElementById('approval_status'+copyIndex).value;
	document.getElementById('reason'+index).title			=	document.getElementById('reason'+copyIndex).value;
	document.getElementById('approval_remarks'+index).title	=	document.getElementById('approval_remarks'+copyIndex).value;
}

function closeRecApr(){
	window.close();
}

function reset()
{
	/* Commented By Aravindh/11-04-2018/MMS-DM-CRF-0125 */
	//parent.frames[2].BillingRecordApproval.document.location.reload();
	/* Added By Aravindh/11-04-2018/MMS-DM-CRF-0125 */
	var calledForm="";
		if(parent.frames[1].frames[3]!=undefined){
			//calledForm=parent.frames[1].frames[3].BillingPreApprovalRequestDetailsForm.document.forms[0].calledForm.value;
			calledForm=parent.frames[1].frames[3].document.forms[0].calledForm.value;
		}
		else{
			//calledForm=parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.document.forms[0].calledForm.value;
			calledForm=parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.document.forms[0].calledForm.value;

		}
	//V221227
	if(calledForm=='ApprStsTrack' || calledForm=='preAuthStsTrack'){
		window.close();
	}//V221227
	else{
		parent.frames[2].document.location.reload();
	}
}

//Function to disable all special characters in master codes.
function restrictCharacters(event){
	if( (event.keyCode >= 48) && (event.keyCode <= 57) )
		return true ;
else
		return false;
}

//V221027
function CheckForSpecChars_loc(event,obj){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}


function CheckForSpecChar(event,obj){
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
	if(obj.value.length!=0)
	{
		for(var i=0;i<obj.value.length;i++){
			var curChar = obj.value.charAt(i);
			var chck=strCheck.indexOf(curChar) ;
	
			if(chck==-1){
				alert(getMessage("BL8510", 'BL'));
				obj.value = "";
				obj.focus();
				return false;
			}
		}
	}
	return true ;
}
//V221027
function  verifyMandatory()
{		
	var reqd_date;
	var apprvd_date;
	var apprNum;
	var reason ;
	var remarks;
	var cou;
	//V230102
	var calledForm="";
		if(parent.frames[1].frames[3]!=undefined){
			calledForm=parent.frames[1].frames[3].document.getElementById('calledForm').value;
		}else{
			//calledForm=parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.document.forms[0].calledForm.value;
			calledForm=parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.document.getElementById('calledForm').value;

		}
	//V221227
	if(calledForm=='ApprStsTrack' || calledForm=='preAuthStsTrack'){
		var doc = parent.frames[1].recordApprovalPatientDataDetails.recordApprovalPatientData.document;
		//var rowLength = doc.getElementById("panel_categories_header_table").rows.length;
		var rowLength = parent.frames[1].recordApprovalPatientDataDetails.recordApprovalPatientData.document.getElementById("panel_categories_header_table").rows.length;
		var parDoc=parent.frames[1].frames[3].BillingPreApprovalRequestDetailsForm.document;
		var obj1=parent.frames[1].frames[3].BillingPreApprovalRequestDetailsForm;
		var obj = parent.frames[1].recordApprovalPatientDataDetails.recordApprovalPatientData.document;
		var locale = parent.frames[1].frames[3].BillingPreApprovalRequestDetailsForm.document.forms[0].locale.value;
		var authorized 			=	parent.frames[1].frames[3].BillingPreApprovalRequestDetailsForm.document.getElementById('authorized').value;
		var isUserCanAcess 		=	parent.frames[1].frames[3].BillingPreApprovalRequestDetailsForm.document.getElementById('isUserCanAcess').value;
		if(!(authorized == "Y" && isUserCanAcess == "Y")){
			alert(getMessage('BL9136','BL'));
			commontoolbarFrame.location.reload();
			return false;
		}//52174
	}
	else{
		// START - CRF 0165 - Record approval- effective date mandatory Field
    		var doc = parent.frames[2].BillingRecordApproval.recordApprovalPatientDataDetails.document;
		//var rowLength = doc.getElementById("panel_categories_header_table").rows.length;
		var rowLength =doc.getElementById("panel_categories_header_table").rows.length;		
		var parDoc=parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.document;
		var obj1=parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm;//V230102
		var obj = parent.frames[2].BillingRecordApproval.recordApprovalPatientDataDetails.recordApprovalPatientData.document;
		//var locale = parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.document.forms[0].locale.value;
		var locale = parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.document.forms[0].locale.value;
	}//V230102
	
	if(parDoc.forms[0].episodeType.value=='I' || parDoc.forms[0].episodeType.value=='D'){		
	if(obj !=undefined)
	{
		var rowCount = obj.getElementById("panel_categories_header_table").rows.length;

		for(var prevInd=0;prevInd<(rowCount-2);prevInd++)
		{	
			var sno=obj.getElementById('srl_no'+prevInd).className;			

			if(sno == 'YELLOW'){
			//	var locale = parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.document.forms[0].locale.value;//V230102 commented

				var effectiveToDate=obj.getElementById('effective_to'+prevInd).value;
				var policyExpDate			=	obj.getElementById('expiry_date'+prevInd).value;		
				var effectiveFromDate			=	obj.getElementById('policy_effective_from'+prevInd).innerText;	
				var effectiveToDate_prev= obj.getElementById('effective_to_org'+prevInd).value;			
				if(effectiveToDate==undefined || effectiveToDate=='')
				{
					alert(getMessage("BL9566","BL"));
					obj.getElementById('effective_to'+prevInd).focus();
					obj.getElementById('effective_to'+prevInd).value=obj.getElementById('effective_to_org'+prevInd).value;
					return false;
				}
				if(policyExpDate==undefined || policyExpDate=='')
				{
					alert(getMessage("BL9105","BL"));
					return false;
				}
				
				var starr = effectiveToDate.split("/");
				var enarr = policyExpDate.split("-");
				var effFrmArr=effectiveFromDate.split("/");

				var startdt = new Date();
				var enddt = new Date();
				var effFrmDt=new Date();
				startdt.setFullYear(starr[2], starr[1]-1, starr[0]);
				enddt.setFullYear(enarr[0], enarr[1]-1, enarr[2]);
				effFrmDt.setFullYear(effFrmArr[2], effFrmArr[1]-1, effFrmArr[0]);				

				if(startdt<effFrmDt){
					alert("Policy Effective To Date should not be less than Policy Effective From Date");
					//document.getElementById('effective_to'+index).value='';
				
					obj.getElementById('effective_to'+prevInd).focus();
					return false;
				}
				
				if(startdt>enddt)
				{					
					alert(getMessage('BL00965','BL'));		
				//	document.getElementById('effective_to'+index).value='';
				
					obj.getElementById('effective_to'+prevInd).focus();
					return false;
				}				
		//		parent.frames[2].recordPreApprovalRecordDetails.document.BillingPreApprovalRequestDetailsForm.effectiveTo.value=effectiveToDate_prev;
			}
			}
		}
	}	
	for(var row=0;row<(rowLength-2);row++)
	{
		
	var policyExpDate			=	doc.getElementById('effective_to'+row).value;	

	if(policyExpDate==undefined || policyExpDate=='')
	{
		alert(getMessage("BL9105","BL"));
		return false;
	}
	}
	//ENDS
	//if(parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm !=undefined)
	if(obj1 !=undefined)
	{
	//var obj = parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.document;//V230102
	var obj = parDoc;//V230102
	var rowCount = obj.getElementById("record_approval_details_table").rows.length;
	for(var prevInd=0;prevInd<(rowCount-2);prevInd++)
	{
	aprvsts = obj.getElementById('approval_status'+prevInd).value;
	
	/* Karthik added for adding Package Association along with subscription MMS-QH-CRF-0165 - Starts*/

	//var request_status=parent.frames[2].BillingRecordApproval.recordApprovalSearch.recordApproval.request_status.value;
	var  request_status=obj.getElementById('approval_status'+prevInd).value;
	var  reasonchk = obj.getElementById('reason'+prevInd).value;
	var  remarkschk = obj.getElementById('approval_remarks'+prevInd).value;
	/*V220909 Starts*/

	var enableMCNNumberYN=obj.getElementById('enableMCNNumberYN').value; //ME region
	if(enableMCNNumberYN=='Y'){
		if(request_status=='A' || request_status=='H' || request_status=='R'){
		var  mcn = obj.getElementById('MCN_number'+prevInd).value;
		if(mcn==''){
			alert("Please enter MCN number");
			obj.getElementById('MCN_number'+prevInd).focus();
			return false;
		}
		}
	}
	
	/*V220909 Ends*/
	//if(request_status=='S'){
	if(request_status=='R' || request_status=='H' || request_status=='C'){
		if(reasonchk==''){
			//alert("Reason Should be Provided for Request status 'Sent to Insurance'");
			alert("Reason Should be Provided for Request status 'Rejected/Hold/Clarification'");
			commontoolbarFrame.location.reload();
			return false;
		}
	}
	if(request_status=='R' || request_status=='H' || request_status=='C'){
		if(remarkschk==''){
			alert("Remarks Should be Provided for Request status 'Rejected/Hold/Clarification'");
			commontoolbarFrame.location.reload();
			return false;
		}
	}
	/* Karthik added for adding Package Association along with subscription MMS-QH-CRF-0165 - Ends*/
	// to enable upload document in case of Clarification sts updated NMC-JD-CRF-0102.2
	var siteSpecUploadDoc=obj.getElementById('siteSpecUploadDoc').value;
	if(siteSpecUploadDoc=="Y"){	
		var episodeType=obj.getElementById('episodeType').value;
		var docCnt=obj.getElementById('docCnt').value;
		if(request_status=='C' && episodeType=="O" && docCnt!="0"){  
			var file=obj.getElementById('UpdDoc'+prevInd).value;
			if(file!=''){
				/*alert("Please Provide Clarification Document");
				obj.getElementById("DocUplYN"+prevInd).value="N";
				commontoolbarFrame.location.reload();
				return false;
			}else{*/
				idxDot = file.lastIndexOf(".") + 1,
				 extFile = file.substr(idxDot, file.length).toLowerCase();
			     if (extFile=="pdf"){
			    	 //var myFSO = new ActiveXObject("Scripting.FileSystemObject");
					 var myFSO = "";
			    	var thefile = myFSO.getFile(file);
			 		var size = thefile.size;
			 		var sizeInMB = (size / (1024*1024)).toFixed(2);
			 		if(sizeInMB>=2){	
			 			//alert("Uploading File size must be less than 2MB");
			 			alert(getMessage("BL0990", 'BLEXT'));
			 			obj.getElementById("DocUplYN"+prevInd).value="N";
			 			commontoolbarFrame.location.reload();
			 			return false;
			 		}
			    	
			     }else{
			    	// alert("Only pdf files are allowed!");
			    	 alert(getMessage("BL0991", 'BLEXT'));
			    	 obj.getElementById("DocUplYN"+prevInd).value="N";
			    	 commontoolbarFrame.location.reload();
			    	 return false;
			     }
			}
		
		}else if(request_status=='C' && episodeType=="O" && docCnt=="0"){
		//	alert("Please Provide Clarification Document");
 			alert(getMessage("BL0992", 'BLEXT'));
			obj.getElementById("DocUplYN"+prevInd).value="N";
			commontoolbarFrame.location.reload();
			return false;
		}
	}
	
	 if(aprvsts =='A')
	    {
	  reqd_date = obj.getElementById('app_req_date'+prevInd).value;
	  apprvd_date = obj.getElementById('approved_date'+prevInd).value;
	  apprNum  = obj.getElementById('approval_number'+prevInd).value;
	  reason = obj.getElementById('reason'+prevInd).value;
	  remarks = obj.getElementById('approval_remarks'+prevInd).value;
	  
	  if((reqd_date == null || reqd_date == undefined || reqd_date == ''||reqd_date == 'undefined') ||
			  (apprvd_date ==null || apprvd_date == undefined || apprvd_date == '' || apprvd_date == 'undefined') ||
			  (apprNum ==null || apprNum == undefined || apprNum == ''|| apprNum == 'undefined'))
			  //commented for CRF 0165 - Record approval changes 
//			  (reason ==null || reason == undefined || reason == ''|| reason == 'undefined') ||
//			  (remarks ==null || remarks == undefined || remarks == ''|| remarks == 'undefined'))
			  {
		  	 cou = prevInd + 1;
	      alert('All mandatory fields to be filed for Row ['+ cou+']'); 	
	      errorFrame = 'All mandatory fields to be filed for Row ['+ cou+']';
	      //obj.getElementById('approval_status'+prevInd).setFocus();
	      obj.getElementById('approval_status'+prevInd).focus();
	      return false;
	  }
	    } 
	}
	}
	 return true;
}

function create() 
{	
	
}
 
async function apply()  
{
	//V230904-NMC-JD-CRF-0102.2
	var patientId		 ="";
	var episodeType		 ="";
	var episodeId		 ="";
	var visitId			 ="";
	var encounterId		 ="";
	var policyTypeCode	 ="";
	var custGroupCode	 ="";
	var custCode		 ="";
	var accountSeqNo	 ="";
	var priority		 ="";
	var policyNumber	 ="";
	var expiryDate		 ="";
	var effectiveToDate  ="";
	var sysDateTime      ="";
	var authorizedUserId ="";
	var siteId           ="";
	var recalc_charges="";
	var insuranceClr="";
	var membershipNo="";
	
	//V221227
		var calledForm="";
		if(parent.frames[1].frames[3]!=undefined){
			calledForm=parent.frames[1].frames[3].BillingPreApprovalRequestDetailsForm.document.getElementById("calledForm").value;
		}else{
			//console.log("1  "+parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm);
			//console.log("2  "+parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.document.BillingPreApprovalRequestDetailsForm.calledForm.value);
			//console.log("3  "+parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.document.getElementById('calledForm'));
			calledForm=parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.document.getElementById('calledForm').value;
		}
	//V221227
	if(verifyMandatory()==true)
	{
		//Added for MMS-DM-SCF-0083
		if(calledForm=='ApprStsTrack' || calledForm=='preAuthStsTrack'){
			var preAppFrm = parent.frames[1].frames[3].BillingPreApprovalRequestDetailsForm;
		}else{
			var preAppFrm = parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm;
		}
		//var preAppFrm = parent.frames[1].frames[3].BillingPreApprovalRequestDetailsForm;
		var facilityId = preAppFrm.facilityId.value;
		var patId = preAppFrm.patinetId.value;
		var episodeType = preAppFrm.episodeType.value;
		var episodeId = preAppFrm.episodeId.value;
		var visitId = preAppFrm.visitId.value;
		
		var reqId = checkJobStatusForEncounter(facilityId,
															patId,
															episodeType,
															episodeId,
															visitId);
		
		if(reqId > 0){
			var dialogHeight= "17" ;
			var dialogWidth	= "37" ;
			var dialogTop = "225" ;
			var center = "1" ;														   
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			var arguments	= "" ;	
			//var modPatientId = document.getElementById("hiddenPatientId").value;
			retVal = await window.showModalDialog("../../eBL/jsp/BLCheckProcessedCount.jsp?closeDisable=Y&reqId="+reqId,arguments,features); 
			if(retVal != 'Y' && retVal != 'F'){
				alert('Cannot save changes, while financial calculation in progress');
				commontoolbarFrame.location.reload();
				return;
			}
			alert('Financial Calaculation is completed for the Previous Request, Save Again');
			commontoolbarFrame.location.reload();
			return;
		}
		//Added for MMS-DM-SCF-0083
		//V221227
		/*
		if(parent.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.document.getElementById("calledForm").value=="ApprStsTrack"){
			var doc=parent.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.document;
		}
		*/
		//V221227
		var filePath="";
		var siteSpecUploadDoc="N";
	if(calledForm=='ApprStsTrack' || calledForm=='preAuthStsTrack'){
		var rowCount = parent.frames[1].frames[3].BillingPreApprovalRequestDetailsForm.document.getElementById("record_approval_details_table").rows.length;
		parent.frames[1].frames[3].BillingPreApprovalRequestDetailsForm.document.forms[0].rowCount.value=rowCount;
		var authorized 			=	parent.frames[1].frames[3].BillingPreApprovalRequestDetailsForm.document.getElementById('authorized').value;
		var isUserCanAcess 		=	parent.frames[1].frames[3].BillingPreApprovalRequestDetailsForm.document.getElementById('isUserCanAcess').value;
		var dtlsform 		=	parent.frames[1].frames[3].BillingPreApprovalRequestDetailsForm;
		var btnFrame = parent.frames[1].frames[4].document.billpreApprovalRequestDetailBtn;
		filePath =parent.frames[1].frames[3].BillingPreApprovalRequestDetailsForm.document.getElementById("filePath").value;
		siteSpecUploadDoc =parent.frames[1].frames[3].BillingPreApprovalRequestDetailsForm.document.getElementById("siteSpecUploadDoc").value;
		/*var doc = parent.frames[1].recordApprovalPatientDataDetails.recordApprovalPatientData.document;
		var rowLength = doc.getElementById("panel_categories_header_table").rows.length;
		alert("rowLength "+rowLength);
		var parDoc=parent.frames[1].frames[3].BillingPreApprovalRequestDetailsForm.document;
		var obj1=parent.frames[1].frames[3].BillingPreApprovalRequestDetailsForm;
		var obj = parent.frames[1].recordApprovalPatientDataDetails.recordApprovalPatientData.document;
		var locale = parent.frames[1].BillingPreApprovalRequestDetailsForm.document.forms[0].locale.value;
		alert("locale "+locale);*/
	}else{
		//var rowCount = parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.document.getElementById("record_approval_details_table").rows.length;
		var rowCount = parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.document.getElementById("record_approval_details_table").rows.length;
		parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.document.forms[0].rowCount.value=rowCount;
		var authorized 			=	parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.document.getElementById('authorized').value;
		var isUserCanAcess 		=	parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.document.getElementById('isUserCanAcess').value;
		var dtlsform 		=	parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails;
		var btnFrame =parent.frames[2].BillingRecordApproval.recordPreApprovalRecordBtn.document.billpreApprovalRequestDetailBtn;
		filePath =parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.document.getElementById("filePath").value;
		siteSpecUploadDoc =parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.document.getElementById("siteSpecUploadDoc").value;
			
	}//V230102
	
	if(authorized == "Y" && isUserCanAcess == "Y")
	{
		var recalc = btnFrame.recalc_charges;
		//var recalc = parent.frames[2].BillingRecordApproval.recordPreApprovalRecordBtn.document.billpreApprovalRequestDetailBtn.recalc_charges;
		if(recalc.checked){
		//	parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.document.forms[0].recalc_charges.value = "on";		
			dtlsform.document.forms[0].recalc_charges.value = "on";
		}
		else{
		//	parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.document.forms[0].recalc_charges.value = "off";
			dtlsform.document.forms[0].recalc_charges.value = "off";
		}
		//V221130
		//var enableInsClearance = parent.frames[2].BillingRecordApproval.recordPreApprovalRecordBtn.document.billpreApprovalRequestDetailBtn.enableInsClearance.value;
		var enableInsClearance = btnFrame.enableInsClearance.value;
		if(enableInsClearance=='Y' && (episodeType=='I' || episodeType=='D')){//INC-40354
			//var insclr = parent.frames[2].BillingRecordApproval.recordPreApprovalRecordBtn.document.billpreApprovalRequestDetailBtn.genInsClr;
			var insclr = btnFrame.genInsClr;
			if(insclr.checked){
				//parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.document.forms[0].insurance_clr.value = "Y";
				dtlsform.document.forms[0].insurance_clr.value = "Y";
			}
			else{
				//parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.document.forms[0].insurance_clr.value = "N";
				dtlsform.document.forms[0].insurance_clr.value = "N";
			}
		}
		//V221130
		/*
		parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.target='messageFrame'; 
		parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.method="post";
		parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.action="../../servlet/eBL.BillingRecordApprovalServlet";
		parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.submit();
		*/
		
			patientId=dtlsform.document.forms[0].patinetId.value;
			episodeType=dtlsform.document.forms[0].episodeType.value;
			visitId=dtlsform.document.forms[0].visitId.value;
			episodeId=dtlsform.document.forms[0].episodeId.value;
			encounterId=dtlsform.document.forms[0].encounterId.value;
			
			policyTypeCode=dtlsform.document.forms[0].policyTypeCode.value;
			custGroupCode=dtlsform.document.forms[0].custGroupCode.value;
			custCode=dtlsform.document.forms[0].custCode.value;
			accountSeqNo=dtlsform.document.forms[0].acctSeqNo.value;
			priority=dtlsform.document.forms[0].priority.value;
			policyNumber=dtlsform.document.forms[0].policyNumber.value;
			expiryDate=dtlsform.document.forms[0].expiryDate.value;
			effectiveToDate=dtlsform.document.forms[0].effectiveTo.value;
			authorizedUserId=dtlsform.document.forms[0].user_id.value;
			//authorizedUserId=dtlsform.document.forms[0].authorizedUserId.value;
			sysDateTime=dtlsform.document.forms[0].sysDateTime.value;
			siteId=dtlsform.document.forms[0].siteId.value;
			recalc_charges=dtlsform.document.forms[0].recalc_charges.value;
			insuranceClr=dtlsform.document.forms[0].insurance_clr.value;
			membershipNo=dtlsform.document.forms[0].membershipNo.value;
			//V230904
		
		var params="&patientId="+patientId+"&episodeType="+episodeType+"&visitId="+visitId+"&episodeId="+episodeId+"&encounterId="+encodeURIComponent(encounterId)+"&policyTypeCode="+policyTypeCode+"&custGroupCode="+custGroupCode+"&custCode="+custCode+"&accountSeqNo="+accountSeqNo+"&priority="+priority+"&policyNumber="+policyNumber+"&expiryDate="+expiryDate+"&effectiveToDate="+effectiveToDate+"&authorizedUserId="+authorizedUserId+"&sysDateTime="+sysDateTime+"&siteId="+siteId+"&recalc_charges="+recalc_charges+"&insuranceClr="+insuranceClr+"&membershipNo="+membershipNo;
		//alert(params)
		dtlsform.document.forms[0].target='messageFrame'; 
		dtlsform.document.forms[0].method="post";
		dtlsform.document.forms[0].action="../../servlet/eBL.BillingRecordApprovalServlet?filePath="+filePath+"&rows="+rowCount+params;
		//dtlsform.submit();
		dtlsform.document.forms[0].submit();
		
	}
	else{
		alert(getMessage('BL9136','BL'));		
		commontoolbarFrame.location.reload();
		return;
	}
	}
	else{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+errorFrame;
	}				
}

function checkJobStatusForEncounter(facilityId,
		patId,
		episodeType,
		episodeId,
		visitId){
	var reqId = 0;
	$.ajax({
		type:"POST", //V220413
		url:"../jsp/PkgSubscriptionValidation.jsp",
		data:"func_mode=checkForInProgress&facilityId="+facilityId+
			  "&patientId="+patId+
			  "&episdoeType="+episodeType+
			  "&episdoeId="+episodeId+
			  "&visitId="+visitId,
		dataType:"text",
		async:false,
		success: function(data){
			reqId = parseInt($.trim(data));
			
		},
		 error: function(data){
			 reqId = 0;
	      }
	});
	return reqId;
}

async function onSuccess(reqId)
{
	//parent.frames[2].BillingRecordApproval.document.location.reload(); 
	var cnt = 1;
	var status = 'I';
	if(parent.frames[1].frames[3]!=undefined){
		calledForm=parent.frames[1].frames[3].BillingPreApprovalRequestDetailsForm.document.forms[0].calledForm.value;
	}else{
	  calledForm=parent.frames[2].BillingRecordApproval.recordPreApprovalRecordDetails.document.forms[0].calledForm.value;
	}//V230102
		
		
	if(reqId>0){
		
		status = checkProgress(reqId);
		if(status == 'C'){
			msg=getMessage("RECORD_INSERTED","SM");
			alert(msg);
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;	
			if(calledForm=='ApprStsTrack' || calledForm=='preAuthStsTrack'){
				window.close();
			}else{
				BillingRecordApproval.location.reload();
				commontoolbarFrame.location.reload();	
			}//V230102
		}
		else if(status == 'F'){
			msg='Recalculation Job Failed';
			alert(msg);
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;	
			if(calledForm=='ApprStsTrack' || calledForm=='preAuthStsTrack'){
				window.close();
			}else{
				BillingRecordApproval.location.reload();
				commontoolbarFrame.location.reload();	
			}//V230102
		}
		else{
			var intr = setInterval(function chkProg(){
				cnt++;
				status = checkProgress(reqId);
				if(status == 'C'){
					clearInterval(intr);
					msg=getMessage("RECORD_INSERTED","SM");
					alert(msg);
					messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;	
					if(calledForm=='ApprStsTrack' || calledForm=='preAuthStsTrack'){
						window.close();
					}else{
						BillingRecordApproval.location.reload();
						commontoolbarFrame.location.reload();	
					}//V230102
				}
				else if(status == 'F'){
					clearInterval(intr);
					msg='Recalculation Job Failed';
					alert(msg);
					messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;	
					if(calledForm=='ApprStsTrack' || calledForm=='preAuthStsTrack'){
						window.close();
					}else{
						BillingRecordApproval.location.reload();
						commontoolbarFrame.location.reload();	
					}//V230102
				}
				else if(cnt == 5){
					clearInterval(intr);
					var dialogHeight= "14" ;
					var dialogWidth	= "32" ;
					var dialogTop = "225" ;
					var center = "1" ;														   
					var status="no";
					var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
					var arguments	= "" ;	
					//var modPatientId = document.getElementById("hiddenPatientId").value;
					retVal =await window.showModalDialog("../../eBL/jsp/BLCheckProcessedCount.jsp?reqId="+reqId,arguments,features); 
					msg=getMessage("RECORD_INSERTED","SM");
					alert(msg);
					messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;	
					if(calledForm=='ApprStsTrack' || calledForm=='preAuthStsTrack'){
						window.close();
					}else{
						BillingRecordApproval.location.reload();
						commontoolbarFrame.location.reload();	
					}//V230102
				}				
			}, 3000);
		}		
	}
	else{
		msg=getMessage("RECORD_INSERTED","SM");
		alert(msg);
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;	
		if(calledForm=='ApprStsTrack' || calledForm=='preAuthStsTrack'){
			window.close();
		}else{
			BillingRecordApproval.location.reload();
			commontoolbarFrame.location.reload();	
		}//V230102
	}
}

function checkProgress(reqId){
	var progress = 'I';
	$.ajax({
		type:"POST", //V220413
		url:"../jsp/PkgSubscriptionValidation.jsp?reqId="+reqId,
		data:"func_mode=getProgressStatus",
		dataType:"text",
		async:false,
		success: function(data){
			progress = $.trim(data);			
		},
		 error: function(data){
			 progress = 'I';
	      }
	});
	return progress;
}

async function showPopUP1(index)
{	
	if(parent.parent.BillingRecordApproval.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.document.getElementById('authorized').value!="Y")
	{
		return;
	}
	else
	{
		var patinetId 				=	document.getElementById('patinetId').value ;
		var episodeType				=	document.getElementById('episodeType').value ;
		var episodeId				=	document.getElementById('episodeId').value ;
		var visitId					=	document.getElementById('visitId').value ;
		var priority				=	document.getElementById('priority').value;
		var acctSeqNo				=	document.getElementById('acctSeqNo').value;
		var encounterId				=	document.getElementById('encounterId').value;
		var policyTypeCode			=	document.getElementById('policyTypeCode').value;
		var custGroupCode   		=  	document.getElementById('custGroupCode').value;
		var custCode   				=  	document.getElementById('custCode').value;
		var policyNumber			=  	document.getElementById('policyNumber').value;
		var billingServiceCode		=  	document.getElementById('billing_service_code'+index).value;
		var availbleServiceAmount	=  	document.getElementById('available_service_amount'+index).value;
		var approvedDate			=  	document.getElementById('approved_date'+index).value;
		var approvalNumber			=  	document.getElementById('approval_number'+index).value;
		var approvalStatus			=  	document.getElementById('approval_status'+index).value;
		var reason					=  	document.getElementById('reason'+index).value;
		var approvalRemarks			=  	document.getElementById('approval_remarks'+index).value;
		var serviceDate				=  	document.getElementById('service_date'+index).value;
		var effectiveFrom			=  	document.getElementById('effective_from').value;
		var appReqDate				=  	document.getElementById('app_req_date').value;
		var billingGroupId			=  	document.getElementById('billing_grp_id').value;
		var status					=  	document.getElementById('status').value;
		
		var e = document.getElementById("included_excluded"+index);
		
		var includedExcluded;
		for(var j=0; j<e.options.length; j++)
	    {
			if(e.options[j].selected)
				includedExcluded=e.options[j].value;
	    }
		var retVal;
		var dialogHeight= "25" ;
		var dialogWidth	= "60" ;
		var dialogTop = "280" ;
		var center = "1" ;														   
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		var url = "../../eBL/jsp/BillingPreApprovalRequstModal.jsp?patinetId="+patinetId+"&episodeType="+episodeType
			+"&episodeId="+episodeId+"&visitId="+visitId+"&priority="+priority+"&acctSeqNo="+acctSeqNo+"&encounterId="+encounterId
			+"&policyTypeCode="+policyTypeCode+"&custGroupCode="+custGroupCode+"&custCode="+custCode+"&policyNumber="+policyNumber+"&billingServiceCode="+billingServiceCode
			+"&includedExcluded="+includedExcluded+"&availbleServiceAmount="+availbleServiceAmount+"&approvedDate="+approvedDate+"&approvalNumber="+approvalNumber
			+"&approvalStatus="+approvalStatus+"&reason="+reason+"&approvalRemarks="+approvalRemarks+"&serviceDate="+serviceDate+"&effectiveFrom="+effectiveFrom
			+"&billingGroupId="+billingGroupId+"&appReqDate="+appReqDate+"&status="+status;
		retVal =await  window.showModalDialog(url,arguments,features);
	}
}

function saveBillingRecordApprovalModalValues() {	
	 var frmObj=document.recordApprovalDetailsModalForm; 
		if(frmObj!="" && frmObj!=null && frmObj !=undefined )
		{
			var xmlString=formXMLStringMain(frmObj);
			var updation=formValidation(xmlString);			
		}
}

///XML String passing for validation
function formValidation(xmlStr)
{	 	
	var temp_jsp="../../eBL/jsp/BillingRecordApprovalModalValidations.jsp";
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	if (xmlDoc.parseError.errorCode != 0)
	{
	alert("Error in line " + xmlDoc.parseError.line +
	" position " + xmlDoc.parseError.linePos +
	"\nError Code: " + xmlDoc.parseError.errorCode +
	"\nError Reason: " + xmlDoc.parseError.reason +
	"Error Line: " + xmlDoc.parseError.srcText);
	return(null);
	}
	xmlHttp.open("POST",temp_jsp,false);
	xmlHttp.send(xmlDoc);
	var responseText=xmlHttp.responseText ;
	eval(responseText);
	return true; 
}	

function formXMLStringMain(frmObj)
{	
if( frmObj!=null && frmObj != "undefined" && frmObj.length >0)
{
	var xmlStr ="<root><SEARCH ";
	if(true)
	{
	var arrObj = frmObj.elements;
	for(var i=0;i<arrObj.length;i++)
	{
		var val = "" ;
		if(arrObj[i].type == "checkbox")
		{
			val = arrObj[i].value;
			if(arrObj[i].name != null && arrObj[i].name != "")
				xmlStr+= arrObj[i].name+"=\"" + val + "\" " ;
     }
		
		 else if(arrObj[i].type == "radio")
		{
			if(arrObj[i].checked)
			{
				val = arrObj[i].value;
		        if(arrObj[i].name != null && arrObj[i].name != "")
					xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
         }
	    }
		
		else if(arrObj[i].type == "select-multiple" )
		{
			for(var j=0; j<arrObj[i].options.length; j++)
		    {
				if(arrObj[i].options[j].selected)
					val+=arrObj[i].options[j].value +"~"
         }
	        val= val.substring(0,val.lastIndexOf('~'))
		    if(arrObj[i].name != null && arrObj[i].name != "")
			    xmlStr+= arrObj[i].name+"=\"" + checkSpl(val) + "\" " ;
	       
		}
		else
		{
			val = arrObj[i].value;
			if(arrObj[i].name != null && arrObj[i].name != "")
	        {
	        		xmlStr+= arrObj[i].name+"=\"" + val + "\" " ;
	        }
		 }
	}
}
xmlStr +=" /></root>";	
}
return xmlStr;
}

async function showPopUP()
{
	var retVal;
	var dialogHeight= "25" ;
	var dialogWidth	= "50" ;
	var dialogTop = "280" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	var url = "../../eBL/jsp/ScreeningServiceApplciable.jsp";
	retVal =await window.showModalDialog(url,arguments,features);
}

function call_pass_valid()
{
	var user = document.forms[0].user.value;
	var err_msg = document.forms[0].err_msg.value;

	var remarks = document.forms[0].remarks.value;
	if(err_msg!=""){
			alert(getMessage(err_msg,'BL'));
			return false;
		}else{
			var returnArray = new Array ("Y","Y",remarks,user);
			
			parent.window.returnValue=returnArray;
			parent.window.close();
			return true;
		}//V220323
}	

function confirmPasswdchk(obj)
{
	var usr_id=document.forms[0].user_id;
	var pass_wd=document.forms[0].passwd;
	var rmks=document.forms[0].remarks;
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
	if(rmks.value=="")
	{
		alert(getMessage("BL9306","BL"));  
		rmks.focus();
		return false;
	}	
	var HTMLVal="<html><body><form name='BillingRecordApprovalPasswrdForm' id='BillingRecordApprovalPasswrdForm' method='post' action='../../eBL/jsp/BillingRecordApprovalPasswrCheck.jsp'>"+
				"<input type='hidden' name='usr_id' id='usr_id' value='"+usr_id.value+"'>"+
				"<input type='hidden' name='pass_wd' id='pass_wd' value='"+pass_wd.value+"'>"+
				"<input type='hidden' name='remarks' id='remarks' value='"+rmks.value+"'>"+
                "<input type='hidden' name='mod_fin_chk' id='mod_fin_chk' value='Y'>"+
				"</form></body></html>";
				parent.frames[1].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
				parent.frames[1].document.BillingRecordApprovalPasswrdForm.submit();			
}

async function authUser()
{	
	var dialogHeight= "50vh" ;//14
	var dialogWidth	= "28vw" ;//22
	var dialogTop = "10px" ;//225
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;	
	retVal = await window.showModalDialog("../../eBL/jsp/BillingRecordApprovalAuthorizeMain.jsp?mode=s",arguments,features); 
	var doc = parent.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.document;
	//var siteId = doc.getElementById('siteId').value;
	var siteId = parent.recordPreApprovalRecordDetails.document.getElementById('siteId').value;
	var site3TierAlmoFeatureYN = parent.recordPreApprovalRecordDetails.document.getElementById('site3TierAlmoFeatureYN').value; //Added V200415 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	var calledForm = parent.recordPreApprovalRecordDetails.document.getElementById('calledForm').value;
	if(retVal!=undefined)
	{
		if(retVal.length>0)
		{
			if(retVal[0]=="Y")
			{	
				if(retVal[3] != null && retVal[3] != undefined && retVal[3] != ''){
					parent.recordPreApprovalRecordDetails.document.getElementById('authorizedUserId').value = retVal[3];
				}
				//comment starts
		/*		var rowCount = doc.getElementById("record_approval_details_table").rows.length;		
				for(var i=0;i<(rowCount-2);i++)
				{
					if((siteId != 'ALMO' || doc.getElementById('billApprovedYn'+i).value == 'N') || (site3TierAlmoFeatureYN != 'Y' || doc.getElementById('billApprovedYn'+i).value == 'N')){ //Added V200415 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
						doc.getElementById('included_excluded'+i).disabled = false;
						doc.getElementById('billing_service_code'+i).disabled = false;
						doc.getElementById('billing_service_desc'+i).disabled = false;
						doc.getElementById('service_date'+i).disabled = false;
						doc.getElementById('available_service_amount'+i).disabled = false;
						doc.getElementById('available_service_qty'+i).disabled = false;
						
						doc.getElementById('included_excluded'+i).readOnly = true;
						doc.getElementById('billing_service_code'+i).readOnly = true;
						doc.getElementById('billing_service_desc'+i).readOnly = true;
						doc.getElementById('service_date'+i).readOnly = true;
						doc.getElementById('available_service_amount'+i).readOnly = true;
						doc.getElementById('available_service_qty'+i).readOnly = true;
						
						doc.getElementById('app_req_date'+i).disabled = false;
						doc.getElementById('approved_date'+i).disabled = false;
						doc.getElementById('approved_req_cal'+i).disabled = false;
						doc.getElementById('approved_given_cal'+i).disabled = false;
						doc.getElementById('approval_number'+i).disabled = false;
						var enableMCNNumberYN=doc.getElementById('enableMCNNumberYN').value; //taiba
						if(enableMCNNumberYN=='Y'){
							doc.getElementById('MCN_number'+i).disabled = false;//V220909
						}
						doc.getElementById('approval_status'+i).disabled = false;
						doc.getElementById('approvedQty'+i).disabled = false;
						doc.getElementById('approvedAmount'+i).disabled = false;
						doc.getElementById('reason'+i).disabled = false;
						doc.getElementById('reason_lookup'+i).disabled = false;
						doc.getElementById('approval_remarks'+i).disabled = false;
						doc.getElementById('select_all'+i).disabled = false;
						//doc.getElementById('pop_modal'+i).disabled = false;
					}				
				}
*/ // V230608 comment ends
					//doc.getElementById('addnew').disabled = false;
				parent.recordPreApprovalRecordDetails.document.getElementById('authorized').value="Y";
				//document.getElementById('recalc_charges').disabled=false; Commented By Vijay for MMS Internal Changes
				//document.getElementById('recalc_charges').checked=true; 
				//V220627 starts
				var siteRecAppRecalChargeYN=parent.recordPreApprovalRecordDetails.document.getElementById('siteRecAppRecalChargeYN').value; //ME region
				if(! siteRecAppRecalChargeYN=='Y'){
					document.getElementById('recalc_charges').checked=true; 
				}
				//V220627 ends
				var enableInsClearance=document.getElementById('enableInsClearance').value;
        var episodeType=document.getElementById('episodeType').value;
				if(enableInsClearance=='Y' && (episodeType=='I' || episodeType=='D')){//INC-40354
					if(document.getElementById('genInsClr').checked==true || document.getElementById('genInsClr').checked=='true'){
						document.getElementById('genInsClr').disabled=true;
						document.getElementById('cancelInsClr').disabled=false;
					}else{
						enbleGenIns();
						document.getElementById('cancelInsClr').disabled=true;
					}
				}
				//V221130
				//parent.window.close();//comment new
				//alert(window.name)
				
				var doc = parent.recordApprovalPatientDataDetails.document;
				var index = doc.getElementById('printUCAFIndex').value;				 
				showRecordApprovalPatientDeatilsAuth(index);		
				
				//V230608 testing code starts
				doc = parent.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.document;
	
			var patinetId=parent.recordPreApprovalRecordDetails.document.getElementById('patinetId').value;
			var episodeType=parent.recordPreApprovalRecordDetails.document.getElementById('episodeType').value;
			var episodeId=parent.recordPreApprovalRecordDetails.document.getElementById('episodeId').value;
			var visitId=parent.recordPreApprovalRecordDetails.document.getElementById('visitId').value;
			var priority=parent.recordPreApprovalRecordDetails.document.getElementById('priority').value;
			var acctSeqNo=parent.recordPreApprovalRecordDetails.document.getElementById('acctSeqNo').value;
			var encounterId=parent.recordPreApprovalRecordDetails.document.getElementById('encounterId').value;
			var policyTypeCode=parent.recordPreApprovalRecordDetails.document.getElementById('policyTypeCode').value;
			var custGroupCode=parent.recordPreApprovalRecordDetails.document.getElementById('custGroupCode').value;
			var custCode=parent.recordPreApprovalRecordDetails.document.getElementById('custCode').value;
			var policyNumber=parent.recordPreApprovalRecordDetails.document.getElementById('policyNumber').value;
			var requestStatus=parent.recordPreApprovalRecordDetails.document.getElementById('requestStatus').value;
			var approvedAmount=parent.recordPreApprovalRecordDetails.document.getElementById('approvedAmount').value;
			var expiryDate=parent.recordPreApprovalRecordDetails.document.getElementById('expiryDate').value;

			var effectiveTo=parent.recordPreApprovalRecordDetails.document.getElementById('effectiveTo').value;
			var site_spec=parent.recordPreApprovalRecordDetails.document.getElementById('site_spec').value; 
			var membershipNo=parent.recordPreApprovalRecordDetails.document.getElementById('membershipNo').value;//102.2
		var enableMCNNumberYN=parent.recordPreApprovalRecordDetails.document.getElementById('enableMCNNumberYN').value; //taiba
		parent.recordPreApprovalRecordDetails.location.href = "../../eBL/jsp/BillingPreApprovalRequestDetails.jsp?patinetId="+patinetId+"&episodeType="+episodeType
			+"&episodeId="+episodeId+"&visitId="+visitId+"&priority="+priority+"&acctSeqNo="+acctSeqNo+"&encounterId="+encodeURIComponent(encounterId)+"&policyTypeCode="+encodeURIComponent(policyTypeCode)
			+"&custGroupCode="+custGroupCode+"&custCode="+custCode+"&policyNumber="+policyNumber+"&requestStatus="+requestStatus+"&approvedAmount="+approvedAmount+"&expiryDate="+expiryDate+"&effectiveTo="+effectiveTo+"&site_spec="+site_spec+"&enableYN=Y&authorized=Y&authuser="+parent.recordPreApprovalRecordDetails.document.getElementById('authorizedUserId').value+"&calledForm="+calledForm+"&enableMCNNumberYN="+enableMCNNumberYN+"&membershipNo="+membershipNo;//V230102
	//testing code ends
			}			
		}
	}
}
//V220627 starts 
function isChanged(val,called,idx){
	if(called=='apprSts'){
		if(document.getElementById('approvalstatus_hdn'+idx).value!=val.value){
			parent.recordPreApprovalRecordBtn.document.billpreApprovalRequestDetailBtn.recalc_charges.checked=true;
		}//V221130
		var enableInsClearance=parent.frames[4].document.getElementById('enableInsClearance').value;
		var episodeType=document.getElementById('episodeType').value;
		if(enableInsClearance=="Y" && ( episodeType=="I" || episodeType=="D")){ 
			if(document.getElementById('prevSts'+idx).value!=''){
				var insclr=parent.recordPreApprovalRecordBtn.document.billpreApprovalRequestDetailBtn.genInsClr.checked;
				if((insclr==true || insclr=='true')){
					alert(getMessage("BL0962","BLEXT"));  
					document.getElementById('approval_status'+idx).value=document.getElementById('prevSts'+idx).value;
					return false;
				}else{
					enbleGenIns();
				}
			}
			document.getElementById('prevSts'+idx).value=val.value;
		//V221130
		}
		
		//NMC-JD-CRF-0102.2
		var siteSpecUploadDoc=document.getElementById('siteSpecUploadDoc').value;
		if(siteSpecUploadDoc && episodeType=="O"){
			if(document.getElementById('approval_status'+idx).value=='C' ){
				document.getElementById('UpdDoc'+idx).disabled=false; 
				//document.getElementById('uploadfile'+idx).disabled=false;
			}else{
				document.getElementById('UpdDoc'+idx).disabled=true; 
			}
		}
		
	}else if(called=='apprQty'){
		if((! (val.value == document.getElementById('p_approvedQty'+idx).value))){
			parent.recordPreApprovalRecordBtn.document.billpreApprovalRequestDetailBtn.recalc_charges.checked=true;
		}
	}else if(called=='apprAmt'){
		if((! (val.value == document.getElementById('p_approvedAmount'+idx).value))){
			parent.recordPreApprovalRecordBtn.document.billpreApprovalRequestDetailBtn.recalc_charges.checked=true;
		}
	}
}
//V220627 ends

/*function trimString(sInString)
{
  var sInString = sInString.replace( '/^\s+/g', "" );// strip leading
  return sInString.replace( '/\s+$/g', "" );// strip trailing
    //sInString = sInString.replace(/^\s+/, '');
	//return sInString.replace(/\s+$/, '');
}*/
function trimString(sInString) {
	// If sInString is null or undefined, default to an empty string
  sInString = sInString || '';
  
  // Strip leading whitespace
  sInString = sInString.replace(/^\s+/g, ""); 

  // Strip trailing whitespace
  return sInString.replace(/\s+$/g, "");
}

async function printUCAF(index)
{	
	var doc = parent.recordApprovalPatientDataDetails.document;
	var index = doc.getElementById('printUCAFIndex').value; 
	
	if(index!= undefined && index!='')
	{
		var p_patinetId 		=	trimString(doc.getElementById('patient_id'+index).innerText) ;
		var p_episodeType		=	trimString(doc.getElementById('episode_type'+index).value);
		var p_episodeId			=	trimString(doc.getElementById('episode_id'+index).innerText);
		var p_visitId			=	trimString(doc.getElementById('visit_id'+index).value);
		var p_priority			=	trimString(doc.getElementById('priority'+index).value);
		var p_acctSeqNo			=	trimString(doc.getElementById('acct_seq_no'+index).value);
		var p_encounterId		=	trimString(doc.getElementById('encounterId'+index).innerText);
		var p_policyTypeCode	=	trimString(doc.getElementById('p_policy'+index).value);
		var p_custGroupCode		=  	trimString(doc.getElementById('p_payer_group'+index).value);
		var p_custCode   		=  	trimString(doc.getElementById('p_payer'+index).value);
		var p_policyNumber		=  	trimString(doc.getElementById('policy_number'+index).value);
		var p_requestStatus		=	trimString(doc.getElementById('requestStatus').value);
		var p_approvedAmount	=	trimString(doc.getElementById('approved_amount'+index).innerText);
		var p_fm_date			=	trimString(doc.getElementById('policy_effective_from'+index).innerText);
		var p_to_date			=	trimString(doc.getElementById('effective_to'+index).innerText);
		var p_encounter_id_str		=	trimString(doc.getElementById('encounterId'+index).value);
		
		//Added the below check for DC
		if(p_episodeType=='I' || p_episodeType=='D') p_visitId='';
		//if(p_episode_type == 'I' || p_episode_type =='i')  p_visitId='';

			var languageId			= doc.forms[0].locale.value;
			var facilityId			= doc.forms[0].facilityId.value;	
			var url		= "../../eCommon/jsp/report_options_frameset.jsp?p_patient_id="+p_patinetId+"&p_episode_type="+p_episodeType+
			"&p_episode_id="+p_episodeId+"&p_visit_id="+p_visitId+
			"&p_language_Id="+languageId+"&p_facility_id="+facilityId+"&p_report_id=INRUCAF&p_module_id=IN"+
			"&p_policy_type_code="+encodeURIComponent(p_policyTypeCode)+"&p_payer_grp_code="+p_custGroupCode+
			"&p_cust_code="+p_custCode+
			"&p_fm_date="+p_fm_date+"&p_to_date="+p_to_date+"&pgm_id=INRUCAF"+
			"&p_encounter_id_str="+encodeURIComponent(p_encounter_id_str);
			
			var dialogHeight	= "30vh" ;
			var dialogWidth	= "30vw" ;
			var arguments	= "" ;
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status:no" ;
			var reportURL 	= await top.window.showModalDialog( url, arguments, features ) ;
			//var reportURL 	= window.open( url, '_blank', features ) ;
			if ( reportURL != null ) {			 
				reportURL		= "../../eCommon/jsp/report_process.jsp?" + reportURL ;
				var myBars 		= 'directories=no,location=no,menubar=no' ;
				var myOptions 	= 'width=' + window.screen.availwidth + ', height=' + window.screen.availheight + ', resizable=yes' ;
				var myFeatures 	= myBars + ', ' + myOptions ;
				var reportWindow 	= open( reportURL, '_blank', myFeatures ) ;
				reportWindow.title= "Medicom Report Viewer" ;
				reportWindow.resizeTo( screen.availWidth, screen.availHeight ) ;
				reportWindow.moveTo( 0,0 ) ;
				reportWindow.focus() ;
			}
	}	
}

//Added By Rajesh V - To Chnage Field Color
function changeFieldColor(obj){
	obj = obj-1;
	var prevClicked = document.forms[0].prevClicked.value;
	var calledForm = document.getElementById('calledForm').value;/* Added By Aravindh/11-04-2018/MMS-DM-CRF-0125 */
	if(prevClicked.length>0){
		//V201013 START
		var rowbgColorYN = trimString(document.getElementById('rowbgColorYN'+prevClicked).value);		
		if (rowbgColorYN=='Y') {
			document.getElementById('srl_no'+prevClicked).className =  "RED";
			document.getElementById('patient_id'+prevClicked).className =  "RED";
			document.getElementById('patient_name'+prevClicked).className =  "RED";
			document.getElementById('episode_id'+prevClicked).className =  "RED";
			document.getElementById('age'+prevClicked).className =  "RED";
			document.getElementById('mobile_number'+prevClicked).className =  "RED";
			document.getElementById('payer_group'+prevClicked).className =  "RED";
			document.getElementById('payer'+prevClicked).className =  "RED";
			document.getElementById('policy'+prevClicked).className =  "RED";
			document.getElementById('policy_effective_from'+prevClicked).className =  "RED";
			document.getElementById('effective_to'+prevClicked).className =  "RED";
			document.getElementById('approved_amount'+prevClicked).className =  "RED";
			if(calledForm == "serviceApprStatus") {
				document.getElementById('effective_to_fld'+prevClicked).className =  "RED";
			}
		}else // V201013 END
		{
			document.getElementById('srl_no'+prevClicked).className =  "fields";
			document.getElementById('patient_id'+prevClicked).className =  "fields";
			document.getElementById('patient_name'+prevClicked).className =  "fields";
			document.getElementById('episode_id'+prevClicked).className =  "fields";
			//document.getElementById('encounter_id'+prevClicked).className =  "fields"; // Vijay for  MMS-DM-CRF-0077 
			document.getElementById('age'+prevClicked).className =  "fields";
			document.getElementById('mobile_number'+prevClicked).className =  "fields";
			document.getElementById('payer_group'+prevClicked).className =  "fields";
			document.getElementById('payer'+prevClicked).className =  "fields";
			document.getElementById('policy'+prevClicked).className =  "fields";
			document.getElementById('policy_effective_from'+prevClicked).className =  "fields";
			document.getElementById('effective_to'+prevClicked).className =  "fields";
			document.getElementById('approved_amount'+prevClicked).className =  "fields";
			//document.getElementById('expiry_date_fld'+prevClicked).className =  "fields";//Karthik Record approval   -  MMS-QH-CRF-0165
			/* Added By Aravindh/11-04-2018/MMS-DM-CRF-0125/Starts */
			if(calledForm == "serviceApprStatus") {
				document.getElementById('effective_to_fld'+prevClicked).className =  "fields";
			} //V201013
		}
		/* Added By Aravindh/11-04-2018/MMS-DM-CRF-0125/Ends */
	}
		document.getElementById('srl_no'+obj).className =  "YELLOW";
		document.getElementById('patient_id'+obj).className =  "YELLOW";
		document.getElementById('patient_name'+obj).className =  "YELLOW";
		document.getElementById('episode_id'+obj).className =  "YELLOW";
		//document.getElementById('encounter_id'+obj).className =  "YELLOW"; Vijay for  MMS-DM-CRF-0077
		document.getElementById('age'+obj).className =  "YELLOW";
		document.getElementById('mobile_number'+obj).className =  "YELLOW";
		document.getElementById('payer_group'+obj).className =  "YELLOW";
		document.getElementById('payer'+obj).className =  "YELLOW";
		document.getElementById('policy'+obj).className =  "YELLOW";
		document.getElementById('policy_effective_from'+obj).className =  "YELLOW";
		document.getElementById('effective_to'+obj).className =  "YELLOW";
		document.getElementById('approved_amount'+obj).className =  "YELLOW";
		//document.getElementById('expiry_date_fld'+obj).className =  "YELLOW";//Karthik Record approval   -  MMS-QH-CRF-0165
		/* Added By Aravindh/11-04-2018/MMS-DM-CRF-0125/Starts */
		if(calledForm == "serviceApprStatus") {
			document.getElementById('effective_to_fld'+obj).className =  "YELLOW";
		}
		/* Added By Aravindh/11-04-2018/MMS-DM-CRF-0125/Ends */

	document.forms[0].prevClicked.value = obj;

}

//Added By Rajesh V - To Chnage Field Color
//Added By Rajesh V - To Call Policy Details
async function fnPolicyDetails(){
	
	var doc = parent.recordApprovalPatientDataDetails.document;
	var prevClicked = doc.forms[0].prevClicked.value;
	if(prevClicked.length>0){
		var payerGroup = trimString(doc.getElementById('p_payer_group'+prevClicked).value);
		var payer = trimString(doc.getElementById('p_payer'+prevClicked).value);
		var policy = trimString(doc.getElementById('p_policy'+prevClicked).value);
		var startDate = trimString(doc.getElementById('policy_effective_from'+prevClicked).innerText);
		var endDate = trimString(doc.getElementById('effective_to'+prevClicked).innerText);
		var patientId = trimString(doc.getElementById('patient_id'+prevClicked).innerText);
		var visitId = trimString(doc.getElementById('visit_id'+prevClicked).value);
		var acctSeq = trimString(doc.getElementById('acct_seq_no'+prevClicked).value);
		var priority = trimString(doc.getElementById('priority'+prevClicked).value);
		var policyNo = trimString(doc.getElementById('policy_number'+prevClicked).value);
		var episodeType = trimString(doc.getElementById('episode_type'+prevClicked).value);
		var episodeId = trimString(doc.getElementById('episode_id'+prevClicked).innerText);
		var dialogHeight= "75vh" ;
		var dialogWidth	= "90vw" ;
														   
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; status: " + status + "; scroll=auto; ";
		var arguments	= "" ;	
		var retVal =await top.window.showModalDialog('../../eBL/jsp/RcrdApprovalPolicyDefinitionMainFrame.jsp?mode=modify&patinetId='+patientId+'&payergroupCode='+ payerGroup+
					'&payerCode='+payer+'&policyCode='+policy+'&startDate='+startDate+'&endDate='+endDate+'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+
					'&policyNo='+policyNo+'&episodeType='+episodeType+'&episodeId='+episodeId+'&auth=N',arguments,features);
	}
	
	//&patinetId='+patientId+'&payergroupCode='+ payerGroup+'&payerCode='+payer+'&policyCode='+policy+'&startDate='+startDate+'&endDate='+endDate+
		//'&visitId='+visitId+'&acctSeq='+acctSeq+'&priority='+priority+'&policyNo='+policyNo+'&episodeType='+episodeType+'&episodeId='+episodeId+'&auth='+auth
}

async function callBGDesc(sqlSelect,drop,obj,code){
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facilityId.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	switch(sqlSelect){
		case 1:
		{
			var cn = drop.value;
			if(cn == 'C'){
				sql="Select description, code from (select short_desc description,clinic_code code from OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' Union Select 'All Clinic','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Clinic';
			}
			else if(cn == 'N'){
				sql = "Select description, code from (SELECT LONG_DESC DESCRIPTION, NURSING_UNIT_CODE CODE  FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' Union Select 'All Nursing Unit','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Nursing Unit';
			}
			else if(cn == 'A'){
				sql = "Select description, code from (Select 'All Clinic/ Nursing Unit' DESCRIPTION,'**' CODE From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Clinic / Nursing Unit';
			}
			else{
				alert('Please select Clinic / Nursing Unit');
				return false;
			}
			
			break;
		}
				
		case 2:
		{
			var criteria = drop.value;
			if(criteria == 'S'){
				sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where nvl(status,'N') != 'S' and upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Billing Services';							
			}
			else if(criteria == 'BSG'){
				sql = "Select description, code from (SELECT short_desc description,SERV_GRP_CODE CODE FROM BL_BLNG_SERV_GRP_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Billing Service Group';
			}
			else if(criteria == 'BSGC'){
				sql = "Select description, code from (SELECT short_desc description,SERV_CLASSIFICATION_CODE CODE FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE  upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Billing Classification';
			}
			else if(criteria == 'ESG'){
				sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE CODE FROM BL_BLNG_PRT_GRP_HDR_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Enterprise Service Group';
			}
			else if(criteria == 'ESGL'){
				sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE||PRT_GRP_LINE_CODE CODE FROM BL_BLNG_PRT_GRP_LINE_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Enterprise Service Group Line';
			}
			
			else if(criteria == 'PG'){
				sql = "Select description, code from (select short_desc description,package_serv_group_code CODE from bl_package_serv_group_hdr where OPERATING_FACILITY_ID = '"+facility_id+"' Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2"; //V211130
				title = 'Package Group';
			}
			else if(criteria == 'M'){
				sql = "Select description, code from (SELECT short_desc description,item_code CODE FROM mm_item_lang_vw WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Material Item';
			}
			else if(criteria == 'T'){
				sql = "Select description, code from (select short_desc description,sale_category_code CODE from bl_st_item_sale_catg_hdr Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Sale Category';
			}
			else if(criteria == 'P'){
				sql = "Select description, code from (select short_desc description,package_code CODE from BL_PACKAGE_LANG_VW WHERE upper(language_id) = upper('"+locale+"') AND OPERATING_FACILITY_ID = '"+facility_id+"' Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Package';
			}
			else{
				alert('Please select Inc / Exc Criteria');
				return false;
			}
			
			break;
		}
			
	}

	//var sql="SELECT DESCRIPTION, CODE FROM (SELECT 'All' DESCRIPTION,'*ALL' CODE FROM DUAL UNION SELECT A.SHORT_DESC DESCRIPTION,A.SPECIALITY_CODE CODE FROM AM_SPECIALITY_LANG_VW A, OT_SPECIALITIES B  WHERE A.LANGUAGE_ID='"+locale+"' AND  A.SPECIALITY_CODE = B.SPECIALITY_CODE ) WHERE UPPER(DESCRIPTION) LIKE UPPER(?) AND UPPER(CODE) LIKE UPPER(?) ORDER BY 2";
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = obj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = DESC_CODE;

	returnedValues = await CommonLookup(title, argumentArray );
	var ret1=unescape(returnedValues);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = arr[1];
		code.value = arr[0];	
	}
else
	{
	obj.value = arr[1];
	code.value = arr[0];		
		//obj.value = returnedValues[1];
	}
}

async function callBGDescCode(sqlSelect,drop,obj,code){
	var locale = document.forms[0].locale.value;
	var facility_id = document.forms[0].facilityId.value;
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	switch(sqlSelect){
		case 1:
		{
			var cn = drop.value;
			if(cn == 'C'){
				sql="Select description, code from (select short_desc description,clinic_code code from OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' Union Select 'All Clinic','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Clinic';
			}
			else if(cn == 'N'){
				sql = "Select description, code from (SELECT LONG_DESC DESCRIPTION, NURSING_UNIT_CODE CODE  FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' Union Select 'All Nursing Unit','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Nursing Unit';
			}
			else if(cn == 'A'){
				sql = "Select description, code from (Select 'All Clinic/ Nursing Unit' description,'**' code From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Clinic / Nursing Unit';
			}
			else{
				alert('Please select Clinic / Nursing Unit');
				return false;
			}

			break;
		}
				
		case 2:
		{
			var criteria = drop.value;
			if(criteria == 'S'){
				sql = "Select description, code from (select short_desc description,blng_serv_code code from bl_blng_serv_lang_vw where nvl(status,'N') != 'S' and upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Billing Services';							
			}
			else if(criteria == 'BSG'){
				sql = "Select description, code from (SELECT short_desc description,SERV_GRP_CODE CODE FROM BL_BLNG_SERV_GRP_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Billing Service Group';
			}
			else if(criteria == 'BSGC'){
				sql = "Select description, code from (SELECT short_desc description,SERV_CLASSIFICATION_CODE CODE FROM BL_SERV_CLASSIFICATION_LANG_VW WHERE  upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Billing Classification';
			}
			else if(criteria == 'ESG'){
				sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE CODE FROM BL_BLNG_PRT_GRP_HDR_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Enterprise Service Group';
			}
			else if(criteria == 'ESGL'){
				sql = "Select description, code from (SELECT short_desc description,PRT_GRP_HDR_CODE||PRT_GRP_LINE_CODE CODE FROM BL_BLNG_PRT_GRP_LINE_LANG_VW WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Enterprise Service Group Line';
			}
			
			else if(criteria == 'PG'){
				sql = "Select description, code from (select short_desc description,package_serv_group_code CODE from bl_package_serv_group_hdr where OPERATING_FACILITY_ID = '"+facility_id+"' Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2"; //V211130
				title = 'Package Group';
			}
			else if(criteria == 'M'){
				sql = "Select description, code from (SELECT short_desc description,item_code CODE FROM mm_item_lang_vw WHERE upper(language_id) = upper('"+locale+"') Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Material Item';
			}
			else if(criteria == 'T'){
				sql = "Select description, code from (select short_desc description,sale_category_code CODE from bl_st_item_sale_catg_hdr Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Sale Category';
			}
			else if(criteria == 'P'){
				sql = "Select description, code from (select short_desc description,package_code CODE from BL_PACKAGE_LANG_VW WHERE upper(language_id) = upper('"+locale+"') AND OPERATING_FACILITY_ID = '"+facility_id+"' Union Select 'All Billing Services','**' From Dual ) where upper(description) like upper(?) and upper(code) like upper(?) order by 2";
				title = 'Package';
			}
			else{
				alert('Please select Inc / Exc Criteria');
				return false;
			}
			break;
		}
			
	}

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "1,2";
	argumentArray[5] = code.value;
	argumentArray[6] = CODE_LINK;
	argumentArray[7] = DESC_CODE;

	/*if(!(sqlSelect == '1' && drop.value == 'A')){
	returnedValues = CommonLookup(title, argumentArray );
	}
	else{
		returnedValues = new Array();
		returnedValues[0] = '**'
		returnedValues[1] = 'All Clinic/ Nursing Unit';
	}*/
	returnedValues = await CommonLookup(title, argumentArray );
	
	if((returnedValues != null) && (returnedValues != "") )  {
		obj.value = returnedValues[1];
		code.value = returnedValues[0];	
	}
	else
	{
		if(sqlSelect == '1' && drop.value == 'A'){
			obj.value = 'All Clinic/ Nursing Unit';
			code.value = '**';	
		}
		else{
			obj.value = '';
			code.value = '';	
		}		
	}
}

function isValidDate(obj){
	if(obj.value!=""){
		var flag=true;
		var RE_NUM =  /^\/?\d+$/;
		var str_date = obj.value;
		var arr_date = str_date.split('/');
		if (arr_date.length != 3) return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);//flag=false;
	
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
	}
	return true;
}

function cal_error (str_message,obj) {
	alert (str_message);
	obj.focus();
	obj.select();
	return false;
}

async function reasonCodeLookupFilter(obj,code)
{
	var sql;
	var locale=document.forms[0].locale.value;
	sql="BLINTERNALREP_9::blsql::"+locale+"::";
	var title									= 	getLabel("Common.reason.label", 'common');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	obj.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   await CommonLookup( title, argumentArray );
	
			var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
	if(retVal != null && retVal != "")
	{
		obj.value 							= 	arr[1];
		code.value							=	arr[0];
	}
	else
	{
		obj.value			  				=	arr[1];
		code.value							=	arr[0];
	}     
}
//V230411 Ends
function applyFilter(){
	var frm = parent.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm;
	var site_spec=frm.site_spec.value;
	var enableMCNNumberYN=frm.enableMCNNumberYN.value;//V220909
	var encounterIdFilter='';
	/* Modified V180524-Aravindh/MMS-DM-CRF-0125/Modified from site_spec is 'false' to site_spec is 'true' */
	if(site_spec=='true' || site_spec==true){
	encounterIdFilter=	frm.encounterIdFilter.value;
	}
	var orderStatusFilter='';
	/* Modified V180524-Aravindh/MMS-DM-CRF-0125/Modified from site_spec is 'false' to site_spec is 'true' */
	if(site_spec=='true' || site_spec==true){	
	orderStatusFilter=frm.orderStatusFilter.value;
	}
	
	/* Added by Aravindh/11-05-2018/MMS-DM-CRF-0125 */
	var calledForm = document.forms[0].calledForm.value;
	/* Added by Aravindh/11-05-2018/MMS-DM-CRF-0125/if-condition */
	if(calledForm == "serviceApprStatus") {
		var doc = parent.recordApprovalSearch.document.forms[0];
		var serviceGroupHid = doc.serviceGroupHid.value;
		var serviceClassficationHid = doc.serviceClassficationHid.value;
		var orderStatusHid = doc.orderStatusHid.value;
		
		parent.recordPreApprovalRecordDetails.location.href = "../../eBL/jsp/BillingPreApprovalRequestStatusDetails.jsp?patinetId="+frm.patinetId.value+"&episodeType="+frm.episodeType.value
		+"&episodeId="+frm.episodeId.value+"&visitId="+frm.visitId.value+"&priority="+frm.priority.value+"&acctSeqNo="+frm.acctSeqNo.value+"&encounterId="+encodeURIComponent(frm.encounterId.value)+"&policyTypeCode="+encodeURIComponent(frm.policyTypeCode.value)
		+"&custGroupCode="+frm.custGroupCode.value+"&custCode="+frm.custCode.value+"&policyNumber="+frm.policyNumber.value+"&requestStatus="+frm.requestStatus.value+"&approvedAmount="+frm.approvedAmount.value			
		+"&criteriaFilter="+frm.criteriaFilter.value+"&bg_code_filter="+frm.bg_code_filter.value+"&bg_desc_filter="+frm.bg_desc_filter.value+"&serviceDate_filter="+frm.serviceDate_filter.value
		+"&serviceAmount_filter="+frm.serviceAmount_filter.value+"&serviceQuantity_filter="+frm.serviceQuantity_filter.value+"&apprReqDate_filter="+frm.apprReqDate_filter.value+"&apprGvnDate_filter="+frm.apprGvnDate_filter.value
		+"&apprNo_filter="+frm.apprNo_filter.value+"&approval_status_filter="+frm.approval_status_filter.value+"&apprQty_filter="+frm.apprQty_filter.value+"&apprAmt_filter="+frm.apprAmt_filter.value
		+"&reason_filter="+frm.reason_filter.value+"&reason_hdn_filter="+frm.reason_hdn_filter.value+"&remarks_filter="+frm.remarks_filter.value+"&userAuthorization="+frm.authorized.value+"&encounterIdFilter="+encounterIdFilter
		+"&orderStatusFilter="+orderStatusFilter+"&calledForm="+calledForm+"&site_spec="+site_spec+"&servGrpCode="+serviceGroupHid+"&servClsfctnCode="+serviceClassficationHid
		+"&orderStatus="+orderStatusHid;
	} else {
		parent.recordPreApprovalRecordDetails.location.href = "../../eBL/jsp/BillingPreApprovalRequestDetails.jsp?patinetId="+frm.patinetId.value+"&episodeType="+frm.episodeType.value
		+"&episodeId="+frm.episodeId.value+"&visitId="+frm.visitId.value+"&priority="+frm.priority.value+"&acctSeqNo="+frm.acctSeqNo.value+"&encounterId="+encodeURIComponent(frm.encounterId.value)+"&policyTypeCode="+encodeURIComponent(frm.policyTypeCode.value)
		+"&custGroupCode="+frm.custGroupCode.value+"&custCode="+frm.custCode.value+"&policyNumber="+frm.policyNumber.value+"&requestStatus="+frm.requestStatus.value+"&approvedAmount="+frm.approvedAmount.value			
		+"&criteriaFilter="+frm.criteriaFilter.value+"&bg_code_filter="+frm.bg_code_filter.value+"&bg_desc_filter="+frm.bg_desc_filter.value+"&serviceDate_filter="+frm.serviceDate_filter.value
		+"&serviceAmount_filter="+frm.serviceAmount_filter.value+"&serviceQuantity_filter="+frm.serviceQuantity_filter.value+"&apprReqDate_filter="+frm.apprReqDate_filter.value+"&apprGvnDate_filter="+frm.apprGvnDate_filter.value
		+"&apprNo_filter="+frm.apprNo_filter.value+"&approval_status_filter="+frm.approval_status_filter.value+"&apprQty_filter="+frm.apprQty_filter.value+"&apprAmt_filter="+frm.apprAmt_filter.value
		+"&reason_filter="+frm.reason_filter.value+"&reason_hdn_filter="+frm.reason_hdn_filter.value+"&remarks_filter="+frm.remarks_filter.value+"&userAuthorization="+frm.authorized.value+"&encounterIdFilter="+encounterIdFilter+"&orderStatusFilter="+orderStatusFilter+"&site_spec="+site_spec+"&enableMCNNumberYN="+enableMCNNumberYN;//V220909
	}
}

function resetFilter(){
	var frm = parent.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm;// Added by Aravindh/11-05-2018/MMS-DM-CRF-0125
	var site_spec=frm.site_spec.value;// Added by Aravindh/11-05-2018/MMS-DM-CRF-0125

	var calledForm = document.forms[0].calledForm.value;// Added by Aravindh/11-05-2018/MMS-DM-CRF-0125
	/* Added by Aravindh/11-05-2018/MMS-DM-CRF-0125/if-condition */
	if(calledForm == "serviceApprStatus") {
		parent.recordPreApprovalRecordDetails.location.href = "../../eBL/jsp/BillingPreApprovalRequestStatusDetails.jsp?patinetId="+frm.patinetId.value+"&episodeType="+frm.episodeType.value
		+"&episodeId="+frm.episodeId.value+"&visitId="+frm.visitId.value+"&priority="+frm.priority.value+"&acctSeqNo="+frm.acctSeqNo.value+"&encounterId="+encodeURIComponent(frm.encounterId.value)+"&policyTypeCode="+encodeURIComponent(frm.policyTypeCode.value)
		+"&custGroupCode="+frm.custGroupCode.value+"&custCode="+frm.custCode.value+"&policyNumber="+frm.policyNumber.value+"&requestStatus="+frm.requestStatus.value+"&approvedAmount="+frm.approvedAmount.value+'&userAuthorization='+frm.authorized.value+"&site_spec="+site_spec;
	} else {
		parent.recordPreApprovalRecordDetails.location.href = "../../eBL/jsp/BillingPreApprovalRequestDetails.jsp?patinetId="+frm.patinetId.value+"&episodeType="+frm.episodeType.value
		+"&episodeId="+frm.episodeId.value+"&visitId="+frm.visitId.value+"&priority="+frm.priority.value+"&acctSeqNo="+frm.acctSeqNo.value+"&encounterId="+encodeURIComponent(frm.encounterId.value)+"&policyTypeCode="+encodeURIComponent(frm.policyTypeCode.value)
		+"&custGroupCode="+frm.custGroupCode.value+"&custCode="+frm.custCode.value+"&policyNumber="+frm.policyNumber.value+"&requestStatus="+frm.requestStatus.value+"&approvedAmount="+frm.approvedAmount.value+'&userAuthorization='+frm.authorized.value+"&site_spec="+site_spec;
	}
}

function initiateAuthorization(){
	var doc = parent.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.document;
	var rowCount = parent.recordPreApprovalRecordDetails.document.getElementById("record_approval_details_table").rows.length;		
	var siteId = parent.recordPreApprovalRecordDetails.document.getElementById('siteId').value;
	var site3TierAlmoFeatureYN = parent.recordPreApprovalRecordDetails.document.getElementById('site3TierAlmoFeatureYN').value; //Added V200415 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	for(var i=0;i<(rowCount-2);i++)
	{
		if((siteId != 'ALMO' || parent.recordPreApprovalRecordDetails.document.getElementById('billApprovedYn'+i).value == 'N') || (site3TierAlmoFeatureYN != 'Y' || parent.recordPreApprovalRecordDetails.document.getElementById('billApprovedYn'+i).value == 'N')){ //Added V200415 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
			parent.recordPreApprovalRecordDetails.document.getElementById('included_excluded'+i).disabled = false;
			parent.recordPreApprovalRecordDetails.document.getElementById('billing_service_code'+i).disabled = false;
			parent.recordPreApprovalRecordDetails.document.getElementById('billing_service_desc'+i).disabled = false;
			parent.recordPreApprovalRecordDetails.document.getElementById('service_date'+i).disabled = false;
			parent.recordPreApprovalRecordDetails.document.getElementById('available_service_amount'+i).disabled = false;
			
			
			parent.recordPreApprovalRecordDetails.document.getElementById('included_excluded'+i).readOnly = true;
			parent.recordPreApprovalRecordDetails.document.getElementById('billing_service_code'+i).readOnly = true;
			parent.recordPreApprovalRecordDetails.document.getElementById('billing_service_desc'+i).readOnly = true;
			parent.recordPreApprovalRecordDetails.document.getElementById('service_date'+i).readOnly = true;
			parent.recordPreApprovalRecordDetails.document.getElementById('available_service_amount'+i).readOnly = true;
			
			parent.recordPreApprovalRecordDetails.document.getElementById('app_req_date'+i).disabled = false;
			parent.recordPreApprovalRecordDetails.document.getElementById('approved_date'+i).disabled = false;
			parent.recordPreApprovalRecordDetails.document.getElementById('approved_req_cal'+i).disabled = false;
			parent.recordPreApprovalRecordDetails.document.getElementById('approved_given_cal'+i).disabled = false;
			parent.recordPreApprovalRecordDetails.document.getElementById('approval_number'+i).disabled = false;
			parent.recordPreApprovalRecordDetails.document.getElementById('MCN_number'+i).disabled = false;//V220909
			parent.recordPreApprovalRecordDetails.document.getElementById('approval_status'+i).disabled = false;
			parent.recordPreApprovalRecordDetails.document.getElementById('approvedQty'+i).disabled = false;
			parent.recordPreApprovalRecordDetails.document.getElementById('approvedAmount'+i).disabled = false;
			parent.recordPreApprovalRecordDetails.document.getElementById('reason'+i).disabled = false;
			parent.recordPreApprovalRecordDetails.document.getElementById('reason_lookup'+i).disabled = false;
			parent.recordPreApprovalRecordDetails.document.getElementById('approval_remarks'+i).disabled = false;
			parent.recordPreApprovalRecordDetails.document.getElementById('select_all'+i).disabled = false;
			//doc.getElementById('pop_modal'+i).disabled = false;
		}	
	}
	//doc.getElementById('addnew').disabled = false;
	parent.recordPreApprovalRecordDetails.document.getElementById('authorized').value="Y";
	document.getElementById('recalc_charges').disabled=false;
	document.getElementById('recalc_charges').checked=true;
}

function assignEffectDate(index)
{
	var index=index;
	var effectiveToDate		=	document.getElementById('effective_to'+index).value;
	/*var policyExpDate			=	document.getElementById('expiry_date'+index).value;		
	var effectiveFromDate			=	document.getElementById('policy_effective_from'+index).innerText;	

	
	if(effectiveToDate==undefined || effectiveToDate=='')
	{
		alert(getMessage("BL9566","BL"));
		document.getElementById('effective_to'+index).focus();
		document.getElementById('effective_to'+index).value=document.getElementById('effective_to_org'+index).value;
		return;
	}
	if(policyExpDate==undefined || policyExpDate=='')
	{
		alert(getMessage("BL9105","BL"));
		return;
	}
	
	var starr = effectiveToDate.split("/");
	var enarr = policyExpDate.split("-");
	var effFrmArr=effectiveFromDate.split("/");

	var startdt = new Date();
	var enddt = new Date();
	var effFrmDt=new Date();
	startdt.setFullYear(starr[2], starr[1]-1, starr[0]);
	enddt.setFullYear(enarr[0], enarr[1]-1, enarr[2]);
	effFrmDt.setFullYear(effFrmArr[2], effFrmArr[1]-1, effFrmArr[0]);
	

	if(startdt<effFrmDt){
		alert("Policy Effective To Date should not be less than Policy Effective From Date");
		//document.getElementById('effective_to'+index).value='';
	
		document.getElementById('effective_to'+index).focus();
		return;
	}
	
	if(startdt>enddt)
	{
		alert(getMessage('BL00905','BL'));		
	//	document.getElementById('effective_to'+index).value='';
	
		document.getElementById('effective_to'+index).focus();
		return;
	}			
	*/
	parent.recordPreApprovalRecordDetails.document.BillingPreApprovalRequestDetailsForm.effectiveTo.value=effectiveToDate;
}

function validDateChk(obj)
{	
	var locale=document.forms[0].locale.value;		
	if(obj.value!="")
	{
	if(validDate(obj.value,'DMY',locale))
	{
		return true;
	}
	else{
		alert(getMessage("INVALID_DATE_FMT","SM"));
		obj.select();
		return false;
		}
	}
	else
	{
		return true;
	}
}

function fnClearCode(obj){
	obj.value = '';
}
//Added By Rajesh V - To Call Policy Details

/* Added By Aravindh/11-04-2018/MMS-DM-CRF-0125/Starts */
async function serviceLookUp(serviceObj, service_type) {
	var argumentArray = new Array();
	var dataNameArray = new Array();
	var dataValueArray = new Array();
	var dataTypeArray = new Array();
	var title = "";
	var local = document.forms[0].locale.value;
	var serviceGroupCode = document.forms[0].service_group.value;
	
	if (service_type == "G") {
		argumentArray[0] = "select description, code from (select short_desc description, serv_grp_code code from BL_BLNG_SERV_GRP_LANG_VW"
				+ " where  language_id='"
				+ local
				+ "' union Select 'All Service Group','**' From Dual)"
				+ " where upper(description) like upper(?) and upper(code) like upper(?) ORDER BY 2  ";
		title = getLabel("eBL.SERVICE_GROUP.label", "BL");
	} else if (service_type == "C") {
		if(serviceGroupCode != "" && serviceGroupCode != "**") {
			argumentArray[0] = "SELECT   a.short_desc description, a.serv_classification_code code"+
		    					" FROM bl_serv_classification_lang_vw a, bl_blng_serv_grp_lang_vw b"+
		    					" WHERE SUBSTR (a.serv_classification_code, 1, 2) = b.serv_grp_code"+
		    					" AND A.LANGUAGE_ID = B.LANGUAGE_ID"+
		    					" AND a.language_id = '"+local+"'"+
		    					" AND b.serv_grp_code = '"+serviceGroupCode+"'"+
		    					" AND UPPER (a.short_desc) LIKE UPPER (?)"+
		    					" AND a.serv_classification_code LIKE UPPER (?)"+
		    					" ORDER BY 2";
		} else {
			argumentArray[0] = "select description, code from (select short_Desc description, serv_classification_code code from BL_SERV_CLASSIFICATION_LANG_VW where " +
			" language_id='"
			+ local
			+ "' union Select 'All Service Classification','**' From Dual)"
			+ " where upper(description) like upper(?) and upper(code) like upper(?) ORDER BY 2";
		}
		
		title = getLabel("eBL.SERVICE_CLASSIFICATION.label", "BL");
	}
	
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	argumentArray[4] = "2,1";
	argumentArray[5] = serviceObj.value;
	argumentArray[6] = DESC_LINK;
	argumentArray[7] = CODE_DESC;
	retVal = await CommonLookup(title, argumentArray);

	if (retVal != null && retVal != "") {
		serviceObj.value = retVal[0];
	} else {
		serviceObj.value = "";
	}
}
/* Added By Aravindh/11-04-2018/MMS-DM-CRF-0125/Ends */
//V201024 start
function run()  
{
	var formsObj = parent.content.serviceApprovalStatusFrames.recordApprovalSearch.document.forms[0];
	var episode_type 		= formsObj.episode_type.value;	 	
	var patinetId 			= formsObj.patient_id.value;	
	var encounterId			= formsObj.encounter_id.value;
	var encounterFromDate	=	formsObj.Effective_from.value;
	var encounterToDate		=	formsObj.Effective_to.value;
	var payerGroup		=	formsObj.payer_group.value; //V201027 added
	
	if(episode_type==undefined || episode_type=='')
	{
		alert(getMessage("BL00028","BL"));
		return;
	}
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
  //V201027 start
	if(payerGroup==undefined || payerGroup=='')
	{
		alert(getMessage("BL6277","BL"));
		return;
	}//V201027 end
	var starr = formsObj.Effective_from.value.split("/");
	var enarr = formsObj.Effective_to.value.split("/");
	var startdt = new Date();
	var enddt = new Date();
	startdt.setFullYear(starr[2], starr[1]-1, starr[0]);
	enddt.setFullYear(enarr[2], enarr[1]-1, enarr[0]);
	var timeDiff;
	var daysDiff;
	if(startdt>enddt)
	{
		alert(getMessage('BL4115','BL'));
		return;
	}
	timeDiff = enddt.getTime() - startdt.getTime();
	daysDiff =  Math.floor(timeDiff / (1000 * 60 * 60 * 24));
	
	var daysRestrict = formsObj.restrictDate.value;
	if(daysRestrict != ''){
		var actualDays = parseInt(daysRestrict)-1;
		if(daysDiff > actualDays)
		{
				alert("Encounter To Date Cannot be greater than "+daysRestrict+" Days from Encounter from Date");
				return;
		}
	}
	var calledForm = formsObj.calledForm.value;
	var dayDiff = 31;
	if(calledForm == "serviceApprStatusReport") {
		if(patinetId == "" && encounterId =="") {
			if (daysDiff > dayDiff - 1) {
				alert("Encounter To Date Cannot be greater than " + dayDiff + " Days from Encounter from Date");
				return false;
			}
		}
	}
	
	var dummyDoc = parent.frames[2].messageFrame.document;
	var htmlVal = "<html><body>";
		htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
		htmlVal += "<input type='hidden' name='p_patient_id' id='p_patient_id' value='"+formsObj.patient_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_episode_type' id='p_episode_type' value='"+formsObj.episode_type.value+"'>";
		htmlVal += "<input type='hidden' name='p_encounter_id' id='p_encounter_id' value='"+formsObj.encounter_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_language_Id' id='p_language_Id' value='"+formsObj.locale.value+"'>";
		htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+formsObj.facilityId.value+"'>";
		htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+formsObj.p_report_id.value+"'>";
		htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+formsObj.p_module_id.value+"'>";
//		htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='INRUCAF'>";
		htmlVal += "<input type='hidden' name='p_policy_type_code' id='p_policy_type_code' value='"+formsObj.policy.value+"'>";
		htmlVal += "<input type='hidden' name='p_payer_grp_code' id='p_payer_grp_code' value='"+formsObj.payer_group.value+"'>";
		htmlVal += "<input type='hidden' name='p_cust_code' id='p_cust_code' value='"+formsObj.payer.value+"'>";
		htmlVal += "<input type='hidden' name='p_fm_date' id='p_fm_date' value='"+formsObj.Effective_from.value+"'>";
		htmlVal += "<input type='hidden' name='p_to_date' id='p_to_date' value='"+formsObj.Effective_to.value+"'>";
		htmlVal += "<input type='hidden' name='pgm_id' id='pgm_id' value='"+formsObj.pgm_id.value+"'>";
//		htmlVal += "<input type='hidden' name='pgm_id' id='pgm_id' value='INRUCAF'>";
		htmlVal += "<input type='hidden' name='p_specialty_code' id='p_specialty_code' value='"+formsObj.speciality.value+"'>";
		htmlVal += "<input type='hidden' name='p_request_status' id='p_request_status' value='"+formsObj.request_status.value+"'>";
/*		htmlVal += "<input type='hidden' name='p_service_group' id='p_service_group' value='"+formsObj.service_group.value+"'>";
		htmlVal += "<input type='hidden' name='p_service_classification' id='p_service_classification' value='"+formsObj.service_classification.value+"'>";
		htmlVal += "<input type='hidden' name='p_order_status' id='p_order_status' value='"+formsObj.order_status.value+"'>";
*/
		htmlVal += "</form></body></html>";
	dummyDoc.body.insertAdjacentHTML("afterbegin",HTMLVal);
	dummyDoc.dummy_frm.submit();
}
//V201024 end

//V220909 starts
function CopyData(idx){
	document.getElementById("currMCNNum").value=document.getElementById("MCN_number"+idx).value;
	document.getElementById("currMCNNumidx").value=idx;
}

function loadMCNnumber(chck){
	var currMCNNum=parent.frames[3].document.getElementById("currMCNNum").value;
	var rowLength = parent.frames[3].document.getElementById("record_approval_details_table").rows.length-1;
	if(chck.checked=='true' ||chck.checked==true){
		if(currMCNNum!=''){
			//alert(rowLength)
			dataArr.length=0;
			dataArr.push(parent.frames[3].document.getElementById("currMCNNumidx").value);
			for(var i=0;i<(rowLength-1);i++)
			{
				var MCN_number=parent.frames[3].document.getElementById("MCN_number"+i).value;
				if((parent.frames[3].document.getElementById("MCN_number"+i).value=='') && ( parent.frames[3].document.getElementById("approval_status"+i).value=='A' || parent.frames[3].document.getElementById("approval_status"+i).value=='H' || parent.frames[3].document.getElementById("approval_status"+i).value=='R')){//approval_status_filter
					parent.frames[3].document.getElementById("MCN_number"+i).value=currMCNNum;
					dataArr.push(i);
				}
			}
		}else{
			alert("please enter MCN number");
			document.getElementById("auto_fill").checked=false;
		}
	}else{
		if(dataArr.length!=0){
			for (index = 0; index < dataArr.length; index++) { 
				parent.frames[3].document.getElementById("MCN_number"+dataArr[index]).value='';
			}
		}
	}
}

function checkMCNsts(idx){
	if(document.getElementById('approval_status'+idx).value=='P' || document.getElementById('approval_status'+idx).value=='C' ||document.getElementById('approval_status'+idx).value=='S' ){
		if(document.getElementById('MCN_number'+idx).value!=''){
				document.getElementById('MCN_number'+idx).value='';
			}
	}
}

function ckckStatus(idx){
	if(document.getElementById('approval_status'+idx).value=='P' || document.getElementById('approval_status'+idx).value=='C' ||document.getElementById('approval_status'+idx).value=='S' || document.getElementById('approval_status'+idx).value=='A' || document.getElementById('approval_status'+idx).value=='R'){
		if(document.getElementById('MCN_number'+idx).value!=''){
				document.getElementById('MCN_number'+idx).value='';
			}
	}
}
//V220909 Ends

//V221130

function validateSts(){
	var doc = parent.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.document;
	var rowCount = doc.getElementById("record_approval_details_table").rows.length;
	var disStatus='';
	//checkbox 
	var insclr=document.getElementById('genInsClr').checked;
	if(!(insclr==true || insclr=='true')){
		document.getElementById('genInsClr').checked=false;
		return false;
	}else{
		var patId=document.getElementById('patientId').value;
		var episodeType=document.getElementById('episodeType').value;
		var visitId=document.getElementById('visitId').value;
		var episodeId=document.getElementById('episodeId').value;
	
		$.ajax({
				type:"POST", 
				url:"../jsp/InsuranceClearanceAjax.jsp?functionMode=get_bill_ip_indicator",
				data:"patientId="+patId+
					  "&episodeType="+episodeType+
					  "&episodeId="+episodeId+
					  "&visitId="+visitId,
				dataType:"text",
				async:false,
				success: function(data){
					disStatus = $.trim(data);
					
				},
				 error: function(data){
					 alert(error)
				  }
		});
		
		if(disStatus=="I"){
			alert(getMessage("BL0957","BLEXT")); //BL0957
			document.getElementById('genInsClr').checked=false;
			return false;
		}else if(disStatus=="U"){
			alert(getMessage("BL0959","BLEXT"));//BL0959
			document.getElementById('genInsClr').checked=false;
			return false;
		}//Extra code 
		else if(disStatus=="D"){
			document.getElementById('genInsClr').checked=true;
			}	
		}
	
}

function checkinsclr(){
	var enableInsClearance=document.getElementById('enableInsClearance').value;
	var episodeType=document.getElementById('episodeType').value;
	if(enableInsClearance=="Y" && ( episodeType=="I" || episodeType=="D")){
		var patId=document.getElementById('patientId').value;
		var visitId=document.getElementById('visitId').value;
		var episodeId=document.getElementById('episodeId').value;
		var status='';
		$.ajax({
				type:"POST", 
				url:"../jsp/InsuranceClearanceAjax.jsp?functionMode=insuranceClearanceSts",
				data:"patientId="+patId+
					  "&episodeType="+episodeType+
					  "&episodeId="+episodeId+
					  "&visitId="+visitId,
				dataType:"text",
				async:false,
				success: function(data){ 
					status = $.trim(data);
					if(status=="Y"){
						document.getElementById('genInsClr').checked=true;
						document.getElementById('genInsClr').disabled=true;
					}
					
				},
				 error: function(data){
					 alert(error)
				  }
			});
		
	}	
}

function enbleGenIns(){
	var doc = parent.recordPreApprovalRecordDetails.BillingPreApprovalRequestDetailsForm.document;
	var rowCount = doc.getElementById("record_approval_details_table").rows.length;
	var check='Y';
	for(var i=0;i<(rowCount-2);i++){
		if(!(doc.getElementById('approval_status'+i).value=='A' || doc.getElementById('approval_status'+i).value=='R')){
			check='N';
		}
	}
	
	if(check=='N'){
		parent.recordPreApprovalRecordBtn.document.billpreApprovalRequestDetailBtn.genInsClr.disabled=true;
		parent.recordPreApprovalRecordBtn.document.billpreApprovalRequestDetailBtn.genInsClr.checked=false;
	}else{
		parent.recordPreApprovalRecordBtn.document.billpreApprovalRequestDetailBtn.genInsClr.disabled=false;
	}
}

function cancelInsurclear(){
	var insclr=document.getElementById('genInsClr').checked;
	
	if(!(insclr==true || insclr=='true')){
		return false;
	}else{
		var disStatus='';
			var patId=document.getElementById('patientId').value;
			var episodeType=document.getElementById('episodeType').value;
			var visitId=document.getElementById('visitId').value;
			var episodeId=document.getElementById('episodeId').value;
			
			$.ajax({
				type:"POST", 
				url:"../jsp/InsuranceClearanceAjax.jsp?functionMode=get_bill_ip_indicator",
				data:"patientId="+patId+
					  "&episodeType="+episodeType+
					  "&episodeId="+episodeId+
					  "&visitId="+visitId,
				dataType:"text",
				async:false,
				success: function(data){
					disStatus = $.trim(data);
					
				},
				 error: function(data){
					 alert(error)
				  }
			}); //discharge bill sts
			
			if(disStatus=='U'){
				alert(getMessage("BL0958","BLEXT")); 
				return false;
			}else if (disStatus=="I"){
				alert(getMessage("BL0959","BLEXT")); 
				return false;
			}else if(disStatus=='D'){
				$.ajax({
					type:"POST", 
					url:"../jsp/InsuranceClearanceAjax.jsp?functionMode=cancelInsuranceClearance",
					data:"patientId="+patId+
						  "&episodeType="+episodeType+
						  "&episodeId="+episodeId+
						  "&visitId="+visitId,
					dataType:"text",
					async:false,
					success: function(data){
						transSts = $.trim(data);
						if(transSts=='S'){
							document.getElementById('cancelInsClr').disabled=true;
							document.getElementById('genInsClr').checked=false;
							document.getElementById('genInsClr').disabled=false;
							alert(getMessage("BL0961","BLEXT")); 
						}
					},
					 error: function(data){
						 alert(error)
					  }
				});
			}
		}
}
//V221130

//NMC-JD-CRF-0102.2
function getFileType(ind){
	 //var myFSO = new ActiveXObject("Scripting.FileSystemObject");
	 var myFSO ="";
     var filepath = document.getElementById("UpdDoc"+ind).value;
     var filename;
	 //alert("filepath "+filepath)
	  idxDot = filepath.lastIndexOf(".") + 1,
	  extFile = filepath.substr(idxDot, filepath.length).toLowerCase();
     if (extFile=="pdf"){
    	 if(getSize(ind)){
    		 uploadfile(ind)
    	 }else{
    		 return false;
    	 }
    	// return true;
     }else{
    	// alert("Only pdf files are allowed!");
    	 alert(getMessage("BL0991", 'BLEXT'));
    	 return false;
     }
}

function getSize(ind){
	//alert("inside getsize ")
	// var myFSO = new ActiveXObject("Scripting.FileSystemObject");
	 var myFSO = "";
     var file = document.getElementById("UpdDoc"+ind).value;
    var filename;
	       //TO DO
		var thefile = myFSO.getFile(file);
		var size = thefile.size;
		var sizeInMB = (size / (1024*1024)).toFixed(2);
		//alert(sizeInMB)
		if(sizeInMB>=2){	
			//alert("Uploading File size must be less than 2MB");
			alert(getMessage("BL0990", 'BLEXT'));
			return false;
		}else{
			document.getElementById("UpdDoc"+ind).value=file;
			return true;
		}
}

function uploadfile(ind){
	var filePath = document.forms[0].filePath.value;
	var pathExist = document.forms[0].pathExist.value;
	var writeAccess = document.forms[0].writeAccess.value;
	//var applServerURL = document.forms[0].applServerURL.value;
	var uploadFile = document.getElementById("UpdDoc"+ind).value;
	var uploadFileType = uploadFile.substr(uploadFile.lastIndexOf(".")+1, uploadFile.length);
	//alert("filePath ===>"+filePath)
	if(filePath==""){
		alert("Configured file path is empty");
		document.getElementById("DocUplYN"+ind).value="N";
		return false;
	}
	else if(pathExist=="false"){
		alert("Configured file path - '"+filePath+"' does not exist");
		document.getElementById("DocUplYN"+ind).value="N";
		return false;
	}
	else if(writeAccess=="false"){
		alert("Configured file path - '"+filePath+"' does not have write access");
		document.getElementById("DocUplYN"+ind).value="N";
		return false;
	}
	else{
		if(uploadFile != '' )
		{
		if(uploadFileType.toUpperCase() == 'PDF' )
		{	
			document.getElementById("DocUplYN"+ind).value="Y";
			document.getElementById('docCnt').value="1";
			return true;
		}
		else
		{
			//alert(getCAMessage("FILE_TYPE_NOT_ALLOWED"))//Sanjay
			//alert(getMessage("UPLOAD_PROPER_FILE_TYPE", "BT"));
			document.getElementById("DocUplYN"+ind).value="N";
			//alert("Please upload PDF Files Only");
			alert(getMessage("BL0991", 'BLEXT'));
			return false;
		}
	}
	else
		{
			//alert(getCAMessage("FILE_TYPE_NOT_ALLOWED"))//Sanjay
			document.getElementById("DocUplYN"+ind).value="N";
			alert("Uploaded file path cannot be empty");
			return false;
		}
	}
}

