<!DOCTYPE html>
<%--
*	Copyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:	
*	Created By		:	Janet George
*	Created On		:	6 Jan 2005

--%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eMR.*, eCommon.Common.*,com.ehis.eslp.* " %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  	
  <script src="../js/TermSetCritforPatientClass.js" language="javascript"></script>
  <script language="JavaScript" src="../../eOR/js/OrMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown='lockKey()'>
 <%
  
	  Connection con 	      = null;
	  PreparedStatement pstmt	      = null;
	  ResultSet rs		      = null;
try
   {
     con = ConnectionManager.getConnection(request);
	 %>
		<form name="form_add_mod" id="form_add_mod">
		 	<table border='0' cellpadding='5' cellspacing='0' align='center' width="90%">
			    <tr>
				<td class="label" width="20%"><fmt:message key="Common.criteria.label" bundle="${common_labels}"/></td>
				<td class="fields" width="60%">
				<select name="criteria_val" id="criteria_val" onChange='PopulateVal(this);'>
				<option value="" selected>----------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----------</option>
				<option value='Accuracy' ><fmt:message key="Common.Accuracy.label" bundle="${common_labels}"/>
				<option value='Encounter_stage' ><fmt:message key="Common.encounter.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Stage.label" bundle="${common_labels}"/>
				<option value='Nature' ><fmt:message key="Common.Nature.label" bundle="${common_labels}"/>
				<option value='Priority' ><fmt:message key="Common.priority.label" bundle="${common_labels}"/>
				<%
					/*String accuracy ="";
					 accuracy = "Select accuracy_code ,long_desc from mr_accuracy where eff_status = 'E' order by long_desc";
					pstmt =con.prepareStatement(accuracy);
					rs = pstmt.executeQuery( );
					while(rs!=null  && rs.next())
					 {
						out.println("<option value='"+rs.getString(1)+"'>"+rs.getString(2)+""); 
					 }*/
				%>
				</select><img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td>
				<td class="padding" width="20%"></td>
			  </tr>
			  <tr>
				<td class="label" width="20%"><fmt:message key="eMR.ListValue.label" bundle="${mr_labels}"/></td>
				<td class="fields" width="60%">
				<select name="listValue" id="listValue" onChange='addListitem(this);'>
				<option value="" >----------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----------</option>
				</select><img src='../../eCommon/images/mandatory.gif'align='center'></img>
				
				<select name="listValue1"  onChange="clearResult();" id='img1' style='visibility:hidden'>
				<option value="">----------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----------</option></select>				
				</td>
				<td class='button' width='20%'><input type=button class=button value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onclick='searchDetails()'></td>
				</tr>

			</table>	

			
	  </form>
 <%}catch(Exception e)
	{
		//out.println("Error is ---"+e);
		e.printStackTrace();
	}
finally
  {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			ConnectionManager.returnConnection(con,request);
  }
%>
</body>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>


