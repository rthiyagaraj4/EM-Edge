<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<%
	request.setCharacterEncoding("UTF-8");
	String p_patient_id1 = "";
	String title	     = "";
    String p_dup_group_id= "";

	p_dup_group_id   = request.getParameter("p_dup_group_id");
    p_patient_id1    = request.getParameter("p_patient_id1");
	title			 = request.getParameter("title");
	StringBuffer sb = new StringBuffer();

	for(int i=0;i<title.length();i++)
	{
		if(title.charAt(i)=='_') sb.insert(i," ");
		else sb.append(title.charAt(i));
	}

	title = sb.toString();
	%>
<head>
<title><%=title%></title>
<script language='javascript' src='../../eCommon/js/common.js'></script>
 <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<iframe name='modal' id='modal' src="../../eDR/jsp/PossibleDuplicateDisplay.jsp?p_dup_group_id=<%=p_dup_group_id%>&p_patient_id1=<%=p_patient_id1%>"  scrolling='auto' style='height:100vh;width:100vw;border:none;'></iframe>
	 
	
	<body onKeyDown='lockKey();'>
	<form>
	
	</form>
	</body>
    
</html>

