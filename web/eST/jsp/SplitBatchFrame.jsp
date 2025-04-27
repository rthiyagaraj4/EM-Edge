<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import=" java.text.*, java.util.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title> </title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<!-- 	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../eST/js/StMessages.js"></script> -->
		<script language="JavaScript" src="../../eST/js/SplitBatch.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
<%
	eST.SplitBatchBean bean = (eST.SplitBatchBean) getBeanObject( "splitBatchBean", "eST.SplitBatchBean", request  );
	bean.setLanguageId(locale);
 //modified on 23/12
	//bean.clear();
	bean.initialize();
%>

<!--	<frameset rows='20,*'>
		<frame name='frameOpeningStockHeader' id='frameOpeningStockHeader'				src="../../eST/jsp/SplitBatchHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize>
		<frameset cols="30%,*" >
			<frame name='frameOpeningStockDetail' id='frameOpeningStockDetail'			src="../../eST/jsp/SplitBatchListResult.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='auto'   noresize>
			<frame name='frameOpeningStockList' id='frameOpeningStockList'			src="../../eST/jsp/SplitBatchListFrame.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='no' noresize>
			</frameset>
		</frameset>

	</frameset>  -->
	<iframe name='frameOpeningStockHeader' id='frameOpeningStockHeader'				src="../../eST/jsp/SplitBatchHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:4vh;width:100vw'></iframe>
	<iframe name='frameOpeningStockDetail' id='frameOpeningStockDetail'			src="../../eST/jsp/SplitBatchListResult.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='auto'   noresize style='height:94vh;width:28vw'></iframe>
	<iframe name='frameOpeningStockList' id='frameOpeningStockList'			src="../../eST/jsp/SplitBatchListFrame.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='auto' noresize style='height:94vh;width:70vw'></iframe>
<%
putObjectInBean("splitBatchBean",bean,request);
%>
</html>

