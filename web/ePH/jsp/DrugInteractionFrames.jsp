<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import ="eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086

	String locale		=		(String) session.getAttribute("LOCALE");
	String sStyle		=		(session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
   String params = request.getQueryString();
	
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="JavaScript" src="../js/PhCommon.js"></script>
<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> 
<script language="JavaScript" src="../js/DrugInteraction.js"></script>
</head>

  <!-- <frameset rows="*,47%"> -->
	<iframe name="f_drug_interaction"   id="f_drug_interaction"  frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DrugInteractionAddModify.jsp?<%=params%>" style='height:70vh;width:100vw'></iframe>
	<iframe name="f_drug_interaction_list" id="f_drug_interaction_list" frameborder="0" scrolling="auto" src="../../eCommon/html/blank.html" style='height:30vh;width:100vw'></iframe>
	<!-- <frameset rows="20,28,20,15,*" id="druginteractionframeid"> -->
</frameset>
</html>
