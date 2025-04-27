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
	function clearval()
	{
	   // document.forms[0].
	   parent.frames[3].location.href="../../eMP/jsp/PatCatOrgMbspSub.jsp?param=create&mode=insert&coming=query"
		//document.forms[0].organization.selectedIndex=0;
	    //document.forms[0].sub_org.selectedIndex=0;
	    //document.forms[0].prefix.selectedIndex=0;
		//document.forms[0].relationship.selectedIndex=0;
	}
</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function callresetvalue(){
	document.forms[0].membership.disabled = false;
	document.forms[0].organization.disabled = false;
	document.forms[0].sub_org.disabled = false;
	document.forms[0].prefix.disabled = false;
	document.forms[0].relationship.disabled = false;
	document.forms[0].Clear.disabled = false;
}
	</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name='PatCatOrg' id='PatCatOrg' action='../../servlet/eMP.PatCatOrgMbspServlet' method='post' target='messageFrame'>

<%	String disabled_fld="";	
	    String membership_type_code	  = checkForNull(request.getParameter("membership_type_code"));
	    String from					  = checkForNull(request.getParameter("from"));
		String family_org_id_code	  = checkForNull(request.getParameter("family_org_id_code"));
		String family_org_sub_id_code = checkForNull(request.getParameter("family_org_sub_id_code"));
		String relationship_code1	  = checkForNull(request.getParameter("relationship_code1"));
		String name_prefix		      = checkForNull(request.getParameter("name_prefix"));
       
		String coming		      =checkForNull(request.getParameter("coming"));
		
		String mode		      =checkForNull(request.getParameter("mode"));
		
		String sel_org="";
		String sel_name="";
		String sel_rel="";
		String disabled_some="";
		if(mode.equals(""))
			mode="insert";
		else
			param="create";
		if(mode.equals("insert"))
			disabled_fld="disabled";
		if(membership_type_code.equals("4"))
			disabled_some="disabled";
		
%>
 <table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
	 <th colspan=4 align='left'><fmt:message key="eMP.MembershipDetails.label" bundle="${mp_labels}"/></th>
<TR>
	<TD class ='label' width='20%'>&nbsp;</TD>
	<TD class ='label' width='30%'>&nbsp;</TD>
	 <TD class ='label' width='20%'>&nbsp;</TD>
	<TD class ='label' width='30%'>&nbsp;</TD>
</TR>
<!-- <tr><TD class=label colspan=2>&nbsp;</TD></tr> -->
<!-- <tr><TD class=label colspan=4>&nbsp;</TD></tr> -->
<TR>
	<TD class ='label' align=right id='label2'><fmt:message key="eMP.membership.label" bundle="${mp_labels}"/></TD>
	<TD class="fileds" align='left' id='obj2'>
		&nbsp;<SELECT name="membership" id="membership" <%=disabled_fld%> onchange="validateFields(this)">
		<option value =""> ------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------------- </option>
		<option value ="1"><fmt:message key="eMP.organizationmember.label" bundle="${mp_labels}"/></option>
		<option value ="2"><fmt:message key="eMP.relatedmemberfamily.label" bundle="${mp_labels}"/></option>
		<option value ="3"><fmt:message key="eMP.relatedmembernonfamily.label" bundle="${mp_labels}"/></option>
		<option value ="4"><fmt:message key="eMP.nonorganizationmember.label" bundle="${mp_labels}"/></option>
	</SELECT>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
	<script>
	document.forms[0].membership.value="<%=membership_type_code%>"
	</script>
	</TD><TD class=label colspan=4>&nbsp;</TD>
</TR>

