<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,eBL.Common.*,eBL.*,eCommon.Common.*,java.net.*,webbeans.op.CurrencyFormat,java.io.*,com.ehis.util.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
      <head>
	  <%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
	 
	  <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
      <link rel="stylesheet" type="text/css"	href="../../eCommon/html/CommonCalendar.css"></link>
	  <script src="../../eCommon/js/ValidateControl.js"></script>
	  <script src='../../eBL/js/BLRecordPaymentConsent.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	  <title><%= request.getParameter("title")%> </title>
	  </head>
	  <body onKeyDown="lockKey();" onMouseDown="CodeArrest();">
	  <FORM name="consentformdtls" id="consentformdtls">
	  
	  <table cellpadding='3' cellspacing='0' width='100%' align='center' border='0'>
		<tr>
			<td class="label" nowrap><fmt:message key="eBL.ConsentFormOption.label" bundle="${bl_labels}"/></td>
			<td class="fields">
				<select id="consentFormOption" name="consentFormOption" id="consentFormOption">
					<option value="V"><fmt:message key="Common.view.label", bundle="${common_labels}" /></option>
					<option value="P"><fmt:message key="Common.print.label" bundle="${common_labels}" /></option>
					<option value="S"><fmt:message key="Common.Save.label" bundle="${common_labels}" /></option>
				</select>
			</td>
	  </tr>
	  
	  
	  <tr>
		<td colspan="2">&nbsp;</td>
	  </tr>
	<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" name="ok" id="ok" id="ok" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onclick="callPrintViewSaveConsentForm();">&nbsp;
			<input type="button" name="cancel" id="cancel" id="cancel" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onclick="parent.window.close();">
		</td>
	</tr>
			
		
	   </table> 
	  </form>
	  
	  </body>
	  
</html>

