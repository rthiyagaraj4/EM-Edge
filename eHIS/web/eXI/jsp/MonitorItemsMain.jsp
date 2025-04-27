<!DOCTYPE html>
<html>			 
<head>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>

<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eXI/js/MonitorItems.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 
</head>
<% 
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String moduleID = request.getParameter("module_id");
	String source = url + params ;
	String siteID = request.getParameter("site_id");
	session.setAttribute("intSiteID",siteID);
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%= source %>' frameborder=0 scrolling='no' noresize style='height:4vh;width:100vw'></iframe>
	<iframe name='schemaBrowserQueryFrame' id='schemaBrowserQueryFrame' src="../../eXI/jsp/MonitorItemsQueryCriteria.jsp?moduleID=<%=moduleID%>" frameborder=0 noresize scrolling='no' style='height:4vh;width:100vw'></iframe>
	<iframe name='monitorItemsMoreCriteria' id='monitorItemsMoreCriteria' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
	<iframe name='schemaBrowserResultFrame' id='schemaBrowserResultFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:48vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:6vh;width:100vw'></iframe>
<input type="hidden" id="siteID" name="siteID" id="siteID" value="<%= siteID %>">

</html>

																	   		    

