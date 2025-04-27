<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  contentType="text/html;charset=UTF-8"  import ="eCommon.Common.CommonBean,eCommon.XSSRequestWrapper,eCommon.Common.*,eOT.*,eOT.Common.*"  %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<HTML>
<head> 
<%
	String params = request.getQueryString();
    String	tab_id = CommonBean.checkForNull(request.getParameter("tab_id"));
	String	called_from = CommonBean.checkForNull(request.getParameter("called_from"));
	//System.out.println("====called_from====PreOperChkListFrames======"+called_from);
	params+="&tab_id="+tab_id;
	String bean_id = "CheckInBean";
	String bean_name = "eOT.CheckInBean";
	CheckInBean bean = (CheckInBean)mh.getBeanObject(bean_id, request, bean_name);
	bean.clear();	
	String height1 =""; 
	String height2 =""; 
	String height3 =""; 
	if(called_from.equals("OT_MENU") || called_from.equals("BOOKING"))
	{
		if(called_from.equals("OT_MENU"))
		{
			height1 ="";
			height2 ="58vh";
			height3 ="44vh";
%>
	<!-- <FRAMESET  rows='54%,*'  border='0'> -->
<%
		}
		else if(called_from.equals("BOOKING"))
		{
%>
		<!-- <FRAMESET  rows='12%,34%,*'  border='0'> -->
				<iframe name='OtPatientLineFrame' src="../../eOT/jsp/OTPatLineFrame.jsp?<%=params%>" noresize scrolling='no' ></iframe>
	<%
		}
	%>
	<iframe name='ChkListRecordFrame' id='ChkListRecordFrame' src="../../eOT/jsp/PreOperChkListHdr.jsp?<%=params%>" noresize scrolling='yes' frameborder='0' style="height:<%=height2 %>;width:100vw;"></iframe>
	<iframe name='ChkListDetailFrame' id='ChkListDetailFrame' src="../../eOT/jsp/PreOperativeChkListDtlsFrames.jsp?<%=params%>" noresize scrolling='no'frameborder='0' style="height:<%=height3 %>;width:100vw;"></iframe>
<!-- <FRAMESET> -->
<%
	}
	else if(called_from.equals("OT_SLATE")) 
	{
%>
	<!-- <FRAMESET  rows='12%,33%,*'  border='0'> -->
	<iframe name='OtPatientLineFrame' src="../../eOT/jsp/OTPatLineFrame.jsp?<%=params%>" noresize scrolling='no' ></iframe>
	<iframe name='ChkListRecordFrame' src="../../eOT/jsp/PreOperChkListHdr.jsp?<%=params%>" noresize scrolling='yes' style="height:<%=height2 %>;width:100vw;"></iframe>
	<iframe name='ChkListDetailFrame' src="../../eOT/jsp/PreOperativeChkListDtlsFrames.jsp?<%=params%>" noresize scrolling='no' style="height:<%=height3 %>;width:100vw;"></iframe>
<%
	}
%>
</head>
<body  onKeyDown = 'lockKey()' >
<form name="PreOperChkListForm" >
	<input type='hidden' name='params' value='<%=params%>' >
	<input type='hidden' name='tab_id' value='<%=tab_id%>' >
</form>
</body>
</HTML>
