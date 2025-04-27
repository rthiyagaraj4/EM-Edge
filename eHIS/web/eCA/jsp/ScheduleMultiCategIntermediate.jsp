<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
 <%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	//java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
//	String locale = (String) p.getProperty("LOCALE");
	//String userId=(String) session.getValue("login_user");


	Connection			con		= null;
	PreparedStatement	pstmt	= null;
	ResultSet			rs		= null;
	con = ConnectionManager.getConnection(request);

	String vacc_categ_id ="";
	String patient_id ="";
	String multi_sch_yn ="";

	vacc_categ_id=request.getParameter("schedule_catog")==null?"":request.getParameter("schedule_catog");
	patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	
	

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
    <head>
	</head>
	<body class='CONTENT' onload=""  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<form >

<%
		try
		{

		String Categ_multi_query="select 'Y' from  CA_IM_VAC_CATEG oa where oa.VACC_CATEG_ID = ? and (oa.ALLOW_MULTIPLE_YN='Y' or not exists ( SELECT 1 FROM CA_IM_PAT_VAC_SCH_HDR iA  WHERE IA.PATIENT_ID = ? and iA.VACC_CATEG_ID = oa.VACC_CATEG_ID )) " ;

		pstmt=con.prepareStatement(Categ_multi_query);
		pstmt.setString(1,vacc_categ_id);
		pstmt.setString(2,patient_id);
		rs= pstmt.executeQuery();
		
		if(rs.next())
		{
			multi_sch_yn = "Y";
			
		}

		out.println("<script>");

		
		out.println("top.content.workAreaFrame.frames[0].document.forms[0].allow_multiple_yn.value='"+multi_sch_yn+"'");

	//	out.println("alert('Val'+top.content.workAreaFrame.frames[0].document.forms[0].allow_multiple_yn.value);");
		out.println("allow_multiple_yn1='"+multi_sch_yn+"'");
		out.println("</script>");
		

		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
		%>
			
			 <script>
				//allow_multiple_yn1 =<%=multi_sch_yn%>;
				//alert("allow_multiple_yn1..in inter."+allow_multiple_yn1);	
			</script>
		<%

		}
		catch(Exception e )
		{
			e.printStackTrace() ;
		}
		finally
		{
			if (con!=null) ConnectionManager.returnConnection(con,request);
		}


%>

	</form>
 </body>
</html>

