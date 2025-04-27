<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
<head>
<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			request.setCharacterEncoding("UTF-8");
			String locale			= (String)session.getAttribute("LOCALE");
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown='lockKey()'>
<%
String fieldname=request.getParameter("fieldname");
if(fieldname == null)
fieldname="";
String fieldvalue=request.getParameter("fieldvalue");
if(fieldvalue == null)
fieldvalue=""; 

Connection con		= ConnectionManager.getConnection(request);
PreparedStatement stmt			= null;
ResultSet rset				= null;
String res_area_appl_yn ="";
String res_town_appl_yn ="";
String region_appl_yn ="";
String postal_code_appl_yn ="";
String res_area_prompt ="";
String res_town_prompt ="";
String postal_code_prompt ="";
String region_prompt ="";
String sql="SELECT initcap(res_area_prompt) res_area_prompt,initcap(res_town_prompt) res_town_prompt, postal_code_prompt, initcap(region_prompt) region_prompt,res_area_appl_yn,res_town_appl_yn,region_appl_yn,postal_code_appl_yn from sm_site_param_LANG_VW where language_id='"+locale+"'";

try
{
stmt = con.prepareStatement(sql.toString());
			rset = stmt.executeQuery();
			System.out.println("rset"+rset);
			if(rset.next())
			{
				//out.println("res_area_prompt:"+rset.getString("res_area_prompt"));
				res_area_prompt=rset.getString("res_area_prompt");
				System.out.println("res_area_prompt"+res_area_prompt);
				res_town_prompt=rset.getString("res_town_prompt");
				System.out.println("res_town_prompt :"+res_town_prompt);
				postal_code_prompt=rset.getString("postal_code_prompt");
				region_prompt=rset.getString("region_prompt");
				res_area_appl_yn=rset.getString("res_area_appl_yn");
				region_appl_yn=rset.getString("region_appl_yn");
				postal_code_appl_yn=rset.getString("postal_code_appl_yn");
				res_town_appl_yn=rset.getString("res_town_appl_yn");
				System.out.println("res_town_appl_yn :"+res_town_appl_yn);
			}
			if(res_area_appl_yn==null)
			res_area_appl_yn="N";

			if(region_appl_yn==null)
			region_appl_yn="N";

			if(postal_code_appl_yn==null)
			postal_code_appl_yn="N";

			if(res_town_appl_yn==null)
			res_town_appl_yn="N";

			if(res_area_prompt==null)
			res_area_prompt="";

			if(res_town_prompt==null)
			res_town_prompt="";

			if(postal_code_prompt==null)
			postal_code_prompt="";

			if(region_prompt==null)
			region_prompt="";

			
%>
<form name="CriteriaForm" id="CriteriaForm"  target='lookup_detail' action='AddressLookupResult.jsp'>
<table align="right"  border="0" width="100%" cellspacing="0" cellpadding="0">
<tr>
		<td class='label' width='15%'><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
		<td class='fields' width='55%'>
		<%
		System.out.println("fieldname"+fieldname);
System.out.println("res_town_prompt"+res_town_prompt);
		if(fieldname.equals("postal_code"))
		{
			if(postal_code_appl_yn.equals("Y")){%>
			
			<input type="radio" name="search_by" id="search_by" class="label" value="P"  checked   > <%=postal_code_prompt%>
			<%} if(res_town_appl_yn.equals("Y")){%>
			<input type="radio" name="search_by" id="search_by" class="label" value="T"  > <%=res_town_prompt%>
			<%} if(res_area_appl_yn.equals("Y")){%>
			<input type="radio" name="search_by" id="search_by" class="label" value="A"  > <%=res_area_prompt%>
			<%} if(region_appl_yn.equals("Y")){%>
			<input type="radio" name="search_by" id="search_by" class="label" value="R"  > <%=region_prompt%>
			<%}%>
		<%}
		else if(fieldname.equals("region_code")) 
		{%>
			 <input type="radio" name="search_by" id="search_by" class="label" value="R"  checked  > <%=region_prompt%>
			<input type="radio" name="search_by" id="search_by" class="label" value="C" > <fmt:message key="Common.country.label" bundle="${common_labels}"/>
		<%}
		
		else if(fieldname.equals("area_code")) {%>
			
			<input type="radio" name="search_by" id="search_by"  class="label" value="A" checked  > <%=res_area_prompt%>
			<%if(region_appl_yn.equals("Y")){%>
			<input type="radio" name="search_by" id="search_by" class="label" value="R"  > <%=region_prompt%>
			<%}%>
		<%}
		else if(fieldname.equals("town_code")) {%>

			
			
			<input type="radio" name="search_by" id="search_by" class="label" value="T" checked > <%=res_town_prompt%>
            
			<% if(res_area_appl_yn.equals("Y")){%>

			<input type="radio" name="search_by" id="search_by" class="label" value="A"  > <%=res_area_prompt%>
			<%} if(region_appl_yn.equals("Y")){%>
			<input type="radio" name="search_by" id="search_by" class="label" value="R"  > <%=region_prompt%>
			<%}
			if(postal_code_appl_yn.equals("Y")){%>
			
			<input type="radio" name="search_by" id="search_by" class="label" value="P"     > <%=postal_code_prompt%>
			<%}%>
		<%}
		%>
		
		</td>
		<td class='label' width='15%'><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
		<td class='fields' width='15%'>
		<select name="search_criteria" id="search_criteria">
			<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
			<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
			<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
			</select></td>

	</tr>
	<tr>
		<td class='label'><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="text" onBlur='makeValidString(this);'  name="search_text" id="search_text" value="<%=fieldvalue%>" width=30% align="left" size='40' maxlength='70' ></td>
		<td></td>
		<td><input type="submit" width='20%' align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='button' ></td>
	</tr>
</table>
<BR>
<BR>
<INPUT TYPE="hidden" name='postal_code_appl_yn' id='postal_code_appl_yn' value='<%=postal_code_appl_yn%>'>
<INPUT TYPE="hidden" name='region_appl_yn' id='region_appl_yn' value='<%=region_appl_yn%>'>
<INPUT TYPE="hidden" name='res_area_appl_yn' id='res_area_appl_yn' value='<%=res_area_appl_yn%>'>
<INPUT TYPE="hidden" name='res_town_appl_yn' id='res_town_appl_yn' value='<%=res_town_appl_yn%>'>
<INPUT TYPE="hidden" name='postal_code_prompt' id='postal_code_prompt' value='<%=postal_code_prompt%>'>
<INPUT TYPE="hidden" name='region_prompt' id='region_prompt' value='<%=region_prompt%>'>
<INPUT TYPE="hidden" name='res_area_prompt' id='res_area_prompt' value='<%=res_area_prompt%>'>
<INPUT TYPE="hidden" name='res_town_prompt' id='res_town_prompt' value='<%=res_town_prompt%>'>

<INPUT TYPE="hidden" name='fieldname' id='fieldname' value='<%=fieldname%>'>
</form>


<%
}catch(Exception e)
{
	e.printStackTrace();
}
 finally
	    {
			if(rset != null) rset.close();
			if(stmt != null) stmt.close();
			ConnectionManager.returnConnection(con,request);
        }%>
</body>
</html>
<%
if(!fieldvalue.equals("")) {
%>
<SCRIPT LANGUAGE="JavaScript">
document.CriteriaForm.submit();
</SCRIPT>
<%}%>

