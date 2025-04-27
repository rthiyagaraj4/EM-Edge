<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<jsp:useBean id="dispatchList" scope="session" class="java.util.ArrayList"/>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Sudha Krishnadasar">
<%
			request.setCharacterEncoding("UTF-8");
			String locale			= (String)session.getAttribute("LOCALE");
			String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/Dispatch.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<body>
<%
	DispatchListBean bean = (DispatchListBean)getBeanObject( "DispatchListBean", "eSS.DispatchListBean",request );  
	
	bean.clear();
	
	String disabled			=	"";
	String index			=	bean.checkForNull(request.getParameter("index"),"-1");
	if(!index.equals("-1"))
		bean.initialize((HashMap)dispatchList.get(Integer.parseInt(index)));
	else	
		disabled="disabled";

		String sys_date		=	bean.getSystemDate();

%>
	<body onLoad="FocusFirstElement();"onMouseDown='CodeArrest();'>
		<form name="formDispatchDetail" id="formDispatchDetail" >
			<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
			<td width='100%' height='100%' align='center' valign='top'>
			<table border="0" cellpadding="3" cellspacing="0" width='100%' align='center'>
				<tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<input type='text' name="group_desc" id="group_desc" disabled value="<%=bean.getGroup_desc()%>" maxLength='15' size='15' readOnly ><input type='button' class='BUTTON' value='?' name="group_search" id="group_search" disabled ><input type="hidden" name="group_code" id="group_code" value="<%=bean.getGroup_code()%>"></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></td>
					<td>&nbsp;&nbsp;<input type='text' class="NUMBER" name="tray_no" id="tray_no" value="<%=bean.getTray_no()%>" maxLength='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' size='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' onKeyPress="return isValidInteger();"  disabled onBlur="searchTrayDetail();"><input type='button' class='BUTTON' value='?' onClick="searchTrayNo();"  name="tray_search" id="tray_search" disabled></td>
				</tr>
				
				<tr>
					<td  class="label"><fmt:message key="eSS.DispatchDate.label" bundle="${ss_labels}"/></td>
					<td>&nbsp;&nbsp;<input type='text' name="dispatch_date" id="dispatch_date" value="<%=com.ehis.util.DateUtils.convertDate(bean.getDispatch_date(),"DMY","en",locale)%>" maxLength="10" size="10" <%=disabled%> onBlur="CheckDate(this);">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dispatch_date');"></img><img src="../../eCommon/images/mandatory.gif" align=center></td>
				</tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				</tr>
				<tr>
					<td  class="label" colspan='2'>
						<input type='button' class='BUTTON' name="apply" id="apply" onClick="addToList();" value="Modify" <%=disabled%>>
						<input type='button' class='BUTTON' name="cancel" id="cancel" onClick="resetDetail();" value="Cancel" <%=disabled%>>					
					</td>
				</tr>
				
				<tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				</tr>
			</table>
			</td>
			</tr>
			</table>
			<input type='hidden' name="index" id="index"				value="<%=index%>">
			<input type='hidden' name="locale" id="locale"				value="<%=locale%>">
			<input type='hidden' name="sys_date" id="sys_date"			value="<%=sys_date%>">
			<input type='hidden' name="function_id" id="function_id"			value="<%=request.getParameter("function_id")%>">
			<input type="hidden" name="SQL_SS_ITEM_LOOKUP" id="SQL_SS_ITEM_LOOKUP"  value="<%= bean.getSsRepositoryValue("SQL_SS_ITEM_LOOKUP")%>">

		</form>
	</body>
</html>
<%
	putObjectInBean("DispatchListBean",bean,request);
%>

