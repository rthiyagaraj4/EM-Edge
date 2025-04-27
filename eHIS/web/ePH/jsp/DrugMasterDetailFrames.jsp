<!DOCTYPE html>
 <!--
Fine Tuning
-->
<%@page contentType="text/html;charset=UTF-8" import="eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<HTML>
<HEAD>
<%
request.setCharacterEncoding("UTF-8");
//Added  for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<SCRIPT LANGUAGE="JavaScript" SRC="../js/PhCommon.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="../js/DrugMaster.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="../js/DrugMasterDetail.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<%
	String url_1 = "../../ePH/jsp/DrugMasterTitle.jsp?" ;
	String url_2 = "../../ePH/jsp/DrugMasterAddModifyDetail.jsp?" ;
	String params = request.getQueryString() ;
	String source_1 = url_1 + params ;
	String source_2 = url_2 + params ;

%>
<iframe name="f_title" id="f_title" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="<%=source_1%>" style="height:10vh;width:100vw"></iframe>
<iframe name="f_detail" id="f_detail" FRAMEBORDER="0" SCROLLING="auto" NORESIZE  SRC="<%=source_2%>" style="height:60vh;width:100vw"></iframe>
<iframe name="f_add_modify" id="f_add_modify" SRC="../../eCommon/html/blank.html" FRAMEBORDER="0" NORESIZE SCROLLING="no" style="height:30vh;width:100vw"></iframe>
</HTML>

