<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String callFor				=	request.getParameter("callFor")==null?"":request.getParameter("callFor");
		String title="";
		if(callFor.equals("HD"))
			title = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ReasonForHold.label", "ph_labels");
		else
			title = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ReasonForDiscont.label", "ph_labels");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/MedicationAdministration.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><%=title%></title>
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="MARSchLevelHoldReason" id="MARSchLevelHoldReason" >
<%
			String admin_bean_id	=	"MedicationAdministrationBean";
			String admin_bean_name=	"ePH.MedicationAdministrationBean";		
			MedicationAdministrationBean admin_bean = (MedicationAdministrationBean)getBeanObject( admin_bean_id,admin_bean_name, request ) ;	

			String order_line_no		=	request.getParameter("order_line_no")==null?"":request.getParameter("order_line_no");
			String order_id				=	request.getParameter("order_id")==null?"":request.getParameter("order_id");
			String patient_id			=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
			String sch_date_time		=	request.getParameter("sch_date_time")==null?"":request.getParameter("sch_date_time");
			ArrayList	alReasonList	=	admin_bean.loadReason(callFor.substring(0,1));
			String  remarks="";
%>
			<table cellpadding="0" cellspacing="2" width="100%" align="center" border="0">
				<tr>
					<td  class="label"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
					<td  class="label">&nbsp;&nbsp;<select name="reason" id="reason" onchange="getRemarks(this)"><option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<% 
					for(int i=0; i<alReasonList.size(); i+=3) {
						remarks = (String)alReasonList.get(i+2);
						remarks         =   remarks.replaceAll(" ","%20");
						remarks         =   java.net.URLEncoder.encode(remarks,"UTF-8");
						remarks         =   remarks.replaceAll("%2520","%20");						
%>
						<option value="<%=(String)alReasonList.get(i)%>" type='<%=remarks%>'><%=(String)alReasonList.get(i+1)%></option>
<%
					}
%>
					</select>
					</td>
				</tr>

				<tr>
					<td  class="label"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td  class="label">&nbsp;&nbsp;<textarea rows="8" cols="50" name="remarks" onKeyPress="return checkRemarksMaxLimit(this,255,'remarks');" onBlur="checkRemarksMaxLimit(this,255,'remarks');"></textarea><img src="../../eCommon/images/mandatory.gif" ></td> 
				</tr>
				<tr>
					<td colspan="2" class="white">&nbsp;</td>
				</tr>
				<tr align="right">
					<td  colspan="2" class="button">
<%
						if(callFor.equals("HD")){
%>
							<input type="button" value='<fmt:message key="ePH.Hold.label" bundle="${ph_labels}"/>' class="button"  onClick="recordHoldDiscont('<%=callFor%>');">
<%
						}
						else{
%>
							<input type="button" value='<fmt:message key="Common.Discontinue.label" bundle="${common_labels}"/>' class="button"  onClick="recordHoldDiscont('<%=callFor%>');">
<%
						}
%>
						<input type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  class="button"  onClick="window.close();">
					</td>
				</tr>
			</table>
			<input type="hidden" name="order_line_no" id="order_line_no" value="<%=order_line_no%>">
			<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
			<input type="hidden" name="callFor" id="callFor" value="<%=callFor%>">
			<input type="hidden" name="sch_date_time" id="sch_date_time" value="<%=sch_date_time%>">
		</form>
	</body>
</html>

