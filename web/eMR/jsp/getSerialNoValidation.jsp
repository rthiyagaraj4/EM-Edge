<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HEAD>
<script language='javascript' src='../../eMR/js/RecodePrivilegeSetup.js'></script>

<%
    request.setCharacterEncoding("UTF-8");
	String ser_no=checkForNull(request.getParameter("srl_no_valid"));
	int _chkSerNo=0;
	if(!ser_no.equals(""))
	 _chkSerNo=Integer.parseInt(ser_no);

	
	
	StringBuffer _srlsql=new StringBuffer();

    try{
		 Connection con = null;
		 PreparedStatement pstmt=null;
		 ResultSet rs=null;
		 int stage=0;
		 
		con=ConnectionManager.getConnection(request);
		if(_srlsql.length() > 0) _srlsql.delete(0,_srlsql.length());
		_srlsql.append("SELECT AUTH_AT_STAGE  FROM mr_parameter");
		pstmt=con.prepareStatement(_srlsql.toString());
		rs = pstmt.executeQuery();
		rs.next();
		stage=rs.getInt("AUTH_AT_STAGE");
		if(stage!=0){
		if(_chkSerNo==stage)
			out.println("<script>_validateSerialNoEqual()</script>");
		else if(_chkSerNo < stage)
			out.println("<script>_validateSerialNoLess()</script>");
		else if(_chkSerNo > stage)
			out.println("<script>_validateSerialNoGrettet()</script>");  			
		}
		else{}
		  String sStyle	=
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"
			+"</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey();'></body></html>");

	}
	catch(Exception ex){
		ex.printStackTrace();
	}
	finally{
	}
	%>

<HEAD>
</HEAD>
<BODY onKeyDown='lockKey()'>
<FORM name="SerialNoValidiation" id="SerialNoValidiation">


</FORM>
</BODY>

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

