<!DOCTYPE html>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*," %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8"); 
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String title = request.getParameter("title")==null?"":request.getParameter("title");
		String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String srl_no = request.getParameter("srl_no")==null?"":request.getParameter("srl_no");
		 String bean_id		= "CapturePregnencyDetailBean";
		 String bean_name	= "ePH.CapturePregnencyDetailBean";

		CapturePregnencyDetailBean bean = (CapturePregnencyDetailBean)getBeanObject( bean_id,bean_name,request) ;
		String remarks = bean.getPregRemarks(patient_id+"~"+srl_no);
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="ePH.pregnancy.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="ePH.OverrideReasons.label" bundle="${ph_labels}"/></title>

	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="CapturePregnencyDetailRemarks" id="CapturePregnencyDetailRemarks">
			<table  border='0' align="center" width='100%' cellpadding='0' cellspacing='0'>
				<tr><td>&nbsp;</td></tr>
				<tr> 
					 <td  class="label"><textarea cols="50" rows="10" name="PregnencyRemarks" readonly ><%=remarks%></textarea>
					 </td>	 
				</tr>
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td class='button'>
					<input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  class="BUTTON" onClick="parent.window.close();">&nbsp;&nbsp;&nbsp;
				</tr>
			</table>
		</form>
	</body>
</html>

