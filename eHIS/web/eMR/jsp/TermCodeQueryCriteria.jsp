<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<html>
<head>
<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
    <script language="JavaScript" src="../../eMR/js/NoteTerminologyCode.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body onKeyDown='lockKey()'>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
String term_desc = request.getParameter("term_desc")==null?"":request.getParameter("term_desc");
String mulitple_yn = request.getParameter("mulitple_yn")==null?"":request.getParameter("mulitple_yn");
String temp_term_code = request.getParameter("temp_term_code")==null?"":request.getParameter("temp_term_code");
//String term_code_associated = request.getParameter("term_code_associated")==null?"":request.getParameter("term_code_associated");
//String Db_term_code = request.getParameter("Db_term_code")==null?"":request.getParameter("Db_term_code");
String term_group_id = request.getParameter("term_group_id")==null?"":request.getParameter("term_group_id");
String returnVal1  =  request.getParameter( "returnVal1" )  ;
String recode_yn= request.getParameter("recode_yn")==null?"":request.getParameter("recode_yn");
//String sql_term = "select term_set_id,term_set_desc,defn_levels from mr_term_set where proc_spec_yn = 'Y' and eff_status = 'E'";


String sql_term = "";
if(recode_yn.equals("Y")){
	sql_term="select TERM_SET_ID,TERM_SET_DESC ,defn_levels from mr_term_set where PROC_SPEC_YN='Y' and RECODERS_APPL_YN='Y'";
}else{
	sql_term="select term_set_id,term_set_desc,defn_levels from mr_term_set where eff_status = 'E'";
}

String sql_level = "select  '1' code1 ,LEVEL_1_DESC   descr  ,LEVEL_1_CODE_LENGTH  LENGTH from mr_term_set  where term_Set_id = (?) and LEVEL_1_DESC is not null  and eff_status = 'E' union  select  '2' code2 ,LEVEL_2_DESC descr  ,LEVEL_2_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id =(?) and LEVEL_2_DESC is not null  and eff_status = 'E' union select  '3' code ,LEVEL_3_DESC descr  ,LEVEL_3_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id = (?) and LEVEL_3_DESC is not null  and eff_status = 'E' union select  '4' code3 ,LEVEL_4_DESC descr ,LEVEL_4_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id = (?) and LEVEL_4_DESC is not null  and eff_status = 'E' union select  '5' code3 ,LEVEL_5_DESC descr  ,LEVEL_5_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id =(?) and LEVEL_5_DESC is not null  and eff_status = 'E' union select  '6' code  ,LEVEL_6_DESC descr ,LEVEL_6_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id =(?) and LEVEL_6_DESC is not null  and eff_status = 'E' union select  '7' code ,LEVEL_7_DESC descr  ,LEVEL_7_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id =(?) and LEVEL_7_DESC is not null  and eff_status = 'E' union select  '8' code ,LEVEL_8_DESC descr  ,LEVEL_8_CODE_LENGTH LENGTH from mr_term_set  where   term_Set_id =(?) and LEVEL_8_DESC is not null  and eff_status = 'E' union select  '9' code ,LEVEL_9_DESC descr  ,LEVEL_9_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id =(?) and LEVEL_9_DESC is not null  and eff_status = 'E' union select  '10' code ,LEVEL_10_DESC descr  ,LEVEL_10_CODE_LENGTH LENGTH from mr_term_Set where term_Set_id =(?) and LEVEL_10_DESC is not null  and eff_status = 'E'  order by 1";


	Connection con = null;
	PreparedStatement pstmt_term = null,pstmt_level = null;
	ResultSet rs_term,rs_level = null;
	
	con = ConnectionManager.getConnection(request);
	//pstmt_dept = con.prepareStatement(sql_dept);
	//pstmt_serv = con.prepareStatement(sql_serv);
	pstmt_term = con.prepareStatement(sql_term);
	pstmt_level = con.prepareStatement(sql_level);
	
	pstmt_level.setString(1,term_set_id);
	pstmt_level.setString(2,term_set_id);
	pstmt_level.setString(3,term_set_id);
	pstmt_level.setString(4,term_set_id);
	pstmt_level.setString(5,term_set_id);
	pstmt_level.setString(6,term_set_id);
	pstmt_level.setString(7,term_set_id);
	pstmt_level.setString(8,term_set_id);
	pstmt_level.setString(9,term_set_id);
	pstmt_level.setString(10,term_set_id);
	
	rs_term = pstmt_term.executeQuery();
	rs_level = pstmt_level.executeQuery();
