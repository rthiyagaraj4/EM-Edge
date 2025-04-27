<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<%
	    request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale= (String)session.getAttribute("LOCALE");
         String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||
		               (session.getAttribute("PREFERRED_STYLE")!="")?
					    (String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
   <script language="javascript" src="../../eCommon/js/messages.js"></script> 
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../ePH/js/SlidingScaleTmpl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
 	<SCRIPT>
		function_id = "<%= request.getParameter( "function_id" ) %>"
	</SCRIPT> 
</HEAD>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="FocusFirstElement()">
<%
	String	mode			=	request.getParameter( "mode" ) ;
	String	bean_id			=	"SlidingScaleTmpl" ;
	String	bean_name		=	"ePH.SlidingScaleTmplBean";
	String db_action		=		"";

	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;
	/* Mandatory checks end */
	/* Initialize Function specific start */
	SlidingScaleTmplBean bean = (SlidingScaleTmplBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	
	String facility_id				= (String)session.getValue( "facility_id" );

	String template_id			=					"";
	String templateDesc			=					"";
    String rangeUOM_desc		=					"";
	String adminUnitUOM_desc	=					"";
	
		String eff_statusTemp = "E";
		String disab = "";
		String cheked = "";
		if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			template_id			= request.getParameter("template_id")==null?"":request.getParameter("template_id");
			templateDesc		= request.getParameter("templateDesc")==null?"":request.getParameter("templateDesc");
            rangeUOM_desc		= request.getParameter("rangeUOM_desc")==null?"":request.getParameter("rangeUOM_desc");
			adminUnitUOM_desc	= request.getParameter("adminUnitUOM_desc")==null?"":request.getParameter("adminUnitUOM_desc");
			eff_statusTemp		= request.getParameter("eff_statusTemp")==null?"":request.getParameter("eff_statusTemp");
			disab				= "disabled";
		}
			if(((String)eff_statusTemp).equals("E"))
				cheked  = "checked";
	%>
<FORM name="SlidingScaleTmplDetails" id="SlidingScaleTmplDetails" id="SlidingScaleTmplDetail" >
	<table cellpadding="0" cellspacing="3" width="100%" align="center" border="0">
		<tr>
			<th align="left" colspan="7" class="label"><fmt:message key="ePH.SlidingScaleTemplate.label" bundle="${ph_labels}"/></th>
		</tr>
		<tr>
		    
			<td  class="label" align="right"> <fmt:message key="Common.TemplateID.label" bundle="${common_labels}"/> </td>
			<td	 align="left" colspan="1">&nbsp;
			<input type="text" class='UPPER' maxlength="10" tabIndex="0" size="10" name="template_id" id="template_id" value="<%=template_id%>"
			oninput="this.value = this.value.toUpperCase();" 
			onKeyPress="return CheckForSpecChars(event);" 
			onblur="specialChar(this)" <%=disab%>>
			&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></img>
			</td>
            <td	 align="left" colspan="2">&nbsp;</td>
			<td  class="label" align="right"> <fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td  align="left" colspan="3">&nbsp;&nbsp;<input type="text" tabIndex="1" name="templateDesc" id="templateDesc" value="<%=templateDesc%>" size="60" maxlength="60" >
			&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
		</tr>
		<tr > 
			<td  class="label" align="right"><fmt:message key="ePH.RangeUOM.label" bundle="${ph_labels}"/></td>
			<td  align="left">&nbsp;&nbsp;<input type="text" tabIndex="2" name="rangeUOM_desc" id="rangeUOM_desc" size="10" maxlength="10" value="<%=rangeUOM_desc%>" Onchange="changeUnit();"  onblur="changeUnit()"
			<%=disab%>>
			&nbsp;
			<IMG  src="../../eCommon/images/mandatory.gif" align="center"></IMG>
			</td>
			<td	 align="left" colspan="2">&nbsp;</td>
            <td  class="label" align="right"><fmt:message key="ePH.AdminUnitsUOM.label" bundle="${ph_labels}"/> </td>
			<td  align="left">&nbsp;&nbsp;<input type="text" tabIndex="3" name="adminUnitUOM_desc" id="adminUnitUOM_desc" size="10" maxlength="10" value="<%=adminUnitUOM_desc%>" Onchange="changeUnit();" 
			onblur="changeUnit()"
			<%=disab%>>
			&nbsp;
			<IMG  src="../../eCommon/images/mandatory.gif" align="center"></IMG>
			</td>
			<td	 align="left" colspan="1">&nbsp;</td>
		</tr>
		<tr>
            <td  class="label" align="right">
			<fmt:message key="Common.status.label" bundle="${common_labels}"/> </td>
			<td  align="left">&nbsp;
		    <input type="checkBox" name="eff_status" id="eff_status" value="" onclick="assignValue(this);" <%=cheked%> >
			<td	 align="left" colspan="2">&nbsp;</td>
		</tr>
	</table>
	<input type="hidden" name="mode" id="mode" value="<%= mode %>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%= locale %>">
	<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%=bean.getFunctionId()%>">
	<input type="hidden" name="eff_statusTemp" id="eff_statusTemp" value="<%=eff_statusTemp%>">
	<input type="hidden" name="db_action" id="db_action"	value="<%=db_action%>">
</FORM>
</BODY>
<script>
changeUnit();
parent.f_temp_range.location.reload();
</script>
</HTML>
<%
putObjectInBean(bean_id,bean,request);
%>

