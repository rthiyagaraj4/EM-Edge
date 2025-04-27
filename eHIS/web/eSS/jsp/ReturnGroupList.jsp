<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eSS.ReturnGroupBean,eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@	include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<%@	include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 

<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale			= (String)session.getAttribute("LOCALE");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eSS/js/ReturnGroup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String bean_id				=		"returnGroupBean";
		String bean_name			=		"eSS.ReturnGroupBean";
		String checked				=		"";
		String disabled				=		"disabled";
		String className			=			"";

		java.util.ArrayList alTrays =		new java.util.ArrayList();
		String mode					=		request.getParameter("mode");
		String function_id			=		request.getParameter("function_id");

		ReturnGroupBean returnGroupBean =	(ReturnGroupBean) getBeanObject( bean_id, bean_name, request );		
		returnGroupBean.setLanguageId(locale);
		alTrays							=	returnGroupBean.getSelectedTraysList();
		int i							=	0;
		%>
	<body onMouseDown="CodeArrest()">
		<form name='formReturnGroupList' id='formReturnGroupList'>
		<%
		if (alTrays != null && alTrays.size()>0) {
		%>
			<table name ="tblTrayList" id="tblTrayList" border='1' cellpadding='0' cellspacing='0'  width='1085'>
			<tr>
				<th width='30'><fmt:message key="eSS.Del.label" bundle="${ss_labels}"/></th>
				<th width='205'><fmt:message key="eSS.GroupDescription.label" bundle="${ss_labels}"/></th>
				<th width='70'><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></th>
				<th width='150'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
				<th width='180'><fmt:message key="eSS.BinLocation.label" bundle="${ss_labels}"/></th><!-- width increased  150 to 180-->
				<th width='150'><fmt:message key="eSS.Reason.label" bundle="${ss_labels}"/></th>
				<th width='50'><fmt:message key="eSS.Expired.label" bundle="${ss_labels}"/></th>
				<th width='40'><fmt:message key="Common.used.label" bundle="${common_labels}"/></th>
				<th width='60'><fmt:message key="eSS.Sterilized.label" bundle="${ss_labels}"/></th>
				<th width='40'><fmt:message key="eSS.Wash.label" bundle="${ss_labels}"/></th>
				<th width='40'><fmt:message key="eSS.Pack.label" bundle="${ss_labels}"/></th>
				<th width='70'><fmt:message key="eSS.Contaminated.label" bundle="${ss_labels}"/></th>
				<th width='90'><fmt:message key="eSS.ChgConsum.label" bundle="${ss_labels}"/></th>
				<th width='90'><fmt:message key="eSS.Discrepancy.label" bundle="${ss_labels}"/></th>
			</tr>
			<%
				int totalSize		=		alTrays.size();
				
				for (i=0;	i<totalSize;	i++){
					String tray[]	=		(String[]) alTrays.get(i);
					

					className		=		((i%2)==0)?"QRYODD":"QRYEVEN";

					if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))  {
						
						if ((tray[15] != null) && ((String) tray[15]).equals("Y")) {
								checked		=	 "";
								disabled	=	 "";
							}
							else {
								checked		=	 "checked";
								disabled	=	 "disabled";
							}
					}
					else {
							disabled		=	 "";
							checked			=	"";
					}
				String mouseOver = "";
				String hyper = "";
				if(! returnGroupBean.checkForNull(tray[23]).equals("")){
				mouseOver = "onmouseover=\"changeCursor(this);\" onClick=\"reason("+i+");\"";
					hyper = "HYPERLINK";
				}
			%>
			<tr>
				<td class="<%=className%>" width='30'><input type='checkbox' name="tray_id_<%=i%>" id="tray_id_<%=i%>" <%=disabled%> <%=checked%>></td>
				<td class="NODISPLAY"><%=tray[0]%></td>
				<td class="<%=className%>"  width='205' onClick="dispalyReturnGroupDtls(this,<%=i%>);" onMouseOver="changeCursor(this);"><font class="HYPERLINK"><%=java.net.URLDecoder.decode(tray[1])%></font></td>
				<td class="<%=className%>"  width='70'><%=tray[2]%></td>
				<td class="<%=className%>"  width='150'><%=returnGroupBean.checkForNull(tray[6],"&nbsp;")%></td>
				<td class="<%=className%>"  width='150'><%=returnGroupBean.checkForNull(tray[21],"&nbsp;")%></td>
				<td class="<%=className%>" <%=mouseOver%>>  <font class="<%=hyper%>"> <fmt:message key="eSS.Reason.label" bundle="${ss_labels}"/>&nbsp&nbsp</font></td>
				<td class="<%=className%>"  width='50'><%=returnGroupBean.getImage(tray[7])%></td>
				<td class="<%=className%>"  width='40'><%=returnGroupBean.getImage(tray[8])%></td>
				<td class="<%=className%>"  width='60'><%=returnGroupBean.getImage(tray[9])%></td>
				<td class="<%=className%>"  width='40'><%=returnGroupBean.getImage(tray[10])%></td>
				<td class="<%=className%>"  width='40'><%=returnGroupBean.getImage(tray[11])%></td>
				<td class="<%=className%>"  width='70'><%=returnGroupBean.getImage(tray[12])%></td>	
				<td class="<%=className%>"  width='90'><%=returnGroupBean.getImage(tray[13])%></td>	
				<%

				if (((String) tray[8]).equals("Y")) {
					mouseOver = "onmouseover=\"changeCursor(this);\" onClick=\"showHyperDiscrepancyDetails(patient_id_"+i+",group_code_"+i+",tray_no_"+i+","+mode+");\"";
					hyper = "HYPERLINK";
				}
				else {
					hyper = "";
					mouseOver = "";
				}
				%>
				<td class="<%=className%>" align='center' width='90' <%=mouseOver%>><font class="<%=hyper%>"><fmt:message key="eSS.Discrepancy.label" bundle="${ss_labels}"/></font></td>	
			</tr>
				<input type="hidden" name="tray_no_<%=i%>" id="tray_no_<%=i%>"					 value="<%=tray[2]%>">
				<input type="hidden" name="group_code_<%=i%>" id="group_code_<%=i%>"				 value="<%=tray[0]%>">
				<input type="hidden" name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>"		 value="<%=tray[3]%>">
				<input type="hidden" name="expiry_date_<%=i%>" id="expiry_date_<%=i%>"				 value="<%=tray[4]%>">
				<input type="hidden" name="non_returnable_yn_<%=i%>" id="non_returnable_yn_<%=i%>"		 value="<%=tray[5]%>">
				<input type="hidden" name="used_status_<%=i%>" id="used_status_<%=i%>"				 value="<%=tray[8]%>">
				<input type="hidden" name="patient_id_<%=i%>" id="patient_id_<%=i%>"				 value="<%=tray[6]%>">
				<input type="hidden" name="charge_consumable_yn_<%=i%>" id="charge_consumable_yn_<%=i%>"		 value="<%=tray[13]%>">
				<input type="hidden" name="remarks_<%=i%>" id="remarks_<%=i%>"					 value="<%=returnGroupBean.checkForNull(tray[23])%>">
			<%
				}
			%>
			</table>
			<%
			}
			%>
			<input type="hidden" name="total_checkboxes" id="total_checkboxes"		value="<%=i%>">
			<input type="hidden" name="records_for_submission" id="records_for_submission"  value="">
			<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"				value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id"				value="<%=function_id%>">
<%
putObjectInBean(bean_id,returnGroupBean,request); 
%>
		</form>
	</body>
</html>

