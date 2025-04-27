<!DOCTYPE html>
<%
//"java.util.*, eOT.*, eOT.Common.*, eCommon.Common.*" 
%>
<%@page import = "eCommon.Common.*"  contentType=" text/html;charset=UTF-8" %>

<% request.setCharacterEncoding("UTF-8");%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<html>
<head>
    <%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eOT/js/SwabCount.js' language='javascript'></SCRIPT> 
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body  onKeyDown="lockKey()">
	<form name="ResultsHeaderForm" id="ResultsHeaderForm" >
	<table class='grid' width='100%' cellpadding='3' cellspacing='0' align="centre" border="1">
			<tr id="swab_count_results_table_row">
 				<td class='columnHeader'nowrap><fmt:message key="Common.Items.label" bundle="${common_labels}"/></td>
				<!--Commented against Added against PMG2015-MOD-CRF-0001<td class='columnHeader'nowrap><fmt:message key="eOT.FirstCount.Label" bundle="${ot_labels}"/></td>-->
				<!-- Added against PMG2015-MOD-CRF-0001 -->
				<td class='columnHeader'nowrap><fmt:message key="eOT.InCount.Label" bundle="${ot_labels}"/>
				</td>
				<td class='columnHeader'nowrap><fmt:message key="eOT.AdditionsduringOP.Label" bundle="${ot_labels}"/></td>
				<td class='columnHeader'nowrap><fmt:message key="Common.TotalCount.label" bundle="${common_labels}"/></td>
				<!--Commented against Added against PMG2015-MOD-CRF-0001
				<td class='columnHeader'nowrap><fmt:message key="eOT.2ndCount.Label" bundle="${ot_labels}"/></td>-->
				<td class='columnHeader'nowrap><fmt:message key="eOT.SecondCount.Label" bundle="${ot_labels}"/></td>
				<td class='columnHeader'nowrap><fmt:message key="eOT.AddnsafterCC.Label" bundle="${ot_labels}"/></td>
				<td class='columnHeader'nowrap><fmt:message key="Common.TotalCount.label" bundle="${common_labels}"/></td>
				<td class='columnHeader'nowrap><fmt:message key="eOT.FinalCount.Label" bundle="${ot_labels}"/></td>
				<td class='columnHeader'nowrap><fmt:message key="Common.view.label" bundle="${common_labels}"/></td>
				<% if(!CommonBean.checkForNull(request.getParameter("qry_mode")).equals("YES") ) { %>
				<td class='columnHeader'nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td> 
				<%}%>
			</tr>		
	</table>
	</form>
</body>
</html>

