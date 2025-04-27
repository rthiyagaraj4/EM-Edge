<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>


	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/DrugInformationSource.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>	

<% 
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
    request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
    response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
    response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
    //ends
	String locale			= (String)session.getAttribute("LOCALE");


	String url = "../../ePH/jsp/DrugInformationSourceAddModify.jsp?" ;
	String mode			= request.getParameter("mode")==null?"":request.getParameter("mode") ;
	String qry_str		= request.getQueryString();
	String source		= url+qry_str;
	String source1		= "../../eCommon/html/blank.html";
	if(mode.equals("2")||mode.equals("MODE_MODIFY") )
		source1 = "../../ePH/jsp/DrugInformationSourceResult.jsp?"+qry_str;
		
		
%>


<iframe name="drug_information_header" id="drug_information_header" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="<%= source %>" style="height:11vh;width:100vw"></iframe><iframe name="drug_information_button" id="drug_information_button" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../eCommon/html/blank.html" style="height:3vh;width:100vw"></iframe><iframe name="drug_information_detail" id="drug_information_detail" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="<%= source1 %>" style="height:86vh;width:100vw"></iframe>
</HTML>

