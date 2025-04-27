<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<% 
		request.setCharacterEncoding("UTF-8");
//		String locale			= (String)session.getAttribute("LOCALE");
		//locale ="en";
//		String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eMM/js/Parameter.js"></script>
<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
//	String function_id =  request.getParameter( "function_id" );
    //Adding start for PMG2017-SS-CRF-0002
	eMM.ParameterBean bean = (eMM.ParameterBean)getBeanObject( "ParameterBean","eMM.ParameterBean",request );
     HashMap	accounting_period_count=(HashMap)bean.fetchRecord("select count(*) total from ST_ACC_ENTITY_PARAM");
	  if (accounting_period_count.get("TOTAL").toString().equals("0")) {
	        out.println("<script>alert(getMessage('ACCOUNTING_PERIOD','MM'));window.location.href ='../../eCommon/jsp/dmenu.jsp;'</script>");
	   }
	   //Adding end for PMG2017-SS-CRF-0002
%>
<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw"></iframe><iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eMM/jsp/AddModifyParameter.jsp" style="height:83vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:9vh;width:100vw"></iframe>

</html>


