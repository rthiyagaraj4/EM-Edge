<!DOCTYPE html>
<%@page import="java.sql.*,java.io.*,java.awt.*,webbeans.eCommon.*,org.jfree.chart.servlet.*,javax.print.*,javax.print.attribute.*,javax.print.attribute.standard.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%	request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
<head>
<title><fmt:message key="eCA.Graphs.label" bundle="${ca_labels}"/></title>
		<%

			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script Language="vbscript">
    Dim WSHShell
    Dim myHeader
    Dim myFooter
    Dim myMarginleft 
    Dim myMarginright 
    Set WSHShell = CreateObject("WScript.Shell")
    REM myHeader = WSHShell.RegRead("HKCU\Software\Microsoft\Internet Explorer\PageSetup\header")
    REM myFooter = WSHShell.RegRead("HKCU\Software\Microsoft\Internet Explorer\PageSetup\footer")
    REM myMarginleft = WSHShell.RegRead("HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_left") 
    REM myMarginright = WSHShell.RegRead("HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_right") 

    WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\header", "&bPage &p of &P"
    WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\footer", "&b&d"
    WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_left", "0.5"
    WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_right", "0.3"

  
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>


<%
	String filename		= request.getParameter("filename") == null ? "" : request.getParameter("filename");
	//out.println("<script>alert('Printing page---"+filename+"');</script>");
	String[] filenames = filename.split(",");
	//out.println("<script>alert('"+filenames.length+"');</script>");
	String callOn		= request.getParameter("callOn") == null ? "callOnExit" : request.getParameter("callOn");
	//String patient_id		= request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String pat_line		= request.getParameter("pat_line") == null ? "" : request.getParameter("pat_line");
	boolean deleted = false;
	String name = "";
%>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()" <%if(callOn.equals("callOnPrint")){%>onLoad = "Print()" <%}%>>
<form>
<%
	if(callOn.equals("callOnPrint"))
	{
		/*String patient_name = "",		age = "";
		String sex = "";
		String sql = "select a.patient_name, a.sex, GET_AGE(a.date_of_birth) age from mp_patient a where patient_id = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		
		

		try
		{
			con = ConnectionManager.getConnection(p);
			
			if(con != null)
			{
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,patient_id.trim());
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					patient_name = rs.getString(1)== null ? "" : rs.getString(1);
					sex = rs.getString(2)== null ? "" : rs.getString(2);
					age = rs.getString(3)== null ? "" : rs.getString(3);
				}
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

					
			

			if(sex.equals("M"))
				sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				
			if(sex.equals("F"))
				sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				 
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
				ConnectionManager.returnConnection(con,request);

		} */
%>
			<table width='95%'>
				<tr>
					<td><b><%=pat_line%></b></td>
				</tr>
			</table>
<%
		for(int i=0;i<filenames.length;i++)
		{
			name = filenames[i];
%>
			<img src="../../eCA/MediPainter/images/<%=name%>" alt = 'Graph' border=0 /><br>
<%
		}
	}
	else if(callOn.equals("callOnExit"))
	{
		try
		{
			for(int i=0;i<filenames.length;i++)
			{
				name = filenames[i];
				File file = new File(config.getServletContext().getRealPath("/")+"eCA/MediPainter/images/" + name);
				if(file.exists())
					deleted = file.delete();
			}
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
	}
%>

</form>
<script>
	function Print() 
	{
			var res = confirm('Continue printing?');
			if(res)  
			{
				window.print();
			}
			window.close();
	}
</script>
</body>
</html>
	

