<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
07/05/2019		ML-MMOH-CRF-1064	Kamalakannan G		07/05/2019		Ramesh Goli		IN066304
11/24/2023     32902        Twinkle Shah    	           Ramesh Goli             MMS-DM-CRF-0210			
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
	<script language='javascript' src='../../eCA/js/CAPrintingEmrPatient.js'> </script>
</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
			 <form name='CAPrintingEmrCriteriaForm' id='CAPrintingEmrCriteriaForm' target='result' >
			  	<table border='0' cellspacing='0' width='100%'>
			  	 <% 
	  				 String	facility_id				 =  (String) session.getValue( "facility_id" ) ;
			  	     String clinicianId=(String) session.getValue("ca_practitioner_id");  //32902
					 String	patient_id				 =  request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
			  	   	 String date_from="",date_to="";
					  String disableString="";
					 if(!"".equals(patient_id)){
						disableString="disabled";
					 }
				  	 if (date_from.equals(""))
						{
							date_to		= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
							date_from	= com.ehis.util.DateUtils.minusDate(date_to,"DMY",locale,6,"M");
						}
					else
						{
							date_to = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
							date_from = com.ehis.util.DateUtils.convertDate(date_from,"DMY","en",locale);				
						}	
			  	 %>
			   		<tr>
		 			 	 <td class='LABEL' width='16%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
						 <td class='fields' width='16%'>
								<input type='text'  name=patient_id id=patient_id  value='<%=patient_id%>' <%=disableString%> maxLength='20' size='20' onKeyPress="return CheckForSpecChars(event);">
								<input type="button" name="patient_search" id="patient_search" class=BUTTON value="?" <%=disableString%> onClick="callPatientSearch()" />
						</td>		
						 <td class='LABEL' width='16%'><fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/></td>
						 <td class='fields' width='16%'>
							<input type="text" maxlength=10 size="8" value='<%=date_from%>' name="p_date_from" id = "p_date_from" onBlur='chkDateTime(this,"DMY","<%=locale%>"); '><img src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('p_date_from');" ><img src="../../eCommon/images/mandatory.gif"></img>
						</td>
						 <td  class=label width='16%'><fmt:message key="Common.date.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
						 <td class='fields' width='16%'>
							<input type="text" maxlength=10 size="8" value='<%=date_to%>' name="p_date_to" id = "p_date_to" onBlur='chkDateTime(this,"DMY","<%=locale%>");'><img src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('p_date_to');" ><img src="../../eCommon/images/mandatory.gif"></img>
						 </td>
					</tr>
					<tr>
						<td></td><td></td><td></td><td></td><td></td>
						 <td align='right' class='button'>
						 <input type='button' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='button' onClick='submitPage();'>
						 <input type='button' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onClick='clearAll();'>
						 </td>
					</tr>
				</table>
				  <input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
				  <input type='hidden' name='clinicianId' id='clinicianId' value='<%=clinicianId%>'>  <!-- 32902 -->
				  <input type='hidden' name='language_id' id='language_id' value='<%=locale%>'>
			</form>	
		
	</body>
</html>
<script>
if(""!='<%=patient_id%>'){
	submitPage();
}
</script>

