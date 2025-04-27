<!DOCTYPE html>
<%@ page  import="java.sql.*,webbeans.eCommon.*,java.util.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<title><fmt:message key="eBL.SUBS_OPEN_PACKAGE_DTL.label" bundle="${bl_labels}"/></title>
</head>
<iframe src="BLViewTrmtPkgHdr.jsp?<%=request.getQueryString()%>" name="pkg_hdr_frame" frameborder=0 scrolling='no' noresize style='height:95vh;width:100vw'></iframe>
	<iframe SRC="../../eCommon/html/blank.html" frameborder=0 name='MainFrame1' id='MainFrame1' scrolling='no' noresize style='height:0vh;width:100vw'></iframe>
	<iframe src="BLViewTrmtPkgBtn.jsp" name="pkg_btn_frame" id="pkg_btn_frame" frameborder=0 scrolling='no' noresize  style='height:5vh;width:100vw'></iframe>
</head>
</html>

