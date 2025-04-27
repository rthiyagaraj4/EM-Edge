<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--ChartResultTypeAddModify.jsp -->





<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>


<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!--<script language="javascript" src="../../eCommon/js/messages.js"></script>
	-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
 	<script language="JavaScript" src="../../eOR/js/ChartResultType.js"></script>
 	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="FocusFirstElement()">
<%
String bean_id			= "Or_chart_result_type" ;
String bean_name		= "eOR.ChartResultType";
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String mode				= (request.getParameter("mode")==null)?"1":request.getParameter("mode");
if ( mode == null || mode.equals("") )
		return ;

 String chart_result_type="";
 String chart_result_type_desc="";
 String chart_horzi_desc="";
 String chart_no_columns="";
 String chart_vert_desc="";
 String eff_status="";
 String checkValue="checked";
 String service_code="";
 String service_desc="";
// String function_id="";




ChartResultType bean = (ChartResultType)getBeanObject( bean_id,  bean_name, request ) ;
bean.clear() ;
bean.setMode(mode) ;

if(mode.equalsIgnoreCase("2") ){
	//out.println("<script>alert('"+mode+"');</script>");
	
		  //function_id				= request.getParameter("function_id") ;
		  chart_result_type			= request.getParameter("chart_result_type") ;
		  chart_result_type_desc	= request.getParameter("chart_result_type_desc") ;
		  chart_horzi_desc			= request.getParameter("chart_horzi_desc") ;
		  chart_no_columns			= request.getParameter("chart_no_columns") ;
		  chart_vert_desc			= request.getParameter("chart_vert_desc") ;
		  service_code				= request.getParameter("service_code");
		  eff_status				= request.getParameter("eff_status") ;
		  service_desc=bean.getServiceDesc(service_code);
		  
		  if(eff_status.equals("E")){
				checkValue="checked";
			}else if((eff_status.equals("D")) || (eff_status.equals(""))) {
				checkValue="";
			}
			

}
if(chart_result_type == null || chart_result_type.equals("null") ) chart_result_type =" "; else chart_result_type = chart_result_type.trim();
if(chart_result_type_desc == null || chart_result_type_desc.equals("null")) chart_result_type_desc =" "; else chart_result_type_desc = chart_result_type_desc.trim();
if(chart_horzi_desc == null || chart_horzi_desc.equals("null")) chart_horzi_desc =" "; else chart_horzi_desc = chart_horzi_desc.trim();
if(chart_no_columns == null || chart_no_columns.equals("null")) chart_no_columns =""; else chart_no_columns = chart_no_columns.trim();
if(chart_vert_desc == null || chart_vert_desc.equals("null")) chart_vert_desc =" "; else chart_vert_desc = chart_vert_desc.trim();
if(service_code == null || service_code.equals("null")) service_code =" "; else service_code = service_code.trim();
if(service_desc == null || service_desc.equals("null")) service_desc =" "; else service_desc = service_desc.trim();
if(eff_status == null || eff_status.equals("null")) eff_status =" "; else eff_status = eff_status.trim();		 

%>
<form name='formChartResultAdd' id='formChartResultAdd'>
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
	<tr>
		<td width="35%"   class="label"><fmt:message key="Common.type.label" bundle="${common_labels}"/></td></td>
		<td colspan=3 class="fields"><input type=text name="chart_result" id="chart_result" size='1' value='<%=chart_result_type%>' onBlur="ChangeUpperCase( this )" 
		onKeyPress="return vali(event);return CheckForSpecChars(event);" maxlength='1' <%if(mode.equalsIgnoreCase("2")){%>readonly<%}%>><img src="../../eCommon/images/mandatory.gif"></td>
	</tr>

	
	

	<tr>
		<td width="35%"   class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<td colspan=3 class="fields"><input type=text name="chart_result_desc" id="chart_result_desc" size='20' value='<%=chart_result_type_desc%>' onKeyPress='return CheckSpecChars(event)' maxlength='20' ><img src="../../eCommon/images/mandatory.gif"></td>
	</tr>

	
	<%
	%>

	<tr>
		<td width="35%"   class="label"><fmt:message key="eOR.MatrixRowDesc.label" bundle="${or_labels}"/></td>
		<td colspan=3 class="fields"><input type=text name="chart_horizontal_desc" id="chart_horizontal_desc" size='15' value='<%=chart_horzi_desc%>'onKeyPress='return CheckSpecChars(event)' maxlength='15'><img src="../../eCommon/images/mandatory.gif"></td>
	</tr>

	

	<tr>
		<td width="35%"   class="label"><fmt:message key="eOR.Columns.label" bundle="${or_labels}"/></td>
		<td colspan=3 class="fields"><input type=text name="chart_no_cols" id="chart_no_cols" size='1'
		maxlength='1' <%if(mode.equalsIgnoreCase("2")){%>value='<%=chart_no_columns%>'
		<%}else{%>value='7'<%}%> onKeyPress='return CheckSpecCharsCols(event)' onBlur="checkPositiveNumber(this)" ><img src="../../eCommon/images/mandatory.gif"></td>
	</tr>
			
	


	<tr>
		<td width="35%"  align='left' class="label"><fmt:message key="eOR.MatrixColumnDesc.label" bundle="${or_labels}"/></td>
		<td colspan=3 class="fields"><input type=text name="chart_vetical_desc" id="chart_vetical_desc" size='15' value='<%=chart_vert_desc%>' onKeyPress='return CheckSpecChars(event)' maxlength='15'><img src="../../eCommon/images/mandatory.gif"></td>
	</tr>

	

	<tr>
		<td width="35%"   class="label"><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
		<td colspan=3><input type='hidden' name='service_code' id='service_code' value='<%=service_code%>' ><input type=text name="service_desc" id="service_desc" size='30' maxlength='30' value="<%=service_desc%>" <%if(mode.equalsIgnoreCase("1") ){%> Onblur= "before_show_service_window(service_desc,service_code);" <%}%> maxlength='15' <%if(mode.equalsIgnoreCase("2") && !service_desc.equals("") && service_desc!=null){%>readonly<%}%> ><input type='button' name='service_button' id='service_button' class='button'  <%if(mode.equalsIgnoreCase("2") && !service_desc.equals("") && service_desc!=null){%>disabled<%}%>		<%=eHISFormatter.chkReturn("checked",checkValue,"","disabled")%>  value='?' onClick="show_service_window(service_desc,service_code);"><img src="../../eCommon/images/mandatory.gif">
		<input type='hidden' name='service_sql' id='service_sql' value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_SERVICE_LOOKUP")%>" >
		<input type='hidden' name='service_desc_temp' id='service_desc_temp' value="" ></td>

	</tr>

	


	<tr>
		<td width="35%"   class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td colspan=3 class="fields"><input type=checkbox name="enable" id="enable" value="E" <%=checkValue%> ></td>
	</tr>
	
	

</table>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="function_id" id="function_id" value="ResultMatrix">

</form>
<script><%if(mode.equalsIgnoreCase("2")){%>toCheck()<%}%></script>
</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>


