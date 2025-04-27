<!DOCTYPE html>
<%@page import="eOT.*, eOT.Common.*,eCommon.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%	
String  surgeon_doc_comp_yn = 																CommonBean.checkForNull(request.getParameter("surgeon_doc_comp_yn")); 
%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<!--<script language="JavaScript" src="../../eOT/js/Hashtable.js"></script>-->
<script language="JavaScript" src="../../eOT/js/ICDPCS.js"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style>
OPTION.AUTO,TD.AUTO {
			FONT-FAMILY: VERDANA;
			FONT-SIZE: 9PT;
			BACKGROUND-COLOR: #00ff66;
			BORDER-STYLE: SOLID;
			BORDER-LEFT-COLOR: #B2B6D7;
			BORDER-RIGHT-COLOR: #B2B6D7;
			BORDER-TOP-COLOR: #E2E3F0;
			BORDER-BOTTOM-COLOR: #E2E3F0;
}
OPTION.MANDATORY,TD.MANDATORY{
			FONT-FAMILY: VERDANA ;
			FONT-SIZE: 9PT ;
			BACKGROUND-COLOR: #cc0033;
			COLOR:WHITE;
			BORDER-STYLE:SOLID;
			BORDER-LEFT-COLOR: #B2B6D7;
			BORDER-RIGHT-COLOR: #B2B6D7;
			BORDER-TOP-COLOR: #E2E3F0;
			BORDER-BOTTOM-COLOR: #E2E3F0;
 }
 OPTION.OPTIONAL,TD.OPTIONAL{
			FONT-FAMILY: VERDANA ;
			FONT-SIZE: 9PT ;
			COLOR:BROWN;
			BACKGROUND-COLOR: gold;
			COLOR:BROWN
			BORDER-STYLE: SOLID;
			BORDER-LEFT-COLOR: #B2B6D7;
			BORDER-RIGHT-COLOR: #B2B6D7;
			BORDER-TOP-COLOR: #E2E3F0;
			BORDER-BOTTOM-COLOR: #E2E3F0;
 }
 TD.SEN {
	BACKGROUND-COLOR: LightYellow ;
	FONT-SIZE: 9PT ;
	BORDER-STYLE: SOLID;
	BORDER-LEFT-COLOR: #B2B6D7;
	BORDER-RIGHT-COLOR: #B2B6D7;
	BORDER-TOP-COLOR: #E2E3F0;
	BORDER-BOTTOM-COLOR: #E2E3F0 
}
</style>
</head>
<body onLoad="createTable();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="ICDPCSDetailForm" id="ICDPCSDetailForm" >
<div id="test"></div>
<SPAN Style="position:absolute;visibility:hidden" id="tooltip"></SPAN>
<input type="hidden"  name="doc_comp" id="doc_comp" value="<%=surgeon_doc_comp_yn%>" >
</form>
</body>
</html>

