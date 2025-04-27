<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="com.ehis.util.*,java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<title><fmt:message key="Common.view.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Link.label" bundle="${common_labels}"/></title>
<%	

String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//String locale			= (String)session.getAttribute("LOCALE");

%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css">
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script language='javascript' src='../../eCommon/js/common.js'></Script>
<script src='../js/RecDiagnosis.js' language='javascript'></script>
<script src='../js/RecDiagnosisMain.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
<%
	Connection con		    = null;
	ResultSet rset		    = null;
	PreparedStatement pstmt	= null;

try {

	//Statement stmt		    = null;
	StringBuffer sql		= new StringBuffer(); 
	con = ConnectionManager.getConnection(request);
	
	//	String term_set_id		= checkForNull(request.getParameter("term_set_id"));
	String term_code		= checkForNull(request.getParameter("term_code"));
	//String term_desc		= checkForNull(request.getParameter("term_desc"));
	String equi_term_set_id = "";
	String equi_term_code   = "";
	String equi_term_desc   = "";
	int k					= 0;
	int maxRecord			= 0;
	String classValue		= "";

	sql.append("SELECT a.equivalent_term_set_id,a.equivalent_term_code, b.short_desc from  mr_equivalent_term_code a,mr_term_code b WHERE a.equivalent_term_set_id = b.term_set_id  AND a.equivalent_term_code = b.term_code and a.term_code=? and a.CROSS_REF_TYPE='EQ' ");
	pstmt = con.prepareStatement( sql.toString() ) ;
	pstmt.setString( 1, term_code) ;
	rset = pstmt.executeQuery();
	

	
%>
<br><br>
<table border="1" cellpadding="0" cellspacing="0" width="100%" align='center'>
	<tr>
		<th nowrap><font size=2 align='top'><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></font></td>
		<th nowrap><font size=2 align='top'><fmt:message key="Common.TermCode.label" bundle="${common_labels}"/></font></td>
		<th nowrap><font size=2 align='top'><fmt:message key="Common.description.label" bundle="${common_labels}"/></font></td>
	</tr>
<%
	while(rset.next())
	{
		equi_term_set_id    = checkForNull(rset.getString("equivalent_term_set_id"));
		equi_term_code      = checkForNull(rset.getString("equivalent_term_code"));
		equi_term_desc      = checkForNull(rset.getString("short_desc"));
		
		if ( k%2 == 0 )
                classValue = "qryeven" ;
             else
                classValue = "qryodd" ;
		out.println("<tr align='center'>");
		out.println("<td class='"+classValue+"'  nowrap>"+equi_term_set_id+"</td>");
		out.println("<td class='"+classValue+"'  nowrap>"+equi_term_code+"</td>");
		out.println("<td class='"+classValue+"'  nowrap>"+equi_term_desc+"</td>");
		out.println("</tr>");
	k++;
	maxRecord++;

}
/*if(maxRecord == 0)
{
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));window.close();</script>");
}*/
	if (pstmt!=null) pstmt.close();
	if(rset!=null) rset.close();	

} catch(Exception e) { 
	e.printStackTrace(); 
}
finally{
		if(con!= null){
			if (pstmt!=null) pstmt.close();
			if(rset!=null) rset.close();	
			ConnectionManager.returnConnection(con,request);
	 }

}

%>
</table>

</body>
</html>

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

