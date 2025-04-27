<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/PrintHeaderImageList.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
Connection con=null;
try{
PreparedStatement stmt=null;
//PreparedStatement pstmt=null,pstmt1=null;
ResultSet rs=null;
//String chkstr="disabled";
String sql="";
String dis1="";
String mode="";
//String sel="";
String status="";
//String note_group_id="";
String note_type="";
String note_type_desc="";
String file_type="";
String enabled_checked="checked";
//String confidential_yn="N";
String eff_status ="" ;
//StringBuffer sb_created_notes = new StringBuffer();



mode		=(request.getParameter("mode")==null)?"":request.getParameter("mode");
note_type	=(request.getParameter("note_type")==null)?"":request.getParameter("note_type");


	try
	{
		
		con =	ConnectionManager.getConnection(request);
		if(mode.trim().equalsIgnoreCase("update")) 
		{
			//sql ="select LOGO_ID note_type,LOGO_DESC note_type_desc,LOGO_EXEC_NAME file_type,EFF_STATUS eff_status from CA_NOTE_LOGO_LIST where LOGO_ID='"+note_type + "'" ;//common-icn-0180
			sql ="select LOGO_ID note_type,LOGO_DESC note_type_desc,LOGO_EXEC_NAME file_type,EFF_STATUS eff_status from CA_NOTE_LOGO_LIST where LOGO_ID=?" ;//common-icn-0180
			
			stmt=con.prepareStatement(sql,   ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
			// stmt=con.prepareStatement(sql);
			stmt.setString(1, note_type);//common-icn-0180
			rs = stmt.executeQuery();
			 
			if(rs.next())
			{
				
				note_type=(rs.getString("note_type")== null)? "":rs.getString("note_type");             
				note_type_desc=(rs.getString("note_type_desc")== null)? "":rs.getString("note_type_desc");
				
                file_type=(rs.getString("file_type")== null)? "":rs.getString("file_type");

			
			
				eff_status=(rs.getString("eff_status")== null)? "":rs.getString("eff_status"); 
			
				if(eff_status.equals("E"))
					enabled_checked="checked";
				else
				{
					enabled_checked="";
					dis1="disabled";
				}
				

			}
			if(rs!=null) { rs.close(); rs=null; }
			if(stmt!=null) { stmt.close(); stmt=null; }
		}}	
	catch(Exception e)
	{
		//out.println("Exception@1: "+e.toString());//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181
	}

	
%>


</head>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement()' onKeyDown="lockKey()">
<form name="NoteType_form" id="NoteType_form" action="../../servlet/eCA.PrintHeaderImageListServlet" method="post" target="messageFrame">
<br><br>
<table border=0 cellspacing=0 cellpadding='3' width='75%' align=center>
<tr>
	<td class=label ><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
	<%if(mode.trim().equalsIgnoreCase("update")) {status="disabled" ;}else{status="";}%>
	<td colspan="2" class='fields' ><input type="text" name="note_type" id="note_type" value="<%=note_type%>" <%=status%>
	size=10 maxlength=10 onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" ><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
	<td class=label><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td colspan="2" class='fields'><input type="text" name="note_type_desc" id="note_type_desc" value="<%=note_type_desc%>"   size=40 maxlength=40  <%=dis1%> onBlur="makeValidString(this)" onkeypress='return CheckForSpecCharsNoCaps(event)'><img src='../../eCommon/images/mandatory.gif'></td>
</tr>

<!-- <tr>
	<td class=label><fmt:message key="eCA.filename.label" bundle="${ca_labels}"/></td>
	<td colspan="2" class='fields'><input type="text" name="file_type" id="file_type" value="<%=file_type%>"   size=100 maxlength=100  <%=dis1%> onBlur="makeValidString(this)" onkeypress='return CheckForSpecCharsNoCaps(event)'><img src='../../eCommon/images/mandatory.gif'></td>
</tr> -->
<tr>
	<td class=label><fmt:message key="Common.FileName.label" bundle="${common_labels}"/></td>
	<td class='fields' ><input type="text" name="file_type" id="file_type" value="<%=file_type%>"  size=40 maxlength=100 <%=dis1%>><img src='../../eCommon/images/mandatory.gif' ></td>
</tr> 
<tr>
	<td class=label ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td colspan="2" class='fields'><input type="checkbox" name="eff_status" id="eff_status" value="E"  <%=enabled_checked%>></td>
</tr>
</table>
<input type=hidden name="mode" id="mode" value="<%=mode%>">
<input type=hidden name="note_type_update" id="note_type_update"   value="<%=note_type%>">
<input type=hidden name="beforeUpdateEff_status" id="beforeUpdateEff_status" value="<%=enabled_checked%>">
<input type=hidden name='eff_status1' id='eff_status1' value=<%=eff_status%>>
 
</form>
</body>
</html>
<%
}
catch(Exception e)
{
	//out.println("Exception="+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{
    
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

