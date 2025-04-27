<!DOCTYPE html>
<!-- Added Against PMG2013-CRF-0009.1 -->
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.sql.Statement,eCommon.Common.*"
%>
<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%@include file="../../eCommon/jsp/Common.jsp"%>
<html>
<title><fmt:message key="eDS.CancellationReason.Label" bundle="${ds_labels}" /></title>
<head>
<%	
	String servingDate = java.net.URLDecoder.decode(request.getParameter("servingDate"),"UTF-8");	
	String locale=(String)session.getAttribute("LOCALE");	
	//String dateFrom = java.net.URLDecoder.decode(request.getParameter("dateFrom"),"UTF-8");
	String dateChkFlag = request.getParameter("dateChkFlag");	
	request.setCharacterEncoding("UTF-8");
%>
	<script type="text/javascript" src="../../eDS/js/PlaceDietOrder.js"></script> 
	<script type="text/javascript" src="../../eDS/js/DSCommon.js"></script>
	<script type="text/javascript" src="../../eDS/js/DocAcknowledgeReportForStaff.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../framework/js/PopupWindow.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	if(dateChkFlag.equals("Y")){
%>
	<p> This order cannot be cancelled as it is active for the current date.Clicking OK to this message will update the To date of the order as <%=servingDate%>. Do you wish to continue? </p>
<%
	}else{
%>
	<p> Are you sure you wish to cancel this order? </p>
<%}%>	
	<table>
	<tr>			
		<td>
		<fmt:message key="eDS.ReasonForCancellation.Label" bundle="${ds_labels}"/></font>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="text" value="" id="complaintDesc" name="complaintDesc" id="complaintDesc" onblur="if(this.value!='') return complaintsLookup('complaintDesc'); else complaintCode.value=''" />
		<input type="hidden"  value="" name="complaintCode" id="complaintCode" id="complaintCode"/>
		<input type="button" id="bt" class="BUTTON" value="?" onclick="complaintsLookup('complaintDesc')" />
		<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
	<tr>
		<td align="center" style="width: 600px;">
		<input type="button" name="button" id="button" 
		value='<fmt:message key="eOT.Ok.label" bundle="${ot_labels}" />' onClick='okButton(document.getElementById("complaintCode").value)' class="button" >
		<input name="cancel" id="cancel" type="button" value='<fmt:message key="eOT.Cancel.label" bundle="${ot_labels}" />' class="button" onClick="window.close();" />
		</td>
	</tr>
	</tr>
	</table>
	<input type="hidden" name="locale" id="locale"  value="<%=locale%>"/>		
</body>
</html>

