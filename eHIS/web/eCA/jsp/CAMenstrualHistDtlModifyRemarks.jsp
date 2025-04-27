<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
01/10/2024     68508     krishna pranay             13/10/2024  Ashwini Ragupathi  ML-MMOH-CRF-1759							
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<head>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script type='text/javascript' src="../../eCommon/js/CommonCalendar.js"></script>		
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script language='javascript' src='../../eCA/js/CAMenstrualHistDtlTrans.js'></script>
</head>
<title>
	 <fmt:message key="eCA.modifiedRemarks.label" bundle="${common_labels}"/>
</title>
<%
String modify_remarks="";
%>

<body>
<form name="CAMenstrualHistDtlRemarksForm" id="CAMenstrualHistDtlRemarksForm">

<br>
	<div>
          <textarea  id="modifyRemark" name="modifyRemark" rows="6" cols="46" maxlength="100" onblur="onValidationModifyRemarks();"><%=modify_remarks%></textarea><img src='../../eCommon/images/mandatory.gif'>
	</div>
<br>
<div align='Right'>	
	<button type="button" onclick="onsubmitRemarks();"><fmt:message key="Common.ok.label" bundle="${common_labels}"/></button>
</div>
</body>
<%-- <input type="hidden" id="modifyRemark" name="modifyRemark" id="modifyRemark" value="<%= modify_remarks %>">
 --%></form>
</HTML>

