<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eSS.LoanReturnGroupBean,eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>
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
		<script language="javascript" src="../../eSS/js/LoanReturnGroup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String bean_id				=		"LoanReturnGroupBean";
		String bean_name			=		"eSS.LoanReturnGroupBean";
		//String checked				=		"";
		//String disabled				=		"disabled";
		String className			=			"";

		java.util.ArrayList alTrays =		new java.util.ArrayList();
		String mode					=		request.getParameter("mode");
		String function_id			=		request.getParameter("function_id");
		String entry_completed_yn	=		(request.getParameter("entry_completed_yn")== null)?"":request.getParameter("entry_completed_yn");
		
		LoanReturnGroupBean LoanReturnGroupBean =	(LoanReturnGroupBean) getBeanObject( bean_id, bean_name, request );		
		LoanReturnGroupBean.setLanguageId(locale);
		alTrays							=	LoanReturnGroupBean.getSelectedTraysList();
		int i							=	0;
		String binValues		=			LoanReturnGroupBean.getSsRepositoryValue("DEFAULT_LIST_OPTION");
		String visibility		 =			"";
		String disabled			=		"";
		String bin_desc			=		"";
		String code_disabled	= "";
		//Added by Sakti against inc#45808
		if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) && entry_completed_yn.equals("Y"))  {
				code_disabled = "disabled";
		}
		
		%>
	<body onMouseDown="CodeArrest()">
		<form name='formLoanReturnGroupList' id='formLoanReturnGroupList'>
		<%
		if (alTrays != null && alTrays.size()>0) {
		%>
			<table name ="tblTrayList" id="tblTrayList" border='1' cellpadding='0' cellspacing='0'  width=''>
			<tr>
				<th width='30'><fmt:message key="eSS.Del.label" bundle="${ss_labels}"/></th>
				<th width='205'><fmt:message key="eSS.GroupDescription.label" bundle="${ss_labels}"/></th>
				<th width='70'><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></th>
				<th width='150'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
				<th width='150'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>				
				<th width='180'><fmt:message key="eSS.BinLocation.label" bundle="${ss_labels}"/></th>				
				<th width='50'><fmt:message key="eSS.Expired.label" bundle="${ss_labels}"/></th>
				<th width='40'><fmt:message key="Common.used.label" bundle="${common_labels}"/></th>
				<th width='60'><fmt:message key="eSS.Sterilized.label" bundle="${ss_labels}"/></th>
				<th width='40'><fmt:message key="eSS.Wash.label" bundle="${ss_labels}"/></th>
				<th width='40'><fmt:message key="eSS.Pack.label" bundle="${ss_labels}"/></th>
				<th width='70'><fmt:message key="eSS.Contaminated.label" bundle="${ss_labels}"/></th>
				<th width='90'><fmt:message key="eSS.ChgConsum.label" bundle="${ss_labels}"/></th>
				<th width='150'><fmt:message key="eSS.Reason.label" bundle="${ss_labels}"/></th>
				<th width='90'><fmt:message key="eSS.Discrepancy.label" bundle="${ss_labels}"/></th>
			</tr>
			<%
				int totalSize		=		alTrays.size();
				
				for (i=0;	i<totalSize;	i++){
					String tray[]	=		(String[]) alTrays.get(i);
					
					className		=		((i%2)==0)?"QRYODD":"QRYEVEN";
					visibility		 =			"visibility:hidden";
					if(LoanReturnGroupBean.checkForNull(tray[6]).equals("")) {
						visibility		 =			"visibility:visible";
					}
					

					/*if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))  {
						
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
					}*/
				String mouseOver = "";
				String hyper = "";
				if(! LoanReturnGroupBean.checkForNull(tray[23]).equals("")){
				mouseOver = "onmouseover=\"changeCursor(this);\" onClick=\"reason("+i+");\"";
					hyper = "HYPERLINK";
				}
				disabled = "";
				if (((String) tray[8]).equals("N")) {
					disabled = "disabled";
				}
					
			%>
			<tr>
				<td class="<%=className%>" width='30'><input type='checkbox' name="tray_id_<%=i%>" id="tray_id_<%=i%>" <%=code_disabled%>></td>
				<td class="NODISPLAY"><%=tray[0]%></td>
				<td class="<%=className%>"  width='205' onClick="details(<%=i%>)" onMouseOver="changeCursor(this);"><font class="HYPERLINK"><%=java.net.URLDecoder.decode(tray[1])%></font></td>
				<td class="<%=className%>"  width='70'><%=tray[2]%></td>				
				<td class="<%=className%>" >&nbsp;<input type="text" name="patient_id_<%=i%>" id="patient_id_<%=i%>"  size=20 maxlength=20 onBlur= "return getPatientName(this,patient_name_<%=i%>,formLoanReturnGroupList,<%=i%>);" value="<%=LoanReturnGroupBean.checkForNull(tray[6])%>" <%=code_disabled%>><input class="button"  onClick="return callPatientSearch(patient_id_<%=i%>,patient_name_<%=i%>,formLoanReturnGroupList,<%=i%>);" type="button" name="cmdPatientSearch_<%=i%>" value="?" <%=code_disabled%>></td>				
				<td class= "<%=className%>" >&nbsp;<input type="text" name="patient_name_<%=i%>" id="patient_name_<%=i%>" size=20 value="<%=LoanReturnGroupBean.checkForNull(tray[16])==""?LoanReturnGroupBean.checkForNull(LoanReturnGroupBean.getPatientName(tray[6])):LoanReturnGroupBean.checkForNull(LoanReturnGroupBean.checkForNull(tray[16]))%>" disabled></td>
				<td class= "<%=className%>" >&nbsp;<select name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>" disabled value="<%=LoanReturnGroupBean.getBinLocationsList(tray[0],tray[2],LoanReturnGroupBean.checkForNull(tray[21]))%>" ></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td><!-- LoanReturnGroupBean.checkForNull(tray[21],"&nbsp;")> -->
				<td class= "<%=className%>" >&nbsp;<input type="checkbox" name="expired_yn_<%=i%>" id="expired_yn_<%=i%>" <%=code_disabled%> value="<%=LoanReturnGroupBean.checkForNull(tray[7],"N")%>"  <%=LoanReturnGroupBean.getChecked(LoanReturnGroupBean.checkForNull(tray[7],"N")) %>  <%=LoanReturnGroupBean.checkForNull(tray[4],"N").equals("Y")?"checked":""%> ></td>	
				<td class= "<%=className%>" >&nbsp;<input type="checkbox" name="used_yn_<%=i%>" id="used_yn_<%=i%>" <%=code_disabled%> value="<%=LoanReturnGroupBean.checkForNull(tray[8],"N")%>" onClick="canDisableDiscrepancy(this,<%=i%>);" <%=LoanReturnGroupBean.getChecked(LoanReturnGroupBean.checkForNull(tray[8],"N")) %>></td>
				<td class= "<%=className%>" >&nbsp;<input type="checkbox" name="sterilize_yn_<%=i%>" id="sterilize_yn_<%=i%>" value="<%=LoanReturnGroupBean.checkForNull(tray[9],"N")%>" onClick="checkSterilized();" <%=LoanReturnGroupBean.getChecked(LoanReturnGroupBean.checkForNull(tray[9],"N")) %> disabled <%=code_disabled%>></td>
				<td class= "<%=className%>" >&nbsp;<input type="checkbox" name="wash_yn_<%=i%>" id="wash_yn_<%=i%>" <%=code_disabled%> value="<%=LoanReturnGroupBean.checkForNull(tray[10],"N")%>" <%=LoanReturnGroupBean.getChecked(LoanReturnGroupBean.checkForNull(tray[10],"N")) %>  <%=LoanReturnGroupBean.checkForNull(tray[9],"N").equals("Y")?"disabled":""%> ></td>
				<td class= "<%=className%>" >&nbsp;<input type="checkbox" name="pack_yn_<%=i%>" id="pack_yn_<%=i%>" value="<%=LoanReturnGroupBean.checkForNull(tray[11],"N")%>" <%=LoanReturnGroupBean.getChecked(LoanReturnGroupBean.checkForNull(tray[11],"N")) %>  <%=LoanReturnGroupBean.checkForNull(tray[9],"N").equals("Y")?"disabled":""%> <%=code_disabled%>></td>
				<td class= "<%=className%>" >&nbsp;<input type="checkbox" name="contaminated_yn_<%=i%>" id="contaminated_yn_<%=i%>"  value="<%=LoanReturnGroupBean.checkForNull(tray[12],"N")%>" <%=LoanReturnGroupBean.getChecked(LoanReturnGroupBean.checkForNull(tray[12],"N")) %> <%=code_disabled%>></td>
				<td class= "<%=className%>" >&nbsp;<input type="checkbox" name="charge_consumable_yn_<%=i%>" id="charge_consumable_yn_<%=i%>" value="<%=LoanReturnGroupBean.checkForNull(tray[13],"N")%>" <%=LoanReturnGroupBean.getChecked(LoanReturnGroupBean.checkForNull(tray[13],"N")) %> <%=code_disabled%>></td>
				
				
				<td class="<%=className%>" onMouseOver="changeCursor(this)"; onClick="showRemarks(<%=i%>)" ><font class="HYPERLINK"> <fmt:message key="eSS.Reason.label" bundle="${ss_labels}"/> </font>&nbsp;<img id="img_remarks_<%=i%>"  src="../../eCommon/images/mandatory.gif" style="<%=visibility%>" /></td><input type="hidden" name="remarks_code_<%=i%>" id="remarks_code_<%=i%>" value="">
				
			<!--	<%

				if (((String) tray[8]).equals("Y")) {
					mouseOver = "onmouseover=\"changeCursor(this);\" onClick=\"showHyperDiscrepancyDetails(patient_id_"+i+",group_code_"+i+",tray_no_"+i+","+mode+");\"";
					hyper = "HYPERLINK";
				}
				else {
					hyper = "";
					mouseOver = "";
				}
				%>
				<td class="<%=className%>" align='center' width='90' <%=mouseOver%> id= "discrepancy_<%=i%>"><font class="<%=hyper%>"><fmt:message key="eSS.Discrepancy.label" bundle="${ss_labels}"/></font></td>	-->
				<td class="<%=className%>" align='center' width='90' onmouseover ="changeCursor(this);" <%=disabled%> onclick="showHyperDiscrepancyDetails('<%=LoanReturnGroupBean.checkForNull(tray[6])%>',group_code_<%=i%>,tray_no_<%=i%>,'<%=mode %>');"  id= "discrepancy_<%=i%>"><font class="HYPERLINK"><fmt:message key="eSS.Discrepancy.label" bundle="${ss_labels}"/></font></td>
			</tr>
			
			
				<input type="hidden" name="tray_no_<%=i%>" id="tray_no_<%=i%>"					 value="<%=tray[2]%>">
				<input type="hidden" name="group_code_<%=i%>" id="group_code_<%=i%>"				 value="<%=tray[0]%>">
				<input type="hidden" name="group_desc_<%=i%>" id="group_desc_<%=i%>"				 value="<%=java.net.URLDecoder.decode(tray[1])%>">
				<!-- <input type="hidden" name="bin_location_code_<%=i%>" id="bin_location_code_<%=i%>"		 value="<%=tray[3]%>">-->
				<input type="hidden" name="expiry_date_<%=i%>" id="expiry_date_<%=i%>"				 value="<%=tray[4]%>">
				<input type="hidden" name="non_returnable_yn_<%=i%>" id="non_returnable_yn_<%=i%>"		 value="<%=tray[5]%>">
				<input type="hidden" name="used_status_<%=i%>" id="used_status_<%=i%>"				 value="<%=tray[8]%>">				
				<input type="hidden" name="remarks_<%=i%>" id="remarks_<%=i%>"					 value="<%=LoanReturnGroupBean.checkForNull(tray[22])%>">
				<input type="hidden" name="iss_doc_type_code_<%=i%>" id="iss_doc_type_code_<%=i%>"		 value="<%=tray[19]%>">
				<input type="hidden" name="iss_doc_no_<%=i%>" id="iss_doc_no_<%=i%>"				 value="<%=tray[20]%>">	
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
			<input type="hidden" name="entry_completed_yn" id="entry_completed_yn"		value="<%=LoanReturnGroupBean.getEntry_completed_yn()%>">
<%
putObjectInBean(bean_id,LoanReturnGroupBean,request); 
%>
		</form>
	</body>
</html>

