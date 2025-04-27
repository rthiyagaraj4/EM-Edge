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
04/07/2021		TFS19249		 Shazana		ML-MMOH-CRF-1661-US001
---------------------------------------------------------------------------------------------------------------
*/ %> 
<%@ page import ="eSS.*, eSS.Common.* , eCommon.Common.*,java.util.*,java.util.Properties,java.sql.*,java.util.ArrayList,java.util.Hashtable,webbeans.eCommon.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%@	include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		
		String sStyle			 =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eSS/js/TrayDtls.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
//	java.util.HashMap defaultParameter		=		null;
	String bean_id							=		"trayDtlBean";
	String bean_name						=		"eSS.TrayDtlBean";
	String disabled							=		"";
//	String facility_id						=		(String) session.getValue("facility_id");

	TrayDtlBean bean						=		(TrayDtlBean) getBeanObject( bean_id,  bean_name,request);  
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	Connection con			= null;//MMOH-CRF-1661 START
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
		out.print("Exception in TrayDtlsQueryCriteria.jsp"); 
	}
	finally{
		if(con != null)
    		ConnectionManager.returnConnection(con,request); 
	}
	//end 
%>
<body onload='FocusFirstElement();'onMouseDown="CodeArrest();" >
	<form name="TrayDetailQuery" id="TrayDetailQuery" action="../../eSS/jsp/TrayDtlsQueryResult.jsp" method="post" target="qryResultTrayDtl">
	<br>
			<table border="0" cellpadding="0" cellspacing="0" width='98%'>
				 <tr>
					<td colspan='8'>&nbsp;</td>
				  </tr>
				  <tr>
				    <td class="label" ><fmt:message key="eSS.GroupType.label" bundle="${ss_labels}"/>&nbsp;&nbsp;</td>
					<td><select name="group_type" id="group_type" onChange="clearGroupDetail();"><%=bean.getGroup_type_List()%></select></td>
					<td  class="label"><fmt:message key="Common.Group.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td class="label"><input type='text' name="description" id="description" value="" maxLength='15' size='15' <%=disabled%> ><input type='button' class='BUTTON' value='?' onClick="searchGroupCode(group_code, description);"  name="group_search" id="group_search" ><input type='hidden' name="group_code" id="group_code" ></td>
					<td class=label ><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/>&nbsp;&nbsp;</td>
					<td class=label><input class="number" maxLength=15 size=15 name="tray_no" id="tray_no" value="" onKeyPress="return isValidInteger();"></td>
					<td class=label ><fmt:message key="eSS.OwnerStore.label" bundle="${ss_labels}"/>&nbsp;&nbsp;</td>
					<td class=label><select name="owner_store_code" id="owner_store_code" > <%=bean.getOwnerStores()%></select>&nbsp;</td>
				  </tr>
				  <tr>
					<td colspan='8'>&nbsp;</td>
				  </tr>
				  <tr>
					<td class=label ><fmt:message key="eSS.CurrentStore.label" bundle="${ss_labels}"/>&nbsp;&nbsp;</td>
					<td class=label ><select name="curr_store_code" id="curr_store_code" ><%=bean.getCurrentTRDStores()%></select>&nbsp;</td>
					<td  class="label" ><fmt:message key="Common.status.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td><select name="status" id="status"><%=bean.getStatus_List()%></select></td>
					<td class=label ><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td class=label><input type="text" maxLength=10 size=10 name="expiry_date" id="expiry_date" value= "" onBlur="CheckDate(this);">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('expiry_date');"></img></td>
					<td>&nbsp;</td>
					<td ><input type="button" value="Search" class="BUTTON" onClick="submitForm();"></td>
				  </tr>
				  <tr>
					<td colspan='8'>&nbsp;</td>
				  </tr>
			</table>
			<input type="hidden" name="locale" id="locale" value="<%=locale%>">
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE" id="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE" value="<%= bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE")%>">
			<input type="hidden" name="orderbycolumns" id="orderbycolumns" value="1">
		</form>
		<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

