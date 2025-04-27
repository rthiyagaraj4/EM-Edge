<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script>
</head>
<%
	String params	= request.getQueryString();
	String tab_name = request.getParameter("tab_name") ;
	if(tab_name==null) tab_name="AnesthesiaDetails";
	if(tab_name!=null && tab_name.equals("null")) tab_name="AnesthesiaDetails";
	if(tab_name.equals("AnesthesiaDetails")){
%>
<iframe name="record_details_frame" id="record_details_frame"  scrolling="no" noresize src="../../eOT/jsp/AT_AnaesthesiaDetailsSearch.jsp?<%=params%>" style="height:auto;width:100vw" frameborder='0'></iframe>
<iframe name="record_anethesia_details_hdr_frame" id="record_anethesia_details_hdr_frame"  scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:0vh;width:100vw" frameborder='0'></iframe>
<iframe name="record_anethesia_details_frame" id="record_anethesia_details_frame"  scrolling="yes" noresize src="../../eCommon/html/blank.html" style="height:60vh;width:100vw" frameborder='0'></iframe>
<iframe name="record_anethesia_colors_ind_frame" id="record_anethesia_colors_ind_frame"  scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:9vh;width:100vw" frameborder='0'></iframe>
<%
	}else if(tab_name.equals("PendingOrders")){
%>
<iframe name="record_pendingorders_frame" id="record_pendingorders_frame"  scrolling="no" noresize src="../../eOT/jsp/AT_AnaesthesiaPendingOrdersSearch.jsp?<%=params%>" style="height:auto;width:100vw" frameborder='0'></iframe><iframe name="record_anethesia_details_hdr_frame" id="record_anethesia_details_hdr_frame" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:0vh;width:100vw" frameborder='0'></iframe><iframe name="record_anethesia_details_frame" id="record_anethesia_details_frame"  scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:14vh;width:100vw" frameborder='0'></iframe>
<%
}
%>

