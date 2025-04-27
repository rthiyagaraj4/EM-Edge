<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title>RecClinicalNotesPTEditor</title>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCA/js/RecClinicalNotesPart1.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<style type='text/css'>
	ADDRESS{FONT-FAMILY:Verdana;FONT-SIZE: 9pt ;font-style: NORMAL;COLOR: BLACK;}
</style>
</head>
<body onLoad = 'callMeOnLoad()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
<%
	String RTEText		=	"";

	RTEText				=	request.getParameter("RTEText");
	if(RTEText == null || RTEText.equals("null")) RTEText = "";
	if(RTEText.equals(""))
	RTEText	=	"<style type='text/css'>ADDRESS{font-style: normal; FONT-FAMILY: Verdana ;FONT-SIZE: 9pt ;COLOR: BLACK;}P{FONT-FAMILY:Verdana;FONT-SIZE: 9pt ;font-style: NORMAL;COLOR: BLACK;}</style><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' style=\"font-size:9pt;font-face:Verdana;\" ></body>";
	RTEText				=	java.net.URLDecoder.decode(RTEText,"UTF-8");

%>
<iframe id="RTEditor0" width="100%" height="100%">
<style type='text/css'>ADDRESS{FONT-FAMILY:Verdana;FONT-SIZE:9pt ;font-style: NORMAL;COLOR: BLACK;}</style>
</iframe>
<DIV id=plainmsg style="HEIGHT:0px; LEFT: 0px; POSITION: absolute; TOP: 0px; VISIBILITY: hidden"><%=RTEText%></DIV>
</body>
</html>

