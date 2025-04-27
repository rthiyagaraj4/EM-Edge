<!DOCTYPE html>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<html>
	<head>
		<%
					String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
					|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
					.getAttribute("PREFERRED_STYLE")
					: "IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
			type='text/css'></link>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript'
			src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/messages.js'></script>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
		<script language='javascript' src='../../eST/js/StMessages.js'></script>
		<script language='javascript' src='../../eST/js/StTransaction.js'></script>
		<script language='javascript' src='../../eST/js/ViewGRNS.js'></script>
		<script>
        function_id = "<%=request.getParameter("function_id")%>"
		menu_id		= "<%=request.getParameter("menu_id")%>"
		module_id	= "<%=request.getParameter("module_id")%>"							  
    </script>
	</head>
	<%
		String url = "../../eCommon/jsp/commonToolbar.jsp?";
		String params = request.getQueryString();
		String source = url + params;
		String facilityid = (String) session.getValue("facility_id");

		eST.GoodsReceivedNoteBean bean = (eST.GoodsReceivedNoteBean) getBeanObject(
				"goodsReceivedNoteBean", "eST.GoodsReceivedNoteBean",
				request);

		// Passing login_facility_id, material_group_code as arguments
		if (!(bean.recordExists(facilityid, "ALL"))) {
			out
			.println("<script>alert(getMessage('FACILITY_PARAM_NOT_SET'));history.go(-1);</script>");
		}
	%>
	<%
	putObjectInBean("goodsReceivedNoteBean", bean, request);
	%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src="<%=source%>" frameborder=0
			scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eCommon/html/blank.html"
			frameborder=0 scrolling='no' style='height:4vh;width:100vw'></iframe>
			<iframe name='f_query_rst' id='f_query_rst' src="../../eCommon/html/blank.html"
			frameborder=0 scrolling='no' style='height:46vh;width:100vw'></iframe>
			<iframe name='f_query_rst_dtl' id='f_query_rst_dtl' src="../../eCommon/html/blank.html"
			frameborder=0 scrolling='auto' style='height:37vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp'
			frameborder=0 noresize scrolling='auto' style='height:7vh;width:100vw'></iframe>
	</h

