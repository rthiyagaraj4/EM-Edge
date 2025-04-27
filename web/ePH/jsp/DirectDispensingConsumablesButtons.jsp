<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
	<head>
<% 
		request.setCharacterEncoding("UTF-8");
	
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../ePH/js/DirectDispensingConsumables.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="frm_disp_consumableItemButtons" id="frm_disp_consumableItemButtons">
			<table border="0" width="100%" cellspacing="0" cellpadding="0">
				<tr>
					<td align='right' width="35%" colspan='3'><input type='button' name='btn_confirm' id='btn_confirm' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' onclick='RecordDetails()' class='button'>&nbsp;
					</td> 
					<td align='right' width="2%" colspan='1'>&nbsp;</td>
				</tr>				
			</table>			
		</form>
	</body>
</html> 




