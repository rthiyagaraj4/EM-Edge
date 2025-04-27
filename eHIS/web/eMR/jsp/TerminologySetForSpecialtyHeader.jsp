<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eMR.*, eCommon.Common.*,com.ehis.eslp.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  	
  <script src="../js/TerminologySetforSpecialty.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
 <%
  
	  Connection con 	      = null;
	  PreparedStatement pstmt	      = null;
	  ResultSet rs		      = null;
try
   {
     con = ConnectionManager.getConnection(request);
	 %>
		<form name="form_add_mod" id="form_add_mod" >
		 <br>
			<table border='0' cellpadding='3' cellspacing='0' align='center' width="100%">
			  
			    <tr>
				<td class="label" width="20%"><fmt:message key="Common.TerminologySet.label" bundle="${common_labels}"/></td>
				<td class="fields" width="60%">
				<select name="term_set_id" id="term_set_id"   onchange='changeTerminology();'>
				<option value="" selected> ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----- </option>
				<%
					String terminology_set ="";
					 terminology_set = "Select term_set_id ,term_set_desc from mr_term_set where eff_status = 'E' order by term_set_desc";
					pstmt =con.prepareStatement( terminology_set);
					rs = pstmt.executeQuery( );
					while(rs!=null  && rs.next())
					 {
						out.println("<option value='"+rs.getString(1)+"'>"+rs.getString(2)+""); 
					 }
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
				%>
				</select><img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td>
				<td width='20%' class='label'></td>
				</tr>
				 <!-- Modified by munisekhar on 18-09-12 against Incident Number 35168 --> 
				<tr><td width='20%' class='label'><fmt:message key="eMP.SpecialityDesc.label" bundle="${mp_labels}"/> </td>
				 <!-- Commented by munisekhar on 18-09-12 for incident IN35168
		                 <td width='20%' class='label'><fmt:message key="Common.search.label" bundle="${common_labels}"/> </td> -->
				 
				<td width='60%' class='fields'><input type='text' name='specialty_desc' id='specialty_desc' size='15' maxlength='15' ></input><select name='search_criteria' id='search_criteria'><option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option><option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option><option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option></select></td>
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

