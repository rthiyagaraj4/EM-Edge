<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	Connection con =null;
	PreparedStatement pstmt =null;
	ResultSet rs =null;
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>

<body OnMouseDown='CodeArrest()' onKeyDown='lockKey();' onLoad="Focusing('occupation_code')">

<form name='occupation_form' id='occupation_form' action='../../servlet/eMP.OccupationServlet' method='post' target='messageFrame'>
<div align='left'>
<BR><BR><BR><BR><BR><BR><BR>
  <table border='0' cellpadding='3' cellspacing='0' width='75%' align='center'>

<tr>
	<td width="40%" >&nbsp;</td>
  	<td width="60%" colspan="2">&nbsp;</td>
</tr>

    <tr>
      <td width='40%' class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      <td width='60%' colspan='2' class='fields'><input type='text' name='occupation_code' id='occupation_code' size='7'maxlength='6' onBlur=ChangeUpperCase(this); onKeyPress="return CheckForSpecChars(event)"><img src='../images/mandatory.gif'></img>
      </td>
    </tr>

    <tr>
      <td width='40%' class='label'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      <td width='60%' colspan='2' class='fields'><input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' onBlur='makeValidString(this)' style='{ font-size: ;}'><img src='../images/mandatory.gif'></img></td>
    </tr>

    <tr>
      <td width='40%' class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
      <td width='60%' colspan="2" class='fields'><input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' onBlur='makeValidString(this)'><img src='../images/mandatory.gif'></img></td>
    </tr>
    <tr>
	  <td width='40%' class='label'><fmt:message key="eMP.OccupationClass.label" bundle="${mp_labels}"/></td>
	  <td width='60%' colspan='2' class='fields'><select name='occupation_class' id='occupation_class'><option value='' selected>-------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------


<%
		try{
//			con = (Connection)Sesssion.getValue("connection");
			con = ConnectionManager.getConnection(request);
	        pstmt = con.prepareStatement("Select ocpn_class_code,long_desc short_desc  from mp_occupation_class where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by short_desc ");
		//String sql1 = "Select ocpn_class_code,Short_Desc from mp_occupation_class where eff_status='E' and ( trunc(eff_date_from) <= trunc(sysdate) and trunc(eff_date_to) >= trunc(sysdate) ) or ( trunc(eff_date_from) <= trunc(sysdate) and eff_date_to is null ) or ( trunc(eff_date_to) >= trunc(sysdate) and trunc(eff_date_from) is null) or ( eff_date_from is null and eff_date_to is null )";
	        rs = pstmt.executeQuery();
		    if( rs != null )
		      {
	          while( rs.next() )
	          {
				String classcode = rs.getString( "ocpn_class_code" ) ;
				String classname = rs.getString( "short_desc" ) ;
%>
			<OPTION VALUE='<%= classcode %>' ><%= classname %>
<%
	          }
	      }
%>
              </select><img src='../images/mandatory.gif'></img>
	  </td>
    </tr>
    <!--tr>
      <td width='40%' align='right' class='label' >Effective From</td>
      <td width='13%' align='left'>&nbsp;&nbsp;&nbsp;--><input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10'  maxlength='10'><!--/td-->
      <!--td width='47%' align='left' class='label'>&nbsp;&nbsp;To&nbsp;&nbsp;--> <input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10'  maxlength='10'><!--/td-->
    <!--/tr-->

<!--tr>
	<td width="40%" >&nbsp;</td>
  	<td width="60%" colspan="2">&nbsp;</td>
</tr-->

	<tr>
	<td width='40%' class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
    <td width='60%' colspan='2' class='fields'><input type='checkbox' name='eff_status' id='eff_status' value='E' checked></td>
    </tr>

<tr>
	<td width="40%" >&nbsp;</td>
  	<td width="60%" colspan="2">&nbsp;</td>
</tr>

</table>
</div>
<input type='hidden' name='function' id='function' value='insert'>
<input type='hidden' name='eff_date_from' id='eff_date_from' >
<input type='hidden' name='eff_date_to' id='eff_date_to' >
<input type='hidden' name='function_name' id='function_name' value='insert'>

</form>

<%
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
	}catch(Exception e) { 
		// out.println(e.toString());
		e.printStackTrace();
	}
	finally	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

