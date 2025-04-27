<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String queryString = request.getQueryString() == null ? "" : request.getQueryString();
	%>
	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCA/js/ProgressNotes.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>	
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

</head>
<%

String module_id =  request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
String patient_id =  request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
String called_from =  request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
String progression_ref =  request.getParameter("progression_ref") == null ? "" : request.getParameter("progression_ref");
/*
The below Query was changed by
Name   : DINESH T
Date   : 2010-05-03
INCNO  : 21026
Changes: Added an extra condition called_from = ? in the query and an extra setString statement			 for the same
*/
String SQL="SELECT max(PROGRESSION_CYCLE_NO) FROM CA_PAT_PROGRESSION_HDR WHERE PATIENT_ID=? AND  MODULE_ID =?  and CALLED_FROM = ? ";

Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

int progression_no=0;

if(!called_from.equals("OH_TREATMENT"))
{
	try
	{
		con = ConnectionManager.getConnection(request);
		pstmt=con.prepareStatement(SQL);
		pstmt.setString(1,patient_id);
		pstmt.setString(2,module_id);
		pstmt.setString(3,called_from);
		rs	 =pstmt.executeQuery();
		if (rs.next())
		{ 
			progression_no=Integer.parseInt(rs.getString(1)==null?"0":rs.getString(1));
		}

		if(rs!=null)	rs.close();
		if(pstmt!=null) pstmt.close();	
	}
	catch(Exception e)
	{
		e.printStackTrace() ;		
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
}
else
{
	if(progression_ref.equals(""))
	{
		progression_no=0;
	}
	else
	{
		progression_no=1;
	}


}

if(progression_no==0){%>
<script>
	//top.content.workArea.cols="0%,0%,24,0%";
	// this comment for OH calling
	//top.content.workArea.cols="0%,20%,*,0%";
</script>
<FRAMESET rows='10%,*' frameborder=0 framespacing=0>
<FRAME name='maternityeventframe' id='maternityeventframe' src='../../eCA/jsp/ProgressNotesProgression.jsp?<%=queryString%>' frameborder=0 marginheight=0 marginwidth=0 scrolling='no'>
<FRAME name='maternitytreeframe' id='maternitytreeframe'src='../../eCommon/html/blank.html' frameborder=0 marginheight=0 marginwidth=0 scrolling='yes'>
<%}else{
%>
<FRAMESET rows='10%,*' frameborder=0 framespacing=0>
	<FRAME name='maternityeventframe' id='maternityeventframe' src='../../eCA/jsp/ProgressNotesProgression.jsp?<%=queryString%>' frameborder=0 marginheight=0 marginwidth=0 scrolling='no'>
	<FRAMESET id ='trFrm' cols='90%,10%' frameborder=0 framespacing=0>
		
		<FRAME name='maternitytreeframe' id='maternitytreeframe' src='../../eCA/jsp/ProgressNotesMenu.jsp?<%=queryString%>&sel_progression_no=<%=progression_no%>' frameborder=0 marginheight=0 marginwidth=0 scrolling='yes'>
		<FRAME name='matExpFrame' id='matExpFrame' src='../../eCommon/html/blank.html' frameborder=0  marginheight=0 marginwidth=0 SCROLLING='no' BORDERCOLOR='red'>
	</FRAMESET>
<%}%>
</FRAMESET>
</HTML>

