<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eSS.ROFEntryBean" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eSS/js/ROFEntry.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String bean_id				=		"rofEntryBean";
		String bean_name			=		 "eSS.ROFEntryBean";

		String checked				=		"";

		String disabled				=		"disabled";
		String className			=		"";

		ROFEntryBean bean			=		(ROFEntryBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);
		String mode					=		request.getParameter("mode");
		String index				=		bean.checkForNull(request.getParameter("index"),"-1");
		String function_id			=		request.getParameter("function_id");
		String group_type			=		""; //ML-MMOH-CRF-1821
		
		java.util.ArrayList alTrays =		bean.getSelectTray();
		
		int i=0;
		%>
	<body onMouseDown="CodeArrest()">
		<form name='formROFEntryList' id='formROFEntryList'>
		<%
		if (alTrays != null && alTrays.size()>0) {
		%>
			<table name ="tblTrayList" id="tblTrayList" border='1' cellpadding='0' cellspacing='0'  width='455'>
			<%

				int totalSize = alTrays.size();
				int loopValue = 0;
				for (i=0;	i<totalSize;	i++){
					String tray[] = (String[]) alTrays.get(i);
					className	=	((i%2)==0)?"QRYODD":"QRYEVEN";
					disabled = "";
					checked = "";
					
					group_type  = tray[6]; //ML-MMOH-CRF-1821
		%>
			<tr>
				<td class="<%=className%>"  width='30'><input type='checkbox' name="tray_id_<%=i%>" id="tray_id_<%=i%>" <%=disabled%> <%=checked%>></td>
				<td class="<%=className%>"  width='150'  onClick="displayDetail(<%=i%>);" onMouseOver="changeCursor(this);"><font class="HYPERLINK"><%=tray[11]%></font></td>
				<td class="<%=className%>" width='150'><%=tray[1]%></td>
				<td class="<%=className%>"  width='125'><%=tray[2]%></td>
			</tr>
				<input type="hidden" name="selected_tray_<%=i%>" id="selected_tray_<%=i%>" value="<%=tray[0]%>-<%=tray[2]%>">
			<%
					
					// call script only once to set 
					loopValue = i;
					if(mode!=null && mode.equalsIgnoreCase("2") && ((loopValue+1)==totalSize)) {	
			%>
								<script>setTimeout("defaultGroupType('<%=group_type%>')",1500);</script> 	

			<%		}
				}
			%>
			</table>
			<%
					}
			%>
			<input type="hidden" name="total_trays" id="total_trays"				value="<%=i%>">
			<input type="hidden" name="records_for_submission" id="records_for_submission"	value="">
			<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
			<input type="hidden" name="index" id="index"					value="<%=index%>">
			<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"				value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id"				value="<%=function_id%>">
			
		</form>
	</body>
	<%	putObjectInBean(bean_id,bean,request);%>
</html>

