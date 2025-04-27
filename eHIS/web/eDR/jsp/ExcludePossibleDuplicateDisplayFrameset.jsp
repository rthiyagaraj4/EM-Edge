<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	request.setCharacterEncoding("UTF-8");
	String p_patient_id1	= "";
	String p_patient_id2	= "";
	String title			= "";
	String p_dup_group_id	= "";

	StringBuffer sb = new StringBuffer();

	title			= request.getParameter("title");
	p_dup_group_id	= request.getParameter("p_dup_group_id");

	if(p_dup_group_id == null)
	{
		p_dup_group_id = "X";
		p_patient_id1 = request.getParameter("p_patient_id1");
		p_patient_id2 = request.getParameter("p_patient_id2");

		if(p_patient_id1 == null)
		{
			p_patient_id1 = "";
		}
		if(p_patient_id2 == null)
		{
			p_patient_id2 = "";
		}
	}

	for(int i=0;i<title.length();i++)
	{
		if(title.charAt(i) == '_') { sb.insert(i," "); }
		else { sb.append(title.charAt(i)); }
	}

	title = sb.toString();
	%>

<html>

	<head><title><%=title%></title>
	<script language='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head>
	<iframe name='modal' id='modal' src='../../eDR/jsp/ExcludePossibleDuplicateDisplay.jsp?p_dup_group_id=<%=p_dup_group_id%>&p_patient_id1=<%=p_patient_id1%>&p_patient_id2=<%=p_patient_id2%>'  scrolling='auto' noresize style='height:100vh;width:100vw'></iframe>
	
</html>

