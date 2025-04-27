<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../js/SectionTemplate.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onload='FocusFirstElement()' onKeyDown="lockKey()">
<form name='CASectionTemplateHeaderForm' id='CASectionTemplateHeaderForm'>
<table  width='100%' border='0' cellspacing='0' cellpadding='3' align="center" >
<tr>
<td  class="label" width ='25%'><fmt:message key="Common.Section.label" bundle="${common_labels}"/>&nbsp;&nbsp;
<input type ="text" name ="sect_name" size ="30" value="" onBlur='showpopulateSections(this);'  ><input type="hidden" name ="section" value=""><input type="button" class='Button' name="section_button" id="section_button" title='search_code' value="?" onClick='showpopulateSections(this);'><img src='../../eCommon/images/mandatory.gif' ></img>

</td>
</tr>
</form>
</body>
</html>

