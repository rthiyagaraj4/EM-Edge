<!DOCTYPE html>

<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");	
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCA/js/CAMainMenu.js' language='javascript'></script>
	<script src='../../eCA/js/MaternityConsTree.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>	
	<script src="../../eCommon/js/common.js" language="javascript"></script> 
</head>
<%
	/*String spltySQL="SELECT SPLTY_EVENT_CODE,SPLTY_EVENT_DESC FROM CA_SPLTY_EVENT_LANG_VW WHERE MODULE_ID=? AND LANGUAGE_ID=? AND EFF_STATUS='E' ORDER BY 2";

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;*/

%>
<body  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<FORM METHOD=POST ACTION="" name="MaternityConsOpenRegisterForm" id="MaternityConsOpenRegisterForm">
<%	
try{

	}catch(Exception e){
	e.printStackTrace() ;
}
%>
</FORM>
</body>
</html>

