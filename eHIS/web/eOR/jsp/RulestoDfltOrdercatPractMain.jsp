<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,com.ehis.util.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %> 
<html>

<head>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script> 
    <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script> 
    <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
    <Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<script language='javascript' src="../js/RulestoDfltOrdercatPract.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  

</head>

<%
	request.setCharacterEncoding("UTF-8");
	String id="",name="";
	String facid = (String) session.getValue( "facility_id" ) ;
	Connection conn = null;
	PreparedStatement pstmt	= null;
	ResultSet rs = null;

try
{
	conn = ConnectionManager.getConnection(request);
	
%>
    
<body OnMouseDown='CodeArrest()' onload='Facilitychange();' onKeyDown = 'lockKey()'>
	 <form name="DfltorderCategoryPractForm" id="DfltorderCategoryPractForm" method="post" target="messageFrame">
	     <table  border="0" class='grid' width="45%" align="center">
		 
			<tr>
			   <td colspan='5' class=label>&nbsp;</td>
			</tr>

			<tr>

			<td width='5%'>&nbsp;</td>

			<td align='left' class='label'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		     <td align='left' nowrap >&nbsp;&nbsp;<select name='facility' id='facility' id='facility' onchange='Facilitychange();'>
			<option value='AL'>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
	 <%
	   pstmt = conn.prepareStatement("select facility_id,facility_name from sm_facility_param order by 2");
	  try
	  {
	  rs = pstmt.executeQuery();
	  if(rs!=null)
	  {
		  while(rs.next())
		  {
			 id=rs.getString(1);
			 name = rs.getString(2);
			if(id.equals(facid))
			  {
			%>
				<option value=<%=id%> selected><%=name%></option>
		  <%
			  }
			  else
			  {%>
				<option value=<%=id%> ><%=name%> </option> 
			<%	}
				}
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
	  }
	  }catch(Exception e){out.println(e);}
	 
	  %>
			</td>
			</tr>

			<tr>
			   <td colspan='2' class=label>&nbsp;</td>
			</tr>
		</table>

		<input type='hidden' name='fac' id='fac' value=''>

    </form>

</body>

<%
}catch(Exception e)
{
	out.print(e.toString());
}
finally   
{
	if(conn != null)
	ConnectionManager.returnConnection(conn,request);
}
%>

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

</html>

