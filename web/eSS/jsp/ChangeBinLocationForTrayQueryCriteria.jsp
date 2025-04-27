<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8" import=" eSS.ChangeBinLocationForTrayBean" %>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
	
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";



%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsTransaction.js"></script>
		<script language="javascript" src="../../eSS/js/ChangeBinLocationForTray.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	 <%
		String mode			 =		request.getParameter("mode");
		if (mode != null) {
			mode		= mode.trim();
		}
		String bean_id		=		"changeBinLocationForTrayBean";
		String bean_name	=		 "eSS.ChangeBinLocationForTrayBean";
		String function_id	=		request.getParameter("function_id");

		ChangeBinLocationForTrayBean bean = (ChangeBinLocationForTrayBean) getBeanObject( bean_id,  bean_name, request);  
	
		bean.clear();
		bean.setLanguageId(locale);
		bean.setMode(mode);
		bean.setFunctionId(function_id);
	
	%> 
	<body onLoad="addBinLocationData(document.forms[0].owner_store_code)" onMouseDown='CodeArrest();' >
		<form name="formChangeBinLocationForTrayQueryCriteria" id="formChangeBinLocationForTrayQueryCriteria"  onReset="FocusFirstElement();" >
			<table border="0" cellpadding="1" cellspacing="0" width='100%' align='center' title="Query Criteria">
				<tr>
					<td class="label"><fmt:message key="eSS.Owner.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<select name="owner_store_code" id="owner_store_code" onBlur="addBinLocationData(this);loadBlank();"><%=bean.getOwnerStores()%></select></td>
					<td  class="label"><fmt:message key="eSS.OldBinLocation.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<select name="bin_location_code" id="bin_location_code" onBlur="validateChangeBinLocBean(this);loadBlank();">
					<%=eSS.Common.SsRepository.getSsKeyValue("DEFAULT_LIST_OPTION")%></select></td>
					<td class="label"><fmt:message key="eSS.NewBinLocation.label" bundle="${ss_labels}"/></td>
					<td class="label" >&nbsp;<select name="new_bin_location_code" id="new_bin_location_code"  onBlur="validateChangeBinLocBean(this);" ><%=bean.getSsRepositoryValue("DEFAULT_LIST_OPTION")%></select></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<input type="text" name="group_desc" id="group_desc" maxLength="15" size="15"><input class=button onclick="searchCode(group_code,group_desc);" onBlur="loadBlank()" type="button" value="?">&nbsp;</td>
					<td  class="label"><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></td>
					<td class="label" colspan=3>&nbsp;<input type="text" name="tray_no" id="tray_no" 	size="12" maxLength="12" onKeyPress="return isValidNumber(this,event,12,0);"  onBlur="loadBlank()" class="NUMBER" onBlur="checkIntegerFormat(this);"></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<select name="doc_type_code" id="doc_type_code" onBlur="loadBlank()"><%=bean.getDocTypes()%></select></td>
					<td  class="label"><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
					<td class="label" colspan=3>&nbsp;<input type='text' name="doc_no" id="doc_no" onBlur="loadBlank()" value="" size='8' maxLength='8' class="NUMBER" onKeyPress="return isValidInteger();" onBlur="return checkIntegerFormat(this);"></td>
					
				</tr>
				<tr>
				<td colspan='6' align='right'><input type='button'  class='BUTTON' name='previous' id='previous' value='Previous' disabled onClick='goPrev();'><input type='button' class='BUTTON' name='next' id='next' value='Next' onClick='goNext();' disabled><input type='button' class='Button' value='Search' name='search' id='search' onClick="return submitCriteria();"></td>
				</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id"			value="<%=bean_id%>">
			<input type="hidden" name="mode" id="mode"			value="<%=mode%>">
			<input type="hidden" name="bean_name" id="bean_name"		value="<%=bean_name%>">
			<input type="hidden" name="locale" id="locale"			value="<%=locale%>">
			<input type="hidden" name="group_code" id="group_code"				value="">
			<input type="hidden" name="new_bin_location_desc" id="new_bin_location_desc"	value="">
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP" id="SQL_SS_GROUP_LOOKUP"		value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_GROUP_LOOKUP")%>">
			<input type="hidden" name="function_id" id="function_id"				value="<%=bean.getFunctionId()%>">
			<script>
				submitCriteria();
			</script>
   		</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

