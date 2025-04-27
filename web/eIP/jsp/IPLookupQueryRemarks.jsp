<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,java.net.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8");
String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html> 
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<title><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></title>
<script>
function closeWin()
{
	//window.close();
	const dialogTag = parent.document.getElementById("dialog_tag"); 
	dialogTag.close();
}

function doClose()	
{
	//window.close();
	const dialogTag = parent.document.getElementById("dialog_tag"); 
	dialogTag.close();
} 

</script>

</head>
<body onload='' onUnload ='closeWin()' onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<%
    String facility_id			= (String)session.getValue("facility_id");
	String p_remarks = request.getParameter("p_remarks");
	String remark ="";
	if (p_remarks==null) p_remarks="";

	Connection con = null;
	Statement stmt = null;
	ResultSet rs =null;
	try
	{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		String sql="select leave_remarks from ip_leave_detail_vw where facility_id='"+facility_id+"' and encounter_id='"+p_remarks+"'";
		rs= stmt.executeQuery(sql);	
		if(rs != null)
		{	
			while(rs.next())
			{
				remark = rs.getString("leave_remarks") == null ? "" : rs.getString("leave_remarks");
			}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		}
	
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();

	}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
<table width='100%' border='0' cellspacing='0' cellpadding='0' align=center>
	<tr>
		<td align='left' class='label' width='10%'></td>
	</tr>
	<tr>
		<td align='left' width='90%' class='label'>&nbsp;&nbsp;<textarea style="resize:none;" name="comments" rows="5" cols="40" readonly><%=remark%></textarea></td>
	</tr>
</table>
<table width='100%' border='0' cellspacing='0' cellpadding='0' align=center>
	<tr><td class='label' align='center'><input type='Button' class='Button' name='Ok' id='Ok' value= '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onclick='doClose()'>
	</tr></td>
	<tr><td class='label'>&nbsp;</td></tr>
	</table>

</body>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

