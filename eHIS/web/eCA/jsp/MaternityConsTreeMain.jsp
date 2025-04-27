<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String queryString = request.getQueryString() == null ? "" : request.getQueryString();
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script src='../../eCA/js/CAMainMenu.js' language='javascript'></script>
	<script src='../../eCA/js/MaternityConsTree.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>	
	<script src="../../eCommon/js/common.js" language="javascript"></script> 
</head>
<%

String module_id =  request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
String patient_id =  request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");


String SQL="SELECT CYCLE_NO, CYCLE_STATUS  FROM CA_PAT_SPLTY_EPISODE_HDR WHERE PATIENT_ID=? AND  MODULE_ID=? ORDER  BY 2 desc, 1 desc";

Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
//variable declarations
int cycle_no=0;
String cycle_status="";

try{
con = ConnectionManager.getConnection(request);
}catch(Exception e){
	e.printStackTrace() ;
}



try{
pstmt=con.prepareStatement(SQL);
pstmt.setString(1,patient_id);
pstmt.setString(2,module_id);
rs	 =pstmt.executeQuery();
if (rs.next())
{ 
	cycle_no=Integer.parseInt(rs.getString(1)==null?"0":rs.getString(1));
	cycle_status=rs.getString(2);
}
if(rs!=null)
	rs.close();
if(pstmt!=null)
	pstmt.close();	
}catch(Exception e){
	e.printStackTrace() ;
}finally{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}

if(cycle_no==0){%>
<script>
	top.content.workArea.cols="0%,0%,24,0%";
</script>
<FRAMESET rows='10%,*' frameborder=0 framespacing=0>
<FRAME name='maternityeventframe' src='../../eCA/jsp/MaternityConsCycle.jsp?<%=queryString%>' frameborder=0 marginheight=0 marginwidth=0 scrolling='no'>
<FRAME name='maternitytreeframe'src='../../eCommon/html/blank.html' frameborder=0 marginheight=0 marginwidth=0 scrolling='yes'>
<%}else{
%>
<FRAMESET rows='10%,*' frameborder=0 framespacing=0>
	<FRAME name='maternityeventframe' src='../../eCA/jsp/MaternityConsCycle.jsp?<%=queryString%>' frameborder=0 marginheight=0 marginwidth=0 scrolling='no'>
	<FRAMESET id ='trFrm' cols='90%,10%' frameborder=0 framespacing=0>
		<FRAME name='maternitytreeframe' src='../../eCA/jsp/MaternityConsMenu.jsp?<%=queryString%>' frameborder=0 marginheight=0 marginwidth=0 scrolling='yes'>
		<FRAME name='matExpFrame' src='../../eCA/jsp/MaternityConsTreeExp.jsp' frameborder=0  marginheight=0 marginwidth=0 SCROLLING='no' BORDERCOLOR='red'>
	</FRAMESET>
<%}%>
</FRAMESET>
</HTML>
