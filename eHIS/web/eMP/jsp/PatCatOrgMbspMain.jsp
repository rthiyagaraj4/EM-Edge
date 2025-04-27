<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%	
	Connection con =null;
	Statement stmt=null;
	ResultSet rs =null;
	String param = checkForNull(request.getParameter("param"));
	StringBuffer sql1 = new StringBuffer();
	if(param == null) param = "";
	//String facilityID=(String)session.getValue("facility_id");
	
	try{
		con = ConnectionManager.getConnection(request);
  String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html> 
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	
	<script src='../js/PatCatOrgMbsp.js' language='javascript'></script>

<SCRIPT LANGUAGE="JavaScript">

</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name='PatCatOrg' id='PatCatOrg' action='../../servlet/eMP.PatCatOrgMbspServlet' method='post' target='messageFrame'>
 <table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
<TR>
	<TD width='25%'></TD>
	<TD width='24%'></TD>
	<TD width='26%'></TD>
	<TD width='25%'></TD> 
</TR>

<TR>
<TD class='label' align='left' >
<TD class='label' align='right' id='label1'><fmt:message key="Common.category.label" bundle="${common_labels}"/></TD>
<TD class="fileds" align='left' id='obj1' >
	&nbsp;<SELECT name="category" id="category" onchange="LoadResultPage(this);">
		<option value =""> --------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------- </option>

<% if(param.equals("create"))
  {
			stmt = con.createStatement();
			if(sql1.length() > 0) sql1.delete(0,sql1.length());
			sql1.append("Select PAT_CAT_CODE,SHORT_DESC  from mp_pat_category where EFF_STATUS='E' order by short_desc ");
			rs = stmt.executeQuery(sql1.toString()); 

	      if( rs != null )
	      {
	          while( rs.next() )
	          {
				String catcode = checkForNull(rs.getString( "PAT_CAT_CODE" ));
				String catname = checkForNull(rs.getString( "SHORT_DESC" ));
			%>
				<OPTION VALUE="<%= catcode %>" ><%= catname %>
			<%
	          }
	      }
		} 
	if ( stmt != null ) stmt.close() ;
	if ( rs != null ) rs.close() ;
	%>
	</SELECT>
	</TD>
	<TD class='label' align='left'>
	</TD>
</TR>
<TR><TD class ='label' colspan='4'></TD></TR>
<TR><TD class ='label' colspan='4'></TD></TR>
<TR><TD class ='label' colspan='4'></TD></TR>
<TR><TD class ='label' colspan='4'></TD></TR>

</TABLE>
<input type='hidden' name='param' id='param' value='<%=param%>'>
</form>

<%	if ( stmt != null ) stmt.close() ;
	if ( rs != null ) rs.close() ;
}
catch ( Exception e ){out.println(e.toString());}
finally
 {
	 ConnectionManager.returnConnection(con,request);
 }
%>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>
</body>
</html>

