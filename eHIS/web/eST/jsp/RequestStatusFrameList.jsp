<!DOCTYPE html>
<!-- This Page is invoked when a user select Item For Store  from the menu -->
<%@page  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
request.setCharacterEncoding("UTF-8");
		
	String doc_type_desc = request.getParameter("doc_type_desc")==null?"":request.getParameter( "doc_type_desc" ) ;
	String doc_type_code = request.getParameter("doc_type_code")==null?"":request.getParameter( "doc_type_code" ) ;
	//Added by rabbani #inc no:45231 on 28-NOV-2013
	String store_code    = request.getParameter("store_code")==null?"": request.getParameter( "store_code" ) ;
		
	String doc_no = request.getParameter("doc_no")==null?"":request.getParameter( "doc_no" ) ;
	String function_id = request.getParameter("function_id")==null?"":request.getParameter( "function_id" ) ;
%>
<head>
	<title><fmt:message key="eST.RequestItemDetailsfor.label" bundle="${st_labels}"/> <%=doc_type_desc%>/<%=doc_no%>&nbsp;&nbsp;</title>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<!-- <script language="JavaScript" src="../../eST/js/StMessages.js"></script> -->
	<script language='javaScript' src="../../eST/js/RequestStatus.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
       
		menu_id		= "<%= request.getParameter( "menu_id" ) %>"
		module_id	= "<%= request.getParameter( "module_id" ) %>"
    </script>
</head>
<iframe name="noDisplayFrame" id="noDisplayFrame" src="../../eCommon/html/blank.html" frameborder="0" scrolling="no" style="height:0vh;width:100vw"></iframe><iframe name="detailsFrame" id="detailsFrame"  
	noresize src='../../eST/jsp/RequestStatusList.jsp?doc_type_code=<%=doc_type_code%>&doc_no=<%=doc_no%>&store_code=<%=store_code%>&function_id=<%=function_id%>' frameborder="" scrolling="auto" style='height:96vh;width:100vw'></iframe>
</html>


