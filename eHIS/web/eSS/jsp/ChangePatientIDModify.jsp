<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
17/8/2021		TFS:22471		Shazana					ML-MMOH-SCF-1884
---------------------------------------------------------------------------------------------------------------
*/ %> 

<%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*, eSS.Common.*, webbeans.eCommon.*,java.sql.*, java.util.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	 =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/ChangePatientID.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<%
	String mode;
	String bean_id;
	String bean_name;
	String doc_type_code;
	String doc_no;
	String issue_group_code;
	String tray_no;

	
	mode						=		request.getParameter( "mode" ) ;
	bean_id						=		"changePatientIDBean" ;
	bean_name					=		"eSS.ChangePatientIDBean";

	if ((mode == null) || (mode.equals(""))) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;

	ChangePatientIDBean bean	=		(ChangePatientIDBean) getBeanObject( bean_id,  bean_name , request);
	bean.clear() ;
	bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
	bean.setFunctionId(request.getParameter("function_id"));
	bean.setMode(mode) ;
	Connection con			= null;//ML-MMOH-SCF-1884 START
	boolean linen_applicable_yn = false; 
	try{
		con				= ConnectionManager.getConnection(request);
		linen_applicable_yn = eCommon.Common.CommonBean.isSiteSpecific(con,"SS", "SS_GROUP_TYPE_LINEN"); 
		if(linen_applicable_yn){
			bean.setLinenApplicableYN("Y");
		}else{
			bean.setLinenApplicableYN("N");  
		}
	}
	catch(Exception e){
		e.printStackTrace();
	
	}
	finally{
		if(con != null)
			ConnectionManager.returnConnection(con,request);
	}//end  

	if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {

		doc_type_code			=		request.getParameter("doc_type_code");
		doc_no					=		request.getParameter("doc_no");
		issue_group_code		=		request.getParameter("issue_group_code");
		tray_no					=		request.getParameter("tray_no");

		if (( doc_type_code== null )||( doc_no== null )) {
			return;		
		}
		bean.setDoc_no(doc_no.trim()) ;
		bean.setDoc_type_code(doc_type_code.trim()) ;
		bean.setIssue_group_code(issue_group_code.trim()) ;
		bean.setTray_no(tray_no.trim()) ;
		bean.loadData() ;
	}
%>
	<body onload="FocusFirstElement();"onMouseDown='CodeArrest();'>
		<form name="formChangePatientID" id="formChangePatientID"onReset="FocusFirstElement();">
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
	<tr>
	<td width='100%' align='center' class="WHITE">
	<table border="0" cellpadding="1" cellspacing="0" width='60%'align='center'>
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>

				<tr>
					<td class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<select name="doc_type_code" id="doc_type_code" onChange="checkDoc_type_code()" disabled>
						<%=bean.getDoc_type_code_List()%>
					</select></td>
				</tr>
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>

				<tr>
					<td  class="label"><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type="text" class="NUMBER" value="<%=bean.getDoc_no()%>" name="doc_no" maxLength="8" size="8" disabled></td>
				</tr>			
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr>
					<td  class="label" ><fmt:message key="eSS.GroupType.label" bundle="${ss_labels}"/></td>
					<td>&nbsp;<select name="group_type" id="group_type" disabled>
						<%=bean.getGroup_type_List()%>
					</select></td>
				</tr>
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr>
						<td  class="label"><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
						<td class="label" >&nbsp;<input type="text" name="issue_group_code" id="issue_group_code" maxLength='15' size='15' value="<%=bean.getGroup_desc()%>"  disabled></td>
				</tr>
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr>
						<td class="label"><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></td>
						<td class="label">&nbsp;<input type='text' class="NUMBER" name="tray_no" id="tray_no" value="<%=bean.getTray_no()%>" maxLength='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' size='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' disabled></td>
				</tr>
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr>
						<td  class="label"><fmt:message key="eSS.BinLocation.label" bundle="${ss_labels}"/></td>
						<td class="label">&nbsp;<input type="text" name="bin_location_code" id="bin_location_code" maxLength='15' size='15' value="<%=bean.getBin_location_code()%>" disabled></td>
				</tr>
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="patient_id" id="patient_id" value="<%=bean.getPatient_id()%>" maxLength='20' size='20' onBlur="searchPatientName()"><input type='button' class='BUTTON' value='?' onClick="searchPatient();" name="patient_search" id="patient_search"><%=bean.getMandatoryImageTag()%></td>
				</tr>			
				<tr>
					<td  class="label"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="patient_name" id="patient_name" value="<%=bean.getPatient_name()%>" maxLength="20" size="20" disabled></td>
				</tr>
				<tr>
					<td colspan='2'>&nbsp;</td>
				</tr>
			</table>
			</td>
			</tr>
			</table>
			<input type="hidden" name="mode" id="mode"		value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"		value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"	value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id" value="<%= bean.getFunctionId() %>">
		</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

