<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:	
*	Created By		:	Vinay
*	Created On		:	11 Jan 2005
--%>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<%
Connection con = null;
ResultSet defnlevelRs = null;
PreparedStatement defnlevelStmt = null;
String defnlevelSql = "";
String defnlevel = "";
String codfldlen = "";
String lvldesc = "";
//String codefldlength = request.getParameter("codefldlength");
String termsetid = request.getParameter("termsetid");
String codelevel = request.getParameter("codelevel");
//String termcode = request.getParameter("termcode");
if(codelevel==null) codelevel="1";
try
{
	con = ConnectionManager.getConnection(request);
	if(codelevel.equals("1"))
	defnlevelSql = "select defn_levels,level_1_code_length,level_1_desc from mr_term_set where term_set_id=?";
	else if(codelevel.equals("2"))
	defnlevelSql = "select defn_levels,level_2_code_length,level_2_desc from mr_term_set where term_set_id=?";
	else if(codelevel.equals("3"))
	defnlevelSql = "select defn_levels,level_3_code_length,level_3_desc from mr_term_set where term_set_id=?";
	else if(codelevel.equals("4"))
	defnlevelSql = "select defn_levels,level_4_code_length,level_4_desc from mr_term_set where term_set_id=?";
	else if(codelevel.equals("5"))
	defnlevelSql = "select defn_levels,level_5_code_length,level_5_desc from mr_term_set where term_set_id=?";
	else if(codelevel.equals("6"))
	defnlevelSql = "select defn_levels,level_6_code_length,level_6_desc from mr_term_set where term_set_id=?";
	else if(codelevel.equals("7"))
	defnlevelSql = "select defn_levels,level_7_code_length,level_7_desc from mr_term_set where term_set_id=?";
	else if(codelevel.equals("8"))
	defnlevelSql = "select defn_levels,level_8_code_length,level_8_desc from mr_term_set where term_set_id=?";
	else if(codelevel.equals("9"))
	defnlevelSql = "select defn_levels,level_9_code_length,level_9_desc from mr_term_set where term_set_id=?";
	else if(codelevel.equals("10"))
	defnlevelSql = "select defn_levels,level_10_code_length,level_10_desc from mr_term_set where term_set_id=?";
	defnlevelStmt = con.prepareStatement(defnlevelSql);
	defnlevelStmt.setString(1,termsetid);
	defnlevelRs = defnlevelStmt.executeQuery();
	if(defnlevelRs!=null)
	{
		if(defnlevelRs.next())
		{
			defnlevel = defnlevelRs.getString("defn_levels");
			codfldlen = defnlevelRs.getString(2);
			int len = Integer.parseInt(codfldlen);
			lvldesc = defnlevelRs.getString(3);
			%>
			<script>
			parent.f_query_result.document.getElementById("dynlevel").innerText="Classification Levels  "+"<%=defnlevel%>";
			parent.f_query_result.document.term_code_result_header.class_lvl.value="<%=defnlevel%>";
			parent.f_query_criteria.document.frm_terminology_code.dyanmic_level.value="<%=defnlevel%>";
			//parent.f_term_add_modify.document.term_code_addmodify.term_code.maxLength="<%=len%>";
			//parent.f_term_add_modify.document.getElementById("classificationlabel").innerText=" "+"<%=lvldesc%>";
			//parent.f_term_add_modify.document.term_code_addmodify.term_code.size="<%=len%>";
			//parent.f_term_add_modify.document.term_code_addmodify.codefldlength.value="<%=len%>";
			</script>
			<%
		}
	}
}
catch (Exception e)
{
	//out.println(e.toString());
	e.printStackTrace();
}
finally
{
	if(defnlevelRs!=null) defnlevelRs.close();
	if(defnlevelStmt!=null) defnlevelStmt.close();
	ConnectionManager.returnConnection(con,request);
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
