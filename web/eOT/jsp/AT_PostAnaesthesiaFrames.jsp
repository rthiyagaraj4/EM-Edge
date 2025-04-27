<!DOCTYPE html>

<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<head>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
</head>

<html>

<%  String params = request.getQueryString(); 
	String tab_id = request.getParameter("tab_id");
	String facility_id=request.getParameter("facility_id");
	String anaesthesia_srl_no=request.getParameter("anesthesia_srl_no");
	String params11 ="facility_id="+facility_id+"&anaesthesia_srl_no="+anaesthesia_srl_no+"&postop_done_yn="+request.getParameter("postop_done_yn");
	
%>

<% if(tab_id.equals("recovery_particulars")){ 	%>
	
		 <iframe NAME='RecordFrame' id='RecordFrame' SRC='../../eOT/jsp/AT_RecoveryParticulars.jsp?<%=params%>'  scrolling='no' noresize='no' style="height:100vh;width:100vw;border=0"></iframe> 
		<!--<FRAME NAME='DetailFrame' SRC='../../eCommon/html/blank.html'   scrolling='no' noresize='no'></FRAME>-->
	
<% } else if(tab_id.equals("reversal")) {  %>
   	
	 <iframe NAME='RecordFrame' id='RecordFrame' SRC=''  scrolling='no' noresize='no' style="height:50vh;width:100vw;border=0"></iframe> 
	 <iframe NAME='DetailFrame' id='DetailFrame' SRC='../../eCommon/html/blank.html'   scrolling='no' noresize='no' style="height:50vh;width:100vw;border=0"></iframe>
	<!--<FRAME NAME='DetailFrame' SRC='../../eOT/jsp/AT_RecoveryParticulars.jsp?'<%=params%>'   scrolling='no' noresize='no'></FRAME>-->
 
 <% } else if(tab_id.equals("complications")) {  %>
	
	<FRAMESET ROWS='56%,*' border='0'>
	<FRAME NAME='MgmtTextAreaFrame' SRC='../../eOT/jsp/ManagementText.jsp?<%=params%>'  scrolling='no' noresize='no'></FRAME> 
    <FRAMESET COLS='50%,*' border='0'>	
	 <FRAME NAME='RecordFrame' SRC='../../eOT/jsp/PostAnaesthesiaComplRecord.jsp?<%=params%>'  scrolling='no' noresize='no'></FRAME> 
	 <FRAME NAME='DetailFrame' SRC='../../eCommon/html/blank.html'   scrolling='auto' noresize='no'>
	</FRAME>
	 </FRAMESET>
 </FRAMESET>

<%} else if(tab_id.equals("personnel_details")) {%>
		
			<iframe name='personal_record_frame'  
			src='../../eOT/jsp/AT_PostAnaesPersonalRecord.jsp?<%=params11%>'  nowrap noresize scrolling='no' style="height:50vh;width:100vw"></iframe> 
			<iframe name='personal_details_frame'  
			src='../../eCommon/html/blank.html'  nowrap noresize scrolling='auto' style="height:50vh;width:100vw"></iframe> 
	

<%}%>
