<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>    
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="JavaScript" src='../../eCommon/js/common.js'> </script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language="JavaScript" src='../../eXH/js/Validate.js'> </script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script Language="JavaScript">
//Added by prithivi for enotification requirement on 11/05/2016. these functions are used for filter out the details


	function AADHAAR()
	{
		var aadhaarID = "";
		//var url = "http://ekyc.mobilewaretech.com:2080/KDAHEKYC/kyc?EM_FACILITY_ID=KH&EM_USER_ID=SURESHM&AADHAAR_NO=523261344811&REQUEST_ID=12345678";

		var url = "http://ekyc.mobilewaretech.com:2080/KDAHEKYC/kyc?EM_FACILITY_ID=dasdas&EM_USER_ID=dasdsa&AADHAAR_NO=936862739806&REQUEST_ID=dasdasdas";

		var errMessage = "";

		alert("1");			
		var dialogTop   = "350";			     
		var dialogHeight= "25" ;
		var dialogWidth = "55" ;											 
		var arguments   = "" ;
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop + "; status: no" ;
		//window.showModalDialog( url, arguments, features ) ;
		//window.open( url, arguments, features ) ;
		window.open("http://ekyc.mobilewaretech.com:2080/KDAHEKYC/kyc?EM_FACILITY_ID=123&EM_USER_ID=123&AADHAAR_NO=123123465&REQUEST_ID=123456","KADHKYC",'height=320,width=428,toolbar=no,menubar=no,scrollbars=yes, resizable=yes,location=no, directories=no, status=no,copyhistory=no');



	}


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  
</HEAD>
<BODY  leftmargin=0 topmargin=0  onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="FilterSearchForm" id="FilterSearchForm" target='' action=''>

<input class='button' type='button'  name='aadhaar' id='aadhaar' value='AADHAAR' onClick="AADHAAR()"> 


 
</form>	
</BODY>
</HTML>

