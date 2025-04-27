<!DOCTYPE html>

<%@ page  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>

<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
		
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/StCommon.js"></script>
<!-- 	<script language="JavaScript" src="../js/StMessages.js"></script> -->
	<script language="JavaScript" src="../js/StockStatusByStore.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
String item_code = request.getParameter("item_code")==null?"":request.getParameter( "item_code" ) ;
		
String store_code = request.getParameter("store_code")==null?"":request.getParameter( "store_code" ) ;
String mode = request.getParameter("mode")==null?"":request.getParameter( "mode" ) ;
String function_id = request.getParameter("function_id")==null?"":request.getParameter( "function_id" );
%>

<iframe name="noDisplayFrame" id="noDisplayFrame" src="../../eCommon/html/blank.html" frameborder="0" scrolling="no" style="height:0%;width:100vw"></iframe>
<iframe name="detailsFrame" id="detailsFrame"  noresize src='../../eST/jsp/StockStatusByStoreList.jsp?item_code=<%=item_code%>&store_code=<%=store_code%>&mode=<%=mode%>&function_id=<%=function_id%>' frameborder="" scrolling="no" style='height:100vh;width:100vw'></iframe>

</html>