<!-- <tr><TD class=label colspan=2></TD></tr>
<tr><TD class=label colspan=2></TD></tr>
<tr><TD class=label colspan=2></TD></tr>
<tr><TD class=label colspan=2></TD></tr> -->
<tr><TD class=label colspan=4>&nbsp;</TD></tr>
<TR>
	<TD class ='label' align='right' id='label3'><fmt:message key="Common.Organization.label" bundle="${common_labels}"/></TD> 
	<TD class="fileds" align='left' id='obj3'>
	&nbsp;<SELECT name="organization" id="organization" <%=disabled_some%> <%=disabled_fld%> onchange="generateSubOrg('','','CREATE','CHANGE')">
		<option value =""> ------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------------- </option>
		<option value ="*ALL">       <fmt:message key="Common.all.label" bundle="${common_labels}"/>    </option>
	<% if(param.equals("create")) 
  {
	       		stmt = con.createStatement();
				if(sql1.length() > 0) sql1.delete(0,sql1.length());
				sql1.append("Select FAMILY_ORG_ID, FAMILY_ORG_NAME from MP_FAMILY_ORG where  EFF_STATUS='E' order by FAMILY_ORG_NAME ");
	       		rs = stmt.executeQuery(sql1.toString());
				String sel="";

	      if( rs != null )
	      {
	          while( rs.next() )
	          {
				
				sel="";
				String Org_id = checkForNull(rs.getString( "FAMILY_ORG_ID" ));
				String Org_name = checkForNull(rs.getString( "FAMILY_ORG_NAME" ));
				if(family_org_id_code.equals(Org_id) && mode.equals("update")){
					sel="selected";
					sel_org="exist";
				}

			%>
				<OPTION VALUE="<%=Org_id%>" <%=sel%>><%= Org_name %>
			<%
	          }
	      }
		} 
	if ( stmt != null ) stmt.close() ;
	if ( rs != null ) rs.close() ;
	%>
	</SELECT>&nbsp;<img id="orgimage" style="visibility:visible" src='../../eCommon/images/mandatory.gif'></img>
		<script>
	         document.forms[0].organization.value="<%=family_org_id_code%>"
	if("<%=mode%>"=='update')
		{
		  if("<%=sel_org%>"=='' && "<%=family_org_id_code%>"!='*ALL')
             document.forms[0].organization.value='';
		}
	</script>
	</TD>
		
		<TD class=label nowrap align='right'><fmt:message key="eMP.SubUnit.label" bundle="${mp_labels}"/></TD>
	<TD class="fileds">&nbsp;<SELECT name="sub_org" id="sub_org" <%=disabled_some%> <%=disabled_fld%>>
		<option value =""> ------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------------- </option>
		<!-- <option value ="*ALL">       All  </option> -->
		</SELECT>&nbsp;<img id="suborgimage" style="visibility:visible" src='../../eCommon/images/mandatory.gif'>
			
	</script>
	</TD>
</TR><%if(mode.equals("update")){%>
          <script>
			   generateSubOrg("<%=family_org_id_code%>","<%=family_org_sub_id_code%>",'CREATE','NORMAL')
		  </script>
		<%}%>
<tr><TD class=label colspan=4>&nbsp;</TD></tr>

