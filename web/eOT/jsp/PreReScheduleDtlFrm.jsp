<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>             
<%

String surgeon_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
String bookingDate_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BookingDate.label","common_labels");
String startTime_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StartTime.label","common_labels");
String endTime_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.EndTime.label","common_labels");
String room_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
String doneBy_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DoneBy.label","common_labels");
String actionDate_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ActionDate.Label","ot_labels");
String reason_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reason.label","common_labels");

 String strLegends=surgeon_title+","+bookingDate_title+","+startTime_title+","+endTime_title+","+room_title+","+doneBy_title+","+actionDate_title+","+reason_title;

 String strSizes="21,10,5,5,20,20,10,10";
 String source="../../eOT/jsp/HdrComDisplay.jsp?";
 String param="legends="+strLegends+"&sizes="+strSizes;
 source=source+param;
%>

<iframe name='schedule_hdr'	id='schedule_hdr' src='<%=source%>'
 frameborder=0 scrolling='no' noresize style='height:0vh;width:100vw'></iframe>

	 <iframe name='schdule_dtl' id='schdule_dtl' src="../../eOT/jsp/PreReScheduleDtl.jsp?<%=request.getQueryString()%>" scrolling='yes'  frameborder=0 style='height:100vh;width:100vw'></iframe>
