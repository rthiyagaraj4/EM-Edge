<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/framework/html/Tag.text"%>
<%@ page import="com.iba.framework.core.util.Constants"%>
<ibaHTML:html>
<head>
	<Script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/common.js"></Script>
	<Script Language="JavaScript" src="<%=request.getContextPath()%>/framework/js/validations.js"></Script>
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/interface/MessageReader.js'></script>
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/engine.js'></script>
    <script type='text/javascript' src='<%=request.getContextPath()%>/dwrcore/util.js'></script>
    <Script language="JavaScript" src="<%=request.getContextPath()%>/eLC/RepLCMasterCodes/js/LinenMasterCodes.js"></Script>
    <%! String codeListFrame="",reportsFrame="";%>
     <%			
		String locale	= (String)session.getAttribute("LOCALE");
		String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
		.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
		:"IeStyle.css" ;
		if(sStyle==null)sStyle="IeStyle.css";
		codeListFrame=request.getContextPath()+"/eLC/RepLCMasterCodes/jsp/MasterRep.jsp";
	%>	
<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/eCommon/html/<%=sStyle%>' />
</head>

	<iframe src="" name="" id="" scrolling="no" frameborder="0" style="height:13%;width:100vw"></iframe>--%>
		<iframe src="<%=codeListFrame%>" name="codeListFrame" scrolling="auto" frameborder="0" style="height:40%;width:100vw"></iframe>
		<iframe src="" name="reportsFrame" id="reportsFrame" scrolling=no" frameborder="0" style="height:100vh;width:100vw"></iframe>
	
	
	<ibaHTML:form action="/RepLinenMasterCodesAction.do" target="messageFrame" method="GET">
		<table border='0' cellpadding='2' cellspacing='0' width='75%' align='center'>
		</table>
	</ibaHTML:form>	
	<ibaTiles:insert definition="masterlayout"></ibaTiles:insert>
</ibaHTML:html>


