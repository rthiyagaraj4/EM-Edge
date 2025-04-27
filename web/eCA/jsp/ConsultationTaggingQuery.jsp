<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
22/04/2024  50627    Twinkle Shah    22/04/2024		Ramesh Goli        ML-MMOH-CRF-2106
--------------------------------------------------------------------------------------------------------------------
*/
%>

<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.Common.*,java.util.*,eCA.*,eCommon.*,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	String locale = ((String)session.getAttribute("LOCALE"));
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link   rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='javascript' src='../../eCommon/js/common.js'></script>
  	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script> 
	<script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js' > </script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></Script>
    <script language='javascript' src='../../eCA/js/ConsultationTagging.js'></script>	
</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
			 <form name='ConsultationTagFrom' id='ConsultationTagFrom' target='result' >
			  	<table border='0' cellspacing='0' width='100%'>
			  	 <% 
	  				 String	facility_id				 =  (String) session.getValue( "facility_id" ) ;
			  	     String clinicianId=(String) session.getValue("ca_practitioner_id");  
					 String	patient_id				 =  request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
					 String	option_id				 =  request.getParameter("option_id")==null?"":request.getParameter("option_id");
			  	 %>
			   		<tr>
		 			 <td class='LABEL' align='center' width='18%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class='fields' align='center' width='18%'><input type='text' id='patient_id' name='patient_id' id='patient_id'  value='<%=patient_id%>' maxLength='16' size='16' onKeyPress="return CheckForSpecChars(event);"><input type="button" id="patient_search" name="patient_search" id="patient_search" class=BUTTON value="?" onClick="callPatientSearch()">
					<img src="../../eCommon/images/mandatory.gif"></img></td>
					
						<td></td><td></td>
						 <td align='center'>
						 <input type='button' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='button' onClick='submitPage();'>
						 <input type='button' name='clear' id='clear' value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' class='button' onClick='reset1();'>
						 </td>
					</tr>
				</table>
				  <input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
				  <input type='hidden' name='clinicianId' id='clinicianId' value='<%=clinicianId%>'>  
				  <input type='hidden' name='language_id' id='language_id' value='<%=locale%>'>
				  <input type='hidden' name='option_id' id='option_id' value='<%=option_id%>'>
				 
			</form>	
		
	</body>
</html>
<script>
if(""!='<%=patient_id%>'){
	submitPage();
}
</script>

