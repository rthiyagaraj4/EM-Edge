<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<!--this is for futher simulteanous user -->
<%@ page isThreadSafe="false" %>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>



<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>
	
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>



<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='detailUpperForm' id='detailUpperForm' >
<%

try{

	/* Mandatory checks start */
	
	String mode		  = request.getParameter( "mode" ) ;
	String bean_id = "Or_CareSet" ;
	String bean_name = "eOR.CareSetBean";

	//CareSetBean bean = (CareSetBean)mh.getBeanObject(bean_id,request, bean_name ) ;
	CareSetBean bean = (CareSetBean)getBeanObject( bean_id, bean_name , request) ;	
	bean.setLanguageId(localeName);
	HashMap careSetHeaderStr =	bean.getCareSetHeaderStr();

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ))
	return ;
	bean.setMode( mode ) ;
	
	String eff_status = "E";
	String explanatory_text_updatable		 = "Y";
	if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )){
		//In modify mode if the eff status is no then all shold be disabled
		eff_status  = (String)careSetHeaderStr.get("eff_status");
		eff_status	= eff_status.trim();
	}


%>

  <table border="0" cellpadding=3 cellspacing=0 width="100%" align="center" >

<%	

/*
String explanatory_text=careSetHeaderStr.get("explanatory_text")==null?"":(String)careSetHeaderStr.get("explanatory_text");
*/

ArrayList  explanatoryRecStr		 =  bean.getExplanatoryRecStr();	

if(eff_status.trim().equalsIgnoreCase("D")){//only in mod mode if eff_staus is disabled
	explanatory_text_updatable =  "N"	;
}
  
%>

<tr><td colspan='8'></td></tr>
<tr >
<td class="label"><fmt:message key="Common.Text.label" bundle="${common_labels}"/></td>

<td><textarea name="explanatory_text"
onBlur='makeValidString(this);SPCheckMaxLen("Explanatory Text",this,255);' rows='6' cols='60' <%=eHISFormatter.chkReturn("y",explanatory_text_updatable,
"","disabled")%>><%=bean.getdefaultArrListValue(explanatoryRecStr,0,"explanatory_text","")%></textarea>
</td>

</tr>

	


</table>

<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="tabType" id="tabType" value="E">

</form>
<%
	 putObjectInBean(bean_id,bean,request);
%>
<%}catch(Exception e){
	e.printStackTrace();
}%>

</body>
</html>

