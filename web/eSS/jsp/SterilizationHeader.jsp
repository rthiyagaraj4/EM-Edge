<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
		
		<% 
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SterilizationCost.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest();" >
<jsp:useBean id="bean" scope="page" class="eSS.SterilizationCostBean"/>
<%
String bean_id					= "sterilizationCostBean" ;
String bean_name				= "eSS.SterilizationCostBean";
String mode				=	"";
String facility_id				= (String)session.getValue( "facility_id" );
//String group_code		=	request.getParameter( "group_code" )==null?"": request.getParameter( "group_code" );
//String sterile_type		=	request.getParameter( "sterile_type" )==null?"": request.getParameter( "sterile_type" );
String codeDisabled		=	"";

String from_source	= request.getParameter( "from_source" )==null?"":request.getParameter( "from_source" );
mode	= request.getParameter( "mode" )==null?"": request.getParameter( "mode" );
// SterilizationCostBean bean = (SterilizationCostBean)getBeanObject( bean_id, bean_name, request ) ;
//SterilizationCostBean bean = (SterilizationCostBean)mh.getBeanObject( bean_id, request,  bean_name ) ;  
bean.clear() ;
bean.setMode( mode ) ;
bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")==null?"":request.getParameter("function_id")));	

//HashMap dataList=null;

%>
<form name="sterilization_header" id="sterilization_header" >
  <table border="0" cellpadding="0" cellspacing="0" width="70%" align="center">
	<tr><td colspan="2"></td></tr><br>

		 <tr>
				<td align="right" class="label" width="30%"> <fmt:message key="Common.Group.label" bundle="${common_labels}"/> </td>
				<td class="label">&nbsp;&nbsp;<input type='text' name="group_desc" id="group_desc" value="<%=bean.getGroup_desc()%>" maxLength='15' size='15' <%=codeDisabled%> ><input type='button' class='BUTTON' value='?' onClick="searchCode(group_code, group_desc);" <%=codeDisabled%> name="group_search"><%=bean.getMandatoryImageTag()%><input type="hidden" name="group_code" id="group_code" value="<%=bean.getGroup_code()%>"></td>
			</tr>
	 <script>document.sterilization_header.group_desc.focus();</script>
	
	<tr>
		<td colspan="2"></td></tr><tr><td colspan="2"></td></tr><tr><td colspan="2"></td>
	</tr>
  </table>
  <input type="hidden" value="<%=from_source%>" name="from_source">
  <input type="hidden" value="<%=mode%>" name="mode">
  
  <input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
  <input type="hidden" name="locale" id="locale" value="<%=locale%>">
  <input type="hidden" name="SQL_SS_GROUP_LOOKUP" id="SQL_SS_GROUP_LOOKUP" value="<%= bean.getSsRepositoryValue("SQL_SS_GROUP_LOOKUP")%>">
 <input type="hidden" name="select_val" id="select_val" value="0">
 <input type="hidden" name="delete_val" id="delete_val" value="0">
 </form>
</body>
<% putObjectInBean(bean_id,bean,request);%>
</html>

