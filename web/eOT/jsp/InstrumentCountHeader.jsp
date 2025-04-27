<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>
    <%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String called_from = request.getParameter("instr_called_from");
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eOT/js/InstrumentCount.js' language='javascript'></SCRIPT> 
	<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<body  onKeyDown="lockKey()">
	<form name="InstrumentCountHeaderForm" id="InstrumentCountHeaderForm" >
	<%
		if(called_from.equals("SET")){
	%>
		<table width='100%' cellpadding=3 cellspacing='0' align="centre" border="1">
			<tr id="instr_count_set_hdr_table">
				<td class="columnHeader" width="35%" >
				<fmt:message key="Common.operation.label" bundle="${common_labels}"/>
				</td>
				<td class="columnHeader"  width="35%" >
				<fmt:message key="Common.Set.label" bundle="${common_labels}"/>
				</td>
				<td class="columnHeader" width="19%"  >
				<fmt:message key="Common.Tray.label" bundle="${common_labels}"/>
				</td>
			</tr>		
		</table>
	<%
		}else if(called_from.equals("ITEM")){
	%>
		<table width='100%' cellpadding=3  cellspacing='0' align="centre" border="1">
			<tr id="instr_count_item_dtls_hdr_table">
				<td class="columnHeader" width="20%" >
				<fmt:message key="Common.item.label" bundle="${common_labels}"/>
				</td>
				<td class="columnHeader" width="7%"  >
				<fmt:message key="eOT.StdQty.Label" bundle="${ot_labels}"/>
				</td>
				<td class="columnHeader" width="7%"  >
				<fmt:message key="eOT.CSSDQty.Label" bundle="${ot_labels}"/>
				</td>
				<td class="columnHeader" width="7%"  >
				<fmt:message key="eOT.OpenQty.Label" bundle="${ot_labels}"/>
				</td>
				<td class="columnHeader" width="11%" >
				<fmt:message key="eOT.InitialStatus.Label" bundle="${ot_labels}"/>
				</td>
				<td class="columnHeader"  width="7%"  >
				<fmt:message key="Common.remarks.label" bundle="${common_labels}"/> 
				</td>
				<td class="columnHeader" width="7%"  >
				<fmt:message key="Common.ReturnQty.label" bundle="${common_labels}"/>
				</td>
				<td class="columnHeader" width="11%" >
				<fmt:message key="eOT.FinalStatus.Label" bundle="${ot_labels}"/>
				</td>
				<td  class="columnHeader" width="7%"  >
				<fmt:message key="Common.final.label" bundle="${common_labels}"/> </td>
				<td class="columnHeader"  width="7%"  >
				<fmt:message key="Common.general.label" bundle="${common_labels}"/> </td>
			</tr>		
		</table>
	<%
		}
	%>

	</form>
</body>
</html>

