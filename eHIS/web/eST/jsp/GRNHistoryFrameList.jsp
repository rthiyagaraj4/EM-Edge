<!DOCTYPE html>
	<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String doc_type_code = request.getParameter("doc_type_code")==null?"":request.getParameter( "doc_type_code" ) ;
String doc_no = request.getParameter("doc_no")==null?"":request.getParameter( "doc_no" ) ;
String item_code = request.getParameter("item_code")==null?"":request.getParameter( "item_code" ) ;

%>

<html>

<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<%
request.setCharacterEncoding("UTF-8");

		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/StCommon.js"></script>
	<!-- <script language="JavaScript" src="../js/StMessages.js"></script> -->
	<script language="JavaScript" src="../js/GRNHistoy.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="eST.RTVDetailsforReplacementGRN.label" bundle="${st_labels}"/> <%=doc_type_code%>/<%=doc_no%>(<%=item_code%>)</title>
</head>

<iframe name="noDisplayFrame" id="noDisplayFrame" src="../../eCommon/html/blank.html" frameborder="0"  style="height:10vh;width:99vw"></iframe><iframe name="detailsFrame" id="detailsFrame"  
	noresize src='../../eST/jsp/GRNHistoryRTVList.jsp?item_code=<%=item_code%>&doc_type_code=<%=doc_type_code%>&doc_no=<%=doc_no%>' frameborder="0" scrolling="auto" style='height:85vh;width:99vw'></iframe>

</html>

