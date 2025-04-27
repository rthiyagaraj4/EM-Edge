<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>    
<% request.setCharacterEncoding("UTF-8");	%>
<%@ page contentType="text/html;charset=UTF-8" %>
<HTML>
<%! 
	public String removeNull(String str){
		return (str!=null && str.intern()!="null" && str.intern()!="")?str:"MAIN_MENU";
	}
%>
<head>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<%
String anaesthesiaHistory = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AnaesthesiaHistory.Label","ot_labels");
%>

<title><%=anaesthesiaHistory%> </title>
<%
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<%  
	String called_from = removeNull(request.getParameter("called_from"));
	String facility_id = (String) session.getAttribute("facility_id");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String qry_string =request.getQueryString();
	String params =(called_from.intern()=="MAIN_MENU")?qry_string:qry_string+"&facility_id="+facility_id+"&function_name=Anesthesia History";
	String source = url + params ;
%>
<script language="JavaScript" src="../../eOT/js/AT_AnaesthesiaHistory.js"></script>
<!--<FRAMESET rows='8%,40%,*,15%'>-->
<!-- <FRAMESET rows='8%,*,5%,15%'> -->
<!-- <FRAMESET rows='42,*,5%'>
    <FRAME name="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%=source%>"></FRAME>
		
		<FRAMESET ROWS='24%,*,3%' border='0'>
			<FRAME NAME='SearchCriteriaFrame' SRC="../../eOT/jsp/AT_AnaesthesiaHistoryQryCriteria.jsp?<%=params%>"  scrolling='no' noresize>
			</FRAME>
			<FRAME NAME='ResultFrame' SRC='../../eCommon/html/blank.html'  scrolling='auto' noresize></FRAME>
			<FRAME NAME='content' src="../../eOT/jsp/ContentMessageFrame.jsp"  scrolling='auto' noresize>
			</FRAME>
		</FRAMESET>
<FRAME name="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto"></FRAME>
</FRAMESET> -->

<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize frameborder='0' src="<%=source%>" style='height:6vh;width:97vw'></iframe>		
<iframe NAME='SearchCriteriaFrame' id='SearchCriteriaFrame' SRC="../../eOT/jsp/AT_AnaesthesiaHistoryQryCriteria.jsp?<%=params%>"  scrolling='no' frameborder='0' noresize style='height:18vh;width:100vw;border="0"';></iframe>
<iframe NAME='ResultFrame' id='ResultFrame' SRC='../../eCommon/html/blank.html'  scrolling='auto' noresize frameborder='0' style='height:65vh;width:97vw;border="0"'></iframe> 
<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize frameborder='0' scrolling="auto" style='height:5vh;width:97vw'></iframe>
<body  onKeyDown = 'lockKey();'>
	<form name="AnesthesiaHistoryForm" >
		<input type='hidden' name='params' value='<%=params%>' >
	</form>
</body>
</html>
