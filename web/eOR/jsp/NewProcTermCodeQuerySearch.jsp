<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<html>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
%>
<head>
<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

    <script language="JavaScript" src="../../eOR/js/NewProcedureTermCode.js"></script>
	<script language="JavaScript" src="../../eMR/js/eMRmessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onload='setRadioVal()'>
<%
String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
String term_desc = request.getParameter("term_desc")==null?"":request.getParameter("term_desc");
String mulitple_yn = request.getParameter("mulitple_yn")==null?"":request.getParameter("mulitple_yn");
String temp_term_code = request.getParameter("temp_term_code")==null?"":request.getParameter("temp_term_code");
String term_code_associated = request.getParameter("term_code_associated")==null?"":request.getParameter("term_code_associated");
String Db_term_code = request.getParameter("Db_term_code")==null?"":request.getParameter("Db_term_code");
String radioval = request.getParameter("radioval")==null?"":request.getParameter("radioval");
//term_set_id = "ICD10";
String practitioner_id=(String) session.getValue("ca_practitioner_id");
if(radioval.equals(""))
	radioval="";	

String sql_term = "select term_set_id,term_set_desc,defn_levels from mr_term_set a  where (exists (select 1 from mr_term_set_for_pract ib  where PRACTITIONER_ID=? AND TERM_SET_ID=A.TERM_SET_ID) or not exists (select 1 from mr_term_set_for_pract  where PRACTITIONER_ID=?) ) and proc_spec_yn = 'Y' and eff_status='E'";

String sql_level = "select  '1' code1 ,LEVEL_1_DESC   descr  ,LEVEL_1_CODE_LENGTH  LENGTH from mr_term_set  where term_Set_id = (?) and LEVEL_1_DESC is not null  and eff_status = 'E' union  select  '2' code2 ,LEVEL_2_DESC descr  ,LEVEL_2_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id =(?) and LEVEL_2_DESC is not null  and eff_status = 'E' union select  '3' code ,LEVEL_3_DESC descr  ,LEVEL_3_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id = (?) and LEVEL_3_DESC is not null  and eff_status = 'E' union select  '4' code3 ,LEVEL_4_DESC descr ,LEVEL_4_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id = (?) and LEVEL_4_DESC is not null  and eff_status = 'E' union select  '5' code3 ,LEVEL_5_DESC descr  ,LEVEL_5_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id =(?) and LEVEL_5_DESC is not null  and eff_status = 'E' union select  '6' code  ,LEVEL_6_DESC descr ,LEVEL_6_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id =(?) and LEVEL_6_DESC is not null  and eff_status = 'E' union select  '7' code ,LEVEL_7_DESC descr  ,LEVEL_7_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id =(?) and LEVEL_7_DESC is not null  and eff_status = 'E' union select  '8' code ,LEVEL_8_DESC descr  ,LEVEL_8_CODE_LENGTH LENGTH from mr_term_set  where   term_Set_id =(?) and LEVEL_8_DESC is not null  and eff_status = 'E' union select  '9' code ,LEVEL_9_DESC descr  ,LEVEL_9_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id =(?) and LEVEL_9_DESC is not null  and eff_status = 'E' union select  '10' code ,LEVEL_10_DESC descr  ,LEVEL_10_CODE_LENGTH LENGTH from mr_term_Set where term_Set_id =(?) and LEVEL_10_DESC is not null  and eff_status = 'E'  order by 1";


	Connection con = null;
	PreparedStatement pstmt_term = null,pstmt_level = null;
	ResultSet rs_term,rs_level = null;
	
	con = ConnectionManager.getConnection(request);
	//pstmt_dept = con.prepareStatement(sql_dept);
	//pstmt_serv = con.prepareStatement(sql_serv);
	pstmt_term = con.prepareStatement(sql_term);
	pstmt_term.setString(1,practitioner_id);
	pstmt_term.setString(2,practitioner_id);

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
	<tr>
        <td colspan=''  class="label" >Group
		 <input type="radio" name="terminology" id="terminology" value="G" onclick="storeVal(this)" <%=(radioval.equals("G")||radioval.equals(""))?"checked":""%>>
		 
		 Code<input type="radio" name="terminology" id="terminology" value="C" onclick="storeVal(this)" <%=(radioval.equals("C"))?"checked":""%>>
		 </td>
		<td class="label" >
		<!-- Code<input type="radio" name="terminology" id="terminology" value="C" onclick="storeVal(this)"> -->
        </td>
    </tr>
    <tr >
        <td colspan=''  class="label" width="40%">Term Set
       <select name='term_set' id='term_set' onChange='changeLevel(this)' <%=disabled(term_set_id,term_set_id)%>><option>---------Select--------</option>
		<%while(rs_term.next()){ %>
				<option value='<%=rs_term.getString(1)+"~"+rs_term.getString(3)%>' <%=select(rs_term.getString(1),term_set_id)%> ><%=rs_term.getString(2).trim()%></option> 
		<%}%>
		</select><img id='term_set_man' style="visibility:hidden" src="../../eCommon/images/mandatory.gif">
		<input type="hidden" name="term_set_id" id="term_set_id" value="">
		</td>
		<td class="label" width="60%">
		Level<select name='level' id='level' onChange=''><option value="">--Select--</option>
		<!-- <option>Level 1</option>
		<option>Level 2</option>
		<option>Level 3</option>
		<option>Level 4</option>
		<option>Level 5</option>
		<option>Level 6</option>
		<option>Level 7</option>
		<option>Level 8</option>
		<option>Level 9</option>
		<option>Level 10</option> -->
		<%while(rs_level.next()){ %>
				<option value='<%=rs_level.getString(1)%>'><%=rs_level.getString(2).trim()%></option> 
		<%}%>
		</select>Search By<select name='search_by' id='search_by' onChange='setSearch(this)'><option value="D" >Description</option><option value="C">Code</option></select>
        </td>
    </tr>
	<tr>
		<td class="label" colspan='' id='term'><label id=''>Term Description</label><input type="text" onBlur=""  name="search_text" id="search_text" value="<%=term_desc%>" width="30%" align="left" size="20" maxlength="40" onkeypress="return CheckForSpecChars(event);"><img id='term_set_man1' style="visibility:hidden" src="../../eCommon/images/mandatory.gif"></td>
		<td class='label'>Search Criteria
        <select name="search_criteria" id="search_criteria">
        <option value="S">Starts With
        <option value="E">Ends With
        <option value="C">Contains
        </select></td>
	</tr>
    <tr>
		<td class="label">
        </td>
        <td align="right"><input type="button" align="left" name="Search" id="Search" value="Search" onClick="javascript:search();" class="button" >
        <input type="button" align="left" name="Reset" id="Reset" value="Reset" onClick="resetForm(this.form)" class="button" >
        </td>
    </tr>
</table>
<BR>
<BR>
<input type="hidden" name="multiple_yn" id="multiple_yn" value="<%=mulitple_yn%>">
<input type="hidden" name="temp_term_code" id="temp_term_code" value="<%=temp_term_code%>">
<input type="hidden" name="Db_term_code" id="Db_term_code" value="<%=Db_term_code%>">
<input type="hidden" name="term_code_associated" id="term_code_associated" value="<%=term_code_associated%>">
<input type="hidden" name="ret_term_code" id="ret_term_code" value="<%=term_code_associated%>">
<input type="hidden" name="tmp_radioval" id="tmp_radioval" value="<%=radioval%>">
</form>
</body>
<% 
	  if ( !term_desc.equals("") )
	   {
 %>
<script>
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

