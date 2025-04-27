<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>

<HTML>
<head>
 <%
    request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../js/NoteType.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<style>
textarea {
  resize: none;
}
</style>
<TITLE><fmt:message key="eCA.DisclaimerText.label" bundle="${ca_labels}"/></TITLE>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">

<%

	String rem	= request.getParameter("rem")==null?"":request.getParameter("rem");
	String disclaimer_text="";	
	String sql="";


Connection con=null;
PreparedStatement pstmt=null;
ResultSet rs=null;
try
{

con =ConnectionManager.getConnection(request);

sql ="select DISCLIMER_TEXT from CA_DISCLIMER_TEXT where DISCLIMER_CODE="+ rem +"" ;
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			 
		if(rs.next())
		{
			disclaimer_text=(rs.getString("DISCLIMER_TEXT")== null)? "":rs.getString("DISCLIMER_TEXT");
			
		}
	
	
	if(rs!=null)  rs.close(); 
	if(pstmt!=null)  pstmt.close();
}//try 

catch(Exception eg)
{
  // out.println("Exception="+eg.toString());//COMMON-ICN-0181
     eg.printStackTrace();//COMMON-ICN-0181
}

finally
	{
		if (con!= null)
		ConnectionManager.returnConnection(con,request);
	} 
%>		

<form>
<center>
	<table width='100%' border='0' cellspacing='0' cellpadding='3' align=center>
	  <tr>
		<td class ='fields'> 
		<textarea name="comments" size=200 maxlength=200  readonly rows="18" cols ="65" value=""> <%=disclaimer_text%></textarea>		
	    </td>
	  </tr>
	  </table><!-- <BR><BR><BR><BR> -->
    <table width='100%' border='0' cellspacing='0' cellpadding='3' align=center>
	 <tr><td colspan=3 align='right'>
	 <input type='Button' class='Button' name='Ok' id='Ok' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onclick='doClose()'>
	 </td></tr>
	 <!-- <tr>
	 <td class='label'>&nbsp;</td>
	 </tr> 
	 <tr>
	 <td class='label'>&nbsp;</td>
	 </tr> -->
	</table>
</center>
</form>
</BODY>
</HTML>

