<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
<center>
<form name='RecClinicalNotesLinkHistNoteResult' id='RecClinicalNotesLinkHistNoteResult'>
<p align='right'>
	<table border='0' cellpadding='3' cellspacing='1' width='100%' align='center'>
	<tr>
<%
	Connection			con			=	null;

	 String  patient_id = "";
    String  result_linked_rec_type	 = ""; 
    String  note_group	 = "";
	String  comp_id	 = "";
	String  note_type	 = "";
	String  section	 = "";
    String  comp_val	 = "";
    String  search_criteria	 = "";
    String  current_encounter	 = "";
    String  order_by1	 = "";
    String  order_by2	 = "";
	String	from_date_time		=	"",		to_date_time		=	"";
		

	
	
	from_date_time		=	(request.getParameter("from_date_time")==null)	?	""	:	request.getParameter("from_date_time");

	//out.println("<script>alert('from_date_time"+from_date_time+"')</script>");
	to_date_time		=	(request.getParameter("to_date_time")==null)	?	""	:	request.getParameter("to_date_time");

    patient_id		=	(request.getParameter("patient_id")==null)	?	""	:	request.getParameter("patient_id");
   	
	
	result_linked_rec_type		=	(request.getParameter("result_linked_rec_type")==null)	?	""	:	request.getParameter("result_linked_rec_type");
	
	
	note_group		=	(request.getParameter("note_group")==null)	?	""	:	request.getParameter("note_group");
	
	
	note_type		=	(request.getParameter("note_type")==null)	?	""	:	request.getParameter("note_type");

	section		=	(request.getParameter("section")==null)	?	""	:	request.getParameter("section");

	comp_id		=	(request.getParameter("comp_id")==null)	?	""	:	request.getParameter("comp_id");
	
	comp_val		=	(request.getParameter("comp_val")==null)	?	""	:	request.getParameter("comp_val");
	
	search_criteria		=	(request.getParameter("search_criteria")==null)	?	""	:	request.getParameter("search_criteria");
	
	current_encounter		=	(request.getParameter("current_encounter")==null)	?	""	:	request.getParameter("current_encounter"); 
	
	order_by1		=	(request.getParameter("order_by1")==null)	?	""	:	request.getParameter("order_by1");
	
	order_by2		=	(request.getParameter("order_by2")==null)	?	""	:	request.getParameter("order_by2");

	try
	{
		
		con				=	ConnectionManager.getConnection(request);

		if(result_linked_rec_type.equals("CLNT"))
		{%>

		<script>
			parent.parent.RecClinicalNotesLinkHistNoteTreeFrame.location.href="../../eCA/jsp/RecClinicalNotesLinkHistNoteTree.jsp?patient_id=<%=patient_id%>&result_linked_rec_type=<%=result_linked_rec_type%>&note_group=<%=note_group%>&comp_id=<%=comp_id%>&comp_id=<%=comp_id%>&comp_val=<%=comp_val%>&search_criteria=<%=search_criteria%>&current_encounter=<%=current_encounter%>&order_by1=<%=order_by1%>&order_by2=<%=order_by2%>&from_date_time=<%=from_date_time%>&to_date_time=<%=to_date_time%>&note_type=<%=note_type%>&section=<%=section%>";
		</script>
		<%

		}

	}
	catch(Exception e)
	{
		out.println("Exception@1 : "+e);
	}
	finally
	{
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

	%>
		
	<tr>
	</table>
	</p>
</form>
</center>
</body>
</html>

