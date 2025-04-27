<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page import="eCommon.XSSRequestWrapper" %>
<html>
	<head>
	<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language='javascript' src='../../eST/js/Acknowledgment.js'></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function_id = "<%= request.getParameter( "function_id" ) %>"  
			menu_id		= "<%= request.getParameter( "menu_id" ) %>"
			module_id	= "<%= request.getParameter( "module_id" ) %>"
			//Added by Sakti against BRU-HIMS-CRF-073.1
			store_code	= "<%= request.getParameter( "store_code" ) %>"
			trn_name	= "<%= request.getParameter( "trn_name" ) %>"
			//Added ends  
		</script>
	</head>

	<%
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
	 
		eST.AcknowledgmentBean bean = (eST.AcknowledgmentBean)getBeanObject( "acknowledgmentBean","eST.AcknowledgmentBean",request );
		if(!(bean.getAckReqd())) {
			out.println("<script>alert(getMessage('ACK_NOT_APPLICABLE','ST'));window.location.href ='../../eCommon/jsp/dmenu.jsp;'</script>");
		}	
		//eST.OTTransactionBean bean1 = (eST.OTTransactionBean)getBeanObject( "ottransactionbean","eST.OTTransactionBean",request );
		bean.setLanguageId(locale);
		//bean1.setLanguageId(locale);
		//bean1.initialize();
		//bean1.requestForOT(new HashMap(),bean1.getConnection());
	%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="<%= source %>" frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eCommon/html/blank.html" frameborder=0 scrolling='no' style='height:82vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:10;width:100vw'></iframe>
	<%
		putObjectInBean("acknowledgmentBean",bean,request);
	%>
</html>
<script>
if(trn_name != "null" && trn_name != "")
create();
</script> 

