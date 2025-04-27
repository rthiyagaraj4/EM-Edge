<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<!-- <body > -->
	<body onMouseDown="" onKeyDown="lockKey()">
		<form name="frmDispMedicationPatientIDDisplay" id="frmDispMedicationPatientIDDisplay" >
<%
			String	bean_id				=	"DispMedicationAllStages" ;
			String	bean_name			=	"ePH.DispMedicationAllStages";	
			DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject( bean_id, bean_name,request);
			bean.setLanguageId(locale);

			String patient_id	       =	request.getParameter("patient_id");	
			String order_id 	       =	request.getParameter("order_id");  
			String  classValue		   =    "";
			ArrayList result		   =    (ArrayList) bean.getpendingRefillorders(patient_id,order_id);	

			if(result.size()>0){
%>	
			<title><fmt:message key="ePH.PendingRefillOrders.label" bundle="${ph_labels}"/></title>
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="patientiddisplaytable">
					<tr id="header"nowrap>
						<td class= "COLUMNHEADER"  width="30%"><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
						<td class= "COLUMNHEADER"  width="30%"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
						<td class= "COLUMNHEADER"  width="30%"><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td>			
					</tr>
<% 
					for(int i=0;i<result.size();i=i+3){				
						if(i%2==0)
							classValue	=	"QRYEVEN";
						else
							classValue	=	"QRYODD";
%>
						<tr nowrap>				 
							<td class="<%=classValue%>" style="font-size:9;" ><label>&nbsp;<%=result.get(i)%>&nbsp;</label></td>
							<td class="<%=classValue%>" style="font-size:9;"><label>&nbsp;<%=com.ehis.util.DateUtils.convertDate((String)result.get(i+1),"DMYHM","en",locale)  %>&nbsp;</label></td>
							<td class="<%=classValue%>" style="font-size:9;"><label>&nbsp;<%=com.ehis.util.DateUtils.convertDate((String)result.get(i+2),"DMYHM","en",locale)  %>&nbsp;</label></td>			
						</tr>		 
<%
					}
%>
				</table>
<%
			}
%>
		</form>
	</body>
</html>

