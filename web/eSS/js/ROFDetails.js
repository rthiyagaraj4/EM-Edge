/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var	function_id	=	"" ;
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;

function query(){
	f_query_add_mod.location.href = "../../eSS/jsp/ROFDetailsMain.jsp?function_id="+function_id;
}

function reset() {
	
	parent.content.f_query_add_mod.qryCriteriaROFDetails.document.forms[0].reset();
	parent.content.f_query_add_mod.qryResultROFDetails.location.href="../../eCommon/html/blank.html";
	
}

function showTrayDtl()
{
		
	var from_date   =  document.ROFDetailsQuery.from_date.value ;
	var to_date		=  document.ROFDetailsQuery.to_date.value ;
	var locale		= document.ROFDetailsQuery.p_language_id.value;
	var sys_date	= document.ROFDetailsQuery.p_system_date.value;

	   if(locale != "en") {
			from_date = convertDate(from_date, "DMY", locale, "en");
			to_date = convertDate(to_date, "DMY", locale, "en");
			sys_date = convertDate(sys_date, "DMY", locale, "en");
		}
	  
	   if(from_date==""){
		   alert(getMessage("FROM_DATE_NOT_BLANK", "SS"));
		   document.ROFDetailsQuery.from_date.focus();
		   parent.qryResultROFDetails.location.href="../../eCommon/html/blank.html";
		   return ;
		   }else{
			   if (to_date=="")
			   {
				   document.ROFDetailsQuery.submit();
					   
			   }else if(!isBefore(from_date,to_date,"DMY",'en'.value)) {
				   alert(getMessage("FM_DATE_GR_TO_DATE", "SS"));
				   document.ROFDetailsQuery.from_date.value = "" ;
				   document.ROFDetailsQuery.from_date.focus();
				   parent.qryResultROFDetails.location.href="../../eCommon/html/blank.html";
				   return ;
		   
			   }else if(!checkDateWithSysDate(from_date,to_date,sys_date)){
				   alert(getMessage("BOTH_DATE_LESS_SYS_DATE", "SS"));
				   document.ROFDetailsQuery.from_date.value = "";
				   document.ROFDetailsQuery.from_date.focus();
				   parent.qryResultROFDetails.location.href="../../eCommon/html/blank.html";
				   return ;		
			   }else{
				   document.ROFDetailsQuery.action = "../../eSS/jsp/ROFDetailsQueryResult.jsp";
				   document.ROFDetailsQuery.target = "qryResultROFDetails"
				   document.ROFDetailsQuery.submit();
			   }
		   }

}

function Modify(doc_type_code,rof_status,obj)
{
	//var doc_type_code		=	obj.cells[7].innerText;
	var doc_no				=	obj.cells[1].innerText;

	var dialogHeight = "250px" ;
	var dialogWidth	= "60vw" ;

	var dialogTop = "265" ;
	var center = "1" ;

	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; center: " + center + "; dialogTop :" + dialogTop +"; scroll=no; status=no;" ;
	var arguments = "" ;
	var title="Request Detail";
	var params = "doc_type_code="+doc_type_code+"&doc_no="+doc_no+"&rof_status="+rof_status;
	retVal = window.showModalDialog("../../eSS/jsp/ROFDetailsQueryDetailFrame.jsp?"+params,arguments,features);
	
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
	parent.parent.document.getElementById("dialog_tag").close(); 
}
