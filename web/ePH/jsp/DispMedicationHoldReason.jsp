<!DOCTYPE html>
<%--corrected on 10/25/2005--%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="ePH.ReasonforHold/Release.label" bundle="${ph_labels}"/></title>
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="DispMedicationHoldReason" id="DispMedicationHoldReason" >
<%
			String	bean_id			=	"DispMedicationAllStages" ;
			String	bean_name		=	"ePH.DispMedicationAllStages";
			
			DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject(bean_id, bean_name, request);

			String reason_code			=	"";
			String reason_desc			=	"";
			String bean_remarks			=	"";
			int no						=	0;
			String recno				=	request.getParameter("recno")==null?"":request.getParameter("recno");
			String drug_code			=	request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
			String order_line_no		=	request.getParameter("order_line_no")==null?"":request.getParameter("order_line_no");
			String order_id				=	request.getParameter("order_id")==null?"":request.getParameter("order_id");
			String fromdb				=	request.getParameter("fromdb")==null?"":request.getParameter("fromdb");
			String held	 				=	request.getParameter("held")==null?"":request.getParameter("held");
			String curr_date_time		=	"";
			String pharmacist_id		=	"";
			String hold_reason			=	"";
			ArrayList	reason			=	bean.getReason();
			HashMap	hold_remarks=new HashMap();
			if (fromdb.equals("Y")){
				//first time
				hold_remarks		=	bean.loadHoldRemarks(order_id,order_line_no);
			}
			if(hold_remarks.size() == 0 ) {
				ArrayList bean_reason		=	bean.getBeanReason(recno);
				curr_date_time				=	bean.getCurrDateTime();
				pharmacist_id				=	bean.getPharmacistID();
				if( bean_reason.size()==3) {
					hold_reason 	=	(String)bean_reason.get(++no);
					bean_remarks		=	(String)bean_reason.get(++no);
				}
			}
			else {
				pharmacist_id		=	(String)hold_remarks.get("hold_by_id")==null?"":(String)hold_remarks.get("hold_by_id");
				curr_date_time		=	(String)hold_remarks.get("hold_by_date")==null?"":(String)hold_remarks.get("hold_by_date");
				hold_reason			=	(String)hold_remarks.get("hold_reason")==null?"":(String)hold_remarks.get("hold_reason");
				bean_remarks		=(String)hold_remarks.get("hold_reason_desc")==null?"":(String)hold_remarks.get("hold_reason_desc");
			}
			String disabled="disabled";

			if (held.equals("N")){
				disabled				="";
				hold_reason		="";
				bean_remarks	="";
			}
%>
			<table cellpadding="0" cellspacing="2" width="100%" align="center" border="0">
				<tr>
					<td  class="label"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
					<td  class="label">&nbsp;&nbsp;<select name="reason" id="reason" <%=disabled%> onchange="getremarks(this)"><option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<% 
					for(int i=0; i<reason.size(); i+=2) {
						reason_code	=	(String)reason.get(i);
						reason_desc	=	(String)reason.get(i+1); 
						if( hold_reason.equals(reason_code)) {
%>
							<option value="<%=reason_code%>" selected><%=reason_desc%></option>
<%	
						}
						else {	
%>
							<option value="<%=reason_code%>"><%=reason_desc%></option>
<%
						}	
					}
%>
					</select>
					</td>
				</tr>

				<tr>
					<td  class="label"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td  class="label">&nbsp;&nbsp;<textarea rows="8" cols="50" name="remarks" id="remarks" onKeyPress="return checkRemarksMaxLimit(this,255,'remarks');" onBlur="checkRemarksMaxLimit(this,255,'remarks');" <%=disabled%>><%=bean_remarks%></textarea><img src="../../eCommon/images/mandatory.gif" ></td> <!-- checkRemarksMaxLimit added for [IN:039007]-->
				</tr>
				<tr>
					<td colspan="2" class="white">&nbsp;</td>
				</tr>
				<tr align="right">
					<td  colspan="2" class="button">
<% 
					if (held.equals("Y")) {
%>
						<input type="button" value='<fmt:message key="Common.Release.label" bundle="${common_labels}"/>' class="button"  onClick="storeReasonValues( document.DispMedicationHoldReason,<%=order_line_no%> ) ;" id='BtnRelease' name='BtnRelease' >
<% 
					}
					else {
%>
						<input type="button" value='<fmt:message key="ePH.Hold.label" bundle="${ph_labels}"/>' class="button"  onClick="storeReasonValues(document.DispMedicationHoldReason,<%=order_line_no%>);">
<%
					}
%>

					<input type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  class="button"  onClick="callClose();">&nbsp;&nbsp;&nbsp;
					</td>
				</tr>
			</table>
			<input type="hidden" name="recno" id="recno" value="<%=recno%>">
			<input type="hidden" name="drug_code" id="drug_code" value="<%=drug_code%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="order_line_no" id="order_line_no" value="<%=order_line_no%>">
			<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
			<input type="hidden" name="fromdb" id="fromdb" value="<%=fromdb%>">
		</form>
	</body>
</html>

