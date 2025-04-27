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
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
		<script language="JavaScript" src="../../ePH/js/BLGroupOrderRouting.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<%
	try{
		String mode	= request.getParameter( "mode" ) ;
		String bean_id = "OrderRoutingBean" ;
		String bean_name = "ePH.OrderRoutingBean";

		if ( mode == null || mode.equals("") )
			return ;
		if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
			return ;
		OrderRoutingBean bean = (OrderRoutingBean)getBeanObject( bean_id, bean_name , request) ;
		bean.setLanguageId(locale);
		//bean.clear() ;
		bean.setMode( mode ) ;
		int recCount = 1;
		String disp_locn_code="",day_type="";
%>
		<form name="frmOrderRoutingLocationDetailForBL" id="frmOrderRoutingLocationDetailForBL" id="Order Routing Location Detail">
			<table cellpadding=0 cellspacing=0 width="100%" align="center" border="1" id="locationDetailTable" name="locationDetailTable">
				<tr>
					<th colspan="11"><fmt:message key="ePH.RoutingLocations.label" bundle="${ph_labels}"/></td>
				</tr>
				<tr> 
					<td class="COLUMNHEADER" width="8%"><fmt:message key="ePH.RoutingLevel.label" bundle="${ph_labels}"/></td>
					<td class="COLUMNHEADER" width="8%"><fmt:message key="ePH.Routing.label" bundle="${ph_labels}"/> </td>
					<td class="COLUMNHEADER" width="15%"><fmt:message key="Common.PerformingFacility.label" bundle="${common_labels}"/></td>
					<td width="10%" class="COLUMNHEADER"><fmt:message key="Common.routine.label" bundle="${common_labels}"/></td>
					<td width="10%" class="COLUMNHEADER"><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></td>
					<td width="10%" class="COLUMNHEADER"><fmt:message key="ePH.Discharge/TakeHomeMedication.label" bundle="${ph_labels}"/></td>
					<td width="9%" class="COLUMNHEADER"><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
					<td width="9%" class="COLUMNHEADER"><fmt:message key="ePH.CustomerGroup.label" bundle="${ph_labels}"/></td>
					<td width="9%" class="COLUMNHEADER"><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></td>
					<td width="9%" class="COLUMNHEADER"><fmt:message key="ePH.PolicyType.label" bundle="${ph_labels}"/></td>
					<td class="COLUMNHEADER" width="5%"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
				</tr>
			</table>
			<input type="hidden" name="number_of_rows" id="number_of_rows" value="">
			<input type="hidden" name="disp_locn_code" id="disp_locn_code" value=""> 
			<input type="hidden" name="recCount" id="recCount" value="<%=recCount%>">

		</form>
<%
		putObjectInBean(bean_id,bean,request);
	}
	catch ( Exception fe ) {
		fe.printStackTrace() ;
	}
%>
	</body>
</html>

