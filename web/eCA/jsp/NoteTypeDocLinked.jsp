<!DOCTYPE html>
<!--
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	created
11/11/2011   IN028710      Chowminya G    Incident No: IN028710 - <file upload issue for procedure notes> 
13/12/2022	37958			Ramesh Goli		ML-MMOH-CRF-1977
-----------------------------------------------------------------------
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<%
			String applTaskId = "";
			request.setCharacterEncoding("UTF-8");
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="JavaScript" src ="../../eCA/js/NoteType.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String noteGrp = request.getParameter("noteGrp") == null ? "" :  request.getParameter("noteGrp");	
		try
		{
			con = ConnectionManager.getConnection(request);
			ps = con.prepareStatement("SELECT APPL_TASK_ID FROM CA_NOTE_GROUP WHERE NOTE_GROUP =? ");
			ps.setString(1,noteGrp);

			rs = ps.executeQuery();

			while(rs.next())
			{
				applTaskId = rs.getString("APPL_TASK_ID") == null ? "" : rs.getString("APPL_TASK_ID");
			}

			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
		catch(Exception e)
		{
			//out.println("Exception in NoteTypeDocLinked.jsp --"+e.toString());//COMMON-ICN-0181
			e.printStackTrace() ;
		}
		finally
		{
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
	%>
	<script>
		parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
		if('<%=applTaskId%>' == 'CLINICAL_NOTES' || '<%=applTaskId%>' == 'DISCHARGE_SUMMARY' || '<%=applTaskId%>' == 'REFERRAL_LETTER' || '<%=applTaskId%>' == 'RESULT_REPORTING' || '<%=applTaskId%>' == 'OT_NOTES') <!-- IN028710--><!-- 37958  added OT_NOTES-->
		{
			parent.f_query_add_mod.document.forms[0].doc_link_note.disabled = false;
		}
		else
		{
			parent.f_query_add_mod.document.forms[0].doc_link_note.checked = false;
			parent.f_query_add_mod.document.forms[0].doc_link_note.disabled = true;
		}

	</script>
</HTML>

