<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,eBL.Common.*,eBL.*,eCommon.Common.*,java.net.*,webbeans.op.CurrencyFormat,java.io.*,com.ehis.util.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
      <head>
	  <%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	
	String locale = (String)session.getAttribute("LOCALE");
%>
	 
	  <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
      <link rel="stylesheet" type="text/css"	href="../../eCommon/html/CommonCalendar.css"></link>
	  <script src="../../eCommon/js/ValidateControl.js"></script>
	  <script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	  <script language="javascript" src="../../eCommon/js/common.js"></script>
	  <script src='../../eBL/js/BLRecordPaymentConsent.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	  <title><%= request.getParameter("title")%> </title>
	  </head>
	  <body onKeyDown="lockKey();" onMouseDown="CodeArrest();">
	  <FORM name="relativedtls" id="relativedtls">
	
	  <table cellpadding='0' cellspacing='0' width='100%' align='center' border='0'>
		<tr>
			<td class="label" ><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
			<td class="fields" colspan="3"><input type="text" name="name" id="name" id="name" /><span class="mandHide"><img  src="../../eCommon/images/mandatory.gif"></span>
			</td>
			
			<td class="label"><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
			<td class="fields" colspan="2"><input type="text" name="nationality_desc" id="nationality_desc" id="nationality_desc" value="" onblur='if(this.value!=""){ search_country(nationality_desc,nationality_code); } else{clearFields(nationality_desc);}'/><input type="button" class="button" name="Nationalitybtn" id="Nationalitybtn" value='?' onClick="search_country(nationality_desc,nationality_code);"/><span class="mandHide"><img  src="../../eCommon/images/mandatory.gif"></span>	
			</td>
	  </tr>
	  
	  <tr>
			<td class="label"><fmt:message key="eBL.CivilId.label" bundle="${bl_labels}"/></td>
			<td class="fields" colspan="3"><input type="text" name="civilId" id="civilId" id="civilId" maxlength='10'  onblur="return CheckForAlphaCharsNatID(this);"/><span class="mandHide"><img  src="../../eCommon/images/mandatory.gif"></span>
			</td>
			
			<td class="label"><fmt:message key="eBL.telnum.label" bundle="${bl_labels}"/></td>
			<td class="fields" colspan="2"><input type="text" name="telephoneNumber" id="telephoneNumber" id="telephoneNumber" size='20' maxlength='10' onblur="return isValidCharacter(this);" /><span class="mandHide"><img  src="../../eCommon/images/mandatory.gif"></span>
			</td>
	  </tr>
	 

	  <tr>
		<td colspan="2">&nbsp;</td>
	  </tr>
	<tr>
		<td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td colspan="2"><input type="button" name="eSign" id="eSign" id="eSign" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.eSign.label","bl_labels")%>" onClick="saveRelativeDtls();">&nbsp;
		<input type="button" name="Reset" id="Reset" id="Reset" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reset.label","common_labels")%>" onClick="resetRelativeDtls();"/>&nbsp;
		<input type="button" name="cancel" id="cancel" id="cancel" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onClick="parent.window.close();"></td>
	</tr>
	</table> 
	   
	   <input type=hidden name="relativeDtlsYN" id="relativeDtlsYN" id="relativeDtlsYN" value="N">
	   <input type=hidden name="locale" id="locale" id="locale" value="<%=locale%>">
		<input type=hidden name="nationality_code" id="nationality_code" id="nationality_code" value="" />
		
	  </form>
	  
	  </body>
	  
</html>
<%!	
			private String checkForNull(String inputString)
			{
				return (inputString==null)	?	""	:	inputString;
			}
			public static String checkForNull(String inputString, String defaultValue)
			{
				return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
			}
		%>

