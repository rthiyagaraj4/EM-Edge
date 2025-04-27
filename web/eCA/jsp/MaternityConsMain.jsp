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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>

<%
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
String module_id =  request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
String patient_id =  request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
String new_cycle =  request.getParameter("new_cycle") == null ? "O" : request.getParameter("new_cycle");
String NewEvent =  request.getParameter("NewEvent") == null ? "" : request.getParameter("NewEvent");



String SQL1="SELECT SPLTY_EPISODE_DESC,SPLTY_TITLE_EVENT_DESC FROM CA_SPLTY_EPISODE_CYCLE_LANG_VW WHERE MODULE_ID=? AND LANGUAGE_ID=?";
String SQL2="SELECT CYCLE_NO FROM CA_PAT_SPLTY_EPISODE_HDR WHERE PATIENT_ID=? AND  MODULE_ID=? AND CYCLE_STATUS  ='O' ORDER  BY 1";
String SQL3="SELECT CYCLE_NO, CYCLE_STATUS  FROM CA_PAT_SPLTY_EPISODE_HDR WHERE PATIENT_ID=? AND  MODULE_ID=? ORDER  BY 2 desc, 1 desc";

Connection con = null;
PreparedStatement pstmt1 = null;
PreparedStatement pstmt2 = null;
PreparedStatement pstmt3 = null;

ResultSet rs1 = null;
ResultSet rs2 = null;
ResultSet rs3 = null;

//variable declarations
String splty_episode_desc=null;
String splty_title_event_desc=null;
int cycle_open=0;
int cycle_no=0;
String cycle_status="";

try{
con = ConnectionManager.getConnection(request);


try{
	pstmt1=con.prepareStatement(SQL1);

	pstmt1.setString(1,module_id);
	pstmt1.setString(2,locale);
	rs1	 =pstmt1.executeQuery();
	while(rs1.next()){
	splty_episode_desc=rs1.getString(1)==null?"CYCLE":rs1.getString(1);
	splty_title_event_desc=rs1.getString(2)==null?"EVENT":rs1.getString(2);
	}
	splty_episode_desc=splty_episode_desc==null?"CYCLE":splty_episode_desc;
	splty_title_event_desc=splty_title_event_desc==null?"EVENT":splty_title_event_desc;


	if(rs1!=null)
		rs1.close();
	if(pstmt1!=null)
		pstmt1.close();
}catch(Exception e){
	e.printStackTrace() ;
}

try{
	pstmt2=con.prepareStatement(SQL2);
	pstmt2.setString(1,patient_id);
	pstmt2.setString(2,module_id);
	rs2	 =pstmt2.executeQuery();
	if (rs2.next())
			cycle_open=Integer.parseInt(rs2.getString(1));
	if(rs2!=null)
		rs2.close();
	if(pstmt2!=null)
		pstmt2.close();


	
}catch(Exception e){
	e.printStackTrace() ;
}

	try{
	pstmt3=con.prepareStatement(SQL3);
	pstmt3.setString(1,patient_id);
	pstmt3.setString(2,module_id);
	rs3	 =pstmt3.executeQuery();
	if (rs3.next())
	{
		cycle_no=Integer.parseInt(rs3.getString(1));
		cycle_status=rs3.getString(2);
	}

	if(rs3!=null)
		rs3.close();
	if(pstmt3!=null)
		pstmt3.close();	


	}catch(Exception e){
		e.printStackTrace() ;
	}

%>
<%

if(cycle_no==0 || new_cycle.equals("N") || NewEvent.equals("NewEvent")){%>
		<iframe name='matcycleframe' id='matcycleframe' src='../../eCA/jsp/MaternityConsOpenCycle.jsp?cycle_status=<%=cycle_status%>&p_cycle_no=<%=cycle_no%>&<%=queryString%>&p_event_title=<%=splty_title_event_desc%>&new_cycle=<%=new_cycle%>&NewEvent=<%=NewEvent%>' frameborder=0 scrolling='no' noresize style='height:*%;width:100vw'></iframe>
		<iframe name='matactionframe' id='matactionframe' src='../../eCA/jsp/MaternityConsOpenActionbar.jsp' frameborder=0 scrolling='no' noresize style='height:0%;width:100vw'></iframe>
		
	<%}else{
%>
		<iframe name='matcycleframe' id='matcycleframe' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:80%;width:100vw'></iframe>
		<iframe name='matactionframe' id='matactionframe' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:10%;width:100vw'></iframe>
		
<%}
}catch(Exception e){
	e.printStackTrace() ;
}
finally
{
	try
	{
	if(con!= null) ConnectionManager.returnConnection(con,request);
	}
	catch(Exception e)
	{
	out.println("Exception in CAMainMenu.jsp"+e.toString());
	}
}
%>
</html>

