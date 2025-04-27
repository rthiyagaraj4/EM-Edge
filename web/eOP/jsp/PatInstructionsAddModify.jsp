<!DOCTYPE html>
<%--
	FileName		: PatInstructionsAddModify.jsp
	Version	    : 3	
	Created On	: 05-08-2009
	Created By:  S.Sathish
--%>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<jsp:useBean id="associateDiagBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<html> 
<head>
	<%
	request.setCharacterEncoding("UTF-8");
	//String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	 
	%>
	
</head>
<%  

String deafult_yn="";
String pos="";
deafult_yn=(request.getParameter("deafult_yn")==null)?"":request.getParameter("deafult_yn"); 
pos=(request.getParameter("position")==null)?"":request.getParameter("position"); 

int new_pos=(Integer.parseInt(pos)*4)+3;

associateDiagBean.setObject(new_pos,deafult_yn);

%>
<script>
parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
</script>

</html>
