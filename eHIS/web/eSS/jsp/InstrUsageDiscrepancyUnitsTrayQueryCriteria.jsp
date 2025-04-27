<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import=" eSS.*,eSS.Common.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page import="eSS.TrayNoSearchBean" %>
<html>
	<head>
 <%
			 request.setCharacterEncoding("UTF-8");
			String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 %>
	    <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/InstrUsageDiscrepancyUnits.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<body onLoad='FocusFirstElement();'>
	<%
		String store_code			=		request.getParameter("store_code");
		String group_code			=		request.getParameter("group_code");
		String group_desc			=		request.getParameter("group_desc");
		String tray_no				=		request.getParameter("tray_no");
		String disabled				=		"disabled";
		TrayNoSearchBean bean		=		(TrayNoSearchBean) getBeanObject( "trayNoSearchBean",  "eSS.TrayNoSearchBean",request);  
		bean.clear();
		bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
		
		if(store_code!=null){
			bean.setStore_code_list(store_code);
			bean.setStore_code(store_code);
			
		}
	%>
		<form name="formInstrUsageDiscrepancyUnitsTrayQueryCriteria" id="formInstrUsageDiscrepancyUnitsTrayQueryCriteria" action="../../eSS/jsp/InstrUsageDiscrepancyUnitsTrayQueryResult.jsp" method="post" target="frameInstrUsageDiscrepancyUnitsTrayQueryResult" onreset="FocusFirstElement();">
			<table border="0" cellpadding="1" cellspacing="0" width='100%' height='100%' align='center'>
				<tr>
					<td class="label"><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<input name="group_desc" id="group_desc" maxLength='15' size='15' readOnly value="<%=group_desc%>" <%=disabled%>><input type="hidden" value="<%=group_code%>" name="group_code"><input type="button" class="BUTTON" value='?' onClick="searchGroupCode(group_code, group_desc);" <%=disabled%>></td>
					<td class="label"><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="tray_no" id="tray_no" value="<%=bean.checkForNull(tray_no)%>" size='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' maxLength='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' class="NUMBER" onKeyPress="return isValidInteger();"></td>
					<td class="label"><fmt:message key="eSS.CurrentStore.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<select name="owner_store_code" id="owner_store_code" <%=(store_code==null)?"":"disabled"%>><%=bean.getStore_code_List()%></select></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="eSS.BinLocation.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<select name="bin_location_code" id="bin_location_code" >
						<%
						if(store_code==null)
							out.println(bean.getSsRepositoryValue("DEFAULT_LIST_OPTION"));
						else
							out.println(bean.getBinLocations());
						%>
							</select>
							</td>
					<td class="label"><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="expiry_date" id="expiry_date" value="" size='10' maxLength='10' onBlur="CheckDate(this);">
							</td>
 					<td  class="label"> </td>
					<td class="label">&nbsp;<input type='submit' class='Button' value='Search' name='search' id='search'></td>
				</tr>
			</table>
			<br>
			<input type="hidden" name="function_id" id="function_id"			value="<%=request.getParameter("function_id")%>">
			<input type="hidden" name="orderbycolumns" id="orderbycolumns"	    value="group_code,tray_no">
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP" id="SQL_SS_GROUP_LOOKUP" value="<%= bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP")%>">
			<input type="hidden" name="store_code" id="store_code"			value="<%=store_code%>">

	</form>
	</body>
</html>
<%
	putObjectInBean( "trayNoSearchBean",  bean,request);
%>

