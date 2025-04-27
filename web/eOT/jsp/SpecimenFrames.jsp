<!DOCTYPE html>
<%@page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String tab = checkForNull(request.getParameter("tab")); 
//System.err.println("tab--->"+tab);
String rows_value = "";
if(("record_nursing".equals(tab)))
{
	rows_value="30%,*";
}
else{
	rows_value="43%,*";
}
//System.err.println("rows_value---->"+rows_value);
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>




<% String params = request.getQueryString(); %>
<FRAMESET ROWS='<%=rows_value%>' border='0'>	
	    <FRAME name='RecordFrame' id='RecordFrame' SRC='../../eOT/jsp/SpecimenRecord.jsp?<%=params%>'  scrolling='no' noresize='no'></FRAME> 
	    <!--<FRAME name='DetailFrame' id='DetailFrame' SRC='../../eOT/jsp/SpecimenDtls.jsp?<%=params%>' 			   scrolling='no' noresize='no'></FRAME>-->
		<FRAME name='DetailFrame' id='DetailFrame' SRC='../../eCommon/html/blank.html'   scrolling='no' noresize='no'></FRAME>
 </FRAMESET>

