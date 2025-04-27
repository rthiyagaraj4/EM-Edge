<!DOCTYPE html>

 <!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
 <!-- Author - kumar: called from PackageDetailsMain.jsp on pressing Package Details button-->
<%@  page  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String patient_id = request.getParameter("patient_id");
	String pkg_bill_type = request.getParameter("pkg_bill_type") == null ? "" : request.getParameter("pkg_bill_type");
	String pkg_bill_no = request.getParameter("pkg_bill_no") == null ? "" : request.getParameter("pkg_bill_no");
%>
<html>
<head>
<title><fmt:message key="eBL.PACKAGE_DTL.label" bundle="${bl_labels}"/></title>
</head>
<iframe src="QueryPackageHeader.jsp?patient_id=<%=patient_id%>&pkg_bill_type=<%=pkg_bill_type%>&pkg_bill_no=
<%=pkg_bill_no%>" name="pkghdr_frame" frameborder=0 scrolling='no' noresize style='height:36vh;width:100vw'></iframe>
<iframe src="QueryPackageDetailMain.jsp?patient_id=<%=patient_id%>&pkg_bill_type=<%=pkg_bill_type%>&pkg_bill_no=
<%=pkg_bill_no%>" name="pkgdetail_frame" frameborder=0 scrolling='yes' noresize  style='height:56vh;width:100vw'></iframe><iframe src="PackageDetailsClose.jsp" name="close_frame" id="close_frame" frameborder=0 scrolling='no' noresize  style='height:8vh;width:100vw'></iframe>
</head>
</html>

