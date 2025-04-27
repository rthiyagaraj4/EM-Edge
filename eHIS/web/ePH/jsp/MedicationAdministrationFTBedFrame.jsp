<!DOCTYPE html>
<html>
<head>
<%
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   String  rows="4%,95%";
   	String patient_id     = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	if(!patient_id.equals("")){
			rows="0%,100%";
	}
	String params = request.getQueryString() ;
	
	
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<!--     <script language="JavaScript" src="../../ePH/js/PhMessages.js"></script> -->
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/PhCommon.js"></script>
	<script language="JavaScript" src="../../ePH/js/MedicationAdministrationFixedTime.js"></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
 	
		<iframe name="f_bed_patient" id="f_bed_patient" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/MedicationAdministrationFTLocator.jsp?<%=params%>" style="height:25vh;width:100vw"></iframe>
		<iframe name="f_bedheader" id="f_bedheader" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/MedicationAdministrationFTBedHeader.jsp?<%=params%>" style="height:70vh;width:100vw"></iframe>

</html>


