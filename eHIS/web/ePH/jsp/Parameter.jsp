
  <!--This file is saved on 07/11/2005-->
<!-- 
Developed by    : P.Sudhakaran.
Module/Function : 
-->

<html>
<head>
    <!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
    <script language="JavaScript" src="../js/PhCommon.js"></script>
    <script language="JavaScript" src="../js/Parameter.js"></script>
<!--     <script language="JavaScript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 --></head>

<%
    String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
    String params = request.getQueryString() ;
    String source = url + params ;
%>
<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:7vh;width:100vw"></iframe>
<iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/ParameterAddModifyHeader.jsp" style="height:42vh;width:100vw"></iframe>
<iframe name="f_query_details" id="f_query_details" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:40vh;width:100vw"></iframe>
<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:9vh;width:100vw"></iframe>

</html>


