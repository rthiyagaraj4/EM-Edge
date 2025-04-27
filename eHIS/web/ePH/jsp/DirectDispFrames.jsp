<!DOCTYPE html>
 <html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*,  ePH.Common.* , eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>  	
	<script language="JavaScript" src="../../ePH/js/DirectDispensing.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script> 
	
</head>
   <%
      String params			= request.getQueryString() ;
   %>
	<iframe name="f_header" id="f_header" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DirectDispOrdHeader.jsp?<%= params %>"  style="height:9vh;width:100vw"></iframe>
	<iframe name="f_ord_detail" id="f_ord_detail" frameborder="0" scrolling="no" class="CATHIRDWORKAREA1" noresize  src="../../ePH/jsp/DirectDispOrderFrames.jsp"  style="height:70vh;width:100vw"></iframe>
	<iframe name ="f_disp_detail" id ="f_disp_detail"  frameborder="0" noresize scrolling="no"  src="../../ePH/jsp/DirectDispDetailFrames.jsp?" style="height:35vh;width:100vw"></iframe>

</html>

