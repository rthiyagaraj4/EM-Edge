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
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../js/NPBRequest.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String bean_id					= "@NPBRequestBean"+patient_id+encounter_id;
	String bean_name				= "ePH.NPBRequestBean";
	NPBRequestBean bean			= (NPBRequestBean)getBeanObject(bean_id,bean_name,request);
	bean.clear();
	String params = request.getQueryString() ;
	String order_date = request.getParameter("order_date_time")==null?"":request.getParameter("order_date_time");
	String priority = request.getParameter("priority")==null?"":request.getParameter("priority");
	String location_type = request.getParameter("location_type")==null?"":request.getParameter("location_type");
	String location_code = request.getParameter("location_code")==null?"":request.getParameter("location_code");
	String pract_id = request.getParameter("ordering_practitioner")==null?"":request.getParameter("ordering_practitioner");
	String order_type = request.getParameter("order_type")==null?"":request.getParameter("order_type");
	String order_category = request.getParameter("order_category")==null?"":request.getParameter("order_category");
	String act_patient_class = request.getParameter("act_patient_class")==null?"":request.getParameter("act_patient_class");
	HashMap orderDetails = new HashMap();
	orderDetails.put("ORDER_DATE",order_date);
	orderDetails.put("PRIORITY",priority);
	orderDetails.put("ORDERING_LOCATION_TYPE",location_type);
	orderDetails.put("ORDERING_LOCATION",location_code);
	orderDetails.put("ORDERING_PRACTITIONER",pract_id);
	orderDetails.put("ORDER_TYPE","NPBREQ");
	orderDetails.put("ORDER_CATEGORY","PH");
	orderDetails.put("ACT_PATIENT_CLASS",act_patient_class);
	bean.setOrderDetails(orderDetails);
%>
	<body onKeyDown = 'lockKey()'>
		<form name='NPBRequestOptions' id='NPBRequestOptions'>
			<table cellpadding=0 cellspacing=0 width="100%" align="center" border='0'>
				<tr height='35'>
					<td width='20%' nowrap class='label'> <font size='2'>
						<input type='radio' name='NPBRequestOptions' id='NPBRequestOptions' value='N' checked onclick='loadNBPRequest("N");'/> <fmt:message key="ePH.NewRequest.label" bundle="${ph_labels}"/>&nbsp;&nbsp;
						<input type='radio' name='NPBRequestOptions' id='NPBRequestOptions' value='E' onclick='loadNBPRequest("E");'/> <fmt:message key="ePH.ExistingRequest.label" bundle="${ph_labels}"/>
					</td>
					<td width='*'>&nbsp;</td>
				</tr>
				<input type='hidden' name="query_string" id="query_string" value="<%=request.getQueryString()%>">
			</table>
		</form>
	</body>
</html> 
<% 	putObjectInBean(bean_id,bean,request); %>

