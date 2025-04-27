<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Latha
*	Created On		:	27 Jan 2005

--%>

<%@page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.*, java.util.*, eRS.*,eCommon.Common.*" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
 <script language='javascript' src='../../eCommon/js/common.js'></script>
 <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<!--   <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script>
 -->  <script src="../js/LocnForWorkplace.js" language="javascript"></script>
  <script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
String facility_id=(String)session.getValue("facility_id");
%>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
 
		<form name="form_add_mod" id="form_add_mod">
			<table border='0' cellpadding='0' cellspacing='0' align='center' width="100%">
			 <tr><td colspan="4">&nbsp</td></tr>
			 <tr>
				<td align=right class="label"><fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/>&nbsp;</td>
					<td><input type=text name="workplace_desc" id="workplace_desc" value=""  readonly onBlur='populateworkplace(this.form)'><input class='button' type=button name="workplace_desc_button" id="workplace_desc_button" value="?"  onClick='viewworkplace(workplace_desc);populateworkplace(this.form);'>
				    <img src='../../eCommon/images/mandatory.gif'align='center'></img>
					<input type="hidden" name="workplace_code" id="workplace_code" value="">			
				</td>
			</tr>
            <tr>
				<td align="right" class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>&nbsp;</td>
				<td  class="label" >
				<select name="location_code" id="location_code" onchange='changeTerminology();'>
				<option value="" selected> &nbsp&nbsp------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------- </option>
				</select>
			    <img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type=button class=button value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'onclick='searchDetails()'>&nbsp;&nbsp;&nbsp;</td>
		    </tr>

			<tr><td colspan="4">&nbsp</td></tr>
		  </table>	
		  	<input type="hidden" name="facility_id" id="facility_id" value='<%=facility_id%>'>
		  	<input type="hidden" name="locale" id="locale" value='<%=locale%>'>
	  </form>
</body>
</html>

