
function reset()
{
	CardSubscripFrame.document.location.reload();
}

function create()
{	

}


function query()
{


}


function CheckForSpecChars_loc(event,obj){
	
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
	if(obj.value.length==0)
	{

		if('_'.indexOf(key)!=-1)
			return false;
	}

    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}


function chkSpecial(event,obj)
{
	return CheckForSpecChars_loc(event,obj);

}
function putdeci(object)
	{	
		if(object.value!='')
		{
		//var decimal=parent.PkgDefHeader.document.forms[0].noofdecimal.value;
		var decimal=eval("document.frmPkgSubs.noofdecimal").value;
	
		putDecimal(object,17,decimal);
		}
	}

function apply()
{
	var topFrame = CardSubscripFrame.CardSubscripPatientSearch.report_form;
	var botFrame = CardSubscripFrame.CardSubscripEntry.frmPkgSubs;
	var patientId=topFrame.patientId.value;
	var fieldsTop  = new Array (topFrame.patientId);
	var patIdlbl=getLabel("Common.patientId.label","common");
	var namesTop = new Array ( patIdlbl);
	if(checkFieldsofMst( fieldsTop, namesTop, messageFrame)) {
		var cardType = botFrame.card_type_id.value;
		var effFrom = botFrame.effFromHdn.value;
		var tbl = botFrame.document.getElementById('billing_group_category_table');
		var totalRows = tbl.rows.length; 
		totalRows = totalRows-1;
		//alert(patientId+'-'+cardType+'-'+effFrom+'-'+totalRows);
		
		var patId = '';
		var addPatId = '';
		
		var tempPatId = '';

		var fields = new Array (topFrame.patientId,botFrame.card_type_id,botFrame.effFromHdn);
		var patIdlbl=getLabel("Common.patientId.label","common");
		var cardTypeLbl=getLabel("eBL.CARD_TYPE.label","bl");
		var fromDtLbl = getLabel("Common.fromdate.label","bl");
		var names = new Array ( patIdlbl,cardTypeLbl,fromDtLbl);
		if(checkFieldsofMst( fields, names, messageFrame)) 
		{
			for(var i=0;i<totalRows;i++){
				patId = 'billing_group_by_category_code'+i;
				//if(botFrame.document.getElementById(patId).value.length>0)
				addPatId = addPatId+botFrame.document.getElementById(patId).value+':::';
			}
		
			//alert(patientId+'-'+cardType+'-'+effFrom+'-'+totalRows+'-'+addPatId);
		
			botFrame.action = '../../servlet/eBL.CardSubscriptionServlet?patient_id='+patientId+'&card_type='+cardType+'&effFrom='+effFrom+'&addPatId='+addPatId;
			
			botFrame.submit();
		}
	}
	
	
}


function getPatID()
	{	
		var pat_id=PatientSearch();			
		if( pat_id != null )						
		document.forms[0].patientId.value = pat_id ;					
		
	}

function getnewPatID()
{	
	var pat_id=PatientSearch();				
	if( pat_id != null )						
	document.forms[0].patientids.value = pat_id ;	
}


function getrowPatID(index)
{	
	var pat_id=PatientSearch();		
	if( pat_id != null )						
	eval("document.forms[0].patientrowids"+index).value = pat_id ;					
	eval("document.forms[0].patientrowids"+index).focus();
}

function onSuccess()
{
	var formObj = document.forms[0];
	var params = formObj.params.value;
	CardSubscripFrame.location.href="../../eBL/jsp/CardSubscripPatientQueryFrame.jsp?"+params;
}


function callPatValidation(obj)
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
		callPackagesubspage()
	}
	
	}
}

