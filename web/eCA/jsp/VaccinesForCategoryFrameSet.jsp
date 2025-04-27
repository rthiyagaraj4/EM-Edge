<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eCA.*" contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<html>
	<head>
<% 
	 request.setCharacterEncoding("UTF-8");
     String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>


		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

		<script language="JavaScript" src ="../../eCA/js/VaccinesForCategory.js"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
 		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
		<iframe src="../../eCA/jsp/VaccinesForCategoryHdr.jsp" name='VaccinesForCategoryHeaderFrame' id='VaccinesForCategoryHeaderFrame' scrolling = "no"   style='height:10vh; width:98vw;' ></iframe>
		<iframe src="../../eCommon/html/blank.html" name='VaccinesForCategoryMiddleFrame' id='VaccinesForCategoryMiddleFrame' scrolling = "no"  style='height:25vh; width:98vw; border:0px;'></iframe>
		<iframe src="../../eCommon/html/blank.html" name='VaccinesForCategorySearchFrame' id='VaccinesForCategorySearchFrame' scrolling = "no"  style='height:20vh; width:98vw; border:0px;'></iframe>
		<iframe src="../../eCommon/html/blank.html" name='VaccinesForCategoryBottomFrame' id='VaccinesForCategoryBottomFrame' scrolling = "no"  style='height:35vh; width:98vw; border:0px;'></iframe>
		<iframe src="../../eCommon/html/blank.html" name='blankFrame' id='blankFrame' scrolling = "no"  style='height:5vh; width:98vw; border:0px;'></iframe>
	
</html>