<TR>
<TD class='label' align='right' id='label4' nowrap><fmt:message key="Common.NamePrefix.label" bundle="${common_labels}"/></TD>
	<TD class="fileds" align='left' id='obj4'>
	&nbsp;<SELECT name="prefix" id="prefix" <%=disabled_fld%> <%=disabled_some%>>
		<option value ="">---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
		<option value ="*ALL">       <fmt:message key="Common.all.label" bundle="${common_labels}"/>  </option>

	<% if(param.equals("create"))
  {
	       		stmt = con.createStatement();
				if(sql1.length() > 0) sql1.delete(0,sql1.length());
				//sql1.append("Select FAMILY_ORG_ID, FAMILY_ORG_NAME from MP_FAMILY_ORG where  EFF_STATUS='E' order by FAMILY_ORG_NAME ");
				sql1.append("Select NAME_PREFIX FROM mp_name_prefix where EFF_STATUS='E' order by NAME_PREFIX ");
	       		rs = stmt.executeQuery(sql1.toString());

	      if( rs != null )
	      {
	          String sel="";
			  String prefix_name="";
			  while( rs.next() )
	          {
				 sel="";
				 prefix_name = checkForNull(rs.getString( "NAME_PREFIX" ));
				if(name_prefix.equals(prefix_name)){
					sel="selected";
					sel_name="exist";
				}
			%>
				<OPTION VALUE="<%=prefix_name%>" <%=sel%>><%= prefix_name %>
			<%
	          }
	      }
		} 
	if ( stmt != null ) stmt.close() ;
	if ( rs != null ) rs.close() ;
	%>
	</SELECT>&nbsp;<img id="nprefimage" style="visibility:visible" src='../../eCommon/images/mandatory.gif'></img>
		<script>
	document.forms[0].prefix.value="<%=name_prefix%>"
	if("<%=mode%>"=='update')
		{
		  if("<%=sel_name%>"=='' && "<%=name_prefix%>"!='*ALL')
             document.forms[0].prefix.value='';
		}
	</script>
	</TD><TD class='label' align='right' id='label5'><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></TD>
	<TD class="fileds" align='left' id='obj5'>
	&nbsp;<SELECT name="relationship" id="relationship" <%=disabled_fld%>>
	<option value =""> ------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------------- </option>
	<option value ="*ALL">       <fmt:message key="Common.all.label" bundle="${common_labels}"/>  </option>
	<% if(param.equals("create")) 
  {
	       		stmt = con.createStatement();
				if(sql1.length() > 0) sql1.delete(0,sql1.length());
				sql1.append("select RELATIONSHIP_CODE, SHORT_DESC from mp_relationship where EFF_STATUS='E' order by SHORT_DESC");
	       		rs = stmt.executeQuery(sql1.toString());

	      if( rs != null )
	      {
			  String rel_code="";
			  String short_desc="";
			  String sel="";

	          while( rs.next() )
	          {
				 sel="";
				 rel_code = checkForNull(rs.getString( "RELATIONSHIP_CODE" ));
				 short_desc = checkForNull(rs.getString( "SHORT_DESC" ));
				if(rel_code.equals(relationship_code1)){
					sel="selected";
					sel_rel="exist";
					
				}
			%>
				<OPTION VALUE="<%=rel_code%>" <%=sel%>><%= short_desc %>
			<%
	          }
	      }
		} 
	if ( stmt != null ) stmt.close() ;
	if ( rs != null ) rs.close() ;
	%>
	</SELECT>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
		<script>
	document.forms[0].relationship.value="<%=relationship_code1%>"
	if("<%=mode%>"=='update')
		{
		  if("<%=sel_rel%>"=='' && "<%=relationship_code1%>"!='*ALL')
             document.forms[0].relationship.value='';
		}
	</script>
	</TD>
</TR>


<tr><TD class=label colspan=4>&nbsp;</TD></tr>


<tr>
	<TD class=label>&nbsp;</TD>
	<TD class=label colspan=3 align='right'><INPUT TYPE="button" name="Clear" id="Clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>'  class="button" disabled onclick="clearval()" > &nbsp;&nbsp<!-- ;<INPUT TYPE="button" name="Record" id="Record" onclick="record()" class="button" value="Record" disabled> -->&nbsp;</TD>
</tr>
<tr><TD class=label colspan=4>&nbsp;</TD></tr>
</TABLE>

<input type='hidden' name='cat_value' id='cat_value' value=''>
<input type='hidden' name='param' id='param' value='<%=param%>'>
<!-- <input type='hidden' name='membership_hid' id='membership_hid' value=''> -->
<input type='hidden' name='organization_hid' id='organization_hid' value=''>
<input type='hidden' name='sub_org_hid' id='sub_org_hid' value=''>
<input type='hidden' name='prefix_hid' id='prefix_hid' value=''>
<input type='hidden' name='mode_hid' id='mode_hid' value='<%=mode%>'>


<!--  -->
<input type='hidden' name='membership_type_code_up' id='membership_type_code_up' value='<%=membership_type_code%>'>
<input type='hidden' name='family_org_id_code_up' id='family_org_id_code_up' value='<%=family_org_id_code%>'>
<input type='hidden' name='family_org_sub_id_code_up' id='family_org_sub_id_code_up' value='<%=family_org_sub_id_code%>'>
<input type='hidden' name='relationship_code1_up' id='relationship_code1_up' value='<%=relationship_code1%>'>
<input type='hidden' name='name_prefix_up' id='name_prefix_up'
value="<%=name_prefix%>">

<!--  -->
<%
	if(family_org_sub_id_code.equals("*ALL")){
%>
	<script>

document.forms[0].sub_org.value='*ALL'
</script>

<%}if(membership_type_code.equals("4")){%>
	<script>
	validate_query();
</script>
<%}%>
<%if(coming.equals("query") || from.equals("success")){
	%><script>
         callresetvalue();
		</script>
<!--  -->
<%}%>
<%if(mode.equals("update")){%>
	<script>
	document.forms[0].Clear.disabled=false;
	</script>
<%}%>
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

