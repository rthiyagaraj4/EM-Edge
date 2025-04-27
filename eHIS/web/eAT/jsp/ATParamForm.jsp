<!DOCTYPE html>
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<%  
	String facility_id  = (String) session.getValue("facility_id");
	String params = request.getQueryString()+"&facility_id="+facility_id;
    String url = "../../eCommon/jsp/commonToolbar.jsp?";
    String source = url + params ;

%>
</head>
<script language='javascript' src='../../eAT/js/Atparameter.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%=source%>" style="height:8vh;width:100vw"></iframe><iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eAT/jsp/ATParameter.jsp?<%=params%>" style="height:100vh;width:100vw"></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' style='height:50%;width:100vw'></iframe>
</html>

