<!DOCTYPE html>
<%@ include file="../../eXH/jsp/CommonIncludeSession.jsp" %>

<HTML>
<SCRIPT language="javascript">
	async function callDocuArch()
	{
		var dialogHeight = "250";			    
		var dialogWidth  = "250";
		var dialogTop    = "230";
		var dialogLeft   = "230";
		var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status:no;scroll:no" ;

		var arguments  = new Array();
		var url = "docuarch.jsp?patientID=123456";
		arguments[0] = 'test';
		var returnval = await window.showModalDialog(url,null,features);	
		alert(returnval);
	}
</SCRIPT>

<style type="text/css">
#mydiv {
    position:fixed;
    top: 20%;
    left: 45%;
    margin-top: -3em; /*set to a negative number 1/2 of your height*/
    margin-left: -9em; /*set to a negative number 1/2 of your width*/
}
</style>

<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src="../../eSM/js/login.js" language="javascript"></script>
<script src="../../eXH/js/ExternalApplication.js" language="javascript"></script>
<script src="../../eXH/js/GatewayServer.js" language="javascript"></script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='${pageContext.request.contextPath}/eCommon/js/CommonCalendar.js'> </Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<HEAD>

</head>																		   
<form name="dmsSimulator" id="dmsSimulator" id="dmsSimulator">
<BODY leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown='lockKey()'>
<TABLE ID="mydiv">
 <TR>
	<TD>Patient ID</TD>
	<TD><INPUT TYPE="text" name="P_PATIENT_ID" id="P_PATIENT_ID" VALUE="${documentInfo['patientID']}"></TD>
 </TR>
  <TR>
	<TD>Username</TD>
	<TD><INPUT TYPE="text" name="P_USE_ID" id="P_USE_ID" VALUE="${documentInfo['userID']}"></TD>
 </TR>
 <TR>
	<TD>Encounter ID</TD>
	<TD><INPUT TYPE="text" name="P_EPISODE_ID" id="P_EPISODE_ID" VALUE="${documentInfo['episodeID']}"></TD>
</TR>
 <TR>
	<TD>Encounter Date</TD>
	<TD>
		<INPUT TYPE="text" name="P_ENCNTR_DATE" id="P_ENCNTR_DATE" ID="P_ENCNTR_DATE" SIZE="11" VALUE="${documentInfo['encounterDate']}">
		<INPUT TYPE='image' ID="P_ENC_DATE_Calendar" SRC='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('P_ENCNTR_DATE','dd/mm/y hh:mm');">
	</TD>
 </TR>
 <!-- <TR>
	<TD>Location Type</TD>
	<TD><INPUT TYPE="text" name="P_LOCN_TYPE" id="P_LOCN_TYPE" VALUE="${documentInfo['locationType']}"></TD>
</TR>
 <TR>	
	<TD>Location Code</TD>
	<TD><INPUT TYPE="text" name="P_LOCN_CODE" id="P_LOCN_CODE" VALUE="${documentInfo['locationCode']}"></TD>
</TR>
 <TR>	
	<TD>Location Desc</TD>
	<TD><INPUT TYPE="text" name="P_LOCN_DESC" id="P_LOCN_DESC" VALUE="${documentInfo['locationDate']}"></TD>
 </TR>
 <TR>
	<TD>Encounter Status</TD>
	<TD><INPUT TYPE="text" name="P_ENC_STATUS" id="P_ENC_STATUS" VALUE="${documentInfo['encounterStatus']}"></TD>
 </TR>
 <TR>
	<TD>Document Type</TD>
	<TD><INPUT TYPE="text" name="P_DOC_TYPE" id="P_DOC_TYPE" VALUE="${documentInfo['documentType']}"></TD>
 </TR>
 <TR>
	<TD>Order ID</TD>
	<TD><INPUT TYPE="text" name="P_ORDER_ID" id="P_ORDER_ID" VALUE="${documentInfo['orderID']}"></TD>
 </TR>
 <TR>
	<TD>Specimen No</TD>
	<TD><INPUT TYPE="text" name="P_SPECIMEN_NO" id="P_SPECIMEN_NO" VALUE="${documentInfo['specimenNo']}"></TD>
 </TR>-->
 <TR>
	<TD>Facility ID</TD>
	<TD><INPUT TYPE="text" name="P_FACILITY_ID" id="P_FACILITY_ID" VALUE="${documentInfo['facilityID']}"></TD>
 </TR>
  <TR>
	<TD>Card Number</TD>
	<TD><INPUT TYPE="text" name="P_CC_NUMBER" id="P_CC_NUMBER" VALUE=""></TD>
 </TR>
  <TR>
	<TD>Total Bill Amount</TD>
	<TD><INPUT TYPE="text" name="P_TOTAL_BILL_AMOUNT" id="P_TOTAL_BILL_AMOUNT" VALUE=""></TD>
 </TR>
  <TR>
	<TD>Bill Number</TD>
	<TD><INPUT TYPE="text" name="P_BILL_NUMBER" id="P_BILL_NUMBER" VALUE=""></TD>
 </TR>
  <TR>
	<TD>Bill date</TD>
	<TD><INPUT TYPE="text" name="p_doc_date" id="p_doc_date" VALUE=""></TD>
 </TR>
  <TR>
	<TD>Reciept Number</TD>
	<TD><INPUT TYPE="text" name="P_RECEIPT_NUMBER" id="P_RECEIPT_NUMBER" VALUE=""></TD>
 </TR>
 <TR>
	<TD>Reciept date</TD>
	<TD><INPUT TYPE="text" name="P_RECEIPT_DATE" id="P_RECEIPT_DATE" VALUE=""></TD>
 </TR>
  <TR>
	<TD>Bill Amount</TD>
	<TD><INPUT TYPE="text" name="P_BILL_AMOUNT" id="P_BILL_AMOUNT" VALUE=""></TD>
 </TR>
 <TR>
	<TD>Bill Doc Type</TD>
	<TD><INPUT TYPE="text" name="P_Bill_Doc_Type" id="P_Bill_Doc_Type" VALUE=""></TD>
 </TR>
 <TR>
	<TD>Bill Doc Num</TD>
	<TD><INPUT TYPE="text" name="P_Bill_Doc_Num" id="P_Bill_Doc_Num" VALUE=""></TD>
 </TR>
  <TR>
	<TD>Settlement Type</TD>
	<TD><INPUT TYPE="text" name="P_settlement_type" id="P_settlement_type" VALUE=""></TD>
 </TR>

 <TR ALIGN="right">
	<TD COLSPAN="2"><INPUT TYPE="button" VALUE="Submit" onClick="invokeEMExternalAppServlet('${pageContext.request.contextPath}')"></TD>
<!-- <TD><INPUT TYPE="button" VALUE="Invoke DocuArch(servlet)" onClick="callDocuArch()"></TD> -->
 </TR>
</TABLE>
<INPUT TYPE="HIDDEN" name="callFrom" id="callFrom" VALUE="INTERFACE_SIM">	
</form>
</body>
</html>

