<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ page import="eSS.TrayNoSearchBean" %>
<%@page contentType="text/html;charset=UTF-8"  import="eSS.*, eSS.Common.* , eCommon.Common.*,java.util.*" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/PhyInvEntry.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onLoad='FocusFirstElement();' onMouseDown='CodeArrest();'>
	<%
		String store_code		=	request.getParameter("store_code");
		String group_code		=	request.getParameter("group_code");
		String group_desc		=	request.getParameter("group_desc");
		String tray_no			=	request.getParameter("tray_no");
		String current_store_code = request.getParameter("current_store_code");
		String phy_inv_id		=	request.getParameter("phy_inv_id");

		String disabled			=		"disabled";
		TrayNoSearchBean bean	=		(TrayNoSearchBean)getBeanObject( "trayNoSearchBean", "eSS.TrayNoSearchBean",request );  
		bean.clear();
		bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
		if(store_code!=null){
			bean.setStore_code(store_code);
			bean.setStore_code_list(current_store_code);
		}
	%>
		<form name="formPhyInvEntryTrayQueryCriteria" id="formPhyInvEntryTrayQueryCriteria" action="../../eSS/jsp/PhyInvEntryTrayQueryResult.jsp" method="post" target="framePhyInvEntryTrayQueryResult" onreset="FocusFirstElement();">
			<table border="0" cellpadding="1" cellspacing="0" width='100%' height='100%' align='center'>
				<tr>
					<td align="right" class="label"><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<input name="group_desc" id="group_desc" maxLength='15' size='15' readOnly value="<%=group_desc%>" <%=disabled%>><input type="hidden" value="<%=group_code%>" name="group_code"><input type="button" class="BUTTON" value='?' onClick="searchGroupCode(group_code, group_desc);" <%=disabled%>></td>
					<td align="right" class="label">Owner Store</td>
					<td class="label">&nbsp;<select name="store_code_disp" id="store_code_disp" <%=(store_code==null)?"":"disabled"%>><%=bean.getStore_codes()%></select></td>
					<td align="right" class="label">Current Store</td>
					<td class="label">&nbsp;<select name="current_store_code_disp" id="current_store_code_disp" <%=(store_code==null)?"":"disabled"%>><%=bean.getStore_code_List()%></select></td>
				</tr>
				<tr>
					<td align="right" class="label">Tray No</td>
					<td class="label">&nbsp;<input type='text' name="tray_no" id="tray_no" value="<%=bean.checkForNull(tray_no)%>" size='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' maxLength='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' class="NUMBER" onKeyPress="return isValidInteger();"></td>
					<td align="right" class="label">Bin Location</td>
					<td class="label">&nbsp;<select name="bin_location_code" id="bin_location_code" >
						<%
						if(store_code==null)
							out.println(bean.getSsRepositoryValue("DEFAULT_LIST_OPTION"));
						else
							out.println(bean.getBinLocations());
						%></select>
					</td>
 					<td align="right" class="label"> </td>
					<td class="label">&nbsp;<input type='submit' class='Button' value='Search' name='search' id='search'></td>
				</tr>
			</table>
			<br>
			<input type="hidden" name="function_id" id="function_id" value="<%=request.getParameter("function_id")%>">
			<input type="hidden" name="orderbycolumns" id="orderbycolumns" value=" dtl.bin_location_code, dtl.group_code, tray_no">
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP" id="SQL_SS_GROUP_LOOKUP" value="<%= bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP")%>">
			<input type="hidden" name="store_code" id="store_code" value="<%=store_code%>">
			<input type="hidden" name="current_store_code" id="current_store_code" value="<%=current_store_code%>">
			<input type="hidden" name="phy_inv_id" id="phy_inv_id" value="<%=phy_inv_id%>">
	</form>
	<%
putObjectInBean("trayNoSearchBean",bean,request);
%>
	</body>
</html>

