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
<%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*, eSS.Common.*,java.sql.*,webbeans.eCommon.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/TrayDiscrepancy.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<%
	String mode;
	String bean_id;
	String bean_name;

	mode						=		request.getParameter( "mode" ) ;
	bean_id						=		"trayDiscrepancyBean" ;
	bean_name					=		"eSS.TrayDiscrepancyBean";

	if ((mode == null) || (mode.equals(""))) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
	TrayDiscrepancyBean bean = (TrayDiscrepancyBean) getBeanObject( bean_id,  bean_name,request );
	bean.clear() ;
	bean.setFunctionId(request.getParameter("function_id"));
	bean.setMode(mode) ;
	bean.setLanguageId(locale) ;
	bean.setSession(session) ;
	Connection con			= null;//MMOH-CRF-1661 START
	boolean linen_applicable_yn =false;
	try{
		con				= ConnectionManager.getConnection(request);
		linen_applicable_yn = eCommon.Common.CommonBean.isSiteSpecific(con,"SS", "SS_GROUP_TYPE_LINEN"); 
		if(linen_applicable_yn){
			bean.setLinen_applicable_yn("Y");
		}else{
			bean.setLinen_applicable_yn("N");    
		}
	}
	catch(Exception e){
		e.printStackTrace();
		System.out.println("Exception in TrayDiscrepancyHeader.jsp");  
	}
	finally{
		if(con != null)
    		ConnectionManager.returnConnection(con,request);
	}//end 
%>
	<body onload="FocusFirstElement();" onMouseDown="CodeArrest()">
		<form name="formTrayDiscrepancyHeader" id="formTrayDiscrepancyHeader"onReset="FocusFirstElement();">
			<table border="0" cellpadding="0" cellspacing="0" width='100%' height='100%' align='center'>
				<tr>
					<td  class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<select name="store_code" id="store_code">
						<%=bean.getStore_code_List()%>
					</select><%=bean.getMandatoryImageTag()%></td>
					<td  class="label" ><fmt:message key="eSS.GroupType.label" bundle="${ss_labels}"/></td>
					<td>&nbsp;&nbsp;<select name="group_type" id="group_type">
						<%=bean.getGroup_type_List()%>
					</select></td>
					<td  class="label"><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
					<td >&nbsp;&nbsp;<input type='text' name="group_desc" id="group_desc" value="<%=bean.getGroup_desc()%>" maxLength='15' size='15'><input type='button' class='BUTTON' value='?' onClick="searchGroupCode(group_code, group_desc);"  name="group_search" id="group_search" ><%=bean.getMandatoryImageTag()%><a style = "CURSOR:DEFAULT" href='javascript:details();'  disabled id='details' name='details'><fmt:message key="Common.details.label" bundle="${common_labels}"/>&nbsp&nbsp</a></td>
					<td  class="label"><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></td>
					<td>&nbsp;&nbsp;<input type="text" value="<%=bean.getTray_no()%>" name="tray_no" class='NUMBER' onKeyPress="return isValidInteger();" size="<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" maxLength="<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>" onBlur="checkTrayNo(this);" ><input type="button" class="BUTTON" value="?" onClick="searchTrayNo();" name="tray_search" id="tray_search" ><%=bean.getMandatoryImageTag()%></td>
				</tr>			
			</table>
			<input type="hidden" name="records_to_delete" id="records_to_delete"		value="">
			<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
			<input type="hidden" name="locale" id="locale"					value="<%=locale%>">
			<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"				value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id"				value="<%= bean.getFunctionId() %>">
			<input type="hidden" name="group_code" id="group_code"				value="<%=bean.getGroup_code()%>">
			<input type="hidden" name="params" id="params"				value="<%=request.getQueryString()%>"><!--  //Added for KDAH-SCF-0329 [IN:057314] -->
			<!--<input type="hidden" name="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE" id="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE" value="<%= bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE")%>">-->
			<!-- Added by Sakti against SCF inc#42391 -->
			<input type="hidden" name="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_FOR_TRAYDISCREPENCY" id="SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_FOR_TRAYDISCREPENCY" value="<%= bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP_BASED_ON_TYPE_FOR_TRAYDISCREPENCY")%>">
		</form>
	<%
	putObjectInBean(bean_id,bean,request);
	%>
	</body>
</html>

