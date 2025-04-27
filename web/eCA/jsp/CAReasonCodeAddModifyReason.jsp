<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	    Edit History      		Name        		             Rev.Date		        Rev.Name		          Description
------------------------------------------------------------------------------------------------------------------------------------------------------
21/04/2023	IN061903			Srinivasa			                  21/04/2023		Ramesh G		           ML-BRU-CRF-0605.4		
------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,webbeans.eCommon.* "  contentType="text/html;charset=UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/CAReasonCode.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
Connection con=null;
try
{	
	PreparedStatement stmt=null;
	ResultSet rs=null;
	String mode="";
	String readOnly = "";
	String sql="";
	String status="";
	String reason_code1	=	"";
	String reason_desc1	=	"";
	String reason_description1 ="";
	String effective_status1="E";
	String enabled_checked1="checked";


	mode		=(request.getParameter("mode")==null)?"":request.getParameter("mode");
	reason_code1=(request.getParameter("reason_code")==null)?"":request.getParameter("reason_code");


	try
	{  
		con =	ConnectionManager.getConnection(request);
		if(mode.trim().equalsIgnoreCase("update")) 
		{
			
			sql ="select * from CA_REASON_CODE where REASON_CODE='"+ reason_code1 + "'" ;
			stmt=con.prepareStatement(sql);
			rs = stmt.executeQuery();
			 
			if(rs.next())
			{
				 reason_code1		=(rs.getString("REASON_CODE")==null)?"":rs.getString("REASON_CODE");
				 reason_desc1		=(rs.getString("REASON_DESC")==null)?"":rs.getString("REASON_DESC");
				 reason_description1		=(rs.getString("REASON_TEXT")==null)?"":rs.getString("REASON_TEXT");
				 effective_status1		=(rs.getString("EFF_STATUS")==null)?"":rs.getString("EFF_STATUS");

					if(effective_status1.equals("E"))
						enabled_checked1="checked";
					else
					{
						//effective_status1="N";
						enabled_checked1="";
					}

			}
		if(rs!=null)  rs.close(); 
		if(stmt!=null)  stmt.close();
				
	}

}catch(Exception e)
{
	out.println("Exception@1: "+e.toString());
	e.printStackTrace();
}

%>
<body onload='FocusFirstElement()' OnMouseDown="CodeArrest()"  onKeyDown="lockKey()"   >
<form name='reasonCode_form' id='reasonCode_form' target='messageFrame'  action="../../servlet/eCA.CAReasonCodeServlet" method="post">

<BR><BR><BR><BR><BR><BR><BR><BR><BR>
<table border=0 cellspacing=0 cellpadding='3' width='75%' align=center>
<tr style="line-height:1">
	<td colspan="3"></td>
</tr>
<tr>
<%
	
	if(mode.trim().equalsIgnoreCase("update")) 
	{status="readonly"; }
	
	if(mode.trim().equalsIgnoreCase("insert")){status="enabled";readOnly = "";}%>
	
	<td class=label ><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" name="reason_code" id="reason_code" value="<%=reason_code1%>" <%=status%> 
	 size=10 maxlength=10 onkeypress="return CheckForSpecChars(event)"  
	onBlur="ChangeUpperCase(this)" ><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td class="fields"><input type="text" name="reason_short_desc" id="reason_short_desc" value="<%=reason_desc1%>" onBlur="makeValidString(this);"  size='40' maxlength='40'><img src="../../eCommon/images/mandatory.gif" align=center></img></td>
</tr>
<tr>
	<td class="label"><fmt:message key="eOR.ReasonText.label" bundle="${or_labels}"/></td>
	<td class='fields'><TEXTAREA NAME="reason_desc" ROWS="3" COLS="40" onBlur = "return makeValidString(this)" onKeyPress="return CheckMaxLength(this,200)" ><%=reason_description1%></TEXTAREA><img src="../../eCommon/images/mandatory.gif" align=center></img></td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="checkbox" name="eff_status" id="eff_status" value='Y' <%=enabled_checked1%> OnClick ='checkForMode(this)' ></td>
</tr>
</table>

<input type=hidden name="mode" id="mode" value="<%=mode%>">
<input type=hidden name="reason_code1" id="reason_code1" value="<%=reason_code1%>">
<input type=hidden name="reason_desc1" id="reason_desc1" value="<%=reason_desc1%>">
<input type=hidden name="reason_description1" id="reason_description1" value="<%=reason_description1%>">
<input type=hidden name="eff_status1" id="eff_status1" value="<%=effective_status1%>">
</form>
</body>
</html>
<%
}
catch(Exception e)
{
	out.println("Exception in  CAReasonCodeAddModify.jsp"+e.toString());
}
finally
{
    
    if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>



