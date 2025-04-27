<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../js/EditDispLabel.js"></script> 
		<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
		<title><fmt:message key="ePH.ViewAuditTrail.label" bundle="${ph_labels}"/></title>
	</head>
<%
	String    dispense_no = (String) request.getParameter("dispense_no")==null?"":request.getParameter("dispense_no");
	String	bean_id			=	"EditDispLabelBean" ;
	String	bean_name		=	"ePH.EditDispLabelBean";
	EditDispLabelBean bean = (EditDispLabelBean)getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	ArrayList audit_trail = (ArrayList) bean.getAuditTrailDatails(dispense_no);
%>

	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0"> 
		<form name="frmEditDispLabelQryResult" id="frmEditDispLabelQryResult">
<%

		if(audit_trail.size() > 0){
%>
			<table cellpadding="0" cellspacing="0" width="90%" align="center" border="1">
				<tr>
					<th><fmt:message key="Common.date.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.user.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.WorkStation.label" bundle="${common_labels}"/></th>
				</tr>
<%
				for(int i = 0; i < audit_trail.size(); i=i+3){
%>
					<tr>
						<td><%=com.ehis.util.DateUtils.convertDate((String) audit_trail.get(i),"DMYHM","en",locale)%></td>
						<td><%=audit_trail.get(i+1)%></td>
						<td><%=audit_trail.get(i+2)%></td>
					</tr>
<%
				}
%>
			</table>
<%
		}
		else{
%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);window.close();</script>
<%
		}
%>
		</form>
	</body>
</html>

