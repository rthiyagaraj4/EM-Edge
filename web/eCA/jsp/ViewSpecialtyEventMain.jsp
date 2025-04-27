<!DOCTYPE html>
<html>
<%@page import="java.sql.*,java.io.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%	request.setCharacterEncoding("UTF-8");%>
<%String image = request.getParameter("image");%>
<head>
	 <%
		String sStyle =

		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
  	<script src='../../eCA/js/ViewSpecialtyEventHist.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%if (image.equals("true")) {%>
		<style>
		ADDRESS	{ FONT-FAMILY: Courier ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }
	</style>
	<%}else{%>
	<style>
		ADDRESS	{ FONT-FAMILY: Arial ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }
	</style>
	<%}%>
	<title><fmt:message key="Common.EventDetails.label" bundle="${common_labels}"/></title>
</head>
<body   class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="viewSpecialty_text" id="viewSpecialty_text" align='center'>

<%
	
	String disc_id = request.getParameter("disc_id");
	String strConvDt = request.getParameter("strConvDt");
	String Accessionnum = request.getParameter("Accessionnum");
	String Contrsyseventcode = request.getParameter("Contrsyseventcode");

	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String sql = "";
	StringBuffer displaydata = new StringBuffer();
	//String hist_data_type="";
	
	try
	{
			con = ConnectionManager.getConnection(request);
			sql = " SELECT DISCR_MSR_ID,RESULT_STR,TO_CHAR(trans_date,'dd/mm/yyyy hh24:mi') trans_date,  ACCESSION_NUM,EVENT_CODE,RESULT_DATA  FROM  CA_SPLTY_DISCR_MSR WHERE  DISCR_MSR_ID=? AND TO_CHAR(trans_date,'dd/mm/yyyy HH24:MI')=TO_CHAR(TO_DATE(?,'dd/mm/yyyy HH24:MI'),'dd/mm/yyyy HH24:MI') AND ACCESSION_NUM=? AND EVENT_CODE=? ";
//			out.println(sql);

			stmt = con.prepareStatement(sql);

			stmt.setString(1, disc_id);
			stmt.setString(2, strConvDt);
			stmt.setString(3, Accessionnum);
			stmt.setString(4, Contrsyseventcode);

			rs = stmt.executeQuery();

			if(rs.next())
			{
				Clob note=rs.getClob("RESULT_DATA");
				displaydata = new StringBuffer();
				if(note!=null)
				{
					java.io.BufferedReader r = new java.io.BufferedReader(note.getCharacterStream());
					String line = null;
					while((line=r.readLine()) != null) displaydata.append(line+"\n");
				}
			}

				out.println(displaydata.toString());
			
		if(rs !=null) rs.close();
		if(stmt != null ) stmt.close();

	}catch(Exception e)
	{	
	//	out.println(e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}

	finally
	{
		
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
%>
</form>
</body>
</html>

