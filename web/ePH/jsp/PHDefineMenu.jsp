<!DOCTYPE html>
<!--
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
21/06/2021		TFS-15609         Prabha          	MO-CRF-20169
---------------------------------------------------------------------------------------------------------------
*/ --> 
<%@ page contentType="text/html;charset=UTF-8" import =" ePH.*, ePH.Common.* , eCommon.Common.*, java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %> <!-- Modified for MO-CRF-20169 -->
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="ePH.PharmacistMenu.label" bundle="${ph_labels}"/></title>
	<%
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale			=		(String)session.getAttribute("LOCALE");
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
		<script language="javascript" src="../../eCommon/js/common.js" ></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js" ></script>
		<script language="javascript" src='../../ePH/js/PHDefineMenu.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%
	//Added for MO-CRF-20169 -Start
Connection conn=null;
	try {		
		conn = ConnectionManager.getConnection(request);
		boolean site = eCommon.Common.CommonBean.isSiteSpecific(conn, "ST","ST_PHIS_INV_HOMEPAGE");
	
	//Added for MO-CRF-20169 -End
		
	String	bean_id					=		"pHDefineMenuBean";
	String  bean_name				=		"ePH.PHDefineMenuBean";

	PHDefineMenuBean bean		=		(PHDefineMenuBean)getBeanObject( bean_id,bean_name,request ) ;
	bean.setLanguageId(locale);
	bean.clear() ;

	ServletContext context =		getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);


	String user_id="" ,user_name = "",mode="" ;
	String enabled_checked="checked", effStatus="E", modify_mode_dis="";
	String disabled="";

	mode = (request.getParameter("mode")==null)?"":request.getParameter("mode");

	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals((String) CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals( (String)CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
		return ;
	
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	user_id		= (request.getParameter("user_id")==null)?"":request.getParameter("user_id").trim();
	user_name   = (request.getParameter("user_name")==null)?"":request.getParameter("user_name").trim();

	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){	
		bean.setUser_Id(user_id);
		bean.loadData() ;
		modify_mode_dis		= " disabled ";
		effStatus = bean.getEffStatus();
		if(effStatus.equals("E"))	{
			enabled_checked			=	" CHECKED ";
		}
		else{
			enabled_checked			=	"";
			disabled				=	" disabled ";
		}
	}
	
	ArrayList desktopList = new ArrayList(); //Added for MO-CRF-20169
	
	if(site){
		desktopList = bean.getDesktopListNew();   //Added for MO-CRF-20169
	}else
	{
		 desktopList = bean.getDesktopList();  //Modified for MO-CRF-20169
	}
%>
	</head>
	<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="FocusFirstElement()" >
		<form name="formPHDefineMenu" id="formPHDefineMenu">
			<br><br><br><br><br><br><br>
			<table border=0 cellpadding=3 cellspacing=0 width='75%' align=center >
				
				<tr>
					<td class='label' ><fmt:message key="Common.user.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type="text" name="user_name" id="user_name" value="<%=user_name%>" size=30 maxLength=60  onkeypress="return CheckForSpecChars(event)" <%=disabled%> <%=modify_mode_dis%> onblur="searchCode(this);"><input type="button" class="button" name="userIdSearch" id="userIdSearch" value="?" onClick="searchCode(user_name)" align="left" <%=modify_mode_dis%>>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img><input type="hidden" name="user_id" id="user_id" value="<%=bean.getUser_Id()%>"></td>
				</tr>
				 <tr>
					<td class='label' ><fmt:message key="ePH.DesktopId.label" bundle="${ph_labels}"/></td>
					<td class='fields'>
						<select name="desktop_id" id="desktop_id" <%=disabled%> onchange='defDesc(this)'>
							<option value='' selected>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
							<%=bean.getListOptionTag(desktopList, bean.getDesktop_id())%>
						</select>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</td>
				</tr>
				<tr>
					<td class='label' ><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type="text" name="desktop_desc" id="desktop_desc" value="<%=bean.getDesktop_desc()%>" size='30' maxlength='30' onkeypress="return CheckSpecChar(event)" <%=disabled%>><img src='../../eCommon/images/mandatory.gif'></img></td>
				</tr>
				
				<tr>
					<td class='label' ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type="checkbox" name="eff_status" id="eff_status" onclick="func_enable_check()" value="<%=effStatus%>" <%=enabled_checked%> >
				</tr>	

			</table>
			<input type='hidden' name="bean_id" id="bean_id"		value="<%=bean_id%>"></input>
			<input type='hidden' name="bean_name" id="bean_name"   value="<%=bean_name%>"></input>
			<input type='hidden' name="mode" id="mode"		value="<%=mode%>"></input>
			<input type='hidden' name="language_id" id="language_id"	value="<%=locale%>"></input>
			<input type='hidden' name="SQL_ST_USER_LOOKUP_USERACCESS" id="SQL_ST_USER_LOOKUP_USERACCESS"		value="<%=PhRepository.getPhKeyValue("SQL_ST_USER_LOOKUP_USERACCESS")%>"></input>
		 </form>
	 </body>
<%
	putObjectInBean(bean_id,bean,request);
//Added for MO-CRF-20169 -Start
}catch(Exception e){
	e.printStackTrace();
	out.println(e);
}
finally { 
	
	ConnectionManager.returnConnection(conn,request);
}
//Added for MO-CRF-20169 - End
%>
</html>

