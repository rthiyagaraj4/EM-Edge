<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
1/7/2021  	TFS:19249        	Shazana                      			ML-MMOH-CRF-1661-US001

-------------------------------------------------------------------------------------------------------------------------------------------------------------
 */ %> 
<%@ page import="eSS.*" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
			request.setCharacterEncoding("UTF-8");
			String locale			=		(String)session.getAttribute("LOCALE");
			String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/ChangePatientID.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onLoad='FocusFirstElement();'onMouseDown='CodeArrest();'>
	<%
		ChangePatientIDBean bean	=		(ChangePatientIDBean)getBeanObject( "changePatientIDBean", "eSS.ChangePatientIDBean",request ) ;

		//String group_code			=	request.getParameter("group_code");
		String group_desc			=	request.getParameter("description");
		String tray_no				=	request.getParameter("tray_no");
		String group_type= request.getParameter("group_type"); //mmoh-crf-1661  
		bean.clear();
		bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
		bean.setLanguageId(locale);
	%>
		<form name="formChangePatientIDTrayQueryCriteria" id="formChangePatientIDTrayQueryCriteria" action="../../eSS/jsp/ChangePatientIDTrayQueryResult.jsp" method="post" target="frameChangePatientIDTrayQueryResult" onreset="FocusFirstElement();">

			<table border="0" cellpadding="1" cellspacing="0" width='100%' height='100%' align='center'>
				<tr>
					<td  class="label"><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<input name="group_desc" id="group_desc" maxLength='15' size='15' readOnly value="<%=group_desc%>" ><input type="hidden" value="" name="group_code" id="group_code"><input type="button" class="BUTTON" value='?' onClick="searchGroupCodeForTray(group_code, group_desc);">	
							</td>
					<td  class="label"><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="tray_no" id="tray_no" value="<%=tray_no%>"  size='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' maxLength='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' class="NUMBER" onKeyPress="return isValidInteger();"></td>
					<td  class="label"><fmt:message key="eSS.OwnerStore.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<select name="owner_store_code" id="owner_store_code" onBlur="populateBinLocation(this)">
							<%=bean.getStore_code_List()%></select>
							</td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="eSS.BinLocation.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<select name="bin_location_code" id="bin_location_code" >
						<%
							out.println(bean.getSsRepositoryValue("DEFAULT_LIST_OPTION"));
						%>
							</select>
							</td>
					<td  class="label"><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="expiry_date" id="expiry_date" value="" size='10' maxLength='10' onBlur="CheckDate(this);">
							</td>
 					<td  class="label"> </td>
					<td class="label">&nbsp;<input type='submit' class='Button' value='Search' name='search' id='search'></td>
				</tr>
			</table>
			<br>
			<input type="hidden" name="function_id" id="function_id" value="<%=request.getParameter("function_id")%>">
			<input type="hidden" name="locale" id="locale" value="<%=locale%>">
			<input type="hidden" name="group_type" id="group_type" value="<%=group_type%>"><!-- added for ML-MMOH-CRF-1661 -->
			<input type="hidden" name="orderbycolumns" id="orderbycolumns" value="group_code,tray_no">
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP" id="SQL_SS_GROUP_LOOKUP" value="<%= bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP")%>">
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE" id="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE" value="<%= bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE")%>">
	</form>
	</body>
</html>

<%
	putObjectInBean("changePatientIDBean",bean,request);
%>

