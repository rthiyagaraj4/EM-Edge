<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<%
{
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String term_group_id="";
	String term_group_desc="";
	String term_set_id="";
	String term_set_desc="";
	String eff_status="";
	String mode="";
	String sr_nos="";

	String indexed=request.getParameter("term_group_id")==null?"N":request.getParameter("indexed");
	term_group_id=request.getParameter("term_group_id")==null?"":request.getParameter("term_group_id");
	term_group_desc=request.getParameter("term_group_desc")==null?"":request.getParameter("term_group_desc");

	String term_group_desc1=java.net.URLEncoder.encode(term_group_desc);

	term_set_id=request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	term_set_desc=request.getParameter("term_set_desc")==null?"":request.getParameter("term_set_desc");
	eff_status=request.getParameter("eff_status")==null?"":request.getParameter("eff_status");
	mode=request.getParameter("mode")==null?"":request.getParameter("mode");
	sr_nos=request.getParameter("sr_nos")==null?"":request.getParameter("sr_nos");
	if(mode.equals(""))
		mode="1";

	StringBuffer params = new StringBuffer("../../eMR/jsp/TerminologyGroupAddModify.jsp?mode="+mode);
	StringBuffer param1 = new StringBuffer("../../eMR/jsp/TerminologyGroupAddModifyDetail.jsp?mode="+mode);

if(mode.equals("2"))
{
	params.append("&indexed="+indexed+"&term_group_id="+term_group_id+"&term_group_desc="+term_group_desc1+"&term_set_id="+term_set_id+"&term_set_desc="+term_set_desc+"&eff_status="+eff_status+"&sr_nos="+sr_nos);
	param1.append("&indexed="+indexed+"&term_group_id="+term_group_id+"&term_set_id="+term_set_id+"&eff_status="+eff_status);
}

%>

<html>
	<head>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		
		<script language="JavaScript" src="../js/TerminologyGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		<frameset rows='33%,*%' >
	<frame name='term_set' id='term_set' 	src='<%=params%>' frameborder='0' noresize scrolling='no'>
<%
	if(mode.equals("1"))
	{
	%>
			<frame name='term_associated' id='term_associated' src='../../eCommon/html/blank.html' frameborder='0' scrolling='auto' noresize>
	<%
	}
	else
	{
		%>
		<frame name='term_associated' id='term_associated' src=<%=param1%> frameborder='0' scrolling='auto' noresize>
	<%
	}
		%>
		</frameset>
	</head>
</html>
<%
}
%>

