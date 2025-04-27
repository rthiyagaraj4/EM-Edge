<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		     Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
05/10/2011        		          Chandra Shekar a  26/07/2019                              TH-KW-CRF-0008
--------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<html>
<head>
 <%
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
    <script language="JavaScript" src="../js/PhCommon.js"></script>
<script language="javascript" src="../../ePH/js/DrugMasterDetail.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  
</head>

<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
    String params = request.getQueryString() ;
%>
<iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/SupportiveDrugHeader.jsp?<%=request.getQueryString()%>" style="height:11vh;width:100vw"></iframe> <!-- Passed querysting for ICN-37519 -->
<iframe name="f_add_mod_detail" id="f_add_mod_detail" frameborder="0" scrolling="yes" noresize src="../../ePH/jsp/SupportiveDrugsDetail.jsp?<%=request.getQueryString()%>"style="height:73vh;width:100vw"></iframe><!-- Added scroll yes for ICN-37519 -->
<iframe name="f_button" id="f_button" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/SupportiveDrugsButton.jsp?<%=request.getQueryString()%>" style="height:10vh;width:100vw"></iframe>

</html>

