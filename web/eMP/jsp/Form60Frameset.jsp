<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<Script language='javascript' src='../../eCommon/js/common.js'></Script>
<Script language='javascript' src='../../eMP/js/Form60.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	request.setCharacterEncoding("UTF-8");
    String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
    String params = request.getQueryString() ;
    String source = url + params ;
	
	
					   

							 
							 %>
								</head>
								
								<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
									<iframe name='searchCriteria' id='searchCriteria' src='../../eMP/jsp/Form60Criteria.jsp' frameborder=0  scrolling='auto' style='height:15vh;width:100vw'></iframe>
									<iframe name='SearchResults' id='SearchResults' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:68vh;width:100vw'></iframe>
									<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
									<iframe name='dummyform' id='dummyform' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:0vh;width:100vw'></iframe>
							 <%			
					%>
</html>

