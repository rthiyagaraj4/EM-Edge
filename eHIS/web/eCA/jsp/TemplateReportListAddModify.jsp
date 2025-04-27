<!DOCTYPE html>

<%@ page import ="java.sql.*,webbeans.eCommon.*,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/TemplateReportList.js'></script>
<script language='javascript' src='../js/NoteType.js'></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
	Connection con=null;
	PreparedStatement stmt=null;
//	PreparedStatement stmt1=null;
	ResultSet rs=null;
//	ResultSet rs1=null;
	
	
	String report_name1="";
	String report_type1="";
	String default_age_group1="";
	String report_name="";
	String report_type="";
//	String default_age_group="";

//	String def_agegrp="";
	String sql="";
	String status="";
	String mode="";
//	String note_group_id="";
//	String enabled_checked="";
//	String note_group_id1="";
//	String note_group_desc1="";
//	String applic_task1="";
//	String note_encounter1="";	
//	String role_base1="";	
//	String precondition_recording1="";	
//	String report_header1="";
	String effective_status1="";
//	String sel="";
	String enabled_checked1="";
//	String app_code="";
//	String app_desc="";
	String readOnly = "";
//	String system_user_define="";
	String status1="";
//	String disbl_appl_task="";
//	String trans_checked="";
//	String cutoff_period="";
//	String transcription_yn="";
//	String trans_val="";
//	String applic_task_desc="";
//	String sqlSpec="";
//	String transcription_yn1="";

//	String report_id="";
//	String effective_status="";
	//String mode1="";
	//String report_id1="";
	String mystatus="";
	String mystatus1="";


	
	mode		=(request.getParameter("mode")==null)?"":request.getParameter("mode");
	

	report_name=(request.getParameter("report_name")==null)?"":request.getParameter("report_name");

	report_type=(request.getParameter("report_type")==null)?"":request.getParameter("report_type");

	report_type1=(request.getParameter("report_type")==null)?"":request.getParameter("report_type");

	default_age_group1=(request.getParameter("default_age_group")==null)?"":request.getParameter("default_age_group");

	effective_status1=(request.getParameter("eff_status")==null)?"":request.getParameter("eff_status");

	String new_sql="Select SHORT_DESC description from am_age_group Where upper(AGE_GROUP_CODE) LIKE  UPPER(?)  ";
		
	/*sqlSpec = "select APPL_TASK_ID,APPL_TASK_DESC, TRANSCRIPTION_YN from ca_appl_task where note_spec_yn='Y'";*/
	
	if(mode=="insert" || mode.equals("insert") || mode == null) 
	{
		mode="insert";
		enabled_checked1 = "checked";
	}




	try
	{
		
		con =	ConnectionManager.getConnection(request);
		if(mode.trim().equalsIgnoreCase("update")) 
		{
			//sql ="select * from CA_TEMPLATE_REPORT_LIST	where report_name='"+ report_name + "'" ;//common-icn-0180
			sql ="select * from CA_TEMPLATE_REPORT_LIST	where report_name= ?" ;//common-icn-0180
			stmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1,report_name);//common-icn-0180
			rs = stmt.executeQuery();
			 
			if(rs.next())
			{
				 //report_id1				=(rs.getString("REPORT_ID_REF")==null)?"":rs.getString("REPORT_ID_REF");
				 report_name1			=(rs.getString("REPORT_NAME")==null)?"":rs.getString("REPORT_NAME");
				 report_type1				=(rs.getString("REPORT_TYPE")==null)?"":rs.getString("REPORT_TYPE");
				 default_age_group1		=(rs.getString("DEFULT_AGE_GROUP")==null)?"":rs.getString("DEFULT_AGE_GROUP");
				 effective_status1			=(rs.getString("EFF_STATUS")==null)?"":rs.getString("EFF_STATUS");
		
				//con =	ConnectionManager.getConnection(request);

			PreparedStatement pst_seq = con.prepareStatement(new_sql);
			pst_seq.setString(1,default_age_group1);
			ResultSet rs_seq =  pst_seq.executeQuery();
			
			//String default_age_group1="";
			if (rs_seq.next())
			{
				default_age_group1=rs_seq.getString("description");

			}
			if(rs_seq!=null)  rs_seq.close(); 
			if(pst_seq!=null)  pst_seq.close();

			 if(effective_status1.equals("E"))
				enabled_checked1="checked";
			 else
				enabled_checked1="";

			}

			if(rs!=null)  rs.close(); 
			if(stmt!=null)  stmt.close();
	}
}

