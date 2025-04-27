
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<HTML>
<HEAD>
</HEAD>
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
-->
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		
		<script language='javascript' src='../../eBL/js/BLNursingUnitBillingDetails.js'></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
//			System.out.println("params in BLNursingUnitBillingDetails.jsp:"+params);
			String function_id=request.getParameter("function_id");
			if(function_id==null || function_id.equals("")) function_id="";

%>

		<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='../../eCommon/jsp/commonToolbar.jsp?<%=params%>'  frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='BLNursingUnitBlngDtlsMainFrame' id='BLNursingUnitBlngDtlsMainFrame' 	src='../../eBL/jsp/BLNursingUnitBillingDetailsFrame.jsp?<%=params%>' frameborder=0 scrolling='' noresize style='height:86vh;width:100vw'> </iframe>
		<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:9vh;width:100vw'></iframe>

	
</HTML>

