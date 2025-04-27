<!DOCTYPE html>
<html>
<%@ page import= "java.net.*,eCommon.XSSRequestWrapper" buffer="8kb" autoFlush="false" contentType="text/html;charset=UTF-8" %>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		String tabInd= request.getParameter("tabIndicator");
		String s=request.getQueryString();
		%>
		<iframe name='processBar' frameborder=0  noresize  scrolling='no' style='height:0vh;width:99vw;display: none;'></iframe>
		<iframe name='criteria0' src='../../eCommon/html/blank.html' frameborder=0  scrolling='no'style='height:0vh;width:99vw;display: none;'></iframe>
		
		<%
		if (tabInd.equals("others_tab")){
	    %>
			<iframe name='pat_result' src='../../eAE/jsp/AEManagePatGIWaitListResult.jsp?<%=s%>' frameborder=0  scrolling='yes'style='height:87vh;width:99vw'></iframe>		
			<!-- <frame name='result' src='../../eAE/jsp/AEManagePatGIFrameLayer.jsp?<%=s%>' frameborder=0  scrolling='yes'> -->
			<iframe name='result' src='../../eCommon/html/blank.html' frameborder=0  scrolling='no'style='height:0vh;width:99vw;display: none;'></iframe>
		<%}else if(tabInd.equals("char_tab")){
			%>
			<iframe name='result' src='../../eAE/jsp/AEManagePatGIFrameLayer.jsp?<%=s%>' frameborder=0  scrolling='yes'style='height:87vh;width:99vw'></iframe>
	      <!--   <frame name='pat_result' src='../../eAE/jsp/AEManagePatGIWaitListResult.jsp?<%=s%>' frameborder=0  scrolling='yes'>	 -->	
	        <iframe name='pat_result'src='../../eCommon/html/blank.html' frameborder=0  scrolling='no'style='height:0vh;width:99vw;display: none;'></iframe>		
	    <%}%>
			<iframe name='status' src='../../eAE/jsp/BedColorStandard.jsp' frameborder=0 noresize scrolling='no'style='height:6vh;width:99vw'></iframe>
			<iframe name='dummy_frame' src='../../eCommon/jsp/error.jsp' frameborder=0  scrolling='no'style='height:0vh;width:99vw;display: none;'></iframe>
	<script>

	if("<%=tabInd%>"=="others_tab"){ 
	
		//parent.AEMPSearchResultFrame.frameSetId.rows='0%,0%,*,0%,6%,0%';
	}
	else{
	
		//parent.AEMPSearchResultFrame.frameSetId.rows='0%,0%,*,%0,6%,0%';
	}
	</script>

<%! 

public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}

%>

</html>