function callPatValidationSub(obj,ind)
{
	var patient_id=obj.value;	
	var frm = document.forms[0];
	var primaryPat = parent.CardSubscripPatientSearch.report_form.patientId.value

	var pId = 'billing_group_by_category_code'+ind;
	var name = 'billing_group_by_category_long_desc'+ind;
	var age =  'billing_group_by_category_short_desc'+ind;
	var price = 'billing_group_by_category_price_class'+ind;
	if(primaryPat == patient_id){
		alert(getMessage('BL9133','BL'));
		document.getElementById(name).value = '';
		document.getElementById(age).value =  '';
		document.getElementById(price).value =  '';	
		document.getElementById(pId).value = '';
		return false;
	}
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
		document.getElementById(name).value = '';
		document.getElementById(age).value =  '';
		document.getElementById(price).value =  '';
		obj.select();
	}else if(responseText=="Y"){
		obj.value = patient_id;
		var cardCode=document.forms[0].card_type_id.value;
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "patient_id=\"" + patient_id + "\" " ;					
		xmlStr +=" /></root>";
		var temp_jsp="PkgSubscriptionValidation.jsp?func_mode=get_patient_hdr&patient_id="+patient_id+"&cardCode="+cardCode;					
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		var responseText=trimString(xmlHttp.responseText);
		//alert(responseText)
		var responseTextArr = responseText.split("::::");
		var responseArr = responseTextArr[0].split('###');

		document.getElementById(name).value = responseArr[0];
		document.getElementById(age).value =  responseArr[1];
		//document.getElementById(price).value =  frm.price_desc.value;		
		if(responseTextArr[1]!= null && responseTextArr[1]!='undefined' && responseTextArr[1]!='null'){
			document.getElementById(price).value =  responseTextArr[1];
		}
		else{
			alert(getMessage('BL00225','BL'));
			document.getElementById(name).value = '';
			document.getElementById(age).value =  '';
			document.getElementById(price).value =  '';	
			document.getElementById(pId).value = '';
		}
		
	}
	
	}
	else{
		document.getElementById(name).value = '';
		document.getElementById(age).value =  '';
		document.getElementById(price).value =  '';
	}
}


function callPackagesubspage()
{
	var patientId=parent.CardSubscripPatientSearch.document.report_form.patientId.value;
		if(patientId=="") {
		alert(getMessage("BL0002","BL"));
		parent.CardSubscripPatientSearch.document.report_form.patientId.select();
	}
	else parent.CardSubscripEntry.location.href="../../eBL/jsp/PkgPrivilegeDtls.jsp?patientId="+patientId;
}


function closeSubs()
{
	window.close();
}

//Function for duplicate service/item check
function checkForDuplicate(item,index)
{

	item=item.value
	var total_records = 0;
	total_records = document.forms[0].total_records.value;
	if(total_records>1)
	{
		var xmlStr ="<root><SEARCH ";
		for(var i=0;i<total_records; i++)
		{
			xmlStr+= "code_"+i+"=\"" + eval("document.forms[0].packageCode_"+i).value + "\" " ;

		}
		xmlStr+= "item=\"" + item + "\" " ;		
		xmlStr+= "index=\"" + index + "\" " ;		
		xmlStr+= "total_records=\"" + total_records + "\" " ;
		xmlStr +=" /></root>";
		//alert("xmlStr:"+xmlStr)
		var updation=formValidation(xmlStr,"DUPLICATE_CHECK");
	}
}

function duplicateAlert(index)
{

	eval("document.forms[0].packageCode_"+index).value= "";
	eval("document.forms[0].packageDesc_"+index).value= "";
	eval("document.forms[0].fromDate_"+index).value= "";
	eval("document.forms[0].pkgAmt_"+index).value= "";
	eval("document.forms[0].episodeType_"+index).value= "";
	eval("document.forms[0].strOPYN_"+index).value= "";
	eval("document.forms[0].strEMYN_"+index).value= "";
	eval("document.forms[0].strIPYN_"+index).value= "";
	eval("document.forms[0].strDCYN_"+index).value= "";

	alert(getMessage("BL8507",'BL'));
}



function checkForSpecCharsforID(event)
{
    var strCheck = '0123456789/';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}

function cal_error (str_message,obj) {
	alert (str_message);
	document.forms[0].errCheck.value = 'yes';
	obj.focus();
	obj.select();
	return false;
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
		document.forms[0].errCheck.value = 'no';
	}

	return true;
}


