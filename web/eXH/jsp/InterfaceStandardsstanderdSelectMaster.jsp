<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>
<HTML>
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<% 
Connection con=null;
Statement stmt = null;
ResultSet rs  = null;
ResultSet rs1  = null;
String selected = "selected";
String defaultval = "";
String code_yn="";
%>
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script language='JavaScript' src='../../eXH/js/DataElementCrossReference.js'></script>
<script language='JavaScript' src='../../eXH/js/Validate.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language='JavaScript' src='../../eXH/js/DataElementCrossReferenceappltab.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY  leftmargin=0 topmargin=0   onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>

<form name="application_element_setup_form" id="application_element_setup_form">

<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='30%'></td>
	<td width='70%'></td>
</tr>
<tr><td class=label><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td>
<td class='fields'>
<%
try
{
	con=ConnectionManager.getConnection();
	String qry = "SELECT APPLICATION_ID,APPLICATION_NAME FROM XH_APPLICATION_LANG_VW where IN_USE_YN='Y' and   LANGUAGE_ID='"+locale+"'";
	stmt = con.createStatement();
	rs = stmt.executeQuery(qry);
%>

<select class='select' name='application' id='application'onChange='onSelectAppliction()'>
            <option value='' selected>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
<%
	while(rs.next())
            {
              if ((rs.getString(1)+"").equalsIgnoreCase(defaultval))
              {
                selected = "selected";
              }
              else
              {
                selected = " ";
              }
%>
	<option value='<%=rs.getString(1)%>'  "+selected+" ><%=rs.getString(2)%></option>
            
		<% 	}%>

            </select>

 <%

rs1 = stmt.executeQuery("select MASTER_CODE_MAP_YN from  xh_param ");
while(rs1.next())
{

 code_yn=rs1.getString(1);
}

}catch(Exception exp)
    {
       
	   exp.printStackTrace(System.err);
    }

%>
<img src='../../eCommon/images/mandatory.gif' align=middle> </td></tr>
<tr>
	<td width='30%'></td>
	<td width='70%'></td>
</tr>

</table>
<%
		if(rs!=null)rs.close();
		if(rs1!=null)rs1.close();
		if(stmt!=null)stmt.close();
		ConnectionManager.returnConnection(con);
%>
<input  type="hidden" name=code value='<%=code_yn%>'/>
</form>

</BODY>
</HTML>

