<!DOCTYPE html>
<%@ page import = "eCommon.XSSRequestWrapper" contentType=" text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<head>
<title><fmt:message key="eOT.PatientSurgeryHistory.Label" bundle="${ot_labels}"/> </title>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%! 
	public String removeNull(String str){
		return (str!=null && str.intern()!="null" && str.intern()!="")?str:"MAIN_MENU";
	}

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
	<script type='text/javascript' src='../../eOT/js/SurgeryHistory.js'></script>
	<!-- <script src="../../eCommon/js/messages.js" language="javascript"></script>
	<script src="../../eOT/js/OTMessages.js" language="javascript"></script> -->
</head>
<%  
	//String facility_id  = (String) session.getValue("facility_id");
	//String login_user = (String) session.getValue("login_user");
	String called_from = removeNull( request.getParameter("called_from"));
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params="";
	String source ="";

	if( "OPER_REG".equals(called_from) || "OT_SLATE".equals(called_from)  ){
		params=request.getQueryString()+"&home_required_yn=N";
	}else{
		params = request.getQueryString();
	source = url + request.getQueryString() ;

	}
		if(source.equals("")){
		source=url+params;
		}
%>
    <iframe name="commontoolbarFrame" id='commontoolbarFrame' frameborder="0" scrolling="no" noresize src="<%=source%>" style='height:6vh;width:100vw' ></iframe>
	<iframe NAME='SearchCriteriaFrame' id='SearchCriteriaFrame' SRC='../../eOT/jsp/SurgeryHistoryQryCriteria.jsp?<%=params%>'  scrolling='no' noresize style='height:14vh;width:100vw;border:0'></iframe>
	<iframe NAME='ResultFrame' id='ResultFrame' SRC='../../eCommon/html/blank.html'  scrolling='auto' noresize style='height:68vh;width:100vw;border:0'></iframe>
	<iframe NAME='content' id='content' src="../../eOT/jsp/ContentMessageFrame.jsp"  scrolling='auto' noresize style='height:0vh;width:100vw;border:0'></iframe>
	<iframe name="messageFrame" id='messageFrame' src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style='height:9vh;width:100vw'></iframe>
<body  onKeyDown = 'lockKey();'>
	<form name="SurgeryHistoryForm"  id="SurgeryHistoryForm" >
		<input type='hidden' name='params' id='params' value='<%=params%>' >
		<input type='hidden' name='called_from' id='called_from' value='<%=called_from%>' >
	</form>
</body>
</html>
