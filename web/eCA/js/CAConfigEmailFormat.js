
 function getData(obj)
  {

	  if (obj.value!="")
	  { 
			populateReportsLookup();
	  }
	  else
	  {
		  document.configEmailFrmtHdrForm.txtconfigureEmailReport.value = "";
		  document.configEmailFrmtHdrForm.configureEmailReport.value  = "";		 
		  
	  }
  }
  function CheckForSpeChar(event)
{
   var strCheck='0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
   var whichCode = (window.Event) ? event.which : event.keyCode;
   key = String.fromCharCode(whichCode);  
   if (strCheck.indexOf(key) == -1) 
		return false;  //Not a valid key
}
  function populateReportsLookup()
{
	    var target=document.configEmailFrmtHdrForm.txtconfigureEmailReport;
		//var splval= parent.frames[1].document.forms[0].speciality_code1.value;
		var retVal=  new String();
		var dialogTop	= "40";
		var dialogHeight= "10" ;
		var dialogWidth= "40" ;
		var features= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments	= "" ;
		var search_desc	= "";
		var title = getLabel("Common.report.label","COMMON");

		var sql="select DISTINCT A.REPORT_ID code, A.REPORT_DESC description from SM_REPORT A,CA_CONFIG_EMAIL_FORMAT B where A.REPORT_ID=B.REPORT_ID AND A.SEND_BY_MAIL_YN='Y' and upper(A.REPORT_ID ) like upper(?) and upper(A.REPORT_DESC) like upper(?)";

		//var sql="select EVENT_NAME, EVENT_DESC,EVENT_STATUS,EVENT_HDR from CA_CONFIG_EMAIL_FORMAT where EFF_STATUS ='E' AND REPORT_ID=? order by SRL_NO"
		

				var argArray = new Array();
				var namesArray = new Array();
				var valuesArray = new Array();
				var datatypesArray = new Array();
				argArray[0] = sql;
				argArray[1] = namesArray;
				argArray[2] = valuesArray;
				argArray[3] = datatypesArray;
				argArray[4] = "2,1";
				argArray[5] = target.value;
				argArray[6] = DESC_LINK;
				argArray[7] = DESC_CODE;
				
				retArray = CommonLookup(title,argArray);
				
				if(retArray != null && retArray !="")
				{
					document.configEmailFrmtHdrForm.txtconfigureEmailReport.value = retArray[0];
					document.configEmailFrmtHdrForm.configureEmailReport.value = retArray[1];
				}
				else
				{
					document.configEmailFrmtHdrForm.txtconfigureEmailReport.value = "";
					document.configEmailFrmtHdrForm.configureEmailReport.value  = "";
				}
}







function loadReportNames()
 {
	 var txtconfigureEmailReport = document.configEmailFrmtHdrForm.txtconfigureEmailReport;
	 
	 if(txtconfigureEmailReport.value == '')
	 {
		 alert(getMessage("REPORT_CANT_BE_BLANK","CA"));
		 return 
	 }
	 else
	 {
		parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
		parent.configEmailFrmtDtlFrame.location.href = '../../eCA/jsp/CAConfigEmailFormatDtl.jsp?reportTypeId='+txtconfigureEmailReport.value;
	 }
 }

 function apply()
{
	if(configEmailFrmtDtlFrame.document.configEmailFrmtDtlForm !=null){	//configEmailFrmtDtlFrame.document.configEmailFrmtDtlForm.action="../../servlet/eCA.CAConfigEmailFrmtServlet.java";
    configEmailFrmtDtlFrame.document.configEmailFrmtDtlForm.target="messageFrame";
    configEmailFrmtDtlFrame.document.configEmailFrmtDtlForm.method="post";
	configEmailFrmtDtlFrame.document.configEmailFrmtDtlForm.submit();
	}
	else{
		var errors = getMessage("NOT_VALID","CA");		messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
		return false ;
	}
}



 function reset()
 {
		if(configEmailFrmtHdrFrame.document.forms[0]!=null)
	{
	   configEmailFrmtHdrFrame.document.forms[0].reset();	
	   configEmailFrmtDtlFrame.location.href = '../../eCommon/html/blank.html';
	}
 }

