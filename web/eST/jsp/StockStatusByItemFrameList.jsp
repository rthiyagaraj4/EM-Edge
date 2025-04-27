<!DOCTYPE html>
<%@ page import=" eST.*, eST.Common.* , eCommon.Common.*,  java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String item_code = request.getParameter("item_code")==null?"":request.getParameter( "item_code" ) ;
String move_year = request.getParameter("move_year")==null?"":request.getParameter( "move_year" ) ;
String move_year1 = request.getParameter("move_year1")==null?"":request.getParameter( "move_year1" ) ;
String move_month = request.getParameter("move_month")==null?"":request.getParameter( "move_month" ) ;
String language_id = request.getParameter("language_id")==null?"":request.getParameter( "language_id" ) ;
String store_code_from = request.getParameter("store_code_from")==null?"":request.getParameter( "store_code_from" ) ;
String store_code_to = request.getParameter("store_code_to")==null?"":request.getParameter( "store_code_to" ) ;
String cost_access			=			request.getParameter( "cost_access" )==null?"":request.getParameter( "cost_access" );

%>

<html>

<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
		
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/StCommon.js"></script>
	<!-- <script language="JavaScript" src="../js/StMessages.js"></script> -->
	<script language="JavaScript" src="../js/StockStatusByStore.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="eST.StorewiseConsumptionforthePeriod.label" bundle="${st_labels}"/> <%=move_month%>/<%=move_year1%></title>
</head>

<iframe name="noDisplayFrame" id="noDisplayFrame" src="../../eCommon/html/blank.html" frameborder="0"  style="height:0vh;width:100vw"></iframe>
<iframe name="detailsFrame" id="detailsFrame"  noresize src='../../eST/jsp/StockStatusByItemList.jsp?item_code=<%=item_code%>&move_month=<%=move_month%>&move_year=<%=move_year%>&language_id=<%=language_id%>&store_code_from=<%=store_code_from%>&store_code_to=<%=store_code_to%>&cost_access=<%=cost_access%>' frameborder="0" scrolling="no" style='height:100vh;width:100vw'></iframe>

</html>
<!-- &move_month=<%=move_month%>&move_year="<%=move_year%> -->

