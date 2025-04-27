<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
		
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
<script language='javascript' src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src="../../eST/js/ProductComplaint.js"></script>
<script language='javascript' src="../../eST/js/StCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<%
//String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
//String params = request.getQueryString() ;
//String source = url + params ;

%>

<iframe name="frameProductComplaintCriteria" id="frameProductComplaintCriteria" frameborder="0" scrolling="no" noresize src="../../eST/jsp/ProductComplaintCriteria.jsp" style="height:80%;width:100vw"></iframe><iframe name="frameProductComplaintResult" id="frameProductComplaintResult" src="../../eCommon/html/blank.html" frameborder="0" noresize scrolling="0" style="height:100vh;width:100vw"></iframe>

</html>

