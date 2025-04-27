function create(){
}

function apply(){
}

function reset(){	
	frames[1].location.href = "../../eBL/jsp/BLZatcaResponseSearch.jsp";
	frames[2].location.href = "../../eCommon/html/blank.html";
}


function resendZatca(){
	var selRecCnt = 0;	
	frmObj1=parent.frames[2].document.forms[0];
	
	var totalRecords=frmObj1.totalRecords.value; 
	
	for(var i=1;i<=totalRecords;i++){
		var chk = eval("frmObj1.selectedIndex_" + i); 
		
		if(chk.checked == true)
			selRecCnt++;
	}
	
	if(selRecCnt == 0){
		alert("No record selected for resubmission");
		return false;
	}
	
	if (frmObj1 != "" && frmObj1 != null && frmObj1 != undefined) {	
		var xmlString1 = formXMLStringMain1(frmObj1);	
		
		var updation1 = formValidation1(xmlString1);

		frmObj1.target = 'messageFrame';
		frmObj1.method = 'post';
		frmObj1.action = "../../servlet/eBL.BLZATCAResponseServlet";
		frmObj1.submit();		
	}
}

function onSuccess(){
	frames[0].location.reload();
	frames[1].location.reload();
	frames[2].location.href = "../../eCommon/html/blank.html";
}

function formXMLStringMain1(frmObj1) {
	submitParamsMain	= "";
	if (frmObj1 != null && frmObj1 != "undefined" && frmObj1.length > 0) {
	var xmlStr1 = "<root><SEARCH ";
	if (true) {
		var arrObj = frmObj1.elements;
		for ( var i = 0; i < arrObj.length; i++) {
			var val = "";
			if (arrObj[i].type == "checkbox") {
				val = arrObj[i].value;
				if (arrObj[i].name != null && arrObj[i].name != ""){
					xmlStr1 += arrObj[i].name + "=\"" + checkSpl(val)
							+ "\" ";			
				}
			} else if (arrObj[i].type == "radio") {
				if (arrObj[i].checked) {
					val = arrObj[i].value;
					if (arrObj[i].name != null && arrObj[i].name != ""){
						xmlStr1 += arrObj[i].name + "=\"" + checkSpl(val)
								+ "\" ";					
					}
				}
			} else if (arrObj[i].type == "select-multiple") {
				for ( var j = 0; j < arrObj[i].options.length; j++) {
					if (arrObj[i].options[j].selected)
						val += arrObj[i].options[j].value + "~"
				}
				val = val.substring(0, val.lastIndexOf('~'))
				if (arrObj[i].name != null && arrObj[i].name != ""){
					xmlStr1 += arrObj[i].name + "=\"" + checkSpl(val)
							+ "\" ";				
				}
			} else {
				val = arrObj[i].value;
				if (arrObj[i].name != null && arrObj[i].name != ""){
					xmlStr1 += arrObj[i].name + "=\"" + checkSpl(val)
							+ "\" ";			
				}
			}
		}
	}
		xmlStr1 += " /></root>";
	}
	return xmlStr1;
}

function formValidation1(xmlStr1) 
{
	var count="";
	var temp_jsp = "../../eBL/jsp/BLZatcaResponseValidation.jsp?xmlStr="+xmlStr1;
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", temp_jsp, false);
	xmlHttp.send();
	
	var retVal = trimString(xmlHttp.responseText);
	
}

function setValue(obj){
	if(obj.checked)
		obj.value = 'Y';
	else
		ibj.value = 'N';
}

function selectAllRec(obj){
	var selRecCnt = 0;	
	var frmObj1=parent.frames[2].document.forms[0];
	
	var totalRecords=frmObj1.totalRecords.value; 
	
	if(obj.checked){
		for(var i=1;i<=totalRecords;i++){
			var chk = eval("frmObj1.selectedIndex_" + i); 
			
			chk.checked = true;
			chk.value = "Y";		
		}
	} else {
		for(var i=1;i<=totalRecords;i++){
			var chk = eval("frmObj1.selectedIndex_" + i); 
			
			chk.checked = false;
			chk.value = "N";		
		}		
	}
}

