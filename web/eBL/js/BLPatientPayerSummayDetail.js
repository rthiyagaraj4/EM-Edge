function run() 
{	

var facility_id=parent.content.summarydetail.document.forms[0].facility_id.value;
var report_id=parent.content.summarydetail.document.forms[0].report_id.value;
var locale=parent.content.summarydetail.document.forms[0].locale.value;
var custGrpCode=parent.content.summarydetail.document.forms[0].custGrpCode.value;
if(custGrpCode=='')
	{
	alert(getMessage("BL6278","BL"));
	return;
	}

var custCode=parent.content.summarydetail.document.forms[0].custCode.value;
if(custCode=='')
{
alert(getMessage("BL9102","BL"));
return;
}

var Bill_Duration_From=parent.content.summarydetail.document.forms[0].Bill_Duration_From.value;
var Bill_Duration_To=parent.content.summarydetail.document.forms[0].Bill_Duration_To.value;
if(Bill_Duration_From=='')
	{
	alert(getMessage("BL00949","BL"));
	return;
	}
if(Bill_Duration_To=='')
{
alert(getMessage("BL00950","BL"));
return;
}

var App_status=parent.content.summarydetail.document.forms[0].App_status.value;
var Episodetype_OP=parent.content.summarydetail.document.forms[0].Episodetype_OP.value;
var Episodetype_IP=parent.content.summarydetail.document.forms[0].Episodetype_IP.value;
var Episodetype_EM=parent.content.summarydetail.document.forms[0].Episodetype_EM.value;
var Episodetype_DC=parent.content.summarydetail.document.forms[0].Episodetype_DC.value;
/*alert('Episodetype_OP : '+Episodetype_OP);
alert('Episodetype_IP : '+Episodetype_IP);
alert('Episodetype_EM : '+Episodetype_EM);
alert('Episodetype_DC : '+Episodetype_DC);*/
if( Episodetype_OP =='N' && Episodetype_IP =='N' && Episodetype_EM =='N' && Episodetype_DC =='N'){
	alert(getMessage("BL8518","BL"));
	return;
}
var PatientPayerWisebut=parent.content.summarydetail.document.forms[0].ppwb.value;
var ReportOptionbut=parent.content.summarydetail.document.forms[0].rb.value;
var userid=parent.content.summarydetail.document.forms[0].userid.value;

$.ajax({
	type  	: "POST",
	url 	: "../../servlet/eBL.BLPatientPayerSummaryDetail?facility_id="+facility_id+"&report_id="+report_id+"&custGrpCode="+custGrpCode+"&custCode="+custCode+"&Bill_Duration_From="+Bill_Duration_From+"&Bill_Duration_To="+Bill_Duration_To+"&App_status="+App_status+"&Episodetype_OP="+Episodetype_OP+"&Episodetype_IP="+Episodetype_IP+"&Episodetype_EM="+Episodetype_EM+"&Episodetype_DC="+Episodetype_DC+"&PatientPayerWisebut="+PatientPayerWisebut+"&ReportOptionbut="+ReportOptionbut+"&userid="+userid,
	async	: false,
	dataType: "json",
	success : function(data) {	
		if(data.Success == 'Y')
			{
		
			var session_id=data.SessionID;
			var pgm_date=data.PgmDate;
			
			var dummyDoc = dummy_frame.document;
			var htmlVal = "<html><body>";
			htmlVal += "<form name='dummy_frm' id='dummy_frm'  action='../../eCommon/jsp/report_options.jsp' >";
			htmlVal += "<input type='hidden' name='p_facility_id' id='p_facility_id' value='"+facility_id+"'>";
		    htmlVal += "<input type='hidden' name='p_language_id' id='p_language_id' value='"+locale+"'>";		
			htmlVal += "<input type='hidden' name='p_report_id' id='p_report_id' value='"+report_id+"'>";
			htmlVal += "<input type='hidden' name='p_session_id' id='p_session_id' value='"+session_id+"'>";
			htmlVal += "<input type='hidden' name='p_pgm_date' id='p_pgm_date' value='"+pgm_date+"'>";
			htmlVal += "<input type='hidden' name='p_module_id' id='p_module_id' value='"+"BL"+"'>";
			htmlVal += "<input type='hidden' name='p_pgm_id' id='p_pgm_id' value='"+report_id+"'>";
			
			htmlVal += "</form></body></html>";
			
			dummyDoc.body.insertAdjacentHTML("afterbegin",HTMLVal);
			dummyDoc.dummy_frm.submit();
			
			}
		else
			{
			alert(data.errorMessage);
	
			}
		
		}
});
}


