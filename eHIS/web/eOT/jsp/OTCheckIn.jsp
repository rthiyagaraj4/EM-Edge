<!DOCTYPE html>
<%@ page import ="eOR.OrderEntryBillingQueryBean,eCommon.XSSRequestWrapper,eCommon.Common.*,eOT.SlateBean,eOT.*, eOT.Common.*, eCommon.Common.*"%>
<%@page  contentType=" text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>

<%String or_bean_id 						= "Or_billingQueryBean";
  String or_bean_name 					= "eOR.OrderEntryBillingQueryBean";
  OrderEntryBillingQueryBean or_bean		= (OrderEntryBillingQueryBean)mh.getBeanObject( or_bean_id,request, or_bean_name ) ;
  or_bean.clearBean();

    String bean_id		= "SlateBean";
  String bean_name	= "eOT.SlateBean";
  SlateBean   bean  = (SlateBean)mh.getBeanObject(bean_id, request, bean_name);

  %>
<html>
<title><fmt:message key="eOT.CheckIn.Label" bundle="${ot_labels}"/></title>
<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String locale = (String)session.getAttribute("LOCALE");//muthu

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eOT/js/PreOperCheckIn.js"></script>
	<script language="javascript" src="../../eOT/js/OTCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script> 

</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString();
	String called_from = request.getParameter("called_from");
	String access = request.getParameter("access");
	String booking_num = request.getParameter("booking_num"); // 04000112
	String slate_user_id = request.getParameter("slate_user_id"); // logged in user from Slate
	//Added by Sanjay
	String current_date =bean.getSysDateTime();
	current_date = DateUtils.convertDate(current_date,"DMY","en",locale);
	//Added by MuthuN against 37688 on 2/7/2013
	String current_date_format = current_date.substring(6,10);
	//Added by MuthuN against 37688 on 2/7/2013

	if(access.equals("NYNNY")) access="NYNNN";
	if(called_from==null) called_from="OT_MENU";
	if(called_from!=null && called_from.equals("null")) called_from="OT_MENU";
	if(called_from!=null && called_from.equals("")) called_from="OT_MENU";
	if(called_from.equals("OT_MENU"))
	if(request.getParameter("called_from")==null){
		params =params+"&called_from="+called_from+"&booking_num="+booking_num+"&slate_user_id="+slate_user_id;
	}else{
		params =params+"&booking_num="+booking_num+"&slate_user_id="+slate_user_id;
	}
	String source = url + params ;
	if(called_from.equals("OT_SLATE")){
	params=params+"&access=NYNNN";	

	}
	
	String height1 =""; 
	String height2 =""; 
	String height3 =""; 
	String height4 =""; 
	
%>

<%
	if(called_from.equals("OT_MENU")){
		height1 ="7vh";
		height2 ="4vh";
		height3 ="77vh";
		height4 ="12vh";
		
%>
		<!-- <frameset rows="42,20,*,50">
		 -->
		
<%
	}else{
		height1 ="7vh";
		height3 ="77vh";
        height4 ="12vh";
%>
	   <!-- <frameset rows="42,*,50"> -->
<%
	}
%>
    <iframe name="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:<%=height1 %>;width:100vw;"></iframe> 

<%
	if(called_from.equals("OT_MENU")){
%>
	<iframe name="tab_frame" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/CheckInTab.jsp?<%=params%>" style="height:<%=height2 %>;width:100vw;"></iframe>
<%
	}
%>
          <iframe name="f_query_add_mod" frameborder="0" scrolling="auto" noresize src="../../eOT/jsp/PreOperChkListFrames.jsp?<%=params%>" style="height:<%=height3 %>;width:100vw;"></iframe>
          <iframe name="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:<%=height4 %>;width:100vw;"></iframe>>
 <!--  </frameset> -->
<body  onKeyDown = 'lockKey();'>
<form name="OTCheckinForm" >
<input type='hidden' name='params' id='params' value='<%=params%>' > 
<input type='hidden' name='tab_id' id='tab_id' value='CheckIn' > 
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<!-- Added by MuthuN against 37688 on 2/7/2013 -->
<input type='hidden' name='current_date' id='current_date' value="<%=current_date%>">
<input type='hidden' name='rDateHdn' id='rDateHdn'>
<input type='hidden' name='current_date_format' id='current_date_format' value="<%=current_date_format%>">
<!-- Added by MuthuN against 37688 on 2/7/2013 -->

</form>
</body>
</html>
