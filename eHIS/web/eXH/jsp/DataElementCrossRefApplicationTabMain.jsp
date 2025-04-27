<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); 
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	
	String source = url + params ;

   
%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<script language='JavaScript' src='../../eXH/js/DataElementCrossRefLayer.js'></script>  
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script language='JavaScript' src='../../eXH/js/Validate.js'></script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 
 </head>   
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'src=<%=source%> frameborder=0 scrolling='no' noresize style='height:7.5vh;width:100vw'></iframe>
		<iframe name='applmenubar' id='applmenubar' src='../../eXH/jsp/DataElementCrossRefApplicationTab.jsp?source=<%=source%>' frameborder=0 noresize scrolling='no' style='height:7.5vh;width:100vw'></iframe>
		<iframe name='applicationframe' id='applicationframe' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto'  style='height:80vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='no' style='height:5vh;width:100vw'></iframe>
</html>                          

