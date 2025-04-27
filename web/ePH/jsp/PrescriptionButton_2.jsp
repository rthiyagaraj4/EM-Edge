<!DOCTYPE html>
 <%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
06/11/2020      IN:069887              Haribabu                   Manickavasagam J          MO-CRF-20152
--------------------------------------------------------------------------------------------------------------
*/ 
%>
<!--saved on 27th Oct 2005 -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* , eCommon.Common.*" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../js/Prescription_2.js"></script>
		<script language="JavaScript" src="../js/PrescriptionTest.js"></script>  <!-- added for IN069887 -->
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		String source=request.getParameter("mode")==null?"":request.getParameter("mode");
		String scheduled_yn=request.getParameter("scheduled_yn")==null?"":request.getParameter("scheduled_yn");
%>
		<form name="prescription_button" id="prescription_button" >
			<table cellpadding=0 cellspacing=0 width="100%" height="100%" align="center" border="0">
				<tr>
<%
				if(source.equals("amend")){
%>
					<td width="50%" align="left"><input type="button" class="button" value='<fmt:message key="Common.confirm.label" bundle="${common_labels}"/>'  id="modify_drug" onclick="amendDrug()"></input></td>
					<td width="50%" align="right"><input type="button" class="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  onclick="parent.window.close();" ></input></td>
<%
				}
				else{
%>
					<tr><td  width="100%" align="right" ><input type="button" class="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  onclick="parent.window.close();" ></input></td>
<%
				}
%>
				</tr>
			</table>
		</form>
	</body>
</html>

