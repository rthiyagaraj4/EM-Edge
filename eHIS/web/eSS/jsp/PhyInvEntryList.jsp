<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eSS.PhyInvEntryBean" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@page contentType="text/html;charset=UTF-8"  import="eSS.*, eSS.Common.* , eCommon.Common.*,java.util.*" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eSS/js/PhyInvEntry.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<%
		String bean_id						=		"phyInvEntryBean";
		String bean_name					=		"eSS.PhyInvEntryBean";
		PhyInvEntryBean phyInvEntryBean		=		(PhyInvEntryBean) getBeanObject( bean_id, bean_name,request );  
	%>
	<body onMouseDown='CodeArrest();'>
		<form name='formPhyInvEntryList' id='formPhyInvEntryList'>
			<%
				int i=0;
				String tray_no					= null;
				String bin_location_code		= "&nbsp;";
				String bin_location_desc		= "&nbsp;";
				String group_code				= "";
				String group_desc				= "&nbsp;";
				String key						= null;
				String className				=	"";
				
				java.util.ArrayList alTrayDetails = phyInvEntryBean.getTrayDetailsKey();
				if (alTrayDetails.size() >0) {
					java.util.Hashtable htTrays = phyInvEntryBean.getTrayDetailsTable();
					%>
				<table name ="tblTrayList" id="tblTrayList" border='1' cellpadding='0' cellspacing='0' width='455' >
					<%
					for (i=0;	i<alTrayDetails.size();	i++){
						key					= (String) alTrayDetails.get(i);
						String tray[]		= (String[]) htTrays.get(key);
						tray_no				=	tray[0] ;
						bin_location_code	=	tray[1];
						bin_location_desc	=	tray[2];
						group_code			=	tray[3];
						group_desc			=	tray[4];
						className			=	((i%2)==0)?"QRYODD":"QRYEVEN";
				%>
				<tr width='455'>
					<td class="<%=className%>" align='center' width='30'><input type='checkbox' name="tray_id_<%=i%>" id="tray_id_<%=i%>"></td>
					<td class="<%=className%>" width='160' align='left' onClick="setTrayNo(this,<%=i%>);" onMouseOver="changeCursor(this);"><font class="HYPERLINK"><%=group_desc%></font></td>
					<td class='NODISPLAY'><%=bin_location_code%></td>
					<td class="<%=className%>" align='right' idth='105'><%=tray_no.trim()%></td>
					<td class="<%=className%>" align='left' width='160'><%=bin_location_desc%></td>
					<td class='NODISPLAY'><%=group_code%></td>
					<input type="hidden" name="selected_tray_<%=i%>" id="selected_tray_<%=i%>" value="<%=group_code%>-<%=tray_no.trim()%>">
				</tr>
				<%
					}
				%>
			</table>
			<%
			}
			%>
			<input type="hidden" name="total_trays" id="total_trays" value="<%=i%>">
			<input type="hidden" name="records_for_submission" id="records_for_submission" value="">
			<input type="hidden" name="mode" id="mode" value="<%=phyInvEntryBean.getMode()%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id" value="<%=phyInvEntryBean.getFunctionId()%>">
		</form>
		<%
putObjectInBean(bean_id,phyInvEntryBean,request);
%>
	</body>
</html>

