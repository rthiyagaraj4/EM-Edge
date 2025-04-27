<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:	
*	Created By		:	Sreenivasulu.Y
*	Created On		:	6 Dec 2004

--%>


<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eMR.*, eCommon.Common.*,com.ehis.eslp.*,java.sql.*,java.text.*,webbeans.eCommon.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  
  <script src="../js/TerminologySetForPractitioner.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
 <%
  
	  Connection con 	      = null;
	  PreparedStatement pstmt	      = null;
	  ResultSet rs		      = null;
	  PreparedStatement pstmt1	      = null;
	  ResultSet rs1		      = null;
try
   {
     con = ConnectionManager.getConnection(request);
	 %>
		<form name="form_add_mod" id="form_add_mod">
			<table border='0' cellpadding='5' cellspacing='0' align='center' width="90%">
			 
			 <tr>
				<td class="label" width="20%"><fmt:message key="Common.TerminologySet.label" bundle="${common_labels}"/></td>
				<td class="fields" width="60%">
				<select name="term_set_id" id="term_set_id" onChange="clearDetail()">
				<option value="" selected> ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----- </option>
				<%
					String term_set = "Select term_set_id, term_set_desc from mr_term_set where eff_status = 'E'order by term_set_desc";
					pstmt =con.prepareStatement(term_set);
					rs = pstmt.executeQuery();
					while(rs!=null  && rs.next())
					 {
						out.println("<option value='"+rs.getString(1)+"'>"+rs.getString(2)+""); 
					 }
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
				%>
				</select><img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td>
				<td class='label'></td>
			</tr>
            <tr>
				<td class="label" ><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></td>
				<td class="fields" >
				<select name="pract_type" id="pract_type" onChange="clearDetail()">
				<option value="" selected> ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----- </option>
				<%
					String pract_type = "Select pract_type, desc_userdef from am_pract_type where eff_status = 'E' order by desc_userdef";
					pstmt1 =con.prepareStatement(pract_type);
					rs1 = pstmt1.executeQuery();
					while(rs1!=null  && rs1.next())
					 {
						out.println("<option value='"+rs1.getString(1)+"'>"+rs1.getString(2)+""); 
					 }
					if (rs1 != null) rs1.close();
					if (pstmt1 != null) pstmt1.close();
				%>
				</select>
				</td>
				<td class='label'></td>
			</tr>
			<tr>
			         <!-- Modified by munisekhar on 18-09-12 against Incident Number 35168 --> 
			
			         <td width='20%' class='label'><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/> </td>
			
			         <!-- Commented by munisekhar on 18-09-12 for incident IN35168
		                 <td width='20%' class='label'><fmt:message key="Common.search.label" bundle="${common_labels}"/> </td> -->
				<td width='60%' class='fields'><input type='text' name='pract_desc' id='pract_desc' size='15' maxlength='15' ></input><select name='search_criteria' id='search_criteria'><option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option><option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option><option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option></select></td>
				<td class='button'><input type=button class=button value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onclick='searchDetails()'></td>
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
			if (rs1 != null) rs1.close();
			if (pstmt1 != null) pstmt1.close();
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


