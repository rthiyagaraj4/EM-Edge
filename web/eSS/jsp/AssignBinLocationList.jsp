<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8"  import="eSS.AssignBinLocationBean" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eSS/js/AssignBinLocation.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id				=		 "AssignBinLocationBean";
		String bean_name			=		"eSS.AssignBinLocationBean";
		AssignBinLocationBean bean  =		(AssignBinLocationBean) getBeanObject( bean_id,  bean_name, request);  
		String store_code					=	 bean.checkForNull(request.getParameter("store_code"));
		
		
		bean.setStore_code(store_code);
	%>
	<body onMouseDown="CodeArrest();">
		<form name='formAssignBinLocationList' id='formAssignBinLocationList'>
			<table name ="tblTrayList" id="tblTrayList" border='1' cellpadding='0' cellspacing='0' width='455' >
			<%
				int i							=		0;
				String tray_no					=		null;
				String bin_location_code		=		"&nbsp;";
				String disabled					=		"disabled";
				String className				=			"";
				java.util.ArrayList alTrayDetails =		 bean.getTrayDetails();
				
				for (i=0;	i<alTrayDetails.size();	i++){
					String tray[]				=		(String[]) alTrayDetails.get(i);
					tray_no						=		tray[1] ;
					bin_location_code			=		tray[2] ;
					className					=		((i%2)==0)?"QRYODD":"QRYEVEN";
			%>
			<tr>
				<td class="<%=className%>" align='center' width='50'><input type='checkbox' name="tray_id_<%=i%>" id="tray_id_<%=i%>" <%=disabled%> ></td>
				<td class="<%=className%>" width='120' align="right"  onClick="setTrayNo(this,<%=i%>,'<%=store_code%>');" onMouseOver="changeCursor(this);"><font class="HYPERLINK"><%=tray_no%></font></td>
				<td class='NODISPLAY'>&nbsp;</td>
				<input type="hidden" name="bin_location_<%=i%>" id="bin_location_<%=i%>" value="">
				<td class="<%=className%>" align='left' width='285'>&nbsp;</td>
			</tr>
			<%
				}
			%>
			</table>
			<input type="hidden" name="total_checkboxes" id="total_checkboxes" value="<%=i%>">
			<input type="hidden" name="total_trays" id="total_trays" value="<%=i%>">
			<input type="hidden" name="records_for_submission" id="records_for_submission" value="">
			<input type="hidden" name="mode" id="mode" value="<%=bean.getMode()%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
		</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