function addnew(tableId)
{
	 	if(tableId=='billing_group_category_table')
		{		
			table = document.getElementById(tableId);
			var rowCount =  table.rows.length; 
			
			var i=rowCount;
			var index;
			index = i-1;
			var indexChk = index-1;
			patIdChk = 'billing_group_by_category_code'+indexChk;
			if(document.getElementById(patIdChk).value.length<1){
				alert(getMessage('BL9130','BL'));
				document.getElementById(patIdChk).focus();
				return false;
			}
			var row =  table.insertRow(i);
			var cell1=row.insertCell(0);
			var cell2=row.insertCell(1);
			var cell3=row.insertCell(2);
			var cell4=row.insertCell(3);
			var cell5=row.insertCell(4);
			cell1.innerHTML="<input type ='text' 	 	name='patientrowids"+index+"' id='patientrowids"+index+"'  		id='billing_group_by_category_code"+index+"'	 	maxlength=12 	size=15 	onBlur='ChangeUpperCase( this );callPatValidationSub(this,"+index+");' onKeyPress='changeToUpper()' onBlur='showServiceGroup();' /><input type='button' class='button' name='patientidbut "+index+"' id='patientidbut "+index+"' value='?' onClick='getrowPatID("+index+");callPatValidationSub(billing_group_by_category_code"+index+","+index+");' tabindex='2'>"
			cell2.innerHTML="<input type ='text' 		name='billing_group_by_category_long_desc"+index+"' id='billing_group_by_category_long_desc"+index+"'   	id='billing_group_by_category_long_desc"+index+"' 	maxlength=100 	size=50 	onBlur='copyBillingGroupByCategory("+index+");showBillingGroupByCategory("+index+");'    onKeyPress='return CheckForSpecChar1(event);lockbackSpace();'   disabled  />"
			cell3.innerHTML="<input type ='text' 		name='billing_group_by_category_short_desc"+index+"' id='billing_group_by_category_short_desc"+index+"'   	id='billing_group_by_category_short_desc"+index+"' 	maxlength=100 	size=15     onKeyPress='return CheckForSpecChar1(event);lockbackSpace();' disabled />"
			cell4.innerHTML="<input type ='text' 		name='billing_group_by_category_price_class"+index+"' id='billing_group_by_category_price_class"+index+"'   id='billing_group_by_category_price_class"+index+"'	maxlength=100 	size=35     onKeyPress='return CheckForSpecChar1(event);lockbackSpace();' disabled />"
			cell5.innerHTML="<input type='hidden'  		name='type"+index+"' id='type"+index+"'  									id='type"+index+"'	 						 		value=\"insert\"		 />";
			window.scrollTo(0, table.scrollHeight);
			//row.setAttribute("onclick",showBillingGroupByCategoryDetails('','','insert'));


		}
}

function callPackageServiceCode( obj)
{
	var frm = document.forms[0];
	var retVal =    new String();
	
	var value  = obj.value;
	//var sql ="SELECT SHORT_DESC DESCRIPTION, CARD_TYPE_CODE CODE FROM  BL_HCARD_HDR WHERE UPPER(CARD_TYPE_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) ORDER BY 1";
	var sql = frm.sqlCardDesc.value;
	var title									= 	getLabel("eBL.CARD_TYPE.label", 'Bl');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
    var package_service_code					=	document.getElementById('package_service_code');
    argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	value ;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	
	retVal 										=   CommonLookup( title, argumentArray );
	if(retVal != null && retVal != "")
	{
		frm.card_type_id.value 				= 	retVal[0];
		frm.card_type.value 				=	retVal[1] ;
		var patientId = frm.patientId.value;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var param="func_mode=get_Card_Details&card_id="+retVal[0]+"&patient_id="+patientId;
		//var param="func_mode=get_Card_Details&card_id="+retVal[0];
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eBL/jsp/PkgSubscriptionValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var responseText=trimString(xmlHttp.responseText);	
	//	alert(responseText);
		var responseTextArr = responseText.split(":::");
		frm.price_class.value = responseTextArr[0];
		frm.price_desc.value = responseTextArr[1];
		frm.valid_days.value = responseTextArr[2];
		frm.effFromMaster.value = responseTextArr[3];
		frm.effToMaster.value = responseTextArr[4];
		frm.from_date.disabled = false;
		frm.calendar_ctrl.disabled = false;
		//Added to blank if a differnt card is chosen
		frm.from_date.value = '';
		frm.to_date.value = '';
		frm.member_fees.value = '';
		//Added to blank if a differnt card is chosen
		//Modified by DhanasekarV against incident  38675
		if(frm.price_class.value=='')
		{
		alert(getMessage('BL00225','BL'));
		obj.value ='';
		return false;
		}
		//Modified by DhanasekarV against incident  38675  End
		setPriceClass(responseTextArr[1]);
 	}
	else
	{
		frm.card_type_id.value  			=	"";
		frm.card_type.value  			= 	"" ;
		frm.price_class.value = "";
		frm.price_desc.value = "";
		frm.from_date.disabled = true;
		frm.from_date.value = '';
		frm.to_date.value = '';
		frm.member_fees.value = '';
		frm.calendar_ctrl.disabled = true;
		setPriceClass('');
	}


}

