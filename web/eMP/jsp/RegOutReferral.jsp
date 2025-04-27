<!DOCTYPE html>
<!--
This file was developed by Venkatesh.S on 27-Nov-2019 against crf Bru-HIMS-CRF-287 [IN033669] 
-->

<html>
<head>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%
	 request.setCharacterEncoding("UTF-8");
	String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eOP/js/RegOutReferral.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
    	String source = url + params ;
		String fac_id    	= (String) session.getValue("facility_id" ) ;
		String userid           = (String) session.getValue("login_user");
		String function_id=request.getParameter("function_id");
		
		/*Below line Modified for this CRF Bru-HIMS-CRF-261*/

%>
   	
   <iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' noresize style='height:7vh;width:100vw'></iframe>
    <iframe name='regOutRef_Criteria' id='regOutRef_Criteria' src='../../eMP/jsp/RegOutReferralCriteria.jsp' noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no' style='height:16vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod'   src=''   noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no' style='height:72vh;width:100vw'></iframe>
   <iframe name='messageFrame' id='messageFrame'	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:5vh;width:100vw'></iframe>
</html>

