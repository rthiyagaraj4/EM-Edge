<!DOCTYPE html>
 <!--This file is saved on 25/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<head>
	
<% 
		request.setCharacterEncoding("UTF-8"); 
		String locale = (String) session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
<script language="JavaScript" src="../js/PhCommon.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script>
<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<%
    String width="";
	String group_by		=	request.getParameter("group_by");
	if(group_by.equals("DR")) { 
		width	=	"120%";
     	} else {	
		width	=	"100%";
		}
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name="frmPrescriptionPrevOrdersResultTitle" id="frmPrescriptionPrevOrdersResultTitle">
<table border="1" cellpadding="0" cellspacing="0" width="<%=width%>" align="center" name="resultTable">
			<tr>  
				<th width="1%" style="font-size:10">&nbsp;</th>
				<th width="4%" style="font-size:10"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
				<th width="30%" nowrap style="font-size:10"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th>
				<th width="28%" nowrap style="font-size:10"><fmt:message key="ePH.DosageDetail.label" bundle="${ph_labels}"/></th>
				<th width="12%" nowrap style="font-size:10"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th>
				<th nowrap style="font-size:10"><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></th>
				<% if(!group_by.equals("PR")) { %>
				<th nowrap style="font-size:10"><fmt:message key="Common.OrderedBy.label" bundle="${common_labels}"/></th>
				<th nowrap style="font-size:10"><fmt:message key="ePH.OrderedLocation.label" bundle="${ph_labels}"/></th>	
				<%	}	%>
          </tr>
</table>
</form>
</body>
</html>

