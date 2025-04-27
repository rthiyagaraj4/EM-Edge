<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eSS.ReturnGroupBean,eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>

<%@	include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@	include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/ReturnGroup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String bean_id			=		"returnGroupBean";
		String bean_name		=		"eSS.ReturnGroupBean";
		String group_code		=		request.getParameter("group_code");
		String tray_no			=		request.getParameter("tray_no");
		String val				=		"";
		String mode				=		request.getParameter("mode");


		ReturnGroupBean returnGroupBean =		(ReturnGroupBean) getBeanObject( bean_id, bean_name,  request);		


		if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		
			returnGroupBean.loadDiscrepancyDetails(group_code,tray_no);
		}
	%>
	<body  onMouseDown="CodeArrest()">
		<form name='formReturnGroupDiscrepancyList' id='formReturnGroupDiscrepancyList'>
			<table name ="tblInstrumentList" id="tblInstrumentList" border='1' cellpadding='0' cellspacing='0' width='455' >
			<%
				String instrument_code			=	null;
				String instrument_desc			=	null;
				String discrepancy_desc			=	null;
				String instrument_qty			=	null;
				String discrepancy_qty			=	null;
				String write_off_reason_code	=	null;
				String className				=	"";
				try{
				int i=0,classIndex;
				java.util.ArrayList alDiscrepancyKey	= returnGroupBean.getDiscrepancyDetailsKey(group_code,tray_no);

				if(alDiscrepancyKey.size()>0){
					
				java.util.Hashtable discreapncyDetails = returnGroupBean.getDiscrepancyDetails(group_code,tray_no);
				
				for ( i=0,classIndex=0;i<alDiscrepancyKey.size();i++,classIndex++){
				
					String instrument[]		=	(String[]) discreapncyDetails.get(alDiscrepancyKey.get(i));
					instrument_code			=	instrument[2];
					discrepancy_qty			=	instrument[6];
					instrument_desc			=	instrument[3];
					discrepancy_desc		=	instrument[15];
					instrument_qty			=	instrument[16];
					write_off_reason_code	=   instrument[4];
					className				=	((classIndex%2)==0)?"QRYODD":"QRYEVEN";
					
					
				
			%>
	 <tr width='365'>
				
				<td class="<%=className%>"  width='30'><input type='checkbox' name="item_id_<%=i%>" id="item_id_<%=i%>"></td>
				<td class="<%=className%>"  width='140' onClick="displayDiscrepancyDtls(this,<%=i%>);" onMouseOver="changeCursor(this);"><font class="HYPERLINK"><%=returnGroupBean.checkForNull(instrument_desc,"&nbsp;")%></font></td>
				<td class="<%=className%>"  width='140'><%=returnGroupBean.checkForNull(discrepancy_desc,"&nbsp;")%></td>
				<td class="<%=className%>"  width='73'><%=returnGroupBean.checkForNull(instrument_qty,"&nbsp;")%></td>
				<td class="<%=className%>"  width='72'><%=returnGroupBean.checkForNull(discrepancy_qty,"&nbsp;")%></td>
				<td class='NODISPLAY'><%=instrument_code%></td>
			</tr>
				<input type="hidden" name="group_tray_item_<%=i%>" id="group_tray_item_<%=i%>" value="<%=alDiscrepancyKey.get(i)%>">
				<input type="hidden" name="group_tray_<%=i%>" id="group_tray_<%=i%>" value="<%=group_code%>-<%=tray_no%>"> 
			<%
				}
			}
				
			%>
			</table>
			<input type="hidden" name="total_inst_checkboxes" id="total_inst_checkboxes"			value="<%=i%>">
			<input type="hidden" name="total_records_for_submission" id="total_records_for_submission"	value="">
			<input type="hidden" name="mode" id="mode"							value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"							value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"						value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id"						value="<%=val%>">
			<input type="hidden" name="group_code" id="group_code"						value="<%=group_code%>">
			<input type="hidden" name="tray_no" id="tray_no"							value="<%=tray_no%>">
				<%
				}
				catch(Exception e){
				     // System.err.println(e.getMessage());
				     // out.println(e);
				     e.printStackTrace(); // COMMON-ICN-0185
				}
				%>
		</form>
	</body>
		<%
			putObjectInBean(bean_id,returnGroupBean,request); 
	%>

</html>

