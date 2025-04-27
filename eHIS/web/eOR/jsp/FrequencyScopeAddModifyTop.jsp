
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
---------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------
03/08/2017	IN062992		Dinesh T		7/8/2017		Ramesh G		ML-MMOH-CRF-0345.1
---------------------------------------------------------------------------------------------------------------------------------
-->
<%@page import="eOR.*,java.util.*,eOR.Common.*,eCommon.XSSRequestWrapper "  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
 	<script language="JavaScript" src="../../eCommon/js/common.js"></script> 
 	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script> 
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
	<script language="javascript" src="../../eOR/js/FrequencyScope.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



 </head>
 <body onload='FocusFirstElement()'  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">  
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_FrequencyScope" ;
	String bean_name = "eOR.FrequencyScopeBean";
	//String readOnly = "" ;
	//String disabled = "" ;
	
	// out.println("add modify");
	
	/* Mandatory checks end */
	
/*	Initialize Function specific start */
	FrequencyScopeBean  bean = (FrequencyScopeBean)getBeanObject( bean_id,  bean_name, request ) ;  
	bean.clear() ;
	//IN062992, starts
	bean.setSiteSpecificYN("ORMS_FREQ_SCOPE");//Hard coded since Function id is not coming
	//IN062992, ends
	bean.setMode( mode ) ;   
	/*Initialize Function specific end */
//out.println("the value of mod in top  :"+mode);
%>
		
<form name="form_frequency_scope" id="form_frequency_scope" method="post"  target="messageFrame">
<table border="0" cellpadding=3 cellspacing=0 width="100%" height='100%' align="center">
<tr>
	<td width='25%' class="label" ><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td>
	<td class='fields'>

	<input type='hidden' name='frequency' id='frequency' value=""><input type='text' name='frequencyDesc' id='frequencyDesc' value="" size='20' maxlength='20' onChange='before_showFreqencyWindow(this,frequency);setOrder(frequency);'><input type='hidden' name='frequencyDesc_temp' id='frequencyDesc_temp' value=""><input type='button' class='button' name='frequencySearch' id='frequencySearch' value='?' onClick='showFreqencyWindow(frequencyDesc,frequency);setOrder(frequency);'>
	<input type='hidden' name='frequency_sql' id='frequency_sql' value="<%=OrRepository.getOrKeyValue("SQL_OR_FREQUENCY")%>">

	<input type='hidden' name='consent_type_val' id='consent_type_val' value="C,R,Z">
	 </select><img src="../../eCommon/images/mandatory.gif"></img>
</td>

	<td id="freqLegend" class=label></td>
</tr> 
</table>
 
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="FrequencyScope">
<input type='hidden' name='test_chk' id='test_chk' value=''>
</form>
</body>
</html>


<%
		putObjectInBean(bean_id,bean,request);
 
%>

