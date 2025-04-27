
<%
/*
-----------------------------------------------------------------------
Date       	Edit History   Name        Description
-----------------------------------------------------------------------
?             100            		?           created
30/01/2012	IN030566	Ramesh G	When we place another Order of the same category the Pin No. is prompted again even if the Patient chart is not closed.	
13/06/2013	IN038776	Ramesh G	This is a child cr for  MMS-QH-CRF- 0042 to cover the Billing related changes							  
18/11/2013	IN044811	Ramesh G	In genogram, double click on the 'Double Square' symbol.
19/09/2018	IN068658	Ramesh G	MMS-DM-CRF-0115.3
-----------------------------------------------------------------------
*/
%>
<%@ page import="java.text.*,java.sql.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String title = "";
	String PGeno_Name = request.getParameter("PGeno_Name")==null?"":request.getParameter("PGeno_Name");  //IN044811
	try
	{
		con = ConnectionManager.getConnection(request);
		ps = con.prepareStatement("SELECT PRODUCT_DESCRIPTION FROM SM_INSTALLATION");
		rs = ps.executeQuery();

		while(rs.next())
		{
			title = rs.getString("PRODUCT_DESCRIPTION") == null ? "" : rs.getString("PRODUCT_DESCRIPTION");
		}

		if(rs != null) rs.close();
		if(ps != null) ps.close();
	}
	catch(Exception e)
	{		
		e.printStackTrace();
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
%>

<html>
<head>
<title><%=title%></title>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language="JavaScript" src="../../eCA/js/CAMenu.js"></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script>
	if('<%=PGeno_Name%>'==""){  //IN044811
		window.moveTo(0,0); 
		window.resizeTo(screen.availWidth ,screen.availHeight); 
	}//IN044811
</script>
<%

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

</head>

<%
String query_string = request.getQueryString() == null? "" :request.getQueryString()+"&child_window=Y";
String lookupFileName = request.getParameter("lookupFileName")==null?"":request.getParameter("lookupFileName");
String patientId	= request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
String episodeId	= request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");
String visitId		= request.getParameter("visit_id") == null ? "" : request.getParameter("visit_id");
String enableCDR	="N";//IN068658
String windowName	= patientId+episodeId+visitId;
String patChartCalledFrm =  request.getParameter("patChartCalledFrm") == null ? "" : request.getParameter("patChartCalledFrm");  //IN038776
session.putValue(patientId+"patChartCalledFrm",patChartCalledFrm);  //IN038776
int headerFrameSize = 7;
if(lookupFileName.equals("")){
	headerFrameSize = 7;
	enableCDR="Y";//IN068658
}else{
	headerFrameSize = 0;
}
%>
	<!-- [IN030566] Starts -->
	<iframe name='plineFrame' id='plineFrame'  frameborder="no" src='../../eCommon/jsp/pline.jsp?EncounterId=<%=episodeId%>&Patient_ID=<%=patientId%>&visit_id=<%=visitId%>&enableCDR=<%=enableCDR%>' scrolling='no' noresize style='height:7vh;width:100vw'></iframe><!--IN068658 added  CRD-->
	<iframe name='content' id='content' src='../../eCA/jsp/CAMain.jsp?<%=query_string%>' frameborder=0  marginheight=0 marginwidth=0 SCROLLING='yes' frameborder=0 noresize style='height:92vh;width:100vw'></iframe>
	<iframe name='blankFrameForCharts' id='blankFrameForCharts' src='../../eCommon/html/blank.html' SCROLLING='no'  style='display:none;border:none;height:0vh;width:100vw'></iframe>
</html>

