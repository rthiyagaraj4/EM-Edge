<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<HTML>
<HEAD>
	
<% String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
	
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/IPFillAll.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script type="text/javascript">
function closeDialog() {
	const dialogTag = parent.parent.document.getElementById("dialog_tag");
	dialogTag.close();
}

</script>

</HEAD>

<%
	String type = request.getParameter("type");	   
	String disp_locn_code			 = request.getParameter("disp_locn_code");
	if(type == null) 
		type = "";
	/* Initialize Function specific start */
//added for SRR20056-CRF-0612 - start
	String bean_id = "IpFillAllBean" ;
	String bean_name = "ePH.IpFillAllBean";
	IpFillAllBean bean = (IpFillAllBean)getBeanObject(bean_id, bean_name, request ) ;
	bean.setPrintOption(disp_locn_code); 
	String sPrintOption = bean.getPrintOption();
	if (sPrintOption==null)
		sPrintOption ="";
// added for SRR20056-CRF-0612 - end
%>	
<body onKeyDown="lockKey()">
<form name="formViewFillListButtons" id="formViewFillListButtons">
<TABLE  ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0" width="100%">
	<TR>
	<td align="left" width="20%" nowrap>&nbsp;<font size="2" color="#CC6600"><b><fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/><fmt:message key="Common.Selected.label" bundle="${common_labels}"/></b></td> 
	<!-- <td align="left" width="20%" nowrap>&nbsp;<font size="2" color="#CC00CC"><b><fmt:message key="Common.multiple.label" bundle="${common_labels}"/> <fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/></b></td> -->							   
	<td align="left" width="20%" nowrap>&nbsp;<font size="2" color="#990033"><img 	 src='../../eCommon/images/disabled.gif' align='center'> - <b><fmt:message key="ePH.NoStock.label" bundle="${ph_labels}"/> <fmt:message key="Common.available.label" bundle="${common_labels}"/></b></td>
	<td align="right" > <input type="button" class="button" name="GenerateFillList" id="GenerateFillList" value='<fmt:message key="ePH.GenerateFillList.label" bundle="${ph_labels}"/>' onclick="genFillList();" id='idGenerateFillList'></td>
	<td align="right"> <input type="button" class="button" name='<fmt:message key="ePH.PrintUnallocatedReport.label" bundle="${ph_labels}"/>' id='<fmt:message key="ePH.PrintUnallocatedReport.label" bundle="${ph_labels}"/>' value='Print Report' onclick="callUnallocatedReport('PRINTREPORT')"></td>
	<td align="right"><input type="button" class="button" name="Cancel" id="Cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="closeDialog();"></td>
	<input type='hidden' name='UnAllocRepprintOption' id='UnAllocRepprintOption' value='<%=sPrintOption%>'> <!--added for SRR20056-CRF-0612-->
	</TR>
</table>
</form>
</body>
</HTML>

