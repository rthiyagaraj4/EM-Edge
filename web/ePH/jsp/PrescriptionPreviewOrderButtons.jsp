<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<%@page contentType="text/html; charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
    <!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
		String call_from= request.getParameter("call_from")==null?"":request.getParameter("call_from");
		String relbtnDisp="";
		if(call_from.equals("COPYPREVORDERS"))
			relbtnDisp = "display:none";
			
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../ePH/js/PrescriptionTest.js"></script>
	<script language="JavaScript" src="../../ePH/js/Prescription_1.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="previeworder_buttons" id="previeworder_buttons" >
    <table cellpadding=0 cellspacing=0 width="90%" align="center" border="0">       
	<tr>
		<td  class="white"  align='right'>
		<input type="button" class="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="parent.window.returnValue='C';parent.window.close();"
 ><!-- added parent.window.returnValue='C' for ICN no:32735 by chandrashekar raju  -->
		</td>
		<td width="50%" class="white" style='<%=relbtnDisp%>'> 
			<input type="button"   class="button" value='<fmt:message key="ePH.ReleaseRx.label" bundle="${ph_labels}"/>' name="release_rx" id="release_rx" onclick="parent.window.returnValue='R';parent.window.close();"
 ></input><!-- added   ReleaseRx button for ICN no:32735 by chandrashekar raju  -->
		</td>
	</tr>
	</table>
</body>
</html>

