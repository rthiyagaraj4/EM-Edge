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
         <title>
			<fmt:message key="ePH.TokenDetails.label" bundle="${ph_labels}"/>
		</title>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<body >
		<form name="frmDispMedicationTokenDetails" id="frmDispMedicationTokenDetails" >
<%
		String	bean_id				=	"DispMedicationBean" ;
		String	bean_name			=	"ePH.DispMedicationBean";	
		DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name,request);
		bean.setLanguageId(locale);
		String sPatientId	       =	request.getParameter("patient_id");	
		ArrayList alResult		   =    (ArrayList) bean.getTokenNumberDetails(sPatientId);
		int width				   =    30;
		String  classValue		   =    "";
		String prev_order_id	   =    "";
		String new_order_id	       =    "";
		if(alResult.size()>0){
%>	
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="patientiddisplaytable">
				<tr id="header">
					<th width="'<%=width%>'%" nowrap><fmt:message key="ePH.TokenDate.label" bundle="${ph_labels}"/></th>
					<th width="'<%=width%>'%" nowrap><fmt:message key="ePH.TokenSeries.label" bundle="${ph_labels}"/></th>
					<th width="'<%=width%>'%" nowrap><fmt:message key="ePH.TokenNo.label" bundle="${ph_labels}"/></th>
					<th width="'<%=width%>'%"><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
				</tr>
<% 
				String sTokenStatusCode = "";
				for(int i=0;i<alResult.size();i=i+4){
					if(i%2==0){
						classValue="class='QRYEVENSMALL'";
					}
					else{
						classValue="class='QRYODDSMALL'";
					}
%>
					<tr>
					<td <%=classValue%> ><label>&nbsp;<%=alResult.get(i)%>&nbsp;</label>
					<td <%=classValue%> ><label>&nbsp;<%=alResult.get(i+1)%>&nbsp;</label>
					<td <%=classValue%> ><label>&nbsp;<%=alResult.get(i+2)%>&nbsp;</label>
<%
					sTokenStatusCode = alResult.get(i+3)==null?"":alResult.get(i+3).toString();
					if(sTokenStatusCode.equals("")){
%>
						<td <%=classValue%> ><label>&nbsp;<fmt:message key="Common.Pending.label" bundle="${common_labels}"/>&nbsp;</label>
<%
					}
					else{
%>
						<td <%=classValue%> ><label>&nbsp;<%=sTokenStatusCode%>&nbsp;</label>
<%				
					}
%>
					</tr>	
<% 
				}
%>	
				</table>
  <%
			}
			else {
   %>
				<script>
					alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				</script>
<%
			}
%>
		</form>
		<%putObjectInBean(bean_id,bean,request);%>
	</body>
</html>

