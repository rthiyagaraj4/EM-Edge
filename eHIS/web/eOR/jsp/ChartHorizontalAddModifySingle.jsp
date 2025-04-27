<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.* ,eOR.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>  

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>


<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 	

</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
	request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String readOnly = "" ;
	//String disabled = "" ;
	String enableStatus = "";

	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter("function_id") ;
	String bean_id = "or_organism" ;
	String bean_name = "eOR.ChartHorizontalBean";
	


	if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) )
		return ;


/* Mandatory checks end */
	
	/* Initialize Function specific start */
	ChartHorizontalBean bean =
	(ChartHorizontalBean)getBeanObject( bean_id,bean_name , request);  
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode(mode) ;
	/* Initialize Function specific end */

		String chart_result_type_desc		= "";
		String chart_result_type		= "";		
		String org_code		="";

		if ( mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) ) {

		chart_result_type_desc	=request.getParameter("chart_result_type_desc") ;
		chart_result_type	=request.getParameter("chart_result_type") ;
		org_code	=request.getParameter("org_code") ;
	
		bean.setOrg_code(org_code.trim());
		bean.setResult_type(chart_result_type.trim());
			
		bean.loadData() ;

		readOnly = "readonly" ;
	//	disabled = "disabled" ;

		if((bean.getEff_status()).equalsIgnoreCase("D")){
		  enableStatus = "disabled"	  ;
		}
	}




%>
<form name='Org_update' id='Org_update' >
<table cellpadding=3 cellspacing=0 border=0 width='100%'  align='center'>
<tr>
	<td class="label"><fmt:message key="eOR.resultmatrix.label" bundle="${or_labels}"/></td>
	<td class='fields'><input type=text name='chart_result_type_desc' id='chart_result_type_desc' size=20 maxlength=20 value="<%=chart_result_type_desc.trim()%>" readonly  <%=enableStatus%>>
	<img src="../../eCommon/images/mandatory.gif" align=center></img></td>
</tr>
<tr>
<td class="label" width="40%"><fmt:message key="eOR.MatrixColumnCode.label" bundle="${or_labels}"/></td>
	<td class='fields'><input type=text name='org_code' id='org_code' size=6 maxlength=4 value="<%=bean.getOrg_code().trim()%>" <%=readOnly%>
	<%=enableStatus%>><img src="../../eCommon/images/mandatory.gif" align=center></img></td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
	<td class='fields' ><input type=text name='org_long_desc' id='org_long_desc' size=40 maxlength=40 value="<%=bean.getOrg_long_desc().trim()%>" onBlur="makeValidString(this)" <%=enableStatus%>>
	<img src="../../eCommon/images/mandatory.gif" align=center></img></td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
	<td class='fields' ><input type=text name='org_short_desc' id='org_short_desc' size=15 maxlength=15 value="<%=bean.getOrg_short_desc().trim()%>" onBlur="makeValidString(this)" <%=enableStatus%>>
	<img src="../../eCommon/images/mandatory.gif" align=center></img></td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type=text name='seq_no' id='seq_no' size=2 maxlength=2 value="<%=bean.getSeq_no().trim()%>" <%=readOnly%> <%=enableStatus%>>
	<img src="../../eCommon/images/mandatory.gif" align=center></img></td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="checkbox" name="eff_status" id="eff_status" value="<%=bean.getEff_status().trim()%>" <%=eHISFormatter.ChkBoxChecked("E" ,bean.getEff_status())%> ></td>
</tr>
</table>

	<INPUT TYPE="hidden" name="mode" id="mode" value="<%=mode%>">
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<INPUT TYPE="hidden" name="chart_result_type" id="chart_result_type" value="<%=chart_result_type.trim()%>">
	<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">
    <input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
  </form>
 </body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>

