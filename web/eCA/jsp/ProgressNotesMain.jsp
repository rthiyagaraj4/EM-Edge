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
	String	module_id	=  request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
	String	patient_id	=  request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String	new_cycle	=  request.getParameter("new_cycle") == null ? "O" : request.getParameter("new_cycle");
	String	NewEvent	=  request.getParameter("NewEvent") == null ? "" : request.getParameter("NewEvent");

	String	called_from	=  request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
	String	progression_ref	=  request.getParameter("progression_ref") == null ? "" : request.getParameter("progression_ref");

	/*
	The below Query was changed by
	Name   : DINESH T
	Date   : 2010-05-03
	INCNO  : 21026
	Changes: Added an extra condition called_from = ? in the query and an extra setString statement for the same
	*/
	String SQL3="SELECT PROGRESSION_CYCLE_NO, PROGRESSION_STATUS FROM CA_PAT_PROGRESSION_HDR WHERE PATIENT_ID = ? AND  MODULE_ID = ?  AND CALLED_FROM= ? ORDER  BY 2 desc, 1 desc";

	Connection		  con	 = null;
	
	PreparedStatement pstmt3 = null;

	ResultSet		  rs3	 = null;

//	String	splty_episode_desc=null;
	String	splty_title_event_desc=null;
	
	int		cycle_no=0;
	String	cycle_status="";

try{
con = ConnectionManager.getConnection(request);

	if(!called_from.equals("OH_TREATMENT"))
	{

	try
	{
		pstmt3=con.prepareStatement(SQL3);
		pstmt3.setString(1,patient_id);
		pstmt3.setString(2,module_id);
		pstmt3.setString(3,called_from);
		rs3	 =pstmt3.executeQuery();
		if (rs3.next())
		{
			cycle_no=Integer.parseInt(rs3.getString(1));
			cycle_status=rs3.getString(2);
		}

		if(rs3!=null) 		rs3.close();
		if(pstmt3!=null)	pstmt3.close();	
		
	}
	catch(Exception e)
	{
		e.printStackTrace() ;
	}
	}
	else
	{	
		if(progression_ref.equals(""))
		{
			cycle_no = 0;
		}
		else
		{
			cycle_no = 1;
		}
	}

%>
<%

if(cycle_no==0 || new_cycle.equals("N") || NewEvent.equals("NewEvent")){%>
		<iframe name='matcycleframe' id='matcycleframe' src='../../eCA/jsp/ProgressNotesOpenProgression.jsp?cycle_status=<%=cycle_status%>&p_cycle_no=<%=cycle_no%>&<%=queryString%>&p_event_title=<%=splty_title_event_desc%>&new_cycle=<%=new_cycle%>&NewEvent=<%=NewEvent%>' frameborder=0 scrolling='no' noresize style='height:*%;width:100vw'></iframe>
		<iframe name='matactionframe' id='matactionframe' src='../../eCA/jsp/MaternityConsOpenActionbar.jsp' frameborder=0 scrolling='no' noresize style='height:10%;width:100vw'></iframe>
		
	<%}else{%>
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

