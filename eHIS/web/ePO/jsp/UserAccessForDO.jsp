<!DOCTYPE html>
<%@ page import=" ePO.UserAccessForDOBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
		
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../ePO/js/UserAccessForDO.js"></script>
	<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter( "function_id" ) %>";
    </script>
</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?";
	String params =request.getQueryString() ;
	System.out.println("params"+params);
	String source = url + params ;
	System.out.println("source"+source);
	
	UserAccessForDOBean bean = (UserAccessForDOBean) getBeanObject("userAccessForDOBean","ePO.UserAccessForDOBean", request );  
	bean.initialize();
	if(!bean.checkForNull((String)	bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_ACC_ENTITY_PARAM_SELECT1"),new String[]{(String)session.getAttribute("ACC_ENTITY_ID")}).get("PO_INTERFACE_YN"),"N").equals("Y")){ 	
	%>
  <SCRIPT>alert("Purchase Module Not Applicable");window.location.href = '../../eCommon/jsp/dmenu.jsp'</SCRIPT>   
 <%
	}
	putObjectInBean("usertAccessForDOBean",bean,request);
%>

<iframe name = "commontoolbarFrame" id = "commontoolbarFrame"  scrolling = "no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe><iframe name = "f_query_add_mod" id = "f_query_add_mod" scrolling = "auto" noresize src="../../eCommon/html/blank.html" style="height:83vh;width:100vw"></iframe><iframe name = "messageFrame" id = "messageFrame" src="../../eCommon/jsp/error.jsp" noresize scrolling = "auto" style="height:9vh;width:100vw" ></iframe>
</html>




