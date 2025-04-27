<!DOCTYPE html>
<!-- 
Sr No        Version              TFS              SCF/CRF           		 Developer Name
-----------------------------------------------------------------------------------------------
1            V210120             7339  	       	MOHE-CRF-0050		         Mohana Priya K
-->

<%-- JSP Page specific attributes start --%>
<%@ page    contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eBL/js/dailycashTabFrame.js'></script>		
<html>
<head>
<%
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String called=request.getParameter("called")==null?"":request.getParameter("called");
	String servGpCode=request.getParameter("servGpCode")==null?"":request.getParameter("servGpCode");
	String servGpDesc=request.getParameter("servGpdesc") == null ? "" :request.getParameter("servGpdesc");	
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<%
    request.setCharacterEncoding("UTF-8");
	String params = request.getQueryString();	
%>
	<iframe name='AssocServtab' id='AssocServtab' id='AssocServtab' src='AssocServGrpTab.jsp?<%=params%>'  frameborder=0 style='height:15vh;width:100vw'></iframe>
	<iframe name='AssocService' id='AssocService' id='AssocService' src='../../eCommon/html/blank.html'  frameborder=0 style='height:85vh;width:100vw'></iframe>	
	<input type='hidden' name='called' id='called' id='called' value='<%=called%>'>
	<input type='hidden' name='servGpCode' id='servGpCode' id='servGpCode' value='<%=servGpCode%>'>
	<input type='hidden' name='servGpdesc' id='servGpdesc' id='servGpdesc' value='<%=servGpDesc%>'>
</html>

