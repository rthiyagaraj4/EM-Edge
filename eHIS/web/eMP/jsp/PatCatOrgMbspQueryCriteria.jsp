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
	String facilityID=(String)session.getValue("facility_id");
	
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
	<form name='PatCatOrg' id='PatCatOrg' action='../jsp/PatCatOrgMbspDtls.jsp' method='post' target='messageFrame'>
<br>
<br>
<br>
<br>
<br>
 <table border='0' cellpadding='0' cellspacing='0' width='80%' align='center'>
<TR>
	<TD class ='label' width='40%'></TD>
	<TD class ='label' width='60%'></TD>
</TR>
<tr><TD class=label colspan=2>&nbsp;</TD></tr>
<tr><TD class=label colspan=2>&nbsp;</TD></tr>

<TR>
	<TD class ='label' align=right id='label2'><fmt:message key="Common.category1.label" bundle="${common_labels}"/></TD>
	<TD class='label' align='left' id='obj2'>
			&nbsp;<SELECT name="category" id="category" onchange="LoadResultPage_query(this);">
		<option value =""> ------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------------- </option>

<% if(param.equals("query"))
  {
			stmt = con.createStatement();
			if(sql1.length() > 0) sql1.delete(0,sql1.length());
			sql1.append("Select PAT_CAT_CODE,SHORT_DESC  from mp_pat_category where /*operating_facility_id='"+facilityID+"'  and */ EFF_STATUS='E' order by short_desc ");
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
	</TD>
</TR>

<tr><TD class=label colspan=2>&nbsp;</TD></tr>
<TR>
	<TD class ='label' align=right id='label2'><fmt:message key="eMP.membership.label" bundle="${mp_labels}"/></TD>
	<TD class='label' align='left' id='obj2'>
		&nbsp;<SELECT name="membership" id="membership" onchange="clearvalues1(this);">
		<option value =""> ------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------------- </option>
		<option value ="1"><fmt:message key="eMP.organizationmember.label" bundle="${mp_labels}"/></option>
		<option value ="2"><fmt:message key="eMP.relatedmemberfamily.label" bundle="${mp_labels}"/></option>
		<option value ="3"><fmt:message key="eMP.relatedmembernonfamily.label" bundle="${mp_labels}"/></option>
		<option value ="4"><fmt:message key="eMP.nonorganizationmember.label" bundle="${mp_labels}"/></option>
	</TD>
</TR>

<!-- <tr><TD class=label colspan=2></TD></tr>
<tr><TD class=label colspan=2></TD></tr>
<tr><TD class=label colspan=2></TD></tr>
<tr><TD class=label colspan=2></TD></tr> -->
<tr><TD class=label colspan=2>&nbsp;</TD></tr>
<TR>
	<TD class ='label' align='right' id='label3'><fmt:message key="Common.Organization.label" bundle="${common_labels}"/></TD> 
	<TD class='label' align='left' id='obj3'>
	&nbsp;<SELECT name="organization" id="organization"  onchange="generateSubOrg(this,'QUERY')">
		<option value =""> ------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------------- </option>
		<option value ="*ALL">       <fmt:message key="Common.all.label" bundle="${common_labels}"/>    </option>
	<% if(param.equals("query")) 
  {
	       		stmt = con.createStatement();
				if(sql1.length() > 0) sql1.delete(0,sql1.length());
				sql1.append("Select FAMILY_ORG_ID, FAMILY_ORG_NAME from MP_FAMILY_ORG where  EFF_STATUS='E' order by FAMILY_ORG_NAME ");
	       		rs = stmt.executeQuery(sql1.toString());

	      if( rs != null )
	      {
	          while( rs.next() )
	          {
				String Org_id = checkForNull(rs.getString( "FAMILY_ORG_ID" ));
				String Org_name = checkForNull(rs.getString( "FAMILY_ORG_NAME" ));
			%>
				<OPTION VALUE="<%=Org_id%>" ><%= Org_name %>
			<%
	          }
	      }
		} 
	if ( stmt != null ) stmt.close() ;
	if ( rs != null ) rs.close() ;
	%>
	</SELECT>
	</TD>
</TR>
<!-- <tr><TD class=label colspan=2></TD></tr>
<tr><TD class=label colspan=2></TD></tr>
<tr><TD class=label colspan=2></TD></tr>
<tr><TD class=label colspan=2></TD></tr> -->
<tr><TD class=label colspan=2>&nbsp;</TD></tr>
<tr>
	<TD class=label nowrap align='right'><fmt:message key="eMP.suborgn.label" bundle="${mp_labels}"/></TD>
	<TD class=label>&nbsp;<SELECT name="sub_org" id="sub_org" >
		<option value =""> ------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------------- </option>
		<!-- <option value ="*ALL">       All  </option> -->
		</SELECT>
	</TD>
</tr>
<tr><TD class=label colspan=2>&nbsp;</TD></tr>
<!-- <tr><TD class=label colspan=2></TD></tr>
<tr><TD class=label colspan=2></TD></tr>
<tr><TD class=label colspan=2></TD></tr>
<tr><TD class=label colspan=2></TD></tr> -->
<TR>
<TD class='label' align='right' id='label4' nowrap><fmt:message key="Common.NamePrefix.label" bundle="${common_labels}"/></TD>
	<TD class='label' align='left' id='obj4'>
	&nbsp;<SELECT name="prefix" id="prefix" >
		<option value =""> ------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------------- </option>
		<option value ="*ALL">       <fmt:message key="Common.all.label" bundle="${common_labels}"/>  </option>

	<% if(param.equals("query"))
  {
	       		stmt = con.createStatement();
				if(sql1.length() > 0) sql1.delete(0,sql1.length());
				//sql1.append("Select FAMILY_ORG_ID, FAMILY_ORG_NAME from MP_FAMILY_ORG where  EFF_STATUS='E' order by FAMILY_ORG_NAME ");
				sql1.append("Select NAME_PREFIX FROM mp_name_prefix where EFF_STATUS='E' order by NAME_PREFIX ");
	       		rs = stmt.executeQuery(sql1.toString());

	      if( rs != null )
	      {
	          while( rs.next() )
	          {
				String prefix_name = checkForNull(rs.getString( "NAME_PREFIX" ));
			%>
				<OPTION VALUE="<%=prefix_name%>" ><%= prefix_name %>
			<%
	          }
	      }
		} 
	if ( stmt != null ) stmt.close() ;
	if ( rs != null ) rs.close() ;
	%>
	</SELECT>
	</TD>
</TR>
<!-- <tr><TD class=label colspan=2></TD></tr>
<tr><TD class=label colspan=2></TD></tr>
<tr><TD class=label colspan=2></TD></tr>
<tr><TD class=label colspan=2></TD></tr> -->

<tr><TD class=label colspan=2>&nbsp;</TD></tr>
<tr>
<TD class='label' align='right' id='label5'><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></TD>
	<TD class='label' align='left' id='obj5'>
	&nbsp;<SELECT name="relationship" id="relationship" >
	<option value =""> ------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------------- </option>
	<option value ="*ALL">       <fmt:message key="Common.all.label" bundle="${common_labels}"/>  </option>
	<% if(param.equals("query")) 
  {
	       		stmt = con.createStatement();
				if(sql1.length() > 0) sql1.delete(0,sql1.length());
				sql1.append("select RELATIONSHIP_CODE, SHORT_DESC from mp_relationship where EFF_STATUS='E' order by SHORT_DESC");
	       		rs = stmt.executeQuery(sql1.toString());

	      if( rs != null )
	      {
	          while( rs.next() )
	          {
				String rel_code = checkForNull(rs.getString( "RELATIONSHIP_CODE" ));
				String short_desc = checkForNull(rs.getString( "SHORT_DESC" ));
			%>
				<OPTION VALUE="<%=rel_code%>" ><%= short_desc %>
			<%
	          }
	      }
		} 
	if ( stmt != null ) stmt.close() ;
	if ( rs != null ) rs.close() ;
	%>
	</SELECT>
	</TD>
		</tr>
<tr><TD class=label colspan=2>&nbsp;</TD></tr>
<tr>
	<TD class=label>&nbsp;</TD>
	<TD class=label align='right'><INPUT TYPE="button" name="execute" id="execute" onclick="displayresult()" class="button" value='<fmt:message key="Common.Execute.label" bundle="${common_labels}"/>' >&nbsp;</TD>
</tr>
<tr><TD class=label colspan=2>&nbsp;</TD></tr>
</TABLE>

<input type='hidden' name='cat_value' id='cat_value' value=''> 
<input type='hidden' name='param' id='param' value='<%=param%>'>

<!-- <input type='hidden' name='membership_hid' id='membership_hid' value=''> -->
<input type='hidden' name='organization_hid' id='organization_hid' value=''>
<input type='hidden' name='sub_org_hid' id='sub_org_hid' value=''>
<input type='hidden' name='prefix_hid' id='prefix_hid' value=''>

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

