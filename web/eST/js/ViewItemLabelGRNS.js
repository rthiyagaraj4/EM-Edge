
/*
-------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		 	Edit history        Name			       Rev.Date		     Rev.Nam			     Description
-------------------------------------------------------------------------------------------------------------------------------------------------------------
04/08/2017							Shazana hasan							        				MMS-DM-CRF-099.2(Added Look Up screen for GRN item label)

--------------------------------------------------------------------------------------------------------------------------------------------------------------
*/


function showDocDetails(docno,docType) {
	
	//window.returnValue = docno+":"+docType;
	//window.close();
	let dialogBody = parent.parent.document.getElementById('dialog-body');
    dialogBody.contentWindow.returnValue = docno+":"+docType;
    
    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close(); 
}
function searchCodeStore(objCode,objDesc) {
		var argumentArray = new Array();
		var dataNameArray = new Array();
		var dataValueArray = new Array();
		var dataTypeArray = new Array();
		dataNameArray[0] = "facility_id";
		dataValueArray[0] = document.forms[0].p_facility_id.value;
		dataTypeArray[0] = STRING;
		argumentArray[0] = escape(document.forms[0].SQL_ST_ITEM_STORE_LOOKUP.value) + "'" + document.forms[0].p_language_id.value + "'";		
		argumentArray[1] = dataNameArray;
		argumentArray[2] = dataValueArray;
		argumentArray[3] = dataTypeArray;
				argumentArray[4] = "2,3";
		argumentArray[5] = objDesc.value;
		argumentArray[6] = CODE_LINK;
		argumentArray[7] = CODE_DESC;
				
		returnedValues = CommonLookup(getLabel("Common.Store.label", "Common"), argumentArray);		
		if (returnedValues != null && returnedValues != "" && returnedValues!=undefined) {
			objCode.value = returnedValues[0];
			objDesc.value = returnedValues[1];
			//objCode.readOnly = true;
		}
}
// Added for CRF-99.2 CRF STARTS
function AssignSupplier(obj)
{
	document.formViewGRNSCriteria.supp_code.value=obj.value;

}

function AssignStoreCode(obj){
	document.formViewGRNSCriteria.store_code.value=obj.value;
	
	
}
function frmdate(){
	var to_dt=document.formViewGRNSCriteria.to_date_time.value;
	 if(to_dt==""){
		   alert(getMessage("PERIOD_TO_DATE_NOT_BLANK", "ST"));
		   document.formViewGRNSCriteria.to_date_time.focus();
		   return;
		   
	 }
	 else{
		 getResults();
	 }
	
}

function getResults() 
{

	
	var dt_from = document.forms[0].from_date_time.value;
	var dt_to  = document.forms[0].to_date_time.value;
	var p_facility_id  = document.forms[0].p_facility_id.value;
	var store_code = document.forms[0].store_code.value;
	var supp_code=	document.forms[0].supp_code.value;
	
	parent.ViewGRNSResultFrame.location.href = "../../eST/jsp/ViewItemLabelGRNSResultDetails.jsp?store_code="+store_code+"&dt_from="+dt_from+"&dt_to="+dt_to+"&p_facility_id="+p_facility_id+"&supp_code="+supp_code;	
	//parent.f_query_rst.location.href = "../../eST/jsp/ViewGRNSResult.jsp?" + qryString;
	//parent.f_query_rst_dtl.location.href = "../../eCommon/html/blank.html";
	//parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
} 
// Added for CRF-99.2 CRF ENDS

function CheckValidDate(Object2, focusflag) {
	alert('CheckValidDate Object2 --> ',+Object2.value);
	var datefield = Object2;
	if (Object2.value != undefined) {
		Object2 = Object2.value;
	} else {
		Object2 = Object2;
	}
	if (ChkDate(Object2) == false) {
		//alert(getMessage("XI1059", "XI"));
		alert ('value required');
		if (datefield.value != undefined && focusflag == null) {
			datefield.select();
			datefield.focus();
		}
		return false;
	} else {
		return true;
	}
}
function AllowDateFormat() {
	var key = window.event.keyCode;
	if (!(((key >= 48) && (key < 58)) || (key == 47))) {
		return false;
	}
}
function checkDateRange(fromDate, toDate) {
	if (doDateCheckOR(fromDate, toDate) == 1) {
		alert(getMessage("XI1009", "XI"));
		//parent.f_query_add_mod.document.forms[0].to_date_time.value = fromDate.value;
		toDate.focus();
		return false;
	}
}
function doDateCheckOR(from, to) {
	var fromarray;
	var toarray;
	var fromdate = from.value;
	var todate = to.value;
	if (fromdate.length > 0 && todate.length > 0) {
		fromarray = fromdate.split("/");
		toarray = todate.split("/");
		var fromdt = new Date(fromarray[2], fromarray[1] - 1, fromarray[0]);
		var todt = new Date(toarray[2], toarray[1] - 1, toarray[0]);
		if (Date.parse(todt) < Date.parse(fromdt)) {
			return 1;
		} else {
			if (Date.parse(todt) > Date.parse(fromdt)) {
				return -1;
			} else {
				if (Date.parse(todt) == Date.parse(fromdt)) {
					return 0;
				}
			}
		}
	}
} //End of function
function checkWithSysDate(obj) {
	//var currDate = parent.f_query_add_mod.document.forms[0].sys_date;
	
	var currDate = document.forms[0].sys_date.value;
	alert('checkWithSysDate', +currDate);
	if (doDateCheckOR(obj, currDate) == 1) {
		alert(getMessage("DATE_NOT_GREATER_SYSDATE", "common"));
		obj.value = currDate.value;
		obj.focus();
		return false;
	}
}
function showCalendarValidate(str) {
	var flg = showCalendar(str);
	//eval("document.all." + str + ".focus();");
	document.getElementById(str).focus();
	return flg;
}

