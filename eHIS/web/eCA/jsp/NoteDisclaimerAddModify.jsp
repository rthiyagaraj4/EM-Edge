<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/NoteDisclaimer.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
setInterval("chopText(document.forms[0].disclaimer_text,200)",1000);
</script>
<%
Connection con=null;
try
{	
	PreparedStatement stmt=null;
	//PreparedStatement pstmt=null;
	ResultSet rs=null;
	String mode="";
	String readOnly = "";
	String sql="";
	String status="";
	String note_disclaimer_id="";
	String note_disclaimer_id1="";
	String note_disclaimer_desc1="";
	String disclaimer_text1="";
	String effective_status1="E";
	String enabled_checked1="checked";
	String applicable_to_rep_yn="N";

	mode		=(request.getParameter("mode")==null)?"":request.getParameter("mode");
	note_disclaimer_id=(request.getParameter("note_disclaimer_id")==null)?"":request.getParameter("note_disclaimer_id");


	try
	{
		con =	ConnectionManager.getConnection(request);
		if(mode.trim().equalsIgnoreCase("update")) 
		{
			
			//sql ="select * from CA_DISCLIMER_TEXT where DISCLIMER_CODE='"+ note_disclaimer_id + "'" ;//common-icn-0180
			sql ="select * from CA_DISCLIMER_TEXT where DISCLIMER_CODE= ?" ;//common-icn-0180
			stmt=con.prepareStatement(sql);
			stmt.setString(1, note_disclaimer_id);//common-icn-0180
			rs = stmt.executeQuery();
			 
			if(rs.next())
			{
				 note_disclaimer_id1		=(rs.getString("DISCLIMER_CODE")==null)?"":rs.getString("DISCLIMER_CODE");
				 note_disclaimer_desc1		=(rs.getString("DISCLIMER_DESC")==null)?"":rs.getString("DISCLIMER_DESC");
				
				 disclaimer_text1		=(rs.getString("DISCLIMER_TEXT")==null)?"":rs.getString("DISCLIMER_TEXT");
				 
				 effective_status1		=(rs.getString("EFF_STATUS")==null)?"":rs.getString("EFF_STATUS");
				applicable_to_rep_yn=(rs.getString("applicable_to_rep_yn")==null)?"N":rs.getString("applicable_to_rep_yn");

					if(effective_status1.equals("E"))
						enabled_checked1="checked";
					else
					{
						enabled_checked1="";
						//note_disclaimer_id="";
					}

			}
		if(rs!=null)  rs.close(); 
		if(stmt!=null)  stmt.close();
				
	}
	//else	if(mode.trim().equalsIgnoreCase("insert"))
		//enabled_checked1="checked";

}catch(Exception e)
{
	//out.println("Exception@1: "+e.toString());//COMMON-ICN-0181
	e.printStackTrace();
}

%>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()">
<BR>
<form name="notedisclaimer_form" id="notedisclaimer_form" action="../../servlet/eCA.NoteDisclaimerServlet" method="post" target="messageFrame">

<BR><BR><BR><BR><BR><BR><BR><BR><BR>
<table border=0 cellspacing=0 cellpadding='3' width='75%' align=center>



<tr>
	<%
	
	if(mode.trim().equalsIgnoreCase("update")) 
	{status="disabled"; readOnly = "readonly";}
	/*{status="enabled" ;readOnly = ""; }else */
	
	
	if(mode.trim().equalsIgnoreCase("insert")){status="enabled";readOnly = "";}%>
	
	<td class=label ><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" name="note_disclaimer_id" id="note_disclaimer_id" value="<%=note_disclaimer_id1%>" <%=status%> 
	 size=10 maxlength=10 onkeypress="return CheckForSpecChars(event)"  
	onBlur="ChangeUpperCase(this)" ><img src='../../eCommon/images/mandatory.gif'></td>
	
</tr>
<tr>
	<td class=label ><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" name="note_disclaimer_desc" id="note_disclaimer_desc" value="<%=note_disclaimer_desc1%>"<%=status%>  size=30 maxlength=30 onBlur = "return makeValidString(this)"  ><img src='../../eCommon/images/mandatory.gif'></td>
	
</tr>
<tr>
	<td class=label ><fmt:message key="eCA.DisclaimerText.label" bundle="${ca_labels}"/></td>
	<td class='fields' >
		<textarea name="disclaimer_text" value='' maxlength='200' rows="3" cols ="60" onBlur="makeValidString(this)" onKeyPress='checkMaxLimit(this,200)' onchange='chopText(this,200)'
		onkeyup='chopText(this,200)' ><%=disclaimer_text1%></textarea>
	
</td>
<tr>
	<td class=label ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="checkbox" name="eff_status" id="eff_status" value='E' <%=enabled_checked1%> OnClick ='checkForMode(this)'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eCA.ApplicableToReport.label" bundle="${ca_labels}"/>&nbsp;&nbsp;<input type="checkbox" name="applicable_to_rep_yn" id="applicable_to_rep_yn" value="<%=applicable_to_rep_yn%>" <%if(applicable_to_rep_yn.equals("Y")){%> checked <%}%>OnClick ='checkRepAppl(this)'></td>
</tr>
</table>
<input type=hidden name="mode" id="mode" value="<%=mode%>">
<input type=hidden name="note_disclaimer_id1" id="note_disclaimer_id1" value="<%=note_disclaimer_id1%>">
<input type=hidden name="note_disclaimer_desc1" id="note_disclaimer_desc1" value="<%=note_disclaimer_desc1%>">
<input type=hidden name="disclaimer_text1" id="disclaimer_text1" value="<%=disclaimer_text1%>">
<input type=hidden name="eff_status1" id="eff_status1" value="<%=effective_status1%>">
<input type=hidden name="old_note_disclaimer_id" id="old_note_disclaimer_id" value="<%=note_disclaimer_id%>">

</form>
</body>
</html>
<%
}
catch(Exception e)
{
	//out.println("Exception in  NoteDisclaimerAddModify.jsp"+e.toString());//COMMON-ICN-0181
     e.printStackTrace();//COMMON-ICN-0181
}
finally
{
    
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<SCRIPT LANGUAGE="JavaScript">
//parent.commontoolbarFrame.document.getElementById("apply").disabled = false;
</SCRIPT>

