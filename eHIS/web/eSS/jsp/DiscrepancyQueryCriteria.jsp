<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="eSS.*, eSS.Common.* ,java.util.*,java.sql.*, eCommon.Common.*,java.util.Properties,java.util.ArrayList,java.util.Hashtable,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@	include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

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
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eSS/js/Discrepancy.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<%
//	java.util.HashMap defaultParameter = null;

	String bean_id					=			"trayDtlBean";
	String bean_name				=			"eSS.TrayDtlBean";
	String disabled					=			"";
//	String facility_id				=			(String) session.getValue("facility_id");

	TrayDtlBean bean				=			(TrayDtlBean)getBeanObject( bean_id,bean_name, request  );  
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
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
		System.out.println("Exception in DiscrepancyQueryCriteria.jsp..");  
	}
	finally{
		if(con != null)
    		ConnectionManager.returnConnection(con,request);
	}
%>
<body onload='FocusFirstElement();document.TrayDiscrepancyQuery.submit()'onMouseDown="CodeArrest()">
	
	<form name="TrayDiscrepancyQuery" id="TrayDiscrepancyQuery" action="../../eSS/jsp/DiscrepancyQueryResult.jsp" method="post" target="frameTrayDiscrepancyQueryResult">
			<table border="0" cellpadding="0" cellspacing="0" width='100%' height='100%'>
				 <tr> 
					<td colspan='8'>&nbsp;</td>
				  </tr>
				  <tr>
				    <td  class="label" ><fmt:message key="eSS.GroupType.label" bundle="${ss_labels}"/></td>
					<td>&nbsp;&nbsp;<select name="group_type" id="group_type" onChange="clearGroupDetail();"><%=bean.getGroup_type_List()%></select></td>
					<td class="label"><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type='text' name="group_desc" id="group_desc" value="" maxLength='15' size='15' <%=disabled%> ><input type='button' class='BUTTON' value='?' onClick="searchGroupCode(group_code, group_desc)"  name="group_search" id="group_search" ><input type='hidden' name="group_code" id="group_code" ></td>
					<td class=label ><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input class="number" maxLength=15 size=15 name="tray_no" id="tray_no" value="" onKeyPress="return isValidInteger();"></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					
				</tr>
				<tr>
					<td colspan='8'>&nbsp;</td>
				</tr>
				<tr>
					<td class="label" align="left"><fmt:message key="eSS.DescrepancyEnteredAt.label" bundle="${ss_labels}"/></td>
					<td class=label >&nbsp;&nbsp;<select name="entered_requestor" id="entered_requestor" > <%=bean.getCurrentTRDStores()%></select>&nbsp;</td>
					<td align="left" class="label" ><fmt:message key="eSS.Discrepancy.label" bundle="${ss_labels}"/></td>
					<td>&nbsp;&nbsp;<select name="discrepancy" id="discrepancy"  >
					<%=bean.getDiscrepancy()%>
					</select></td>
					<td class=label align=left><fmt:message key="eSS.Owner.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<select name="owner_store_code" id="owner_store_code" > <%=bean.getStores()%></select>&nbsp;</td>
					<td>&nbsp;</td>
					<td ><input type="submit" value="Search" class="BUTTON" ></td>
				</tr>
				<tr>
					<td colspan='8'>&nbsp;</td>
				</tr>
			</table>
			<input type="hidden" name="locale" id="locale" value="<%=locale%>">
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE" id="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE" value="<%= bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE")%>">
			<input type="hidden" name="orderbycolumns" id="orderbycolumns" value="1">
		</form>
	</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>

