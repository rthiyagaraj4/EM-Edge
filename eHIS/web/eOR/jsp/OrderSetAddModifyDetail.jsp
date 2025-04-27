<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>
<html>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String params	 = request.getQueryString() ;
	String tabFlag   = request.getParameter("tabFlag");
	//String frameSize = "100%,*";
	String height1 = "46vh";
	String height2 = "52vh";
	String flags[]		={"C","Se","S","E","B"} ;
	
	String flagsView[]  = {"OrderSetComponentDetailTab.jsp","OrderSetSettingDetailForm.jsp","OrderSetSynonymDetailForm.jsp","OrderSetExplanatoryDetailForm.jsp","OrderSetBillingDetailForm.jsp"} ;

	String jsp			=
	eHISFormatter.chkReturn(flags,tabFlag,flagsView,"error.jsp");

	String src1 ="../../eOR/jsp/" + jsp + "?" + params ; 
	String src2 = "";

	if(tabFlag.equalsIgnoreCase("C")){
	//frameSize = "21%,*";
	height1 = "25vh" ;
	height2 = "75vh" ;
	src2 = "../../eCommon/html/blank.html";
	}
	else{
	src2 = "../../eCommon/html/blank.html";
	}
	//String queryStr ="";
	//String function_id		=  "";
%>
<iframe name='detailUpper' id='detailUpper' src='<%=src1%>' scrolling='no' frameborder=0 style='height:<%=height1%>;width:100vw'></iframe>
<iframe name='detailLower' id='detailLower' src='<%=src2%>' scrolling='auto' frameborder=0 style='height:<%=height2%>;width:100vw'></iframe>

</html>

