<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</HEAD>
<body onKeyDown="lockKey()">
<%
	String practitioner_id=(String)request.getParameter("home_page_pract_id") == null ? "" : (String)request.getParameter("home_page_pract_id");	
	String pract_type =(String)request.getParameter("home_page_pract_type") == null ? "" : (String)request.getParameter("home_page_pract_type");
	String group_type = "";
	String filename = "";
	String header = "";
	String qs = request.getQueryString();

	Connection con				= null;
	PreparedStatement pstmtComp1 = null;
	ResultSet rsComp1			= null;
	
	try
	{
		con = ConnectionManager.getConnection(request);
		
		pstmtComp1 = con.prepareStatement("SELECT distinct A.GROUP_TYPE FROM ca_home_page_comp A, CA_PERSONALIZED_HOME_PAGE B where A.COMP_ID = B.COMP_ID and B.PRACT_TYPE = ? and B.PRACTITIONER_ID = ?");
		pstmtComp1.setString(1,pract_type);
		pstmtComp1.setString(2,practitioner_id);
	
		rsComp1 = pstmtComp1.executeQuery();
		out.println("<table width='100%' height='100%' align='center' border=0 CELLSPACING=0><tr>");
		while (rsComp1.next())
		{
			group_type = rsComp1.getString("GROUP_TYPE") == null ? "" : rsComp1.getString("GROUP_TYPE");
			if(group_type.equals("1"))
			{
				header = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Orders.label","common_labels");
				filename = "../../eCA/jsp/CAMainHomePageCommonTasksNew.jsp?"+qs;
			}
			else if(group_type.equals("2"))
			{
				header = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ResultsforReview.label","ca_labels");
				filename = "../../eCA/jsp/CAMainHomePageMyTasksNew.jsp?"+qs;
			}
			else if(group_type.equals("3"))
			{
				header = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notes.label","common_labels");
				filename = "../../eCA/jsp/CAHomePageNotesNew.jsp?"+qs;
			}
			else if(group_type.equals("4"))
			{
				header = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Patients.label","common_labels");
				filename = "../../eCA/jsp/CAHomePagePatientsNew.jsp?"+qs;
			}
			else
			{
				header = "";
				filename = "";
			}
			if(!filename.equals(""))
			{
				out.println("<td>");
				out.println("<table width='100%' CELLSPACING=0><tr><td class='PANELTOOLBAR'>"+header+"</td></tr></table>");
				out.println("<iframe src='"+filename+"' frameborder='0' framespacing='0' scrolling='no'  MARGINWIDTH='0px' MARGINHEIGHT='0px' width='100%' height='100%'></iframe></td>");
			}
		}
		out.println("</tr></table>");

		if(rsComp1!=null)rsComp1.close();
		if(pstmtComp1!=null)pstmtComp1.close();
	}
	catch(Exception e)
	{
	//	out.println("Exception in CAHomePageNew.jsp "+e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}

	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</HTML>
	

