<!DOCTYPE html>
<%@page import="java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title>RuleBasedTransfer</title>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
		request.setCharacterEncoding("UTF-8");	
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");		
		String s=request.getQueryString();	
%>
		
				<iframe name='RuleBasedTransfer_criteria' id='RuleBasedTransfer_criteria' src='RuleBasedTransferCriteria.jsp?<%=s%>' frameborder=0 scrolling='no' noresize style='height:40vh;width:100vw'></iframe>	
					<iframe name='RuleBasedTransfer_result' id='RuleBasedTransfer_result' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:50vh;width:100vw'></iframe>				
					<iframe name='RuleBasedTransfer_msgFrame' id='RuleBasedTransfer_msgFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:10vh;width:100vw'></iframe>				
						
</html>

