<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8  " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<HTML>
<HEAD>	
	<!-- <LINK rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
	 request.setCharacterEncoding("UTF-8");	
	//Added  for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<!-- import the calendar script -->
	<SCRIPT language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></SCRIPT>
	<SCRIPT language="JavaScript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT language="javascript" src="../../eCommon/js/common.js"></SCRIPT>
	<!-- <SCRIPT language="javascript" src="../../eCommon/js/messages.js"></SCRIPT> -->
	<SCRIPT language="Javascript" src="../../ePH/js/TDMAttributes.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<FORM name="formTDMAtrributesCatalogHdr" id="formTDMAtrributesCatalogHdr">
<%
        String	bean_id			=	"TDMAttributes" ;
		String	bean_name	=	"ePH.TDMAttributesBean";
		String  sample="";

				TDMAttributesBean bean = (TDMAttributesBean)getBeanObject( bean_id,bean_name,request);
				bean.setLanguageId(locale);
				sample	=	request.getParameter("sample");

		%>
<table align="right"  border="0" width="100%" cellspacing="0" cellpadding="0">
    <tr width="100">
        <td>&nbsp;&nbsp;</td>
        <td colspan=2  class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/>   
        <input type="radio" name="search_by" id="search_by" value="C" checked><fmt:message key="Common.code.label" bundle="${common_labels}"/>  
        <input type="radio" name="search_by" id="search_by" value="D"> <fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/>    
        <select name="search_criteria" id="search_criteria">
        <option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>   
        <option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>    
        <option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>    
        </select>
        </td>
        <td>&nbsp;</td>
    </tr> 
    <tr>
        <td>&nbsp;&nbsp;</td>
        <td class="label" colspan=2 ><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/>     
        <input type="text" onBlur="makeValidString(this);"  name="search_text" id="search_text" value="" width="30%" align="left" size="40" maxlength="70" >
        </td>
        <td align="right"><input type="button" class="button" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'align="left" onClick="searchstring(sample);">
        <input type="button" align="left" name="Reset" id="Reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="resetForm(this.form)" class="button" >
        </td>
    </tr>
</table>
<BR>
<BR>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="sample" id="sample" value="<%=sample%>">

<% putObjectInBean(bean_id,bean,request); %>

</form>
</body>
</html>

