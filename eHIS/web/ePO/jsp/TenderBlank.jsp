<!DOCTYPE html>
<%@ page import=" ePO.TenderBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>

	<script language="JavaScript" src="../../ePO/js/Tender.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>


<form name='hideForm' id='hideForm'>
		<img id='hideImg' style='cursor:pointer;position:relative;top:250px;left:0px;width=15px;'  src='../../eST/images/POleft.png' onclick="resizeFrames()" />

</form>

</html>