%>
<form name="CriteriaForm" id="CriteriaForm"  >
<table align="right"  border="0" width="100%" cellspacing="0" cellpadding="0">
    <tr width="100" border="0">
        <td colspan='' width="15%" class="label" ><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></td>
       <td width="30%"><select name='term_set' id='term_set' onChange='' <%=disabled(term_set_id,term_set_id)%>><option>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
		<%while(rs_term.next()){ %>
				<option value='<%=rs_term.getString(1)%>' <%=select(rs_term.getString(1),term_set_id)%> ><%=rs_term.getString(2).trim()%></option> 
		<%}%>
		</select><img src="../../eCommon/images/mandatory.gif"></td>
		<td class="label" width="15%">
		<fmt:message key="Common.Level.label" bundle="${common_labels}"/></td><td width = "20%"><select name='level' id='level'  onChange=''>
		<option value="">---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
		<%while(rs_level.next()){ %>
				<option value='<%=rs_level.getString(1)%>'><%=rs_level.getString(2).trim()%></option> 
		<%}%>
		</select></td><td class="label" width = "25%"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/><select name='search_by' id='search_by' onChange='setSearch(this)'><option value="D" ><fmt:message key="Common.description.label" bundle="${common_labels}"/></option><option value="C"><fmt:message key="Common.code.label" bundle="${common_labels}"/></option></select>
        </td>
    </tr>	
	<tr>
		<td class="label" width = "15%" colspan='' id='term'><fmt:message key="eMR.TermDescription.label" bundle="${mr_labels}"/></td><td width = "20%"><input type="text" onBlur=""  name="search_text" id="search_text" value="<%=term_desc%>"  align="left" size="20" maxlength="40" onkeypress="return CheckForSpecChars_term(event);"><img src="../../eCommon/images/mandatory.gif"></td>
		<td class='label' width = "15%"><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
		<td width = "20%" colspan = '2'>
        <select name="search_criteria" id="search_criteria">
        <option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
        <option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
        <option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
        </select></td>		
	</tr>
    <tr>		
		<td width = "20%" colspan = '3'>				
        <td class='button' align="right" colspan = '6' width = "20%"><input type="button" align="left" name="Search" id="Search" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" onClick="javascript:search();" class="button" >
        <input type="button" align="left" name="Reset" id="Reset" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")%>" onClick="resetForm(this.form)" class="button" >
        </td>
    </tr>
</table>
<BR>
<BR>
<input type="hidden" name="multiple_yn" id="multiple_yn" value="<%=mulitple_yn%>">
<input type="hidden" name="temp_term_code" id="temp_term_code" value="<%=temp_term_code%>">
<input type="hidden" name="ret_term_code" id="ret_term_code" value="">
<input type="hidden" name="term_group_id" id="term_group_id" value="<%=term_group_id%>">
<input type="hidden" name="returnVal1" id="returnVal1" value="<%=returnVal1%>">
</form>
</body>
<% 
	  if ( !term_desc.equals("") )
	   {
 %>
<script>
   //initializeText();
   search();
</script>
<%  }  

	if ( rs_term != null) 	rs_term.close();
	if ( rs_level != null) 	rs_level.close();
	if ( pstmt_term != null) pstmt_term.close();
	if ( pstmt_level != null) pstmt_level.close();
	if ( con != null )	ConnectionManager.returnConnection(con,request);
%>
</html>
<%!
String select(String str1, String str2)
{
		if(str1.trim().equalsIgnoreCase(str2.trim()))
		return "selected";
		else
		return "";
}
String disabled(String str1, String str2)
	{
		if(!str1.trim().equals("")){
			if(str1.trim().equalsIgnoreCase(str2.trim()))
				return "disabled";
			else
				return "";
		}else
			return "";
	}
%>

