<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<!--<script language="javascript" src="../js/OrMessages.js"></script>-->
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

<html>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String params	 = request.getQueryString() ;
	String tabFlag   = request.getParameter("tabFlag");
	String frameSize = "100%,*";
	String detailUpperStyle = "height:98vh;width:99vw";
	String detailLower = "height:0vh;width:99vw";

	String flags[]		={"C","Timing","F","R","Se","I","O","B","P","T"} ;

	String flagsView[]  = {"OtherSetUpDetailTab.jsp","OtherSetUpDetailTab.jsp","OrderCatalogFrequencyDetail.jsp","OrderCatalogAddModifyReviewsDetail.jsp","OrderCatalogAddModifySettingDetail.jsp","OrderCatalogAddModifyInstructionsDetail.jsp","OtherSetUpDetailTab.jsp","BillingDetail.jsp","OrderCatalogAddModifyPrepDetail.jsp","OrderCatalogAddModifyTurnAroundDetail.jsp"} ;
	
	String jsp			=
	eHISFormatter.chkReturn(flags,tabFlag,flagsView,"error.jsp");

	String src1 ="../../eOR/jsp/" + jsp + "?" + params ;
	String src2 = "";
	if(tabFlag.equalsIgnoreCase("C") ){
		frameSize = "7%,*";
		detailUpperStyle = "height:9vh;width:99vw";
		detailLower = "height:80vh;width:99vw";
		src2 = "../../eOR/jsp/OtherSetUpDetailForm.jsp?"+ params ;
	}else if(tabFlag.equalsIgnoreCase("Timing")|| tabFlag.equalsIgnoreCase("O")){
		frameSize = "7%,*";
		detailUpperStyle = "height:0vh;width:99vw";
		detailLower = "height:107vh;width:99vw";
		src1 = "../../eCommon/html/blank.html";
		src2 = "../../eOR/jsp/OtherSetUpDetailForm.jsp?"+ params ;
	}
	else{
		src2 = "../../eCommon/html/blank.html";
	}
	
	
	System.out.println(" ******************* Inside OrderCatalogAddModifyDetail JSP 58 detailUpperStyle : "+detailUpperStyle+" detailLower : "+detailLower);
	
	//String queryStr ="";
	//String function_id		=  "";

	//out.println(src2);
%>


<iframe name='detailUpper' id='detailUpper' src='<%=src1%>' noresize scrolling='auto' frameborder=0 style=<%=detailUpperStyle%>></iframe>
<iframe name='detailLower' id='detailLower' src='<%=src2%>' noresize scrolling='auto' frameborder=0 style=<%=detailLower%>></iframe>

</html>