function setPriceClass(obj){
	var table = document.getElementById('billing_group_category_table');
	var rowCount =  table.rows.length; 
	var index = rowCount-1;
	for(i=0;i<index;i++){
		patIdChk = 'billing_group_by_category_code'+i;		
		priceChk = 'billing_group_by_category_price_class'+i;
		nameChk = 'billing_group_by_category_long_desc'+i;
		ageChk = 'billing_group_by_category_short_desc'+i;
		if(document.getElementById(patIdChk).value.length>0){
			document.getElementById(patIdChk).value = '';
			document.getElementById(priceChk).value = '';
			document.getElementById(nameChk).value = '';
			document.getElementById(ageChk).value = '';
		}
	}
}

function setToDate(obj){
	var frm = document.forms[0];
	if(obj.value.length<1){
		frm.to_date.value = '';
		frm.member_fees.value = '';
		return false;
	}
	//Modified By DhanasekarV   38610
//	var valid_days = frm.valid_days.value;
  var valid_days = (frm.valid_days.value-1);
	var fromDate = obj.value;
	//For Checking Dates
	var effFromMaster = frm.effFromMaster.value;
	var effToMaster = frm.effToMaster.value;

	var fromDateArr = fromDate.split("/");
	var effFromDateArr = effFromMaster.split("/");
	var effToDateArr = effToMaster.split("/");

	var fromDt = new Date();
	fromDt.setFullYear(fromDateArr[2],fromDateArr[1]-1,fromDateArr[0]);

	var effFromDt = new Date();
	effFromDt.setFullYear(effFromDateArr[2],effFromDateArr[1]-1,effFromDateArr[0]);

	var effToDt = new Date();
	effToDt.setFullYear(effToDateArr[2],effToDateArr[1]-1,effToDateArr[0]);

	//alert(effToMaster)
	if(fromDt<effFromDt || fromDt>effToDt){
		if(effToMaster!='null'){
			alert("Please select From date in the range "+effFromMaster+" and "+effToMaster);
		}
		else{
			alert("Please select From date greater than "+effFromMaster);
		}
		frm.to_date.value = '';
		frm.member_fees.value = '';
		frm.from_date.value = '';
		return false;
	}

	//alert(fromDt);
	//alert(effFromDt);
	//alert(effToDt);
	//For Checking Dates
	frm.effFromHdn.value = obj.value;
	var patientId = frm.patientId.value;
	var card_type = frm.card_type_id.value;
	if(frm.errCheck.value == 'no'){
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var param="func_mode=get_To_Date&fromDate="+fromDate+"&valid_days="+valid_days+"&patientId="+patientId+"&card_type="+card_type;
		//var param="func_mode=get_Card_Details&card_id="+retVal[0];
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eBL/jsp/PkgSubscriptionValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var responseText=trimString(xmlHttp.responseText);	
		responseTextArr = responseText.split(":::");
		frm.to_date.value = responseTextArr[0];
		if(responseTextArr[1] != null){
			if(responseTextArr[1] >=0 ){
				frm.member_fees.value = responseTextArr[1];
			}
			else{
				frm.member_fees.value = 0;
			}
		}
		else frm.member_fees.value = 0;
	}
	
}

function clearCard(){
	var frm = document.forms[0];
	frm.card_type_id.value = '';
	frm.price_class.value = '';
	frm.price_desc.value = '';
	frm.from_date.value = '';
	frm.to_date.value = '';
	frm.member_fees.value = '';
	frm.from_date.disabled = true;
	frm.calendar_ctrl.disabled = true;
	setPriceClass('');
}

