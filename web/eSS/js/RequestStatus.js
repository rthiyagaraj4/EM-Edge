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
	f_query_add_mod.location.href = "../../eSS/jsp/RequestStatusMain.jsp?function_id="+function_id;
}

function reset() {
	
	parent.content.f_query_add_mod.qryCriteriaRequestStatus.document.forms[0].reset();
	parent.content.f_query_add_mod.qryResultRequestStatus.location.href="../../eCommon/html/blank.html";
	
}

function showTrayDtl()
{
		
	var from_date   =  document.RequestStatusQuery.from_date.value ;
	var to_date		=  document.RequestStatusQuery.to_date.value ;
	var locale		= document.RequestStatusQuery.p_language_id.value;
	var sys_date	= document.RequestStatusQuery.p_system_date.value;

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
				   document.RequestStatusQuery.action="../../eSS/jsp/RequestStatusQueryResult.jsp";
				   document.RequestStatusQuery.target= "qryResultRequestStatus"
				   document.RequestStatusQuery.submit();
				   
			   }
		   }

}

async function Modify(obj)
{
	
	//var doc_type_code		=	obj.cells[11].innerText;//Commented by Rabbani #INC no:32068 on 06/12/2012
	//var doc_type_code		=	obj.cells[12].innerText; //Added by Rabbani #INC no:32068 on 06/12/2012
	var doc_type_code		=	obj.cells[14].innerText; //Added by Rabbani #INC no:32068 on 06/12/2012
	var doc_no				=	obj.cells[2].innerText;
	var dialogHeight = "65vh" ;
	var dialogWidth	= "45vw" ;

	var dialogTop = "265" ;
	var center = "1" ;

	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"; center: " + center + "; dialogTop :" + dialogTop +"; scroll=no; status=no;" ;
	var arguments = "" ;
	var title="Request Detail";
	var params = "doc_type_code="+doc_type_code+"&doc_no="+doc_no;
	
	retVal =await window.showModalDialog("../../eSS/jsp/RequestStatusQueryDetailFrame.jsp?"+params,arguments,features);
	
	
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
