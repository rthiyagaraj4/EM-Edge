<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");%>
<html>
	<head>
<%	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>	
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src='../js/AddModifyPatFinDetailsPkgDiscDtls.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>

<BODY onLoad="" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 					      					  onSelect="codeArrestThruSelect();">
	<FORM name='' id='' action="" method='post'>
	  <TABLE border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
	    <TR>

		<td width="25%"  class='labels'>	</td>
		<td width="25%"  class='labels'>	</td>
		<td width="25%"  class='labels'>	</td>
		<td width="25%"  class='labels'>
		<input type='button' class='button' onclick='funApply()' name="apply_button" id="apply_button"  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.apply.label","common_labels")%>" >
		<input type='button'  onClick='closediscwin()' name="cancel_button" id="cancel_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" class='button' onClick='cancel()'></td>
		
</TR>
</TABLE>
</BODY>
</FORM>
</HTML>

