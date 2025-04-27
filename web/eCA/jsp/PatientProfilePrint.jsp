<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             	100            ?           	created
16/09/2013	IN041358		Vijayakumark	ML-BRU-SCF-0918-Issue with printing from patient profile in CA . The printer window is hidden behind the application window.
24/09/2013	IN043676		Ramesh G		'Family Members' details not displayed in Print out
---------------------------------------------------------------------------------------------------------------

-->
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!--IN041358 starts-->
<%@page import="java.sql.*,webbeans.eCommon.*"%>
<!--IN041358 ends-->
<html>
<head>
	<title><fmt:message key="eCA.PatientProfile.label" bundle="${ca_labels}"/></title>
 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//IN041358 starts
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;
	int pat_profile_prn_time_interval	=	0;
	
	try
		{	
		con	= ConnectionManager.getConnection(request);
		
		pstmt	=	con.prepareStatement("SELECT NOTE_PRINT_TIME_INTERVAL FROM CA_NOTE_PARAM ");
		rs		=	pstmt.executeQuery();
		if(rs.next()){
			pat_profile_prn_time_interval			= Integer.parseInt(rs.getString("NOTE_PRINT_TIME_INTERVAL") == null ? "0" : (String)rs.getString("NOTE_PRINT_TIME_INTERVAL"));
		}
		if(rs!=null)	rs.close();
		if(pstmt!=null)	pstmt.close();
		
		}
	    catch(Exception e)
		{
			//out.println("Exception:PatientProfilePrint.jsp@30: "+e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
			
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
		//IN041358 ends
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language=javascript src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script Language="vbscript">
		Dim WSHShell
		Dim myHeader
		Dim myFooter
		Dim myMarginleft 
		Dim myMarginright 
		Set WSHShell = CreateObject("WScript.Shell")

		WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\header", "&bPage &p of &P"
		WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\footer", "&b&d"
		WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_left", "0.5"
		WSHShell.RegWrite "HKCU\Software\Microsoft\Internet Explorer\PageSetup\margin_right", "0.3"
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<script>
	function printtext()
	{
		if(document.getElementById("chk1") != null)
		document.getElementById("chk1").style.visibility="hidden";
		if(document.getElementById("chk2") != null)
			document.getElementById("chk2").style.visibility="hidden";
		if(document.getElementById("chk3") != null)
			document.getElementById("chk3").style.visibility="hidden";
		if(document.getElementById("chk4") != null)
			document.getElementById("chk4").style.visibility="hidden";
		if(document.getElementById("chk5") != null)
			document.getElementById("chk5").style.visibility="hidden";
		if(document.getElementById("chk6") != null)
			document.getElementById("chk6").style.visibility="hidden";
		if(document.getElementById("chk7") != null)
			document.getElementById("chk7").style.visibility="hidden";
		if(document.getElementById("chk8") != null)
			document.getElementById("chk8").style.visibility="hidden";
		if(document.getElementById("chk9") != null)
			document.getElementById("chk9").style.visibility="hidden";
		if(document.getElementById("chk10") != null)						//IN043676
			document.getElementById("chk10").style.visibility="hidden";	//IN043676
		window.print();
		//IN041358 starts
		//window.close();
		setTimeout(function() { window.close(); }, <%=pat_profile_prn_time_interval %>);
		//IN041358 ends
	}
	</script>
	
</head>
<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onload="printtext()">
<form>
<%
	try
	{
		String chk1 = request.getParameter("chk1") == null ? "N" : request.getParameter("chk1");
		String chk2 = request.getParameter("chk2") == null ? "N" : request.getParameter("chk2");
		String chk3 = request.getParameter("chk3") == null ? "N" : request.getParameter("chk3");
		String chk4 = request.getParameter("chk4") == null ? "N" : request.getParameter("chk4");
		String chk5 = request.getParameter("chk5") == null ? "N" : request.getParameter("chk5");
		String chk6 = request.getParameter("chk6") == null ? "N" : request.getParameter("chk6");
		String chk7 = request.getParameter("chk7") == null ? "N" : request.getParameter("chk7");
		String chk8 = request.getParameter("chk8") == null ? "N" : request.getParameter("chk8");
		String chk9 = request.getParameter("chk9") == null ? "N" : request.getParameter("chk9");
		String chk10 = request.getParameter("chk10") == null ? "N" : request.getParameter("chk10");  //IN043676
		String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
		String header = request.getParameter("header") == null ? "" : request.getParameter("header");
%>
		<font size='4'><p align='center'> <b> <fmt:message key="eCA.PatientProfile.label" bundle="${ca_labels}"/> </b> </p></font>
		<font size='4'><%=header%></font>
		<jsp:include page="PatientProfileContent.jsp" flush="true">
			<jsp:param name ="chk1" value= "<%=chk1%>" /> 
			<jsp:param name ="chk2" value= "<%=chk2%>" />	
			<jsp:param name ="chk3" value= "<%=chk3%>" />   										 
			<jsp:param name ="chk4" value= "<%=chk4%>" />  
			<jsp:param name ="chk5" value= "<%=chk5%>" />  
			<jsp:param name ="chk6" value= "<%=chk6%>" />  
			<jsp:param name ="chk7" value= "<%=chk7%>" />  
			<jsp:param name ="chk8" value= "<%=chk8%>" />  
			<jsp:param name ="chk9" value= "<%=chk9%>" />  
			<jsp:param name ="chk10" value= "<%=chk10%>" />
			<jsp:param name ="patient_id" value= "<%=patient_id%>" />  
			<jsp:param name ="encounter_id" value= "<%=encounter_id%>" />  
		</jsp:include>
<!--<script>
	var a=window.dialogArguments;
	document.write(a);
</script>-->

<%
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
%>
</form>
</body>
</html>

