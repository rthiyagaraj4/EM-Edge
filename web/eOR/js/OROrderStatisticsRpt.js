/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
--------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------
15/03/2016	IN055027		Raja S			Ramesh G		06/04/2016			MMS-QH-CRF-0216

--------------------------------------------------------------------------------------------------------
*/

function reset(){

	OrorderStatisticsRptFrame.document.Or0rderStatisticsRptForm.reset() ;
	OrorderStatisticsRptFrame.document.getElementById("p_order_type_code").length=0;
	var element = document.createElement('OPTION') ;
	element.value =  'ALL' ;
	element.text =  getLabel("Common.all.label","common_labels");
	OrorderStatisticsRptFrame.document.getElementById("p_order_type_code").add(element);
}

function frompractSearch1(target,code)
{
	if(target.value!="")
		frompractSearch(target,code);	
	else
		parent.OrorderStatisticsRptFrame.document.Or0rderStatisticsRptForm.p_fm_ord_pract_id.value="";
} 

async function frompractSearch(target,code)
{
	
	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	localeName=parent.OrorderStatisticsRptFrame.document.Or0rderStatisticsRptForm.language_id.value;
	var sql="SELECT practitioner_id code, practitioner_name description  FROM am_practitioner_lang_vw where  eff_status ='E'  and language_id=? and upper(practitioner_id) like upper(?) and upper(practitioner_name) like upper(?) order by 2";
	sql=sql.replace('?',"'"+localeName+"'");
	
	argumentArray[0]   =sql;	
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

	retVal= await CommonLookup(getLabel("eOR.practitionerfrom.label","eCA"),argumentArray);
	var ret1 = unescape(retVal);
	arr=ret1.split(",");
	// Commented By Abdulhamid Mohamed
//	if(retVal !=null && retVal != ""){
//		code.value=retVal[0];
//		target.value=retVal[1];
//		
//		}else{
//   		target.value = "";
//   		code.value = "" ;
// 	}
	// Added By Abdulhamid Mohamed
	if(arr[1] == undefined){
		arr[0] = "";
		arr[1] = "";	
	}else{
   		target.value = arr[1];
   		code.value = arr[0];
 	}
}

function FillStatsticsOrderType(OrderCatObj){
	
	var callFrom1="ORDERCAT";
    var ordercatname=OrderCatObj.name;
	var ordercatvalue=OrderCatObj.value;
    var tmplocale=document.Or0rderStatisticsRptForm.language_id.value;
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	xmlStr ="<root><SEARCH ";
		xmlStr += "callFrom=\""+ callFrom1 +"\" " ;

		xmlStr += "ordercatname=\""+ ordercatname +"\" " ;
		xmlStr += "ordercatvalue=\""+ ordercatvalue +"\" " ;		
		xmlStr += "tmplocale=\""+ tmplocale +"\" " ;
		xmlStr +=" /></root>" ;	

		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");

		xmlHttp.open( "POST", "OROrderStatisticsRptValidate.jsp", false );
		xmlHttp.send( xmlDoc );
		responseText=xmlHttp.responseText ;
	eval(responseText );
}

function addLocationList1(code,value) {
	var element = document.createElement('OPTION') ;
	element.value =  code ;
	element.text = value ;
	document.Or0rderStatisticsRptForm.p_order_type_code.add(element);
}
function clearList1( docObj ) {
	var len = eval(docObj+".forms[0].p_order_type_code.options.length") ;
		for(var i=0;i<len;i++){
		eval(docObj+".Or0rderStatisticsRptForm.p_order_type_code.remove(\"locn\")") ;
		}
		var tp = getLabel("Common.all.label","Common") ;
		var opt = eval(docObj+".createElement(\"OPTION\")") ;
		opt.text = tp ;
		opt.value = "ALL" ;
		eval(docObj+".Or0rderStatisticsRptForm.p_order_type_code.add(opt)") ;
}


function showCalendarValidate(str){
	var flg = showCalendar(str);
	document.getElementById(str).focus();
	return flg;
}
function allowDateFormat(){
   var key = window.event.keyCode;   
   if( ! ( (( key>=48 ) && ( key<=58 ) ) || (key == 47)|| (key == 32)) ) {
       return false;
   }
}

function val_from_date(){
	var frdt = document.getElementById("temp_fm_date");
	var tdt = document.getElementById("temp_to_date");
	var locale =  document.getElementById("language_id").value;
	if(frdt.value !='' && tdt.value !='' )// DateUtils.js
	{
		if(validDate(frdt.value,"DMY",locale) && validDate(tdt.value,"DMY",locale))
		{
			var fromDt	= convertDate(frdt.value,"DMY",locale,"en");
			var toDt	= convertDate(tdt.value,"DMY",locale,"en");

			if(!isBefore(fromDt,toDt,'DMY',locale))// DateUtils.js
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				tdt.value="";
				tdt.focus();
			}
		}
	}
}
function val_to_date(obj){
	var frdt = document.getElementById("temp_fm_date");
	var tdt = document.getElementById("temp_to_date");
	var locale =  document.getElementById("language_id").value;

	if(frdt.value !='' && tdt.value !='' )// DateUtils.js
	{
		if(validDate(frdt.value,"DMY",locale) && validDate(tdt.value,"DMY",locale))
		{
			var fromDt	= convertDate(frdt.value,"DMY",locale,"en");
			var toDt	= convertDate(tdt.value,"DMY",locale,"en");

			if(!isBefore(fromDt,toDt,'DMY',locale))// DateUtils.js
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				frdt.focus();
			}
		}
	}
}

