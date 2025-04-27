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
<%@page import="eOR.*, eOR.Common.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>


<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<head><title><fmt:message key="eOR.MultiFacilityProcessingHeader.label" bundle="${or_labels}"/></title>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
    String mode=(request.getParameter("mode")==null)?"":request.getParameter("mode");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
	<script language="JavaScript" src="../../eOR/js/MultiFacilityProcessing.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<STYLE TYPE="text/css">

	A:active {
		COLOR: black;
	}

	A:visited {
		COLOR: black;
	}
	A:link {
		COLOR: black
 

	</STYLE>

	<script>
	function lockKey() {
		if(event.keyCode == 93)
			alert("Welcome to eHIS");
	}
	</script>

</head>
<body onMouseDown='CodeArrest()'; onKeyDown='lockKey()'; onLoad='<%if(!mode.equals("2")){%>document.forms[0].ordering_facility_id.focus();visibility();<%}else{%>multimodify();<%}%>'>
<%
	String bean_id = "multifacilityprocessingbean" ;
	String bean_name = "eOR.MultiFacilityProcessingBean";
	//mode	= "1";

	/* Mandatory checks starts */
	if ( mode == null || mode.equals("") )
		mode	= "1";
		//return ;
	if ( !(mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals(CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */

	//MultiFacilityProcessingBean bean = (MultiFacilityProcessingBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	MultiFacilityProcessingBean bean = (MultiFacilityProcessingBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clearDBRec();
	//boolean clearDBbean		=  bean.clearDBRec();

	/* Initialize Function specific end */
	String ordering_facility_ids=(request.getParameter("ordering_facility_id")==null)?"":request.getParameter("ordering_facility_id");
	String order_categorys=(request.getParameter("order_category")==null)?"":request.getParameter("order_category");
	String order_type_codes=(request.getParameter("order_type_code")==null)?"":request.getParameter("order_type_code");
	String performing_facility_ids=(request.getParameter("performing_facility_id")==null)?"":request.getParameter("performing_facility_id");
	String source_types=(request.getParameter("source_type")==null)?"":request.getParameter("source_type");
	String source_locations=(request.getParameter("source_location")==null)?"":request.getParameter("source_location");
	mode=(request.getParameter("mode")==null)?"":request.getParameter("mode");
	String perform_location="";
	String disabled="";
	if(mode.equals("2"))
	{
		disabled="disabled";
	}
	if(order_type_codes.equals("*ALL"))
	{
		perform_location=bean.getPerformingLocation(ordering_facility_ids,order_categorys,order_type_codes,source_types,source_locations,performing_facility_ids);
		order_type_codes="ALL";
	
		
	}
%>
<form name="formMultiFacilityProcessingHdr" id="formMultiFacilityProcessingHdr">
<table border='0' cellspacing='0' cellpadding='3' width='100%' height='100%' align='center'>
<tr>
	<td class='label' width='40%'> <fmt:message key="Common.OrderingFacility.label" bundle="${common_labels}"/></td> 
	<td class='fields'><select name='ordering_facility_id' id='ordering_facility_id' <%=disabled%> onChange='fillComboOptions(this,"<%=ordering_facility_ids%>");'><option value=""> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option><%=bean.getComboOptionsFacId(ordering_facility_ids.trim())%></select><img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
</tr>
<TR>
	<TD class='label'><fmt:message key="Common.SourceType.label" bundle="${common_labels}"/></td> 
	<TD id='source_type' name='source_type' class='fields'><Select name='source_type_code' id='source_type_code'  <%=disabled%> onChange='fillLocation(this,"<%=source_types%>")'>   <!--onChange='fillLocation(this)'-->
			<option value=""> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option>
			<Option value='C' <%
			if (source_types.equals("C")) {out.println("selected");}%>><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></Option>
    		<Option value='N' <%if (source_types.equals("N")) {out.println("selected");}%>><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></Option>
	</Select><img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
</TR>
<TR>
	<TD class='label'><fmt:message key="eOR.SourceLocation.label" bundle="${or_labels}"/></td>
	<TD id='source_location' name='source_location' class='fields'><Select name='source_location_code' id='source_location_code'  <%=disabled%>>
		<option value=""> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option>
	</Select><img src="../../eCommon/images/mandatory.gif" align=center></img></TD>
</TR>
<tr>
 <td class='label'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td> 
	<td colspan='' class='fields'><select name='order_category' id='order_category'  <%=disabled%> onChange='fillComboOptions(this,"<%=order_categorys%>");'><option value=""> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option><%=bean.getComboOptionsOrCat(order_categorys.trim())%></select><img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
</tr>

<tr>
	<td class='label'><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td> 
	<td colspan='' id="order_type_id" name="order_type_id" class='fields'><select name='order_type_code' id='order_type_code'  onChange='setForAll(this);'><option value=""> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option></select><img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
</tr>

<tr>
	<td class='label'><fmt:message key="Common.PerformingFacility.label" bundle="${common_labels}"/></td> 
	<td id="performing_facility_id_id" name="performing_facility_id_id" class='fields'><select name='performing_facility_id' 
	id='performing_facility_id' <%=disabled%> onChange='fillPerformingLocation(this);'><option value=""> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option></select><img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
</tr>
<%--<TR><td class='label' id='perf_locn_lbl'></td><td colspan='' id="performing_facility_lo_lo"></td></TR>--%>
<tr id='perf_locn' name ="perf_locn" style='display:none'>
	<td class='label' id='perf_locn_lbl' name='perf_locn_lbl' ><fmt:message key="Common.PerformingLocation.label" bundle="${common_labels}"/></td> 
	<td id="performing_facility_lo_lo" name="performing_facility_lo_lo" class='fields'><select name='performing_facility_lo' id='performing_facility_lo'><option value=""> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option></select></td></tr>
	<tr><td colspan='2' align='left'>
			<table align='left' cellspacing='0' cellpadding='3' width="30%" border='1' id="rowTab">
				<tr>
					<td id="SelectTab" name="SelectTab" class="clicked" width="15%" onClick='dispLink("S")'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td> 
					<td id="AssociateTab" name="AssociateTab" class="normal" width="15%" onClick='dispLink("A")'><fmt:message key="Common.Associate.label" bundle="${common_labels}"/></td> 
				</tr>
			</table>
		</td>
	</tr>
<tr>
	<td colspan='2' align='left' id='linkId' name='linkId'>
	<jsp:include page="OrCommonAlphaLink.jsp" flush="true"/>
	</td>
</tr>

</table>
<input class='fields' type="hidden" name="mode" id="mode" value="<%=mode%>">
<input class='fields' type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input class='fields' type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input class='fields' type="hidden" name="tabVal" id="tabVal" value="">
<input class='fields' type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="ordering_facility_ids" id="ordering_facility_ids" value="<%=ordering_facility_ids%>">
<input type="hidden" name="order_categorys" id="order_categorys" value="<%=order_categorys%>">
<input type="hidden" name="order_type_codes" id="order_type_codes" value="<%=order_type_codes%>">
<input type="hidden" name="performing_facility_ids" id="performing_facility_ids" value="<%=performing_facility_ids%>">
<input type="hidden" name="source_types" id="source_types" value="<%=source_types%>">
<input type="hidden" name="source_locations" id="source_locations" value="<%=source_locations%>">
<input type="hidden" name="perform_location" id="perform_location" value="<%=perform_location%>">
</form>
</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>