async function enCounterIdLookup()
	{
		
		var fieldLegend;
		fieldLegend = new Array() ;
		fieldLegend["CODE_LEGEND"] = "EncounterId"
		fieldLegend["DESC_LEGEND"] = "EpisodeId"
		var e = document.getElementById("episode_type");
		var episodeType;
		var partsql = '';
		if(e == "Inpatient")
		{
		episodeType = "I";
		}
		partsql = "SELECT EPISODE_ID DESCRIPTION, ENCOUNTER_ID CODE FROM bl_episode_fin_dtls WHERE upper(EPISODE_ID) like upper(?) and upper(ENCOUNTER_ID) like upper(?) AND OPERATING_FACILITY_ID = ";
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
		retVal 										=  await  CommonLookup(title, argumentArray);
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
		//alert("zat");
		var sql;
		var facility_id = document.forms[0].facility_id.value;
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
		argumentArray[4]   							= 	"2,1";             // Modified by Gayathri  for MMS-ICN-00036
		argumentArray[5]   							= 	payerGroup.value;
		argumentArray[6]   							= 	DESC_LINK ;
		argumentArray[7]   							= 	CODE_DESC;/* Modified by Aravindh/11-04-2018/MMS-DM-CRF-0125/From CODE_DESC */
		retVal 										=   await CommonLookup( title, argumentArray );

		if(retVal != null && retVal != "")
		{
			payerGroup.value 						= 	retVal[0];
		}
		else
		{
			payerGroup.value			  			=	"";			
		}	    
	}
	
	async function payerLookup()
	{
		//alert("zat");
		var sql;
		var facility_id = document.forms[0].facility_id.value;
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
		argumentArray[4]   							= 	"2,1";          // Modified by Gayathri  for MMS-ICN-00036
		argumentArray[5]   							= 	payer.value;
		argumentArray[6]   							= 	DESC_LINK ;
		argumentArray[7]   							= 	CODE_DESC;/* Modified by Aravindh/11-04-2018/MMS-DM-CRF-0125/From CODE_DESC */
		retVal 										=   await CommonLookup( title, argumentArray );
		if(retVal != null && retVal != "")
		{
			payer.value 							= 	retVal[0];
		}
		else
		{
			payer.value			  					=	"";
			
		}    
	}	

function onSearch()
{
	var facility_id = document.forms[0].facility_id.value;
	var locale = document.forms[0].locale.value;

	var encounterFromDate =	document.getElementById("Effective_from").value;
	var encounterToDate	= document.getElementById("Effective_to").value;
	var encounterId	= document.getElementById("encounter_id").value;
	var patientId	= document.getElementById("patient_id").value;
	var episodeType	= document.getElementById("epiType").value;
	var payerGroup	= document.getElementById("payer_group").value;
	var payer	= document.getElementById("payer").value;
	var zatcaStatus	= document.getElementById("zatcaStatus").value;	
	var active_bill_YN = document.getElementById("active_bill_YN").value;	
	
	if(zatcaStatus == ""){
		alert("Status cannot be blank");
		return false;
	}

	var validation = dateCompare();
	
	if(validation)
		parent.frames[2].location.href = "../../eBL/jsp/BLZatcaResponseSearchResult.jsp?facility_id="+facility_id+"&locale="+locale+"&encounterFromDate="+encounterFromDate+"&encounterToDate="+encounterToDate+"&encounterId="+encounterId+"&patientId="+patientId+"&episodeType="+episodeType+"&payerGroup="+payerGroup+"&payer="+payer+"&zatcaStatus="+zatcaStatus+"&active_bill_YN="+active_bill_YN;
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

function dateCompare()
{
	var encounterFromDate =	document.getElementById("Effective_from").value;
	var encounterToDate	= document.getElementById("Effective_to").value;
	var locale = document.forms[0].locale.value;

	if((encounterFromDate==undefined || encounterFromDate=='') && (encounterToDate==undefined || encounterToDate==''))
	{
			alert(getMessage('BL0965','BLEXT'));
			return false;
	}
	if(encounterFromDate==undefined || encounterFromDate=='')
	{
			alert(getMessage("BL0747","BL"));
			return false;
	}
	if(encounterToDate==undefined || encounterToDate=='')
	{
			alert(getMessage("BL0748","BL"));
			return false;
	}
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
	/*if( (encounterFromDate > encounterToDate) || (encounterFromDate!=getCurrentDate('DMY',locale) && isAfterNow(encounterFromDate,'DMY',locale)==true))
	{
			alert(getMessage('BL0964','BLEXT'));
			return false;
	}*/
	if(encounterToDate!= getCurrentDate('DMY',locale) && isAfterNow(encounterToDate,'DMY',locale)==true)
	{
			alert(getMessage('BL0966','BLEXT'));
			return false;
	}	
	return true;
}

function lockbackSpace()
{
	   if(window.event.keyCode==8)
	   	{
		   //return false;
	   	}
}

function check_active_bill(){
	var active_bill_YN = document.getElementById('active_bill_YN');

	if(active_bill_YN.checked)
		active_bill_YN.value = "Y";
	else
		active_bill_YN.value = "N";
}