async function callCommonLookupCode(obj,code,sqlSelect,codeDesc){		
	var locale = $('#locale').val();
	var facilityId = $('#facility_id').val();
	var cust_code=$('#custGrpCode').val();
	var argumentArray  = new Array();
	var dataNameArray  = new Array();
	var dataValueArray = new Array();
	var dataTypeArray  = new Array();
	var sql = '';
	var title = '';
	
	switch(sqlSelect){
		case 1:
		{
			
			sql="select description,code from (select long_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null and "+
			"cust_group_code in (Select Distinct Cust_Group_Code From Bl_Cust_By_Cust_Group Where Cust_Code In (Select Cust_Code From Ar_Customer_Lang_Vw "+
			"where acc_entity_code  in (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facilityId+"') and upper(language_id) = upper('"+locale+"') "+
			"and nvl(patient_flag,'N')  ='Y' And Nvl(Insurance_Yn, 'N') = 'Y' )) "+
			"And Acc_Entity_Code In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facilityId+"') and upper(language_id) = upper('"+locale+"')) where upper(description) like upper(?) and upper(code) like upper(?) "+
			" order by 2";
			title = getLabel("eBL.CUSTOMER_GROUP.label","BL");
			break;	
		}
		case 2:
		{
			sql="Select description,code from (Select long_name description,cust_code code from ar_customer_lang_vw "+
			"Where Cust_Code In ( SELECT cust_code "+
			"FROM bl_cust_by_cust_group "+
			"WHERE cust_group_code = "+
					 "DECODE ('"+cust_code+"', "+
							 "'**', cust_group_code, '"+ cust_code+
							"')) "+
			"and acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '"+facilityId+"') "+
			"and nvl(patient_flag,'N')  ='Y' "+
			"and nvl(pat_com_flag,'N')='N' "+
			"And Nvl(Insurance_Yn, 'N') = 'Y' And Status Is Null "+
			"and upper(language_id) = upper('"+locale+"') union  Select 'All Payer','**' From Dual) where upper(description) like upper(?) and upper(code) like upper(?) ";
			title = getLabel("Common.Customer.label","Common");
			break;
		}
	}
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray;
	argumentArray[2] = dataValueArray;
	argumentArray[3] = dataTypeArray;
	if(codeDesc == '1'){
		argumentArray[4] = "1,2";
		argumentArray[5] = code.value;
		argumentArray[6] = CODE_LINK;
		argumentArray[7] = DESC_CODE;
	}
	else if(codeDesc == '2'){
		argumentArray[4] = "2,1";
		argumentArray[5] = obj.value;
		argumentArray[6] = DESC_LINK;
		argumentArray[7] = DESC_CODE;
	}

	returnedValues = await CommonLookup(title, argumentArray );
	var ret1=unescape(returnedValues);
		 	arr=ret1.split(",");
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
	}
}
		
function fnClearCode(obj){
		obj.value = '';
}


function toFromDateChk(obj)
{
	if(!(obj.value==""))
	{		
		var locale=document.forms[0].locale.value;
		var effFromDt =document.forms[0].Bill_Duration_From.value;
		var effToDt =document.forms[0].Bill_Duration_To.value;
		if(validDate(obj.value,'DMY',locale))
		{
			if(  effToDt!=getCurrentDate('DMY',locale) && isAfterNow(effToDt,'DMY',locale)==true){
				alert(getMessage("BL00952",'BL'));
				obj.value = '';
				return false;
				return true;
			}
			if(effFromDt != ''){
				if((!isBefore(effFromDt,effToDt,'DMY',locale)))
				{		
					alert(getMessage("BL4115",'BL'));
					obj.value = '';
					return false;
				}
				else
				{			
					return true;
				}
			}		
			
		}
		else{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			obj.value='';
			return false;
		}
	}
	else
	{
		return true;
	}
}

function checkDateBL(entered_date)
	{
		
	var locale=document.forms[0].locale.value;
	var effFromDt =document.forms[0].Bill_Duration_From.value;
	var effToDt =document.forms[0].Bill_Duration_To.value;
	if(entered_date.value!="")
	{
		if(validDate(entered_date.value,'DMY',locale))
		{
			if(!isBeforeNow(entered_date.value,'DMY',locale)){
				alert(getMessage("BL00951",'BL'));
				entered_date.value='';
				return false;
			}			
			if(effToDt != ''){
				if((!isBefore(effFromDt,effToDt,'DMY',locale))){
					alert(getMessage("BL00953",'BL'));
					entered_date.value='';
					return false;
			}
			else{
					return true;
			}
			}
		
		}
		else
		{	
			alert(getMessage("INVALID_DATE_FMT","SM"));
			entered_date.value='';
			return false;
		}
	}
	else
	{
		return true;
	}
}

function reset(){
	summarydetail.location.reload();
}

