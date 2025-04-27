<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@	include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="eSS.*, eSS.Common.* , eCommon.Common.*, webbeans.eCommon.*,java.sql.*, java.util.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
04/07/2021		TFS19249		 Shazana		ML-MMOH-CRF-1661-US001  
---------------------------------------------------------------------------------------------------------------
*/ %>  
<html>
	<head>
<%

	request.setCharacterEncoding("UTF-8");
	String locale					=		(String)session.getAttribute("LOCALE");
	String sStyle					=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/ChangePatientID.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body onLoad="FocusFirstElement();" onMouseDown='CodeArrest();'>
	<%

		String mode					=		request.getParameter( "mode" ) ;
		String bean_id				=		"changePatientIDBean" ;
		String bean_name			=		"eSS.ChangePatientIDBean";

		ChangePatientIDBean bean	=		(ChangePatientIDBean) getBeanObject( bean_id,  bean_name, request);  
		bean.clear();
		bean.setMode(mode) ;
		bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
		bean.setLoginById((String)session.getAttribute("login_user")) ;
		bean.setMode(mode) ;
		bean.initSsParameter();
		bean.initDoc_type_code();
	bean.setLanguageId(locale);
	Connection con			= null;//MMOH-CRF-1661 START
	boolean linen_applicable_yn =false;
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
		System.out.println("Exception in ChangePatientIDQueryCriteria.jsp..");  
	}
	finally{
		if(con != null)
    		ConnectionManager.returnConnection(con,request);
	}//end 
		
	%>
		<form name="formChangePatientIDQueryCriteria" id="formChangePatientIDQueryCriteria" action="../../eSS/jsp/ChangePatientIDQueryResult.jsp" method="get" target="frameChangePatientIDQueryResult" onreset="FocusFirstElement();">
			<table border="0" cellpadding="1" cellspacing="0" width='100%' height='100%' align='center'>
				<tr>
				<!-- // Added by Rabbani #Inc no:39364 (Bru-HIMS-CRF-360) on 30-Apr-2013-->
				   <td align="right" class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
				   <td class="label">&nbsp;<select name="store_code" id="store_code"><%=bean.getAccess_store_code_List()%></select><img src="../../eCommon/images/mandatory.gif" align=center></td>
				   <!--ends -->
					<td align="right" class="label"><fmt:message key="eSS.IssDocType.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<select name="doc_type_code" id="doc_type_code"><%=bean.getDoc_type_code_List()%></select></td>
					<td align="right" class="label"><fmt:message key="eSS.IssDocNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="doc_no" id="doc_no" value="" size='8' maxLength='8' class="NUMBER" onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);"></td>
					<!--<td colspan='2'>&nbsp;</td> -->
				</tr>
				<tr>
					<td align="right" class="label" ><fmt:message key="eSS.GroupType.label" bundle="${ss_labels}"/></td>
					<td>&nbsp;&nbsp;<select name="group_type" id="group_type"><%=bean.getGroup_type_List()%></select></td>
					<td align="right" class="label"><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<input type="text" name="description" id="description" maxLength='15' size='15' value="" class='UPPER'><input type='button' class='BUTTON' value='?' onClick="searchGroupCode(issue_group_code,description);"  name="group_search" id="group_search" ></td>
					<td align="right" class="label"><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' class="NUMBER" name="tray_no" id="tray_no" value="" maxLength='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' size='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);" ><input type='button' class='BUTTON' value='?' onClick="searchTrayNo();" name="tray_search" id="tray_search" ></td>
				</tr>

				<tr>
					<td align="right" class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="patient_id" id="patient_id" value="" maxLength='20' size='20'><input type='button' class='BUTTON' value='?' onClick="searchPatient();" name="patient_search" id="patient_search"></td>
					<!-- // Added by Rabbani #Inc no:39364 (Bru-HIMS-CRF-360) on 30-Apr-2013 -->
					<td  align="right" class="label"><fmt:message key="eSS.DisplayGroupsLinkedToPatient.label" bundle="${ss_labels}"/></td>
	                <td  class="label">&nbsp;<select name="patient_order" id="patient_order" >
		           <option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		            <option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
		            <option value="N" selected><fmt:message key="Common.no.label" bundle="${common_labels}"/></option></select></td>
					<!-- ends-->
					<td align="right" class="label"><input type='button' class='Button' value='Search' name='search' id='search' onclick="showResults();"></td>
				</tr>
			</table>
			<br>
			<input type="hidden" name="issue_group_code" id="issue_group_code"		value="">
			<input type="hidden" name="locale" id="locale"					value="<%=locale%>">
			<input type="hidden" name="function_id" id="function_id"				value="<%=request.getParameter("function_id")%>">
			<input type="hidden" name="orderbycolumns" id="orderbycolumns"			value="doc_type_code,doc_no">
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_FOR_REQUEST" id="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_FOR_REQUEST" value="<%= bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_FOR_REQUEST")%>">

	</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>
 

