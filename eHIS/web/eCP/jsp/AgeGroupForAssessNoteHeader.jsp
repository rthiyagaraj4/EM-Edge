<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Sreenivasulu.Y
*	Created On		:	10 Jan 2005

--%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
  <!-- <link rel='stylesheet' type='text/css' href ='../../eCommon/html/IeStyle.css'> </link> -->
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
    <script src="../../eCP/js/AgeGroupForAssessNote.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" > <%
 try
   {
	 %>
		<form name="form_add_mod" id="form_add_mod">
			<table border='0' cellpadding='0' cellspacing='0' align='center' width="100%">
			  <tr><td colspan="5">&nbsp</td></tr>
			    <tr>
					<td width="25%"  align=right class="label"><fmt:message key="eCP.AssessmentNote.label" bundle="${cp_labels}"/></td>
					<td>&nbsp;<input type=text name="assess_note_desc" id="assess_note_desc" value=""  readonly onChange='clearDetail()' onBlur=''><input class='button' type=button name="assess_note_button" id="assess_note_button" value="?"  onClick='viewAssessNote(assess_note_desc);clearDetail()' >
				    <img src='../../eCommon/images/mandatory.gif'align='center'></img>
					<input type="hidden" name="assess_note_id" id="assess_note_id" value="" >				
				<td colspan="2" align="right"><input type=button class=button value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick='searchDetails()'>&nbsp;&nbsp;&nbsp;</td>
			  </tr>
			 <tr><td colspan="5">&nbsp</td></tr>
		  </table>	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	  </form>
 <%}catch(Exception e)
	{
		//out.println("Error is ---"+e);//COMMON-ICN-0181
                  e.printStackTrace();//COMMON-ICN-0181
	}
finally
  {
			
  }
%>
</body>
</html>

