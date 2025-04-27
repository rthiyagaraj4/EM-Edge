  //saved on 02.11.2005
function reset()
{
	f_query_add_mod.location.reload();
}
async function callDrugSearch(obj) {
	var arrCodeDesc = await DrugSearch("D",obj);
	if(arrCodeDesc != null && arrCodeDesc != "" ) {
		document.formPhCytoInciReportCriteria.drug_code.value	=	arrCodeDesc[0];
		obj.value =	arrCodeDesc[1];
	}
}
function getNext(flagSelect){
	//alert("flagSelect===="+flagSelect);
	var formObjDetail =parent.f_query_report_result.document.formPhReportQueryResult
		alert(formObjDetail);
	parent.parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?";
	formObjDetail.nextPrevFlag.value=flagSelect;//set the Flag to next or Prevoius
	formObjDetail.action.value="nextPrev";
	//alert("nextPrevFlag===="+formObjDetail.nextPrevFlag.value);
	formObjDetail.action="../../ePH/jsp/PhCytoInciReportResult.jsp";
	//alert("action===="+formObjDetail.action);
	formObjDetail.submit();
}
function showReport(seqnum)
{
parent.f_query_report_result.document.formPhReportQueryResult.p_incident_no.value = seqnum;
parent.f_query_report_result.document.formPhReportQueryResult.p_report_id.value="PHCYTOINCIREPO";
parent.f_query_report_result.document.formPhReportQueryResult.action="../../eCommon/jsp/report_options.jsp";
parent.f_query_report_result.document.formPhReportQueryResult.submit();
parent.f_query_report_result.location.href="../../eCommon/html/blank.html";
}

function showResult()
{
	var formObj = document.formPhCytoInciReportCriteria;
	var locale					=	formObj.locale.value;
	var cyto_reported_fromdate	=	convertDate(formObj.cyto_reported_fromdate.value,'DMY',locale,"en"); 
	var cyto_reported_todate	=	convertDate(formObj.cyto_reported_todate.value,'DMY',locale,"en");
	//var cyto_reported_fromdate = formObj.cyto_reported_fromdate.value;
	//var cyto_reported_todate = formObj.cyto_reported_todate.value;
	var drug_code = formObj.drug_code.value;
	var cyto_no = formObj.cyto_no.value;
	var ReportedBy = formObj.ReportedBy.value;
	var locn_type = formObj.locn_type.value;
	var locations = formObj.locations.value;
	var mode = formObj.mode.value;
	
//	alert(locn_type);
//	alert(locations);
	var fields = new Array (formObj.cyto_reported_fromdate,formObj.cyto_reported_todate);
	var names = new Array (getLabel("ePH.ReportingDateFrom.label","PH"),getLabel("ePH.ReportingDateTo.label","PH") );
	if(checkFields( fields, names, parent.parent.messageFrame)) {

		parent.f_query_report_result.location.href="../../ePH/jsp/PhCytoInciReportResult.jsp?cyto_reported_fromdate="+cyto_reported_fromdate+"&cyto_reported_todate="+cyto_reported_todate+"&cyto_no="+cyto_no+"&ReportedBy="+ReportedBy+"&drug_code="+drug_code+"&locn_type="+locn_type+"&locations="+locations+"&mode="+mode;
		parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
	}
}

function callLocation(obj){
	var frmObj=document.formPhCytoInciReportCriteria;
	var locn_type=frmObj.locn_type.value;
	if(locn_type!=""){
		var xmlStr ="<root><SEARCH ";
		xmlStr+= "bean_id =\"" + frmObj.bean_id.value+ "\" " ;
		xmlStr+= "bean_name =\"" + frmObj.bean_name.value + "\" " ;
		xmlStr+= "locn_type =\"" + locn_type + "\" " ;
		xmlStr +=" /></root>";
		var temp_jsp="PhCytoInciReportingValidate.jsp?func_mode=getLocations";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		//alert(xmlStr);
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST",temp_jsp,false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText ;	
		//alert(responseText);
		eval(responseText);
	}
}

function assignLocationph(locn_code, short_desc){
	var opt=parent.frames[0].document.createElement('OPTION');
	opt.value=locn_code;
	opt.text=short_desc;
	parent.frames[0].document.forms[0].locations.add(opt);
}

async function searchUserNames2( target ) 
{
	var frmObj = document.formPhCytoInciReportCriteria;

	var language_id=document.formPhCytoInciReportCriteria.locale.value;
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0]   = document.formPhCytoInciReportCriteria.user_id_sql.value+"'"+language_id+"'";

	/*
	var argumentArray	= new Array() ;
	var dataNameArray	= new Array() ;
	var dataValueArray	= new Array() ;
	var dataTypeArray	= new Array() ;
	argumentArray[0] = document.getElementById("user_id_sql").value+"'"+frmObj.language_id.value+"'";
	*/

	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = CODE_LINK ;
	argumentArray[7] = CODE_DESC ;
	retArray = await CommonLookup(getLabel("Common.user.label","Common"), argumentArray );
	var ret1=unescape(retArray);
 	var arr=ret1.split(',');
 	if(arr[1]==undefined) 
		{
 		arr[0]="";	
 		arr[1]="";	
		}
	if(retArray != null && retArray != "" ) 
	{
		frmObj.ReportedBy.value = arr[0];
	    frmObj.rprtby_search.disabled=true;
	}
}
async function checkUser2(objVal) 
{
	if (objVal == "") 
		{
			document.formPhCytoInciReportCriteria.ReportedBy.disabled=false;
		}
		else 
		{
			await searchUserNames2(document.formPhCytoInciReportCriteria.ReportedBy);
		}
}

function doDateCheck1(from,to) {
	alert();
    var fromarray; var toarray;
    var fromdate = from.value ;
    var todate = to.value ;
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
            if(Date.parse(todt) < Date.parse(fromdt)) {
               // messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=APP-SM0012 - To Date should be greater than or equal to From Date";
			   alert(getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH'));
			   from.value="";
			   from.focus();
               return false;
            }
            else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
    }
return true;
}


function doFromDateCheck(from,to) {
    var fromarray; var toarray;
    var fromdate = from.value ;
    var todate   = to.value ;
    if(fromdate.length > 0 && todate.length > 0 ) {
            fromarray = fromdate.split("/");
            toarray = todate.split("/");
            var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
            var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
            if(Date.parse(todt) < Date.parse(fromdt))
               return 1 ;
            else if(Date.parse(todt) > Date.parse(fromdt))
			  return  -1 ;
			else if(Date.parse(todt) == Date.parse(fromdt))
			 return  0 ;

   }

}

function checkDateRange(obj,from){

	var fromDate = eval("document."+from+".cyto_reported_fromdate")
	var toDate = eval("document."+from+".cyto_reported_todate")
	
	if(CheckDateT(obj)){  // changed CheckDate to CheckDateT for leap year calculation 

		if(doFromDateCheck(fromDate,toDate) == 1) { 
			alert(getMessage('TO_DATE_EQUAL_GREATER_FROM_DATE','PH')); 
			obj.value="";
			obj.focus()
			return false
		}
	}
}

// the below method is used for leap year calculation
	function CheckDateT(obj){
		var locale=document.formPhCytoInciReportCriteria.p_language_id.value;
	
		if(obj.value!=""){
			if(!validDate(obj.value, 'DMY',locale)){
				alert(getMessage("INVALID_DATE_FMT", "SM"));
				obj.select();
				obj.focus();
				return false;
			}
		}
		else{
			obj.value=convertDate(obj,'DMY',locale,'en');
		}
	}
function callFocus(obj){

	obj.focus();
}
