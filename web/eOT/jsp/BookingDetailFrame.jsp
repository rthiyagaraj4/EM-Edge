<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="eCommon.Common.CommonBean,eCommon.XSSRequestWrapper,eOT.*,eOT.Common.*" %>                
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>
<html>
<head > </head>
<script type="text/javascript" src="../../eOT/js/OTCommon.js"></script>
<script type="text/javascript" src="../../eCommon/js/common.js"></script>
<script type='text/javascript' src='../../eOT/js/CancelTransfer.js'></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>


<script language='javascript'>
function setAssignValue(dat){
	return dat;
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<form name='hiddenFrm' id='hiddenFrm'>
 <input type='hidden' name='booking_date' id='booking_date' value="<%=request.getParameter("booking_date")%>">
 <input type='hidden' name='room_code' id='room_code' value="<%=request.getParameter("room_code")%>">
 <input type='hidden' name='seq_change_yn' id='seq_change_yn'
 value="<%=request.getParameter("seq_change_yn")%>">
<input type='hidden' name='transfer' id='transfer'
 value="<%=request.getParameter("transfer")%>">
 </form>
<%
	String source="../../eCommon/jsp/commonToolbar.jsp?module_id=OT&function_type=F&menu_id=OT_JAVA_DFLT";
	String transfer=CommonBean.checkForNull(request.getParameter("transfer"));
	String strCancelFlag=CommonBean.checkForNull(request.getParameter("cancel_flag"));
	String called_from=CommonBean.checkForNull(request.getParameter("called_from"));
	String menu_reqd=CommonBean.checkForNull(request.getParameter("menu_required_yn"));
	if(called_from.equals("CHK_OUT_WARD")){ // When "View Booking Details" is called from Check-Out from Ward function
		menu_reqd = "N";
	}

	String title="";
if(transfer.equals("1")==true){
	source=source+"&access=NYNNY&home_required_yn=N";
	title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transfer.label","common_labels")+"  "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.booking.label","common_labels");
}else if(transfer.equals("5")==true) {
	source=source+"&access=NNNNY&home_required_yn=N";
title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ViewBookingDetails.Label","ot_labels");
}else if(transfer.equals("6")==true){
title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.RescheduleForm.Label","ot_labels");
	source=source+"&access=NYNNY&home_required_yn=N";
} else {
title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelBooking.label","common_labels");

if(strCancelFlag.equals("1"))
title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.CancelViewDetails.Label","ot_labels");//title="Cancel View Details";
source+=("BookingQry".equals(called_from))?"&access=NNNNN&home_required_yn=N":"&access=NYNNN&home_required_yn=N";
source=source+"&access=NYNNN&home_required_yn=N";
}
%>
<TITLE><%=title%></TITLE>
<%
if(!menu_reqd.equals("N") && (!called_from.equals("BookingQry"))){
%>
<iframe name="commontoolbarFrame" id="commontoolbarFrame"  scrolling="no" noresize src="<%= source %>" style="height:4vh;width:97vw" frameborder='0'></iframe>
<iframe name="OTPatientLineFrame" id="OTPatientLineFrame"  scrolling="no" noresize src="../../eOT/jsp/OTPatLineFrame.jsp?<%=request.getQueryString()%>" frameborder='0' style="height:15vh;width:97vw"></iframe>
	 <iframe name='header_frame' id='header_frame'	src="../../eOT/jsp/BookingDetail.jsp?<%=request.getQueryString()%>"   scrolling="no"  nowrap frameborder='0' style="height:23vh;width:97vw"></iframe>
	<iframe name='message_search_frame' id='message_search_frame'	 src="../../eOT/jsp/BookingCommonFrame.jsp?<%=request.getQueryString()%>" noresize frameborder='0' style="height:50vh;width:97vw"></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp'  noresize frameborder='0' style="height:7vh;width:97vw"></iframe>

<%}else{%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='../../eCommon/html/blank.html'  noresize  frameborder='0' style='height:0vh;width:97vw'></iframe>
<iframe name="OTPatientLineFrame" id="OTPatientLineFrame"  scrolling="no" noresize src="../../eOT/jsp/OTPatLineFrame.jsp?<%=request.getQueryString()%>" frameborder='0' style='height:18vh;width:99vw'></iframe>
	 <iframe name='header_frame' id='header_frame'	src="../../eOT/jsp/BookingDetail.jsp?<%=request.getQueryString()%>"   scrolling="no"   nowrap frameborder='0' style='height:20vh;width:99vw'></iframe>
	<iframe name='message_search_frame' id='message_search_frame'	 src="../../eOT/jsp/BookingCommonFrame.jsp?<%=request.getQueryString()%>"   frameborder='0' noresize style='height:56vh;width:99vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/html/blank.html'  noresize frameborder='0' style='height:0vh;width:99vw'></iframe>

<%}%>
</html>


