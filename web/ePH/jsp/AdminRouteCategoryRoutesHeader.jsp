<!DOCTYPE html>
<%@page contentType="text/html; charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	ePH
*	Purpose 		:	
*	Created By		:	Abdul Sukkur
*	Created On		:	28 Oct 2009

--%>
<%-- JSP Page specific attributes start --%>
<%@page  import=" ePH.*, eCommon.Common.*,com.ehis.eslp.* " contentType="text/html; charset=UTF-8"%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, java.lang.*,webbeans.eCommon.*,eOR.Common.*" %>
<jsp:useBean id="AdminRouteCategoryRoutes" class="webbeans.eCommon.RecordSet" scope="session"/>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
<%
	  request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	  String locale=(String)session.getAttribute("LOCALE");
	String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
      	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
      	<script language='javascript' src='../../eCommon/js/common.js' ></script>
	    <script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
		<script language="JavaScript" src="../../ePH/js/AdminRouteCategoryRoutes.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
AdminRouteCategoryRoutes.clearAll();
String admin_route_categ_code=request.getParameter("admin_route_categ_code")== null ? "":request.getParameter("admin_route_categ_code");
%>
<body  onMouseDown="" onKeyDown="lockKey()" >
		<form name="form_AdminRouteCategoryRoutes" id="form_AdminRouteCategoryRoutes">
		<table border='0' cellspacing='0' cellpadding='0' align='center' width='102%'>
			<tr>
				<td  width="25%" class='label'><fmt:message key="ePH.AdminRouteCategory.label" bundle="${ph_labels}"/></td>
				<td>&nbsp;&nbsp;<input type=text name="short_desc" id="short_desc" value=""><input class='button' type=button name="route_categ_button" id="route_categ_button" value="?"  onClick='selectNature(short_desc);'>&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>						
					<input type="hidden" name="admin_route_categ_code" id="admin_route_categ_code" value="<%=admin_route_categ_code%>">
				    
				</td>
				<td></td>
			  </tr>			 			 
			<td width="25%"  class='label'><fmt:message key="ePH.AdminRouteDescription.label" bundle="${ph_labels}"/></td>
			<td>&nbsp;&nbsp;<input type='text' name='route_code_desc' id='route_code_desc' value='' size='50' maxlength='100' onchange='clearDetail();'>
			&nbsp;&nbsp;<select name='search_criteria' id='search_criteria' onchange='clearDetail();'>
								<option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
								<option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
								<option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
							</select>
			<td></td>
			
			</tr>			
					<tr>
						<td></td>
					<td></td>
				<td><input class='button' type=button name="search_button" id="search_button" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'  onClick='searchDetails()'></td>
			 </tr>
		 </table>
	 <input type="hidden" name="AchkAll" id="AchkAll" value="">
	 <input type="hidden" name="BchkAll" id="BchkAll" value="">
	 <input type="hidden" name="CchkAll" id="CchkAll" value="">
	 <input type="hidden" name="DchkAll" id="DchkAll" value="">
	 <input type="hidden" name="EchkAll" id="EchkAll" value="">
	 <input type="hidden" name="FchkAll" id="FchkAll" value="">
	 <input type="hidden" name="GchkAll" id="GchkAll" value="">
	 <input type="hidden" name="HchkAll" id="HchkAll" value="">
	 <input type="hidden" name="IchkAll" id="IchkAll" value="">
	 <input type="hidden" name="JchkAll" id="JchkAll" value="">
	 <input type="hidden" name="KchkAll" id="KchkAll" value="">
	 <input type="hidden" name="LchkAll" id="LchkAll" value="">
	 <input type="hidden" name="MchkAll" id="MchkAll" value="">
	 <input type="hidden" name="NchkAll" id="NchkAll" value="">
	 <input type="hidden" name="OchkAll" id="OchkAll" value="">
	 <input type="hidden" name="PchkAll" id="PchkAll" value="">
	 <input type="hidden" name="QchkAll" id="QchkAll" value="">
	 <input type="hidden" name="RchkAll" id="RchkAll" value="">
	 <input type="hidden" name="SchkAll" id="SchkAll" value="">
	 <input type="hidden" name="TchkAll" id="TchkAll" value="">
	 <input type="hidden" name="UchkAll" id="UchkAll" value="">
	 <input type="hidden" name="VchkAll" id="VchkAll" value="">
	 <input type="hidden" name="WchkAll" id="WchkAll" value="">
	 <input type="hidden" name="XchkAll" id="XchkAll" value="">
	 <input type="hidden" name="YchkAll" id="YchkAll" value="">
	 <input type="hidden" name="ZchkAll" id="ZchkAll" value="">
	 <input type="hidden" name="_chkAll" id="_chkAll" value="">
	 <input type="hidden" name="AssociatedchkAll" id="AssociatedchkAll" value="Y">
	 <input type="hidden" name="locale" id="locale" value="<%=locale%>">
  </form>
  <script>
document.forms[0].short_desc.focus();</script><!-- /**
 * @Name - Sandhya A 
 * @Date - 18/12/2009
 * @Inc# - IN016185 (online help)
 * @Desc - set focus to the admin route category lookup text.
 */ -->
 </body>
</html>

