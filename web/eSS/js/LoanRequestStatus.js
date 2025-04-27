/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
 /*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Create History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
11/02/2014	       		BRU-HIMS-CRF-225.1	    Sakti Sankar	   11/02/2014	    Sakti Sankar			 Newly Created
--------------------------------------------------------------------------------------------------------------------------------------------
*/

var	function_id	=	"" ;
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;

function query(){
	f_query_add_mod.location.href = "../../eSS/jsp/LoanRequestStatusMain.jsp?function_id="+function_id;
}

function reset() {
	
	parent.content.f_query_add_mod.qryCriteriaRequestStatus.document.forms[0].reset();
	parent.content.f_query_add_mod.qryResultRequestStatus.location.href="../../eCommon/html/blank.html";
	
}

function showTrayDtl()
{
		
	var from_date    =  document.RequestStatusQuery.from_date.value ;
	var to_date =  document.RequestStatusQuery.to_date.value ;
	var sys_date	= document.RequestStatusQuery.p_system_date.value;
	var locale= document.RequestStatusQuery.p_language_id.value;
	   if(locale != "en") {
			from_date = convertDate(from_date, "DMY", locale, "en");
			to_date = convertDate(to_date, "DMY", locale, "en");
			sys_date = convertDate(sys_date, "DMY", locale, "en");
		}
	   
	   if(from_date==""){
		   alert(getMessage("FROM_DATE_NOT_BLANK", "SS"));
		   document.RequestStatusQuery.from_date.focus();
		   parent.qryResultRequestStatus.location.href="../../eCommon/html/blank.html";
		   return ;
		   }else{
			   if (to_date=="")
			   {
				   document.RequestStatusQuery.submit();
					   
			   }else if(!isBefore(from_date,to_date,"DMY",'en'.value)) {
				   alert(getMessage("FM_DATE_GR_TO_DATE", "SS"));
				   document.RequestStatusQuery.from_date.focus();
				   parent.qryResultRequestStatus.location.href="../../eCommon/html/blank.html";
				   return ;
		   
			   }else if(!checkDateWithSysDate(from_date,to_date,sys_date)){
				   alert(getMessage("BOTH_DATE_LESS_SYS_DATE", "SS"));
				   document.RequestStatusQuery.from_date.focus();
				   parent.qryResultRequestStatus.location.href="../../eCommon/html/blank.html";
				   return ;		
			   }else{
		
				   document.RequestStatusQuery.submit();
				   
			   }
		   }

}

function Modify(obj)
{
	
	
	var doc_type_code		=	obj.cells[14].innerText; 
	var doc_no				=	obj.cells[2].innerText;
	var dialogHeight = "25" ;
	var dialogWidth	= "50" ;

	var dialogTop = "265" ;
	var center = "1" ;

	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; center: " + center + "; dialogTop :" + dialogTop +"; scroll=no; status=no;" ;
	var arguments = "" ;
	var title="Request Detail";
	var params = "doc_type_code="+doc_type_code+"&doc_no="+doc_no;
	
	retVal = window.showModalDialog("../../eSS/jsp/LoanRequestStatusQueryDetailFrame.jsp?"+params,arguments,features);
	
	
	/*var dialogHeight	= "73";
	var dialogWidth	= "150" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; status=no;" ;
	var arguments	= "" ;
	var params = "?"+patientID.name+"="+patientID.value
	+"&"+groupCode.name+"="+groupCode.value 
	+"&"+trayNo.name+"="+trayNo.value;
	retVal = window.open("../../eSS/jsp/ReturnGroupDiscrepancyFrame.jsp"+params);
	//,arguments,features);
	//showModalDialog*/
}

function CloseWindow()
{
	parent.window.close();
}
