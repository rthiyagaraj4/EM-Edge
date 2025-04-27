<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../../eBL/js/BLReprintReport.js'></script>
<!--<script language='javascript' src='../../eBL/js/BLReprintBtn.js'></script>-->
<HTML>
	<HEAD>
	<TITLE>
		<%=request.getParameter("title")%>
	<%
	String includeBanner = request.getParameter("includeBanner");
	%>	
	</TITLE>
	<script>
	function refresh(){
		search_hdr.document.location.href = '../../eBL/jsp/BLReprintReportHdr.jsp'
		body_frame.document.location.href = "../../eCommon/html/blank.html";
		dummy_frame.document.location.href = '../../eCommon/html/blank.html';
		selectedFrame.document.location.href = '../../eBL/jsp/BLReprintSelected.jsp';
		buttonFrame.document.location.href = '../../eBL/jsp/BLReprintBtn.jsp';
		messageFrame.document.location.href = '../../eCommon/jsp/error.jsp';
	}

	function closeWindow(){
		//window.close();
		const dialogTag = parent.parent.document.getElementById("dialog_tag");    
		dialogTag.close(); 
	}
	</script>
    </HEAD> 
    <%if("Y".equals(includeBanner)){ %>
	      <!--<FRAMESET framespacing="0" frameborder="0" ROWS="16%,20%,27%,3%,26%,4%,4%"  align = "center">-->
	      <!--	<IFrame src='../../eBL/jsp/BLCommonMenuFrame.jsp' name='menu_frame' id='menu_frame' frameborder=0 noresize style="height:16vh;width:100vw"></IFRAME>-->
		  
			<IFRAME SRC= '../../eBL/jsp/BLReprintReportHdr.jsp' name="search_hdr" id="search_hdr" frameborder=0 noresize scrolling='no' style="height:40vh;width:98vw"></IFRAME>											
			<IFRAME SRC="../../eCommon/html/blank.html"	  name="body_frame" id="body_frame" frameborder=0 noresize style="height:29vh;width:98vw"></IFRAME>
			
	<%}
    else{%>
    	<!--<FRAMESET framespacing="0" frameborder="0" ROWS="30%,29%,3%,30%,4%,4%"  align = "center">-->
    <%} %>
			<IFRAME SRC= '../../eBL/jsp/BLReprintReportHdr.jsp' name="search_hdr" id="search_hdr" frameborder=0 noresize scrolling='no' style="height:39vh;width:98vw"></IFRAME>											
			<IFRAME SRC="../../eCommon/html/blank.html"	  name="body_frame" id="body_frame" frameborder=0 noresize style="height:22vh;width:98vw"></IFRAME>
			<IFRAME NAME="dummy_frame" ID="dummy_frame"  src='../../eCommon/html/blank.html'	 frameborder=0 noresize scrolling='no' style="height:0vh;width:98vw"></IFRAME>
			<iframe SRC="../../eBL/jsp/BLReprintSelected.jsp"	  name="selectedFrame" id="selectedFrame" frameborder=0 noresize style="height:19vh;width:98vw"></iframe>
		<iframe SRC="../../eBL/jsp/BLReprintBtn.jsp"	  name="buttonFrame" id="buttonFrame" frameborder=0 noresize  style="height:9vh;width:98vw"></iframe>
		
	   
</HTML>