//Added for CRF-99.2 CRF starts
function doDateCheckLoc(fromDate,toDate,currDate,format,locale)
{	
	if (!(fromDate.value == null || fromDate.value == "" ))
	{		
				
		if((fromDate.value != '' && !validDate(fromDate.value, format, locale)))
		{

			fromDate.focus();
			return false;
		}
		if((toDate.value != '' && !validDate(toDate.value, format, locale)))
		{
			alert(getMessage("INVALID_DATE_FMT", "SM"));////Added by Archana Dhal related to incident no. IN022829.
			//alert(msg);
			toDate.select();
			toDate.focus();
			return false;
		}
		if((fromDate.value != '' && !validDate(fromDate.value, format, locale)))
		{
			alert(getMessage("INVALID_DATE_FMT", "SM"));////Added by Archana Dhal related to incident no. IN022829.
			//alert(msg);
			fromDate.select();
			fromDate.focus();
			return false;
		}
		alert("befr if loop");
		alert("fromDate.value:  "+fromDate.value);
		alert("toDate.value:  "+toDate.value);	
		
		if(isBeforeNow(fromDate.value, format, locale))
		{
			alert("inside if loop");
			alert("fromDate.value:  "+fromDate.value);
			alert("toDate.value:  "+toDate.value);
			
			if (!(toDate.value == null || toDate.value == "" ))
			{
				if(isBeforeNow(toDate.value, format, locale))
				{
					if(isAfter(toDate.value, fromDate.value, format, locale))
						return true;
					else
					{
						alert(getMessage("TO_DT_GR_EQ_FM_DT","CA"));
						/*if(patientId==""|| patientId==null)
						{
							fromDate.focus();
							return false;
						}
						else
						{
							toDate.focus();
							return false;
						}*/
					}
				}
				else
				{
					alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
					//toDate.focus();
					//return false;
				}
			}
		}
		else
		{
			
			alert(getMessage("DATE_NOT_GREATER_SYSDATE","Common"));
			//fromDate.focus();
			//return false;
		}
		
	}
	
	
 }
 // Added for CRF-99.2 CRF ends
 function submitPrevNext(from, to) {
	document.forms[0].from.value = from;
	document.forms[0].to.value = to;
	document.forms[0].target = "ViewGRNSResultFrame";
	document.forms[0].submit();
	//parent.ViewGRNSResultFrame.location.href = "../../eCommon/html/blank.html";
	//parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num=";
}

 
 function checkSysdate(receiptdate, sysdate, locale) {//added locale for SRR20056-SCF-9527 by Badmavathi on 26/08/2015
		if(receiptdate.value!=""){
			//alert(""+receiptdate);
		//	var flag = ChkDate(receiptdate); //commented for SRR20056-SCF-9527 by Badmavathi on 26/08/2015
			var flag = CheckDateLeap(receiptdate,'DMY',locale);//added for SRR20056-SCF-9527 by Badmavathi on 26/08/2015
			//alert("flag"+flag);
			/*	if (!flag) {
				alert(getMessage("INVALID_DATE_FMT", "ST"));
				receiptdate.select();
				receiptdate.focus();
				return false;
			}*///commented for SRR20056-SCF-9527 by Badmavathi on 26/08/2015
			if (flag) {
				if (checkdateWithSysDate(receiptdate, sysdate)) {
					
					alert(getMessage("ST_DOC_DT_NOT_GR_SYSDATE", "ST"));
					receiptdate.select();
					//receiptdate.focus();
					return false;
				}
			}
		}
	}
 function doDateCheckLocalfrom(from, to) {
		var fromdate = from.value;
		
		var todate = to.value;
		var arFromDate = fromdate.split("/");
		var arToDate = todate.split("/");
		if (Date.parse("" + arFromDate[1] + "/" + arFromDate[0] + "/" + arFromDate[2] + "/") > Date.parse("" + arToDate[1] + "/" + arToDate[0] + "/" + arToDate[2] + "/")) {
			alert(getMessage("TO_DT_GR_FM_DT", "ST"));
			from.select();
			from.focus();
			return false;
		}
	}
 function doDateCheckLocal(from, to) {
		var fromdate = from.value;
		
		var todate = to.value;
		var arFromDate = fromdate.split("/");
		var arToDate = todate.split("/");
		if (Date.parse("" + arFromDate[1] + "/" + arFromDate[0] + "/" + arFromDate[2] + "/") > Date.parse("" + arToDate[1] + "/" + arToDate[0] + "/" + arToDate[2] + "/")) {
			alert(getMessage("TO_DT_GR_FM_DT", "ST"));
			to.select();
			to.focus();
			return false;
		}
	}
 

	function checkdateWithSysDate(entered_date, sys_date) {
		var fromdate = entered_date.value;
		var todate = sys_date.value;
		var arFromDate = fromdate.split("/");
		var arToDate = todate.split("/");
			if (Date.parse("" + arFromDate[1] + "/" + arFromDate[0] + "/" + arFromDate[2] + "/") > Date.parse("" + arToDate[1] + "/" + arToDate[0] + "/" + arToDate[2] + "/")) {
				return true;
			}else{
				return false;
			}
	}
	
	/*function CheckDateNew(Object2,focusflag) {
		var datefield = Object2;
	    if (ChkDateNew(Object2) == false) {
	        if(focusflag == null)
	        {
	            datefield.select();
	            datefield.focus();
	        }
	        return false;
	    }
	    else {
	        return true;
	    }
	}
*/
