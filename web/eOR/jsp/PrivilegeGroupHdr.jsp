<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>

<%@page  import="java.util.*, eOR.*, eOR.Common.*,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../js/PrivilegeGroup.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	String function_id	=	request.getParameter("function_id");
	String mode = request.getParameter("mode");
	String PRIV_GRP_ID = request.getParameter("PRIV_GRP_ID");
	String PRIV_GRP_DESC = request.getParameter("PRIV_GRP_DESC");
	String checked="checked";
	String EffStatus="E";
	if(PRIV_GRP_ID==null) PRIV_GRP_ID="";
	if(PRIV_GRP_DESC==null) PRIV_GRP_DESC="";
	String bean_id = "privilegegroupbean" ;
	String bean_name = "eOR.PrivilegeGroupBean";
	String disabled = "enabled";	
	PrivilegeGroupBean bean = (PrivilegeGroupBean)getBeanObject( bean_id,  bean_name, request ) ;  
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setLanguageId(localeName);
	bean.clearHashValues();
	if(mode==null) mode="1";
	//System.out.println("=="+mode+"==");
	bean.set_order_tab();
	if(mode.equals("1")) bean.clearUpdateValues();
	if(mode.equals("2")){
		disabled = "disabled";	
		bean.setValuesForUpdate(PRIV_GRP_ID.trim());
		bean.copyOnceUpdateValues();
		EffStatus=bean.getEff_status();
		//System.out.println("=EffStatus=="+EffStatus);
		if(EffStatus==null) EffStatus="D";
		if(EffStatus.equals("D"))
		checked="";
		//System.out.println("PRIV_GRP_ID"+PRIV_GRP_ID+"PRIV_GRP_DESC"+PRIV_GRP_DESC);
	}
	/*if(mode.equals("2")){
		exception_type = request.getParameter("exception_type");
		disabled = "disabled";	
		exception_type = exception_type.trim();
		if(exception_type.equals("OC"))
			oc_select = "selected";
		else if(exception_type.equals("OT"))
			ot_select = "selected";
		else if(exception_type.equals("OR"))
			or_select = "selected";
	}*/
	
	if(mode.equals("1")){
	%>
		<body onLoad="document.formPrivilegeGroupHdr.Privilege_id.focus()" onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<%}else if(mode.equals("2")){%>
		<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%}%>
<form name="formPrivilegeGroupHdr" id="formPrivilegeGroupHdr">
<table border="0" cellspacing="0" cellpadding="3" width="100%" height='100%' align="center">
<tr>
	<td class="label" width='27%' colspan='2'><fmt:message key="eOR.PrivilegeGroupID.label" bundle="${or_labels}"/></td>
	<td class="fields"  colspan='3'><input type="text" name="Privilege_id" id="Privilege_id" value='<%=PRIV_GRP_ID%>' size="10" maxlength="10" onBlur="ChangeUpperCase( this );" onKeyPress="return CheckForSpecChars(event);" <%=disabled%>><img src="../../eCommon/images/mandatory.gif" align=center></img></td></tr>
	<tr><td class="label" width='27%' colspan='2'><fmt:message key="eOR.PrivilegeGroupDescription.label" bundle="${or_labels}"/></td>
	<td class="fields"  colspan='3'><input type="text" name="Privilege_long_desc" id="Privilege_long_desc" value='<%=PRIV_GRP_DESC%>'  size="40" maxLength="30" onBlur="makeValidString(this);"><img src="../../eCommon/images/mandatory.gif" align=center></img></td>
	<tr><td class="label" width='27%' colspan='2'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td class="fields"  colspan='3'><input type="checkbox" name="eff_status" id="eff_status" value='<%=EffStatus%>' <%=checked%> onClick="change(this);">
</tr>
</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="eff_status_yn" id="eff_status_yn" value="<%=EffStatus%>">
<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
</form>
</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>

