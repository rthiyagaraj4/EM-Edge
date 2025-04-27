<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*" contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="alIssueGroupList" scope="session" class="java.util.ArrayList"/>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
<%
			request.setCharacterEncoding("UTF-8");
			String locale			= (String)session.getAttribute("LOCALE");
			String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	    <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/IssueGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<body>
<%
	IssueGroupListBean bean			=		(IssueGroupListBean)getBeanObject( "issueGroupListBean",  "eSS.IssueGroupListBean",request );  
	bean.clear();
	String mode								=		request.getParameter( "mode" ) ;
	String function_id						=		request.getParameter( "function_id" ) ;
	
	
	String disabled					=		"";
	String index					=		bean.checkForNull(request.getParameter("index"),"-1");
	System.out.println("index in issue detail"+index);
	if(!index.equals("-1")) {
		bean.initialize((HashMap)alIssueGroupList.get(Integer.parseInt(index)));
	}
	else if(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) {	
		disabled					=		"disabled";
	}else{
		disabled="";
	}
	//System.out.println("bean.getIssue_group_code_List()"+bean.getAuth_group_code());
	//System.out.println("bean.index()"+index);


%>
	<body onMouseDown="CodeArrest();" >
		<form name="formIssueGroupDetail" id="formIssueGroupDetail" >
			<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
			<td width='100%' height='100%' align='center' valign='top'>
			<table border="0" cellpadding="3" cellspacing="0" width='100%' align='center'>
				<tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				</tr>
				<%if(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {	%>
				<tr>
					<td class="label"><fmt:message key="eSS.GroupCode.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="description" id="description" value="<%=bean.getIssue_group_code()%>" maxLength='15' size='15'  ><input type='button' class='BUTTON' value='?' onClick="searchGroupCode(description);"  name="group_search" id="group_search" ><%=bean.getMandatoryImageTag()%><input type="hidden" name="req_group_code" id="req_group_code" value="<%=bean.getReq_group_desc()%>">
				</tr>
				<%}%>
				<tr>
				<td align="right" class="label" ><fmt:message key="eSS.ReqGroup.label" bundle="${ss_labels}"/></td>
				<td>&nbsp;<input type="text" value="<%=bean.getReq_group_desc()%>" name="req_group_desc" disabled size='15' maxLength='15'></td>
				</tr>
				<tr>
				<td align="right" class="label" ><fmt:message key="eSS.AuthGroup.label" bundle="${ss_labels}"/></td>
				<td>&nbsp;<input type="text" value="<%=bean.getAuth_group_desc()%>" name="auth_group_desc" disabled size='15' maxLength='15'></td>
				</tr>
				<tr>
				<td align="right" class="label" ><fmt:message key="eSS.IssueGroup.label" bundle="${ss_labels}"/></td>
				<td>&nbsp;<select name="issue_group_code" id="issue_group_code" <%=disabled%> onChange="clearTrayDetails();">
					<%if(disabled.equals("disabled")){%>
								<option value="">&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp;&nbsp;</option>
					<%}else{%>
										<%=bean.getIssue_group_code_List()%>
					<%}%>
				</select><%=bean.getMandatoryImageTag()%></td>
				</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></td>
					<!--Commented by Rabbani on 13/12/2012 -->
					<!--<td class="label">&nbsp;<input type='text' class="NUMBER" name="tray_no" id="tray_no" value="<%=bean.getTray_no()%>" maxLength='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' size='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' onKeyPress="return isValidInteger();"  <%=disabled%> onBlur="searchTrayDetail();"><input type='button' class='BUTTON' value='?' onClick="searchTrayNo();"  name="tray_search" id="tray_search" <%=disabled%>><%=bean.getMandatoryImageTag()%></td> -->
					
					<td class="label">&nbsp;<input type='text' class="NUMBER" name="tray_no" id="tray_no" value="<%=bean.getTray_no()%>" maxLength='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' size='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' onKeyPress="return isValidInteger();"  <%=disabled%> onBlur="validateTrayno();"><input type='button' class='BUTTON' value='?' onClick="searchTrayNo();"  name="tray_search" id="tray_search" <%=disabled%>><%=bean.getMandatoryImageTag()%></td>
					
				</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="eSS.BinLocation.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="bin_location_code" id="bin_location_code" value="<%=bean.getBin_location_desc()%>" maxLength="15" size="15" disabled></td>
				</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="expiry_date" id="expiry_date" value="<%=com.ehis.util.DateUtils.convertDate(bean.getExpiry_date(),"DMY","en",locale)%>" maxLength="10" size="10" disabled></td>
				</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="eSS.IssueCost.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="issue_cost" id="issue_cost" value="<%=bean.getIssue_cost()%>" maxLength="16" size="16" disabled class="NUMBER"></td>
				</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="patient_id" id="patient_id" value="<%=bean.getPatient_id()%>" maxLength='20' size='20' onBlur="searchPatientName()" <%=disabled%>><input type='button' class='BUTTON' value='?' onClick="searchPatient();" name="patient_search" id="patient_search" <%=disabled%>></td>
				</tr>
 				<tr>
					<td align="right" class="label"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="patient_name" id="patient_name" value="<%=bean.getPatient_name()%>" maxLength="20" size="20" disabled></td>
				</tr>
				<tr>
					<td align="center" class="label" colspan='2'>
						<input type='button' class='BUTTON' name="apply" id="apply" onClick="addToList();" value="Modify" <%=disabled%>>
						<input type='button' class='BUTTON' name="cancel" id="cancel" onClick="resetIssueGroupDetail();" value="Cancel" <%=disabled%>>					
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				</tr>
			</table>
			</td>
			</tr>
			</table>
			<input type='hidden' name="index" id="index"		value="<%=index%>">
			<input type='hidden' name="locale" id="locale"		value="<%=locale%>">
			<input type='hidden' name="function_id" id="function_id" value="<%=request.getParameter("function_id")%>">
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP_FOR_REPORT" id="SQL_SS_GROUP_LOOKUP_FOR_REPORT"		value="<%=bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP_FOR_REPORT")%>">
			<input type='hidden' name="mode" id="mode"		value="<%=mode%>">
		</form>
	</body>
</html>
<%
	putObjectInBean( "issueGroupListBean",  bean,request);
%>