catch(Exception e)
{
	//out.println("Exception@1: "+e.toString());//common-icn-0181
	e.printStackTrace();
}
finally
{
		if(con != null) ConnectionManager.returnConnection(con,request);
}

%>
<%if(mode.trim().equalsIgnoreCase("insert")){%>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()">
<%}else{%>

<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='DisplayTrans();' onKeyDown="lockKey()">
<%}%>
<BR>

<form name="template_form" id="template_form" action="../../servlet/eCA.TemplateReportListServlet" method="post" target="messageFrame">
<BR><BR><BR><BR><BR><BR><BR><BR><BR>
<table border=0 cellspacing=0 cellpadding='3' width='90%' align=center>

<tr>
	<%
	
	
	if(mode.trim().equalsIgnoreCase("update")&& (effective_status1.equals("E"))) 
	{
		status="enabled" ;readOnly = ""; 
	}
	else
	{
		status="disabled"; 
		readOnly = "readonly";
	}
	if(mode.trim().equalsIgnoreCase("update")) 
	{status1="disabled" ;}else{status1=""; }
	if(mode.trim().equalsIgnoreCase("insert")){status="enabled";readOnly = "";}
	%>
	
	<td class=label><fmt:message key="Common.reportname.label" bundle="${common_labels}"/></td>
   <% if(mode.trim().equalsIgnoreCase("update")) { %>
	   <td class='fields' >&nbsp;<input type="text" name="report_name" id="report_name" value="<%=report_name1%>" readonly 
	 <%=status1%> size=10 maxlength=10 onkeypress="return CheckForSpecChars(event)"  
	onBlur="ChangeUpperCase(this)" ><img src='../../eCommon/images/mandatory.gif'></td>
		<%}else{%>
	 <td class='fields'>&nbsp;<input type="text" name="report_name" id="report_name" value="<%=report_name1%>" <%=status%> <%=status1%> size=10 maxlength=10 onkeypress="return CheckForSpecChars(event)"  
	onBlur="ChangeUpperCase(this)" ><img src='../../eCommon/images/mandatory.gif'></td>
		<%}%>
</tr>
<tr>
	<td class=label ><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
	<td class='fields' >&nbsp;<select name='report_type' id='report_type'>
	
	<option>-----<fmt:message key="Common.defaultSelect.label" bundle="${ca_labels}"/>-----</option>
	<%
	if(mode=="update" || mode.equals("update") )
	{
		if(report_type1=="SC" ||report_type1.equals("SC"))
		{mystatus="selected";}
		else
			mystatus1="selected";
		

	}
	
	%>
	<option value="SC" <%=mystatus%>>Simple Count</option>
	<option value="LC" <%=mystatus1%>>List Choice Count</option>
	</select><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
		<td class=label ><fmt:message key="eCA.DefaultAgeGrp.label" bundle="${ca_labels}"/></td>
		<td class='fields' >&nbsp;<input type="text" name="default_age_group" id="default_age_group" value="<%=default_age_group1%>"  size=10 maxlength=10 onkeypress="return CheckForSpecChars(event)"  
	onBlur="ChangeUpperCase(this)" >&nbsp;<input name="default_value" id="default_value" type='hidden' value=""/><input type="button" value="?" onclick="Lookupwindow(default_age_group,default_value)"></td>
	
	
</td>
</tr>
  
<tr>
	<td class=label ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td class=fields><input type="checkbox" name="eff_status" id="eff_status" value="E" <%=enabled_checked1%> OnClick ='checkForMode(this)'></td>
</tr>
</table>


<input type='hidden' name="mode" id="mode" value="<%=mode%>">
<input type='hidden' name="report_name1" id="report_name1" value="<%=report_name1%>">
<input type='hidden' name="report_type1" id="report_type1" value="<%=report_type1%>">
<input type='hidden' name="default_age_group1" id="default_age_group1" value="<%=default_age_group1%>">
<input type='hidden' name="eff_status1" id="eff_status1" value="<%=effective_status1%>">




</form>
</body>
</html>

