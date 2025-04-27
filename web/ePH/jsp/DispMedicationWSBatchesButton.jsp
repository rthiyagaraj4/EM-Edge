<!DOCTYPE html>

  <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eST.Common.*,eCommon.XSSRequestWrapper" %>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<%
	  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="" onKeyDown="lockKey()">
<%
	String quantity = request.getParameter("quantity");
	String identity = request.getParameter("identity");
	String flag	    = request.getParameter("flag");
//preview
%>
<form name="frmDispMedicationWSBatchesButton" id="frmDispMedicationWSBatchesButton">
	<table cellpadding="0" cellspacing="0" border="0" id="wsbatchesbutton" align="right">
		<tr>
			<td class="white" >
			<%
				if(identity == null || identity.equals("null") || identity.equals("")){				
			%>
				<input type="button" name="btnOK" id="btnOK" class="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="saveSelectedBatches('<%=flag%>','<%=quantity%>')">&nbsp;&nbsp;&nbsp;&nbsp;
			<%
				}else if(identity.equals("alloc_batches")){				
			%>
				<input type="button" name="btnOK" id="btnOK" class="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="saveAllocatedBatches('<%=flag%>','<%=quantity%>')">&nbsp;&nbsp;&nbsp;&nbsp;
			<%
				}else if(identity.equals("preview")){
			%>
				<input type="button" name="btnOK" id="btnOK" class="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="saveAllocatedBatches('CANCEL')">&nbsp;&nbsp;&nbsp;&nbsp;
			<%
			}else{
			%>
				<input type="button" name="btnOK" id="btnOK" class="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="showDisplaySection()">&nbsp;&nbsp;&nbsp;&nbsp;
			<%
				}
			%>
			</td>
		</tr>	
	</table>
</form>
</body>
</html>

