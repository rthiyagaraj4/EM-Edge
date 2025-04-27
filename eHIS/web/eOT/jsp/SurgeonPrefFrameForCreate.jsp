<!DOCTYPE html>
<%@page  import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<html>                 
	<head>
	<script language='javascript' src='../../eOT/js/SurgicalAccessories.js'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	</head>
	<%
	    String source=request.getParameter("source");
		String function_id = request.getParameter("function_id") ;
		/*String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
//		String params = request.getQueryString() ;
		String source = url + params ;*/
		String update_mode_yn = request.getParameter("update_mode_yn");
		update_mode_yn=update_mode_yn==null?"insert":update_mode_yn;
		update_mode_yn=update_mode_yn.equals("null")?"insert":update_mode_yn;
		String all_operations="AOPR";
		String applicability=checkForNull(request.getParameter("applicability"));
		String speciality_code=checkForNull(request.getParameter("speciality_code"));
		String speciality_desc=checkForNull(request.getParameter("speciality_desc"));
		String surgeon_code=checkForNull(request.getParameter("surgeon_code"));
		String surgeon_desc=checkForNull(request.getParameter("surgeon_desc"));
		String oper_cat_code=checkForNull(request.getParameter("oper_cat_code"));
		String oper_sub_cat_code=checkForNull(request.getParameter("oper_sub_cat_code"));
		String oper_code=checkForNull(request.getParameter("oper_code"));
		String oper_desc=checkForNull(request.getParameter("oper_desc"));
	%>


		<iframe name='MasterFrame' id='MasterFrame' src='../../eOT/jsp/SurgeonPrefMain.jsp?update_mode_yn=<%=update_mode_yn%>&oper_desc=<%=oper_desc%>&surgeon_code=<%=surgeon_code%>&surgeon_desc=<%=surgeon_desc%>&all_operations=<%=all_operations%>&applicability=<%=applicability%>&speciality_code=<%=speciality_code%>&speciality_desc=<%=speciality_desc%>&oper_cat_code=<%=oper_cat_code%>&oper_sub_cat_code=<%=oper_sub_cat_code%>&oper_code=<%=oper_code%>' frameborder=0 scrolling='no' noresize style='height:28vh;width:99vw'></iframe>

		    <iframe name='hidden_frame' id='hidden_frame' src='../../eOT/jsp/SurgeonPrefObjectCollect.jsp' frameborder=0 noresize style='height:0vh;width:0vw'></iframe>
		    <iframe name='button_frame' id='button_frame' src='../../eOT/jsp/SurgicalAccessoriesTab.jsp?update_mode_yn=<%=update_mode_yn%>&surgeon_code=<%=surgeon_code%>&surgeon_desc=<%=surgeon_desc%>&all_operations=<%=all_operations%>&applicability=<%=applicability%>&speciality_code=<%=speciality_code%>&speciality_desc=<%=speciality_desc%>&oper_cat_code=<%=oper_cat_code%>&oper_sub_cat_code=<%=oper_sub_cat_code%>&oper_code=<%=oper_code%>&source=<%=source%>&function_id=<%=function_id%>' frameborder=0  scrolling='no' style='height:6vh;width:99vw' noresize></iframe>

		    <iframe name='RecordFrame' id='RecordFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:15vh;width:99vw'></iframe>
		   <iframe name='DetailFrame' id='DetailFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:42vh;width:99vw'></iframe>

</html>
