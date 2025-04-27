<!DOCTYPE html>

  
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%-- Mandatory declarations end --%>
<html>
<head>
	<%
	 request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String sPatientId	= request.getParameter("patientId");
	String sOrderId		= request.getParameter("orderId");
%>
 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
 
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../ePH/js/PPNRegimen.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<form name = "PPNSearchCriteria" >
<table  border="0" width="100%" cellspacing="0" cellpadding="0">
    <tr >
        <td>&nbsp;&nbsp;</td> 
		<td   class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>

        <td  class="fields"><fmt:message key="Common.code.label" bundle="${common_labels}"/>
			<input type="radio" name="search_by" id="search_by" class="label" value="C" onclick="storeVal(this)"> 
			<fmt:message key="Common.description.label" bundle="${common_labels}"/> 
	        <input type="radio" name="search_by" id="search_by" class="label" value="D" onclick="storeVal(this)" checked>
		</td>
       
    </tr> 
    <tr>
        <td>&nbsp;&nbsp;</td>
        <td class="label"><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
        <td class="fields">
			<input type="text" name="search_text" id="search_text"  onkeypress="if(event.keyCode !=32){return CheckForSpecChars(event)}" value="" width="30%" align="left" size="40" maxlength="70" >
			<select name="search_criteria" id="search_criteria">
				<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
				<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
			</select>

        </td>
	</tr>
	<tr>
		<td class="label" colspan=2>&nbsp;</td>

        <td align="right" nowrap>
			<input type="button" align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="searchPPN('<%=sPatientId%>','<%=sOrderId%>')" class="button" >
			<input type="button" align="left" name="Cancel" id="Cancel" onclick='window.close()' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="" class="button" >
	        <input type="reset" align="left" name="Reset" id="Reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' class="button" >
        </td>
    </tr>
</table>
	<input type="hidden" name="searchBy" id="searchBy" value="D">
</form>
</body>


</html>

