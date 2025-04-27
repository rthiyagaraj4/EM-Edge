<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@ page import ="eSS.*, eSS.Common.* ,java.util.*,java.sql.*, eCommon.Common.*,java.util.Properties,java.util.ArrayList,java.util.Hashtable,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
04/07/2021		TFS19249		 Shazana		ML-MMOH-CRF-1661-US001
---------------------------------------------------------------------------------------------------------------
*/ %> 
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
	<head>
		<title> </title>

		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Suri">
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/AlternateGroup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
    	<script language="javascript" src="../../eSS/js/SsTransaction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onload="FocusFirstElement();"  onMouseDown="CodeArrest()">
<%
	String codeDisabled			=	"";
	String mode					=	"";
	String bean_id				=	"";
	String bean_name			=	"";
	mode						=	request.getParameter( "mode" ) ;
	bean_id						=	"AlternateGroupBean" ;
	bean_name					=	"eSS.AlternateGroupBean";


	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	AlternateGroupBean bean = (AlternateGroupBean) getBeanObject( bean_id,  bean_name, request ) ;  
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setSession( session) ;
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
		// System.out.println("Exception in AlternateGroupAddModify.jsp..");  
	}
	finally{
		if(con != null)
    		ConnectionManager.returnConnection(con,request);
	}
	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		codeDisabled	= "disabled";
		if (null == request.getParameter( "group_code" ) )
			return;		
		bean.setGroup_code(request.getParameter( "group_code" )) ;
	}

%>
		<form name="formAlternateGroup" id="formAlternateGroup" onReset="FocusFirstElement();">
			<table border="0" cellpadding="1" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
				<td  class="label" ><fmt:message key="eSS.GroupType.label" bundle="${ss_labels}"/></td>
				<td>&nbsp;&nbsp;<select name="group_type" id="group_type" <%=codeDisabled%> onBlur="clearGroup()">
					<%=bean.getGroup_type_List()%>  
				</select></td>
				<td class="label"><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type='text' name="group_desc" id="group_desc" value="<%=bean.getGroup_desc()%>" maxLength='15' size='15' <%=codeDisabled%> ><input type='button' class='BUTTON' value='?' onClick="searchGroupCode(group_code, group_desc);" <%=codeDisabled%> name="group_search"><%=bean.getMandatoryImageTag()%><input type="hidden" name="group_code" id="group_code" value="">
				</td>
			</tr>
					<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
			<tr>
				<td  class="label" ><fmt:message key="eSS.UsageType.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;&nbsp;<select name="usage_desc" id="usage_desc" >
				<%=bean.getUsage_List()%>
				</select></td>

				<td  class="label"><fmt:message key="eSS.SurgeryType.label" bundle="${ss_labels}"/></td>
				<td class="label">&nbsp;&nbsp;<select name="surgery_type" id="surgery_type" >
				<%=bean.getSurgery_List()%>
				</select></td>
				
			</tr>
			<tr>
				<td  colspan=3>&nbsp;</td>
				
				<td class="label" align=right>&nbsp;&nbsp;<input type='button' class='BUTTON' value='Search'  onClick="popAlternateGroups(group_code, group_desc);"  name="Alternategroup_search" id="Alternategroup_search">
				</td>
			</tr>
			</table>
			<input type="hidden" name="mode" id="mode"		value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"		value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"	value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">

			<input type="hidden" name="records_to_delete" id="records_to_delete" value="">
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE" id="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE" value="<%= bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_FOR_ALTERNATE")%>">
			<input type="hidden" name="locale" id="locale" value="<%=locale%>">
			<input type="hidden" name="total_delete" id="total_delete"		value="0">
			<input type="hidden" name="total_select" id="total_select"		value="0">
		</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

