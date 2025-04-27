<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.net.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
 String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//String locale=(String)session.getAttribute("LOCALE");
	//String facilityId = (String) session.getValue( "facility_id" ) ;
	//Connection connection = null;
	//Statement stmt = null;
	//ResultSet rset = null;

%>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	  
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>       
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<script src='../../eOA/js/OAPatientInstructions.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String patInsTabYN=request.getParameter("patInsTabYN")==null?"N":request.getParameter("patInsTabYN");
	String procInsTabYN=request.getParameter("procInsTabYN")==null?"N":request.getParameter("procInsTabYN");
	String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"N":request.getParameter("rd_appt_yn");//Modified against PMG20089-CRF-0885.3
	String visibilityTab="hidden";
	String displayTab="none";
	if(patInsTabYN.equals("Y") && procInsTabYN.equals("Y")){
		visibilityTab="";
		displayTab="";
	}
%>
<body onKeyDown='lockKey()'>
	<div id='patinsdivtab' style="visibility:<%=visibilityTab%>;display:<%=displayTab%>">
		<form name="patInsTabForm" id="patInsTabForm">
			 <ul id="tablist" class="tablist" >
				<li class="tablistitem" title="Patient Instructions">
						<a onclick="ChangeTabs('patInsTab')" class="tabclicked" id='patInsTab' >
							<span class="tabspanclicked" id="patInsTabspan" >Patient Instructions</span>
					</a>
			</li>
		<li class="tablistitem" title="Procedure Instructions">
			<a onclick="ChangeTabs('procInsTab')" class="tabA" id="procInsTab" >
				<span class="tabAspan" id="procInsTabspan">Procedure Instructions</span>
			</a>
		</li>
	</ul>
	<!--Modified against PMG20089-CRF-0885.3-->
	<input type='hidden' name="rd_appt_yn" id="rd_appt_yn" value="<%=rd_appt_yn%>">
	<script>prevTabObj='patInsTab'</script>
	</div>
</body>
</html>