function displayDate(fromDate,toDate){
		var formObj = document.Or0rderStatisticsRptForm;
		formObj.p_period_to.value=toDate;
		formObj.p_period_from.value=fromDate;
}

function run(){

    var formobj=OrorderStatisticsRptFrame.document.Or0rderStatisticsRptForm;	
	var pracDesc=formobj.from_pract_desc.value;
	var pract=formobj.to_pract_desc.value;
	var frmdt=formobj.p_fm_date.value;
	var todt=formobj.p_to_date.value;
	
	if(pracDesc !="" && pract !="")
	{
		if( frmdt !="" && todt !="" )
		{
			fields = new Array( formobj.temp_fm_date,formobj.temp_to_date);
			names =  new Array(getLabel("Common.periodfrom.label","Common") ,getLabel("Common.periodto.label","Common"));
	
				if(OrorderStatisticsRptFrame.checkFields(fields,names,messageFrame))
				{
					OrorderStatisticsRptFrame.document.Or0rderStatisticsRptForm.action="../../eCommon/jsp/report_options.jsp";			
					OrorderStatisticsRptFrame.document.Or0rderStatisticsRptForm.submit() ;	
				}				
		}else
		{ 
			errorMsg = "APP-OR0414 From and To dates are Mandatory ";
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errorMsg ;
		}
	}else
	{
		errorMsg = "APP-OR0414 Practitioner From and Practitioner To are Mandatory";
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errorMsg ;
	}
}	


function topractSearch1(target,code)
{
if(target.value!="")
	{
	topractSearch(target,code);
	}
	else
	parent.OrorderStatisticsRptFrame.document.Or0rderStatisticsRptForm.p_to_ord_pract_id.value="";
} 
async function topractSearch(target,code)
{

	var argumentArray= new Array();
	var dataNameArray= new Array();
	var dataValueArray= new Array();
	var dataTypeArray= new Array();
	localeName=parent.OrorderStatisticsRptFrame.document.Or0rderStatisticsRptForm.language_id.value;
	var sql="SELECT practitioner_id code, practitioner_name description  FROM am_practitioner_lang_vw where  eff_status ='E'  and language_id=? and upper(practitioner_id) like upper(?) and upper(practitioner_name) like upper(?) order by 2";
	sql=sql.replace('?',"'"+localeName+"'");
	
	argumentArray[0]   = sql;
	argumentArray[1]   = dataNameArray ;
	argumentArray[2]   = dataValueArray ;
	argumentArray[3]   = dataTypeArray ;
	argumentArray[4]   = "1,2";
	argumentArray[5]   = target.value;
	argumentArray[6]   = CODE_LINK ;
	argumentArray[7]   = CODE_DESC ;

	retVal= await CommonLookup(getLabel("eOR.practitionerto.label","COMMON"),argumentArray);
	var ret1 = unescape(retVal);
	arr=ret1.split(",");
	// Commented By Abdulhamid Mohamed
//	if(retVal !=null && retVal != ""){
//		code.value=retVal[0];
//		target.value=retVal[1];
//		
//		}else{
//   		target.value = "";
//   		code.value = "" ;
// 	}
	// Added By Abdulhamid Mohamed
	if(arr[1] == undefined){
		arr[0] = "";
		arr[1] = "";	
	}else{
   		target.value = arr[1];
   		code.value = arr[0];
 	}
}

function chkDateto(Obj) 
{
	var localeName=parent.OrorderStatisticsRptFrame.document.Or0rderStatisticsRptForm.language_id.value;
	if (localeName!='en')
	{
	var date = convertDate(Obj.value,'DMY',localeName,"en");
	parent.OrorderStatisticsRptFrame.document.Or0rderStatisticsRptForm.p_to_date.value=date;
	}else{
		parent.OrorderStatisticsRptFrame.document.Or0rderStatisticsRptForm.p_to_date.value=Obj.value;
	}
}

function chkDatefrm(Obj) 
{
	var localeName=parent.OrorderStatisticsRptFrame.document.Or0rderStatisticsRptForm.language_id.value;
	if (localeName!='en')
	{
	var date = convertDate(Obj.value,'DMY',localeName,"en");
	parent.OrorderStatisticsRptFrame.document.Or0rderStatisticsRptForm.p_fm_date.value=date;
	}else{
		parent.OrorderStatisticsRptFrame.document.Or0rderStatisticsRptForm.p_fm_date.value=Obj.value;
	}
}
