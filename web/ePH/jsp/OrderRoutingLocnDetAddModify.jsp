<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
	<!--<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>-->
	<!--<script language="Javascript" src="../../eCommon/js/messages.js"></script>-->
	<script language="JavaScript" src="../../ePH/js/OrderRouting.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<%
	/* Mandatory checks start */
	String mode	= request.getParameter( "mode" ) ;
	String bean_id = "OrderRoutingBean" ;
	String bean_name = "ePH.OrderRoutingBean";

	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	OrderRoutingBean bean = (OrderRoutingBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
	bean.clear() ;
	bean.setMode( mode ) ;
	/* Initialize Function specific end */

%>

<form name="frmOrderRoutingLocationDetail" id="frmOrderRoutingLocationDetail" id="Order Routing Location Detail">
	<table cellpadding=0 cellspacing=0 width="100%" align="center" border="1" id="locationDetailTable">
		<tr>
			<th colspan="7"><fmt:message key="ePH.RoutingLocations.label" bundle="${ph_labels}"/></td>
		</tr>
		<tr>
			<th class="border">&nbsp;</th>
			<th class="border" >&nbsp;</th>
			<th class="border" >&nbsp;</th>
			<th colspan="3" style=" border-left:none;border-top:none ;"><fmt:message key="ePH.DefaultDispenseLocation.label" bundle="${ph_labels}"/></th>
			<th class="border">&nbsp;</th>
		</tr>
		<tr> 
			<th class="border" width="13%"><fmt:message key="ePH.RoutingLevel.label" bundle="${ph_labels}"/></th>
			<th class="border" width="12%"><fmt:message key="ePH.Routing.label" bundle="${ph_labels}"/> </th>
			<th class="border" width="25%"><fmt:message key="Common.PerformingFacility.label" bundle="${common_labels}"/></th>
			<th width="15%" class="border"><fmt:message key="Common.routine.label" bundle="${common_labels}"/></th>
			<th width="15%" class="border"><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></th>
			<th width="15%" class="border"><fmt:message key="ePH.Discharge/TakeHomeMedication.label" bundle="${ph_labels}"/></th>
			<th class="border" width="5%"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
		</tr>
	</table>
	<input type="hidden" name="number_of_rows" id="number_of_rows" value="">
</form>
</body>
</html>

<%
putObjectInBean(bean_id,bean,request);
%>

