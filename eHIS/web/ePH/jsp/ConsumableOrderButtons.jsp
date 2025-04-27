<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
	<head>
<% 
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	

		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
		String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");
		String bl_install_yn = request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
		String bl_disp_charge_dtl_in_rx_yn = request.getParameter("bl_disp_charge_dtl_in_rx_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_rx_yn");
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../js/ConsumableOrder.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="" onKeyDown="lockKey()">
		<form name="frm_consumableOrderButtons" id="frm_consumableOrderButtons">
		<table border="0" width="100%" cellspacing="0" cellpadding="0">
			<tr>
				<td align='right'>
<%
				if(bl_install_yn.equals("Y")&&bl_disp_charge_dtl_in_rx_yn.equals("Y")){
%>
					<input type="button" name="btn_item_search" id="btn_item_search" value='<fmt:message key="Common.ChargeDetails.label" bundle="${common_labels}"/>' class="button"  onClick="displayChargeDetails();" >
<%
				}
				if(called_from.equals("TAB")||called_from.equals("ORDERSET")){
%>
					&nbsp;<input type="button" name="btn_item_search" id="btn_item_search" value='<fmt:message key="ePH.ReleaseRx.label" bundle="${ph_labels}"/>' class="button"  onClick="release();">
<%
				}else{
%>
					&nbsp;<input type="button" name="btn_item_search" id="btn_item_search" value='<fmt:message key="Common.confirm.label" bundle="${common_labels}"/>' class="button"  onClick="release();">
<%
				}
%>
				&nbsp;<input type="button" name="btn_cancel" id="btn_cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class="button"  onClick="clearAll();">
				</td>
			</tr>
		</table>
		</form>
	</body>
</html> 

