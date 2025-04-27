<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import=" java.text.*, java.util.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eST.StockStatusByItem.label" bundle="${st_labels}"/></title>
		<%
		request.setCharacterEncoding("UTF-8");
		
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
<!-- 		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
 -->		<!-- <script language="JavaScript" src="../../eST/js/StMessages.js"></script> -->
		<script language="JavaScript" src="../../eST/js/StockStatusByItem.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/PhyInvForSpecificItem.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<!--<frameset rows='24%,*,62'>  -->
<iframe name="f_adding_criteria" id="f_adding_criteria" frameborder="0" scrolling="no" noresize src= "../../eCommon/html/blank.html" style='height:32vh;width:100vw'></iframe>
<iframe name='f_added_value' id='f_added_value'	src="../../eCommon/html/blank.html" frameborder=0 scrolling='auto' noresize style='height:58vh;width:100vw'></iframe>
<!--<frame name='f_adding_Remarks' id='f_adding_Remarks' src="../../eST/jsp/PhyInvForSpecificItemAddingRemarks.jsp" frameborder=0 
scrolling='no'  noresize>-->
<iframe name='f_adding_Remarks' id='f_adding_Remarks' src="../../eCommon/html/blank.html" frameborder=0 
scrolling='no'  noresize style='height:10vh;width:100vw'></iframe>

</html>

