<!DOCTYPE html>
 <%@ page contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
String item_code = request.getParameter("item_code")==null?"":request.getParameter( "item_code" ) ;
String doc_type_code = request.getParameter("doc_type_code")==null?"":request.getParameter( "doc_type_code" ) ;
String doc_no = request.getParameter("doc_no")==null?"":request.getParameter( "doc_no" ) ;

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
<!-- 	<script language="JavaScript" src="../js/StMessages.js"></script> -->
	<script language="JavaScript" src="../js/GRNHistoy.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="eST.ReplacementRTVDetailsForItem.label" bundle="${st_labels}"/> : &nbsp;<%=item_code%>&nbsp; <%=doc_type_code%>/<%=doc_no%></title>
</head>

<iframe name="noDisplayFrame" id="noDisplayFrame" src="../../eCommon/html/blank.html" frameborder="0"  style="height:0%;width:100vw"></iframe><iframe name="detailsFrame" id="detailsFrame"  
	noresize src='../../eST/jsp/GRNHistoryReplDtls.jsp?item_code=<%=item_code%>&doc_type_code=<%=doc_type_code%>&doc_no=<%=doc_no%>' frameborder="0" scrolling="no" style='height:100vh;width:100vw'></iframe>

</html>

