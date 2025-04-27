<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.ChartComponents.label" bundle="${ca_labels}"/></title>
		<script src="../../eCA/js/ChartComponent.js" language='javascript'></script> 
		<script src="../../eCommon/js/common.js" language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>
	<%  
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?";
		String param = request.getQueryString();
		String source = url+param;
	%>
<!---	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' noresize scrolling='no' style='height:8vh;width:100vw'></iframe>
	
			<iframe name='chartComponentHeaderFrame' id='chartComponentHeaderFrame' src='../../eCA/jsp/blank.jsp' scrolling='no' frameborder=0 noresize style='height:8vh;width:100vw'></iframe>
			<iframe name='chartComponentListFrame' id='chartComponentListFrame' src='../../eCA/jsp/blank.jsp' scrolling='auto' frameborder=0  style='height:90vh;width:100vw'></iframe>
		
		<iframe name='blankFrame' id='blankFrame' src='../../eCommon/html/blank.html' scrolling='no' frameborder=0 noresize style='height:0vh;width:100vw'></iframe>
		<iframe name='blankFrame2' id='blankFrame2' src='../../eCommon/html/blank.html' scrolling='no' frameborder=0 noresize style='height:0vh;width:100vw'></iframe>
		<iframe name='blankFrame3' id='blankFrame3' src='../../eCommon/html/blank.html' scrolling='no' frameborder=0 noresize style='height:0vh;width:100vw'></iframe>
		<iframe name='blankFrameAddPanel' id='blankFrameAddPanel' src='../../eCommon/html/blank.html' scrolling='no' frameborder=0 style='height:0vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' scrolling='no' frameborder=0 noresize style='height:9vh;width:100vw'></iframe>
		<iframe name='blankFrameSumDef' id='blankFrameSumDef' src='../../eCA/jsp/ChartComponentBeanIntermediate.jsp' scrolling='no' frameborder=0 noresize style='height:0vh;width:100vw'></iframe> 
--->
	<frameset rows='8%,*,0%,0%,0%,0%,10%,0%'>
		<frame name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder='0' noresize scrolling='no'></frame>
		<frameset rows='8%,*'>
			<frame name='chartComponentHeaderFrame' id='chartComponentHeaderFrame' src='../../eCA/jsp/blank.jsp' scrolling='no' frameborder=0 noresize></frame>
			<frame name='chartComponentListFrame'  id='chartComponentListFrame' src='../../eCA/jsp/blank.jsp' scrolling='auto' frameborder=0 ></frame>
		</frameset>
		<frame name='blankFrame' id='blankFrame' src='../../eCommon/html/blank.html' scrolling='no' frameborder=0 noresize></frame>
		<frame name='blankFrame2' id='blankFrame2' src='../../eCommon/html/blank.html' scrolling='no' frameborder=0 noresize></frame>
		<frame name='blankFrame3' id='blankFrame3' src='../../eCommon/html/blank.html' scrolling='no' frameborder=0 noresize></frame>
		<frame name='blankFrameAddPanel' id='blankFrameAddPanel' src='../../eCommon/html/blank.html' scrolling='no' frameborder=0 ></frame>
		<frame name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' scrolling='no' frameborder=0 noresize></frame>
		<frame name='blankFrameSumDef' id='blankFrameSumDef' src='../../eCA/jsp/ChartComponentBeanIntermediate.jsp' scrolling='no' frameborder=0 noresize></frame> 
	</frameset>
</html>

