<!DOCTYPE html>
<!-- 
Sr No        Version           Incident             SCF/CRF             Developer Name
--------------------------------------------------------------------------------------
1            V210623            16777	      PMG2021-COMN-CRF-0076      Palani Narayanan
2            V210730            16777	      PMG2021-COMN-CRF-0076      Mohana Priya
3			V230106				36652			TH-KW-CRF-0145.1			Mohanapriya
 -->
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>


<HTML>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language='javascript' src='../../eBL/js/json2.js'></script>
	
<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eBL/js/MaintainTreamentPackage.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
	String params = request.getQueryString();
	System.err.println("params--"+params);
	if(params==null || params.equals("")) params="";
	String function_id=request.getParameter("function_id");
	String module_id=request.getParameter("module_id");
	if(function_id==null || function_id.equals("")) function_id="";
	
	String calledFrom=request.getParameter("calledFrom");//V230106
	if(calledFrom==null || calledFrom.equals("")) calledFrom="";
	System.err.println("calledFrom MaintainTreatmentPackMain.jsp--"+calledFrom);
	String url ="";
    String height1, height2, height3, height4, height5, height6;
	if(calledFrom.equals("managePatientPopup")){
		url = "../../eCommon/jsp/MstCodeToolbar.jsp?home_required_yn=N";
		height1 = "6vh";  
        height2 = "9vh";   
        height3 = "8vh"; 
        height4 = "35vh";   
        height5 = "35vh";   
        height6 = "8vh";  
		%>
		<!-- <FRAMESET ROWS ='6%,7%,7%,36%,35%,9%' framespacing=0 name='BLMaintaintreatmentPackageframeset'> -->
		<%
	}else{
		url = "../../eCommon/jsp/MstCodeToolbar.jsp?home_required_yn=Y";
		height1 = "6vh";  
        height2 = "9vh";  
        height3 = "8vh";   
        height4 = "35vh";   
        height5 = "35vh";   
        height6 = "5vh";   
		%>
		<!-- <FRAMESET ROWS ='6%,7%,7%,36%,39%,5%' framespacing=0 name='BLMaintaintreatmentPackageframeset'> -->
		<%
	}//V230106
	
	String source = url + params;
	System.err.println("source MaintainTreatmentPackMain.jsp "+source);
%>
<!--<FRAMESET ROWS ='6%,7%,7%,36%,39%,5%' framespacing=0 name='BLMaintaintreatmentPackageframeset'>-->
	<%-- <FRAME name='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no'  noresize>
	<FRAME name='BLMaintaintreatmentPackagepat' src='../../eBL/jsp/MainTreatmentPackageHdr.jsp?<%=params%>' frameborder=0>
	<FRAME name='BLMaintaintreatmentPackageHdr' src='../../eCommon/html/blank.html' frameborder=0  >
	<FRAME name='BLMaintaintreatmentPackage' src='../../eCommon/html/blank.html' frameborder=0  scrolling='auto'>
	<FRAME name='BLMaintaintreatmentPackageserv' src='../../eCommon/html/blank.html' frameborder=0  scrolling='auto'>
	<FRAME name='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'>
	
</FRAMESET> --%>
		<iframe name="commontoolbarFrame" src="<%= source %>" frameborder="0" scrolling="no" noresize style="height:<%= height1 %>; width:100vw"></iframe> 
		<iframe name="BLMaintaintreatmentPackagepat" src="../../eBL/jsp/MainTreatmentPackageHdr.jsp?<%=params%>" frameborder="0" style="height:<%= height2 %>; width:100vw"></iframe>
		<iframe name="BLMaintaintreatmentPackageHdr" src="../../eCommon/html/blank.html" frameborder="0" style="height:<%= height3 %>; width:100vw"></iframe>
		<iframe name="BLMaintaintreatmentPackage" src="../../eCommon/html/blank.html" frameborder="0" scrolling="auto" style="height:<%= height4 %>; width:100vw"></iframe>
		<iframe name="BLMaintaintreatmentPackageserv" src="../../eCommon/html/blank.html" frameborder="0" scrolling="auto" style="height:<%= height5 %>; width:100vw"></iframe>
		<iframe name="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:<%= height6 %>; width:100vw"></iframe>
</HTML>
