<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import= "java.util.*,java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8");  %>
<html>
<head>
	<title><fmt:message key="eOA.SecondaryResources.label" bundle="${oa_labels}"/></title>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>                         
<%
		String excludePract  =	request.getParameter("excludePract");
		String practCount  =	request.getParameter("practCount")==null?"0":request.getParameter("practCount");
		String clinic_code  =	request.getParameter("clinic_code")==null?"":request.getParameter("clinic_code");
		String appt_id  =	request.getParameter("appt_id")==null?"":request.getParameter("appt_id");
		String practList  =	request.getParameter("practList")==null?"":request.getParameter("practList");
		String curpractid  =	request.getParameter("curpractid")==null?"":request.getParameter("curpractid");
		if ((excludePract==null) || (excludePract.equals("null")))  excludePract = "";
%>
<frameset rows="20%,*,9%,5%">
                           
	<frame name='criteria_frame' id='criteria_frame' src="../../eOP/jsp/SecResCriteria.jsp?excludePract=<%=excludePract%>&practCount=<%=practCount%>&clinic_code=<%=clinic_code%>&appt_id=<%=appt_id%>&practList=<%=practList%>&curpractid=<%=curpractid%>" frameborder=0 noresize scrolling='auto'> </frame>
	<frame name='contents_frame' id='contents_frame'	src='../../eCommon/html/blank.html?' frameborder=0 noresize scrolling='auto'></frame>
	<frame name='buttons_frame' id='buttons_frame'	src='../../eCommon/html/blank.html?' frameborder=0 noresize scrolling='auto'></frame>
	<frame name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/error.jsp?' frameborder=0 noresize scrolling='no'></frame>
</frameset>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

