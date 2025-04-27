<!DOCTYPE html>
<%@page import="java.text.*,ePH.*, ePH.Common.*, eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<HTML>
	<head>
		<title><fmt:message key="Common.Instructions.label" bundle="${common_labels}"/></title>		
<%
		String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>	
	</head>
	<body >
		<form name='PHQueryApptForPatientInstruction' id='PHQueryApptForPatientInstruction'>
<%
			request.setCharacterEncoding("UTF-8");
			String patient_id	=	request.getParameter("patient_id") ;	
			String appt_refno	=	request.getParameter("appt_refno") ;	
			String locale		= (String)session.getAttribute("LOCALE");	

			String bean_id			= "DispMedicationBean" ;
			String bean_name		= "ePH.DispMedicationBean";	
			DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
			bean.setLanguageId(locale);	
%>			
			<table border="1" width="100%" cellspacing='0' cellpadding='0'>					
<%			
				String patient_instruction = bean.patientInstruction(appt_refno,patient_id);
				String procedure_instruction = bean.procedureInstruction(appt_refno,patient_id);

				if(!patient_instruction.equals("")) { 
%>
					<th align="left"><fmt:message key="Common.PatientInstructions.label" bundle="${common_labels}"/></th>			
					<tr>												
						<td  class="label" >&nbsp;&nbsp;&nbsp;<textarea cols="85" rows="10"  readonly > <%=patient_instruction%></textarea>
						</td>						
					</tr>
<% 
				}
				if(!procedure_instruction.equals("")) { 
%>
					<th align="left"><fmt:message key="Common.Procedures.label" bundle="${common_labels}"/> <fmt:message key="Common.Instructions.label" bundle="${common_labels}"/></th>
					<tr>												
						<td  class="label" >&nbsp;&nbsp;&nbsp;<textarea cols="85" rows="10"  readonly > <%=procedure_instruction%></textarea>
						</td>						
					</tr>
<% 
				}
%>				
			</table>	
		</form>
	</body>
</html>

