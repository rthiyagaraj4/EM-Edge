<!DOCTYPE html>
<!--Created by Thamizh selvi on 29th Mar 2017 against GDOH-CRF-0124-->
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html> 
<head>
    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eIP/js/IPCancelTransfer.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	
	Connection con	= null;
	String facilityId=(String)session.getValue("facility_id");
	String userId=(String)session.getValue("login_user");
	
	con = ConnectionManager.getConnection(request);
		
	String isCancelTrfInAllowed = eIP.IPCancelTransferBean.MRUserLevelRestriction(con,facilityId,userId);

	isCancelTrfInAllowed	= checkForNull(isCancelTrfInAllowed,"N");

	if(isCancelTrfInAllowed.equals("N"))
	{
		out.print(" <script>alert(getMessage('CANCEL_TRF_USER_RESTRICTION','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
	}
	else{
	%>

		<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
			<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eIP/jsp/IPCancelTransferCriteria.jsp?' frameborder='0' scrolling='no'  noresize  style='height:20vh;width:100vw'></iframe><iframe name='f_query_add_mod1' id='f_query_add_mod1' src='../../eCommon/html/blank.html' frameborder='0' scrolling='no'  noresize  style='height:60vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>

	<%
	} %>
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
</html>

